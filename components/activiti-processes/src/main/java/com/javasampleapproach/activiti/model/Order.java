package com.javasampleapproach.activiti.model;

import java.io.Serializable;

public class Order implements Serializable {
	
	private String id;
	
	private String assignee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
}
