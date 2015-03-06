<%-- <html>
<body>
	<h1>GAE + Spring 3 MVC REST example</h1>
	
	<h3>Movie : ${movie} , DI message : ${message}</h3>	
</body>
</html> --%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Blue White</title>
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
						<li><a href="support.html">Support</a></li>
						<li><a href="about.html">About Us</a></li>
						<li><a href="blog.html">Blog</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="clr"></div>
				<div class="logo">
					<h1>
						<a href="index.html">ImagePro</a>
					</h1>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<div class="article">
						<h2>Log in</h2>
						<!-- 
						    If the user is anonymous (not logged in), show the login form
						    and social sign in buttons.
						-->
						<sec:authorize access="isAnonymous()">
							<!-- Login form -->
							<div class="panel panel-default">
								<div class="panel-body">
									<h2>
										<spring:message code="label.login.form.title" />
									</h2>
									<!--
						                Error message is shown if login fails.
						            -->
									<c:if test="${param.error eq 'bad_credentials'}">
										<div class="alert alert-danger alert-dismissable">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">&times;</button>
											<spring:message code="text.login.page.login.failed.error" />
										</div>
									</c:if>
									<!-- Specifies action and HTTP method -->
									<form
										action="${pageContext.request.contextPath}/login/authenticate"
										method="POST" role="form">
										<!-- Add CSRF token -->
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
										<div class="row">
											<div id="form-group-email" class="form-group col-lg-4">
												<label class="control-label" for="user-email"><spring:message
														code="label.user.email" />:</label>
												<!-- Add username field to the login form -->
												<input id="user-email" name="username" type="text"
													class="form-control" />
											</div>
										</div>

										<div class="row">
											<div id="form-group-password" class="form-group col-lg-4">
												<label class="control-label" for="user-password"><spring:message
														code="label.user.password" />:</label>
												<!-- Add password field to the login form -->
												<input id="user-password" name="password" type="password"
													class="form-control" />
											</div>
										</div>
										<div class="row">
											<div class="form-group col-lg-4">
												<!-- Add submit button -->
												<button type="submit" class="btn btn-default">
													<spring:message code="label.user.login.submit.button" />
												</button>
											</div>
										</div>
									</form>
									<div class="row">
										<div class="form-group col-lg-4">
											<!-- Add create user account link -->
											<a href="${pageContext.request.contextPath}/user/register"><spring:message
													code="label.navigation.registration.link" /></a>
										</div>
									</div>
								</div>
							</div>
							<!-- Social Sign In Buttons -->
							<div class="panel panel-default">
								<div class="panel-body">
									<h2>
										<spring:message code="label.social.sign.in.title" />
									</h2>
									<div class="row social-button-row">
										<div class="col-lg-4">
											<!-- Add Facebook sign in button -->
											<a href="${pageContext.request.contextPath}/auth/facebook"><button
													class="btn btn-facebook">
													<i class="icon-facebook"></i> |
													<spring:message code="label.facebook.sign.in.button" />
												</button></a>
										</div>
									</div>
									<div class="row social-button-row">
										<div class="col-lg-4">
											<!-- Add Twitter sign in Button -->
											<a href="${pageContext.request.contextPath}/auth/twitter"><button
													class="btn btn-twitter">
													<i class="icon-twitter"></i> |
													<spring:message code="label.twitter.sign.in.button" />
												</button></a>
										</div>
									</div>
								</div>
							</div>
						</sec:authorize>
						<!-- 
						    If the user is already authenticated, show a help message instead
						    of the login form and social sign in buttons.
						-->
						<sec:authorize access="isAuthenticated()">
							<p>
								<spring:message code="text.login.page.authenticated.user.help" />
							</p>
						</sec:authorize>
						<img src="images/facebook-login.jpg" width="230" height="43"
							alt="" class="ilf" />
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
