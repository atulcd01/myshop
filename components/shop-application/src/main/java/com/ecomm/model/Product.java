package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
	private String name;
	private String packages;
	private String description;
	private String baseCategory;
	
	public Product(){
		
	}
	
	
	public Product(int id, String name, String packages, String description, String baseCategory) {
		super();
		this.id = id;
		this.name = name;
		this.packages = packages;
		this.description = description;
		this.baseCategory = baseCategory;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPackages() {
		return packages;
	}


	public void setPackages(String packages) {
		this.packages = packages;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getBaseCategory() {
		return baseCategory;
	}



	public void setBaseCategory(String baseCategory) {
		this.baseCategory = baseCategory;
	}



	@Override
    public boolean equals(Object object) {
        if (object instanceof Product){
        	Product product = (Product) object;
            return product.id == id;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
