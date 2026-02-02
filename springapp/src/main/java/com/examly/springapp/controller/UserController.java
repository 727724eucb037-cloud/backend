package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users/page/{pageNumber}/{pageSize}
    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<User>> getUsers(
            @PathVariable int pageNumber,
            @PathVariable int pageSize) {

        Page<User> users = userService.getUsersWithPagination(pageNumber, pageSize);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUsers(@RequestBody User user) {
        User users=userService.addUsers(user);
        return new ResponseEntity<>(users, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> user=userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User obj){
        User user=userService.updateUser(id, obj);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
