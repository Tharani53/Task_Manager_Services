package com.cognizant.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.taskmanager.dao.ParentTask;
import com.cognizant.taskmanager.dao.Task;

import com.cognizant.taskmanager.model.TaskObj;
import com.cognizant.taskmanager.repository.ParentTaskManagerRepository;

import com.cognizant.taskmanager.repository.TaskRepository;


@Service
public class TaskService {
	
	@Autowired 
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskManagerRepository repo;

	
//	@Autowired
//	private ParentTask pTask;
//	
//	@Autowired
//	private Task t;
//	
//	@Autowired
//	private TaskObj obj;
//	
//	@Autowired
//	private Project p;
	
	public String addNewTask(TaskObj task) {
		if(task.isParentTask()){
			ParentTask pTask = new ParentTask();
			pTask.setParentTask(task.getTaskName());
			repo.save(pTask);
		}else{
			Task t = new Task();
			t.setParentId(task.getParentTaskId());
			t.setProjectId(task.getProjectId());
			t.setTask(task.getTaskName());
			t.setStartDate(task.getStartDate());
			t.setEndDate(task.getEndDate());
			t.setPriority(task.getPriority());
			t.setUserId(task.getUserId());	
			t.setStatus("STARTED");
			taskRepo.save(t);
		}
		
		return "Saved";
	}
	
	
	public List<TaskObj> getAllTasks() {
		List<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList =  (List<Task>) taskRepo.findAll();
		for(Task t: taskList){
			TaskObj obj = new TaskObj();
			obj.setTaskId(t.getTaskId());
			obj.setParentTaskId(t.getParentId());
			obj.setProjectId(t.getProjectId());
			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());
			obj.setUserId(t.getUserId());
			if(t.getParentId() != null){
				ParentTask	 pTask = repo.findOne(t.getParentId());
				if(pTask != null){
					obj.setParentTaskName(pTask.getParentTask());
				}
			}
			
			
			taskObjList.add(obj);
			
		}
		
		return taskObjList;
	}
	
	

	public Task updateTask(TaskObj task) {
		Task	t = taskRepo.findOne(task.getTaskId());
		t.setParentId(task.getParentTaskId());
		t.setProjectId(task.getProjectId());
		t.setTask(task.getTaskName());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
	    t.setStatus(task.getStatus());     
		return taskRepo.save(t);
	}


	public Iterable<TaskObj> getTasksByProject(Integer id) {
		 List<TaskObj> taskObjList = new ArrayList<>();
			List<Task> taskList = taskRepo.findAllByProjectId(id);
			for(Task t: taskList){
				TaskObj obj = new TaskObj();
				obj.setTaskId(t.getTaskId());
				obj.setParentTaskId(t.getParentId());
				obj.setProjectId(t.getProjectId());
				obj.setTaskName(t.getTask());
				obj.setStartDate(t.getStartDate());
				obj.setEndDate(t.getEndDate());
				obj.setPriority(t.getPriority());
				obj.setStatus(t.getStatus());
				obj.setUserId(t.getUserId());
				if(t.getParentId() != null){
					ParentTask pTask = repo.findOne(t.getParentId());
					if(pTask != null){
						obj.setParentTaskName(pTask.getParentTask());
					}
				}
				
				
				taskObjList.add(obj);
				
			}
			return taskObjList;
	}
	


}
