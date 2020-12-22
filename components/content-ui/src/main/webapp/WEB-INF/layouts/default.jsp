<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR" id="ng-app" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	
   <%--  <script type="text/javascript" src="<c:url value='/webjars/bootstrap/3.3.7/js/bootstrap.min.js'  />"></script> --%>
      <link rel="icon" type="image/gif/png" href="/staticimages/flipkart_f_logo_thumb.jpg">
       
        <link href="http://linux.machine.com/content-service/resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        
        <link href="http://linux.machine.com/content-service/resources/css/project_style.css" rel="stylesheet"/>
        <link href="http://linux.machine.com/content-service/resources/css/progressbar.css" rel="stylesheet"/>
        
        <script src="http://linux.machine.com/content-service/resources/js/jquery-1.9.1.min.js"></script>
        <script src="http://linux.machine.com/content-service/resources/js/angular.min.js"></script> 
        
         <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.3/angular-sanitize.js"></script> 
        
         <link href="http://linux.machine.com/content-service/resources/css/header.css" rel="stylesheet"/>
        
         <script src="http://linux.machine.com/content-service/resources/js/bootstrap.min.js"></script> 
        
         
      
         
          <link href="http://linux.machine.com/content-service/resources/css/bootstrap-responsive.min.css" rel="stylesheet"/>

        
<title><tiles:insertAttribute name="title" /></title>

</head>
<body style = 'padding: 0px;' ng-app="Application">

	<tiles:insertAttribute name="header" />
	<br />
	<br />
	<tiles:insertAttribute name="content" />
	<br />
	<br />
	<tiles:insertAttribute name="footer" />

</body>
<script src="http://linux.machine.com/content-service/resources/js/main.js"></script>
</html>