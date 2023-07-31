package com.cogent.cartservice.service;

import com.cogent.cartservice.dao.RoleDAO;
import com.cogent.cartservice.dao.UserDAO;
import com.cogent.cartservice.entity.Role;
import com.cogent.cartservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    @Autowired
    RoleDAO roleDao;
    public User registerNewUser(User user){
        return userDao.save(user);
    }

    /**
     * Hard Code init user and roles
     */
    public void initRolesAndUser()
    {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDesc("Admin Role");
        roleDao.save(adminRole);

        Role commonUserRole = new Role();
        commonUserRole.setRoleDesc("Common User Role");
        commonUserRole.setRoleName("User");
        roleDao.save(commonUserRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("123456");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User commonUser = new User();
        commonUser.setUserFirstName("CCC");
        commonUser.setUserLastName("CCC");
        commonUser.setUserName("CCC1234");
        commonUser.setUserPassword("121314CCC");
        Set<Role> commonRoles = new HashSet<>();
        commonRoles.add(commonUserRole);
        commonUser.setRole(commonRoles);
        userDao.save(commonUser);
    }
}
