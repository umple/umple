// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license   
Ajax = new Object();
Ajax.isSending = false;
Ajax.queue = [];

Ajax.waitUntilReady = function()
{
  if (!Ajax.isSending && Ajax.queue.length > 0)
  {
    Ajax.isSending = true;
    var sender = Ajax.queue[0];
    sender.go();
    Ajax.queue.splice(0,1);
  }
  
  if (Ajax.queue.length > 0)
  {
    setTimeout("Ajax.waitUntilReady()",100);
  }
}

Ajax.createHttp = function()
{
  for (var i=0;i<httpFactories.length;i++) 
  {
    try { return httpFactories[i](); }
    catch (e) { continue; }
  }
  return false;
}

Ajax.sendRequest = function(url,callback,postData)
{
  var sender = new AjaxSender(url,callback,postData);
  Ajax.queue.push(sender);
  Ajax.waitUntilReady();  
}

Ajax.defaultAjaxHandle = function(http)
{
  var response = http.responseText;
  alert(response);
}

var httpFactories = [
    function () {return new XMLHttpRequest()},
    function () {return new ActiveXObject("Msxml2.XMLHTTP")},
    function () {return new ActiveXObject("Msxml3.XMLHTTP")},
    function () {return new ActiveXObject("Microsoft.XMLHTTP")}
  ];

  

function AjaxSender(aUrl,aCallback,aPostData)
{
  this.url = aUrl;
  this.callback = aCallback;
  this.postData = aPostData;


  this.go = function()
  {
    var url = this.url;
    var callback = this.callback;
    var postData = this.postData;
  
    http = Ajax.createHttp();
    if (!http) { return; }
    
    var method = (postData) ? "POST" : "GET";
    callback = (callback) ? callback : Ajax.defaultAjaxHandle;
    
    http.open(method, url, true);
    http.setRequestHeader('User-Agent','XMLHTTP/1.0');
    if (postData)
    {
      http.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    }
  
    http.onreadystatechange = 
      function () {
        if (http.readyState != 4) { return; }
        if (http.status != 200 && http.status != 304) { return; }
        callback(http);
        Ajax.isSending = false;
      }
  
    if (http.readyState == 4) return;
    http.send(postData);
  }
 } 