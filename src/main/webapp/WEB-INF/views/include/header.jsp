<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="robots" content="noindex, follow" />
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/favicon.ico">

<!-- CSS
	============================================ -->
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/vendor/bootstrap.min.css' />">

<!-- Test -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/style.css' />">
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
</head>

<body>
	<!-- Main Header Area Start -->
	<div class="main-header header-sticky" id="header_main">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-lg-2 col-xl-2 col-md-6 col-6 col-custom">
					<div class="header-logo d-flex align-items-center"><br>
						<%-- <a href="http://localhost:8080/CoffeeHouse/cart/buymore.htm">
							<img
							src="${pageContext.request.contextPath}/resources/img/logo.png"
							alt="Header Logo">
						</a> --%>
					</div>
				</div>
				<div
					class="col-lg-8 d-none d-lg-flex justify-content-center col-custom">
					<nav class="main-nav d-none d-lg-flex">
						<ul class="nav" id="navbar_main">
							<li><a
								href="http://localhost:8080/CoffeeHouse/cart/buymore.htm"> <span
									class="menu-text"> Home</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/blog/main.htm"> <span
									class="menu-text"> Blog</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/about_us.htm">
									<span class="menu-text"> About Us</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/contact_us.htm">
									<span class="menu-text">Contact Us</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
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
</body>
</html>