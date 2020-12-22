<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="cartController" >
   <style>
   .table{
   /* border: 1pt solid #ddd !important; */
   margin-top:5px;
   box-shadow: 1px 1px 8px 2px rgba(0, 0, 0, .06);padding: 0px .5px 0px 15px;
   
   }
   .table th, .table td { 
 
    border-bottom: 1pt solid #ddd !important;
 }
 .no-border {
    border: 0;
    box-shadow: none; /* You may want to include this as bootstrap applies these styles too */
    
}
.no-bordertd{
	border:0;
}

.divqty .inputdiv {
    display: inline-block;
    padding: 3px 6px;
    width: calc(100% - 60px);
    height: 100%;
    width: 46px;
    height: 28px;
    border-radius: 2px;
    background-color: #fff;
    border: 1px solid #c2c2c2;
    margin: 0 9px;
}

.divqty .inputdiv .inputstyle {
    border: none;
    width: 100%;
    font-size: 14px;
    font-weight: 500;
    vertical-align: middle;
    text-align: center;
}

.divqty .buttonqty {
    width: 28px;
    height: 28px;
    background: linear-gradient(#fff, #f9f9f9);
    display: inline-block;
    border: 1px solid #c2c2c2;
    cursor: pointer;
    font-size: 16px;
    border-radius: 50%;
    padding-top: 1px;
    line-height: 1;
}

.hideobject{display:none;}

.txtshow{
	font-size: 16px;
	padding-top: 5px;
    text-align: center;
    display: inline-block;
    font-weight: 500;
    color:blue;
}

   </style> 
    
 <div>
    
  <div >
  <form><br><br>
  <div class="table-responsive" style="border:none">
  	<div class=" col-sm-8">
	<h1 style="font-size:auto;" ng-show="count==0">No Cart Is Available..  </h1> 
	
  	 
            <table class="table " border="0" id="cartTable" ng-hide="count==0">
               
               <thead>
                <tr>
                    <th colspan="2"><h2>My Cart ({{count}})</h2></th>
       				<th  align="right"><input type="text" value="421202" size="6" class="no-border"><a href="#" text-align="right">Change</a></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="product in page.source">
						<td width="15%" ><a	href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.productId }}'/>?a=<%= request.getParameter("a")%>">
								<div  class="item-container" style="height:100px">
									<img  
										src="http://linux.machine.com/content-service/staticimages/{{product.productId}}/I{{product.productId}}.jpeg" />
									
								</div>
						</a>
						<div class="divqty">
						<button class="buttonqty" ng-click="showSubTotal(product,page,product.product.someadditionalattr.prize);" ng-disabled="product.qty == 1"> – </button>
						 <div class="inputdiv"><input type="text" value="{{ product.qty }}" class="inputstyle">
						</div> 
						
						<button class="buttonqty" ng-click="showAddTotal(product,page,product.product.someadditionalattr.prize)"> + </button>
						</div>
						</td>
						
						<td width="50%">
                   			<a	class="_325-ji _3ROAwx" href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.productId }}'/>?a=<%= request.getParameter("a")%>">
                   			{{product.product.name}}
                   			</a>
                   			
                   			
                   			</b><br>
							<div class="smallfont"> Sony CP-ABC150/BCWW 2 in 1 USB Type C Cable,Compatible with Mobile Phone, Tablet, Desktop, Black, Sync and Charge Cable </div>
							<div class="smallfont">Seller: ANANDSAREES</div>
							<span class="pMSy0p XU9vZa">₹{{ product.product.someadditionalattr.prize }}</span>
							<span class="pMSy0p LYRnr_">₹690</span>
							<span class="hMGTLH">49% Off</span>
							<div class="c8yCDe" id="offers-LSTACCF9YQHHYSPSSYNWUOZQP"><span>2 Offers Available</span><svg width="14" height="14" xmlns="http://www.w3.org/2000/svg" class="_3p6_km"><g fill="none"><path d="M-1-1h16v16H-1"></path><path d="M7 0C3.136 0 0 3.136 0 7s3.136 7 7 7 7-3.136 7-7-3.136-7-7-7zm.7 10.5H6.3V6.3h1.4v4.2zm0-5.6H6.3V3.5h1.4v1.4z" fill="#388e3c" class=""></path></g></svg></div>
						<a  class="gdUKd9" ng-click="removeFromCart(product.id,$index)">REMOVE</a>
                  		 </td>
                   		
                   		<td width="25%">Free delivery by Fri, Dec 1</td>
                   		
                   		
                   
                   
                </tr>
                <tr>
					<td colspan="3" width="100%" align="right">
						 <a class="_2AkmmA _14O7kc mrmU5i" style="text-decoration:none;" href="http://linux.machine.com/shop-application/protected/home?a=<%= request.getParameter("a")%>">
						<span>Continue shopping</span></a>
						<a class="_2AkmmA _14O7kc mrmU5i" style="text-decoration:none;background-color: #fb641b;color:white;" href="<c:url value='http://linux.machine.com/shop-application/protected/order' />?a=<%= request.getParameter("a")%>">
						<span  >Place Order</span></a>
					</td>
				</tr>
                </tbody>
                
	            </table>
	          <!--  </div> -->  
	            </div>
	            <div class=" col-sm-3" ng-hide="count==0">
	           <!--   <div ng-class="{'hideobject': count==0}">-->
					<!--  <h2 class="txtshow">No Cart Is Available..  </h2>-->
						<table class="table ">
							<tr>
								<td colspan="3">PRICE DETAILS</td>
							</tr>
							<tr>
								<td colspan="2">Price ({{count}} items)<br>
								
								<br>Delivery Charges<br>
								
								<br>
								<b>Amount Payable</b></td>
								<td>₹{{total}}<br>
								
								<br><font color="green">FREE</font><br>
								
								<br>
								<b>₹{{total}}</b></td>
							</tr>
							
							<tr>
								<td colspan="3"><font color="green">Your Total
										Savings on this order ₹{{total}}</font></td>
							</tr>
						</table>
						<!--  </div>-->
					</div>
    </div>
    
	</div>
	</form>
	
	
	
	
		</div>     </div></div>
		
		
		
		
		

