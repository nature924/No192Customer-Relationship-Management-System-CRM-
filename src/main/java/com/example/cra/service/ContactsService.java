package com.example.cra.service;

import com.example.cra.entity.Contacts;

import java.util.List;

public interface ContactsService {
    public String addContacts(Contacts contacts);

    public List<Contacts> contactsList();

    public String delContacts(int cont_id);

    public List<Contacts> queryContacts(String datemin, String datemax, String cust_name);

    public Contacts selectContacts(int cont_id);

    public boolean updateContacts(Contacts contacts);
}
