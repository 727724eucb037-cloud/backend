package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.TaskAssignment;

public interface TaskAssignmentService {
    public List<TaskAssignment> getAssignmentsByUserId(Long id);
}
