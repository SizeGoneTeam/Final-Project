<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="./index.jsp"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="<%=request.getContextPath() %>/loadSach">Home</a></li>
						<li><a href="search?key=">Shop</a></li>
						<li><a href="FAQControl">FAQ</a></li>
						<li><a href="AdminProduct">Admin</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
					<c:if test="${sessionScope.acc != null}">
						<li><a href="taoSach"><i class="fa fa-book"></i> <span>2</span></a></li>
						<li><a href="yeuthich?MaTK=${sessionScope.acc.maTK}""><i class="fa fa-heart"></i> <span>${dem}</span></a></li>
						<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
					</c:if>
						
					</ul>
					<div class="header__cart__price">
					<c:if test="${sessionScope.acc != null}">
						Money: <span><a href="NapTien.jsp">${sessionScope.acc.tien} USD</a></span>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						item: <span>$0.00</span>
					</c:if>
						
					</div>
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>