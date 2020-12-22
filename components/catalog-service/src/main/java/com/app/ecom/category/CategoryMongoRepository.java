package com.app.ecom.category;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface CategoryMongoRepository extends MongoRepository<Category, String> {

    public List<Category> findByParent(String parent);
    public List<Category> findByBreadcrumbRegex(String breadcrumb);

}
