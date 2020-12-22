package com.ecomm.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/trackorder")
public class TrackOrderController {
	
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ModelAndView  welcome(@PathVariable("orderId") String orderId,Locale locale) {
        
	 return new ModelAndView("trackOrder");
    }
	
	
	
}
