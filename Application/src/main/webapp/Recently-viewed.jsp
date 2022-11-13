<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="font-marketsans mdl-js">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BookStore - Recently viewed</title>
  <link rel="stylesheet" href="css/recently.css">
</head>

<body>
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
                  <li class="medium-text m-tab m-tab__title fake-tabs__item">
                    <a href="#">Account</a>
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
              <li class="selected"><a href="RecentlyviewedControl">Đã xem gần đây</a></li>
              <li><a href="OrderControl">Đã mua</a></li>
              <li><a href="NopayControl">Chưa thanh toán</a></li>
            </ul>
          </section>
        </div>
        <div class="grid__cell grid__cell--13of16 m-page-middle full-width">
          <div class="m-river summary ">
            <div class="m-container__header border-header">
              <div class="title-container">
                <h2 class="title large-text-2">Đã xem gần đây</h2>
              </div>
            </div>
             
            <div class="m-rvi-container">
            <c:forEach items="${lastSeen}" var="o">
              <div class="container-column">
                <div class="container-item"><a href="#">
                    <div class="m-image">
                      <img src="${o.getAnh()}">
                    </div>
                    <div class="container-item__title medium-text">
                      <a href="#">${o.getTenSach() }</a>
                    </div>
                    <div class="container-item__locator">
                      <span class="BOLD">${o.getDonGia()} VNĐ</span>
                    </div>
                  </a></div>
              </div>
              </c:forEach>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>