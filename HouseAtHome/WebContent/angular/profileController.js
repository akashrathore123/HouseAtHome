var app=angular.module("ProfileContent",[]);
app.controller=("profileData",function($scope,$http,$window){
	alert("chala");
	var userId=$scope.id;
	$http({
		method:POST,
		url:"ProfileData",
        headers: {'Content-Type': 'application/json'},
        data:userId		
	}).
	success(function(data,status,headers,config){
		$scope.userData=data;
	}).
	error(function(data,status,headers,config){
		
		if(status==503){
			$window.location="error503.jsp";
		}else{
			$window.location="error404.jsp";
			
		}
	});
});