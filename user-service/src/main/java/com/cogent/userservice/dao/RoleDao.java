package com.cogent.userservice.dao;

import com.cogent.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "role",path = "role")
public interface RoleDao extends JpaRepository<Role,String> {
}
