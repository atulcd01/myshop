package com.app.ecom.order;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

abstract public class BaseController {


	
	@Autowired
    HttpServletRequest request;
	
	public String getEmail() {
		String email  = request.getHeader("email");
		
		if(email == null || "".equals(email.trim()) || "null".equalsIgnoreCase(email))
		 email = request.getRemoteAddr();
		
		System.out.println("Email ->"+email);
		return email ;
	}
	
	public String getLocalEmail() {
		String email  = request.getHeader("localemail");
		
		if(email == null || "".equals(email.trim()) || "null".equalsIgnoreCase(email))
		 email = request.getRemoteAddr();
		System.out.println("Local Email ->"+email);
		return email ;
	}
	public String getApplication(){
		
		return request.getParameter("a")==null? "-1" : request.getParameter("a");
	}
}
