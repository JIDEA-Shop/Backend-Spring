package com.cogent.userservice.config;

import com.cogent.userservice.Service.UserService;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class SecurityConfig_RDS {
    @Autowired
    UserService userService;
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        List<User> userList = userService.getAllUser();
        for(User user: userList)
        {

        }
        return new InMemoryUserDetailsManager();
    }
}
