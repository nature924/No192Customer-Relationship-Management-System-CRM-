package com.example.cra.mapper;

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
public class UsersMapperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void login() {
        Users users = new Users();
        users.setUser_name("admin");
        users.setPassword("admin");
        Users u = usersMapper.login(users);
        System.out.println(u.toString());
    }

    @Test
    public void register() {
        Users users = new Users();
        users.setUser_name("abc");
        users.setPassword("abc");
        users.setSex("男");
        users.setBirthday(new Date());
        users.setRole_id(1);
        users.setStatus(2);
        usersMapper.register(users);
    }

    @Test
    public void selectRoleId() {
        int i = usersMapper.selectRoleId("admin");
        System.out.println("RoleId:"+i);
    }
    @Test
    public void deleteUsers(){
        String user_name = "abc";
        int e = usersMapper.deleteUsers(user_name);
        if(e>0){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
    }
    @Test
    public void selectAll() {
        List<Users> list = usersMapper.selectAll();
        for (Users u : list) {
            System.out.println(u.toString());
        }
    }
    @Test
    public void updateUsers(){
        Users users = new Users();
        users.setUser_name("abc");
        users.setPassword("12314");
       // usersMapper.updateUsers(users);
    }
}
