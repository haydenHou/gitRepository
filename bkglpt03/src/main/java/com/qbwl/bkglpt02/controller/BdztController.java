package com.qbwl.bkglpt02.controller;

import com.qbwl.bkglpt02.aspect.anno.SysLog;
import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.entity.PageEntity;
import com.qbwl.bkglpt02.responseResult.ResponseResult;
import com.qbwl.bkglpt02.service.IBDZTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
@RestController
@RequestMapping("bkgl")
public class BdztController extends BaseController {
    @Autowired
    IBDZTService bdztService;

    /**
     * 根据人员姓名，身份证号模糊查询获取可疑人员列表
     * @param bdztry xm,sfzh
     * @return rybh,xm, bmch,xb,csrq,sfzh,lxfs,hjdxz,xzdxz,sg,ajbh,ajlb,tprq,dbjb,tjjb,jj,ladwqh,zbr,jyaq
     */
    @PostMapping("listBdzt")
    public ResponseResult<PageEntity> listBdzt(@Valid @RequestBody BDZTRY bdztry, HttpServletRequest request){
        logParam(request,bdztry.getXm());
        List<BDZTRY> list = bdztService.listShowEnteringBdzt(bdztry);
        ResponseResult<PageEntity> rr = new ResponseResult<>();
        rr.setData(new PageEntity<>(list));
        return rr;
    }

    /**
     * 根据人员编号获取嫌疑人详细信息
     * @param bdztry rybh
     */
    @PostMapping("getBdzt")
    public ResponseResult<BDZTRY> getBdzt(@Valid @RequestBody BDZTRY bdztry, HttpServletRequest request){
        logParam(request,bdztry.getRybh());
        BDZTRY bdztrys = bdztService.getByPrimaryKey(bdztry.getRybh());
        ResponseResult<BDZTRY> rr = new ResponseResult<>();
        rr.setData(bdztrys);
        return rr;
    }


    /**
     * 新增bdzt人员信息
     * @param bdztry  rXm,rBmch,rXb,rCsrq,rSfzh,rHjdxz,rXzdxz,rSg,rAjbh,rAjlb,rJyaq,rTprq,rDbjb,rJj,rTjjb,rLadwqh,rZbr,rLxfs
     * @return
     */
    @PostMapping("insertBdzt")
    public ResponseResult insertBdzt(@Valid @RequestBody BDZTRY bdztry, HttpServletRequest request){
        logParam(request,bdztry);
        bdztService.insert(bdztry);
        return new ResponseResult();
    }

    /**
     * 更改bdzt人员信息
     * @param bdztry   rXm,rBmch,rXb,rCsrq,rSfzh,rHjdxz,rXzdxz,rSg,rAjbh,rAjlb,rJyaq,rTprq,rDbjb,rJj,rTjjb,rLadwqh,rZbr,rLxfs
     */
    @PostMapping("updateBdzt")
    public ResponseResult updateBdzt(@Valid @RequestBody BDZTRY bdztry, HttpServletRequest request){
        logParam(request,bdztry);
        bdztService.updateByPrimaryKeySelective(bdztry);
        return new ResponseResult();
    }


    /**
     * 更改bdzt人员信息
     * @param bdztry   rybh
     */
    @PostMapping("delBdzt")
    public ResponseResult delBdzt(@Valid @RequestBody BDZTRY bdztry, HttpServletRequest request){
        logParam(request,bdztry);
        bdztService.deleteByPrimaryKey(bdztry.getRybh());
        return new ResponseResult();
    }

}
