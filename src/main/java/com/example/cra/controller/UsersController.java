package com.example.cra.controller;

import com.example.cra.entity.Users;
import com.example.cra.service.UsersService;
import com.example.cra.util.SelectUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Users result = usersService.login(username, password);
        if (result != null) {
            request.getSession().setAttribute("username", username);
            map.put("success", true);
            map.put("msg", "登陆成功！");
        } else {
            map.put("success", false);
            map.put("msg", "登陆失败！");
        }
        return map;
    }

    //系统管理员创建用户信息，默认角色为销售
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public Map<String, Object> addUsers(HttpServletRequest request) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        Users user = new Users();
        user.setUser_name(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        user.setBirthday(date);
        user.setRole_id(Integer.parseInt(request.getParameter("authority")));
        user.setStatus(1);
        String result = usersService.createUsers(user);
        map.put("msg", result);
        return map;
    }

    @RequestMapping(value = "/selectUsers", method = RequestMethod.POST)
    public Map<String, Object> selectUsers(@RequestParam("select_username") String username,
                                           @RequestParam("select_sex") String sex,
                                           @RequestParam("datemin") String datemin,
                                           @RequestParam("datemax") String datemax,
                                           @RequestParam("select_role") String select_role,
                                           @RequestParam("select_status") String select_status) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        SelectUsers selectUsers = new SelectUsers();
        selectUsers.setUsername(username);
        selectUsers.setSex(sex);
        if (datemin != null && datemin != "") {
            selectUsers.setDatemin(datemin);
        }
        if (datemax != null && datemax != "") {
            selectUsers.setDatemax(datemax);
        }
        selectUsers.setSelect_role(Integer.parseInt(select_role));
        selectUsers.setSelect_status(Integer.parseInt(select_status));
        List<Users> users = usersService.selectUsers(selectUsers);
        map.put("users", users);
        return map;
    }

    //修改用户角色
    @RequestMapping(value = "/editUsers", method = RequestMethod.POST)
    public Map<String, Object> editUsers(@RequestParam("editname") String editname,
                                         @RequestParam("editRole") String editRole) {
        Map<String, Object> map = new HashMap<String, Object>();
        String result = usersService.editUsers(editname, editRole);
        map.put("msg", result);
        return map;
    }

    //系统管理员对系统所有用户进行删除
    @RequestMapping(value = "/delUsers", method = RequestMethod.GET)
    public Map<String, Object> delUsers(@RequestParam("del_user_name") String del_user_name) {
        Map<String, Object> map = new HashMap<String, Object>();
        String result = usersService.delUsers(del_user_name);
        map.put("msg", result);
        return map;
    }

    //系统管理员对系统所有用户进行查看
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public Map<String, Object> listUsers() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Users> users = new ArrayList<Users>();
        users = usersService.listUsers();
        map.put("users", users);
        return map;
    }

    //获取session
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public Map<String, Object> session(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("session", request.getSession().getAttribute("username"));
        return map;
    }

    //通过用户名获取用户id
    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
    public Map<String, Integer> getUserId(@RequestParam("user_name") String user_name) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer user_id = usersService.findUserIdByUserName(user_name);
        map.put("user_id", user_id);
        System.out.println(user_id);
        return map;
    }

    //检测用户名
    @RequestMapping(value = "/checkname", method = RequestMethod.POST)
    public Map<String, Object> checkname(@RequestParam("username") String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        String result = usersService.checkname(username);
        map.put("msg", result);
        return map;
    }

    @RequestMapping(value = "/selectuser", method = RequestMethod.POST)
    public Map<String, Object> selectuser(@RequestParam("userid") String user_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Users result = usersService.queryuser(Integer.parseInt(user_id));
        map.put("users", result);
        return map;
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public Map<String, Object> updateUser(HttpServletRequest request) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        Users user = new Users();
        user.setUser_id(Integer.parseInt(request.getParameter("userid")));
        user.setUser_name(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        user.setBirthday(date);
        user.setRole_id(Integer.parseInt(request.getParameter("authority")));
        user.setStatus(Integer.parseInt(request.getParameter("status")));
        boolean result = usersService.updateUser(user);
        map.put("success",result);
        return map;
    }
}
