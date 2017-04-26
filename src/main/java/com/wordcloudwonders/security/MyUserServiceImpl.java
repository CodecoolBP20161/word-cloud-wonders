package com.wordcloudwonders.security;

import com.wordcloudwonders.model.MyUser;
import com.wordcloudwonders.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(MyUser myUser) {
        myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
        myUser.setRole(Role.USER);
        myUserRepository.save(myUser);
    }

    @Override
    public MyUser find(String userName) {
        return myUserRepository.findByUsername(userName);
    }
}
