<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.servletContext.contextPath}" />
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root}/resources/Staff/shifts.css">
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

</head>
</head>
<body id="page-top">
	<div id="wrapper">
		<%@ include file="/WEB-INF/common/Manager/Sidebar.jsp"%>

		<div class="card-header">
			<form:form class="row" modelAttribute="clv"
				action="${root}/manager/branch/shifts.htm" rel="stylesheet">
				<div class="col-md-6">
					<label class="font-weight-bold"
						style="color: darkblue; font-size: 18px; font-weight: bold;">Tên
						Quản Lý: </label> <label
						style="color: black; font-size: 16px; font-weight: bold;"
						name="nhanvientemp" type="text" items="${nhanviennhap}"
						itemValue="manv" itemLabel="manv" class="form-control">${nhanviennhap.ho}
						${nhanviennhap.ten}</label>
				</div>
				<form:form modelAttribute="nhanvien"
					action="${root}/manager/branch/shifts.htm" rel="stylesheet">
					<div class="col-md-8">
						<div class="col-md-6">
							<label class="font-weight-bold"
								style="color: darkblue; font-size: 18px; font-weight: bold;">Chọn
								Nhân Viên: </label>
							<form:select path="manv" items="${nvselect}" itemValue="manv"
								itemLabel="ten" class="form-control"
								aria-label=".form-select-lg example">
							</form:select>
						</div>
					</div>
				</form:form>
				<form:form modelAttribute="chinhanh"
					action="${root}/manager/branch/shifts.htm" rel="stylesheet">
					<div class="col-md-12">
						<label class="font-weight-bold"
							style="color: darkblue; font-size: 18px; font-weight: bold;">Chọn
							Chi Nhánh</label>
						<form:select path="madiadiem" items="${cnselect}"
							itemValue="madiadiem" itemLabel="vitri" class="form-control"
							aria-label=".form-select-lg example">
						</form:select>
					</div>
				</form:form>
				<div class='parent' class="col-md-2">
					<hr>
					<div class='child float-left-child' style="margin-left: 2.5em">
						<button name="XacNhanCN" class="btn btn-danger">Chọn Chi
							Nhánh</button>
						<button
							onclick="location.href='http://localhost:8080/CoffeeHouse/manager/branch/shifts.htm'"
							class="btn btn-success" type="button">Reload</button>

					</div>
				</div>
				<div class="container">
					<div class="timetable-img text-center">
						<img src="img/content/timetable.png" alt="">
					</div>
					<div class="table-responsive">
						<table class="table table-bordered text-center">
							<thead>
								<tr class="bg-light-gray">
									<th class="text-uppercase">Thời Gian</th>
									<th class="text-uppercase">Thứ 2</th>
									<th class="text-uppercase">Thứ 3</th>
									<th class="text-uppercase">Thứ 4</th>
									<th class="text-uppercase">Thứ 5</th>
									<th class="text-uppercase">Thứ 6</th>
									<th class="text-uppercase">Thứ 7</th>
									<th class="text-uppercase">Chủ Nhật</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="clv" items="${clvs}">
									<tr>
										<td class="align-middle">${clv.giobatdau}-${clv.gioketthuc}</td>
										<form:form class="row g-3" modelAttribute="chonnhanvien"
											action="${root}/manager/branch/shifts.htm" rel="stylesheet">
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr>
											<td><span
												class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13"></span>
												<div class="margin-10px-top font-size14"></div> <form:select
													path="manv" items="${nvselect}" itemValue="manv"
													itemLabel="ten" class="form-control"
													aria-label=".form-select-lg example">
												</form:select>
												<hr> 
										</form:form>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	form:form { display: inline-block;}
</body>
</html>