<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/logo/small_logo.png" /> 
    <title> Login | House At Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
     <link href="css/spin.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body ng-app="LoginForm">
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +91 8273816122</a></li>
								<li><a href="contactUs.jsp"><i class="fa fa-envelope"></i> info@houseathome.com</a></li>
							</ul>
						</div>
					</div>
				<!-- put social icons here -->
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="home.jsp"><img src="images/logo/logo_clear.png" alt="" height="40px" /></a>
						</div>
						
					</div>
					
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="home.jsp">Home</a></li>
								<li class="dropdown"><a href="#">Sell/Rent<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="residentialSell.jsp">Residential</a></li>
										<li><a href="commercialSell.jsp">Commercial</a></li> 
										 
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="buy.jsp">Buy<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="residentialBuy.jsp">Residential</a></li>
										<li><a href="commercialBuy.jsp">Commercial</a></li>
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="rent.jsp">On Rent<i class="fa fa-angle-down"></i></a>
								   <ul role="menu" class="sub-menu">
                                        <li><a href="residentialRent.jsp">Residential</a></li>
										<li><a href="commercialRent.jsp">Commercial</a></li> 
										 
                                    </ul>
                                    <li><a href="pgHostel.jsp">PG & Hostel<i class="fa fa-angle-down"></i></a>
                        		 <ul role="menu" class="sub-menu">
                                        <li><a href="pg.jsp">PG</a></li>
										<li><a href="hostel.jsp">HOSTEL</a></li>
	                                    <li><a href="pgHostelRent.jsp">Provide</a></li>
										 
                                    </ul></li>						
								<li><a href="contactUs.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form ng-controller="loginCheck" ng-submit="login()">
							 <input type="email" name="email" ng-model="user.email" class="login_form" placeholder="email" maxlength="37" required/>
                           
                           <br />
                           <input type="password" name="password" class="login_form"  ng-model="user.password" placeholder="password" maxlength="30" required/>
                           
							<span style="color: #70c0db;float: right">
								<a href="forgotPassword.jsp">Forgot Password?</a>
							</span><br />
											<span style="color:red">{{loginError}}</span><br />
							
							<button type="submit" class="btn btn-default">Login</button>
						</form>
						<div class="loader1" id="spinBlock"></div>
						<div class="loader" style="display:none;"id="spinner">
				</div>
					</div><!--/login form-->
				</div>	
				
				<div class="col-sm-1" style="{margin-top: 400px;margin-left: 450px;}">
					<h2 class="or">OR</h2></div><br>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<form ng-controller="signUpCheck" ng-submit="signUp()">
							<input type="text" placeholder="Name" ng-model=newUser.name maxlength="50"  required/>
							<input type="email" placeholder="Email Address" ng-model=newUser.email maxlength="37"/>
					        <input type="text" placeholder="Mobile Number" ng-model=newUser.mobile maxlength="10" required/>
					        <input type="text" placeholder="City" ng-model=newUser.city maxlength="30" required/>					        
							<input type="password" placeholder="Password" ng-model=newUser.password maxlength="30" required/>
							
												<span style="color:red">{{signupError}}</span><br />
							
							
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	
	<%@include file="footer.jsp" %>
  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
    <script type="text/javascript" src="angular/angular.min.js"></script>
    <script src="js/spin.js"></script>
    <script type="text/javascript" src="angular/loginController.js"></script>
    
</body>
</html>