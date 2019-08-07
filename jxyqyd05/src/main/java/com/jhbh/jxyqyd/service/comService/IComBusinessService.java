package com.jhbh.jxyqyd.service.comService;

import com.jhbh.jxyqyd.entity.CarInfo;

import java.util.List;
import java.util.Map;

/**
 * @author:Hayden
 * @Date:2019/5/16
 */
public interface IComBusinessService {

    /**
     * 统计各业务在具体时间段业务数
     * @param carInfo startTime,endTime,companyCode
     * @return 各业务在该时间段的数量
     * send,take,service,parts,beauty,park,accident,suspicious
     */
    Map countComBusiness(CarInfo carInfo);

    /**
     * 根据时间段统计车辆登记业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarBasic(CarInfo carInfo);

    /**
     *根据时间段统计收车业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarSend(CarInfo carInfo);

    /**
     *根据时间段统计取车业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarTake(CarInfo carInfo);

    /**
     *根据时间段统计车辆维修业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarService(CarInfo carInfo);

    /**
     *根据时间段统计车辆配件业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarParts(CarInfo carInfo);

    /**
     *根据时间段统计车辆美容业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarBeauty(CarInfo carInfo);

    /**
     *根据时间段统计车辆停放业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarPark(CarInfo carInfo);

    /**
     *根据时间段统计事故车辆业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarAccident(CarInfo carInfo);

    /**
     *根据时间段统计可疑车辆业务
     * @param carInfo startTime，endTime
     * @return 该段时间业务数
     */
    int countCarSuspicious(CarInfo carInfo);


    /**
     * 车辆基本信息查询
     * @param carInfo receiveId,startTime,endTime
     * @return receiveId,carType,brand,`owner`,color,plateNumber,engineNumber,frameNumber
     */
    List<CarInfo> listCarBasicInfo(CarInfo carInfo);

    /**
     *送车人信息
     * @param carInfo receiveId,startTime,endTime
     * @return senderIsself,senderCode,sender,senderPhone,accepter
     */
    List<CarInfo> listCarSenderInfo(CarInfo carInfo);

    /**
     * 收车人信息
     * @param carInfo receiveId,startTime,endTime
     * @return takerIsself,taker,takerCode,takerPhone,sender,senderPhone,accepter
     */
    List<CarInfo> listCarTakerInfo(CarInfo carInfo);

    /**
     * 车辆维修信息
     * @param carInfo receiveId,startTime,endTime
     * @return progectId,serCause,serProject,sender,senderPhone,accepter
     */
    List<CarInfo> listCarServiceInfo(CarInfo carInfo);

    /**
     * 车辆配件信息
     * @param carInfo receiveId,startTime,endTime
     * @return receiveId,progectId,partsName,specification,notes,number,sender,senderPhone,accepter
     */
    List<CarInfo> listCarPartsInfo(CarInfo carInfo);

    /**
     * 车辆美容信息
     * @param carInfo receiveId,startTime,endTime
     * @return receiveId,progectId,proBeautify,notes,sender,senderPhone,accepter
     */
    List<CarInfo> listCarBeautyInfo(CarInfo carInfo);

    /**
     * 车辆停放信息
     * @param carInfo receiveId,startTime,endTime
     * @return receiveId,parkId,notes,sender,senderPhone,accepter
     */
    List<CarInfo> listCarParkInfo(CarInfo carInfo);

    /**
     * 车辆事故信息
     * @param carInfo receiveId,startTime,endTime
     * @return accidentCode,accident_unit,damage1,damage2,damage3,sender,senderPhone,reporter,notes
     */
    List<CarInfo> listCarAccidentInfo(CarInfo carInfo);

    /**
     * 可疑车辆信息
     * @param carInfo receiveId,startTime,endTime
     * @return suspType,susp_describe,sender,senderPhone,reporter
     */
    List<CarInfo> listCarSuspiciousInfo(CarInfo carInfo);

    /**
     * 根据 登记序号，车主姓名，车牌号，车辆类型，车辆品牌，登记时间
     * @return
     */
    List<CarInfo> listCarBasicAndConnectInfo(CarInfo carInfo);



