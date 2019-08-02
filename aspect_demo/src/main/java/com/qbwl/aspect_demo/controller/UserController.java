package com.qbwl.aspect_demo.controller;

import com.qbwl.aspect_demo.entity.User;
import com.qbwl.aspect_demo.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author:Hayden
 * @Date:2019/8/1
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("test")
    public String getUser(@RequestBody @Valid User name){
        userService.addUser(name);
        userService.updateUser(name);
        userService.deleteUser(name);
        return "hello";
    }


}
