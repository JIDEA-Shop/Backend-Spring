package com.cogent.userservice.restcontroller;

import com.cogent.userservice.dao.UserDao;
import com.cogent.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    UserDao userDao;
    @GetMapping
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("username") String id)
    {
        return userDao.findById(id).get();
    }
    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody User user)
    {
        if(userDao.existsById(user.getUsername())){
            return ResponseEntity.ok("User Already Exist");
        }
        userDao.save(user);
        return ResponseEntity.ok("User Added:" + user.toString());
    }
    @DeleteMapping
    public void deleteUser(@RequestParam(name = "username") String id)
    {
        userDao.deleteById(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> putUser(@PathVariable String id, @RequestBody User user)
    {
        User currentUser = userDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Does not Exist with ID :" + id));
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        userDao.save(currentUser);
        return ResponseEntity.ok(currentUser);

    }
}