package com.example.cra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Contacts {
    private  int cont_id;
    private int cust_id;
    private String cont_name;
    private String cont_dept;
    private String cont_position;
    private String cont_telephone;
    private String cont_mobile;
    private String cont_email;
    private String cont_qq;
    private String tech_degree;
    private String more_info;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date create_time;
    private Customers customers;

    public Contacts() {
    }

    public int getCont_id() {
        return cont_id;
    }

    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getCont_dept() {
        return cont_dept;
    }

    public void setCont_dept(String cont_dept) {
        this.cont_dept = cont_dept;
    }

    public String getCont_position() {
        return cont_position;
    }

    public void setCont_position(String cont_position) {
        this.cont_position = cont_position;
    }

    public String getCont_telephone() {
        return cont_telephone;
    }

    public void setCont_telephone(String cont_telephone) {
        this.cont_telephone = cont_telephone;
    }

    public String getCont_mobile() {
        return cont_mobile;
    }

    public void setCont_mobile(String cont_mobile) {
        this.cont_mobile = cont_mobile;
    }

    public String getCont_email() {
        return cont_email;
    }

    public void setCont_email(String cont_email) {
        this.cont_email = cont_email;
    }

    public String getCont_qq() {
        return cont_qq;
    }

    public void setCont_qq(String cont_qq) {
        this.cont_qq = cont_qq;
    }

    public String getTech_degree() {
        return tech_degree;
    }

    public void setTech_degree(String tech_degree) {
        this.tech_degree = tech_degree;
    }

    public String getMore_info() {
        return more_info;
    }

    public void setMore_info(String more_info) {
        this.more_info = more_info;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "cont_id=" + cont_id +
                ", cust_id=" + cust_id +
                ", cont_name='" + cont_name + '\'' +
                ", cont_dept='" + cont_dept + '\'' +
                ", cont_position='" + cont_position + '\'' +
                ", cont_telephone='" + cont_telephone + '\'' +
                ", cont_mobile='" + cont_mobile + '\'' +
                ", cont_email='" + cont_email + '\'' +
                ", cont_qq='" + cont_qq + '\'' +
                ", tech_degree='" + tech_degree + '\'' +
                ", more_info='" + more_info + '\'' +
                ", create_time=" + create_time +
                ", customers=" + customers +
                '}';
    }
}
