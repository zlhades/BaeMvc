function goBack() {
	window.history.go(-1);
}
function goUrl(url){
	window.location.href = url;
}
function formSubmit(actionUrl){
	var submitForm = window.document.forms[0];
	window.document.forms[0].action = actionUrl;
	window.document.forms[0].submit();
}
function disableTable(id) {
	var tableObj = document.getElementById(id);
	if (tableObj.style.display.toLowerCase() == 'block') {
		tableObj.style.display = 'none';
	} else {
		tableObj.style.display = 'block';
	}
}

function checkLogon() {
    if($("#qqLoginBtn > a")[0])     {
        $("#qqLoginBtn > a").click();
        return false;
    }
    return true;
}

