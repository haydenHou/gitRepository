package com.jhbh.jxyqyd.dao;

import com.jhbh.jxyqyd.entity.CarInfo;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/16
 * 企业业务统计和查询
 */
@Repository
public interface ComBusinessDao {


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
     * @param  carInfo receiveId,owner,plateNumber,carType,createTime,brand
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
     * 根据登记序号获取车基本信息
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
    @Update("UPDATE `jxy_data_db`.`car_info_basic` SET  `owner` = #{owner}, `car_type` = #{carType}, `brand` = #{brand}, `color` = #{color}, `plate_number` = #{plateNumber}, `engine_number` = #{engineNumber}, `frame_number` = #{frameNumber}, `picture` = #{picture}, `modified_time` = #{modifiedTime} WHERE  `receive_id` = #{receiveId}")
    Boolean updateBasicById(CarInfo carInfo);

    /**
     * 更改送车人信息
     * @param carInfo car_coon_id	sender	sender_type	sender_code	sender_phone	acc_time	appoint_time	accident_car	suspicious_car	accepter modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_info_connect` SET `sender` = #{sender}, `sender_type` = #{senderType}, `sender_code` = #{senderCode}, `sender_phone` = #{senderPhone}, `sender_isself` = #{senderIsself}, `acc_time` = #{accTime}, `appoint_time` = #{appointTime}, `accepter` = #{accepter},  `modified_time` = #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateSenderById(CarInfo carInfo);

    /**
     * 更改取车人信息
     * @param carInfo car_coon_id	taker	taker_type	taker_code	taker_phone	taker_isself	take_time	accepter
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_info_connect` SET `accepter` = #{accepter}, `taker` =#{taker}, `taker_type` = #{takerType}, `taker_code` = #{takerCode}, `taker_phone` = #{takerPhone}, `taker_isself` = #{takerIsself}, `take_time` = #{takeTime}, `modified_time` = #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateTakerById(CarInfo carInfo);

    /**
     * 更改修理业务信息
     * @param carInfo buss_service_id	progect_id	ser_cause	ser_project	notes modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_bussines_service` SET  `progect_id` = #{progectId}, `ser_cause` = #{serCause}, `ser_project` = #{serProject}, `notes` = #{notes}, `modified_time` = #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateServiceById(CarInfo carInfo);

    /**
     * 更改配件业务信息
     * @param carInfo buss_parts_id   progect_id	parts_name	specification	number	notes	status modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_bussines_parts` SET `progect_id` =#{progectId}, `parts_name` = #{partsName}, `specification` = #{specification}, `number` =#{number}, `notes` = #{notes},`modified_time` =#{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updatePartsById(CarInfo carInfo);

    /**
     * 更改美容业务信息
     * @param carInfo buss_beautify_id	progect_id	pro_beautify	notes	status modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_bussines_beautify` SET `progect_id` = #{progectId}, `pro_beautify` = #{proBeautify}, `notes` = #{notes},`modified_time` = #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateBeautyById(CarInfo carInfo);

    /**
     * 更改停放业务信息
     * @param carInfo buss_park_id  park_id	notes	status modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_bussines_park` SET  `park_id` = #{parkId}, `notes` = #{notes},`modified_time` =#{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateParkById(CarInfo carInfo);

    /**
     * 更改事故车辆信息
     * @param carInfo addinfo_acci_id	accident_code	accident_unit	damage1	reporter	report_time	notes	status modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_addinfo_accident` SET `accident_code` = #{accidentCode}, `accident_unit` = #{accidentUnit}, `damage1` = #{damage1}, `reporter` = #{reporter}, `report_time` = #{reportTime}, `notes` = #{notes},modified_time = #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateAAById(CarInfo carInfo);

    /**
     * 更改可疑车辆信息
     * @param carInfo  addinfo_susp_id	susp_type	susp_describe	reporter	report_time	status modified_time
     * @return 成功为true，失败false
     */
    @Update("UPDATE `jxy_data_db`.`car_addinfo_suspicious` SET `susp_type` = #{suspType}, `susp_describe` = #{suspDescribe}, `reporter` = #{reporter}, `report_time` = #{reportTime},modified_time= #{modifiedTime} WHERE `receive_id` = #{receiveId}")
    Boolean updateASById(CarInfo carInfo);



}