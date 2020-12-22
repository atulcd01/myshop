package com.ecomm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public String redirect(){
        return "redirect:/protected/home";
    }
    /*@RequestMapping(value = "/{appId}",method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public String redirectApplication(@PathVariable("appId") int appId){
        return "redirect:/protected/home/"+appId;
    }*/

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, produces = "application/json")
    public ResponseEntity<?> doGetAjax() {
        return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
    }    
}
