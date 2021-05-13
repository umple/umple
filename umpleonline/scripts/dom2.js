/* v0.8.0beta */

/*
 * Dom Utilities
 */
function Dom() {} 
  
Dom.hookEvent = function (obj, eventName, func){
  if (obj.attachEvent) {
    obj.attachEvent("on" + eventName, func);
  }
  else if (obj.addEventListener) {
    obj.addEventListener(eventName, func, true);
  }
}

Dom.unhookEvent = function(obj, eventName, func){
  if (obj.detachEvent) {
    obj.detachEvent("on" + eventName, func);
  }
  else if (obj.removeEventListener) {
    obj.removeEventListener(eventName, func, true);
  }
}


Dom.cancelBubble = function(event) {
  if (!event) event = window.event;
  event.cancelBubble = true;
  if (event.stopPropagation) event.stopPropagation();
}


Dom.bubbleToTarget = function(obj, name)
{
  if (!name) return obj;
  try {
    if (obj.getAttribute('name')==name) return obj;
    if (obj.tagName=="HTML") return null;
    while (obj && obj.tagName!="BODY") {
    obj = obj.parentNode;
      if (obj.getAttribute('name')==name) return obj;
    }
  } catch (e) { alert(e.message); /*TODO*/ }
  return null;  
}


Dom.getEventTarget = function(evt, tgtName){
  if (!evt) evt = window.event;
  if (!evt) return null;
  var obj = evt.srcElement;
  if (!obj) obj = evt.target;
  if (!obj) return null;
  
  if (!tgtName) return obj;
  try {
    if (obj.getAttribute("name") == tgtName) return obj;
    
    if (obj.tagName == "HTML") return null;
    while (obj && obj.tagName != "BODY") {
      obj = obj.parentNode;
      if (obj && obj.getAttribute("name") == tgtName) return obj;
    }
  } 
  catch (e) { /*TODO*/ }
  return null;
}



Dom.createElement = function(tagName, name, type){
  var newEle;
  try {
    if (type) newEle = document.createElement("<" + tagName + " name='" + name + "' type='" + type + "'>");
    else newEle = document.createElement("<" + tagName + " name='" + name + "'>");
  } 
  catch (e) {
    try
    {
      newEle = document.createElement(tagName);
      newEle.setAttribute("name", name);
      if (type) newEle.setAttribute("type", type);
    } 
    catch (e2) { alert("failed again: " + e2); }
  }
  return newEle;
}



Dom.findNodeByTagName = function(chunk, tagname, recurse){
  return Dom.findNodeByIdOrName(chunk, tagname, null, recurse);
}

Dom.findNodeByName = function(chunk, tagname, idOrName, recurse){
  return Dom.findNodeByIdOrName(chunk, tagname, idOrName, recurse, "name");
}

Dom.findNodeById = function(chunk, tagname, idOrName, recurse){
  return Dom.findNodeByIdOrName(chunk, tagname, idOrName, recurse, "id");
}

Dom.findNodeByIdOrName = function(chunk, tagname, idOrName, recurse, type){
  if (chunk.childNodes == null) 
    return null;
  
  for (var i = 0; i < chunk.childNodes.length; i++) {
    if ((tagname == null || chunk.childNodes[i].tagName == tagname) &&
    (idOrName == null || chunk.childNodes[i].getAttribute(type) == idOrName)) {
      return chunk.childNodes[i];
    }
    if (recurse) {
      var rec = Dom.findNodeByIdOrName(chunk.childNodes[i], tagname, idOrName, recurse, type);
      if (rec) return rec;
    }
  }
  return null;
}

Dom.replaceHtml = function(el,html)
{
  var oldEl = typeof el === "string" ? document.getElementById(el) : el;
  var newEl = document.createElement(oldEl.nodeName);
  newEl.id = oldEl.id;
  newEl.className = oldEl.className;
  newEl.innerHTML = html;
  oldEl.parentNode.replaceChild(newEl, oldEl);
  alert(newEl.name);
  return newEl;
}
