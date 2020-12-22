<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="ordersController" >
    
    
 <div>
    
  <div style="padding:6px">
  <h2>All Purchase Orders</h2>
  <div >
  
   <table class="table table-bordered table-condensed table-responsive">
    <thead>
      <tr>
        <th>Order id</th>
        <th>Email</th>
        <th>Address</th>
        <th>Product id</th>
        <th>Qty</th>
        <th>Price</th>
        <th>Order Date</th>
        <th>Vendor</th>
         <th>Comments</th>
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody ng-repeat="order in page.source">
      <tr ng-repeat="x in order.orderDetails">
        <td>{{order.id}}</td>
        <td>{{order.userid}}</td>
        <td>{{order.addressId}}</td>
        <td>{{x.productId}}</td>
        <td>{{x.quantity}}</td>
        <td>{{x.price}}</td>
        <td>{{x.shipingDate}}</td>
        <td>flipkart</td>
        <td>{{x.status}}</td>
        <td nowrap>{{x.status}}</td>
        <td><button type="button" ng-click="completeTask(x)" >Process</button></td></td>
      </tr>
    </tbody>
  </table>
 <!--  <table  width="100%">
  <tr  style="border: 1px solid #ddd;height:50px; background-color:#eee" >
    
    <td colspan="4" style="padding: 10px;"><button type="button" class="buttonorder btn-primary" >Order Number {{order.id}}</button><br>{{order.userid}}</td>
    <td style="padding: 10px;"></li></td>
  </tr>
  
  
  <tr ng-repeat="x in order.orderDetails" style="border: 1px solid #ddd;height:80px;" >
  <td style="padding: 15px;"><img src="#"/></td>
  <td valign="top" style="padding: 10px;">{{x.productId}} <br> {{x.status}} </td>
  <td valign="top" style="padding: 10px;">₹{{x.price}}</td>
  <td valign="top" style="padding: 10px;">Delivery expected by Sun, Nov 12th '17 </td>
  <td valign="top" style="padding: 10px;"><button type="button" ng-click="completeTask(x)" class="buttonreturn  pull-right">Process</button></td>
  </tr>
  
	<tr  style="border: 1px solid #ddd;height:50px;" >
		<td colspan="4" style="padding: 10px;">Ordered On Thu, Nov 9th '17</td>
		<td style="padding: 10px;">Order Total ₹449</td>
	</tr>

    
  </table> -->

	</div>
        
            <div class="text-center">
                <button href="#" class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.currentPage != 0, 'disabled': page.currentPage == 0}"
                        ng-disabled="page.currentPage == 0" ng-click="changePage(0)"
                        title='<spring:message code="pagination.first"/>'
                        >
                    <spring:message code="pagination.first"/>
                </button>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.currentPage != 0, 'disabled': page.currentPage == 0}"
                        ng-disabled="page.currentPage == 0" class="btn btn-inverse"
                        ng-click="changePage(page.currentPage - 1)"
                        title='<spring:message code="pagination.back"/>'
                        >&lt;</button>
                <span>{{page.currentPage + 1}} <spring:message code="pagination.of"/> {{page.pagesCount}}</span>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.pagesCount - 1 != page.currentPage, 'disabled': page.pagesCount - 1 == page.currentPage}"
                        ng-click="changePage(page.currentPage + 1)"
                        ng-disabled="page.pagesCount - 1 == page.currentPage"
                        title='<spring:message code="pagination.next"/>'
                        >&gt;</button>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.pagesCount - 1 != page.currentPage, 'disabled': page.pagesCount - 1 == page.currentPage}"
                        ng-disabled="page.pagesCount - 1 == page.currentPage"
                        ng-click="changePage(page.pagesCount - 1)"
                        title='<spring:message code="pagination.last"/>'
                        >
                    <spring:message code="pagination.last"/>
                </button>
            </div>
   </div>     </div>

