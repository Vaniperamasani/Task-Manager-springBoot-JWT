package com.taskManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManagement.Repository.TaskRepository;
import com.taskManagement.entity.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repo;
	
	public Task add(Task task) {
		return  repo.save(task);
	}
	
	public List<Task> getAll() {
		return repo.findAll();
	}
	
	public Task update(int id, Task task) {
		Task existing = repo.findById(id).orElse(null);
		
		if(existing != null) {
			existing.setTitle(task.getTitle());
			existing.setDescription(task.getDescription());
			return repo.save(task);
		}
		return null;
	}
	
	public void delete(int id) {
		repo.deleteById(id);
		
	}

}
