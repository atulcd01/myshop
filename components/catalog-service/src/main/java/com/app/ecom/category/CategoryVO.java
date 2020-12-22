package com.app.ecom.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CategoryVO implements Serializable {
	
	Category baseCategory ;

	public List<Category> getProductList() {
		List<Category> productList  = new ArrayList<Category>();
		recurs(baseCategory,  productList );
		return productList;
	}
	
	public List<Category> recurs(Category categories, List<Category> productList ) {
	
		for (Category category : categories.getChildren()) {
			
			if(category.getChildren()== null || category.getChildren().isEmpty()){
				productList.add(category);
			}else{
				recurs(category,  productList );
			}
		}
		return productList;
	}

	public Category getBaseCategory() {
		return baseCategory;
	}

	public void setBaseCategory(Category baseCategory) {
		this.baseCategory = baseCategory;
	}

	public CategoryVO(Category baseCategory) {
		super();
		this.baseCategory = baseCategory;
	}

	public Category getMenuBaseCategory() {
		Category baseCategory2 = new Category("base_","x",0,null);
		try{
		int cnt=0;
		Category baseCategory1 = new Category("base_","x",0,null);
		baseCategory1.setChildren(new ArrayList<Category>());
		for (Category category : baseCategory.getChildren()) {
			
			//System.out.println(category.getName());
			Category c = new Category();
			c.setId(category.getId());
			c.setName(category.getName());
			baseCategory1.getChildren().add(c);
			c.setChildren(new ArrayList<Category>());
			for (Category category2 : category.getChildren()) {
				
				Category c2 = new Category();
				c2.setId(category2.getId());
				c2.setName(category2.getName());
				c.getChildren().add(c2);
				c2.setChildren(new ArrayList<Category>());
				
				Category c21 = new Category();
				c21.setId(category2.getId());
				c21.setName(category2.getName());
				c21.setCss("bold");
				c2.getChildren().add(c21);
				//System.out.println("\t\t"+category2.getName());
				
				for (Category category3 : category2.getChildren()) {
					Category c3 = new Category();
					c3.setId(category3.getId());
					c3.setName(category3.getName());
					c2.getChildren().add(c3);
					//System.out.println("\t\t\t\t"+category3.getName());
				}
			}
		}
		
		
		baseCategory2.setChildren(new ArrayList<Category>());
		Category c2= null;
		for (Category category : baseCategory1.getChildren()) {
			
			//System.out.println(category.getName());
			Category c = new Category();
			c.setId(category.getId());
			c.setName(category.getName());
			baseCategory2.getChildren().add(c);
			c.setChildren(new ArrayList<Category>());
			
			for (Category category2 : category.getChildren()) {
				
				
				
				//System.out.println("\t\t"+category2.getName());
				
				for (Category category3 : category2.getChildren()) {
					
					if(cnt%50 == 0){
						c2 = new Category();
						c2.setId(category2.getId());
						c2.setName(category2.getName());
						c.getChildren().add(c2);
						c2.setChildren(new ArrayList<Category>());
					}
					
					
					Category c3 = new Category();
					c3.setId(category3.getId());
					c3.setName(category3.getName());
					c3.setCss(category3.getCss());
					c2.getChildren().add(c3);
					//System.out.println("\t\t\t\t"+category3.getName() +"        " +cnt);
					cnt++;
				}
				
			}cnt=0;
		}
		
		for (Category category : baseCategory2.getChildren()) {
			
			//System.out.println(category.getName());
			
			for (Category category2 : category.getChildren()) {
				
				
				//System.out.println("\t\t"+category2.getName());
				
				for (Category category3 : category2.getChildren()) {
					
					//System.out.println("\t\t\t\t"+category3.getName() );
				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return baseCategory2;
	}
}
