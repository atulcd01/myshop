package com.app.ecom.order.vo;

import java.util.List;

import com.app.ecom.order.model.Order;


public class OrderListVO {
    private int pagesCount;
    private long totalOrder;

    private String actionMessage;
    private String searchMessage;

    private List<Order> orders;

    public OrderListVO() {
    }

    public OrderListVO(int pages, long totalOrder, List<Order> orders) {
        this.pagesCount = pages;
        this.orders = orders;
        this.totalOrder = totalOrder;
    }

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	

	public long getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(long totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public String getSearchMessage() {
		return searchMessage;
	}

	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

    


}
