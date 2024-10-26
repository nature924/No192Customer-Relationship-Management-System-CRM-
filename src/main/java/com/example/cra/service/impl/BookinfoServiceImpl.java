package com.example.cra.service.impl;

import java.util.List;

import com.example.cra.entity.Bookinfo;
import com.example.cra.mapper.BookinfoMapper;
import com.example.cra.service.BookinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookinfoServiceImpl implements BookinfoService {
    @Autowired
    private BookinfoMapper bookinfoMapper;

    @Override
    public List<Bookinfo> getAllBookinfo() {
        List<Bookinfo> list = null;
        list = bookinfoMapper.getAllBookinfo();
        return list;
    }

    @Override
    public Bookinfo getABookinfo(int book_id) {
        Bookinfo bookinfo = null;
        bookinfo = bookinfoMapper.getABookinfo(book_id);
        if (bookinfo == null)
            System.out.println("无法查询到相关内容");
        else
            System.out.println("查询成功");
        return bookinfo;
    }

    @Override
    public boolean addBookinfo(Bookinfo bookinfo) {
        boolean isSuccess = false;
        isSuccess = bookinfoMapper.addBookinfo(bookinfo);
        if (isSuccess)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");
        return isSuccess;
    }

    @Override
    public boolean editBookinfo(Bookinfo bookinfo) {
        boolean isSuccess = false;
        isSuccess = bookinfoMapper.editBookinfo(bookinfo);
        if (isSuccess)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
        return isSuccess;
    }

    @Override
    public boolean delBookinfo(int book_id) {
        boolean isSuccess = false;
        isSuccess = bookinfoMapper.delBookinfo(book_id);
        if (isSuccess)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
        return isSuccess;
    }

    @Override
    public List<Bookinfo> getBookinfoByCustName(String cust_name) {
        List<Bookinfo> list = null;
        list = bookinfoMapper.getBookinfoByCustName(cust_name);
        return list;
    }

}
