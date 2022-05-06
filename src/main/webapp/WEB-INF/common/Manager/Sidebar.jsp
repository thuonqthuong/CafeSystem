<!-- Sidebar -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="http://localhost:8080/CoffeeHouse/">
		<div name="${name}">Xin Chào<br>${name}</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link"
		href="http://localhost:8080/CoffeeHouse/dashboard.htm"> <i
			class="fab fa-pagelines"></i> <span>Tổng quan</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed"
		href="http://localhost:8080/CoffeeHouse/manager/material.htm" data-toggle="collapse"
		data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cubes"></i></i> <span>Kho</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/material.htm">Nguyên Liệu</a> <a class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/material/import.htm">Nhập nguyên liệu</a><a class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/material/CTPN.htm">Chi tiết phiếu nhập</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link"
		href="http://localhost:8080/CoffeeHouse/manager/product.htm"> <i
			class="fas fa-fw fas fa-star"></i> <span>Sản Phẩm</span></a></li>

	<li class="nav-item"><a class="nav-link"
		href="http://localhost:8080/CoffeeHouse/manager/employee.htm"> <i
			class="fas fa-fw fas fa-user-alt"></i> <span>Nhân viên</span></a></li>
			<li class="nav-item"><a class="nav-link"
		href="http://localhost:8080/CoffeeHouse/manager/account.htm"> <i
			class="fas fa-fw fas fa-users"></i> <span>Tài Khoản</span></a></li>
	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fas fa-map-marker-alt"></i> <span>Chi Nhánh</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/branch.htm">Địa điểm</a> <a class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/branch/shifts.htm">Phân công ca làm</a>
			</div>
		</div></li>


	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed"
		href="${root}/resources/Manager/#" data-toggle="collapse"
		data-target="#collapsePages" aria-expanded="true"
		aria-controls="collapsePages"> <i class="fas fa-signal"></i> <span>Thống kê</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="${root}/resources/Manager/login.html">Lương nhân viên</a> <a class="collapse-item"
					href="${root}/resources/Manager/register.html">Bán hàng</a> <a
					class="collapse-item"
					href="http://localhost:8080/CoffeeHouse/manager/branch/shifts.htm">Ca làm việc</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

	<!-- Sidebar Message -->
	<div class="sidebar-card d-none d-lg-flex">
		<img class="sidebar-card-illustration mb-2"
			src="${root}/resources/Manager/img/undraw_rocket.svg" alt="...">
		<p class="text-center mb-2">
			<strong>SB Admin Pro</strong> is packed with premium features,
			components, and more!
		</p>
	</div>

</ul>
<!-- End of Sidebar -->