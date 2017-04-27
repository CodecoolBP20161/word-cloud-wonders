package com.wordcloudwonders.controller;


import com.wordcloudwonders.model.MyUser;
import com.wordcloudwonders.security.MyUserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private MyUserService myUserService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody String data) throws JSONException {
        MyUser newUser = new MyUser();
        JSONObject json = new JSONObject(data);
        newUser.setUsername(json.getString("username"));
        newUser.setPassword(json.getString("password"));
        myUserService.save(newUser);
        return "index";
    }

}
