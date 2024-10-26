package com.example.cra.service;

import java.util.List;

import com.example.cra.entity.Bookinfo;

public interface BookinfoService {
    public List<Bookinfo> getAllBookinfo();

    public Bookinfo getABookinfo(int book_id);

    public boolean addBookinfo(Bookinfo bookinfo);

    public boolean editBookinfo(Bookinfo bookinfo);

    public boolean delBookinfo(int book_id);

    public List<Bookinfo> getBookinfoByCustName(String cust_name);
}
