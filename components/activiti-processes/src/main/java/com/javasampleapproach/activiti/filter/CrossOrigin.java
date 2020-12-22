package com.javasampleapproach.activiti.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * Standard Filter. Allows cross origin restful access. 
 */
//@WebFilter(urlPatterns="/*")
@WebFilter(urlPatterns = {"/*" })
public class CrossOrigin implements Filter {

	
	@Override
	public void destroy() {
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
			System.out.println("In CrossOrigin.doFilter Method");
		
		HttpServletResponse r = (HttpServletResponse) response;
	    //String origin = ((HttpServletRequest) request).getHeader("origin");
			r.addHeader("Access-Control-Allow-Origin", "*");
		    r.addHeader("Access-Control-Allow-Credentials", "true");
		    r.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
		    r.addHeader("X-Content-Type-Options", "nosniff");
		    
		    r.addHeader("Access-Control-Allow-Headers",
	            	"Accept,Accept-Encoding,Accept-Language,x-requested-with,"
	            	+ "Cache-Control,Connection,Content-Length,Content-Type,"
	            	+ "Cookie,Host,Pragma,Referer,RemoteQueueID,User-Agent,"
	            	+ "refresh_token,Checksum,form_name,user_name");
		    r.addHeader("Access-Control-Expose-Headers","refresh_token,form_name,user_name");
	    r.addHeader("X-FRAME-OPTIONS", "DENY");//PT-Changes|24May16|To deny clickjacking
	    chain.doFilter(request, r);
	    
	    	System.out.println("Out CrossOrigin.doFilter Method");
	} 

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
	} 

}
