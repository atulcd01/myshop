<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Flipkart </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
    
  
</head>

	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">


<div id="flipkart-navbar" ng-controller="categoryController">
<ng-include src="'http://linux.machine.com/shop-application/resources/templates/loginModal.html'"></ng-include>
    <div class="">
        <div  class="smallnav  row1 ">
        
            <ul class="">
            <li class=" upper-links"><a class="links"  href="<c:url value='http://linux.machine.com/shop-application/protected/home'  />?a=<%= request.getParameter("a")%>">{{brand}}</a></li>
                <li class="upper-links" ng-show="!user"><b><a class="links" href="#" ng-click="showLogin()">Login and Signup</a></b></li>
                <li class="upper-links" ng-show="user"><a class="links" href="<c:url value='http://linux.machine.com/shop-application/protected/vieworder'  />?a=<%= request.getParameter("a")%>">Track Order</a></li>
                <li class="upper-links">
                    <a class="links" href="#">
                        <svg class="" width="16px" height="12px" style="overflow: visible;">
                            <path d="M8.037 17.546c1.487 0 2.417-.93 2.417-2.417H5.62c0 1.486.93 2.415 2.417 2.415m5.315-6.463v-2.97h-.005c-.044-3.266-1.67-5.46-4.337-5.98v-.81C9.01.622 8.436.05 7.735.05 7.033.05 6.46.624 6.46 1.325v.808c-2.667.52-4.294 2.716-4.338 5.98h-.005v2.972l-1.843 1.42v1.376h14.92v-1.375l-1.842-1.42z" fill="#fff"></path>
                        </svg>
                    </a>
                </li>
                <li class=" upper-links"> <a class=""  href="<c:url value='http://linux.machine.com/shop-application/protected/cart'/>?a=<%= request.getParameter("a")%>">
               <svg class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 " fill="#fff "></path>
                    </svg> 
                    <span class="item-number" style="margin-left: 0px" id="cartfacade1"> {{cartcount}}</span>
                </a></li>
                <li class="upper-links dropdown"><a class="links" href="#">${user.name}</a>
                    <ul class="dropdown-menu">
                        <li class="profile-li"><a class="profile-links" href="<c:url value='http://linux.machine.com/shop-application/protected/home'  />?a=<%= request.getParameter("a")%>" ng-click="logout()">Logout</a></li>
                    </ul>
                </li>
            </ul>
            <a class="profile-links" href="<c:url value='http://linux.machine.com/shop-application/protected/home'  />?a=<%= request.getParameter("a")%>" ng-click="logout()">Logout</a>
        </div>
        <div class="largenav row row1 container">
        
            <ul class=" pull-right">
            	<li class="upper-links" ng-show="!user"><b><a class="links" href="#" ng-click="showLogin()">Login and Signup</a></b></li>
                <li class="upper-links" ng-show="user"><a class="links" href="<c:url value='http://linux.machine.com/shop-application/protected/vieworder'  />?a=<%= request.getParameter("a")%>">Track Order</a></li>
                <li class="upper-links">
                    <a class="links" href="#">
                        <svg class="" width="16px" height="12px" style="overflow: visible;">
                            <path d="M8.037 17.546c1.487 0 2.417-.93 2.417-2.417H5.62c0 1.486.93 2.415 2.417 2.415m5.315-6.463v-2.97h-.005c-.044-3.266-1.67-5.46-4.337-5.98v-.81C9.01.622 8.436.05 7.735.05 7.033.05 6.46.624 6.46 1.325v.808c-2.667.52-4.294 2.716-4.338 5.98h-.005v2.972l-1.843 1.42v1.376h14.92v-1.375l-1.842-1.42z" fill="#fff"></path>
                        </svg>
                    </a>
                </li>
                
                <li class="upper-links dropdown"><a class="links" href="#">{{user.name}}</a>
                    <ul class="dropdown-menu">
                        <li class="profile-li"><a class="profile-links" href="<c:url value='http://linux.machine.com/shop-application/protected/home'  />?a=<%= request.getParameter("a")%>" ng-click="logout()">Logout</a></li>
                    </ul>
                </li>
            </ul>
            
        </div>
        <!-- search and cart bar -->
        <div class="container" style="display:flex;width:100%;">
        
            <div >
                
                <h1 style="margin:0px;"><span class="largenav"><a style ='no-decoration' href="<c:url value='http://linux.machine.com/shop-application/protected/home'  />?a=<%= request.getParameter("a")%>"><font style="color:white;white-space: nowrap;font-family:Impact, Charcoal, sans-serif;">{{brand}}</font></a></span></h1>
                
            </div>
            <div class="largenav ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
            
    <form class="_1WMLwI header-form-search">
	<div class="col-12-12 _2tVp4j" style="color:black">
		<div class="O8ZS_U">
			<input type="text" id="searchtext" value="" class="LM6RPg"
				title="Search for products, brands and more" name="q"
				autocomplete="off" 
				onfocus="document.getElementById('searchauto').style.display='inline'"
				onblur="document.getElementById('searchauto').style.display='none'"
				placeholder="Search for products, brands and more"
				ng-keyup="autocomplete()">
		</div>
		<button class="vh79eN" type="submit" onclick="location.href='http://linux.machine.com/shop-application/protected/products/'+document.getElementById('searchtext').value.trim()+'?a=<%= request.getParameter("a")%>'">
			<svg width="20" height="20" viewBox="0 0 17 18" class=""
				xmlns="http://www.w3.org/2000/svg">
				<g fill="#2874F1" fill-rule="evenodd">
				<path class="_2BhAHa"
					d="m11.618 9.897l4.225 4.212c.092.092.101.232.02.313l-1.465 1.46c-.081.081-.221.072-.314-.02l-4.216-4.203"></path>
				<path class="_2BhAHa"
					d="m6.486 10.901c-2.42 0-4.381-1.956-4.381-4.368 0-2.413 1.961-4.369 4.381-4.369 2.42 0 4.381 1.956 4.381 4.369 0 2.413-1.961 4.368-4.381 4.368m0-10.835c-3.582 0-6.486 2.895-6.486 6.467 0 3.572 2.904 6.467 6.486 6.467 3.582 0 6.486-2.895 6.486-6.467 0-3.572-2.904-6.467-6.486-6.467"></path></g></svg>
		</button>
		
	</div>
	<ul class="col-12-12 _1PBbw8" id="searchauto" style="cursor: pointer;" >
		<li class="_1va75j"><a class="_2ja22P" ng-repeat="category in autolist track by $index"
			ng-mousedown="search(category.parent,'<%= request.getParameter("a")%>' )"><div
					class="prZF9U">
					<div class="_3BTv9X" style="height: 32px; width: 32px;">
						<img class="_1Nyybr _20scMb  _30XEf0" alt=""
							src="https://rukminim1.flixcart.com/www/100/100/promos/19/07/2018/321e89f8-9ffa-47a7-a9d4-731da9bde6c4.png?q=90">
					</div>
				</div>
				<div class="_2kpuIQ">
					{{category.name}}
					<div class="xOS6RD">in {{category.parent}}</div>
				</div></a></li>
		
		<li class="_1va75j"><div class="">
				<div class="wAx14M hX1COa">
					<div class="hX1COa">Trending</div>
				</div>
			</div></li>
		<li class="_1va75j"><a class="_2ja22P _2Yi_mU"
			onMouseDown="location.href='http://linux.machine.com/shop-application/protected/products/cakes?a=<%= request.getParameter("a")%>'"><div
					class="prZF9U">
					<div class="_3BTv9X" style="height: 32px; width: 32px;">
						<img class="_1Nyybr _20scMb  _30XEf0" alt=""
							src="https://rukminim1.flixcart.com/www/100/100/promos/19/07/2018/cc6daa23-e09c-40d8-a4e1-ead447bf80fa.png?q=90">
					</div>
				</div>
				<div class="_2kpuIQ">cakes</div></a></li>
		
	</ul>
