package com.ecomm.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.ecomm.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    Iterable<User> findByApplicationId(String applicationId);
}
