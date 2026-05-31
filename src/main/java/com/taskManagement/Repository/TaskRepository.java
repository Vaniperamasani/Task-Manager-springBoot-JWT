package com.taskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskManagement.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
