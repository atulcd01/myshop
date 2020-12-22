package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/protected/cart")
public class CartController extends BaseController {

	

	 @RequestMapping(method = RequestMethod.GET)
	    public ModelAndView welcome() {
	    	
	    	System.out.println("in side cartPage");
	        return new ModelAndView("cartPage");
	    }

	
	 
	 
}
