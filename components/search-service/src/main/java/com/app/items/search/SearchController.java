package com.app.items.search;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping(value = "/protected/products")
public class SearchController extends  BaseController {
	
	private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "0";
	
	@Autowired
    private SearchService searchService;
	
	@Autowired
    private MessageSource messageSource;

    @Value("9")
    private int maxResults;

	
	
	 
	 @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	    public ModelAndView  welcome(@PathVariable("name") String name,
	                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
	                                    Locale locale) {
	        
		// System.out.println("name welcome >>"+name);
		 return new ModelAndView("productsList");
	    }
	 
	 @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	    public  ResponseEntity<?>  search(@PathVariable("name") String name,
	                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
	                                    Locale locale) {

		 //System.out.println("name object >>"+name);
		 //System.out.println("name page >>"+page);
		 return new ResponseEntity<SearchVO>( getProductlist(name, page, locale, null), HttpStatus.OK);
	 }

	 private SearchVO  getProductlist(String name, int page, Locale locale, String actionMessageKey) {
	        SearchVO productListVO = searchService.findByNameLike(page, maxResults, name, getApplication());
	        System.out.println("productListVO >>" + productListVO.getProducts());
	        if (actionMessageKey!=null) {
	            addActionMessageToVO(productListVO, locale, actionMessageKey, null);
	        }

	        Object[] args = {name};

	        addSearchMessageToVO(productListVO, locale, "message.search.for.active", args);
	        return productListVO;
	       
	    }
	 
	 //utility methods 
	 private SearchVO addActionMessageToVO(SearchVO productListVO, Locale locale, String actionMessageKey, Object[] args) {
	        if (actionMessageKey==null) {
	            return productListVO;
	        }

	        productListVO.setActionMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

	        return productListVO;
	    }

	    private SearchVO addSearchMessageToVO(SearchVO productListVO, Locale locale, String actionMessageKey, Object[] args) {
	        if (actionMessageKey==null) {
	            return productListVO;
	        }

	        productListVO.setSearchMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

	        return productListVO;
	    }
}
