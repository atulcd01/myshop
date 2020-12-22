package com.ecomm.vo;

import java.util.List;

import com.ecomm.model.Cart;

public class CartListVO {

	
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		
		this.count = count;
	}

	public String getIds() {
		return ids;
	}

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private List<Cart> cartList;
	
	private int count;
	
	private String ids;
	
	private double total;
	
	
}
