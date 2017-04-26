package com.wordcloudwonders.controller;


import com.wordcloudwonders.security.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private MyUserService myUserService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(String data) {
        System.out.println("data = " + data);
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
