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
              <li><a href="RecentlyviewedControl">Đã xem gần đây</a></li>
              <li><a href="OrderControl">Đã mua</a></li>
              <li class="selected"><a href="NopayControl">Chưa thanh toán</a></li>

            </ul>
          </section>
        </div>
        <div class="grid__cell grid__cell--13of16 m-page-middle full-width">
          <div class="m-river summary ">
            <div class="m-river__body">
              

              <div class="m-container container-2" id="container-2-anchor" type="MyebayWatchlistModule"
                name="ITEM_CONTAINER" container-id="container-2">
                <div class="title-container">
                  <h2 class="title large-text-2">Chưa thanh toán</h2>
                </div>
                <div class="container-actions border-header bottom-padding"></div>
               <c:forEach items="${NoPay}" var="o">
                <div class="m-container__body">
                  <div class="m-container__body--items">
                    <div class="m-container-items BuyingActivityDwebModule">
                      <div class="m-item-card">
                        <div class="m-container-item-layout-row m-container-item-layout-row__body">
                          <div class="container-item-col container-item-col-img">
                            <a href="detail?pid=${o.maSach }&amp;maKH=${sessionScope.acc.maTK}">
                              <div class="m-image"><img
                                  src="${o.getAnh()}"
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
                              <div><span class="POSITIVE BOLD">${o.getDonGia()} VNĐ</span></div>
                            </div>
                         
                          </div>
                          <div class="container-item-col container-item-col-cta">
                            <div class="container-item-col-cta__item">
                              <div class="m-cta">
                                <a href="cart" class="default primary fake-btn fake-btn--fluid fake-btn--primary">
                                  Thanh toán
                                </a>
                              </div>
                            </div>
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

</html>