package com.example.cra.mapper;

import java.util.List;

import com.example.cra.entity.Logs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogsMapper {
    public List<Logs> getAllLogs();

    public Logs getALog(int log_id);

    public List<Logs> getLogByCustName(String cust_name);

    public boolean addLog(Logs logs);

    public boolean editLog(Logs logs);

    public boolean delLog(int log_id);

    public List<String> getCustName();
}
