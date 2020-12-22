package com.ecomm.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

abstract public class BaseController {

	
	@Autowired
    ServletContext context;
	
	@Autowired
    HttpServletRequest request;
	
	public String getEmail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = request.getRemoteAddr();
		 if(auth.isAuthenticated()){
			if(!"anonymousUser".equals(auth.getName()))
				 email = auth.getName();
		 }
		return email;
	}
	
	public String getApplication(){
		
		return request.getParameter("a")==null? "1" : request.getParameter("a");
	}
}
