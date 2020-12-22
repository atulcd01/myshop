<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="viewController" >


	<div style="font-size: 3px;">
		<style>
td {
	padding: 15px;
}

.pincode {
	font-weight: 500;
	font-size: 14px;
	border: none;
	outline: none;
	width: 150px;
	padding-left: 6px;
	vertical-align: middle;
}

._2tFX2Q {
	margin-top: 24px;
	border-radius: 2px 2px 0 0;
	background-color: #fff;
	border: solid 1px #f0f0f0;
	border-bottom: none;
	padding: 24px;
	color: #212121;
}

._2tFX2Q ._2OAbe2 {
	font-size: 24px;
	font-weight: 500;
	line-height: 1;
}

._2tFX2Q {
	margin-top: 24px;
	border-radius: 2px 2px 0 0;
	background-color: #fff;
	border: solid 1px #f0f0f0;
	border-bottom: none;
	padding: 24px;
	color: #212121;
}

._3jmfs- {
	
}

._3-fMoP {
	border: solid 1px #f0f0f0;
	padding: 24px;
	margin-top: -1px;
}

._2briKY {
	background-color: #fff;
}

.Lib_as {
	overflow: hidden;
	width: 200px;
	margin: 0 auto 5px 0;
}

._2XGBfy {
	padding-left: 32px;
	float: right;
}

.Pk2voS {
	text-align: center;
}

._8Uh6-B {
	float: left;
	padding-right: 32px;
}

._1GuuTl {
	font-size: 20px;
	font-weight: 400;
	color: #212121;
	padding-bottom: 10px;
}

.DQKXPi {
	font-size: 14px;
	font-weight: 400;
	line-height: 1.29;
	color: #212121;
}

button {
	font-family: Roboto, Arial, sans-serif;
	letter-spacing: 0;
}

.I6UH2U {
	border-radius: 0 0 2px 2px;
	background-color: #fff;
	border: solid 1px #f0f0f0;
	padding: 24px;
	width: 100%;
	text-align: left;
	margin-top: -1px;
	box-shadow: none;
	font-size: 16px;
	color: #2874f0;
	font-weight: 400;
}

._2AkmmA {
	display: inline-block;
	border-radius: 2px;
	color: #212121;
	padding: 10px 20px;
	font-size: 13px;
	font-weight: 500;
	transition: box-shadow 0.2s ease;
	vertical-align: super;
	background: #fff;
	cursor: pointer;
	outline: none;
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, .1);
	border: solid 1px #e0e0e0;
}

._2ixwsm {
	margin-top: 24px;
	border-radius: 2px;
	font-size: 15px;
	border: solid 1px #f0f0f0;
}

._3rm8Tk {
	padding: 24px 30px 24px 24px;
	font-size: 24px;
	font-weight: 500;
	line-height: 1.14;
	color: #212121;
	div
	{
	display
	:
	block;
}

._2ixwsm ._2MCvv7._29dsPi {
	max-height: 350px;
	overflow: hidden;
	position: relative;
}

._2ixwsm ._2MCvv7 {
	
}

._2ixwsm ._2Kp3n6 {
	border-top: solid 1px #f0f0f0;
	padding: 24px 24px 34px 24px;
	font-size: 14px;
}

._2ixwsm ._2Kp3n6 ._1KuY3T {
	padding-bottom: 16px;
}

li {
	list-style: none;
}

._2ixwsm ._2Kp3n6 ._1KuY3T .vmXPri {
	color: #878787;
	padding-right: 12px;
}

.col-3-12 {
	width: 25%;
}

.col {
	display: inline-block;
	vertical-align: top;
	width: 100%;
}

._2ixwsm ._2Kp3n6 ._1KuY3T ._3dG3ix {
	line-height: 1.4;
	color: #212121;
}

.col-9-12 {
	width: 75%;
}

._2ixwsm ._2Kp3n6 ._1KuY3T .sNqDog:last-child {
	padding-bottom: 0;
}

._2ixwsm ._2Kp3n6 ._1KuY3T .sNqDog {
	padding-bottom: 5px;
}

._2ixwsm ._2Kp3n6 .HoUsOy {
	padding-bottom: 16px;
	font-size: 20px;
	white-space: nowrap;
	line-height: 1.4;
	text-wrap: none;
}

._2ixwsm ._2V7q8b {
	border-radius: 0 0 2px 2px;
	border: none;
	padding: 24px;
	width: 100%;
	text-align: left;
	margin-top: -1px;
	box-shadow: none;
	font-size: 16px;
	color: #2874f0;
	font-weight: 400;
}

._2AkmmA:hover {
	box-shadow: 0 4px 6px 0 rgba(0, 0, 0, .12);
}

._2AkmmA {
	display: inline-block;
	border-radius: 2px;
	color: #212121;
	padding: 10px 20px;
	font-size: 13px;
	font-weight: 500;
	transition: box-shadow 0.2s ease;
	vertical-align: super;
	background: #fff;
	cursor: pointer;
	outline: none;
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, .1);
	border: solid 1px #e0e0e0;
}

