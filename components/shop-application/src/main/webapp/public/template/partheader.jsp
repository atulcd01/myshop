<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="row-fluid" >
   
  <div class="row-fluid">
    <div class="span6">
       <a href="<c:url value='http://linux.machine.com/shop-application/protected/home' />">Online Shoping</a>
    </div>
    <div class="span6">
        <div class="pull-right">

            <a href="<c:url value='/' />" title='<spring:message code="header.logout"/>'><spring:message code="header.logout"/>&nbsp;${user.name}</a>
           
             
        </div>
    </div>
</div>
  
  
  
  
</div>

<script src="<c:url value="http://linux.machine.com/shop-application/resources/js/pages/category.js" />"></script>