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

/*
* Use handlers to pass the onError and onFinally
* The onError will be called when the ajax receives http status code other than 200 or 304
* The onFinally will always be called after the ajax completes the request regardless of status
* The onFinally will always run after any callback or onError
* The onFinally should be noexcept. If onFinally throws anything while the callback or onError also throws, the error from onFinally will override the thrown error and the error from the callback or onError will be ignored
*/
Ajax.sendRequest = function(url,callback,postData,handlers)
{
  handlers = handlers || {};
  let sender = new AjaxSender(url, callback, postData, handlers.onError, handlers.onFinally);
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

  

function AjaxSender(aUrl,aCallback,aPostData,aOnError,aOnFinally)
{
  this.url = aUrl;
  this.callback = aCallback;
  this.postData = aPostData;
  this.onError = aOnError;
  this.onFinally = aOnFinally;


  this.go = function()
  {
    var url = this.url;
    var callback = this.callback;
    var postData = this.postData;
    var onError = this.onError;
    var onFinally = this.onFinally;

    http = Ajax.createHttp();
    if (!http) { return; }
    
    var method = (postData) ? "POST" : "GET";
    callback = (callback) ? callback : Ajax.defaultAjaxHandle;
    
    http.open(method, url, true);

    if (postData)
    {
      http.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    }

    http.onreadystatechange =
      function () {
        // The ready state will always be 4 after request ends. Whatever error or not.
        if (http.readyState !== 4) { return; }
        try {
          if (http.status !== 200 && http.status !== 304) {
            if (onError) onError(http);
            return;
          }
          callback(http);
        }
        finally {
          try {
            if (onFinally) onFinally(http);
          }
          finally {
            Ajax.isSending = false;
          }
        }
      }
  
    if (http.readyState === 4) return;
    http.send(postData);
  }
 }