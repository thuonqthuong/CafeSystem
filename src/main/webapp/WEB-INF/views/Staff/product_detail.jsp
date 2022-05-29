<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>DNT Bicycle Shop</title>
<meta name="robots" content="noindex, follow" />
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='/resources/assets/images/icon.ico' />">

<!-- CSS
	============================================ -->
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/vendor/bootstrap.min.css' />">

<!-- Test -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/images/icon.ico' />">
<!-- Font Awesome CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/vendor/font.awesome.min.css' />">
<!-- Linear Icons CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/vendor/linearicons.min.css' />">
<!-- Swiper CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/plugins/swiper-bundle.min.css' />">

<!-- Animation CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/plugins/animate.min.css' />">
<!-- Jquery ui CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/plugins/jquery-ui.min.css' />">
<!-- Nice Select CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/plugins/nice-select.min.css' />">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/plugins/magnific-popup.css' />">
<!-- Main Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/style.css' />">

<base href="${pageContext.servletContext.contextPath }" />
<style type="text/css">
.zoom:hover {
	-ms-transform: scale(1.1); /* IE 9 */
	-webkit-transform: scale(1.1); /* Safari 3-8 */
	transform: scale(1.1);
}
</style>
</head>

<body>
	<header id="header" id="home">


		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="${root}/resources/homepage/index.html"><img
						src="img/logo.png" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active"><a href="#home">Trang chủ</a></li>
						<li><a href="#about">Về Chúng Tôi</a></li>
						<li><a href="#coffee">Coffee</a></li>
						<li><a href="#coffee">Thông Tin Cá Nhân</a></li>
						<li><a
							href="http://localhost:8080/CoffeeHouse/login/logout.htm">Đăng
								xuất</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>

	<!-- Breadcrumb Area End Here -->
	<!-- Single Product Main Area Start -->
	<div class="single-product-main-area">
		<div class="container container-default custom-area">
			<div class="row">
				<div class="col-lg-5 offset-lg-0 col-md-8 offset-md-2 col-custom">
					<div class="product-details-img">
						<div
							class="single-product-img swiper-container gallery-top popup-gallery">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
								<div class="swiper-slide">
									<a class="w-100"
										href="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}">
										<img class="w-100"
										src="${pageContext.request.contextPath}/resources/images/bicycle/${bicycle.image}"
										alt="Product">
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-7 col-custom">
					<div class="product-summery position-relative">
						<form:form method="GET">
							<div class="product-head mb-3">
								<h2 class="product-title">${bicycle.name}</h2>
							</div>
							<div class="price-box mb-2">
								<c:if test="${bicycle.discount==0 || bicycle.discount==null }">
									<span class="regular-price "><fmt:formatNumber
											pattern="###,### VND" value="${bicycle.price}"
											type="currency" /></span>
								</c:if>
								<c:if test="${bicycle.discount!=0 && bicycle.discount!=null }">
									<span class="regular-price "><fmt:formatNumber
											pattern="###,### VND"
											value="${bicycle.price - (bicycle.price*bicycle.discount)/100 }"
											type="currency" /> </span>
									<del>
										<span class="old-price"><fmt:formatNumber
												pattern="###,### VND" value="${bicycle.price}"
												type="currency" /></span>
									</del>
								</c:if>
							</div>
							<div class="product-rating mb-3">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star-o"></i>
							</div>
							<div class="sku mb-3">
								<span>${bicycle.views} views</span>
							</div>
							<p class="desc-content mb-5">${bicycle.contents}</p>
							<div class="quantity-with_btn mb-5">
								<div class="quantity">
									<div class="cart-plus-minus">
										<input class="cart-plus-minus-box" value="1" name="qtt"
											type="text">
										<div class="dec qtybutton">-</div>
										<div class="inc qtybutton">+</div>
									</div>
								</div>
								<div class="add-to_cart">
									<c:if test="${userLogin==null}">
										<a class="btn product-cart button-icon flosun-button dark-btn"
											href="${pageContext.request.contextPath}/pages/login.htm">Add
											to cart</a>
									</c:if>
									<c:if test="${userLogin!=null}">
										<input
											class="btn flosun-button primary-btn rounded-0 black-btn"
											type="submit"
											formaction="${pageContext.request.contextPath}/shop/cart/insert/${bicycle.id}.htm"
											value="Add to cart">
									</c:if>
									<a
										class="btn flosun-button secondary-btn secondary-border rounded-0">Add
										to wishlist</a>
								</div>
							</div>
							<div class="social-share mb-4">
								<span>Share :</span> <a href="#"><i
									class="fa fa-facebook-square facebook-color"></i></a> <a href="#"><i
									class="fa fa-twitter-square twitter-color"></i></a> <a href="#"><i
									class="fa fa-linkedin-square linkedin-color"></i></a> <a href="#"><i
									class="fa fa-pinterest-square pinterest-color"></i></a>
							</div>
							<div class="payment">
								<a href="#"><img class="border"
									src="${pageContext.request.contextPath}/resources/assets/images/payment/payment-icon.jpg"
									alt="Payment"></a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Product Area Start-->
	<div class="product-area mt-text-3">
		<div class="container custom-area-2 overflow-hidden">
			<div class="row">
				<!--Section Title Start-->
				<div class="col-12 col-custom">
					<div class="section-title text-center mb-30">
						<span class="section-title-1">The Most Trendy</span>
						<h3 class="section-title-3">Featured Products</h3>
					</div>
				</div>
				<!--Section Title End-->
			</div>
			<div class="row product-row">
				<div class="col-12 col-custom">
					<div class="product-slider swiper-container anime-element-multi">

						<div class="swiper-wrapper">
							<c:forEach var="flo" items="${TopBicycle}">
								<div class="single-item swiper-slide">
									<!--Single Product Start-->
									<div class="single-product position-relative mb-30">
										<div class="product-image">
											<a class="d-block"
												href="${pageContext.request.contextPath}/shop/product_detail/${flo.f1.id}.htm">
												<img
												src="${pageContext.request.contextPath}/resources/images/bicycle/${flo.f1.image}"
												alt="" class="product-image-1 w-100"> <img
												src="${pageContext.request.contextPath}/resources/images/bicycle/${flo.f1.image}"
												alt="" class="product-image-2 position-absolute w-100 zoom">
											</a>
											<c:if test="${flo.f1.discount!=0 && flo.f1.discount!=null }">
												<span class="onsale">-${flo.f1.discount}%</span>
											</c:if>
											<div class="add-action d-flex flex-column position-absolute">
												<a title="Compare"> <i class="lnr lnr-sync"
													data-toggle="tooltip" data-placement="left" title="Compare"></i>
												</a> <a title="Add To Wishlist"> <i class="lnr lnr-heart"
													data-toggle="tooltip" data-placement="left"
													title="Wishlist"></i>
												</a>
												<%--  <a href="#exampleModalCenter${flo.f1.id}" title="Quick View" data-toggle="modal" data-target="#exampleModalCenter${flo.f1.id}">
                                                <i class="lnr lnr-eye" data-toggle="tooltip" data-placement="left" title="Quick View"></i>
                                            </a> --%>
											</div>
										</div>
										<div class="product-content">
											<div class="product-title">
												<h4 class="title-2">
													<a
														href="${pageContext.request.contextPath}/shop/product_detail/${flo.f1.id}.htm">${flo.f1.name}</a>
												</h4>
											</div>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o"></i>
											</div>
											<div class="price-box">
												<c:if test="${flo.f1.discount==0 || flo.f1.discount==null }">
													<span class="regular-price "><fmt:formatNumber
															pattern="###,### VND" value="${flo.f1.price}"
															type="currency" /></span>
												</c:if>
												<c:if test="${flo.f1.discount!=0 && flo.f1.discount!=null }">
													<span class="regular-price "><fmt:formatNumber
															pattern="###,### VND"
															value="${flo.f1.price - (flo.f1.price*flo.f1.discount)/100 }"
															type="currency" /> </span>
													<del>
														<span class="old-price"><fmt:formatNumber
																pattern="###,### VND" value="${flo.f1.price}"
																type="currency" /></span>
													</del>
												</c:if>
											</div>
											<c:if test="${userLogin==null}">
												<a href="${pageContext.request.contextPath}/pages/login.htm"
													class="btn product-cart">Add to Cart</a>
											</c:if>
											<c:if test="${userLogin!=null}">
												<a
													href="${pageContext.request.contextPath}/shop/cart/insert/${flo.f1.id}.htm"
													class="btn product-cart">Add to Cart</a>
											</c:if>
										</div>
									</div>
									<!--Single Product End-->

									<div class="single-product position-relative mb-30">
										<div class="product-image">
											<a class="d-block"
												href="${pageContext.request.contextPath}/shop/product_detail/${flo.f2.id}.htm">
												<img
												src="${pageContext.request.contextPath}/resources/images/bicycle/${flo.f2.image}"
												alt="" class="product-image-1 w-100"> <img
												src="${pageContext.request.contextPath}/resources/images/bicycle/${flo.f2.image}"
												alt="" class="product-image-2 position-absolute w-100 zoom">
											</a>
											<c:if test="${flo.f2.discount!=0 && flo.f2.discount!=null }">
												<span class="onsale">-${flo.f2.discount}%</span>
											</c:if>
											<div class="add-action d-flex flex-column position-absolute">
												<a title="Compare"> <i class="lnr lnr-sync"
													data-toggle="tooltip" data-placement="left" title="Compare"></i>
												</a> <a title="Add To Wishlist"> <i class="lnr lnr-heart"
													data-toggle="tooltip" data-placement="left"
													title="Wishlist"></i>
												</a>
											</div>
										</div>
										<div class="product-content">
											<div class="product-title">
												<h4 class="title-2">
													<a
														href="${pageContext.request.contextPath}/shop/product_detail/${flo.f2.id}.htm">${flo.f2.name}</a>
												</h4>
											</div>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o"></i>
											</div>
											<div class="price-box">
												<c:if test="${flo.f2.discount==0 || flo.f2.discount==null }">
													<span class="regular-price "><fmt:formatNumber
															pattern="###,### VND" value="${flo.f2.price}"
															type="currency" /></span>
												</c:if>
												<c:if test="${flo.f2.discount!=0 && flo.f2.discount!=null }">
													<span class="regular-price "><fmt:formatNumber
															pattern="###,### VND"
															value="${flo.f2.price - (flo.f2.price*flo.f2.discount)/100 }"
															type="currency" /> </span>
													<del>
														<span class="old-price"><fmt:formatNumber
																pattern="###,### VND" value="${flo.f2.price}"
																type="currency" /></span>
													</del>
												</c:if>
											</div>
											<c:if test="${userLogin==null}">
												<a href="${pageContext.request.contextPath}/pages/login.htm"
													class="btn product-cart">Add to Cart</a>
											</c:if>
											<c:if test="${userLogin!=null}">
												<a
													href="${pageContext.request.contextPath}/shop/cart/insert/${flo.f2.id}.htm"
													class="btn product-cart">Add to Cart</a>
											</c:if>
										</div>
									</div>
									<!--Single Product End-->
								</div>
							</c:forEach>
						</div>







						<!-- Slider pagination -->
						<div class="swiper-pagination default-pagination"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Product Area End-->
	<footer class="footer-area section-gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>About Us</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore dolore magna aliqua.</p>
						<p class="footer-text">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="${root}/resources/homepage/https://colorlib.com"
								target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
				<div class="col-lg-5  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Newsletter</h6>
						<p>Stay update with our latest</p>
						<div class="" id="mc_embed_signup">
							<form target="_blank" novalidate="true"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="form-inline">
								<input class="form-control" name="EMAIL"
									placeholder="Enter Email" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Enter Email '" required=""
									type="email">
								<button class="click-btn btn btn-default">
									<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
								</button>
								<div style="position: absolute; left: -5000px;">
									<input name="b_36c4fd991d266f23781ded980_aefe40901a"
										tabindex="-1" value="" type="text">
								</div>

								<div class="info pt-20"></div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6 social-widget">
					<div class="single-footer-widget">
						<h6>Follow Us</h6>
						<p>Let us be social</p>
						<div class="footer-social d-flex align-items-center">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-dribbble"></i></a> <a href="#"><i
								class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- Scroll to Top Start -->
	<a class="scroll-to-top" href="#"> <i class="lnr lnr-arrow-up"></i>
	</a>
	<!-- Scroll to Top End -->

	<!-- JS
