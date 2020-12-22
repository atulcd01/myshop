package com.app.ecom.order.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.ecom.order.model.Order;


public interface OrderRepository  extends PagingAndSortingRepository<Order, Integer> {

	Page<Order> findByUseridAndApplicationId(Pageable pageable, String email, String applicationId);
}


