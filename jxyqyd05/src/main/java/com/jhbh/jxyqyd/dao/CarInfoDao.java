package com.jhbh.jxyqyd.dao;

import com.jhbh.jxyqyd.entity.CarInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author:Hayden
 * @Date:2019/5/13
 * 车辆业务
 */
@Repository
public interface CarInfoDao {



    /*
    业务添加
     */

    /**
     * 添加机动车辆信息
     * @param carInfo companyCode,receiveId,carType,brand ,owner,color,plateNumber,engineNumber,frameNumber,pictus,status,createTime
     */
    @Insert("INSERT INTO car_info_basic " +
                   "(`company_code`, `receive_id`, `owner`, `car_type`, `brand`, `color`, `plate_number`, `engine_number`, `frame_number`, `picture`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{owner}, #{carType}, #{brand}, #{color}, #{plateNumber}, #{engineNumber}, #{frameNumber},#{picture}, #{status}, #{createTime})")
    Boolean addCarInfo(CarInfo carInfo);

    /**
     * 根据companyCode获取登记序号
     * @param carInfo receiveId,companyCode
     * receiveId
     */
    @Select("SELECT receive_id receiveId " +
            "FROM car_info_connect " +
            "WHERE company_code=#{companyCode} and receive_id like CONCAT ('%',#{receiveId},'%')")
    List<String> getReceviveIdByCompanyCode(CarInfo carInfo);

    /**
     * 添加车辆登记序号
     * @param carInfo receiveId，startTime
     */
    @Insert("INSERT INTO `jxy_data_db`.`car_receive_id`" +
                "(`receive_id`,`status`, `create_time`, `modified_time`) " +
            "VALUES " +
                "(#{receiveId},#{status},#{createTime},#{modifiedTime})")
    int addCarReceiveId(CarInfo carInfo);

    /**
     * 根据receiveId 部分内容 获取具体receiveId
     * @param receiveId receiveId
     * @return
     */
    @Select("SELECT receive_id receiveId,status " +
            "FROM car_receive_id " +
            "WHERE receive_id like CONCAT (#{receiveId},'%')")
    List<CarInfo> listCarReceiveId(String receiveId);

    /**
     * 根据receiveId 获取 receiveId
     * @param receiveId 登记序号
     */
    @Select("SELECT receive_id receiveId " +
            "FROM car_receive_id " +
            "WHERE receive_id = #{receiveId}")
    CarInfo getReceiveIdByReceiveId(String receiveId);

    /**
     *覆盖原有登记序号
     * @param carInfo modifiedTime，receiveId
     * @return
     */
    @Update("UPDATE `jxy_data_db`.`car_receive_id` " +
            "SET `modified_time` = #{modifiedTime} ,`status` = #{status} WHERE  `receive_id` = #{receiveId}")
    int updateCarReceiveId(CarInfo carInfo);


    /**
     * 添加车辆交接信息
     * @param carInfo companyCode,receiveId,sender,senderType,senderCode,senderPhone,accTime,appointTime,accidentCar,suspiciousCar,accepter,createTime
     * @return 成功返回true
     */
    @Insert("INSERT INTO car_info_connect " +
                    "(`company_code`, `receive_id`, `sender`, `sender_type`, `sender_code`, `sender_phone`, sender_isself,`acc_time`, `appoint_time`,`accepter`,`create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{sender}, #{senderType}, #{senderCode}, #{senderPhone},#{isself}, #{accTime}, #{appointTime}, #{accepter}, #{createTime})")
    Boolean addCarConnect(CarInfo carInfo);

    /**
     * 添加车辆维修业务
     * @param carInfo companyCode,receiveId,progectId,serCause,serProject,notes,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO car_bussines_service " +
                    "(`company_code`, `receive_id`, `progect_id`, `ser_cause`,`ser_project`, `notes`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{progectId}, #{serCause}, #{serProject}, #{notes}, #{status}, #{createTime})")
    Boolean addCarService(CarInfo carInfo);

    /**
     * 添加车辆配件业务信息
     * @param carInfo  companyCode,receiveId,progectId,parts_name,specification,number,notes,status,create_time
     * @return 成功返回true
     */
    @Insert("INSERT INTO car_bussines_parts " +
                "( `company_code`, `receive_id`, `progect_id`, `parts_name`, `specification`, `number`, `notes`, `status`, `create_time`) " +
            "VALUES " +
                "( #{companyCode}, #{receiveId}, #{progectId}, #{partsName}, #{specification}, #{number},#{notes}, #{status},#{createTime})")
    Boolean addCarParts(CarInfo carInfo);

