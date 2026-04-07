package com.gaurav.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.taskmanager.entity.Task;
import com.gaurav.taskmanager.service.TaskService;
@RestController
@RequestMapping("/tasks") // ← all operations prefixed with /tasks
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE → return updated list
    @PostMapping
    public List<Task> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return taskService.getAllTasks(); // return full list
    }

    // GET ALL
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // UPDATE → return updated list
    @PutMapping("/{id}")
    public List<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return taskService.getAllTasks(); // return full list
    }

    // DELETE → return updated list
    @DeleteMapping("/{id}")
    public List<Task> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return taskService.getAllTasks(); // return full list
    }
}