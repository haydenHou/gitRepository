package com.qbwl.aspect_demo.service;

import com.qbwl.aspect_demo.entity.User;

/**
 * @author:Hayden
 * @Date:2019/8/1
 */
public interface UserService{


    void addUser(User user);


    void updateUser(User user);

    void deleteUser(User user);
}
