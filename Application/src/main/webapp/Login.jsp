<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<link rel="stylesheet" href="css/Login-css.css" type="text/css">
<body>
	    <div id="preloder">
        <div class="loader"></div>
    </div>
	<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Đăng nhập</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Đăng ký</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<form action="login" method="post">
					<div class="group">
					<div class="alert wrong-pass" role="alert">
						<p style="color:red">${mess}</p>
					</div>
						<label for="user" class="label">Tên đăng nhập</label>
						<input name="user" id="user" type="text" class="input" maxlength="10"  minlength="3">
					</div>
					<div class="group">
						<label for="pass" class="label">Mật khẩu (ít nhất 6 kí tự)</label>
						<input name="pass" id="pass" type="password" class="input" data-type="password" maxlength="20"  minlength="6">
					</div>
					<div class="group">
						<input id="check" type="checkbox" class="check" name="rememberMe" checked>
						<label for="check"><span class="icon"></span> Lưu đăng nhập</label>
					</div>
					<div class="group">
						<input type="submit" class="button" value="Đăng nhập">
					</div>
					<div class="hr"></div>
					<div class="foot-lnk">
						<label for="tab-2">Chưa có tài khoản?</a>
					</div>
				</form>
			</div>
			<div class="sign-up-htm">
				<form action="Register" method="post">
					<div class="group">
						<p style="color:red">${mess}</p>
						<label for="user" class="label">Tên đăng nhập</label>
						<input name="user" id="user" type="text" class="input" maxlength="10"  minlength="3">
					</div>
					<div class="group">
						<label for="pass" class="label">Mật khẩu (ít nhất 6 kí tự)</label>
						<input name="pass" id="pass" type="password" class="input" data-type="password" maxlength="20"  minlength="6">
					</div>
					<div class="group">
						<label for="pass" class="label">Nhập lại mật khẩu</label>
						<input name="re_pass" id="pass" type="password" class="input" data-type="password" maxlength="20"  minlength="6">
					</div>
					<div class="group">
						<input type="submit" class="button" value="Đăng ký">
					</div>
					<div class="hr"></div>
					<div class="foot-lnk">
						<label for="tab-1">Đã có tài khoản?</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>