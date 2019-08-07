package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.dao.ComBusinessDao;
import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.service.GBService.IGbCarDamageService;
import com.jhbh.jxyqyd.service.comService.IComBusinessService;
import com.jhbh.jxyqyd.service.comService.IndexService;
import com.jhbh.jxyqyd.utils.ParametricSwitchUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Hayden
 * @Date:2019/5/16
 */
@Service
public class ComBusinessImpl implements IComBusinessService {

    @Autowired
    ComBusinessDao bussinessDao;

    @Autowired
    IGbCarDamageService damageService;

    @Autowired
    IndexService indexService;



    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Map countComBusiness(CarInfo carInfo) {
        setTime(carInfo);
        Map<String,Integer> map = new HashMap<>();
            map.put("send",countCarSend(carInfo));
            map.put("take",countCarTake(carInfo));
            map.put("service",countCarService(carInfo));
            map.put("parts",countCarParts(carInfo));
            map.put("beauty",countCarBeauty(carInfo));
            map.put("park",countCarPark(carInfo));
            map.put("accident",countCarAccident(carInfo));
            map.put("suspicious",countCarSuspicious(carInfo));
        return map;
    }

    @Override
    public List<CarInfo> listCarBasicInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> basicInfo = bussinessDao.listCarBasicInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(basicInfo);
        return basicInfo;
    }

    @Override
    public List<CarInfo> listCarSenderInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carSenderInfo = bussinessDao.listCarSenderInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carSenderInfo);
        return carSenderInfo;
    }

    @Override
    public List<CarInfo> listCarTakerInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carTakerInfo = bussinessDao.listCarTakerInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carTakerInfo);
        return carTakerInfo;
    }

    @Override
    public List<CarInfo> listCarServiceInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carServiceInfo = bussinessDao.listCarServiceInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carServiceInfo);
        return carServiceInfo;
    }

    @Override
    public List<CarInfo> listCarPartsInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carPartsInfo = bussinessDao.listCarPartsInfo(carInfo);
