/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

function loadAllElections() {
	request = new ajaxRequest()
	var params = "action=loadAllElections";
	request.open("POST", "addelectionforposition.php", false);
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
		}
	}
	request.send(params)
}

function loadAllPositions() {
	request = new ajaxRequest()
	var params = "action=loadAllPositions";
	request.open("POST", "addelectionforposition.php", false);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");
	request.onreadystatechange = function() {
	if(request.readyState == 4 && request.status == 200) {
			var txt=request.responseText;
			var obj = JSON.parse(txt); 
			var options="";
			
			for (i=0;i<obj.positions.length;i++) {
				options+='<option value="'+obj.positions[i].idPosition+'">'
						+obj.positions[i].name+'</option>';
			}
			document.getElementById('positions').innerHTML=options;
		}
	}
	request.send(params)
}

function update() {
	request = new ajaxRequest();
	
	var electionId=document.getElementById('elections').value;

	var selObj = document.getElementById('positions');
	var i;
	var efpJSONs=new Array();
	var count=0;
	for (i=0; i<selObj.options.length; i++) {
		if (selObj.options[i].selected) {
			positionId = selObj.options[i].value;
			efpJSONs[count++]=JSON.stringify({'election': electionId, 'position': positionId});
		}
	}
	var params = "action=addElectionForPosition";
	for (i=0; i<efpJSONs.length; ++i) {
		params+=("&efpJSON"+i+"="+efpJSONs[i])
	}
	//alert(params);
	request.open("POST", "addelectionforposition.php", false);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");
	request.onreadystatechange = function() {
	if(request.readyState == 4 && request.status == 200) {
			var txt=request.responseText;
			//alert(txt);
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