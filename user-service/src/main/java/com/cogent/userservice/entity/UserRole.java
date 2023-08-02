package com.cogent.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import java.util.List;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long role_id;

    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleName;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<User> user;

    @Override
    public String toString() {
        return roleName.toString();
    }
}
