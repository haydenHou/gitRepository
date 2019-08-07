package com.qbwl.bkglpt02.controller;

import com.qbwl.bkglpt02.entity.User;
import com.qbwl.bkglpt02.responseResult.ResponseResult;
import com.qbwl.bkglpt02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
@RestController
@RequestMapping("bkgl")
public class UserController extends BaseController{

    @Autowired
    IUserService userService;

    /**
     * 处理用户登录请求
     * @param user username，userpw
     * @return user userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
   @PostMapping("doLogin")
    public ResponseResult<User> doLogin(@RequestBody @Valid User user, HttpServletRequest request){
        logParam(request,user);
        User users = userService.doLogin(user);
        ResponseResult<User> rr = new ResponseResult<>();
        rr.setData(users);
        logParam(rr);
        return rr;
    }

    /**
     * 处理用户登录请求
     * @param user username，userpw
     * @return user userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    @PostMapping("doReg")
    public ResponseResult<User> doReg(@RequestBody @Valid User user, HttpServletRequest request){
        logParam(request,user);
        userService.doReg(user);
        ResponseResult<User> rr = new ResponseResult<>();
        logParam(rr);
        return rr;
    }

    /**
     * 用户更改密码
     * @param user username，userpw,newPw
     * @return
     */
    @PostMapping("doChangePw")
    public ResponseResult<User> doChangePw(@RequestBody @Valid User user, HttpServletRequest request){
        logParam(request,user);
        userService.doChangePw(user);
        ResponseResult<User> rr = new ResponseResult<>();
        logParam(rr);
        return rr;
    }


}
