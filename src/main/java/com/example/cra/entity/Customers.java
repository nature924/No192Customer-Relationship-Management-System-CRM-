package com.example.cra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Customers {
    private int customer_id;
    private String cust_name;
    private int cust_type;
    private int cust_background;
    private int listed;
    private int reg_capital;
    private int year_sales;
    private int entp_scale;
    private int tester_no;
    private String url;
    private String zip_code;
    private String address;
    private String major_services;
    private String main_products;
    private int status;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date create_time;
    private int user_id;
    private String user_name;

    public Customers() {

    }


    public int getCustomer_id() {
        return customer_id;
    }


    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    public String getCust_name() {
        return cust_name;
    }


    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }


    public int getCust_type() {
        return cust_type;
    }


    public void setCust_type(int cust_type) {
        this.cust_type = cust_type;
    }


    public int getCust_background() {
        return cust_background;
    }


    public void setCust_background(int cust_background) {
        this.cust_background = cust_background;
    }


    public int getListed() {
        return listed;
    }


    public void setListed(int listed) {
        this.listed = listed;
    }


    public int getReg_capital() {
        return reg_capital;
    }


    public void setReg_capital(int reg_capital) {
        this.reg_capital = reg_capital;
    }


    public int getYear_sales() {
        return year_sales;
    }


    public void setYear_sales(int year_sales) {
        this.year_sales = year_sales;
    }


    public int getEntp_scale() {
        return entp_scale;
    }


    public void setEntp_scale(int entp_scale) {
        this.entp_scale = entp_scale;
    }


    public int getTester_no() {
        return tester_no;
    }


    public void setTester_no(int tester_no) {
        this.tester_no = tester_no;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getZip_code() {
        return zip_code;
    }


    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getMajor_services() {
        return major_services;
    }


    public void setMajor_services(String major_services) {
        this.major_services = major_services;
    }


    public String getMain_products() {
        return main_products;
    }


    public void setMain_products(String main_products) {
        this.main_products = main_products;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public Date getCreate_time() {
        return create_time;
    }


    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_type=" + cust_type +
                ", cust_background=" + cust_background +
                ", listed=" + listed +
                ", reg_capital=" + reg_capital +
                ", year_sales=" + year_sales +
                ", entp_scale=" + entp_scale +
                ", tester_no=" + tester_no +
                ", url='" + url + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", address='" + address + '\'' +
                ", major_services='" + major_services + '\'' +
                ", main_products='" + main_products + '\'' +
                ", status=" + status +
                ", create_time=" + create_time +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
