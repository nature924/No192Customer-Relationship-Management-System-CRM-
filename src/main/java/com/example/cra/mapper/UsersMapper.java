package com.example.cra.mapper;

import com.example.cra.entity.Users;
import com.example.cra.util.SelectUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    //登陆
    public Users login(Users users);

    //注册
    public int register(Users user);

    //权限查询 TODO
    public int selectRoleId(String user_name);

    //删除用户
    public int deleteUsers(String user_name);

    //查看用户
    public List<Users> selectAll();

    //编辑用户
    public int updateUsers(@Param("editname") String editname, @Param("editRole") String editRole);

    //查询满足条件的用户
    public List<Users> selectUsers(SelectUsers selectUsers);

    //根据用户名查找用户id
    public int findUserIdByUserName(@Param("user_name") String user_name);

    public int checkname(String username);

    public Users queryuser(int user_id);

    public int updateUser(Users user);

}
