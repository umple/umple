/* v0.8.0beta */

/*
 * Dom Utilities
 */
function Dom() {} 
  
Dom.getEvent = function(e)
{
  if (!e) var e = window.event;
  return e;
}

Dom.getObject = function(e)
{
  if (e.currentTarget) return e.currentTarget;
  else return event.srcElement;
}

Dom.removeObject = function(obj)
{
  if (obj == null)
  {
    return;
  }
  obj.parentNode.removeChild(obj);
}

Dom.x = function(e)
{
  if (e.pageX) return e.pageX;
  else return e.x;
  //else return e.clientX;  // This has been changed for IE
}

Dom.y = function(e)
{
  if (e.pageY) return e.pageY;
  else return e.y;
  //else return e.clientY; // This has been changed for IE
}

Dom.left = function(div)
{
  return div.offsetLeft == 0 && div.offsetTop == 0 ? div.style.left.substr(0,div.style.left.length- "px".length) : div.offsetLeft;
}

Dom.top = function(div)
{
  return div.offsetLeft == 0 && div.offsetTop == 0 ? div.style.top.substr(0,div.style.top.length- "px".length) : div.offsetTop;
}

Dom.cornerX = function(e)
{
  if (e.layerX) return Dom.x(e) - e.layerX;
  else return Dom.x(e) - e.offsetX;
}

Dom.cornerY = function(e)
{
  if (e.layerY) return Dom.y(e) - e.layerY;
  else return Dom.y(e) - e.offsetY;
}

Dom.setClass = function(obj,className)
{
  obj.setAttribute("class",className);
  obj.setAttribute("className",className);
}

Dom.setStyle = function(obj,css)
{
  obj.setAttribute("style",css);
  obj.style.cssText = css;
}

Dom.setDisplay = function(id,displayType)
{
  var obj = document.getElementById(id);
  if (obj == null)
  {
    return;
  }
  obj.style.display = displayType;
}

Dom.attachEvent = function(obj,eventName,functionReference)
{
  if (obj.attachEvent) 
  {
    obj.attachEvent("on"+eventName, functionReference);
  }
  else if (obj.addEventListener) 
  {
    obj.addEventListener(eventName, functionReference, true);
  }

}

Dom.getElementsByName = function(tag, name) 
{
  var elem = document.getElementsByTagName(tag);
  var arr = new Array();
  for(i = 0,iarr = 0; i < elem.length; i++) 
  {
    att = elem[i].getAttribute("name");
    if(att == name) 
    {
      arr[iarr] = elem[i];
      iarr++;
    }
  }
  return arr;
}

/*********************************************************************
 * No onMouseOut event if the mouse pointer hovers a child element 
 * *** Please do not remove this header. ***
 * This code is working on my IE7, IE6, FireFox, Opera and Safari
 * 
 * Usage: 
 * <div onMouseOut="fixOnMouseOut(this, event, 'JavaScript Code');"> 
 *    So many childs 
 *  </div>
 *
 * @Author Hamid Alipour Codehead @ webmaster-forums.code-head.com    
**/
Dom.is_child_of =  function(parent, child) 
{
  if(child != null) 
  {
   try {
     while( child.parentNode ) 
     {
       if( (child = child.parentNode) == parent ) 
       {
        return true;
       }
     }
   } 
   catch (e) 
   {
     Debugger.log("Unable to ask is_child_of: " + e);
   }
  }
  return false;
}
Dom.divMouseEvent = function(element, event, JavaScript_code) {
  var current_mouse_target = null;
  if( event.toElement ) {
    current_mouse_target = event.toElement;
  } else if( event.relatedTarget ) {
    current_mouse_target = event.relatedTarget;
  }
  if( !Dom.is_child_of(element, current_mouse_target) && element != current_mouse_target ) {
    eval(JavaScript_code);
  }
}