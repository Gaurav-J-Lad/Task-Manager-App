package com.gaurav.taskmanager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Task Manager API!\n\n" +
               "Available endpoints:\n" +
               "GET /tasks → Get all tasks\n" +
               "GET /tasks/{id} → Get task by ID\n" +
               "POST /tasks → Create a new task (JSON body)\n" +
               "PUT /tasks/{id} → Update a task (JSON body)\n" +
               "DELETE /tasks/{id} → Delete a task";
    }
}