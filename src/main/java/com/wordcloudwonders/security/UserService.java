package com.wordcloudwonders.security;

import com.wordcloudwonders.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);

    User find(String userName);
}
