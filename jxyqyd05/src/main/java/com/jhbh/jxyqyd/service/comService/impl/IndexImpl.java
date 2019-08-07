package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.service.comService.IComBusinessService;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.service.comService.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Hayden
 * @Date:2019/7/3
 */
@Service
public class IndexImpl implements IndexService {




    @Autowired
    IComBusinessService businessService;
    @Autowired
    IComWorkerService workerService;

    @Override
    public Map<String,Object> showIndexData(CarInfo carInfo) {

        Map<String,Object> map = new HashMap<>(75);
        Map<String,Object> sevenDay = new HashMap<>(75);
        Map<String,Object> fifteenDay = new HashMap<>(75);
        List<Integer> service ;
        List<Integer> parts ;
        List<Integer> beauty ;
        List<Integer> park ;
        List<String> dates ;

//        如果未输入时间区间则默认为统计今日业务
        Integer timeZone = carInfo.getTimeZone();
        if(null == timeZone){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            carInfo.setStartTime(today);
            carInfo.setEndTime(today);

            map.put("sender",businessService.countCarSend(carInfo));
            map.put("taker", businessService.countCarTake(carInfo));
            map.put("basic", businessService.countCarBasic(carInfo));
            return map;
        }else{
            for (int i = 0; i < 2; i++) {
                if(i == 0){
                    timeZone = 7;
                    dates = setTimes(timeZone);

                    service = new ArrayList<>();
                    parts = new ArrayList<>();
                    beauty = new ArrayList<>();
                    park = new ArrayList<>();

                    setList(carInfo, service, parts, beauty, park, dates);
                    sevenDay.put("list",dates);
                    sevenDay.put("service",service);
                    sevenDay.put("parts",parts);
                    sevenDay.put("beauty",beauty);
                    sevenDay.put("park",park);
                    map.put("sevenDay",sevenDay);
                }else {
                    timeZone = 15;
                    dates = setTimes(timeZone);

                    service = new ArrayList<>();
                    parts = new ArrayList<>();
                    beauty = new ArrayList<>();
                    park = new ArrayList<>();

                    setList(carInfo, service, parts, beauty, park, dates);
                    fifteenDay.put("list",dates);
                    fifteenDay.put("service",service);
                    fifteenDay.put("parts",parts);
                    fifteenDay.put("beauty",beauty);
                    fifteenDay.put("park",park);
                    map.put("fifteenDay",fifteenDay);
                }
            }
        }

        return map;
    }

    @Override
    public Map<String, Object> showCountNum(CarInfo carInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        carInfo.setStartTime(format);
        carInfo.setEndTime(format);

        int send = businessService.countCarSend(carInfo);
        int take = businessService.countCarTake(carInfo);
        int basic = businessService.countCarBasic(carInfo);
        ComServiceWorkers workers = new ComServiceWorkers();
        workers.setCompanyCode(carInfo.getCompanyCode());
        workers.setStatus("0");
        Integer workerNum = workerService.countWorker(workers);

        Map<String, Object> map = new HashMap<>();
        map.put("worker",workerNum);
        map.put("accCar",send);
        map.put("takeCar",take);
        map.put("basic",basic);

        return map;
    }


    /**
     * 自定义时间填充
     * @param
     */
    @Override
    public List<String> setTimes(int timeZone){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < timeZone; i++) {
            int j ;
            if(i == 0){
                j = 0;
            }else{
                j=1;
            }
            calendar.add(Calendar.DATE,-j);
            String format = sdf.format(calendar.getTime());
            list.add(format);
        }
        return list;
    }

    /**
     * 将需要展示的echarts数据进行封装
     * @param carInfo
     * @param service
     * @param parts
     * @param beauty
     * @param park
     * @param dates
     */
    private void setList(CarInfo carInfo, List<Integer> service, List<Integer> parts, List<Integer> beauty, List<Integer> park, List<String> dates) {
        for (String today:dates) {
            carInfo.setStartTime(today);
            carInfo.setEndTime(today);
            service.add(businessService.countCarService(carInfo));
            parts.add(  businessService.countCarParts(carInfo));
            beauty.add( businessService.countCarBeauty(carInfo));
            park.add(   businessService.countCarPark(carInfo));
        }
    }

}
