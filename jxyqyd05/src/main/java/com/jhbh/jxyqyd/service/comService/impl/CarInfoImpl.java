package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.commonenum.Dao_Type;
import com.jhbh.jxyqyd.commonenum.Table_Name;
import com.jhbh.jxyqyd.commonenum.Table_Type;
import com.jhbh.jxyqyd.dao.CarInfoDao;
import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.carInfo.*;
import com.jhbh.jxyqyd.exception.ChangeFailException;
import com.jhbh.jxyqyd.exception.InsertDataException;
import com.jhbh.jxyqyd.service.comService.ICarInfoService;
import com.jhbh.jxyqyd.service.comService.IComBusinessService;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.DaoEntity;
import com.jhbh.jxyqyd.utils.SqlToJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author:Hayden
 * @Date:2019/5/14
 */
@Service
public class CarInfoImpl implements ICarInfoService {
    @Autowired
    CarInfoDao carInfoDao;
    @Autowired
    IComWorkerService userService;

    @Autowired
    IComBusinessService businessService;

    /**
     * 用于创建序列号的日期格式
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 用于保存的详细时间格式
     */
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 详细保存时间的字符串
     */
    /**
     * 当前业务状态
     */
    private static final String STATUS = "0";


    @Override
    public void addCarInfo(CarInfo carInfo) {
        if(businessService.getBasicInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            // 添加状态为未修理
            carInfo.setStatus(STATUS);
            if (carInfoDao.addCarInfo(carInfo)) {
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_info_basic,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆基本信息添加失败");
            }
        }else{
            if (!businessService.updateBasicById(carInfo)) {
                throw new ChangeFailException("车辆基本信息更改失败");
            }
        }
    }

    @Override
    public void addCarConnect(CarInfo carInfo) {
        if(businessService.getSenderInfoByReceiveId(carInfo) == null){
            System.out.println(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setAccTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            if (carInfoDao.addCarConnect(carInfo)) {
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_info_connect,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆交接信息添加失败");
            }
        }else{
            if (!businessService.updateSenderById(carInfo)) {
                throw new ChangeFailException("送车信息更改失败");
            }
        }
    }

    @Override
    public void addCarService(CarInfo carInfo) {
        if(businessService.getServiceInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setStatus(STATUS);
            if(StringUtils.isEmpty(carInfo.getNotes())){
                carInfo.setNotes("");
            }
            if(carInfoDao.addCarService(carInfo)){
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_bussines_service, Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆维修信息添加失败");
            }
        }else{
            if (!businessService.updateServiceById(carInfo)) {
                throw new ChangeFailException("修理信息更改失败");
            }
        }
    }

    @Override
    public void addCarParts(CarInfo carInfo) {
        StringBuilder pname = new StringBuilder();
        StringBuilder speci = new StringBuilder();
        StringBuilder number = new StringBuilder();
        List<CarInfo> list = carInfo.getPartsArray();
        if(StringUtils.isEmpty(carInfo.getNotes())){
            carInfo.setNotes("");
        }
        addParts(pname, speci, number, list);
        carInfo.setPartsName(pname.toString());
        carInfo.setSpecification(speci.toString());
        carInfo.setNumber(number.toString());
        carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
        carInfo.setStatus(STATUS);

        if(businessService.getPartsInfoByReceiveId(carInfo) == null){
            if (carInfoDao.addCarParts(carInfo)) {
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_bussines_parts,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆配件信息添加失败");
            }
        }else{
            if (!businessService.updatePartsById(carInfo)) {
                throw new ChangeFailException("车辆配件信息更改失败");
            }
        }
    }

    private void addParts(StringBuilder pname, StringBuilder speci, StringBuilder number, List<CarInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            CarInfo carInfo1 = list.get(i);
            pname.append(carInfo1.getPartsName());
            speci.append(carInfo1.getSpecification());
            number.append(carInfo1.getNumber());
            if(list.size()-i>1){
                pname.append(",");
                speci.append(",");
                number.append(",");
            }
        }
    }

