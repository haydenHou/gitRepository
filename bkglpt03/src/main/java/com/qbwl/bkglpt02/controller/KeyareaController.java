package com.qbwl.bkglpt02.controller;

import com.qbwl.bkglpt02.entity.Keyarea;
import com.qbwl.bkglpt02.entity.PageEntity;
import com.qbwl.bkglpt02.responseResult.ResponseResult;
import com.qbwl.bkglpt02.service.IKeyareaService;
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
public class KeyareaController extends BaseController{

    @Autowired
    IKeyareaService keyareaService;

    /**
     * 添加报警信息
     * @param keyarea   kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     * @return
     */
    @PostMapping("insertKeyArea")
    public ResponseResult insert(@Valid @RequestBody Keyarea keyarea, HttpServletRequest request){
        logParam(request,keyarea);
        keyareaService.insert(keyarea);
        return new ResponseResult();
    }

    /**
     *根据kaid删除对应信息
     * @param keyarea kaid
     * @return 200 401 402
     */
    @PostMapping("deleteKeyAreaByKaid")
    public ResponseResult delete(@Valid @RequestBody Keyarea keyarea, HttpServletRequest request){
        logParam(request,keyarea);
        keyareaService.deleteByPrimaryKey(keyarea.getKaid());
        return new ResponseResult();
    }

    /**
     *根据kaid更改对应信息
     * @param keyarea kaid,kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     */
    @PostMapping("updateKeyAreaSelective")
    public ResponseResult update(@Valid @RequestBody Keyarea keyarea, HttpServletRequest request){
        logParam(request,keyarea);
        keyareaService.updateByPrimaryKeySelective(keyarea);
        return new ResponseResult();
    }

    /**
     * 根据kaid查询 对应信息
     * @param keyarea kaid
     * @return
     */
    @PostMapping("getKeyAreaByKaid")
    public ResponseResult<Keyarea> getKeyareaById(@Valid @RequestBody Keyarea keyarea, HttpServletRequest request){
        logParam(request,keyarea);
        ResponseResult<Keyarea> rr = new ResponseResult<>();
        rr.setData(keyareaService.getByPrimaryKey(keyarea.getKaid()));
        return rr;
    }

    /**
     * 根据可以类型和治安管理机构查询报警信息
     * @param keyarea katype,kasecurityorg
     */
    @PostMapping("listKeyArea")
    public ResponseResult<PageEntity> listByKatypeAndKasecurityorg(@Valid @RequestBody Keyarea keyarea, HttpServletRequest request){
        logParam(request,keyarea);
        ResponseResult<PageEntity> rr = new ResponseResult<>();
        List<Keyarea> keyareas = keyareaService.listByKatypeAndKasecurityorg(keyarea);
        rr.setData(new PageEntity<>(keyareas));
        return rr;
    }






}
