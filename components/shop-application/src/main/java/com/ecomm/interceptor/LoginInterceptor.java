package com.ecomm.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ecomm.model.User;
import com.ecomm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        //System.out.println("hi from intercepter");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if(user == null && auth!=null && !"anonymousUser".equals(auth.getName())){
           
            String email = auth.getName();
          //  System.out.println("user.email ->" + email);
            user = userService.findByEmail(email);
          //  System.out.println("user.name ->" + user.getName());
            session.setAttribute("user", user);
            
        }

        return super.preHandle(request, response, handler);
    }
}
