package com.example.cra.controller;

import com.example.cra.entity.Contacts;
import com.example.cra.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping(value = "/addcontacts" , method = RequestMethod.POST)
    public Map<String,Object> addContacts(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String cust_id = request.getParameter("cust_id");
        String cont_name= request.getParameter("cont_name");
        String cont_dept= request.getParameter("cont_dept");
        String cont_position= request.getParameter("cont_position");
        String cont_telephone= request.getParameter("cont_telephone");
        String cont_mobile= request.getParameter("cont_mobile");
        String cont_email= request.getParameter("cont_email");
        String cont_qq= request.getParameter("cont_qq");
        String  tech_degree= request.getParameter("tech_degree");
        String  more_info= request.getParameter("more_info");
        Contacts contacts = new Contacts();
        contacts.setCust_id(Integer.parseInt(cust_id));
        contacts.setCont_name(cont_name);
        contacts.setCont_dept(cont_dept);
        contacts.setCont_position(cont_position);
        contacts.setCont_telephone(cont_telephone);
        contacts.setCont_mobile(cont_mobile);
        contacts.setCont_email(cont_email);
        contacts.setCont_qq(cont_qq);
        contacts.setTech_degree(tech_degree);
        contacts.setMore_info(more_info);
        contacts.setCreate_time(new Date());
        String result = contactsService.addContacts(contacts);
        map.put("msg",result);
        return  map;
    }

    @RequestMapping(value = "/contactsList" , method = RequestMethod.GET)
    public Map<String,Object> contactsList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contacts> contacts = contactsService.contactsList();
        map.put("contacts",contacts);
        return map;
    }
    @RequestMapping(value = "/delcontacts" , method = RequestMethod.GET)
    public Map<String,Object> delContacts(@RequestParam("cont_id") String cont_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String result = contactsService.delContacts(Integer.parseInt(cont_id));
        map.put("msg",result);
        return map;
    }

    @RequestMapping(value = "/querycontacts" , method = RequestMethod.POST)
    public Map<String,Object> queryContacts(@RequestParam("datemin") String datemin,
                                            @RequestParam("datemax") String datemax,
                                            @RequestParam("cust_name") String cust_name) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contacts> contacts = contactsService.queryContacts(datemin,datemax,cust_name);
        map.put("contacts",contacts);
        return map;
    }
    @RequestMapping(value = "/selectcontacts" , method = RequestMethod.POST)
    public Map<String,Object> selectContacts(@RequestParam("cont_id") String cont_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Contacts contact = contactsService.selectContacts(Integer.parseInt(cont_id));
        map.put("contact",contact);
        return map;
    }
    @RequestMapping(value = "/updatecontacts" , method = RequestMethod.POST)
    public Map<String,Object> updateContacts(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Contacts contacts = new Contacts();
        contacts.setCont_id(Integer.parseInt(request.getParameter("cont_id")));
        contacts.setCust_id(Integer.parseInt(request.getParameter("cust_id")));
        contacts.setCont_name(request.getParameter("cont_name"));
        contacts.setCont_dept(request.getParameter("cont_dept"));
        contacts.setCont_position(request.getParameter("cont_position"));
        contacts.setCont_telephone(request.getParameter("cont_telephone"));
        contacts.setCont_mobile(request.getParameter("cont_mobile"));
        contacts.setCont_email(request.getParameter("cont_email"));
        contacts.setCont_qq(request.getParameter("cont_qq"));
        contacts.setTech_degree(request.getParameter("tech_degree"));
        contacts.setMore_info(request.getParameter("more_info"));
        boolean result = contactsService.updateContacts(contacts);
        map.put("success",result);
        return map;
    }
}
