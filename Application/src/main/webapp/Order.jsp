<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="font-marketsans mdl-js">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BookStore - Summary</title>
  <link rel="stylesheet" href="./My eBay - Summary_files/summary-88zDzmOw.css">
  <link rel="stylesheet" href="css/sumary.css">
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
						<a href="./index.jsp"><img src="img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="loadSach">Home</a></li>
							<li><a href="./shop-grid.html">Shop</a></li>
							<li><a href="#">Pages</a>
								<ul class="header__menu__dropdown">
									<li><a href="./shop-details.html">Shop Details</a></li>
									<li><a href="./shoping-cart.html">Shoping Cart</a></li>
									<li><a href="./checkout.html">Check Out</a></li>
									<li><a href="./blog-details.html">Blog Details</a></li>
								</ul></li>
							<li><a href="FAQ.jsp">FAQ</a></li>
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
  <div class="mainContent  summary" id="mainContent" role="main" currency="USD">
    <div class="grid">
      <div class="grid__group">
        <div class="grid__cell grid__cell--16of16 m-page-top">
          <div class="m-top-nav__top">
            <div class="page-title">
              <h1>My BookStore </h1>
            </div>
          </div>
          <div class="m-top-nav__bottom">
            <div class="m-page-tabs">
              <div class="fake-tabs">
                <ul class="fake-tabs__items">
                  <li class="medium-text m-tab selected m-tab__title fake-tabs__item">
                    <a aria-current="page" href="SummarybuysideControl">Buy mode</a>
                  </li>
                  <li class="medium-text m-tab m-tab__title fake-tabs__item">
                    <a href="SummarysellsideControl">Sell mode</a>
                  </li>
                  <li class="medium-text m-tab selected m-tab__title fake-tabs__item">
                    <a  href="LichsugiaodichControl">Lịch sử giao dịch</a>
                  </li>
                  <li class="medium-text m-tab m-tab__title fake-tabs__item">
                    <a href="user/profile">Account</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="grid">
      <div class="grid__group">
        <div class="grid__cell grid__cell--3of16 m-page-left">
          <section class="m-links-accordion">
            <ul>
              <li><a href="SummarybuysideControl">Tóm tắt</a></li>
              <li><a href="RecentlyviewedControl">Đã xem gần đây</a></li>

              <li class="selected"><a href="OrderControl">Đã mua</a></li>
              <li><a href="NopayControl">Chưa thanh toán</a></li>

            </ul>
          </section>
        </div>
        <div class="grid__cell grid__cell--13of16 m-page-middle full-width">
          <div class="m-river summary ">
            <div class="m-river__body">
              <div class="m-container container-1">
                <div class="m-container__header border-header">
                  <div class="title-container">
                    <h2 class="title large-text-2">Đã mua</h2>
                    <div class="sub-title regular-text"></div>
                  </div>
                </div>
                <c:forEach items="${Order}" var="o">
                <div class="m-container__body">
                  <div class="m-container__body--items">
                    <div class="m-container-items BuyingActivityDwebModule">
                      <div class="m-item-card">
                        <div class="m-container-item-layout-row m-container-item-layout-row__body">
                          <div class="container-item-col container-item-col-img">
                            <a href="detail?pid=${o.maSach }&amp;maKH=${sessionScope.acc.maTK}">
                              <div class="m-image"><img
                                  src="${o.getAnhs().get(0).getAnh()}"
                                  alt="product's image">
                              </div>
                            </a>
                          </div>
                          <div class="container-item-col container-item-col-item-info">
                            <div
                              class="container-item-col__info-item-info-primary container-item-col__info-item-info-title">
                              <div><a href="detail?pid=${o.maSach }&amp;maKH=${sessionScope.acc.maTK}" class="nav-link">${o.getTenSach() }</a></div>
                            </div>
                            
                          </div>
                          <div class="container-item-col container-item-col-time-left-info">
                        
                          </div>
                          <div class="container-item-col container-item-col-orderTotal">
                            <div class="container-item-col__info-tertiary container-item-col__info-displayPrice">
                              <div><span class="POSITIVE BOLD">${o.getDonGia()} $</span></div>
                            </div>
                         
                          </div>
                          <div class="container-item-col container-item-col-cta">
                            <div class="container-item-col-cta__item">
                              <div class="m-cta">
                                <a href="detail?pid=${o.maSach }&amp;maKH=${sessionScope.acc.maTK}" class="default primary fake-btn fake-btn--fluid fake-btn--primary">
                                  Xem chi tiết
                                </a>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>

            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
</body>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/toast.js"></script>
    <script src="js/main.js"></script>
</html>