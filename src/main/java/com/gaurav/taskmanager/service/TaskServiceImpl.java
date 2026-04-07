package com.gaurav.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gaurav.taskmanager.entity.Status;
import com.gaurav.taskmanager.entity.Task;
import com.gaurav.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {

        // Set default only if not provided
        if (task.getStatus() == null) {
            task.setStatus(Status.PENDING);
        }

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());     // ENUM
        task.setPriority(updatedTask.getPriority()); // ENUM

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
