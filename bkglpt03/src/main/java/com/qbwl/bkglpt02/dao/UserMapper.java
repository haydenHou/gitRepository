package com.qbwl.bkglpt02.dao;

import com.qbwl.bkglpt02.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 根据userid删除用户
     * @param userid 用户表单序列id
     * @return  成功返回1，失败返回0
     */
    int deleteByPrimaryKey(String userid);

    /**
     * 添加用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     * @return 成功返回1，失败返回0
     */
    int insert(User record);

    /**
     * 选择性添加用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     * @return 成功返回1，失败返回0
     */
    int insertSelective(User record);

    /**
     * 根据用户id查询用户详细信息
     * @param userid 用户序列id
     * @return userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    User getByPrimaryKey(String userid);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return userid, username, userpw, userdate, department, company, active, fail, super, userrank
     */
    User getUserByUsername(String username);

    /**
     * 选择性根据userid更改用户信息
     * @param record userid, username, userpw, userdate, department, company, active, fail, super, userrank
     * @return 成功为1，失败为0
     */
    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);
}