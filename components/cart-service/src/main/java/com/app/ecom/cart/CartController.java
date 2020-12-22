package com.app.ecom.cart;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/protected/cart")
public class CartController extends BaseController {

	@Autowired
    private CartService cartService;
	
	
	 @RequestMapping( method = RequestMethod.GET)
	    public  CartListVO  getCart( Locale locale) {
		 CartListVO cartListVO = new CartListVO();
		 String email = getEmail();
		 if(getApplication()!=null){
		 cartListVO.setCartList(cartService.getCart(email, getApplication()));
		 if(cartListVO.getCartList()!=null){
			 cartListVO.setCount(cartListVO.getCartList().size());
			 StringBuilder  ids = new StringBuilder(",");
			 double total = 0;
			 /*for (Cart cart : cartListVO.getCartList()) {
				 if(cart.getProduct()==null) continue;
				 ids.append(cart.getProductId());
				 total = total + cart.getProduct().getSomeadditionalattr().getPrize()*cart.getQty();
			}*/
			 cartListVO.setTotal(total);
			 cartListVO.setIds(ids.substring(1));
		 }
		 }
		 return cartListVO;
	 }
	 
	 @RequestMapping( value = "/check/{productId}",method = RequestMethod.GET)
	    public  CartListVO  identifyCart(@PathVariable("productId") String productId) {
		 CartListVO cartListVO = new CartListVO();
		// db.cart.find({'productId' : 'pastries1'}).count()
		 cartListVO.setInCart(cartService.getCart( getEmail() ,getApplication(),productId));
		 
		 return cartListVO;
	 }
	 
	 @RequestMapping( value = "/count",method = RequestMethod.GET)
	 public  CartListVO  getCartCount( Locale locale,HttpServletRequest request) {
		 CartListVO cartListVO = new CartListVO();
		 String email = getEmail();
		 List cartList = cartService.getCart(email,getApplication());//query to get only count.. that would not be much long
		 cartListVO.setCartList(cartList);
		 cartListVO.setCount(cartList.size());
		 return cartListVO; 
		 
	
	 }
	 
	 @RequestMapping( value = "/{id}/{operation}",method = RequestMethod.POST)
	 public  Cart  addToCart( @PathVariable("id") String id,
			 							@PathVariable("operation") String operation,
			 								Locale locale ) {
		 String email = getEmail();
	
		 Cart cart = new Cart();
		 if("addtocart".equals(operation)){
			 cart.setId(String.valueOf((email+id).hashCode()));
			 cart.setEmail(email);
			 cart.setProductId(id);
			 cart.setQty(1);
			 cart.setAppId(getApplication());
			 cart = cartService.save(cart);
		 }else  if("remove".equals(operation)){
			 cart.setId(id);
			 cartService.delete(cart);
		 }
		 return cart;
	 }
	 
	 
	 @RequestMapping( value = "/add/{id}",method = RequestMethod.GET)
	 public  void  addQuantity( @PathVariable("id") String id) {
		 Cart cart = cartService.findById(id);
		 cart.setQty(cart.getQty() + 1);
		 cartService.save(cart);
	 }
	 
	 @RequestMapping( value = "/sub/{id}",method = RequestMethod.GET)
	 public  void  subQuantity( @PathVariable("id") String id) {
		 Cart cart = cartService.findById(id);
		 cart.setQty(cart.getQty() - 1);
		 cartService.save(cart);
	 }
	 
	 @RequestMapping( value = "/merge",method = RequestMethod.GET)
	 public  void  addCarttoUserAfterLogin() {
		 List<Cart> ls = cartService.getCart(getLocalEmail(),getApplication());
		 for (Cart cart : ls) {
			 cartService.delete(cart.getId());
			 cart.setId(null);
			 cart.setEmail(getEmail());
			 cartService.save(cart);
			 
		}
	 }
	 
	 
}
