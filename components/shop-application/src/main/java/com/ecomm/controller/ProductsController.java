package com.ecomm.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/products")
public class ProductsController extends  BaseController {
	
	private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "0";
	
	
	@Autowired
    private MessageSource messageSource;

    @Value("9")
    private int maxResults;

	
	
	 
	 @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	    public ModelAndView  welcome(@PathVariable("name") String name,
	                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
	                                    Locale locale) {
	        
		// System.out.println("name welcome >>"+name);
		 return new ModelAndView("productsList");
	    }
	 
	 
}