._1RKpgi ._1YATKR {
	color: #2874f0;
	border: none;
	font-size: 14px;
	box-shadow: none;
	cursor: pointer;
	padding: 0;
	vertical-align: middle;
	margin-top: -2px;
}

._1RKpgi .uD4D24 {
	margin-left: 5px;
	font-weight: 500;
}

.E4FWq0 {
	margin-left: 8px;
}

._1RKpgi {
	font-size: 14px;
}

._2zwbSZ {
	margin-top: 12px;
}

li {
	list-style: none;
}

button {
	font-family: Roboto, Arial, sans-serif;
	letter-spacing: 0;
}

._1RKpgi ._3o5g5J {
	font-weight: 500;
}

.fullline {
	text-align: left;
}

.desc {
	float: left;
	margin-top: 2px;
	font-size: 14px;
	font-weight: 500;
	color: #878787;
	width: 110px;
	min-width: 110px;
	padding-right: 10px;
	position: relative;
}

.inlineimg {
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-flex-wrap: wrap;
	-ms-flex-wrap: wrap;
	flex-wrap: wrap;
}

.imgshow {
	display: -webkit-inline-flex;
	display: -ms-inline-flexbox;
	display: inline-flex;
	position: relative;
	margin: 0 16px 4px 0;
}

.fullline ._37KLG6 {
	position: relative;
}

.col-12-12 {
	width: 100%;
}

.col {
	display: inline-block;
	vertical-align: top;
	width: 100%;
}

.fullline ._2a2WU {
	margin: 16px 8px -8px -8px;
	padding: 8px;
}

#color {
	color: #878787;
}

.outbox {
	padding: 0 0 4px 0;
	border: none;
	border-bottom: solid 2px #2874f0;
	font-weight: 500;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
}

</style>


		<div class=" table-responsive">
			<div style="display: inline-block; white-space: nowrap;"></div>
			<div class=" col-sm-5" >
				<div class="productbar">
					<img class="img-fluid"
						src="http://linux.machine.com/content-service/staticimages/{{page.product.id}}/L{{page.product.id}}.jpeg" />

				</div>
				<div
					style="display: inline-block; white-space: nowrap; width: 100%;">

					<span ng-show="incart"><button type="button"
							class="buttona2c" ng-click="goToCart()">GO TO CART</button></span> <span
						ng-show="!incart"><button type="button" class="buttona2c"
							ng-click="addToCart()">ADD TO CART</button></span>

					<button type="button" class="buttonbn"
						ng-click="removeFromCart(page.product.id)">BUY NOW</button>
				</div>
			</div>
			<!-- right screen -->
			<div class=" col-sm-5" style="font-size: 14px;">
				
				<div>
					<div class="smallfont _1joEet" id="breadcrumb">
					
					</div>
					

					<!-- <div STYLE="font-family: Arial; font-size: 20px;" class="roww">
					{{page.product.name}}</div>

				<div ng-repeat="custom in page.product.addonList">
					<div STYLE="font-family: Arial; font-size: 20px;" class="roww">
						{{custom}}</div>
				</div>
				{{page.product.name}} <br>


				Table create
				<div STYLE="font-family: Arial; font-size: 15px"
					;class=" table-responsive">
					<table>
						<tr>
							<td
								STYLE="color: #878787; vertical-align: top; font-family: Roboto, Arial, sans-serif;";><b>Price</b></td>
							<td><div>{{page.product.someadditionalattr.prize}}</div></td>
						</tr>
						<tr>
							<td
								STYLE="color: #878787; vertical-align: top; font-family: Roboto, Arial, sans-serif;";><b>Color</td>
							<td>Black/White</td>
							  images in one td here
							<td colspan="2"></td>
						</tr>
						<tr>
							<td
								STYLE="color: #878787; vertical-align: top; font-family: Roboto, Arial, sans-serif;";>
								<b>Delivery</b>
							</td>
							<td STYLE="text-align: left;">
								<div class="outbox">


									<input type="text" class="pincode" name="pincode"
										placeholder="Enter Delivery Pincode" maxlength="6">

									<td colspan="2"></td>
						</tr>

					</table>
				</div>
 -->
					<!-- Table end -->

					<!-- product -->
					<style>
