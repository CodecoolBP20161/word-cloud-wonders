package com.wordcloudwonders.config;

import com.wordcloudwonders.model.User;
import com.wordcloudwonders.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataLoader {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void populateUsers() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("1234");
        userService.save(user);
    }
}
