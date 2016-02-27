

function showCity(){
	if(document.getElementById("city").value=="object:77"){
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
function typeChange() {
		if(document.getElementById("type").value=="object:3"){
			document.getElementById("washroom").style.display="none";
			document.getElementById("balcony").style.display="block";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";
		}
		if(document.getElementById("type").value=="object:4"){
			document.getElementById("balcony").style.display="none";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";
		}
		if(document.getElementById("type").value=="object:5"){
			document.getElementById("balcony").style.display="block";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";

		}
		if(document.getElementById("type").value=="object:6"){
			document.getElementById("balcony").style.display="block";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";

		}
		if(document.getElementById("type").value=="object:7"){
			document.getElementById("balcony").style.display="block";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";

		}
		if(document.getElementById("type").value=="object:8"){
			document.getElementById("balcony").style.display="block";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";

			}
		if(document.getElementById("type").value=="object:9"){
			document.getElementById("balcony").style.display="none";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="none";
			document.getElementById("bathroom").style.display="none";
			}
		if(document.getElementById("type").value=="object:10"){
			document.getElementById("balcony").style.display="block";
			document.getElementById("washroom").style.display="none";
			document.getElementById("bedroom").style.display="block";
			document.getElementById("bathroom").style.display="block";
			}
		
	}				
	function checkDescription(){
		if(document.getElementById("description").value.length<=100){
		var desc = 100-document.getElementById("description").value.length;
		document.getElementById("counter").innerHTML="("+(desc)+")";
	}}