package com.app.ecom.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecom.order.model.Address;
import com.app.ecom.order.model.Order;
import com.app.ecom.order.model.OrderDetails;
import com.app.ecom.order.repository.jpa.OrderDetailsRepo;
import com.app.ecom.order.repository.jpa.OrderRepository;
import com.app.ecom.order.repository.mongo.AddressRespository;
import com.app.ecom.order.vo.OrderListVO;
import com.app.ecom.order.vo.TrackOrderVO;



@Service
@Transactional
public class OrderService {



	@Autowired
	private AddressRespository addressRepository;

	@Autowired
	private OrderRepository  orderRepository;

	@Autowired
	private OrderDetailsRepo  orderDetailRepository;

	
	//for order view
	
	 @Transactional(readOnly = true)
	    public OrderListVO findAll(int page, int maxResults, String email, String applicationId) {
	        Page<Order> result = executeQueryFindByEmail(page, maxResults, email,applicationId);

	        if(shouldExecuteSameQueryInLastPage(page, result)){
	            int lastPage = result.getTotalPages() - 1;
	            result = executeQueryFindByEmail(lastPage, maxResults, email,applicationId);
	        }

	        return buildResult(result);
	    }

	 @Transactional(readOnly = true)
	    public OrderListVO findAll(int page, int maxResults) {
	        Page<Order> result = executeQueryFindByEmail(page, maxResults);

	        if(shouldExecuteSameQueryInLastPage(page, result)){
	            int lastPage = result.getTotalPages() - 1;
	            result = executeQueryFindByEmail(lastPage, maxResults);
	        }

	        return buildResult(result);
	    }
	 
	 	private boolean shouldExecuteSameQueryInLastPage(int page, Page<Order> result) {
	        return isUserAfterOrOnLastPage(page, result) && hasDataInDataBase(result);
	    }
	    
	    private Sort sortByNameASC() {
	        return new Sort(Sort.Direction.DESC, "id");
	    }

	    private OrderListVO buildResult(Page<Order> result) {
	        return new OrderListVO(result.getTotalPages(), result.getTotalElements(), result.getContent());
	    }

	    private Page<Order> executeQueryFindByEmail(int page, int maxResults, String email,String applicationId) {
	        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNameASC());

	        System.out.println( email );
	        return orderRepository.findByUseridAndApplicationId(pageRequest, email, applicationId);
	    }
	    
	    private Page<Order> executeQueryFindByEmail(int page, int maxResults) {
	        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNameASC());

	      //  System.out.println( email );
	        return orderRepository.findAll(pageRequest);
	    }

	    private boolean isUserAfterOrOnLastPage(int page, Page<Order> result) {
	        return page >= result.getTotalPages() - 1;
	    }

	    private boolean hasDataInDataBase(Page<Order> result) {
	        return result.getTotalElements() > 0;
	    }
	
	//
	

	public   List<Address> getAddressList(String email){
		return addressRepository.findByEmail(email) ;
	}

	public Order save(Order order) {

		return orderRepository.save(order);

	}
	public OrderDetails saveDtls(OrderDetails orderDetails) {

		return orderDetailRepository.save(orderDetails);

	}

	public void addAddress(Address address) {
		addressRepository.save(address);
	}




	public void remove(Address address) {

		addressRepository.delete(address.getId());

	}

	public TrackOrderVO getOrder(int orderIdInt) {
		
		TrackOrderVO trackOrderVO = new TrackOrderVO();
		Order order = orderRepository.findOne(orderIdInt);
		trackOrderVO.setOrder(order);
		
		Address address = addressRepository.findOne(order.getAddressId());
		trackOrderVO.setAddress(address);
		
		return trackOrderVO;
	}
	
	public OrderDetails findById(int  id) {

		return orderDetailRepository.findById(id);

	}
	
}
