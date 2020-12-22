package com.app.ecom.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.ecom.order.model.Address;
import com.app.ecom.order.model.Cart;
import com.app.ecom.order.model.CreateOrder;
import com.app.ecom.order.model.Filter;
import com.app.ecom.order.model.Order;
import com.app.ecom.order.model.OrderDetails;
import com.app.ecom.order.vo.AddressListVO;
import com.app.ecom.order.vo.OrderListVO;
import com.app.ecom.order.vo.TrackOrderVO;




@RestController
@RequestMapping(value = "/protected/order")
public class OrderController extends BaseController{

	@Autowired
	private OrderService orderService;
	
	@Autowired
    private MessageSource messageSource;
	
	
	private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "0";
	

    @Value("3")
    private int maxResults;
	
	 @Value("${spring.url.orderprocess}")
	 private String orderprocessrurl ;
	 
	 @Value("${spring.url.nexttaskurl}")
	 private String nexttaskurl ;

	@RequestMapping(value = "/address", method = RequestMethod.GET, produces = "application/json")
	public  AddressListVO  getAddress( Locale locale) {
		String email = getEmail();
		AddressListVO addressListVO = new AddressListVO();
		addressListVO.setAddressList(orderService.getAddressList(email));
		return addressListVO;

	}

	@RequestMapping(value = "/{operation}",  method = RequestMethod.POST, produces = "application/json")
	public AddressListVO addAddress(@PathVariable("operation") String operation , Address address,               
			Locale locale) {
		String email = getEmail();
		System.out.println("in side operation 1" + operation);
		// System.out.println("in side id" + id);
		System.out.println("in side addAddress" + address);
		// String email = getEmail();
		AddressListVO addressListVO = new AddressListVO();
		address.setEmail(email);
		// address.setId(id);

		if("remove".equals(operation)){
			orderService.remove(address);
		}else  if("add".equals(operation)){
			orderService.addAddress(address);

			List<Address> l = addressListVO.getAddressList();
			if(l==null){
				addressListVO.setAddressList(new ArrayList<Address>());
				addressListVO.getAddressList().add(address);
			}else{
				addressListVO.getAddressList().add(address);
			}

		}

		return addressListVO;
	}


	// check which one is used ..   
	@RequestMapping(value = "/{operation}/{id}",  method = RequestMethod.GET, produces = "application/json")
	public AddressListVO removeAddress(@PathVariable("operation") String operation ,@PathVariable("id") String id ,
			@ModelAttribute("address") Address address,               
			Locale locale) {
		String email = getEmail();
		System.out.println("in side operation 2" + operation);
		System.out.println("in side id" + id);
		System.out.println("in side addAddress" + address);
		AddressListVO addressListVO = new AddressListVO();
		address.setEmail(email);
		address.setId(id);

		if("remove".equals(operation)){
			orderService.remove(address);
		}

		return addressListVO;
	}

	//this should be called after payment
	@RequestMapping(value = "/create",  method = RequestMethod.POST, produces = "application/json")
	public Integer createOrder(@RequestBody  CreateOrder createOrder, Locale locale)  {

		System.out.println("in side cartListVO" + createOrder.getSource().size());

		Order order = new Order();

		String email = getEmail();
		order.setUserid(email);
		order.setApplicationId(getApplication());
		order.setAddressId(createOrder.getDeliveryAdId());
		order.setOrderDate(new Date());

		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		
		
		for (Cart cart : createOrder.getSource()) {

			OrderDetails orderDetail = new OrderDetails();
			//orderDetail.setOrderId(order.getId());
			orderDetail.setQuantity(cart.getQty());
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setProductName(cart.getProduct().getName());

			Filter someadditionalattr = cart.getProduct().getSomeadditionalattr();
			int prize = someadditionalattr.getPrize();

			orderDetail.setPrice(prize);
			// orderService.saveDtls(orderDetails);
			orderDetails.add(orderDetail);
			orderDetail.setOrder(order);
			 String header = request.getHeader("Authorization");
			  System.out.println(header);
			  Map<String, String> uriVariables = new HashMap<>();
			    uriVariables.put("assignee", email);
			  
		    ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(//put this in properties files 
		    		orderprocessrurl, String.class,
		        uriVariables);
		    orderDetail.setProcessId(responseEntity.getBody().split("~")[0]);
		    orderDetail.setStatus(responseEntity.getBody().split("~")[1]);
		    orderDetail.setStep(1);
		    //call cart url here
			//cartService.delete(cart.getId());
		}
		order.setOrderDetails(orderDetails);
		order = orderService.save(order);

		return 0;
	}
	
