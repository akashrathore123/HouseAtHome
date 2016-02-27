var app = angular.module('ForgotPassword',[]);
app.controller('newPasswordRequest',function($scope,$http,$window){
	$scope.verifyEmail = function(){
		var email = JSON.stringify($scope.email);
		$http({
			method:'POST',
			url:"checkemail",
			headers:{'Content-Type': 'application/json'},
			data: email
		}).success(function(data,status,headers,config){
			$scope.error="";
			$scope.data=data;
			
		}).error(function(data,status,headers,config){
			if(status==500){
				$window.location = "error500.jsp";
			}else{
				$scope.error =data;
			}
		});
	};
	$scope.changePassword = function(){
		var password = $scope.user.password;
		var confirm = $scope.user.confirmPassword;

		if(password===confirm){

			$http({

					method:'POST',
			        url:"changepassword",
			        headers:{'Content-Type': 'application/json'},
			        data: JSON.stringify($scope.user)
		    }).success(function(data1,status1,headers1,config1){
				$window.location = "login.jsp";
				
			}).error(function(data1,status1,headers1,config1){
				if(status==500){
				$window.location = "error500.jsp";
				}else{
					$scope.error=data1;
				}
			});
			}else{
				$scope.error="* Password Not matched.";
			}
			};
	
});