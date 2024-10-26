package com.example.cra.service;

import com.example.cra.entity.Customers;

import java.util.List;

public interface CustomersService {
    public List<Customers> getAllCustomers();

    public Customers getCustomerById(int id);

    public Customers getCustomersByStatus(String status);

    public Customers getCustomersByCust_name(String Cust_name);

    public int deleteCustomerByName(String cust_name);

    public int updateCustomer(Customers customer);

    public int insertCustomer(Customers customer);

    public List<Customers> queryCustomers(String cust_name, Integer user_id, Integer cust_background, Integer listed,
                                          Integer cust_type, Integer status);
}
