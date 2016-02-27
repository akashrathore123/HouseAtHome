var app=angular.module('LoginForm',[]);
app.controller('loginCheck',function($scope,$http,$window)
{

	$scope.login=function(){
	var user1=JSON.stringify($scope.user);
    document.getElementById("spinBlock").style.display="none";	
    document.getElementById("spinner").style.display="block";	

	//var target = document.getElementById("spin");

	//var spinner = new Spinner().spin(target);	
	   $http({
			 

	            method : 'POST',
	            url : 'LogInCheck',
	            headers: {'Content-Type': 'application/json'},
	            data : user1
	        }).
	        success(function(data,status,headers,config){

	  //      	spinner.stop();
	        	$window.location="home.jsp";
	        })
		 .error(function(data,status,headers,config){
			 if(status==500){
				 $window.location="error500.jsp";
			 }else
			 $scope.loginError=data;
			 
		 });
	
		};
		
	});
	

app.controller('signUpCheck',function($scope,$http,$window){
	$scope.signUp=function(){
		var user=JSON.stringify($scope.newUser);
		alert(user);
		$http({
			method:'POST',
		    url:'signup',
		    headers: {'Content-Type': 'application/json'},
		    data:user
		}).
        success(function(data,status,headers,config){
          $window.location="verifyAccount.jsp";
        })
		 .error(function(data,status,headers,config){
          
            if(status==500){
            	$window.location="error500.jsp";
            }else{
            	$scope.signupError=data;
            }
		 });
		};
});