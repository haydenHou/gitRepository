package com.qbwl.bkglpt02.service;

import com.qbwl.bkglpt02.entity.User;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
public interface IUserService {

    /**
     * 根据userid删除用户
     * @param userid 用户表单序列id
     */
    void deleteByPrimaryKey(String userid);

    /**
     * 添加用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    void insert(User record);

    /**
     * 选择性添加用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    void insertSelective(User record);

    /**
     * 根据用户id查询用户详细信息
     * @param userid 用户序列id
     * @return userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    User selectByPrimaryKey(String userid);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    User getUserByUsername(String username);

    /**
     * 选择性根据userid更改用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    void updateByPrimaryKeySelective(User record);

    /**
     * 根据用户id更改全部参数
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    void updateByPrimaryKey(User record);

    /**
     * 处理用户登录请求
     * @param user username，userpw
     * @return token,userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    User doLogin(User user);

    /**
     * 处理用户注册
     * @param user userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    void doReg(User user);

    /**
     * 更改用户密码
     * @param user userid，userpw
     */
    void doChangePw(User user);
}
