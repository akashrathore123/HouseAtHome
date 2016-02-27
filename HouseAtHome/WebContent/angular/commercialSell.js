var app = angular.module('commercialsellapp',[]);
app.controller('sellForm',function($scope,$http,$window){
	$scope.propertyList=[{type:'Commercial Office/Space'}, {type:'Commercial Shop'},{type:'Commercial Showrooms'}, {type:'Ware House'},{type:'Office in IT Park'}, {type:'Hotel/Resorts'},{type:'Banquet Hall/Guest House'}, {type:'Space in Retail Mall'},{type:'Bussiness Center'}, {type:'Manufacturing'}, {type:'Cold Storage'},{type:'Industrial Land'},{type:'Commercial Land'},{type:'Agricultural Land'},{type:'Other'} ];
    $scope.citiesList=[{name:"Adilabad"},{name:"Agra"},{name:"Ahmedabad"},{name:"Ahmednagar"},{name:"Ajitgarh (Mohali)"},{name:"Ajmer"},{name:"Aligarh"},{name:"Allahabad"},{name:"Ambala"},{name:"Amritsar"},{name:"Aurangabad"},{name:"Ballia"},{name:"Banda"},{name:"Bangalore"},{name:"Bareilly"},{name:"Basti"},{name:"Bikaner"},{name:"Chandigarh"},{name:"Chennai"},{name:"Coimbatore"},{name:"Darjeeling"},{name:"Dehradun"},{name:"Dhanbad"},{name:"Etawah"},{name:"Faridabad"},{name:"Firozabad"},{name:"Gandhinagar"},{name:"Ghaziabad"},{name:"Gonda"},{name:"Hamirpur"},{name:"Haridwar"},{name:"Howrah"},{name:"Hyderabad"},{name:"Indore"},{name:"Jabalpur"},{name:"Jaipur"},{name:"Jalandhar"},{name:"Jammu"},{name:"Jhansi"},{name:"Jodhpur"},{name:"Kannur"},{name:"Kolkata"},{name:"Korba"},{name:"Kota"},{name:"Kurukshetra"},{name:"Lucknow"},{name:"Meerut"},{name:"Moradabad"},{name:"Mumbai City"},{name:"Mumbai suburban"},{name:"Mysore"},{name:"Nagpur"},{name:"Nainital"},{name:"New Delhi"},{name:"North Delhi"},{name:"North East Delhi"},{name:"North West Delhi"},{name:"Patna"},{name:"Pune"},{name:"South Delhi"},{name:"South West Delhi"},{name:"Srinagar"},{name:"Ujjain"},{name:"Varanasi"},{name:"West Delhi"},{name:"West Sikkim"},{name:"Other"}];
    $scope.possessionListUnderConstruction=[{name:"With in 3months"},{name:"By 2016"},{name:"By 2017"},{name:"By 2018"},{name:"By 2019"},{name:"By 2020"},{name:"By 2021"},{name:"By 2022"}];
    $scope.possessionListReadyToMove=[{name:"0-1 year old"},{name:"1-5 year old"},{name:"5-10 year old"},{name:"10+ year old"}];
    $scope.unitsList=[{type:"Sq.Ft"},{type:"Sq.Yards"},{type:"Sq.Meter"},{type:"Acres"},{type:"Cents"},{type:"Bigha"},{type:"Grounds"},{type:"Hectares"}];
    $scope.washroomList=[{number:"None"},{number:"Shared"},{number:"1"},{number:"2"},{number:"3"},{number:"4"},{number:"5"},{number:"6"},{number:"6+"}];
    $scope.balconyList=[{number:"None"},{number:"1"},{number:"2"},{number:"3"},{number:"3+"}];
    $scope.bedroomList=[{number:"None"},{number:"1"},{number:"2"},{number:"3"},{number:"3+"}];
   
    
    var target = document.getElementById("spin");
	var spinner = new Spinner();
    
    var error=document.getElementById("error"); 
    $scope.commercialSubmit=function(){
    	spinner.spin(target);

    document.getElementById("button").disabled=true;
    	if(document.getElementById("role1").checked==false){
    		if(document.getElementById("role2").checked==false){
    			if(document.getElementById("role3").checked==false){
    	         	error.innerHTML="* Enter Seller role";
    	            document.getElementById("button").disabled=false;
    	         	spinner.stop();
    		        return;
    	}
    		}
    	}
    	if(document.getElementById("for1").checked==false){
    		if(document.getElementById("for2").checked==false){
    	     	error.innerHTML="* Enter Property purpose.";
    	     	document.getElementById("button").disabled=false;
    	     	spinner.stop();
    	     	return;
    	}
    	}
    	if(document.getElementById("type").value==""){
    		error.innerHTML="* Enter Type of property.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();
    		return;
    	}
    	if(document.getElementById("city").value==""){
    		error.innerHTML="* Select City Name.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();
    		return;
    	}
    
    	if(document.getElementById("city").value=="object:80"){
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
    	if(document.getElementById("society").value.trim()!=null || document.getElementById("society").value.trim()!=""){
        	if(document.getElementById("society").value.trim().length<'3' || document.getElementById("society").value.trim().length>70){
    			error.innerHTML="* Enter correct Society name.";
             	spinner.stop();
             	document.getElementById("button").disabled=false;
             	return;
    		}
        	}
        	if(document.getElementById("address").value.trim()!=null || document.getElementById("address").value.trim()!=""){
        	if(document.getElementById("address").value.trim().length<'3' || document.getElementById("address").value.trim().length>100){
    			error.innerHTML="* Enter correct address.";
             	spinner.stop();
             	document.getElementById("button").disabled=false;
             	return;
    		}
        	}
    	if(document.getElementById("area").value.trim()=="" || document.getElementById("area").value.trim()==null){
    		error.innerHTML="* Enter area(size) of property.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();	
    		return;
    	}
    	if(document.getElementById("area").value.length>12 || !((document.getElementById("area").value).match("^[0-9]+$"))){
    		error.innerHTML="* Enter correct area(size) of property.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();	
    		return;
    	}
    	if(document.getElementById("unit").value==""){
    		error.innerHTML="* Select unit of area.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();
    		return;
    	}
    	if(document.getElementById("price").value.trim()=="" || document.getElementById("price").value.trim()==null){
    		error.innerHTML="* Enter price of property.";
    		document.getElementById("button").disabled=false;
    		spinner.stop();	
    		return;
    	}
    	if(document.getElementById("price").value.trim().length<3 || document.getElementById("price").value.trim().length>35){
    		error.innerHTML="* Enter correct price of property.";
         	spinner.stop();
         	document.getElementById("button").disabled=false;
         	return;
    	}
    	if(document.getElementById("mcharge").value.trim()!=null || document.getElementById("mcharge").value.trim()!=""){
        	if(document.getElementById("mcharge").value.trim().length>15){
    			error.innerHTML="* Enter correct maintainance charge value.";
             	spinner.stop();
             	document.getElementById("button").disabled=false;
             	return;
    		}
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
	
    	var property=$scope.form;
	   

	   $http({
		  
		method:'POST',
		url:'commercialSubmit?category=Commercial',
		header: {'Content-Type': 'application/json'},
		data: property
	}).success(function(data,status,headers,config){
		document.getElementById("button").disabled=false;
		$window.location="submitSuccess.jsp";
	}).error(function(data,status,headers,config){
		if(status==500){
			spinner.stop();
			document.getElementById("button").disabled=false;
		    $window.location="error500.jsp";
		}else{
			spinner.stop();
			document.getElementById("button").disabled=false;
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