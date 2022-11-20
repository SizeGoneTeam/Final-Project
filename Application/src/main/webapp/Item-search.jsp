<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tìm kiếm</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
/* Style The Dropdown Button */
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

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}
</style>
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
							<li><a href="loadSach">Home</a></li>
							<li class="active"><a href="search?key=">Shop</a></li>
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
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<span>Tất cả thể loại</span>
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

							<form action="search" method="get">

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
				</div>
			</div>
	</section>
    <!-- Hero Section End -->




    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Thể loại</h4>
                            <ul>
							<c:forEach items="${category}" var="o">
								<li><a href="categorysearch?keycategory=${o.getTenTheLoai() }">${o.getTenTheLoai()}</a></li>
							</c:forEach>
                            </ul>
                        </div>

                        <div class="sidebar__item">
                            <div class="latest-product__text">
                                <h4>Sách mới đăng</h4>
                                <div class="latest-product__slider owl-carousel">

						
								<c:forEach items="${lastAdd}" var="o">
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
                <div class="col-lg-9 col-md-7">           
                   
                    <div class="row">
                    	<c:forEach items="${search}" var="o">
	                       	<div class="col-lg-4 col-md-6 col-sm-6">
	                            <div class="product__item">
	                           
	                                <div  class="product__item__pic set-bg"  data-setbg="${o.getAnhs().get(0).getAnh()}" onclick="window.location='detail?pid=${o.maSach }';">
	                                    
	                                </div>
	                                <div class="product__item__text">
	                                <h6>
										<a href="detail?pid=${o.maSach }">${o.getTenSach() }</a>
									</h6>
	                                    <h5>${o.getDonGia()}VNĐ</h5>
	                                </div>
	                            </div>
	                        </div>
                      	</c:forEach>
                    </div>
                    <div class="product__pagination">
                    	<c:forEach begin="1" end="${endPTitle}" var="o">
	                        <a href="${keyout}&amp;page=${o}">${o}</a>
                        </c:forEach>
                        <c:forEach begin="1" end="${endPCategory}" var="o">
	                        <a href="categorysearch?keycategory=${keyout}&amp;page=${o}">${o}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

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
    <!-- Footer Section End -->

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