package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.commonenum.E_CarType;
import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.PageEntity;
import com.jhbh.jxyqyd.exception.UserNotFoundException;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.IComBusinessService;
import com.jhbh.jxyqyd.utils.ftpUtils.FtpFileUploadService;
import com.jhbh.jxyqyd.utils.rankUtils.UserRank;
import com.jhbh.jxyqyd.utils.tokenUtils.LoginRequired;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:Hayden
 * @Date:2019/5/16
 * 企业业务统计
 */

@RestController
@RequestMapping("qy")
@CrossOrigin
@LoginRequired
public class ComBusinessController extends BaseController {


    @Autowired
    IComBusinessService businessService;
    @Autowired
    FtpFileUploadService ftpFileUploadService;

    private static final Integer BASIC = 0;
    /**
     * 送车
     */
    private static final Integer SENDER = 1;
    /**
     * 取车
     */
    private static final Integer TAKER = 2;
    /**
     * 车辆修理
     */
    private static final Integer SERVICE = 3;
    /**
     * 车辆配件
     */
    private static final Integer PARTS = 4;
    /**
     * 车辆美容
     */
    private static final Integer BEAUTIFY = 5;
    /**
     * 车辆停放
     */
    private static final Integer PARK = 6;
    /**
     * 事故车辆
     */
    private static final Integer ACCIDENT = 7;
    /**
     * 嫌疑车辆
     */
    private static final Integer SUSPICIOUS = 8;


    /**
     * 统计时间段内业务数量
     * @param carInfo
     *   startTime 开始时间
     *   endTime 结束时间
     * @return send,take,service,parts,beauty,park,accident,suspicious
     */
    @PostMapping("countComBusiness")
    public ResponseResult<Map> countComBusiness(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        logParam(carInfo);
        Map map = businessService.countComBusiness(carInfo);
        ResponseResult<Map> rr = new ResponseResult<>();
        rr.setData(map);
        logParam(rr);
        return rr;
    }

    /**
     * 企业业务数据统一返回接口
     * @param carInfo
     *    startTime 开始时间
     *    endTime 结束时间
     *    moduleId  模块id
     *    receiveId
     * @return carInfo,business
     */
    @PostMapping("getCarBusinessInfo")
    @UserRank
    public ResponseResult<List<CarInfo>> getComBusiness(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){
        Integer moduleId = carInfo.getModuleId();
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        logParam(carInfo);
        List<CarInfo> list = new ArrayList<>();
        if(SENDER.equals(moduleId)){
             list = businessService.listCarSenderInfo(carInfo);
        }else if(TAKER.equals(moduleId)){
            list = businessService.listCarTakerInfo(carInfo);
        }else if(SERVICE.equals(moduleId)){
            list = businessService.listCarServiceInfo(carInfo);
        }else if(PARTS.equals(moduleId)){
            list = businessService.listCarPartsInfo(carInfo);
        }else if(BEAUTIFY.equals(moduleId)){
            list = businessService.listCarBeautyInfo(carInfo);
        }else if(PARK.equals(moduleId)){
            list = businessService.listCarParkInfo(carInfo);
        }else if(ACCIDENT.equals(moduleId)){
            list = businessService.listCarAccidentInfo(carInfo);
        }else if(SUSPICIOUS.equals(moduleId)){
            list = businessService.listCarSuspiciousInfo(carInfo);
        }
        ResponseResult<List<CarInfo>> rr = new ResponseResult<>();
        rr.setData(list);
        logParam(rr);
        return rr;
    }

    /**
     * 根据 登记序号，车主姓名，车牌号，车辆类型，车辆品牌，登记时间 模糊查询车辆信息
     * @param carInfo receiveId,owner,plateNumber,carType,createTime,brand
     */
    @PostMapping("listCarBasicInfo")
    public ResponseResult<PageEntity<CarInfo>> listCarBasicAndConnectInfo(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){

        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        List<CarInfo> carInfos = businessService.listCarBasicAndConnectInfo(carInfo);
        ResponseResult<PageEntity<CarInfo>> rr = new ResponseResult<>();
        rr.setData(new PageEntity<>(carInfos));
        logParam(rr);
        return rr;
    }

