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

function loadElectionPolls(elections) {
	idElection=elections.options[elections.selectedIndex].value;
	request = new ajaxRequest()
	var params = "action=loadElectionPolls&idElection="+idElection;
	request.open("POST", "openpoll.php", false);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");
	request.onreadystatechange = function() {
	if(request.readyState == 4 && request.status == 200) {
			var txt=request.responseText;
			var obj = JSON.parse(txt);
			var options="";
			for (i=0;i<obj.polls.length;i++) {
				options+='<option value="'+obj.polls[i].idpoll+'">'
						+obj.polls[i].name+' ('+obj.polls[i].description+' '+obj.polls[i].theElection+')</option>';
			}
			document.getElementById('polls').innerHTML=options;
		}
	}
	request.send(params)
}

function openPoll() {
	polls=document.getElementById('polls');
	if (polls.selectedIndex!=-1) {
		idPoll=polls.options[polls.selectedIndex].value;
		request = new ajaxRequest()
		var params = "action=openPoll&idpoll="+idPoll;
		request.open("POST", "openpoll.php", false);
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