package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.exception.DataTooLongException;
import com.jhbh.jxyqyd.exception.MaterialNotNullException;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.ICarInfoService;
import com.jhbh.jxyqyd.service.comService.IComBusinessService;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.ftpUtils.FtpFileUploadService;
import com.jhbh.jxyqyd.utils.tokenUtils.LoginRequired;
import com.jhbh.jxyqyd.utils.tokenUtils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/14
 * 车辆相关业务
 */
@RestController
@CrossOrigin
@RequestMapping("qy")
@LoginRequired
public class CarInfoController extends BaseController{

    @Autowired
    ICarInfoService carInfoService;

    @Autowired
    IComWorkerService workerService;

    @Autowired
    FtpFileUploadService ftpFileUploadService;

    @Autowired
    IComBusinessService businessService;

    /**
     * 生成车辆登记序列号
     * @return 车辆登记序列号
     */
    @LoginRequired
    @PostMapping("RegistrationNumber")
    public ResponseResult<String> getReceiveId(HttpServletRequest request){
        ResponseResult<String> rr  = new ResponseResult<>();
        rr.setData(carInfoService.makeReceiveId(getCompanyCodeByJwt(request)));
        logParam(rr);
        return rr;
    }


    /**
     * 机动车辆基本信息登记
     * @param receiveId   登记序号
     * @param carType     车辆类型
     * @param brand       车辆品牌名称
     * @param owner       车主
     * @param color       车身颜色
     * @param plateNumber 车牌号
     * @param engineNumber 发动机号
     * @param frameNumber 车架号
     * @return  成功  200  data:空集合
     */
    @PostMapping("RegistrationCarInfo")
    public ResponseResult<String> registrationCarInfo(
            @RequestParam("receiveId")    String receiveId,   @RequestParam("brand")       String brand,
            @RequestParam("carType")      String carType,     @RequestParam("color")       String color,
            @RequestParam("owner")        String owner,       @RequestParam("frameNumber") String frameNumber,
            @RequestParam("engineNumber") String engineNumber,String plateNumber,
            HttpServletRequest request)
    {
        CarInfo car = null;
        String photo = null;
        try {
            if(StringUtils.isEmpty(plateNumber)){
                plateNumber = "新车未挂牌";
            }
            photo = ftpFileUploadService.savePic(request).toString();
            if(StringUtils.isEmpty(photo)){
                throw new MaterialNotNullException("文件为空");
            }

            String companyCode = getCompanyCodeByJwt(request);
            car = new CarInfo(companyCode,receiveId,owner,carType.toUpperCase(),brand,color,plateNumber,engineNumber,frameNumber,photo);
            logParam(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(businessService.getBasicInfoByReceiveId(car) == null){
            carInfoService.addCarInfo(car);
        }else {
            businessService.updateBasicById(car);
        }
        return new ResponseResult<>();
    }

    /**
     * 车辆交接登记
     * @param carInfo
     *   receiveId   车辆登记序号
     *   sender      送车人
     *   senderCode  送车人证件号
     *   senderPhone 送车人电话
     *   isself      是否本人
     *   appointTime 约定取车时间
     * @return 200：成功
     */
    @PostMapping("RegistrationHandover")
    public ResponseResult registrationHandover(@Valid @RequestBody  CarInfo carInfo, HttpServletRequest request){
        ComServiceWorkers workers = workerService.getLoginInfoByUsername(TokenUtils.getUserNameOrRankFromJwt(request,0));
        if(workers!=null){
            carInfo.setCompanyCode(workers.getCompanyCode());
            if(carInfo.getAccepter() == null){
                carInfo.setAccepter(workers.getName());
            }
            carInfoService.addCarConnect(carInfo);
        }
        return new ResponseResult();
    }


    /**
     * 添加维修业务
     * @param   carInfo：
     *    receiveId 车辆登记序号
     *    serCause 修理原因
     *    serProject 修理项目
     *    progectId 项目序号
     *    notes 备注
     * @return 200：成功
     */
    @PostMapping("RegistrationMaintenance")
    public ResponseResult registrationMaintenance(
             @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        if(carInfo.getSerCause().length()==1){
            carInfo.setCompanyCode(getCompanyCodeByJwt(request));
            carInfoService.addCarService(carInfo);
        }else{
            throw new DataTooLongException("参数过长");
        }
        return new ResponseResult();
    }


    /**
     * 添加配件业务
     * @param carInfo：
     *     partsArray: {partsName:配件名称,"specification":配件型号,"number":数量}
     *     notes        备注
     *     progectId   项目序号
     *     receiveId   车辆登记序号
     * @return  200:成功
     */
    @PostMapping("RegistrationParts")
    public ResponseResult registrationParts(
            @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        carInfoService.addCarParts(carInfo);
        return new ResponseResult();
    }


    /**
     * 添加美容业务
     * @param carInfo:
     *    receiveId   车辆登记序号
     *    proBeautify 美容项目 多个时以","隔开
     *    notes       备注
     *    progectId   项目序号
     * @return 200 ：成功
     */
    @PostMapping("RegistrationBeauty")
    public ResponseResult registrationBeauty(
            @Valid @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        carInfoService.addCarBeauty(carInfo);
        return new ResponseResult();
    }

    /**
     * 添加停放业务
     * @param carInfo:
     *    parkId     停车位号
     *    notes      备注
     *    progectId  项目序号
     *    receiveId  车辆登记序号
     * @return 200：成功
     */
    @PostMapping("RegistrationParking")
    public ResponseResult registrationParking(
            @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        carInfoService.addCarPark(carInfo);
        return new ResponseResult();
    }

    /**
     *添加事故车辆信息
     * @param carInfo:
     *    receiveId    车辆登记序号     *
     *    accidentCode 事故证明编号     *
     *    accidentUnit 事故证明出具单位 *
     *    damage1      损毁部为1        *
     *    damage2      损毁部为2
     *    damage3      损毁部为3
     *    reporter     报告人           *
     *    reportTime   报告时间
     *    notes        备注
     * @return 200:成功
     */
    @PostMapping("RegistrationAccident")
    public ResponseResult registrationAccident(
           @Valid @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        carInfoService.addCarAccident(carInfo);
        return new ResponseResult();
    }

    /**
     * 可疑车辆信息添加
     * @param carInfo
     *    receiveId    车辆登记序列号
     *    suspType     可疑情况类别
     *    suspDescribe 疑点情况描述
     *    reporter     举报人
     *    reportTime   举报时间
     * @return 成功：200
     */
    @PostMapping("RegistrationSuspicious")
    public ResponseResult registrationSuspicious(
            @Valid @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        carInfoService.addCarSuspicious(carInfo);
        return new ResponseResult();
    }

    /**
     * 添加取车信息
     * @param carInfo taker，takerType，takerCode，takerPhone
     * @return 成功：200
     */
    @PostMapping("RegistrationTake")
    public ResponseResult registrationTake(
            @Valid @RequestBody CarInfo carInfo,HttpServletRequest request
    ){
        logParam(carInfo);
        carInfoService.addCarTake(carInfo);
        return new ResponseResult();
    }


    /**
     *根据车辆登记序号中的时间和企业代码进行查询，获取车辆登记序号
     * @param carInfo startTime,companyCode  登记序号
     */
    @PostMapping("getReceiveId")
    public  ResponseResult<List> getReceiveIdByCompanyCode(HttpServletRequest request,@RequestBody @Valid CarInfo carInfo){
        logParam(carInfo);
//        拼接企业代码和创建时间
        String receiveId = getCompanyCodeByJwt(request)+carInfo.getStartTime();
        ResponseResult<List> rr = new ResponseResult<>();
        rr.setData(carInfoService.listCarReceiveId(receiveId));
        logParam(rr);
        return rr;
    }



}