    /**
     * 根据登记序号查询指定业务模块信息
     * @param carInfo receiveId，moduleId
     * @return CarInfo
     */
    @PostMapping("getCarInfoByReceiveId")
    public ResponseResult<CarInfo> getCarInfoByReceiveId(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){
        logParam(carInfo);
        Integer moduleId = carInfo.getModuleId();
        CarInfo info = new CarInfo();
        if(businessService.getBasicInfoByReceiveId(carInfo) != null){
            if(BASIC.equals(moduleId)){
                info = businessService.getBasicInfoByReceiveId(carInfo);
            }else if(SENDER.equals(moduleId)){
                info = businessService.getSenderInfoByReceiveId(carInfo);
            }else if(TAKER.equals(moduleId)){
                info = businessService.getTakerInfoByReceiveId(carInfo);
            }else if(SERVICE.equals(moduleId)){
                info = businessService.getServiceInfoByReceiveId(carInfo);
            }else if(PARTS.equals(moduleId)){
                info = businessService.getPartsInfoByReceiveId(carInfo);
            }else if(BEAUTIFY.equals(moduleId)){
                info = businessService.getBeautyInfoByReceiveId(carInfo);
            }else if(PARK.equals(moduleId)){
                info = businessService.getParkInfoByReceiveId(carInfo);
            }else if(ACCIDENT.equals(moduleId)){
                info = businessService.getAAInfoByReceiveId(carInfo);
            }else if(SUSPICIOUS.equals(moduleId)){
                info = businessService.getAsInfoByReceiveId(carInfo);
            }
        }
        ResponseResult<CarInfo> rr = new ResponseResult<>();

        if(info == null){
            rr.setData(new CarInfo());
        }else{
            rr.setData(info);
        }
        logParam(rr);
        return  rr;
    }

    /**
     * 根据登记序号查询指定业务模块信息
     * @param carInfo receiveId，moduleId
     * @return CarInfo
     */
    @PostMapping("updateCarInfoById")
    public ResponseResult<CarInfo> updateCarInfoByReceiveId(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){
        logParam(carInfo);
        Integer moduleId = carInfo.getModuleId();
        if(SENDER.equals(moduleId)){
             businessService.updateSenderById(carInfo);
        }else if(TAKER.equals(moduleId)){
             businessService.updateTakerById(carInfo);
        }else if(SERVICE.equals(moduleId)){
             businessService.updateServiceById(carInfo);
        }else if(PARTS.equals(moduleId)){
             businessService.updatePartsById(carInfo);
        }else if(BEAUTIFY.equals(moduleId)){
             businessService.updateBeautyById(carInfo);
        }else if(PARK.equals(moduleId)){
             businessService.updateParkById(carInfo);
        }else if(ACCIDENT.equals(moduleId)){
             businessService.updateAAById(carInfo);
        }else if(SUSPICIOUS.equals(moduleId)){
             businessService.updateASById(carInfo);
        }
        return  new ResponseResult<>();
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
     * @return  成功  200
     */
    @PostMapping("updateCarBasic")
    public ResponseResult updateCarBasic(
            @RequestParam("receiveId")    String receiveId,   @RequestParam("brand")       String brand,
            @RequestParam("carType")      String carType,     @RequestParam("color")       String color,
            @RequestParam("owner")        String owner,       @RequestParam("frameNumber") String frameNumber,
            @RequestParam("engineNumber") String engineNumber,String plateNumber,
            HttpServletRequest request)
    {
        CarInfo car = null;
        try {
            if(StringUtils.isEmpty(plateNumber)){
                plateNumber = "新车未挂牌";
            }
            String photo = ftpFileUploadService.savePic(request).toString();
            String companyCode = getCompanyCodeByJwt(request);
            String carType1 = E_CarType.getCodeByName(carType);
            if(carType1==null){
                carType1= "";
            }
            car = new CarInfo(companyCode,receiveId,owner,carType1,brand,color,plateNumber,engineNumber,frameNumber,photo);
            logParam(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        businessService.updateBasicById(car);
        return new ResponseResult();
    }




}
