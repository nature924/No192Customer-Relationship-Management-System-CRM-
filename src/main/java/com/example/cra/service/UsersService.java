package com.example.cra.service;

import com.example.cra.entity.Users;
import com.example.cra.util.SelectUsers;

import java.text.ParseException;
import java.util.List;

public interface UsersService {

    //登录
    public Users login(String username, String password);

    //系统管理员创建用户信息，默认角色为销售
    public String createUsers(Users user);

    //系统管理员对系统所有用户进行编辑
    public String editUsers(String editname, String editRole);

    //系统管理员对系统所有用户进行删除
    public String delUsers(String user_name);

    //系统管理员对系统所有用户进行查看
    public List<Users> listUsers();

    //查询满足条件的Users
    public List<Users> selectUsers(SelectUsers selectUsers) throws ParseException;

    //通过用户名查找用户id
    public int findUserIdByUserName(String user_name);

    //检测用户名
    public String checkname(String username);

    //查询用户
    public Users queryuser(int user_id);

    public  boolean updateUser(Users user);
}
