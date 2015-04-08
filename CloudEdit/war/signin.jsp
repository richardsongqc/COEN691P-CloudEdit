<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE HTML>
<html>
	<head>
		<title>Cloud Edit</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/custom/signin.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" />
		<link href="css/skel.css" rel="stylesheet" type="text/css">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<link href="css/style-desktop.css" rel="stylesheet" type="text/css">
		<![endif]-->
		</head>
	<body>

		<!-- Nav -->
			<nav id="nav" style="width: 100%">
				<ul>
					<h2 id="nav-header"><a href="/">Cloud Edit</a></h2>
						<li style="display:block">
						<a href="/signup.jsp" style="float:right;width: 100px;display:block">
						Sign up</a></li>
						<li style="display:block">
						<a href="/signin.jsp" style="float:right;width: 100px;;display:block ">
						Sign in</a></li>
				</ul>
			</nav>

		
		<!-- Work -->
		<div>

			<div class="wrapper style2" style="padding: 7em 0 8em 0;">
				<article class="container" id="top" style="width: 200px">
					<div class="row">
<!-- 						<img alt="" height="300" src="images/icon.jpg" width="450"> -->
						<div class="8u" style="width:500px">
							<header>
								<h1>Sign in</h1>
							</header>
							<p>Enter email and password
							<form id="signin-form" action="login" method="get">
								<input autocomplete="on" name="email" style="left: 5px; top: 0px; width: 70%; height: 39px" type="text" placeholder="email">
								<input name="password" placeholder="password" style="margin-top:10px;margin-bottom:20px;left: 5px; top: 0px; width: 70%; height: 39px;" type="password">
								<button type="submit" class="button button-block" style="vertical-align: top;left: 5px; top: 26px">
								Sign in</button>
							</form>
							<div class="or-spacer">
							<div class="mask"></div>
							  <span><i>or</i></span>
							</div>
							<a href="/login_fb" style="display: inline-block; position: absolute;">
                				<img alt="" src="images/fblogin.png" height="90px" width="250px">
              				</a>		
					  </div>
					</div>
				</article>
			</div>
      
		<!-- footer -->
		<jsp:include page="_footer.jsp" flush="true"/>

	</body>
</html>