package com.cogent.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.cartservice.entity.Role;
import com.cogent.cartservice.service.RoleService;

@RestController
@RequestMapping("/role/api")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	/**
	 * URL for ADDING A ROLE.
	 */
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role)
	{
		return roleService.createNewRole(role);
	}
}	
