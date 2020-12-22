package com.javasampleapproach.activiti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.activiti.model.Order;
import com.javasampleapproach.activiti.repo.PersonRepository;

@Service
@Transactional
public class MyService {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private PersonRepository personRepository;
	
	public void getProcessTask(String processId){
		BpmnModel model = repositoryService.getBpmnModel(processId);
		List<Process> processes = model.getProcesses();
		List<UserTask> userTasks = new ArrayList<>();
		for( Process p : processes ) {
		     userTasks.addAll( p.findFlowElementsOfType(UserTask.class));
		}
		for (UserTask userTask : userTasks) {
			System.out.println(userTask.getId());
		}
		
	}

	public String startProcess(String assignee) {
		//Person person = personRepository.findByName(assignee);
		Order order = new Order();
		order.setAssignee(assignee);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("order", order);
		ProcessInstance p =runtimeService.startProcessInstanceByKey("orderProcess", variables);
		TaskInfo t = taskService.createTaskQuery().processInstanceId(p.getId()).list().get(0);
		System.out.println("processinstance id -->"+p.getProcessInstanceId()+"task service " +t.getId() + "task name "+ t.getName() );
		return p.getId()+"~"+t.getName()+"~"+t.getId();
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}
	
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}
	
	public Task getTaskfromProcessId(String processId){
		List<Task> tlist = taskService.createTaskQuery().processInstanceId(processId).list();
		if(tlist.size()>0){
			return tlist.get(0);
		}else
			return null;
	}
	
	public String  completeTask(String processId, String xyz, String abc) {

		Task task = getTaskfromProcessId(processId);
		if(task!=null){
			taskService.complete(task.getId());
			Task t = getTaskfromProcessId(processId);
			if(t!=null)
				return t.getId()+"~"+t.getName();
		}
		return "0~Order Processed";
	}
	
	public String  completeTask(String assignee, String xyz) {
		List<Task> tlist = taskService.createTaskQuery().taskAssignee(assignee).list();
		//List<Task> tlist = taskService.createTaskQuery().processInstanceId("57501").list();
		if(tlist.size()>0){
			Task task = tlist.get(0);
			taskService.complete(task.getId());
			return task.getName();
		}
		else 
			return "Order Processed";
	}

	public String processInfo() {
		List<Task> tasks = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Number of process definitions : "
				+ repositoryService.createProcessDefinitionQuery().count() + "--> Tasks >> <br>");
		for (Task task : tasks) {
			stringBuilder
					.append("<br>"+task + " | Assignee: " + task.getAssignee() + " | Description: " + task.getDescription());
		}
		return stringBuilder.toString();
	}
	
	public String processInfo(String assignee) {
		List<Task> tasks = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Number of process definitions : "
				+ repositoryService.createProcessDefinitionQuery().count() + "--> Tasks >> <br>");
		/*for (Task task : tasks) {
			stringBuilder.append("<br>"+task + " | Assignee: " + task.getAssignee() + " | Description: " + task.getDescription() +" TaskDefinitionKey ->"  +task.getTaskDefinitionKey());
		}*/
		for(ProcessDefinition p :repositoryService.createProcessDefinitionQuery().list()){
			stringBuilder.append(""+ p.getId() + "<br>");
			
		}
		stringBuilder.append("<br>");
		
		return stringBuilder.toString();
	}
}