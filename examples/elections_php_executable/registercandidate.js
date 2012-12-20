/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

function registerCandidate() {
	request = new ajaxRequest();
	
	var candidateName=document.getElementById('candidateName').value;
	var candidateAddress=document.getElementById('candidateAddress').value;
	var candidateTelephone=document.getElementById('candidateTelephone').value;
	
	if (candidateName=='')
		document.getElementById('result').innerHTML='Candidate name cannot be empty!';
	else if (candidateAddress=='')
		document.getElementById('result').innerHTML='Candidate address cannot be empty!';
	else if (candidateTelephone=='')
		document.getElementById('result').innerHTML='Candidate telephone cannot be empty!';
	else {
		var candidateJSON=JSON.stringify({'name': candidateName
										, 'address': candidateAddress
										, 'telephone': candidateTelephone});
		
		var params = "action=registerCandidate&candidateJSON="+candidateJSON;
		request.open("POST", "registercandidate.php", false);
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