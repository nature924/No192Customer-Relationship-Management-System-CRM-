package com.example.cra.mapper;

import java.util.List;

import com.example.cra.entity.Bookinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookinfoMapper {
    public List<Bookinfo> getAllBookinfo();//查询全部数据

    public Bookinfo getABookinfo(int book_id);//id查询

    public List<Bookinfo> getBookinfoByCustName(String cust_name);//通过客户名称查询

    public boolean addBookinfo(Bookinfo bookinfo);//添加

    public boolean editBookinfo(Bookinfo bookinfo);//修改

    public boolean delBookinfo(int book_id);//删除
}
