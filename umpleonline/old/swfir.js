//	=============================================
//	swfir!
//	=============================================
//	Copyright 2006, 2007 Jon Aldinger, Mark Huot
//	and Dan Mall
//	
//	This software is licensed under the CC-GNU LGPL
//	http://creativecommons.org/licenses/LGPL/2.1/
//	---------------------------------------------

//	=============================================
//	Get DOM Elements with CSS Selectors
//	=============================================
//	Use this function to call DOM elements by
//	passing in a CSS selector such as 'p .date'
//	---------------------------------------------
function getAllChildren(e)
{
	return e.all ? e.all : e.getElementsByTagName('*');	
}
function checkToken(hint, element, context)
{
	/*
	If we're not limiting */
	if(hint == "") return true;
	
	/*
	Descendant Selector */
	else if(hint == ">")
	{
		context = context.firstChild;
		while(context)
		{
			if(context == element) return true;
			context = context.nextSibling;
		}
	}
	
	/*
	First Child Selector */
	else if(hint == "first-child")
	{
		context = context.firstChild;
		while(context.nodeName == "#text")
		{
			if(context.firstChild)
			{
				context = context.firstChild;
			}
			else
			{
				context = context.nextSibling;
			}
		}
		if(context == element) return true;
	}
	
	/*
	:link selector */
	else if(hint == "a")
	{
		if(element.nodeName == "A") return true;
	}
	
	/*
	Adjacent Selector */
	else if(hint == "+")
	{
		context = context.nextSibling;
		while(context)
		{
			if(context == element) return true;
			context = context.nextSibling;
		}
	}
	
	/*
	Attribute Selector */
	else if(hint.length > 0)
	{
		if(element.getAttribute(hint[1]))
		{
			if(hint[2] == "" && element.getAttribute(hint[1]) == hint[3]) return true;
			else if((hint[2] == "~" || hint[2] == "|") && element.getAttribute(hint[1]).indexOf(hint[3]) > -1) return true;
		}
	}
	return false;
}
getElementsBySelector = document.getElementsBySelector = function(selector)
{
	/*
		Error Checking
	*/
	if(!document.getElementsByTagName || typeof(selector) != "string") {
		return Array();
	}
	
	/*
		Local Variables
	*/
	var resultElements = new Array();
	
	/*
		Split the Selectors
	*/
	var selectors = selector.split(",");
	for(var i=0; i<selectors.length; i++)
	{
		var selector = selectors[i].replace(/^\s+/,'').replace(/\s+$/,'');
		
		/*
			Get the Tokens
		*/
		var tokens = selector.split(" ");
		var tokenContext = new Array(this);
		var nextTokenHint = "";
		
		/*
		Loop Through the Tokens */
		for(var j=0; j<tokens.length; j++)
		{
			var token = tokens[j].replace(/^\s+/,'').replace(/\s+$/,'');
			
			/*
			CSS3 Selectors: */
			if(token.indexOf(">") > -1)
			{
				nextTokenHint = ">";
				continue;
			}
			else if(token.indexOf(":first-child") > -1)
			{
				nextTokenHint = "first-child";
				token = token.replace(/:first-child/g, "");
			}
			else if(token.indexOf(":link") > -1)
			{
				nextTokenHint = "a";
				token = token.replace(":link","");
			}
			else if(token.indexOf("+") > -1)
			{
				nextTokenHint = "+";
				continue;
			}
			else if (token.match(/^([a-zA-Z*]+)\[([a-zA-Z]+)([~\|]?)=.([^\]"]*).\]$/))
			{
				// token.match(/^(\w*)\[(\w+)([=~\|\^\$\*]?)=?"?([^\]"]*)"?\]$/)
				parts = token.match(/^([a-zA-Z*]+)\[([a-zA-Z]+)([~\|]?)=.([^\]"]*).\]$/);
				nextTokenHint = new Array("attribute", parts[2], parts[3], parts[4]);
				token = parts[1];
			}
			
			/*
			Activity Selectors*/
			token = token.replace(":visited","").replace(":active","").replace(":hover","").replace(":focus","");
			
			/*
			ID Tokens */
			if (token.indexOf("#") > -1)
			{
				/*
				Split the Token */
				var pieces = token.split("#");
				
				/*
				Error Out Gracefully */
				if(pieces[1] == "") { return Array(); }
				
				/*
				Check for Universal Selectors */
				if(pieces[0] == "") { pieces[0] = "*"; }
				
				var foundElements = new Array();
				for(var k=0; k<tokenContext.length; k++)
				{
					if(nextTokenHint != "+")
						var element = tokenContext[k].getElementById(pieces[1]);
					else
						var element = tokenContext[k].parentNode.getElementById(pieces[1]);
					
					if(element && element.nodeName && (pieces[0] == "*" || element.nodeName.toLowerCase() == pieces[0].toLowerCase()))
					{
						if(checkToken(nextTokenHint, element, tokenContext[k]))
						{
							foundElements[foundElements.length] = element;
						}
					}
				}
				tokenContext = foundElements;
				
				continue;
			}
			
			/*
			Class Tokens */
			if (token.indexOf(".") > -1)
			{
				/*
				Split the Token */
				var pieces = token.split(".");
				
				/*
				Error Out Gracefully */
				if(pieces[1] == "") { return Array(); }
				
				/*
				Check for Universal Selectors */
				if(pieces[0] == "") { pieces[0] = "*"; }
				
				var foundElements = new Array();
				for(var k=0; k<tokenContext.length; k++)
				{
					if (pieces[0] == '*') {
						if(nextTokenHint != "+")
							var elements = getAllChildren(tokenContext[k]);
						else
							var elements = getAllChildren(tokenContext[k].parentNode);
					} else {
						if(nextTokenHint != "+")
							var elements = tokenContext[k].getElementsByTagName(pieces[0]);
						else
							var elements = tokenContext[k].parentNode.getElementsByTagName(pieces[0]);
					}
					
					for (var l=0; l<elements.length; l++)
					{
						if (elements[l].className && elements[l].className.match(new RegExp('\\b'+pieces[1]+'\\b')))
						{
							if(checkToken(nextTokenHint, elements[l], tokenContext[k]))
							{
								foundElements[foundElements.length] = elements[l];
							}
						}
					}
				}
				
				tokenContext = foundElements;
				
				continue;
			}
			
			/*
			Elements */
			var foundElements = new Array();
			for(var k=0; k<tokenContext.length; k++)
			{
				if(token == "*")
				{
					if(nextTokenHint != "+")
						var elements = getAllChildren(tokenContext[k]);
					else if(nextTokenHint == "+")
						var elements = getAllChildren(tokenContext[k].parentNode);
				}
				else
				{
					if(nextTokenHint != "+")
						var elements = tokenContext[k].getElementsByTagName(token);
					else
						var elements = tokenContext[k].parentNode.getElementsByTagName(token);
				}
				
				for(var l=0; l<elements.length; l++)
				{
					if(checkToken(nextTokenHint, elements[l], tokenContext[k]))
					{
						foundElements[foundElements.length] = elements[l];
					}
				}
			}
			
			tokenContext = foundElements;
			nextTokenHint = "";
		}
		
		resultElements = tokenContext;
	}
	
	/*
	Remove Duplicates */
	var cleanedArray = new Array();
	for(i=0;i<resultElements.length;i++)
	{
		for(j=0;j<resultElements.length;j++)
		{
			if(resultElements[i] == resultElements[j] && i!=j)
			{
				resultElements[j] = "";
			}
		}
		
		if(resultElements[i] != "")
		{
			cleanedArray[cleanedArray.length] = resultElements[i];
		}
	}
	
	/*
	Return Results */
	return cleanedArray;
}

//	=============================================
//	Hold References to swfir Objects
//	=============================================
//	This class holds references to the various
//	swfir objects on the page.  It is called by
//	flash when the swf is resized
//	---------------------------------------------
function swfirController()
{
	
	this.swfirs = new Array();
	
	this.addswfir = function ( swfirReference )
	{
		var swfirId = this.swfirs.length;
		this.swfirs[swfirId] = swfirReference;
		return swfirId;
	}
	
	this.getswfirs = function()
	{
		return this.swfirs;
	}
	
	this.getNextId = function()
	{
		return this.swfirs.length;
	}
	
	this.resize = function( id, width, height )
	{
		if(this.swfirs[id].elasticityWidth == false)
		{
			this.swfirs[id].setAttribute("width", width);
			this.swfirs[id].style.width = width+'px';
		}
		
		this.swfirs[id].setAttribute("height", height);
		this.swfirs[id].style.height = height+'px';
	}

}
var firController = new swfirController();

//	=============================================
//	Swap the IMG
//	=============================================
//	The meat and potatoes.  This class accepts
//	params and swaps the specified images with
//	swf's.
//	---------------------------------------------
function swfir()
{
	
	/*
		Global Variables
	*/
	this.name = "swfir";
	this.version = "1.1.1";
	this.debug = false;
	this.params = new Array();
	this.background = "";
	this.src = "swfir.swf";
	this.wmode = 'transparent';
	this.elasticityWidth = false;
	
	/*
		Set Parameters
	*/
	this.specify = function( key, value )
	{
		if(key == "debug")
		{
			if(value == true || value == "true")
			{
				this.debug = true;
			}
			else
			{
				this.debug = false;
			}
			return;
		}
		if(key == 'wmode')
		{
			this.wmode = value;
		}
		if(key == "background-color")
		{
			this.background = this.cleanColor(value);
			return;
		}
		if(key == "border-color" || key == "shadow-color")
		{
			value = this.cleanColor(value, "flash");
		}
		if(key == "shadow-blur")
		{
			this.params["shadowBlurX"] = value;
			this.params["shadowBlurY"] = value;
			acceptableFound = true;
		}
		if(key == "border-radius" || key == "border-width" || key == "border-alpha" || key == "shadow-blur-x" || key == "shadow-blur-y")
		{
			value = parseFloat(value);
			if((value == NaN || value == "NaN") && this.debug == true)
			{
				this.error("'"+key+"' must be a number.  Please make sure in your source there are no quotes (\") around the number.");
			}
		}
		if(key == "rotate" && Number(value) < 0)
		{
			value = 360 + Number(value);
		}
		if(key == "src")
		{
			this.src = value;
			return;
		}
		if(key == 'elasticity')
		{
			if(parseFloat(value))
			{
				this.elasticityWidth = value;
			}
			else
			{
				var tmp = document.createElement('div');
					tmp.style.position = 'absolute';
					tmp.style.left = '-10em';
					tmp.style.width = '1em';
					tmp.style.height = '1em';
				document.body.appendChild(tmp);
				
				this.elasticityWidth = tmp.offsetHeight;
				
				tmp.parentNode.removeChild(tmp);
			}
			return;
		}
		
		var translation = new Array();
			translation["border-radius"] = "borderRadius";
			translation["border-width"] = "borderWidth";
			translation["border-color"] = "borderColor";
			translation["shadow-offset"] = "shadowOffset";
			translation["shadow-angle"] = "shadowAngle";
			translation["shadow-alpha"] = "shadowAlpha";
			translation["shadow-blur-x"] = "shadowBlurX";
			translation["shadow-blur-y"] = "shadowBlurY";
			translation["shadow-strength"] = "shadowStrength";
			translation["shadow-color"] = "shadowColor";
			translation["shadow-quality"] = "shadowQuality";
			translation["shadow-inner"] = "shadowInner";
			translation["shadow-knockout"] = "shadowKnockout";
			translation["shadow-hide"] = "shadowHide";
			translation["rotate"] = "rotate";
			translation["overflow"] = "overflow";
			translation["link"] = "link";
			
		this.params[translation[key]] = value;
	}

	/*
		Swap SWF
	*/
	this.swap = function( selector )
	{
		if(typeof(selector).toLowerCase() == 'string')
		{
			var elements = document.getElementsBySelector(selector);
		}
		else if(selector.nodeName)
		{
			var elements = [selector];
		}
		else if(selector.length != 0)
		{
			var elements = selector;
		}
		
		if(this.hasImg(elements) == false)
		{
			var elements = document.getElementsBySelector(selector+" img");
			if(this.hasImg(elements) == false && this.debug == true)
			{
				this.error("No images were selected with the selector '"+selector+"'");
				return;
			}
		}
		
		for(var i=0; i<elements.length; i++)
		{
			/*
				Embed Params
			*/
			var id = "";
			var className = "";
			var style = "";
			var width = "";
			var height = "";
			var bgcolor = "";
			var src = this.src;
			var flashvars = "";
			
			/*
				Retain some existing parameters
			*/
			if(elements[i].getAttribute("id"))
			{
				id = elements[i].getAttribute("id");
			}
			if(elements[i].className != '')
			{
				className = elements[i].className+' swfir';
			}
			else
			{
				className = 'swfir';
			}
			
			if(this.background != "")
			{
				bgcolor = this.background;
			}
			if(elements[i].getAttribute("style"))
			{
				if(elements[i].style.cssText && elements[i].style.cssText != "")
				{
					style += elements[i].style.cssText+";";
				}
				else if(typeof elements[i].getAttribute("style") == "string")
				{
					style += elements[i].getAttribute("style");
				}
			}
			
			width = elements[i].width;
			height = elements[i].height;
			
			if(this.elasticityWidth != false)
			{
				if(style != "") style += " ";
				style += "width:"+(width / this.elasticityWidth)+"em;";
			}
			else
			{
				if(elements[i].getAttribute("width",2))
				{
					if(style != "") style += " ";
					style += "width:"+elements[i].getAttribute("width",2)+";";
				}
				if(elements[i].getAttribute("height",2))
				{
					if(style != "") style += " ";
					style += "height:"+elements[i].getAttribute("height",2)+";";
				}
			}
			
			/*
				Pass in Width/Height
			*/
			this.params['srcWidth'] = width;
			this.params['srcHeight'] = height;
			
			/*
				Flash Vars
			*/
			var varString = "";
			for(var key in this.params){ varString += ("&"+key+'='+ this.params[key]); }
			
			/*
				Is there a link
			*/
			if((elementLink = this.withinLink(elements[i])) != false && !this.params["link"])
			{
				varString += "&link="+elementLink.href.replace(/\?/g,"%3F").replace(/&/g,"%26");
			}
			
			/*
				Add the vars
			*/
			flashvars = "url="+elements[i].src+varString+"&swfirId="+firController.getNextId();
			
			/*
				Create Container Span
			*/
			var span = document.createElement('span');
				if(id) span.setAttribute("id", id);
				if(className) span.className = className;
			elements[i].parentNode.insertBefore(span, elements[i]);
			span.appendChild(elements[i].parentNode.removeChild(elements[i]));
			
			/*
				Add the Flash
			*/
			var so = new SWFObject(this.src, "swfir"+firController.getNextId(), width, height, "6", this.bgcolor);
				if(style != "") so.setAttribute('style', style);
				so.addParam('flashvars', flashvars);
				so.addParam("menu", "false");
				so.addParam("wmode", this.wmode);
			so.write(span);
			
			/*
				Remember Me
			*/
			firController.addswfir(span.firstChild);
		}
	}
	
	this.cleanColor = function( color, style )
	{
		color = color.replace(/^0x/, '');
		color = color.replace(/^#/, '');
		if(color.length == "3")
		{
			color = color.substring(0,1)+color.substring(0,1)+color.substring(1,2)+color.substring(1,2)+color.substring(2,3)+color.substring(2,3);
		}
		if(style == "flash")
		{
			color = "0x"+color;
		}
		else
		{
			color = "#"+color;
		}
		return color;
	}
	
	this.hasImg = function ( elementList )
	{
		for(var i=0; i<elementList.length; i++)
		{
			if(elementList[i].nodeName == "IMG")
			{
				return true;
			}
		}
		return false;
	}
	
	this.withinLink = function( element )
	{
		while(element.nodeName != "A")
		{
			if(element.parentNode)
			{
				element = element.parentNode;
			}
			else
			{
				return false;
			}
		}
		return element;
	}
	
	this.error = function( alertString )
	{
		alert(this.name+" "+this.version+" Error\n\n"+alertString);
	}
}


/**
 * SWFObject v1.4.4: Flash Player detection and embed - http://blog.deconcept.com/swfobject/
 *
 * SWFObject is (c) 2006 Geoff Stearns and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 *
 * **SWFObject is the SWF embed script formerly known as FlashObject. The name was changed for
 *   legal reasons.
 */
if(typeof deconcept=="undefined"){var deconcept=new Object();}
if(typeof deconcept.util=="undefined"){deconcept.util=new Object();}
if(typeof deconcept.SWFObjectUtil=="undefined"){deconcept.SWFObjectUtil=new Object();}
deconcept.SWFObject=function(_1,id,w,h,_5,c,_7,_8,_9,_a,_b){if(!document.getElementById){return;}
this.DETECT_KEY=_b?_b:"detectflash";
this.skipDetect=deconcept.util.getRequestParameter(this.DETECT_KEY);
this.params=new Object();
this.variables=new Object();
this.attributes=new Array();
if(_1){this.setAttribute("swf",_1);}
if(id){this.setAttribute("id",id);}
if(w){this.setAttribute("width",w);}
if(h){this.setAttribute("height",h);}
if(_5){this.setAttribute("version",new deconcept.PlayerVersion(_5.toString().split(".")));}
this.installedVer=deconcept.SWFObjectUtil.getPlayerVersion();
if(c){this.addParam("bgcolor",c);}
var q=_8?_8:"high";
this.addParam("quality",q);
this.setAttribute("useExpressInstall",_7);
this.setAttribute("doExpressInstall",false);
var _d=(_9)?_9:window.location;
this.setAttribute("xiRedirectUrl",_d);
this.setAttribute("redirectUrl","");
if(_a){this.setAttribute("redirectUrl",_a);}};
deconcept.SWFObject.prototype={setAttribute:function(_e,_f){
this.attributes[_e]=_f;
},getAttribute:function(_10){
return this.attributes[_10];
},addParam:function(_11,_12){
this.params[_11]=_12;
},getParams:function(){
return this.params;
},addVariable:function(_13,_14){
this.variables[_13]=_14;
},getVariable:function(_15){
return this.variables[_15];
},getVariables:function(){
return this.variables;
},getVariablePairs:function(){
var _16=new Array();
var key;
var _18=this.getVariables();
for(key in _18){_16.push(key+"="+_18[key]);}
return _16;},getSWFHTML:function(){var _19="";
if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){
if(this.getAttribute("doExpressInstall")){
this.addVariable("MMplayerType","PlugIn");}
_19="<embed type=\"application/x-shockwave-flash\" src=\""+this.getAttribute("swf")+"\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\"  style=\""+this.getAttribute("style")+"\"";
_19+=" id=\""+this.getAttribute("id")+"\" name=\""+this.getAttribute("id")+"\" ";
var _1a=this.getParams();
for(var key in _1a){_19+=[key]+"=\""+_1a[key]+"\" ";}
var _1c=this.getVariablePairs().join("&");
if(_1c.length>0){_19+="flashvars=\""+_1c+"\"";}_19+="/>";
}else{if(this.getAttribute("doExpressInstall")){this.addVariable("MMplayerType","ActiveX");}
_19="<object id=\""+this.getAttribute("id")+"\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\"  style=\""+this.getAttribute("style")+"\">";
_19+="<param name=\"movie\" value=\""+this.getAttribute("swf")+"\" />";
var _1d=this.getParams();
for(var key in _1d){_19+="<param name=\""+key+"\" value=\""+_1d[key]+"\" />";}
var _1f=this.getVariablePairs().join("&");
if(_1f.length>0){_19+="<param name=\"flashvars\" value=\""+_1f+"\" />";}_19+="</object>";}
return _19;
},write:function(_20){
if(this.getAttribute("useExpressInstall")){
var _21=new deconcept.PlayerVersion([6,0,65]);
if(this.installedVer.versionIsValid(_21)&&!this.installedVer.versionIsValid(this.getAttribute("version"))){
this.setAttribute("doExpressInstall",true);
this.addVariable("MMredirectURL",escape(this.getAttribute("xiRedirectUrl")));
document.title=document.title.slice(0,47)+" - Flash Player Installation";
this.addVariable("MMdoctitle",document.title);}}
if(this.skipDetect||this.getAttribute("doExpressInstall")||this.installedVer.versionIsValid(this.getAttribute("version"))){
var n=(typeof _20=="string")?document.getElementById(_20):_20;
n.innerHTML=this.getSWFHTML();return true;
}else{if(this.getAttribute("redirectUrl")!=""){document.location.replace(this.getAttribute("redirectUrl"));}}
return false;}};
deconcept.SWFObjectUtil.getPlayerVersion=function(){
var _23=new deconcept.PlayerVersion([0,0,0]);
if(navigator.plugins&&navigator.mimeTypes.length){
var x=navigator.plugins["Shockwave Flash"];
if(x&&x.description){_23=new deconcept.PlayerVersion(x.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s+r|\s+b[0-9]+)/,".").split("."));}
}else{try{var axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7");}
catch(e){try{var axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6");
_23=new deconcept.PlayerVersion([6,0,21]);axo.AllowScriptAccess="always";}
catch(e){if(_23.major==6){return _23;}}try{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash");}
catch(e){}}if(axo!=null){_23=new deconcept.PlayerVersion(axo.GetVariable("$version").split(" ")[1].split(","));}}
return _23;};
deconcept.PlayerVersion=function(_27){
this.major=_27[0]!=null?parseInt(_27[0]):0;
this.minor=_27[1]!=null?parseInt(_27[1]):0;
this.rev=_27[2]!=null?parseInt(_27[2]):0;
};
deconcept.PlayerVersion.prototype.versionIsValid=function(fv){
if(this.major<fv.major){return false;}
if(this.major>fv.major){return true;}
if(this.minor<fv.minor){return false;}
if(this.minor>fv.minor){return true;}
if(this.rev<fv.rev){
return false;
}return true;};
deconcept.util={getRequestParameter:function(_29){
var q=document.location.search||document.location.hash;
if(q){var _2b=q.substring(1).split("&");
for(var i=0;i<_2b.length;i++){
if(_2b[i].substring(0,_2b[i].indexOf("="))==_29){
return _2b[i].substring((_2b[i].indexOf("=")+1));}}}
return "";}};
deconcept.SWFObjectUtil.cleanupSWFs=function(){if(window.opera||!document.all){return;}
var _2d=document.getElementsByTagName("OBJECT");
for(var i=0;i<_2d.length;i++){_2d[i].style.display="none";for(var x in _2d[i]){
if(typeof _2d[i][x]=="function"){_2d[i][x]=function(){};}}}};
deconcept.SWFObjectUtil.prepUnload=function(){__flash_unloadHandler=function(){};
__flash_savedUnloadHandler=function(){};
if(typeof window.onunload=="function"){
var _30=window.onunload;
window.onunload=function(){
deconcept.SWFObjectUtil.cleanupSWFs();_30();};
}else{window.onunload=deconcept.SWFObjectUtil.cleanupSWFs;}};
if(typeof window.onbeforeunload=="function"){
var oldBeforeUnload=window.onbeforeunload;
window.onbeforeunload=function(){
deconcept.SWFObjectUtil.prepUnload();
oldBeforeUnload();};
}else{window.onbeforeunload=deconcept.SWFObjectUtil.prepUnload;}
if(Array.prototype.push==null){
Array.prototype.push=function(_31){
this[this.length]=_31;
return this.length;};}
var getQueryParamValue=deconcept.util.getRequestParameter;
var FlashObject=deconcept.SWFObject;
var SWFObject=deconcept.SWFObject;
