package com.wordcloudwonders.config;

import com.wordcloudwonders.model.MyUser;
import com.wordcloudwonders.security.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataLoader {

    @Autowired
    private MyUserService myUserService;

    @PostConstruct
    public void populateUsers() {
        MyUser myUser = new MyUser();
        myUser.setUsername("testUser");
        myUser.setPassword("1234");
        myUserService.save(myUser);
    }
}
