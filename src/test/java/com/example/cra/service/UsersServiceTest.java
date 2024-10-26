package com.example.cra.service;

import com.example.cra.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Test
    public void login() {
        Users result = usersService.login(null, null);
        System.out.println(result.toString());
    }

    //系统管理员创建用户信息，默认角色为销售
    @Test
    public void createUsers() {
        Users user = new Users();
        user.setUser_name("7月8日");
        user.setPassword("7月8日");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setRole_id(3);
        user.setStatus(1);
        String result = usersService.createUsers(user);
        System.out.println(result);
    }
}
