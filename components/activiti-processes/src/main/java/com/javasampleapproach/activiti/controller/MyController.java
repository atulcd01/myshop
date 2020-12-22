package com.javasampleapproach.activiti.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.activiti.service.MyService;


@RestController
public class MyController {

	@Autowired
	private MyService myService;

	@RequestMapping(value = "/process")
	public Object startProcessInstance(@RequestParam String assignee) {
		return myService.startProcess(assignee);
	}
	
	@RequestMapping(value = "/listperuser")
	public Object getListPerUser(@RequestParam String assignee) {
		return myService.processInfo(assignee);
	}
	
	@RequestMapping(value = "/process/task")
	public Object getProcessAllUserTask(@RequestParam String name) {
		
		myService.getProcessTask(name);
		return "done" ;
	}

	@RequestMapping(value = "/tasks/{assignee}")
	public Object getTasks(@PathVariable("assignee") String assignee) {
		List<Task> tasks = myService.getTasks(assignee);
		return tasks.toString();
	}

	/*@RequestMapping(value = "/completetask/{assignee}")
	public String completeTask(@PathVariable("assignee" ) String assignee, String xyz) {
		
		return "Task with id " + myService.completeTask(assignee,xyz) + " has been completed!";
	}*/
	
	@RequestMapping(value = "/completetask/{processId}")
	public String completeTask(@PathVariable("processId" ) String processId, String xyz  ,String abc) {
		
		return  myService.completeTask(processId,xyz,abc) ;
	}
	
	
	
	/*@RequestMapping(value = "/completetask")
	public String completeTask(@RequestParam String id) {
		myService.completeTask(id);
		return "Task with id " + id + " has been completed!";
	}*/

}
