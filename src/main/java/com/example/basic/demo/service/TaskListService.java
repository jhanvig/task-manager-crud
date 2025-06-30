package com.example.basic.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.demo.model.Board;
import com.example.basic.demo.model.TaskList;
import com.example.basic.demo.repository.BoardRepository;
import com.example.basic.demo.repository.TaskListRepository;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private BoardRepository boardRepository;

    public TaskList createTaskList(TaskList taskList) {
        if (taskList.getBoard() != null && taskList.getBoard().getId() != null) {
            Board board = boardRepository.findById(taskList.getBoard().getId())
                    .orElseThrow(() -> new RuntimeException("Board not found"));
            taskList.setBoard(board);
        } else {
            throw new RuntimeException("Board ID must be provided");
        }
        return taskListRepository.save(taskList);
    }

    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }
}
