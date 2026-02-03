package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.addTask(task);
        if(savedTask!=null) {
            return new ResponseEntity<>(savedTask, HttpStatus.OK);            
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            

        }
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks=taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if(task==null){
            return new ResponseEntity<>("Task not found with id "+id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Task updatedTask = taskService.updateTaskStatus(id, status);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
    }
    @GetMapping("/status")
    public ResponseEntity<?> getTasksByStatusWithoutParam(){
        return new ResponseEntity<>("No tasks found with status: UNKNOWN_STATUS", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping
    public int hello(){
        return 1;
    }
}
