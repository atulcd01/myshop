<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="Application" ng-cloak>

<head>
        <title><spring:message  code="project.title" /></title>
        <link rel="icon" type="image/gif/png" href='/staticimages/flipkart_f_logo_thumb.jpg'>
       
        <link href='http://linux.machine.com/shop-application/resources/css/bootstrap.min.css' rel="stylesheet" id="bootstrap-css"/>
        
        
        
        
        
        <script src='http://linux.machine.com/shop-application/resources/js/jquery.min2.1.3.js' ></script>
        <script src='http://linux.machine.com/shop-application/resources/js/angular.min.6.js' ></script> 
        
        <script src="http://linux.machine.com/shop-application/resources/js/angular-sanitize.js"></script> 
         <link href='http://linux.machine.com/shop-application/resources/css/header.css' rel="stylesheet"/>
        
         <script src='http://linux.machine.com/shop-application/resources/js/bootstrap.min.js' ></script> 
         
          <link href='http://linux.machine.com/shop-application/resources/css/bootstrap-responsive.min.css' rel="stylesheet"/>
          
          <link href='http://linux.machine.com/shop-application/resources/css/products.css' rel="stylesheet"/> 
         <link href='http://linux.machine.com/shop-application/resources/css/project_style.css' rel="stylesheet"/>
         <link href='http://linux.machine.com/shop-application/resources/css/copied.css' rel="stylesheet"/> 
        <link href='http://linux.machine.com/shop-application/resources/css/progressbar.css' rel="stylesheet"/>
         
    </head>
    <body style = 'padding: 0px;'>
        <div  >
            <tiles:insertAttribute name="header" />

            <tiles:insertAttribute name="body" />
            
            <tiles:insertAttribute name="footer" />
        </div>

        

        
    </body>
    <script src='http://linux.machine.com/shop-application/resources/js/main.js' ></script>
</html> 