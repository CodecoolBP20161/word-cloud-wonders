package com.wordcloudwonders.security;

import com.wordcloudwonders.model.User;
import com.wordcloudwonders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(String userName) {
        return userRepository.findByUsername(userName);
    }
}
