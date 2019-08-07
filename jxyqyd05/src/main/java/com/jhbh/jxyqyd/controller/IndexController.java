package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.IndexArticle;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.IIndexArticleService;
import com.jhbh.jxyqyd.service.comService.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author:Hayden
 * @Date:2019/6/25
 */
@RestController
@CrossOrigin
@RequestMapping("qy")
public class IndexController extends BaseController{

    @Autowired
    IndexService indexService;

    @Autowired
    IIndexArticleService articleService;

    /**
     * 首页车辆业务信息统计展示
     * @param carInfo timeZone 7  15
     * @param request
     * @return
     */
    @PostMapping("showBusinessData")
    public ResponseResult<Map<String, Object>> mapTodayBusinessData(@RequestBody @Valid CarInfo carInfo, HttpServletRequest request){
        logParam(carInfo);
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        Map<String, Object> map = indexService.showIndexData(carInfo);
        ResponseResult<Map<String, Object>> rr = new ResponseResult<>();
        rr.setData(map);
        logParam(rr);
        return rr;
    }

    /**
     * 首页车辆业务信息统计展示
     * 从业人员 本日业务 本日取车 本日收车
     * @param request 需要从请求头中获取username
     * @return
     */
    @PostMapping("showCountNum")
    public ResponseResult<Map<String, Object>> showCountNum(HttpServletRequest request){
        CarInfo carInfo = new CarInfo();
        carInfo.setCompanyCode(getCompanyCodeByJwt(request));
        Map<String, Object> map = indexService.showCountNum(carInfo);
        ResponseResult<Map<String, Object>> rr = new ResponseResult<>();
        rr.setData(map);
        logParam(rr);
        return rr;
    }

    /**
     * 展示登录页面需要展示的文章摘要
     * @return 文章标题，类型，时间
     */
    @PostMapping("getIndexAbstract")
    public ResponseResult<List> showIndexTitle(HttpServletRequest request){
        List<IndexArticle> list = articleService.getIndexAbstract();

        ResponseResult<List> rr = new ResponseResult<>();
        rr.setData(list);
        return rr;
    }





}
