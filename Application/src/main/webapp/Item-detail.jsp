<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm nè</title>
</head>


<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
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
<link rel="stylesheet" href="css/slideshow.css" type="text/css">

<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
   position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 250px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

table {
	border: 1px solid #e5e5e5;
	width: 100%;
	border-collapse: collapse;
	text-indent: initial;
}

th {
	background-color: #f2f2f2;
}
.loader {
  border: 16px solid #f3f3f3; /* Light grey */
  border-top: 16px solid #3498db; /* Blue */
  border-radius: 50%;
  width: 120px;
  height: 120px;
  animation: spin 2s linear infinite;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
</head>

<body>
	<div id="preloder" class="preloder" style="display: none;">
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
							<li><a href="loadSach">Home</a></li>
							<li class="active"><a href="search?key=">Shop</a></li>
							
							<c:if test="${sessionScope.acc != null}">
							<li><a href="FAQControl">FAQ</a></li>
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
						</c:if>
							
						</ul>
						<div class="header__cart__price">
						<c:if test="${sessionScope.acc != null}">
							Money: <span><a href="NapTien.jsp">${sessionScope.acc.tien.toString()} USD</a></span>
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
	<!-- Header Section End -->

	<!-- Hero Section Begin -->
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Tất cả thể loại</span>
						</div>
						<ul>
							<div class="dropdown">
							  <button class="dropbtn">Xem Thêm</button>
							  <div class="dropdown-content">
							  <c:forEach items="${category}" var="o" begin ="12">
							    <a href="categorysearch?keycategory=${o.getTenTheLoai() }">${o.getTenTheLoai()}</a>
							    </c:forEach>
							  </div>
							</div>
							<c:forEach items="${category}" var="o" begin ="0" end ="11">
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
										<a href="login">Đăng Nhập</a>
									</h5>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
	</section>

	<!-- Hero Section End -->

	<!-- Breadcrumb Section Begin -->

	<!-- Breadcrumb Section End -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<div class="w3-content w3-display-container">
							<c:forEach items="${anhs}" var="o">
							<img class="mySlides" src="${o.getAnh()}" style="width:100%">
							</c:forEach>
							    <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  								<button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
							<%-- <img class="product__details__pic__item--large"
								src="${detail.getAnhs().get(0).getAnh() }"> --%>
							</div>
								
						</div>

					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h2 style=" word-wrap: break-word;">${detail.tenSach}</h2>
						<div class="product__details__rating">
							<h5 style="color: #0066ff;">Ngày kết thúc: ${detail.getPhienDauGia().getNgayKetThuc()}</h4>
						</div>
						<div class="product__details__price">${detail.donGia}$</div>
						<c:if test="${sessionScope.acc.getMaTK() != detail.getNguoiSoHuu().getMaTK()}">
						<c:if test="${demgh <3}">
						<c:if test="${detail.getPhienDauGia().getLoaiPhien() == 1}">
							<form action="placeBid">
						</c:if>
						<c:if test="${detail.getPhienDauGia().getLoaiPhien() == 2}">
							<form action="DauGia" method="post">
						</c:if>
								<div class="product__details__quantity">
									<div class="quantity">
									<c:if test="${sessionScope.acc.getDiaChiMacDinh() != 0}">
									<c:if test="${detail.getPhienDauGia().getIsEnd() == 0}">
									<c:if test="${detail.getPhienDauGia().getLoaiPhien() == 1}">
										<div class="pro-qty">
											<input name="new_price" type="Number" value="${detail.donGia +1}" min="${detail.donGia+0.01}" step = "0.01" max = "9999999">
											<input name="maSach" value="${detail.maSach}" hidden> 
										</div>
										</c:if>
										<c:if test="${detail.getPhienDauGia().getLoaiPhien() == 2}">
											<input name="maSach" value="${detail.maSach}" hidden> 
										</c:if>  
									
								
									<input type="submit" class="primary-btn" style="color: #66FFFF" value="Đấu Giá" onclick="load()">
									</c:if>
									</c:if>
									<c:if test="${sessionScope.acc.getDiaChiMacDinh() == 0}">
										<a href="user/address" style="color: red;">Vui lòng thêm địa chỉ để đấu giá</a>
									</c:if>									 
									</div>
								</div>
								<c:if test="${detail.getPhienDauGia().getIsEnd() == 1}">
								<h2>Phiên đấu giá đã kết thúc</h2>
								</c:if>
								 
							</form>
							</c:if>
							<c:if test="${demgh ==3}"><h5>Giỏ hàng đã đạt 3 sản phẩm. Vui lòng thanh toán để tiếp tục đấu giá</h5></c:if>
						</c:if>
						
						
						 <a href="insertytdetail?MaSach=${detail.maSach }" class="heart-icon"><span class="icon_heart_alt"></span></a>
					</div>
					<div>
					<c:forEach items="${tacGia}" var="o">
						<a href="search?key=${o.getTenTacGia()}">${o.getTenTacGia()}</a>
					</c:forEach>
					</div>
					<hr>
					<div class="bid-history">
						<table border="1">
							<tr>
								<th>Bidder</th>
								<th>Bid Amount</th>
								<th>Bid Time</th>
							</tr>
							<c:forEach items="${BidHistory}" var="o">
								<tr>
									<td>${o.account.getMaTK()}</td>
									<td>${o.bid} $</td>
									<td>${o.ngayTao}</td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
					<h2 style="color: black;">Người đăng: <a style="color: red;" href="FeedbackControl?id=${detail.getNguoiSoHuu().getMaTK() }">${detail.getNguoiSoHuu().getMaTK() }</a> </h2> 
					<c:forEach items="${theloai}" var="o">
					<a href="categorysearch?keycategory=${o.getTenTheLoai() }">${o.getTenTheLoai()} |</a>
					
					</c:forEach>
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô tả</a>
							</li>

						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<p>${detail.moTa }</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->

	<!-- Related Product Section Begin -->
	<section class="related-product">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title related__product__title">
						<h2>Sách vừa đăng</h2>
					</div>
				</div>
			</div>
			<div class="row">
			<c:forEach items="${listNew}" var="o">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg"  onclick="window.location='detail?pid=${o.maSach }';">
							<img src="${o.getAnhs().get(0).getAnh()}" alt="">
							<ul class="product__item__pic__hover">
								<li><a href="insertyt?MaSach=${o.maSach }"><i class="fa fa-heart"></i></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#">${o.getTenSach() }</a>
							</h6>
							<h5>${o.getDonGia()}$</h5>
						</div>
					</div>
				</div>
			</c:forEach>
				
			</div>
		</div>
	</section>
	<!-- Related Product Section End -->

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
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

<script>
function load(){
	document.querySelector(".preloder").style.display = "block";
	document.querySelector(".loader").style.display = "block";
}

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>


</body>
</html>