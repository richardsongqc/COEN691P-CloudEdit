<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->
<html>
<head>
<title>Cloud Edit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
</head>
<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="nav_menu">
					<ul>
						<li class="active"><a href="index.html">Home</a></li>
						<%if(null == session.getAttribute("facebook")) {%>
						<li><a href="/login">Sign in</a></li>
						<%}%>
						<%if(null != session.getAttribute("facebook")){%>
						<li><a href="/profile">${facebook.name}</a></li>
						<li><a href="/logout">Log out</a>
						<%}%>
					</ul>
				</div>
				<div class="clr"></div>
				<div class="logo">
					<h1>
						<a href="index.jsp">ImagePro</a>
					</h1>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<div class="article">
						<h2>Log in</h2>
						<a href="login"><img src="images/facebook-login.jpg" width="230" height="43"
							alt="" class="ilf" /></a>
						<div class="clr"></div>
					</div>
					<div>
						<div class="article" style="float: right; display: block">
							<h2>Image conversion in the cloud</h2>
							<img src="images/cloud.png" width="100" height="110" alt="" />
							<p>There is no need to install any software on your computer!
								Select your files from Dropbox and we will do the job for you.</p>
							<div class="clr"></div>
						</div>
						<div class="clr"></div>
						<div class="article" style="float: right; display: block">
							<h2>Multiples supported formats</h2>
							<img src="images/cloud.png" width="100" height="110" alt="" />
							<p>There is no need to install any software on your computer!
								Select your files from Dropbox and we will do the job for you.</p>
							<div class="clr"></div>
						</div>
					</div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="fbg">
			<div class="fbg_resize">
				<div class="col c1">
					<h2>Image Gallery</h2>
					<a href="#"><img src="images/pix1.jpg" width="56" height="56"
						alt="" class="ad" /></a> <a href="#"><img src="images/pix2.jpg"
						width="56" height="56" alt="" class="ad" /></a> <a href="#"><img
						src="images/pix3.jpg" width="56" height="56" alt="" class="ad" /></a>
					<a href="#"><img src="images/pix4.jpg" width="56" height="56"
						alt="" class="ad" /></a>
					<div class="clr"></div>
					<h2>Lorem Ipsum</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec
						libero. <a href="#">Suspendisse bibendum</a>. Cras id urna. Morbi
						tincidunt, orci ac convallis aliquam, lectus turpis. Donec semper
						vulputate nibh id pharetra. Sed sit amet aliquet ligula.
						Pellentesque molestie sem eu dolor luctus egestas auctor elit
						vestibulum.
					</p>
				</div>
				<div class="col c2">
					<h2>Lorem Ipsum</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Curabitur dui nunc, molestie ut porta et, egestas vel justo.
						Mauris nec velit in libero sollicitudin adipiscing non sodales
						sem. Fusce rutrum mauris quis purus vulputate placerat.</p>
					<p>
						Praesent nulla ipsum, congue in tincidunt ut, placerat sed erat. <a
							href="#">Nunc tempor venenatis vehicula</a>. Integer placerat
						ultricies sapien, non pharetra tortor egestas ut. Etiam elit
						dolor, congue eu iaculis non, mollis sed urna. Donec bibendum
						semper nisi non elementum.<br /> Vestibulum imperdiet mattis
						metus quis.
					</p>
				</div>
				<div class="col c3">
					<h2>Contact</h2>
					<p>Praesent dapibus, neque id cursus faucibus.</p>
					<p>
						<strong>Phone:</strong> +1234567<br /> <strong>Address:</strong>
						123 Put Your Address<br /> <strong>E-mail:</strong> <a href="#">info@example.com</a>
					</p>
					<h2>Services</h2>
					<ul class="sb_menu">
						<li><a href="#">consequat molestie</a></li>
						<li><a href="#">sem justo</a></li>
						<li><a href="#">semper</a></li>
					</ul>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="footer">
			<div class="footer_resize">
				<p class="lf">
					&copy; Copyright MyWebSite. Designed by Blue <a
						href="http://www.bluewebtemplates.com/">Website Templates</a>
				</p>
				<ul class="fmenu">
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="support.html">Support</a></li>
					<li><a href="blog.html">Blog</a></li>
					<li><a href="about.html">About Us</a></li>
					<li><a href="contact.html">Contacts</a></li>
				</ul>
			</div>
			<div class="clr"></div>
		</div>
	</div>
</body>
</html>

