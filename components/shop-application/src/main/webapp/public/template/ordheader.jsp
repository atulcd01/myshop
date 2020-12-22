<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Flipkart like navbar - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
    
  
</head>
<body>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<div id="flipkart-navbar" ng-controller="categoryController">
    <div class="container">
        
        <div class="row row2c">
            <div class="col-sm-2">
                
                <h1 style="margin:0px;"><span class=""><a href="<c:url value='http://linux.machine.com/shop-application/protected/home' />?a=<%= request.getParameter("a")%>"><font style="color:white;white-space: nowrap;font-family:Impact, Charcoal, sans-serif;">{{brand}}</font></a></span></h1>
            </div>
            <div class="flipkart-navbar-search smallsearch col-sm-8 col-xs-11">
                <div class="row">
                    
                </div>
            </div>
            
		</div>
		
		
		
        </div>
    </div>
</div>
<div id="mySidenav" class="sidenav">
    <div class="container" style="background-color: #2874f0; padding-top: 10px;">
        <span class="sidenav-heading">Home</span>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    </div>
    <a href="#">Link</a>
    <a href="#">Link</a>
    <a href="#">Link</a>
    <a href="#">Link</a>
</div>
	<script type="text/javascript">
	function openNav() {
    document.getElementById("mySidenav").style.width = "70%";
    // document.getElementById("flipkart-navbar").style.width = "50%";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "rgba(0,0,0,0)";
}

//var myInnerHtml = document.getElementById("forloop").innerHTML;


	</script>
	<script src="http://linux.machine.com/shop-application/resources/js/pages/category.js"></script>
</body>
</html>