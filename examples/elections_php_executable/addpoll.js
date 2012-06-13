/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

function loadAllElections() {
	request = new ajaxRequest()
	var params = "action=loadAllElections";
	request.open("POST", "openpoll.php", false);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");
	request.onreadystatechange = function() {
	if(request.readyState == 4 && request.status == 200) {
			var txt=request.responseText;
			var obj = JSON.parse(txt); 
			var options="";
			
			for (i=0;i<obj.elections.length;i++) {
				options+='<option value="'+obj.elections[i].idElection+'">'
						+obj.elections[i].name+'</option>';
			}
			document.getElementById('elections').innerHTML=options;
			loadElectionPolls(document.getElementById('elections'));
		}
	}
	request.send(params)
}

function addPoll() {
	request = new ajaxRequest();
	
	var pollName=document.getElementById('pollName').value;
	var pollDescription=document.getElementById('pollDescription').value;
	var electionId=document.getElementById('elections').value;
	var pollJSON=JSON.stringify({'election': electionId, 'name': pollName, 'description': pollDescription});
	var params = "action=addPoll&pollJSON="+pollJSON;
	request.open("POST", "addpoll.php", false);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");
	request.onreadystatechange = function() {
	if(request.readyState == 4 && request.status == 200) {
			var txt=request.responseText;
			alert(txt);
			document.getElementById('result').innerHTML=txt;
		}
	}
	request.send(params)
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