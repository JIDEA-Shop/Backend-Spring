package com.cogent.userservice.Service;

import com.cogent.userservice.dao.UserDao;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userDao.findById(username).get();
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(x-> x.toString()).collect(Collectors.joining()))
                .build();
        System.out.println(userDetails);
        return userDetails;
    }
}
