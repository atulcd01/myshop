package com.app.ecom.cart;

import java.util.List;


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
	public boolean isInCart() {
		return inCart;
	}

	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}
	private List<Cart> cartList;
	
	private int count;
	
	private String ids;
	
	private boolean inCart;
	
	

	private double total;
	
	
}
