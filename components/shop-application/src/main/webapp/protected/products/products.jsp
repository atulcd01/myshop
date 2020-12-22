<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="productsController" >


<div>
    
        
        

<div class="">

      <!-- Sidebar -->
      <div class="col-lg-3">

        <div class="">

          <!-- Grid row -->
          <div class="">

            <div class="col-md-6 col-lg-12 mb-5">

              <!-- Panel -->
							<div class="_1HmYoV _35HD7C col-md-6 col-lg-12 mb-5">
								<div class="bhgxx2 col-12-12">
									<div class="_1YuAuf">
										<section class="xeGmCJ D_NGuZ">
											<div class="_1iMC4O">
												<div class="D0YrLF">
													<span><h3>Filters</h3></span>
												</div>
											</div>
										</section>
										<div class="_1AsMpB">
											<section class="_3aoPnm">
												<div class="_1-5MDT">
													<span><h4>CATEGORIES</h4></span>
												</div>
												<div>
													<div class="sUG0yY" ng-click="toogleFilterElement($event)">
														<span><svg width="10" height="10"
																viewBox="0 0 16 27" xmlns="http://www.w3.org/2000/svg"
																class="_3OIXYL _3J6OLT">
																<path
																	d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
																	fill="#fff" class="_2z277k"></path></svg></span><a
															class="_3XS1AH _32ZSYo" title="Footwear"
															href="">Footwear</a>
													</div>
													<div>
														<a class="_2SvCnW" title="Women's Footwear"
															href="">Women's
															Footwear</a><a class="_2SvCnW"
															title="Kids' &amp; Infant Footwear"
															href="">Kids'
															&amp; Infant Footwear</a><a class="_2SvCnW"
															title="Men's Footwear"
															href="">Men's
															Footwear</a>
													</div>
												</div>
											</section>
										</div>
										<section class="_1MCcAi D_NGuZ">
											<div class="_1IqaqM _1iMC4O">
												<div class="_2Bzspk D0YrLF">
													<span>Price</span>
												</div>
											</div>
											<form class="range-field mt-3">

                  <input id="calculatorSlider" class="no-border" type="range" value="0" min="0" max="30">

                </form>
											<div class="_3Uy12X">
												<div class="_1qKb_B">
													<select class="fPjUPw"><option value="Min"
															class="OMc8Rd">Min</option>
														<option value="500" class="OMc8Rd">₹500</option>
														<option value="1000" class="OMc8Rd">₹1000</option>
														<option value="1500" class="OMc8Rd">₹1500</option>
														<option value="2000" class="OMc8Rd">₹2000</option>
														<option value="3000" class="OMc8Rd">₹3000</option></select>
												</div>
												<div class="_2LchWD">to</div>
												<div class="_1YoBfV">
													<select class="fPjUPw"><option value="500"
															class="OMc8Rd">₹500</option>
														<option value="1000" class="OMc8Rd">₹1000</option>
														<option value="1500" class="OMc8Rd">₹1500</option>
														<option value="2000" class="OMc8Rd">₹2000</option>
														<option value="3000" class="OMc8Rd">₹3000</option>
														<option value="Max" class="OMc8Rd">₹3000+</option></select>
												</div>
											</div>
										</section>
										<section class="_1gjf4c D_NGuZ">
											<div class="_3xglSm _1iMC4O" ng-click="toogleFilterElement($event)">
												<div class="_2yccxO D0YrLF">Brand</div>
												<svg width="16" height="27" viewBox="0 0 16 27"
													xmlns="http://www.w3.org/2000/svg" class="_3KyMh7 _2Gnm9R">
													<path
														d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
														fill="#fff" class="_1ooUW7"></path></svg>
											</div>
											<div class="_3mk-PQ">
												<div class="_36jUgy">
													<div class="-FTLnR">
														<svg width="20" height="20" viewBox="0 0 17 18"
															class="_2oWmkA" xmlns="http://www.w3.org/2000/svg">
															<g fill="#2874F1" fill-rule="evenodd">
															<path class="_2Re8ik"
																d="m11.618 9.897l4.225 4.212c.092.092.101.232.02.313l-1.465 1.46c-.081.081-.221.072-.314-.02l-4.216-4.203"></path>
															<path class="_2Re8ik"
																d="m6.486 10.901c-2.42 0-4.381-1.956-4.381-4.368 0-2.413 1.961-4.369 4.381-4.369 2.42 0 4.381 1.956 4.381 4.369 0 2.413-1.961 4.368-4.381 4.368m0-10.835c-3.582 0-6.486 2.895-6.486 6.467 0 3.572 2.904 6.467 6.486 6.467 3.582 0 6.486-2.895 6.486-6.467 0-3.572-2.904-6.467-6.486-6.467"></path></g></svg>
														<input type="text" value="" class="_3vKPvR"
															placeholder="Search Brand">
													</div>
													<div class="_4IiNRh _2mtkou" title="ADIDAS">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">ADIDAS</div>
															</div>
														</div>
													</div>
													
													
													
													
													
												</div>
												<div class="opNt-w _2Tprpw" style="display:none;">
													<span>2644 MORE</span>
												</div>
											</div>
										</section>
										<section class="_1gjf4c D_NGuZ">
											<div class="_3xglSm _1iMC4O" ng-click="toogleFilterElement($event)">
												<div class="_2yccxO D0YrLF">Customer Ratings</div>
												<svg width="16" height="27" viewBox="0 0 16 27"
													xmlns="http://www.w3.org/2000/svg" class="_3KyMh7 _2Gnm9R">
													<path
														d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
														fill="#fff" class="_1ooUW7"></path></svg>
											</div>
											<div class="_3mk-PQ">
												<div class="_36jUgy">
													<div class="_4IiNRh _2mtkou" title="4★ &amp; above">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">4★ &amp; above</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="3★ &amp; above">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">3★ &amp; above</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="2★ &amp; above">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">2★ &amp; above</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="1★ &amp; above">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">1★ &amp; above</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</section>
										<section class="_1gjf4c D_NGuZ">
											<div class="_3xglSm _1iMC4O" ng-click="toogleFilterElement($event)">
												<div class="_2yccxO D0YrLF">Color</div>
												<svg width="16" height="27" viewBox="0 0 16 27"
													xmlns="http://www.w3.org/2000/svg" class="_3KyMh7 _2Gnm9R">
													<path
														d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
														fill="#fff" class="_1ooUW7"></path></svg>
											</div>
											<div class="_3mk-PQ">
												<div class="_36jUgy">
													<div class="_4IiNRh _2mtkou" title="Beige">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">
																		<div>
																			<div class="_1mOIX_"
																				style="background: rgb(245, 245, 220);"></div>
																			<div class="_1O37ie _1GEhLw">Beige</div>
																		</div>
																	</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="Black">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">
																		<div>
																			<div class="_1mOIX_"
																				style="background: rgb(41, 36, 33);"></div>
																			<div class="_1O37ie _1GEhLw">Black</div>
																		</div>
																	</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="Blue">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">
																		<div>
																			<div class="_1mOIX_"
																				style="background: rgb(51, 161, 222);"></div>
																			<div class="_1O37ie _1GEhLw">Blue</div>
																		</div>
																	</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="Bronze">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">
																		<div>
																			<div class="_1mOIX_"
																				style="background: rgb(140, 120, 83);"></div>
																			<div class="_1O37ie _1GEhLw">Bronze</div>
																		</div>
																	</div>
															</div>
														</div>
													</div>
												
												</div>
												<div class="opNt-w _2Tprpw" style="display:none;">
													<span>21 MORE</span>
												</div>
											</div>
										</section>
										
										<section class="_1gjf4c D_NGuZ">
											<div class="_3xglSm _1iMC4O" ng-click="toogleFilterElement($event)">
												<div class="_2yccxO D0YrLF">Offers</div>
												<svg width="16" height="27" viewBox="0 0 16 27"
													xmlns="http://www.w3.org/2000/svg" class="_3KyMh7 _2Gnm9R">
													<path
														d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z"
														fill="#fff" class="_1ooUW7"></path></svg>
											</div>
											<div class="_3mk-PQ">
												<div class="_36jUgy">
													<div class="_4IiNRh _2mtkou" title="Buy More, Save More">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">Buy More, Save More</div>
															</div>
														</div>
													</div>
													<div class="_4IiNRh _2mtkou" title="Special Price">
														<div class="_2wQvxh _1WV8jE">
															<div class="_2kFyHg _2mtkou">
																<input type="checkbox" class="_3uUUD5"
																	readonly="" value="on">
																<div class="_1p7h2j"></div>
																	<div class="_1GEhLw">Special Price</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</section>
										
									</div>
								</div>
							</div>
							
            <!-- Filter by category -->
      
            <!-- Filter by rating -->

          </div>
          <!-- Grid row -->

        </div>
