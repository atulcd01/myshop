package com.ecomm.controller;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecomm.model.User;
import com.ecomm.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController  extends BaseController{
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;

	/*@Autowired
    private CartService cartService;*/
	
	 @Value("${cart.merge.url}")
	 private  String mergecarturl ;
	
	@PostMapping("/login")
    public User login(@RequestBody User user) {
    	UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
    	
    	Authentication auth = null;
    	try{
    	 auth = authenticationManager.authenticate(authReq);
    	 SecurityContext sc = SecurityContextHolder.getContext();
         sc.setAuthentication(auth);
    	 String email = getEmail();
    	 //
    	 /*List<Cart> ls = cartService.getCart(request.getRemoteAddr(),user.getApplicationId());
    	 
    	 for (Cart cart : ls) {
    		 cartService.delete(cart.getId());
    		 cart.setId(null);
    		 cart.setEmail(email);
    		 cartService.addToCart(cart);
    		 
		}*/
    	 mergeCart(request.getRemoteAddr(),email,user.getApplicationId());
        
        
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        if(auth.isAuthenticated()){
        
        	HttpSession session = request.getSession(true);
        	String email = auth.getName();
        	user = userService.findByEmail(email);
        	session.setAttribute("user", user);
        	return user;
        }
        else
        	return null;
        	
    	
    }
    
	@GetMapping("/localemail")
    public String getLocalEmail() throws ServletException {
		return request.getRemoteHost();
    }

	@PostMapping("/logout")
    public void logout() throws ServletException {
		request.logout();
    }
    
    @RequestMapping(value = "/register", method =RequestMethod.POST )
    public User doRegisterUser(User user) {

    	if(userService.findByEmail(user.getEmail())==null){
    		user = userService.saveUser(user);
    		login(user);
    		return user;
    	}else
    		return null;
    }
    
    @RequestMapping(value = "/isauthenticated", method = RequestMethod.GET)
    public boolean isauthenticated() {

    	 SecurityContext sc = SecurityContextHolder.getContext();
    	 return sc.getAuthentication().isAuthenticated();
    }
    
    private  void mergeCart(String localemail, String loginemail,String applicationId)
    {
        final String uri = String.format(mergecarturl, applicationId);
        System.out.println("uri->"+uri);
        
        RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject(uri, String.class);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("localemail", localemail);
        headers.add("email", loginemail);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
         
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
         
         
        System.out.println(result);
    }
    
    
    
}
