package com.cognizant.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.taskmanager.dao.ParentTask;
import com.cognizant.taskmanager.service.ParentTaskManagerService;
//import com.cognizant.projectmanagement.service.ParentTaskService;
@CrossOrigin
@Controller
@RequestMapping(path="/parenttask")
public class ParentTaskManagerController {

	@Autowired
	private ParentTaskManagerService parentTaskService;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ParentTask> fetchUsers() {
		return parentTaskService.fetchUsers();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ParentTask addNewTask (@RequestBody String task) {
		return parentTaskService.addNewTask(task);
	}

}
