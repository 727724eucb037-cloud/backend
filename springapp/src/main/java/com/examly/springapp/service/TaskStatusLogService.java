package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public class TaskStatusLogService {

    @Autowired
    private TaskStatusLogRepository repository;

    public TaskStatusLog addLog(TaskStatusLog log) {
        return repository.save(log);
    }

    public List<TaskStatusLog> getAllLogs() {
        return repository.findAll();
    }

    public TaskStatusLog getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TaskStatusLog> getLogsByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }
}
