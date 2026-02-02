package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskStatusLogService;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService service;

    // POST /api/status-logs
    @PostMapping
    public ResponseEntity<TaskStatusLog> addLog(@RequestBody TaskStatusLog log) {
        TaskStatusLog savedLog = service.addLog(log);
        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    // GET /api/status-logs
    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllLogs() {
        List<TaskStatusLog> logs = service.getAllLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // GET /api/status-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getLogById(@PathVariable Long id) {
        TaskStatusLog log = service.getLogById(id);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    // GET /api/status-logs/task/{taskId}
    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable Long taskId) {
        List<TaskStatusLog> logs = service.getLogsByTask(taskId);
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}
