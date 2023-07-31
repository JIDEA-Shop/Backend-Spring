package com.cogent.userservice.dao;

import com.cogent.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserDao extends JpaRepository<User,String> {
}
