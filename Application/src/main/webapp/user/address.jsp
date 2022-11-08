<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="viewport" content="width=1240,shrink-to-fit=no" />
    
        <style>
          .form-container {
              z-index: 1;
          }
          .box {
              display: flex;
              flex-direction: column;
              box-sizing: border-box;
              padding: 30px;
              background-color: #fff;
              box-shadow: 0 2px 4px rgb(0 0 0 / 54%);
              border-radius: 3px;
              width: 500px;
          }
          .heading {
              align-items: center;
              display: flex;
              font-size: 20px;
              font-family: Arial, Helvetica, sans-serif;
          }
          .form-inside {
              position: relative;
              padding-top: 15px;
              height: 370px;
              box-sizing: border-box;
          }
          .form-content {
              flex: 1;
              padding-bottom: 66px;
          }
          .form-nav {
              position: absolute;
              bottom: 0;
              left: 0;
              right: 0;
              background: linear-gradient(hsla(0,0%,100%,.7),#fff);
              height: 66px;
              justify-content: flex-end;
              display: flex;
              align-items: flex-end;
          }
          .form-nav-back {
              color: #555;
              align-items: center;
              display: flex;
              justify-content: center;
              outline: none;
              padding: 10px;
              border: 0;
              background: none;
              border-radius: 2px;
              min-width: 140px;
              font-size: 14px;
              cursor: pointer;
          }
          .form-nav-submit {
              color: #fff;
              background-color: #ee4d2d;
              align-items: center;
              display: flex;
              justify-content: center;
              outline: none;
              padding: 10px;
              border: 0;
              border-radius: 2px;
              min-width: 140px;
              font-size: 14px;
              cursor: pointer;
          }
          .form-field {
              width: 100%;
              display: flex;
          }
          .form-input {
              flex: 1;
              position: relative;
              margin-bottom: 15px;
              margin-top: 6px;
          }
          .form-input-box {
              position: relative;
              box-shadow: inset 0 2px 0 0 rgb(0 0 0 / 2%);
              border-radius: 2px;
              height: 40px;
              box-sizing: border-box;
              border: 1px solid rgba(0,0,0,.14);
              transition: border-color .3s ease-in-out,box-shadow .3s ease-in-out,background-color .3s ease-in-out;
              align-items: center;
              display: flex;
          }
          .form-input-content {
              height: 38px;
              box-sizing: border-box;
              width: 100%;
              padding: 10px;
              background-color: transparent;
              flex: 1;
              outline: none;
              font-size: 14px;
              min-width: 0;
              color: #222;
              border: 0;
              word-break: break-all;
              line-height: normal;
              margin: 0;
  
              writing-mode: horizontal-tb !important;
              text-rendering: auto;
              color: fieldtext;
              letter-spacing: normal;
              word-spacing: normal;
              line-height: normal;
              text-transform: none;
              text-indent: 0px;
              text-shadow: none;
              display: inline-block;
              text-align: start;
              appearance: auto;
              -webkit-rtl-ordering: logical;
              cursor: text;
          }
          .form-space {
              width: 16px;
          }
  
          /* The Modal (background) */
          .modal {
              display: none; /* Hidden by default */
              position: fixed; /* Stay in place */
              z-index: 1; /* Sit on top */
              left: 0;
              top: 0;
              width: 100%; /* Full width */
              height: 100%; /* Full height */
              overflow: auto; /* Enable scroll if needed */
              background-color: rgb(0,0,0); /* Fallback color */
              background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
              padding-top: 60px;
          }
  
          /* Modal Content/Box */
          .modal-content {
              background-color: #fefefe;
              margin: 5px auto; /* 15% from the top and centered */
              border: 1px solid #888;
              width: 35%; /* Could be more or less, depending on screen size */
          }
  
          /* Add Zoom Animation */
          .animate {
              -webkit-animation: animatezoom 0.6s;
              animation: animatezoom 0.6s
          }
  
          @-webkit-keyframes animatezoom {
              from {-webkit-transform: scale(0)}
              to {-webkit-transform: scale(1)}
          }
  
          @keyframes animatezoom {
              from {transform: scale(0)}
              to {transform: scale(1)}
          }
      </style>

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
    
        <link
          rel="stylesheet"
          type="text/css"
          href="./styles_main/2825.c1fba5fdd46028ab.css"
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
                        <div class="aBgnwW" style="display:flex">
                          <div style="flex:1">
                            <h1 class="QvBZmg">Địa chỉ của tôi</h1>
                          </div>
                          <div>
                            <div class="sS8qJ1">
                              <div style="display: flex;">
                                <button class="shopee-button-solid shopee-button-solid--primary bXfVa5" onclick="document.getElementById('id00').style.display='block'">
                                  <div class="hH4BC2" style="display:flex;align-items:center;height:40px;padding: 0 20px;">
                                    <div class="_1Gw94p" style="margin-right: 10px;">
                                      <svg enable-background="new 0 0 10 10" viewBox="0 0 10 10" x="0" y="0" class="shopee-svg-icon icon-plus-sign">
                                        <polygon points="10 4.5 5.5 4.5 5.5 0 4.5 0 4.5 4.5 0 4.5 0 5.5 4.5 5.5 4.5 10 5.5 10 5.5 5.5 10 5.5"></polygon>
                                      </svg>
                                    </div>
                                    <div>Thêm địa chỉ mới</div>
                                  </div>
                                </button>
                              </div>
                            </div>
                          </div>
                        </div>
      
                        <div class="xbLgBv" style="display: block;">
                          <div>Địa chỉ</div>     
                          
                          <c:set var="count" value="0" scope="page" />
                          <c:forEach items="${addresses}" var="o">
                            <c:set var="count" value="${count + 1}" scope="page"/>

                            <div class="ApAubL nn3Z+6" style="display:flex;padding: 18px 0 20px;border-bottom: 1px solid rgba(0,0,0,.09);">
                              <div class="_221a6W" style="min-width: 0;width: 100%; display: block;">
                                <div role="heading" class="FSlv-V m3QHyX" style="margin-bottom: 4px; justify-content: space-between;display: flex;">
                                  <div class="nFbAe4 beZuCH" style="    margin-right: 8px; flex-grow: 1; overflow-x: hidden; display: flex;">
                                    <span class="_30MS7O VKNC5l" style="display: inline-flex;align-items: center;">
                                      <div class="tziqvJ" style="    overflow-x: hidden;text-overflow: ellipsis;white-space: nowrap;">${o.hoVaTen}</div>
                                    </span>
                                    <div class="kTdq3r" style="margin: 0px 5px;">|</div>
                                    <div role="row" class="bRMEUm _2bzRo+ _4DcXuJ" style="white-space: nowrap;display: flex;align-items: center;">${o.sdt}</div>
                                  </div>
                                  <div class="aQxJVJ" style="flex-basis: 40px;justify-content: flex-end;display: flex;">
                                    <button class="wORiuh" style="white-space: nowrap;padding: 4px;color: #08f;border: 0;background: none;outline: none;" onclick="document.getElementById('id0${count}').style.display='block'">Cập nhật</button>
                                  </div>
                                  <div class="kTdq3r" style="margin: 0px 5px;">|</div>
                                  <form action="address" method="post">
                                    <div class="aQxJVJ" style="flex-basis: 40px;justify-content: flex-end;display: flex;">
                                      <input name="type" value="delete" hidden />
                                      <button class="wORiuh" style="white-space: nowrap;padding: 4px;color: rgb(255, 0, 0);border: 0;background: none;outline: none;" name="id" value="${o.id}">Xóa</button>
                                    </div>
                                  </form>
                                </div>
                                
                                <div role="heading" class="FSlv-V m3QHyX" style="    margin-bottom: 4px;    justify-content: space-between;display: flex;">
                                  <div class="nFbAe4 beZuCH" style="margin-right: 8px;    flex-grow: 1;overflow-x: hidden;display: flex;">
                                    <div class="xk89A1">
                                      <div role="row" class="_4DcXuJ" style="display: flex;align-items: center;">${o.diaChi}</div>
                                      <div role="row" class="_4DcXuJ" style="    display: flex;    align-items: center;">
                                        ${o.tenPhuong}, ${o.tenQuan}, ${o.tbTinhThanh.tinhThanh}
                                      </div>
                                    </div>
                                  </div>
                                  <div class="_5txhTu aQxJVJ" style="padding-top: 4px;    flex-basis: 40px;justify-content: flex-end;display: flex; display:none;">
                                    <button class="WTM1cN amiqmV EfkdTP" disabled="" style="white-space: nowrap;    background-color: #fff;    padding: 4px 12px;color: rgba(0,0,0,.87);border: 1px solid rgba(0,0,0,.26);opacity: .7;">
                                      Thiết lập mặc định
                                    </button>
                                  </div>
                                </div>
                                <div role="row" class="GM70BR _4DcXuJ" style="margin-top: 4px;flex-wrap: wrap;display: flex;align-items: center; display:none;">
                                  <span role="mark" class="BQozJg D+-Kud _8-tEK7" style="margin-right: 0;color: #ee4d2d;border-color: #ee4d2d;margin: 0 4px 4px 0;border-radius: 1px;padding: 2px 4px;border: .5px solid;">Mặc định</span>
                                </div>
                              </div>
                            </div>



                            <div id="id0${count}" class="form-container modal">
                              <div class="box modal-content animate">
                                  <div class="heading">Cập nhật địa chỉ</div>
                      
                                  <form action="address" method="post">
                                      <div class="form-inside">
                                          <div class="form-content">

                                            <input name="type" value="update" hidden />
                                            <input name="id" value="${o.id}" hidden />
                      
                                              <div class="form-field">
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                          <input class="form-input-content" type="text" placeholder="Họ và tên" autocomplete="name" maxlength="64" value="${o.hoVaTen}" name="fullName">
                                                      </div>
                                                  </div>
                                                  <div class="form-space"></div>
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                          <input class="form-input-content" type="text" placeholder="Số điện thoại" autocomplete="user-address-phone" value="${o.sdt}" name="phone">
                                                      </div>
                                                  </div>
                                              </div>
                      
                                              <div class="form-field">
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                        <select class="form-input-content" required name="province">
                                                          <option value="${o.tbTinhThanh.id}" hidden>${o.tbTinhThanh.tinhThanh}</option>
                                                          <c:forEach items="${provinces}" var="p">
                                                            <option value="${p.id}">${p.tinhThanh}</option>
                                                          </c:forEach>
                                                      </select>
                                                      </div>
                                                  </div>
                                              </div>
                      
                                              <div class="form-field">
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                          <input class="form-input-content"
                                                              type="text" placeholder="Quận/Huyện" value="${o.tenQuan}" name="city">
                                                      </div>
                                                  </div>
                                              </div>
                      
                                              <div class="form-field">
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                            <input class="form-input-content"
                                                                type="text" placeholder="Phường/Xã" value="${o.tenPhuong}" name="ward">
                                                      </div>
                                                  </div>
                                              </div>
                      
                                              <div class="form-field">
                                                  <div class="form-input">
                                                      <div class="form-input-box">
                                                          <input class="form-input-content"
                                                              type="text" placeholder="Địa chỉ" value="${o.diaChi}" name="street">
                                                      </div>
                                                  </div>
                                              </div>
                      
                                              <div class="up5fr-" style="display:none"><label class="PV5AVe"><input class="hd41si" type="checkbox">
                                                      <div class="EAm2pi"></div>Đặt làm địa chỉ mặc đinh
                                                  </label></div>
                                          </div>
                      
                                          <div class="form-nav">
                                              <button class="form-nav-back" onclick="document.getElementById('id0${count}').style.display='none'" type="button">Trở Lại</button>
                                              <button class="form-nav-submit" type="submit">Hoàn thành</button>
                                          </div>
                                      </div>
                                  </form>
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
          </div>

          <div id="id00" class="form-container modal">
            <div class="box modal-content animate">
                <div class="heading">Địa chỉ mới</div>
    
                <form action="address" method="post">
                    <div class="form-inside">
                        <div class="form-content">
                            <input name="type" value="add" hidden />
    
                            <div class="form-field">
                                <div class="form-input">
                                    <div class="form-input-box">
                                        <input class="form-input-content" type="text" placeholder="Họ và tên" autocomplete="name" maxlength="64" value="" name="fullName">
                                    </div>
                                </div>
                                <div class="form-space"></div>
                                <div class="form-input">
                                    <div class="form-input-box">
                                        <input class="form-input-content" type="text" placeholder="Số điện thoại" autocomplete="user-address-phone" value="" name="phone">
                                    </div>
                                </div>
                            </div>
    
                            <div class="form-field">
                                <div class="form-input">
                                    <div class="form-input-box">
                                      <select class="form-input-content" required name="province">
                                        <option value="" hidden>Tỉnh/ Thành phố</option>
                                        <c:forEach items="${provinces}" var="o">
                                          <option value="${o.id}">${o.tinhThanh}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                </div>
                            </div>
    
                            <div class="form-field">
                                <div class="form-input">
                                    <div class="form-input-box">
                                        <input class="form-input-content"
                                            type="text" placeholder="Quận/Huyện" value="" name="city">
                                    </div>
                                </div>
                            </div>
    
                            <div class="form-field">
                                <div class="form-input">
                                    <div class="form-input-box">
                                          <input class="form-input-content"
                                              type="text" placeholder="Phường/Xã" value="" name="ward">
                                    </div>
                                </div>
                            </div>
    
                            <div class="form-field">
                                <div class="form-input">
                                    <div class="form-input-box">
                                        <input class="form-input-content"
                                            type="text" placeholder="Địa chỉ" value="" name="street">
                                    </div>
                                </div>
                            </div>
    
                            <div class="up5fr-" style="display:none"><label class="PV5AVe"><input class="hd41si" type="checkbox">
                                    <div class="EAm2pi"></div>Đặt làm địa chỉ mặc đinh
                                </label></div>
                        </div>
    
                        <div class="form-nav">
                            <button class="form-nav-back" onclick="document.getElementById('id00').style.display='none'" type="button">Trở Lại</button>
                            <button class="form-nav-submit" type="submit">Hoàn thành</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    
        <script>
            // Get the modal
            var modal = document.getElementById('id00');
            
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </body>

    </html>