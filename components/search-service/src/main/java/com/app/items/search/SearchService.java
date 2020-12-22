package com.app.items.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;

    @Transactional(readOnly = true)
    public SearchVO findAll(int page, int maxResults) {
        Page<Category> result = executeQueryFindAll(page, maxResults);

        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            result = executeQueryFindAll(lastPage, maxResults);
        }

        return buildResult(result);
    }

    public void save(Category product) {
        searchRepository.save(product);
    }

   // @Secured("ROLE_ADMIN")
    public void delete(String productId) {
        searchRepository.delete(productId);
    }

    @Transactional(readOnly = true)
    public SearchVO findByNameLike(int page, int maxResults, String name, String applicationId) {
        Page<Category> result = executeQueryFindByName(page, maxResults, name, applicationId);

        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            result = executeQueryFindByName(lastPage, maxResults, name, applicationId);
        }

        return buildResult(result);
    }

    private boolean shouldExecuteSameQueryInLastPage(int page, Page<Category> result) {
        return isUserAfterOrOnLastPage(page, result) && hasDataInDataBase(result);
    }

    private Page<Category> executeQueryFindAll(int page, int maxResults) {
        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNameASC());

        return searchRepository.findAll(pageRequest);
    }

    private Sort sortByNameASC() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    private SearchVO buildResult(Page<Category> result) {
        return new SearchVO(result.getTotalPages(), result.getTotalElements(), result.getContent());
    }

    private Page<Category> executeQueryFindByName(int page, int maxResults, String name,  String applicationId) {
        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNameASC());

        System.out.println( name );
        Query query = new Query();
		query.addCriteria(Criteria.where("breadcrumb").regex(name).and("applicationId").is(applicationId));
		query.with(pageRequest);
		List<Category> cartList = mongoTemplate.find(query, Category.class);
		return PageableExecutionUtils.getPage(cartList, pageRequest,
	            () -> mongoTemplate.count(query, Category.class));
		
        //return searchRepository.findByBreadcrumbRegex(pageRequest, name );
    }

    private boolean isUserAfterOrOnLastPage(int page, Page<Category> result) {
        return page >= result.getTotalPages() - 1;
    }

    private boolean hasDataInDataBase(Page<Category> result) {
        return result.getTotalElements() > 0;
    }
}