<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <style>
 .row4 {
    /* margin-right: -15px; */
    /* margin-left: -15px; */
    text-align:center;
}
.row_flex {
    /* display: -webkit-flex; */
    display: -ms-flexbox;
    display: flex;
    -webkit-flex-flow: row wrap;
    -ms-flex-flow: row wrap;
    flex-flow: row wrap;
}
 </style>
 <div style=" margin-bottom: 0px;margin-top: 10px;" ng-controller="categoryController">
	<div class="TW4owM">
		<div class="row4">
			<div class="col gu12 _2-C188"></div>
		</div>
		<div class="row4">
			<div class="col gu12 gY-jFd">
				<!-- <div class="_2G8BHl text-left">
					<span> <span>Top Stories</span> : <a class="_1DLn60"
						href="/brands"><span>Brand Directory</span></a></span>
				</div> -->
				<div>
					<div class="_1XtOOW">
						<div style="text-align:left">
							MOST SEARCHED :
							<!-- -->
							<a class="_1DLn60 _2vZ4m7" ng-repeat="product in page.sourcelist" ng-if="product.someadditionalattr!=null"
								href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.id }}'/>?a=<%= request.getParameter("a")%>">
								<!-- -->{{product.name}}
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="background-color: #172337;">

			<div class="_2NHqR1 row_flex">
				
				<div class="_3qd5C5">
					<div class="_18wTSA">SOCIAL</div>
					<a href="https://www.facebook.com/shop" class="_287FRX">Facebook</a><a
						href="https://www.twitter.com/shop" class="_287FRX">Twitter</a><a
						href="https://www.youtube.com/shop" class="_287FRX">YouTube</a>
				</div>
				<div class="_3qd5C5 address" style="display:none">
					<div class="_38DIp6">
						<div class="_18wTSA">
							<span>Mail Us:</span>
						</div>
						<div class="_2V3TtE">
							<div class="_3Lv0nZ">
								<div class="_3aS5mM _2V3TtE">
									<p>Shop Internet Pvt Ltd Block B (Begonia),</p>
									<p>Ground Floor, Embassy Tech Village,</p>
									<p>Outer Ring Road, Devarabeesanahalli Village,</p>
									<p>Varthur Hobli, Bengaluru East Taluk,</p>
									<p>Bengaluru District,</p>
									<p>Karnataka, India, 560103.</p>
								</div>
							</div>
						</div>
					</div>
				</div> 
				<div class="_3qd5C5 address" style="display:none">
					<div class="m6ABEi">
						<div class="_18wTSA">
							<span>Registered Office Address:</span>
						</div>
						<div class="_2V3TtE">
							<div class="_3Lv0nZ">
								<div class="_3aS5mM _2V3TtE">
									<p>Shop Internet Private Limited,</p>
									<p>Vaishnavi Summit, Ground Floor, 7th Main,</p>
									<p>80 Feet Road, 3rd Block,</p>
									<p>Koramangala,</p>
									<p>Bengaluru - 560034</p>
									<p>India</p>
									<p>CIN : U51109KA2012PTC066107</p>
									<p>
										Telephone: <a href="tel:18002089898">1800 208 9898</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="_1DXv5h">
					<div>
						<img
							src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNiIgaGVpZ2h0PSIxNSIgdmlld0JveD0iMCAwIDE2IDE1Ij4KICAgIDxkZWZzPgogICAgICAgIDxsaW5lYXJHcmFkaWVudCBpZD0iYSIgeDE9IjAlIiB4Mj0iODYuODc2JSIgeTE9IjAlIiB5Mj0iODAuMjAyJSI+CiAgICAgICAgICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNGRkQ4MDAiLz4KICAgICAgICAgICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjRkZBRjAwIi8+CiAgICAgICAgPC9saW5lYXJHcmFkaWVudD4KICAgIDwvZGVmcz4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTS0yLTJoMjB2MjBILTJ6Ii8+CiAgICAgICAgPHBhdGggZmlsbD0idXJsKCNhKSIgZmlsbC1ydWxlPSJub256ZXJvIiBkPSJNMTUuOTMgNS42MTRoLTIuOTQ4VjQuMTRjMC0uODE4LS42NTUtMS40NzMtMS40NzMtMS40NzNIOC41NmMtLjgxNyAwLTEuNDczLjY1NS0xLjQ3MyAxLjQ3M3YxLjQ3NEg0LjE0Yy0uODE4IDAtMS40NjYuNjU2LTEuNDY2IDEuNDc0bC0uMDA3IDguMTA1YzAgLjgxOC42NTUgMS40NzQgMS40NzMgMS40NzRoMTEuNzljLjgxOCAwIDEuNDc0LS42NTYgMS40NzQtMS40NzRWNy4wODhjMC0uODE4LS42NTYtMS40NzQtMS40NzQtMS40NzR6bS00LjQyMSAwSDguNTZWNC4xNGgyLjk0OHYxLjQ3NHoiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0yIC0yKSIvPgogICAgPC9nPgo8L3N2Zz4K"><a
							href="http://35.237.16.145:8081/category/?a=1"><span
							class="_1Dwg_s">Sell On Shop</span></a>
					</div>
					<div>
						<img
							src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNSIgaGVpZ2h0PSIxNSIgdmlld0JveD0iMCAwIDE1IDE1Ij4KICAgIDxkZWZzPgogICAgICAgIDxsaW5lYXJHcmFkaWVudCBpZD0iYSIgeDE9IjAlIiB4Mj0iODYuODc2JSIgeTE9IjAlIiB5Mj0iODAuMjAyJSI+CiAgICAgICAgICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNGRkQ4MDAiLz4KICAgICAgICAgICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjRkZBRjAwIi8+CiAgICAgICAgPC9saW5lYXJHcmFkaWVudD4KICAgIDwvZGVmcz4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTS0zLTNoMjB2MjBILTN6Ii8+CiAgICAgICAgPHBhdGggZmlsbD0idXJsKCNhKSIgZmlsbC1ydWxlPSJub256ZXJvIiBkPSJNMTAuNDkyIDNDNi4zNTMgMyAzIDYuMzYgMyAxMC41YzAgNC4xNCAzLjM1MyA3LjUgNy40OTIgNy41QzE0LjY0IDE4IDE4IDE0LjY0IDE4IDEwLjUgMTggNi4zNiAxNC42NCAzIDEwLjQ5MiAzem0zLjE4IDEyTDEwLjUgMTMuMDg4IDcuMzI3IDE1bC44NC0zLjYwN0w1LjM3IDguOTdsMy42OS0uMzE1TDEwLjUgNS4yNWwxLjQ0IDMuMzk4IDMuNjkuMzE1LTIuNzk4IDIuNDIyLjg0IDMuNjE1eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMgLTMpIi8+CiAgICA8L2c+Cjwvc3ZnPgo="><a
							href="https://brands.shop.com"><span class="_1Dwg_s">Advertise</span></a>
					</div>
					<div>
						<img
							src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxOCIgaGVpZ2h0PSIxNyIgdmlld0JveD0iMCAwIDE4IDE3Ij4KICAgIDxkZWZzPgogICAgICAgIDxsaW5lYXJHcmFkaWVudCBpZD0iYSIgeDE9IjAlIiB4Mj0iODYuODc2JSIgeTE9IjAlIiB5Mj0iODAuMjAyJSI+CiAgICAgICAgICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNGRkQ4MDAiLz4KICAgICAgICAgICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjRkZBRjAwIi8+CiAgICAgICAgPC9saW5lYXJHcmFkaWVudD4KICAgIDwvZGVmcz4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTS0xLTFoMjB2MjBILTF6Ii8+CiAgICAgICAgPHBhdGggZmlsbD0idXJsKCNhKSIgZmlsbC1ydWxlPSJub256ZXJvIiBkPSJNMTYuNjY3IDVIMTQuODVjLjA5Mi0uMjU4LjE1LS41NDIuMTUtLjgzM2EyLjQ5NyAyLjQ5NyAwIDAgMC00LjU4My0xLjM3NUwxMCAzLjM1bC0uNDE3LS41NjdBMi41MSAyLjUxIDAgMCAwIDcuNSAxLjY2N2EyLjQ5NyAyLjQ5NyAwIDAgMC0yLjUgMi41YzAgLjI5MS4wNTguNTc1LjE1LjgzM0gzLjMzM2MtLjkyNSAwLTEuNjU4Ljc0Mi0xLjY1OCAxLjY2N2wtLjAwOCA5LjE2NkExLjY2IDEuNjYgMCAwIDAgMy4zMzMgMTcuNWgxMy4zMzRhMS42NiAxLjY2IDAgMCAwIDEuNjY2LTEuNjY3VjYuNjY3QTEuNjYgMS42NiAwIDAgMCAxNi42NjcgNXptMCA2LjY2N0gzLjMzM3YtNWg0LjIzNEw1LjgzMyA5LjAyNWwxLjM1Ljk3NSAxLjk4NC0yLjdMMTAgNi4xNjdsLjgzMyAxLjEzMyAxLjk4NCAyLjcgMS4zNS0uOTc1LTEuNzM0LTIuMzU4aDQuMjM0djV6IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMSAtMSkiLz4KICAgIDwvZz4KPC9zdmc+Cg=="><a
							href="/account/giftcard?otracker=undefined_footer_footer_navlinks"><span
							class="_1Dwg_s">Gift Cards</span></a>
					</div>
					<div>
						<img
							src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNSIgaGVpZ2h0PSIxNSIgdmlld0JveD0iMCAwIDE1IDE1Ij4KICAgIDxkZWZzPgogICAgICAgIDxsaW5lYXJHcmFkaWVudCBpZD0iYSIgeDE9IjAlIiB4Mj0iODYuODc2JSIgeTE9IjAlIiB5Mj0iODAuMjAyJSI+CiAgICAgICAgICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNGRkQ4MDAiLz4KICAgICAgICAgICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjRkZBRjAwIi8+CiAgICAgICAgPC9saW5lYXJHcmFkaWVudD4KICAgIDwvZGVmcz4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTS0yLTNoMjB2MjBILTJ6Ii8+CiAgICAgICAgPHBhdGggZmlsbD0idXJsKCNhKSIgZmlsbC1ydWxlPSJub256ZXJvIiBkPSJNOS41IDNDNS4zNiAzIDIgNi4zNiAyIDEwLjUgMiAxNC42NCA1LjM2IDE4IDkuNSAxOGM0LjE0IDAgNy41LTMuMzYgNy41LTcuNUMxNyA2LjM2IDEzLjY0IDMgOS41IDN6bS43NSAxMi43NWgtMS41di0xLjVoMS41djEuNXptMS41NTMtNS44MTNsLS42NzYuNjljLS41NC41NDgtLjg3Ny45OTgtLjg3NyAyLjEyM2gtMS41di0uMzc1YzAtLjgyNS4zMzgtMS41NzUuODc3LTIuMTIzbC45My0uOTQ1Yy4yNzgtLjI3LjQ0My0uNjQ1LjQ0My0xLjA1NyAwLS44MjUtLjY3NS0xLjUtMS41LTEuNVM4IDcuNDI1IDggOC4yNUg2LjVhMyAzIDAgMSAxIDYgMGMwIC42Ni0uMjcgMS4yNi0uNjk3IDEuNjg4eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTIgLTMpIi8+CiAgICA8L2c+Cjwvc3ZnPgo="><a
							href="/helpcentre?otracker=undefined_footer_footer_navlinks"><span
							class="_1Dwg_s">Help Center</span></a>
					</div>
					<span class="_2tFDQF">© 2007-<!-- -->2019<!-- --> <span>Shop.com.</span></span>
					<!-- <img src="//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/payment-method_2dd397.svg"> -->
				</div>
			</div>
		</div>
	</div>
</div>
<script src="http://linux.machine.com/shop-application/resources/js/pages/category.js"></script>	
<script src="http://linux.machine.com/shop-application/resources/js/pages/products.js" ></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/viewPage.js"></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/cart.js"></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/processorder.js" ></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/vieworder.js"></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/trackorder.js" ></script>
<script src="http://linux.machine.com/shop-application/resources/js/pages/order.js" ></script>