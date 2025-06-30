package com.example.basic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.demo.model.TaskList;
import com.example.basic.demo.service.TaskListService;

@RestController
@RequestMapping("/api/tasklists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @PostMapping("make")
    public TaskList createTaskList(@RequestBody TaskList taskList) {
        return taskListService.createTaskList(taskList);
    }

    @GetMapping("all")
    public List<TaskList> getAllTaskLists() {
        return taskListService.getAllTaskLists();
    }
}
