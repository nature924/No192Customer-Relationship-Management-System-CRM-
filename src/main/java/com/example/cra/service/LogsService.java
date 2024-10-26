package com.example.cra.service;

import java.util.List;

import com.example.cra.entity.Logs;

public interface LogsService {
    public List<Logs> getAllLogs();

    public Logs getALog(int log_id);

    public List<Logs> getLogByCustName(String cust_name);

    public boolean addLog(Logs logs);

    public boolean editLog(Logs logs);

    public boolean delLog(int log_id);

    public List<String> getCustName();
}
