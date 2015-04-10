<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Cloud Edit</title>
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
			<link rel="stylesheet" href="css/jquery-ui.css">
			<link rel="stylesheet" type="text/css" href="css/jquery-ui-custom.css">
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
			<div class="wrapper style3">
				<article id="work">
				<br>
				<br>
					<div class="container">
						<div class="row">
							<div style="width:95%">
								<section class="doc style2" >
									<h3><i class="fa fa-arrow-circle-down fa-lg"></i> API Endpoint</h3>
									<p><a href="http://cloudedit-coen691p.appspot.com">http://cloudedit-coen691p.appspot.com</a></p>
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Upload an image</h4>
									<p><b>POST</b> /images/upload
									   <br><u>src</u><span>The url of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Rotate</h4>
									<p><b>GET</b> /images/rotate
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>angle</u><span>The angle of rotation in degree</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Resize</h4>
									<p><b>GET</b> /images/resize
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>width</u><span>The width (pixel) of the result image</span>
									   <br><u>height</u><span>The height (pixel) of the result image</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Exposure</h4>
									<p><b>GET</b> /images/exposure
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>brightness</u><span>The brightness level [-100%, 100%]</span>
									   <br><u>contrast</u><span>The contrast level [-100%, 100%]</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Color</h4>
									<p><b>GET</b> /images/color
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>R</u><span>The red level [-100%, 100%]</span>
									   <br><u>G</u><span>The green level [-100%, 100%]</span>
									   <br><u>B</u><span>The blue level [-100%, 100%]</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> HSV</h4>
									<p><b>GET</b> /images/hsv
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>Hue</u><span>The red level [-100%, 100%]</span>
									   <br><u>Saturation</u><span>The green level [-100%, 100%]</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: grayscale</h4>
									<p><b>GET</b> /images/grayscale
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: negate</h4>
									<p><b>GET</b> /images/negate
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: grayscale</h4>
									<p><b>GET</b> /images/grayscale
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: vignette</h4>
									<p><b>GET</b> /images/vignette
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: oil paint</h4>
									<p><b>GET</b> /images/oilpaint
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: gradient fade</h4>
									<p><b>GET</b> /images/gfade
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: sepia</h4>
									<p><b>GET</b> /images/sepia
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: pixelate</h4>
									<p><b>GET</b> /images/pixelate
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>pixel</u><span>pixelation squares</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: blur</h4>
									<p><b>GET</b> /images/blur
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>level</u><span>blur level (range: 1-2000)</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: sharpen</h4>
									<p><b>GET</b> /images/sharpen
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>level</u><span>sharpen level (range: 1-2000)</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Effect: sharpen</h4>
									<p><b>GET</b> /images/sharpen
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>level</u><span>sharpen level (range: 1-2000)</span>
									</p>
									
									<h4><i class="fa fa-arrow-circle-right fa-lg"></i> Overlay: frame</h4>
									<p><b>GET</b> /images/frame
									   <br><u>public_id</u><span>The public ID of the image you wish to process</span>
									   <br><u>pixel</u><span>the pixel width of the border</span>
									</p>
								</section>
							</div>
						</div>
					</div>
				</article>
			</div>
			
		<!-- footer -->
		<jsp:include page="_footer.jsp" flush="true"/>
	</body>
</html>