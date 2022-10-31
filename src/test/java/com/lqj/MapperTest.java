package com.lqj;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lqj.entity.User;
import com.lqj.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author lqj
 * @Date 2022-10-24 15:19
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper(){
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName,"lqj"));
        System.out.println(user);
    }

}
