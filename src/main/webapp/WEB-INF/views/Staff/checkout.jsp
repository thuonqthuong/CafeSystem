<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!doctype html>
<html class="no-js" lang="zxx">
<style type="text/css">
.float-left {
	float: left;
	width: 30px;
}
.alert {
  padding: 20px;
  background-color: #C6E2FF;
  color: black;
}

.closebtn {
  margin-left: 15px;
  color: balck;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
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
					<form:form>
						<!-- Cart Table Area -->
						<div class="cart-table table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="pro-thumbnail">Tên Sản Phẩm</th>
										<th class="pro-title">Số Lượng</th>
										<th class="pro-price">Giá</th>
										<th class="pro-quantity">Tổng tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cart" items="${carts}" varStatus="status">
										<tr>
											<td class="pro-title"><a href="#">${cart.tensanpham}</a></td>
											<td class="pro-quantity"><a>${cart.soluong}</a></td>
											<td class="pro-price"><span><fmt:formatNumber
														pattern="###,### VND" value="${cart.gia}" type="currency" /></span></td>
											<td class="pro-title"><a href="#">${cart.tongtien}</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- Cart Update Option -->
							<div class="alert">
								<span class="closebtn"
									onclick="this.parentElement.style.display='none';">&times;</span>
								<strong>${message1}</strong>
								<strong>${message0}</strong>
							</div>
						<div
							class="cart-update-option d-block d-md-flex justify-content-between">
							<div class="apply-coupon-wrapper">
								<a href="http://localhost:8080/CoffeeHouse/cart/new.htm"
									class="btn flosun-button primary-btn rounded-0 black-btn">Tiếp
									tục với đơn hàng mới</a>
							</div>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- cart main wrapper end -->

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