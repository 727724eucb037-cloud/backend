package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.service.TaskAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {
    @Autowired
    TaskAssignmentService taskAssignmentService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAssignmentsByUserId(@PathVariable Long userId){
        List<TaskAssignment> tasks=taskAssignmentService.getAssignmentsByUserId(userId);
        if(tasks.isEmpty()){
            return new ResponseEntity<>("No assignments found for user id: "+userId, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
