package com.example.basic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.demo.model.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}