    //    根据登记序号获取相关业务信息
    /**
     * 根据登记序号获取车辆基本信息
     * @param carInfo receiveId
     * @return car_basic_id	  owner	 car_type	brand	color	plate_number	engine_number	frame_number
     */
    CarInfo getBasicInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取送车基本信息
     * @param carInfo receiveId
     * @return car_coon_id	sender	sender_type	sender_code	sender_phone	acc_time	appoint_time	accident_car	suspicious_car	accepter
     */

    CarInfo getSenderInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取取车基本信息
     * @param carInfo receiveId
     * @return car_coon_id	taker	taker_type	taker_code	taker_phone	taker_isself	take_time	accepter
     */
    CarInfo getTakerInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取维修基本信息
     * @param carInfo receiveId
     * @return buss_service_id	progect_id	ser_cause	ser_project	notes
     */
    CarInfo getServiceInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取配件基本信息
     * @param carInfo receiveId
     * @return buss_parts_id   progect_id	parts_name	specification	number	notes	status
     */
    CarInfo getPartsInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取美容基本信息
     * @param carInfo receiveId
     * @return buss_beautify_id	progect_id	pro_beautify	notes	status
     */
    CarInfo getBeautyInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取停放基本信息
     * @param carInfo receiveId
     * @return buss_park_id  park_id	notes	status
     */
    CarInfo getParkInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取事故车辆基本信息
     * @param carInfo receiveId
     * @return addinfo_acci_id	accident_code	accident_unit	damage1	reporter	report_time	notes	status
     */
    CarInfo getAAInfoByReceiveId(CarInfo carInfo);

    /**
     * 根据登记序号获取可疑车辆基本信息
     * @param carInfo receiveId
     * @return addinfo_susp_id	susp_type	susp_describe	reporter	report_time	status
     */
    CarInfo getAsInfoByReceiveId(CarInfo carInfo);


    /**
     * 更改车辆基本信息
     * @param carInfo car_basic_id	  owner	 car_type	brand	color	plate_number	engine_number	frame_number modified_time
     * @return 成功为true，失败false
     */
    Boolean updateBasicById(CarInfo carInfo);

    /**
     * 更改送车人信息
     * @param carInfo car_coon_id	sender	sender_type	sender_code	sender_phone	acc_time	appoint_time	accident_car	suspicious_car	accepter modified_time
     * @return 成功为true，失败false
     */
    Boolean updateSenderById(CarInfo carInfo);

    /**
     * 更改取车人信息
     * @param carInfo car_coon_id	taker	taker_type	taker_code	taker_phone	taker_isself	take_time	accepter
     * @return 成功为true，失败false
     */
    Boolean updateTakerById(CarInfo carInfo);

    /**
     * 更改修理业务信息
     * @param carInfo buss_service_id	progect_id	ser_cause	ser_project	notes modified_time
     * @return 成功为true，失败false
     */
    Boolean updateServiceById(CarInfo carInfo);

    /**
     * 更改配件业务信息
     * @param carInfo buss_parts_id   progect_id	parts_name	specification	number	notes	status modified_time
     * @return 成功为true，失败false
     */
    Boolean updatePartsById(CarInfo carInfo);

    /**
     * 更改美容业务信息
     * @param carInfo buss_beautify_id	progect_id	pro_beautify	notes	status modified_time
     * @return 成功为true，失败false
     */
    Boolean updateBeautyById(CarInfo carInfo);

    /**
     * 更改停放业务信息
     * @param carInfo buss_park_id  park_id	notes	status modified_time
     * @return 成功为true，失败false
     */
    Boolean updateParkById(CarInfo carInfo);

    /**
     * 更改事故车辆信息
     * @param carInfo addinfo_acci_id	accident_code	accident_unit	damage1	reporter	report_time	notes	status modified_time
     * @return 成功为true，失败false
     */
    Boolean updateAAById(CarInfo carInfo);

    /**
     * 更改可疑车辆信息
     * @param carInfo  addinfo_susp_id	susp_type	susp_describe	reporter	report_time	status modified_time
     * @return 成功为true，失败false
     */
    Boolean updateASById(CarInfo carInfo);
}
