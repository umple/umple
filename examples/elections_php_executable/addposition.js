/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

function addPosition() {
	request = new ajaxRequest();
	
	var positionName=document.getElementById('positionName').value;
	
	if (positionName=='')
		document.getElementById('result').innerHTML='Position name cannot be empty!';
	else {
		var positionDescription=document.getElementById('positionDescription').value;
		var positionJSON=JSON.stringify({'name': positionName, 'description': positionDescription});
		
		var params = "action=addPosition&positionJSON="+positionJSON;
		request.open("POST", "addposition.php", false);
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		request.setRequestHeader("Content-length", params.length);
		request.setRequestHeader("Connection", "close");
		request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
				var txt=request.responseText;
				document.getElementById('result').innerHTML=txt;
			}
		}
		request.send(params)
	}
}

function ajaxRequest() {
	try	{
		var request = new XMLHttpRequest()
	} catch(e1) {
		try	{
			request = new ActiveXObject("Msxml2.XMLHTTP")
		} catch(e2)	{
			try	{
				request = new ActiveXObject("Microsoft.XMLHTTP")
			} catch(e3)	{
				request = false
			}
		}
	}
	
	return request
}