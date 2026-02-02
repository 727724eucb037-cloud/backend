package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CommentController {
    @GetMapping
    public ResponseEntity<?> hello(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
