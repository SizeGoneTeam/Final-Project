<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
                <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="../css/nice-select.css" type="text/css">
<link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<link rel="stylesheet" href="../css/toast.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="viewport" content="width=1240,shrink-to-fit=no" />
    
        <link
          rel="stylesheet"
          data-modern="true"
          href="./styles_main/bundle.c58d9ed1d023c47b.css"
        />
    
        <title>
          Password
        </title>
        <meta name="robots" content="noindex" data-rh="true" />
        <meta
          property="og:title"
          content="Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website"
          data-rh="true"
        />
    
        <link
          rel="stylesheet"
          type="text/css"
          href="./styles_main/1714.48f8bc255163fcad.css"
        />
    
        <script
          type="text/javascript"
          id="sp-af-c9349935"
          src="./styles_main/04d858199d5f5876b8977ff54f296aafebd498a6.js.download"
        ></script>
    
    
        </style>
    
        <link
          rel="stylesheet"
          type="text/css"
          href="./styles_main/2825.c1fba5fdd46028ab.css"
        />
        
        <link rel="stylesheet" type="text/css" href="styles/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="styles/custom.css"/>    
    </head>

    <body>
     -<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.jsp"><img src="../image/logobook.png" width="100"  height="50" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="../loadSach">Home</a></li>
							<li><a href="../search?key=">Shop</a></li>
							<li><a href="../FAQControl">FAQ</a></li>
							<c:if test="${sessionScope.acc != null}">
							<c:if test="${sessionScope.acc.getIsAdmin() != 0}">
								<li><a href="../adminpage/DashboardControl">Admin</a></li>
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
        <noscript>
            <iframe
              src="https://www.googletagmanager.com/ns.html?id=GTM-WJZQSJF"
              height="0"
              width="0"
              style="display: none; visibility: hidden"
            ></iframe>
          </noscript>
          <div id="main">
            <div>
              <section class="lF2jXb" tabindex="-1">
                <button class="stardust-button u6BOJM" tabindex="10000">
                  <span class="zV2jR+">bỏ qua nội dung chính</span>
                </button>
              </section>
              <div class="shopee-progress-bar"></div>
              <div class="dYFPlI">
             
                <div class="container pIHdXn">
                  <%@include file="menu.jsp" %>
                  <div class="xMDeox">
                    <div class="Hvae38" role="main">
                      <div class="GDF4Dt">
                        <div class="aBgnwW">
                          <h1 class="QvBZmg">Thêm mật khẩu</h1>
                          <div class="ItV+hT">
                            Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác
                          </div>
                        </div>
      
                        <form action="password">
                          <div><i>${message}</i></div>
                          <div class="fo5IeT" style="padding-top: 1.5625rem;    flex-direction: column;display: flex;align-items: center;">
                            <div class="Kuz0mN" style="width: 50rem;display: flex;align-items: center;">
                              <div class="A8yLgM" style="width: 100%;margin-bottom: .9375rem;border-radius: .125rem;display: block;">
                                <div class="ltFKuQ" style="display: flex;align-items: center;">
                                  <div class="op-21F" style="text-align: right;width: 20%;display: block;">
                                    <label class="mlaS58" for="password" style="color: #757575;text-transform: capitalize;text-align: right;">Mật khẩu cũ</label>
                                  </div>
                                  <div class="iqUYOb" style="width: 50%;box-sizing: border-box;padding-left: 1.25rem;padding-right: 1.25rem;display: flex;">
                                    <input
                                      id="password"
                                      class="-wQUjw kpK-3W"
                                      type="password"
                                      autocomplete="off"
                                      name="oldPassword"
                                      value=""
                                       required
                                      style="width: 100%;padding: .625rem;box-sizing: border-box;
                                      outline: none;
                                      border: 1px solid rgba(0,0,0,.14);
                                      height: 2.5rem;
                                      word-break: break-all;
                                      line-height: normal;
                                      color: inherit;
                                      font: inherit;
                                      margin: 0;"
                                    />
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="Kuz0mN" style="width: 50rem;display: flex;align-items: center;">
                              <div class="A8yLgM" style="width: 100%;margin-bottom: .9375rem;border-radius: .125rem;display: block;">
                                <div class="ltFKuQ" style="display: flex;align-items: center;">
                                  <div class="op-21F" style="text-align: right;width: 20%;display: block;">
                                    <label class="mlaS58" for="password" style="color: #757575;text-transform: capitalize;text-align: right;">Mật khẩu mới</label>
                                  </div>
                                  <div class="iqUYOb" style="width: 50%;box-sizing: border-box;padding-left: 1.25rem;padding-right: 1.25rem;display: flex;">
                                    <input
                                      id="password"
                                      class="-wQUjw kpK-3W"
                                      type="password"
                                      autocomplete="off"
                                      name="newPassword"
                                      value=""
                                       required
                                      style="width: 100%;padding: .625rem;box-sizing: border-box;
                                      outline: none;
                                      border: 1px solid rgba(0,0,0,.14);
                                      height: 2.5rem;
                                      word-break: break-all;
                                      line-height: normal;
                                      color: inherit;
                                      font: inherit;
                                      margin: 0;"
                                    />
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="Kuz0mN" style="width: 50rem;display: flex;align-items: center;">
                              <div class="A8yLgM" style="width: 100%;margin-bottom: .9375rem;border-radius: .125rem;display: block;">
                                <div class="ltFKuQ" style="display: flex;align-items: center;">
                                  <div class="op-21F" style="text-align: right;width: 20%;display: block;">
                                    <label class="mlaS58" for="passwordRepeat" style="color: #757575;text-transform: capitalize;text-align: right;">Xác nhận mật khẩu</label>
                                  </div>
                                  <div class="iqUYOb" style="width: 50%;box-sizing: border-box;padding-left: 1.25rem;padding-right: 1.25rem;display: flex;">
                                    <input
                                      id="passwordRepeat"
                                      class="-wQUjw kpK-3W"
                                      type="password"
                                      autocomplete="off"
                                      name="newPasswordRepeat"
                                      value=""
                                       required
                                      style="width: 100%;padding: .625rem;box-sizing: border-box;
                                      outline: none;
                                      border: 1px solid rgba(0,0,0,.14);
                                      height: 2.5rem;
                                      word-break: break-all;
                                      line-height: normal;
                                      color: inherit;
                                      font: inherit;
                                      margin: 0;"
                                    />
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="Kuz0mN">
                              <div class="RlzsL7"></div>
                              <div class="vuqET4">
                                <button
                                  type="submit"
                                  class="btn btn-solid-primary btn--m btn--inline"
                                >
                                  Xác nhận
                                </button>
                              </div>
                            </div>
                          </div>
                        </form>
      
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </body>

    </html>