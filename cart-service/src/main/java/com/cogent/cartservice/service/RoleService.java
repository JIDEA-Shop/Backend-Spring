package com.cogent.cartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.cartservice.dao.RoleDAO;
import com.cogent.cartservice.entity.Role;

@Service
public class RoleService {
	@Autowired
	RoleDAO roledao;
	public Role createNewRole(Role role) {
		return roledao.save(role);
	}
}
