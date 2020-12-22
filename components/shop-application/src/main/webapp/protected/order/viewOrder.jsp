<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="ordersViewController" >
    
    
 <div>
    
  <div class="container">
  <h2>My Order</h2>
  <div ng-repeat="order in page.source">
  <table  width="100%" class="table-responsive">
  <tr  style="border: 1px solid #ddd;height:50px; background-color:#eee" >
    
    <td colspan="2" style="padding: 10px;"><button type="button" class="buttonorder btn-primary" >Order Number {{order.id}}</button></td>
    <td style="padding: 10px;"><button type="button" class="buttonreturn pull-right"  ng-click="trackOrder('/protected/trackorder/'+order.id+'?a=<%= request.getParameter("a")%>')">Track</button></li></td>
  </tr>
  
  
  <tr ng-repeat="x in order.orderDetails" style="border: 1px solid #ddd;height:80px;" >
  <td style="padding: 15px;"><img src="http://linux.machine.com/content-service/staticimages/{{x.productId}}/I{{x.productId}}.jpeg"></td>
  <td valign="top" style="padding: 10px;">{{x.productName}} ₹{{x.price}} Delivery expected by Sun, Nov 12th '17</td>
  <!-- <td valign="top" style="padding: 10px;">₹{{x.price}}</td>
  <td valign="top" style="padding: 10px;">Delivery expected by Sun, Nov 12th '17 </td> -->
  <td valign="top" style="padding: 10px;"><button type="button" class="buttonreturn  pull-right">Return</button></td>
  </tr>
  
	<tr  style="border: 1px solid #ddd;height:50px;" >
		<td colspan="2" style="padding: 10px;">Ordered On Thu, Nov 9th '17</td>
		<td style="padding: 10px;">Order Total ₹449</td>
	</tr>

    
  </table>
<br><br>
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

