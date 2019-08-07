package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.GB.GbCarDamage;
import com.jhbh.jxyqyd.entity.GB.XaRegisterAgency;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.GBService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@RestController
@CrossOrigin
@RequestMapping("qy")
public class GBController extends BaseController {
    @Autowired
    IGbPunishTypeService punishTypeService;
    @Autowired
    IGbCarTypeService carTypeService;
    @Autowired
    IGbEcotypeService ecotypeService;
    @Autowired
    IGbDegreeService degreeService;
    @Autowired
    IGbCarDamageService damageService;
    @Autowired
    IGbCarProService proService;
    @Autowired
    IGbCarService carService;
    @Autowired
    IGbSuseTypeService suseTypeService;
    @Autowired
    IGbIdTypeService idTypeService;
    @Autowired
    IGbRegisterService registerService;
    @Autowired
    IGbXaRegisterService xaRegisterService;
    @Autowired
    IGbCarColorService carColorService;
    @Autowired
    IGBComtypeService comtypeService;




    /**
     *展示供选择的相关参数对应代码
     */
    @PostMapping(value ={
            "getCarType","getPunishType","getEcotype","getDegree","getRegister","getCarService","getCarPro","getSuseType","getIdType",
            "getCarColor","getComType"
            })
    public ResponseResult<List> getCarTypeByName(HttpServletRequest request){

        String uri = getURI(request);
        ResponseResult <List> rr = new ResponseResult<>();
        List list = new ArrayList();
        if(("getCarType").equals(uri)){
//            车辆类型
            list = carTypeService.getCarType();
        }else if(("getPunishType").equals(uri)){
//            处罚类别
            list = punishTypeService.getPunishCode();
        }else if(("getEcotype").equals(uri)){
//            经济类型
            list = ecotypeService.getEcotype();
        }else if(("getDegree").equals(uri)){
//           文化程度
            list = degreeService.getDegreeCode();
        }else if(("getCarService").equals(uri)){
//            车辆修理部位
            list = carService.getCarService();
        }else if(("getCarPro").equals(uri)){
//            车辆修理原因
            list = proService.getCarProservice();
        }else if(("getSuseType").equals(uri)){
//            车辆修理原因
            list = suseTypeService.getSuseType();
        }else if (("getRegister").equals(uri)){
//            查询行政区划
            list = registerService.listDistrict();
        }else if(("getIdType").equals(uri)){
            list = idTypeService.listIdType();
        }else if(("getCarColor").equals(uri)){
            list = carColorService.getColor();
        }else if("getComType".equals(uri)){
            list = comtypeService.listComtyoe();
        }
        rr.setData(list);
        logParam(rr);
        return rr;
    }

    /**
     *展示供选择的相关参数对应代码
     * @param   typeName
     */
    @PostMapping(value ="getCarDamage")
    public ResponseResult<List> getCarDamage(HttpServletRequest request,@RequestBody @Valid GbCarDamage typeName){

        ResponseResult <List> rr = new ResponseResult<>();
//            配件名称
        List list = damageService.getCodeByName(typeName.getTypeName());
        rr.setData(list);
        logParam(rr);
        return rr;
    }


    /**
     * 获取各街道派出所代码和名称
     * @param code 代码
     * @return
     */
    @PostMapping("getXaRegister")
    public ResponseResult<List<XaRegisterAgency>> listXaRetister(@RequestBody @Valid  XaRegisterAgency code){

        ResponseResult<List<XaRegisterAgency>> rr = new ResponseResult<>();
//            查询派出所
            String districtCode = null;
            if(code.getDistrictCode()!=null){
                districtCode = code.getDistrictCode()+"000000";
            }
            rr.setData(xaRegisterService.listXaRegister(districtCode));
            return  rr;
    }



}
