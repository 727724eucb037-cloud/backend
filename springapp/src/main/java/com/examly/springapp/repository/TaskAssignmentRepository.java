package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;

@Repository
public class TaskAssignmentRepository {
    @Id
    private int id;
}
