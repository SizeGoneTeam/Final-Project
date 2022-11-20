<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
      <link rel="stylesheet" type="text/css" href="../css/style.css"/>    
      <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="viewport" content="width=1240,shrink-to-fit=no" />
    
        <link
          rel="stylesheet"
          data-modern="true"
          href="./styles_main/bundle.c58d9ed1d023c47b.css"
        />
    
        <title>
          Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website
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
							<li><a href="AdminProduct">Admin</a></li>
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
							item: <span><a href="NapTien.jsp">${sessionScope.acc.tien} USD</a></span>
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
                          <h1 class="QvBZmg">Hồ sơ của tôi</h1>
                          <div class="ItV+hT">
                            Quản lý thông tin hồ sơ để bảo mật tài khoản
                          </div>
                        </div>
                        <div class="xbLgBv">
                          <div class="cfTCNE">
                            <form action="profile">
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM">
                                    <label>Tên đăng nhập</label>
                                  </div>
                                  <div class="v1Bl9+">
                                    <div class="_2MJTPE">
                                      <div class="J7g-AJ">${sessionScope.acc.UName}</div>
                                      <button class="OcJZJm"></button>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Tên</label></div>
                                  <div class="v1Bl9+">
                                    <div class="input-with-validator-wrapper">
                                      <div class="input-with-validator">
                                        <input
                                          type="text"
                                          maxlength="255"
                                          name="fullName"
                                          value="${sessionScope.acc.hoTen}"
                                        />
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Email</label></div>
                                  <div class="v1Bl9+">
                                    <div class="input-with-validator-wrapper">
                                      <div class="input-with-validator">
                                        <input
                                          type="text"
                                          maxlength="255"
                                          name="email"
                                          value="${sessionScope.acc.email}"
                                        />
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Số điện thoại</label></div>
                                  <div class="v1Bl9+">
                                    <div class="input-with-validator-wrapper">
                                      <div class="input-with-validator">
                                        <input
                                          type="text"
                                          maxlength="255"
                                          name="phoneNumber"
                                          value="${sessionScope.acc.phone}"
                                        />
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Ngày Sinh</label></div>
                                  <div class="v1Bl9+">
                                    <div class="input-with-validator-wrapper">
                                      <div class="input-with-validator">
                                        <input
                                          type="date"
                                          name="dateOfBirth"
                                          value="${sessionScope.acc.dateOfBirth.toString()}"
                                        />
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="HqWwZ8">
                                <button type="submit" class="btn btn-solid-primary btn--m btn--inline" aria-disabled="false">
                                  Lưu
                                </button>
                              </div>
                            </form>
                          </div>
                        </div>
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
    <script src="js/main.js"></script>
    

    </html>