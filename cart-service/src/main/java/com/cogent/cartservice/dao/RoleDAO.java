package com.cogent.cartservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.cartservice.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
