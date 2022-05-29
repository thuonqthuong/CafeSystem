<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<c:set var="root" value="${pageContext.servletContext.contextPath}" />
<head>
<style type="text/css">
.float-left {
	float: left;
	width: 30px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script data-require="jquery@3.1.1" data-semver="3.1.1"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="${root}/resources/Staff/style.css" />
<script src="${root}/resources/Staff/script.js"></script>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="${root}/resources/homepage/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="codepixer">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Coffee</title>

<link
	href="${root}/resources/homepage/https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="resources/assets/css/vendor/bootstrap.min.css">
<!-- Test -->
<link rel="stylesheet" href="${root}resources/assets/images/icon.ico">
<!-- Font Awesome CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/vendor/font.awesome.min.css">
<!-- Linear Icons CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/vendor/linearicons.min.css">
<!-- Swiper CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/plugins/swiper-bundle.min.css">

<!-- Animation CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/plugins/animate.min.css">
<!-- Jquery ui CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/plugins/jquery-ui.min.css">
<!-- Nice Select CSS -->
<link rel="stylesheet"
	href="${root}resources/assets/css/plugins/nice-select.min.css">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${root}resources/assets/css/plugins/magnific-popup.css">
<!-- Main Style CSS -->
<link rel="stylesheet" href="${root}resources/assets/css/style.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/linearicons.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/bootstrap.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/magnific-popup.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/nice-select.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/animate.min.css">
<link rel="stylesheet"
	href="${root}/resources/homepage/css/owl.carousel.css">
<link rel="stylesheet" href="${root}/resources/homepage/css/main.css">
</head>
<body>

	<header id="header" id="home">


		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<%-- <div id="logo">
					<a href="${root}/resources/homepage/index.html"><img
						src="img/logo.png" alt="" title="" /></a>
				</div> --%>
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
	<section class="menu-area section-gap" id="coffee">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="title text-center">
					<h1 class="mb-10">Hãy chọn cho mình hương vị cà phê tuyệt vời
						nhất!</h1>
				</div>
			</div>
			<br>
			<div class="row" style="float: right;">
				<button class="btn btn-outline-warning" name="btnBuyNow"
					onclick="window.location.href='http://localhost:8080/CoffeeHouse/cart/insert.htm'"
					style="margin-left: 50px">Mua ngay (${soluongsp})</button>
			</div>
			<br> <br> <br>
			<form:form action="/CoffeeHouse/login/logininfo.htm" rel="stylesheet"
				modelAttribute="themgiohang" items="${cart}">
				<div class="row">
					<c:forEach var="prd" items="${products}" varStatus="status">
						<div class="col-lg-4">
							<div class="single-menu">
								<div class="title-div justify-content-between d-flex">
									<h4>
										<a href="${pageContext.request.contextPath}/cart/details/${cart.masanpham}.htm">${prd.tensanpham}</a>
									</h4>
									<c:out value="${price[status.index]}" />
								</div>
								<div class="product-content">
									<div class="product-title">
										<%-- <h4 class="title-2">
											<a
												href="http://localhost:8080/CoffeeHouse/cart/insert/${prd.masanpham}.htm">${flo.f1.name}</a>
										</h4> --%>
									</div>
									<c:if test="${userLogin==null}">
										<a style="color: #861F09;"
											href="http://localhost:8080/CoffeeHouse/login.htm"
											class="btn product-cart">Mua món này</a>
									</c:if>
									<c:if test="${userLogin!=null}">
										<a style="color: #800000; font-weight: bold;"
											href="http://localhost:8080/CoffeeHouse/cart/insert/${prd.masanpham}.htm"
											class="btn product-cart">Mua món này</a>
									</c:if>
								</div>
								<hr>
								<c:if test="${soluong>0}">
									<button class="btn btn-outline-warning" name="btnCart"
										style="margin-right: 100px">Thêm vào giỏ hàng</button>
								</c:if>
								<c:if test="${soluong<=0}">
									<div>Hết hàng</div>
								</c:if>
							</div>
						</div>
					</c:forEach>

					<%-- </c:forEach> --%>
				</div>
			</form:form>
		</div>
	</section>

	<!-- End menu Area -->

	<!-- Start gallery Area -->
	<section class="gallery-area section-gap" id="gallery">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<a href="${root}/resources/homepage/img/g1.jpg"
						class="img-pop-home"> <img class="img-fluid" src="img/g1.jpg"
						alt="">
					</a> <a href="${root}/resources/homepage/img/g2.jpg"
						class="img-pop-home"> <img class="img-fluid" src="img/g2.jpg"
						alt="">
					</a>
				</div>
				<div class="col-lg-8">
					<a href="${root}/resources/homepage/img/g3.jpg"
						class="img-pop-home"> <img class="img-fluid" src="img/g3.jpg"
						alt="">
					</a>
					<div class="row">
						<div class="col-lg-6">
							<a href="${root}/resources/homepage/img/g4.jpg"
								class="img-pop-home"> <img class="img-fluid"
								src="img/g4.jpg" alt="">
							</a>
						</div>
						<div class="col-lg-6">
							<a href="${root}/resources/homepage/img/g5.jpg"
								class="img-pop-home"> <img class="img-fluid"
								src="img/g5.jpg" alt="">
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End gallery Area -->


	<!-- start footer Area -->
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
	<!-- End footer Area -->

	<script src="${root}/resources/homepage/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="${root}/resources/homepage/js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="${root}/resources/homepage/js/easing.min.js"></script>
	<script src="${root}/resources/homepage/js/hoverIntent.js"></script>
	<script src="${root}/resources/homepage/js/superfish.min.js"></script>
	<script src="${root}/resources/homepage/js/jquery.ajaxchimp.min.js"></script>
	<script
		src="${root}/resources/homepage/js/jquery.magnific-popup.min.js"></script>
	<script src="${root}/resources/homepage/js/owl.carousel.min.js"></script>
	<script src="${root}/resources/homepage/js/jquery.sticky.js"></script>
	<script src="${root}/resources/homepage/js/jquery.nice-select.min.js"></script>
	<script src="${root}/resources/homepage/js/parallax.min.js"></script>
	<script src="${root}/resources/homepage/js/waypoints.min.js"></script>
	<script src="${root}/resources/homepage/js/jquery.counterup.min.js"></script>
	<script src="${root}/resources/homepage/js/mail-script.js"></script>
	<script src="${root}/resources/homepage/js/main.js"></script>
	<!-- Modernizer JS -->
	<script src="${root}/resources/assets/js/vendor/modernizr-3.7.1.min.js"></script>
	<!-- jQuery JS -->
	<script src="${root}/resources/assets/js/vendor/jquery-3.5.1.min.js"></script>
	<!-- Bootstrap JS -->
	<script
		src="${root}/resources/assets/js/vendor/bootstrap.bundle.min.js"></script>

	<!-- Swiper Slider JS -->
	<script src="${root}/resources/assets/js/plugins/swiper-bundle.min.js"></script>
	<!-- nice select JS -->
	<script src="${root}/resources/assets/js/plugins/nice-select.min.js"></script>
	<!-- Ajaxchimpt js -->
	<script
		src="${root}/resources/assets/js/plugins/jquery.ajaxchimp.min.js"></script>
	<!-- Jquery Ui js -->
	<script src="${root}/resources/assets/js/plugins/jquery-ui.min.js"></script>
	<!-- Jquery Countdown js -->
	<script
		src="${root}/resources/assets/js/plugins/jquery.countdown.min.js"></script>
	<!-- jquery magnific popup js -->
	<script
		src="${root}/resources/assets/js/plugins/jquery.magnific-popup.min.js"></script>

	<!-- Main JS -->
	<script src="${root}/resources/assets/js/main.js"></script>

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