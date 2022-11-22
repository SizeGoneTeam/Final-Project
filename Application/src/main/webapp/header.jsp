<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.jsp"><img src="image/logobook.png" width="100"  height="50" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="loadSach">Home</a></li>
							<li><a href="search?key=">Shop</a></li>
							<li><a href="FAQControl">FAQ</a></li>
							<c:if test="${sessionScope.acc != null}">
							<c:if test="${sessionScope.acc.getIsAdmin() != 0}">
								<li><a href="adminpage/DashboardControl">Admin</a></li>
							</c:if>
							</c:if>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
						<c:if test="${sessionScope.acc != null}">
							<li><a href="taoSach"><i class="fa fa-book"></i> <span>${demdb}</span></a></li>
							<li><a href="yeuthich"><i class="fa fa-heart"></i> <span>${demyt}</span></a></li>
							<li><a href="cart"><i class="fa fa-shopping-bag"></i> <span>${demgh}</span></a></li>
							<li><a href="NapTien.jsp"><i class="fa-solid fa-wallet"></i></a></li>
						</c:if>
							
						</ul>
						<div class="header__cart__price">
						<c:if test="${sessionScope.acc != null}">
							<span><a href="NapTien.jsp">${sessionScope.acc.tien.toString()} USD</a></span>
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