package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Task;

public interface TaskService {
    public Task addTask(Task task);
    public List<Task> getAllTasks();
    public Task getTaskById(Long id);
    public Task updateTaskStatus(Long id, String status);
    public List<Task> getTasksByUser(Long userId);
    public List<Task> getTasksByStatus(String status);
    
    
}
