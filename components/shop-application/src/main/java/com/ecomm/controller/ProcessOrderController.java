package com.ecomm.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/protected/processorder")
public class ProcessOrderController {

	private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "0";
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewOrder(@RequestParam(required = false, 
    								defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
            						Locale locale) {

        return new ModelAndView("orderProcessPage");
    }
	
	
	
		
}
