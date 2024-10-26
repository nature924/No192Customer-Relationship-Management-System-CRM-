package com.example.cra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/front")
public class FrontendController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/user-add", method = RequestMethod.GET)
    public String userAdd() {
        return "user-add";
    }

    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public String userList() {
        return "user-list";
    }

    @RequestMapping(value = "/user-update", method = RequestMethod.GET)
    public String userUpdate() {
        return "user-update";
    }

    @RequestMapping(value = "/contact-add", method = RequestMethod.GET)
    public String contactAdd() {
        return "contact-add";
    }

    @RequestMapping(value = "/contact-list", method = RequestMethod.GET)
    public String contactList() {
        return "contact-list";
    }

    @RequestMapping(value = "/contact-update", method = RequestMethod.GET)
    public String contactUpdate() {
        return "contact-update";
    }

    @RequestMapping(value = "/customer-add", method = RequestMethod.GET)
    public String customerAdd() {
        return "customer-add";
    }

    @RequestMapping(value = "/customer-list", method = RequestMethod.GET)
    public String customerList() {
        return "customer-list";
    }

    @RequestMapping(value = "/bookinfo-add", method = RequestMethod.GET)
    public String bookinfoAdd() {
        return "bookinfo-add";
    }

    @RequestMapping(value = "/bookinfo-list", method = RequestMethod.GET)
    public String bookinfoList() {
        return "bookinfo-list";
    }

    @RequestMapping(value = "/bookinfo-update", method = RequestMethod.GET)
    public String bookinfoUpdate() {
        return "bookinfo-update";
    }

    @RequestMapping(value = "/log-add", method = RequestMethod.GET)
    public String logAdd() {
        return "log-add";
    }

    @RequestMapping(value = "/log-list", method = RequestMethod.GET)
    public String logList() {
        return "log-list";
    }

    @RequestMapping(value = "/log-update", method = RequestMethod.GET)
    public String logUpdate() {
        return "log-update";
    }

    @RequestMapping(value = "/document-add", method = RequestMethod.GET)
    public String documentAdd() {
        return "document-add";
    }

    @RequestMapping(value = "/document-list", method = RequestMethod.GET)
    public String documentList() {
        return "document-list";
    }

}
