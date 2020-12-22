package com.ecomm.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/view")
public class ViewController  extends  BaseController{
	
	
	
	 
	 @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	    public ModelAndView  welcome(@PathVariable("name") String name,
	                                    
	                                    Locale locale) {
	        
		 System.out.println("name welcome to viewPage >>"+name);
		 return new ModelAndView("viewPage");
	    }
	 
	
}