</form>
<div class="largenav ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>


<div class="cart largenav ">
                <a class="cart-button"  href="<c:url value='http://linux.machine.com/shop-application/protected/cart'/>?a=<%= request.getParameter("a")%>">
                    <svg class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 " fill="#fff "></path>
                    </svg> <b>CART
                    <span class="item-number" id="cartfacade"> {{cartcount}}</span></b>
                </a>
            
		</div>

</div> 
<!-- over -->
		<style scoped>
				@media screen and (min-width:1600px) {
					.on-the-fly-behavior {
						font-size: 26px;
					}
				}

			@media screen and (max-width:600px) {
				.on-the-fly-behavior {
					word-wrap: break-word;
					font-size: 9px;
					line-height: 16px;
					font-weight:bold;
				}
		}
		</style>
		<span class="on-the-fly-behavior"></span>   
              
		<!-- category menu bar  -->
		<div id="menu-wrapper">		
					<ul class="navg"  >
						<li ng-repeat="category in page.source.children" class="d-flex flex-wrap"><a
							 href="#"><div style="text-transform: uppercase;" class="on-the-fly-behavior">{{ category.name }}</div></a>
							<div class="d-flex flex-wrap" style="border: thin solid #dddbdb">
		

							 <div ng-repeat="category2 in category.children" class="navg-column">
							  <!-- ng-class="
								{'navg-column': $index== 0, 'navg-column-no': $index> 0}">
									class="p-2"--> <%--  <a href="<c:url value='http://linux.machine.com/shop-application/protected/products/{{category2.id }}?a=<%= request.getParameter("a") %>'/>" >
										<div class="bold">{{ category2.name }}</div></a>  --%>

									<ul ng-if="category2.children">
										<li ng-repeat="category3 in category2.children" style="line-height: 16px">
											<a	 ng-show="category3.css!=null" href="<c:url value='http://linux.machine.com/shop-application/protected/products/{{ category3.id }}'/>?a=<%= request.getParameter("a")%>">
													<div class="{{category3.css}}" style="white-space: nowrap;">{{
														category3.name }}</div>
											</a>
											<a	 ng-show="category3.css==null" href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ category3.id }}'/>?a=<%= request.getParameter("a")%>">
													<div class="{{category3.css}}" style="white-space: nowrap;">{{
														category3.name }}</div>
											</a>
										</li>

									</ul></div>
						</li> 
					</ul>
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
	<%-- <script src="<c:url value="http://linux.machine.com/shop-application/resources/js/pages/category.js" />"></script> --%>
</html>