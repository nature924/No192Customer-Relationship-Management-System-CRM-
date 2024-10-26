package com.example.cra.service.impl;

import java.util.List;

import com.example.cra.entity.Logs;
import com.example.cra.mapper.LogsMapper;
import com.example.cra.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsMapper logsMapper;

    @Override
    public List<Logs> getAllLogs() {
        List<Logs> list = null;
        list = logsMapper.getAllLogs();
        if (list != null)
            System.out.println("查询成功");
        else
            System.out.println("查询失败");
        return list;
    }

    @Override
    public Logs getALog(int log_id) {
        Logs logs = null;
        logs = logsMapper.getALog(log_id);
        if (logs != null)
            System.out.println("查询成功");
        else
            System.out.println("查询失败");
        return logs;
    }

    @Override
    public boolean addLog(Logs logs) {
        boolean isSuccess = false;
        isSuccess = logsMapper.addLog(logs);
        if (isSuccess)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");
        return isSuccess;
    }

    @Override
    public boolean editLog(Logs logs) {
        boolean isSuccess = false;
        isSuccess = logsMapper.editLog(logs);
        if (isSuccess)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
        return isSuccess;
    }

    @Override
    public boolean delLog(int log_id) {
        boolean isSuccess = false;
        isSuccess = logsMapper.delLog(log_id);
        if (isSuccess)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
        return isSuccess;
    }

    public List<String> getCustName() {
        List<String> list = logsMapper.getCustName();
        return list;
    }

    @Override
    public List<Logs> getLogByCustName(String cust_name) {
        List<Logs> list = null;
        list = logsMapper.getLogByCustName(cust_name);
        return list;
    }

    ;
}
