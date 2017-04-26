package com.wordcloudwonders.security;

import com.wordcloudwonders.model.MyUser;
import org.springframework.stereotype.Service;

@Service
public interface MyUserService {
    void save(MyUser myUser);

    MyUser find(String userName);
}