	@RequestMapping(value = "/completetask",  method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> completeTask( OrderDetails orderDetails) {
		
		if(!"Order Processed".equals(orderDetails.getStatus())) {
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("processId", orderDetails.getProcessId());

			ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
					nexttaskurl, String.class,
					uriVariables);

			orderDetails =  orderService.findById(orderDetails.getId());
			orderDetails.setTaskId(responseEntity.getBody().split("~")[0]);
			orderDetails.setStatus(responseEntity.getBody().split("~")[1]);
			orderDetails.setStep(orderDetails.getStep()+1);

			orderService.saveDtls(orderDetails);
		}
		 return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = "application/json")
    public  ResponseEntity<?>  getOrderByEmail(@RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
                                    Locale locale) {

	 return new ResponseEntity<OrderListVO>( getOrderlist(getEmail(),getApplication(), page, locale, null), HttpStatus.OK);
	 
 }
	
	
	private OrderListVO  getOrderlist( String email,String applicationId, int page, Locale locale, String actionMessageKey) {
        OrderListVO orderListVO = orderService.findAll(page, maxResults,email,applicationId);
        System.out.println("orderListVO >>" + orderListVO.getOrders());
        if (actionMessageKey!=null) {
            addActionMessageToVO(orderListVO, locale, actionMessageKey, null);
        }

       // Object[] args = {email};

       // addSearchMessageToVO(orderListVO, locale, "message.search.for.active", args);
        return orderListVO;
       
    }
	
	private OrderListVO  getOrderlist( int page, Locale locale, String actionMessageKey) {
        OrderListVO orderListVO = orderService.findAll(page, maxResults);
        System.out.println("orderListVO >>" + orderListVO.getOrders());
        if (actionMessageKey!=null) {
            addActionMessageToVO(orderListVO, locale, actionMessageKey, null);
        }

       // Object[] args = {email};

       // addSearchMessageToVO(orderListVO, locale, "message.search.for.active", args);
        return orderListVO;
       
    }

	//utility methods 
	 private OrderListVO addActionMessageToVO(OrderListVO orderListVO, Locale locale, String actionMessageKey, Object[] args) {
	        if (actionMessageKey==null) {
	            return orderListVO;
	        }

	        orderListVO.setActionMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

	        return orderListVO;
	    }

	    private OrderListVO addSearchMessageToVO(OrderListVO orderListVO, Locale locale, String actionMessageKey, Object[] args) {
	        if (actionMessageKey==null) {
	            return orderListVO;
	        }

	        orderListVO.setSearchMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

	        return orderListVO;
	    }

	    @RequestMapping(value = "/track/{orderId}", method = RequestMethod.GET, produces = "application/json")
	    public  TrackOrderVO  search(@PathVariable("orderId") String orderId,Locale locale) {
			System.out.println("orderId object >>"+orderId);
			
			int orderIdInt = Integer.valueOf(orderId);
			TrackOrderVO trackOrderVO = orderService.getOrder(orderIdInt);
		 return trackOrderVO;
	 }
	    
	    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
	    public  OrderListVO  getAllOrder(@RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
                Locale locale) {
	    	 OrderListVO  orderListVO =  getOrderlist( page, locale, null);
		 return orderListVO;
	 }
}
