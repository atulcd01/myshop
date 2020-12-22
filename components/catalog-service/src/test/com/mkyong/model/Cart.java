package model;

public class Cart {
	
	private String id;
	private String email;
	private String productId;
	private String appId;
	private int qty = 1;
	private boolean active = false;
	
	private Category product;
	
	
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public Category getProduct() {
		return product;
	}

	public void setProduct(Category product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", email=" + email + ", productId=" + productId + "]";
	}

	
	
	
	
	
	
}
