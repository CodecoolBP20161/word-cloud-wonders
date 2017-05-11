package com.wordcloudwonders.controller;

import com.wordcloudwonders.model.MyUser;
import com.wordcloudwonders.repository.MyUserRepository;
import com.wordcloudwonders.security.MyUserServiceImpl;
import com.wordcloudwonders.security.Role;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertEquals;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private MyUserServiceImpl myUserService;

    @Test
    public void shouldReturnLoginRegistrationForm() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Login")))
                .andExpect(content().string(containsString("Register")));
    }

    @Test
    public void shouldSaveNewUser() throws Exception {
        String userDetails = "{\"username\":\"testuser\",\"password\":\"testpw\"}";
        this.mockMvc.perform(post("/registration").content(userDetails))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Login")));
        MyUser savedUser = myUserRepository.findByUsername("testuser");
        assertEquals("testuser", savedUser.getUsername());
        assertEquals(Role.USER, savedUser.getRole());
    }
}