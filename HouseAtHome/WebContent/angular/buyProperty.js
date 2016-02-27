var app=angular.module('buypagedata',[]);
app.controller('allBuyData',function($scope,$http,$window){
	var data1=JSON.stringify({category:'residential+commercial',pfor:'sell'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data1
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});
app.controller('commercialBuyData',["ui.router"]).config(function($stateProvider,$scope,$http,$window){
	var data2=JSON.stringify({category:'commercial',pfor:'sell'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data2
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});
app.controller('residentialBuyData',function($scope,$http,$window){
	var data1=JSON.stringify({category:'residential',pfor:'sell'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data1
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});
app.controller('residentialRentData',function($scope,$http,$window){
	var data1=JSON.stringify({category:'residential',pfor:'rent'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data1
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});
app.controller('commercialRentData',function($scope,$http,$window){
	var data1=JSON.stringify({category:'commercial',pfor:'rent'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data1
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});
app.controller('allRentData',function($scope,$http,$window){
	var data1=JSON.stringify({category:'residential+commercial',pfor:'rent'});
	$http({
		method:'POST',
		url:"residentialBuy",
		header: {'Content-Type': 'application/json'},
		data:data1
	}).success(function(data,status,headers,config){
         $scope.properties=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			$scope.error=data;
		}
		});
	
});