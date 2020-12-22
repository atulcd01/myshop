package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	
	private String id;
	private String parent;
	int order;
	private Filter someadditionalattr;
	private String breadcrumb;
	private List<Category> children;
	private List<Column> productSpecification;
	private String description;
	private String hasGroup;
	private List<String> addonList;
	private String name;
	
	private String applicationId;
	
	public Category(String id, String parent, int order, Filter someadditionalattr) {
		super();
		this.id = id;
		this.parent = parent;
		this.order = order;
		this.someadditionalattr = someadditionalattr;
	}
	
	public Category(String id) {
		super();
		this.id = id;
		
	}
	
	public Category() {
		super();
	}
	
	public Category(String id,String name, String parent, int order, String description,String isProduct, String prize , String[] productids , String[] c,
			ArrayList<String> headerList,String applicationId) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.order = order;
		this.description = description;
		this.applicationId = applicationId;
		
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
		
		if(!headerList.isEmpty()){
			this.productSpecification = new ArrayList<Column>();
	System.out.println(c.length);
	for (String s : c) {
		System.out.println(s);
	}
	if(c.length>9)
				for (int i = 0; i < headerList.size(); i++) {
					String val = c[8+i];
					if(val!=null && !"".equals(val.trim()))
						productSpecification.add(new Column(headerList.get(i),val));
				}
		}
		
		
	}
	
	public Category(String id,String name, String parent, int order, String description,String isProduct, String prize,String applicationId) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.order = order;
		this.description = description;
		this.applicationId = applicationId;
		
		if("Y".equals(isProduct)){
			this.someadditionalattr = new Filter();
			this.someadditionalattr.setPrize(Integer.valueOf(prize));
		}
	}
	
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public List<Column> getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(List<Column> productSpecification) {
		this.productSpecification = productSpecification;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHasGroup() {
		return hasGroup;
	}

	public void setHasGroup(String hasGroup) {
		this.hasGroup = hasGroup;
	}

	public List<String> getAddonList() {
		return addonList;
	}

	public void setAddonList(List<String> addonList) {
		this.addonList = addonList;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parent=" + parent + ", order=" + order + ", someadditionalattr="
				+ someadditionalattr + "]";
	}

	
}
