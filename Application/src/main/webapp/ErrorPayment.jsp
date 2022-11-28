<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Error payment</title>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300|Montserrat' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/errorpayment.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

</head>

<body>
    <!-- partial:index.partial.html -->
    <div class="background"></div>
    <div class="container">
        
        <!--/.row-->
        <div class="row">
            <div class="modalbox error center animate">
                <div class="icon" style="text-align:center">
                    <span class="material-icons">mood_bad</span>
                </div>
                <!--/.icon-->
                <h1>Oh no!</h1>
                <p>Đã có lỗi xảy ra, Bạn vui lòng thử lại sau
                </p>
                <p style="color: red;">${mess}</p>
                <button type="button" > <a href="loadSach" style="color: red;" >Go home</button>
                <c:if test="${back != null }">
                <button type="button"> <a href="${back}"  style="color: green;" >Back</button>
                </c:if>
            </div>
            <!--/.success-->
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->
    <!-- partial -->
</body>

</html>