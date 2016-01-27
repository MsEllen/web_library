function validateDate(){
	 var regexp = new RegExp("^[0-9]{4}$");
	if(!regexp.test($("#filmYear").val())){
		$("#filmYear").css("border", "1.25px solid red");
		return false;
	}
	else {
		$("#filmYear").css("border", "1.25px solid #CCC");
		return true;
	}
}

function validateName(){
	if($("#filmName").val().length == 0){
		$("#filmName").css("border", "1.25px solid red");
		return false;
	}
	else {
		$("#filmName").css("border", "1.25px solid #CCC");
		return true;
	}
}

function validate(){
	var i = 0;
	if(validateDate()){
		i++;
	}
	if(validateName()){
		i++;
	}
	return i === 2;
}