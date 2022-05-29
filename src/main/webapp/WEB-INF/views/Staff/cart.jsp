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
<title>The Coffee Shop</title>
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
<link
	href="${root}/resources/Manager/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${root}/resources/Manager/css/sb-admin-2.min.css"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="${root}/resources/Manager/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<base href="${pageContext.servletContext.contextPath }" />
</head>

<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>

	<!-- Breadcrumb Area End Here -->
	<!-- cart main wrapper start -->
	<div class="cart-main-wrapper mt-no-text">
		<div class="container custom-area">
			<div class="row">
				<div class="col-lg-12 col-custom">
					<form:form method="GET">
						<!-- Cart Table Area -->
						<div class="cart-table table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="pro-thumbnail">Tên Sản Phẩm</th>
										<th class="pro-title">Số Lượng</th>
										<th class="pro-price">Giá</th>
										<th class="pro-quantity">Tổng tiền</th>
										<th class="pro-remove">Xóa bỏ</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cart" items="${carts}" varStatus="status">
										<tr>
											<td class="pro-title"><a href="#">${cart.tensanpham}</a></td>
											<td class="pro-quantity">
												<div class="quantity">
													<div class="cart-plus-minus">
														<input class="cart-plus-minus-box"
															name="qtt${cart.masanpham}" value="${cart.soluong}"
															type="text">
														<div class="dec qtybutton">-</div>
														<div class="inc qtybutton">+</div>
														<div class="dec qtybutton">
															<i class="fa fa-minus"></i>
														</div>
														<div class="inc qtybutton">
															<i class="fa fa-plus"></i>
														</div>
													</div>
												</div>
											</td>
											<td class="pro-price"><span><fmt:formatNumber
														pattern="###,### VND" value="${cart.gia}" type="currency" /></span></td>
											<td class="pro-title"><a href="#">${cart.tongtien}</a></td>
											<td class="pro-remove"><a
												href="${pageContext.request.contextPath}/cart/delete/${cart.masanpham}.htm"><i
													class="lnr lnr-trash"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- Cart Update Option -->
						<div
							class="cart-update-option d-block d-md-flex justify-content-between">
							<div class="apply-coupon-wrapper">
								<a href="http://localhost:8080/CoffeeHouse/cart/buymore.htm"
									class="btn flosun-button primary-btn rounded-0 black-btn">Tiếp
									tục mua thêm</a>
							</div>
							<div class="cart-update mt-sm-16">
								<input class="btn flosun-button primary-btn rounded-0 black-btn"
									type="submit"
									formaction="${pageContext.request.contextPath}/cart/deleteAll.htm"
									value="Xóa đơn hàng">
							</div>
							<div class="cart-update mt-sm-16">
								<input class="btn flosun-button primary-btn rounded-0 black-btn"
									type="submit"
									formaction="${pageContext.request.contextPath}/cart/update.htm"
									value="Cập Nhật Giỏ Hàng">
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-5 ml-auto col-custom">
					<!-- Cart Calculation Area -->
					<div class="cart-calculator-wrapper">
						<div class="cart-calculate-items">
							<h3>Cart Totals</h3>
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td>Sub Total</td>
										<td><span class="amount"><fmt:formatNumber
													pattern="###,### VND" value="${subTotal}" type="currency" /></span></td>
									</tr>
									<tr class="total">
										<td>Total</td>
										<td class="total-amount"><span class="amount"><fmt:formatNumber
													pattern="###,### VND" value="${subTotal}" type="currency" /></span></td>
									</tr>
								</table>
							</div>
						</div>
						<a href="${pageContext.request.contextPath}/cart/checkout.htm"
							class="btn flosun-button primary-btn rounded-0 black-btn w-100">Lập
							Hóa Đơn Thanh Toán</a> <br> <br> <br> <br> <br>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- cart main wrapper end -->
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