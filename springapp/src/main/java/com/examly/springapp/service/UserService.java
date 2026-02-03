package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.User;

public interface UserService {
    public Page<User> getUsersWithPagination(int pageNumber, int pageSize);
    public List<User> getAllUsers();
    public User addUsers(User user);
    public Optional<User> getUserById(long id);
    public List<User> getUserByRole(String role);
    public User updateUser(Long id, User obj);
  
}
