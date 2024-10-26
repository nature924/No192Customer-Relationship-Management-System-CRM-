package com.example.cra.util;

public class SelectUsers {
    private String username;
    private String sex;
    private String datemin;
    private String datemax;
    private int select_role;
    private int select_status;

    public SelectUsers() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDatemin() {
        return datemin;
    }

    public void setDatemin(String datemin) {
        this.datemin = datemin;
    }

    public String getDatemax() {
        return datemax;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }

    public int getSelect_role() {
        return select_role;
    }

    public void setSelect_role(int select_role) {
        this.select_role = select_role;
    }

    public int getSelect_status() {
        return select_status;
    }

    public void setSelect_status(int select_status) {
        this.select_status = select_status;
    }
}