//      将合并的配件信息进行拆分供给前端展示
        for (CarInfo c: carPartsInfo) {
         String   partsName = c.getPartsName();
         String   number = c.getNumber();
         String   specification = c.getSpecification();

         String[] pnames  = partsName.split(",");
         String[] numbers = number.split(",");
         String[] specis  = specification.split(",");

         List<CarInfo> list = new ArrayList<>();
            for (int i = 0; i < pnames.length; i++) {
                CarInfo car = new CarInfo();
                car.setPartsName(pnames[i]);
                car.setNumber(numbers[i]);
                car.setSpecification(specis[i]);
                list.add(car);
                c.setPartsArray(list);
            }
        }
        ParametricSwitchUtil.carInfoSwitch(carPartsInfo);
        return carPartsInfo;
    }

    @Override
    public List<CarInfo> listCarBeautyInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carBeautyInfo = bussinessDao.listCarBeautyInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carBeautyInfo);
        return carBeautyInfo;
    }

    @Override
    public List<CarInfo> listCarParkInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carParkInfo = bussinessDao.listCarParkInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carParkInfo);
        return carParkInfo;
    }

    @Override
    public List<CarInfo> listCarAccidentInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carAccidentInfo = bussinessDao.listCarAccidentInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carAccidentInfo);
        return carAccidentInfo;
    }

    @Override
    public List<CarInfo> listCarSuspiciousInfo(CarInfo carInfo) {
        setTime(carInfo);
        List<CarInfo> carSuspiciousInfo = bussinessDao.listCarSuspiciousInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carSuspiciousInfo);
        return carSuspiciousInfo;
    }

    @Override
    public List<CarInfo> listCarBasicAndConnectInfo(CarInfo carInfo) {
        List<CarInfo> carInfos = bussinessDao.listCarBasicAndConnectInfo(carInfo);
        ParametricSwitchUtil.carInfoSwitch(carInfos);
        return carInfos;
    }

    @Override
    public CarInfo getBasicInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getBasicInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getSenderInfoByReceiveId(CarInfo carInfo) {
        CarInfo ca = bussinessDao.getSenderInfoByReceiveId(carInfo);
        if(ca!=null){
            ParametricSwitchUtil.carInfoSwitch(ca);
        }
        return ca;
    }

    @Override
    public CarInfo getTakerInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getTakerInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getServiceInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getServiceInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getPartsInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getPartsInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getBeautyInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getBeautyInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getParkInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getParkInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getAAInfoByReceiveId(CarInfo carInfo) {
        CarInfo carInfo1 = bussinessDao.getAAInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public CarInfo getAsInfoByReceiveId(CarInfo carInfo) {

        CarInfo carInfo1 = bussinessDao.getAsInfoByReceiveId(carInfo);
        if(carInfo1!=null){
            ParametricSwitchUtil.carInfoSwitch(carInfo1);
        }
        return carInfo1;
    }

    @Override
    public Boolean updateBasicById(CarInfo carInfo) {
        return bussinessDao.updateBasicById(carInfo);
    }

    @Override
    public Boolean updateSenderById(CarInfo carInfo) {
        carInfo.setAccTime(sdf.format(new Date()));
        return bussinessDao.updateSenderById(carInfo);
    }

    @Override
    public Boolean updateTakerById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        carInfo.setTakeTime(sdf.format(new Date()));
        carInfo.setTakerIsself(carInfo.getIsself());
        return bussinessDao.updateTakerById(carInfo);
    }

    @Override
    public Boolean updateServiceById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updateServiceById(carInfo);
    }

    @Override
    public Boolean updatePartsById(CarInfo carInfo) {
        StringBuilder pname = new StringBuilder();
        StringBuilder speci = new StringBuilder();
        StringBuilder number = new StringBuilder();
        List<CarInfo> list = carInfo.getPartsArray();

        if(StringUtils.isEmpty(carInfo.getNotes())){
            carInfo.setNotes("");
        }
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
        carInfo.setPartsName(pname.toString());
        carInfo.setSpecification(speci.toString());
        carInfo.setNumber(number.toString());

        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updatePartsById(carInfo);
    }

    @Override
    public Boolean updateBeautyById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updateBeautyById(carInfo);
    }

    @Override
    public Boolean updateParkById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updateParkById(carInfo);
    }

    @Override
    public Boolean updateAAById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updateAAById(carInfo);
    }

    @Override
    public Boolean updateASById(CarInfo carInfo) {
        carInfo.setModifiedTime(sdf.format(new Date()));
        return bussinessDao.updateASById(carInfo);
    }


    /**
     * 如果未选择开始和结束时间，则统计前三天的业务量
     * @param carInfo startTime,endTime
     */
    private void setTime(CarInfo carInfo){
        //      如果未选择开始和结束时间，则统计前三天的业务量
        if(StringUtils.isEmpty(carInfo.getStartTime())&&StringUtils.isEmpty(carInfo.getEndTime())){

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calendar.add(Calendar.DATE, -3);

            carInfo.setStartTime(sdf.format(calendar.getTime()));
            carInfo.setEndTime(sdf.format(new Date()));
        }
        if(StringUtils.isNotEmpty(carInfo.getStartTime())&& StringUtils.isEmpty(carInfo.getEndTime())){
            carInfo.setEndTime(sdf.format(new Date()));
        }
    }

    @Override
    public int countCarBasic(CarInfo carInfo) {
        return bussinessDao.countCarBasic(carInfo);
    }

    @Override
    public int countCarSend(CarInfo carInfo) {
        return bussinessDao.countCarSend(carInfo);
    }

    @Override
    public int countCarTake(CarInfo carInfo) {
        return bussinessDao.countCarTake(carInfo);
    }

    @Override
    public int countCarService(CarInfo carInfo) {
        return bussinessDao.countCarService(carInfo);
    }

    @Override
    public int countCarParts(CarInfo carInfo) {
        return bussinessDao.countCarParts(carInfo);
    }

    @Override
    public int countCarBeauty(CarInfo carInfo) {
        return bussinessDao.countCarBeauty(carInfo);
    }

    @Override
    public int countCarPark(CarInfo carInfo) {
        return bussinessDao.countCarPark(carInfo);
    }

    @Override
    public int countCarAccident(CarInfo carInfo) {
        return bussinessDao.countCarAccident(carInfo);
    }

    @Override
    public int countCarSuspicious(CarInfo carInfo) {
        return bussinessDao.countCarSuspicious(carInfo);
    }
}
