<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>

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
            height: auto;
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
            background: linear-gradient(hsla(0, 0%, 100%, .7), #fff);
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
            border: 1px solid rgba(0, 0, 0, .14);
            transition: border-color .3s ease-in-out, box-shadow .3s ease-in-out, background-color .3s ease-in-out;
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
            display: none;
            /* Hidden by default */
            position: fixed;
            /* Stay in place */
            z-index: 1;
            /* Sit on top */
            left: 0;
            top: 0;
            width: 100%;
            /* Full width */
            height: 100%;
            /* Full height */
            overflow: auto;
            /* Enable scroll if needed */
            background-color: rgb(0, 0, 0);
            /* Fallback color */
            background-color: rgba(0, 0, 0, 0.4);
            /* Black w/ opacity */
            padding-top: 60px;
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 5px auto;
            /* 15% from the top and centered */
            border: 1px solid #888;
            width: 35%;
            /* Could be more or less, depending on screen size */
        }

        /* Add Zoom Animation */
        .animate {
            -webkit-animation: animatezoom 0.6s;
            animation: animatezoom 0.6s
        }

        @-webkit-keyframes animatezoom {
            from {
                -webkit-transform: scale(0)
            }

            to {
                -webkit-transform: scale(1)
            }
        }

        @keyframes animatezoom {
            from {
                transform: scale(0)
            }

            to {
                transform: scale(1)
            }
        }
    </style>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <%@include file="header.jsp" %>

    <!-- Shoping Cart Section Begin -->
    <script>
        function totalPrice() {
            var input = document.getElementsByClassName('shoping__cart__price');
            var total = 0;
            var totalShipping = 0;
            for (var i = 0; i < input.length; i++) {
                if (document.getElementsByClassName('shoping__cart__price').item(i).parentElement.firstElementChild.firstElementChild.checked) {
                    total += Number(document.getElementsByClassName('shoping__cart__price').item(i).innerText.replace('VND', ''));
                    totalShipping += Number(document.getElementsByClassName('shipping_cost').item(i).innerText.replace('VND', ''));
                }
            }
            document.getElementsByClassName('shoping__checkout').item(0).children.item(1).firstElementChild.firstElementChild.innerText= total;
            document.getElementsByClassName('shoping__checkout').item(0).children.item(1).children.item(1).firstElementChild.innerText= totalShipping;
            document.getElementsByClassName('shoping__checkout').item(0).children.item(1).lastElementChild.firstElementChild.innerText = total + totalShipping;

            setPrice();
        }
        function checkAll() {
            var input = document.getElementsByClassName('shoping__cart__price');
            if (document.getElementsByClassName('shoping__cart__table').item(0).firstElementChild.firstElementChild.firstElementChild.firstElementChild.firstElementChild.checked) {
                for (var i = 0; i < input.length; i++) {
                    document.getElementsByClassName('shoping__cart__price').item(i).parentElement.firstElementChild.firstElementChild.checked=true;
                }
            }
            else {
                for (var i = 0; i < input.length; i++) {
                    document.getElementsByClassName('shoping__cart__price').item(i).parentElement.firstElementChild.firstElementChild.checked=false;
                }
            }
            totalPrice();
        }
        function setPrice() {
            var input = document.getElementsByClassName('price').item(0).innerText;
            for (var i = 0; i < input.length; i++) {
                if (!document.getElementsByClassName('price').item(i).innerText.includes('VND')) {
                    document.getElementsByClassName('price').item(i).innerText += ' VND';
                }   
            }
        }
    </script>
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th style="width:10px;">
                                        <input type="checkbox" title="Check all" onclick="checkAll()" />
                                    </th>
                                    <th class="shoping__product">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Phí ship</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="o">
                                    <tr>
                                        <td>
                                            <input type="checkbox" onclick="totalPrice()" />
                                            <div id='startUserID${o.tbSach.maSach}' style='display: none;'>${o.tbSach.nguoiSoHuu.maTK}</div>
                                        </td>
                                        <td class="shoping__cart__item">
                                            <a href="detail?pid=${o.tbSach.maSach }&amp;maKH=${sessionScope.acc.maTK}" class="latest-product__item">
                                                <div class="latest-product__item__pic">
                                                    <img src="${o.tbSach.anh}" alt="">
                                                </div>
                                                <div class="latest-product__item__text">
                                                    <h6>${o.tbSach.tenSach}</h6>
                                                </div>
                                            </a>
                                        </td>
                                        <td class="shoping__cart__price price">
                                            ${o.tbSach.donGia}
                                        </td>
                                        <td id="shipping_cost${o.tbSach.maSach}" class="shipping_cost price">0<td>
                                    </tr>
                                    <script>
                                        $(document).ready(function() {
                                            $.ajax({
                                                url : 'shipping',
                                                data : {
                                                    startUserID : $('#startUserID${o.tbSach.maSach}').text(),
                                                    targetUserID: '${sessionScope.acc.maTK}'
                                                },
                                                success : function(responseText) {
                                                    $('#shipping_cost${o.tbSach.maSach}').text(responseText);
                                                    setPrice();
                                                }
                                            });
                                        });
                                    </script>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div style="padding: 28px 30px 24px;">
                        <div style="display: flex;
                        align-items: center;
                        justify-content: space-between;">
                            <div style="display: flex;
                            align-items: center;
                            font-size: 1.25rem;
                            color: #ee4d2d;
                            margin-bottom: 20px;
                            text-transform: capitalize;
                            flex: 1 1 auto;">
                                <div>
                                    Địa chỉ nhận hàng
                                </div>
                            </div>
                        </div>
                        <div style="display: flex;
                        align-items: center;">
                            <div>
                                <div style="display: flex;
                                align-items: center;
                                font-size: 1rem;
                                word-break: break-word;">
                                    <div style="font-weight: 700;
                                    color: #222;">${addresses[0].hoVaTen} ${addresses[0].sdt}</div>
                                    <div style="margin-left: 20px;
                                    word-break: break-word;">${addresses[0].diaChi} ${addresses[0].tenPhuong} ${addresses[0].tenQuan} ${addresses[0].tbTinhThanh.tinhThanh}</div>
                                </div>          
                            </div>
                            <div style="color: #4080ee;
                            text-transform: capitalize;
                            margin-left: 2.5rem;
                            cursor: pointer;" onclick="document.getElementById('id00').style.display='block'">Thay đổi</div>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="." class="primary-btn cart-btn">Tiếp tục mua hàng</a>
                        <a href="cart" class="primary-btn cart-btn cart-btn-right">Cập nhật giỏ hàng</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue" style="display:none">
                        <div class="shoping__discount">
                            <h5>Discount Codes</h5>
                            <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">APPLY COUPON</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng tiền</h5>
                        <ul>
                            <li>Tổng tiền hàng <span class="price">0</span></li>
                            <li>Phí ship <span class="price">${shipping}</span></li>
                            <li>Tổng thanh toán <span class="price">0</span></li>
                        </ul>
                        <a href="#" class="primary-btn">Thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <c:forEach items="${addresses}" var="o">
        <div id="id00" class="form-container modal">
            <div class="box modal-content animate">
                <div class="heading">Chọn địa chỉ</div>

                <form action="address" method="post">
                    <div class="form-inside">
                        <div class="form-content">
                            <div class="ApAubL nn3Z+6"
                            style="display:flex;padding: 18px 0 20px;border-top: 1px solid rgba(0,0,0,.09);">
                            <div style="padding: 0px 10px 0px 0px;">
                            <input type='radio' name='' />
                            </div>
                            <div class="_221a6W" style="min-width: 0;width: 100%; display: block;">
                                <div role="heading" class="FSlv-V m3QHyX"
                                    style="margin-bottom: 4px; justify-content: space-between;display: flex;">
                                    <div class="nFbAe4 beZuCH"
                                        style="    margin-right: 8px; flex-grow: 1; overflow-x: hidden; display: flex;">
                                        <span class="_30MS7O VKNC5l" style="display: inline-flex;align-items: center;">
                                            <div class="tziqvJ"
                                                style="    overflow-x: hidden;text-overflow: ellipsis;white-space: nowrap;">
                                                ${o.hoVaTen}</div>
                                        </span>
                                        <div class="kTdq3r" style="margin: 0px 5px;">|</div>
                                        <div role="row" class="bRMEUm _2bzRo+ _4DcXuJ"
                                            style="white-space: nowrap;display: flex;align-items: center;">${o.sdt}</div>
                                    </div>
                                </div>

                                <div role="heading" class="FSlv-V m3QHyX"
                                    style="    margin-bottom: 4px;    justify-content: space-between;display: flex;">
                                    <div class="nFbAe4 beZuCH"
                                        style="margin-right: 8px;    flex-grow: 1;overflow-x: hidden;display: flex;">
                                        <div class="xk89A1">
                                            <div role="row" class="_4DcXuJ" style="display: flex;align-items: center;">
                                                ${o.diaChi}</div>
                                            <div role="row" class="_4DcXuJ"
                                                style="    display: flex;    align-items: center;">
                                                ${o.tenPhuong}, ${o.tenQuan}, ${o.tbTinhThanh.tinhThanh}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="_5txhTu aQxJVJ"
                                        style="padding-top: 4px;    flex-basis: 40px;justify-content: flex-end;display: flex; display:none;">
                                        <button class="WTM1cN amiqmV EfkdTP" disabled=""
                                            style="white-space: nowrap;    background-color: #fff;    padding: 4px 12px;color: rgba(0,0,0,.87);border: 1px solid rgba(0,0,0,.26);opacity: .7;">
                                            Thiết lập mặc định
                                        </button>
                                    </div>
                                </div>
                                <div role="row" class="GM70BR _4DcXuJ"
                                    style="margin-top: 4px;flex-wrap: wrap;display: flex;align-items: center; display:none;">
                                    <span role="mark" class="BQozJg D+-Kud _8-tEK7"
                                        style="margin-right: 0;color: #ee4d2d;border-color: #ee4d2d;margin: 0 4px 4px 0;border-radius: 1px;padding: 2px 4px;border: .5px solid;">Mặc
                                        định</span>
                                </div>
                            </div>
                        </div>

                        <div class="form-nav">
                            <button class="form-nav-back" onclick="document.getElementById('id00').style.display='none'"
                                type="button">Hủy</button>
                            <button class="form-nav-submit" type="submit">Xác nhận</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </c:forEach>

    <script>
        totalPrice();
    </script>

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>


</body>

</html>