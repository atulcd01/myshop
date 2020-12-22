
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




    
    
<div style="width:100%" ng-controller="categoryController">
       
<!-- https://hemelcreativeprint.co.uk/wp-content/uploads/2015/11/plaques-and-signs1-1680x280.jpg
https://hemelcreativeprint.co.uk/wp-content/uploads/2015/11/artwork-guidelines-1680x280.jpg
 -->
  <div id="myCarousel" class="carousel slide" style="width:100%; top-padding:1px;" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="http://linux.machine.com/content-service/staticimages/<%= request.getParameter("a")%>/slideone.jpeg" alt="Los Angeles" style="width:100%; min-height:150px;">
      </div>

      <div class="item">
        <img src="http://linux.machine.com/content-service/staticimages/<%= request.getParameter("a")%>/slidetwo.jpeg" alt="Chicago" style="width:100%;min-height:150px;">
      </div>
    
      <div class="item">
        <img src="http://linux.machine.com/content-service/staticimages/<%= request.getParameter("a")%>/slidethree.jpeg" alt="New york" style="width:100%;min-height:150px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" data-target="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" data-target="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>



<!-- from flipkart start-->

	<div class="bhgxx2 col-12-12" style="padding: 0px 0px 10px 0px">
		<div class="_1GRhLX _3NTa49 required-tracking"
			data-tkid="R:s;p:STIF648WKXR9HQ4J;pt:hp;uid:51869e3a-7c0f-173e-2210-64e512146558;">
			<div class="_2WNbFM">
				<div class="_2E1Y7K">
					<h2 class="Ul-VjD">You May Like</h2>
					<h3 class="_32I3ms">Based on Your Activity</h3>
				</div>
				<div class="_2rQIn7">
					<a class="_2AkmmA _1eFTEo"
						href="/products-list/you-may-like?screen=dynamic&amp;pk=stores%3Darb%2Fyod%2Fsi0%2F~pIds%3DSTIF648WKXR9HQ4J%2CSTIEGS8QBFWZCKYX%2CSTIE4VR5GAG3YQHB~marketplace%3DFLIPKART~widgetType%3DproductCard~contentType%3DpersonalisedRecommendation%2Fp2p-same&amp;marketplace=FLIPKART&amp;wid=7.productCard.PMU_V2_5"><span>VIEW
							ALL</span></a>
				</div>
			</div>
			<div class="required-tracking" data-tracking-id="You May Like">
				<div class="_3BEcOp" >
					<div class="EstLIe" >
						<div class="_2NTrR2" style="transform: translateX(-0px);">
							<div class="_2kSfQ4" style="width: 220px" ng-repeat="product in page.sourcelist" ng-if="product.someadditionalattr!=null">
								<div class="_1CzqlW">
									<div class="_3liAhj _2Vsm67"
										data-tkid="R:s;p:STIF648WKXR9HQ4J;pt:hp;uid:51869e3a-7c0f-173e-2210-64e512146558;.STIEFZV3SY6FHFFA.LSTSTIEFZV3SY6FHFFAM318O4">
										<a class="Zhf2z-"
											title="{{product.name}}"
											 rel="noopener noreferrer"
											href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.id }}'/>?a=<%= request.getParameter("a")%>"><div
												class="_8Vcv_L">
												<div>
													<div class="_3BTv9X" style="height: 150px; width: 150px">
														<img class="_1Nyybr _30XEf0"
															alt="{{product.name}}"
															src="http://linux.machine.com/content-service/staticimages/{{product.id}}/S{{product.id}}.jpeg">
													</div>
												</div>
											</div></a>
										<div>
											<div>
												<a title="{{product.name}}"
													class="_2cLu-l"  rel="noopener noreferrer"
													href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.id }}'/>?a=<%= request.getParameter("a")%>">
													{{product.name}}</a>
											</div>
											<div class="niH0FQ _36Fcw_">
												<span
													id="productRating_LSTSTIEFZV3SY6FHFFAM318O4_STIEFZV3SY6FHFFA_"
													class="_2_KrJI"><div class="hGSR34">
														4.1<img
															src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMyIgaGVpZ2h0PSIxMiI+PHBhdGggZmlsbD0iI0ZGRiIgZD0iTTYuNSA5LjQzOWwtMy42NzQgMi4yMy45NC00LjI2LTMuMjEtMi44ODMgNC4yNTQtLjQwNEw2LjUuMTEybDEuNjkgNC4wMSA0LjI1NC40MDQtMy4yMSAyLjg4Mi45NCA0LjI2eiIvPjwvc3ZnPg=="
															class="_2lQ_WZ">
													</div></span><span class="_38sUEc">(57,687)</span>
											</div>
											<div class="_1Vfi6u">
												<div class="_1uv9Cb">
													<div class="_1vC4OE">₹{{product.someadditionalattr.prize}}</div>
													<div class="_3auQ3N">
														₹
														<!-- -->
														799
													</div>
													<div class="VGWI6T">
														<span>81% off</span>
													</div>
												</div>
											</div>
										</div>
										<div class="_3gDSOa _3iGnbq">
											<div class="DsQ2eg">
												<svg xmlns="http://www.w3.org/2000/svg" class="_2oLiqr"
													width="16" height="16" viewBox="0 0 20 16">
													<path
														d="M8.695 16.682C4.06 12.382 1 9.536 1 6.065 1 3.219 3.178 1 5.95 1c1.566 0 3.069.746 4.05 1.915C10.981 1.745 12.484 1 14.05 1 16.822 1 19 3.22 19 6.065c0 3.471-3.06 6.316-7.695 10.617L10 17.897l-1.305-1.215z"
														fill="#2874F0" class="_35Y7Yo" stroke="#FFF"
														fill-rule="evenodd" opacity=".9"></path></svg>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							</div>
					</div>
					<div class="_2AEDbQ _1WxWr5 leftLst">
						<svg width="14.6" height="24" viewBox="0 0 16 27"
							xmlns="http://www.w3.org/2000/svg" class="">
							<path
								d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
								fill="#fff" class="_32EAsf"></path></svg>
					</div>
					<div class="_2AEDbQ _1V02gy rightLst">
						<svg width="14.6" height="24" viewBox="0 0 16 27"
							xmlns="http://www.w3.org/2000/svg" class="Hfq2pU">
							<path
								d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
								fill="#fff" class="_32EAsf"></path></svg>
					</div>
				</div>
			</div>
		</div>
	</div>
	
							
							
		
		<!-- start -->					
		<style>
    	.MultiCarousel .leftLst { left:0; }
    	.MultiCarousel .rightLst { right:0; }
        .MultiCarousel .leftLst.over, .MultiCarousel .rightLst.over { pointer-events: none; background:#ccc; }
		</style>	
				
	<script >
	$(document).ready(function () {
	    var itemsMainDiv = ('.MultiCarousel');
	    var itemsDiv = ('.MultiCarousel-inner');
	    var itemWidth = "";

	    $('.leftLst, .rightLst').click(function () {
	        var condition = $(this).hasClass("leftLst");
	        if (condition)
	            click(0, this);
	        else
	            click(1, this)
	    });
	    
	    //It is used to get some elements from btn
	    function click(e, ee) {
	        //var Parent = "#" + $(ee).parent().siblings().first().children().first().css('transform', 'translateX(' + -translateXval + 'px)');
	       // alert(ell)
	        var divStyle = $(ee).siblings().first().children().first().css('transform');
	        var values = divStyle.match(/-?[\d\.]+/g);
	        var xds = Math.abs(values[4]);
	       // alert(xds);
	       
	       
	        var s=1;
	        var itemWidth = 220;
	        var translateXval = 0;
	        if (e == 0) {
		        translateXval = parseInt(xds) - parseInt(itemWidth * s);
		        if (translateXval <= itemWidth / 2) {
	                translateXval = 0;
		        }
	        }
	        else if (e == 1) {
	        	var itemsCondition = parseInt($(ee).siblings().first().children().first().width() - $(ee).width())  ;
	        	
	        	 translateXval = parseInt(xds) + parseInt(itemWidth * s);
	        	 //alert(itemsCondition + ' > ' + translateXval )
	        	 if (translateXval >= itemsCondition) {
	        		 alert(itemsCondition + ' > ' + translateXval )
		                translateXval = itemsCondition;
	        	 }
	        }
	        $(ee).siblings().first().children().first().css('transform', 'translateX(' + -translateXval + 'px)');
	    }

	});
	
	
	</script>
					
    </div>
