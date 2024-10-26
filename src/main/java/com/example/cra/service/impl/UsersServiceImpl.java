package com.example.cra.service.impl;

import com.example.cra.entity.Users;
import com.example.cra.mapper.UsersMapper;
import com.example.cra.service.UsersService;
import com.example.cra.util.SelectUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String username, String password) {
        Users user = new Users();
        user.setUser_name(username);
        user.setPassword(password);
        Users result = usersMapper.login(user);
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public String createUsers(Users user) {
        int result = usersMapper.register(user);
        if (result > 0) {
            return "创建用户成功！";
        } else {
            return "创建用户失败！";
        }
    }

    @Override
    public String editUsers(String editname, String editRole) {
        int result = usersMapper.updateUsers(editname, editRole);
        if (result > 0) {
            return "修改用户成功！";
        } else {
            return "修改用户失败！";
        }
    }

    @Override
    public String delUsers(String username) {
        int result = usersMapper.deleteUsers(username);
        if (result > 0) {
            return "删除用户成功！";
        } else {
            return "删除用户失败！";
        }
    }

    @Override
    public List<Users> listUsers() {
        List<Users> users = new ArrayList<Users>();
        users = usersMapper.selectAll();
        return users;
    }

    @Override
    public List<Users> selectUsers(SelectUsers selectUsers) {
        List<Users> users = new ArrayList<Users>();
        users = usersMapper.selectUsers(selectUsers);
        return users;
    }

    @Override
    public int findUserIdByUserName(String user_name) {
        return usersMapper.findUserIdByUserName(user_name);
    }

    //检测用户名
    @Override
    public String checkname(String username) {
        int result = usersMapper.checkname(username);
        if (result > 0) {
            return "用户名已存在，不能使用！";
        } else {
            return "用户名可以使用！";
        }
    }

    //查询用户
    @Override
    public Users queryuser(int user_id) {
        return usersMapper.queryuser(user_id);
    }

    @Override
    public boolean updateUser(Users user) {
        int result = usersMapper.updateUser(user);
        if (result>0){
            return  true;
        }else {
            return false;
        }
    }
}
