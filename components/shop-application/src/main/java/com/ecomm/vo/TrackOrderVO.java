package com.ecomm.vo;

import java.util.List;

import com.ecomm.model.Address;
import com.ecomm.model.Order;
import com.ecomm.model.OrderDetails;

public class TrackOrderVO {

	
	private Order order;
	private Address address;
	
	private int quantity;
	private int total;
	private List<String> messagelist;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getMessagelist() {
		return messagelist;
	}
	public void setMessagelist(List<String> messagelist) {
		this.messagelist = messagelist;
	}
	public int getQuantity() {

		if(order!=null)
			quantity = order.getOrderDetails().size();
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		
		if(order!=null)
		for (OrderDetails details : order.getOrderDetails()) {

			total = details.getPrice() * details.getQuantity();

		}
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	//invoice
	
	
	
}
