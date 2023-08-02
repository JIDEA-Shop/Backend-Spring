package com.cogent.userservice.dao;

import com.cogent.userservice.entity.Role;
import com.cogent.userservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user_role",path = "user_role")
public interface RoleDao extends JpaRepository<UserRole,String> {
}
