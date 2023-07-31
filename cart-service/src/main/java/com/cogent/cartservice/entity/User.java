package com.cogent.cartservice.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class User {
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;

    private String userPassword;
    @ManyToMany(fetch  = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
        joinColumns = {
                @JoinColumn(name = "user_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "role_id")
        }
    )
    private Set<Role> Role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<com.cogent.cartservice.entity.Role> getRole() {
        return Role;
    }

    public void setRole(Set<com.cogent.cartservice.entity.Role> role) {
        Role = role;
    }
}
