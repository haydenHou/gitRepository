package com.jhbh.jxyqyd.service.comService;

import com.jhbh.jxyqyd.entity.CarInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/15
 */
public interface ICarInfoService {


    /**
     * 添加车辆基本信息
     * @param carInfo `companyCode`, `receiveId`, `owner`, `carType`, `brand`, `color`, `plateNumber`, `engineNumber`, `frameNumber`, `picture`, `status`, `createTime`, `modifiedTime`
     */
    void addCarInfo(CarInfo carInfo);

    /**
     * 添加车辆交接信息
     * @param carInfo companyCode,receiveId,sender,senderType,senderCode,senderPhone,accTime,appointTime,accidentCar,suspiciousCar,accepter,createTime
     */
    void addCarConnect(CarInfo carInfo);


    /**
     * 添加车辆维修业务
     * @param carInfo companyCode,receiveId,progectId,serCause,serProject,notes,status,createTime
     */
    void addCarService(CarInfo carInfo);

    /**
     * 添加车辆配件业务信息
     * @param carInfo  companyCode,receiveId,progectId,partsName,specification,number,notes,status,createTime
     */
    void addCarParts(CarInfo carInfo);

    /**
     * 添加车辆美容信息
     * @param carInfo companyCode,receiveId,progectId,proBeautify,notes,status,createTime
     */
    void addCarBeauty(CarInfo carInfo);

    /**
     * 添加车辆停放信息
     * @param carInfo companyCode,receiveId,parkId,notes,status,createTime
     */
    void addCarPark(CarInfo carInfo);

    /**
     *添加车辆事故信息
     * @param carInfo companyCode,receiveId,accidentCode,accidentUnit,damage1,damage2,damage3,reporter,reportTime,notes,status,createTime
     */
    void addCarAccident(CarInfo carInfo);

    /**
     * 添加可疑车辆信息
     * @param carInfo companyCode,receiveId,suspType,suspDescribe,reporter,reportTime,status,createTime
     */
    void addCarSuspicious(CarInfo carInfo);

    /**
     * 添加取车人信息
     * @param carInfo taker，takerType，takerCode，takerPhone，takeTime，modifiedTime
     */
    void addCarTake(CarInfo carInfo);

    /**
     * 添加车辆登记序号
     * @param carInfo receiveId，startTime
     */
    void addCarReceiveId(CarInfo carInfo);

    /**
     * 根据receiveId 部分内容 获取具体receiveId
     * @param receiveId
     * @return
     */
    List<CarInfo> listCarReceiveId(String receiveId);

    /**
     * 根据receiveId 获取 receiveId
     * @param receiveId 登记序号
     */
    CarInfo getReceiveIdByReceiveId(String receiveId);

    int updateCarReceiveId(CarInfo carInfo);

    /**
     * 根据企业代码获取登记序号
     * @param carInfo  receiveId,companyCode
     * @return
     */
    List getReceviveIdByCompanyCode(CarInfo carInfo);




    /**
     * 统计今日业务数
     * @param carInfo createTime,companyCode
     * @return 统计的该企业今日的业务数量
     */
    Integer countTodayBusiness(CarInfo carInfo);

    /**
     * 统计今日该企业维修业务
     * @param carInfo createTime,companyCode
     */
    Integer countTodayService(CarInfo carInfo);

    /**
     * 统计今日该企业维修业务数
     * @param carInfo createTime,companyCode
     */
    Integer countTodayParts(CarInfo carInfo);

    /**
     * 统计今日该企业美容业务数
     * @param carInfo createTime,companyCode
     */
    Integer countTodayBeautify(CarInfo carInfo);

    /**
     * 统计今日该企业停放业务数
     * @param carInfo createTime,companyCode
     */
    Integer countTodayPark(CarInfo carInfo);


    /**
     * 利用companyCode生成车辆的登记序号
     * @param  companyCode 企业代码
     * @return 登记序号
     */
    String makeReceiveId(String companyCode);


}
