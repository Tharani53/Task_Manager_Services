package com.cognizant.taskmanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cognizant.taskmanager.dao.Task;
import com.cognizant.taskmanager.model.TaskObj;
import com.cognizant.taskmanager.service.TaskService;
@CrossOrigin
@Controller
@RequestMapping(path="/task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewTask (@RequestBody TaskObj task) {

		return taskService.addNewTask(task);
	}

	@GetMapping(path="/all")
	public @ResponseBody List<TaskObj> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody Task updateTask(@RequestBody TaskObj task){
		
		return taskService.updateTask(task);
	}
	
	

}
