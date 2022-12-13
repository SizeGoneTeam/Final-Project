<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BookStore</title>
  <link rel="stylesheet" href="css/feedback.css">
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
							<li><a href="search?key=">Shop</a></li>
							
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
  <!--Headline-->
  <div class="str-seller-card">
    <div class="str-seller-card__store-logo"><a href="#"><img
          src="image/avatar7.png" alt="Logo User"></a>
    </div>
    <div class="str-seller-card__store-name">
      <h1><a href="#">${sessionScope.acc.UName}</a></h1>
    </div>
    <div class="str-seller-card__stats">
      <div class="str-seller-card__stats-content">
        <div><span>Tham gia từ </span>${ngayThamGIa}</div>
        <div><span>${sachdadangLong} </span>Sách đã bán</div>
      </div>
    </div>
  </div>
  <!--End Headline-->

  <!--Tab Navigation-->
  <div class="str-controlbar-wrap">
    <div class="str-controlbar app-layout app-layout--gutters">
      <div class="str-tablist" role="tablist">
        <div role="tab" aria-selected="true">
          <span onclick="window.location.href='#'">Feedback</span>
        </div>
      </div>
    </div>
  </div>
  <!--End Tab Navigation-->

  <!--Thống kê điểm đánh giá-->
  <div class="app-layout app-layout--gutters">
    <div class="fdbk-overall-rating">
      <h2 class="fdbk-overall-rating__title"> <span>Điểm đánh giá</span></h2>
      <div class="fdbk-overall-rating__details">
        <div class="rating-element">
          <p style="color: green;">Tích cực</p>
          <a href="#"><span>${tichCuc}</span></a>
        </div>
        <div class="rating-element">
          <p style="color: orange;">Trung lập</p>
          <a href="#"><span>${trungLap}</span></a>
        </div>
        <div class="rating-element">
          <p style="color: red">Tiêu cực</p>
          <a href="#"><span>${tieuCuc}</span></a>
        </div>
      </div>
    </div>
    <!--End Thống kê điểm đánh giá-->

    <!--Chi tiết đánh giá-->
    <div class="fdbk-seller-rating" align="center">
      <h2 class="fdbk-seller-rating__title"> <span>Điểm Trung Bình</span> </h2>
      <h1>${trungBinh }</h1>
    </div>
    <!--End Chi tiết đánh giá-->

    <!--Danh sách đánh giá người dùng-->
    <div class="fdbk-detail-list">
      <h2 class="fdbk-detail-list__title">
        <span>Đánh giá của người mua </span>
        <span class="SECONDARY">(${tongNX})</span>
      </h2>

      <!--Feedback mode: positive (tích cực)-->
      <div class="fdbk-container">
      <c:forEach items="${nhanXets}" var="o">
      <div class="fdbk-container__details__info">
          <!--Icon-->
          <div class="fdbk-container__details__info_icon">
            ${o.getSao()} ⭐
          </div>
          <!--Name Id-->
          <div class="fdbk-container__details__info__username">
            <span><h5>${o.getMaTK()}</h5></span>
          </div>
          <!--Time-->
          <ul class="fdbk-container__details__info_divide">
            <li><span>${o.getNgayDG()}</span></li>
          </ul>
        </div>
        <!--Comment-->
        <span><h4 style="color: black;">${o.getNhanXet()}</h4>
        </span>
        <hr>
        </c:forEach>
      </div>

  <!--Button-->
  <div class="Phan Trang" align="center">
    <c:forEach begin="1" end="${endPage}" var="i">
      		<a href="FeedbackControl?startPage=${i}" style="font-size: 1.5em; color: red; margin: 0.7em; border: 2px solid #b1154a; background-color: #00e1ff">${i}</a>
      	</c:forEach>
      </div>
  </div>
</body>

</html>