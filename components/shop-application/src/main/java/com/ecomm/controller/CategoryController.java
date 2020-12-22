package com.ecomm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RequestMapping(value = "/protected/category")
public class CategoryController {
	
	
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
    	
    	
    	
        return new ModelAndView("welcomePage");
    }

	
}
