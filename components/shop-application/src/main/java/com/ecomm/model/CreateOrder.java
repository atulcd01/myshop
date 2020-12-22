package com.ecomm.model;

import java.util.List;

public class CreateOrder {

	String deliveryAdId;
	
	List<Cart> source;

	public String getDeliveryAdId() {
		return deliveryAdId;
	}

	public void setDeliveryAdId(String deliveryAdId) {
		this.deliveryAdId = deliveryAdId;
	}

	public List<Cart> getSource() {
		return source;
	}

	public void setSource(List<Cart> source) {
		this.source = source;
	}
}
