package com.qbwl.aspect_demo.service.impl;

import com.qbwl.aspect_demo.entity.User;
import com.qbwl.aspect_demo.exception.UsernameConflictException;
import com.qbwl.aspect_demo.exception.exception;
import com.qbwl.aspect_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author:Hayden
 * @Date:2019/8/1
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        System.out.println(user+"添加成功");
    }

    @Override
    public void updateUser(User user) {
            System.out.println(user+"更改成功");
    }

    @Override
    public void deleteUser(User user) {
        if("1".equals(user.getName())){
            System.out.println(user+"删除成功");
        }else {
            throw new UsernameConflictException("用户不存在");
        }

    }
}