.bqXGTW {
	padding: 2px 7px;
	border-radius: 14px;
	font-size: 16px;
	background-color: #26a541;
	vertical-align: baseline;
}

.hGSR34 {
	line-height: normal;
	display: inline-block;
	color: #fff;
	padding: 2px 4px 2px 6px;
	border-radius: 3px;
	font-weight: 500;
	font-size: 12px;
	vertical-align: middle;
	background-color: #388e3c;
}
</style>
					<div class="_29OxBi">
						<div>
							<h1 class="_9E25nV">
								<span class="_35KyD6"
									style='font-family: Roboto, Arial, sans-serif; letter-spacing: 0;'>{{page.product.name}}
								</span>
							</h1>
						</div>

						<div class="_1uv9Cb">
							<div
								style='font-size: 28px; vertical-align: sub; font-weight: bold; font-family: Roboto, Arial, sans-serif; letter-spacing: 0;'>
								₹&nbsp;{{page.product.someadditionalattr.prize}}
								<div
									style='display: inline; margin-left: 12px; font-weight: 500; color: #ff6161;'>Hurry,
									Only a few left!</div>
							</div>
						</div>

					</div>

					<div>
						<div>
							<div>
								<div class="bqXGTW hGSR34 "
									style='font-size: 20px; padding: 2px 10px; border-radius: 14px;'>
									5<img
										src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMyIgaGVpZ2h0PSIxMiI+PHBhdGggZmlsbD0iI0ZGRiIgZD0iTTYuNSA5LjQzOWwtMy42NzQgMi4yMy45NC00LjI2LTMuMjEtMi44ODMgNC4yNTQtLjQwNEw2LjUuMTEybDEuNjkgNC4wMSA0LjI1NC40MDQtMy4yMSAyLjg4Mi45NCA0LjI2eiIvPjwvc3ZnPg=="
										class="_2lQ_WZ _3OMTVO">
								</div>
								<div
									style='font-size: 14px; display: inline; margin-left: 12px; font-weight: 500;'>99
									ratings and 100 reviews</div>
							</div>
						</div>
						<!-- <span class="_3V7-QV _55FW5e"><img height="21"
									src="//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/fa_8b4b59.png"
									class="gYMg9u _9Z7kX3"></span> -->
					</div>
				</div>

				<div>
<br>
					<div ng-repeat="specification in page.product.productSpecification">
					<div class="._3jmfs-">
						<div class="_3-fMoP _2briKY">
							<div>
								<div>
									<div class="Lib_as _2XGBfy Pk2voS"></div>
									<div>
										<div class="_1GuuTl">{{specification.name}}</div>

										<div class=".DQKXPi ">
											<p>{{specification.value}}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		<!-- <div ng-repeat="specification in page.product.productSpecification">
			<div class="row">
			  <div class="col-sm-4">{{specification.name}}</div>
			  <div class="col-sm-8">{{specification.value}}</div>
			</div>
		</div> -->
				</div>

				<button class="_2AkmmA I6UH2U">
					<span>Read More</span>
				</button>












			</div>
		</div>
		<h1 class="_9E25nV" ng-show="page.product.addonList!=null" >
								<span class="_35KyD6 ng-binding" style="font-family: Roboto, Arial, sans-serif; letter-spacing: 0;">You might be interested in
								</span>
							</h1>
		
		<table class="">
               
                <tr >
                    <td  ng-repeat="product in page.product.addonList">
                   <a href="<c:url value='/protected/view/{{product}}'/>?a=<%= request.getParameter("a")%>"  >
				   <div class="item-container">
				      <img class="icon" src="http://linux.machine.com/content-service/staticimages/{{product}}/S{{product}}.jpeg" />
				   </div>
				   </a>
                   </td>
                   
                </tr>
            </table>
		
	</div>

