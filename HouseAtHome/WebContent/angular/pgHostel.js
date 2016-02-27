
var app = angular.module('pgHostelData',[]);

app.controller('allPGHostelData',function($scope,$http,$window){
	$http({
		method:'POST',
		url:"pgHostel?extract=all",
		header: {'Content-Type': 'application/json'},
	
	}).success(function(data,status,headers,config){
         $scope.pgs=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			
		}
		});
});

app.controller('allPGData',function($scope,$http,$window){
	$http({
		method:'POST',
		url:"pgHostel?extract=pg",
		header: {'Content-Type': 'application/json'},
	
	}).success(function(data,status,headers,config){
         $scope.pg=data;
	}).error(function(data,status,headers,config){
		if(status==500){
             $window.location="error500.jsp";
		}else{
         	
         	
			
		}
		});
});

app.controller('allHostelData',function($scope,$http,$window){
	$http({
		method:'POST',
		url:"pgHostel?extract=hostel",
		header: {'Content-Type': 'application/json'},
	
	}).success(function(data,status,headers,config){
         $scope.hostel=data;
	}).error(function(data,status,headers,config){
		if(status==500){
         	$window.location="error500.jsp";
		}else{
         	
         	
			
		}
		});
});

app.controller('pgHostelRent',function($scope,$http,$window){
	 $scope.citiesList=[{name:"Adilabad"},{name:"Agra"},{name:"Ahmedabad"},{name:"Ahmednagar"},{name:"Ajitgarh (Mohali)"},{name:"Ajmer"},{name:"Aligarh"},{name:"Allahabad"},{name:"Ambala"},{name:"Amritsar"},{name:"Aurangabad"},{name:"Ballia"},{name:"Banda"},{name:"Bangalore"},{name:"Bareilly"},{name:"Basti"},{name:"Bikaner"},{name:"Chandigarh"},{name:"Chennai"},{name:"Coimbatore"},{name:"Darjeeling"},{name:"Dehradun"},{name:"Dhanbad"},{name:"Etawah"},{name:"Faridabad"},{name:"Firozabad"},{name:"Gandhinagar"},{name:"Ghaziabad"},{name:"Gonda"},{name:"Hamirpur"},{name:"Haridwar"},{name:"Howrah"},{name:"Hyderabad"},{name:"Indore"},{name:"Jabalpur"},{name:"Jaipur"},{name:"Jalandhar"},{name:"Jammu"},{name:"Jhansi"},{name:"Jodhpur"},{name:"Kannur"},{name:"Kolkata"},{name:"Korba"},{name:"Kota"},{name:"Kurukshetra"},{name:"Lucknow"},{name:"Meerut"},{name:"Moradabad"},{name:"Mumbai City"},{name:"Mumbai suburban"},{name:"Mysore"},{name:"Nagpur"},{name:"Nainital"},{name:"New Delhi"},{name:"North Delhi"},{name:"North East Delhi"},{name:"North West Delhi"},{name:"Patna"},{name:"Pune"},{name:"South Delhi"},{name:"South West Delhi"},{name:"Srinagar"},{name:"Ujjain"},{name:"Varanasi"},{name:"West Delhi"},{name:"West Sikkim"},{name:"Other"}];
	    $scope.possessionListUnderConstruction=[{name:"With in 3months"},{name:"By 2016"},{name:"By 2017"},{name:"By 2018"},{name:"By 2019"},{name:"By 2020"},{name:"By 2021"},{name:"By 2022"}];
	    $scope.possessionListReadyToMove=[{name:"0-1 year old"},{name:"1-5 year old"},{name:"5-10 year old"},{name:"10+ year old"}];
	    $scope.roomsList=[{number:"1"},{number:"2"},{number:"3"},{number:"4"},{number:"5"},{number:"6"},{number:"7"},{number:"8"},{number:"9"},{number:"9+"}];
	    $scope.bedsList=[{number:"1"},{number:"2"},{number:"3"},{number:"3+"}];
	    $scope.bathroomList=[{number:"Separate"},{number:"Combined"}];
	   
	    
	    	 var target = document.getElementById("spin");
	    		var spinner = new Spinner();
	    	    
	    	    var error=document.getElementById("error"); 
	    	    $scope.propertySubmit=function(){
	    	    	spinner.spin(target);

	    	    	 document.getElementById("button").disabled=true;
	    	   	if(document.getElementById("role1").checked==false){
	    	    		if(document.getElementById("role2").checked==false){
	    	    			if(document.getElementById("role3").checked==false){
	    	    	         	error.innerHTML="* Enter your role.";
	    	    	            document.getElementById("button").disabled=false;
	    	    	         	spinner.stop();
	    	    		        return;
	    	    	}
	    	    		}
	    	    	}
	    	    	if(document.getElementById("type1").checked==false){
    	    			if(document.getElementById("type2").checked==false){
    	    	         	error.innerHTML="* Enter type of property.";
    	    	            document.getElementById("button").disabled=false;
    	    	         	spinner.stop();
    	    		        return;
    	    	}
    	    		}
	    	    	if(document.getElementById("city").value==""){
	    	    		error.innerHTML="* Select City Name.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();
	    	    		return;
	    	    	}
	    	    
	    	    	if(document.getElementById("city").value=="object:69"){
	    	    		if(document.getElementById("city1").value.trim()=="" || document.getElementById("city1").value.trim()==null){
	    	    			
	    	    			error.innerHTML="* Enter City Name.";
	    	    			document.getElementById("button").disabled=false;
	    	    			spinner.stop();
	    	    			return;
	    	    		}
	    	    		var regex="^[A-Z a-z]+$";
	    	    		if(document.getElementById("city1").value.trim().length<'3' || !((document.getElementById("city1").value).match(regex)) || document.getElementById("city1").value.trim().length>'32' ){
	    	    			error.innerHTML="* Enter correct City Name.";
	    	    			document.getElementById("button").disabled=false;
	    	    			spinner.stop();
	    	    			return;
	    	    		}
	    	    	}
	    	    	
	    	    	
	    	    	if(document.getElementById("locality").value.trim()=="" || document.getElementById("locality").value.trim()==null){
	    				
	    				error.innerHTML="* Enter Location.";
	    				document.getElementById("button").disabled=false;
	    				spinner.stop();
	    				return;
	    			}
	    	    	if(document.getElementById("locality").value.trim().length<'3' || document.getElementById("locality").value.trim().length>70){
	    				error.innerHTML="* Enter correct Location.";
	    				document.getElementById("button").disabled=false;
	    				spinner.stop();
	    				return;
	    			}
	    	
	    	    	if(document.getElementById("address").value.trim()==""){
	    	    		error.innerHTML="* Enter Address of property.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();
	    	    		return;
	    	    	}
	    	    	if(document.getElementById("address").value.trim().length<3 || document.getElementById("address").value.trim().length>100){
	    	    		error.innerHTML="* Enter correct Address of property.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();
	    	    		return;
	    	    	}
	    	    	if(document.getElementById("noOfRooms").value==""){
	    	    		error.innerHTML="* Enter number of Rooms.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();
	    	    		return;
	    	    	}
	    	    	if(document.getElementById("rentroom").value.trim()=="" || document.getElementById("rentroom").value.trim()==null){
	    	    		error.innerHTML="* Enter rent of property.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();	
	    	    		return;
	    	    	}
	    	    	if(document.getElementById("rentroom").value.trim().length<3 || document.getElementById("rentroom").value.trim().length>10){
	    	    		error.innerHTML="* Enter correct rent of property.";
	    	         	spinner.stop();
	    	         	document.getElementById("button").disabled=false;
	    	         	return;
	    	    	}
	    	    	if(document.getElementById("furnish1").checked==false){
	    	    		if(document.getElementById("furnish2").checked==false){
	    	    			if(document.getElementById("furnish3").checked==false){
	    	    	         	error.innerHTML="* Enter Furnishing status.";
	    	    	            document.getElementById("button").disabled=false;
	    	    	         	spinner.stop();
	    	    		        return;
	    	    	}
	    	    		}
	    	    	}
	    	    	if(document.getElementById("bathroom").value==""){
	    	    		error.innerHTML="* Enter type of Bathroom.";
	    	    		document.getElementById("button").disabled=false;
	    	    		spinner.stop();
	    	    		return;
	    	    	}
	    	 	
	        	if(document.getElementById("construction").checked==false){
	        		if(document.getElementById("ready").checked==false){
	        	             error.innerHTML="* Select availability of property.";
	        	             document.getElementById("button").disabled=false;
	        	             spinner.stop();
	        	             return;
	        		}
	        	}
	        	if(document.getElementById("construction").checked){
	        	if(document.getElementById("possession1").value==""){
	        		error.innerHTML="* Enter possession of property.";
	        		document.getElementById("button").disabled=false;
	        		spinner.stop();
	        		return;
	        	}}
	        	if(document.getElementById("ready").checked){
	            	if(document.getElementById("possession2").value==""){
	            		error.innerHTML="* Enter possession of property.";
	            		document.getElementById("button").disabled=false;
	            		spinner.stop();
	            		return;
	            	}}
	    	
		var data = JSON.stringify($scope.form);
		$http({
			method:'POST',
			url:"addPGHostel",
			header: {'Content-Type': 'application/json'},
		    data:data
		}).success(function(data,status,headers,config){
    		document.getElementById("button").disabled=false;
    		spinner.stop();	
	         $window.location="submitSuccess.jsp";
		}).error(function(data,status,headers,config){
			if(status==500){
				spinner.stop();	
        		document.getElementById("button").disabled=false;

	         	$window.location="error500.jsp";
			}else{
        		document.getElementById("button").disabled=false;
    			spinner.stop();	         	
	         	$scope.error=data;
				
			}
		});
	    	    };
	
	
	
	$scope.uploadFile = function(files) {
		
	    var fd = new FormData();
	    //Take the first selected file
	    fd.append("file", files[0]);

	    $http.post('image', fd, {
	        withCredentials: true,
	        headers: {'Content-Type': undefined },
	        transformRequest: angular.identity
	    }).success(function(data,status,headers,config){

			$scope.imagedata=data;
		}).error(function(data,status,headers,config){
			if(status==500){
				
				$window.location="error500.jsp";
			}else{
				$scope.imageerror=data;
			}
			});
	};
	
});

function showCity(){
	if(document.getElementById("city").value=="object:69"){
		document.getElementById("otherCity").style.display="block";
		
	}else{
		document.getElementById("otherCity").style.display="none";
	}}
function showPossession(){
	if(document.getElementById("construction").checked){
		document.getElementById("1").style.display="block";
		document.getElementById("2").style.display="none";
	}else{
		if(document.getElementById("ready").checked){
			document.getElementById("2").style.display="block";
			document.getElementById("1").style.display="none";
		}
	}
}

function checkDescription(){
	if(document.getElementById("description").value.length<=100){
	var desc = 100-document.getElementById("description").value.length;
	document.getElementById("counter").innerHTML="("+(desc)+")";
}}
function checkCondition(){
	if(document.getElementById("conditions").value.length<=100){
	var desc1 = 70-document.getElementById("conditions").value.length;
	document.getElementById("counter1").innerHTML="("+(desc1)+")";
}}

