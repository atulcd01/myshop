<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#myProgress {
  width: 100%;
  background-color: #ddd;
}

#myBar {
  width: 1%;
  height: 10px;
  background-color: #4CAF50;
}
</style>
<div class="row-fluid" ng-controller="trackOrderController" >
	<div class="container">
		<br>
		<table class="table table-bordered table-condensed table-responsive">
			<tr >
				<td>Order Details
					<table>
						<tr>
							<td>Order ID</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>{{page.order.id}}({{page.quantity}} item)</td>
						</tr>
						<tr>
							<td>Order Date</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>{{page.order.orderDate}}</td>
						</tr>
						<tr>
							<td>total Amount</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>₹{{page.total}} through Net banking</td>
						</tr>
					</table>
				<td>Address
					<table>
						<tr>
							<td>{{page.address.name}}</td>
						</tr>
						<tr>
							<td>{{page.address.address}}</td>
						</tr>
						<tr>
							<td>{{page.address.landmark}}</td>
						</tr>
						<tr>
							<td>{{page.address.country}}</td>
						</tr>
					</table>
				<td>Manage
					<table>
						<tr>
							<td>REQUEST INVOICE</td>
						</tr>
						<tr>
							<td>NEED HELP ?</td>
						</tr>
					</table>
			</tr>
		</table>
		<table class="table table-bordered" id="table">
			<tr ng-repeat="x in (page.order.orderDetails) "> <td>
			<table width="100%" class="tablenoborder" ><tr>
			<td><img  
										src="http://linux.machine.com/content-service/staticimages/{{x.productId}}/I{{x.productId}}.jpeg" /></td>
			<td>
				U&F Women's Fit and Flare Light Blue Dress<br>
				Color: Turquoise Blue
				Size: L<br>
				30 Days Exchange<br>
				Seller{{$index}}:	UniqueFashion
			</td>
			<td width="40%">
			<br><br>
			<ul class="steps"><!-- make this responsive -->
			  <li class="step step--incomplete step--active">
				<span class="step__name">Ordered</span>
			    <span class="step__icon"></span>
			    
			  </li>
			  <li class="step step--incomplete step--inactive">
			  <span class="step__name">Packed</span>
			    <span class="step__icon"></span>
			    
			  </li>
			  <li class="step step--incomplete step--inactive">
			  <span class="step__name">Shipped</span>
			    <span class="step__icon"></span>
			   
			  </li>
			  <li class="step step--incomplete step--inactive">
			  <span class="step__name">Delivered</span>
			    <span class="step__icon"></span>
			    
			  </li>
			</ul>
			
			</td>
			<td>
			₹377   6 Offers Applied<br>

			RATE & REVIEW PRODUCT
			
			</td>
			
			</tr>
			
			<tr><td style=" border-top: 1px solid #ddd;" colspan="4">Delivered on Tue, Jul 25th '17</td></tr>
				</tr></table></td>
				</tr>
		</table>

	</div>

</div>


<script>

$(document).on("click", ".steps .step--active", function() {
	 
	 $(this).removeClass('step--incomplete').addClass('step--complete');
	  $(this).removeClass('step--active').addClass('step--inactive');
	  $(this).next().removeClass('step--inactive').addClass('step--active');
	});
	
window.setTimeout(function(){
	var order = angular.element(document.getElementById('table')).scope().page.order.orderDetails;
	//alert(JSON.stringify(order));
    angular.forEach(order ,function(value,index){
    	//alert(JSON.stringify(value));
    	if(value.step>1)
    	window.setTimeout(function(){$('.steps .step--active')[index].click();}, 700);
    	if(value.step>2)
    	window.setTimeout(function(){$('.steps .step--active')[index].click();}, 1000);
    	if(value.step>3)
    	window.setTimeout(function(){$('.steps .step--active')[index].click();}, 1500);
     });
	
	}, 400);

 </script>


