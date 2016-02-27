<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PG::House At Home</title>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/homeLoader.css" rel="stylesheet">
	
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
      <script src="angular/angular.min.js"></script>
     <script src="angular/pgHostel.js"></script>
</head><!--/head-->

<body ng-app="pgHostelData"  ng-controller="allPGData">
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
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
							<%if(null==session || null==session.getAttribute("email")) {%>
							<li><a href="login.jsp" class="active"><i class="fa fa-lock"></i> Login</a></li><%}else{ %>
								<li><a href="profile.jsp"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="signout"><i class="fa fa-lock"></i> Log out</a></li>
								<%} %>
							</ul>
						</div>
					</div>
				</div>
			</div>
	          <!--/header-middle-->
	
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
								<li><a href="contactUs.jsp">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						
					</div>
				</div>
			</div>
	      <!--/header-bottom-->
	</header><!--/header-->
	
	
	<section>
		<div class="container">
		<div  ng-repeat="property in pg" style="float: right;margin-left: 30%"><br><br><br><br>
	<div class="col-sm-9 padding-right" style="float: right; width: 950px; ">
					<div class="product-details" style="height: 302px; padding-left:3px;padding-right: 3px"><!--product-details-->
						<div class="col-sm-5" style="width:250px ;height:150px; ;">
							<div class="view-product">
								<img src="images/property/{{property.image}}"  style="height: 260px; alt=""/>
							
							</div>
							
						</div>
						<div class="col-sm-7" style=" padding-left:3px;padding-right: 3px;">
							<div class="product-information" style="width: 120%;height:100% ;padding-top:30px; ;padding-bottom: 30px;"><!--/product-information-->
								<h2 style="color: #70c0db;font-size: 17px;"><img alt="" src="images/icons/rupee.png" height="5%" width="4%"> 
								 {{property.rentroom}}/Room , {{property.type}}/{{property.locality}}</h2>
								<p >Property ID: {{property.pid}}
								<input class="btn btn-default" style="background:#70c0db;margin-left: 10%;" type="button" value="Contact {{property.srole}}">								
								<input class="btn btn-default" style="background:#70c0db;" type="button" value="Report Problem">
								</p >
							
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">Address:</b>{{property.address}}
								</p>
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">City:</b>{{property.city}} </p>
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">Highlights:</b>{{property.noOfRooms}}-Room/{{property.furnish}}/{{property.availability}}-{{property.possession}}/{{property.bathroom}} Bathroom</p>
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">Description:</b>{{property.description}}</p>
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">Conditions:</b>{{property.conditions}}</p>
								<p style="font-weight: 250;font-size: 14px;"><b style="color: #70c0db">{{property.srole}}:</b>{{property.sname}}</p>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
	
	</div><br><br><br></div>
		
		
		
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar" >
						<h2>Quick Look</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Buy
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Apartment </a></li>
											<li><a href="#">Independent Floor </a></li>
											<li><a href="#">House/Villa </a></li>
											<li><a href="#">Farm House</a></li>
											<li><a href="#">Serviced Apartments </a></li>
											<li><a href="#">Shops </a></li>
											<li><a href="#">Showrooms </a></li>
											<li><a href="#">Agricultural/Farm Land </a></li>
											<li><a href="#">Industrial Lands/Plots</a></li>
											<li><a href="#">Hotel/Resorts </a></li>
											<li><a href="#">Warehouse</a></li>
											<li><a href="#">Factory</a></li>
											<li><a href="#">Bussiness center </a></li>
											<li><a href="#">Others </a></li>
											
										</ul>
									</div>
								</div>
							</div><br />
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#mens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Rent
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											
											<li><a href="#">Apartment </a></li>
											<li><a href="#">Independent Floor </a></li>
											<li><a href="#">House/Villa </a></li>
											<li><a href="#">Farm House</a></li>
											<li><a href="#">Serviced Apartments </a></li>
											<li><a href="#">Shops </a></li>
											<li><a href="#">Showrooms </a></li>
											<li><a href="#">Agricultural/Farm Land </a></li>
											<li><a href="#">Industrial Lands/Plots</a></li>
											<li><a href="#">Hotel/Resorts </a></li>
											<li><a href="#">Warehouse</a></li>
											<li><a href="#">Factory</a></li>
											<li><a href="#">Bussiness center </a></li>
											<li><a href="#">Others </a></li>
										</ul>
									</div>
								</div>
							</div>
							<br />
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
											Sell/On Rent
										</a>
									</h4>
								</div>
								
							</div>
							<br />
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          Hostels										</a>
									</h4>
								</div>
								
							</div>
					           <br />
					           	<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          PG's										</a>
									</h4>
								</div>
								
							</div>
							<br />
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          Top Projects										</a>
									</h4>
								</div>
								
							</div>
							<br />
							<div class="brands_products"><!--brands_products-->
							<h2></h2>
							</div><br />
							
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          Ask a Question										</a>
									</h4>
								</div>
								
							</div>
							<br />
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          Discuss a Topic										</a>
									</h4>
								</div>
								
							</div>
					           <br />
					           	<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
                                          News										</a>
									</h4>
								</div>
								
							</div>
					           
				
				</div>
			
	</div>		</div>
	
</div>	</section>
	

 <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
</body><%@include file = "../footer.jsp" %>
</html>