    /**
     * 添加车辆美容信息
     * @param carInfo companyCode,receiveId,progectId,proBeautify,notes,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO car_bussines_beautify " +
                    "( `company_code`, `receive_id`, `progect_id`, `pro_beautify`, `notes`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{progectId}, #{proBeautify}, #{notes}, #{status},#{createTime})")
    Boolean addCarBeauty(CarInfo carInfo);

    /**
     * 添加车辆停放信息
     * @param carInfo companyCode,receiveId,parkId,notes,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO car_bussines_park " +
                    "(`company_code`, `receive_id`, `park_id`, `notes`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{parkId}, #{notes}, #{status},#{createTime})")
    Boolean addCarPark(CarInfo carInfo);

    /**
     *添加车辆事故信息
     * @param carInfo companyCode,receiveId,accidentCode,accidentUnit,damage1,damage2,damage3,reporter,reportTime,notes,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO car_addinfo_accident " +
                    "( `company_code`, `receive_id`, `accident_code`, `accident_unit`, `damage1`, `damage2`, `damage3`, `reporter`, `report_time`, `notes`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{accidentCode}, #{accidentUnit}, #{damage1},#{damage2}, #{damage3}, #{reporter}, #{reportTime},#{notes}, #{status},#{createTime})")
    Boolean addCarAccident(CarInfo carInfo);

    /**
     * 添加可疑车辆信息
     * @param carInfo companyCode,receiveId,suspType,suspDescribe,reporter,reportTime,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO car_addinfo_suspicious " +
                    "( `company_code`, `receive_id`, `susp_type`, `susp_describe`, `reporter`, `report_time`, `status`, `create_time`) " +
            "VALUES " +
                    "(#{companyCode}, #{receiveId}, #{suspType}, #{suspDescribe}, #{reporter},#{reportTime}, #{status},#{createTime})")
    Boolean addCarSuspicious(CarInfo carInfo);

    /**
     * 添加取车人信息
     * @param carInfo taker，takerType，takerCode，takerPhone，takeTime，modifiedTime
     * @return 成功为true
     */
    @Update("UPDATE car_info_connect SET " +
                "`taker` = #{taker}, `taker_type` = #{takerType}, " +
                "`taker_code` = #{takerCode}, `taker_phone` = #{takerPhone}, `take_time` = #{takeTime},taker_isself = #{takerIsself}, " +
                "`modified_time` = #{modifiedTime} " +
            "WHERE " +
                "receive_id = #{receiveId}")
    int addCarTake(CarInfo carInfo);


//    业务统计

    /**
     * 统计今日业务数
     * @param carInfo createTime,companyCode
     * @return 统计的该企业今日的业务数量
     */
    @Select("SELECT count(*) FROM car_info_basic WHERE create_time LIKE CONCAT('%',#{createTime},'%') and company_code=#{companyCode}")
    Integer countTodayBusiness(CarInfo carInfo);

    /**
     * 统计今日该企业维修业务
     * @param carInfo createTime,companyCode
     */
    @Select("SELECT count(*) FROM car_bussines_service WHERE company_code = #{companyCode} AND create_time LIKE CONCAT('%','#{createTime},'%')")
    Integer countTodayService(CarInfo carInfo);

    /**
     * 统计今日该企业配件业务数
     * @param carInfo createTime,companyCode
     */
    @Select("SELECT count(*) FROM car_bussines_parts WHERE company_code = #{companyCode} AND create_time LIKE CONCAT('%','#{createTime},'%')")
    Integer countTodayParts(CarInfo carInfo);

    /**
     * 统计今日该企业美容业务数
     * @param carInfo createTime,companyCode
     */
    @Select("SELECT count(*) FROM car_bussines_beautify WHERE company_code = #{companyCode} AND create_time LIKE CONCAT('%','#{createTime},'%')")
    Integer countTodayBeautify(CarInfo carInfo);

    /**
     * 统计今日该企业停放业务数
     * @param carInfo createTime,companyCode
     */
    @Select("SELECT count(*) FROM car_bussines_park WHERE company_code = #{companyCode} AND create_time LIKE CONCAT('%','#{createTime},'%')")
    Integer countTodayPark(CarInfo carInfo);





}
