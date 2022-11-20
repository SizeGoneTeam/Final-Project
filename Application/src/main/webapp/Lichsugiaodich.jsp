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
   <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
   <link rel="stylesheet" type="text/css" href="./css/style.css"/>  
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
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
                  <li class="medium-text m-tab m-tab__title fake-tabs__item">
                    <a href="SummarybuysideControl">Buy mode</a>
                  </li>
                  <li class="medium-text m-tab selected m-tab__title fake-tabs__item">
                    <a href="SummarysellsideControl">Sell mode</a>
                  </li>
                  
                  <li class="medium-text m-tab selected m-tab__title fake-tabs__item">
                    <a aria-current="page" href="LichsugiaodichControl">Lịch sử giao dịch</a>
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

        <div class="grid__cell grid__cell--13of16 m-page-middle full-width">
          <div class="m-river summary ">
            <div class="m-river__body">
              <div class="m-container container-2" id="container-2-anchor" type="MyebayWatchlistModule"
                name="ITEM_CONTAINER" container-id="container-2">
                <div class="title-container">
                  <h2 class="title large-text-2">Lịch sử giao dịch</h2>
                </div>
                <div class="container-actions border-header bottom-padding"></div>
               <table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Loại giao dịch</th>
				      <th scope="col">Ngày giao dịch</th>
				      <th scope="col">Số tiền</th>
				    </tr>
				  </thead>
				  <tbody>
				 <c:forEach items="${lsgd}" var="o">
				    <tr>
				    <c:if test="${o.getLoaiGD() == 1}">
				      <td>Nạp tiền</td>
				      <td>${o.getNgayTao()}</td>
				      <td style="color: green">+ ${o.getTienGD()}</td>
				    </c:if>
				    <c:if test="${o.getLoaiGD() == 2}">
				      <td>Chuyển tiền</td>
				      <td>${o.getNgayTao()}</td>
				      <c:if test="${o.getNguoiGui() == matk}">
				       <td style="color: red">- ${o.getTienGD()}</td>
				       </c:if>
				       <c:if test="${o.getNguoiNhan() == matk}">
				       <td style="color: green" >+ ${o.getTienGD()}</td>
				       </c:if>
				     </c:if>
				    <c:if test="${o.getLoaiGD() == 3}">
				      <td>Rút tiền</td>
				      <td>${o.getNgayTao()}</td>
				      <td style="color: red">- ${o.getTienGD()}</td>
				    </c:if>

				    </tr>
					</c:forEach>
				  </tbody>
				</table>


              </div>
            </div>
            <div class="product__pagination">
                    	<c:forEach begin="1" end="${endPape}" var="o">
	                        <a href="LichsugiaodichControl?page=${o}">${o}</a>
                        </c:forEach>
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
    <script src="js/main.js"></script>

</html>