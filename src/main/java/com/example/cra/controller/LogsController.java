package com.example.cra.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cra.entity.Logs;
import com.example.cra.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    private LogsService logsService;

    @RequestMapping("/getlogs")
    @ResponseBody
    public String getAllBookinfo() {
        List<Logs> list = logsService.getAllLogs();
        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }

    @RequestMapping("/findlog")
    @ResponseBody
    public String getALog(int log_id) {
        Logs logs = null;
        logs = logsService.getALog(log_id);
        String json = JSON.toJSONString(logs);
        System.out.println(json);
        return json;
    }

    @RequestMapping("/addlog")
    @ResponseBody
    public Map<String, Object> addLog(String title, String cust_name, String desc, Date create_time) {
        Map<String, Object> map = new HashMap<>();
        Logs logs = new Logs();
        logs.setTitle(title);
        logs.setDesc(desc);
        logs.setCust_name(cust_name);
        logs.setCreate_time(create_time);
        System.out.println(JSON.toJSONString(logs));
        boolean isSuccess = logsService.addLog(logs);
        map.put("isSuccess", isSuccess);
        return map;
    }

    @RequestMapping("/editlog")
    @ResponseBody
    public Map<String, Object> editLog(int log_id, String title, String desc, String cust_name, Date create_time) {
        Map<String, Object> map = new HashMap<>();
        Logs logs = logsService.getALog(log_id);
        System.out.println(JSON.toJSONString(logs));
        logs.setTitle(title);
        logs.setDesc(desc);
        logs.setCust_name(cust_name);
        logs.setCreate_time(create_time);
        boolean isSuccess = logsService.editLog(logs);
        map.put("isSuccess", isSuccess);
        return map;
    }

    @RequestMapping("/dellog")
    public String delLog(int log_id) {
        logsService.delLog(log_id);
        return "log-list";
    }

    @RequestMapping("/getcustname")
    @ResponseBody
    public String getCustName() {
        List<String> list = logsService.getCustName();
        String json = JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }

    @RequestMapping("/getlogbycustname")
    @ResponseBody
    public String getLogByCustName(String cust_name) {
        List<Logs> list = logsService.getLogByCustName(cust_name);
        String json = JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }

}
