<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<c:if test="${sessionScope.acc != null}">
	<h1>Nạp Tiền</h1>
	<form action="authorize_payment" method = "post">
		<table>
			<tr>
				<td>Tên Tài Khoản:</td>
				<td><input type = "text" name = "UserName" value = "${sessionScope.acc.UName }" readonly></td>
			</tr>
			<tr>
				<td>Số tiền hiện có:</td>
				<td><input type = "text" name = "TienHienTai" value = "${sessionScope.acc.tien }" readonly></td>
			</tr>
			<tr>
				<td><input type = "text" name = "subtotal" value = "0" hidden></td>
			</tr>
			<tr>
				<td><input type = "text" name = "shipping" value = "0" hidden></td>
			</tr>
			<tr>
				<td><input type = "text" name = "tax" value = "0" hidden></td>
			</tr>
			<tr>
				<td>Số Tiền Nạp:</td>
				<td><input type = "text" name = "total" value = "100"></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "Checkout"></td>
			</tr>
		</table>
	</form>
	</c:if>
	<c:if test="${sessionScope.acc == null}">
    <h1>Vui Lòng đăng nhập lại để tiếp tục</h1>
    <h2><a href="login">Login</a></h2>
    </c:if>
</div>
</body>
</html>