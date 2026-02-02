package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TaskAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,unique=true)
    private LocalDateTime assignedAt;
    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    
    public TaskAssignment() {

    }
    


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }



    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }



    public Task getTask() {
        return task;
    }



    public void setTask(Task task) {
        this.task = task;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    public TaskAssignment(Long id, LocalDateTime assignedAt, Task task, User user) {
        this.id = id;
        this.assignedAt = assignedAt;
        this.task = task;
        this.user = user;
    }
}