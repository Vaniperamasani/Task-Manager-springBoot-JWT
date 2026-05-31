package com.taskManagement.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManagement.Service.TaskService;
import com.taskManagement.entity.Task;

@RestController
@RequestMapping("/Task")
public class TaskController {
	
	@Autowired
	public TaskService service;
	
	
	
	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return service.add(task);
	}
	
	@GetMapping
	public List<Task> getAllTasks() {
		return service.getAll();
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable int id, @RequestBody Task task) {
		
		return service.update(id, task);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable int id) {
		 service.delete(id);
		return "task deleted Successfully!";
	}
	

}
