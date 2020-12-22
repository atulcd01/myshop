package com.ecomm.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;




public class Category {
	
	@Id
	private String id;
	private String name;
	private String parent;
	private int order;
	private boolean show = true;
	private Filter someadditionalattr;
	private String breadcrumb;
	private List<Category> children;
	private String description;
	private String css;
	private List<Column> productSpecification;
	private List<String> addonList;
	private String applicationId;
	
	private int views = 1;
	private int rating = 5; 
	
	public Category(String id, String parent, int order, Filter someadditionalattr) {
		super();
		this.id = id;
		this.parent = parent;
		this.order = order;
		this.someadditionalattr = someadditionalattr;
	}
	
	
	public List<Column> getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(List<Column> productSpecification) {
		this.productSpecification = productSpecification;
	}
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getAddonList() {
		return addonList;
	}


	public void setAddonList(List<String> addonList) {
		this.addonList = addonList;
	}


	public Category(String id) {
		super();
		this.id = id;
		
	}
	
	public Category() {
		super();
	}
	
	public Category(String id,String name, String parent, int order, String description,String isProduct, String prize , String[] productids) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.order = order;
		this.description = description;
		
		if("Y".equals(isProduct)){
			this.someadditionalattr = new Filter();
			this.someadditionalattr.setPrize(Integer.valueOf(prize));
		}
		
		if(productids != null){
			this.addonList = new ArrayList<String>();
			for (String productid : productids) {
				addonList.add(productid);
			}
		}
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
	public Filter getSomeadditionalattr() {
		return someadditionalattr;
	}
	public void setSomeadditionalattr(Filter someadditionalattr) {
		this.someadditionalattr = someadditionalattr;
	}
	
	public String getBreadcrumb() {
		return breadcrumb;
	}
	public void setBreadcrumb(String breadcrumb) {
		this.breadcrumb = breadcrumb;
	}
	
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", parent=" + parent + ", order=" + order + ", someadditionalattr="
				+ someadditionalattr + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public String getName() {
		if(name==null || "".equals(name))
			name = id.replaceAll("_", " ");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}

	
}