</div>
      </div>
      <!-- Sidebar -->

      <!-- Content -->
      <div class="col-lg-9" >

        <!-- Filter Area -->
        <div class="row" >

          <div class="col-md-12 mt-3">

           <!-- <div class="bhgxx2" style="flex-grow: 1; overflow: auto;"><div class="_3UEiDE"><div class="_1joEet"><div class="_1HEvv0"><a class="_1KHd47" href="/">Home</a><svg width="16" height="27" viewBox="0 0 16 27" xmlns="http://www.w3.org/2000/svg" class="_2XP0B_"><path d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z" fill="#fff" class="_24NaUy"></path></svg></div><div class="_1HEvv0"><a class="_1KHd47" href="/mobiles-accessories/pr?sid=tyy&amp;marketplace=FLIPKART">Mobiles &amp; Accessories</a><svg width="16" height="27" viewBox="0 0 16 27" xmlns="http://www.w3.org/2000/svg" class="_2XP0B_"><path d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z" fill="#fff" class="_24NaUy"></path></svg></div><div class="_1HEvv0"><a class="_1KHd47" href="/mobiles/pr?sid=tyy,4io&amp;marketplace=FLIPKART">Mobiles</a><svg width="16" height="27" viewBox="0 0 16 27" xmlns="http://www.w3.org/2000/svg" class="_2XP0B_"><path d="M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z" fill="#fff" class="_24NaUy"></path></svg></div></div><span class="_2yAnYN">Showing 1 – 24 of 191 results for "<span>mobiles</span>"</span><div class="_3ywJNQ"><span class="_3YmFT8">Sort By</span><div class="_1xHtJz xufquN">Relevance</div><div class="_1xHtJz">Popularity</div><div class="_1xHtJz">Price -- Low to High</div><div class="_1xHtJz">Price -- High to Low</div><div class="_1xHtJz">Newest First</div></div></div></div> -->

            <label ><div style="font-weight: inherit;
					    margin-top: 8px;
					    display: flex;
					    font-family: Roboto,Arial,sans-serif;
					    letter-spacing: 0;" >
            <h3>Showing {{3 * page.currentPage + 1}} – {{page.currentPage + 3}} of {{page.totalProduct}} results for "{{pId}}"</h3></div>
  			</label>
  			<div class="_3ywJNQ"><span class="_1xHtJz "><b>Sort By</b></span><div class="_1xHtJz xufquN">Relevance</div><div class="_1xHtJz">Popularity</div><div class="_1xHtJz">Price -- Low to High</div><div class="_1xHtJz">Price -- High to Low</div><div class="_1xHtJz">Newest First</div></div>
            <!-- Sort by -->
            <style>
       ._3ywJNQ {
			    display: -webkit-flex;
			    display: -ms-flexbox;
			    display: flex;
			    -webkit-align-content: center;
			    -ms-flex-line-pack: center;
			    align-content: center;
			}
			._1xHtJz {
			    border-bottom: 2px solid transparent;
			    display: inline-block;
			    font-weight: 500px;
			    padding: 8px 10px 4px 0;
			    letter-spacing: 0.5px;
			}
          </style>
            
          </div>
          

          <!-- <div class="col-md-8 text-right">
            <a class="btn blue darken-3 btn-sm waves-effect waves-light"><i class="fas fa-th mr-2" aria-hidden="true"></i><strong> Grid</strong></a>
            <a class="btn blue darken-3 btn-sm waves-effect waves-light"><i class="fas fa-th-list mr-2" aria-hidden="true"></i><strong>
                List</strong></a>
          </div> -->

        </div>
        <!-- Filter Area -->

        <!-- Products Grid -->
        <section class="section pt-4" style="box-shadow: 1px 1px 8px 2px rgba(0, 0, 0, .06);padding: 0px .5px 0px 15px;">

          <!-- Grid row -->
          <div class="row">

            <!-- Grid column -->
						<div data-id="ACCFYH3NCGKGAA3P" style="width: 25%; min-width: fit-content;"  ng-repeat="product in page.source" class="col-lg-4 col-md-12 mb-4">
							<div class="_3liAhj _1R0K0g"
								data-tkid="2b4b20f8-60b7-4025-9a51-515d5fdf4f19.ACCFYH3NCGKGAA3P.SEARCH">
								<a class="Zhf2z-" target="_blank" rel="noopener noreferrer"
									href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.id }}'/>?a=<%= request.getParameter("a")%>"><div>
										<div>
											<div class="_3BTv9X" style="height: 280px; width: 200px;">
												<img class="_1Nyybr  _30XEf0"
													alt="{{product.description}}"
													src="http://linux.machine.com/content-service/staticimages/{{product.id}}/S{{product.id}}.jpeg">
											</div>
										</div>
									</div>
									<div></div>
									<div class="_3gDSOa _3iGnbq">
										<div class="DsQ2eg">
											<svg xmlns="http://www.w3.org/2000/svg" class="_2oLiqr"
												width="16" height="16" viewBox="0 0 20 16">
												<path
													d="M8.695 16.682C4.06 12.382 1 9.536 1 6.065 1 3.219 3.178 1 5.95 1c1.566 0 3.069.746 4.05 1.915C10.981 1.745 12.484 1 14.05 1 16.822 1 19 3.22 19 6.065c0 3.471-3.06 6.316-7.695 10.617L10 17.897l-1.305-1.215z"
													fill="#2874F0" class="_35Y7Yo" stroke="#FFF"
													fill-rule="evenodd" opacity=".9"></path></svg>
										</div>
									</div></a><a class="_2cLu-l"
									title="iVoltaa Pixie Braided 2.4A USB Type C Cable"
									target="_blank" rel="noopener noreferrer"
									href="<c:url value='http://linux.machine.com/shop-application/protected/view/{{ product.id }}'/>?a=<%= request.getParameter("a")%>"><h3>{{product.name}}</h3></a>
								<div class="niH0FQ _36Fcw_">
									<span
										id="productRating_LSTACCFYH3NCGKGAA3PPMBXAE_ACCFYH3NCGKGAA3P_"
										class="_2_KrJI"><div class="hGSR34">
											5<img
												src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMyIgaGVpZ2h0PSIxMiI+PHBhdGggZmlsbD0iI0ZGRiIgZD0iTTYuNSA5LjQzOWwtMy42NzQgMi4yMy45NC00LjI2LTMuMjEtMi44ODMgNC4yNTQtLjQwNEw2LjUuMTEybDEuNjkgNC4wMSA0LjI1NC40MDQtMy4yMSAyLjg4Mi45NCA0LjI2eiIvPjwvc3ZnPg=="
												class="_2lQ_WZ">
										</div></span><span class="_38sUEc">(100)</span>
								</div>
								<div class="_3LWrw9">
									<img height="21"
										src="">
								</div>
								<a class="_1Vfi6u" target="_blank" rel="noopener noreferrer"
									href="/ivoltaa-pixie-braided-2-4a-usb-type-c-cable/p/itmfyh5uvvusagm8?pid=ACCFYH3NCGKGAA3P&amp;lid=LSTACCFYH3NCGKGAA3PPMBXAE&amp;marketplace=FLIPKART&amp;srno=s_1_1&amp;otracker=AS_QueryStore_OrganicAutoSuggest_1_3&amp;otracker1=AS_QueryStore_OrganicAutoSuggest_1_3&amp;fm=SEARCH&amp;iid=2b4b20f8-60b7-4025-9a51-515d5fdf4f19.ACCFYH3NCGKGAA3P.SEARCH&amp;ppt=SearchPage&amp;ppn=Search&amp;ssid=hbad18sgcg0000001558040355353&amp;qH=1c3483cdfc68b622"><div
										class="_1uv9Cb">
										<div class="_1vC4OE"><h3>₹{{product.someadditionalattr.prize}}</h3></div>
										<div class="_3auQ3N">₹0</div>
										<div class="VGWI6T">
											<span>0% off</span>
										</div>
									</div></a>
								<div class="OPF9v4">
									<span class="_1xZuAn">Offers</span><span class="_3U7997"></span>
								</div>
								<div class="_3ighFh">
									<div class="_34CFgI"></div>
									<div><!-- Cable Length:&nbsp;1 m --></div>
									<div class="_3hobaQ"></div>
								</div>
							</div>
						</div>
						<!-- Grid column -->

            
            <!-- Grid column -->

          </div>
          <!-- Grid row -->

          <!-- Grid row -->
          <div class="row justify-content-center mb-4">

            <!-- Pagination -->
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
            <!-- Pagination -->

          </div>
          <!-- Grid row -->

        </section>
        <!-- Products Grid -->

      </div>
      <!-- Content -->

    </div>

   </div>     


	
	