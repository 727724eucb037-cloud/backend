package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.TaskStatusLog;

public interface TaskStatusLogService {
    public TaskStatusLog addLog(TaskStatusLog log);
    public List<TaskStatusLog> getAllLogs();
    public TaskStatusLog getLogById(Long id);   
    public List<TaskStatusLog> getLogsByTask(Long taskId); 
    public List<TaskStatusLog> getLogsByOldStatus(String oldStatus);
}
