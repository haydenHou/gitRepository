package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.dao.UserMapper;
import com.qbwl.bkglpt02.entity.User;
import com.qbwl.bkglpt02.exception.*;
import com.qbwl.bkglpt02.service.IUserService;
import com.qbwl.bkglpt02.utils.tokenUtils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
@Service
public class UserImpl implements IUserService {

    /**
     * 用于创建序列号的日期格式
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 用于保存的详细时间格式
     */
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 详细保存时间的字符串
     */
//    private static final String TIME = LocalDateTime.now().format(DATE_FORMAT);
    private static final String TIME = LocalDateTime.now().format(DATE_FORMAT);
    @Autowired
    UserMapper userMapper;

    @Override
    public User doLogin(User user) {
        User users = getUserByUsername(user.getUsername());
        if (users!=null) {
            if(users.getUserpw().equals(user.getUserpw())){
                users.setToken(TokenUtils.createJwtToken(users.getUsername() + "," + users.getUserRank()));
//                TODO 需要对登录状态进行更改
                return users;
            }else{
                throw new PasswordNotMatchException("密码不匹配");
            }
        }else{
            throw new UserNotFoundException("该用户不存在");
        }
    }


    @Override
    public void doReg(User user) {
        User users = getUserByUsername(user.getUsername());
        if(users == null){
//          TODO  需要对密码进行加密
            user.setUserDate(new Date());
            System.out.println(user.getUserDate());
            insert(user);
        }else{
            throw new UsernameConflictException("该用户已经存在");
        }
    }

    @Override
    public void doChangePw(User user) {
        User users = getUserByUsername(user.getUsername());
        if (users!=null) {
            if(users.getUserpw().equals(user.getUserpw())){
                user.setUserpw(user.getNewPw());
                updateByPrimaryKeySelective(user);
            }else{
                throw new PasswordNotMatchException("密码不匹配");
            }
        }else{
            throw new UserNotFoundException("该用户不存在");
        }
    }

    @Override
    public void deleteByPrimaryKey(String userid) {
        if (userMapper.deleteByPrimaryKey(userid) != 1){
          throw new DeleteFailException("用户信息删除失败");
        }
    }

    @Override
    public void insert(User record) {
        if(userMapper.insert(record)!=1){
            throw new InsertFailException("用户信息添加失败");
        }
    }

    @Override
    public void insertSelective(User record) {
        if (userMapper.insertSelective(record)!=1) {
            throw new InsertFailException("用户信息添加失败");
        }
    }

    @Override
    public User selectByPrimaryKey(String userid) {
        User byPrimaryKey = userMapper.getByPrimaryKey(userid);
        if( byPrimaryKey == null){
            throw new NoResultException("未匹配到有效数据");
        }
        return byPrimaryKey;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if(user == null){
            throw new NoResultException("未匹配到有效数据");
        }
        return user;
    }

    @Override
    public void updateByPrimaryKeySelective(User record) {
        if (userMapper.updateByPrimaryKeySelective(record)!=1) {
            throw new UpdateFailException("用户信息更改失败");
        }
    }

    @Override
    public void updateByPrimaryKey(User record) {
        if (userMapper.updateByPrimaryKey(record)!=1) {
            throw new UpdateFailException("用户信息更改失败");
        }
    }


}
