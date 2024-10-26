package com.example.cra.mapper;

import java.util.List;

import com.example.cra.entity.Customers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CustomersMapper {

    public List<Customers> getAllCustomers();

    public Customers getCustomerById(int id);

    public Customers getCustomersByStatus(String status);

    public Customers getCustomersByCust_name(String Cust_name);

    public Customers getCustomersByUser_id(int user_id);

    public List<Customers> queryCustomers(@Param("cust_name") String cust_name,
                                          @Param("user_id") Integer user_id,
                                          @Param("cust_background") Integer cust_background,
                                          @Param("listed") Integer listed,
                                          @Param("cust_type") Integer cust_type,
                                          @Param("status") Integer status);

    public int deleteCustomerById(int id);

    public int deleteCustomerByName(String cust_name);

    public int updateCustomer(Customers customer);

    public int insertCustomer(Customers customer);
}
