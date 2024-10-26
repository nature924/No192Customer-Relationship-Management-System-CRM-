package com.example.cra.mapper;

import com.example.cra.entity.Contacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactsMapper {
    //添加
    public int addContacts(Contacts contacts);

    public List<Contacts> contactsList();

    public int delContacts(int cont_id);

    public List<Contacts> queryContacts(@Param("datemin") String datemin, @Param("datemax") String datemax, @Param("cust_name") String cust_name);

    public Contacts selectContacts(int cont_id);

    public int updateContacts(Contacts contacts);
}
