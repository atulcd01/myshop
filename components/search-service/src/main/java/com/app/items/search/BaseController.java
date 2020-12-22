package com.app.items.search;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

abstract public class BaseController {

	
	
	
	@Autowired
    HttpServletRequest request;
	
	
	
	public String getApplication(){
		
		return request.getParameter("a")==null? "1" : request.getParameter("a");
	}
}
