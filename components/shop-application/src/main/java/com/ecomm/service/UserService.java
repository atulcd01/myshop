package com.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.model.User;
import com.ecomm.repository.jpa.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
    
    public Iterable<User> findByApplicationId(String applicationId){
        return userRepository.findByApplicationId(applicationId);
    }
}
