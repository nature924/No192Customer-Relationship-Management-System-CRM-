package com.example.cra.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cra.entity.Bookinfo;
import com.example.cra.service.BookinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/bookinfo")
public class BookinfoController {
    @Autowired
    private BookinfoService bookinfoService;

    @RequestMapping("/getbookinfos")
    @ResponseBody
    public String getAllBookinfo() {
        List<Bookinfo> list = bookinfoService.getAllBookinfo();
        String JsonString = JSON.toJSONString(list);
        System.out.println(JsonString);
        return JsonString;
    }

    @RequestMapping("/findbookinfo")
    @ResponseBody
    public String getABookinfo(int book_id) {
        Bookinfo bookinfo = null;
        bookinfo = bookinfoService.getABookinfo(book_id);
        String json = JSON.toJSONString(bookinfo);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/addbookinfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addBookinfo(@RequestParam("cust_name") String cust_name,
                                           @RequestParam("title") String title,
                                           @RequestParam("desc") String desc,
                                           @RequestParam("book_time") Date book_time,
                                           @RequestParam("create_time") Date create_time) {
        Map<String, Object> map = new HashMap<>();
        Bookinfo bookinfo = new Bookinfo();
        bookinfo.setCust_name(cust_name);
        bookinfo.setTitle(title);
        bookinfo.setDesc(desc);
        bookinfo.setBook_time(book_time);
        bookinfo.setCreate_time(create_time);
        System.out.println(JSON.toJSONString(bookinfo));
        boolean isSuccess = bookinfoService.addBookinfo(bookinfo);
        map.put("isSuccess", isSuccess);
        return map;
    }

    @RequestMapping("/editbookinfo")
    @ResponseBody
    public Map<String, Object> editBookinfo(int book_id, String cust_name, String title, String desc, Date book_time, Date create_time) {
        Map<String, Object> map = new HashMap<>();
        Bookinfo bookinfo = bookinfoService.getABookinfo(book_id);
        System.out.println(JSON.toJSONString(bookinfo));
        bookinfo.setBook_id(book_id);
        bookinfo.setCust_name(cust_name);
        bookinfo.setTitle(title);
        bookinfo.setDesc(desc);
        bookinfo.setBook_time(book_time);
        bookinfo.setCreate_time(create_time);
        boolean isSuccess = bookinfoService.editBookinfo(bookinfo);
        map.put("isSuccess", isSuccess);
        return map;
    }

    @RequestMapping("/delbookinfo")
    public String delBookinfo(int book_id) {
        bookinfoService.delBookinfo(book_id);
        return "bookinfo-list";
    }

    @RequestMapping("/getbookinfobycustname")
    @ResponseBody
    public String getBookinfoByCustName(String cust_name) {
        List<Bookinfo> list = bookinfoService.getBookinfoByCustName(cust_name);
        String json = JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }

}
