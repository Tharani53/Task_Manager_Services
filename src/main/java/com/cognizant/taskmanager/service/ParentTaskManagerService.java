package com.cognizant.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.taskmanager.dao.ParentTask;
import com.cognizant.taskmanager.repository.ParentTaskManagerRepository;

@Service
public class ParentTaskManagerService {
	
	@Autowired
	private ParentTaskManagerRepository repo;
	
//	@Autowired
//	private ParentTask ptask;

	public Iterable<ParentTask> fetchUsers() {
		return repo.findAll();
	}
	
	

	public ParentTask addNewTask(String task) {
		ParentTask ptask = new ParentTask();
		ptask.setParentTask(task);
		return repo.save(ptask);
	}
	

}
