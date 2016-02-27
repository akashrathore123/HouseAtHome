var app1= angular.module("homepagedata",[]);
app1.controller('extractbuilder',function($scope,$http,$window){
	

		
	$http({
		method:'GET',
	    url:"topProjects",
	    headers: {'Content-Type': 'application/json'},
	}).
	success(function(data,status,headers,config){
	document.getElementById("loader").style.display="none";
	$scope.builderData = data;
	}).
	error(function(data,status,headers,config){
		$window.location = "error500.jsp";
	});
	
});
app1.controller('extractDealers',function($scope,$http,$window){
	

	$http({
	
	method:'POST',
    url:"topdealers",
    headers: {'Content-Type': 'application/json'},
}).
success(function(data,status,headers,config){
	document.getElementById("loader1").style.display="none";

	$scope.dealerData = data;
   }).
    error(function(data,status,headers,config){
		$window.location = "error500.jsp";

   });
});