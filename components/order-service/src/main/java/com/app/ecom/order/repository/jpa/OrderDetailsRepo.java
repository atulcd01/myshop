package com.app.ecom.order.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.app.ecom.order.model.OrderDetails;



public interface OrderDetailsRepo  extends CrudRepository<OrderDetails, Integer>{

	OrderDetails findById(int  id);
}
