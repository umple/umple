function addElection() {
	request = new ajaxRequest();
	
	var electionName=document.getElementById('electionName').value;
	
	if (electionName=='')
		document.getElementById('result').innerHTML='Election name cannot be empty!';
	else {
		var electionDescription=document.getElementById('electionDescription').value;
		var electionJSON=JSON.stringify({'name': electionName, 'description': electionDescription});
		
		var params = "action=addElection&electionJSON="+electionJSON;
		request.open("POST", "addelection.php", false);
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