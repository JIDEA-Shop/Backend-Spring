package com.cogent.cartservice.controller;

import com.cogent.cartservice.entity.User;
import com.cogent.cartservice.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    UserService userService;
    @PostConstruct
    public void initRoleAndUsers()
    {
        userService.initRolesAndUser();
    }
    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user)
    {
        return userService.registerNewUser(user);
    }
    /**
     * only accessible for Admin Role
     */
    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "URL is only for admin";
    }
    @GetMapping({"/forUser"})
    public String forUser(){
        return "URL is only for Common USER";
    }
}
