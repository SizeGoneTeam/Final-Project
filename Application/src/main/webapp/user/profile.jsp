<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="viewport" content="width=1240,shrink-to-fit=no" />
    
        <link
          rel="stylesheet"
          data-modern="true"
          href="./Shopee Việt Nam _ Mua và Bán Trên Ứng Dụng Di Động Hoặc Website_files/bundle.c58d9ed1d023c47b.css"
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
          href="./Shopee Việt Nam _ Mua và Bán Trên Ứng Dụng Di Động Hoặc Website_files/1714.48f8bc255163fcad.css"
        />
    
        <script
          type="text/javascript"
          id="sp-af-c9349935"
          src="./Shopee Việt Nam _ Mua và Bán Trên Ứng Dụng Di Động Hoặc Website_files/04d858199d5f5876b8977ff54f296aafebd498a6.js.download"
        ></script>
    
    
        </style>
    
        <link
          rel="stylesheet"
          type="text/css"
          href="./Shopee Việt Nam _ Mua và Bán Trên Ứng Dụng Di Động Hoặc Website_files/2825.c1fba5fdd46028ab.css"
        />
        
        <link rel="stylesheet" type="text/css" href="styles/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="styles/custom.css"/>    
    </head>

    <body>
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
                                          placeholder="${sessionScope.acc.hoTen}"
                                          maxlength="255"
                                          name="fullName"
                                          value=""
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
                                          placeholder="${sessionScope.acc.email}"
                                          maxlength="255"
                                          name="email"
                                          value=""
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
                                          placeholder="${sessionScope.acc.phone}"
                                          maxlength="255"
                                          name="phoneNumber"
                                          value=""
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

    </html>