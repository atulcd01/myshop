package com.app.ecom.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue
	private int id;
	private String  userid;
	private String addressId;
	private String applicationId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderDetails> orderDetails;
	

	public String getAddressId() {
		return addressId;
	}

	
	
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}



	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date  orderDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  paymentDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


}
