package com.example.cra.service.impl;

import java.util.List;

import com.example.cra.entity.Customers;
import com.example.cra.mapper.CustomersMapper;
import com.example.cra.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersMapper customersMapper;

    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customersList = customersMapper.getAllCustomers();
        return customersList;
    }

    @Override
    public Customers getCustomerById(int id) {
        return customersMapper.getCustomerById(id);
    }

    @Override
    public Customers getCustomersByStatus(String status) {
        return null;
    }

    @Override
    public Customers getCustomersByCust_name(String Cust_name) {
        Customers customers = customersMapper.getCustomersByCust_name(Cust_name);
        return customers;
    }

    @Override
    public int deleteCustomerByName(String cust_name) {
        return customersMapper.deleteCustomerByName(cust_name);
    }

    @Override
    public int updateCustomer(Customers customer) {
        return customersMapper.updateCustomer(customer);
    }

    @Override
    public int insertCustomer(Customers customer) {
        return customersMapper.insertCustomer(customer);
    }

    @Override
    public List<Customers> queryCustomers(String cust_name, Integer user_id, Integer cust_background, Integer listed,
                                          Integer cust_type, Integer status) {
        return customersMapper.queryCustomers(cust_name, user_id, cust_background, listed, cust_type, status);

    }
}
