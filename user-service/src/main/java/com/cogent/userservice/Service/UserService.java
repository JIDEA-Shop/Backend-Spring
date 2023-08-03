package com.cogent.userservice.Service;

import com.cogent.userservice.dao.UserDao;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    public List<User> getAllUser();
}