    @Override
    public void addCarBeauty(CarInfo carInfo) {

        if(businessService.getBeautyInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setStatus(STATUS);
            if(StringUtils.isEmpty(carInfo.getNotes())){
                carInfo.setNotes("");
            }
            if(StringUtils.isEmpty(carInfo.getReceiveId())){
                throw new InsertDataException("登记序号不能为空");
            }
            if (carInfoDao.addCarBeauty(carInfo)) {
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_bussines_beautify,Table_Type.CarInfo,carInfo);

            }else{
                throw new InsertDataException("车辆美容信息添加失败");
            }
        }else{
            if (!businessService.updateBeautyById(carInfo)) {
                throw new ChangeFailException("美容信息更改失败");
            }
        }
    }

    @Override
    public void addCarPark(CarInfo carInfo) {
        if(businessService.getParkInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setStatus(STATUS);
            if(StringUtils.isEmpty(carInfo.getNotes())){
                carInfo.setNotes("");
            }
            if(carInfoDao.addCarPark(carInfo)){
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_bussines_park,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆停放信息添加失败");
            }
        }else{
            if (!businessService.updateParkById(carInfo)) {
                throw new ChangeFailException("车辆停放信息更改失败");
            }
        }


    }

    @Override
    public void addCarAccident(CarInfo carInfo) {
        if(StringUtils.isEmpty(carInfo.getNotes())){
            carInfo.setNotes("");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(carInfo.getDamage1());
        if(StringUtils.isNotEmpty(carInfo.getDamage2())){
            sb.append(",");
            sb.append(carInfo.getDamage2());
            if(StringUtils.isNotEmpty(carInfo.getDamage3())){
                sb.append(",");
                sb.append(carInfo.getDamage3());
            }
        }
        carInfo.setDamage1(sb.toString());

        if(businessService.getAAInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setReportTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setStatus(STATUS);
            if(carInfoDao.addCarAccident(carInfo)){
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_addinfo_accident,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("车辆事故信息添加失败");
            }
        }else{
            if (!businessService.updateAAById(carInfo)) {
                throw new ChangeFailException("事故车辆信息更改失败");
            }
        }


    }

    @Override
    public void addCarSuspicious(CarInfo carInfo) {
        if(businessService.getAsInfoByReceiveId(carInfo) == null){
            carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setReportTime(LocalDateTime.now().format(DATE_FORMAT));
            carInfo.setStatus(STATUS);
            if(StringUtils.isEmpty(carInfo.getNotes())){
                carInfo.setNotes("");
            }
            if(carInfoDao.addCarSuspicious(carInfo)){
                SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_addinfo_suspicious,Table_Type.CarInfo,carInfo);
            }else{
                throw new InsertDataException("可疑车辆信息添加失败");
            }
        }else{
            if (!businessService.updateASById(carInfo)) {
                throw new ChangeFailException("可疑车辆信息更改失败");
            }
        }


    }

    @Override
    public void addCarTake(CarInfo carInfo) {
        CarInfo carInfos = businessService.getTakerInfoByReceiveId(carInfo);
        if(carInfos != null){
            if(carInfos.getTaker() != null){
                carInfo.setModifiedTime(LocalDateTime.now().format(DATE_FORMAT));
                carInfo.setTakeTime(LocalDateTime.now().format(DATE_FORMAT));
                carInfo.setTakerIsself(carInfo.getIsself());
                if(carInfoDao.addCarTake(carInfo) == 1){
                    SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.car_info_connect,Table_Type.CarInfo,carInfo);

                }else{
                    throw new InsertDataException("登记序号有误");
                }
            }else{
                if (!businessService.updateTakerById(carInfo)) {
                    throw new ChangeFailException("取车信息更改失败");
                }
            }
        }

    }

    @Override
    public void addCarReceiveId(CarInfo carInfo) {
        carInfo.setCreateTime(LocalDateTime.now().format(DATE_FORMAT));
        if(getReceiveIdByReceiveId(carInfo.getReceiveId()) == null){
            carInfo.setStatus("0");
            if(carInfoDao.addCarReceiveId(carInfo) != 1){

                throw new InsertDataException(carInfo.getReceiveId()+"\t--\t登记序号添加失败");
            }
        }else{
            updateCarReceiveId(carInfo);
        }

    }

    @Override
    public List<CarInfo> listCarReceiveId(String receiveId) {
        return carInfoDao.listCarReceiveId(receiveId);
    }

    @Override
    public CarInfo getReceiveIdByReceiveId(String receiveId) {
        return carInfoDao.getReceiveIdByReceiveId(receiveId);
    }

    @Override
    public int updateCarReceiveId(CarInfo carInfo) {
        carInfo.setModifiedTime(LocalDateTime.now().format(DATE_FORMAT));
        carInfo.setStatus("1");
        return carInfoDao.updateCarReceiveId(carInfo);
    }

    @Override
    public List getReceviveIdByCompanyCode(CarInfo carInfo) {
        return carInfoDao.getReceviveIdByCompanyCode(carInfo);
    }

    @Override
    public Integer countTodayBusiness(CarInfo carInfo) {
        return carInfoDao.countTodayBusiness(carInfo);
    }

    @Override
    public Integer countTodayService(CarInfo carInfo) {
        return carInfoDao.countTodayService(carInfo);
    }

    @Override
    public Integer countTodayParts(CarInfo carInfo) {
        return carInfoDao.countTodayParts(carInfo);
    }

    @Override
    public Integer countTodayBeautify(CarInfo carInfo) {
        return carInfoDao.countTodayBeautify(carInfo);
    }

    @Override
    public Integer countTodayPark(CarInfo carInfo) {
        return carInfoDao.countTodayPark(carInfo);
    }


    private static Set<String> set = new HashSet<>();
    private int num;

    /**
     * 每天23:59:59 定时重置set，确保每天的序列号从零开始
     */
    @Scheduled(cron ="59 59 23 * * ?")
    private void resetSet(){
        set = new HashSet<>();
    }


    /**
     * 根据companyCode生成序列号
     * @param  companyCode 企业代码
     * @return receiveId
     */
    @Override
    public String makeReceiveId(String companyCode){
        if(!set.contains(companyCode)){
            set.add(companyCode);
            num = 0;
        }else{
            num++;
        }
        String time = LocalDateTime.now().format(FORMATTER);
        int length = Integer.valueOf(num).toString().length();
        String str = null;
        if(length == 1){
            str = "00"+num;
        }else if(length == 2){
            str = "0"+num;
        }else if(length == 3){
            str = ""+num;
        }
        String receiveId = companyCode + time + str;
        CarInfo car = new CarInfo();
        car.setReceiveId(receiveId);
        car.setCompanyCode(companyCode);
//            如果事故车辆或可疑车辆不存在该登记序号对应信息，将该条信息插入
        if(businessService.getAAInfoByReceiveId(car) == null){
            addCarAccident(car);
        }
        if(businessService.getAsInfoByReceiveId(car) == null){
            addCarSuspicious(car);
        }
        addCarReceiveId(car);
        return receiveId;
    }

}
