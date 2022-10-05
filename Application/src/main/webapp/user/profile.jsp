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
                                      <div class="J7g-AJ">${sessionScope.acc.user}</div>
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
                                          placeholder="${sessionScope.acc.name}"
                                          maxlength="255"
                                          name="userName"
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
                                    <div class="_2MJTPE">
                                      <div class="J7g-AJ">
                                        ${sessionScope.acc.email}
                                      </div>
                                      <button class="OcJZJm">Thay đổi</button>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM">
                                    <label>Số điện thoại</label>
                                  </div>
                                  <div class="v1Bl9+">
                                    <div class="_2MJTPE">
                                      <div class="J7g-AJ">${sessionScope.acc.phoneNumber}</div>
                                      <button class="OcJZJm">Thay đổi</button>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Giới tính</label></div>
                                  <div class="v1Bl9+">
                                    <div class="fkl4oC">
                                      <div
                                        class="stardust-radio-group"
                                        role="radiogroup"
                                      >
                                        <div
                                          class="stardust-radio"
                                          tabindex="0"
                                          role="radio"
                                          aria-checked="false"
                                        >
                                          <div class="stardust-radio-button">
                                            <div
                                              class="stardust-radio-button__outer-circle"
                                            >
                                              <div
                                                class="stardust-radio-button__inner-circle"
                                              ></div>
                                            </div>
                                          </div>
                                          <div class="stardust-radio__content">
                                            <div class="stardust-radio__label">
                                              Nam
                                            </div>
                                          </div>
                                        </div>
                                        <div
                                          class="stardust-radio"
                                          tabindex="0"
                                          role="radio"
                                          aria-checked="false"
                                        >
                                          <div class="stardust-radio-button">
                                            <div
                                              class="stardust-radio-button__outer-circle"
                                            >
                                              <div
                                                class="stardust-radio-button__inner-circle"
                                              ></div>
                                            </div>
                                          </div>
                                          <div class="stardust-radio__content">
                                            <div class="stardust-radio__label">
                                              Nữ
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="es8DWX">
                                <div class="_5eQ8vX">
                                  <div class="_3cfiVM"><label>Ngày sinh</label></div>
                                  <div class="v1Bl9+">
                                    <div class="ndO8jd">
                                      <div
                                        class="shopee-dropdown shopee-dropdown--has-selected"
                                      >
                                        <div
                                          class="shopee-dropdown__entry shopee-dropdown__entry--selected"
                                        >
                                          <span>3</span
                                          ><svg
                                            enable-background="new 0 0 11 11"
                                            viewBox="0 0 11 11"
                                            x="0"
                                            y="0"
                                            class="shopee-svg-icon icon-arrow-down"
                                          >
                                            <g>
                                              <path
                                                d="m11 2.5c0 .1 0 .2-.1.3l-5 6c-.1.1-.3.2-.4.2s-.3-.1-.4-.2l-5-6c-.2-.2-.1-.5.1-.7s.5-.1.7.1l4.6 5.5 4.6-5.5c.2-.2.5-.2.7-.1.1.1.2.3.2.4z"
                                              ></path>
                                            </g>
                                          </svg>
                                        </div>
                                      </div>
                                      <div
                                        class="shopee-dropdown shopee-dropdown--has-selected"
                                      >
                                        <div
                                          class="shopee-dropdown__entry shopee-dropdown__entry--selected"
                                        >
                                          <span>Tháng 8</span
                                          ><svg
                                            enable-background="new 0 0 11 11"
                                            viewBox="0 0 11 11"
                                            x="0"
                                            y="0"
                                            class="shopee-svg-icon icon-arrow-down"
                                          >
                                            <g>
                                              <path
                                                d="m11 2.5c0 .1 0 .2-.1.3l-5 6c-.1.1-.3.2-.4.2s-.3-.1-.4-.2l-5-6c-.2-.2-.1-.5.1-.7s.5-.1.7.1l4.6 5.5 4.6-5.5c.2-.2.5-.2.7-.1.1.1.2.3.2.4z"
                                              ></path>
                                            </g>
                                          </svg>
                                        </div>
                                      </div>
                                      <div
                                        class="shopee-dropdown shopee-dropdown--has-selected"
                                      >
                                        <div
                                          class="shopee-dropdown__entry shopee-dropdown__entry--selected"
                                        >
                                          <span>2001</span
                                          ><svg
                                            enable-background="new 0 0 11 11"
                                            viewBox="0 0 11 11"
                                            x="0"
                                            y="0"
                                            class="shopee-svg-icon icon-arrow-down"
                                          >
                                            <g>
                                              <path
                                                d="m11 2.5c0 .1 0 .2-.1.3l-5 6c-.1.1-.3.2-.4.2s-.3-.1-.4-.2l-5-6c-.2-.2-.1-.5.1-.7s.5-.1.7.1l4.6 5.5 4.6-5.5c.2-.2.5-.2.7-.1.1.1.2.3.2.4z"
                                              ></path>
                                            </g>
                                          </svg>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="HqWwZ8">
                                <button
                                  type="submit"
                                  class="btn btn-solid-primary btn--m btn--inline"
                                  aria-disabled="false"
                                >
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