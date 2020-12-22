package com.install.model;

public class ProductVO {
	
	Product baseProduct ;

	public ProductVO(Product baseProduct) {
		super();
		this.baseProduct = baseProduct;
	}

	public Product getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(Product baseProduct) {
		this.baseProduct = baseProduct;
	}

	public void print() {
		
		for(Product product : baseProduct.getChildren()){
			System.out.println(product.getId());
			iterator(product);
		}
		
	}
	
	public void iterator(Product bproduct) {
		
		if(hasNext(bproduct))
		
		for(Product product : bproduct.getChildren()){
			System.out.println(product.getId());
			iterator(product);
		}
		
	}
	
public boolean hasNext(Product product) {
		
		if(product.getChildren() != null)
			return true;
		else
			return false;
		
	}

	
}
