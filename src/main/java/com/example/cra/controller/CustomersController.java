package com.example.cra.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.cra.entity.Customers;
import com.example.cra.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showCustomers(HttpServletResponse response, HttpServletRequest request) {
        return new ModelAndView("customer-list");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCustomers(HttpServletResponse response, HttpServletRequest request) {
        return new ModelAndView("customer-add");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateCustomer(HttpServletResponse response, HttpServletRequest request) {
        return new ModelAndView("customer-update");
    }

    @ResponseBody
    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public Map<String, Object> getAllCustomers() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Customers> costomersList = customersService.getAllCustomers();
        map.put("Customers", costomersList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public Map<String, Object> addCustomer(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Customers customer = new Customers();
        customer.setCust_name(request.getParameter("cust_name"));
        customer.setCust_type(Integer.valueOf(request.getParameter("cust_type")));
        customer.setCust_background(Integer.valueOf(request.getParameter("cust_background")));
        customer.setListed(Integer.valueOf(request.getParameter("listed")));
        customer.setReg_capital(Integer.valueOf(request.getParameter("reg_capital")));
        if (!request.getParameter("year_sales").equals("")) {
            customer.setYear_sales(Integer.valueOf(request.getParameter("year_sales")));
        }
        if (!request.getParameter("entp_scale").equals("")) {
            customer.setEntp_scale(Integer.valueOf(request.getParameter("entp_scale")));
        }
        if (!request.getParameter("tester_no").equals("")) {
            customer.setTester_no(Integer.valueOf(request.getParameter("tester_no")));
        }
        customer.setUrl(request.getParameter("url"));
        customer.setZip_code(request.getParameter("zip_code"));
        customer.setAddress(request.getParameter("address"));
        customer.setMain_products(request.getParameter("main_products"));
        customer.setMajor_services(request.getParameter("major_services"));
        customer.setStatus(Integer.parseInt(request.getParameter("status")));
        customer.setUser_id(1);//待修改
        Date date = new Date();
        customer.setCreate_time(date);
        System.out.println(customer.toString());
        if (customersService.insertCustomer(customer) > 0) {
            map.put("msg", "新增成功！");
        } else {
            map.put("msg", "新增失败！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateShowCustomer", method = RequestMethod.GET)
    public Map<String, Object> updateShowCustomer(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(request.getParameter("name"));
        Customers customer = customersService.getCustomersByCust_name(request.getParameter("name"));
        map.put("Customer", customer);
        System.out.println(customer.toString());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public Map<String, Object> updateCustomer(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Customers customer = new Customers();
        customer.setCust_name(request.getParameter("cust_name"));
        customer.setCust_type(Integer.valueOf(request.getParameter("cust_type")));
        customer.setCust_background(Integer.valueOf(request.getParameter("cust_background")));
        customer.setListed(Integer.valueOf(request.getParameter("listed")));
        customer.setReg_capital(Integer.valueOf(request.getParameter("reg_capital")));
        if (!request.getParameter("year_sales").equals("")) {
            customer.setYear_sales(Integer.valueOf(request.getParameter("year_sales")));
        }
        if (!request.getParameter("entp_scale").equals("")) {
            customer.setEntp_scale(Integer.valueOf(request.getParameter("entp_scale")));
        }
        if (!request.getParameter("tester_no").equals("")) {
            customer.setTester_no(Integer.valueOf(request.getParameter("tester_no")));
        }
        customer.setUrl(request.getParameter("url"));
        customer.setZip_code(request.getParameter("zip_code"));
        customer.setAddress(request.getParameter("address"));
        customer.setMain_products(request.getParameter("main_products"));
        customer.setMajor_services(request.getParameter("major_services"));
        customer.setStatus(Integer.parseInt(request.getParameter("status")));
        customer.setUser_id(1);//待修改
        System.out.println(customer.toString());
        if (customersService.updateCustomer(customer) > 0) {
            map.put("msg", "修改成功！");
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public Map<String, Object> deleteCustomer(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (customersService.deleteCustomerByName(request.getParameter("cust_name")) > 0) {
            map.put("msg", "删除成功！");
        } else {
            map.put("msg", "删除失败！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserId", method = RequestMethod.GET)
    public Map<String, Object> updateUserId(@RequestParam("user_id") int user_id, @RequestParam("cust_name") String cust_name) {
        Map<String, Object> map = new HashMap<String, Object>();
        Customers customer = new Customers();
        customer.setCust_name(cust_name);
        customer.setUser_id(user_id);
        if (customersService.updateCustomer(customer) > 0) {
            map.put("msg", "指派成功！");
        } else {
            map.put("msg", "指派失败！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/queryCustomers", method = RequestMethod.GET)
    public Map<String, Object> queryCustomers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Customers> costomersList;
        String cust_name = "";
        Integer user_id = null, cust_background = null, listed = null, status = null, cust_type = null;
        if (!request.getParameter("ss").equals("")) {
            listed = Integer.parseInt(request.getParameter("ss"));
        }
        if (!request.getParameter("bj").equals("")) {
            cust_background = Integer.parseInt(request.getParameter("bj"));
        }
        if (!request.getParameter("zt").equals("")) {
            status = Integer.parseInt(request.getParameter("zt"));
        }
        if (!request.getParameter("leix").equals("")) {
            cust_type = Integer.parseInt(request.getParameter("leix"));
        }
        if (!request.getParameter("user_id").equals("")) {
            user_id = Integer.parseInt(request.getParameter("user_id"));
        }
        if (!request.getParameter("cname").equals("")) {
            cust_name = request.getParameter("cname");
        }
//        if(user_id.equals(null) && cust_name.equals(null) && cust_background.equals(null) && listed.equals(null)
//        		&& status.equals(null) && cust_type.equals(null)) {
//        	costomersList = customersService.getAllCustomers();
//        }else {
        costomersList = customersService.queryCustomers(cust_name, user_id, cust_background, listed, cust_type, status);
        System.out.println(costomersList.toString());
        System.out.println(cust_name);
//        }
        map.put("Customers", costomersList);
        for (Customers customers : costomersList) {
            customers.toString();
        }
        return map;
    }
}
