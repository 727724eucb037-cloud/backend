package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getUsersWithPagination(int pageNumber, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUsers(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
        
    }

    public User updateUser(Long id, User obj) {
    User user = userRepository.findById(id).orElse(null);
    if (user != null) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setRole(obj.getRole());
        return userRepository.save(user);
    }
    return null;
}


  
}
