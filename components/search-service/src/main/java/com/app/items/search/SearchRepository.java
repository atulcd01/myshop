package com.app.items.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface SearchRepository extends PagingAndSortingRepository<Category, String> {
	
	Page<Category> findByBreadcrumbRegex(Pageable pageable, String breadcrumb);
	 
}