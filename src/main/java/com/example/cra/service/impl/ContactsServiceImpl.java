package com.example.cra.service.impl;

import com.example.cra.entity.Contacts;
import com.example.cra.mapper.ContactsMapper;
import com.example.cra.mapper.CustomersMapper;
import com.example.cra.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsMapper contactsMapper;

    @Autowired
    private CustomersMapper customersMapper;

    @Override
    public String addContacts(Contacts contacts) {
        int result = contactsMapper.addContacts(contacts);
        if (result > 0) {
            return "新增联络成功！";
        } else {
            return "新增联络失败！";
        }
    }

    @Override
    public List<Contacts> contactsList() {
        List<Contacts> contacts = contactsMapper.contactsList();
        return contacts;
    }

    @Override
    public String delContacts(int cont_id) {
        int result = contactsMapper.delContacts(cont_id);
        if (result > 0) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @Override
    public List<Contacts> queryContacts(String datemin, String datemax, String cust_name) {
        List<Contacts> contacts = contactsMapper.queryContacts(datemin, datemax, cust_name);
        return contacts;
    }

    @Override
    public Contacts selectContacts(int cont_id) {
        return contactsMapper.selectContacts(cont_id);
    }

    @Override
    public boolean updateContacts(Contacts contacts){
        int result = contactsMapper.updateContacts(contacts);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }
}
