<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Sizegone Book</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/toast.css" type="text/css">
</head>
<body>
    <div id="preloder">
        <div class="loader"></div>
    </div>
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
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">

							<span>Tất cả thể loại</span>
						</div>
						<ul>
							<c:forEach items="${category}" var="o">
							<li><a href="categorysearch?keycategory=${o.getTenTheLoai() }">${o.getTenTheLoai()}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="search" method="post">

								<input type="text" placeholder="Tìm sách gì dợ?"  name="key">
								<button type="submit" class="site-btn">Tìm kiếm</button>
							</form>
						</div>
						<div class="hero__search__login">
							
							<c:if test="${sessionScope.acc != null}">
							<a href="SummarybuysideControl">
									<div class="hero__search__login__icon">
										<i class="fa fa-user"></i>
									</div>
								</a>
								<div class="hero__search__login__text hello_user">
									<h5>Xin chào ${sessionScope.acc.UName}</h5>
								</div>
								<br>
								<div class="hero__search__login__text">
									<h5>
										<a href="logout">Đăng Xuất</a>
									</h5>
								</div>


							</c:if>
							<c:if test="${sessionScope.acc == null}">
							
								<div class="hero__search__login__text">
									<h5>
										<a href="Login.jsp">Đăng Nhập</a>
									</h5>
								</div>
							</c:if>
						</div>
					</div>
					<div class="hero__item set-bg"
						data-setbg="picture/book-banner.jpg">
						<div class="hero__text">
							<span>SÁCH XỊN</span>
							<h2>
								Mua liền tay <br />Sách về ngay
							</h2>
							<p></p>
							<a href="#" class="primary-btn">MUA NGAY</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->


	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Đầu sách hay</h2>
					</div>

				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach items="${listP}" var="o">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item" style="cursor: pointer;" onclick="window.location='detail?pid=${o.maSach }';">
							<div class="featured__item__pic set-bg">
							<img src="${o.getAnhs().get(0).getAnh()}" alt="">					
								<ul class="featured__item__pic__hover">
								<c:if test="${sessionScope.acc != null}">
									<li><a href="insertyt?MaSach=${o.maSach }"><i class="fa fa-heart"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6 style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
									<a href="detail?pid=${o.maSach }">${o.getTenSach() }</a>
								</h6>
								<h5 >${o.getDonGia()}$</h5>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>

	<!-- Latest Product Section Begin -->
	<section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sách Vừa Xem</h4>
						
						<input name="idlogin" value="${sessionScope.acc.UName}" hidden>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!--  <div class="latest-product__slider owl-carousel">-->
						<div class="latest-prdouct__slider__item">
							<c:forEach items="${lastSeen}" var="o">
								<a href="detail?pid=${o.maSach }"  class="latest-product__item">
									<div class="latest-product__item__pic">
										<img src="${o.getAnhs().get(0).getAnh()}" alt="">
									</div>
									<div class="latest-product__item__text">
										<h6>${o.getTenSach()}</h6>
										<span>${o.getDonGia()}VNĐ</span>
									</div>
								</a>
							</c:forEach>

						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Top Sách Có Giá Thấp Nhất</h4>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!-- <div class="latest-product__slider owl-carousel"> -->
						
						<div class="latest-prdouct__slider__item">
							<c:forEach items="${lowest}" var="o">
								<a href="detail?pid=${o.maSach }"  class="latest-product__item">
									<div class="latest-product__item__pic">
										<img src="${o.getAnhs().get(0).getAnh()}" alt="">
									</div>
									<div class="latest-product__item__text">
										<h6>${o.getTenSach()}</h6>
										<span>${o.getDonGia()}VNĐ</span>
									</div>
								</a>
							</c:forEach>

						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sách Mới Được Đăng</h4>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!-- <div class="latest-product__slider owl-carousel"> -->
						<div>
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${listNew}" var="o">
									<a href="detail?pid=${o.maSach }" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${o.getAnhs().get(0).getAnh()}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${o.getTenSach()}</h6>
											<span>${o.getDonGia()}VNĐ</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Latest Product Section End -->

	<!-- Blog Section Begin -->

	<!-- Blog Section End -->

	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">

			<div class="row">
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<div class="footer__about__logo">
							<a href="./index.jsp"><img src="image/logobook.png" width="250"  height="150" alt=""></a> <br>
						</div>
			
					</div>
				</div>
			       <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <p>Address: Số 1 Võ Văn Ngân, Thành phố Thủ Đức</p>
                        <p>Phone: +84 88.888.888</p>
                        <p>Email: sizegonebook@gmail.com</p>
                     
                    </div>
                	</div>
                	  <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Sự hài lòng của bạn là hạnh phúc của chúng tôi</h6>
                        <p> </p>
                       
                     
                    </div>
                	</div>
		</div>
		</div>
	</footer>
	    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/toast.js"></script>
    <script src="js/main.js"></script>
    <script src="https://kit.fontawesome.com/17fd3f26a2.js" crossorigin="anonymous"></script>
</body>
</html>