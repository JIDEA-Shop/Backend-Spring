package com.cogent.cartservice.dao;

import com.cogent.cartservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {
}
