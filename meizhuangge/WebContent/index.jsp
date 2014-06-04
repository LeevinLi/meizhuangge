<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台开发</title>
</head>
<!--                       CSS                       -->

<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
	media="screen" />

<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="screen" />

<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
	media="screen" />

<!--                       Javascripts                       -->

<!-- jQuery -->
<script type="text/javascript"
	src="resources/scripts/jquery-1.3.2.min.js"></script>

<!-- jQuery Configuration -->
<script type="text/javascript"
	src="resources/scripts/simpla.jquery.configuration.js"></script>

<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>

<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>


</head>

<body id="login">

	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h1>Simpla Admin</h1>
			<img id="logo" src="resources/images/logo2.png"
				alt="Simpla Admin logo" width="100" height="100" /> 微信公众平台 V2.1
			&COPY;
		</div>

		<div id="login-content">

			<form action="login" method="post">

				<div class="notification information png_bg">
					<div>Just click "Sing in". &nbsp; Fill in the username.</div>
				</div>

				<p>
					<label>Username:</label> <input name="txtUserName" class="text-input"
						type="text" value="${cookie.currentUserName.value}" />
				</p>
				<div class="clear"></div>
				<p>
					<label>Password:</label> <input name="txtUserPwd"
						class="text-input" type="password"
						value="${cookie.currentUserPwd.value}" />
				</p>
				<div class="clear"></div>
				<p id="remember-password">
					<input name="ckbRemPwd" type="checkbox" />Remember me?
				</p>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="Sing in" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
