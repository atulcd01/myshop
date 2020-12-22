package com.install.model;

import java.util.List;

public class Product {
	
	private String id;
	private String parent;
	int order;
	private String someadditionalattr;
	private String breadcrumb;
	private List<Product> children;
	
	public Product(String id, String parent, int order, String someadditionalattr) {
		super();
		this.id = id;
		this.parent = parent;
		this.order = order;
		this.someadditionalattr = someadditionalattr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getSomeadditionalattr() {
		return someadditionalattr;
	}
	public void setSomeadditionalattr(String someadditionalattr) {
		this.someadditionalattr = someadditionalattr;
	}
	
	public String getBreadcrumb() {
		return breadcrumb;
	}
	public void setBreadcrumb(String breadcrumb) {
		this.breadcrumb = breadcrumb;
	}
		public List<Product> getChildren() {
		return children;
	}
	public void setChildren(List<Product> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", parent=" + parent + ", order=" + order + ", someadditionalattr="
				+ someadditionalattr + "]";
	}

	
}
