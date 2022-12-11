<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Rút Tiền</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/recharge.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-image:
		url("image/hinh-nen-may-cuc-dep.jpg");
	background-color: #cccccc;
	background-position: center;
}
.btn-info {
    background-color: red;
    border-color: #17a2b8;
}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${sessionScope.acc != null}">
			<form action="Withdraw" method="post">
				<div class="main-body" align="center">
					<div class="w-50">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center"
									align="center">
									<img src="image/avatar7.png"
										alt="image" class="rounded-circle" width="150">
									<div class="mt-3">
										<h4>Thông tin cá nhân</h4>
										<input type="text" name="UserName"
											value="${sessionScope.acc.UName }" hidden> <input
											type="text" name="subtotal" value="0" hidden> <input
											type="text" name="shipping" value="0" hidden> <input
											type="text" name="tax" value="0" hidden>
										<p class="text-secondary mb-1">${sessionScope.acc.UName }</p>
										<p class="text-secondary mb-1">Số tiền hiện có:
											${sessionScope.acc.tien } $</p>
									</div>
								</div>
								<div class="">
									<div align="center">
										<h6>Email Người nhận</h6>
										<input class="col-sm-5 text-secondary" type="email"
											name="email" value="${sessionScope.acc.email }" required="required">
										<h6>Số tiền muốn rút</h6>
										<input class="col-sm-5 text-secondary" type="Number"
											name="total" value="10" step="0.01" min = 10 max =${sessionScope.acc.tien } max =${sessionScope.acc.tien }>
										<hr>
										<input class="btn btn-info " type="submit" value="Rút Ngay">
										
									</div>
									<a class="rut" href="NapTien.jsp">Nạp Tiền</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</c:if>
		<c:if test="${sessionScope.acc == null}">
			<div class="main-body" align="center">
				<div class="w-50">
					<div class="card">
						<div class="card-body">
							<h1>Vui Lòng đăng nhập lại để tiếp tục</h1>
							<h2>
								<a href="login">Login</a>
							</h2>
						</div>
					</div>
				</div>
		</c:if>
	</div>
</body>
</html>