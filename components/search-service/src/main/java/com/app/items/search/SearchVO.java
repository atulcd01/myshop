package com.app.items.search;

import java.util.List;

public class SearchVO {
    private int pagesCount;
    private long totalProduct;

    private String actionMessage;
    private String searchMessage;

    private List<Category> products;

    public SearchVO() {
    }

    public SearchVO(int pages, long totalProduct, List<Category> products) {
        this.pagesCount = pages;
        this.products = products;
        this.totalProduct = totalProduct;
    }

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	

	public long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
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

	public List<Category> getProducts() {
		return products;
	}

	public void setProducts(List<Category> products) {
		this.products = products;
	}

    


}
