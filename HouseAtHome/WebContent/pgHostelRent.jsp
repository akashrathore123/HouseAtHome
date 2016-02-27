<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/logo/small_logo.png" /> 
    <title> On Rent | PG & Hostel </title>
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

<body ng-app="pgHostelData" >
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
							
								<li><a href="profile.jsp"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="signout"><i class="fa fa-lock"></i> Log out</a></li>
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
	
								<div id="spin" style="position:absolute; margin-left: 670px;margin-top: 450px;"></div>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
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
			
	</div>	</div></div></section>
	<span style="font-weight: 300;font-size: 15px;float: right;margin-right: 10%;margin-top: -45%; color: #70c0db">Fields Marked * are mandatory.</span>
	
 		<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
				
				
                <div class="sell-form"  style="margin-left:400px ;margin-top:-500px; width: 850px;">
                     <form id="formname" class="navbar-form navbar-left" ng-controller="pgHostelRent" ng-submit="propertySubmit()" name="formname" novalidate>
                    <span style="color: #70c0db;font-size: 18px;""> Register Your Property Details:</span>
                    <br><br>
                    <div class="form-group">
							<span style="color: #70c0db">*</span>
						    I am:    <input type="radio" class="radio-inline" ng-model="form.role" value="Owner" name="role" id="role1" >Owner
						     <input  type="radio" class="radio-inline" ng-model="form.role" value="Broker" name="role" id="role2">Broker
					         <input type="radio" class="radio-inline" ng-model="form.role" value="Builder" name="role" id="role3">Builder
							<br />
							<span style="color: #70c0db">*</span>
							Type:  <input type="radio" class="radio-inline" ng-model="form.type" value="PG" name="for" id="type1" >PG
						     <input type="radio" class="radio-inline" ng-model="form.type" value="Hostel" name="for" id="type2">Hostel<br>
							
						
							<span style="color: #70c0db">*</span>
							City: <select class="form-control" style="width:272px;height: 30px;" ng-model="form.city" ng-options="cities.name for cities in citiesList" style="width:200px;height: 25px;" id="city" onchange="showCity()"><option  value="">Select</option></select><br><br>
							<div id="otherCity" style="display: none;">
							Other:<input class="form-control"  type="text" style="width: 250px;" ng-model="form.otherCity" value="" id="city1" placeholder="Other City" maxlength="30"></div><br>
							<span style="color: #70c0db">*</span>
							
							Locality:<input type="text"  class="form-control" style="width: 251px;"  ng-model="form.locality" id="locality" maxlength="70" required><br>							
							
							<span style="color: #70c0db">*</span>
							Address:<input type="text" class="form-control" style="width: 258px;" ng-model="form.address" id="address" maxlength="100"><br>
							<span style="color: #70c0db">*</span>
							
							No Of Rooms: <select class="form-control" style="width:272px;height: 30px;" ng-model="form.noOfRooms" ng-options="rooms.number for rooms in roomsList" style="width:200px;height: 25px;" id="noOfRooms"><option  value="">Select</option></select>
							<br>
							
							<span style="color: #70c0db">*</span>
							Rent/Room:<img alt="" src="images/icons/rupee.png" width="12px" height="15px"  >
							<input type="text" class="form-control" style="width: 251px;"" id="rentroom" required ng-model="form.rentroom" maxlength="10" >(in rupees)<br>
							
							
							<span style="color: #70c0db">*</span>
							
							Furnishing:<input type="radio" class="radio-inline" ng-model="form.furnish" value="Furnished" name="role1" id="furnish1">Furnished
						     <input  type="radio" class="radio-inline" ng-model="form.furnish" value="Semifurnished" name="role1" id="furnish2">Semifurnished
					         <input type="radio" class="radio-inline" ng-model="form.furnish" value="Unfurnished" name="role1" id="furnish3">Unfurnished
							<br />
							<span style="color: #70c0db">*</span>
							Bathroom: <select class="form-control" style="width:272px;height: 30px;" ng-model="form.bathroom" ng-options="room.number for room in bathroomList" style="width:200px;height: 25px;" id="bathroom" >
							<option  value="">Select</option></select><br>
							
							Conditions:
							<input value="" class="form-control" style="width: 240px;height: 50px;" type="text" style="width: 200px;height: 50px;" ng-model="form.conditions" maxlength="70" onkeyup="checkCondition()" id="conditions" placeholder="max. 70 characters">
							<span id="counter1"></span><br><br>
						<span style="color: #70c0db">*</span>
							Availability:<input type="radio" class="radio-inline" ng-model="form.availability" id="construction" name="availability" value="Under Construction" onchange="showPossession()" >Under Construction
							
							<input type="radio" class="radio-inline" ng-model="form.availability" name="availability" id="ready" value="Ready to Move" onchange="showPossession()">Ready to Move<br>
							<div id="1" style="display: none;">
														<span style="color: #70c0db">*</span>
							Possession:<select class="form-control" style="width:190px;height: 30px;" ng-model="form.possession" id="possession1" ng-options="possession.name for possession in possessionListUnderConstruction" style="width:200px; height: 25px;"><option  value="">select</option></select><br>
							</div><div id="2" style="display: none;">
																					<span style="color: #70c0db">*</span>
							Possession:<select class="form-control" style="width:190px;height: 30px;" ng-model="form.possession" id="possession2" ng-options="possession.name  for possession in possessionListReadyToMove" style="width:200px;height: 25px;" ><option  value="">select</option></select><br><br>
							</div>
							Description:<input value="" class="form-control" style="width: 240px;height: 50px;" type="text" style="width: 200px;height: 50px;" ng-model="form.description" maxlength="100" onkeyup="checkDescription()" id="description" placeholder="max. 100 characters">
							<span id="counter"></span><br><br>
						<div class="input-group" style="height: 20px;">
  <span class="input-group-addon"  id="basic-addon1">Image:</span>
							
						<input class="form-control" style="height:30px;width: 246px;" name="image" onchange="angular.element(this).scope().uploadFile(this.files)" file-model="image" accept=".png,.jpg,.jpeg" type="file" id="image" placeholder="Property image" />
							
							
												
							</div>
							<span style="color: red;font-weight: 230;font-size: 14px;">{{imageerror}}</span>
								<span style="color: #70c0db;font-weight: 230;font-size: 14px;">{{imagedata}}</span>
				<span class="help-block" style="width: 500px;color: #70c0db;">
										(Note:Only jpg,png or jpeg format is allowed and Max. Size:5 MB)</span>		
							<span style="color: red;font-weight: 230;font-size: 14px;" id="error">{{error}}</span><br><br>
							<button type="submit" class="btn btn-default" id="button">Submit</button>
						
						
						</div>
						</form>
						
						</div></div></div>
						
				
</body><%@include file="footer.jsp" %>
 <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>   
          <script src="js/spin.js"></script>
     
    
 
</html>