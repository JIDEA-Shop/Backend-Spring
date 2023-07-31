package com.cogent.userservice.Service;

import com.cogent.userservice.dao.UserDao;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUser();
}
