package com.app.ecom.order.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class OrderDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String productId;
	private String productName;
	private int price;
	private int quantity;
	@Column(nullable=true,unique=false)
	private int step ;
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date  shipingDate;
	
	private String taskId;
	private String processId;
	private String status;
	
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "order_id")
	private Order order;

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getShipingDate() {
		return shipingDate;
	}
	public void setShipingDate(Date shipingDate) {
		this.shipingDate = shipingDate;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getProductName() {
		if(productName == null)
			productName = productId.replaceAll("_", " ");
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
