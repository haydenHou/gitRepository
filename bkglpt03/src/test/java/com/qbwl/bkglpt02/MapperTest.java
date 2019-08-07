package com.qbwl.bkglpt02;

import com.qbwl.bkglpt02.dao.UserMapper;
import com.qbwl.bkglpt02.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
public class MapperTest extends Bkglpt01ApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserMapper() {

        User user = userMapper.getByPrimaryKey("014422");
        System.out.println(user);
    }
}
