package com.example.basic.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.demo.model.Task;
import com.example.basic.demo.model.TaskList;
import com.example.basic.demo.model.User;
import com.example.basic.demo.repository.TaskListRepository;
import com.example.basic.demo.repository.TaskRepository;
import com.example.basic.demo.repository.UserRepository;

@Service
public class TaskService {

    @Autowired private TaskRepository taskRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private TaskListRepository taskListRepository;

    public Task createTask(Task task) {
        // Ensure assignedTo is fully loaded
        if (task.getAssignedTo() != null && task.getAssignedTo().getId() != null) {
            User user = userRepository.findById(task.getAssignedTo().getId())
                .orElseThrow(() -> new RuntimeException("Assigned user not found"));
            task.setAssignedTo(user);
        }

        // Ensure taskList is fully loaded
        if (task.getTaskList() != null && task.getTaskList().getId() != null) {
            TaskList list = taskListRepository.findById(task.getTaskList().getId())
                .orElseThrow(() -> new RuntimeException("Task list not found"));
            task.setTaskList(list);
        }

        return taskRepository.save(task);
    }

    public List<Task> getTasksByAssignee(Long userId) {
        return taskRepository.findByAssignedToId(userId);
    }
}
