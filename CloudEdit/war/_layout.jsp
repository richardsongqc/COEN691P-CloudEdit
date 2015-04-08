<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

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
					<h2 id="nav-header" style="margin-top:20px; margin-left:20px;">Cloud Edit</h2>
					<tag:notloggedin>
						<li style="display:block">
						<a href="/Signup" style="float:right;width: 100px;display:block">
						Sign up</a></li>
						<li style="display:block">
						<a href="/login" style="float:right;width: 100px;;display:block ">
						Log in</a></li>
					</tag:notloggedin>
					<tag:loggedin>
						<li style="display:block">
						<a id="link_logout" href="/logout" style="float:right;display:block">
						Log out</a></li>
						<li style="display:block">
						<a href="#top" style="float:right;display:block">
						${username}</a></li>
					</tag:loggedin>
				</ul>
			</nav>

		<!-- Container  -->
		<jsp:include page="${page}" flush="true"/>
		
		<!-- footer -->
		<div class="wrapper style4">
			<p style="margin-top:2em">© 2015 Concordia University - COEN691P - Team7 </p>
		</div>
	</body>
</html>