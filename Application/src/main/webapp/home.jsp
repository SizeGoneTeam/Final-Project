<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Ogani | Template</title>

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
</head>
<body>
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
							<li class="active"><a href="./index.jsp">Home</a></li>
							<li><a href="./shop-grid.html">Shop</a></li>
							<li><a href="#">Pages</a>
								<ul class="header__menu__dropdown">
									<li><a href="./shop-details.html">Shop Details</a></li>
									<li><a href="./shoping-cart.html">Shoping Cart</a></li>
									<li><a href="./checkout.html">Check Out</a></li>
									<li><a href="./blog-details.html">Blog Details</a></li>
								</ul></li>
							<li><a href="./blog.html">Blog</a></li>
							<li><a href="./contact.html">Contact</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
							<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
						</ul>
						<div class="header__cart__price">
							item: <span>$0.00</span>
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
							<li><a href="#">Sách văn học</a></li>
							<li><a href="#">Sách kinh tế</a></li>
							<li><a href="#">Sách thiếu nhi</a></li>
							<li><a href="#">Sách kỹ năng sống</a></li>
							<li><a href="#">Thiếu nhi</a></li>
							<li><a href="#">Sách Bà mẹ - Em bé</a></li>
							<li><a href="#">Sách Giáo Khoa - Giáo Trình</a></li>
							<li><a href="#">Sách Học Ngoại Ngữ</a></li>
							<li><a href="#">Sách Tham Khảo</a></li>
							<li><a href="#">Từ Điển</a></li>
							<li><a href="#">Sách Kiến Thức Tổng Hợp</a></li>
							<li><a href="#">Sách Khoa Học - Kỹ Thuật</a></li>
							<!--                             <li><a href="#">Sách Lịch sử</a></li>
                            <li><a href="#">Điện Ảnh - Nhạc - Họa</a></li>
                            <li><a href="#">Truyện Tranh - Manga - Comic</a></li>
                            <li><a href="#">Sách Tôn Giáo - Tâm Linh</a></li>
                            <li><a href="#">Sách Văn Hóa - Địa Lý - Du Lịch</a></li>
                            <li><a href="#">Sách Chính Trị - Pháp Lý</a></li>
                            <li><a href="#">Sách Nông - Lâm - Ngư Nghiệp</a></li>
                            <li><a href="#">Sách Công Nghệ Thông Tin</a></li>
                            <li><a href="#">Sách Y Học</a></li>
                            <li><a href="#">Tạp Chí - Catalogue</a></li>
                            <li><a href="#">Sách Tâm lý - Giới tính</a></li>
                            <li><a href="#">Sách Thường Thức - Gia Đình</a></li>
                            <li><a href="#">Thể Dục - Thể Thao</a></li> -->
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">

								<input type="text" placeholder="Tìm sách gì dợ?">
								<button type="submit" class="site-btn">Tìm kiếm</button>
							</form>
						</div>
						<div class="hero__search__login">
							<div class="hero__search__login__icon">
								<i class="fa fa-user"></i>
							</div>
							<c:if test="${sessionScope.acc != null}">
								<div class="hero__search__login__text hello_user">
									<h5>Xin chào ${sessionScope.acc.user}</h5>
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
							<p>Free ship cho đơn hàng trên 200k</p>
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
					<div class="featured__controls">
						<ul>
							<li class="active" data-filter="*">Tắt cả</li>
							<li data-filter=".vanhoc">Sách văn học</li>
							<li data-filter=".kinhte">Sách kinh tế</li>
							<li data-filter=".thieunhi">Sách thiếu nhi</li>
							<li data-filter=".kynang song">Sách kỹ năng sống</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach items="${listP}" var="o">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item" style="cursor: pointer;" onclick="window.location='detail?pid=${o.maSach }';">
							<div class="featured__item__pic set-bg"
							 data-setbg="${o.anh }"
								
								>								
								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>

									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="detail?pid=${o.maSach }">${o.tenSach }</a>
								</h6>
								<h5 >${o.price}VNĐ</h5>
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
						<h4>Sách Vừa Bán</h4>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!--  <div class="latest-product__slider owl-carousel">
 -->
						<div class="latest-prdouct__slider__item">
							<c:forEach items="${listLast}" var="o">
								<a href="detail?pid=${o.maSach }" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img src="${o.anh}" alt="">
									</div>
									<div class="latest-product__item__text">
										<h6>${o.tenSach}</h6>
										<span>${o.price}VNĐ</span>
									</div>
								</a>
							</c:forEach>

						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Top Sách được đánh giá cao</h4>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!-- <div class="latest-product__slider owl-carousel"> -->
						<div>
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${listRated}" var="o">
									<a href="detail?pid=${o.maSach }" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${o.anh}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${o.tenSach}</h6>
											<span>${o.price}VNĐ</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Top Sách Bán Chạy</h4>
						<!-- có class="latest-product__slider owl-carousel" thì k chạy được chả hiểu vì sao -->
						<!-- <div class="latest-product__slider owl-carousel"> -->
						<div>
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${listSell}" var="o">
									<a href="detail?pid=${o.maSach }" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${o.anh}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${o.tenSach}</h6>
											<span>${o.price}VNĐ</span>
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
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.jsp"><img src="img/logo.png" alt=""></a>
						</div>
						<ul>
							<li>Address: Số 1 Võ Văn Ngân,<br> Thành phố Thủ Đức
							</li>
							<li>Phone: +65 11.188.888</li>
							<li>Email: hello@colorlib.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<h6>Useful Links</h6>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">About Our Shop</a></li>
							<li><a href="#">Secure Shopping</a></li>
							<li><a href="#">Delivery infomation</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Our Sitemap</a></li>
						</ul>
						<ul>
							<li><a href="#">Who We Are</a></li>
							<li><a href="#">Our Services</a></li>
							<li><a href="#">Projects</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Innovation</a></li>
							<li><a href="#">Testimonials</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Join Our Newsletter Now</h6>
						<p>Get E-mail updates about our latest shop and special
							offers.</p>
						<form action="#">
							<input type="text" placeholder="Enter your mail">
							<button type="submit" class="site-btn">Subscribe</button>
						</form>
						<div class="footer__widget__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-pinterest"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer__copyright">
						<div class="footer__copyright__text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(2012);
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
						<div class="footer__copyright__payment">
							<img src="img/payment-item.png" alt="">
						</div>
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
    <script src="js/main.js"></script>
	
</body>
</html>