============================================ -->


	<!-- Modernizer JS -->
	<script
		src="<c:url value='/resources/assets/js/vendor/modernizr-3.7.1.min.js' />"></script>
	<!-- jQuery JS -->
	<script
		src="<c:url value='/resources/assets/js/vendor/jquery-3.5.1.min.js' />"></script>
	<!-- Bootstrap JS -->
	<script
		src="<c:url value='/resources/assets/js/vendor/bootstrap.bundle.min.js' />"></script>

	<!-- Swiper Slider JS -->
	<script
		src="<c:url value='/resources/assets/js/plugins/swiper-bundle.min.js' />"></script>
	<!-- nice select JS -->
	<script
		src="<c:url value='/resources/assets/js/plugins/nice-select.min.js' />"></script>
	<!-- Ajaxchimpt js -->
	<script
		src="<c:url value='/resources/assets/js/plugins/jquery.ajaxchimp.min.js' />"></script>
	<!-- Jquery Ui js -->
	<script
		src="<c:url value='/resources/assets/js/plugins/jquery-ui.min.js' />"></script>
	<!-- Jquery Countdown js -->
	<script
		src="<c:url value='/resources/assets/js/plugins/jquery.countdown.min.js' />"></script>
	<!-- jquery magnific popup js -->
	<script
		src="<c:url value='/resources/assets/js/plugins/jquery.magnific-popup.min.js' />"></script>

	<!-- Main JS -->
	<script src="<c:url value='/resources/assets/js/main.js' />"></script>

	<script>
		// Get all <li>
		var lis = document.getElementById('navbar_main').querySelectorAll(
				'li a');
		/*  lis.forEach((item, index) => {
		 	
		 	item.className += " active";
		     console.log({ index, item })
		   }); */
		var item = lis[1];
		item.className += " active";
	</script>
</body>

</html>