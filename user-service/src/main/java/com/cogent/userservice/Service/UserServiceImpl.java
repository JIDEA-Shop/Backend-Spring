package com.cogent.userservice.Service;

import com.cogent.userservice.dao.UserDao;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService extends UserDetailService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }
}
