var Prototype={Version:"1.7.1",Browser:(function(){var b=navigator.userAgent;var a=Object.prototype.toString.call(window.opera)=="[object Opera]";
return{IE:!!window.attachEvent&&!a,Opera:a,WebKit:b.indexOf("AppleWebKit/")>-1,Gecko:b.indexOf("Gecko")>-1&&b.indexOf("KHTML")===-1,MobileSafari:/Apple.*Mobile/.test(b)}
})(),BrowserFeatures:{XPath:!!document.evaluate,SelectorsAPI:!!document.querySelector,ElementExtensions:(function(){var a=window.Element||window.HTMLElement;
return !!(a&&a.prototype)})(),SpecificElementExtensions:(function(){if(typeof window.HTMLDivElement!=="undefined"){return true}var c=document.createElement("div"),b=document.createElement("form"),a=false;
if(c.__proto__&&(c.__proto__!==b.__proto__)){a=true}c=b=null;return a})()},ScriptFragment:"<script[^>]*>([\\S\\s]*?)<\/script\\s*>",JSONFilter:/^\/\*-secure-([\s\S]*)\*\/\s*$/,emptyFunction:function(){},K:function(a){return a
}};if(Prototype.Browser.MobileSafari){Prototype.BrowserFeatures.SpecificElementExtensions=false}var Class=(function(){var d=(function(){for(var e in {toString:1}){if(e==="toString"){return false
}}return true})();function a(){}function b(){var h=null,g=$A(arguments);if(Object.isFunction(g[0])){h=g.shift()}function e(){this.initialize.apply(this,arguments)
}Object.extend(e,Class.Methods);e.superclass=h;e.subclasses=[];if(h){a.prototype=h.prototype;e.prototype=new a;h.subclasses.push(e)}for(var f=0,j=g.length;
f<j;f++){e.addMethods(g[f])}if(!e.prototype.initialize){e.prototype.initialize=Prototype.emptyFunction}e.prototype.constructor=e;return e
}function c(l){var g=this.superclass&&this.superclass.prototype,f=Object.keys(l);if(d){if(l.toString!=Object.prototype.toString){f.push("toString")
}if(l.valueOf!=Object.prototype.valueOf){f.push("valueOf")}}for(var e=0,h=f.length;e<h;e++){var k=f[e],j=l[k];if(g&&Object.isFunction(j)&&j.argumentNames()[0]=="$super"){var m=j;
j=(function(n){return function(){return g[n].apply(this,arguments)}})(k).wrap(m);j.valueOf=(function(n){return function(){return n.valueOf.call(n)
}})(m);j.toString=(function(n){return function(){return n.toString.call(n)}})(m)}this.prototype[k]=j}return this}return{create:b,Methods:{addMethods:c}}
})();(function(){var z=Object.prototype.toString,l=Object.prototype.hasOwnProperty,A="Null",C="Undefined",L="Boolean",x="Number",w="String",J="Object",j="[object Function]",d="[object Boolean]",k="[object Number]",f="[object String]",b="[object Array]",I="[object Date]",e=window.JSON&&typeof JSON.stringify==="function"&&JSON.stringify(0)==="0"&&typeof JSON.stringify(Prototype.K)==="undefined";
var r=["toString","toLocaleString","valueOf","hasOwnProperty","isPrototypeOf","propertyIsEnumerable","constructor"];var a=(function(){for(var M in {toString:1}){if(M==="toString"){return false
}}return true})();function E(N){switch(N){case null:return A;case (void 0):return C}var M=typeof N;switch(M){case"boolean":return L;case"number":return x;
case"string":return w}return J}function h(M,O){for(var N in O){M[N]=O[N]}return M}function m(M){try{if(p(M)){return"undefined"}if(M===null){return"null"
}return M.inspect?M.inspect():String(M)}catch(N){if(N instanceof RangeError){return"..."}throw N}}function B(M){return n("",{"":M},[])
}function n(V,S,T){var U=S[V];if(E(U)===J&&typeof U.toJSON==="function"){U=U.toJSON(V)}var O=z.call(U);switch(O){case k:case d:case f:U=U.valueOf()
}switch(U){case null:return"null";case true:return"true";case false:return"false"}var R=typeof U;switch(R){case"string":return U.inspect(true);
case"number":return isFinite(U)?String(U):"null";case"object":for(var N=0,M=T.length;N<M;N++){if(T[N]===U){throw new TypeError("Cyclic reference to '"+U+"' in object")
}}T.push(U);var Q=[];if(O===b){for(var N=0,M=U.length;N<M;N++){var P=n(N,U,T);Q.push(typeof P==="undefined"?"null":P)}Q="["+Q.join(",")+"]"
}else{var W=Object.keys(U);for(var N=0,M=W.length;N<M;N++){var V=W[N],P=n(V,U,T);if(typeof P!=="undefined"){Q.push(V.inspect(true)+":"+P)
}}Q="{"+Q.join(",")+"}"}T.pop();return Q}}function K(M){return JSON.stringify(M)}function D(M){return $H(M).toQueryString()}function q(M){return M&&M.toHTML?M.toHTML():String.interpret(M)
}function y(M){if(E(M)!==J){throw new TypeError()}var O=[];for(var P in M){if(l.call(M,P)){O.push(P)}}if(a){for(var N=0;P=r[N];N++){if(l.call(M,P)){O.push(P)
}}}return O}function H(M){var N=[];for(var O in M){N.push(M[O])}return N}function t(M){return h({},M)}function F(M){return !!(M&&M.nodeType==1)
}function v(M){return z.call(M)===b}var c=(typeof Array.isArray=="function")&&Array.isArray([])&&!Array.isArray({});if(c){v=Array.isArray
}function s(M){return M instanceof Hash}function o(M){return z.call(M)===j}function g(M){return z.call(M)===f}function G(M){return z.call(M)===k
}function u(M){return z.call(M)===I}function p(M){return typeof M==="undefined"}h(Object,{extend:h,inspect:m,toJSON:e?K:B,toQueryString:D,toHTML:q,keys:Object.keys||y,values:H,clone:t,isElement:F,isArray:v,isHash:s,isFunction:o,isString:g,isNumber:G,isDate:u,isUndefined:p})
})();Object.extend(Function.prototype,(function(){var m=Array.prototype.slice;function d(q,n){var p=q.length,o=n.length;while(o--){q[p+o]=n[o]
}return q}function k(o,n){o=m.call(o,0);return d(o,n)}function g(){var n=this.toString().match(/^[\s\(]*function[^(]*\(([^)]*)\)/)[1].replace(/\/\/.*?[\r\n]|\/\*(?:.|[\r\n])*?\*\//g,"").replace(/\s+/g,"").split(",");
return n.length==1&&!n[0]?[]:n}function h(p){if(arguments.length<2&&Object.isUndefined(arguments[0])){return this}if(!Object.isFunction(this)){throw new TypeError("The object is not callable.")
}var r=function(){};var n=this,o=m.call(arguments,1);var q=function(){var s=k(o,arguments),t=p;var t=this instanceof q?this:p;return n.apply(t,s)
};r.prototype=this.prototype;q.prototype=new r();return q}function f(p){var n=this,o=m.call(arguments,1);return function(r){var q=d([r||window.event],o);
return n.apply(p,q)}}function l(){if(!arguments.length){return this}var n=this,o=m.call(arguments,0);return function(){var p=k(o,arguments);
return n.apply(this,p)}}function e(p){var n=this,o=m.call(arguments,1);p=p*1000;return window.setTimeout(function(){return n.apply(n,o)
},p)}function a(){var n=d([0.01],arguments);return this.delay.apply(this,n)}function c(o){var n=this;return function(){var p=d([n.bind(this)],arguments);
return o.apply(this,p)}}function b(){if(this._methodized){return this._methodized}var n=this;return this._methodized=function(){var o=d([this],arguments);
return n.apply(null,o)}}var j={argumentNames:g,bindAsEventListener:f,curry:l,delay:e,defer:a,wrap:c,methodize:b};if(!Function.prototype.bind){j.bind=h
}return j})());(function(c){function b(){return this.getUTCFullYear()+"-"+(this.getUTCMonth()+1).toPaddedString(2)+"-"+this.getUTCDate().toPaddedString(2)+"T"+this.getUTCHours().toPaddedString(2)+":"+this.getUTCMinutes().toPaddedString(2)+":"+this.getUTCSeconds().toPaddedString(2)+"Z"
}function a(){return this.toISOString()}if(!c.toISOString){c.toISOString=b}if(!c.toJSON){c.toJSON=a}})(Date.prototype);RegExp.prototype.match=RegExp.prototype.test;
RegExp.escape=function(a){return String(a).replace(/([.*+?^=!:${}()|[\]\/\\])/g,"\\$1")};var PeriodicalExecuter=Class.create({initialize:function(b,a){this.callback=b;
this.frequency=a;this.currentlyExecuting=false;this.registerCallback()},registerCallback:function(){this.timer=setInterval(this.onTimerEvent.bind(this),this.frequency*1000)
},execute:function(){this.callback(this)},stop:function(){if(!this.timer){return}clearInterval(this.timer);this.timer=null},onTimerEvent:function(){if(!this.currentlyExecuting){try{this.currentlyExecuting=true;
this.execute();this.currentlyExecuting=false}catch(a){this.currentlyExecuting=false;throw a}}}});Object.extend(String,{interpret:function(a){return a==null?"":String(a)
},specialChar:{"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r","\\":"\\\\"}});Object.extend(String.prototype,(function(){var NATIVE_JSON_PARSE_SUPPORT=window.JSON&&typeof JSON.parse==="function"&&JSON.parse('{"test": true}').test;
function prepareReplacement(replacement){if(Object.isFunction(replacement)){return replacement}var template=new Template(replacement);
return function(match){return template.evaluate(match)}}function gsub(pattern,replacement){var result="",source=this,match;replacement=prepareReplacement(replacement);
if(Object.isString(pattern)){pattern=RegExp.escape(pattern)}if(!(pattern.length||pattern.source)){replacement=replacement("");return replacement+source.split("").join(replacement)+replacement
}while(source.length>0){if(match=source.match(pattern)){result+=source.slice(0,match.index);result+=String.interpret(replacement(match));
source=source.slice(match.index+match[0].length)}else{result+=source,source=""}}return result}function sub(pattern,replacement,count){replacement=prepareReplacement(replacement);
count=Object.isUndefined(count)?1:count;return this.gsub(pattern,function(match){if(--count<0){return match[0]}return replacement(match)
})}function scan(pattern,iterator){this.gsub(pattern,iterator);return String(this)}function truncate(length,truncation){length=length||30;
truncation=Object.isUndefined(truncation)?"...":truncation;return this.length>length?this.slice(0,length-truncation.length)+truncation:String(this)
}function strip(){return this.replace(/^\s+/,"").replace(/\s+$/,"")}function stripTags(){return this.replace(/<\w+(\s+("[^"]*"|'[^']*'|[^>])+)?>|<\/\w+>/gi,"")
}function stripScripts(){return this.replace(new RegExp(Prototype.ScriptFragment,"img"),"")}function extractScripts(){var matchAll=new RegExp(Prototype.ScriptFragment,"img"),matchOne=new RegExp(Prototype.ScriptFragment,"im");
return(this.match(matchAll)||[]).map(function(scriptTag){return(scriptTag.match(matchOne)||["",""])[1]})}function evalScripts(){return this.extractScripts().map(function(script){return eval(script)
})}function escapeHTML(){return this.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;")}function unescapeHTML(){return this.stripTags().replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&amp;/g,"&")
}function toQueryParams(separator){var match=this.strip().match(/([^?#]*)(#.*)?$/);if(!match){return{}}return match[1].split(separator||"&").inject({},function(hash,pair){if((pair=pair.split("="))[0]){var key=decodeURIComponent(pair.shift()),value=pair.length>1?pair.join("="):pair[0];
if(value!=undefined){value=decodeURIComponent(value)}if(key in hash){if(!Object.isArray(hash[key])){hash[key]=[hash[key]]}hash[key].push(value)
}else{hash[key]=value}}return hash})}function toArray(){return this.split("")}function succ(){return this.slice(0,this.length-1)+String.fromCharCode(this.charCodeAt(this.length-1)+1)
}function times(count){return count<1?"":new Array(count+1).join(this)}function camelize(){return this.replace(/-+(.)?/g,function(match,chr){return chr?chr.toUpperCase():""
})}function capitalize(){return this.charAt(0).toUpperCase()+this.substring(1).toLowerCase()}function underscore(){return this.replace(/::/g,"/").replace(/([A-Z]+)([A-Z][a-z])/g,"$1_$2").replace(/([a-z\d])([A-Z])/g,"$1_$2").replace(/-/g,"_").toLowerCase()
}function dasherize(){return this.replace(/_/g,"-")}function inspect(useDoubleQuotes){var escapedString=this.replace(/[\x00-\x1f\\]/g,function(character){if(character in String.specialChar){return String.specialChar[character]
}return"\\u00"+character.charCodeAt().toPaddedString(2,16)});if(useDoubleQuotes){return'"'+escapedString.replace(/"/g,'\\"')+'"'}return"'"+escapedString.replace(/'/g,"\\'")+"'"
}function unfilterJSON(filter){return this.replace(filter||Prototype.JSONFilter,"$1")}function isJSON(){var str=this;if(str.blank()){return false
}str=str.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@");str=str.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]");
str=str.replace(/(?:^|:|,)(?:\s*\[)+/g,"");return(/^[\],:{}\s]*$/).test(str)}function evalJSON(sanitize){var json=this.unfilterJSON(),cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
if(cx.test(json)){json=json.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})}try{if(!sanitize||json.isJSON()){return eval("("+json+")")
}}catch(e){}throw new SyntaxError("Badly formed JSON string: "+this.inspect())}function parseJSON(){var json=this.unfilterJSON();return JSON.parse(json)
}function include(pattern){return this.indexOf(pattern)>-1}function startsWith(pattern){return this.lastIndexOf(pattern,0)===0}function endsWith(pattern){var d=this.length-pattern.length;
return d>=0&&this.indexOf(pattern,d)===d}function empty(){return this==""}function blank(){return/^\s*$/.test(this)}function interpolate(object,pattern){return new Template(this,pattern).evaluate(object)
}return{gsub:gsub,sub:sub,scan:scan,truncate:truncate,strip:String.prototype.trim||strip,stripTags:stripTags,stripScripts:stripScripts,extractScripts:extractScripts,evalScripts:evalScripts,escapeHTML:escapeHTML,unescapeHTML:unescapeHTML,toQueryParams:toQueryParams,parseQuery:toQueryParams,toArray:toArray,succ:succ,times:times,camelize:camelize,capitalize:capitalize,underscore:underscore,dasherize:dasherize,inspect:inspect,unfilterJSON:unfilterJSON,isJSON:isJSON,evalJSON:NATIVE_JSON_PARSE_SUPPORT?parseJSON:evalJSON,include:include,startsWith:startsWith,endsWith:endsWith,empty:empty,blank:blank,interpolate:interpolate}
})());var Template=Class.create({initialize:function(a,b){this.template=a.toString();this.pattern=b||Template.Pattern},evaluate:function(a){if(a&&Object.isFunction(a.toTemplateReplacements)){a=a.toTemplateReplacements()
}return this.template.gsub(this.pattern,function(d){if(a==null){return(d[1]+"")}var f=d[1]||"";if(f=="\\"){return d[2]}var b=a,g=d[3],e=/^([^.[]+|\[((?:.*?[^\\])?)\])(\.|\[|$)/;
d=e.exec(g);if(d==null){return f}while(d!=null){var c=d[1].startsWith("[")?d[2].replace(/\\\\]/g,"]"):d[1];b=b[c];if(null==b||""==d[3]){break
}g=g.substring("["==d[3]?d[1].length:d[0].length);d=e.exec(g)}return f+String.interpret(b)})}});Template.Pattern=/(^|.|\r|\n)(#\{(.*?)\})/;
var $break={};var Enumerable=(function(){function c(y,x){try{this._each(y,x)}catch(z){if(z!=$break){throw z}}return this}function s(A,z,y){var x=-A,B=[],C=this.toArray();
if(A<1){return C}while((x+=A)<C.length){B.push(C.slice(x,x+A))}return B.collect(z,y)}function b(z,y){z=z||Prototype.K;var x=true;this.each(function(B,A){x=x&&!!z.call(y,B,A,this);
if(!x){throw $break}},this);return x}function j(z,y){z=z||Prototype.K;var x=false;this.each(function(B,A){if(x=!!z.call(y,B,A,this)){throw $break
}},this);return x}function k(z,y){z=z||Prototype.K;var x=[];this.each(function(B,A){x.push(z.call(y,B,A,this))},this);return x}function u(z,y){var x;
this.each(function(B,A){if(z.call(y,B,A,this)){x=B;throw $break}},this);return x}function h(z,y){var x=[];this.each(function(B,A){if(z.call(y,B,A,this)){x.push(B)
}},this);return x}function g(A,z,y){z=z||Prototype.K;var x=[];if(Object.isString(A)){A=new RegExp(RegExp.escape(A))}this.each(function(C,B){if(A.match(C)){x.push(z.call(y,C,B,this))
}},this);return x}function a(x){if(Object.isFunction(this.indexOf)){if(this.indexOf(x)!=-1){return true}}var y=false;this.each(function(z){if(z==x){y=true;
throw $break}});return y}function r(y,x){x=Object.isUndefined(x)?null:x;return this.eachSlice(y,function(z){while(z.length<y){z.push(x)
}return z})}function m(x,z,y){this.each(function(B,A){x=z.call(y,x,B,A,this)},this);return x}function w(y){var x=$A(arguments).slice(1);
return this.map(function(z){return z[y].apply(z,x)})}function q(z,y){z=z||Prototype.K;var x;this.each(function(B,A){B=z.call(y,B,A,this);
if(x==null||B>=x){x=B}},this);return x}function o(z,y){z=z||Prototype.K;var x;this.each(function(B,A){B=z.call(y,B,A,this);if(x==null||B<x){x=B
}},this);return x}function e(A,y){A=A||Prototype.K;var z=[],x=[];this.each(function(C,B){(A.call(y,C,B,this)?z:x).push(C)},this);return[z,x]
}function f(y){var x=[];this.each(function(z){x.push(z[y])});return x}function d(z,y){var x=[];this.each(function(B,A){if(!z.call(y,B,A,this)){x.push(B)
}},this);return x}function n(y,x){return this.map(function(A,z){return{value:A,criteria:y.call(x,A,z,this)}},this).sort(function(C,B){var A=C.criteria,z=B.criteria;
return A<z?-1:A>z?1:0}).pluck("value")}function p(){return this.map()}function t(){var y=Prototype.K,x=$A(arguments);if(Object.isFunction(x.last())){y=x.pop()
}var z=[this].concat(x).map($A);return this.map(function(B,A){return y(z.pluck(A))})}function l(){return this.toArray().length}function v(){return"#<Enumerable:"+this.toArray().inspect()+">"
}return{each:c,eachSlice:s,all:b,every:b,any:j,some:j,collect:k,map:k,detect:u,findAll:h,select:h,filter:h,grep:g,include:a,member:a,inGroupsOf:r,inject:m,invoke:w,max:q,min:o,partition:e,pluck:f,reject:d,sortBy:n,toArray:p,entries:p,zip:t,size:l,inspect:v,find:u}
})();function $A(c){if(!c){return[]}if("toArray" in Object(c)){return c.toArray()}var b=c.length||0,a=new Array(b);while(b--){a[b]=c[b]
}return a}function $w(a){if(!Object.isString(a)){return[]}a=a.strip();return a?a.split(/\s+/):[]}Array.from=$A;(function(){var y=Array.prototype,q=y.slice,s=y.forEach;
function b(E,D){for(var C=0,F=this.length>>>0;C<F;C++){if(C in this){E.call(D,this[C],C,this)}}}if(!s){s=b}function p(){this.length=0;
return this}function d(){return this[0]}function g(){return this[this.length-1]}function l(){return this.select(function(C){return C!=null
})}function B(){return this.inject([],function(D,C){if(Object.isArray(C)){return D.concat(C.flatten())}D.push(C);return D})}function k(){var C=q.call(arguments,0);
return this.select(function(D){return !C.include(D)})}function f(C){return(C===false?this.toArray():this)._reverse()}function o(C){return this.inject([],function(F,E,D){if(0==D||(C?F.last()!=E:!F.include(E))){F.push(E)
}return F})}function t(C){return this.uniq().findAll(function(D){return C.indexOf(D)!==-1})}function w(){return q.call(this,0)}function m(){return this.length
}function z(){return"["+this.map(Object.inspect).join(", ")+"]"}function a(F,D){if(this==null){throw new TypeError()}var G=Object(this),E=G.length>>>0;
if(E===0){return -1}D=Number(D);if(isNaN(D)){D=0}else{if(D!==0&&isFinite(D)){D=(D>0?1:-1)*Math.floor(Math.abs(D))}}if(D>E){return -1}var C=D>=0?D:Math.max(E-Math.abs(D),0);
for(;C<E;C++){if(C in G&&G[C]===F){return C}}return -1}function r(F,D){if(this==null){throw new TypeError()}var G=Object(this),E=G.length>>>0;
if(E===0){return -1}if(!Object.isUndefined(D)){D=Number(D);if(isNaN(D)){D=0}else{if(D!==0&&isFinite(D)){D=(D>0?1:-1)*Math.floor(Math.abs(D))
}}}else{D=E}var C=D>=0?Math.min(D,E-1):E-Math.abs(D);for(;C>=0;C--){if(C in G&&G[C]===F){return C}}return -1}function c(J){var H=[],I=q.call(arguments,0),K,D=0;
I.unshift(this);for(var G=0,C=I.length;G<C;G++){K=I[G];if(Object.isArray(K)&&!("callee" in K)){for(var F=0,E=K.length;F<E;F++){if(F in K){H[D]=K[F]
}D++}}else{H[D++]=K}}H.length=D;return H}function v(C){return function(){if(arguments.length===0){return C.call(this,Prototype.K)}else{if(arguments[0]===undefined){var D=q.call(arguments,1);
D.unshift(Prototype.K);return C.apply(this,D)}else{return C.apply(this,arguments)}}}}function x(G){if(this==null){throw new TypeError()
}G=G||Prototype.K;var C=Object(this);var F=[],E=arguments[1],I=0;for(var D=0,H=C.length>>>0;D<H;D++){if(D in C){F[I]=G.call(E,C[D],D,C)
}I++}F.length=I;return F}if(y.map){x=v(Array.prototype.map)}function h(G){if(this==null||!Object.isFunction(G)){throw new TypeError()
}var C=Object(this);var F=[],E=arguments[1],I;for(var D=0,H=C.length>>>0;D<H;D++){if(D in C){I=C[D];if(G.call(E,I,D,C)){F.push(I)}}}return F
}if(y.filter){h=Array.prototype.filter}function j(F){if(this==null){throw new TypeError()}F=F||Prototype.K;var E=arguments[1];var C=Object(this);
for(var D=0,G=C.length>>>0;D<G;D++){if(D in C&&F.call(E,C[D],D,C)){return true}}return false}if(y.some){var j=v(Array.prototype.some)
}function A(F){if(this==null){throw new TypeError()}F=F||Prototype.K;var E=arguments[1];var C=Object(this);for(var D=0,G=C.length>>>0;
D<G;D++){if(D in C&&!F.call(E,C[D],D,C)){return false}}return true}if(y.every){var A=v(Array.prototype.every)}var u=y.reduce;function n(C,E){E=E||Prototype.K;
var D=arguments[2];return u.call(this,E.bind(D),C)}if(!y.reduce){var n=Enumerable.inject}Object.extend(y,Enumerable);if(!y._reverse){y._reverse=y.reverse
}Object.extend(y,{_each:s,map:x,collect:x,select:h,filter:h,findAll:h,some:j,any:j,every:A,all:A,inject:n,clear:p,first:d,last:g,compact:l,flatten:B,without:k,reverse:f,uniq:o,intersect:t,clone:w,toArray:w,size:m,inspect:z});
var e=(function(){return[].concat(arguments)[0][0]!==1})(1,2);if(e){y.concat=c}if(!y.indexOf){y.indexOf=a}if(!y.lastIndexOf){y.lastIndexOf=r
}})();function $H(a){return new Hash(a)}var Hash=Class.create(Enumerable,(function(){function e(q){this._object=Object.isHash(q)?q.toObject():Object.clone(q)
}function f(s,r){for(var q in this._object){var t=this._object[q],u=[q,t];u.key=q;u.value=t;s.call(r,u)}}function k(q,r){return this._object[q]=r
}function c(q){if(this._object[q]!==Object.prototype[q]){return this._object[q]}}function n(q){var r=this._object[q];delete this._object[q];
return r}function p(){return Object.clone(this._object)}function o(){return this.pluck("key")}function m(){return this.pluck("value")
}function g(r){var q=this.detect(function(s){return s.value===r});return q&&q.key}function j(q){return this.clone().update(q)}function d(q){return new Hash(q).inject(this,function(r,s){r.set(s.key,s.value);
return r})}function b(q,r){if(Object.isUndefined(r)){return q}var r=String.interpret(r);r=r.gsub(/(\r)?\n/,"\r\n");r=encodeURIComponent(r);
r=r.gsub(/%20/,"+");return q+"="+r}function a(){return this.inject([],function(u,x){var t=encodeURIComponent(x.key),r=x.value;if(r&&typeof r=="object"){if(Object.isArray(r)){var w=[];
for(var s=0,q=r.length,v;s<q;s++){v=r[s];w.push(b(t,v))}return u.concat(w)}}else{u.push(b(t,r))}return u}).join("&")}function l(){return"#<Hash:{"+this.map(function(q){return q.map(Object.inspect).join(": ")
}).join(", ")+"}>"}function h(){return new Hash(this)}return{initialize:e,_each:f,set:k,get:c,unset:n,toObject:p,toTemplateReplacements:p,keys:o,values:m,index:g,merge:j,update:d,toQueryString:a,inspect:l,toJSON:p,clone:h}
})());Hash.from=$H;Object.extend(Number.prototype,(function(){function d(){return this.toPaddedString(2,16)}function b(){return this+1
}function h(k,j){$R(0,this,true).each(k,j);return this}function g(l,k){var j=this.toString(k||10);return"0".times(l-j.length)+j}function a(){return Math.abs(this)
}function c(){return Math.round(this)}function e(){return Math.ceil(this)}function f(){return Math.floor(this)}return{toColorPart:d,succ:b,times:h,toPaddedString:g,abs:a,round:c,ceil:e,floor:f}
})());function $R(c,a,b){return new ObjectRange(c,a,b)}var ObjectRange=Class.create(Enumerable,(function(){function b(f,d,e){this.start=f;
this.end=d;this.exclusive=e}function c(e,d){var f=this.start;while(this.include(f)){e.call(d,f);f=f.succ()}}function a(d){if(d<this.start){return false
}if(this.exclusive){return d<this.end}return d<=this.end}return{initialize:b,_each:c,include:a}})());var Abstract={};var Try={these:function(){var c;
for(var b=0,d=arguments.length;b<d;b++){var a=arguments[b];try{c=a();break}catch(f){}}return c}};var Ajax={getTransport:function(){return Try.these(function(){return new XMLHttpRequest()
},function(){return new ActiveXObject("Msxml2.XMLHTTP")},function(){return new ActiveXObject("Microsoft.XMLHTTP")})||false},activeRequestCount:0};
Ajax.Responders={responders:[],_each:function(b,a){this.responders._each(b,a)},register:function(a){if(!this.include(a)){this.responders.push(a)
}},unregister:function(a){this.responders=this.responders.without(a)},dispatch:function(d,b,c,a){this.each(function(f){if(Object.isFunction(f[d])){try{f[d].apply(f,[b,c,a])
}catch(g){}}})}};Object.extend(Ajax.Responders,Enumerable);Ajax.Responders.register({onCreate:function(){Ajax.activeRequestCount++},onComplete:function(){Ajax.activeRequestCount--
}});Ajax.Base=Class.create({initialize:function(a){this.options={method:"post",asynchronous:true,contentType:"application/x-www-form-urlencoded",encoding:"UTF-8",parameters:"",evalJSON:true,evalJS:true};
Object.extend(this.options,a||{});this.options.method=this.options.method.toLowerCase();if(Object.isHash(this.options.parameters)){this.options.parameters=this.options.parameters.toObject()
}}});Ajax.Request=Class.create(Ajax.Base,{_complete:false,initialize:function($super,b,a){$super(a);this.transport=Ajax.getTransport();
this.request(b)},request:function(b){this.url=b;this.method=this.options.method;var d=Object.isString(this.options.parameters)?this.options.parameters:Object.toQueryString(this.options.parameters);
if(!["get","post"].include(this.method)){d+=(d?"&":"")+"_method="+this.method;this.method="post"}if(d&&this.method==="get"){this.url+=(this.url.include("?")?"&":"?")+d
}this.parameters=d.toQueryParams();try{var a=new Ajax.Response(this);if(this.options.onCreate){this.options.onCreate(a)}Ajax.Responders.dispatch("onCreate",this,a);
this.transport.open(this.method.toUpperCase(),this.url,this.options.asynchronous);if(this.options.asynchronous){this.respondToReadyState.bind(this).defer(1)
}this.transport.onreadystatechange=this.onStateChange.bind(this);this.setRequestHeaders();this.body=this.method=="post"?(this.options.postBody||d):null;
this.transport.send(this.body);if(!this.options.asynchronous&&this.transport.overrideMimeType){this.onStateChange()}}catch(c){this.dispatchException(c)
}},onStateChange:function(){var a=this.transport.readyState;if(a>1&&!((a==4)&&this._complete)){this.respondToReadyState(this.transport.readyState)
}},setRequestHeaders:function(){var e={"X-Requested-With":"XMLHttpRequest","X-Prototype-Version":Prototype.Version,Accept:"text/javascript, text/html, application/xml, text/xml, */*"};
if(this.method=="post"){e["Content-type"]=this.options.contentType+(this.options.encoding?"; charset="+this.options.encoding:"");if(this.transport.overrideMimeType&&(navigator.userAgent.match(/Gecko\/(\d{4})/)||[0,2005])[1]<2005){e.Connection="close"
}}if(typeof this.options.requestHeaders=="object"){var c=this.options.requestHeaders;if(Object.isFunction(c.push)){for(var b=0,d=c.length;
b<d;b+=2){e[c[b]]=c[b+1]}}else{$H(c).each(function(f){e[f.key]=f.value})}}for(var a in e){this.transport.setRequestHeader(a,e[a])}},success:function(){var a=this.getStatus();
return !a||(a>=200&&a<300)||a==304},getStatus:function(){try{if(this.transport.status===1223){return 204}return this.transport.status||0
}catch(a){return 0}},respondToReadyState:function(a){var c=Ajax.Request.Events[a],b=new Ajax.Response(this);if(c=="Complete"){try{this._complete=true;
(this.options["on"+b.status]||this.options["on"+(this.success()?"Success":"Failure")]||Prototype.emptyFunction)(b,b.headerJSON)}catch(d){this.dispatchException(d)
}var f=b.getHeader("Content-type");if(this.options.evalJS=="force"||(this.options.evalJS&&this.isSameOrigin()&&f&&f.match(/^\s*(text|application)\/(x-)?(java|ecma)script(;.*)?\s*$/i))){this.evalResponse()
}}try{(this.options["on"+c]||Prototype.emptyFunction)(b,b.headerJSON);Ajax.Responders.dispatch("on"+c,this,b,b.headerJSON)}catch(d){this.dispatchException(d)
}if(c=="Complete"){this.transport.onreadystatechange=Prototype.emptyFunction}},isSameOrigin:function(){var a=this.url.match(/^\s*https?:\/\/[^\/]*/);
return !a||(a[0]=="#{protocol}//#{domain}#{port}".interpolate({protocol:location.protocol,domain:document.domain,port:location.port?":"+location.port:""}))
},getHeader:function(a){try{return this.transport.getResponseHeader(a)||null}catch(b){return null}},evalResponse:function(){try{return eval((this.transport.responseText||"").unfilterJSON())
}catch(e){this.dispatchException(e)}},dispatchException:function(a){(this.options.onException||Prototype.emptyFunction)(this,a);Ajax.Responders.dispatch("onException",this,a)
}});Ajax.Request.Events=["Uninitialized","Loading","Loaded","Interactive","Complete"];Ajax.Response=Class.create({initialize:function(c){this.request=c;
var d=this.transport=c.transport,a=this.readyState=d.readyState;if((a>2&&!Prototype.Browser.IE)||a==4){this.status=this.getStatus();this.statusText=this.getStatusText();
this.responseText=String.interpret(d.responseText);this.headerJSON=this._getHeaderJSON()}if(a==4){var b=d.responseXML;this.responseXML=Object.isUndefined(b)?null:b;
this.responseJSON=this._getResponseJSON()}},status:0,statusText:"",getStatus:Ajax.Request.prototype.getStatus,getStatusText:function(){try{return this.transport.statusText||""
}catch(a){return""}},getHeader:Ajax.Request.prototype.getHeader,getAllHeaders:function(){try{return this.getAllResponseHeaders()}catch(a){return null
}},getResponseHeader:function(a){return this.transport.getResponseHeader(a)},getAllResponseHeaders:function(){return this.transport.getAllResponseHeaders()
},_getHeaderJSON:function(){var a=this.getHeader("X-JSON");if(!a){return null}try{a=decodeURIComponent(escape(a))}catch(b){}try{return a.evalJSON(this.request.options.sanitizeJSON||!this.request.isSameOrigin())
}catch(b){this.request.dispatchException(b)}},_getResponseJSON:function(){var a=this.request.options;if(!a.evalJSON||(a.evalJSON!="force"&&!(this.getHeader("Content-type")||"").include("application/json"))||this.responseText.blank()){return null
}try{return this.responseText.evalJSON(a.sanitizeJSON||!this.request.isSameOrigin())}catch(b){this.request.dispatchException(b)}}});Ajax.Updater=Class.create(Ajax.Request,{initialize:function($super,a,c,b){this.container={success:(a.success||a),failure:(a.failure||(a.success?null:a))};
b=Object.clone(b);var d=b.onComplete;b.onComplete=(function(e,f){this.updateContent(e.responseText);if(Object.isFunction(d)){d(e,f)}}).bind(this);
$super(c,b)},updateContent:function(d){var c=this.container[this.success()?"success":"failure"],a=this.options;if(!a.evalScripts){d=d.stripScripts()
}if(c=$(c)){if(a.insertion){if(Object.isString(a.insertion)){var b={};b[a.insertion]=d;c.insert(b)}else{a.insertion(c,d)}}else{c.update(d)
}}}});Ajax.PeriodicalUpdater=Class.create(Ajax.Base,{initialize:function($super,a,c,b){$super(b);this.onComplete=this.options.onComplete;
this.frequency=(this.options.frequency||2);this.decay=(this.options.decay||1);this.updater={};this.container=a;this.url=c;this.start()
},start:function(){this.options.onComplete=this.updateComplete.bind(this);this.onTimerEvent()},stop:function(){this.updater.options.onComplete=undefined;
clearTimeout(this.timer);(this.onComplete||Prototype.emptyFunction).apply(this,arguments)},updateComplete:function(a){if(this.options.decay){this.decay=(a.responseText==this.lastText?this.decay*this.options.decay:1);
this.lastText=a.responseText}this.timer=this.onTimerEvent.bind(this).delay(this.decay*this.frequency)},onTimerEvent:function(){this.updater=new Ajax.Updater(this.container,this.url,this.options)
}});(function(a6){var aC;var aZ=Array.prototype.slice;var at=document.createElement("div");function aX(bm){if(arguments.length>1){for(var F=0,bo=[],bn=arguments.length;
F<bn;F++){bo.push(aX(arguments[F]))}return bo}if(Object.isString(bm)){bm=document.getElementById(bm)}return aD.extend(bm)}a6.$=aX;if(!a6.Node){a6.Node={}
}if(!a6.Node.ELEMENT_NODE){Object.extend(a6.Node,{ELEMENT_NODE:1,ATTRIBUTE_NODE:2,TEXT_NODE:3,CDATA_SECTION_NODE:4,ENTITY_REFERENCE_NODE:5,ENTITY_NODE:6,PROCESSING_INSTRUCTION_NODE:7,COMMENT_NODE:8,DOCUMENT_NODE:9,DOCUMENT_TYPE_NODE:10,DOCUMENT_FRAGMENT_NODE:11,NOTATION_NODE:12})
}var p={};function aO(bm,F){if(bm==="select"){return false}if("type" in F){return false}return true}var c=(function(){try{var F=document.createElement('<input name="x">');
return F.tagName.toLowerCase()==="input"&&F.name==="x"}catch(bm){return false}})();var aG=a6.Element;function aD(bm,F){F=F||{};bm=bm.toLowerCase();
if(c&&F.name){bm="<"+bm+' name="'+F.name+'">';delete F.name;return aD.writeAttribute(document.createElement(bm),F)}if(!p[bm]){p[bm]=aD.extend(document.createElement(bm))
}var bn=aO(bm,F)?p[bm].cloneNode(false):document.createElement(bm);return aD.writeAttribute(bn,F)}a6.Element=aD;Object.extend(a6.Element,aG||{});
if(aG){a6.Element.prototype=aG.prototype}aD.Methods={ByTag:{},Simulated:{}};var a1={};var E={id:"id",className:"class"};function a8(bm){bm=aX(bm);
var F="<"+bm.tagName.toLowerCase();var bn,bp;for(var bo in E){bn=E[bo];bp=(bm[bo]||"").toString();if(bp){F+=" "+bn+"="+bp.inspect(true)
}}return F+">"}a1.inspect=a8;function t(F){return aX(F).style.display!=="none"}function av(bm,F){bm=aX(bm);if(Object.isUndefined(F)){F=!aD.visible(bm)
}aD[F?"show":"hide"](bm);return bm}function aF(F){F=aX(F);F.style.display="none";return F}function h(F){F=aX(F);F.style.display="";return F
}Object.extend(a1,{visible:t,toggle:av,hide:aF,show:h});function ab(F){F=aX(F);F.parentNode.removeChild(F);return F}var aR=(function(){var F=document.createElement("select"),bm=true;
F.innerHTML='<option value="test">test</option>';if(F.options&&F.options[0]){bm=F.options[0].nodeName.toUpperCase()!=="OPTION"}F=null;
return bm})();var G=(function(){try{var F=document.createElement("table");if(F&&F.tBodies){F.innerHTML="<tbody><tr><td>test</td></tr></tbody>";
var bn=typeof F.tBodies[0]=="undefined";F=null;return bn}}catch(bm){return true}})();var a0=(function(){try{var F=document.createElement("div");
F.innerHTML="<link />";var bn=(F.childNodes.length===0);F=null;return bn}catch(bm){return true}})();var v=aR||G||a0;var ao=(function(){var F=document.createElement("script"),bn=false;
try{F.appendChild(document.createTextNode(""));bn=!F.firstChild||F.firstChild&&F.firstChild.nodeType!==3}catch(bm){bn=true}F=null;return bn
})();function M(bo,bq){bo=aX(bo);var br=bo.getElementsByTagName("*"),bn=br.length;while(bn--){X(br[bn])}if(bq&&bq.toElement){bq=bq.toElement()
}if(Object.isElement(bq)){return bo.update().insert(bq)}bq=Object.toHTML(bq);var bm=bo.tagName.toUpperCase();if(bm==="SCRIPT"&&ao){bo.text=bq;
return bo}if(v){if(bm in J.tags){while(bo.firstChild){bo.removeChild(bo.firstChild)}var F=r(bm,bq.stripScripts());for(var bn=0,bp;bp=F[bn];
bn++){bo.appendChild(bp)}}else{if(a0&&Object.isString(bq)&&bq.indexOf("<link")>-1){while(bo.firstChild){bo.removeChild(bo.firstChild)
}var F=r(bm,bq.stripScripts(),true);for(var bn=0,bp;bp=F[bn];bn++){bo.appendChild(bp)}}else{bo.innerHTML=bq.stripScripts()}}}else{bo.innerHTML=bq.stripScripts()
}bq.evalScripts.bind(bq).defer();return bo}function af(bm,bn){bm=aX(bm);if(bn&&bn.toElement){bn=bn.toElement()}else{if(!Object.isElement(bn)){bn=Object.toHTML(bn);
var F=bm.ownerDocument.createRange();F.selectNode(bm);bn.evalScripts.bind(bn).defer();bn=F.createContextualFragment(bn.stripScripts())
}}bm.parentNode.replaceChild(bn,bm);return bm}var J={before:function(F,bm){F.parentNode.insertBefore(bm,F)},top:function(F,bm){F.insertBefore(bm,F.firstChild)
},bottom:function(F,bm){F.appendChild(bm)},after:function(F,bm){F.parentNode.insertBefore(bm,F.nextSibling)},tags:{TABLE:["<table>","</table>",1],TBODY:["<table><tbody>","</tbody></table>",2],TR:["<table><tbody><tr>","</tr></tbody></table>",3],TD:["<table><tbody><tr><td>","</td></tr></tbody></table>",4],SELECT:["<select>","</select>",1]}};
var aH=J.tags;Object.extend(aH,{THEAD:aH.TBODY,TFOOT:aH.TBODY,TH:aH.TD});function am(bn,bq){bn=aX(bn);if(bq&&bq.toElement){bq=bq.toElement()
}if(Object.isElement(bq)){bn.parentNode.replaceChild(bq,bn);return bn}bq=Object.toHTML(bq);var bp=bn.parentNode,bm=bp.tagName.toUpperCase();
if(bm in J.tags){var br=aD.next(bn);var F=r(bm,bq.stripScripts());bp.removeChild(bn);var bo;if(br){bo=function(bs){bp.insertBefore(bs,br)
}}else{bo=function(bs){bp.appendChild(bs)}}F.each(bo)}else{bn.outerHTML=bq.stripScripts()}bq.evalScripts.bind(bq).defer();return bn}if("outerHTML" in document.documentElement){af=am
}function a5(F){if(Object.isUndefined(F)||F===null){return false}if(Object.isString(F)||Object.isNumber(F)){return true}if(Object.isElement(F)){return true
}if(F.toElement||F.toHTML){return true}return false}function bk(bo,bq,F){F=F.toLowerCase();var bs=J[F];if(bq&&bq.toElement){bq=bq.toElement()
}if(Object.isElement(bq)){bs(bo,bq);return bo}bq=Object.toHTML(bq);var bn=((F==="before"||F==="after")?bo.parentNode:bo).tagName.toUpperCase();
var br=r(bn,bq.stripScripts());if(F==="top"||F==="after"){br.reverse()}for(var bm=0,bp;bp=br[bm];bm++){bs(bo,bp)}bq.evalScripts.bind(bq).defer()
}function O(bm,bn){bm=aX(bm);if(a5(bn)){bn={bottom:bn}}for(var F in bn){bk(bm,bn[F],F)}return bm}function s(bm,bn,F){bm=aX(bm);if(Object.isElement(bn)){aX(bn).writeAttribute(F||{})
}else{if(Object.isString(bn)){bn=new aD(bn,F)}else{bn=new aD("div",bn)}}if(bm.parentNode){bm.parentNode.replaceChild(bn,bm)}bn.appendChild(bm);
return bn}function u(bm){bm=aX(bm);var bn=bm.firstChild;while(bn){var F=bn.nextSibling;if(bn.nodeType===Node.TEXT_NODE&&!/\S/.test(bn.nodeValue)){bm.removeChild(bn)
}bn=F}return bm}function a2(F){return aX(F).innerHTML.blank()}function r(bp,bo,bq){var bn=J.tags[bp],br=at;var F=!!bn;if(!F&&bq){F=true;
bn=["","",0]}if(F){br.innerHTML="&#160;"+bn[0]+bo+bn[1];br.removeChild(br.firstChild);for(var bm=bn[2];bm--;){br=br.firstChild}}else{br.innerHTML=bo
}return $A(br.childNodes)}function C(bn,F){if(!(bn=aX(bn))){return}var bp=bn.cloneNode(F);if(!aW){bp._prototypeUID=aC;if(F){var bo=aD.select(bp,"*"),bm=bo.length;
while(bm--){bo[bm]._prototypeUID=aC}}}return aD.extend(bp)}function X(bm){var F=K(bm);if(F){aD.stopObserving(bm);if(!aW){bm._prototypeUID=aC
}delete aD.Storage[F]}}function bi(bm){var F=bm.length;while(F--){X(bm[F])}}function aq(bo){var bn=bo.length,bm,F;while(bn--){bm=bo[bn];
F=K(bm);delete aD.Storage[F];delete Event.cache[F]}}if(aW){bi=aq}function l(bm){if(!(bm=aX(bm))){return}X(bm);var bn=bm.getElementsByTagName("*"),F=bn.length;
while(F--){X(bn[F])}return null}Object.extend(a1,{remove:ab,update:M,replace:af,insert:O,wrap:s,cleanWhitespace:u,empty:a2,clone:C,purge:l});
function ak(F,bn,bo){F=aX(F);bo=bo||-1;var bm=[];while(F=F[bn]){if(F.nodeType===Node.ELEMENT_NODE){bm.push(aD.extend(F))}if(bm.length===bo){break
}}return bm}function aJ(F){return ak(F,"parentNode")}function bj(F){return aD.select(F,"*")}function V(F){F=aX(F).firstChild;while(F&&F.nodeType!==Node.ELEMENT_NODE){F=F.nextSibling
}return aX(F)}function bf(bm){var F=[],bn=aX(bm).firstChild;while(bn){if(bn.nodeType===Node.ELEMENT_NODE){F.push(aD.extend(bn))}bn=bn.nextSibling
}return F}function n(F){return ak(F,"previousSibling")}function be(F){return ak(F,"nextSibling")}function aT(F){F=aX(F);var bn=n(F),bm=be(F);
return bn.reverse().concat(bm)}function aP(bm,F){bm=aX(bm);if(Object.isString(F)){return Prototype.Selector.match(bm,F)}return F.match(bm)
}function aU(bm,bn,bo,F){bm=aX(bm),bo=bo||0,F=F||0;if(Object.isNumber(bo)){F=bo,bo=null}while(bm=bm[bn]){if(bm.nodeType!==1){continue
}if(bo&&!Prototype.Selector.match(bm,bo)){continue}if(--F>=0){continue}return aD.extend(bm)}}function Y(bm,bn,F){bm=aX(bm);if(arguments.length===1){return aX(bm.parentNode)
}return aU(bm,"parentNode",bn,F)}function w(bm,bo,F){bm=aX(bm),bo=bo||0,F=F||0;if(Object.isNumber(bo)){F=bo,bo="*"}var bn=Prototype.Selector.select(bo,bm)[F];
return aD.extend(bn)}function g(bm,bn,F){return aU(bm,"previousSibling",bn,F)}function az(bm,bn,F){return aU(bm,"nextSibling",bn,F)}function a9(F){F=aX(F);
var bm=aZ.call(arguments,1).join(", ");return Prototype.Selector.select(bm,F)}function aB(bn){bn=aX(bn);var bp=aZ.call(arguments,1).join(", ");
var bq=aD.siblings(bn),bm=[];for(var F=0,bo;bo=bq[F];F++){if(Prototype.Selector.match(bo,bp)){bm.push(bo)}}return bm}function B(bm,F){bm=aX(bm),F=aX(F);
while(bm=bm.parentNode){if(bm===F){return true}}return false}function z(bm,F){bm=aX(bm),F=aX(F);if(!F.contains){return B(bm,F)}return F.contains(bm)&&F!==bm
}function H(bm,F){bm=aX(bm),F=aX(F);return(bm.compareDocumentPosition(F)&8)===8}var aK;if(at.compareDocumentPosition){aK=H}else{if(at.contains){aK=z
}else{aK=B}}Object.extend(a1,{recursivelyCollect:ak,ancestors:aJ,descendants:bj,firstDescendant:V,immediateDescendants:bf,previousSiblings:n,nextSiblings:be,siblings:aT,match:aP,up:Y,down:w,previous:g,next:az,select:a9,adjacent:aB,descendantOf:aK,getElementsBySelector:a9,childElements:bf});
var R=1;function aS(F){F=aX(F);var bm=aD.readAttribute(F,"id");if(bm){return bm}do{bm="anonymous_element_"+R++}while(aX(bm));aD.writeAttribute(F,"id",bm);
return bm}function a7(bm,F){return aX(bm).getAttribute(F)}function I(bm,F){bm=aX(bm);var bn=aE.read;if(bn.values[F]){return bn.values[F](bm,F)
}if(bn.names[F]){F=bn.names[F]}if(F.include(":")){if(!bm.attributes||!bm.attributes[F]){return null}return bm.attributes[F].value}return bm.getAttribute(F)
}function d(bm,F){if(F==="title"){return bm.title}return bm.getAttribute(F)}var S=(function(){at.setAttribute("onclick",Prototype.emptyFunction);
var F=at.getAttribute("onclick");var bm=(typeof F==="function");at.removeAttribute("onclick");return bm})();if(S){a7=I}else{if(Prototype.Browser.Opera){a7=d
}}function aY(bo,bn,bq){bo=aX(bo);var bm={},bp=aE.write;if(typeof bn==="object"){bm=bn}else{bm[bn]=Object.isUndefined(bq)?true:bq}for(var F in bm){bn=bp.names[F]||F;
bq=bm[F];if(bp.values[F]){bn=bp.values[F](bo,bq)}if(bq===false||bq===null){bo.removeAttribute(bn)}else{if(bq===true){bo.setAttribute(bn,bn)
}else{bo.setAttribute(bn,bq)}}}return bo}function W(F,bn){bn=aE.has[bn]||bn;var bm=aX(F).getAttributeNode(bn);return !!(bm&&bm.specified)
}a6.Element.Methods.Simulated.hasAttribute=W;function j(F){return new aD.ClassNames(F)}var T={};function e(bm){if(T[bm]){return T[bm]
}var F=new RegExp("(^|\\s+)"+bm+"(\\s+|$)");T[bm]=F;return F}function aj(F,bm){if(!(F=aX(F))){return}var bn=F.className;if(bn.length===0){return false
}if(bn===bm){return true}return e(bm).test(bn)}function m(F,bm){if(!(F=aX(F))){return}if(!aj(F,bm)){F.className+=(F.className?" ":"")+bm
}return F}function ar(F,bm){if(!(F=aX(F))){return}F.className=F.className.replace(e(bm)," ").strip();return F}function ac(bm,bn,F){if(!(bm=aX(bm))){return
}if(Object.isUndefined(F)){F=!aj(bm,bn)}var bo=aD[F?"addClassName":"removeClassName"];return bo(bm,bn)}var aE={};var aN="className",ap="for";
at.setAttribute(aN,"x");if(at.className!=="x"){at.setAttribute("class","x");if(at.className==="x"){aN="class"}}var aI=document.createElement("label");
aI.setAttribute(ap,"x");if(aI.htmlFor!=="x"){aI.setAttribute("htmlFor","x");if(aI.htmlFor==="x"){ap="htmlFor"}}aI=null;function aa(F,bm){return F.getAttribute(bm)
}function f(F,bm){return F.getAttribute(bm,2)}function y(F,bn){var bm=F.getAttributeNode(bn);return bm?bm.value:""}function bg(F,bm){return aX(F).hasAttribute(bm)?bm:null
}at.onclick=Prototype.emptyFunction;var N=at.getAttribute("onclick");var au;if(String(N).indexOf("{")>-1){au=function(F,bm){var bn=F.getAttribute(bm);
if(!bn){return null}bn=bn.toString();bn=bn.split("{")[1];bn=bn.split("}")[0];return bn.strip()}}else{if(N===""){au=function(F,bm){var bn=F.getAttribute(bm);
if(!bn){return null}return bn.strip()}}}aE.read={names:{"class":aN,className:aN,"for":ap,htmlFor:ap},values:{style:function(F){return F.style.cssText.toLowerCase()
},title:function(F){return F.title}}};aE.write={names:{className:"class",htmlFor:"for",cellpadding:"cellPadding",cellspacing:"cellSpacing"},values:{checked:function(F,bm){F.checked=!!bm
},style:function(F,bm){F.style.cssText=bm?bm:""}}};aE.has={names:{}};Object.extend(aE.write.names,aE.read.names);var a4=$w("colSpan rowSpan vAlign dateTime accessKey tabIndex encType maxLength readOnly longDesc frameBorder");
for(var ad=0,ae;ae=a4[ad];ad++){aE.write.names[ae.toLowerCase()]=ae;aE.has.names[ae.toLowerCase()]=ae}Object.extend(aE.read.values,{href:f,src:f,type:aa,action:y,disabled:bg,checked:bg,readonly:bg,multiple:bg,onload:au,onunload:au,onclick:au,ondblclick:au,onmousedown:au,onmouseup:au,onmouseover:au,onmousemove:au,onmouseout:au,onfocus:au,onblur:au,onkeypress:au,onkeydown:au,onkeyup:au,onsubmit:au,onreset:au,onselect:au,onchange:au});
Object.extend(a1,{identify:aS,readAttribute:a7,writeAttribute:aY,classNames:j,hasClassName:aj,addClassName:m,removeClassName:ar,toggleClassName:ac});
function U(F){if(F==="float"||F==="styleFloat"){return"cssFloat"}return F.camelize()}function bl(F){if(F==="float"||F==="cssFloat"){return"styleFloat"
}return F.camelize()}function A(bn,bo){bn=aX(bn);var br=bn.style,bm;if(Object.isString(bo)){br.cssText+=";"+bo;if(bo.include("opacity")){var F=bo.match(/opacity:\s*(\d?\.?\d*)/)[1];
aD.setOpacity(bn,F)}return bn}for(var bq in bo){if(bq==="opacity"){aD.setOpacity(bn,bo[bq])}else{var bp=bo[bq];if(bq==="float"||bq==="cssFloat"){bq=Object.isUndefined(br.styleFloat)?"cssFloat":"styleFloat"
}br[bq]=bp}}return bn}function aM(bm,bn){bm=aX(bm);bn=U(bn);var bo=bm.style[bn];if(!bo||bo==="auto"){var F=document.defaultView.getComputedStyle(bm,null);
bo=F?F[bn]:null}if(bn==="opacity"){return bo?parseFloat(bo):1}return bo==="auto"?null:bo}function q(F,bm){switch(bm){case"height":case"width":if(!aD.visible(F)){return null
}var bn=parseInt(aM(F,bm),10);if(bn!==F["offset"+bm.capitalize()]){return bn+"px"}return aD.measure(F,bm);default:return aM(F,bm)}}function ah(F,bm){F=aX(F);
bm=bl(bm);var bn=F.style[bm];if(!bn&&F.currentStyle){bn=F.currentStyle[bm]}if(bm==="opacity"&&!L){return bc(F)}if(bn==="auto"){if((bm==="width"||bm==="height")&&aD.visible(F)){return aD.measure(F,bm)+"px"
}return null}return bn}function ay(F){return(F||"").replace(/alpha\([^\)]*\)/gi,"")}function Z(F){if(!F.currentStyle.hasLayout){F.style.zoom=1
}return F}var L=(function(){at.style.cssText="opacity:.55";return/^0.55/.test(at.style.opacity)})();function x(F,bm){F=aX(F);if(bm==1||bm===""){bm=""
}else{if(bm<0.00001){bm=0}}F.style.opacity=bm;return F}function bd(F,bo){if(L){return x(F,bo)}F=Z(aX(F));var bn=aD.getStyle(F,"filter"),bm=F.style;
if(bo==1||bo===""){bn=ay(bn);if(bn){bm.filter=bn}else{bm.removeAttribute("filter")}return F}if(bo<0.00001){bo=0}bm.filter=ay(bn)+"alpha(opacity="+(bo*100)+")";
return F}function bb(F){return aD.getStyle(F,"opacity")}function bc(bm){if(L){return bb(bm)}var bn=aD.getStyle(bm,"filter");if(bn.length===0){return 1
}var F=(bn||"").match(/alpha\(opacity=(.*)\)/);if(F[1]){return parseFloat(F[1])/100}return 1}Object.extend(a1,{setStyle:A,getStyle:aM,setOpacity:x,getOpacity:bb});
if("styleFloat" in at.style){a1.getStyle=ah;a1.setOpacity=bd;a1.getOpacity=bc}var k=0;a6.Element.Storage={UID:1};function K(F){if(F===window){return 0
}if(typeof F._prototypeUID==="undefined"){F._prototypeUID=aD.Storage.UID++}return F._prototypeUID}function b(F){if(F===window){return 0
}if(F==document){return 1}return F.uniqueID}var aW=("uniqueID" in at);if(aW){K=b}function a(bm){if(!(bm=aX(bm))){return}var F=K(bm);if(!aD.Storage[F]){aD.Storage[F]=$H()
}return aD.Storage[F]}function a3(bm,F,bn){if(!(bm=aX(bm))){return}var bo=a(bm);if(arguments.length===2){bo.update(F)}else{bo.set(F,bn)
}return bm}function aL(bn,bm,F){if(!(bn=aX(bn))){return}var bp=a(bn),bo=bp.get(bm);if(Object.isUndefined(bo)){bp.set(bm,F);bo=F}return bo
}Object.extend(a1,{getStorage:a,store:a3,retrieve:aL});var al={},aV=aD.Methods.ByTag,aA=Prototype.BrowserFeatures;if(!aA.ElementExtensions&&("__proto__" in at)){a6.HTMLElement={};
a6.HTMLElement.prototype=at.__proto__;aA.ElementExtensions=true}function ba(F){if(typeof window.Element==="undefined"){return false}var bn=window.Element.prototype;
if(bn){var bp="_"+(Math.random()+"").slice(2),bm=document.createElement(F);bn[bp]="x";var bo=(bm[bp]!=="x");delete bn[bp];bm=null;return bo
}return false}var an=ba("object");function ai(bm,F){for(var bo in F){var bn=F[bo];if(Object.isFunction(bn)&&!(bo in bm)){bm[bo]=bn.methodize()
}}}var bh={};function aw(bm){var F=K(bm);return(F in bh)}function ax(bn){if(!bn||aw(bn)){return bn}if(bn.nodeType!==Node.ELEMENT_NODE||bn==window){return bn
}var F=Object.clone(al),bm=bn.tagName.toUpperCase();if(aV[bm]){Object.extend(F,aV[bm])}ai(bn,F);bh[K(bn)]=true;return bn}function aQ(bm){if(!bm||aw(bm)){return bm
}var F=bm.tagName;if(F&&(/^(?:object|applet|embed)$/i.test(F))){ai(bm,aD.Methods);ai(bm,aD.Methods.Simulated);ai(bm,aD.Methods.ByTag[F.toUpperCase()])
}return bm}if(aA.SpecificElementExtensions){ax=an?aQ:Prototype.K}function Q(bm,F){bm=bm.toUpperCase();if(!aV[bm]){aV[bm]={}}Object.extend(aV[bm],F)
}function o(bm,bn,F){if(Object.isUndefined(F)){F=false}for(var bp in bn){var bo=bn[bp];if(!Object.isFunction(bo)){continue}if(!F||!(bp in bm)){bm[bp]=bo.methodize()
}}}function ag(bo){var F;var bn={OPTGROUP:"OptGroup",TEXTAREA:"TextArea",P:"Paragraph",FIELDSET:"FieldSet",UL:"UList",OL:"OList",DL:"DList",DIR:"Directory",H1:"Heading",H2:"Heading",H3:"Heading",H4:"Heading",H5:"Heading",H6:"Heading",Q:"Quote",INS:"Mod",DEL:"Mod",A:"Anchor",IMG:"Image",CAPTION:"TableCaption",COL:"TableCol",COLGROUP:"TableCol",THEAD:"TableSection",TFOOT:"TableSection",TBODY:"TableSection",TR:"TableRow",TH:"TableCell",TD:"TableCell",FRAMESET:"FrameSet",IFRAME:"IFrame"};
if(bn[bo]){F="HTML"+bn[bo]+"Element"}if(window[F]){return window[F]}F="HTML"+bo+"Element";if(window[F]){return window[F]}F="HTML"+bo.capitalize()+"Element";
if(window[F]){return window[F]}var bm=document.createElement(bo),bp=bm.__proto__||bm.constructor.prototype;bm=null;return bp}function P(bo){if(arguments.length===0){D()
}if(arguments.length===2){var bq=bo;bo=arguments[1]}if(!bq){Object.extend(aD.Methods,bo||{})}else{if(Object.isArray(bq)){for(var bp=0,bn;
bn=bq[bp];bp++){Q(bn,bo)}}else{Q(bq,bo)}}var bm=window.HTMLElement?HTMLElement.prototype:aD.prototype;if(aA.ElementExtensions){o(bm,aD.Methods);
o(bm,aD.Methods.Simulated,true)}if(aA.SpecificElementExtensions){for(var bn in aD.Methods.ByTag){var F=ag(bn);if(Object.isUndefined(F)){continue
}o(F.prototype,aV[bn])}}Object.extend(aD,aD.Methods);Object.extend(aD,aD.Methods.Simulated);delete aD.ByTag;delete aD.Simulated;aD.extend.refresh();
p={}}Object.extend(a6.Element,{extend:ax,addMethods:P});if(ax===Prototype.K){a6.Element.extend.refresh=Prototype.emptyFunction}else{a6.Element.extend.refresh=function(){if(Prototype.BrowserFeatures.ElementExtensions){return
}Object.extend(al,aD.Methods);Object.extend(al,aD.Methods.Simulated);bh={}}}function D(){Object.extend(Form,Form.Methods);Object.extend(Form.Element,Form.Element.Methods);
Object.extend(aD.Methods.ByTag,{FORM:Object.clone(Form.Methods),INPUT:Object.clone(Form.Element.Methods),SELECT:Object.clone(Form.Element.Methods),TEXTAREA:Object.clone(Form.Element.Methods),BUTTON:Object.clone(Form.Element.Methods)})
}aD.addMethods(a1)})(this);(function(){function l(H){var G=H.match(/^(\d+)%?$/i);if(!G){return null}return(Number(G[1])/100)}function z(H,I){H=$(H);
var J=H.style[I];if(!J||J==="auto"){var G=document.defaultView.getComputedStyle(H,null);J=G?G[I]:null}if(I==="opacity"){return J?parseFloat(J):1
}return J==="auto"?null:J}function C(G,H){var I=G.style[H];if(!I&&G.currentStyle){I=G.currentStyle[H]}return I}function s(I,H){var K=I.offsetWidth;
var M=v(I,"borderLeftWidth",H)||0;var G=v(I,"borderRightWidth",H)||0;var J=v(I,"paddingLeft",H)||0;var L=v(I,"paddingRight",H)||0;return K-M-G-J-L
}if("currentStyle" in document.documentElement){z=C}function v(Q,R,H){var K=null;if(Object.isElement(Q)){K=Q;Q=z(K,R)}if(Q===null||Object.isUndefined(Q)){return null
}if((/^(?:-)?\d+(\.\d+)?(px)?$/i).test(Q)){return window.parseFloat(Q)}var L=Q.include("%"),I=(H===document.viewport);if(/\d/.test(Q)&&K&&K.runtimeStyle&&!(L&&I)){var G=K.style.left,P=K.runtimeStyle.left;
K.runtimeStyle.left=K.currentStyle.left;K.style.left=Q||0;Q=K.style.pixelLeft;K.style.left=G;K.runtimeStyle.left=P;return Q}if(K&&L){H=H||K.parentNode;
var J=l(Q),M=null;var O=R.include("left")||R.include("right")||R.include("width");var N=R.include("top")||R.include("bottom")||R.include("height");
if(H===document.viewport){if(O){M=document.viewport.getWidth()}else{if(N){M=document.viewport.getHeight()}}}else{if(O){M=$(H).measure("width")
}else{if(N){M=$(H).measure("height")}}}return(M===null)?0:M*J}return 0}function k(G){if(Object.isString(G)&&G.endsWith("px")){return G
}return G+"px"}function n(G){while(G&&G.parentNode){var H=G.getStyle("display");if(H==="none"){return false}G=$(G.parentNode)}return true
}var g=Prototype.K;if("currentStyle" in document.documentElement){g=function(G){if(!G.currentStyle.hasLayout){G.style.zoom=1}return G
}}function j(G){if(G.include("border")){G=G+"-width"}return G.camelize()}Element.Layout=Class.create(Hash,{initialize:function($super,H,G){$super();
this.element=$(H);Element.Layout.PROPERTIES.each(function(I){this._set(I,null)},this);if(G){this._preComputing=true;this._begin();Element.Layout.PROPERTIES.each(this._compute,this);
this._end();this._preComputing=false}},_set:function(H,G){return Hash.prototype.set.call(this,H,G)},set:function(H,G){throw"Properties of Element.Layout are read-only."
},get:function($super,H){var G=$super(H);return G===null?this._compute(H):G},_begin:function(){if(this._isPrepared()){return}var K=this.element;
if(n(K)){this._setPrepared(true);return}var M={position:K.style.position||"",width:K.style.width||"",visibility:K.style.visibility||"",display:K.style.display||""};
K.store("prototype_original_styles",M);var N=z(K,"position"),G=K.offsetWidth;if(G===0||G===null){K.style.display="block";G=K.offsetWidth
}var H=(N==="fixed")?document.viewport:K.parentNode;var O={visibility:"hidden",display:"block"};if(N!=="fixed"){O.position="absolute"
}K.setStyle(O);var I=K.offsetWidth,J;if(G&&(I===G)){J=s(K,H)}else{if(N==="absolute"||N==="fixed"){J=s(K,H)}else{var P=K.parentNode,L=$(P).getLayout();
J=L.get("width")-this.get("margin-left")-this.get("border-left")-this.get("padding-left")-this.get("padding-right")-this.get("border-right")-this.get("margin-right")
}}K.setStyle({width:J+"px"});this._setPrepared(true)},_end:function(){var H=this.element;var G=H.retrieve("prototype_original_styles");
H.store("prototype_original_styles",null);H.setStyle(G);this._setPrepared(false)},_compute:function(H){var G=Element.Layout.COMPUTATIONS;
if(!(H in G)){throw"Property not found."}return this._set(H,G[H].call(this,this.element))},_isPrepared:function(){return this.element.retrieve("prototype_element_layout_prepared",false)
},_setPrepared:function(G){return this.element.store("prototype_element_layout_prepared",G)},toObject:function(){var G=$A(arguments);
var H=(G.length===0)?Element.Layout.PROPERTIES:G.join(" ").split(" ");var I={};H.each(function(J){if(!Element.Layout.PROPERTIES.include(J)){return
}var K=this.get(J);if(K!=null){I[J]=K}},this);return I},toHash:function(){var G=this.toObject.apply(this,arguments);return new Hash(G)
},toCSS:function(){var G=$A(arguments);var I=(G.length===0)?Element.Layout.PROPERTIES:G.join(" ").split(" ");var H={};I.each(function(J){if(!Element.Layout.PROPERTIES.include(J)){return
}if(Element.Layout.COMPOSITE_PROPERTIES.include(J)){return}var K=this.get(J);if(K!=null){H[j(J)]=K+"px"}},this);return H},inspect:function(){return"#<Element.Layout>"
}});Object.extend(Element.Layout,{PROPERTIES:$w("height width top left right bottom border-left border-right border-top border-bottom padding-left padding-right padding-top padding-bottom margin-top margin-bottom margin-left margin-right padding-box-width padding-box-height border-box-width border-box-height margin-box-width margin-box-height"),COMPOSITE_PROPERTIES:$w("padding-box-width padding-box-height margin-box-width margin-box-height border-box-width border-box-height"),COMPUTATIONS:{height:function(I){if(!this._preComputing){this._begin()
}var G=this.get("border-box-height");if(G<=0){if(!this._preComputing){this._end()}return 0}var J=this.get("border-top"),H=this.get("border-bottom");
var L=this.get("padding-top"),K=this.get("padding-bottom");if(!this._preComputing){this._end()}return G-J-H-L-K},width:function(I){if(!this._preComputing){this._begin()
}var H=this.get("border-box-width");if(H<=0){if(!this._preComputing){this._end()}return 0}var L=this.get("border-left"),G=this.get("border-right");
var J=this.get("padding-left"),K=this.get("padding-right");if(!this._preComputing){this._end()}return H-L-G-J-K},"padding-box-height":function(H){var G=this.get("height"),J=this.get("padding-top"),I=this.get("padding-bottom");
return G+J+I},"padding-box-width":function(G){var H=this.get("width"),I=this.get("padding-left"),J=this.get("padding-right");return H+I+J
},"border-box-height":function(H){if(!this._preComputing){this._begin()}var G=H.offsetHeight;if(!this._preComputing){this._end()}return G
},"border-box-width":function(G){if(!this._preComputing){this._begin()}var H=G.offsetWidth;if(!this._preComputing){this._end()}return H
},"margin-box-height":function(H){var G=this.get("border-box-height"),I=this.get("margin-top"),J=this.get("margin-bottom");if(G<=0){return 0
}return G+I+J},"margin-box-width":function(I){var H=this.get("border-box-width"),J=this.get("margin-left"),G=this.get("margin-right");
if(H<=0){return 0}return H+J+G},top:function(G){var H=G.positionedOffset();return H.top},bottom:function(G){var J=G.positionedOffset(),H=G.getOffsetParent(),I=H.measure("height");
var K=this.get("border-box-height");return I-K-J.top},left:function(G){var H=G.positionedOffset();return H.left},right:function(I){var K=I.positionedOffset(),J=I.getOffsetParent(),G=J.measure("width");
var H=this.get("border-box-width");return G-H-K.left},"padding-top":function(G){return v(G,"paddingTop")},"padding-bottom":function(G){return v(G,"paddingBottom")
},"padding-left":function(G){return v(G,"paddingLeft")},"padding-right":function(G){return v(G,"paddingRight")},"border-top":function(G){return v(G,"borderTopWidth")
},"border-bottom":function(G){return v(G,"borderBottomWidth")},"border-left":function(G){return v(G,"borderLeftWidth")},"border-right":function(G){return v(G,"borderRightWidth")
},"margin-top":function(G){return v(G,"marginTop")},"margin-bottom":function(G){return v(G,"marginBottom")},"margin-left":function(G){return v(G,"marginLeft")
},"margin-right":function(G){return v(G,"marginRight")}}});if("getBoundingClientRect" in document.documentElement){Object.extend(Element.Layout.COMPUTATIONS,{right:function(H){var I=g(H.getOffsetParent());
var J=H.getBoundingClientRect(),G=I.getBoundingClientRect();return(G.right-J.right).round()},bottom:function(H){var I=g(H.getOffsetParent());
var J=H.getBoundingClientRect(),G=I.getBoundingClientRect();return(G.bottom-J.bottom).round()}})}Element.Offset=Class.create({initialize:function(H,G){this.left=H.round();
this.top=G.round();this[0]=this.left;this[1]=this.top},relativeTo:function(G){return new Element.Offset(this.left-G.left,this.top-G.top)
},inspect:function(){return"#<Element.Offset left: #{left} top: #{top}>".interpolate(this)},toString:function(){return"[#{left}, #{top}]".interpolate(this)
},toArray:function(){return[this.left,this.top]}});function A(H,G){return new Element.Layout(H,G)}function d(G,H){return $(G).getLayout().get(H)
}function r(G){return Element.getDimensions(G).height}function c(G){return Element.getDimensions(G).width}function t(H){H=$(H);var L=Element.getStyle(H,"display");
if(L&&L!=="none"){return{width:H.offsetWidth,height:H.offsetHeight}}var I=H.style;var G={visibility:I.visibility,position:I.position,display:I.display};
var K={visibility:"hidden",display:"block"};if(G.position!=="fixed"){K.position="absolute"}Element.setStyle(H,K);var J={width:H.offsetWidth,height:H.offsetHeight};
Element.setStyle(H,G);return J}function q(G){G=$(G);if(h(G)||f(G)||p(G)||o(G)){return $(document.body)}var H=(Element.getStyle(G,"display")==="inline");
if(!H&&G.offsetParent){return $(G.offsetParent)}while((G=G.parentNode)&&G!==document.body){if(Element.getStyle(G,"position")!=="static"){return o(G)?$(document.body):$(G)
}}return $(document.body)}function D(H){H=$(H);var G=0,I=0;if(H.parentNode){do{G+=H.offsetTop||0;I+=H.offsetLeft||0;H=H.offsetParent}while(H)
}return new Element.Offset(I,G)}function x(H){H=$(H);var I=H.getLayout();var G=0,K=0;do{G+=H.offsetTop||0;K+=H.offsetLeft||0;H=H.offsetParent;
if(H){if(p(H)){break}var J=Element.getStyle(H,"position");if(J!=="static"){break}}}while(H);K-=I.get("margin-top");G-=I.get("margin-left");
return new Element.Offset(K,G)}function b(H){var G=0,I=0;do{G+=H.scrollTop||0;I+=H.scrollLeft||0;H=H.parentNode}while(H);return new Element.Offset(I,G)
}function B(K){var G=0,J=0,I=document.body;var H=$(K);do{G+=H.offsetTop||0;J+=H.offsetLeft||0;if(H.offsetParent==I&&Element.getStyle(H,"position")=="absolute"){break
}}while(H=H.offsetParent);H=K;do{if(H!=I){G-=H.scrollTop||0;J-=H.scrollLeft||0}}while(H=H.parentNode);return new Element.Offset(J,G)}function y(G){G=$(G);
if(Element.getStyle(G,"position")==="absolute"){return G}var K=q(G);var J=G.viewportOffset(),H=K.viewportOffset();var L=J.relativeTo(H);
var I=G.getLayout();G.store("prototype_absolutize_original_styles",{left:G.getStyle("left"),top:G.getStyle("top"),width:G.getStyle("width"),height:G.getStyle("height")});
G.setStyle({position:"absolute",top:L.top+"px",left:L.left+"px",width:I.get("width")+"px",height:I.get("height")+"px"});return G}function m(H){H=$(H);
if(Element.getStyle(H,"position")==="relative"){return H}var G=H.retrieve("prototype_absolutize_original_styles");if(G){H.setStyle(G)
}return H}function a(G){G=$(G);var H=Element.cumulativeOffset(G);window.scrollTo(H.left,H.top);return G}function w(H){H=$(H);var G=Element.getStyle(H,"position"),I={};
if(G==="static"||!G){I.position="relative";if(Prototype.Browser.Opera){I.top=0;I.left=0}Element.setStyle(H,I);Element.store(H,"prototype_made_positioned",true)
}return H}function u(G){G=$(G);var I=Element.getStorage(G),H=I.get("prototype_made_positioned");if(H){I.unset("prototype_made_positioned");
Element.setStyle(G,{position:"",top:"",bottom:"",left:"",right:""})}return G}function e(H){H=$(H);var J=Element.getStorage(H),G=J.get("prototype_made_clipping");
if(Object.isUndefined(G)){var I=Element.getStyle(H,"overflow");J.set("prototype_made_clipping",I);if(I!=="hidden"){H.style.overflow="hidden"
}}return H}function E(G){G=$(G);var I=Element.getStorage(G),H=I.get("prototype_made_clipping");if(!Object.isUndefined(H)){I.unset("prototype_made_clipping");
G.style.overflow=H||""}return G}function F(H,L,G){G=Object.extend({setLeft:true,setTop:true,setWidth:true,setHeight:true,offsetTop:0,offsetLeft:0},G||{});
L=$(L);H=$(H);var M,N,K,J={};if(G.setLeft||G.setTop){M=Element.viewportOffset(L);N=[0,0];if(Element.getStyle(H,"position")==="absolute"){var I=Element.getOffsetParent(H);
if(I!==document.body){N=Element.viewportOffset(I)}}}if(G.setWidth||G.setHeight){K=Element.getLayout(L)}if(G.setLeft){J.left=(M[0]-N[0]+G.offsetLeft)+"px"
}if(G.setTop){J.top=(M[1]-N[1]+G.offsetTop)+"px"}if(G.setWidth){J.width=K.get("border-box-width")+"px"}if(G.setHeight){J.height=K.get("border-box-height")+"px"
}return Element.setStyle(H,J)}if(Prototype.Browser.IE){q=q.wrap(function(I,H){H=$(H);if(h(H)||f(H)||p(H)||o(H)){return $(document.body)
}var G=H.getStyle("position");if(G!=="static"){return I(H)}H.setStyle({position:"relative"});var J=I(H);H.setStyle({position:G});return J
});x=x.wrap(function(J,H){H=$(H);if(!H.parentNode){return new Element.Offset(0,0)}var G=H.getStyle("position");if(G!=="static"){return J(H)
}var I=H.getOffsetParent();if(I&&I.getStyle("position")==="fixed"){g(I)}H.setStyle({position:"relative"});var K=J(H);H.setStyle({position:G});
return K})}else{if(Prototype.Browser.Webkit){D=function(H){H=$(H);var G=0,I=0;do{G+=H.offsetTop||0;I+=H.offsetLeft||0;if(H.offsetParent==document.body){if(Element.getStyle(H,"position")=="absolute"){break
}}H=H.offsetParent}while(H);return new Element.Offset(I,G)}}}Element.addMethods({getLayout:A,measure:d,getWidth:c,getHeight:r,getDimensions:t,getOffsetParent:q,cumulativeOffset:D,positionedOffset:x,cumulativeScrollOffset:b,viewportOffset:B,absolutize:y,relativize:m,scrollTo:a,makePositioned:w,undoPositioned:u,makeClipping:e,undoClipping:E,clonePosition:F});
function p(G){return G.nodeName.toUpperCase()==="BODY"}function o(G){return G.nodeName.toUpperCase()==="HTML"}function h(G){return G.nodeType===Node.DOCUMENT_NODE
}function f(G){return G!==document.body&&!Element.descendantOf(G,document.body)}if("getBoundingClientRect" in document.documentElement){Element.addMethods({viewportOffset:function(G){G=$(G);
if(f(G)){return new Element.Offset(0,0)}var H=G.getBoundingClientRect(),I=document.documentElement;return new Element.Offset(H.left-I.clientLeft,H.top-I.clientTop)
}})}})();(function(){var c=Prototype.Browser.Opera&&(window.parseFloat(window.opera.version())<9.5);var f=null;function b(){if(f){return f
}f=c?document.body:document.documentElement;return f}function d(){return{width:this.getWidth(),height:this.getHeight()}}function a(){return b().clientWidth
}function g(){return b().clientHeight}function e(){var h=window.pageXOffset||document.documentElement.scrollLeft||document.body.scrollLeft;
var j=window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop;return new Element.Offset(h,j)}document.viewport={getDimensions:d,getWidth:a,getHeight:g,getScrollOffsets:e}
})();window.$$=function(){var a=$A(arguments).join(", ");return Prototype.Selector.select(a,document)};Prototype.Selector=(function(){function a(){throw new Error('Method "Prototype.Selector.select" must be defined.')
}function c(){throw new Error('Method "Prototype.Selector.match" must be defined.')}function d(l,m,h){h=h||0;var g=Prototype.Selector.match,k=l.length,f=0,j;
for(j=0;j<k;j++){if(g(l[j],m)&&h==f++){return Element.extend(l[j])}}}function e(h){for(var f=0,g=h.length;f<g;f++){Element.extend(h[f])
}return h}var b=Prototype.K;return{select:a,match:c,find:d,extendElements:(Element.extend===b)?b:e,extendElement:Element.extend}})();
/*!
 * Sizzle CSS Selector Engine
 *  Copyright 2011, The Dojo Foundation
 *  Released under the MIT, BSD, and GPL Licenses.
 *  More information: http://sizzlejs.com/
 */
(function(){var m=/((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^\[\]]*\]|['"][^'"]*['"]|[^\[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g,n=0,q=Object.prototype.toString,g=false,f=true,o=/\\/g,u=/\W/;
[0,0].sort(function(){f=false;return 0});var c=function(z,e,C,D){C=C||[];e=e||document;var F=e;if(e.nodeType!==1&&e.nodeType!==9){return[]
}if(!z||typeof z!=="string"){return C}var w,H,K,v,G,J,I,B,y=true,x=c.isXML(e),A=[],E=z;do{m.exec("");w=m.exec(E);if(w){E=w[3];A.push(w[1]);
if(w[2]){v=w[3];break}}}while(w);if(A.length>1&&h.exec(z)){if(A.length===2&&j.relative[A[0]]){H=r(A[0]+A[1],e)}else{H=j.relative[A[0]]?[e]:c(A.shift(),e);
while(A.length){z=A.shift();if(j.relative[z]){z+=A.shift()}H=r(z,H)}}}else{if(!D&&A.length>1&&e.nodeType===9&&!x&&j.match.ID.test(A[0])&&!j.match.ID.test(A[A.length-1])){G=c.find(A.shift(),e,x);
e=G.expr?c.filter(G.expr,G.set)[0]:G.set[0]}if(e){G=D?{expr:A.pop(),set:k(D)}:c.find(A.pop(),A.length===1&&(A[0]==="~"||A[0]==="+")&&e.parentNode?e.parentNode:e,x);
H=G.expr?c.filter(G.expr,G.set):G.set;if(A.length>0){K=k(H)}else{y=false}while(A.length){J=A.pop();I=J;if(!j.relative[J]){J=""}else{I=A.pop()
}if(I==null){I=e}j.relative[J](K,I,x)}}else{K=A=[]}}if(!K){K=H}if(!K){c.error(J||z)}if(q.call(K)==="[object Array]"){if(!y){C.push.apply(C,K)
}else{if(e&&e.nodeType===1){for(B=0;K[B]!=null;B++){if(K[B]&&(K[B]===true||K[B].nodeType===1&&c.contains(e,K[B]))){C.push(H[B])}}}else{for(B=0;
K[B]!=null;B++){if(K[B]&&K[B].nodeType===1){C.push(H[B])}}}}}else{k(K,C)}if(v){c(v,F,C,D);c.uniqueSort(C)}return C};c.uniqueSort=function(v){if(p){g=f;
v.sort(p);if(g){for(var e=1;e<v.length;e++){if(v[e]===v[e-1]){v.splice(e--,1)}}}}return v};c.matches=function(e,v){return c(e,null,null,v)
};c.matchesSelector=function(e,v){return c(v,null,null,[e]).length>0};c.find=function(B,e,C){var A;if(!B){return[]}for(var x=0,w=j.order.length;
x<w;x++){var y,z=j.order[x];if((y=j.leftMatch[z].exec(B))){var v=y[1];y.splice(1,1);if(v.substr(v.length-1)!=="\\"){y[1]=(y[1]||"").replace(o,"");
A=j.find[z](y,e,C);if(A!=null){B=B.replace(j.match[z],"");break}}}}if(!A){A=typeof e.getElementsByTagName!=="undefined"?e.getElementsByTagName("*"):[]
}return{set:A,expr:B}};c.filter=function(F,E,I,y){var A,e,w=F,K=[],C=E,B=E&&E[0]&&c.isXML(E[0]);while(F&&E.length){for(var D in j.filter){if((A=j.leftMatch[D].exec(F))!=null&&A[2]){var J,H,v=j.filter[D],x=A[1];
e=false;A.splice(1,1);if(x.substr(x.length-1)==="\\"){continue}if(C===K){K=[]}if(j.preFilter[D]){A=j.preFilter[D](A,C,I,K,y,B);if(!A){e=J=true
}else{if(A===true){continue}}}if(A){for(var z=0;(H=C[z])!=null;z++){if(H){J=v(H,A,z,C);var G=y^!!J;if(I&&J!=null){if(G){e=true}else{C[z]=false
}}else{if(G){K.push(H);e=true}}}}}if(J!==undefined){if(!I){C=K}F=F.replace(j.match[D],"");if(!e){return[]}break}}}if(F===w){if(e==null){c.error(F)
}else{break}}w=F}return C};c.error=function(e){throw"Syntax error, unrecognized expression: "+e};var j=c.selectors={order:["ID","NAME","TAG"],match:{ID:/#((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,CLASS:/\.((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,NAME:/\[name=['"]*((?:[\w\u00c0-\uFFFF\-]|\\.)+)['"]*\]/,ATTR:/\[\s*((?:[\w\u00c0-\uFFFF\-]|\\.)+)\s*(?:(\S?=)\s*(?:(['"])(.*?)\3|(#?(?:[\w\u00c0-\uFFFF\-]|\\.)*)|)|)\s*\]/,TAG:/^((?:[\w\u00c0-\uFFFF\*\-]|\\.)+)/,CHILD:/:(only|nth|last|first)-child(?:\(\s*(even|odd|(?:[+\-]?\d+|(?:[+\-]?\d*)?n\s*(?:[+\-]\s*\d+)?))\s*\))?/,POS:/:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^\-]|$)/,PSEUDO:/:((?:[\w\u00c0-\uFFFF\-]|\\.)+)(?:\((['"]?)((?:\([^\)]+\)|[^\(\)]*)+)\2\))?/},leftMatch:{},attrMap:{"class":"className","for":"htmlFor"},attrHandle:{href:function(e){return e.getAttribute("href")
},type:function(e){return e.getAttribute("type")}},relative:{"+":function(A,v){var x=typeof v==="string",z=x&&!u.test(v),B=x&&!z;if(z){v=v.toLowerCase()
}for(var w=0,e=A.length,y;w<e;w++){if((y=A[w])){while((y=y.previousSibling)&&y.nodeType!==1){}A[w]=B||y&&y.nodeName.toLowerCase()===v?y||false:y===v
}}if(B){c.filter(v,A,true)}},">":function(A,v){var z,y=typeof v==="string",w=0,e=A.length;if(y&&!u.test(v)){v=v.toLowerCase();for(;w<e;
w++){z=A[w];if(z){var x=z.parentNode;A[w]=x.nodeName.toLowerCase()===v?x:false}}}else{for(;w<e;w++){z=A[w];if(z){A[w]=y?z.parentNode:z.parentNode===v
}}if(y){c.filter(v,A,true)}}},"":function(x,v,z){var y,w=n++,e=s;if(typeof v==="string"&&!u.test(v)){v=v.toLowerCase();y=v;e=a}e("parentNode",v,w,x,y,z)
},"~":function(x,v,z){var y,w=n++,e=s;if(typeof v==="string"&&!u.test(v)){v=v.toLowerCase();y=v;e=a}e("previousSibling",v,w,x,y,z)}},find:{ID:function(v,w,x){if(typeof w.getElementById!=="undefined"&&!x){var e=w.getElementById(v[1]);
return e&&e.parentNode?[e]:[]}},NAME:function(w,z){if(typeof z.getElementsByName!=="undefined"){var v=[],y=z.getElementsByName(w[1]);
for(var x=0,e=y.length;x<e;x++){if(y[x].getAttribute("name")===w[1]){v.push(y[x])}}return v.length===0?null:v}},TAG:function(e,v){if(typeof v.getElementsByTagName!=="undefined"){return v.getElementsByTagName(e[1])
}}},preFilter:{CLASS:function(x,v,w,e,A,B){x=" "+x[1].replace(o,"")+" ";if(B){return x}for(var y=0,z;(z=v[y])!=null;y++){if(z){if(A^(z.className&&(" "+z.className+" ").replace(/[\t\n\r]/g," ").indexOf(x)>=0)){if(!w){e.push(z)
}}else{if(w){v[y]=false}}}}return false},ID:function(e){return e[1].replace(o,"")},TAG:function(v,e){return v[1].replace(o,"").toLowerCase()
},CHILD:function(e){if(e[1]==="nth"){if(!e[2]){c.error(e[0])}e[2]=e[2].replace(/^\+|\s*/g,"");var v=/(-?)(\d*)(?:n([+\-]?\d*))?/.exec(e[2]==="even"&&"2n"||e[2]==="odd"&&"2n+1"||!/\D/.test(e[2])&&"0n+"+e[2]||e[2]);
e[2]=(v[1]+(v[2]||1))-0;e[3]=v[3]-0}else{if(e[2]){c.error(e[0])}}e[0]=n++;return e},ATTR:function(y,v,w,e,z,A){var x=y[1]=y[1].replace(o,"");
if(!A&&j.attrMap[x]){y[1]=j.attrMap[x]}y[4]=(y[4]||y[5]||"").replace(o,"");if(y[2]==="~="){y[4]=" "+y[4]+" "}return y},PSEUDO:function(y,v,w,e,z){if(y[1]==="not"){if((m.exec(y[3])||"").length>1||/^\w/.test(y[3])){y[3]=c(y[3],null,null,v)
}else{var x=c.filter(y[3],v,w,true^z);if(!w){e.push.apply(e,x)}return false}}else{if(j.match.POS.test(y[0])||j.match.CHILD.test(y[0])){return true
}}return y},POS:function(e){e.unshift(true);return e}},filters:{enabled:function(e){return e.disabled===false&&e.type!=="hidden"},disabled:function(e){return e.disabled===true
},checked:function(e){return e.checked===true},selected:function(e){if(e.parentNode){e.parentNode.selectedIndex}return e.selected===true
},parent:function(e){return !!e.firstChild},empty:function(e){return !e.firstChild},has:function(w,v,e){return !!c(e[3],w).length},header:function(e){return(/h\d/i).test(e.nodeName)
},text:function(w){var e=w.getAttribute("type"),v=w.type;return w.nodeName.toLowerCase()==="input"&&"text"===v&&(e===v||e===null)},radio:function(e){return e.nodeName.toLowerCase()==="input"&&"radio"===e.type
},checkbox:function(e){return e.nodeName.toLowerCase()==="input"&&"checkbox"===e.type},file:function(e){return e.nodeName.toLowerCase()==="input"&&"file"===e.type
},password:function(e){return e.nodeName.toLowerCase()==="input"&&"password"===e.type},submit:function(v){var e=v.nodeName.toLowerCase();
return(e==="input"||e==="button")&&"submit"===v.type},image:function(e){return e.nodeName.toLowerCase()==="input"&&"image"===e.type},reset:function(v){var e=v.nodeName.toLowerCase();
return(e==="input"||e==="button")&&"reset"===v.type},button:function(v){var e=v.nodeName.toLowerCase();return e==="input"&&"button"===v.type||e==="button"
},input:function(e){return(/input|select|textarea|button/i).test(e.nodeName)},focus:function(e){return e===e.ownerDocument.activeElement
}},setFilters:{first:function(v,e){return e===0},last:function(w,v,e,x){return v===x.length-1},even:function(v,e){return e%2===0},odd:function(v,e){return e%2===1
},lt:function(w,v,e){return v<e[3]-0},gt:function(w,v,e){return v>e[3]-0},nth:function(w,v,e){return e[3]-0===v},eq:function(w,v,e){return e[3]-0===v
}},filter:{PSEUDO:function(w,B,A,C){var e=B[1],v=j.filters[e];if(v){return v(w,A,B,C)}else{if(e==="contains"){return(w.textContent||w.innerText||c.getText([w])||"").indexOf(B[3])>=0
}else{if(e==="not"){var x=B[3];for(var z=0,y=x.length;z<y;z++){if(x[z]===w){return false}}return true}else{c.error(e)}}}},CHILD:function(e,x){var A=x[1],v=e;
switch(A){case"only":case"first":while((v=v.previousSibling)){if(v.nodeType===1){return false}}if(A==="first"){return true}v=e;case"last":while((v=v.nextSibling)){if(v.nodeType===1){return false
}}return true;case"nth":var w=x[2],D=x[3];if(w===1&&D===0){return true}var z=x[0],C=e.parentNode;if(C&&(C.sizcache!==z||!e.nodeIndex)){var y=0;
for(v=C.firstChild;v;v=v.nextSibling){if(v.nodeType===1){v.nodeIndex=++y}}C.sizcache=z}var B=e.nodeIndex-D;if(w===0){return B===0}else{return(B%w===0&&B/w>=0)
}}},ID:function(v,e){return v.nodeType===1&&v.getAttribute("id")===e},TAG:function(v,e){return(e==="*"&&v.nodeType===1)||v.nodeName.toLowerCase()===e
},CLASS:function(v,e){return(" "+(v.className||v.getAttribute("class"))+" ").indexOf(e)>-1},ATTR:function(z,x){var w=x[1],e=j.attrHandle[w]?j.attrHandle[w](z):z[w]!=null?z[w]:z.getAttribute(w),A=e+"",y=x[2],v=x[4];
return e==null?y==="!=":y==="="?A===v:y==="*="?A.indexOf(v)>=0:y==="~="?(" "+A+" ").indexOf(v)>=0:!v?A&&e!==false:y==="!="?A!==v:y==="^="?A.indexOf(v)===0:y==="$="?A.substr(A.length-v.length)===v:y==="|="?A===v||A.substr(0,v.length+1)===v+"-":false
},POS:function(y,v,w,z){var e=v[2],x=j.setFilters[e];if(x){return x(y,w,v,z)}}}};var h=j.match.POS,b=function(v,e){return"\\"+(e-0+1)
};for(var d in j.match){j.match[d]=new RegExp(j.match[d].source+(/(?![^\[]*\])(?![^\(]*\))/.source));j.leftMatch[d]=new RegExp(/(^(?:.|\r|\n)*?)/.source+j.match[d].source.replace(/\\(\d+)/g,b))
}var k=function(v,e){v=Array.prototype.slice.call(v,0);if(e){e.push.apply(e,v);return e}return v};try{Array.prototype.slice.call(document.documentElement.childNodes,0)[0].nodeType
}catch(t){k=function(y,x){var w=0,v=x||[];if(q.call(y)==="[object Array]"){Array.prototype.push.apply(v,y)}else{if(typeof y.length==="number"){for(var e=y.length;
w<e;w++){v.push(y[w])}}else{for(;y[w];w++){v.push(y[w])}}}return v}}var p,l;if(document.documentElement.compareDocumentPosition){p=function(v,e){if(v===e){g=true;
return 0}if(!v.compareDocumentPosition||!e.compareDocumentPosition){return v.compareDocumentPosition?-1:1}return v.compareDocumentPosition(e)&4?-1:1
}}else{p=function(C,B){if(C===B){g=true;return 0}else{if(C.sourceIndex&&B.sourceIndex){return C.sourceIndex-B.sourceIndex}}var z,v,w=[],e=[],y=C.parentNode,A=B.parentNode,D=y;
if(y===A){return l(C,B)}else{if(!y){return -1}else{if(!A){return 1}}}while(D){w.unshift(D);D=D.parentNode}D=A;while(D){e.unshift(D);D=D.parentNode
}z=w.length;v=e.length;for(var x=0;x<z&&x<v;x++){if(w[x]!==e[x]){return l(w[x],e[x])}}return x===z?l(C,e[x],-1):l(w[x],B,1)};l=function(v,e,w){if(v===e){return w
}var x=v.nextSibling;while(x){if(x===e){return -1}x=x.nextSibling}return 1}}c.getText=function(e){var v="",x;for(var w=0;e[w];w++){x=e[w];
if(x.nodeType===3||x.nodeType===4){v+=x.nodeValue}else{if(x.nodeType!==8){v+=c.getText(x.childNodes)}}}return v};(function(){var v=document.createElement("div"),w="script"+(new Date()).getTime(),e=document.documentElement;
v.innerHTML="<a name='"+w+"'/>";e.insertBefore(v,e.firstChild);if(document.getElementById(w)){j.find.ID=function(y,z,A){if(typeof z.getElementById!=="undefined"&&!A){var x=z.getElementById(y[1]);
return x?x.id===y[1]||typeof x.getAttributeNode!=="undefined"&&x.getAttributeNode("id").nodeValue===y[1]?[x]:undefined:[]}};j.filter.ID=function(z,x){var y=typeof z.getAttributeNode!=="undefined"&&z.getAttributeNode("id");
return z.nodeType===1&&y&&y.nodeValue===x}}e.removeChild(v);e=v=null})();(function(){var e=document.createElement("div");e.appendChild(document.createComment(""));
if(e.getElementsByTagName("*").length>0){j.find.TAG=function(v,z){var y=z.getElementsByTagName(v[1]);if(v[1]==="*"){var x=[];for(var w=0;
y[w];w++){if(y[w].nodeType===1){x.push(y[w])}}y=x}return y}}e.innerHTML="<a href='#'></a>";if(e.firstChild&&typeof e.firstChild.getAttribute!=="undefined"&&e.firstChild.getAttribute("href")!=="#"){j.attrHandle.href=function(v){return v.getAttribute("href",2)
}}e=null})();if(document.querySelectorAll){(function(){var e=c,x=document.createElement("div"),w="__sizzle__";x.innerHTML="<p class='TEST'></p>";
if(x.querySelectorAll&&x.querySelectorAll(".TEST").length===0){return}c=function(I,z,D,H){z=z||document;if(!H&&!c.isXML(z)){var G=/^(\w+$)|^\.([\w\-]+$)|^#([\w\-]+$)/.exec(I);
if(G&&(z.nodeType===1||z.nodeType===9)){if(G[1]){return k(z.getElementsByTagName(I),D)}else{if(G[2]&&j.find.CLASS&&z.getElementsByClassName){return k(z.getElementsByClassName(G[2]),D)
}}}if(z.nodeType===9){if(I==="body"&&z.body){return k([z.body],D)}else{if(G&&G[3]){var C=z.getElementById(G[3]);if(C&&C.parentNode){if(C.id===G[3]){return k([C],D)
}}else{return k([],D)}}}try{return k(z.querySelectorAll(I),D)}catch(E){}}else{if(z.nodeType===1&&z.nodeName.toLowerCase()!=="object"){var A=z,B=z.getAttribute("id"),y=B||w,K=z.parentNode,J=/^\s*[+~]/.test(I);
if(!B){z.setAttribute("id",y)}else{y=y.replace(/'/g,"\\$&")}if(J&&K){z=z.parentNode}try{if(!J||K){return k(z.querySelectorAll("[id='"+y+"'] "+I),D)
}}catch(F){}finally{if(!B){A.removeAttribute("id")}}}}}return e(I,z,D,H)};for(var v in e){c[v]=e[v]}x=null})()}(function(){var e=document.documentElement,w=e.matchesSelector||e.mozMatchesSelector||e.webkitMatchesSelector||e.msMatchesSelector;
if(w){var y=!w.call(document.createElement("div"),"div"),v=false;try{w.call(document.documentElement,"[test!='']:sizzle")}catch(x){v=true
}c.matchesSelector=function(A,C){C=C.replace(/\=\s*([^'"\]]*)\s*\]/g,"='$1']");if(!c.isXML(A)){try{if(v||!j.match.PSEUDO.test(C)&&!/!=/.test(C)){var z=w.call(A,C);
if(z||!y||A.document&&A.document.nodeType!==11){return z}}}catch(B){}}return c(C,null,null,[A]).length>0}}})();(function(){var e=document.createElement("div");
e.innerHTML="<div class='test e'></div><div class='test'></div>";if(!e.getElementsByClassName||e.getElementsByClassName("e").length===0){return
}e.lastChild.className="e";if(e.getElementsByClassName("e").length===1){return}j.order.splice(1,0,"CLASS");j.find.CLASS=function(v,w,x){if(typeof w.getElementsByClassName!=="undefined"&&!x){return w.getElementsByClassName(v[1])
}};e=null})();function a(v,A,z,D,B,C){for(var x=0,w=D.length;x<w;x++){var e=D[x];if(e){var y=false;e=e[v];while(e){if(e.sizcache===z){y=D[e.sizset];
break}if(e.nodeType===1&&!C){e.sizcache=z;e.sizset=x}if(e.nodeName.toLowerCase()===A){y=e;break}e=e[v]}D[x]=y}}}function s(v,A,z,D,B,C){for(var x=0,w=D.length;
x<w;x++){var e=D[x];if(e){var y=false;e=e[v];while(e){if(e.sizcache===z){y=D[e.sizset];break}if(e.nodeType===1){if(!C){e.sizcache=z;e.sizset=x
}if(typeof A!=="string"){if(e===A){y=true;break}}else{if(c.filter(A,[e]).length>0){y=e;break}}}e=e[v]}D[x]=y}}}if(document.documentElement.contains){c.contains=function(v,e){return v!==e&&(v.contains?v.contains(e):true)
}}else{if(document.documentElement.compareDocumentPosition){c.contains=function(v,e){return !!(v.compareDocumentPosition(e)&16)}}else{c.contains=function(){return false
}}}c.isXML=function(e){var v=(e?e.ownerDocument||e:0).documentElement;return v?v.nodeName!=="HTML":false};var r=function(e,B){var z,x=[],y="",w=B.nodeType?[B]:B;
while((z=j.match.PSEUDO.exec(e))){y+=z[0];e=e.replace(j.match.PSEUDO,"")}e=j.relative[e]?e+"*":e;for(var A=0,v=w.length;A<v;A++){c(e,w[A],x)
}return c.filter(y,x)};window.Sizzle=c})();Prototype._original_property=window.Sizzle;(function(c){var d=Prototype.Selector.extendElements;
function a(e,f){return d(c(e,f||document))}function b(f,e){return c.matches(e,[f]).length==1}Prototype.Selector.engine=c;Prototype.Selector.select=a;
Prototype.Selector.match=b})(Sizzle);window.Sizzle=Prototype._original_property;delete Prototype._original_property;var Form={reset:function(a){a=$(a);
a.reset();return a},serializeElements:function(h,d){if(typeof d!="object"){d={hash:!!d}}else{if(Object.isUndefined(d.hash)){d.hash=true
}}var e,g,a=false,f=d.submit,b,c;if(d.hash){c={};b=function(j,k,l){if(k in j){if(!Object.isArray(j[k])){j[k]=[j[k]]}j[k].push(l)}else{j[k]=l
}return j}}else{c="";b=function(j,k,l){l=l.gsub(/(\r)?\n/,"\r\n");l=encodeURIComponent(l);l=l.gsub(/%20/,"+");return j+(j?"&":"")+encodeURIComponent(k)+"="+l
}}return h.inject(c,function(j,k){if(!k.disabled&&k.name){e=k.name;g=$(k).getValue();if(g!=null&&k.type!="file"&&(k.type!="submit"||(!a&&f!==false&&(!f||e==f)&&(a=true)))){j=b(j,e,g)
}}return j})}};Form.Methods={serialize:function(b,a){return Form.serializeElements(Form.getElements(b),a)},getElements:function(e){var f=$(e).getElementsByTagName("*");
var d,c=[],b=Form.Element.Serializers;for(var a=0;d=f[a];a++){if(b[d.tagName.toLowerCase()]){c.push(Element.extend(d))}}return c},getInputs:function(g,c,d){g=$(g);
var a=g.getElementsByTagName("input");if(!c&&!d){return $A(a).map(Element.extend)}for(var e=0,h=[],f=a.length;e<f;e++){var b=a[e];if((c&&b.type!=c)||(d&&b.name!=d)){continue
}h.push(Element.extend(b))}return h},disable:function(a){a=$(a);Form.getElements(a).invoke("disable");return a},enable:function(a){a=$(a);
Form.getElements(a).invoke("enable");return a},findFirstElement:function(b){var c=$(b).getElements().findAll(function(d){return"hidden"!=d.type&&!d.disabled
});var a=c.findAll(function(d){return d.hasAttribute("tabIndex")&&d.tabIndex>=0}).sortBy(function(d){return d.tabIndex}).first();return a?a:c.find(function(d){return/^(?:input|select|textarea)$/i.test(d.tagName)
})},focusFirstElement:function(b){b=$(b);var a=b.findFirstElement();if(a){a.activate()}return b},request:function(b,a){b=$(b),a=Object.clone(a||{});
var d=a.parameters,c=b.readAttribute("action")||"";if(c.blank()){c=window.location.href}a.parameters=b.serialize(true);if(d){if(Object.isString(d)){d=d.toQueryParams()
}Object.extend(a.parameters,d)}if(b.hasAttribute("method")&&!a.method){a.method=b.method}return new Ajax.Request(c,a)}};Form.Element={focus:function(a){$(a).focus();
return a},select:function(a){$(a).select();return a}};Form.Element.Methods={serialize:function(a){a=$(a);if(!a.disabled&&a.name){var b=a.getValue();
if(b!=undefined){var c={};c[a.name]=b;return Object.toQueryString(c)}}return""},getValue:function(a){a=$(a);var b=a.tagName.toLowerCase();
return Form.Element.Serializers[b](a)},setValue:function(a,b){a=$(a);var c=a.tagName.toLowerCase();Form.Element.Serializers[c](a,b);return a
},clear:function(a){$(a).value="";return a},present:function(a){return $(a).value!=""},activate:function(a){a=$(a);try{a.focus();if(a.select&&(a.tagName.toLowerCase()!="input"||!(/^(?:button|reset|submit)$/i.test(a.type)))){a.select()
}}catch(b){}return a},disable:function(a){a=$(a);a.disabled=true;return a},enable:function(a){a=$(a);a.disabled=false;return a}};var Field=Form.Element;
var $F=Form.Element.Methods.getValue;Form.Element.Serializers=(function(){function b(h,j){switch(h.type.toLowerCase()){case"checkbox":case"radio":return f(h,j);
default:return e(h,j)}}function f(h,j){if(Object.isUndefined(j)){return h.checked?h.value:null}else{h.checked=!!j}}function e(h,j){if(Object.isUndefined(j)){return h.value
}else{h.value=j}}function a(k,n){if(Object.isUndefined(n)){return(k.type==="select-one"?c:d)(k)}var j,l,o=!Object.isArray(n);for(var h=0,m=k.length;
h<m;h++){j=k.options[h];l=this.optionValue(j);if(o){if(l==n){j.selected=true;return}}else{j.selected=n.include(l)}}}function c(j){var h=j.selectedIndex;
return h>=0?g(j.options[h]):null}function d(l){var h,m=l.length;if(!m){return null}for(var k=0,h=[];k<m;k++){var j=l.options[k];if(j.selected){h.push(g(j))
}}return h}function g(h){return Element.hasAttribute(h,"value")?h.value:h.text}return{input:b,inputSelector:f,textarea:e,select:a,selectOne:c,selectMany:d,optionValue:g,button:e}
})();Abstract.TimedObserver=Class.create(PeriodicalExecuter,{initialize:function($super,a,b,c){$super(c,b);this.element=$(a);this.lastValue=this.getValue()
},execute:function(){var a=this.getValue();if(Object.isString(this.lastValue)&&Object.isString(a)?this.lastValue!=a:String(this.lastValue)!=String(a)){this.callback(this.element,a);
this.lastValue=a}}});Form.Element.Observer=Class.create(Abstract.TimedObserver,{getValue:function(){return Form.Element.getValue(this.element)
}});Form.Observer=Class.create(Abstract.TimedObserver,{getValue:function(){return Form.serialize(this.element)}});Abstract.EventObserver=Class.create({initialize:function(a,b){this.element=$(a);
this.callback=b;this.lastValue=this.getValue();if(this.element.tagName.toLowerCase()=="form"){this.registerFormCallbacks()}else{this.registerCallback(this.element)
}},onElementEvent:function(){var a=this.getValue();if(this.lastValue!=a){this.callback(this.element,a);this.lastValue=a}},registerFormCallbacks:function(){Form.getElements(this.element).each(this.registerCallback,this)
},registerCallback:function(a){if(a.type){switch(a.type.toLowerCase()){case"checkbox":case"radio":Event.observe(a,"click",this.onElementEvent.bind(this));
break;default:Event.observe(a,"change",this.onElementEvent.bind(this));break}}}});Form.Element.EventObserver=Class.create(Abstract.EventObserver,{getValue:function(){return Form.Element.getValue(this.element)
}});Form.EventObserver=Class.create(Abstract.EventObserver,{getValue:function(){return Form.serialize(this.element)}});(function(E){var v=document.createElement("div");
var d=document.documentElement;var l="onmouseenter" in d&&"onmouseleave" in d;var M={KEY_BACKSPACE:8,KEY_TAB:9,KEY_RETURN:13,KEY_ESC:27,KEY_LEFT:37,KEY_UP:38,KEY_RIGHT:39,KEY_DOWN:40,KEY_DELETE:46,KEY_HOME:36,KEY_END:35,KEY_PAGEUP:33,KEY_PAGEDOWN:34,KEY_INSERT:45};
var A=function(Y){return false};if(window.attachEvent){if(window.addEventListener){A=function(Y){return !(Y instanceof window.Event)}
}else{A=function(Y){return true}}}var P;function N(Z,Y){return Z.which?(Z.which===Y+1):(Z.button===Y)}var X={0:1,1:4,2:2};function T(Z,Y){return Z.button===X[Y]
}function Q(Z,Y){switch(Y){case 0:return Z.which==1&&!Z.metaKey;case 1:return Z.which==2||(Z.which==1&&Z.metaKey);case 2:return Z.which==3;
default:return false}}if(window.attachEvent){if(!window.addEventListener){P=T}else{P=function(Z,Y){return A(Z)?T(Z,Y):N(Z,Y)}}}else{if(Prototype.Browser.WebKit){P=Q
}else{P=N}}function C(Y){return P(Y,0)}function j(Y){return P(Y,1)}function e(Y){return P(Y,2)}function p(Y){return Element.extend(L(Y))
}function L(aa){aa=M.extend(aa);var Z=aa.target,Y=aa.type,ab=aa.currentTarget;if(ab&&ab.tagName){if(Y==="load"||Y==="error"||(Y==="click"&&ab.tagName.toLowerCase()==="input"&&ab.type==="radio")){Z=ab
}}if(Z.nodeType==Node.TEXT_NODE){Z=Z.parentNode}return Element.extend(Z)}function k(aa,ab){var Z=L(aa),Y=Prototype.Selector.match;if(!ab){return Element.extend(Z)
}while(Z){if(Object.isElement(Z)&&Y(Z,ab)){return Element.extend(Z)}Z=Z.parentNode}}function u(Y){return{x:V(Y),y:U(Y)}}function V(aa){var Z=document.documentElement,Y=document.body||{scrollLeft:0};
return aa.pageX||(aa.clientX+(Z.scrollLeft||Y.scrollLeft)-(Z.clientLeft||0))}function U(aa){var Z=document.documentElement,Y=document.body||{scrollTop:0};
return aa.pageY||(aa.clientY+(Z.scrollTop||Y.scrollTop)-(Z.clientTop||0))}function s(Y){M.extend(Y);Y.preventDefault();Y.stopPropagation();
Y.stopped=true}M.Methods={isLeftClick:C,isMiddleClick:j,isRightClick:e,element:p,findElement:k,pointer:u,pointerX:V,pointerY:U,stop:s};
var I=Object.keys(M.Methods).inject({},function(Y,Z){Y[Z]=M.Methods[Z].methodize();return Y});if(window.attachEvent){function W(Z){var Y;
switch(Z.type){case"mouseover":case"mouseenter":Y=Z.fromElement;break;case"mouseout":case"mouseleave":Y=Z.toElement;break;default:return null
}return Element.extend(Y)}var R={stopPropagation:function(){this.cancelBubble=true},preventDefault:function(){this.returnValue=false},inspect:function(){return"[object Event]"
}};M.extend=function(Z,Y){if(!Z){return false}if(!A(Z)){return Z}if(Z._extendedByPrototype){return Z}Z._extendedByPrototype=Prototype.emptyFunction;
var aa=M.pointer(Z);Object.extend(Z,{target:Z.srcElement||Y,relatedTarget:W(Z),pageX:aa.x,pageY:aa.y});Object.extend(Z,I);Object.extend(Z,R);
return Z}}else{M.extend=Prototype.K}if(window.addEventListener){M.prototype=window.Event.prototype||document.createEvent("HTMLEvents").__proto__;
Object.extend(M.prototype,I)}var w={mouseenter:"mouseover",mouseleave:"mouseout"};function f(Y){return w[Y]||Y}if(l){f=Prototype.K}function S(Y){if(Y===window){return 0
}if(typeof Y._prototypeUID==="undefined"){Y._prototypeUID=Element.Storage.UID++}return Y._prototypeUID}function J(Y){if(Y===window){return 0
}if(Y==document){return 1}return Y.uniqueID}if("uniqueID" in v){S=J}function y(Y){return Y.include(":")}M._isCustomEvent=y;function B(aa,Z){var Y=E.Event.cache;
if(Object.isUndefined(Z)){Z=S(aa)}if(!Y[Z]){Y[Z]={element:aa}}return Y[Z]}function F(Z,Y){if(Object.isUndefined(Y)){Y=S(Z)}delete E.Event.cache[Y]
}function h(aa,ad,ag){var Y=B(aa);if(!Y[ad]){Y[ad]=[]}var ac=Y[ad];var ab=ac.length;while(ab--){if(ac[ab].handler===ag){return null}}var ae=S(aa);
var Z=E.Event._createResponder(ae,ad,ag);var af={responder:Z,handler:ag};ac.push(af);return af}function t(ad,aa,ae){var Z=B(ad);var Y=Z[aa];
if(!Y){return}var ac=Y.length,af;while(ac--){if(Y[ac].handler===ae){af=Y[ac];break}}if(!af){return}var ab=Y.indexOf(af);Y.splice(ab,1);
return af}function c(aa,Z,ab){aa=$(aa);var ac=h(aa,Z,ab);if(ac===null){return aa}var Y=ac.responder;if(y(Z)){q(aa,Z,Y)}else{n(aa,Z,Y)
}return aa}function n(ab,aa,Z){var Y=f(aa);if(ab.addEventListener){ab.addEventListener(Y,Z,false)}else{ab.attachEvent("on"+Y,Z)}}function q(aa,Z,Y){if(aa.addEventListener){aa.addEventListener("dataavailable",Y,false)
}else{aa.attachEvent("ondataavailable",Y);aa.attachEvent("onlosecapture",Y)}}function K(Z,Y,aa){Z=$(Z);var ac=!Object.isUndefined(aa),ad=!Object.isUndefined(Y);
if(!ad&&!ac){z(Z);return Z}if(!ac){H(Z,Y);return Z}var ab=t(Z,Y,aa);if(!ab){return Z}a(Z,Y,ab.responder);return Z}function D(ab,aa,Z){var Y=f(aa);
if(ab.removeEventListener){ab.removeEventListener(Y,Z,false)}else{ab.detachEvent("on"+Y,Z)}}function b(aa,Z,Y){if(aa.removeEventListener){aa.removeEventListener("dataavailable",Y,false)
}else{aa.detachEvent("ondataavailable",Y);aa.detachEvent("onlosecapture",Y)}}function z(ad){var ac=S(ad),aa=B(ad,ac);F(ad,ac);var Y,ab;
for(var Z in aa){if(Z==="element"){continue}Y=aa[Z];ab=Y.length;while(ab--){a(ad,Z,Y[ab].responder)}}}function H(ac,aa){var Z=B(ac);var Y=Z[aa];
if(!Y){return}delete Z[aa];var ab=Y.length;while(ab--){a(ac,aa,Y[ab].responder)}}function a(Z,Y,aa){if(y(Y)){b(Z,Y,aa)}else{D(Z,Y,aa)
}}function g(Y){if(Y!==document){return Y}if(document.createEvent&&!Y.dispatchEvent){return document.documentElement}return Y}function x(ab,aa,Z,Y){ab=g($(ab));
if(Object.isUndefined(Y)){Y=true}Z=Z||{};var ac=O(ab,aa,Z,Y);return M.extend(ac)}function m(ab,aa,Z,Y){var ac=document.createEvent("HTMLEvents");
ac.initEvent("dataavailable",Y,true);ac.eventName=aa;ac.memo=Z;ab.dispatchEvent(ac);return ac}function o(ab,aa,Z,Y){var ac=document.createEventObject();
ac.eventType=Y?"ondataavailable":"onlosecapture";ac.eventName=aa;ac.memo=Z;ab.fireEvent(ac.eventType,ac);return ac}var O=document.createEvent?m:o;
M.Handler=Class.create({initialize:function(aa,Z,Y,ab){this.element=$(aa);this.eventName=Z;this.selector=Y;this.callback=ab;this.handler=this.handleEvent.bind(this)
},start:function(){M.observe(this.element,this.eventName,this.handler);return this},stop:function(){M.stopObserving(this.element,this.eventName,this.handler);
return this},handleEvent:function(Z){var Y=M.findElement(Z,this.selector);if(Y){this.callback.call(this.element,Z,Y)}}});function G(aa,Z,Y,ab){aa=$(aa);
if(Object.isFunction(Y)&&Object.isUndefined(ab)){ab=Y,Y=null}return new M.Handler(aa,Z,Y,ab).start()}Object.extend(M,M.Methods);Object.extend(M,{fire:x,observe:c,stopObserving:K,on:G});
Element.addMethods({fire:x,observe:c,stopObserving:K,on:G});Object.extend(document,{fire:x.methodize(),observe:c.methodize(),stopObserving:K.methodize(),on:G.methodize(),loaded:false});
if(E.Event){Object.extend(window.Event,M)}else{E.Event=M}E.Event.cache={};function r(){E.Event.cache=null}if(window.attachEvent){window.attachEvent("onunload",r)
}v=null;d=null})(this);(function(c){var g=document.documentElement;var b="onmouseenter" in g&&"onmouseleave" in g;function f(h){return !b&&(h==="mouseenter"||h==="mouseleave")
}function d(j,h,k){if(Event._isCustomEvent(h)){return e(j,h,k)}if(f(h)){return a(j,h,k)}return function(m){var n=Event.cache[j];var l=n.element;
Event.extend(m,l);k.call(l,m)}}function e(j,h,k){return function(m){var n=Event.cache[j],l=n.element;if(Object.isUndefined(m.eventName)){return false
}if(m.eventName!==h){return false}Event.extend(m,l);k.call(l,m)}}function a(j,h,k){return function(n){var p=Event.cache[j],l=p.element;
Event.extend(n,l);var m=n.relatedTarget;while(m&&m!==l){try{m=m.parentNode}catch(o){m=l}}if(m===l){return}k.call(l,n)}}c.Event._createResponder=d;
g=null})(this);(function(a){var e;function b(){if(document.loaded){return}if(e){window.clearTimeout(e)}document.loaded=true;document.fire("dom:loaded")
}function d(){if(document.readyState==="complete"){document.detachEvent("onreadystatechange",d);b()}}function c(){try{document.documentElement.doScroll("left")
}catch(f){e=c.defer();return}b()}if(document.addEventListener){document.addEventListener("DOMContentLoaded",b,false)}else{document.attachEvent("onreadystatechange",d);
if(window==top){e=c.defer()}}Event.observe(window,"load",b)})(this);Element.addMethods();Hash.toQueryString=Object.toQueryString;var Toggle={display:Element.toggle};
Element.Methods.childOf=Element.Methods.descendantOf;var Insertion={Before:function(a,b){return Element.insert(a,{before:b})},Top:function(a,b){return Element.insert(a,{top:b})
},Bottom:function(a,b){return Element.insert(a,{bottom:b})},After:function(a,b){return Element.insert(a,{after:b})}};var $continue=new Error('"throw $continue" is deprecated, use "return" instead');
var Position={includeScrollOffsets:false,prepare:function(){this.deltaX=window.pageXOffset||document.documentElement.scrollLeft||document.body.scrollLeft||0;
this.deltaY=window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop||0},within:function(b,a,c){if(this.includeScrollOffsets){return this.withinIncludingScrolloffsets(b,a,c)
}this.xcomp=a;this.ycomp=c;this.offset=Element.cumulativeOffset(b);return(c>=this.offset[1]&&c<this.offset[1]+b.offsetHeight&&a>=this.offset[0]&&a<this.offset[0]+b.offsetWidth)
},withinIncludingScrolloffsets:function(b,a,d){var c=Element.cumulativeScrollOffset(b);this.xcomp=a+c[0]-this.deltaX;this.ycomp=d+c[1]-this.deltaY;
this.offset=Element.cumulativeOffset(b);return(this.ycomp>=this.offset[1]&&this.ycomp<this.offset[1]+b.offsetHeight&&this.xcomp>=this.offset[0]&&this.xcomp<this.offset[0]+b.offsetWidth)
},overlap:function(b,a){if(!b){return 0}if(b=="vertical"){return((this.offset[1]+a.offsetHeight)-this.ycomp)/a.offsetHeight}if(b=="horizontal"){return((this.offset[0]+a.offsetWidth)-this.xcomp)/a.offsetWidth
}},cumulativeOffset:Element.Methods.cumulativeOffset,positionedOffset:Element.Methods.positionedOffset,absolutize:function(a){Position.prepare();
return Element.absolutize(a)},relativize:function(a){Position.prepare();return Element.relativize(a)},realOffset:Element.Methods.cumulativeScrollOffset,offsetParent:Element.Methods.getOffsetParent,page:Element.Methods.viewportOffset,clone:function(b,c,a){a=a||{};
return Element.clonePosition(c,b,a)}};if(!document.getElementsByClassName){document.getElementsByClassName=function(b){function a(c){return c.blank()?null:"[contains(concat(' ', @class, ' '), ' "+c+" ')]"
}b.getElementsByClassName=Prototype.BrowserFeatures.XPath?function(c,e){e=e.toString().strip();var d=/\s/.test(e)?$w(e).map(a).join(""):a(e);
return d?document._getElementsByXPath(".//*"+d,c):[]}:function(e,f){f=f.toString().strip();var g=[],h=(/\s/.test(f)?$w(f):null);if(!h&&!f){return g
}var c=$(e).getElementsByTagName("*");f=" "+f+" ";for(var d=0,k,j;k=c[d];d++){if(k.className&&(j=" "+k.className+" ")&&(j.include(f)||(h&&h.all(function(l){return !l.toString().blank()&&j.include(" "+l+" ")
})))){g.push(Element.extend(k))}}return g};return function(d,c){return $(c||document.body).getElementsByClassName(d)}}(Element.Methods)
}Element.ClassNames=Class.create();Element.ClassNames.prototype={initialize:function(a){this.element=$(a)},_each:function(b,a){this.element.className.split(/\s+/).select(function(c){return c.length>0
})._each(b,a)},set:function(a){this.element.className=a},add:function(a){if(this.include(a)){return}this.set($A(this).concat(a).join(" "))
},remove:function(a){if(!this.include(a)){return}this.set($A(this).without(a).join(" "))},toString:function(){return $A(this).join(" ")
}};Object.extend(Element.ClassNames.prototype,Enumerable);(function(){window.Selector=Class.create({initialize:function(a){this.expression=a.strip()
},findElements:function(a){return Prototype.Selector.select(this.expression,a)},match:function(a){return Prototype.Selector.match(a,this.expression)
},toString:function(){return this.expression},inspect:function(){return"#<Selector: "+this.expression+">"}});Object.extend(Selector,{matchElements:function(f,g){var a=Prototype.Selector.match,d=[];
for(var c=0,e=f.length;c<e;c++){var b=f[c];if(a(b,g)){d.push(Element.extend(b))}}return d},findElement:function(f,g,b){b=b||0;var a=0,d;
for(var c=0,e=f.length;c<e;c++){d=f[c];if(Prototype.Selector.match(d,g)&&b===a++){return Element.extend(d)}}},findChildElements:function(b,c){var a=c.toArray().join(", ");
return Prototype.Selector.select(a,b||document)}})})();function Dom(){}Dom.getEvent=function(a){if(!a){var a=window.event}return a};Dom.getObject=function(a){if(a.currentTarget){return a.currentTarget
}else{return event.srcElement}};Dom.removeObject=function(a){if(a==null){return}a.parentNode.removeChild(a)};Dom.x=function(a){if(a.pageX){return a.pageX
}else{return a.x}};Dom.y=function(a){if(a.pageY){return a.pageY}else{return a.y}};Dom.left=function(a){return a.offsetLeft==0&&a.offsetTop==0?a.style.left.substr(0,a.style.left.length-"px".length):a.offsetLeft
};Dom.top=function(a){return a.offsetLeft==0&&a.offsetTop==0?a.style.top.substr(0,a.style.top.length-"px".length):a.offsetTop};Dom.cornerX=function(a){if(a.layerX){return Dom.x(a)-a.layerX
}else{return Dom.x(a)-a.offsetX}};Dom.cornerY=function(a){if(a.layerY){return Dom.y(a)-a.layerY}else{return Dom.y(a)-a.offsetY}};Dom.setClass=function(b,a){b.setAttribute("class",a);
b.setAttribute("className",a)};Dom.setStyle=function(b,a){b.setAttribute("style",a);b.style.cssText=a};Dom.setDisplay=function(c,a){var b=document.getElementById(c);
if(b==null){return}b.style.display=a};Dom.attachEvent=function(c,b,a){if(c.attachEvent){c.attachEvent("on"+b,a)}else{if(c.addEventListener){c.addEventListener(b,a,true)
}}};Dom.getElementsByName=function(b,c){var d=document.getElementsByTagName(b);var a=new Array();for(i=0,iarr=0;i<d.length;i++){att=d[i].getAttribute("name");
if(att==c){a[iarr]=d[i];iarr++}}return a};Dom.is_child_of=function(a,c){if(c!=null){try{while(c.parentNode){if((c=c.parentNode)==a){return true
}}}catch(b){Debugger.log("Unable to ask is_child_of: "+b)}}return false};Dom.divMouseEvent=function(element,event,JavaScript_code){var current_mouse_target=null;
if(event.toElement){current_mouse_target=event.toElement}else{if(event.relatedTarget){current_mouse_target=event.relatedTarget}}if(!Dom.is_child_of(element,current_mouse_target)&&element!=current_mouse_target){eval(JavaScript_code)
}};Ajax=new Object();Ajax.isSending=false;Ajax.queue=[];Ajax.waitUntilReady=function(){if(!Ajax.isSending&&Ajax.queue.length>0){Ajax.isSending=true;
var a=Ajax.queue[0];a.go();Ajax.queue.splice(0,1)}if(Ajax.queue.length>0){setTimeout("Ajax.waitUntilReady()",100)}};Ajax.createHttp=function(){for(var a=0;
a<httpFactories.length;a++){try{return httpFactories[a]()}catch(b){continue}}return false};Ajax.sendRequest=function(b,d,a){var c=new AjaxSender(b,d,a);
Ajax.queue.push(c);Ajax.waitUntilReady()};Ajax.defaultAjaxHandle=function(b){var a=b.responseText;alert(a)};var httpFactories=[function(){return new XMLHttpRequest()
},function(){return new ActiveXObject("Msxml2.XMLHTTP")},function(){return new ActiveXObject("Msxml3.XMLHTTP")},function(){return new ActiveXObject("Microsoft.XMLHTTP")
}];function AjaxSender(c,b,a){this.url=c;this.callback=b;this.postData=a;this.go=function(){var e=this.url;var g=this.callback;var d=this.postData;
http=Ajax.createHttp();if(!http){return}var f=(d)?"POST":"GET";g=(g)?g:Ajax.defaultAjaxHandle;http.open(f,e,true);if(d){http.setRequestHeader("Content-type","application/x-www-form-urlencoded")
}http.onreadystatechange=function(){if(http.readyState!=4){return}if(http.status!=200&&http.status!=304){return}g(http);Ajax.isSending=false
};if(http.readyState==4){return}http.send(d)}}function roundTo(b,a){var c=Math.pow(10,a);if(a>0){return Math.round(b/c)*c}else{return Math.round(b/c)*c
}}String.prototype.trim=function(){return this.replace(/^\s+|\s+$/g,"")};String.prototype.ltrim=function(){return this.replace(/^\s+/,"")
};String.prototype.rtrim=function(){return this.replace(/\s+$/,"")};function trim(a){return a.replace(/^\s+|\s+$/g,"")}function format(b){var d=b;
var a="";while(d!=a){a=d;for(var c=1;c<arguments.length;c++){d=d.replace("{"+(c-1)+"}",arguments[c])}}return d}function formatOnce(a){var c=a;
for(var b=1;b<arguments.length;b++){c=c.replace("{"+(b-1)+"}",arguments[b])}return c}Json=new Object();Json.toObject=function(jsonText){if(jsonText==""){return null
}eval(format("var data = {0};",jsonText));return data};Json.toString=function(g,c,f){if(typeof(c)=="undefined"){c=null}if(typeof(f)=="undefined"){f=true
}var e="";for(var d in g){var a=g[d];if((""+a).startsWith("function")||a==undefined){continue}if(e.length>0){e+=","}if(Json.isObject(a)){e+=Json.toString(a,d,false)
}else{if(Json.isArray(a)){e+=format('"{0}" : [',d);for(var b=0;b<a.length;b++){if(b>0){e+=","}e+=Json.toString(a[b],null,true)}e+="]"
}else{e+=format('"{0}" : "{1}"',d,g[d])}}}if(c!=null){e=format('"{0}" : {{1}}',c,e)}if(f){e=format("{{0}}",e)}return e};Json.isObject=function(a){return typeof(a)=="object"&&!Json.isArray(a)
};Json.isArray=function(a){return a.constructor.toString().indexOf("Array")!=-1};Debugger=new Object();Debugger.inspect=function(b){var c="";
for(var a in b){if((""+b[a]).startsWith("function")){continue}c+=typeof(b)+"."+a+"="+b[a]+"\n"}alert(c)};Debugger.log=function(a){console.log(a)
};eval(function(h,b,l,f,g,j){g=function(a){return(a<b?"":g(parseInt(a/b)))+((a=a%b)>35?String.fromCharCode(a+29):a.toString(36))};if(!"".replace(/^/,String)){while(l--){j[g(l)]=f[l]||g(l)
}f=[function(a){return j[a]}];g=function(){return"\\w+"};l=1}while(l--){if(f[l]){h=h.replace(new RegExp("\\b"+g(l)+"\\b","g"),f[l])}}return h
}('f(!1o.31){p 31=h(){p l={5S:{"1e-1c":"","73-2E":1,"2a-1P":u,"1I":u,"6T-6S":U,"1F-1P":4,"5F":O,"5x":U,"1q":U,"5v":O,"6i-6p":U,"6J":O},Q:{5D:u,5i:16,5k:16,7P:O,7I:"5L",1b:{4e:"91 1i",3Y:"92 1i",5l:"93 90 6K",6X:"8Z I 8W 1X 8X 6K 8Y",3u:"3u",6h:"?",1u:"31\\n\\n",5Z:"94\'t 95 7J C: ",7z:"9b 9c\'t 9a C 2j-2n 99: ",6B:"<!96 2j 97 \\"-//98//8b 8V 1.0 8U//8I\\" \\"2y://7A.7E.7o/8J/86/8b/86-8K.8H\\"><2j 8G=\\"2y://7A.7E.7o/8D/8E\\"><70><8F 2y-8L=\\"8M-8S\\" 5h=\\"2c/2j; 8T=8R-8\\" /><36>8Q 31</36></70><2R 1f=\\"2a-7T:8N,\'7h 8O 8P\',7h,7L;9d-53:#9e;53:#9D;2a-1P:9E;2c-8i:85;\\"><z 1f=\\"2c-8i:85;5n-4z:9F;\\"><z 1f=\\"2a-7T:9C,9B,9y,8C-7L;2a-1P:9z-9A;\\">31</z><z 1f=\\"2a-1P:.9G;5n-9H:9N;\\"><z>84 2.0.9O (9M 9L 6H)</z><z><a 2q=\\"2y://6a.4a\\" 9I=\\"4P\\" 1f=\\"53:#9J;2c-9K:9x;\\">2y://6a.4a</a></z></z><z>9w I 9k 9l.</z><z>9m 9j-6H 9i 9f.</z></z></2R></2j>"},7j:O},1p:{59:u,3q:u,3o:u,5j:{}},30:{},8a:{9g:/\\/\\*[\\s\\S]*?\\*\\//4M,9h:/\\/\\/.*$/4M,9n:/#.*$/4M,9o:/"(?:\\.|(\\\\\\")|[^\\""\\n])*"/g,9u:/\'(?:\\.|(\\\\\\\')|[^\\\'\'\\n])*\'/g,9v:/"(?:\\.|(\\\\\\")|[^\\""])*"/g,9t:/\'(?:\\.|(\\\\\\\')|[^\\\'\'])*\'/g,3e:/\\w+:\\/\\/[\\w-.\\/?%&=]*/g,9s:{E:/(&1C;|<)\\?=?/g,17:/\\?(&2m;|>)/g},9p:{E:/(&1C;|<)%=?/g,17:/%(&2m;|>)/g},9q:{E:/(&1C;|<)\\s*2n.*?(&2m;|>)/47,17:/(&1C;|<)\\/\\s*2n\\s*(&2m;|>)/47}},1q:{15:h(32){p 38=J.1t("37"),4L=l.1q.77;38.Y="1q";C(p 2N 1X 4L){p 6j=4L[2N],4G=R 6j(32),22=4G.15();32.5E[2N]=4G;f(22==u){1V}f(9r(22)=="9P"){22=l.1q.6C(22,32.1j,2N)}22.Y+="8w "+2N;38.1z(22)}q 38},6C:h(4v,6O,4w){p a=J.1t("a"),5e=a.1f,4F=l.Q,57=4F.5i,5c=4F.5k;a.2q="#"+4w;a.36=4v;a.5P=6O;a.6c=4w;a.1r=4v;f(5z(57)==O){5e.1N=57+"5H"}f(5z(5c)==O){5e.2u=5c+"5H"}a.8q=h(e){8j{l.1q.6f(c,e||1o.6g,c.5P,c.6c)}8m(e){l.B.1u(e.6F)}q O};q a},6f:h(7i,7a,5T,7O,72){p 4Y=l.1p.5j[5T],45;f(4Y==u||(45=4Y.5E[7O])==u){q u}q 45.2h(7i,7a,72)},77:{4e:h(4p){c.15=h(){f(4p.T("5v")!=U){q}q l.Q.1b.4e};c.2h=h(4q,8v,8B){p z=4p.z;4q.71.51(4q);z.Y=z.Y.D("5t","")}},3Y:h(8g){c.15=h(){q l.Q.1b.3Y};c.2h=h(8p,8o,8t){p 33=l.B.3d(8g.5r).D(/</g,"&1C;"),2b=l.B.4y("","4P",8r,8n,"8x=0, 8k=1, 8s=0, 6n=1");33=l.B.2W(33);2b.J.3t("<5L>"+33+"</5L>");2b.J.4N()}},5l:h(4S){p 3x,8y,5M=4S.1j;c.15=h(){p 2A=l.Q;f(2A.5D==u){q u}h 1L(5C){p 5s="";C(p 5A 1X 5C){5s+="<8z 1c=\'"+5A+"\' 1W=\'"+5C[5A]+"\'/>"}q 5s};h 2p(43){p 5p="";C(p 5o 1X 43){5p+=" "+5o+"=\'"+43[5o]+"\'"}q 5p};p 48={1N:2A.5i,2u:2A.5k,1j:5M+"ai",6z:"bu/x-74-79",36:l.Q.1b.5l},46={bl:"bm",bx:"bA",bz:"5P="+5M,bF:"O"},4t=2A.5D,35;f(/aQ/i.1R(61.6b)){35="<8h"+2p({aT:"bd:bf-b9-b5-b4-b7",b8:"2y://ba.be.4a/bb/74/bc/79/b3.b2#84=9,0,0,0"})+2p(48)+">"+1L(46)+1L({aU:4t})+"</8h>"}F{35="<aS"+2p(48)+2p(46)+2p({aR:4t})+"/>"}3x=J.1t("z");3x.1r=35;q 3x};c.2h=h(aV,aW,4R){p 68=4R.b1;6V(68){2J"7C":p 5d=l.B.2W(l.B.3d(4S.5r).D(/&1C;/g,"<").D(/&2m;/g,">").D(/&b0;/g,"&"));f(1o.6e){1o.6e.aZ("2c",5d)}F{q l.B.2W(5d)}2J"aX":l.B.1u(l.Q.1b.6X);2B;2J"aY":l.B.1u(4R.6F);2B}}},bh:h(4I){c.15=h(){q l.Q.1b.3u};c.2h=h(bg,by,bB){p 25=J.1t("bG"),1J=u;f(l.1p.3o!=u){J.2R.51(l.1p.3o)}l.1p.3o=25;25.1f.bC="bE:bD;1N:6m;2u:6m;E:-6l;4z:-6l;";J.2R.1z(25);1J=25.4J.J;6t(1J,1o.J);1J.3t("<z 1e=\\""+4I.z.Y.D("5t","")+" bn\\">"+4I.z.1r+"</z>");1J.4N();25.4J.4A();25.4J.3u();h 6t(6A,6s){p 2S=6s.7M("4K");C(p i=0;i<2S.v;i++){f(2S[i].6r.bk()=="6q"&&/bi\\.12$/.1R(2S[i].2q)){6A.3t("<4K 6z=\\"2c/12\\" 6r=\\"6q\\" 2q=\\""+2S[i].2q+"\\"></4K>")}}}}},bj:h(bo){c.15=h(){q l.Q.1b.6h};c.2h=h(bv,bt){p 2b=l.B.4y("","4P",bq,bs,"6n=0"),1J=2b.J;1J.3t(l.Q.1b.6B);1J.4N();2b.4A()}}}},B:{5m:h(6R){q 6R+3z.aN(3z.aa()*ab).2f()},5u:h(4E,4x){p 3l={},1S;C(1S 1X 4E){3l[1S]=4E[1S]}C(1S 1X 4x){3l[1S]=4x[1S]}q 3l},7w:h(4u){6V(4u){2J"U":q U;2J"O":q O}q 4u},4y:h(3e,6M,4D,4C,2I){p x=(6N.1N-4D)/2,y=(6N.2u-4C)/2;2I+=", E="+x+", 4z="+y+", 1N="+4D+", 2u="+4C;2I=2I.D(/^,/,"");p 4Q=1o.9Q(3e,6M,2I);4Q.4A();q 4Q},78:h(1A,29,23){f(1A.6D){1A["e"+29+23]=23;1A[29+23]=h(){1A["e"+29+23](1o.6g)};1A.6D("a6"+29,1A[29+23])}F{1A.a7(29,23,O)}},1u:h(A){1u(l.Q.1b.1u+A)},4c:h(5a,5Y){p 2k=l.1p.59,3j=u;f(2k==u){2k={};C(p 55 1X l.30){p 3g=l.30[55].ac;f(3g==u){1V}C(p i=0;i<3g.v;i++){2k[3g[i]]=55}}l.1p.59=2k}3j=l.30[2k[5a]];f(3j==u&&5Y!=O){l.B.1u(l.Q.1b.5Z+5a)}q 3j},42:h(A,60){p 2T=A.21("\\n");C(p i=0;i<2T.v;i++){2T[i]=60(2T[i])}q 2T.4h("\\n")},6x:h(){p z=J.1t("z"),3h=J.1t("z"),6d=10,i=1;28(i<=aO){f(i%6d===0){z.1r+=i;i+=(i+"").v}F{z.1r+="&ah;";i++}}3h.Y="5F 2E";3h.1z(z);q 3h},6U:h(A){q A.D(/^[ ]*[\\n]+|[\\n]*[ ]*$/g,"")},7d:h(A){p 3i,4V={},5b=R M("^\\\\[(?<54>(.*?))\\\\]$"),69=R M("(?<1c>[\\\\w-]+)"+"\\\\s*:\\\\s*"+"(?<1W>"+"[\\\\w-%#]+|"+"\\\\[.*?\\\\]|"+"\\".*?\\"|"+"\'.*?\'"+")\\\\s*;?","g");28((3i=69.N(A))!=u){p 2g=3i.1W.D(/^[\'"]|[\'"]$/g,"");f(2g!=u&&5b.1R(2g)){p m=5b.N(2g);2g=m.54.v>0?m.54.21(/\\s*,\\s*/):[]}4V[3i.1c]=2g}q 4V},80:h(A,12){f(A==u||A.v==0||A=="\\n"){q A}A=A.D(/</g,"&1C;");A=A.D(/ {2,}/g,h(m){p 4U="";C(p i=0;i<m.v-1;i++){4U+="&1O;"}q 4U+" "});f(12!=u){A=l.B.42(A,h(2i){f(2i.v==0){q""}p 3k="";2i=2i.D(/^(&1O;| )+/,h(s){3k=s;q""});f(2i.v==0){q 3k}q 3k+"<I 1e=\\""+12+"\\">"+2i+"</I>"})}q A},7f:h(66,67){p 2Z=66.2f();28(2Z.v<67){2Z="0"+2Z}q 2Z},5y:h(){p 3b=J.1t("z"),3f,3a=0,52=J.2R,1j=l.B.5m("5y"),2O="<z 1e=\\"",2Q="</z>",4W="</1T>";3b.1r=2O+"6L\\">"+2O+"26\\">"+2O+"2E\\">"+2O+"5h"+"\\"><1T 1e=\\"7V\\"><1T 1j=\\""+1j+"\\">&1O;"+4W+4W+2Q+2Q+2Q+2Q;52.1z(3b);3f=J.a5(1j);f(/a4/i.1R(61.6b)){p 5Q=1o.9V(3f,u);3a=7l(5Q.9W("1N"))}F{3a=3f.9U}52.51(3b);q 3a},6Q:h(7R,6Y){p 1F="";C(p i=0;i<6Y;i++){1F+=" "}q 7R.D(/\\t/g,1F)},6P:h(2P,41){p 9T=2P.21("\\n"),1F="\\t",5f="";C(p i=0;i<50;i++){5f+="                    "}h 7X(3c,18,7Z){q 3c.1M(0,18)+5f.1M(0,7Z)+3c.1M(18+1,3c.v)};2P=l.B.42(2P,h(20){f(20.1h(1F)==-1){q 20}p 18=0;28((18=20.1h(1F))!=-1){p 7U=41-18%41;20=7X(20,18,7U)}q 20});q 2P},3d:h(A){q(l.Q.7P==U)?A.D(/<br\\s*\\/?>|&1C;br\\s*\\/?&2m;/47,"\\n"):A},3P:h(A){q A.D(/\\s*$/g,"").D(/^\\s*/,"")},2W:h(A){p 1Q=l.B.3d(A).21("\\n"),9X=R 5B(),7S=/^\\s*/,24=9Y;C(p i=0;i<1Q.v&&24>0;i++){p 3V=1Q[i];f(l.B.3P(3V).v==0){1V}p 3S=7S.N(3V);f(3S==u){q A}24=3z.24(3S[0].v,24)}f(24>0){C(p i=0;i<1Q.v;i++){1Q[i]=1Q[i].1M(24)}}q 1Q.4h("\\n")},7B:h(2L,2K){f(2L.H<2K.H){q-1}F{f(2L.H>2K.H){q 1}F{f(2L.v<2K.v){q-1}F{f(2L.v>2K.v){q 1}}}}q 0},2D:h(8d,2G){h 8e(3W,81){q[R l.4i(3W[0],3W.H,81.12)]};p a2=0,3X=u,3y=[],8c=2G.4m?2G.4m:8e;28((3X=2G.3D.N(8d))!=u){3y=3y.2H(8c(3X,2G))}q 3y},6o:h(8f){q 8f.D(l.8a.3e,h(m){q"<a 2q=\\""+m+"\\">"+m+"</a>"})}},1I:h(7c,4l){h 88(4s){p 49=[];C(p i=0;i<4s.v;i++){49.K(4s[i])}q 49};p 3m=4l?[4l]:88(J.7M(l.Q.7I)),7g="1r",2t=u;f(3m.v===0){q}C(p i=0;i<3m.v;i++){p 2F=3m[i],2s=l.B.7d(2F.Y),2Y;2s=l.B.5u(7c,2s);2Y=2s["7J"];f(2Y==u){1V}f(2s["2j-2n"]=="U"){2t=R l.44(2Y)}F{p 4o=l.B.4c(2Y);f(4o){2t=R 4o()}F{1V}}2t.1I(2F[7g],2s);p 2l=2t.z;f(l.Q.7j){2l=J.1t("a0");2l.1W=2t.z.1r;2l.1f.1N="aj";2l.1f.2u="aE"}2F.71.aF(2l,2F)}},aD:h(76){l.B.78(1o,"aC",h(){l.1I(76)})}};l.4i=h(4j,75,12){c.1W=4j;c.H=75;c.v=4j.v;c.12=12};l.4i.Z.2f=h(){q c.1W};l.44=h(4g){p 1H=l.B.4c(4g),4f=R l.30.aA(),aB=u;f(1H==u){q}1H=R 1H();c.4X=4f;f(1H.3K==u){l.B.1u(l.Q.1b.7z+4g);q}4f.4B.K({3D:1H.3K.I,4m:7F});h 39(4d,7G){C(p j=0;j<4d.v;j++){4d[j].H+=7G}};h 7F(14,aH){p 7x=14.I,1E=[],4k=1H.4B,7p=14.H+14.E.v,2X=1H.3K,1n;C(p i=0;i<4k.v;i++){1n=l.B.2D(7x,4k[i]);39(1n,7p);1E=1E.2H(1n)}f(2X.E!=u&&14.E!=u){1n=l.B.2D(14.E,2X.E);39(1n,14.H);1E=1E.2H(1n)}f(2X.17!=u&&14.17!=u){1n=l.B.2D(14.17,2X.17);39(1n,14.H+14[0].aM(14.17));1E=1E.2H(1n)}q 1E}};l.44.Z.1I=h(7u,7t){c.4X.1I(7u,7t);c.z=c.4X.z};l.87=h(){};l.87.Z={T:h(7v,7n){p 5J=c.1L[7v];q l.B.7w(5J==u?7n:5J)},15:h(7y){q J.1t(7y)},7m:h(5G){C(p i=0;i<c.1Y.v;i++){p 2V=c.1Y[i];f(2V===u){1V}f((5G.H>2V.H)&&(5G.H<2V.H+2V.v)){q U}}q O},6v:h(3v,7D){p 2e=[];f(3v!=u){C(p i=0;i<3v.v;i++){2e=2e.2H(l.B.2D(7D,3v[i]))}}2e=2e.aL(l.B.7B);q 2e},6u:h(){C(p i=0;i<c.1Y.v;i++){f(c.7m(c.1Y[i])){c.1Y[i]=u}}},6k:h(2C){p 3w=2C.21(/\\n/g),3s=7l(c.T("73-2E")),7e=(3s+3w.v).2f().v,89=c.T("1I",[]);2C="";C(p i=0;i<3w.v;i++){p 1s=3w[i],2w=/^(&1O;|\\s)+/.N(1s),5w="2E aK"+(i%2==0?1:2),82=l.B.7f(3s+i,7e),83=89.1h((3s+i).2f())!=-1,1D=u;f(2w!=u){1D=2w[0].2f();1s=1s.1M(1D.v);1D=1D.D(/&1O;/g," ");2w=l.1p.3q*1D.v}F{2w=0}1s=l.B.3P(1s);f(1s.v==0){1s="&1O;"}f(83){5w+=" aI"}2C+="<z 1e=\\""+5w+"\\">"+"<I 1e=\\"aJ\\">"+82+".</I>"+"<1T 1e=\\"5h\\">"+(1D!=u?"<I 1e=\\"az\\">"+1D.D(/\\s/g,"&1O;")+"</I>":"")+"<1T 1e=\\"7V\\" 1f=\\"5n-E: "+2w+"5H !aq;\\">"+1s+"</1T>"+"</1T>"+"</z>"}q 2C},6w:h(5N,5K){p 18=0,3n="",3r=l.B.80;C(p i=0;i<5K.v;i++){p 1y=5K[i];f(1y===u||1y.v===0){1V}3n+=3r(5N.1M(18,1y.H-18),"63")+3r(1y.1W,1y.12);18=1y.H+1y.v}3n+=3r(5N.1M(18),"63");q 3n},1I:h(1g,5R){p am=l.Q,3p=l.1p,z,34;c.1L={};c.z=u;c.26=u;c.I=u;c.2d=u;c.5E={};c.1j=l.B.5m("ar");3p.5j[c.1j]=c;f(1g===u){1g=""}f(3p.3q===u){3p.3q=l.B.5y()}c.1L=l.B.5u(l.5S,5R||{});f(c.T("6J")==U){c.1L.1q=c.1L.5x=O}c.z=z=c.15("37");c.26=c.15("37");c.26.Y="26";z.Y="6L";z.1j=c.1j;f(c.T("5v")){z.Y+=" 5t"}f(c.T("5x")==O){z.Y+=" ax"}z.Y+=" "+c.T("1e-1c");z.1f.av=c.T("2a-1P","");c.5r=1g;c.I=l.B.6U(1g).D(/\\r/g," ");34=c.T("1F-1P");c.I=c.T("6T-6S")==U?l.B.6P(c.I,34):l.B.6Q(c.I,34);c.I=l.B.2W(c.I);f(c.T("1q")){c.2d=c.15("37");c.2d.Y="2d";c.2d.1z(l.1q.15(c));z.1z(c.2d)}f(c.T("5F")){z.1z(l.B.6x())}z.1z(c.26);c.1Y=c.6v(c.4B,c.I);c.6u();1g=c.6w(c.I,c.1Y);1g=c.6k(l.B.3P(1g));f(c.T("6i-6p")){1g=l.B.6o(1g)}c.26.1r=1g},au:h(A){A=A.D(/^\\s+|\\s+$/g,"").D(/\\s+/g,"\\\\b|\\\\b");q"\\\\b"+A+"\\\\b"},at:h(2z){c.3K={E:{3D:2z.E,12:"2n"},17:{3D:2z.17,12:"2n"},I:R M("(?<E>"+2z.E.1i+")"+"(?<I>.*?)"+"(?<17>"+2z.17.1i+")","aw")}}};q l}()}f(!5B.1h){5B.Z.1h=h(5V,3J){3J=3z.as(3J||0,0);C(p i=3J;i<c.v;i++){f(c[i]==5V){q i}}q-1}}f(!1o.M){(h(){p 2v={N:V.Z.N,64:5q.Z.64,D:5q.Z.D,21:5q.Z.21},1G={11:/(?:[^\\\\([#\\s.]+|\\\\(?!k<[\\w$]+>|[65]{[^}]+})[\\S\\s]?|\\((?=\\?(?!#|<[\\w$]+>)))+|(\\()(?:\\?(?:(#)[^)]*\\)|<([$\\w]+)>))?|\\\\(?:k<([\\w$]+)>|[65]{([^}]+)})|(\\[\\^?)|([\\S\\s])/g,al:/(?:[^$]+|\\$(?![1-9$&`\']|{[$\\w]+}))+|\\$(?:([1-9]\\d*|[$&`\'])|{([$\\w]+)})/g,3F:/^(?:\\s+|#.*)+/,3R:/^(?:[?*+]|{\\d+(?:,\\d*)?})/,7H:/&&\\[\\^?/g,7q:/]/g},7N=h(5I,7Y,7K){C(p i=7K||0;i<5I.v;i++){f(5I[i]===7Y){q i}}q-1},7k=/()??/.N("")[1]!==3A,3L={};M=h(1d,1U){f(1d 4T V){f(1U!==3A){3G 62("56\'t 58 an 6G ao 5X V ap ay")}q 1d.3I()}p 1U=1U||"",7s=1U.1h("s")>-1,7r=1U.1h("x")>-1,4b=O,3C=[],13=[],11=1G.11,G,3N,3O,3E,3B;11.L=0;28(G=2v.N.2x(11,1d)){f(G[2]){f(!1G.3R.1R(1d.19(11.L))){13.K("(?:)")}}F{f(G[1]){3C.K(G[3]||u);f(G[3]){4b=U}13.K("(")}F{f(G[4]){3E=7N(3C,G[4]);13.K(3E>-1?"\\\\"+(3E+1)+(5z(1d.5O(11.L))?"":"(?:)"):G[0])}F{f(G[5]){13.K(3L.6Z?3L.6Z.7C(G[5],G[0].5O(1)==="P"):G[0])}F{f(G[6]){f(1d.5O(11.L)==="]"){13.K(G[6]==="["?"(?!)":"[\\\\S\\\\s]");11.L++}F{3N=M.6E("&&"+1d.19(G.H),1G.7H,1G.7q,"",{5W:"\\\\"})[0];13.K(G[6]+3N+"]");11.L+=3N.v+1}}F{f(G[7]){f(7s&&G[7]==="."){13.K("[\\\\S\\\\s]")}F{f(7r&&1G.3F.1R(G[7])){3O=2v.N.2x(1G.3F,1d.19(11.L-1))[0].v;f(!1G.3R.1R(1d.19(11.L-1+3O))){13.K("(?:)")}11.L+=3O-1}F{13.K(G[7])}}}F{13.K(G[0])}}}}}}}3B=V(13.4h(""),2v.D.2x(1U,/[aG]+/g,""));3B.1v={1i:1d,2o:4b?3C:u};q 3B};M.ak=h(1c,o){3L[1c]=o};V.Z.N=h(A){p 1a=2v.N.2x(c,A),1c,i,5g;f(1a){f(7k&&1a.v>1){5g=R V("^"+c.1i+"$(?!\\\\s)",c.3U());2v.D.2x(1a[0],5g,h(){C(i=1;i<7b.v-2;i++){f(7b[i]===3A){1a[i]=3A}}})}f(c.1v&&c.1v.2o){C(i=1;i<1a.v;i++){1c=c.1v.2o[i-1];f(1c){1a[1c]=1a[i]}}}f(c.3H&&c.L>(1a.H+1a[0].v)){c.L--}}q 1a}})()}V.Z.3U=h(){q(c.3H?"g":"")+(c.9Z?"i":"")+(c.6W?"m":"")+(c.3F?"x":"")+(c.a1?"y":"")};V.Z.3I=h(7Q){p 3T=R M(c.1i,(7Q||"")+c.3U());f(c.1v){3T.1v={1i:c.1v.1i,2o:c.1v.2o?c.1v.2o.19(0):u}}q 3T};V.Z.2x=h(a3,A){q c.N(A)};V.Z.9S=h(9R,7W){q c.N(7W[0])};M.3Z=h(4r,4Z){p 40="/"+4r+"/"+(4Z||"");q M.3Z[40]||(M.3Z[40]=R M(4r,4Z))};M.3M=h(A){q A.D(/[-[\\]{}()*+?.\\\\^$|,#\\s]/g,"\\\\$&")};M.6E=h(A,E,W,1k,2M){p 2M=2M||{},2U=2M.5W,X=2M.af,1k=1k||"",4O=1k.1h("g")>-1,6y=1k.1h("i")>-1,5U=1k.1h("m")>-1,4H=1k.1h("y")>-1,1k=1k.D(/y/g,""),E=E 4T V?(E.3H?E:E.3I("g")):R M(E,"g"+1k),W=W 4T V?(W.3H?W:W.3I("g")):R M(W,"g"+1k),1K=[],2r=0,1m=0,1l=0,1x=0,27,1Z,1w,1B,3Q,4n;f(2U){f(2U.v>1){3G ae("56\'t 58 ag ad 5X 3M 6I")}f(5U){3G 62("56\'t 58 3M 6I 6G a8 a9 6W aP")}3Q=M.3M(2U);4n=R V("^(?:"+3Q+"[\\\\S\\\\s]|(?:(?!"+E.1i+"|"+W.1i+")[^"+3Q+"])+)+",6y?"i":"")}28(U){E.L=W.L=1l+(2U?(4n.N(A.19(1l))||[""])[0].v:0);1w=E.N(A);1B=W.N(A);f(1w&&1B){f(1w.H<=1B.H){1B=u}F{1w=u}}f(1w||1B){1m=(1w||1B).H;1l=(1w?E:W).L}F{f(!2r){2B}}f(4H&&!2r&&1m>1x){2B}f(1w){f(!2r++){27=1m;1Z=1l}}F{f(1B&&2r){f(!--2r){f(X){f(X[0]&&27>1x){1K.K([X[0],A.19(1x,27),1x,27])}f(X[1]){1K.K([X[1],A.19(27,1Z),27,1Z])}f(X[2]){1K.K([X[2],A.19(1Z,1m),1Z,1m])}f(X[3]){1K.K([X[3],A.19(1m,1l),1m,1l])}}F{1K.K(A.19(1Z,1m))}1x=1l;f(!4O){2B}}}F{E.L=W.L=0;3G b6("bw bp 8l 8u 8A")}}f(1m===1l){1l++}}f(4O&&!4H&&X&&X[0]&&A.v>1x){1K.K([X[0],A.19(1x),1x,A.v])}E.L=W.L=0;q 1K};',62,725,"||||||||||||this|||if||function||||sh||||var|return||||null|length||||div|str|utils|for|replace|left|else|_109|index|code|document|push|lastIndex|XRegExp|exec|false||config|new||getParam|true|RegExp|_121|vN|className|prototype||part|css|_107|_c3|create||right|pos|slice|_111|strings|name|_101|class|style|_ed|indexOf|source|id|_122|_12d|_12c|_ca|window|vars|toolbar|innerHTML|_e0|createElement|alert|_x|_131|_12e|_ec|appendChild|obj|_132|lt|_e5|_c6|tab|lib|_bd|highlight|doc|_12a|params|substr|width|nbsp|size|_97|test|_4b|span|_102|continue|value|in|matches|_130|_91|split|_8|_57|min|_3c|lines|_12f|while|_56|font|wnd|text|bar|_d7|toString|_6e|execute|_75|html|_5b|_b7|gt|script|captureNames|attributes|href|_12b|_b4|_b1|height|_f8|_e1|call|http|_f4|_28|break|_da|getMatches|line|_b3|_a1|concat|_51|case|m2|m1|_123|_5|_80|_88|_81|body|_40|_62|_124|_d4|unindent|_c9|_b5|_7a|brushes|SyntaxHighlighter|_2|_22|_f2|_32|title|DIV|_3|offsetMatches|_7d|_7b|_8e|fixForBlogger|url|_7c|_5e|_65|_6a|_5c|_76|_4a|_af|_e9|printFrame|_f0|spaceWidth|_ea|_dc|write|print|_d5|_db|_25|_a6|Math|undefined|_10d|_106|regex|_10c|extended|throw|global|addFlags|_f6|htmlScript|_100|escape|cc|len|trim|_133|quantifier|_9d|_116|getNativeFlags|_9c|_a2|_a5|viewSource|cache|key|_89|eachLine|_2c|HtmlScript|_18|_30|gi|_2f|_ad|com|_105|findBrush|_c0|expandSource|_be|_bc|join|Match|_b9|_c7|_ab|func|esc|_b6|_19|_1a|_11b|_ac|swf|_4c|_9|_b|_49|popup|top|focus|regexList|_50|_4f|_48|_e|_7|_129|_38|contentWindow|link|_4|gm|close|_126|_blank|win|_35|_24|instanceof|_73|_6b|_82|xmlBrush|_17|_11c||removeChild|_7e|color|values|_5d|can|_f|supply|discoveredBrushes|_59|_6c|_10|_37|_d|_8c|r2|content|toolbarItemWidth|highlighters|toolbarItemHeight|copyToClipboard|guid|margin|_2e|_2d|String|originalCode|_2a|collapsed|merge|collapse|_e2|gutter|measureSpace|isNaN|_2b|Array|_29|clipboardSwf|toolbarCommands|ruler|_d2|px|_fb|_d0|_e7|pre|_27|_e6|charAt|highlighterId|_83|_ee|defaults|_14|_128|_f5|escapeChar|one|_5a|noBrush|_61|navigator|TypeError|plain|match|pP|_78|_79|_36|_6d|alexgorbatchev|userAgent|commandName|_66|clipboardData|executeCommand|event|help|auto|_6|createDisplayLines|500px|0px|scrollbars|processUrls|links|stylesheet|rel|_3f|copyStyles|removeNestedMatches|findMatches|processMatches|createRuler|_127|type|_3e|aboutDialog|createButton|attachEvent|matchRecursive|message|when|2009|character|light|clipboard|syntaxhighlighter|_4e|screen|_a|processSmartTabs|processTabs|_47|tabs|smart|trimFirstAndLastLines|switch|multiline|copyToClipboardConfirmation|_85|unicode|head|parentNode|_16|first|shockwave|_ba|_b8|items|addEvent|flash|_13|arguments|_aa|parseParams|_dd|padNumber|_b0|Times|_12|debug|_ff|parseInt|isMatchNested|_cf|org|_c8|classRight|_104|_103|_cd|_cc|_ce|toBoolean|_c5|_d1|brushNotHtmlScript|www|matchesSortCallback|get|_d6|w3|process|_c1|classLeft|tagName|brush|_fd|serif|getElementsByTagName|_fa|_15|bloggerMode|_115|_84|_99|family|_93|block|args|insertSpaces|_fc|_90|decorate|_a3|_e3|_e4|version|center|xhtml1|Highlighter|toArray|_de|regexLib|DTD|_a7|_a0|defaultAdd|_a8|_1e|object|align|try|resizable|contains|catch|400|_20|_1f|onclick|750|menubar|_21|unbalanced|_1b|item|location|_26|param|delimiters|_1c|sans|1999|xhtml|meta|xmlns|dtd|EN|TR|transitional|equiv|Content|Georgia|New|Roman|About|utf|Type|charset|Transitional|XHTML|is|your|now|The|to|expand|view|copy|Can|find|DOCTYPE|PUBLIC|W3C|option|configured|Brush|wasn|background|fff|Gorbatchev|multiLineCComments|singleLineCComments|Alex|2004|syntax|highlighter|Copyright|singleLinePerlComments|doubleQuotedString|aspScriptTags|scriptScriptTags|typeof|phpScriptTags|multiLineSingleQuotedString|singleQuotedString|multiLineDoubleQuotedString|JavaScript|none|Helvetica|xx|large|Arial|Geneva|000|1em|3em|75em|bottom|target|0099FF|decoration|01|March|4em|296|string|open|_119|apply|_8a|offsetWidth|getComputedStyle|getPropertyValue|_98|1000|ignoreCase|textarea|sticky|_a4|_117|opera|getElementById|on|addEventListener|using|the|random|1000000|aliases|than|SyntaxError|valueNames|more|middot|_clipboard|70em|addPlugin|replaceVar|_ef|flags|constructing|from|important|highlighter_|max|forHtmlScript|getKeywords|fontSize|sgi|nogutter|another|spaces|Xml|_bf|load|all|30em|replaceChild|sx|_c4|highlighted|number|alt|sort|lastIndexOf|round|150|flag|msie|src|embed|classid|movie|_33|_34|ok|error|setData|amp|command|cab|swflash|96b8|11cf|Error|444553540000|codebase|ae6d|download|pub|cabs|clsid|macromedia|d27cdb6e|_39|printSource|shCore|about|toLowerCase|allowScriptAccess|always|printing|_42|data|500||250|_44|application|_43|subject|wmode|_3a|flashVars|transparent|_3b|cssText|absolute|position|menu|IFRAME".split("|"),0,{}));
SyntaxHighlighter.brushes.Alloy=function(){var a="abstract assert assert fact in all else extends module sig String Int one some lone set no ";
this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,css:"value"},{regex:/(?!\@interface\b)\@[\$\w]+\b/g,css:"color1"},{regex:/\@interface\b/g,css:"color2"},{regex:new RegExp(this.getKeywords(a),"gm"),css:"keyword"}];
this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)};SyntaxHighlighter.brushes.Alloy.prototype=new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Alloy.aliases=["Alloy","alloy","als"];SyntaxHighlighter.brushes.Cpp=function(){var c="ATOM BOOL BOOLEAN BYTE CHAR COLORREF DWORD DWORDLONG DWORD_PTR DWORD32 DWORD64 FLOAT HACCEL HALF_PTR HANDLE HBITMAP HBRUSH HCOLORSPACE HCONV HCONVLIST HCURSOR HDC HDDEDATA HDESK HDROP HDWP HENHMETAFILE HFILE HFONT HGDIOBJ HGLOBAL HHOOK HICON HINSTANCE HKEY HKL HLOCAL HMENU HMETAFILE HMODULE HMONITOR HPALETTE HPEN HRESULT HRGN HRSRC HSZ HWINSTA HWND INT INT_PTR INT32 INT64 LANGID LCID LCTYPE LGRPID LONG LONGLONG LONG_PTR LONG32 LONG64 LPARAM LPBOOL LPBYTE LPCOLORREF LPCSTR LPCTSTR LPCVOID LPCWSTR LPDWORD LPHANDLE LPINT LPLONG LPSTR LPTSTR LPVOID LPWORD LPWSTR LRESULT PBOOL PBOOLEAN PBYTE PCHAR PCSTR PCTSTR PCWSTR PDWORDLONG PDWORD_PTR PDWORD32 PDWORD64 PFLOAT PHALF_PTR PHANDLE PHKEY PINT PINT_PTR PINT32 PINT64 PLCID PLONG PLONGLONG PLONG_PTR PLONG32 PLONG64 POINTER_32 POINTER_64 PSHORT PSIZE_T PSSIZE_T PSTR PTBYTE PTCHAR PTSTR PUCHAR PUHALF_PTR PUINT PUINT_PTR PUINT32 PUINT64 PULONG PULONGLONG PULONG_PTR PULONG32 PULONG64 PUSHORT PVOID PWCHAR PWORD PWSTR SC_HANDLE SC_LOCK SERVICE_STATUS_HANDLE SHORT SIZE_T SSIZE_T TBYTE TCHAR UCHAR UHALF_PTR UINT UINT_PTR UINT32 UINT64 ULONG ULONGLONG ULONG_PTR ULONG32 ULONG64 USHORT USN VOID WCHAR WORD WPARAM WPARAM WPARAM char bool short int __int32 __int64 __int8 __int16 long float double __wchar_t clock_t _complex _dev_t _diskfree_t div_t ldiv_t _exception _EXCEPTION_POINTERS FILE _finddata_t _finddatai64_t _wfinddata_t _wfinddatai64_t __finddata64_t __wfinddata64_t _FPIEEE_RECORD fpos_t _HEAPINFO _HFILE lconv intptr_t jmp_buf mbstate_t _off_t _onexit_t _PNH ptrdiff_t _purecall_handler sig_atomic_t size_t _stat __stat64 _stati64 terminate_function time_t __time64_t _timeb __timeb64 tm uintptr_t _utimbuf va_list wchar_t wctrans_t wctype_t wint_t signed";
var a="break case catch class const __finally __exception __try const_cast continue private public protected __declspec default delete deprecated dllexport dllimport do dynamic_cast else enum explicit extern if for friend goto inline mutable naked namespace new noinline noreturn nothrow register reinterpret_cast return selectany sizeof static static_cast struct switch template this thread throw true false try typedef typeid typename union using uuid virtual void volatile whcar_t while";
var b="assert isalnum isalpha iscntrl isdigit isgraph islower isprintispunct isspace isupper isxdigit tolower toupper errno localeconv setlocale acos asin atan atan2 ceil cos cosh exp fabs floor fmod frexp ldexp log log10 modf pow sin sinh sqrt tan tanh jmp_buf longjmp setjmp raise signal sig_atomic_t va_arg va_end va_start clearerr fclose feof ferror fflush fgetc fgetpos fgets fopen fprintf fputc fputs fread freopen fscanf fseek fsetpos ftell fwrite getc getchar gets perror printf putc putchar puts remove rename rewind scanf setbuf setvbuf sprintf sscanf tmpfile tmpnam ungetc vfprintf vprintf vsprintf abort abs atexit atof atoi atol bsearch calloc div exit free getenv labs ldiv malloc mblen mbstowcs mbtowc qsort rand realloc srand strtod strtol strtoul system wcstombs wctomb memchr memcmp memcpy memmove memset strcat strchr strcmp strcoll strcpy strcspn strerror strlen strncat strncmp strncpy strpbrk strrchr strspn strstr strtok strxfrm asctime clock ctime difftime gmtime localtime mktime strftime time";
this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/^ *#.*/gm,css:"preprocessor"},{regex:new RegExp(this.getKeywords(c),"gm"),css:"color1 bold"},{regex:new RegExp(this.getKeywords(b),"gm"),css:"functions bold"},{regex:new RegExp(this.getKeywords(a),"gm"),css:"keyword bold"}]
};SyntaxHighlighter.brushes.Cpp.prototype=new SyntaxHighlighter.Highlighter();SyntaxHighlighter.brushes.Cpp.aliases=["cpp","c"];SyntaxHighlighter.brushes.Java=function(){var a="abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import instanceof int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws true transient try void volatile while";
this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,css:"value"},{regex:/(?!\@interface\b)\@[\$\w]+\b/g,css:"color1"},{regex:/\@interface\b/g,css:"color2"},{regex:new RegExp(this.getKeywords(a),"gm"),css:"keyword"}];
this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)};SyntaxHighlighter.brushes.Java.prototype=new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Java.aliases=["java"];SyntaxHighlighter.brushes.NuSMV=function(){var a="MODULE IVAR VAR ASSIGN DEFINE TRANS INVARSPEC SPEC CTLSPEC LTLSPEC next init esac case TRUE FALSE main EF AG AX AF EX EG U A E ";
this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,css:"value"},{regex:/(?!\@interface\b)\@[\$\w]+\b/g,css:"color1"},{regex:/\@interface\b/g,css:"color2"},{regex:new RegExp(this.getKeywords(a),"gm"),css:"keyword"}];
this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)};SyntaxHighlighter.brushes.NuSMV.prototype=new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.NuSMV.aliases=["NuSMV","nusmv","smv"];SyntaxHighlighter.brushes.Php=function(){var a="abs acos acosh addcslashes addslashes array_change_key_case array_chunk array_combine array_count_values array_diff array_diff_assoc array_diff_key array_diff_uassoc array_diff_ukey array_fill array_filter array_flip array_intersect array_intersect_assoc array_intersect_key array_intersect_uassoc array_intersect_ukey array_key_exists array_keys array_map array_merge array_merge_recursive array_multisort array_pad array_pop array_product array_push array_rand array_reduce array_reverse array_search array_shift array_slice array_splice array_sum array_udiff array_udiff_assoc array_udiff_uassoc array_uintersect array_uintersect_assoc array_uintersect_uassoc array_unique array_unshift array_values array_walk array_walk_recursive atan atan2 atanh base64_decode base64_encode base_convert basename bcadd bccomp bcdiv bcmod bcmul bindec bindtextdomain bzclose bzcompress bzdecompress bzerrno bzerror bzerrstr bzflush bzopen bzread bzwrite ceil chdir checkdate checkdnsrr chgrp chmod chop chown chr chroot chunk_split class_exists closedir closelog copy cos cosh count count_chars date decbin dechex decoct deg2rad delete ebcdic2ascii echo empty end ereg ereg_replace eregi eregi_replace error_log error_reporting escapeshellarg escapeshellcmd eval exec exit exp explode extension_loaded feof fflush fgetc fgetcsv fgets fgetss file_exists file_get_contents file_put_contents fileatime filectime filegroup fileinode filemtime fileowner fileperms filesize filetype floatval flock floor flush fmod fnmatch fopen fpassthru fprintf fputcsv fputs fread fscanf fseek fsockopen fstat ftell ftok getallheaders getcwd getdate getenv gethostbyaddr gethostbyname gethostbynamel getimagesize getlastmod getmxrr getmygid getmyinode getmypid getmyuid getopt getprotobyname getprotobynumber getrandmax getrusage getservbyname getservbyport gettext gettimeofday gettype glob gmdate gmmktime ini_alter ini_get ini_get_all ini_restore ini_set interface_exists intval ip2long is_a is_array is_bool is_callable is_dir is_double is_executable is_file is_finite is_float is_infinite is_int is_integer is_link is_long is_nan is_null is_numeric is_object is_readable is_real is_resource is_scalar is_soap_fault is_string is_subclass_of is_uploaded_file is_writable is_writeable mkdir mktime nl2br parse_ini_file parse_str parse_url passthru pathinfo readlink realpath rewind rewinddir rmdir round str_ireplace str_pad str_repeat str_replace str_rot13 str_shuffle str_split str_word_count strcasecmp strchr strcmp strcoll strcspn strftime strip_tags stripcslashes stripos stripslashes stristr strlen strnatcasecmp strnatcmp strncasecmp strncmp strpbrk strpos strptime strrchr strrev strripos strrpos strspn strstr strtok strtolower strtotime strtoupper strtr strval substr substr_compare";
var c="and or xor array as break case cfunction class const continue declare default die do else elseif enddeclare endfor endforeach endif endswitch endwhile extends for foreach function include include_once global if new old_function return static switch use require require_once var while abstract interface public implements extends private protected throw";
var b="__FILE__ __LINE__ __METHOD__ __FUNCTION__ __CLASS__";this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineCComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/\$\w+/g,css:"variable"},{regex:new RegExp(this.getKeywords(a),"gmi"),css:"functions"},{regex:new RegExp(this.getKeywords(b),"gmi"),css:"constants"},{regex:new RegExp(this.getKeywords(c),"gm"),css:"keyword"}];
this.forHtmlScript(SyntaxHighlighter.regexLib.phpScriptTags)};SyntaxHighlighter.brushes.Php.prototype=new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Php.aliases=["php"];SyntaxHighlighter.brushes.Ruby=function(){var a="alias and BEGIN begin break case class def define_method defined do each else elsif END end ensure false for if in module new next nil not or raise redo rescue retry return self super then throw true undef unless until when while yield";
var b="Array Bignum Binding Class Continuation Dir Exception FalseClass File::Stat File Fixnum Fload Hash Integer IO MatchData Method Module NilClass Numeric Object Proc Range Regexp String Struct::TMS Symbol ThreadGroup Thread Time TrueClass";
this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLinePerlComments,css:"comments"},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:"string"},{regex:/\b[A-Z0-9_]+\b/g,css:"constants"},{regex:/:[a-z][A-Za-z0-9_]*/g,css:"color2"},{regex:/(\$|@@|@)\w+/g,css:"variable bold"},{regex:new RegExp(this.getKeywords(a),"gm"),css:"keyword"},{regex:new RegExp(this.getKeywords(b),"gm"),css:"color1"}];
this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)};SyntaxHighlighter.brushes.Ruby.prototype=new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Ruby.aliases=["ruby","rails","ror"];SyntaxHighlighter.brushes.Sql=function(){var b="abs avg case cast coalesce convert count current_timestamp current_user day isnull left lower month nullif replace right session_user space substring sum system_user upper user year";
var c="absolute action add after alter as asc at authorization begin bigint binary bit by cascade char character check checkpoint close collate column commit committed connect connection constraint contains continue create cube current current_date current_time cursor database date deallocate dec decimal declare default delete desc distinct double drop dynamic else end end-exec escape except exec execute false fetch first float for force foreign forward free from full function global goto grant group grouping having hour ignore index inner insensitive insert instead int integer intersect into is isolation key last level load local max min minute modify move name national nchar next no numeric of off on only open option order out output partial password precision prepare primary prior privileges procedure public read real references relative repeatable restrict return returns revoke rollback rollup rows rule schema scroll second section select sequence serializable set size smallint static statistics table temp temporary then time timestamp to top transaction translation trigger true truncate uncommitted union unique update values varchar varying view when where with work";
var a="all and any between cross in join like not null or outer some";this.regexList=[{regex:/--(.*)$/gm,css:"comments"},{regex:SyntaxHighlighter.regexLib.multiLineDoubleQuotedString,css:"string"},{regex:SyntaxHighlighter.regexLib.multiLineSingleQuotedString,css:"string"},{regex:new RegExp(this.getKeywords(b),"gmi"),css:"color2"},{regex:new RegExp(this.getKeywords(a),"gmi"),css:"color1"},{regex:new RegExp(this.getKeywords(c),"gmi"),css:"keyword"}]
};SyntaxHighlighter.brushes.Sql.prototype=new SyntaxHighlighter.Highlighter();SyntaxHighlighter.brushes.Sql.aliases=["sql"];SyntaxHighlighter.brushes.Xml=function(){function a(e,j){var f=SyntaxHighlighter.Match,h=e[0],c=new XRegExp("(&lt;|<)[\\s\\/\\?]*(?<name>[:\\w-\\.]+)","xg").exec(h),b=[];
if(e.attributes!=null){var d,g=new XRegExp("(?<name> [\\w:\\-\\.]+)\\s*=\\s*(?<value> \".*?\"|'.*?'|\\w+)","xg");while((d=g.exec(h))!=null){b.push(new f(d.name,e.index+d.index,"color1"));
b.push(new f(d.value,e.index+d.index+d[0].indexOf(d.value),"string"))}}if(c!=null){b.push(new f(c.name,e.index+c[0].indexOf(c.name),"keyword"))
}return b}this.regexList=[{regex:new XRegExp("(\\&lt;|<)\\!\\[[\\w\\s]*?\\[(.|\\s)*?\\]\\](\\&gt;|>)","gm"),css:"color2"},{regex:new XRegExp("(\\&lt;|<)!--\\s*.*?\\s*--(\\&gt;|>)","gm"),css:"comments"},{regex:new XRegExp("(&lt;|<)[\\s\\/\\?]*(\\w+)(?<attributes>.*?)[\\s\\/\\?]*(&gt;|>)","sg"),func:a}]
};SyntaxHighlighter.brushes.Xml.prototype=new SyntaxHighlighter.Highlighter();SyntaxHighlighter.brushes.Xml.aliases=["xml","xhtml","xslt","html","xhtml"];
var inlineeditor_isIE=(navigator.userAgent.toLowerCase().search("msie")!=-1&&navigator.userAgent.toLowerCase().search("opera")==-1)?true:false;
var InlineEditor={alreadyInited:false,addClass:function(a,b){return InlineEditor.jscss("add",a,b)},removeClass:function(a,b){return InlineEditor.jscss("remove",a,b)
},checkClass:function(a,b){return InlineEditor.jscss("check",a,b)},swapClass:function(c,b,a){return InlineEditor.jscss("swap",c,b,a)},customEditor:function(b){var a=jQuery("<input/>");
a.attr("id",b.attr("id")+"_editor");a.val(b.html()=="-- Add More --"?"":b.html());a.width(b.parent().width()-30);a.height(b.offset().height);
return a},handleOnClick:function(a){var a=InlineEditor.fixEvent(a);var e=jQuery(InlineEditor.findEditableTarget(a.target));if(e.hasClass("uneditable")||e.hasClass("editing")){return
}var c=e.html();var b=null;if(InlineEditor.elementValue){b=InlineEditor.elementValue(e)}if(!b){b=e.html()}var d=null;if(InlineEditor.customEditor){d=InlineEditor.customEditor(e)
}d.focusout(function(f){InlineEditor.handleInputBlur(d,b,c)});d.keypress(function(g){var f=13;if(g.which==f){d.blur();if(b=="-- Add More --"&&d.val()!=""){var h=e.attr("id");
jQuery("#"+h).click()}}});e.addClass("editing");e.html("");e.append(d);d.focusin();d.select();return false},handleInputBlur:function(e,a,c){var d=e.parent();
var b=null;if(InlineEditor.editorValue){b=InlineEditor.editorValue(e)}if(!b){b=e.val()==""?a:e.val()}if(a==b){d.html(c);d.removeClass("editing");
return}d.html(b);if(InlineEditor.elementChanged){InlineEditor.elementChanged(d,a,b)}},jscss:function(b,f,d,c){switch(b){case"swap":f.className=!InlineEditor.jscss("check",f,d)?f.className.replace(c,d):f.className.replace(d,c);
break;case"add":if(!InlineEditor.jscss("check",f,d)){f.className+=f.className?" "+d:d}break;case"remove":var e=f.className.match(" "+d)?" "+d:d;
f.className=f.className.replace(e,"");break;case"check":return new RegExp("\\b"+d+"\\b").test(f.className);break}},fixEvent:function(a){var b=a?a:window.event;
if(b.target){if(b.target.nodeType==3){b.target=b.target.parentNode}}if(inlineeditor_isIE){if(b.srcElement){b.target=b.srcElement}}return b
},findEditableTarget:function(a){if(a.nodeType==1&&a.tagName=="TD"){return a}if(InlineEditor.checkClass(a,"editable")){return a}if(a.parentNode){return InlineEditor.findEditableTarget(a.parentNode)
}return null},addEvent:function(d,b,c,a){if(d.addEventListener){d.addEventListener(b,c,a);return true}else{if(d.attachEvent){return d.attachEvent("on"+b,c)
}}},removeEvent:function(d,b,c,a){if(d.removeEventListener){d.removeEventListener(b,c,a);return true}else{if(d.detachEvent){return d.detachEvent("on"+b,c)
}}}};var CodeMirror=(function(){function r(aE,aB){var bO={},ba=r.defaults;for(var aq in ba){if(ba.hasOwnProperty(aq)){bO[aq]=(aB&&aB.hasOwnProperty(aq)?aB:ba)[aq]
}}var cz=bO.document;var av=cz.createElement("div");av.className="CodeMirror"+(bO.lineWrapping?" CodeMirror-wrap":"");av.innerHTML='<div style="overflow: hidden; position: relative; width: 3px; height: 0px;"><textarea style="position: absolute; padding: 0; width: 1px; height: 1em" wrap="off" autocorrect="off" autocapitalize="off"></textarea></div><div class="CodeMirror-scroll" tabindex="-1"><div style="position: relative"><div style="position: relative"><div class="CodeMirror-gutter"><div class="CodeMirror-gutter-text"></div></div><div class="CodeMirror-lines"><div style="position: relative; z-index: 0"><div style="position: absolute; width: 100%; height: 0; overflow: hidden; visibility: hidden; outline: 5px auto none"></div><pre class="CodeMirror-cursor">&#160;</pre><div style="position: relative; z-index: -1"></div><div></div></div></div></div></div></div>';
if(aE.appendChild){aE.appendChild(av)}else{aE(av)}var bL=av.firstChild,bd=bL.firstChild,bb=av.lastChild,bB=bb.firstChild,b3=bB.firstChild,az=b3.firstChild,aR=az.firstChild,bl=az.nextSibling.firstChild,am=bl.firstChild,a4=am.nextSibling,a8=a4.nextSibling,ai=a8.nextSibling;
cq();if(p){bd.style.width="0px"}if(!e){bl.draggable=true}bl.style.outline="none";if(bO.tabindex!=null){bd.tabIndex=bO.tabindex}if(!bO.gutter&&!bO.lineNumbers){az.style.display="none"
}try{cg("x")}catch(bV){if(bV.message.match(/runtime/i)){bV=new Error("A CodeMirror inside a P-style element does not work in Internet Explorer. (innerHTML bug)")
}throw bV}var bU=new w(),an=new w(),cD;var bY,cl=new g([new aa([new d("")])]),b4,b6;bH();var cL={from:{line:0,ch:0},to:{line:0,ch:0},inverted:false};
var b5,bg,aS,bu=0,a3,ca=false,ce=false;var cc,bT,at,cB,aH,a7,aK,cn;var a5=0,cE=0,bA=0,bC=0;var bR;var bs="",ax,bk=aO();aj(function(){aP(bO.value||"");
cc=false})();var a1=new j();o(bb,"mousedown",aj(b7));o(bb,"dblclick",aj(bK));o(bl,"dragstart",aA);o(bl,"selectstart",O);if(!I){o(bb,"contextmenu",aU)
}o(bb,"scroll",function(){bu=bb.scrollTop;b0([]);if(bO.fixedGutter){az.style.left=bb.scrollLeft+"px"}if(bO.onScroll){bO.onScroll(bW)}});
o(window,"resize",function(){b0(true)});o(bd,"keyup",aj(b8));o(bd,"input",aI);o(bd,"keydown",aj(bZ));o(bd,"keypress",aj(be));o(bd,"focus",cI);
o(bd,"blur",aw);o(bb,"dragenter",t);o(bb,"dragover",t);o(bb,"drop",aj(ag));o(bb,"paste",function(){bq();aI()});o(bd,"paste",aI);o(bd,"cut",aj(function(){if(!bO.readOnly){bi("")
}}));var cj;try{cj=(cz.activeElement==bd)}catch(bV){}if(cj){setTimeout(cI,20)}else{aw()}function bh(cO){return cO>=0&&cO<cl.size}var bW=av.CodeMirror={getValue:bP,setValue:aj(aP),getSelection:bQ,replaceSelection:aj(bi),focus:function(){bq();
cI();aI()},setOption:function(cP,cQ){var cO=bO[cP];bO[cP]=cQ;if(cP=="mode"||cP=="indentUnit"){bH()}else{if(cP=="readOnly"&&cQ=="nocursor"){aw();
bd.blur()}else{if(cP=="readOnly"&&!cQ){cp(true)}else{if(cP=="theme"){cq()}else{if(cP=="lineWrapping"&&cO!=cQ){aj(ct)()}else{if(cP=="tabSize"){aj(cJ)()
}}}}}}if(cP=="lineNumbers"||cP=="gutter"||cP=="firstLineNumber"||cP=="theme"){b0(true)}},getOption:function(cO){return bO[cO]},undo:aj(cH),redo:aj(cw),indentLine:aj(function(cP,cO){if(typeof cO!="string"){if(cO==null){cO=bO.smartIndent?"smart":"prev"
}else{cO=cO?"add":"subtract"}}if(bh(cP)){bp(cP,cO)}}),indentSelection:aj(co),historySize:function(){return{undo:a1.done.length,redo:a1.undone.length}
},clearHistory:function(){a1=new j()},matchBrackets:aj(function(){b1(true)}),getTokenAt:aj(function(cO){cO=aL(cO);return cs(cO.line).getTokenAt(bY,ch(cO.line),cO.ch)
}),getStateAfter:function(cO){cO=bM(cO==null?cl.size-1:cO);return ch(cO+1)},cursorCoords:function(cO){if(cO==null){cO=cL.inverted}return ah(cO?cL.from:cL.to)
},charCoords:function(cO){return ah(aL(cO))},coordsChar:function(cO){var cP=ad(bl);return bw(cO.x-cP.left,cO.y-cP.top)},markText:aj(bt),setBookmark:aM,setMarker:aj(bJ),clearMarker:aj(al),setLineClass:aj(bc),hideLine:aj(function(cO){return cx(cO,true)
}),showLine:aj(function(cO){return cx(cO,false)}),onDeleteLine:function(cO,cP){if(typeof cO=="number"){if(!bh(cO)){return null}cO=cs(cO)
}(cO.handlers||(cO.handlers=[])).push(cP);return cO},lineInfo:aN,addWidget:function(cS,cQ,cU,cR,cW){cS=cF(aL(cS));var cT=cS.yBot,cP=cS.x;
cQ.style.position="absolute";bB.appendChild(cQ);if(cR=="over"){cT=cS.y}else{if(cR=="near"){var cO=Math.max(bb.offsetHeight,cl.height*bD()),cV=Math.max(bB.clientWidth,bl.clientWidth)-aY();
if(cS.yBot+cQ.offsetHeight>cO&&cS.y>cQ.offsetHeight){cT=cS.y-cQ.offsetHeight}if(cP+cQ.offsetWidth>cV){cP=cV-cQ.offsetWidth}}}cQ.style.top=(cT+cf())+"px";
cQ.style.left=cQ.style.right="";if(cW=="right"){cP=bB.clientWidth-cQ.offsetWidth;cQ.style.right="0px"}else{if(cW=="left"){cP=0}else{if(cW=="middle"){cP=(bB.clientWidth-cQ.offsetWidth)/2
}}cQ.style.left=(cP+aY())+"px"}if(cU){ar(cP,cT,cP+cQ.offsetWidth,cT+cQ.offsetHeight)}},lineCount:function(){return cl.size},clipPos:aL,getCursor:function(cO){if(cO==null){cO=cL.inverted
}return V(cO?cL.from:cL.to)},somethingSelected:function(){return !X(cL.from,cL.to)},setCursor:aj(function(cO,cQ,cP){if(cQ==null&&typeof cO.line=="number"){aZ(cO.line,cO.ch,cP)
}else{aZ(cO,cQ,cP)}}),setSelection:aj(function(cQ,cP,cO){(cO?bo:bn)(aL(cQ),aL(cP||cQ))}),getLine:function(cO){if(bh(cO)){return cs(cO).text
}},getLineHandle:function(cO){if(bh(cO)){return cs(cO)}},setLine:aj(function(cO,cP){if(bh(cO)){bE(cP,{line:cO,ch:0},{line:cO,ch:cs(cO).text.length})
}}),removeLine:aj(function(cO){if(bh(cO)){bE("",{line:cO,ch:0},aL({line:cO+1,ch:0}))}}),replaceRange:aj(bE),getRange:function(cP,cO){return cC(aL(cP),aL(cO))
},execCommand:function(cO){return G[cO](bW)},moveH:aj(cr),deleteH:aj(b9),moveV:aj(ck),toggleOverwrite:function(){ca=!ca},posFromIndex:function(cP){var cQ=0,cO;
cl.iter(0,cl.size,function(cR){var cS=cR.text.length+1;if(cS>cP){cO=cP;return true}cP-=cS;++cQ});return aL({line:cQ,ch:cO})},indexFromPos:function(cP){if(cP.line<0||cP.ch<0){return 0
}var cO=cP.ch;cl.iter(0,cP.line,function(cQ){cO+=cQ.text.length+1});return cO},scrollTo:function(cO,cP){if(cO!=null){bb.scrollTop=cO}if(cP!=null){bb.scrollLeft=cP
}b0([])},operation:function(cO){return aj(cO)()},refresh:function(){b0(true);if(bb.scrollHeight>bu){bb.scrollTop=bu}},getInputField:function(){return bd
},getWrapperElement:function(){return av},getScrollerElement:function(){return bb},getGutterElement:function(){return az}};function cs(cO){return y(cl,cO)
}function aW(cP,cO){aK=true;var cQ=cO-cP.height;for(var cR=cP;cR;cR=cR.parent){cR.height+=cQ}}function aP(cO){var cP={line:0,ch:0};aG(cP,{line:cl.size-1,ch:cs(cl.size-1).text.length},x(cO),cP,cP);
cc=true}function bP(cO){var cP=[];cl.iter(0,cl.size,function(cQ){cP.push(cQ.text)});return cP.join("\n")}function b7(cU){aX(v(cU,"shiftKey"));
for(var cR=h(cU);cR!=av;cR=cR.parentNode){if(cR.parentNode==bB&&cR!=b3){return}}for(var cR=h(cU);cR!=av;cR=cR.parentNode){if(cR.parentNode==aR){if(bO.onGutterClick){bO.onGutterClick(bW,n(aR.childNodes,cR)+cE,cU)
}return O(cU)}}var cO=aV(cU);switch(u(cU)){case 3:if(I&&!H){aU(cU)}return;case 2:if(cO){aZ(cO.line,cO.ch,true)}return}if(!cO){if(h(cU)==bb){O(cU)
}return}if(!b6){cI()}var cP=+new Date;if(aS&&aS.time>cP-400&&X(aS.pos,cO)){O(cU);setTimeout(bq,20);return aC(cO.line)}else{if(bg&&bg.time>cP-400&&X(bg.pos,cO)){aS={time:cP,pos:cO};
O(cU);return bx(cO)}else{bg={time:cP,pos:cO}}}var cW=cO,cQ;if(A&&!bO.readOnly&&!X(cL.from,cL.to)&&!U(cO,cL.from)&&!U(cL.to,cO)){if(e){bl.draggable=true
}var cT=o(cz,"mouseup",aj(function(cX){if(e){bl.draggable=false}a3=false;cT();if(Math.abs(cU.clientX-cX.clientX)+Math.abs(cU.clientY-cX.clientY)<10){O(cX);
aZ(cO.line,cO.ch,true);bq()}}),true);a3=true;return}O(cU);aZ(cO.line,cO.ch,true);function cV(cX){var cZ=aV(cX,true);if(cZ&&!X(cZ,cW)){if(!b6){cI()
}cW=cZ;bo(cO,cZ);cc=false;var cY=br();if(cZ.line>=cY.to||cZ.line<cY.from){cQ=setTimeout(aj(function(){cV(cX)}),150)}}}var cS=o(cz,"mousemove",aj(function(cX){clearTimeout(cQ);
O(cX);cV(cX)}),true);var cT=o(cz,"mouseup",aj(function(cX){clearTimeout(cQ);var cY=aV(cX);if(cY){bo(cO,cY)}O(cX);bq();cc=true;cS();cT()
}),true)}function bK(cO){for(var cQ=h(cO);cQ!=av;cQ=cQ.parentNode){if(cQ.parentNode==aR){return O(cO)}}var cP=aV(cO);if(!cP){return}aS={time:+new Date,pos:cP};
O(cO);bx(cP)}function ag(cU){cU.preventDefault();var cV=aV(cU,true),cO=cU.dataTransfer.files;if(!cV||bO.readOnly){return}if(cO&&cO.length&&window.FileReader&&window.File){function cR(c0,cZ){var cY=new FileReader;
cY.onload=function(){cX[cZ]=cY.result;if(++cP==cQ){cV=aL(cV);aj(function(){var c1=bE(cX.join(""),cV,cV);bo(cV,c1)})()}};cY.readAsText(c0)
}var cQ=cO.length,cX=Array(cQ),cP=0;for(var cS=0;cS<cQ;++cS){cR(cO[cS],cS)}}else{try{var cX=cU.dataTransfer.getData("Text");if(cX){var cW=cL.from,cT=cL.to;
bo(cV,cV);if(a3){bE("",cW,cT)}bi(cX);bq()}}catch(cU){}}}function aA(cP){var cO=bQ();K(cO);cP.dataTransfer.setDragImage(ab,0,0);cP.dataTransfer.setData("Text",cO)
}function cy(cU){var cR=M[v(cU,"keyCode")],cT=s[bO.keyMap].auto,cS,cO;function cQ(){return cT.call?cT.call(null,bW):cT}if(cR==null||cU.altGraphKey){if(cT){bO.keyMap=cQ()
}return null}if(v(cU,"altKey")){cR="Alt-"+cR}if(v(cU,"ctrlKey")){cR="Ctrl-"+cR}if(v(cU,"metaKey")){cR="Cmd-"+cR}if(v(cU,"shiftKey")&&(cS=k("Shift-"+cR,bO.extraKeys,bO.keyMap))){cO=true
}else{cS=k(cR,bO.extraKeys,bO.keyMap)}if(typeof cS=="string"){if(G.propertyIsEnumerable(cS)){cS=G[cS]}else{cS=null}}if(cT&&(cS||!L(cU))){bO.keyMap=cQ()
}if(!cS){return false}var cP=b5;try{if(bO.readOnly){ce=true}if(cO){b5=null}cS(bW)}finally{b5=cP;ce=false}O(cU);return true}var cv=null;
function bZ(cQ){if(!b6){cI()}if(D&&cQ.keyCode==27){cQ.returnValue=false}if(bO.onKeyEvent&&bO.onKeyEvent(bW,J(cQ))){return}var cO=v(cQ,"keyCode");
aX(cO==16||v(cQ,"shiftKey"));var cP=cy(cQ);if(window.opera){cv=cP?cO:null;if(!cP&&cO==88&&v(cQ,H?"metaKey":"ctrlKey")){bi("")}}}function be(cR){var cQ=v(cR,"keyCode"),cO=v(cR,"charCode");
if(window.opera&&cQ==cv){cv=null;O(cR);return}if(bO.onKeyEvent&&bO.onKeyEvent(bW,J(cR))){return}if(window.opera&&!cR.which&&cy(cR)){return
}if(bO.electricChars&&bY.electricChars&&bO.smartIndent&&!bO.readOnly){var cP=String.fromCharCode(cO==null?cQ:cO);if(bY.electricChars.indexOf(cP)>-1){setTimeout(aj(function(){bp(cL.to.line,"smart")
}),75)}}aI()}function b8(cO){if(bO.onKeyEvent&&bO.onKeyEvent(bW,J(cO))){return}if(v(cO,"keyCode")==16){b5=null}}function cI(){if(bO.readOnly=="nocursor"){return
}if(!b6){if(bO.onFocus){bO.onFocus(bW)}b6=true;if(av.className.search(/\bCodeMirror-focused\b/)==-1){av.className+=" CodeMirror-focused"
}if(!a7){cp(true)}}af();cA()}function aw(){if(b6){if(bO.onBlur){bO.onBlur(bW)}b6=false;if(bR){aj(function(){if(bR){bR();bR=null}})()}av.className=av.className.replace(" CodeMirror-focused","")
}clearInterval(cD);setTimeout(function(){if(!b6){b5=null}},150)}function aG(cT,cS,cR,cP,cO){if(ce){return}if(a1){var cQ=[];cl.iter(cT.line,cS.line+1,function(cU){cQ.push(cU.text)
});a1.addChange(cT.line,cR.length,cQ);while(a1.done.length>bO.undoDepth){a1.done.shift()}}ak(cT,cS,cR,cP,cO)}function bX(cW,cX,cO){var cY=cW.pop(),cS=cY?cY.length:0,cQ=[];
for(var cR=cO>0?0:cS-1,cT=cO>0?cS:-1;cR!=cT;cR+=cO){var cV=cY[cR];var cZ=[],cP=cV.start+cV.added;cl.iter(cV.start,cP,function(c0){cZ.push(c0.text)
});cQ.push({start:cV.start,added:cV.old.length,old:cZ});var cU=aL({line:cV.start+cV.old.length-1,ch:R(cZ[cZ.length-1],cV.old[cV.old.length-1])});
ak({line:cV.start,ch:0},{line:cP-1,ch:cs(cP-1).text.length},cV.old,cU,cU)}cc=true;cX.push(cQ)}function cH(){Action.undo()}function cw(){Action.redo()
}function ak(c3,cS,c9,cO,da){if(ce){return}var c8=false,cR=bs.length;if(!bO.lineWrapping){cl.iter(c3.line,cS.line,function(db){if(db.text.length==cR){c8=true;
return true}})}if(c3.line!=cS.line||c9.length>1){aK=true}var c0=cS.line-c3.line,cZ=cs(c3.line),cP=cs(cS.line);if(c3.ch==0&&cS.ch==0&&c9[c9.length-1]==""){var cX=[],cY=null;
if(c3.line){cY=cs(c3.line-1);cY.fixMarkEnds(cP)}else{cP.fixMarkStarts()}for(var c5=0,c7=c9.length-1;c5<c7;++c5){cX.push(d.inheritMarks(c9[c5],cY))
}if(c0){cl.remove(c3.line,c0,cn)}if(cX.length){cl.insert(c3.line,cX)}}else{if(cZ==cP){if(c9.length==1){cZ.replace(c3.ch,cS.ch,c9[0])}else{cP=cZ.split(cS.ch,c9[c9.length-1]);
cZ.replace(c3.ch,null,c9[0]);cZ.fixMarkEnds(cP);var cX=[];for(var c5=1,c7=c9.length-1;c5<c7;++c5){cX.push(d.inheritMarks(c9[c5],cZ))}cX.push(cP);
cl.insert(c3.line+1,cX)}}else{if(c9.length==1){cZ.replace(c3.ch,null,c9[0]);cP.replace(null,cS.ch,"");cZ.append(cP);cl.remove(c3.line+1,c0,cn)
}else{var cX=[];cZ.replace(c3.ch,null,c9[0]);cP.replace(null,cS.ch,c9[c9.length-1]);cZ.fixMarkEnds(cP);for(var c5=1,c7=c9.length-1;c5<c7;
++c5){cX.push(d.inheritMarks(c9[c5],cZ))}if(c0>1){cl.remove(c3.line+1,c0-1,cn)}cl.insert(c3.line+1,cX)}}}if(bO.lineWrapping){var cU=bb.clientWidth/a9()-3;
cl.iter(c3.line,c3.line+c9.length,function(db){if(db.hidden){return}var dc=Math.ceil(db.text.length/cU)||1;if(dc!=db.height){aW(db,dc)
}})}else{cl.iter(c3.line,c5+c9.length,function(dc){var db=dc.text;if(db.length>cR){bs=db;cR=db.length;ax=null;c8=false}});if(c8){cR=0;
bs="";ax=null;cl.iter(0,cl.size,function(dc){var db=dc.text;if(db.length>cR){cR=db.length;bs=db}})}}var cQ=[],cW=c9.length-c0-1;for(var c5=0,c2=b4.length;
c5<c2;++c5){var c6=b4[c5];if(c6<c3.line){cQ.push(c6)}else{if(c6>cS.line){cQ.push(c6+cW)}}}var c4=c3.line+Math.min(c9.length,500);cu(c3.line,c4);
cQ.push(c4);b4=cQ;bv(100);at.push({from:c3.line,to:cS.line+1,diff:cW});var cV={from:c3,to:cS,text:c9};if(cB){for(var cT=cB;cT.next;cT=cT.next){}cT.next=cV
}else{cB=cV}function c1(db){return db<=Math.min(cS.line,cS.line+cW)?db:db+cW}bn(cO,da,c1(cL.from.line),c1(cL.to.line));if(bb.clientHeight){bB.style.height=(cl.height*bD()+2*cf())+"px"
}}function bE(cP,cS,cR){cS=aL(cS);if(!cR){cR=cS}else{cR=aL(cR)}cP=x(cP);function cQ(cV){if(U(cV,cS)){return cV}if(!U(cR,cV)){return cO
}var cT=cV.line+cP.length-(cR.line-cS.line)-1;var cU=cV.ch;if(cV.line==cR.line){cU+=cP[cP.length-1].length-(cR.ch-(cR.line==cS.line?cS.ch:0))
}return{line:cT,ch:cU}}var cO;au(cP,cS,cR,function(cT){cO=cT;return{from:cQ(cL.from),to:cQ(cL.to)}});return cO}function bi(cO,cP){au(x(cO),cL.from,cL.to,function(cQ){if(cP=="end"){return{from:cQ,to:cQ}
}else{if(cP=="start"){return{from:cL.from,to:cL.from}}else{return{from:cL.from,to:cQ}}}})}function au(cR,cT,cS,cO){var cQ=cR.length==1?cR[0].length+cT.ch:cR[cR.length-1].length;
var cP=cO({line:cT.line+cR.length-1,ch:cQ});aG(cT,cS,cR,cP.from,cP.to)}function cC(cS,cR){var cP=cS.line,cO=cR.line;if(cP==cO){return cs(cP).text.slice(cS.ch,cR.ch)
}var cQ=[cs(cP).text.slice(cS.ch)];cl.iter(cP+1,cO,function(cT){cQ.push(cT.text)});cQ.push(cs(cO).text.slice(0,cR.ch));return cQ.join("\n")
}function bQ(){return cC(cL.from,cL.to)}var bj=false;function af(){if(bj){return}bU.set(bO.pollInterval,function(){aF();bz();if(b6){af()
}ap()})}function aI(){var cO=false;bj=true;function cP(){aF();var cQ=bz();if(!cQ&&!cO){cO=true;bU.set(60,cP)}else{bj=false;af()}ap()}bU.set(20,cP)
}var a2="";function bz(){if(a7||!b6||Y(bd)||bO.readOnly){return false}var cP=bd.value;if(cP==a2){return false}b5=null;var cQ=0,cO=Math.min(a2.length,cP.length);
while(cQ<cO&&a2[cQ]==cP[cQ]){++cQ}if(cQ<a2.length){cL.from={line:cL.from.line,ch:cL.from.ch-(a2.length-cQ)}}else{if(ca&&X(cL.from,cL.to)){cL.to={line:cL.to.line,ch:Math.min(cs(cL.to.line).text.length,cL.to.ch+(cP.length-cQ))}
}}bi(cP.slice(cQ),"end");a2=cP;return true}function cp(cO){if(!X(cL.from,cL.to)){a2="";bd.value=bQ();bd.select()}else{if(cO){a2=bd.value=""
}}}function bq(){if(bO.readOnly!="nocursor"){bd.focus()}}function cN(){if(!a4.getBoundingClientRect){return}var cO=a4.getBoundingClientRect();
if(D&&cO.top==cO.bottom){return}var cP=window.innerHeight||Math.max(document.body.offsetHeight,document.documentElement.offsetHeight);
if(cO.top<0||cO.bottom>cP){a4.scrollIntoView()}}function b2(){var cP=cF(cL.inverted?cL.from:cL.to);var cO=bO.lineWrapping?Math.min(cP.x,bl.offsetWidth):cP.x;
return ar(cO,cP.y,cO,cP.yBot)}function ar(cQ,cV,cO,cU){var cS=aY(),c1=cf(),cX=bD();cV+=c1;cU+=c1;cQ+=cS;cO+=cS;var cY=bb.clientHeight,cR=bb.scrollTop,cP=false,c0=true;
if(cV<cR){bb.scrollTop=Math.max(0,cV-2*cX);cP=true}else{if(cU>cR+cY){bb.scrollTop=cU+cX-cY;cP=true}}var cW=bb.clientWidth,cZ=bb.scrollLeft;
var cT=bO.fixedGutter?az.clientWidth:0;if(cQ<cZ+cT){if(cQ<50){cQ=0}bb.scrollLeft=Math.max(0,cQ-10-cT);cP=true}else{if(cO>cW+cZ-3){bb.scrollLeft=cO+10-cW;
cP=true;if(cO>bB.clientWidth){c0=false}}}if(cP&&bO.onScroll){bO.onScroll(bW)}return c0}function br(){var cP=bD(),cR=bb.scrollTop-cf();
var cO=Math.max(0,Math.floor(cR/cP));var cQ=Math.ceil((cR+bb.clientHeight)/cP);return{from:S(cl,cO),to:S(cl,cQ)}}function b0(cY,cT){if(!bb.clientWidth){cE=bA=a5=0;
return}var cR=br();if(cY!==true&&cY.length==0&&cR.from>cE&&cR.to<bA){return}var cZ=Math.max(cR.from-100,0),c0=Math.min(cl.size,cR.to+100);
if(cE<cZ&&cZ-cE<20){cZ=cE}if(bA>c0&&bA-c0<20){c0=Math.min(cl.size,bA)}var c1=cY===true?[]:bN([{from:cE,to:bA,domStart:0}],cY);var cX=0;
for(var cU=0;cU<c1.length;++cU){var cV=c1[cU];if(cV.from<cZ){cV.domStart+=(cZ-cV.from);cV.from=cZ}if(cV.to>c0){cV.to=c0}if(cV.from>=cV.to){c1.splice(cU--,1)
}else{cX+=cV.to-cV.from}}if(cX==c0-cZ){return}c1.sort(function(c3,c2){return c3.domStart-c2.domStart});var cQ=bD(),cO=az.style.display;
ai.style.display="none";aJ(cZ,c0,c1);ai.style.display=az.style.display="";var cP=cZ!=cE||c0!=bA||bC!=bb.clientHeight+cQ;if(cP){bC=bb.clientHeight+cQ
}cE=cZ;bA=c0;a5=f(cl,cZ);b3.style.top=(a5*cQ)+"px";if(bb.clientHeight){bB.style.height=(cl.height*cQ+2*cf())+"px"}if(ai.childNodes.length!=bA-cE){throw new Error("BAD PATCH! "+JSON.stringify(c1)+" size="+(bA-cE)+" nodes="+ai.childNodes.length)
}if(bO.lineWrapping){ax=bb.clientWidth;var cS=ai.firstChild,cW=false;cl.iter(cE,bA,function(c3){if(!c3.hidden){var c2=Math.round(cS.offsetHeight/cQ)||1;
if(c3.height!=c2){aW(c3,c2);aK=cW=true}}cS=cS.nextSibling});if(cW){bB.style.height=(cl.height*cQ+2*cf())+"px"}}else{if(ax==null){ax=cg(bs)
}if(ax>bb.clientWidth){bl.style.width=ax+"px";bB.style.width="";bB.style.width=bb.scrollWidth+"px"}else{bl.style.width=bB.style.width=""
}}az.style.display=cO;if(cP||aK){aD()}cK();if(!cT&&bO.onUpdate){bO.onUpdate(bW)}return true}function bN(cX,cV){for(var cS=0,cQ=cV.length||0;
cS<cQ;++cS){var cU=cV[cS],cO=[],cW=cU.diff||0;for(var cR=0,cP=cX.length;cR<cP;++cR){var cT=cX[cR];if(cU.to<=cT.from&&cU.diff){cO.push({from:cT.from+cW,to:cT.to+cW,domStart:cT.domStart})
}else{if(cU.to<=cT.from||cU.from>=cT.to){cO.push(cT)}else{if(cU.from>cT.from){cO.push({from:cT.from,to:cU.from,domStart:cT.domStart})
}if(cU.to<cT.to){cO.push({from:cU.to+cW,to:cT.to+cW,domStart:cT.domStart+(cU.to-cT.from)})}}}}cX=cO}return cX}function aJ(cY,cZ,c1){if(!c1.length){ai.innerHTML=""
}else{function cO(c3){var c2=c3.nextSibling;c3.parentNode.removeChild(c3);return c2}var cT=0,cR=ai.firstChild,cP;for(var cU=0;cU<c1.length;
++cU){var c0=c1[cU];while(c0.domStart>cT){cR=cO(cR);cT++}for(var cS=0,cW=c0.to-c0.from;cS<cW;++cS){cR=cR.nextSibling;cT++}}while(cR){cR=cO(cR)
}}var cV=c1.shift(),cR=ai.firstChild,cS=cY;var cX=cz.createElement("div"),cQ;cl.iter(cY,cZ,function(c2){if(cV&&cV.to==cS){cV=c1.shift()
}if(!cV||cV.from>cS){if(c2.hidden){var c3=cX.innerHTML="<pre></pre>"}else{var c3="<pre>"+c2.getHTML(bk)+"</pre>";if(c2.className){c3='<div style="position: relative"><pre class="'+c2.className+'" style="position: absolute; left: 0; right: 0; top: 0; bottom: 0; z-index: -2">&#160;</pre>'+c3+"</div>"
}}cX.innerHTML=c3;ai.insertBefore(cX.firstChild,cR)}else{cR=cR.nextSibling}++cS})}function aD(){if(!bO.gutter&&!bO.lineNumbers){return
}var cO=b3.offsetHeight,cV=bb.clientHeight;az.style.height=(cO-cV<2?cV:cO)+"px";var cQ=[],cP=cE;cl.iter(cE,Math.max(bA,cE+1),function(cX){if(cX.hidden){cQ.push("<pre></pre>")
}else{var cW=cX.gutterMarker;var cZ=bO.lineNumbers?cP+bO.firstLineNumber:null;if(cW&&cW.text){cZ=cW.text.replace("%N%",cZ!=null?cZ:"")
}else{if(cZ==null){cZ="\u00a0"}}cQ.push((cW&&cW.style?'<pre class="'+cW.style+'">':"<pre>"),cZ);for(var cY=1;cY<cX.height;++cY){cQ.push("<br/>&#160;")
}cQ.push("</pre>")}++cP});az.style.display="none";aR.innerHTML=cQ.join("");var cU=String(cl.size).length,cS=aR.firstChild,cT=C(cS),cR="";
while(cT.length+cR.length<cU){cR+="\u00a0"}if(cR){cS.insertBefore(cz.createTextNode(cR),cS.firstChild)}az.style.display="";bl.style.marginLeft=az.offsetWidth+"px";
aK=false}function cK(){var cR=X(cL.from,cL.to);var c0=cF(cL.from,true);var cW=cR?c0:cF(cL.to,true);var cU=cL.inverted?c0:cW,cP=bD();var cO=ad(av),cQ=ad(ai);
bL.style.top=Math.max(0,Math.min(bb.offsetHeight,cU.y+cQ.top-cO.top))+"px";bL.style.left=Math.max(0,Math.min(bb.offsetWidth,cU.x+cQ.left-cO.left))+"px";
if(cR){a4.style.top=cU.y+"px";a4.style.left=(bO.lineWrapping?Math.min(cU.x,bl.offsetWidth):cU.x)+"px";a4.style.display="";a8.style.display="none"
}else{var cY=c0.y==cW.y,cT="";function cZ(c4,c3,c2,c1){cT+='<div class="CodeMirror-selected" style="position: absolute; left: '+c4+"px; top: "+c3+"px; right: "+c2+"px; height: "+c1+'px"></div>'
}if(cL.from.ch&&c0.y>=0){var cX=cY?bl.clientWidth-cW.x:0;cZ(c0.x,c0.y,cX,cP)}var cS=Math.max(0,c0.y+(cL.from.ch?cP:0));var cV=Math.min(cW.y,bl.clientHeight)-cS;
if(cV>0.2*cP){cZ(0,cS,0,cV)}if((!cY||!cL.from.ch)&&cW.y<bl.clientHeight-0.5*cP){cZ(0,cW.y,bl.clientWidth-cW.x,cP)}a8.innerHTML=cT;a4.style.display="none";
a8.style.display=""}}function aX(cO){if(cO){b5=b5||(cL.inverted?cL.to:cL.from)}else{b5=null}}function bo(cQ,cP){var cO=b5&&aL(b5);if(cO){if(U(cO,cQ)){cQ=cO
}else{if(U(cP,cO)){cP=cO}}}bn(cQ,cP);bT=true}function bn(cS,cR,cO,cQ){ci=null;if(cO==null){cO=cL.from.line;cQ=cL.to.line}if(X(cL.from,cS)&&X(cL.to,cR)){return
}if(U(cR,cS)){var cP=cR;cR=cS;cS=cP}if(cS.line!=cO){cS=bF(cS,cO,cL.from.ch)}if(cR.line!=cQ){cR=bF(cR,cQ,cL.to.ch)}if(X(cS,cR)){cL.inverted=false
}else{if(X(cS,cL.to)){cL.inverted=false}else{if(X(cR,cL.from)){cL.inverted=true}}}cL.from=cS;cL.to=cR;aH=true}function bF(cS,cP,cQ){function cR(cV){var cX=cS.line+cV,cU=cV==1?cl.size:-1;
while(cX!=cU){var cT=cs(cX);if(!cT.hidden){var cW=cS.ch;if(cW>cQ||cW>cT.text.length){cW=cT.text.length}return{line:cX,ch:cW}}cX+=cV}}var cO=cs(cS.line);
if(!cO.hidden){return cS}if(cS.line>=cP){return cR(1)||cR(-1)}else{return cR(-1)||cR(1)}}function aZ(cO,cQ,cP){var cR=aL({line:cO,ch:cQ||0});
(cP?bo:bn)(cR,cR)}function bM(cO){return Math.max(0,Math.min(cO,cl.size-1))}function aL(cQ){if(cQ.line<0){return{line:0,ch:0}}if(cQ.line>=cl.size){return{line:cl.size-1,ch:cs(cl.size-1).text.length}
}var cO=cQ.ch,cP=cs(cQ.line).text.length;if(cO==null||cO>cP){return{line:cQ.line,ch:cP}}else{if(cO<0){return{line:cQ.line,ch:0}}else{return cQ
}}}function cb(cR,cV){var cS=cL.inverted?cL.from:cL.to,cW=cS.line,cO=cS.ch;var cU=cs(cW);function cP(){for(var cX=cW+cR,cZ=cR<0?-1:cl.size;
cX!=cZ;cX+=cR){var cY=cs(cX);if(!cY.hidden){cW=cX;cU=cY;return true}}}function cT(cX){if(cO==(cR<0?0:cU.text.length)){if(!cX&&cP()){cO=cR<0?cU.text.length:0
}else{return false}}else{cO+=cR}return true}if(cV=="char"){cT()}else{if(cV=="column"){cT(true)}else{if(cV=="word"){var cQ=false;for(;
;){if(cR<0){if(!cT()){break}}if(Z(cU.text.charAt(cO))){cQ=true}else{if(cQ){if(cR<0){cR=1;cT()}break}}if(cR>0){if(!cT()){break}}}}}}return{line:cW,ch:cO}
}function cr(cO,cP){var cQ=cO<0?cL.from:cL.to;if(b5||X(cL.from,cL.to)){cQ=cb(cO,cP)}aZ(cQ.line,cQ.ch,true)}function b9(cO,cP){if(!X(cL.from,cL.to)){bE("",cL.from,cL.to)
}else{if(cO<0){bE("",cb(cO,cP),cL.to)}else{bE("",cL.from,cb(cO,cP))}}bT=true}var ci=null;function ck(cO,cP){var cR=0,cS=cF(cL.inverted?cL.from:cL.to,true);
if(ci!=null){cS.x=ci}if(cP=="page"){cR=Math.min(bb.clientHeight,window.innerHeight||document.documentElement.clientHeight)}else{if(cP=="line"){cR=bD()
}}var cQ=bw(cS.x,cS.y+cR*cO+2);aZ(cQ.line,cQ.ch,true);ci=cS.x}function bx(cR){var cP=cs(cR.line).text;var cQ=cR.ch,cO=cR.ch;while(cQ>0&&Z(cP.charAt(cQ-1))){--cQ
}while(cO<cP.length&&Z(cP.charAt(cO))){++cO}bo({line:cR.line,ch:cQ},{line:cR.line,ch:cO})}function aC(cO){bo({line:cO,ch:0},{line:cO,ch:cs(cO).text.length})
}function co(cQ){if(X(cL.from,cL.to)){return bp(cL.from.line,cQ)}var cP=cL.to.line-(cL.to.ch?0:1);for(var cO=cL.from.line;cO<=cP;++cO){bp(cO,cQ)
}}function bp(cQ,cX){if(!cX){cX="add"}if(cX=="smart"){if(!bY.indent){cX="prev"}else{var cO=ch(cQ)}}var cY=cs(cQ),cS=cY.indentation(bO.tabSize),cP=cY.text.match(/^\s*/)[0],cU;
if(cX=="prev"){if(cQ){cU=cs(cQ-1).indentation(bO.tabSize)}else{cU=0}}else{if(cX=="smart"){cU=bY.indent(cO,cY.text.slice(cP.length),cY.text)
}else{if(cX=="add"){cU=cS+bO.indentUnit}else{if(cX=="subtract"){cU=cS-bO.indentUnit}}}}cU=Math.max(0,cU);var cW=cU-cS;if(!cW){if(cL.from.line!=cQ&&cL.to.line!=cQ){return
}var cV=cP}else{var cV="",cT=0;if(bO.indentWithTabs){for(var cR=Math.floor(cU/bO.tabSize);cR;--cR){cT+=bO.tabSize;cV+="\t"}}while(cT<cU){++cT;
cV+=" "}}bE(cV,{line:cQ,ch:0},{line:cQ,ch:cP.length})}function bH(){bY=r.getMode(bO,bO.mode);cl.iter(0,cl.size,function(cO){cO.stateAfter=null
});b4=[0];bv()}function a6(){var cO=bO.gutter||bO.lineNumbers;az.style.display=cO?"":"none";if(cO){aK=true}else{ai.parentNode.style.marginLeft=0
}}function ct(cQ,cP){if(bO.lineWrapping){av.className+=" CodeMirror-wrap";var cO=bb.clientWidth/a9()-3;cl.iter(0,cl.size,function(cR){if(cR.hidden){return
}var cS=Math.ceil(cR.text.length/cO)||1;if(cS!=1){aW(cR,cS)}});bl.style.width=bB.style.width=""}else{av.className=av.className.replace(" CodeMirror-wrap","");
ax=null;bs="";cl.iter(0,cl.size,function(cR){if(cR.height!=1&&!cR.hidden){aW(cR,1)}if(cR.text.length>bs.length){bs=cR.text}})}at.push({from:0,to:cl.size})
}function aO(){for(var cP='<span class="cm-tab">',cO=0;cO<bO.tabSize;++cO){cP+=" "}return cP+"</span>"}function cJ(){bk=aO();b0(true)
}function cq(){bb.className=bb.className.replace(/\s*cm-s-\w+/g,"")+bO.theme.replace(/(^|\s)\s*/g," cm-s-")}function cM(){this.set=[]
}cM.prototype.clear=aj(function(){var cT=Infinity,cP=-Infinity;for(var cS=0,cV=this.set.length;cS<cV;++cS){var cQ=this.set[cS],cO=cQ.marked;
if(!cO||!cQ.parent){continue}var cU=T(cQ);cT=Math.min(cT,cU);cP=Math.max(cP,cU);for(var cR=0;cR<cO.length;++cR){if(cO[cR].set==this.set){cO.splice(cR--,1)
}}}if(cT!=Infinity){at.push({from:cT,to:cP+1})}});cM.prototype.find=function(){var cT,cU;for(var cQ=0,cS=this.set.length;cQ<cS;++cQ){var cW=this.set[cQ],cR=cW.marked;
for(var cP=0;cP<cR.length;++cP){var cO=cR[cP];if(cO.set==this.set){if(cO.from!=null||cO.to!=null){var cV=T(cW);if(cV!=null){if(cO.from!=null){cT={line:cV,ch:cO.from}
}if(cO.to!=null){cU={line:cV,ch:cO.to}}}}}}}return{from:cT,to:cU}};function bt(cU,cT,cQ){cU=aL(cU);cT=aL(cT);var cO=new cM();function cS(cV,cY,cX,cW){cs(cV).addMark(new F(cY,cX,cW,cO.set))
}if(cU.line==cT.line){cS(cU.line,cU.ch,cT.ch,cQ)}else{cS(cU.line,cU.ch,null,cQ);for(var cP=cU.line+1,cR=cT.line;cP<cR;++cP){cS(cP,null,null,cQ)
}cS(cT.line,null,cT.ch,cQ)}at.push({from:cU.line,to:cT.line+1});return cO}function aM(cP){cP=aL(cP);var cO=new B(cP.ch);cs(cP.line).addMark(cO);
return cO}function bJ(cO,cQ,cP){if(typeof cO=="number"){cO=cs(bM(cO))}cO.gutterMarker={text:cQ,style:cP};aK=true;return cO}function al(cO){if(typeof cO=="number"){cO=cs(bM(cO))
}cO.gutterMarker=null;aK=true}function aQ(cP,cR){var cQ=cP,cO=cP;if(typeof cP=="number"){cO=cs(bM(cP))}else{cQ=T(cP)}if(cQ==null){return null
}if(cR(cO,cQ)){at.push({from:cQ,to:cQ+1})}else{return null}return cO}function bc(cP,cO){return aQ(cP,function(cQ){if(cQ.className!=cO){cQ.className=cO;
return true}})}function cx(cP,cO){return aQ(cP,function(cQ,cT){if(cQ.hidden!=cO){cQ.hidden=cO;aW(cQ,cO?0:1);var cS=cL.from.line,cR=cL.to.line;
if(cO&&(cS==cT||cR==cT)){var cV=cS==cT?bF({line:cS,ch:0},cS,0):cL.from;var cU=cR==cT?bF({line:cR,ch:0},cR,0):cL.to;bn(cV,cU)}return(aK=true)
}})}function aN(cP){if(typeof cP=="number"){if(!bh(cP)){return null}var cQ=cP;cP=cs(cP);if(!cP){return null}}else{var cQ=T(cP);if(cQ==null){return null
}}var cO=cP.gutterMarker;return{line:cQ,handle:cP,text:cP.text,markerText:cO&&cO.text,markerClass:cO&&cO.style,lineClass:cP.className}
}function cg(cO){am.innerHTML="<pre><span>x</span></pre>";am.firstChild.firstChild.firstChild.nodeValue=cO;return am.firstChild.firstChild.offsetWidth||10
}function ay(c0,cU){if(cU<=0){return 0}var cR=cs(c0),cX=cR.text;function cY(c1){am.innerHTML="<pre><span>"+cR.getHTML(bk,c1)+"</span></pre>";
return am.firstChild.firstChild.offsetWidth}var cV=0,cT=0,cW=cX.length,cS;var cP=Math.min(cW,Math.ceil(cU/a9()));for(;;){var cQ=cY(cP);
if(cQ<=cU&&cP<cW){cP=Math.min(cW,Math.ceil(cP*1.2))}else{cS=cQ;cW=cP;break}}if(cU>cS){return cW}cP=Math.floor(cW*0.8);cQ=cY(cP);if(cQ<cU){cV=cP;
cT=cQ}for(;;){if(cW-cV<=1){return(cS-cU>cU-cT)?cV:cW}var cZ=Math.ceil((cV+cW)/2),cO=cY(cZ);if(cO>cU){cW=cZ;cS=cO}else{cV=cZ;cT=cO}}}var cm=Math.floor(Math.random()*16777215).toString(16);
function bS(cQ,cT){if(cT==0){return{top:0,left:0}}var cO="";if(bO.lineWrapping){var cP=cQ.text.indexOf(" ",cT+2);cO=K(cQ.text.slice(cT+1,cP<0?cQ.text.length:cP+(D?5:0)))
}am.innerHTML="<pre>"+cQ.getHTML(bk,cT)+'<span id="CodeMirror-temp-'+cm+'">'+K(cQ.text.charAt(cT)||" ")+"</span>"+cO+"</pre>";var cS=document.getElementById("CodeMirror-temp-"+cm);
var cV=cS.offsetTop,cU=cS.offsetLeft;if(D&&cV==0&&cU==0){var cR=document.createElement("span");cR.innerHTML="x";cS.parentNode.insertBefore(cR,cS.nextSibling);
cV=cR.offsetTop}return{top:cV,left:cU}}function cF(cT,cR){var cO,cP=bD(),cS=cP*(f(cl,cT.line)-(cR?a5:0));if(cT.ch==0){cO=0}else{var cQ=bS(cs(cT.line),cT.ch);
cO=cQ.left;if(bO.lineWrapping){cS+=Math.max(0,cQ.top)}}return{x:cO,y:cS,yBot:cS+cP}}function bw(cX,cW){if(cW<0){cW=0}var cU=bD(),cS=a9(),c3=a5+Math.floor(cW/cU);
var cY=S(cl,c3);if(cY>=cl.size){return{line:cl.size-1,ch:cs(cl.size-1).text.length}}var cP=cs(cY),c0=cP.text;var c5=bO.lineWrapping,cV=c5?c3-f(cl,cY):0;
if(cX<=0&&cV==0){return{line:cY,ch:0}}function c4(c7){var c8=bS(cP,c7);if(c5){var c9=Math.round(c8.top/cU);return Math.max(0,c8.left+(c9-cV)*bb.clientWidth)
}return c8.left}var c2=0,c1=0,cQ=c0.length,cO;var cZ=Math.min(cQ,Math.ceil((cX+cV*bb.clientWidth*0.9)/cS));for(;;){var cT=c4(cZ);if(cT<=cX&&cZ<cQ){cZ=Math.min(cQ,Math.ceil(cZ*1.2))
}else{cO=cT;cQ=cZ;break}}if(cX>cO){return{line:cY,ch:cQ}}cZ=Math.floor(cQ*0.8);cT=c4(cZ);if(cT<cX){c2=cZ;c1=cT}for(;;){if(cQ-c2<=1){return{line:cY,ch:(cO-cX>cX-c1)?c2:cQ}
}var c6=Math.ceil((c2+cQ)/2),cR=c4(c6);if(cR>cX){cQ=c6;cO=cR}else{c2=c6;c1=cR}}}function ah(cQ){var cO=cF(cQ,true),cP=ad(bl);return{x:cP.left+cO.x,y:cP.top+cO.y,yBot:cP.top+cO.yBot}
}var aT,ao,bI;function bD(){if(bI==null){bI="<pre>";for(var cP=0;cP<49;++cP){bI+="x<br/>"}bI+="x</pre>"}var cO=ai.clientHeight;if(cO==ao){return aT
}ao=cO;am.innerHTML=bI;aT=am.firstChild.offsetHeight/50||1;am.innerHTML="";return aT}var cG,bm=0;function a9(){if(bb.clientWidth==bm){return cG
}bm=bb.clientWidth;return(cG=cg("x"))}function cf(){return bl.offsetTop}function aY(){return bl.offsetLeft}function aV(cS,cR){var cQ=ad(bb,true),cO,cT;
try{cO=cS.clientX;cT=cS.clientY}catch(cS){return null}if(!cR&&(cO-cQ.left>bb.clientWidth||cT-cQ.top>bb.clientHeight)){return null}var cP=ad(bl,true);
return bw(cO-cP.left,cT-cP.top)}function aU(cP){var cT=aV(cP);if(!cT||window.opera){return}if(X(cL.from,cL.to)||U(cT,cL.from)||!U(cT,cL.to)){aj(aZ)(cT.line,cT.ch)
}var cS=bd.style.cssText;bL.style.position="absolute";bd.style.cssText="position: fixed; width: 30px; height: 30px; top: "+(cP.clientY-5)+"px; left: "+(cP.clientX-5)+"px; z-index: 1000; background: white; border-width: 0; outline: none; overflow: hidden; opacity: .05; filter: alpha(opacity=5);";
a7=true;var cR=bd.value=bQ();bq();bd.select();function cO(){var cU=x(bd.value).join("\n");if(cU!=cR){aj(bi)(cU,"end")}bL.style.position="relative";
bd.style.cssText=cS;a7=false;cp(true);af()}if(I){t(cP);var cQ=o(window,"mouseup",function(){cQ();setTimeout(cO,20)},true)}else{setTimeout(cO,50)
}}function cA(){clearInterval(cD);var cO=true;a4.style.visibility="";cD=setInterval(function(){a4.style.visibility=(cO=!cO)?"":"hidden"
},650)}var bf={"(":")>",")":"(<","[":"]>","]":"[<","{":"}>","}":"{<"};function b1(cU){var cO=cL.inverted?cL.from:cL.to,cW=cs(cO.line),cP=cO.ch-1;
var cT=(cP>=0&&bf[cW.text.charAt(cP)])||bf[cW.text.charAt(++cP)];if(!cT){return}var cX=cT.charAt(0),cV=cT.charAt(1)==">",c7=cV?1:-1,c2=cW.styles;
for(var c8=cP+1,c4=0,c6=c2.length;c4<c6;c4+=2){if((c8-=c2[c4].length)<=0){var c5=c2[c4+1];break}}var cR=[cW.text.charAt(cP)],c1=/[(){}[\]]/;
function cZ(dk,df,dg){if(!dk.text){return}var dj=dk.styles,de=cV?0:dk.text.length-1,dh;for(var db=cV?0:dj.length-2,dd=cV?dj.length:-2;
db!=dd;db+=2*c7){var di=dj[db];if(dj[db+1]!=null&&dj[db+1]!=c5){de+=c7*di.length;continue}for(var da=cV?0:di.length-1,c9=cV?di.length:-1;
da!=c9;da+=c7,de+=c7){if(de>=df&&de<dg&&c1.test(dh=di.charAt(da))){var dc=bf[dh];if(dc.charAt(1)==">"==cV){cR.push(dh)}else{if(cR.pop()!=dc.charAt(0)){return{pos:de,match:false}
}else{if(!cR.length){return{pos:de,match:true}}}}}}}}for(var c4=cO.line,c6=cV?Math.min(c4+100,cl.size):Math.max(-1,c4-100);c4!=c6;c4+=c7){var cW=cs(c4),cS=c4==cO.line;
var cY=cZ(cW,cS&&cV?cP+1:0,cS&&!cV?cP:cW.text.length);if(cY){break}}if(!cY){cY={pos:null,match:false}}var c5=cY.match?"CodeMirror-matchingbracket":"CodeMirror-nonmatchingbracket";
var c3=bt({line:cO.line,ch:cP},{line:cO.line,ch:cP+1},c5),cQ=cY.pos!=null&&bt({line:c4,ch:cY.pos},{line:c4,ch:cY.pos+1},c5);var c0=aj(function(){c3.clear();
cQ&&cQ.clear()});if(cU){setTimeout(c0,800)}else{bR=c0}}function a0(cU){var cT,cQ;for(var cP=cU,cR=cU-40;cP>cR;--cP){if(cP==0){return 0
}var cO=cs(cP-1);if(cO.stateAfter){return cP}var cS=cO.indentation(bO.tabSize);if(cQ==null||cT>cS){cQ=cP-1;cT=cS}}return cQ}function ch(cQ){var cP=a0(cQ),cO=cP&&cs(cP-1).stateAfter;
if(!cO){cO=Q(bY)}else{cO=m(bY,cO)}cl.iter(cP,cQ,function(cR){cR.highlight(bY,cO,bO.tabSize);cR.stateAfter=m(bY,cO)});if(cP<cQ){at.push({from:cP,to:cQ})
}if(cQ<cl.size&&!cs(cQ).stateAfter){b4.push(cQ)}return cO}function cu(cQ,cO){var cP=ch(cQ);cl.iter(cQ,cO,function(cR){cR.highlight(bY,cP,bO.tabSize);
cR.stateAfter=m(bY,cP)})}function bG(){var cU=+new Date+bO.workTime;var cX=b4.length;while(b4.length){if(!cs(cE).stateAfter){var cR=cE
}else{var cR=b4.pop()}if(cR>=cl.size){continue}var cP=a0(cR),cO=cP&&cs(cP-1).stateAfter;if(cO){cO=m(bY,cO)}else{cO=Q(bY)}var cT=0,cQ=bY.compareStates,cW=false,cV=cP,cS=false;
cl.iter(cV,cl.size,function(cY){var cZ=cY.stateAfter;if(+new Date>cU){b4.push(cV);bv(bO.workDelay);if(cW){at.push({from:cR,to:cV+1})}return(cS=true)
}var c0=cY.highlight(bY,cO,bO.tabSize);if(c0){cW=true}cY.stateAfter=m(bY,cO);if(cQ){if(cZ&&cQ(cZ,cO)){return true}}else{if(c0!==false||!cZ){cT=0
}else{if(++cT>3&&(!bY.indent||bY.indent(cZ,"")==bY.indent(cO,""))){return true}}}++cV});if(cS){return}if(cW){at.push({from:cR,to:cV+1})
}}if(cX&&bO.onHighlightComplete){bO.onHighlightComplete(bW)}}function bv(cO){if(!b4.length){return}an.set(cO,aj(bG))}function aF(){cc=bT=cB=null;
at=[];aH=false;cn=[]}function ap(){var cS=false,cP;if(aH){cS=!b2()}if(at.length){cP=b0(at,true)}else{if(aH){cK()}if(aK){aD()}}if(cS){b2()
}if(aH){cN();cA()}if(b6&&!a7&&(cc===true||(cc!==false&&aH))){cp(bT)}if(aH&&bO.matchBrackets){setTimeout(aj(function(){if(bR){bR();bR=null
}if(X(cL.from,cL.to)){b1(false)}}),20)}var cO=cB,cQ=cn;if(aH&&bO.onCursorActivity){bO.onCursorActivity(bW)}if(cO&&bO.onChange&&bW){bO.onChange(bW,cO)
}for(var cR=0;cR<cQ.length;++cR){cQ[cR](bW)}if(cP&&bO.onUpdate){bO.onUpdate(bW)}}var cd=0;function aj(cO){return function(){if(!cd++){aF()
}try{var cP=cO.apply(this,arguments)}finally{if(!--cd){ap()}}return cP}}for(var by in W){if(W.propertyIsEnumerable(by)&&!bW.propertyIsEnumerable(by)){bW[by]=W[by]
}}return bW}r.defaults={value:"",mode:null,theme:"default",indentUnit:2,indentWithTabs:false,smartIndent:true,tabSize:4,keyMap:"default",extraKeys:null,electricChars:true,onKeyEvent:null,lineWrapping:false,lineNumbers:false,gutter:false,fixedGutter:false,firstLineNumber:1,readOnly:false,onChange:null,onCursorActivity:null,onGutterClick:null,onHighlightComplete:null,onUpdate:null,onFocus:null,onBlur:null,onScroll:null,matchBrackets:false,workTime:100,workDelay:200,pollInterval:100,undoDepth:40,tabindex:null,document:window.document};
var p=/AppleWebKit/.test(navigator.userAgent)&&/Mobile\/\w+/.test(navigator.userAgent);var H=p||/Mac/.test(navigator.platform);var P=/Win/.test(navigator.platform);
var ac={},N={};r.defineMode=function(af,ag){if(!r.defaults.mode&&af!="null"){r.defaults.mode=af}ac[af]=ag};r.defineMIME=function(ag,af){N[ag]=af
};r.getMode=function(ah,af){if(typeof af=="string"&&N.hasOwnProperty(af)){af=N[af]}if(typeof af=="string"){var aj=af,ag={}}else{if(af!=null){var aj=af.name,ag=af
}}var ai=ac[aj];if(!ai){if(window.console){console.warn("No mode "+aj+" found, falling back to plain text.")}return r.getMode(ah,"text/plain")
}return ai(ah,ag||{})};r.listModes=function(){var ag=[];for(var af in ac){if(ac.propertyIsEnumerable(af)){ag.push(af)}}return ag};r.listMIMEs=function(){var ag=[];
for(var af in N){if(N.propertyIsEnumerable(af)){ag.push({mime:af,mode:N[af]})}}return ag};var W=r.extensions={};r.defineExtension=function(af,ag){W[af]=ag
};var G=r.commands={selectAll:function(af){af.setSelection({line:0,ch:0},{line:af.lineCount()-1})},killLine:function(af){var ai=af.getCursor(true),ah=af.getCursor(false),ag=!X(ai,ah);
if(!ag&&af.getLine(ai.line).length==ai.ch){af.replaceRange("",ai,{line:ai.line+1,ch:0})}else{af.replaceRange("",ai,ag?ah:{line:ai.line})
}},deleteLine:function(af){var ag=af.getCursor().line;af.replaceRange("",{line:ag,ch:0},{line:ag})},undo:function(af){af.undo()},redo:function(af){af.redo()
},goDocStart:function(af){af.setCursor(0,0,true)},goDocEnd:function(af){af.setSelection({line:af.lineCount()-1},null,true)},goLineStart:function(af){af.setCursor(af.getCursor().line,0,true)
},goLineStartSmart:function(af){var ai=af.getCursor();var ah=af.getLine(ai.line),ag=Math.max(0,ah.search(/\S/));af.setCursor(ai.line,ai.ch<=ag&&ai.ch?0:ag,true)
},goLineEnd:function(af){af.setSelection({line:af.getCursor().line},null,true)},goLineUp:function(af){af.moveV(-1,"line")},goLineDown:function(af){af.moveV(1,"line")
},goPageUp:function(af){af.moveV(-1,"page")},goPageDown:function(af){af.moveV(1,"page")},goCharLeft:function(af){af.moveH(-1,"char")},goCharRight:function(af){af.moveH(1,"char")
},goColumnLeft:function(af){af.moveH(-1,"column")},goColumnRight:function(af){af.moveH(1,"column")},goWordLeft:function(af){af.moveH(-1,"word")
},goWordRight:function(af){af.moveH(1,"word")},delCharLeft:function(af){af.deleteH(-1,"char")},delCharRight:function(af){af.deleteH(1,"char")
},delWordLeft:function(af){af.deleteH(-1,"word")},delWordRight:function(af){af.deleteH(1,"word")},indentAuto:function(af){af.indentSelection("smart")
},indentMore:function(af){af.indentSelection("add")},indentLess:function(af){af.indentSelection("subtract")},insertTab:function(af){af.replaceSelection("\t","end")
},transposeChars:function(af){var ah=af.getCursor(),ag=af.getLine(ah.line);if(ah.ch>0&&ah.ch<ag.length-1){af.replaceRange(ag.charAt(ah.ch)+ag.charAt(ah.ch-1),{line:ah.line,ch:ah.ch-1},{line:ah.line,ch:ah.ch+1})
}},newlineAndIndent:function(af){af.replaceSelection("\n","end");af.indentLine(af.getCursor().line)},toggleOverwrite:function(af){af.toggleOverwrite()
}};var s=r.keyMap={};s.basic={Left:"goCharLeft",Right:"goCharRight",Up:"goLineUp",Down:"goLineDown",End:"goLineEnd",Home:"goLineStartSmart",PageUp:"goPageUp",PageDown:"goPageDown",Delete:"delCharRight",Backspace:"delCharLeft",Tab:"indentMore","Shift-Tab":"indentLess",Enter:"newlineAndIndent",Insert:"toggleOverwrite"};
s.pcDefault={"Ctrl-A":"selectAll","Ctrl-D":"deleteLine","Ctrl-Z":"undo","Shift-Ctrl-Z":"redo","Ctrl-Y":"redo","Ctrl-Home":"goDocStart","Alt-Up":"goDocStart","Ctrl-End":"goDocEnd","Ctrl-Down":"goDocEnd","Ctrl-Left":"goWordLeft","Ctrl-Right":"goWordRight","Alt-Left":"goLineStart","Alt-Right":"goLineEnd","Ctrl-Backspace":"delWordLeft","Ctrl-Delete":"delWordRight","Ctrl-S":"save","Ctrl-F":"find","Ctrl-G":"findNext","Shift-Ctrl-G":"findPrev","Shift-Ctrl-F":"replace","Shift-Ctrl-R":"replaceAll",fallthrough:"basic"};
s.macDefault={"Cmd-A":"selectAll","Cmd-D":"deleteLine","Cmd-Z":"undo","Shift-Cmd-Z":"redo","Cmd-Y":"redo","Cmd-Up":"goDocStart","Cmd-End":"goDocEnd","Cmd-Down":"goDocEnd","Alt-Left":"goWordLeft","Alt-Right":"goWordRight","Cmd-Left":"goLineStart","Cmd-Right":"goLineEnd","Alt-Backspace":"delWordLeft","Ctrl-Alt-Backspace":"delWordRight","Alt-Delete":"delWordRight","Cmd-S":"save","Cmd-F":"find","Cmd-G":"findNext","Shift-Cmd-G":"findPrev","Cmd-Alt-F":"replace","Shift-Cmd-Alt-F":"replaceAll",fallthrough:["basic","emacsy"]};
s["default"]=H?s.macDefault:s.pcDefault;s.emacsy={"Ctrl-F":"goCharRight","Ctrl-B":"goCharLeft","Ctrl-P":"goLineUp","Ctrl-N":"goLineDown","Alt-F":"goWordRight","Alt-B":"goWordLeft","Ctrl-A":"goLineStart","Ctrl-E":"goLineEnd","Ctrl-V":"goPageUp","Shift-Ctrl-V":"goPageDown","Ctrl-D":"delCharRight","Ctrl-H":"delCharLeft","Alt-D":"delWordRight","Alt-Backspace":"delWordLeft","Ctrl-K":"killLine","Ctrl-T":"transposeChars"};
function k(ag,af,ai){function ah(aj,an,ao){var al=an[aj];if(al!=null){return al}if(ao==null){ao=an.fallthrough}if(ao==null){return an.catchall
}if(typeof ao=="string"){return ah(aj,s[ao])}for(var ak=0,am=ao.length;ak<am;++ak){al=ah(aj,s[ao[ak]]);if(al!=null){return al}}return null
}return af?ah(ag,af,ai):ah(ag,s[ai])}function L(ag){var af=M[v(ag,"keyCode")];return af=="Ctrl"||af=="Alt"||af=="Shift"||af=="Mod"}r.fromTextArea=function(ag,ai){if(!ai){ai={}
}ai.value=ag.value;if(!ai.tabindex&&ag.tabindex){ai.tabindex=ag.tabindex}function ak(){ag.value=af.getValue()}if(ag.form){var aj=o(ag.form,"submit",ak,true);
if(typeof ag.form.submit=="function"){var ah=ag.form.submit;function al(){ak();ag.form.submit=ah;ag.form.submit();ag.form.submit=al}ag.form.submit=al
}}ag.style.display="none";var af=r(function(am){ag.parentNode.insertBefore(am,ag.nextSibling)},ai);af.save=ak;af.getTextArea=function(){return ag
};af.toTextArea=function(){ak();ag.parentNode.removeChild(af.getWrapperElement());ag.style.display="";if(ag.form){aj();if(typeof ag.form.submit=="function"){ag.form.submit=ah
}}};return af};function m(ai,af){if(af===true){return af}if(ai.copyState){return ai.copyState(af)}var ah={};for(var aj in af){var ag=af[aj];
if(ag instanceof Array){ag=ag.concat([])}ah[aj]=ag}return ah}r.copyState=m;function Q(ah,ag,af){return ah.startState?ah.startState(ag,af):true
}r.startState=Q;function b(af,ag){this.pos=this.start=0;this.string=af;this.tabSize=ag||8}b.prototype={eol:function(){return this.pos>=this.string.length
},sol:function(){return this.pos==0},peek:function(){return this.string.charAt(this.pos)},next:function(){if(this.pos<this.string.length){return this.string.charAt(this.pos++)
}},eat:function(af){var ah=this.string.charAt(this.pos);if(typeof af=="string"){var ag=ah==af}else{var ag=ah&&(af.test?af.test(ah):af(ah))
}if(ag){++this.pos;return ah}},eatWhile:function(af){var ag=this.pos;while(this.eat(af)){}return this.pos>ag},eatSpace:function(){var af=this.pos;
while(/[\s\u00a0]/.test(this.string.charAt(this.pos))){++this.pos}return this.pos>af},skipToEnd:function(){this.pos=this.string.length
},skipTo:function(af){var ag=this.string.indexOf(af,this.pos);if(ag>-1){this.pos=ag;return true}},backUp:function(af){this.pos-=af},column:function(){return l(this.string,this.start,this.tabSize)
},indentation:function(){return l(this.string,null,this.tabSize)},match:function(ai,ag,af){if(typeof ai=="string"){function aj(ak){return af?ak.toLowerCase():ak
}if(aj(this.string).indexOf(aj(ai),this.pos)==this.pos){if(ag!==false){this.pos+=ai.length}return true}}else{var ah=this.string.slice(this.pos).match(ai);
if(ah&&ag!==false){this.pos+=ah[0].length}return ah}},current:function(){return this.string.slice(this.start,this.pos)}};r.StringStream=b;
function F(ai,ah,af,ag){this.from=ai;this.to=ah;this.style=af;this.set=ag}F.prototype={attach:function(af){this.set.push(af)},detach:function(ag){var af=n(this.set,ag);
if(af>-1){this.set.splice(af,1)}},split:function(ai,af){if(this.to<=ai&&this.to!=null){return null}var ah=this.from<ai||this.from==null?null:this.from-ai+af;
var ag=this.to==null?null:this.to-ai+af;return new F(ah,ag,this.style,this.set)},dup:function(){return new F(null,null,this.style,this.set)
},clipTo:function(ag,aj,af,ai,ah){if(this.from!=null&&this.from>=aj){this.from=Math.max(ai,this.from)+ah}if(this.to!=null&&this.to>aj){this.to=ai<this.to?this.to+ah:aj
}if(ag&&ai>this.from&&(ai<this.to||this.to==null)){this.from=null}if(af&&(aj<this.to||this.to==null)&&(aj>this.from||this.from==null)){this.to=null
}},isDead:function(){return this.from!=null&&this.to!=null&&this.from>=this.to},sameSet:function(af){return this.set==af.set}};function B(af){this.from=af;
this.to=af;this.line=null}B.prototype={attach:function(af){this.line=af},detach:function(af){if(this.line==af){this.line=null}},split:function(ag,af){if(ag<this.from){this.from=this.to=(this.from-ag)+af;
return this}},isDead:function(){return this.from>this.to},clipTo:function(ag,aj,af,ai,ah){if((ag||aj<this.from)&&(af||ai>this.to)){this.from=0;
this.to=-1}else{if(this.from>aj){this.from=this.to=Math.max(ai,this.from)+ah}}},sameSet:function(af){return false},find:function(){if(!this.line||!this.line.parent){return null
}return{line:T(this.line),ch:this.from}},clear:function(){if(this.line){var af=n(this.line.marked,this);if(af!=-1){this.line.marked.splice(af,1)
}this.line=null}}};function d(ag,af){this.styles=af||[ag,null];this.text=ag;this.height=1;this.marked=this.gutterMarker=this.className=this.handlers=null;
this.stateAfter=this.parent=this.hidden=null}d.inheritMarks=function(aj,am){var ai=new d(aj),af=am&&am.marked;if(af){for(var ah=0;ah<af.length;
++ah){if(af[ah].to==null&&af[ah].style){var ag=ai.marked||(ai.marked=[]),al=af[ah];var ak=al.dup();ag.push(ak);ak.attach(ai)}}}return ai
};d.prototype={replace:function(aj,ai,am){var an=[],ah=this.marked,ak=ai==null?this.text.length:ai;ae(0,aj,this.styles,an);if(am){an.push(am,null)
}ae(ak,this.text.length,this.styles,an);this.styles=an;this.text=this.text.slice(0,aj)+am+this.text.slice(ak);this.stateAfter=null;if(ah){var al=am.length-(ak-aj);
for(var ag=0;ag<ah.length;++ag){var af=ah[ag];af.clipTo(aj==null,aj||0,ai==null,ak,al);if(af.isDead()){af.detach(this);ah.splice(ag--,1)
}}}},split:function(am,ak){var ai=[ak,null],ag=this.marked;ae(am,this.text.length,this.styles,ai);var ah=new d(ak+this.text.slice(am),ai);
if(ag){for(var aj=0;aj<ag.length;++aj){var al=ag[aj];var af=al.split(am,ak.length);if(af){if(!ah.marked){ah.marked=[]}ah.marked.push(af);
af.attach(ah)}}}return ah},append:function(ag){var al=this.text.length,af=ag.marked,aj=this.marked;this.text+=ag.text;ae(0,ag.text.length,ag.styles,this.styles);
if(aj){for(var ak=0;ak<aj.length;++ak){if(aj[ak].to==null){aj[ak].to=al}}}if(af&&af.length){if(!aj){this.marked=aj=[]}outer:for(var ak=0;
ak<af.length;++ak){var am=af[ak];if(!am.from){for(var ai=0;ai<aj.length;++ai){var ah=aj[ai];if(ah.to==al&&ah.sameSet(am)){ah.to=am.to==null?null:am.to+al;
if(ah.isDead()){ah.detach(this);af.splice(ak--,1)}continue outer}}}aj.push(am);am.attach(this);am.from+=al;if(am.to!=null){am.to+=al}}}},fixMarkEnds:function(ag){var af=this.marked,aj=ag.marked;
if(!af){return}for(var ai=0;ai<af.length;++ai){var al=af[ai],ak=al.to==null;if(ak&&aj){for(var ah=0;ah<aj.length;++ah){if(aj[ah].sameSet(al)){ak=false;
break}}}if(ak){al.to=this.text.length}}},fixMarkStarts:function(){var af=this.marked;if(!af){return}for(var ag=0;ag<af.length;++ag){if(af[ag].from==null){af[ag].from=0
}}},addMark:function(af){af.attach(this);if(this.marked==null){this.marked=[]}this.marked.push(af);this.marked.sort(function(ah,ag){return(ah.from||0)-(ag.from||0)
})},highlight:function(ak,ag,al){var ao=new b(this.text,al),ap=this.styles,am=0;var aj=false,ah=ap[0],an;if(this.text==""&&ak.blankLine){ak.blankLine(ag)
}while(!ao.eol()){var af=ak.token(ao,ag);var ai=this.text.slice(ao.start,ao.pos);ao.start=ao.pos;if(am&&ap[am-1]==af){ap[am-2]+=ai}else{if(ai){if(!aj&&(ap[am+1]!=af||(am&&ap[am-2]!=an))){aj=true
}ap[am++]=ai;ap[am++]=af;an=ah;ah=ap[am]}}if(ao.pos>5000){ap[am++]=this.text.slice(ao.pos);ap[am++]=null;break}}if(ap.length!=am){ap.length=am;
aj=true}if(am&&ap[am-2]!=an){aj=true}return aj||(ap.length<5&&this.text.length<10?null:false)},getTokenAt:function(ak,ai,ah){var af=this.text,aj=new b(af);
while(aj.pos<ah&&!aj.eol()){aj.start=aj.pos;var ag=ak.token(aj,ai)}return{start:aj.start,end:aj.pos,string:aj.current(),className:ag||null,state:ai}
},indentation:function(af){return l(this.text,null,af)},getHTML:function(ap,av){var al=[],aj=true;function az(aI,aH){if(!aI){return}if(aj&&D&&aI.charAt(0)==" "){aI="\u00a0"+aI.slice(1)
}aj=false;if(aH){al.push('<span class="',aH,'">',K(aI).replace(/\t/g,ap),"</span>")}else{al.push(K(aI).replace(/\t/g,ap))}}var at=this.styles,ak=this.text,aq=this.marked;
var aC=ak.length;if(av!=null){aC=Math.min(av,aC)}function ah(aH){if(!aH){return null}return"cm-"+aH.replace(/ +/g," cm-")}if(!ak&&av==null){az(" ")
}else{if(!aq||!aq.length){for(var aA=0,am=0;am<aC;aA+=2){var au=at[aA],aD=at[aA+1],aw=au.length;if(am+aw>aC){au=au.slice(0,aC-am)}am+=aw;
az(au,ah(aD))}}else{var ai=0,aA=0,ao="",aD,aG=0;var aF=aq[0].from||0,ay=[],aE=0;function aB(){var aH;while(aE<aq.length&&((aH=aq[aE]).from==ai||aH.from==null)){if(aH.style!=null){ay.push(aH)
}++aE}aF=aE<aq.length?aq[aE].from:Infinity;for(var aI=0;aI<ay.length;++aI){var aJ=ay[aI].to||Infinity;if(aJ==ai){ay.splice(aI--,1)}else{aF=Math.min(aJ,aF)
}}}var ar=0;while(ai<aC){if(aF==ai){aB()}var an=Math.min(aC,aF);while(true){if(ao){var ag=ai+ao.length;var af=aD;for(var ax=0;ax<ay.length;
++ax){af=(af?af+" ":"")+ay[ax].style}az(ag>an?ao.slice(0,an-ai):ao,af);if(ag>=an){ao=ao.slice(an-ai);ai=an;break}ai=ag}ao=at[aA++];aD=ah(at[aA++])
}}}}return al.join("")},cleanUp:function(){this.parent=null;if(this.marked){for(var af=0,ag=this.marked.length;af<ag;++af){this.marked[af].detach(this)
}}}};function ae(al,am,af,an){for(var aj=0,ak=0,ag=0;ak<am;aj+=2){var ah=af[aj],ai=ak+ah.length;if(ag==0){if(ai>al){an.push(ah.slice(al-ak,Math.min(ah.length,am-ak)),af[aj+1])
}if(ai>=al){ag=1}}else{if(ag==1){if(ai>am){an.push(ah.slice(0,am-ak),af[aj+1])}else{an.push(ah,af[aj+1])}}}ak=ai}}function aa(ag){this.lines=ag;
this.parent=null;for(var ah=0,ai=ag.length,af=0;ah<ai;++ah){ag[ah].parent=this;af+=ag[ah].height}this.height=af}aa.prototype={chunkSize:function(){return this.lines.length
},remove:function(af,al,aj){for(var ai=af,ak=af+al;ai<ak;++ai){var ag=this.lines[ai];this.height-=ag.height;ag.cleanUp();if(ag.handlers){for(var ah=0;
ah<ag.handlers.length;++ah){aj.push(ag.handlers[ah])}}}this.lines.splice(af,al)},collapse:function(af){af.splice.apply(af,[af.length,0].concat(this.lines))
},insertHeight:function(ag,ah,af){this.height+=af;this.lines.splice.apply(this.lines,[ag,0].concat(ah));for(var ai=0,aj=ah.length;ai<aj;
++ai){ah[ai].parent=this}},iterN:function(af,ai,ah){for(var ag=af+ai;af<ag;++af){if(ah(this.lines[af])){return true}}}};function g(ai){this.children=ai;
var ah=0,af=0;for(var ag=0,ak=ai.length;ag<ak;++ag){var aj=ai[ag];ah+=aj.chunkSize();af+=aj.height;aj.parent=this}this.size=ah;this.height=af;
this.parent=null}g.prototype={chunkSize:function(){return this.size},remove:function(ah,ag,ak){this.size-=ag;for(var ai=0;ai<this.children.length;
++ai){var af=this.children[ai],al=af.chunkSize();if(ah<al){var aj=Math.min(ag,al-ah),am=af.height;af.remove(ah,aj,ak);this.height-=am-af.height;
if(al==aj){this.children.splice(ai--,1);af.parent=null}if((ag-=aj)==0){break}ah=0}else{ah-=al}}if(this.size-ag<25){var an=[];this.collapse(an);
this.children=[new aa(an)];this.children[0].parent=this}},collapse:function(af){for(var ag=0,ah=this.children.length;ag<ah;++ag){this.children[ag].collapse(af)
}},insert:function(ag,ah){var af=0;for(var ai=0,aj=ah.length;ai<aj;++ai){af+=ah[ai].height}this.insertHeight(ag,ah,af)},insertHeight:function(ag,an,am){this.size+=an.length;
this.height+=am;for(var ah=0,aj=this.children.length;ah<aj;++ah){var af=this.children[ah],ak=af.chunkSize();if(ag<=ak){af.insertHeight(ag,an,am);
if(af.lines&&af.lines.length>50){while(af.lines.length>50){var ai=af.lines.splice(af.lines.length-25,25);var al=new aa(ai);af.height-=al.height;
this.children.splice(ah+1,0,al);al.parent=this}this.maybeSpill()}break}ag-=ak}},maybeSpill:function(){if(this.children.length<=10){return
}var ai=this;do{var ag=ai.children.splice(ai.children.length-5,5);var ah=new g(ag);if(!ai.parent){var aj=new g(ai.children);aj.parent=ai;
ai.children=[aj,ah];ai=aj}else{ai.size-=ah.size;ai.height-=ah.height;var af=n(ai.parent.children,ai);ai.parent.children.splice(af+1,0,ah)
}ah.parent=ai.parent}while(ai.children.length>10);ai.parent.maybeSpill()},iter:function(ah,ag,af){this.iterN(ah,ag-ah,af)},iterN:function(af,am,al){for(var ag=0,aj=this.children.length;
ag<aj;++ag){var ak=this.children[ag],ai=ak.chunkSize();if(af<ai){var ah=Math.min(am,ai-af);if(ak.iterN(af,ah,al)){return true}if((am-=ah)==0){break
}af=0}else{af-=ai}}}};function y(af,aj){while(!af.lines){for(var ag=0;;++ag){var ai=af.children[ag],ah=ai.chunkSize();if(aj<ah){af=ai;
break}aj-=ah}}return af.lines[aj]}function T(af){if(af.parent==null){return null}var ak=af.parent,aj=n(ak.lines,af);for(var ag=ak.parent;
ag;ak=ag,ag=ag.parent){for(var ah=0,ai=ag.children.length;;++ah){if(ag.children[ah]==ak){break}aj+=ag.children[ah].chunkSize()}}return aj
}function S(al,aj){var ah=0;outer:do{for(var ai=0,ak=al.children.length;ai<ak;++ai){var ag=al.children[ai],af=ag.height;if(aj<af){al=ag;
continue outer}aj-=af;ah+=ag.chunkSize()}return ah}while(!al.lines);for(var ai=0,ak=al.lines.length;ai<ak;++ai){var an=al.lines[ai],am=an.height;
if(aj<am){break}aj-=am}return ah+ai}function f(af,al){var ah=0;outer:do{for(var ag=0,aj=af.children.length;ag<aj;++ag){var ak=af.children[ag],ai=ak.chunkSize();
if(al<ai){af=ak;continue outer}al-=ai;ah+=ak.height}return ah}while(!af.lines);for(var ag=0;ag<al;++ag){ah+=af.lines[ag].height}return ah
}function j(){this.time=0;this.done=[];this.undone=[]}j.prototype={addChange:function(af,al,ag){this.undone.length=0;var ah=+new Date,an=this.done[this.done.length-1],ao=an&&an[an.length-1];
var aj=ah-this.time;if(aj>400||!ao){this.done.push([{start:af,added:al,old:ag}])}else{if(ao.start>af+al||ao.start+ao.added<af-ao.added+ao.old.length){an.push({start:af,added:al,old:ag})
}else{var am=0;if(af<ao.start){for(var ai=ao.start-af-1;ai>=0;--ai){ao.old.unshift(ag[ai])}ao.added+=ao.start-af;ao.start=af}else{if(ao.start<af){am=af-ao.start;
al+=am}}for(var ai=ao.added-am,ak=ag.length;ai<ak;++ai){ao.old.push(ag[ai])}if(ao.added<al){ao.added=al}}}this.time=ah}};function E(){t(this)
}function J(af){if(!af.stop){af.stop=E}return af}function O(af){if(af.preventDefault){af.preventDefault()}else{af.returnValue=false}}function z(af){if(af.stopPropagation){af.stopPropagation()
}else{af.cancelBubble=true}}function t(af){O(af);z(af)}r.e_stop=t;r.e_preventDefault=O;r.e_stopPropagation=z;function h(af){return af.target||af.srcElement
}function u(af){if(af.which){return af.which}else{if(af.button&1){return 1}else{if(af.button&2){return 3}else{if(af.button&4){return 2
}}}}}function v(ag,ah){var af=ag.override&&ag.override.hasOwnProperty(ah);return af?ag.override[ah]:ag[ah]}function o(ai,ah,ag,af){if(typeof ai.addEventListener=="function"){ai.addEventListener(ah,ag,false);
if(af){return function(){ai.removeEventListener(ah,ag,false)}}}else{var aj=function(ak){ag(ak||window.event)};ai.attachEvent("on"+ah,aj);
if(af){return function(){ai.detachEvent("on"+ah,aj)}}}}r.connect=o;function w(){this.id=null}w.prototype={set:function(af,ag){clearTimeout(this.id);
this.id=setTimeout(ag,af)}};var A=function(){if(/MSIE [1-8]\b/.test(navigator.userAgent)){return false}var af=document.createElement("div");
return"draggable" in af}();var I=/gecko\/\d{7}/i.test(navigator.userAgent);var D=/MSIE \d/.test(navigator.userAgent);var e=/WebKit\//.test(navigator.userAgent);
var c="\n";(function(){var af=document.createElement("textarea");af.value="foo\nbar";if(af.value.indexOf("\r")>-1){c="\r\n"}}());function l(ag,af,ai){if(af==null){af=ag.search(/[^\s\u00a0]/);
if(af==-1){af=ag.length}}for(var ah=0,aj=0;ah<af;++ah){if(ag.charAt(ah)=="\t"){aj+=ai-(aj%ai)}else{++aj}}return aj}function q(af){if(af.currentStyle){return af.currentStyle
}return window.getComputedStyle(af,null)}function ad(ag,ao){var ai=ag.ownerDocument.body;var an=0,am=0,ak=false;for(var af=ag;af;af=af.offsetParent){var al=af.offsetLeft,ah=af.offsetTop;
if(af==ai){an+=Math.abs(al);am+=Math.abs(ah)}else{an+=al,am+=ah}if(ao&&q(af).position=="fixed"){ak=true}}var aj=ao&&!ak?null:ai;for(var af=ag.parentNode;
af!=aj;af=af.parentNode){if(af.scrollLeft!=null){an-=af.scrollLeft;am-=af.scrollTop}}return{left:an,top:am}}if(document.documentElement.getBoundingClientRect!=null){ad=function(ai,af){try{var ah=ai.getBoundingClientRect();
ah={top:ah.top,left:ah.left}}catch(aj){ah={top:0,left:0}}if(!af){if(window.pageYOffset==null){var ag=document.documentElement||document.body.parentNode;
if(ag.scrollTop==null){ag=document.body}ah.top+=ag.scrollTop;ah.left+=ag.scrollLeft}else{ah.top+=window.pageYOffset;ah.left+=window.pageXOffset
}}return ah}}function C(af){return af.textContent||af.innerText||af.nodeValue||""}function a(af){if(p){af.selectionStart=0;af.selectionEnd=af.value.length
}else{af.select()}}function X(ag,af){return ag.line==af.line&&ag.ch==af.ch}function U(ag,af){return ag.line<af.line||(ag.line==af.line&&ag.ch<af.ch)
}function V(af){return{line:af.line,ch:af.ch}}var ab=document.createElement("pre");function K(af){ab.textContent=af;return ab.innerHTML
}if(K("a")=="\na"){K=function(af){ab.textContent=af;return ab.innerHTML.slice(1)}}else{if(K("\t")!="\t"){K=function(af){ab.innerHTML="";
ab.appendChild(document.createTextNode(af));return ab.innerHTML}}}r.htmlEscape=K;function R(ai,ah){if(!ah){return 0}if(!ai){return ah.length
}for(var ag=ai.length,af=ah.length;ag>=0&&af>=0;--ag,--af){if(ai.charAt(ag)!=ah.charAt(af)){break}}return af+1}function n(ai,af){if(ai.indexOf){return ai.indexOf(af)
}for(var ag=0,ah=ai.length;ag<ah;++ag){if(ai[ag]==af){return ag}}return -1}function Z(af){return/\w/.test(af)||af.toUpperCase()!=af.toLowerCase()
}var x="\n\nb".split(/\n/).length!=3?function(ah){var ai=0,ag,af=[];while((ag=ah.indexOf("\n",ai))>-1){af.push(ah.slice(ai,ah.charAt(ag-1)=="\r"?ag-1:ag));
ai=ag+1}af.push(ah.slice(ai));return af}:function(af){return af.split(/\r?\n/)};r.splitLines=x;var Y=window.getSelection?function(ag){try{return ag.selectionStart!=ag.selectionEnd
}catch(af){return false}}:function(ah){try{var af=ah.ownerDocument.selection.createRange()}catch(ag){}if(!af||af.parentElement()!=ah){return false
}return af.compareEndPoints("StartToEnd",af)!=0};r.defineMode("null",function(){return{token:function(af){af.skipToEnd()}}});r.defineMIME("text/plain","null");
var M={3:"Enter",8:"Backspace",9:"Tab",13:"Enter",16:"Shift",17:"Ctrl",18:"Alt",19:"Pause",20:"CapsLock",27:"Esc",32:"Space",33:"PageUp",34:"PageDown",35:"End",36:"Home",37:"Left",38:"Up",39:"Right",40:"Down",44:"PrintScrn",45:"Insert",46:"Delete",59:";",91:"Mod",92:"Mod",93:"Mod",186:";",187:"=",188:",",189:"-",190:".",191:"/",192:"`",219:"[",220:"\\",221:"]",222:"'",63276:"PageUp",63277:"PageDown",63275:"End",63273:"Home",63234:"Left",63232:"Up",63235:"Right",63233:"Down",63302:"Insert",63272:"Delete"};
r.keyNames=M;(function(){for(var af=0;af<10;af++){M[af+48]=String(af)}for(var af=65;af<=90;af++){M[af]=String.fromCharCode(af)}for(var af=1;
af<=12;af++){M[af+111]=M[af+63235]="F"+af}})();return r})();CodeMirror.defineMode("clike",function(c,e){var g=c.indentUnit,f=e.keywords||{},a=e.blockKeywords||{},h=e.atoms||{},q=e.hooks||{},j=e.multiLineStrings;
var b=/[+\-*&%=<>!?|\/]/;var n;function d(v,t){var s=v.next();if(q[s]){var r=q[s](v,t);if(r!==false){return r}}if(s=='"'||s=="'"){t.tokenize=p(s);
return t.tokenize(v,t)}if(/[\[\]{}\(\),;\:\.]/.test(s)){n=s;return null}if(/\d/.test(s)){v.eatWhile(/[\w\.]/);return"number"}if(s=="/"){if(v.eat("*")){t.tokenize=l;
return l(v,t)}if(v.eat("/")){v.skipToEnd();return"comment"}}if(b.test(s)){v.eatWhile(b);return"operator"}v.eatWhile(/[\w\$_]/);var u=v.current();
if(f.propertyIsEnumerable(u)){if(a.propertyIsEnumerable(u)){n="newstatement"}return"keyword"}if(h.propertyIsEnumerable(u)){return"atom"
}return"word"}function p(r){return function(w,u){var v=false,t,s=false;while((t=w.next())!=null){if(t==r&&!v){s=true;break}v=!v&&t=="\\"
}if(s||!(v||j)){u.tokenize=d}return"string"}}function l(u,t){var r=false,s;while(s=u.next()){if(s=="/"&&r){t.tokenize=d;break}r=(s=="*")
}return"comment"}function o(v,s,r,u,t){this.indented=v;this.column=s;this.type=r;this.align=u;this.prev=t}function k(t,r,s){return t.context=new o(t.indented,r,s,null,t.context)
}function m(s){var r=s.context.type;if(r==")"||r=="]"||r=="}"){s.indented=s.context.indented}return s.context=s.context.prev}return{startState:function(r){return{tokenize:null,context:new o((r||0)-g,0,"top",false),indented:0,startOfLine:true}
},token:function(u,t){var r=t.context;if(u.sol()){if(r.align==null){r.align=false}t.indented=u.indentation();t.startOfLine=true}if(u.eatSpace()){return null
}n=null;var s=(t.tokenize||d)(u,t);if(s=="comment"||s=="meta"){return s}if(r.align==null){r.align=true}if((n==";"||n==":")&&r.type=="statement"){m(t)
}else{if(n=="{"){k(t,u.column(),"}")}else{if(n=="["){k(t,u.column(),"]")}else{if(n=="("){k(t,u.column(),")")}else{if(n=="}"){while(r.type=="statement"){r=m(t)
}if(r.type=="}"){r=m(t)}while(r.type=="statement"){r=m(t)}}else{if(n==r.type){m(t)}else{if(r.type=="}"||r.type=="top"||(r.type=="statement"&&n=="newstatement")){k(t,u.column(),"statement")
}}}}}}}t.startOfLine=false;return s},indent:function(v,s){if(v.tokenize!=d&&v.tokenize!=null){return 0}var r=v.context,u=s&&s.charAt(0);
if(r.type=="statement"&&u=="}"){r=r.prev}var t=u==r.type;if(r.type=="statement"){return r.indented+(u=="{"?0:g)}else{if(r.align){return r.column+(t?0:1)
}else{return r.indented+(t?0:g)}}},electricChars:"{}"}});(function(){function c(h){var f={},g=h.split(" ");for(var e=0;e<g.length;++e){f[g[e]]=true
}return f}var a="auto if break int case long char register continue return default short do sizeof double static else struct entry switch extern typedef float union for unsigned goto while enum void const signed volatile";
function d(f,e){if(!e.startOfLine){return false}f.skipToEnd();return"meta"}function b(g,f){var e;while((e=g.next())!=null){if(e=='"'&&!g.eat('"')){f.tokenize=null;
break}}return"string"}CodeMirror.defineMIME("text/x-csrc",{name:"clike",keywords:c(a),blockKeywords:c("case do else for if switch while struct"),atoms:c("null"),hooks:{"#":d}});
CodeMirror.defineMIME("text/x-c++src",{name:"clike",keywords:c(a+" asm dynamic_cast namespace reinterpret_cast try bool explicit new static_cast typeid catch operator template typename class friend private this using const_cast inline public throw virtual delete mutable protected wchar_t"),blockKeywords:c("catch class do else finally for if struct switch try while"),atoms:c("true false null"),hooks:{"#":d}});
CodeMirror.defineMIME("text/x-java",{name:"clike",keywords:c("abstract assert boolean break byte case catch char class const continue default do double else enum extends final finally float for goto if implements import instanceof int interface long native new package private protected public return short static strictfp super switch synchronized this throw throws transient try void volatile while"),blockKeywords:c("catch class do else finally for if switch try while"),atoms:c("true false null"),hooks:{"@":function(f,e){f.eatWhile(/[\w\$_]/);
return"meta"}}});CodeMirror.defineMIME("text/x-csharp",{name:"clike",keywords:c("abstract as base bool break byte case catch char checked class const continue decimal default delegate do double else enum event explicit extern finally fixed float for foreach goto if implicit in int interface internal is lock long namespace new object operator out override params private protected public readonly ref return sbyte sealed short sizeof stackalloc static string struct switch this throw try typeof uint ulong unchecked unsafe ushort using virtual void volatile while add alias ascending descending dynamic from get global group into join let orderby partial remove select set value var yield"),blockKeywords:c("catch class do else finally for foreach if struct switch try while"),atoms:c("true false null"),hooks:{"@":function(f,e){if(f.eat('"')){e.tokenize=b;
return b(f,e)}f.eatWhile(/[\w\$_]/);return"meta"}}});CodeMirror.defineMIME("text/x-umple",{name:"clike",keywords:c("abstract activate active after afterEvery as assert association associationClass before boolean Boolean break byte cardinality case catch char class const constant continue Date deactivate debug default defaulted depend do double Double during else entry enum execute exit extends external final finally float Float for generate goto if immutable implements import instanceof int Integer interface internal isA key lazy long namespace native new onThisObject package period position private protected public return self settable short singleton statemachine static strictfp String super switch synchronized this throw throws Time trace tracecase tracer trait transient try unique until use where void volatile while"),blockKeywords:c("catch class do else finally for if switch try while"),atoms:c("true false null"),hooks:{"@":function(f,e){f.eatWhile(/[\w\$_]/);
return"meta"}}})}());CodeMirror.tagRangeFinder=function(j,n){var v="A-Z_a-z\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u02FF\\u0370-\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFFD";
var z=v+"-.0-9\\u00B7\\u0300-\\u036F\\u203F-\\u2040";var c=new RegExp("^["+v+"]["+z+"]*");var e=j.getLine(n);var o=false;var A=null;var f=0;
while(!o){f=e.indexOf("<",f);if(-1==f){return}if(f+1<e.length&&e[f+1]=="/"){f++;continue}if(!e.substr(f+1).match(c)){f++;continue}var m=e.indexOf(">",f+1);
if(-1==m){var u=n+1;var q=false;var a=j.lineCount();while(u<a&&!q){var g=j.getLine(u);var p=g.indexOf(">");if(-1!=p){q=true;var r=g.lastIndexOf("/",p);
if(-1!=r&&r<p){var s=e.substr(r,p-r+1);if(!s.match(/\/\s*\>/)){return u+1}}}u++}o=true}else{var x=e.lastIndexOf("/",m);if(-1==x){o=true
}else{var s=e.substr(x,m-x+1);if(!s.match(/\/\s*\>/)){o=true}}}if(o){var b=e.substr(f+1);A=b.match(c);if(A){A=A[0];if(-1!=e.indexOf("</"+A+">",f)){o=false
}}else{o=false}}if(!o){f++}}if(o){var t="(\\<\\/"+A+"\\>)|(\\<"+A+"\\>)|(\\<"+A+"s)|(\\<"+A+"$)";var d=new RegExp(t,"g");var k="</"+A+">";
var y=1;var u=n+1;var a=j.lineCount();while(u<a){e=j.getLine(u);var h=e.match(d);if(h){for(var w=0;w<h.length;w++){if(h[w]==k){y--}else{y++
}if(!y){return u+1}}}u++}return}};CodeMirror.braceRangeFinder=function(h,m){var f=h.getLine(m);var n=f.lastIndexOf("{");if(n<0||f.lastIndexOf("}")>n){return
}var k=h.getTokenAt({line:m,ch:n}).className;var d=1,g=h.lineCount(),a;outer:for(var b=m+1;b<g;++b){var l=h.getLine(b),e=0;for(;;){var c=l.indexOf("{",e),j=l.indexOf("}",e);
if(c<0){c=l.length}if(j<0){j=l.length}e=Math.min(c,j);if(e==l.length){break}if(h.getTokenAt({line:b,ch:e+1}).className==k){if(e==c){++d
}else{if(!--d){a=b;break outer}}}++e}}if(a==null||a==m+1){return}return a};CodeMirror.newFoldFunction=function(e,a){var d=[];if(a==null){a='<div style="position: absolute; left: 2px; color:#600">&#x25bc;</div>%N%'
}function c(f,j){for(var g=0;g<d.length;++g){var h=f.lineInfo(d[g].start);if(!h){d.splice(g--,1)}else{if(h.line==j){return{pos:g,region:d[g]}
}}}}function b(f,h){f.clearMarker(h.start);for(var g=0;g<h.hidden.length;++g){f.showLine(h.hidden[g])}}return function(f,g){f.operation(function(){var k=c(f,g);
if(k){d.splice(k.pos,1);b(f,k.region)}else{var h=e(f,g);if(h==null){return}var m=[];for(var j=g+1;j<h;++j){var l=f.hideLine(j);if(l){m.push(l)
}}var o=f.setMarker(g,a);var n={start:o,hidden:m};f.onDeleteLine(o,function(){b(f,n)});d.push(n)}})}};(function(){function a(b,e,g,d){this.atOccurrence=false;
this.cm=b;if(d==null){d=typeof e=="string"&&e==e.toLowerCase()}g=g?b.clipPos(g):{line:0,ch:0};this.pos={from:g,to:g};if(typeof e!="string"){this.matches=function(k,o){if(k){var h=b.getLine(o.line).slice(0,o.ch),j=h.match(e),n=0;
while(j){var l=h.indexOf(j[0]);n+=l;h=h.slice(l+1);var m=h.match(e);if(m){j=m}else{break}n++}}else{var h=b.getLine(o.line).slice(o.ch),j=h.match(e),n=j&&o.ch+h.indexOf(j[0])
}if(j){return{from:{line:o.line,ch:n},to:{line:o.line,ch:n+j[0].length},match:j}}}}else{if(d){e=e.toLowerCase()}var c=d?function(h){return h.toLowerCase()
}:function(h){return h};var f=e.split("\n");if(f.length==1){this.matches=function(l,m){var j=c(b.getLine(m.line)),h=e.length,k;if(l?(m.ch>=h&&(k=j.lastIndexOf(e,m.ch-h))!=-1):(k=j.indexOf(e,m.ch))!=-1){return{from:{line:m.line,ch:k},to:{line:m.line,ch:k+h}}
}}}else{this.matches=function(n,p){var o=p.line,q=(n?f.length-1:0),l=f[q],r=c(b.getLine(o));var m=(n?r.indexOf(l)+l.length:r.lastIndexOf(l));
if(n?m>=p.ch||m!=l.length:m<=p.ch||m!=r.length-l.length){return}for(;;){if(n?!o:o==b.lineCount()-1){return}r=c(b.getLine(o+=n?-1:1));
l=f[n?--q:++q];if(q>0&&q<f.length-1){if(r!=l){return}else{continue}}var k=(n?r.lastIndexOf(l):r.indexOf(l)+l.length);if(n?k!=r.length-l.length:k!=l.length){return
}var h={line:p.line,ch:m},j={line:o,ch:k};return{from:n?j:h,to:n?h:j}}}}}}a.prototype={findNext:function(){return this.find(false)},findPrevious:function(){return this.find(true)
},find:function(c){var b=this,f=this.cm.clipPos(c?this.pos.from:this.pos.to);function d(g){var h={line:g,ch:0};b.pos={from:h,to:h};b.atOccurrence=false;
return false}for(;;){if(this.pos=this.matches(c,f)){this.atOccurrence=true;return this.pos.match||true}if(c){if(!f.line){return d(0)}f={line:f.line-1,ch:this.cm.getLine(f.line-1).length}
}else{var e=this.cm.lineCount();if(f.line==e-1){return d(e)}f={line:f.line+1,ch:0}}}},from:function(){if(this.atOccurrence){return this.pos.from
}},to:function(){if(this.atOccurrence){return this.pos.to}},replace:function(c){var b=this;if(this.atOccurrence){b.pos.to=this.cm.replaceRange(c,b.pos.from,b.pos.to)
}}};CodeMirror.defineExtension("getSearchCursor",function(c,d,b){return new a(this,c,d,b)})})();DropboxChooser={};DropboxChooser.init=function(){jQuery(".dropbox-button-chooser").each(function(){this.setAttribute("data-link-type","direct");
this.setAttribute("data-extensions",".ump");var a=this;this.addEventListener("DbxChooserSuccess",function(b){DropboxChooser.load(b.files[0].link)
},false)})};DropboxChooser.load=function(a){UmpleSystem.merge(null);Page.showCanvasLoading(true);Page.showModelLoading(true);Page.showLayoutLoading(true);
jQuery.get(a).done(function(b){Action.freshLoad=true;Page.setUmpleCode(b);Page.hideLoading();History.save(b,"dropboxLoad");Action.updateUmpleDiagram();
Action.setCaretPosition("0");Action.updateLineNumberDisplay()}).fail(function(){Page.setFeedbackMessage("Cannot load from the chosen Dropbox file.");
Page.hideLoading()})};var DropboxInitializer={};DropboxInitializer.initializeDropbox=function(){jQuery(".dropbox-add-saver").addClass("dropbox-option").append('<li id="ttDropboxSaver"><span class="dropbox-button-saver"></span></li>');
jQuery(".dropbox-add-chooser").addClass("dropbox-option").append('<li id="ttDropboxChooser"><input type="dropbox-chooser" class="dropbox-button-chooser"/></li>');
DropboxChooser.init();DropboxSaver.init()};DropboxMaster={resetTimeout:2000};DropboxSaver={};DropboxSaver.init=function(){jQuery(".dropbox-button-saver").each(function(){DropboxSaver.createSaverIn(this)
})};DropboxSaver.createSaverIn=function(b){var c=DropboxSaver.getAbsoluteLink(Page.getFilename());var a=Dropbox.createSaveButton({files:[{url:c}],success:function(){window.setTimeout(function(){jQuery(b).children(".dropbox-dropin-btn").remove();
DropboxSaver.createSaverIn(b)},DropboxMaster.resetTimeout)},error:function(d){console.log(d);Page.setFeedbackMessage("Cannot save to the chosen Dropbox location.")
}});jQuery(b).append(a)};DropboxSaver.getAbsoluteLink=function(b){var c=document.createElement("a");c.href=b.replace(/^\.\.\//,"");return c.href
};var Action=new Object();Action.waiting_time=1500;Action.oldTimeout=null;Action.elementClicked=false;Action.canCreateByDrag=true;Action.manualSync=false;
Action.diagramInSync=true;Action.freshLoad=false;Action.gentime=new Date().getTime();Action.savedCanonical="";Action.clicked=function(b){Page.clickCount+=1;
var d=b.currentTarget;var c=d.id.substring(6);if(c=="PhpCode"){Action.generateCode("php","Php")}else{if(c=="RubyCode"){Action.generateCode("ruby","Ruby")
}else{if(c=="JavaCode"){Action.generateCode("java","Java")}else{if(c=="RTCppCode"){Action.generateCode("rtcpp","RTCpp")}else{if(c=="AlloyCode"){Action.generateCode("alloy","Alloy")
}else{if(c=="NuSMVCode"){Action.generateCode("nusmv","NuSMV")}else{if(c=="CppCode"){Action.generateCode("cpp","Cpp")}else{if(c=="SQLCode"){Action.generateCode("sql","Sql")
}else{if(c=="JavaAPIDoc"){Action.generateCode("javadoc","javadoc")}else{if(c=="StateDiagram"){Action.generateCode("stateDiagram","stateDiagram")
}else{if(c=="StructureDiagram"){Action.generateCode("structureDiagram","structureDiagram")}else{if(c=="classDiagram"){Action.generateCode("classDiagram","classDiagram")
}else{if(c=="entityRelationshipDiagram"){Action.generateCode("entityRelationshipDiagram","entityRelationshipDiagram")}else{if(c=="EcoreCode"){Action.generateCode("xml","Ecore")
}else{if(c=="GenerateCode"){var a=$("inputGenerateCode").value.split(":");Action.generateCode(a[0],a[1])}else{if(c=="SimulateCode"){Action.simulateCode()
}else{if(c=="StartOver"){Action.startOver()}else{if(c=="PngImage"){Action.pngImage()}else{if(c=="YumlImage"){Action.yumlImage()}else{if(c=="Jsf"){Action.uigu()
}else{if(c=="Copy"){Action.showCodeInSeparateWindow()}else{if(c=="CopyEncodedURL"){Action.showEncodedURLCodeInSeparateWindow()}else{if(c=="Undo"){Action.undo()
}else{if(c=="Redo"){Action.redo()}else{if(c=="ShowHideTextEditor"){Layout.showHideTextEditor()}else{if(c=="ShowHideCanvas"){Layout.showHideCanvas()
}else{if(c=="ShowEditableClassDiagram"){Action.changeDiagramType({type:"editableClass"})}else{if(c=="ShowJointJSClassDiagram"){Action.changeDiagramType({type:"JointJSClass"})
}else{if(c=="ShowGvClassDiagram"){Action.changeDiagramType({type:"GVClass"})}else{if(c=="ShowGvStateDiagram"){Action.changeDiagramType({type:"GVState"})
}else{if(c=="ShowStructureDiagram"){Action.changeDiagramType({type:"structure"})}else{if(c=="ShowHideLayoutEditor"){Layout.showHideLayoutEditor()
}else{if(c=="ManualSync"){Action.enableManualSync()}else{if(c=="SyncDiagram"){Action.processTyping("umpleModelEditorText",true)}else{if(c=="PhotoReady"){Action.photoReady()
}else{if(c=="ToggleAttributes"){Action.toggleAttributes()}else{if(c=="ToggleMethods"){Action.toggleMethods()}else{if(c=="ToggleActions"){Action.toggleActions()
}else{if(c=="ToggleTraits"){Action.toggleTraits()}else{if(c=="ToggleTransitionLabels"){Action.toggleTransitionLabels()}else{if(c=="ToggleGuardLabels"){Action.toggleGuardLabels()
}else{if(c=="StructureLink"){Action.generateStructureDiagramFile()}else{if(c=="TabsCheckbox"){Action.toggleTabs()}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}};
Action.focusOn=function(d,b){var a="#"+d;var c=((d=="umpleModelEditorText"||d=="umpleLayoutEditorText")||d=="CodeMirror");if(d=="CodeMirror"){a=".CodeMirror-scroll"
}if(b){if(!Page.isPhotoReady()||c){jQuery(a).parent().addClass("focus");jQuery(a).addClass("visibleFocus");if(c){Page.shortcutsEnabled=false;
if(Page.selectedItem!=null){Page.unselectAllToggleTools()}Action.unselectAll()}}}else{jQuery(a).parent().removeClass("focus");jQuery(a).removeClass("visibleFocus");
if(c||d=="CodeMirror"){Page.shortcutsEnabled=true}}};Action.startOver=function(){Page.setUmpleCode("");UmpleSystem.merge(null);window.location="umple.php"
};Action.undo=function(){if(jQuery("#buttonUndo").hasClass("disabled")){return}Action.redoOrUndo(true)};Action.redo=function(){if(jQuery("#buttonRedo").hasClass("disabled")){return
}Action.redoOrUndo(false)};Action.redoOrUndo=function(a){var b="";if(Action.manualSync&&Action.diagramInSync){Action.diagramInSync=false;
Page.enablePaletteItem("buttonSyncDiagram",true);Page.enableDiagram(false)}if(a){b=History.getPreviousVersion()}else{b=History.getNextVersion()
}if(b==History.noChange){b=""}Action.freshLoad=true;Page.setUmpleCode(b);if(!Action.manualSync){Action.updateUmpleDiagram()}};Action.loadFile=function(){var a=Page.getFilename();
if(a!=""){Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&filename={0}",a))}else{Action.saveNewFile()}};
Action.loadFileCallback=function(a){Action.freshLoad=true;History.save(a.responseText,"loadFileCallback");Page.setUmpleCode(a.responseText);
if(!Action.manualSync){Action.updateUmpleDiagram()}};Action.saveNewFile=function(){var b=Page.getUmpleCode();var a=Page.getFilename();
if(a==""){Ajax.sendRequest("scripts/compiler.php",Action.saveNewFileCallback,format("save=1&&umpleCode={0}",b))}};Action.saveNewFileCallback=function(a){Page.setFilename(a.responseText)
};Action.changeDiagramType=function(b){var a=false;if(b.type=="editableClass"){if(Page.useEditableClassDiagram){return}Page.useEditableClassDiagram=true;
Page.useJointJSClassDiagram=false;Page.useGvClassDiagram=false;Page.useGvStateDiagram=false;Page.useStructureDiagram=false;a=true;jQuery("#buttonShowEditableClassDiagram").prop("checked","checked")
}else{if(b.type=="JointJSClass"){if(Page.useJointJSClassDiagram){return}Page.useEditableClassDiagram=false;Page.useJointJSClassDiagram=true;
Page.useGvClassDiagram=false;Page.useGvStateDiagram=false;Page.useStructureDiagram=false;a=true;jQuery("#buttonShowJointJSClassDiagram").prop("checked","checked")
}else{if(b.type=="GVClass"){if(Page.useGvClassDiagram){return}Page.useEditableClassDiagram=false;Page.useJointJSClassDiagram=false;Page.useGvClassDiagram=true;
Page.useGvStateDiagram=false;Page.useStructureDiagram=false;a=true;jQuery("#buttonShowGvClassDiagram").prop("checked","checked")}else{if(b.type=="GVState"){if(Page.useGvStateDiagram){return
}Page.useEditableClassDiagram=false;Page.useJointJSClassDiagram=false;Page.useGvClassDiagram=false;Page.useGvStateDiagram=true;Page.useStructureDiagram=false;
a=true;jQuery("#buttonShowGvStateDiagram").prop("checked","checked")}else{if(b.type=="structure"){if(Page.useGvStructureDiagram){return
}Page.useEditableClassDiagram=false;Page.useJointJSClassDiagram=false;Page.useGvClassDiagram=false;Page.useGvStateDiagram=false;Page.useStructureDiagram=true;
a=true;jQuery("#buttonShowStructureDiagram").prop("checked","checked")}}}}}if(a){Action.redrawDiagram()}};Action.pngImage=function(){var b=Json.toString(UmpleSystem);
var a=encodeURIComponent(b);window.open("scripts/compiler.php?asImage="+a,"UMLClassDiagram")};Action.yumlImage=function(){var a="#buttonYumlImage";
jQuery(a).showLoading();Action.ajax(Action.yumlImageCallback,"save=1")};Action.yumlImageCallback=function(b){var a=b.responseText;var c="#buttonYumlImage";
jQuery(c).hideLoading();window.open("scripts/compiler.php?asYuml="+a,"yumlClassDiagram");Page.showViewDone()};Action.uigu=function(){var a="#buttonUigu";
jQuery(a).showLoading();Action.ajax(Action.uiguCallback,"save=1")};Action.uiguCallback=function(c){var b=c.responseText;var a="#buttonUigu";
jQuery(a).hideLoading();window.open("scripts/compiler.php?asUI="+b,"showUserInterface");Page.showViewDone()};Action.showCodeInSeparateWindow=function(){codeWindow=window.open("","UmpleCode","height=700, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
codeWindow.document.write('<code><pre id="umpleCode">'+Page.getUmpleCode()+"</pre></code>");codeWindow.document.close()};Action.showEncodedURLCodeInSeparateWindow=function(){codeWindow=window.open("","UmpleCode","height=500, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
codeWindow.document.write('<code><pre id="umpleCode">'+Page.getEncodedURL()+"</pre></code>");codeWindow.document.close()};Action.simulateCode=function(){simulateButtonSelector="#buttonSimulateCode";
jQuery(simulateButtonSelector).showLoading();Action.ajax(Action.simulateCodeCallback,"language=Simulate")};Action.simulateCodeCallback=function(a){simulateButtonSelector="#buttonSimulateCode";
jQuery(simulateButtonSelector).hideLoading();var b=a.responseText;window.open("../umpleonline/simulate.php?model="+b,"umpleSimulator");
Page.showViewDone()};Action.classSelected=function(d){var e=Page.selectedClass;var f=d;if(e!=null){Page.selectedClass=null;jQuery("#"+e.id).css("background-color","white");
var a="#"+e.id+"_anchor";for(var b=0;b<8;b++){jQuery(a+b).hide()}}if(f!=null){jQuery("#umpleCanvas").addClass("unscrollable");Page.selectedClass=UmpleSystem.find(f.id);
jQuery("#"+f.id).css("background-color","#F3F6FB");var a="#"+f.id+"_anchor";var c="#"+f.id+"_hover";for(var b=0;b<8;b++){jQuery(a+b).show();
jQuery(c+b).hide()}}else{jQuery("#umpleCanvas").removeClass("unscrollable")}};Action.classHover=function(h,g){var b=h.currentTarget;if(!Action.diagramInSync){return
}if(Page.selectedClass!=null&&Page.selectedClass.id==b.id){return}var c=g?"block":"none";var a=jQuery("#"+b.id);if(g){a.css("background-color","#F3F6FB")
}else{a.css("background-color","white")}if(Page.canShowHovers()){var f=8;var e="#"+b.id+"_hover";for(var d=0;d<f;d++){if(g){jQuery(e+d).show()
}else{jQuery(e+d).hide()}}}};Action.unselectAll=function(){Action.classSelected(null);Action.associationSelected(null);Action.generalizationSelected(null)
};Action.classClicked=function(a){if(!Action.diagramInSync){return}Action.focusOn("umpleCanvas",true);Action.focusOn("umpleModelEditorText",false);
Action.unselectAll();Action.elementClicked=true;var b=a.currentTarget;Action.selectClass(b.id);if(Page.selectedItem=="DeleteEntity"){DiagramEdit.classDeleted(b.id)
}else{if(Page.selectedItem=="AddAssociation"){if(DiagramEdit.newAssociation==null){Action.canCreateByDrag=false;DiagramEdit.createAssociationPartOne(a)
}else{DiagramEdit.createAssociationPartTwo(a);setTimeout(function(){Action.canCreateByDrag=true},500)}}else{if(Page.selectedItem=="AddGeneralization"){if(DiagramEdit.newGeneralization==null){var c=DiagramEdit.createGeneralizationPartOne(a);
if(c){Action.canCreateByDrag=false}}else{DiagramEdit.createGeneralizationPartTwo(a);setTimeout(function(){Action.canCreateByDrag=true
},500)}}else{Action.classSelected(b)}}}};Action.associationClicked=function(a){if(!Action.diagramInSync){return}Action.elementClicked=true;
Action.unselectAll();var b=a.currentTarget;Action.associationSelected(b)};Action.generalizationClicked=function(a){if(!Action.diagramInSync){return
}Action.elementClicked=true;Action.unselectAll();var b=a.currentTarget;Action.generalizationSelected(b)};Action.associationHover=function(e,d){if(!Action.diagramInSync){return
}var g=e.currentTarget;var b=UmpleSystem.findAssociation(g.id);if(g!=null&&Page.canShowHovers()){var f=2;var a="#"+g.id+"_hover";for(var c=0;
c<f;c++){if(d){jQuery(a+c).show()}else{jQuery(a+c).hide()}}}};Action.generalizationHover=function(d,c){if(!Action.diagramInSync){return
}var e=d.currentTarget;if(e!=null&&Page.canShowHovers()){var a="#"+e.id+"_hover";for(var b=0;b<3;b++){if(c){jQuery(a+b).show()}else{jQuery(a+b).hide()
}}}};Action.associationSelected=function(e){var c=(e==null)?false:true;var a=null;if(Page.selectedItem=="DeleteEntity"&&e!=null){var f=false;
DiagramEdit.associationDeleted(e.id,f);return}if(e!=null){Page.selectedAssociation=e;a=e}else{if(Page.selectedAssociation!=null){a=Page.selectedAssociation;
Page.selectedAssociation=null}else{return}}var b=2;var g="#"+a.id+"_anchor";for(var d=0;d<b;d++){if(c){jQuery(g+d).show()}else{jQuery(g+d).hide()
}}};Action.generalizationSelected=function(e){var c=(e==null)?false:true;var a=null;if(Page.selectedItem=="DeleteEntity"&&e!=null){var f=false;
DiagramEdit.generalizationDeleted(e.id,f);return}if(e!=null){Page.selectedGeneralization=e;a=e}else{if(Page.selectedGeneralization!=null){a=Page.selectedGeneralization;
Page.selectedGeneralization=null}else{return}}var b=3;var g="#"+a.id+"_anchor";for(var d=0;d<b;d++){if(c){jQuery(g+d).show()}else{jQuery(g+d).hide()
}}};Action.generateCode=function(a,c){var b="#buttonGenerateCode";var e=c;var d;if(Page.getAdvancedMode()==0&&(c==="Cpp")){e="Experimental-"+c
}if(c==="StateTables"){d=StateTree.colourStateTables}if(c==="EventSequence"){d=StateTree.colourEventSequences}if(c==="stateDiagram"){e=c+"."+$("inputGenerateCode").value.split(":")[1]
}jQuery(b).showLoading();Action.ajax(function(f){Action.generateCodeCallback(f,a,d)},format("language={0}&languageStyle={1}",e,a),"true")
};Action.photoReady=function(){var a="#"+Page.umpleCanvasId();if(Page.isPhotoReady()){jQuery(a).addClass("photoReady")}else{jQuery(a).removeClass("photoReady")
}UmpleSystem.redrawCanvas()};Action.generateCodeCallback=function(b,d,a){Page.showGeneratedCode(b.responseText,d);Action.gentime=new Date().getTime();
if(a!==undefined){a()}var c="#buttonGenerateCode";jQuery(c).hideLoading();Page.showCodeDone()};Action.classMouseDown=function(a){if(!Action.canCreateByDrag){return
}if(Page.selectedItem=="AddAssociation"&&DiagramEdit.newAssociation==null){DiagramEdit.createAssociationPartOne(a)}else{if(Page.selectedItem=="AddGeneralization"&&DiagramEdit.newGeneralization==null){DiagramEdit.createGeneralizationPartOne(a)
}}};Action.classMouseUp=function(a){if(!Action.canCreateByDrag){return}if(Page.selectedItem=="AddAssociation"&&DiagramEdit.newAssociation!=null){DiagramEdit.createAssociationPartTwo(a)
}else{if(Page.selectedItem=="AddGeneralization"&&DiagramEdit.newGeneralization!=null){DiagramEdit.createGeneralizationPartTwo(a)}}};Action.mouseMove=function(a){Page.clickCount=0;
if(Page.selectedItem=="AddClass"){if(DiagramEdit.newClass==null){DiagramEdit.newClass=new UmpleClass();DiagramEdit.newClass.name="";DiagramEdit.newClass.id="tempClass"
}Action.drawClassOutline(a,DiagramEdit.newClass)}if(DiagramEdit.newAssociation!=null&&Page.selectedItem=="AddAssociation"){Action.drawAssociationLine(a,DiagramEdit.newAssociation)
}if(DiagramEdit.newGeneralization!=null&&Page.selectedItem=="AddGeneralization"){Action.drawGeneralizationLine(a,DiagramEdit.newGeneralization)
}};Action.drawClassOutline=function(a,g){var f="#"+Page.umpleCanvasId();var e=new UmplePosition(a.pageX,a.pageY+1,0,0);var j=e.subtract(UmpleSystem.position());
g.position=new UmplePosition(j.x,j.y,UmpleClassFactory.defaultSize.width,UmpleClassFactory.defaultSize.height);var k=g.drawableClassOutline();
jQuery(f).append(k);var h="#"+g.id;var b=h+"_width";var d=h+"_height";var c=new Object();c.left=e.x;c.top=e.y;jQuery(h).offset(c);jQuery(b).width(g.position.width);
jQuery(d).height(g.position.height)};Action.drawAssociationLine=function(c,b){var a="#"+Page.umpleCanvasId();var d=new UmplePosition(c.pageX,c.pageY,0,0);
b.classTwoPosition=d.subtract(UmpleSystem.position());jQuery(a).append(b.drawable())};Action.drawGeneralizationLine=function(d,g){var c="#"+Page.umpleCanvasId();
var a="#"+g.getElementId();var b=UmpleSystem.position();var f=d.pageX-5-b.x;var e=d.pageY+5-b.y;g.parentPosition=new UmplePosition(f,e,0,0);
jQuery(a).remove();jQuery(c).append(g.drawable(false))};Action.umpleCanvasClicked=function(b){if(Action.elementClicked){Action.elementClicked=false;
return}if(Page.selectedItem=="AddClass"){var a=new UmplePosition(Math.floor(b.pageX),Math.floor(b.pageY),0,0);DiagramEdit.addClass(a)
}else{if(Page.selectedItem=="AddAssociation"&&DiagramEdit.newAssociation!=null){if(Page.clickCount>1){DiagramEdit.removeNewAssociation()
}}else{if(Page.selectedItem=="AddGeneralization"&&DiagramEdit.newGeneralization!=null){if(Page.clickCount>1){DiagramEdit.removeNewGeneralization()
}}else{Action.unselectAll()}}}};Action.updateUmpleTextCallback=function(a){History.save(a.responseText,"TextCallback");Action.freshLoad=true;
Page.setUmpleCode(a.responseText);Page.hideLoading();if(DiagramEdit.textChangeQueue.length==0){DiagramEdit.pendingChanges=false}else{DiagramEdit.doTextUpdate()
}};Action.setExampleType=function setExampleType(){jQuery("#itemLoadExamples").hide();jQuery("#itemLoadExamples2").hide();jQuery("#itemLoadExamples3").hide();
if(Page.getExampleType()=="cdModels"){jQuery("#itemLoadExamples").show();jQuery("#defaultExampleOption").prop("selected",true)}else{if(Page.getExampleType()=="smModels"){jQuery("#itemLoadExamples2").show();
jQuery("#defaultExampleOption2").prop("selected",true)}else{jQuery("#itemLoadExamples3").show();jQuery("#defaultExampleOption3").prop("selected",true)
}}};Action.loadExample=function loadExample(){var h=this.dataset.diagramType;var f=jQuery(" option:selected",this);if(f.hasClass("openUmprOption")){location.href="http://umpr.umple.org?diagram-type="+h;
return}UmpleSystem.merge(null);Page.showCanvasLoading(true);Page.showModelLoading(true);Page.showLayoutLoading(true);Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode="+Page.getSelectedExample());
var a=Page.getSelectedExample().slice(0,-4);var h="";if(Page.useGvStateDiagram){h="&diagramtype=state";jQuery("#genjava").prop("selected",true)
}else{if(Page.useStructureDiagram){h="&diagramtype=structure&generateDefault=cpp";jQuery("#gencpp").prop("selected",true)}else{jQuery("#genjava").prop("selected",true)
}}var b="#buttonLarger";var e="#buttonSmaller";var c="#"+Page.umpleCanvasId();umpleCanvasWidth=jQuery(c).width();umpleCanvasHeight=jQuery(c).height();
var d=Page.getSelectedExample();var g="?example="+a+h;Page.setExampleMessage('<a href="'+g+'">URL for '+a+" example</a>");jQuery("#inputExample").blur()
};Action.loadExampleCallback=function(a){Action.freshLoad=true;Page.setUmpleCode(a.responseText);Page.hideLoading();History.save(a.responseText,"loadExampleCallback");
Action.updateUmpleDiagram();Action.setCaretPosition("0");Action.updateLineNumberDisplay()};Action.customSizeTyped=function(){if(Action.oldTimeout!=null){clearTimeout(Action.oldTimeout)
}var b=jQuery("#widthField").val();var a=jQuery("#heightField").val();Action.oldTimeout=setTimeout(function(){Page.setUmpleCanvasSize(b,a)
},Action.waiting_time)};Action.moveSelectedClass=function(a,b){if(a==null){return}a.position=a.position.add(b);UmpleSystem.updateClass(a);
Action.classSelected(a);if(Action.oldTimeout!=null){clearTimeout(Action.oldTimeout)}Action.oldTimeout=setTimeout(function(){DiagramEdit.classMoved(Page.selectedClass)
},1000)};Action.keyboardShortcut=function(b){if(!Page.shortcutsEnabled){return}var a=b.which;if(a==27){var c=Page.unselectAllToggleTools();
if(!c){jQuery(".visibleFocus").blur()}}else{if((a==8||a==46)&&jQuery("#umpleCanvasColumn").hasClass("focus")){if(Page.selectedClass&&jQuery("#"+Page.selectedClass.id).find("input").length==0){DiagramEdit.classDeleted(Page.selectedClass.id);
b.preventDefault()}else{if(Page.selectedAssociation){DiagramEdit.associationDeleted(Page.selectedAssociation.id);b.preventDefault()}else{if(Page.selectedGeneralization){DiagramEdit.generalizationDeleted(Page.selectedGeneralization.id);
b.preventDefault()}}}}}};Action.getCaretPosition=function(){var d=document.getElementById("umpleModelEditorText");var c=Action.getInputSelectionStart(d);
var a=1;var e=Page.getRawUmpleCode();for(var b=0;b<(c);b++){if(e.charAt(b)=="\n"){a++}if(Page.getAdvancedMode()==2&&b<15){Page.catFeedbackMessage("<"+b+" "+e.charAt(b)+"="+e.charCodeAt(b)+"> ")
}}return a};Action.getInputSelectionStart=function(d){var g=0,f,c,b,a,e;if(typeof d.selectionStart=="number"&&typeof d.selectionEnd=="number"){g=d.selectionStart;
if(Page.getAdvancedMode()==2){Page.setFeedbackMessage("Non-IE browser ")}}else{if(Page.getAdvancedMode()==2){Page.setFeedbackMessage("IE-type browser ")
}c=document.selection.createRange();if(c&&c.parentElement()==d){a=d.value.length;f=d.value.replace(/\r\n/g,"\n");b=d.createTextRange();
b.moveToBookmark(c.getBookmark());e=d.createTextRange();e.collapse(false);if(b.compareEndPoints("StartToEnd",e)>-1){g=a}else{g=-b.moveStart("character",-a);
g+=f.slice(0,g).split("\n").length-1}}}return g};Action.setCaretPosition=function(a){if(isNaN(a-0)){if(a=="av"){document.getElementById("advancedMode").value=1;
Page.setFeedbackMessage("");return}if(a=="db"){document.getElementById("advancedMode").value=2;Page.setFeedbackMessage("Debug Mode");
return}if(a.substr(0,2)=="cm"){if(a.substr(2,1)=="0"&&Page.codeMirrorOn){Page.setFeedbackMessage("Turning code mirroring off");Page.codeMirrorEditor.toTextArea();
Page.codeMirrorOn=false;jQuery("#linenum").val("0")}else{if(a.substr(2,1)=="1"&&!Page.codeMirrorOn){Page.initCodeMirrorEditor();jQuery("#linenum").val("0")
}}return}else{if(!Action.selectMatchingText(a)){Page.setFeedbackMessage('Line number or word "'+a+'" not located');setTimeout(function(){if(true){Page.setFeedbackMessage("")
}},3000)}return}}if(Page.codeMirrorOn){Page.codeMirrorEditor.setSelection({line:a-1,ch:0},{line:a-1,ch:999999});Page.codeMirrorEditor.focus();
return}var f=document.getElementById("umpleModelEditorText");var d=0;var c=-1;if(a<1){c=0}else{var g=Page.getRawUmpleCode();for(var e=0;
e<g.length;e++){if(g.charAt(e)=="\n"){a--;if(a==1){d=e+1}if(a==0){c=e;break}}}if(c==-1){c=g.length;if(a!=1){d=c}}}if(f.setSelectionRange){f.focus();
f.setSelectionRange(d,c)}else{if(f.createTextRange){var b=f.createTextRange();b.collapse(true);b.moveEnd("character",c);b.moveStart("character",d);
b.select()}}};Action.selectMatchingText=function(b){if(Page.codeMirrorOn){var a=Page.codeMirrorEditor.getSearchCursor(b);if(!a.findNext()){return false
}Page.codeMirrorEditor.setSelection(a.from(),a.to());Page.codeMirrorEditor.focus();return true}return false};Action.selectItem=function(e,b){if(Page.codeMirrorOn){var a=Page.codeMirrorEditor.getSearchCursor(e);
if(!a.findNext()){return}var h=a.from();var c=new Object();c.line=Page.codeMirrorEditor.lineCount();c.ch=9999;a=Page.codeMirrorEditor.getSearchCursor(b,a.to());
while(a.findNext()){var f=a.from();innerCursor=Page.codeMirrorEditor.getSearchCursor(new RegExp("//"),f);var d=innerCursor.findPrevious();
if(d&&innerCursor.from().line==f.line){continue}innerCursor=Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"),f);var d=innerCursor.findPrevious();
if(d){if(d[0]==="/*"){innerCursor=Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"),f);var d=innerCursor.findNext();if(d){var g=innerCursor.from();
if(g.line>f.line||(g.line==f.line&&g.ch>=f.ch)){continue}}}}c.line=f.line-1;c.ch=999;break}Page.codeMirrorEditor.setSelection(h,c);return
}return};Action.selectMethod=function(b,e,d){var c=new RegExp(d+" "+e+" "+b+"(\\s|[(])");var a=new RegExp("(public|protected|private|class) [A-Za-z]");
Action.selectItem(c,a)};Action.selectClass=function(c){var b=new RegExp("(class|interface|trait) "+c+"($|\\s|[{])");var a=new RegExp("(class|interface|trait) [A-Za-z]");
Action.selectItem(b,a)};Action.selectStateInClass=function(a,b){if(Page.codeMirrorOn){}};Action.delayedFocus=function(a){var b=document.getElementById("umpleModelEditorText");
setTimeout(function(){b.focus()},a)};Action.updateLineNumberDisplay=function(){jQuery("#linenum").val(Action.getCaretPosition())};Action.umpleTyped=function(a){if(Page.getAdvancedMode()=="2"){Page.catFeedbackMessage("["+a.keyCode+"] ")
}Action.updateLineNumberDisplay();var b=a.keyCode;if(b>=33&&b<=40){return}var c=a.target.id;Action.umpleTypingActivity(c)};Action.umpleCodeMirrorCursorActivity=function(){var a=Page.codeMirrorEditor.getCursor(true).line+1;
jQuery("#linenum").val(a)};Action.umpleCodeMirrorTypingActivity=function(){if(Action.freshLoad==false){Page.codeMirrorEditor.save();Action.umpleTypingActivity("codeMirrorEditor")
}else{Action.freshLoad=false}};Action.trimMultipleNonPrintingAndComments=function(a){a=Action.removeComments(a);a=a.replace(/[^\x21-\x7E]+/g," ");
a=a.replace(/^\s+|\s+$/g,"");return a};Action.removeComments=function(d){var b="_"+ +new Date(),c=[],a=0;return(d.replace(/(['"])(\\\1|.)+?\1/g,function(e){c[a]=e;
return(b+"")+a++}).replace(/([^\/])(\/(?!\*|\/)(\\\/|.)+?\/[gim]{0,3})/g,function(f,e,g){c[a]=g;return e+(b+"")+a++}).replace(/\/\/.*?\/?\*.+?(?=\n|\r|$)|\/\*[\s\S]*?\/\/[\s\S]*?\*\//g," ").replace(/\/\/.+?(?=\n|\r|$)|\/\*[\s\S]+?\*\//g," ").replace(RegExp("\\/\\*[\\s\\S]+"+b+"\\d+","g")," ").replace(RegExp(b+"(\\d+)","g"),function(e,f){return c[f]
}))};Action.umpleTypingActivity=function(a){if(Action.manualSync&&Action.diagramInSync){if(jQuery("#umpleCanvasColumn").is(":visible")){Page.enablePaletteItem("buttonSyncDiagram",true)
}Action.diagramInSync=false;Page.enableDiagram(false)}if(Action.oldTimeout!=null){clearTimeout(Action.oldTimeout)}Action.oldTimeout=setTimeout('Action.processTyping("'+a+'",'+false+")",Action.waiting_time)
};Action.processTyping=function(b,a){History.save(Page.getUmpleCode(),"processTyping");Page.setExampleMessage("");if(!Action.manualSync||a){if(b=="umpleModelEditorText"||b=="codeMirrorEditor"){Action.updateLayoutEditorAndDiagram()
}else{Action.updateUmpleDiagramForce(false)}Action.diagramInSync=true;Page.enablePaletteItem("buttonSyncDiagram",false);Page.enableDiagram(true)
}};Action.updateLayoutEditorAndDiagram=function(){Action.ajax(Action.updateUmpleLayoutEditor,"language=Json")};Action.updateUmpleLayoutEditor=function(a){var d=a.responseText.split("URL_SPLIT");
var c=d[0];var b=d[1];if(b==null||b==undefined){b=a.responseText}Page.showLayoutLoading();Action.ajax(Action.updateUmpleLayoutEditorCallback,format("action=addPositioning&actionCode={0}",b))
};Action.updateUmpleLayoutEditorCallback=function(a){var b=a.responseText;var c=Page.splitUmpleCode(b)[1];Page.setUmplePositioningCode(c);
Page.hideLoading();Action.updateUmpleDiagramForce(false)};Action.updateUmpleDiagram=function(){return Action.updateUmpleDiagramForce(true)
};Action.updateUmpleDiagramForce=function(b){var a=Action.trimMultipleNonPrintingAndComments(Page.getUmpleCode());if(!b){if(a==Action.savedCanonical){return
}}Action.savedCanonical=a;Page.showCanvasLoading();if(Page.useEditableClassDiagram){language="language=Json"}else{if(Page.useJointJSClassDiagram){language="language=JsonMixed"
}else{if(Page.useGvClassDiagram){if(Page.showTraits){language="language=traitDiagram"}else{language="language=classDiagram"}}else{if(Page.useGvStateDiagram){language="language=stateDiagram"
}else{if(Page.useStructureDiagram){language="language=StructureDiagram"}}}}}if(Page.useGvStateDiagram){if(!Page.showActions){language=language+".hideactions"
}if(Page.showTransitionLabels){language=language+".showtransitionlabels"}if(Page.showGuardLabels){language=language+".showguardlabels"
}language=language+"."+$("inputGenerateCode").value.split(":")[1]}if(Page.useGvClassDiagram){if(Page.showMethods){language=language+".showmethods"
}if(!Page.showAttributes){language=language+".hideattributes"}}Action.ajax(Action.updateUmpleDiagramCallback,language)};Action.updateUmpleDiagramCallback=function(response){var diagramCode="";
var errorMessage="";diagramCode=Action.getDiagramCode(response.responseText);errorMessage=Action.getErrorCode(response.responseText);
if(diagramCode==null||diagramCode==""||diagramCode=="null"){Page.enableDiagram(false);Action.diagramInSync=false;Page.setFeedbackMessage('The Umple model/code cannot be compiled; <a href="#errorClick">see explanation at the bottom.</a> To fix: edit the text or click undo')
}else{if(!Action.diagramInSync){Page.enableDiagram(true);Action.diagramInSync=true}Page.setFeedbackMessage("");Page.hideGeneratedCode();
if(Page.useEditableClassDiagram){var newSystem=Json.toObject(diagramCode);UmpleSystem.merge(newSystem);if(Page.showMethods||!Page.showAttributes){UmpleSystem.update()
}if(Page.readOnly){jQuery("span.editable").addClass("uneditable")}}else{if(Page.useJointJSClassDiagram){var model=JSON.parse(diagramCode);
var umpleCanvas=jQuery("#umpleCanvas");var paper=JJSdiagram.initJJSDiagram(umpleCanvas,model);var MouseWheelHandler=function(event){var delta=Math.max(-1,Math.min(1,(event.wheelDelta||-event.detail)));
if(event.altKey===true){var paperHeight=paper.options.height;var paperWidth=paper.options.width;var scaleFactor=1+(Math.abs(delta)/(delta*10));
paper.setDimensions(paperWidth*scaleFactor,paperHeight*scaleFactor);paper.scaleContentToFit({padding:15})}};var paperHolder=document.getElementById("umpleCanvas");
if(paperHolder.addEventListener){paperHolder.addEventListener("mousewheel",MouseWheelHandler,false);paperHolder.addEventListener("DOMMouseScroll",MouseWheelHandler,false)
}else{paperHolder.attachEvent("onmousewheel",MouseWheelHandler)}jQuery("#jjsPaper").click(function(){Action.focusOn(Page.umpleCanvasId(),true)
})}else{if(Page.useGvClassDiagram||Page.useGvStateDiagram){jQuery("#umpleCanvas").html(format("{0}",diagramCode))}else{if(Page.useStructureDiagram){jQuery("#umpleCanvas").html('<svg id="svgCanvas"></svg>');
eval(diagramCode)}}}}}if(errorMessage!=""){Page.showGeneratedCode(errorMessage,"diagramUpdate")}Page.hideLoading()};Action.getDiagramCode=function(c){var a="";
if(Page.useEditableClassDiagram||Page.useJointJSClassDiagram){a=c.split("URL_SPLIT")[1];if(a=="null"){a=""}}else{if(Page.useGvClassDiagram||Page.useGvStateDiagram){var b=c.split("<svg width=");
if(b.length>1&&b[1].length>100){a="<svg width="+b[1];a=a.replace(/<\/svg>$/,"")}}else{if(Page.useStructureDiagram){a=c.split("<p>URL_SPLIT")[1];
a=a.replace(/##CANVAS_ID##/g,"svgCanvas");a=jQuery("<div/>").html(a).text()}}}return a};Action.getErrorCode=function(c){var a="";if(Page.useEditableClassDiagram||Page.useStructureDiagram){a=c.split("URL_SPLIT")[0];
if(a=="<p>"){a=""}}else{if(Page.useGvClassDiagram||Page.useGvStateDiagram){var d=c.split("<svg width=")[0];var b=d.split("errorRow");
if(b.length>1){a=d.split("<\/script>&nbsp;")[0]}}}return a};Action.classResizing=function(e,g){var f=e.target.id;var a=UmpleSystem.find(f);
var c="#"+f;var d=Math.round(jQuery(c).width());var b=Math.round(jQuery(c).height());UmpleSystem.updatingSize(a,d,b)};Action.associationSnap=function(h,g,a){var b=jQuery(a).prop("id");
var d=b.substr(0,b.lastIndexOf("_"));var e=b.substr(b.lastIndexOf("_")+"anchor".length+1);var c=UmpleSystem.findAssociation(d);var j=c.getClass(e);
var f=UmpleClassFactory.perimeterPosition(j,new UmplePosition(h,g,0,0),UmpleSystem.position());return[f.x,f.y]};Action.associationSnapClassReady=function(b,d,a){var c=UmpleClassFactory.perimeterPosition(a,new UmplePosition(b,d,0,0),UmpleSystem.position());
return[c.x,c.y]};Action.updateMovedAssociation=function(h,a){jQuery(h).show();var c=jQuery(h).offset();var b=jQuery(h).prop("id");jQuery(h).hide();
var f=Math.round(c.left);var e=Math.round(c.top);var g=Action.associationSnap(f,e,h);var d=(new UmplePosition(g[0],g[1],0,0));if(b.endsWith("_anchor0")){a.setOffsetOnePosition(d)
}else{a.setOffsetTwoPosition(d)}UmpleSystem.redrawAssociation(a);Action.associationSelected(null)};Action.validateAttributeName=function(a){return a.length!=0&&(a.match(/^[_a-zA-Z0-9]+$/)||a.match(/^[_a-zA-Z0-9]+[\u0020]*:[\u0020]*[_a-zA-Z0-9]+(\[\])?$/))
};Action.validateMethodName=function(a){return a.length!=0&&a.match(/^[-+#]?\s*[_a-zA-Z0-9]+\s*\(([_a-zA-Z0-9]+(\[\])?(,\s*[_a-zA-Z0-9]+(\[\])?)*)?\)(\s*:\s*[_a-zA-Z0-9]+(\[\])?)?$/)
};Action.toggleAttributes=function(){Page.showAttributes=!Page.showAttributes;Action.redrawDiagram()};Action.toggleMethods=function(){Page.showMethods=!Page.showMethods;
Action.redrawDiagram()};Action.toggleActions=function(){Page.showActions=!Page.showActions;Action.redrawDiagram()};Action.toggleTransitionLabels=function(){Page.showTransitionLabels=!Page.showTransitionLabels;
Action.redrawDiagram()};Action.toggleGuardLabels=function(){Page.showGuardLabels=!Page.showGuardLabels;Action.redrawDiagram()};Action.toggleTraits=function(){Page.showTraits=!Page.showTraits;
Action.redrawDiagram()};Action.redrawDiagram=function(){UmpleSystem.merge(null);var a=jQuery("#umpleCanvas");a.html("");if(!Action.manualSync){Action.updateUmpleDiagram();
Action.diagramInSync=true;Page.enableDiagram(true)}if(Action.manualSync&&!Action.diagramInSync){Page.enablePaletteItem("buttonSyncDiagram",true)
}if(!Action.manualSync||Action.diagramInSync){Page.enableCheckBoxItem("buttonPhotoReady","ttPhotoReady",true);Page.enableCheckBoxItem("buttonManualSync","ttManualSync",true);
Page.enablePaletteItem("buttonAddClass",true);Page.enablePaletteItem("buttonAddAssociation",true);Page.enablePaletteItem("buttonAddGeneralization",true);
Page.enablePaletteItem("buttonDeleteEntity",true);Page.initToggleTool("buttonAddClass");Page.initToggleTool("buttonAddAssociation");Page.initToggleTool("buttonAddGeneralization");
Page.initToggleTool("buttonDeleteEntity")}};InlineEditor.elementChanged=function(f,a,d){var c=f.attr("name");var e=f.attr("id");if(c=="className"){var g=e.substr(0,e.length-"_name".length);
DiagramEdit.classNameChanged(g,a,d)}else{if(c=="attributeEdit"){var b=e.substr(e.lastIndexOf("_")+1);var g=e.substr(0,e.length-"_attribute_".length-b.length);
DiagramEdit.attributeNameChanged(g,b,a,d)}else{if(c=="methodEdit"){var b=e.substr(e.lastIndexOf("_")+1);var g=e.substr(0,e.length-"_method_".length-b.length);
DiagramEdit.methodChanged(g,b,a,d)}else{if(c=="attributeNew"){var g=e.substr(0,e.length-"_newAttribute".length);DiagramEdit.attributeNew(g,d)
}else{if(c=="methodNew"){var g=e.substr(0,e.length-"_newMethod".length);DiagramEdit.methodNew(g,d)}}}}}};Action.enableManualSync=function(a){var b=jQuery("#buttonManualSync");
var c=jQuery("#buttonSyncDiagram");if(a==undefined){a=b.is(":checked")}if(a){Action.manualSync=true}else{Action.manualSync=false;Action.processTyping("umpleModelEditorText",true);
Page.enablePaletteItem("buttonSyncDiagram",false)}};Action.generateStructureDiagramFile=function(){var a=Page.getFilename().slice(0,-9)+"structureDiagram.svg";
var b=jQuery("#innerGeneratedCodeRow").html().slice(4,-1);b=format('<svg xmlns="http://www.w3.org/2000/svg" {0}>',b);jQuery("#buttonStructureLink").showLoading();
Ajax.sendRequest("scripts/compiler.php",Action.generateStructureDiagramFileCallback,format("save=1&filename={0}&svgContent={1}",a,b))
};Action.generateStructureDiagramFileCallback=function(a){jQuery("#buttonStructureLink").hideLoading();Page.toggleStructureDiagramLink(true,a.responseText)
};Action.ajax=function(f,c,e){var b=Page.getUmpleCode();var d=encodeURIComponent(b);var a=Page.getFilename();var e="true";Ajax.sendRequest("scripts/compiler.php",f,format("{0}&error={3}&umpleCode={1}&filename={2}",c,d,a,e))
};if(navigator.appVersion.indexOf("Mac")!=-1){jQuery(document).ready(function(){jQuery("#undosmall").html("[cmd+z]");jQuery("#redosmall").html("[cmd+shift+z]")
});Mousetrap.bind(["command+z"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.undo()}a.preventDefault()});Mousetrap.bind(["command+shift+z"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.redo()
}a.preventDefault()})}else{jQuery(document).ready(function(){jQuery("#undosmall").html("[ctrl+z]");jQuery("#redosmall").html("[ctrl+y]")
});Mousetrap.bind(["ctrl+z"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.undo()}a.preventDefault()});Mousetrap.bind(["ctrl+y"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.redo()
}a.preventDefault()})}Mousetrap.bind(["up"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(0,-5,0,0));
return false}});Mousetrap.bind(["shift+up"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(0,-1,0,0));
return false}});Mousetrap.bind(["down"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(0,5,0,0));
return false}});Mousetrap.bind(["shift+down"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(0,1,0,0));
return false}});Mousetrap.bind(["left"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(-5,0,0,0));
return false}});Mousetrap.bind(["shift+left"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(-1,0,0,0));
return false}});Mousetrap.bind(["right"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(5,0,0,0));
return false}});Mousetrap.bind(["shift+right"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")){Action.moveSelectedClass(Page.selectedClass,new UmplePosition(1,0,0,0));
return false}});Mousetrap.bind(["ctrl+e"],function(a){Page.clickShowEditableClassDiagram();return false});Mousetrap.bind(["ctrl+j"],function(a){Page.clickShowJointJSClassDiagram();
return false});Mousetrap.bind(["ctrl+g"],function(a){Page.clickShowGvClassDiagram();return false});Mousetrap.bind(["ctrl+s"],function(a){Page.clickShowGvStateDiagram();
return false});Mousetrap.bind(["ctrl+l"],function(a){Page.clickShowStructureDiagram();return false});Mousetrap.bind(["ctrl+t","ctrl+alt+shift+t"],function(a){Page.clickShowHideText();
return false});Mousetrap.bind(["ctrl+d"],function(a){Page.clickShowHideCanvas();return false});Mousetrap.bind(["ctrl+n","ctrl+alt+n"],function(a){Page.clickShowHideMenu();
return false});Mousetrap.bind(["ctrl+a"],function(a){Page.clickToggleAttributes();return false});Mousetrap.bind(["ctrl+m"],function(a){Page.clickToggleMethods();
return false});Mousetrap.bind(["ctrl+r"],function(a){Page.clickToggleTraits();return false});Mousetrap.bind(["ctrl+i"],function(a){Page.clickToggleTransitionLabels();
return false});Mousetrap.bind(["ctrl+k"],function(a){Page.clickToggleGuardLabels();return false});Mousetrap.bind(["g"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")&&Page.selectedAssociation==null&&Page.selectedGeneralization==null){if(Page.selectedClass==null||(Page.selectedClass&&jQuery("#"+Page.selectedClass.id).find("input").length==0)){jQuery("#buttonAddGeneralization").click()
}}});Mousetrap.bind(["a"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")&&Page.selectedAssociation==null&&Page.selectedGeneralization==null){if(Page.selectedClass==null||(Page.selectedClass&&jQuery("#"+Page.selectedClass.id).find("input").length==0)){jQuery("#buttonAddAssociation").click()
}}});Mousetrap.bind(["c"],function(a){if(jQuery("#umpleCanvasColumn").hasClass("focus")&&Page.selectedAssociation==null&&Page.selectedGeneralization==null){if(Page.selectedClass==null||(Page.selectedClass&&jQuery("#"+Page.selectedClass.id).find("input").length==0)){jQuery("#buttonAddClass").click()
}}});Action.toggleTabsCheckbox=function(a){if($("inputGenerateCode").value.split(":")[1]=="TextUml"){a="TextUml"}if(a=="java"||a=="php"||a=="cpp"||a=="ruby"||a=="sql"){jQuery("#ttTabsCheckbox").show();
jQuery("#tabRow").show()}else{jQuery("#ttTabsCheckbox").hide();jQuery("#tabRow").hide();if(jQuery("#buttonTabsCheckbox").is(":checked")){jQuery("#buttonTabsCheckbox").click()
}}};Action.toggleTabs=function(){if(jQuery("#buttonTabsCheckbox").is(":checked")){jQuery("#tabRow").show();jQuery("#innerGeneratedCodeRow").hide();
jQuery("#tabButton1").click()}else{jQuery("#tabRow").hide();jQuery("#innerGeneratedCodeRow").show();jQuery("#innerGeneratedCodeRow").nextAll().hide()
}};Action.generateTabsCode=function(g){var b=[];var f=0;var e="";var d=[];var a="";var c=false;g.split("URL_SPLIT")[1].split("\n").forEach(function(h){if(h.indexOf("//%%")>=0){f++;
if(f>1){b[f]+="</p>"}strFileName=h.slice(14);strFileName=strFileName.substr(0,strFileName.indexOf(" "));d[f]=strFileName;jQuery("#generatedCodeRow").append("<div id='innerGeneratedCodeRow"+f+"'></div>");
b[f]="<p>URL_SPLIT";c=true}else{if(!c){b[f]+=h+"\n"}else{c=false}}});b[f]+="</p>";for(i=1;i<=f;i++){jQuery("#tabRow").append("<button type='button' id='tabButton"+i+"'>"+d[i]+"</button>");
jQuery("#tabButton"+i).click({code:b[i],tabnumber:i},showTab)}};function showTab(a){jQuery("#innerGeneratedCodeRow").nextAll().hide();
jQuery("#innerGeneratedCodeRow"+a.data.tabnumber).show();Page.showGeneratedCode(a.data.code,$("inputGenerateCode").value.split(":")[0],a.data.tabnumber);
jQuery(".line").last().hide();jQuery(".line").last().hide();jQuery("#innerGeneratedCodeRow").hide()}DiagramEdit=new Object();DiagramEdit.textChangeQueue=[];
DiagramEdit.pendingChanges=false;DiagramEdit.newClass=null;DiagramEdit.newAssociation=null;DiagramEdit.newGeneralization=null;DiagramEdit.updateUmpleText=function(a){if(DiagramEdit.textChangeQueue.length==0&&!DiagramEdit.pendingChanges){DiagramEdit.pendingChanges=true;
DiagramEdit.textChangeQueue.push(a);DiagramEdit.doTextUpdate()}else{DiagramEdit.textChangeQueue.push(a)}};DiagramEdit.doTextUpdate=function(){update=DiagramEdit.textChangeQueue.shift();
if(update.codeChange){Page.hideGeneratedCode()}Action.ajax(Action.updateUmpleTextCallback,update.actionCode)};DiagramEdit.addClass=function(b){DiagramEdit.removeNewClass();
var a=UmpleSystem.createClass(b);var c=Json.toString(a);if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();
Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=addClass&actionCode={0}",c),codeChange:true})};DiagramEdit.addAssociation=function(a){DiagramEdit.removeNewAssociation();
var c=UmpleSystem.createAssociation(a.classOneId,a.classTwoId,a.classOnePosition.add(UmpleSystem.position()),a.classTwoPosition.add(UmpleSystem.position()));
var b=Json.toString(c);if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=addAssociation&actionCode={0}",b),codeChange:true})
};DiagramEdit.addGeneralization=function(a){DiagramEdit.removeNewGeneralization();UmpleSystem.createGeneralization(a.childId,a.parentId);
var b=Json.toString(a);if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=addGeneralization&actionCode={0}",b),codeChange:true})
};DiagramEdit.createAssociationPartOne=function(d){var e=new UmplePosition(d.pageX,d.pageY,0,0);var c=UmpleSystem.position();var b=e.x-c.x;
var a=e.y-c.y;Action.classSelected(d.currentTarget);DiagramEdit.newAssociation=new UmpleAssociation();DiagramEdit.newAssociation.classOneId=d.currentTarget.id;
DiagramEdit.newAssociation.classOnePosition=new UmplePosition(b,a,0,0)};DiagramEdit.createAssociationPartTwo=function(a){var b=new UmplePosition(a.pageX,a.pageY,0,0);
Action.classSelected(a.currentTarget);if(DiagramEdit.newAssociation.classOneId<=a.currentTarget.id){DiagramEdit.newAssociation.classTwoId=a.currentTarget.id;
DiagramEdit.newAssociation.classTwoPosition=b.subtract(UmpleSystem.position())}else{DiagramEdit.newAssociation.classTwoId=DiagramEdit.newAssociation.classOneId;
DiagramEdit.newAssociation.classTwoPosition=DiagramEdit.newAssociation.classOnePosition;DiagramEdit.newAssociation.classOneId=a.currentTarget.id;
DiagramEdit.newAssociation.classOnePosition=b.subtract(UmpleSystem.position())}DiagramEdit.addAssociation(DiagramEdit.newAssociation)
};DiagramEdit.createGeneralizationPartOne=function(b){var a=UmpleSystem.find(b.currentTarget.id);if(a.extendsClass!=null){return false
}Action.classSelected(b.currentTarget);DiagramEdit.newGeneralization=new UmpleGeneralization();DiagramEdit.newGeneralization.childId=b.currentTarget.id;
umpleSystem=UmpleSystem.position();childPositionX=Dom.x(b)-umpleSystem.x;childPositionY=Dom.y(b)-umpleSystem.y;DiagramEdit.newGeneralization.childPosition=new UmplePosition(childPositionX,childPositionY,0,0)
};DiagramEdit.createGeneralizationPartTwo=function(a){Action.classSelected(a.currentTarget);DiagramEdit.newGeneralization.parentId=a.currentTarget.id;
DiagramEdit.newGeneralization.parentPosition=new UmplePosition(Dom.x(a),Dom.y(a),0,0);DiagramEdit.addGeneralization(DiagramEdit.newGeneralization)
};DiagramEdit.classMoved=function(d){var e=UmpleSystem.find(d.id);var c=jQuery("#"+e.id);newPositionX=Math.floor(c.offset().left);newPositionY=Math.floor(c.offset().top);
UmpleSystem.updatePosition(e,newPositionX,newPositionY);var a=Json.toString(e);var b=Page.getUmpleCode();Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",a),codeChange:false});
Action.classSelected(d);UmpleSystem.trimOverlappingAssociations(e)};DiagramEdit.classResized=function(a,m){var n=a.target;var c=n.id;
var o=UmpleSystem.find(c);UmpleSystem.updateClass(o);UmpleSystem.redrawGeneralizationsTo(o,b);for(var e=0;e<UmpleSystem.umpleAssociations.length;
e++){var l=UmpleSystem.umpleAssociations[e];if(l.contains(o)){var j=l.classOneId==o.id;var d=j?l.offsetOnePosition:l.offsetTwoPosition;
var k=j?"_anchor0":"_anchor1";var h="#"+l.id+k;var b=true;DiagramEdit.associationMoved(h,b)}}var f=Json.toString(o);var g=Page.getUmpleCode();
Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",f),codeChange:false});Action.classSelected(n)
};DiagramEdit.associationMoved=function(d,f){if(DiagramEdit.newAssociation!=null){DiagramEdit.removeNewAssociation()}if(f==undefined){f=false
}var b=jQuery(d).attr("id");var c=b.substr(0,b.length-"_anchorX".length);var a=UmpleSystem.findAssociation(c);Action.updateMovedAssociation(d,a);
var e=Json.toString(a);Page.showLayoutLoading();DiagramEdit.updateUmpleText({codeChange:false,actionCode:format("action=editAssociation&actionCode={0}",e)})
};DiagramEdit.regularAssociationMoving=function(b){if(DiagramEdit.newAssociation==null){var c=jQuery(b).attr("id");var a=c.substr(0,c.length-"_anchorX".length);
var d=UmpleSystem.findAssociation(a);var h=new UmpleAssociation();if(c.endsWith("_anchor0")){h.classOneId=d.classTwoId;h.classOnePosition=d.classTwoPosition;
h.offsetOnePosition=d.offsetTwoPosition}else{h.classOneId=d.classOneId;h.classOnePosition=d.classOnePosition;h.offsetOnePosition=d.offsetOnePosition
}DiagramEdit.newAssociation=h}var e=jQuery(b).offset();var j=Action.associationSnap(Math.round(e.left),Math.round(e.top),b);var g=new UmplePosition(j[0],j[1]);
DiagramEdit.newAssociation.classTwoPosition=g.subtract(UmpleSystem.position());DiagramEdit.newAssociation.offsetTwoPosition=new UmplePosition(0,0,0,0);
var f="#"+Page.umpleCanvasId();jQuery(f).append(DiagramEdit.newAssociation.drawable())};DiagramEdit.reflexiveAssociationMoving=function(b){var c=jQuery(b).attr("id");
var a=c.substr(0,c.length-"_anchorX".length);var d=UmpleSystem.findAssociation(a);if(DiagramEdit.newAssociation==null){DiagramEdit.newAssociation=new UmpleAssociation();
DiagramEdit.newAssociation.classOneId=d.classOneId;DiagramEdit.newAssociation.classTwoId=d.classTwoId;DiagramEdit.newAssociation.classOnePosition=d.classOnePosition;
DiagramEdit.newAssociation.classTwoPosition=d.classTwoPosition;DiagramEdit.newAssociation.offsetOnePosition=d.offsetOnePosition;DiagramEdit.newAssociation.offsetTwoPosition=d.offsetTwoPosition;
DiagramEdit.newAssociation.id=DiagramEdit.newAssociation.getElementId()}var f=jQuery(b).offset();var j=Action.associationSnap(Math.round(f.left),Math.round(f.top),b);
var h=(new UmplePosition(j[0],j[1],0,0));var e=h.subtract(UmpleSystem.position());e.x=e.x-DiagramEdit.newAssociation.classOnePosition.x;
e.y=e.y-DiagramEdit.newAssociation.classOnePosition.y;if(c.endsWith("_anchor0")){DiagramEdit.newAssociation.offsetOnePosition=e}else{DiagramEdit.newAssociation.offsetTwoPosition=e
}var g="#"+Page.umpleCanvasId();jQuery(g).append(DiagramEdit.newAssociation.drawableReflexive())};DiagramEdit.classNameChanged=function(c,e,b){if(b.length=0||!b.match(/^[_a-zA-Z0-9]+$/)){Action.updateUmpleDiagram();
var f="Class names must be alphanumeric. &lt;"+(b.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.";
setTimeout(function(){Page.setFeedbackMessage(f)},2000);setTimeout(function(){if(true){Page.setFeedbackMessage("")}},10000)}else{var a=UmpleSystem.renameClass(c,e,b);
a.position.width=UmpleClassFactory.defaultSize.width;var d=Json.toString(a);delete a.oldname;Page.showModelLoading();Page.showLayoutLoading();
DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",d),codeChange:true})}};DiagramEdit.attributeNameChanged=function(c,e,f,b){if(!Action.validateAttributeName(b)){Action.updateUmpleDiagram();
setTimeout(function(){Page.setFeedbackMessage("UML Attributes must be alphanumeric with an optional type after a colon. &lt;"+(b.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.")
},2000);setTimeout(function(){if(true){Page.setFeedbackMessage("")}},10000)}else{var a=UmpleSystem.find(c);a.attributes[e].set(b);UmpleSystem.redraw(a);
var d=Json.toString(a);Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",d),codeChange:true});
a.resetAttribute(e)}};DiagramEdit.attributeNew=function(d,b){if(!Action.validateAttributeName(b)){Action.updateUmpleDiagram();setTimeout(function(){Page.setFeedbackMessage("UML Attributes must be alphanumeric with an optional type after a colon. &lt;"+(b.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.")
},2000);setTimeout(function(){if(true){Page.setFeedbackMessage("")}},10000)}else{var a=UmpleSystem.find(d);var c=a.addAttribute(b);var e=Json.toString(a);
Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",e),codeChange:true});a.resetAttribute(c);
UmpleSystem.updateClass(a);UmpleSystem.redrawGeneralizationsTo(a);UmpleSystem.trimOverlappingAssociations(a)}};DiagramEdit.classDeleted=function(d){var a=true;
var g=UmpleSystem.find(d);var j=[];var b=[];for(var e=0;e<UmpleSystem.umpleAssociations.length;e++){var f=UmpleSystem.umpleAssociations[e];
if(f.contains(g)){j.push(f.id)}}for(var e=0;e<UmpleSystem.umpleClasses.length;e++){var c=UmpleSystem.umpleClasses[e];if(c.extendsClass==g.id){b.push(c.id+"_generalization")
}}for(var e=0;e<j.length;e++){DiagramEdit.associationDeleted(j[e],a)}for(var e=0;e<b.length;e++){DiagramEdit.generalizationDeleted(b[e],a)
}var k=UmpleSystem.removeClass(d);var h=Json.toString(k);if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();
Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=removeClass&actionCode={0}",h),codeChange:true})};DiagramEdit.methodNew=function(d,b){if(!Action.validateMethodName(b)){Action.updateUmpleDiagram();
setTimeout(function(){Page.setFeedbackMessage("Invalid UML Method. &lt;"+(b.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.")
},2000);setTimeout(function(){if(true){Page.setFeedbackMessage("")}},10000)}else{var a=UmpleSystem.find(d);var c=a.addMethod(b);var e=Json.toString(a);
Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",e),codeChange:true});a.resetMethod(c);
UmpleSystem.updateClass(a);UmpleSystem.redrawGeneralizationsTo(a);UmpleSystem.trimOverlappingAssociations(a)}};DiagramEdit.methodChanged=function(c,e,f,b){if(!Action.validateMethodName(b)){Action.updateUmpleDiagram();
setTimeout(function(){Page.setFeedbackMessage("Invalid UML Method. &lt;"+(b.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.")
},2000);setTimeout(function(){if(true){Page.setFeedbackMessage("")}},10000)}else{var a=UmpleSystem.find(c);a.methods[e].set(b);UmpleSystem.redraw(a);
var d=Json.toString(a);Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",d),codeChange:true});
a.resetMethod(e)}};DiagramEdit.methodDelete=function(b,d){var a=UmpleSystem.find(b);a.removeMethod(d);var e=jQuery("#"+a.id);a.position.height=28+17*(a.attributes.size()+a.methods.size());
a.position.width=UmpleClassFactory.defaultSize.width;var c=Json.toString(a);Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",c),codeChange:true});
a.resetMethod(d);UmpleSystem.updateClass(a);UmpleSystem.redrawGeneralizationsTo(a);UmpleSystem.trimOverlappingAssociations(a)};DiagramEdit.attributeDelete=function(b,d){var a=UmpleSystem.find(b);
a.removeAttribute(d);var e=jQuery("#"+a.id);a.position.height=28+17*(a.attributes.size()+a.methods.size());a.position.width=UmpleClassFactory.defaultSize.width;
var c=Json.toString(a);Page.showModelLoading();DiagramEdit.updateUmpleText({actionCode:format("action=editClass&actionCode={0}",c),codeChange:true});
a.resetAttribute(d);UmpleSystem.updateClass(a);UmpleSystem.redrawGeneralizationsTo(a);UmpleSystem.trimOverlappingAssociations(a)};DiagramEdit.associationDeleted=function(a,d){if(d==undefined){d=false
}var c=UmpleSystem.removeAssociation(a);var b=Json.toString(c);if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();
Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=removeAssociation&actionCode={0}",b),codeChange:true})
};DiagramEdit.generalizationDeleted=function(a,d){if(d==undefined){d=false}var c=UmpleSystem.removeGeneralization(a);var b=Json.toString(c);
if(!Page.repeatToolItem){Page.unselectAllToggleTools()}Page.showModelLoading();Page.showLayoutLoading();DiagramEdit.updateUmpleText({actionCode:format("action=removeGeneralization&actionCode={0}",b),codeChange:true})
};DiagramEdit.removeNewClass=function(){if(DiagramEdit.newClass!=null){var a="#"+DiagramEdit.newClass.id;DiagramEdit.newClass=null;jQuery(a).remove();
return true}return false};DiagramEdit.removeNewAssociation=function(){if(DiagramEdit.newAssociation!=null){var a="#"+DiagramEdit.newAssociation.getElementId();
jQuery(a).remove();DiagramEdit.newAssociation=null;return true}return false};DiagramEdit.removeNewGeneralization=function(){if(DiagramEdit.newGeneralization!=null){var a="#"+DiagramEdit.newGeneralization.getElementId();
jQuery(a).remove();DiagramEdit.newGeneralization=null;return true}return false};UmpleAssociationFactory=new Object();UmpleAssociationFactory.create=function(b){var a=new UmpleAssociation();
a.id=b.id;a.classOneId=b.classOneId;a.classTwoId=b.classTwoId;a.offsetOnePosition=UmplePositionFactory.copy(b.offsetOnePosition);a.offsetTwoPosition=UmplePositionFactory.copy(b.offsetTwoPosition);
a.multiplicityOne=b.multiplicityOne;a.multiplicityTwo=b.multiplicityTwo;a.name=b.name;a.roleOne=b.roleOne;a.roleTwo=b.roleTwo;a.isSymmetricReflexive=(b.isSymmetricReflexive=="true"||b.isSymmetricReflexive==true)?true:false;
a.isLeftNavigable=(b.isLeftNavigable=="true"||b.isLeftNavigable==true)?true:false;a.isRightNavigable=(b.isRightNavigable=="true"||b.isRightNavigable==true)?true:false;
a.isLeftComposition=(b.isLeftComposition=="true"||b.isLeftComposition==true)?true:false;a.isRightComposition=(b.isRightComposition=="true"||b.isRightComposition==true)?true:false;
a.color=b.isTraced;return a};function UmpleAssociation(){this.id;this.classOneId;this.classTwoId;this.classOnePosition=null;this.classTwoPosition=null;
this.offsetOnePosition=null;this.offsetTwoPosition=null;this.multiplicityOne="";this.multiplicityTwo="";this.name="";this.roleOne="";
this.roleTwo="";this.isSymmetricReflexive=false;this.isLeftNavigable=true;this.isRightNavigable=true;this.isLeftComposition=false;this.isRightComposition=false;
this.color="black";this.setClasses=function(a,b){this.classOneId=a;this.classTwoId=b};this.setDefaultMultiplicities=function(){this.multiplicityOne="*";
this.multiplicityTwo="*"};this.setDefaultRoles=function(){if(this.classOneId==this.classTwoId){this.roleTwo="roleName"}};this.setRoles=function(b,a){this.roleOne=b;
this.roleTwo=a};this.setName=function(a){this.name=a};this.getName=function(){if(this.name==null||this.name==""){return this.deriveName()
}else{return this.name}};this.deriveName=function(){var c="";var b=this.classOneId;var a=this.classTwoId;if(!(this.roleOne==null||this.roleOne==="")){b=this.classOneId+":"+this.roleOne
}if(!(this.roleTwo==null||this.roleTwo==="")){a=this.classTwoId+":"+this.roleTwo}if(this.classOneId<=this.classTwoId){c=b+"__"+a}else{c=a+"__"+b
}return c};this.getElementId=function(){return this.id==null?"newassociation":this.id};this.getClass=function(a){return a==0?UmpleSystem.find(this.classOneId):UmpleSystem.find(this.classTwoId)
};this.setOffsetOnePosition=function(b){var a=UmpleSystem.find(this.classOneId);this.classOnePosition=a.position;this.offsetOnePosition=b.subtract(a.position).subtract(UmpleSystem.position());
this.offsetOnePosition.width=0;this.offsetOnePosition.height=0};this.setOffsetTwoPosition=function(b){var a=UmpleSystem.find(this.classTwoId);
this.classTwoPosition=a.position;this.offsetTwoPosition=b.subtract(a.position).subtract(UmpleSystem.position());this.offsetTwoPosition.width=0;
this.offsetTwoPosition.height=0};this.trimOverlap=function(){var f=new UmpleLine(this.offsetOnePosition.add(this.classOnePosition),this.offsetTwoPosition.add(this.classTwoPosition));
var j=UmpleSystem.find(this.classOneId).borderLines();var a=UmpleSystem.find(this.classTwoId).borderLines();var b=this.offsetOnePosition.add(this.classOnePosition);
var g=this.offsetTwoPosition.add(this.classTwoPosition);var k=[];var h=[];for(var d=0;d<j.length;d++){intersection=f.intersection(j[d]);
if(intersection!=null){k.push(intersection)}}for(var d=0;d<a.length;d++){intersection=f.intersection(a[d]);if(intersection!=null){h.push(intersection)
}}var c=new UmpleLine(b,g);var e=new UmpleLine(c.pointOne,c.pointTwo);for(var d=0;d<k.length;d++){e.pointOne=k[d];if(e.length()<c.length()){c=new UmpleLine(e.pointOne,e.pointTwo)
}}var e=new UmpleLine(c.pointOne,c.pointTwo);for(var d=0;d<h.length;d++){e.pointTwo=h[d];if(e.length()<c.length()){c=new UmpleLine(e.pointOne,e.pointTwo)
}}this.setOffsetOnePosition(c.pointOne.add(UmpleSystem.position()));this.setOffsetTwoPosition(c.pointTwo.add(UmpleSystem.position()))
};this.adjustReflexiveEndpoints=function(){var c=this.offsetOnePosition;var a=this.offsetTwoPosition;var b=UmpleSystem.find(this.classOneId).borderLines();
this.snapToClosestEdge(c,b);this.snapToClosestEdge(a,b)};this.snapToClosestEdge=function(a,g){var f=true;var h=true;var e=a.x+this.classOnePosition.x;
var d=a.y+this.classOnePosition.y;var b=d-g[0].pointOne.y;var c=e-g[1].pointOne.x;if(b>g[2].pointOne.y-d){f=false;b=g[2].pointOne.y-d
}if(c>g[3].pointOne.x-e){h=false;c=g[3].pointOne.x-e}if(b<=c){if(f){a.y=0}else{a.y=this.classOnePosition.height}}else{if(h){a.x=0}else{a.x=this.classOnePosition.width
}}};this.drawable=function(){if(this.id==null){associationDiv=this.drawableTemp()}else{if(this.isReflexive()){associationDiv=this.drawableReflexive()
}else{if(this.isComposition()){associationDiv=this.drawableComposition()}else{if(this.isBidirectional()){associationDiv=this.drawableBidirectional()
}else{associationDiv=this.drawableUnidirectional()}}}}return associationDiv};this.drawableTemp=function(){var b="#"+this.getElementId();
jQuery(b).remove();var c=this.createBaseJQueryObject();c.addClass("umpleAssociationTemp");c.attr("id","newassociation");var a=new UmpleLine(this.classOnePosition.add(this.offsetOnePosition),this.classTwoPosition.add(this.offsetTwoPosition));
c.append(a.drawable());return c};this.drawableBidirectional=function(){var f="#"+this.id;jQuery(f).remove();var d=this.createBaseJQueryObject();
if(this.color=="red"){d.addClass("redTracedAssociation")}else{d.addClass("untracedAssociation")}d.attr("id",this.id);var a=UmpleSystem.find(this.classOneId);
var k=UmpleSystem.find(this.classTwoId);if(a==null||a==undefined||k==null||k==undefined){return d}this.classOnePosition=a.position;this.classTwoPosition=k.position;
var n=this.classOnePosition.add(this.offsetOnePosition);var g=this.classTwoPosition.add(this.offsetTwoPosition);var q=new UmpleLine(n.add(UmpleClassFactory.offsetError),g.add(UmpleClassFactory.offsetError));
if(!this.isComposition()){d.append(q.drawable())}var o="";var e=-3;o+=this.anchorDivHtml("hover",0,n.x+e,n.y+e);o+=this.anchorDivHtml("anchor",0,n.x+e,n.y+e);
o+=this.anchorDivHtml("hover",1,g.x+e,g.y+e);o+=this.anchorDivHtml("anchor",1,g.x+e,g.y+e);var c=n.slopeAngle(g);var m=this.multiplicityPosition(true);
var j=this.multiplicityPosition(false);var b=this.multiplicityDivHtml("one",this.multiplicityOne,m.x,m.y);var l=this.multiplicityDivHtml("two",this.multiplicityTwo,j.x,j.y);
if(this.roleOne!=""){roleOnePosition=this.rolePosition(true);var p=this.roleDivHtml("one",this.roleOne,roleOnePosition.x,roleOnePosition.y)
}else{p=""}if(this.roleTwo!=""){roleTwoPosition=this.rolePosition(false);var h=this.roleDivHtml("two",this.roleTwo,roleTwoPosition.x,roleTwoPosition.y)
}else{h=""}currentHtml=d.html();d.html(b+l+p+h+o+currentHtml);return d};this.drawableUnidirectional=function(){var f=this.drawableBidirectional();
var g=null;if(this.isLeftNavigable){g=this.classOnePosition.add(this.offsetOnePosition);otherEnd=this.classTwoPosition.add(this.offsetTwoPosition)
}else{g=this.classTwoPosition.add(this.offsetTwoPosition);otherEnd=this.classOnePosition.add(this.offsetOnePosition)}var c=g.slopeAngle360(otherEnd);
var a=c+30;var k=c-30;var b=10;var j=g.travelForward(b,a);var h=g.travelForward(b,k);var e=new UmpleLine(g.add(UmpleClassFactory.offsetError),j.add(UmpleClassFactory.offsetError));
var d=new UmpleLine(g.add(UmpleClassFactory.offsetError),h.add(UmpleClassFactory.offsetError));f.append(e.drawable());f.append(d.drawable());
return f};this.drawableComposition=function(){var g=this.drawableBidirectional();var m=null;if(this.isLeftComposition){m=this.classOnePosition.add(this.offsetOnePosition);
otherEnd=this.classTwoPosition.add(this.offsetTwoPosition)}else{m=this.classTwoPosition.add(this.offsetTwoPosition);otherEnd=this.classOnePosition.add(this.offsetOnePosition)
}var y=m.slopeAngle360(otherEnd);var k=y+30;var r=y-30;var j=8;var F=m.travelForward(j,k);var D=m.travelForward(j,r);var B=F.travelForward(j,r);
var w=new UmpleLine(m.add(UmpleClassFactory.offsetError),F.add(UmpleClassFactory.offsetError));var v=new UmpleLine(m.add(UmpleClassFactory.offsetError),D.add(UmpleClassFactory.offsetError));
var u=new UmpleLine(F.add(UmpleClassFactory.offsetError),B.add(UmpleClassFactory.offsetError));var t=new UmpleLine(D.add(UmpleClassFactory.offsetError),B.add(UmpleClassFactory.offsetError));
g.append(w.drawable());g.append(v.drawable());g.append(u.drawable());g.append(t.drawable());var x=new UmpleLine(B.add(UmpleClassFactory.offsetError),otherEnd.add(UmpleClassFactory.offsetError));
g.append(x.drawable());var e=4;var b=m.travelForward(e,k);var p=m.travelForward(e,r);var E=F.travelForward(e,r);var c=D.travelForward(e,k);
var l=new UmpleLine(m.add(UmpleClassFactory.offsetError),E.add(UmpleClassFactory.offsetError));var z=new UmpleLine(m.add(UmpleClassFactory.offsetError),c.add(UmpleClassFactory.offsetError));
var I=new UmpleLine(m.add(UmpleClassFactory.offsetError),B.add(UmpleClassFactory.offsetError));var n=new UmpleLine(F.add(UmpleClassFactory.offsetError),c.add(UmpleClassFactory.offsetError));
var A=new UmpleLine(F.add(UmpleClassFactory.offsetError),p.add(UmpleClassFactory.offsetError));var J=new UmpleLine(F.add(UmpleClassFactory.offsetError),D.add(UmpleClassFactory.offsetError));
var o=new UmpleLine(D.add(UmpleClassFactory.offsetError),b.add(UmpleClassFactory.offsetError));var C=new UmpleLine(D.add(UmpleClassFactory.offsetError),E.add(UmpleClassFactory.offsetError));
var a=new UmpleLine(B.add(UmpleClassFactory.offsetError),b.add(UmpleClassFactory.offsetError));var d=new UmpleLine(B.add(UmpleClassFactory.offsetError),p.add(UmpleClassFactory.offsetError));
var q=new UmpleLine(b.add(UmpleClassFactory.offsetError),p.add(UmpleClassFactory.offsetError));var G=new UmpleLine(b.add(UmpleClassFactory.offsetError),E.add(UmpleClassFactory.offsetError));
var f=new UmpleLine(b.add(UmpleClassFactory.offsetError),c.add(UmpleClassFactory.offsetError));var s=new UmpleLine(p.add(UmpleClassFactory.offsetError),E.add(UmpleClassFactory.offsetError));
var H=new UmpleLine(p.add(UmpleClassFactory.offsetError),c.add(UmpleClassFactory.offsetError));var h=new UmpleLine(E.add(UmpleClassFactory.offsetError),c.add(UmpleClassFactory.offsetError));
g.append(l.drawable());g.append(z.drawable());g.append(I.drawable());g.append(n.drawable());g.append(A.drawable());g.append(J.drawable());
g.append(o.drawable());g.append(C.drawable());g.append(a.drawable());g.append(d.drawable());g.append(q.drawable());g.append(G.drawable());
g.append(f.drawable());g.append(s.drawable());g.append(H.drawable());g.append(h.drawable());return g};this.drawableReflexive=function(){var j="#"+this.id;
jQuery(j).remove();var z=this.createBaseJQueryObject();if(this.color=="red"){z.addClass("redTracedAssociation")}else{z.addClass("untracedAssociation")
}z.attr("id",this.id);var O=UmpleSystem.find(this.classOneId);this.classOnePosition=O.position;this.classTwoPosition=O.position;var K=O.position.height;
var y=O.position.width;var s=15;var d=this.whichWall(true);factorX=d=="West"?-1:d=="South"?0:d=="East"?1:0;factorY=d=="West"?0:d=="South"?1:d=="East"?0:-1;
var f=this.offsetOnePosition.add(this.classOnePosition);var G=this.offsetOnePosition.add(this.classOnePosition).add(new UmplePosition(s*factorX,s*factorY,0,0));
if(d=="South"){f.y=f.y-1}var H=new UmpleLine(f,G);var a=this.whichWall(false);factorX=a=="West"?-1:a=="South"?0:a=="East"?1:0;factorY=a=="West"?0:a=="South"?1:a=="East"?0:-1;
var F=this.offsetTwoPosition.add(this.classTwoPosition);var P=this.offsetTwoPosition.add(this.classTwoPosition).add(new UmplePosition(s*factorX,s*factorY,0,0));
var g=new UmpleLine(F,P);z.append(H.drawable());z.append(g.drawable());var N=new UmplePosition(0,0,0,0);if(d==a){var c=new UmpleLine(G,P);
if(d=="North"||d=="South"){if(this.isSymmetricReflexive){N.x=(G.x+P.x)/2;N.y=G.y}}else{if(this.isSymmetricReflexive){N.x=G.x;N.y=(G.y+P.y)/2
}}z.append(c.drawable())}else{if(this.offsetOnePosition.wallsAreAdjacent(d,a)){var m=new UmplePosition(0,0,0,0);var v=(d=="West"||a=="West");
var k=(d=="North"||a=="North");if(v){m.x=this.classOnePosition.x-s}else{m.x=this.classOnePosition.x+y+s}if(k){m.y=this.classOnePosition.y-s
}else{m.y=this.classOnePosition.y+K+s}var M=new UmpleLine(G,m);var h=new UmpleLine(P,m);z.append(M.drawable());z.append(h.drawable());
if(this.isSymmetricReflexive){N.set(m.x,m.y)}}else{var w=new UmplePosition(0,0,0,0);var u=new UmplePosition(0,0,0,0);var L;var J;var I;
var t;var q;if(d=="South"||a=="South"){w.x=this.classOnePosition.x-s;w.y=this.classOnePosition.y-s;u.x=w.x;u.y=this.classOnePosition.y+K+s;
if(a=="South"){t=G;q=P}else{t=P;q=G}if(this.isSymmetricReflexive){N.x=w.x;N.y=(w.y+u.y)/2}}else{w.x=this.classOnePosition.x-s;w.y=this.classOnePosition.y+K+s;
u.x=this.classOnePosition.x+y+s;u.y=w.y;if(a=="East"){t=G;q=P}else{t=P;q=G}if(this.isSymmetricReflexive){N.x=(w.x+u.x)/2;N.y=w.y}}L=new UmpleLine(t,w);
J=new UmpleLine(w,u);I=new UmpleLine(u,q);z.append(L.drawable());z.append(J.drawable());z.append(I.drawable())}}if(!this.isSymmetricReflexive){var n=new UmplePosition(0,0,0,0);
if(d=="North"||d=="South"){N.x=G.x;N.y=(f.y+G.y)/2}else{N.x=(f.x+G.x)/2;N.y=G.y}if(a=="North"||a=="South"){n.x=P.x;n.y=(F.y+P.y)/2}else{n.x=(F.x+P.x)/2;
n.y=P.y}}var B="";var p=f;var o=F;var l=3;B+=this.anchorDivHtml("hover",0,p.x-l,p.y-l);B+=this.anchorDivHtml("anchor",0,p.x-l,p.y-l);
B+=this.anchorDivHtml("hover",1,o.x-l,o.y-l);B+=this.anchorDivHtml("anchor",1,o.x-l,o.y-l);if(this.isSymmetricReflexive){var Q=UmplePositionFactory.copy(this.centerMultiplicityPosition(N));
var A=this.adjustRolePosition(N,true);var D=this.roleDivHtml("center",this.roleOne,A.x,A.y);var r=this.multiplicityDivHtml("center",this.multiplicityOne,Q.x,Q.y)
}else{var C=UmplePositionFactory.copy(this.reflexiveMultiplicityPosition(N,n,true));var b=UmplePositionFactory.copy(this.reflexiveMultiplicityPosition(n,N,false));
var e=this.adjustRolePosition(N,true);var x=this.adjustRolePosition(n,false);var D=(this.roleDivHtml("one",this.roleOne,e.x,e.y)+this.roleDivHtml("two",this.roleTwo,x.x,x.y));
var r=(this.multiplicityDivHtml("one",this.multiplicityOne,C.x,C.y)+this.multiplicityDivHtml("two",this.multiplicityTwo,b.x,b.y))}if(this.id==null){z.attr("id","newassociation");
return z}var E=z.html();z.html(r+D+B+E);return z};this.isReflexive=function(){return this.classOneId==this.classTwoId||this.isSymmetricReflexive
};this.isBidirectional=function(){if(this.isRightNavigable==undefined||this.isLeftNavigable==undefined){return true}return this.isRightNavigable&&this.isLeftNavigable
};this.isComposition=function(){return this.isRightComposition||this.isLeftComposition};this.endHasArrow=function(a){if(a){return this.isLeftNavigable
}else{return this.isRightNavigable}};this.contains=function(a){return a.id==this.classOneId||a.id==this.classTwoId};this.anchorDivHtml=function(c,b,a,d){return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,c,b,a,d)
};this.multiplicityDivHtml=function(c,b,a,e,d){if(d==undefined||d=="undefined"){d=""}return format('<div id="{0}_{1}" class="multiplicity" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}&nbsp;&nbsp;{5}</div>',this.id,c,a,e,b,d)
};this.roleDivHtml=function(b,d,a,c){if(b=="one"){idExtension="roleOne"}else{if(b=="two"){idExtension="roleTwo"}else{if(b=="center"){idExtension="role"
}else{idExtension=""}}}return format('<div id="{0}_{1}" class="role" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}</div>',this.id,idExtension,a,c,d)
};this.whichWall=function(b){if(b){var c=this.classOnePosition;var d=this.offsetOnePosition}else{var c=this.classTwoPosition;var d=this.offsetTwoPosition
}var a=1;if(d.x==0){return"West"}else{if(d.y==0){return"North"}else{if(Math.abs(d.x-c.width)<=a){return"East"}else{return"South"}}}};
this.multiplicityPosition=function(f){if(f){var l=this.classOnePosition.add(this.offsetOnePosition);var e=this.classTwoPosition.add(this.offsetTwoPosition);
var k=this.multiplicityOne}else{var l=this.classTwoPosition.add(this.offsetTwoPosition);var e=this.classOnePosition.add(this.offsetOnePosition);
var k=this.multiplicityTwo}var j=this.whichWall(f);var b=k=="*"?new UmplePosition(0,10,0,0):new UmplePosition(0,16,0,0);var c=new UmplePosition(5*k.length+1,0,0,0);
var a=3;if((!this.isBidirectional()&&this.endHasArrow(f))||this.isComposition()){a+=5}var d=l.slopeAngle360(e);if(j=="North"){if(d<90){var h=(180-d)/2+d;
var g=l.travelForward(a,h);g=g.subtract(c);g=g.subtract(b)}else{var h=d/2;var g=l.travelForward(a,h);g=g.subtract(b)}}else{if(j=="East"){if(d>=0&&d<=90){var h=(d+90)/2+270;
var g=l.travelForward(a,h)}else{var h=((360-d+90)/2+d)%360;var g=l.travelForward(a,h);g=g.subtract(b)}}else{if(j=="South"){if(d<=270){var h=(360-d)/2+d;
var g=l.travelForward(a,h);var m=g}else{var h=(d-180)/2+180;var g=l.travelForward(a,h);var m=g;g=g.subtract(c)}}else{if(d<=180){var h=(270-d)/2+d;
var g=l.travelForward(a,h);g=g.subtract(c)}else{var h=(d-90)/2+90;var g=l.travelForward(a,h);g=g.subtract(b);g=g.subtract(c)}}}}return g
};this.centerMultiplicityPosition=function(e){var b=this.whichWall(true);var a=this.whichWall(false);var d=1;var c=5;e.width=5*this.multiplicityOne.length+c+6*this.roleOne.length;
e.height=16;if((b=="West"&&a=="West")||(b=="North"&&a=="South")||(b=="South"&&a=="North")){e.x-=(e.width+d);e.y-=e.height/2}else{if(b=="East"&&a=="East"){e.x+=d;
e.y-=e.height/2}else{if(b=="North"||a=="North"){e.y-=(d+e.height);e.x-=e.width/2}else{e.y+=d;e.x-=e.width/2}}}return e};this.reflexiveMultiplicityPosition=function(e,d,g){var a=5;
var c=1;if(g){var h=this.whichWall(true);var j=this.whichWall(false);var b=this.multiplicityOne.length;var f=this.roleOne.length}else{var h=this.whichWall(false);
var j=this.whichWall(true);var b=this.multiplicityTwo.length;var f=this.roleTwo.length}e.width=5*b+a+6*f;e.height=16;if(h=="North"){e.y-=e.height/2;
if((j=="North"&&e.x<d.x)||j=="East"){e.x-=(e.width+c)}else{e.x+=c}}else{if(h=="East"){if((j=="East"&&e.y<d.y)||j=="South"||j=="West"){e.y-=(e.height)
}else{e.y+=c}}else{if(h=="South"){e.y-=e.height/2;if((j=="South"&&e.x<d.x)||j=="East"){e.x-=(e.width+c)}else{e.x+=c}}else{if(h=="West"){e.x-=e.width;
if((j=="West"&&e.y<d.y)||j=="East"||j=="South"){e.y-=(e.height)}else{e.y+=c}}}}}return e};this.rolePosition=function(h){var m=h?this.multiplicityOne:this.multiplicityTwo;
var g=h?this.roleOne:this.roleTwo;var n=h?this.classOnePosition.add(this.offsetOnePosition):this.classTwoPosition.add(this.offsetTwoPosition);
var f=h?this.classTwoPosition.add(this.offsetTwoPosition):this.classOnePosition.add(this.offsetOnePosition);var e=new UmplePosition(5*(m.length),0,0,0);
var j=new UmplePosition(6*(g.length),0,0,0,0);var b=new UmplePosition(0,16,0,0);var d=b;var a=new UmplePosition(5,0,0,0);var k=this.multiplicityPosition(h);
var l=this.whichWall(h);var c=n.slopeAngle360(f);if(l=="North"){if(c<90){rolePosition=k.subtract(j).subtract(e)}else{rolePosition=k.add(e).add(a)
}if(m=="*"){rolePosition=rolePosition.subtract(new UmplePosition(0,6,0,0))}}else{if(l=="East"){rolePosition=k.add(e).add(a)}else{if(l=="South"){if(c<=270){rolePosition=k.add(e).add(a)
}else{rolePosition=k.subtract(j).subtract(e)}}else{rolePosition=k.subtract(j).subtract(e)}}}return rolePosition};this.adjustRolePosition=function(c,b){var a=b?this.multiplicityOne.length:this.multiplicityTwo.length;
c.x+=5*a+6;return c};this.createBaseJQueryObject=function(){return jQuery(format("<div class='{0}'></div>",this.getName()))}}UmpleAttributeFactory=new Object();
UmpleAttributeFactory.create=function(e){var d=e.type;var c=e.name;var b=e.traceColor;if(b==""){b="black"}var a=new UmpleAttribute(d,c,b);
return a};function UmpleAttribute(b,c,a){this.type=b;this.name=c;this.textColor=a;if(this.aColor===""||this.aColor===undefined){this.aColor="black"
}this.set=function(f){this.textColor="black";var e=this.type!=""&&this.name!="";if(e){this.oldType=this.type;this.oldName=this.name}var d=f.split(":");
if(d.length<2){this.type="String";this.name=f}else{this.name=d[0].trim();this.type=d[1].trim()}if(!e){this.newType=this.type;this.newName=this.name
}};this.copy=function(){return new UmpleAttribute(this.type,this.name,this.textColor)}}UmpleClassFactory=new Object();UmpleClassFactory.defaultSize=new UmplePosition(0,0,109,41);
UmpleClassFactory.offsetError=new UmplePosition(0,0,0,0);UmpleClassFactory.create=function(c){var a=new UmpleClass();a.id=c.id;a.name=c.name;
a.isInterface=c.isInterface;a.isAbstract=c.isAbstract;a.displayColor=c.displayColor;if(a.displayColor==""){a.displayColor="transparent"
}a.position.x=c.position.x;a.position.y=c.position.y;a.position.width=c.position.width;a.position.height=c.position.height;a.extendsClass=c.extendsClass;
for(var b=0;b<c.attributes.length;b++){if(c.attributes[b].modifier=="const"){continue}a.attributes.push(UmpleAttributeFactory.create(c.attributes[b]))
}for(var b=0;b<c.methods.length;b++){a.methods.push(UmpleMethodFactory.create(c.methods[b]))}if(c.implementedInterfaces!=null){for(var b=0;
b<c.implementedInterfaces.length;b++){a.interfaces[b]=c.implementedInterfaces[b].interfacesName+""}}return a};UmpleClassFactory.perimeterPosition=function(e,h,d){if(typeof(d)=="undefined"){d=new UmplePosition(0,0,0,0)
}var g=h.x;var f=h.y;var o=0;var m=d.x+e.position.x+o;var l=m+e.position.width;var k=d.y+e.position.y+o;var j=k+e.position.height;var q=g<m?m:g>l?l:g;
var p=f<k?k:f>j?j:f;var a=g-m;var s=l-g;var c=f-k;var b=j-f;var r=Math.min(a,s);var n=Math.min(c,b);if(r<n){q=a<s?m:l}else{if(n<r){p=c<b?k:j
}}return new UmplePosition(Math.round(q),Math.round(p),0,0)};function UmpleClass(){this.id;this.name;this.isInterface;this.isAbstract;
this.displayColor="transparent";this.position=new UmplePosition(0,0,109,41);this.attributes=[];this.methods=[];this.interfaces=[];this.extendsClass;
this.addAttribute=function(a){var b=new UmpleAttribute("","","");b.set(a);this.attributes.push(b);return this.attributes.length-1};this.removeAttribute=function(a){var b=this.attributes[a];
b.deleteType=b.type;b.deleteName=b.name};this.resetAttribute=function(a){if(this.attributes[a].deleteName!=null){this.attributes.splice(a,1)
}else{this.attributes[a]=this.attributes[a].copy()}};this.resetMethod=function(a){if(this.methods[a].deleteName!=null){this.methods.splice(a,1)
}else{this.methods[a]=this.methods[a].copy()}};this.addMethod=function(a){var b=new UmpleMethod("","","","");b.set(a);this.methods.push(b);
return this.methods.length-1};this.removeMethod=function(a){var b=this.methods[a];b.deleteType=b.type;b.deleteVisibility=b.visibility;
b.deleteName=b.name;b.deleteParameters=b.parameters};this.setExtendsClass=function(a){this.extendsClass=a};this.removeExtendsClass=function(){this.extendsClass=null
};this.borderLines=function(){var g=jQuery("#"+this.id);var f=g.width();var a=g.height();var e=this.position;var d=this.position.add(new UmplePosition(f,0,0,0));
var b=this.position.add(new UmplePosition(0,a,0,0));var c=this.position.add(new UmplePosition(f,a,0,0));borders=[];borders.push(new UmpleLine(e,d));
borders.push(new UmpleLine(e,b));borders.push(new UmpleLine(b,c));borders.push(new UmpleLine(d,c));return borders};this.drawable=function(){var c=this.drawClass();
var a=this.drawGeneralization();var b=[c,a];return b};this.drawClass=function(){var n="#"+this.id;var m=jQuery(n).get();if(m==undefined||m==null||m==""){classDiv=jQuery("<div></div>");
classDiv.addClass("umpleClass")}else{classDiv=jQuery(m);removalSel=format("div#{0} .classTable,div#{0} .umpleAttribute,div#{0} .umpleAttributeNew,div#{0} .anchor, div#{0} .hover",this.id);
jQuery(removalSel).remove()}classDiv.attr("id",this.id);var h=-3.5;var f=-3;var e="";var o="";var k="";if(this.attributes.length>0){for(var j=0;
j<this.attributes.length;j++){var l=this.attributes[j];var g="";if(l.textColor!="black"){g=format("style='color:{0}'",l.textColor)}if(Page.isPhotoReady()){e+=format('<div class="umpleAttribute" {3}>{0} : {1}</div>',l.name,l.type,g)
}else{e+=format('<div class="umpleAttribute" {5}><span id="{2}_attribute_{3}" name="attributeEdit" class="editable editableDoubleClick">{0} : {1}</span> <img src="scripts/delete2.jpg" onclick="DiagramEdit.attributeDelete({4}{2}{4},{4}{3}{4})" /></div>',l.name,l.type,this.id,j,"'",g)
}}}if(this.methods.length>0){for(var j=0;j<this.methods.length;j++){var a=this.methods[j];var c="";if(a.visibility=="public"){c="+ "}else{if(a.visibility=="private"){c="- "
}else{if(a.visibility=="protected"){c="# "}else{c="+ "}}}var b=(a.type==""?"void":a.type);if(Page.isPhotoReady()){if(a.isAbstract=="true"){o+=format('<div class="umpleMethod">{3}<span style="font-style:italic">{1}({2}) </span> : {0} </div>',b,a.name,a.parameters,c)
}else{o+=format('<div class="umpleMethod">{3}{1}({2}) : {0} </div>',b,a.name,a.parameters,c)}}else{if(a.isAbstract=="true"){o+=format('<div class="umpleMethod"><span id="{4}_method_{5}" name="methodEdit" class="editable editableDoubleClick">{3}<span style="font-style:italic">{1}({2})</span> : {0} </span> <img src="scripts/delete2.jpg" onclick="Action.methodDelete({6}{4}{6},{6}{5}{6})" /></div>',b,a.name,a.parameters,c,this.id,j,"'")
}else{o+=format('<div class="umpleMethod"><span id="{4}_method_{5}" name="methodEdit" class="editable editableDoubleClick">{3}{1}({2}) : {0} </span> <img src="scripts/delete2.jpg" onclick="Action.methodDelete({6}{4}{6},{6}{5}{6})" /></div>',b,a.name,a.parameters,c,this.id,j,"'")
}}}}e+=format('<div class="umpleAttributeNew"><span id="{0}_newAttribute" name="attributeNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady()?"&nbsp;":"-- Add More --");
o+=format('<div class="umpleMethodNew"><span id="{0}_newMethod" name="methodNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady()?"&nbsp;":"-- Add More --");
if(!Page.isPhotoReady()){}rowspan=3;if(Page.showAttributes){rowspan+=1}if(Page.showMethods){rowspan+=1}k+=format('<table bgcolor="'+this.displayColor+'" class="classTable" border="0">',this.id)+format('  <tr class="height">    <td rowspan="{2}"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />    </td>  </tr>',this.id,this.position.height,rowspan)+'  <tr class="classArea">    <td > <img src="scripts/class.png" title="Class" /> ';
if(Page.isPhotoReady()){if(this.isInterface=="true"){k+=format('<span>&#171interface&#187<span><br><span id="{0}_name" name="className">{1}</span>',this.id,this.name)
}else{if(this.isAbstract=="true"){k+=format('<span>&#171abstract&#187<span><br><span id="{0}_name" name="className">{1}</span>',this.id,this.name)
}else{k+=format('<span id="{0}_name" name="className">{1}</span>',this.id,this.name)}}}else{if(this.isInterface=="true"){k+=format('<span>&#171interface&#187<span><br><span id="{0}_name" name="className" class="editable editableDoubleClick">{1}</span>',this.id,this.name)
}else{if(this.isAbstract=="true"){k+=format('<span>&#171abstract&#187<span><br><span id="{0}_name" name="className" class="editable editableDoubleClick">{1}</span>',this.id,this.name)
}else{k+=format('<span id="{0}_name" name="className" class="editable editableDoubleClick" >{1}</span>',this.id,this.name)}}}k+=("</td> </tr>");
if(Page.showAttributes==true){k+=format('  <tr class="attributeArea">    <td class="attributes">{0}    </td>  </tr>',e)}if(Page.showMethods==true){k+=format('  <tr class="methodArea">    <td class="methods">{0}    </td>  </tr>',o)
}k+=format('  <tr class="width">    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />    </td>  </tr>',this.id,this.position.width);
k+="</table>";var d=classDiv.html();classDiv.html(k+d);return classDiv};this.drawableClassOutline=function(){var a="#tempClass";var c=jQuery(a).get();
if(c==undefined||c==null||c==""){c=jQuery("<div></div>");c.addClass("umpleClass");c.attr("id",this.id)}else{c=jQuery(a)}var b='<table class="classTable" "border="0">'+format('  <tr class="height">    <td rowspan="4"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />    </td>  </tr>',this.id,this.position.height)+'  <tr class="classArea">    <td> <img src="scripts/class.png" title="Class" /> '+format('      <span id="{0}_name" name="className" >{1}</span>',this.id,this.name)+'    </td>  </tr>  <tr class="attributeArea">    <td class="attributes">    </td>  </tr>  <tr class="width">'+format('    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />    </td>  </tr>',this.id,this.position.width)+"</table>";
c.html(b);return c};this.drawGeneralization=function(){var b=null;var a=[];var d=UmpleSystem.find(this.extendsClass);if(d==null&&this.interfaces.length==0){return null
}if(d!=null){b=new UmpleGeneralization();b.childId=this.id;b.parentId=d.id;b.childPosition=this.position;b.parentPosition=d.position;
a[0]=b.drawable()}if(this.interfaces.length>0){var e=null;for(var c=0;c<this.interfaces.length;c++){e=UmpleSystem.find(this.interfaces[c]);
if(e==null){continue}b=new UmpleGeneralization();b.childId=this.id;b.parentId=e.id;b.childPosition=this.position;b.parentPosition=e.position;
a[c+1]=b.drawable()}}return a};this.anchorDivHtml=function(b,a){return format('<div id="{0}_{1}{2}" class="{3}" name="{4}" style="top: 0px; left: 0px; cursor:{5}; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,b,a,b,b,"move")
}}function UmpleGeneralization(){this.parentId=null;this.childId=null;this.parentPosition=null;this.childPosition=null;this.id=null;this.setClasses=function(a,b){this.childId=a;
this.parentId=b};this.setChildId=function(a){this.childId=a};this.setParentId=function(a){this.parentId=a};this.getElementId=function(){return this.id==null?"newgeneralization":this.id
};this.getChildId=function(){return this.childId};this.getParentId=function(){return this.parentId};this.drawable=function(y){if(y==undefined){y=true
}if(this.childId==null||this.childId==undefined){return null}var s="#"+this.childId+"_generalization";jQuery(s).remove();var j=jQuery("<div></div>");
var D=y?this.childId+"_generalization":"newgeneralization";var b="umpleGeneralization";j.attr("id",D);j.addClass(b);var h=new UmplePosition(0,10,0,0);
var x=new UmplePosition(15,0,0,0);var c=new UmplePosition(0,22,0,0);var v=this.childPosition;var A=new UmplePosition(this.childPosition.width/2,0,0,0);
var z=this.parentPosition;var f=new UmplePosition(this.parentPosition.width/2,this.parentPosition.height,0,0);f=f.add(h).add(c);z=z.add(f);
v=v.add(A);var p=this.childPosition.x;var q=this.childPosition.x+this.childPosition.width;var t=this.childPosition.y+this.childPosition.height;
var B=this.childPosition.y;var u=true;if(z.y>B){if(z.y<t){if(Math.abs(z.x-q)<Math.abs(z.x-p)){v=v.add(new UmplePosition(this.childPosition.width/2,0,0,0));
v.y=z.y;u=false}else{v=v.subtract(new UmplePosition(this.childPosition.width/2,0,0,0));v.y=z.y;u=false}}else{v=v.add(new UmplePosition(0,this.childPosition.height,0,0))
}}var r=new UmplePosition(v.x,z.y);if(u){var C=new UmpleLine(r.add(UmpleClassFactory.offsetError),z.add(UmpleClassFactory.offsetError));
var a=new UmpleLine(v.add(UmpleClassFactory.offsetError),r.add(UmpleClassFactory.offsetError));j.append(C.drawable())}else{var a=new UmpleLine(v.add(UmpleClassFactory.offsetError),z.add(UmpleClassFactory.offsetError))
}j.append(a.drawable());var o=z;var e=z.subtract(c);var d=new UmpleLine(o.add(UmpleClassFactory.offsetError),e.add(UmpleClassFactory.offsetError));
j.append(d.drawable());var n=e.subtract(new UmplePosition(x.x/2,0,0,0));var l=n.add(x);var k=e.subtract(h);var x=new UmpleLine(n.add(UmpleClassFactory.offsetError),l.add(UmpleClassFactory.offsetError));
var w=new UmpleLine(n.add(UmpleClassFactory.offsetError),k.add(UmpleClassFactory.offsetError));var m=new UmpleLine(l.add(UmpleClassFactory.offsetError),k.add(UmpleClassFactory.offsetError));
j.append(x.drawable());j.append(m.drawable());j.append(w.drawable());var g="";var E=j.html();j.html(g+E);return j};this.anchorDivHtml=function(c,b,a,d){return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.childId+"_generalization",c,b,a,d)
}}History=new Object();History.currentIndex=-1;History.oldestAvailableIndex=0;History.newestAvailableIndex=0;History.versionCount=9999;
History.noChange="//$?[No_Change]$?";History.firstSave=true;History.getNextVersion=function(){Page.enablePaletteItem("buttonUndo",true);
var a;if(!History.FirstSave&&History.newestAvailableIndex!=History.currentIndex){History.currentIndex=History.incrementIndex(History.currentIndex);
a=History.getVersion(History.currentIndex);if(a==undefined){a=History.noChange}}else{a=History.noChange}if(History.newestAvailableIndex==History.currentIndex){Page.enablePaletteItem("buttonRedo",false)
}return a};History.getPreviousVersion=function(){var a;if(!History.FirstSave&&History.oldestAvailableIndex!=History.currentIndex){History.currentIndex=History.decrementIndex(History.currentIndex);
a=History.getVersion(History.currentIndex);if(a==undefined){a=History.noChange}else{Page.enablePaletteItem("buttonRedo",true)}}else{a=History.noChange
}if(History.oldestAvailableIndex==History.currentIndex){Page.enablePaletteItem("buttonUndo",false)}return a};History.save=function(a,b){if(!History.firstSave){Page.enablePaletteItem("buttonRedo",false);
Page.enablePaletteItem("buttonUndo",true)}var c=History.distanceBetween(History.oldestAvailableIndex,History.currentIndex);if(c==History.versionCount-1){History.oldestAvailableIndex=History.incrementIndex(History.oldestAvailableIndex)
}History.currentIndex=History.incrementIndex(History.currentIndex);History.newestAvailableIndex=History.currentIndex;History.setVersion(History.currentIndex,a);
if(History.firstSave){History.firstSave=false}};History.decrementIndex=function(b){var a;if(b==0){a=History.versionCount-1}else{a=b-1
}return a};History.incrementIndex=function(b){var a=(b+1)%History.versionCount;return a};History.getVersion=function(b){var a="#textEditorColumn";
var c="version"+b;return jQuery(a).data(c)};History.setVersion=function(b,c){var a="#textEditorColumn";var d="version"+b;return jQuery(a).data(d,c)
};History.distanceBetween=function(d,b){if(History.currentIndex==-1){return 0}var c=0;var a=d;while(a!=b){a=History.incrementIndex(a);
c+=1}return c};var Layout={};Layout.isTextVisible=true;Layout.isDiagramVisible=true;Layout.isPaletteVisible=true;Layout.isLayoutVisible=false;
Layout.layoutHandler=null;Layout.isInSmallScreenMode=false;Layout.screenThresholdWidth=945;var canvasHandle="#umpleCanvasColumn";var editorHandle="#textEditorColumn";
var modelEditorHandle="#topTextEditor";var paletteHandle="#paletteColumn";var layoutEditorHandle="#bottomTextEditor";Layout.init=function(){Layout.errorMessageSpace=jQuery(".spacer").outerHeight();
if(Layout.errorMessageSpace===null){Layout.errorMessageSpace=0}var a=this.checkLayoutNeeded();if(a.layoutType==="large"){this.layoutHandler=new LargeScreenManager();
this.isInSmallScreenMode=false}else{if(a.layoutType==="small"){this.layoutHandler=new SmallScreenManager();this.isInSmallScreenMode=true
}}this.layoutHandler.transition(true);jQuery(window).bind("resize",function(b){if(!jQuery(b.target).hasClass("ui-resizable")){Layout.zoomResize()
}})};Layout.checkLayoutNeeded=function(){if(jQuery(window).innerWidth()>jQuery(window).innerHeight()){return{layoutType:"large"}}else{return{layoutType:"small"}
}};Layout.initPaletteSize=function(){this.layoutHandler.initPaletteSize()};Layout.initUmpleCanvasSize=function(){this.layoutHandler.initUmpleCanvasSize()
};Layout.initUmpleTextAreaSize=function(){this.layoutHandler.initUmpleTextAreaSize()};Layout.setTextEditorSize=function(b,a){this.layoutHandler.setTextEditorSize(b,a)
};Layout.setUmpleCanvasSize=function(b,a){this.layoutHandler.setUmpleCanvasSize(b,a)};Layout.adjustTextEditorHeight=function(a){if(this.isLayoutVisible){jQuery(modelEditorHandle).outerHeight(a*0.7);
if(Page.codeMirrorOn){this.resizeCodeMirrorEditor(a*0.7)}jQuery(layoutEditorHandle).outerHeight(a*0.3)}else{jQuery(modelEditorHandle).outerHeight(a);
if(Page.codeMirrorOn){this.resizeCodeMirrorEditor(a)}}jQuery(editorHandle).height(a)};Layout.resizeCodeMirrorEditor=function(a){if(Page.codeMirrorOn){Page.codeMirrorEditor.getWrapperElement().style.height=a+"px";
Page.codeMirrorEditor.refresh()}};Layout.showHideLayoutEditor=function(b){var c=jQuery(layoutEditorHandle);var a=jQuery(editorHandle).height();
if(b==undefined){b=!this.isLayoutVisible}if(b){Layout.isLayoutVisible=true;c.show()}else{Layout.isLayoutVisible=false;c.hide()}this.adjustTextEditorHeight(a)
};Layout.showHideTextEditor=function(b){var a=jQuery(editorHandle);var c=jQuery("#buttonShowHideLayoutEditor");var d=jQuery(".layoutListItem");
if(b==undefined){b=!this.isTextVisible}if(b){a.show();this.isTextVisible=true;c.prop("disabled",false);c.css("cursor","pointer");d.css("color","Black");
jQuery("#linetext").show();Page.setUmpleCode(Page.getUmpleCode())}else{a.hide();this.isTextVisible=false;c.prop("disabled",true);c.css("cursor","not-allowed");
d.css("color","DimGray");jQuery("#linetext").hide()}this.layoutHandler.showHideResizableAdjustment();this.layoutHandler.showHideResize()
};Layout.showHideCanvas=function(b){var a=jQuery(canvasHandle);if(b==undefined){b=!this.isDiagramVisible}if(b){a.show();this.isDiagramVisible=true;
Action.manualSync=jQuery("#buttonManualSync").prop("checked");jQuery("#buttonShowHideCanvas").prop("checked",true);if(!Action.manualSync){Action.updateUmpleDiagram();
Action.diagramInSync=true;Page.enableDiagram(true)}if(Action.manualSync&&!Action.diagramInSync){Page.enablePaletteItem("buttonSyncDiagram",true)
}if(!Action.manualSync||Action.diagramInSync){Page.enableCheckBoxItem("buttonPhotoReady","ttPhotoReady",true);Page.enableCheckBoxItem("buttonManualSync","ttManualSync",true);
Page.enablePaletteItem("buttonAddClass",true);Page.enablePaletteItem("buttonAddAssociation",true);Page.enablePaletteItem("buttonAddGeneralization",true);
Page.enablePaletteItem("buttonDeleteEntity",true);Page.initToggleTool("buttonAddClass");Page.initToggleTool("buttonAddAssociation");Page.initToggleTool("buttonAddGeneralization");
Page.initToggleTool("buttonDeleteEntity")}}else{a.hide();this.isDiagramVisible=false;Action.manualSync=true;jQuery("#buttonShowHideCanvas").prop("checked",false);
Page.enableCheckBoxItem("buttonPhotoReady","ttPhotoReady",false);Page.enableCheckBoxItem("buttonManualSync","ttManualSync",false);Page.enablePaletteItem("buttonAddClass",false);
Page.enablePaletteItem("buttonAddAssociation",false);Page.enablePaletteItem("buttonAddGeneralization",false);Page.enablePaletteItem("buttonDeleteEntity",false);
Page.enablePaletteItem("buttonSyncDiagram",false);Page.removeToggleTool("buttonAddClass");Page.removeToggleTool("buttonAddAssociation");
Page.removeToggleTool("buttonAddGeneralization");Page.removeToggleTool("buttonDeleteEntity")}this.layoutHandler.showHideResizableAdjustment();
this.layoutHandler.showHideResize()};Layout.showHideMenu=function(a){var b=jQuery("#paletteColumn");if(a==undefined){a=!this.isPaletteVisible
}if(a){Layout.isPaletteVisible=true;b.show()}else{Layout.isPaletteVisible=false;b.hide()}this.layoutHandler.showHideResizableAdjustment();
this.layoutHandler.showHideResize()};Layout.zoomResize=function(){var a=this.checkLayoutNeeded();if(a.layoutType==="large"){if(this.isInSmallScreenMode){this.toggleSmallScreenMode()
}}else{if(a.layoutType==="small"){if(!this.isInSmallScreenMode){this.toggleSmallScreenMode()}}}this.layoutHandler.adjustAfterWindowResize()
};Layout.toggleSmallScreenMode=function(){if(this.isInSmallScreenMode){this.isInSmallScreenMode=false;this.layoutHandler=new LargeScreenManager()
}else{this.isInSmallScreenMode=true;this.layoutHandler=new SmallScreenManager()}this.layoutHandler.transition(false)};Layout.verticallyResizing=function(a,b){this.layoutHandler.verticallyResizing(a,b)
};Layout.verticallyResized=function(a,b){this.layoutHandler.verticallyResized(a,b)};Layout.editorResizing=function(a,b){this.layoutHandler.editorResizing(a,b)
};Layout.editorResized=function(a,b){this.layoutHandler.editorResized(a,b)};Layout.canvasResizing=function(a,b){this.layoutHandler.canvasResizing(a,b)
};Layout.canvasResized=function(a,b){this.layoutHandler.canvasResized(a,b)};Layout.calculateMainHeight=function(){return jQuery(paletteHandle).outerHeight()
};function LargeScreenManager(){this.transition=function(c){if(!c){jQuery(editorHandle).resizable("destroy");jQuery(paletteHandle).resizable("destroy");
jQuery(canvasHandle).resizable("destroy");jQuery(editorHandle).removeClass("smallScreenEditor smallScreenEditorNoMargin");jQuery(canvasHandle).removeClass("smallScreenCanvas smallScreenCanvasNoEditor smallScreenCanvasNoEditorNoPalette")
}this.adjustMarginSpace();this.heightFactor=1;this.minCanvasSize=new UmplePosition(0,0,420,50);this.minEditorSize=new UmplePosition(0,0,284,0);
var a=jQuery(window).innerWidth()-this.marginSpace-jQuery(paletteHandle).outerWidth()-this.minCanvasSize.width;var b=jQuery(window).innerWidth()-this.marginSpace-jQuery(paletteHandle).outerWidth()-this.minEditorSize.width;
this.maxEditorSize=new UmplePosition(0,0,a,0);this.maxCanvasSize=new UmplePosition(0,0,b,0);this.initEditorResizable();this.initCanvasResizable();
this.initVerticalResizable()};this.initUmpleCanvasSize=function(){this.initCanvasResizable();this.setUmpleCanvasSize(this.minCanvasSize.width)
};this.initUmpleTextAreaSize=function(){this.initEditorResizable();this.setTextEditorSize(508,undefined);this.adjustAfterWindowResize()
};this.initPaletteSize=function(){jQuery("#paletteColumn").height(this.calculateHeight());jQuery("#palette").accordion("refresh");this.initVerticalResizable()
};this.setTextEditorSize=function(c,a){var b=jQuery(editorHandle);if(c==undefined){c=b.outerWidth()}if(a==undefined){a=Layout.calculateMainHeight()
}if(c<this.minEditorSize.width){c=this.minEditorSize.width}if(!Layout.isDiagramVisible){c=c}b.outerWidth(c);Layout.adjustTextEditorHeight(a);
if(Layout.isDiagramVisible){this.setUmpleCanvasSize(this.calculateLeftoverWidth()+jQuery(canvasHandle).outerWidth(),undefined)}};this.setUmpleCanvasSize=function(b,a){var c=jQuery(canvasHandle);
if(b==undefined){b=c.outerWidth()}if(a==undefined){a=Layout.calculateMainHeight()}if(b<this.minCanvasSize.width){b=this.minCanvasSize.width
}if(a<this.minCanvasSize.height){a=this.minCanvasSize.height}if(b>this.maxCanvasSize.width&&Layout.isTextVisible){b=this.maxCanvasSize.width
}c.outerWidth(b);c.height(a);jQuery("#palette").accordion("refresh")};this.showHideResize=function(){this.adjustMarginSpace();if(Layout.isDiagramVisible&&!Layout.isTextVisible){this.setUmpleCanvasSize(this.calculateLeftoverWidth()+jQuery(canvasHandle).outerWidth(),undefined)
}if(Layout.isTextVisible){this.setTextEditorSize(this.calculateLeftoverWidth()+jQuery(editorHandle).outerWidth(),undefined)}};this.showHideResizableAdjustment=function(){if(!Layout.isDiagramVisible||!Layout.isTextVisible){try{jQuery(canvasHandle).resizable("destroy")
}catch(a){}try{jQuery(editorHandle).resizable("destroy")}catch(a){}}else{if(Layout.isDiagramVisible&&Layout.isTextVisible){this.initCanvasResizable();
this.initEditorResizable()}}this.adjustMaxSizes()};this.adjustMaxSizes=function(){if(Layout.isDiagramVisible&&Layout.isTextVisible){var a=jQuery(window).innerWidth()-this.marginSpace-this.minCanvasSize.width;
if(Layout.isPaletteVisible){a-=jQuery(paletteHandle).outerWidth()}var b=jQuery(window).innerWidth()-this.marginSpace-this.minEditorSize.width;
if(Layout.isPaletteVisible){b-=jQuery(paletteHandle).outerWidth()}this.maxEditorSize=new UmplePosition(0,0,a,0);this.maxCanvasSize=new UmplePosition(0,0,b,0);
jQuery(editorHandle).resizable("option","maxWidth",this.maxEditorSize.width);jQuery(canvasHandle).resizable("option","maxWidth",this.maxCanvasSize.width)
}};this.adjustAfterWindowResize=function(){this.adjustMaxSizes();jQuery("#paletteColumn").height(this.calculateHeight());jQuery("#palette").accordion("refresh");
var a=this.calculateLeftoverWidth();if(a<=0&&jQuery(canvasHandle).outerWidth()+a<=this.minCanvasSize.width){this.setTextEditorSize(jQuery(editorHandle).outerWidth()+a,undefined)
}else{this.setTextEditorSize(a+jQuery(editorHandle).outerWidth(),undefined)}};this.initVerticalResizable=function(){jQuery("#mainApplication").resizable({resize:function(a,b){Layout.verticallyResizing(a,b)
},stop:function(a,b){Layout.verticallyResized(a,b)},autoHide:true,minHeight:this.minCanvasSize.height,handles:"s"})};this.initEditorResizable=function(){if(!Layout.isTextVisible||!Layout.isDiagramVisible){return
}jQuery(editorHandle).resizable({start:function(a,b){Layout.savedStartingWidth=jQuery(canvasHandle).width()},resize:function(a,b){Layout.editorResizing(a,b)
},stop:function(a,b){Layout.editorResized(a,b)},autoHide:true,minWidth:this.minEditorSize.width,maxWidth:this.maxEditorSize.width,handles:"e"})
};this.initCanvasResizable=function(){if(!Layout.isTextVisible||!Layout.isDiagramVisible){return}var a=jQuery(canvasHandle);a.resizable({start:function(b,c){Layout.savedStartingWidth=jQuery(editorHandle).outerWidth()
},resize:function(b,c){Layout.canvasResizing(b,c)},stop:function(b,c){Layout.canvasResized(b,c)},autoHide:true,minWidth:this.minCanvasSize.width,maxWidth:this.maxCanvasSize.width,handles:"w"})
};this.verticallyResizing=function(a,b){var c=b.size.height;jQuery(paletteHandle).outerHeight(c);jQuery(editorHandle).outerHeight(c);
jQuery(canvasHandle).outerHeight(c);Layout.adjustTextEditorHeight(c);jQuery("#palette").accordion("refresh")};this.verticallyResized=function(a,b){this.heightFactor=jQuery("#mainApplication").outerHeight()/(jQuery(window).innerHeight()-jQuery("#header").outerHeight()-jQuery("#topLine").outerHeight()-parseInt(jQuery("body").css("marginBottom"))-parseInt(jQuery("body").css("marginTop")));
this.setTextEditorSize(undefined,b.size.height);jQuery("#mainApplication").css("height","auto")};this.editorResizing=function(c,d){var a=d.size.width;
var b=d.originalSize.width-a;jQuery(canvasHandle).width(Layout.savedStartingWidth+b);jQuery(modelEditorHandle).width(a);jQuery(layoutEditorHandle).width(a)
};this.editorResized=function(b,c){var a=c.size.width;jQuery(modelEditorHandle).css("width","auto");jQuery(layoutEditorHandle).css("width","auto");
this.setTextEditorSize(a,undefined);delete Layout.savedStartingWidth};this.canvasResizing=function(c,d){var a=d.size.width;jQuery(canvasHandle).outerWidth(a);
var b=a-d.originalSize.width;jQuery(editorHandle).width(Layout.savedStartingWidth-b);jQuery(modelEditorHandle).width(Layout.savedStartingWidth-b);
jQuery(layoutEditorHandle).width(Layout.savedStartingWidth-b);jQuery(canvasHandle).css("left","0px")};this.canvasResized=function(b,c){var a=c.size.width;
jQuery(modelEditorHandle).css("width","auto");jQuery(layoutEditorHandle).css("width","auto");this.setTextEditorSize(this.calculateLeftoverWidth()+jQuery(editorHandle).outerWidth(),undefined);
delete this.savedStartingWidth};this.adjustMarginSpace=function(){jQuery(editorHandle).removeClass("largeScreenEditor largeScreenEditorNoMargin");
jQuery(canvasHandle).removeClass("largeScreenCanvas largeScreenCanvasNoMargin");if(Layout.isTextVisible){if(Layout.isDiagramVisible&&Layout.isPaletteVisible){jQuery(editorHandle).addClass("largeScreenEditor");
jQuery(canvasHandle).addClass("largeScreenCanvas")}else{if(Layout.isDiagramVisible||Layout.isPaletteVisible){jQuery(editorHandle).addClass("largeScreenEditor");
jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin")}else{jQuery(editorHandle).addClass("largeScreenEditorNoMargin");jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin")
}}}else{jQuery(editorHandle).addClass("largeScreenEditorNoMargin");if(Layout.isDiagramVisible&&Layout.isPaletteVisible){jQuery(canvasHandle).addClass("largeScreenCanvas")
}else{jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin")}}this.marginSpace=parseInt(jQuery("body").css("marginLeft"))+parseInt(jQuery("body").css("marginRight"))+1+parseInt(jQuery(canvasHandle).css("marginLeft"))+parseInt(jQuery(editorHandle).css("marginRight"))
};this.calculateLeftoverWidth=function(){var a=jQuery(window).innerWidth()-this.marginSpace;if(Layout.isTextVisible){a-=jQuery(editorHandle).outerWidth()
}if(Layout.isDiagramVisible){a-=jQuery(canvasHandle).outerWidth()}if(Layout.isPaletteVisible){a-=jQuery(paletteHandle).outerWidth()}return a
};this.calculateHeight=function(){var a=(jQuery(window).innerHeight()-jQuery("#header").outerHeight()-jQuery("#topLine").outerHeight()-parseInt(jQuery("body").css("marginBottom"))-parseInt(jQuery("body").css("marginTop"))-Layout.errorMessageSpace)*this.heightFactor;
if(a<this.minCanvasSize.height){return this.minCanvasSize.height}else{return a}}}function SmallScreenManager(){this.transition=function(a){if(!a){jQuery(editorHandle).resizable("destroy");
jQuery(canvasHandle).resizable("destroy");jQuery("#mainApplication").resizable("destroy");jQuery(editorHandle).removeClass("largeScreenEditor largeScreenEditorNoMargin");
jQuery(canvasHandle).removeClass("largeScreenCanvas largeScreenCanvasNoMargin")}this.adjustMarginSpace();this.minCanvasSize=new UmplePosition(0,0,420,50);
this.minEditorSize=new UmplePosition(0,0,284,0);this.initEditorResizable();this.initCanvasResizable();this.initPaletteResizable()};this.initUmpleCanvasSize=function(){this.setUmpleCanvasSize(undefined,this.calculateHeight());
this.initCanvasResizable();this.initPaletteResizable();if(Layout.isDiagramVisible==false){Layout.showHideCanvas(false)}};this.initUmpleTextAreaSize=function(){this.setTextEditorSize();
this.initEditorResizable()};this.initPaletteSize=function(){jQuery("#paletteColumn").outerHeight(this.calculateHeight());jQuery("#palette").accordion("refresh")
};this.setTextEditorSize=function(b,a){var b=this.calculateLeftoverWidth();if(Layout.isPaletteVisible){jQuery(editorHandle).outerWidth(b)
}else{jQuery(editorHandle).outerWidth(b)}if(a!=undefined){Layout.adjustTextEditorHeight(a)}else{Layout.adjustTextEditorHeight(this.calculateHeight())
}};this.setUmpleCanvasSize=function(b,a){if(Layout.isTextVisible){jQuery(canvasHandle).outerWidth(jQuery("body").width())}else{jQuery(canvasHandle).outerWidth(this.calculateLeftoverWidth())
}if(a!=undefined){jQuery(canvasHandle).outerHeight(a)}};this.showHideResize=function(){var a=undefined;this.adjustMarginSpace();if(Layout.isTextVisible){this.setTextEditorSize(undefined,jQuery(paletteHandle).outerHeight())
}else{a=jQuery(paletteHandle).outerHeight()}jQuery("#palette").accordion("refresh");this.pairResizables();this.setUmpleCanvasSize(undefined,a)
};this.showHideResizableAdjustment=function(){};this.adjustAfterWindowResize=function(){jQuery("#paletteColumn").outerHeight(this.calculateHeight());
jQuery("#palette").accordion("refresh");this.setTextEditorSize();this.setUmpleCanvasSize(undefined,this.calculateHeight())};this.initEditorResizable=function(){jQuery(editorHandle).resizable({autoHide:true,minHeight:30,handles:"s"});
this.pairResizables()};this.initPaletteResizable=function(){jQuery(paletteHandle).resizable({autoHide:true,minHeight:30,handles:"s"});
this.pairResizables()};this.initCanvasResizable=function(){jQuery(canvasHandle).resizable({autoHide:true,minHeight:30,handles:"s"});this.pairResizables()
};this.verticallyResizing=function(a,b){jQuery(paletteHandle).outerHeight(b.size.height);jQuery("#palette").accordion("refresh")};this.verticallyResized=function(a,b){};
this.editorResizing=function(a,b){Layout.adjustTextEditorHeight(b.size.height)};this.editorResized=function(a,b){};this.canvasResizing=function(a,b){jQuery(canvasHandle).outerHeight(b.size.height)
};this.canvasResized=function(a,b){};this.adjustMarginSpace=function(){jQuery(canvasHandle).removeClass("smallScreenCanvas smallScreenCanvasNoEditor smallScreenCanvasNoEditorNoPalette");
jQuery(editorHandle).removeClass("smallScreenEditor smallScreenEditorNoMargin");if(Layout.isTextVisible){jQuery(canvasHandle).addClass("smallScreenCanvas");
if(Layout.isPaletteVisible){jQuery(editorHandle).addClass("smallScreenEditor")}else{jQuery(editorHandle).addClass("smallScreenEditorNoMargin")
}}else{jQuery(editorHandle).addClass("smallScreenEditorNoMargin");if(Layout.isPaletteVisible&&Layout.isDiagramVisible){jQuery(canvasHandle).addClass("smallScreenCanvasNoEditor")
}else{jQuery(canvasHandle).addClass("smallScreenCanvasNoEditorNoPalette")}}this.marginSpace=parseInt(jQuery("body").css("marginLeft"))+parseInt(jQuery("body").css("marginRight"))+1+parseInt(jQuery(editorHandle).css("marginRight"))+parseInt(jQuery(canvasHandle).css("marginLeft"))
};this.calculateLeftoverWidth=function(){if(Layout.isPaletteVisible){return jQuery(window).innerWidth()-this.marginSpace-jQuery(paletteHandle).outerWidth()
}else{return jQuery(window).innerWidth()-this.marginSpace}};this.calculateHeight=function(){var a=(jQuery(window).innerHeight()-jQuery("#header").outerHeight(true)-2*jQuery("#topLine").outerHeight(true)-Layout.errorMessageSpace)/2;
return a};this.pairResizables=function(){if(!jQuery(editorHandle).is(".ui-resizable")||!jQuery(paletteHandle).is(".ui-resizable")||!jQuery(canvasHandle).is(".ui-resizable")){return
}if(Layout.isTextVisible){var f=function(g,h){Layout.editorResizing(g,h);Layout.verticallyResizing(g,h)};var a=f;var e=function(g,h){Layout.canvasResizing(g,h)
};var c=function(g,h){Layout.editorResized(g,h);Layout.verticallyResized(g,h)};var b=c;var d=function(g,h){Layout.canvasResized(g,h)}
}else{var f=function(g,h){Layout.editorResizing(g,h)};var e=function(g,h){Layout.canvasResizing(g,h);Layout.verticallyResizing(g,h)};
var a=e;var c=function(g,h){Layout.editorResized(g,h)};var d=function(g,h){Layout.canvasResized(g,h);Layout.verticallyResized(g,h)};var b=d
}jQuery(editorHandle).resizable("option","resize",f);jQuery(editorHandle).resizable("option","stop",c);jQuery(paletteHandle).resizable("option","resize",a);
jQuery(paletteHandle).resizable("option","stop",b);jQuery(canvasHandle).resizable("option","resize",e);jQuery(canvasHandle).resizable("option","stop",d)
}}function UmpleLine(a,b){this.pointOne=a;this.pointTwo=b;this.drawable=function(g){var q=jQuery("<div class='umpleLine'></div>");var d=UmplePositionFactory.copy(this.pointOne);
var f=UmplePositionFactory.copy(this.pointTwo);if(typeof(g)!="undefined"){d.x=d.x+g.x;d.y=d.y+g.y;f.x=f.x+g.x;f.y=f.y+g.y}var j=0;if(d.y==f.y){var o=d.x<f.x?d:f;
var e=Math.abs(f.x-d.x);q.append(this.createConnector(o.x,o.y,e,1));q.append(this.createSelector(o.x,o.y,e,6));return q}else{if(d.x==f.x){var o=d.y<f.y?d:f;
var p=Math.abs(f.y-d.y);q.append(this.createConnector(o.x,o.y,1,p));q.append(this.createSelector(o.x,o.y,6,p));return q}}var k=this.slope();
var h=f.x>d.x?1:-1;var m=h*k;if(Math.abs(k)>1){m=f.y>d.y?1:-1;h=m*(1/k)}var c=0;var l=d.y;for(var n=d.x;(n<=f.x&&h>0)||(n>=f.x&&h<0);
n+=h){if(c++>1000){break}q.append(this.createConnector(n,l,1,1));q.append(this.createSelector(n,l,6,6));l+=m;j++}return q};this.slope=function(){slope=(this.pointTwo.y-this.pointOne.y)/(this.pointTwo.x-this.pointOne.x);
return slope};this.length=function(){var e=this.pointTwo.x-this.pointOne.x;var d=this.pointTwo.y-this.pointOne.y;var f=Math.sqrt(Math.pow(e,2)+Math.pow(d,2));
return Math.round(f)};this.createConnector=function(d,g,f,c){var e=jQuery("<div></div>");e.addClass("umpleAssociation");e.attr("name",this.startId);
e.css({position:"absolute",left:d,top:g,width:f,height:c});return e};this.createSelector=function(e,g,f,d){var c=jQuery("<div></div>");
c.addClass("umpleAssociationSelector");c.attr("name",this.startId);c.css({position:"absolute",left:e,top:g,width:f,height:d});return c
};this.intersection=function(l){var y=this.pointOne.x;var f=this.pointOne.y;var x=this.pointTwo.x;var e=this.pointTwo.y;var w=l.pointOne.x;
var d=l.pointOne.y;var v=l.pointTwo.x;var c=l.pointTwo.y;var q=this.slope();var p=l.slope();var s=null;var r=null;var A=null;var z=null;
var m=false;if(q==p){return null}if(q==Infinity||q==-Infinity){z=d-p*w;s=y;r=p*s+z;m=true}else{if(p==Infinity||p==-Infinity){A=f-q*y;
s=w;r=q*s+A;m=true}}if(!m){A=f-q*y;z=d-p*w;s=(z-A)/(q-p);r=q*s+A}var h=(x>y)?x:y;var g=(v>w)?v:w;var o=(e>f)?e:f;var n=(c>d)?c:d;var k=(h==x)?y:x;
var j=(g==v)?w:v;var u=(o==e)?f:e;var t=(n==c)?d:c;if(s<k||s<j||s>h||s>g||r<u||r<t||r>o||r>n){return null}s=Math.round(s);r=Math.round(r);
return new UmplePosition(s,r,0,0)}}UmpleMethodFactory=new Object();UmpleMethodFactory.create=function(b){var a=new UmpleMethod(b.visibility,b.isAbstract,b.type,b.name,b.parameters);
return a};function UmpleMethod(b,d,a,e,c){this.visibility=b;this.isAbstract=d;this.type=a;this.name=e;this.parameters=(typeof(c)=="string"?c.split(","):c);
this.set=function(j){var h=(this.name!="");if(h){this.oldVisibility=this.visibility;this.oldType=this.type;this.oldName=this.name;this.oldParameters=this.parameters
}j=j.trim();var g=j.charAt(0);if(g=="+"){this.visibility="public";j=j.substr(1)}else{if(g=="-"){this.visibility="private";j=j.substr(1)
}else{if(g=="#"){this.visibility="protected";j=j.substr(1)}else{this.visibility="public"}}}var k=j.split(":");if(k.length<2){this.type="void";
this.name=j.substring(0,j.indexOf("(")).trim();this.parameters=j.match("\\((.*)\\)")[1].replace(/\s+/g,"").split(",")}else{var f=k[0].trim();
this.type=k[1].trim();this.name=f.substring(0,f.indexOf("(")).trim();this.parameters=f.match("\\((.*)\\)")[1].replace(/\s+/g,"").split(",")
}if(!h){this.newVisibility=this.visibility;this.newType=this.type;this.newName=this.name;this.newParameters=this.parameters}};this.copy=function(){return new UmpleMethod(this.visibility,this.type,this.name,this.parameters)
}}Page=new Object();Page.selectedItem=null;Page.selectedClass=null;Page.selectedAssociation=null;Page.selectedGeneralization=null;Page.codeEffect=null;
Page.clickCount=0;Page.repeatToolItem=false;Page.shortcutsEnabled=true;Page.modelDelimiter="//$?[End_of_model]$?";Page.codeMirrorOn=false;
Page.codeMirrorEditor=null;Page.hLine=null;Page.modelLoadingCount=0;Page.layoutLoadingCount=0;Page.canvasLoadingCount=0;Page.readOnly=false;
Page.useEditableClassDiagram=true;Page.useGvClassDiagram=false;Page.useGvStateDiagram=false;Page.useStructureDiagram=false;Page.showAttributes=true;
Page.showMethods=false;Page.showActions=true;Page.showTraits=false;Page.showTransitionLabels=false;Page.showGuardLabels=false;Page.modifiedDiagrams=false;
Page.init=function(e,b,a,d,g,f,c){Layout.isDiagramVisible=e;Layout.isTextVisible=b;Layout.isPaletteVisible=a;Layout.isLayoutVisible=g;
Page.readOnly=d;if(f=="GvState"){Page.useGvStateDiagram=true;Page.useEditableClassDiagram=false}else{if(f=="GvClass"){Page.useGvClassDiagram=true;
Page.useEditableClassDiagram=false}else{if(f=="structureDiagram"){Page.useStructureDiagram=true;Page.useEditableClassDiagram=false}}}jQuery.noConflict();
jQuery(document).keydown(function(h){Action.keyboardShortcut(h)});Layout.init();Page.initPaletteArea();Page.initCanvasArea();Page.initUmpleTextArea();
Page.initSourceCodeArea();jQuery(document).ready(function(){DropboxInitializer.initializeDropbox();ToolTips.initTooltips()});if(Page.readOnly){jQuery("#"+Page.umpleCanvasId()).addClass("photoReady")
}Action.loadFile();jQuery(c).prop("selected",true)};Page.initPaletteArea=function(){var a="#palette";var b=a+" *";jQuery(a).accordion({heightStyle:"fill",fillSpace:true,active:1,collapsible:true});
jQuery(b).addClass("unselectable");Layout.initPaletteSize();Page.initJQueryButton("buttonGenerateCode");Page.initJQueryButton("buttonStartOver");
Page.initHighlighter("buttonAddClass");Page.initHighlighter("buttonAddAssociation");Page.initHighlighter("buttonAddGeneralization");Page.initHighlighter("buttonDeleteEntity");
Page.initHighlighter("buttonPngImage");Page.initHighlighter("buttonYumlImage");Page.initHighlighter("buttonSimulateCode");Page.initHighlighter("buttonUigu");
Page.initHighlighter("buttonCopy");Page.initHighlighter("buttonCopyEncodedURL");Page.initHighlighter("buttonSmaller");Page.initHighlighter("buttonLarger");
Page.initHighlighter("buttonSyncCode");Page.initHighlighter("buttonSyncDiagram");Page.initHighlighter("buttonToggleMethods");Page.initHighlighter("buttonToggleAttributes");
Page.initHighlighter("buttonToggleActions");Page.initHighlighter("buttonToggleTransitionLabels");Page.initHighlighter("buttonToggleGuardLabels");
Page.initHighlighter("buttonToggleTraits");Page.initToggleTool("buttonAddClass");Page.initToggleTool("buttonAddAssociation");Page.initToggleTool("buttonAddGeneralization");
Page.initToggleTool("buttonDeleteEntity");Page.initAction("buttonPngImage");Page.initAction("buttonYumlImage");Page.initAction("buttonPhpCode");
Page.initAction("buttonEcoreCode");Page.initAction("buttonJavaCode");Page.initAction("buttonJavaAPIDoc");Page.initAction("buttonRubyCode");
Page.initAction("buttonAlloyCode");Page.initAction("buttonNuSMVCode");Page.initAction("buttonSqlCode");Page.initAction("buttonCppCode");
Page.initAction("buttonPhotoReady");Page.initAction("buttonSimulateCode");Page.initAction("buttonShowHideTextEditor");Page.initAction("buttonShowHideCanvas");
Page.initAction("buttonShowEditableClassDiagram");Page.initAction("buttonShowJointJSClassDiagram");Page.initAction("buttonShowGvClassDiagram");
Page.initAction("buttonShowGvStateDiagram");Page.initAction("buttonShowStructureDiagram");Page.initAction("buttonShowHideLayoutEditor");
Page.initAction("buttonManualSync");Page.initAction("buttonCopy");Page.initAction("buttonCopyEncodedURL");Page.initAction("buttonUndo");
Page.initAction("buttonRedo");Page.initAction("buttonUigu");Page.initAction("buttonStartOver");Page.initAction("buttonGenerateCode");
Page.initAction("buttonTabsCheckbox");Page.initAction("buttonSmaller");Page.initAction("buttonLarger");Page.initAction("buttonSyncCode");
Page.initAction("buttonSyncDiagram");Page.initAction("buttonToggleMethods");Page.initAction("buttonToggleAttributes");Page.initAction("buttonToggleActions");
Page.initAction("buttonToggleTraits");Page.initAction("buttonToggleTransitionLabels");Page.initAction("buttonToggleGuardLabels");Page.initLabels();
Page.enablePaletteItem("buttonUndo",false);Page.enablePaletteItem("buttonRedo",false);Page.enablePaletteItem("buttonSyncDiagram",false);
jQuery("#genstatus").hide();jQuery("#buttonViewComplete").hide();Page.initExamples();Page.initOptions();if(Page.readOnly){jQuery("#mainDrawMenu").hide();
jQuery(".layoutListItem").hide();jQuery("#preferencesTitle").hide();jQuery("#ttPhotoReady").hide();jQuery("#ttManualSync").hide();jQuery("#canvasSizeTitle").hide();
jQuery("#buttonSmaller").hide();jQuery("#buttonLarger").hide();jQuery("#menuBookmarkable").hide()}if(Page.readOnly||!Layout.isPaletteVisible){jQuery("#topBookmarkable").hide()
}if(!Layout.isPaletteVisible){jQuery("#paletteColumn").hide()}if(!Layout.isTextVisible){if(Page.readOnly){jQuery("#topLine").hide()}else{jQuery("#linetext").hide()
}}};Page.initOptions=function(){jQuery("#buttonShowHideLayoutEditor").prop("checked",Layout.isLayoutVisible);jQuery("#buttonShowHideTextEditor").prop("checked",Layout.isTextVisible);
jQuery("#buttonShowHideCanvas").prop("checked",Layout.isDiagramVisible);jQuery("#buttonTabsCheckbox").prop("checked",false);jQuery("#tabRow").hide();
jQuery("#ttTabsCheckbox").hide();jQuery("#buttonToggleAttributes").prop("checked",true);jQuery("#buttonToggleActions").prop("checked",true);
jQuery("#buttonToggleTransitionLabels").prop("checked",false);jQuery("#buttonToggleGuardLabels").prop("checked",false);jQuery("#buttonToggleTraits").prop("checked",false);
if(Page.useEditableClassDiagram){jQuery("#buttonShowEditableClassDiagram").prop("checked",true)}if(Page.useJointJSClassDiagram){jQuery("#buttonShowJointJSClassDiagram").prop("checked",true)
}if(Page.useGvClassDiagram){jQuery("#buttonShowGvClassDiagram").prop("checked",true)}if(Page.useGvStateDiagram){jQuery("#buttonShowGvStateDiagram").prop("checked",true)
}if(Page.useStructureDiagram){jQuery("#buttonShowStructureDiagram").prop("checked",true)}jQuery("#buttonPhotoReady").prop("checked",false);
jQuery("#buttonManualSync").prop("checked",false);jQuery("#buttonShowHideTextEditor").prop("disabled",false);jQuery("#buttonShowHideCanvas").prop("disabled",false);
jQuery("#buttonPhotoReady").prop("disabled",false);jQuery("#buttonManualSync").prop("disabled",false)};Page.initHighlighter=function(b){var a="#"+b;
jQuery(a).mouseover(function(){Page.highlightItem(b)});jQuery(a).mouseout(function(){Page.unhighlightItem(b)})};Page.removeHighlighter=function(b){var a="#"+b;
jQuery(a).unbind("mouseover");jQuery(a).unbind("mouseout")};Page.enableCheckBoxItem=function(e,b,a){var c=jQuery("#"+b);var d=jQuery("#"+e);
if(a){d.prop("disabled",false);d.css("cursor","pointer");c.css("color","Black")}else{d.prop("disabled",true);d.css("cursor","not-allowed");
c.css("color","Silver")}};Page.enablePaletteItem=function(d,a){var c=jQuery("#"+d);var b=!c.hasClass("disabled");if(b==a){return}if(a){c.removeClass();
c.prop("disabled",true);Page.initHighlighter(d)}else{c.removeClass();c.addClass("disabled");c.prop("disabled",false);Page.removeHighlighter(d)
}};Page.initToggleTool=function(b){var a=jQuery("#"+b);a.click(function(){Page.toggleToolItem(b,false)});a.dblclick(function(){Page.toggleToolItem(b,true)
})};Page.removeToggleTool=function(b){var a=jQuery("#"+b);a.unbind("click");a.unbind("dblclick")};Page.initJQueryButton=function(c){var a="#"+c;
var b=jQuery(a).attr("value");jQuery(a).button({label:b,className:"jQuery-palette-button"})};Page.initAction=function(b){var a="#"+b;
jQuery(a).click(Action.clicked)};Page.initLabels=function(){var d=jQuery(".buttonExtend");for(var b=0,a=d.length;b<a;b++){var c="#"+jQuery(d[b]).prop("id");
jQuery(c).click(function(e){return function(){jQuery("#"+jQuery(e).prop("id").replace("label","button")).trigger("click")}}(c))}};Page.initUmpleTextArea=function(){var a=jQuery("#umpleModelEditorText");
var b=jQuery("#umpleLayoutEditorText");a.keyup(function(c){Action.umpleTyped(c)});a.mousedown(function(){setTimeout('jQuery("#linenum").val(Action.getCaretPosition())',25)
});b.keyup(function(c){Action.umpleTyped(c)});a.focus(function(){Action.focusOn("umpleModelEditorText",true)});b.focus(function(){Action.focusOn("umpleLayoutEditorText",true)
});a.blur(function(){Action.focusOn("umpleModelEditorText",false)});b.blur(function(){Action.focusOn("umpleLayoutEditorText",false)});
Page.initCodeMirrorEditor();Layout.initUmpleTextAreaSize();if(!Layout.isTextVisible){Layout.showHideTextEditor(false)}if(!Layout.isLayoutVisible){Layout.showHideLayoutEditor(false)
}};Page.initCodeMirrorEditor=function(){var a=CodeMirror.newFoldFunction(CodeMirror.braceRangeFinder);Page.codeMirrorEditor=CodeMirror.fromTextArea(document.getElementById("umpleModelEditorText"),{lineNumbers:true,matchBrackets:true,readOnly:Page.readOnly,mode:"text/x-umple",lineWrapping:true,onFocus:function(c,b){Action.focusOn("CodeMirror",true)
},onBlur:function(c,b){Action.focusOn("CodeMirror",false)},onGutterClick:a,onChange:function(b,c){Action.umpleCodeMirrorTypingActivity()
},onCursorActivity:function(){Page.codeMirrorEditor.setLineClass(Page.hLine,null);Page.hLine=Page.codeMirrorEditor.setLineClass(Page.codeMirrorEditor.getCursor().line,"activeline");
Action.umpleCodeMirrorCursorActivity()},extraKeys:{"Ctrl-E":function(b){Page.clickShowEditableClassDiagram()},"Ctrl-J":function(b){Page.clickShowJointJSClassDiagram()
},"Ctrl-G":function(b){Page.clickShowGvClassDiagram()},"Ctrl-S":function(b){Page.clickShowGvStateDiagram()},"Ctrl-L":function(b){Page.clickShowStructureDiagram()
},"Ctrl-T":function(b){Page.clickShowHideText()},"Shift-Ctrl-Alt-T":function(b){Page.clickShowHideText()},"Ctrl-D":function(b){Page.clickShowHideCanvas()
},"Ctrl-N":function(b){Page.clickShowHideMenu()},"Ctrl-Alt-N":function(b){Page.clickShowHideMenu()},"Ctrl-Shift-=":function(b){Page.clickButtonlarger()
},"Ctrl-Shift--":function(b){Page.clickButtonSmaller()},"Ctrl-A":function(b){Page.clickToggleAttributes()},"Ctrl-M":function(b){Page.clickToggleMethods()
},"Ctrl-R":function(b){Page.clickToggleTraits()},"Ctrl-I":function(b){Page.clickToggleTransitionLabels()},"Ctrl-K":function(b){Page.clickToggleGuardLabels()
},Esc:function(b){b.getInputField().blur()}}});Page.hLine=Page.codeMirrorEditor.setLineClass(0,"activeline");Page.codeMirrorOn=true};
Page.clickShowEditableClassDiagram=function(){jQuery("#buttonShowEditableClassDiagram").trigger("click")};Page.clickShowJointJSClassDiagram=function(){jQuery("#buttonShowJointJSClassDiagram").trigger("click")
};Page.clickShowGvClassDiagram=function(){jQuery("#buttonShowGvClassDiagram").trigger("click")};Page.clickShowGvStateDiagram=function(){jQuery("#buttonShowGvStateDiagram").trigger("click")
};Page.clickShowStructureDiagram=function(){jQuery("#buttonShowStructureDiagram").trigger("click")};Page.clickShowHideText=function(){jQuery("#buttonShowHideTextEditor").trigger("click")
};Page.clickShowHideCanvas=function(){jQuery("#buttonShowHideCanvas").trigger("click")};Page.clickShowHideMenu=function(){Layout.showHideMenu()
};Page.clickButtonlarger=function(){jQuery("#buttonLarger").trigger("click")};Page.clickButtonSmaller=function(){jQuery("#buttonSmaller").trigger("click")
};Page.clickToggleAttributes=function(){jQuery("#buttonToggleAttributes").trigger("click")};Page.clickToggleMethods=function(){jQuery("#buttonToggleMethods").trigger("click")
};Page.clickToggleTraits=function(){jQuery("#buttonToggleTraits").trigger("click")};Page.clickToggleTransitionLabels=function(){jQuery("#buttonToggleTransitionLabels").trigger("click")
};Page.clickToggleGuardLabels=function(){jQuery("#buttonToggleGuardLabels").trigger("click")};Page.isPhotoReady=function(){if(Page.readOnly){return(true)
}else{var a="#buttonPhotoReady";return jQuery(a).prop("checked")}};Page.initSourceCodeArea=function(){SyntaxHighlighter.config.clipboardSwf="scripts/clipboard.swf";
var a="#generatedCodeRow";jQuery(a).hide()};Page.hideGeneratedCode=function(){jQuery("#generatedCodeRow").hide();jQuery("#innerGeneratedCodeRow").hide();
if(!Page.useStructureDiagram){jQuery("#svgCanvas").hide()}};Page.initCanvasArea=function(){var a=jQuery("#umpleCanvas");Layout.initUmpleCanvasSize();
a.click(function(b){Action.umpleCanvasClicked(b)});a.mousemove(Action.mouseMove);a.focus(function(){Action.focusOn(Page.umpleCanvasId(),true)
});a.blur(function(){Action.focusOn(Page.umpleCanvasId(),false)});a.delegate("[class$='editableDoubleClick']","dblclick",InlineEditor.handleOnClick);
a.delegate("[class$='editableSingleClick']","click",InlineEditor.handleOnClick);if(!Layout.isDiagramVisible){Layout.showHideCanvas(false)
}};Page.initExamples=function(){jQuery("#inputExample").change(Action.loadExample);jQuery("#defaultExampleOption").attr("selected",true);
jQuery("#inputExampleType").change(Action.setExampleType);jQuery("#inputExample2").change(Action.loadExample);jQuery("#defaultExampleOption2").attr("selected",true);
jQuery("#inputExample3").change(Action.loadExample);jQuery("#defaultExampleOption3").attr("selected",true);if(Page.useStructureDiagram){jQuery("#structureModels").prop("selected",true);
jQuery("#itemLoadExamples").hide();jQuery("#itemLoadExamples2").hide()}else{if(Page.useGvStateDiagram){jQuery("#smModels").prop("selected",true);
jQuery("#itemLoadExamples").hide();jQuery("#itemLoadExamples3").hide()}else{jQuery("#cdModels").prop("selected",true);jQuery("#itemLoadExamples2").hide();
jQuery("#itemLoadExamples3").hide()}}};Page.highlightItem=function(b){var a="#"+b;jQuery(a).addClass("highlight")};Page.unhighlightItem=function(b){var a="#"+b;
jQuery(a).removeClass("highlight")};Page.enableDiagram=function(a){Page.enableEditDragAndResize(a);Page.enablePaletteItem("buttonAddClass",a);
Page.enablePaletteItem("buttonAddAssociation",a);Page.enablePaletteItem("buttonAddGeneralization",a);Page.enablePaletteItem("buttonDeleteEntity",a);
Page.showDiagramSyncNeeded(!a)};Page.enableEditDragAndResize=function(a){if(a){jQuery("span.editable").removeClass("uneditable");jQuery("div.umpleClass").removeClass("unselectable");
jQuery("div.umpleClass.ui-draggable").draggable({disabled:false})}else{jQuery("span.editable").addClass("uneditable");jQuery("div.umpleClass").addClass("unselectable");
jQuery("div.umpleClass.ui-draggable").draggable({disabled:true})}};Page.toggleToolItem=function(d,b){if(b==undefined){b=false}Page.repeatToolItem=b;
var a=d.substring(6);var c=(a!=Page.selectedItem);if(c){Page.selectToggleTool(a)}else{Page.unselectAllToggleTools()}};Page.unselectAllToggleTools=function(){var b=false;
var a=false;a=DiagramEdit.removeNewClass();if(a){b=true}a=DiagramEdit.removeNewAssociation();if(a){b=true}a=DiagramEdit.removeNewGeneralization();
if(a){b=true}var c="ul.toggle li.selected";jQuery(c).removeClass("selected highlight");setTimeout("Page.enableEditDragAndResize(true);",500);
Page.selectedItem=null;Page.repeatToolItem=false;return b};Page.selectToggleTool=function(b){if(Page.selectedItem!=null){DiagramEdit.removeNewClass();
DiagramEdit.removeNewAssociation();DiagramEdit.removeNewGeneralization()}Page.enableEditDragAndResize(false);Page.selectedItem=b;Action.unselectAll();
var c=format("ul.toggle li.selected");var a="#button"+b;jQuery(c).removeClass("selected highlight");jQuery(a).addClass("selected")};Page.canShowHovers=function(){return Page.selectedItem==null||Page.selectedItem=="DeleteEntity"
};Page.getRawUmpleCode=function(){return document.getElementById("umpleModelEditorText").value};Page.getUmpleCode=function(){var a=Page.getRawUmpleCode().replace(Page.modelDelimiter,"");
var c=jQuery("#umpleLayoutEditorText").val().replace(Page.modelDelimiter,"");var b=a+Page.modelDelimiter+c;return b};Page.getEncodedURL=function(){var a=window.location.href.split("?")[0];
if(a.substr(0,42)=="http://cruise.site.uottawa.ca/umpleonline/"){a="http://try.umple.org/"}return a+"?text="+encodeURIComponent(Page.getUmpleCode())
};Page.splitUmpleCode=function(d){var c=d.indexOf(Page.modelDelimiter);if(c==-1){b=d;e=""}else{d=d.replace(Page.modelDelimiter,"");var b=d.substr(0,c);
var e=d.substr(c,d.length)}var a=[b,e];return a};Page.setUmpleCode=function(b,c){var a=Page.splitUmpleCode(b);jQuery("#umpleLayoutEditorText").val(a[1]);
if(Page.codeMirrorOn){Page.codeMirrorEditor.setValue(a[0])}jQuery("#umpleModelEditorText").val(a[0])};Page.setUmplePositioningCode=function(a){jQuery("#umpleLayoutEditorText").val(a)
};Page.umpleCanvasId=function(){return"umpleCanvas"};Page.showDiagramSyncNeeded=function(c){var b=jQuery("#umpleCanvas");var a='<div id="syncNeededMessage" class="syncNeededMessage unselectable">Diagram is out of synchronization with the text due to selecting Manual Sync or an error in the text that has caused the to compiler produce no output. </div>';
if(c){b.html(a+b.html())}else{jQuery("#syncNeededMessage").remove()}};Page.hideLoading=function(){var b="#topTextEditor";var c="#bottomTextEditor";
var a="#"+Page.umpleCanvasId();if(Page.modelLoadingCount>0){Page.modelLoadingCount--}if(Page.layoutLoadingCount>0){Page.layoutLoadingCount--
}if(Page.canvasLoadingCount>0){Page.canvasLoadingCount--}if(Page.modelLoadingCount===0){jQuery(b).hideLoading()}if(Page.layoutLoadingCount===0){jQuery(c).hideLoading()
}if(Page.canvasLoadingCount===0){jQuery(a).hideLoading()}if(Page.modelLoadingCount===0&&Page.layoutLoadingCount===0&&Page.canvasLoadingCount===0){jQuery(".bookmarkableUrl").removeClass("disabled")
}};Page.showModelLoading=function(){var a=jQuery("#topTextEditor");if(Page.modelLoadingCount==0){if(jQuery("#textEditorColumn").is(":visible")){a.showLoading()
}jQuery(".bookmarkableUrl").addClass("disabled")}Page.modelLoadingCount++};Page.showLayoutLoading=function(){var a=jQuery("#bottomTextEditor");
if(Page.layoutLoadingCount==0){jQuery(".bookmarkableUrl").addClass("disabled");if(a.is(":visible")){a.showLoading()}}Page.layoutLoadingCount++
};Page.showCanvasLoading=function(){var a=jQuery("#umpleCanvas");if(Page.canvasLoadingCount==0){jQuery(".bookmarkableUrl").addClass("disabled");
if(a.is(":visible")){a.showLoading()}}Page.canvasLoadingCount++};Page.resetCanvasSize=function(){Page.setUmpleCanvasSize(Layout.minCanvasSize.width,Layout.minCanvasSize.height)
};Page.getSelectedExample=function(){var b="";var c=Page.getExampleType();if(c=="cdModels"){var a=false;b=jQuery("#inputExample option:selected").val();
if(b=="GeometricSystem.ump"){a=true}if(a){if(!Page.useGvClassDiagram){jQuery("#buttonShowGvClassDiagram").attr("checked",true);Action.changeDiagramType({type:"GVClass"})
}else{if(!(Page.useEditableClassDiagram||Page.useGvClassDiagram)){jQuery("#buttonShowEditableClassDiagram").attr("checked",true);Action.changeDiagramType({type:"editableClass"})
}}}}else{if(c=="smModels"){b=jQuery("#inputExample2 option:selected").val();if(!Page.useGvStateDiagram){jQuery("#buttonShowGvStateDiagram").attr("checked",true);
Action.changeDiagramType({type:"GVState"})}}else{b=jQuery("#inputExample3 option:selected").val();if(!Page.useStructureDiagram){jQuery("#buttonShowStructureDiagram").attr("checked",true);
Action.changeDiagramType({type:"structure"})}}}return b};Page.getExampleType=function(){var a=jQuery("#exampleType option:selected").val();
return a};Page.showCodeDone=function(){var a="#genstatus";jQuery(a).show();setTimeout(function(){jQuery(a).hide()},2000)};Page.showViewDone=function(){var a="#buttonViewComplete";
jQuery(a).dialog({closeOnEscape:true,hide:"puff",height:100,width:250});setTimeout(function(){jQuery(a).dialog("close")},2000)};Page.showGeneratedCode=function(code,language,tabnumber){if(typeof(tabnumber)==="undefined"){tabnumber=""
}Action.toggleTabsCheckbox(language);Page.applyGeneratedCodeAreaStyles(language);var errorMarkup=Page.getErrorMarkup(code,language);var generatedMarkup=Page.getGeneratedMarkup(code,language);
if(errorMarkup!=""){jQuery("#messageArea").html(errorMarkup)}if(language=="java"||language=="php"||language=="cpp"||language=="ruby"||language=="xml"||language=="sql"||language=="alloy"||language=="nusmv"){jQuery("#innerGeneratedCodeRow"+tabnumber).html(formatOnce('<pre class="brush: {1};">{0}</pre>',generatedMarkup,language));
SyntaxHighlighter.highlight("code");if(tabnumber==""){jQuery("#innerGeneratedCodeRow").nextAll().remove();jQuery("#tabRow").html("");
Action.generateTabsCode(code);Action.toggleTabs()}}else{if(language=="structureDiagram"){eval(generatedMarkup);var downloadLink='<div id="diagramLinkContainer"></div>';
errorMarkup=downloadLink+errorMarkup;if(errorMarkup!=""){jQuery("#messageArea").html(errorMarkup)}Page.toggleStructureDiagramLink(false)
}else{jQuery("#innerGeneratedCodeRow"+tabnumber).html(generatedMarkup)}}};Page.applyGeneratedCodeAreaStyles=function(b){var a=jQuery("#generatedCodeRow");
a.show();jQuery("#innerGeneratedCodeRow").show();if(b=="diagramUpdate"){a.removeClass("generatedCode");a.removeClass("generatedDiagram")
}else{if(b=="stateDiagram"||b=="classDiagram"||b=="structureDiagram"){a.removeClass("generatedCode");a.addClass("generatedDiagram");if(b=="structureDiagram"){jQuery("#innerGeneratedCodeRow").html('<svg id="generatedSVGCanvas"></svg>')
}}else{a.removeClass("generatedDiagram");a.addClass("generatedCode")}}};Page.getErrorMarkup=function(b,c){var a="";if(c=="classDiagram"||c=="stateDiagram"){a=b.split("<svg xmlns=")[0];
a=a.replace(/&nbsp;\s*$/,"")}else{if(c=="javadoc"||c=="yumlDiagram"){a=b.split("<iframe ")[0]}else{if(c=="diagramUpdate"){a=b.replace(/<p>$/,"")
}else{a=b.split("<p>URL_SPLIT")[0]}}}return a};Page.getGeneratedMarkup=function(b,c){var a="";if(c=="classDiagram"||c=="stateDiagram"){a=b.split("<svg width=")[1];
a="<svg width="+a;a=a.replace(/<\/svg>$/,"")}else{if(c=="javadoc"||c=="yumlDiagram"){a=b.split("<iframe ")[1];a="<iframe "+a}else{if(c=="diagramUpdate"){}else{if(c=="structureDiagram"){a=b.split("<p>URL_SPLIT")[1];
a=a.replace(/##CANVAS_ID##/g,"generatedSVGCanvas");a=jQuery("<div/>").html(a).text()}else{a=b.split("<p>URL_SPLIT")[1]}}}}return a};Page.toggleStructureDiagramLink=function(b,a){linkContainer=jQuery("#diagramLinkContainer");
if(b){linkContainer.html(format("<a href='{0}' target='_blank' id='structureLink'>Download the SVG for the following</a>",a));jQuery("#structureLink").on("click",function(c){Page.toggleStructureDiagramLink(false)
})}else{linkContainer.html('<div id="buttonStructureLink" value="Generate SVG"></div>');Page.initJQueryButton("buttonStructureLink");
Page.initAction("buttonStructureLink")}};Page.setFilename=function(a){jQuery("#filename").val(a)};Page.setFeedbackMessage=function(a){document.getElementById("feedbackMessage").innerHTML=a
};Page.setExampleMessage=function(a){document.getElementById("exampleMessage").innerHTML=a};Page.getFeedbackMessage=function(){return document.getElementById("feedbackMessage").innerHTML
};Page.catFeedbackMessage=function(b){var a=document.getElementById("feedbackMessage").innerHTML;document.getElementById("feedbackMessage").innerHTML=a+b
};Page.getFilename=function(){return jQuery("#filename").val()};Page.getAdvancedMode=function(){return document.getElementById("advancedMode").value
};jQuery.fn.selectRange=function(b,a){return this.each(function(){if(this.setSelectionRange){this.focus();this.setSelectionRange(b,a)
}else{if(this.createTextRange){var c=this.createTextRange();c.collapse(true);c.moveEnd("character",a);c.moveStart("character",b);c.select()
}}})};UmplePositionFactory=new Object();UmplePositionFactory.copy=function(a){return new UmplePosition(a.x,a.y,a.width,a.height)};function UmplePosition(c,b,a,d){this.x=c;
this.y=b;this.width=a;this.height=d;this.set=function(f,e){this.x=f;this.y=e};this.subtract=function(e){return new UmplePosition(this.x-e.x,this.y-e.y,this.width-e.width,this.height-e.height)
};this.add=function(e){if(e==null){return UmplePositionFactory.copy(this)}return new UmplePosition(this.x+e.x,this.y+e.y,this.width+e.width,this.height+e.height)
};this.slopeAngle=function(e){return this.slopeAngleAndQuadrant(e)[0]};this.quadrant=function(e){return this.slopeAngleAndQuadrant(e)[1]
};this.equalsIgnoreSize=function(e){if(this.x!=e.x){return false}if(this.y!=e.y){return false}return true};this.slopeAngleAndQuadrant=function(o){var h=o.y-this.y;
var j=this.x-o.x;var l=h/j;var f=Math.atan(l)*180/3.14159;var g=h>=0&&j>=0;var n=h>=0&&j<0;var k=h<0&&j>=0;var m=h<0&&j<0;var e=g?"top-right":n?"top-left":k?"bottom-right":"bottom-left";
return[f,e]};this.slopeAngle360=function(j){var f;if(this.y==j.y){if(this.x>j.x){return 180}else{return 0}}var g=j.y-this.y;var h=j.x-this.x;
var e=h/g;if(j.y<this.y){f=90+Math.atan(e)*180/3.14159}else{f=270+Math.atan(e)*180/3.14159}return Math.round(f)};this.travelForward=function(j,h){var f=new UmplePosition(0,0,0,0);
var g=0;var e=0;if(h>=0&&h<90){g=Math.cos(h*3.14159/180)*j;e=Math.sin(h*3.14159/180)*j;f.x=this.x+g;f.y=this.y-e}else{if(h>=90&&h<180){h-=90;
g=Math.sin(h*3.14159/180)*j;e=Math.cos(h*3.14159/180)*j;f.x=this.x-g;f.y=this.y-e}else{if(h>=180&&h<270){h-=180;g=Math.cos(h*3.14159/180)*j;
e=Math.sin(h*3.14159/180)*j;f.x=this.x-g;f.y=this.y+e}else{h-=270;g=Math.sin(h*3.14159/180)*j;e=Math.cos(h*3.14159/180)*j;f.x=this.x+g;
f.y=this.y+e}}}f.x=Math.round(f.x);f.y=Math.round(f.y);return f};this.wallsAreAdjacent=function(f,e){if(f==e){return false}if(f=="West"&&e=="East"){return false
}if(f=="East"&&e=="West"){return false}if(f=="North"&&e=="South"){return false}if(f=="South"&&e=="North"){return false}return true};this.areAnglesSimilar=function(f,e){var g=3;
return Math.abs(f-e)<=g};this.toString=function(){return"("+this.x+","+this.y+","+this.width+","+this.height+")"}}jQuery(document).ready(function(){var f="filecode=";
var b="view=";var e="diagram=";var d="pref=";var a=document.cookie.split(";");var h=null;jQuery("#restorecode").hide();for(var g=0;g<a.length;
g++){var j=a[g].trim();if(j.indexOf(f)==0){h=j.substring(f.length,j.length)}else{if(j.indexOf(b)==0){b=j.substring(b.length,j.length)
}else{if(j.indexOf(e)==0){e=j.substring(e.length,j.length)}else{if(j.indexOf(d)==0){d=j.substring(d.length,j.length)}}}}}if(h!=null&&h.length!=0){jQuery("#restorecode").show();
setTimeout(function(){jQuery("#restorecode").hide()},30000);jQuery("#restorecode").click(function(){jQuery("#restorecode").hide();Page.setFilename(h);
Action.loadFile();if(b.indexOf("d")!=-1){if(!jQuery("#buttonShowHideTextEditor").attr("checked")){jQuery("#buttonShowHideTextEditor").trigger("click")
}}if(b.indexOf("t")!=-1){if(!jQuery("#buttonShowHideTextEditor").attr("checked")){jQuery("#buttonShowHideTextEditor").trigger("click")
}}if(b.indexOf("l")!=-1){if(!jQuery("#buttonShowHideLayoutEditor").attr("checked")){jQuery("#buttonShowHideLayoutEditor").trigger("click")
}}if(b.indexOf("a")!=-1){if(!jQuery("#buttonToggleAttributes").attr("checked")){jQuery("#buttonToggleAttributes").trigger("click")}}if(b.indexOf("m")!=-1){if(!jQuery("#buttonToggleMethods").attr("checked")){jQuery("#buttonToggleMethods").trigger("click")
}}if(e.indexOf("e")!=-1){if(!jQuery("#buttonShowEditableClassDiagram").attr("checked")){jQuery("#buttonShowEditableClassDiagram").trigger("click")
}}else{if(e.indexOf("c")!=-1){if(!jQuery("#buttonShowGvClassDiagram").attr("checked")){jQuery("#buttonShowGvClassDiagram").trigger("click")
}}else{if(e.indexOf("s")!=-1){if(!jQuery("#buttonShowGvStateDiagram").attr("checked")){jQuery("#buttonShowGvStateDiagram").trigger("click")
}}}}if(d.indexOf("p")!=-1){if(!jQuery("#buttonPhotoReady").attr("checked")){jQuery("#buttonPhotoReady").trigger("click")}}if(d.indexOf("s")!=-1){if(!jQuery("#buttonManualSync").attr("checked")){jQuery("#buttonManualSync").trigger("click")
}}})}});window.onbeforeunload=function(b){var a=new Date();a.setTime(a.getTime()+(30*24*60*60*1000));if(!(Page.getUmpleCode()==="//$?[End_of_model]$?")){document.cookie="filecode="+Page.getFilename()+";expires="+a.toGMTString()+";";
cookie_view="view=";if(jQuery("#buttonShowHideCanvas").attr("checked")){cookie_view+="d"}if(jQuery("#buttonShowHideTextEditor").attr("checked")){cookie_view+="t"
}if(jQuery("#buttonShowHideLayoutEditor").attr("checked")){cookie_view+="l"}if(jQuery("#buttonToggleAttributes").attr("checked")){cookie_view+="a"
}if(jQuery("#buttonToggleMethods").attr("checked")){cookie_view+="m"}if(jQuery("#buttonToggleTransitionLabel").attr("checked")){cookie_view+="r"
}if(jQuery("#buttonToggleGuardLabel").attr("checked")){cookie_view+="g"}cookie_view+=";expires="+a.toGMTString()+";";document.cookie=cookie_view;
cookie_diagram="diagram=";if(jQuery("#buttonShowEditableClassDiagram").attr("checked")){cookie_diagram+="e"}else{if(jQuery("#buttonShowGvClassDiagram").attr("checked")){cookie_diagram+="c"
}else{if(jQuery("#buttonShowGvStateDiagram").attr("checked")){cookie_diagram+="s"}}}cookie_diagram+=";expires="+a.toGMTString()+";";document.cookie=cookie_diagram;
cookie_pref="pref=";if(jQuery("#buttonPhotoReady").attr("checked")){cookie_pref+="p"}if(jQuery("#buttonManualSync").attr("checked")){cookie_pref+="s"
}cookie_pref+=";expires="+a.toGMTString()+";";document.cookie=cookie_pref}};UmpleSystem=new Object();UmpleSystem.umpleClasses=[];UmpleSystem.umpleAssociations=[];
UmpleSystem.position=function(){var b=jQuery("#umpleCanvas");var a=Math.ceil(b.offset().left-b.scrollLeft());var d=Math.ceil(b.offset().top-b.scrollTop());
var c=new UmplePosition(a,d,0,0);return c};UmpleSystem.findIn=function(c,b){if(c==null){return null}for(var d=0;d<c.length;d++){var a=c[d];
if(a.id==b){return a}}return null};UmpleSystem.find=function(a){return UmpleSystem.findIn(this.umpleClasses,a)};UmpleSystem.findAssociation=function(b){var a=UmpleSystem.findIn(this.umpleAssociations,b);
return a};UmpleSystem.createAssociation=function(a,d,e,c){var b=new UmpleAssociation();b.id=this.nextAssociationId();b.setClasses(a,d);
b.setOffsetOnePosition(e);b.setOffsetTwoPosition(c);b.setDefaultMultiplicities();b.setDefaultRoles();b.setName(b.getName());if(a==d){b.adjustReflexiveEndpoints()
}else{b.trimOverlap()}return this.addAssociation(b)};UmpleSystem.createGeneralization=function(a,c){var b=UmpleSystem.find(a);b.extendsClass=c;
UmpleSystem.updateClass(b)};UmpleSystem.addAssociation=function(a){this.umpleAssociations.push(a);var b=this.redrawAssociation(a);return a
};UmpleSystem.createClass=function(b){var a=new UmpleClass();a.id=this.nextId("NewClass");a.name=a.id;a.position.set(b.x-UmpleSystem.position().x,b.y-UmpleSystem.position().y,UmpleClassFactory.defaultSize.width,UmpleClassFactory.defaultSize.height);
var c=this.addClass(a);UmpleSystem.redrawGeneralizationsTo(c);return c};UmpleSystem.addClass=function(a){this.umpleClasses.push(a);this.updateClass(a);
var b=jQuery("#"+a.id);if(!Page.isPhotoReady()){b.click(Action.classClicked);b.mouseover(function(c){Action.classHover(c,true)});b.mouseout(function(c){Action.classHover(c,false)
});b.mousedown(function(c){setTimeout(function(){Action.classMouseDown(c)},400)});b.mouseup(function(c){Action.classMouseUp(c)});if(!Page.readOnly){b.draggable({containment:"parent",stop:function(c,d){DiagramEdit.classMoved(c.target)
}})}jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");jQuery(".ui-icon").removeClass("ui-icon")}return a
};UmpleSystem.replaceClass=function(f){for(var c=0;c<this.umpleClasses.length;c++){var d=this.umpleClasses[c];if(d.id==f.id){var b="#"+d.id;
var g=b+"_generalization";var e=jQuery(b).get();var a=jQuery(g).get();jQuery(e).attr("id",f.id);if(a!=undefined){jQuery(a).attr("id",f.id+"_generalization");
jQuery(a).remove()}this.umpleClasses[c]=f;this.updateClass(this.umpleClasses[c]);return}}};UmpleSystem.renameClass=function(d,a,g){var h=UmpleSystem.find(d);
var j="#"+d;var c=j+"_generalization";g=this.nextId(g);h.id=g;h.name=g;h.oldname=a;jQuery(j).attr("id",h.id);if(jQuery(c).get()!=undefined){jQuery(c).attr("id",h.id+"_generalization")
}for(var e=0;e<this.umpleAssociations.length;e++){var f=this.umpleAssociations[e];if(f.classOneId==a){f.classOneId=h.id}if(f.classTwoId==a){f.classTwoId=h.id
}}for(var e=0;e<this.umpleClasses.length;e++){var b=this.umpleClasses[e];if(b.extendsClass==a){b.extendsClass=g;this.updateClass(b)}}UmpleSystem.updateClass(h);
return h};UmpleSystem.replaceAssociation=function(a){for(var b=0;b<this.umpleAssociations.length;b++){var c=this.umpleAssociations[b];
if(c.id==a.id){this.umpleAssociations[b]=a;index=b}}this.redrawAssociation(a);return};UmpleSystem.updatePosition=function(a,c,b){a.position.x=c-UmpleSystem.position().x;
a.position.y=b-UmpleSystem.position().y;UmpleSystem.redrawAssociationsFor(a);UmpleSystem.redrawGeneralizationsTo(a);UmpleSystem.updateClass(a)
};UmpleSystem.updateClass=function(h){var f=h.drawable();var g=f[0];var b=f[1];var c=jQuery("#"+Page.umpleCanvasId());var a=jQuery("#"+h.id);
c.append(g);if(b!=null){for(var e=0;e<b.length;e++){c.append(b[e])}}UmpleSystem.redraw(h);var d=2;var j=false;if(a.width()>h.position.width+d){h.position.width=a.width();
j=true}if(a.height()>h.position.height+d){h.position.height=a.height();j=true}if(j){UmpleSystem.redraw(h)}jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
jQuery(".ui-icon").removeClass("ui-icon")};UmpleSystem.redrawAssociationsFor=function(a){for(var c=0;c<this.umpleAssociations.length;
c++){var b=this.umpleAssociations[c];if(b.contains(a)){UmpleSystem.redrawAssociation(b)}}};UmpleSystem.redrawAssociation=function(b){var c="#"+b.id;
var a="#"+Page.umpleCanvasId();var d=null;d=b.drawable();jQuery(a).append(d);if(!Page.isPhotoReady()){jQuery(c).click(Action.associationClicked);
jQuery(c).mouseover(function(e){Action.associationHover(e,true)});jQuery(c).mouseout(function(e){Action.associationHover(e,false)});UmpleSystem.setDragableAssociationAnchor(b,0);
UmpleSystem.setDragableAssociationAnchor(b,1)}return d};UmpleSystem.redrawGeneralizationsTo=function(d){for(var c=0;c<this.umpleClasses.length;
c++){var a=this.umpleClasses[c];if(a.extendsClass==d.id){this.updateClass(a)}else{if(a.interfaces.length>0){for(var b=0;b<a.interfaces.length;
b++){if(a.interfaces[b]==d.id){this.updateClass(a)}}}}}};UmpleSystem.update=function(){for(var a=0;a<this.umpleClasses.length;++a){var g=this.umpleClasses[a];
g.position.height=28;if(UmpleSystem.showAttributes){g.position.height+=17*(g.attributes.size())}if(UmpleSystem.showMethods){g.position.height+=17*(g.methods.size())
}UmpleSystem.updateClass(g)}for(var a=0;a<this.umpleAssociations.length;++a){var f=UmpleSystem.find(this.umpleAssociations[a].classOneId);
var h=this.umpleAssociations[a].offsetOnePosition.x+f.position.x+UmpleSystem.position().x;var d=this.umpleAssociations[a].offsetOnePosition.y+f.position.y+UmpleSystem.position().y;
var k=Action.associationSnapClassReady(h,d,f);var e=UmpleSystem.find(this.umpleAssociations[a].classTwoId);h=this.umpleAssociations[a].offsetTwoPosition.x+e.position.x+UmpleSystem.position().x;
d=this.umpleAssociations[a].offsetTwoPosition.y+e.position.y+UmpleSystem.position().y;var j=Action.associationSnapClassReady(h,d,e);var c=new UmplePosition(k[0],k[1],0,0);
var b=new UmplePosition(j[0],j[1],0,0);this.umpleAssociations[a].setOffsetOnePosition(c);this.umpleAssociations[a].setOffsetTwoPosition(b);
UmpleSystem.redrawAssociation(this.umpleAssociations[a])}for(var a=0;a<this.umpleClasses.length;++a){UmpleSystem.trimOverlappingAssociations(this.umpleClasses[a])
}};UmpleSystem.redraw=function(h){var d=h.position.x+UmpleSystem.position().x;var c=h.position.y+UmpleSystem.position().y;var j="#"+h.id;
var b=j+"_generalization";var e=j+"_width";var g=j+"_height";var f=new Object();f.top=c;f.left=d;jQuery(j).offset(f);jQuery(e).width(h.position.width);
jQuery(g).height(h.position.height);if(!Page.isPhotoReady()){var a=jQuery(b).get();if(a!=undefined){jQuery(b).click(Action.generalizationClicked);
jQuery(b).mouseover(function(k){Action.generalizationHover(k,true)});jQuery(b).mouseout(function(k){Action.generalizationHover(k,false)
})}}this.redrawAssociationsFor(h)};UmpleSystem.trimOverlappingAssociations=function(a){Page.showLayoutLoading();for(var c=0;c<UmpleSystem.umpleAssociations.length;
c++){var b=UmpleSystem.umpleAssociations[c];if(b.contains(a)){var e=UmplePositionFactory.copy(b.offsetOnePosition);var d=UmplePositionFactory.copy(b.offsetTwoPosition);
if(b.isReflexive()){b.adjustReflexiveEndpoints()}else{b.trimOverlap()}if(!e.equalsIgnoreSize(b.offsetOnePosition)||!d.equalsIgnoreSize(b.offsetTwoPosition)){Page.showLayoutLoading();
UmpleSystem.redrawAssociation(b);var f=Json.toString(b);DiagramEdit.updateUmpleText({actionCode:format("action=editAssociation&actionCode={0}",f),codeChange:false})
}}}Page.hideLoading()};UmpleSystem.updateAnchor=function(c,d){var e="#"+c.id;var b=e+"_anchor"+d;var f=e+"_hover"+d;var a="";switch(d){case 0:a="left top";
break;case 1:a="left center";break;case 2:a="left bottom";break;case 3:a="center bottom";break;case 4:a="right bottom";break;case 5:a="right center";
break;case 6:a="right top";break;case 7:a="center top";break}jQuery(b).show();jQuery(f).show();jQuery(b).position({my:"center",at:a,of:e});
jQuery(f).position({my:"center",at:a,of:e});jQuery(b).hide();jQuery(f).hide()};UmpleSystem.setDragableAssociationAnchor=function(c,d){if(Page.readOnly){return
}if(c.isReflexive()){var a="#"+c.id+"_anchor"+d;var b=d==0?c.classOneId:c.classTwoId;jQuery(a).draggable({drag:function(e,f){DiagramEdit.reflexiveAssociationMoving("#"+e.target.id)
},stop:function(e,f){DiagramEdit.associationMoved("#"+e.target.id)},cursor:"pointer",snap:"#"+b,snapTolerance:5,containment:"#"+b,zIndex:1})
}else{var a="#"+c.id+"_anchor"+d;var b=d==0?c.classOneId:c.classTwoId;jQuery(a).draggable({drag:function(e,f){DiagramEdit.regularAssociationMoving("#"+e.target.id)
},stop:function(e,f){DiagramEdit.associationMoved("#"+e.target.id)},cursor:"pointer",snap:"#"+b,snapTolerance:5,containment:"#"+b,zIndex:1})
}};UmpleSystem.updatingSize=function(a,c,b){a.position.width=c;a.position.height=b;UmpleSystem.redraw(a)};UmpleSystem.removeClass=function(b){for(var d=0;
d<this.umpleClasses.length;d++){var a=this.umpleClasses[d];if(a.id==b){this.umpleClasses.splice(d,1);var c="#"+b;var e=c+"_generalization";
jQuery(c).remove();jQuery(e).remove();return a}}return null};UmpleSystem.removeAssociation=function(a){for(var c=0;c<this.umpleAssociations.length;
c++){var b=this.umpleAssociations[c];if(b.id==a){this.umpleAssociations.splice(c,1);var d="#"+a;jQuery(d).remove();return b}}return null
};UmpleSystem.removeGeneralization=function(b){var e="#"+b;jQuery(e).remove();var d=b.replace("_generalization","");var a=UmpleSystem.find(d);
a.extendsClass=null;var c=new UmpleGeneralization();c.childId=a.id;c.parentId=a.extendsClass;return c};UmpleSystem.redrawCanvas=function(){UmpleSystem.merge(UmpleSystem)
};UmpleSystem.merge=function(a){UmpleSystem.mergeClasses(a);UmpleSystem.mergeAssociations(a)};UmpleSystem.mergeClasses=function(d){if(d==null){while(this.umpleClasses.length>0){this.removeClass(this.umpleClasses[0].id)
}return}for(var b=0;b<this.umpleClasses.length;b++){var a=this.umpleClasses[b];var e=this.findIn(d.umpleClasses,a.id);if(e==null){b-=1;
this.removeClass(a.id)}else{this.replaceClass(UmpleClassFactory.create(e))}}for(var b=0;b<d.umpleClasses.length;b++){var e=d.umpleClasses[b];
var c=this.find(e.id);if(c==null){this.addClass(UmpleClassFactory.create(e))}}for(var b=0;b<this.umpleClasses.length;b++){var a=this.umpleClasses[b];
if(a.extendsClass!=null||a.interfaces.length>0){this.updateClass(a)}}};UmpleSystem.mergeAssociations=function(e){if(e==null){while(this.umpleAssociations.length>0){this.removeAssociation(this.umpleAssociations[0].id)
}return}for(var c=0;c<this.umpleAssociations.length;c++){var b=this.umpleAssociations[c];var a=this.findIn(e.umpleAssociations,b.id);
if(a==null){c-=1;this.removeAssociation(b.id)}else{this.replaceAssociation(UmpleAssociationFactory.create(a))}}for(var c=0;c<e.umpleAssociations.length;
c++){var d=this.findAssociation(e.umpleAssociations[c].id);if(d==null){var a=UmpleAssociationFactory.create(e.umpleAssociations[c]);this.addAssociation(a)
}}};UmpleSystem.nextId=function(f){var d="umpleElement_";var b=d+"0";if(typeof(f)!="undefined"){d=f;b=f}var e=false;var a=0;while(a<100&&!e){if(a>0){b=d+a
}e=true;for(var c=0;c<this.umpleClasses.length;c++){if(this.umpleClasses[c].id==b){e=false;a+=1;break}}if(e){return b}}return""};UmpleSystem.nextAssociationId=function(f){var d="umpleAssociation_";
var b=d+"0";if(typeof(f)!="undefined"){d=f;b=f}var e=false;var a=0;while(a<100&&!e){if(a>0){b=d+a}e=true;for(var c=0;c<this.umpleAssociations.length;
c++){if(this.umpleAssociations[c].id==b){e=false;a+=1;break}}if(e){return b}}return""};var ToolTips={};var undo,redo,toggleTextEditor;
if(navigator.appVersion.indexOf("Mac")!=-1){undo="cmd-z";redo="cmd-shift-z";toggleTextEditor="ctrl-t"}else{undo="ctrl-z";redo="ctrl-y";
toggleTextEditor="ctrl-alt-shift-t"}ToolTips.tooltipEntries={ttSaveBookmark:["li","Click to bookmark this model"],ttSaveModel:["li","Click to save this model for future editing"],buttonCopy:["li","Click to open the source for this model"],buttonCopyEncodedURL:["li","Click to view a url encoded with this model"],ttDropboxSaver:["li","Click to save your model to dropbox"],ttStartOver:["li","Click to clear the text editor and the diagram"],ttDropboxChooser:["li","Click to load an example from dropbox"],buttonAddClass:["li","Click the diagram to add a class </br><b>Shortcut: [c]</b>"],buttonAddAssociation:["li","Click on two classes to create an association </br><b>Shortcut: [a]</b>"],buttonAddGeneralization:["li","Click on two classes to create a generalization </br><b>Shortcut: [g]</b>"],buttonDeleteEntity:["li","Click on a class, association, or generalization to delete that entity </br><b>Shortcut: [DEL]</b>"],buttonUndo:["li","Click to undo the most recent action </br><b>Shortcut: ["+undo+"]</b>"],buttonRedo:["li","Click to redo the most recent undone action </br><b>Shortcut: ["+redo+"]</b>"],buttonSyncDiagram:["li","Click to sync the diagram and the text"],ttGeneratedCodeType:["li","Choose the language or diagram to generate"],ttGenerateCode:["li","Click this button to generate the above code or diagram"],ttShowHideCanvas:["li","Show/Hide the diagram </br><b>Shortcut: [ctrl+d]"],ttShowHideTextEditor:["li","Show/Hide the text editor </br><b>Shortcut: ["+toggleTextEditor+"]"],ttShowHideLayoutEditor:["li","Show/Hide the layout editor"],ttToggleAttributes:["li","Show/Hide attributes on class diagrams </br><b>Shortcut: [ctrl+a]"],ttToggleMethods:["li","Show/Hide the methods on class diagrams </br><b>Shortcut: [ctrl+m]"],ttToggleActions:["li","Show/Hide the actions on the state diagrams"],ttToggleTransitionLabel:["li","Show/Hide the transition labels on the state diagrams"],ttToggleGuardLabel:["li","Show/Hide the guard labels on the state diagrams"],ttShowEditableClassDiagram:["li","Display a graphically editable class diagram </br><b>Shortcut: [ctrl+e]</b>"],ttShowJointJSClassDiagram:["li","Display a prettier graphically editable class diagram </br><b>Shortcut: [ctrl+j]</b>"],ttShowGvClassDiagram:["li","Display a class diagram rendered using GraphViz </br><b>Shortcut: [ctrl+g]</b>"],ttShowGvStateDiagram:["li","Display a state diagram rendered using GraphViz</br><b>Shortcut: [ctrl+s]</b>"],ttShowStructureDiagram:["li","Display a graphically editable composite structure diagram </br><b>Shortcut: [ctrl+l]</b>"],ttPhotoReady:["li","Remove editing handles from diagram"],ttManualSync:["li","Stop the diagram from syncing automatically"],ttYumlImage:["li","Generate a class diagram using Yuml in another window"]};
ToolTips.initTooltips=function(){for(var a in this.tooltipEntries){jQuery("#"+a).tooltip({items:this.tooltipEntries[a][0],content:this.tooltipEntries[a][1],show:{delay:1000},position:{my:"right",at:"left",of:"#"+a}})
}dropDownTooltips={exampleType:["li","Choose an example type to load"],itemLoadExamples:["li","Choose a class diagram example to load"],itemLoadExamples2:["li","Choose a state diagram example to load"],itemLoadExamples3:["li","Choose a composite structure diagram example to load"]};
for(a in dropDownTooltips){jQuery("#"+a).tooltip({items:dropDownTooltips[a][0],content:dropDownTooltips[a][1],show:{delay:1000},position:{my:"center+15% bottom",at:"top",of:"#"+a}})
}jQuery(document).tooltip({show:{delay:1000}})};var ObjectsUtil={objects:{},parentCalls:{},declare:function(D,B,q){if(ObjectsUtil.objects[D]){return
}this.parentCalls[D]={};ObjectsUtil.objects[D]=function(){ObjectsUtil.objects[D].prototype.constructor.apply(this,arguments)};var p=[];
for(var w=0;w<B.length;w++){p.push(B[w])}var C=[];for(var w=0;w<p.length;w++){var v=p[w];var x=ObjectsUtil.get(v);if(typeof x!=="function"){continue
}var y=x.prototype;var A=y.constructor;if(A){C.push(A)}for(var s in y){if(s!=="constructor"){var u=y[s];if(typeof u==="function"){if(!this.parentCalls[D][s]){this.parentCalls[D][s]=[]
}this.parentCalls[D][s].push(u)}else{ObjectsUtil.objects[D].prototype[s]=u}}else{}}}ObjectsUtil.objects[D].prototype.className=D;var r;
for(var s in q){if(s==="constructor"){r=q[s]}else{ObjectsUtil.objects[D].prototype[s]=q[s]}}var t=this.parentCalls[D];for(var s in t){if(!ObjectsUtil.objects[D].prototype[s]){var z=t[s];
if(z.length>0){ObjectsUtil.objects[D].prototype[s]=z[0]}}}ObjectsUtil.objects[D].prototype.constructor=function(){for(var a=0;a<C.length;
a++){C[a].apply(this,arguments)}if(r){r.apply(this,arguments)}}},superCall:function(k,h,f){var j=this.parentCalls[j.className];if(j){for(var g=0;
g<j.length;g++){j[g].call(k,f)}}},define:function(c,d){if(ObjectsUtil.objects[c]){return}ObjectsUtil.objects[c]=d;return d},get:function(b){return ObjectsUtil.objects[b]
},newInstance:function(g,h){var f=new ObjectsUtil.objects[g](h);if(typeof h!=="string"){for(var e in h){if(f[e]){continue}f[e]=h[e]}}return f
},isArray:function(b){return b&&(typeof b=="array"||b instanceof Array)}};(function(){var b=ObjectsUtil.get("util.core.CoreUtil");ObjectsUtil.declare("util.core.Map",[],{values:null,keys:null,constructor:function(){this.values=[];
this.keys=[]},put:function(a,e){var f=this.keys.indexOf(a);if(f===-1){this.values.push(e);this.keys.push(a)}else{this.values[f]=e}},get:function(a){return this.values[this.keys.indexOf(a)]
},remove:function(a){var d=this.keys.indexOf(a);if(d<0){return}this.values.splice(d,1);this.keys.splice(d,1)},clear:function(){this.values=[];
this.keys=[]}})})();(function(){var d=ObjectsUtil.newInstance("util.core.Map");var c=[];ObjectsUtil.define("util.core.Events",{topics:{},suspend:null,connect:function(r,p,q,b){var a=this;
var o,l;if(p.addEventListener){o=function(){b.apply(q,arguments)};p.addEventListener(r,o,false);l=function(){p.removeEventListener(r,o,false)
}}else{var n=d.get(p);if(!n){n=[];d.put(p,n)}if(!n[r]){n[r]={bridged:p[r],connects:[]};var a=this;p[r]=function(){n[r].bridged.apply(p,arguments);
if(!a.suspend){var e=n[r].connects;for(var f=0,g;g=e[f];f++){g.callback.apply(g.context,arguments)}}}}n[r].connects.push({callback:b,context:q});
o=b}var m={callback:o,disconnector:l,type:r,object:p,context:q};c.push(m);return m},disconnectAll:function(){while(c.length>0){this.disconnect(c[0],d)
}this.topics={}},disconnect:function(l,o){if(!l){return}if(l.object.removeEventListener){l.disconnector()}else{var b=d.get(l.object);
if(!b){return}var m=b[l.type];if(!m){return}m=m.connects;if(!m){return}for(var p=0,a;a=m[p];p++){if(a.callback===l.callback){m.splice(m.indexOf(a),1);
p=0}}}var n=c.indexOf(l);if(n>-1){c.splice(n,1)}},subscribe:function(h,a,g){if(!this.topics[h]){this.topics[h]=[]}var b={handler:a,context:g};
this.topics[h].push(b);return b},unsubscribe:function(f,a){if(!this.topics[f]){return}var b=this.topics[f].indexof(a);if(b>-1){this.topics[f].splice(b,1)
}},publish:function(j){var b=this.topics[j];if(!b){return}for(var k=0,h;h=b[k];k++){var a=Array.prototype.slice.call(arguments,1);h.handler.apply(h.context||this,a)
}}})})();(function(){ObjectsUtil.define("util.core.UUIDGenerator",{generate:function(){return"xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g,function(f){var e=Math.random()*16|0,d=f==="x"?e:(e&3|8);
return d.toString(16)})}})})();(function(){ObjectsUtil.define("util.svg.SVGUtil",{SVG:"http://www.w3.org/2000/svg",syncLineBetweenVertices:function(U,O,L){var B=O.getRootNode();
var P=parseFloat(B.getAttribute("height"));var S=O.focalNode;var T=L.focalNode;var K=parseFloat(S.getAttribute("x"));var Z=parseFloat(S.getAttribute("y"));
var X=parseFloat(S.getAttribute("height"));var I=parseFloat(S.getAttribute("width"));var M=parseFloat(T.getAttribute("x"));var aa=parseFloat(T.getAttribute("y"));
var Y=parseFloat(T.getAttribute("height"));var J=parseFloat(T.getAttribute("width"));var C=K+(I/2);var F=Z+(X/2);var D={y:F,x:C};var R={y:aa,x:M+(J/2),getRange:function(a,c){var b=M/P;
var d=(J/2)*b;var e=M+(J/2);if(Math.abs(a-e)<2){return e}if(a<M+(J/2)){return e-d}else{if(a>M+(J/2)){return e+d}else{return e}}}};var Q={y:aa+Y,x:M+(J/2),getRange:function(a,c){var b=M/P;
var d=(J/2)*b;var e=M+(J/2);if(Math.abs(a-e)<2){return e}if(a<M+(J/2)){return e-d}else{if(a>M+(J/2)){return e+d}else{return e}}}};var W={y:aa+(Y/2),x:M,getRange:function(a,c){var b=aa/P;
var d=(Y/2)*b;var e=aa+(Y/2);if(Math.abs(c-e)<2){return e}if(c<aa+(Y/2)){return e-d}else{if(c>aa+(Y/2)){return e+d}else{return e}}}};
var N={y:aa+(Y/2),x:M+J,getRange:function(a,c){var b=aa/P;var d=(Y/2)*b;var e=aa+(Y/2);if(Math.abs(c-e)<2){return e}if(c<aa+(Y/2)){return e-d
}else{if(c>aa+(Y/2)){return e+d}else{return e}}}};var ab=function(a,b){return Math.abs((a.x-b.x))+Math.abs((a.y-b.y))};var E=ab(D,R);
var G=ab(D,Q);var V=ab(D,W);var H=ab(D,N);if(E<G&&E<V&&E<H){U.setAttribute("d","M"+C+","+F+" L"+R.getRange(C,F)+" "+R.y)}else{if(G<E&&G<V&&G<H){U.setAttribute("d","M"+C+","+F+" L"+Q.getRange(C,F)+" "+Q.y)
}else{if(V<E&&V<G&&V<H){U.setAttribute("d","M"+C+","+F+" L"+W.x+" "+W.getRange(C,F))}else{if(H<E&&H<G&&H<V){U.setAttribute("d","M"+C+","+F+" L"+N.x+" "+N.getRange(C,F))
}}}}O.parentNode.refreshChild(U)},syncVertixLines:function(g){var k=ObjectsUtil.get("util.svg.SVGUtil");var j=g.getChildren("connector");
for(var h=0;f=j[h];h++){var f=j[h];k.syncLineBetweenVertices(f.focalNode,f.source,f.target)}},getConnector:function(g,h){var k=g.getChildren("connector");
for(var f=0;f<k.length;f++){var j=k[f];if(j.target===g){if(j.source===h){return j}}else{if(j.source===g){if(j.target===h){return j}}}}return null
}})})();(function(){var f=ObjectsUtil.get("util.svg.SVGUtil");var d={};var e={};ObjectsUtil.define("layout.shapes.ShapesRegistry",{register:function(a,b){d[a]=b
},draw:function(a,c,b){var h=ObjectsUtil.newInstance(d[a],c,b);if(!e[a]){e[a]={}}e[a][h.id||h.guid]=h;h.draw(c,b);return h},get:function(b,a){return a?e[b][a]:e[b]
},getAndGroup:function(k,a){var c=this.get(k,a);var n={};for(var m in c){var b=c[m];if(!b){continue}var l=b.parent;if(!l){continue}if(!n[l]){n[l]={}
}n[l][m]=b}return n},destroy:function(a){e[a.guid].destroy();e[a.guid]=undefined},empty:function(){e={}},showMessage:function(k,b){var c=document.getElementById(k);
if(!c){return}ObjectsUtil.get("util.core.Events").disconnectAll();ObjectsUtil.get("layout.shapes.ShapesRegistry").empty();ObjectsUtil.get("util.core.DomUtil").empty(c);
var l=ObjectsUtil.get("util.svg.SVGUtil");var a=c.descriptionMessage||document.createElementNS(l.SVG,"text");a.setAttribute("x",20);a.setAttribute("y",20);
a.setAttribute("style","fill: #000000;  font-family:tahoma; font-size: 16;  font-weight:bold");a.appendChild(document.createTextNode(b));
c.appendChild(a);var j=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(b,a);c.style.width=j.w+120+"px";c.style.height=j.h+5+"px";
c.style.border="none";c.descriptionMessage=a},paint:function(a,b){if(b&&a.args.container){ObjectsUtil.get("util.core.Events").disconnectAll();
ObjectsUtil.get("layout.shapes.ShapesRegistry").empty();ObjectsUtil.get("util.core.DomUtil").empty(a.args.container)}this._paint(a)},_paint:function(a,h,c){if(h){a.args.parentNode=h
}if(c){a.args.container=c}if(!a.args.id){a.args.id=a.args.name}var b=ShapesRegistry.draw(a.descriptor,a.args,a);return b}})})();(function(){var j=ObjectsUtil.get("util.svg.SVGUtil");
var g=ObjectsUtil.get("layout.shapes.ShapesRegistry");var h=40;var k=100000;var f=0.0005;f=0.0005;ObjectsUtil.declare("layout.routers.AutomaticRouter",[],{forcex:null,forcey:null,_layoutInterval:null,graph:null,constructor:function(a){this.graph=a;
this.forcex={};this.forcey={}},layout:function(){var a=this;a._doLayout();this._layoutInterval=setInterval(function(){a._doLayout()},100)
},_doLayout:function(){var w=this.graph.getChildren("rectangle");for(var u=0;vertix1=w[u];u++){var r=vertix1.name;this.forcex[r]=0;this.forcey[r]=0;
for(var t=0;vertix2=w[t];t++){var s=vertix2.name;if(r===s){continue}var a=parseFloat(vertix2.getAttribute("x"))-parseFloat(vertix1.getAttribute("x"));
var b=parseFloat(vertix2.getAttribute("y"))-parseFloat(vertix1.getAttribute("y"));var c=Math.pow(a,2)+Math.pow(b,2);this.forcex[r]-=(k/c)*a;
this.forcey[r]-=(k/c)*b;if(j.getConnector(vertix1,vertix2)){var x=Math.sqrt(c);this.forcex[r]+=(x-h)*a;this.forcey[r]+=(x-h)*b}}}var v=0;
for(var u=0;vertix1=w[u];u++){var r=vertix1.name;var d=this.forcex[r]*f;var e=this.forcey[r]*f;v=v+Math.abs(d)+Math.abs(e);vertix1.setPosition({x:parseFloat(vertix1.getAttribute("x"))+d,y:parseFloat(vertix1.getAttribute("y"))+e})
}if(Math.round(v)<40){clearInterval(this._layoutInterval)}}})})();(function(){var j=ObjectsUtil.get("util.svg.SVGUtil");var g=ObjectsUtil.get("layout.shapes.ShapesRegistry");
var h=40;var k=100000;var f=0.0005;f=0.0005;ObjectsUtil.declare("layout.routers.HorizontalTreeRouter",[],{forcex:null,forcey:null,graph:null,constructor:function(a){this.graph=a;
this.forcex={};this.forcey={}},layout:function(){var a=this;a._doLayout()},_doLayout:function(){var y=[];var B=function(s,n){var m=[];
var o=s.getChildren("connector");for(var l=0;l<o.length;l++){var q=o[l];if(q.source===s){var r=q.target;if(n&&y.indexOf(r)>-1){continue
}m.push(q.target)}else{if(q.target===s){var p=q.source;if(n&&y.indexOf(p)>-1){continue}m.push(q.source)}}}return m};var J=function(n){var m=n.getChildren("connector");
if(m.length<1){return 1}var o=0;for(var l=0;subChild=m[l];l++){o=o+J(subChild)}return o};var e=function(m){var o=m.getChildren("connector");
if(o.length<1){return 1}var n=0;for(var q=0;subChild=o[q];q++){var p;if(subChild.source===m){p=subChild.target}else{if(subChild.target===m){p=subChild.source
}}if(!p){continue}var l=parseFloat(p.getAttribute("width"));if(l>n){n=l}}return n};var A=function(m,o){if(!o){o=[]}var l=B(m);if(l.length===1){return 1
}var n=0;for(var q=0;q<l.length;q++){var p=l[q];if(o.indexOf(p)>-1){continue}o.push(l[q]);n=n+A(l[q],o)}return n};var I=this.graph.getChildren("rectangle");
var c=I;c.sort(function(m,l){return J(l)-J(m)});var b=40;var d=30;var x={x:0,y:0};var G=function(v,r,l,q){if(y.indexOf(v)>-1){return}y.push(v);
var W=J(v,true);if(q){W--}v.setPosition({x:r,y:l});if(l>x.y){x.y=l}if(r>x.x){x.x=r}var s=B(v,true);var w=s.length;var n=W*b;var Y=l-(n/2);
var V=0;for(var aa=0;aa<w;aa++){var U=s[aa];var u=J(U)-1;var m=Y;if(aa){m=m+b}if(!u){u=1}var ab=m+(u*b);var Z=(m+ab)/2;var X=r+d+parseFloat(v.getAttribute("width"));
U.setPosition({x:X,y:Z});if(Z>x.y){x.y=Z}if(X>x.x){x.x=X}Y=ab-b;V=V+(u||1);y.push(U);var t=B(U,true);var p=X+parseFloat(U.getAttribute("width"))+d;
if(t.length===1){G(t[0],p,Z,true)}else{if(t.length>=2){var ac=m+b/2;var T=(((ab-ac)/t.length))+b/t.length;for(var o=0;o<t.length;o++){G(t[o],p,ac+(T*o),true)
}}}}};for(var F=0;F<c.length;F++){var z=c[F];if(y.indexOf(z)>-1){continue}var C=A(z);var a=y.length===0?((C*b)/4):x.y+b;G(z,d,a)}if(!this.graph.height){var H=parseFloat(this.graph.getAttribute("height"));
var D=x.y+b;if(D>H){this.graph.setAttribute("height",parseFloat(D))}}if(!this.graph.width){var E=parseFloat(this.graph.getAttribute("width"));
var D=x.x+100;if(D>E){this.graph.setAttribute("width",parseFloat(D))}}for(var F=0;F<y.length;F++){var z=y[F];z.parentNode.refreshChild(z.focalNode);
j.syncVertixLines(z)}}})})();(function(){var c=0;var d=ObjectsUtil.get("util.core.Events");ObjectsUtil.declare("layout.shapes.AbstractNode",[],{focalNode:null,guid:null,children:null,type:null,parentNode:null,incremntal:null,_incomplete:null,constructor:function(a){this.children=[];
this.id=a.id;this.parentNode=a.parentNode;this.incremntal++},getChildren:function(a){return this.children[a||""]||[]},getPosition:function(){return{x:0,y:0,h:0,w:0}
},setPosition:function(b,a){},shiftPosition:function(a,b){var h=this.getPosition();for(var g in a){h[g]=(h[g]||0)+a[g]}this.setPosition(h,b)
},getSuperContainer:function(){var a=this.container;while(true){var b=a.container;if(b&&b.className){a=b}else{break}}return a},addChild:function(a){this.removeChild(a);
var b=a.type||"";if(!this.children[b]){this.children[b]=[]}this.children[b].push(a)},removeChild:function(a){var b=a.type||"";if(!this.children[b]){return
}if(!this.children[b]){return}var f=this.children[b].indexOf(a);if(f==-1){return}this.children[b].splice(f,1)},appendChild:function(a){this.focalNode.appendChild(a)
},refreshChild:function(a){if(a.parentNode===this.focalNode){this.focalNode.removeChild(a);this.insertBefore(a,this.focalNode.firstChild)
}},insertBefore:function(a,b){if(!b){this.appendChild(a)}else{this.focalNode.insertBefore(a,b)}},draw:function(a){},getAttribute:function(a){return this.focalNode.getAttribute(a)
},setAttribute:function(b,a){this.focalNode.setAttribute(b,a)},getRootNode:function(){var b=this.parentNode.focalNode;if(b.tagName==="svg"){return b
}var a=b.parentNode;while(a){a=a.parentNode;if(a&&a.tagName==="svg"){return a}}return b},handleMove:function(b,a){},destroy:function(){}})
})();(function(){var o=ObjectsUtil.get("util.svg.SVGUtil");var h=ObjectsUtil.get("util.core.Events");var m=ObjectsUtil.get("util.core.UUIDGenerator");
var k=0;var l="#222";var j="#fff";var n="10px";ObjectsUtil.declare("layout.shapes.RectangleNode",["layout.shapes.AbstractNode"],{focalNode:null,guid:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,constructor:function(a){this.type="rectangle";
this.name=a.name||("Node"+k);this.guid=a.id||this.name;this.color=a.color||l;this.fontColor=a.fontColor||j;this.rx=a.rx||n;this.strokeWidth=a.strokeWidth||1;
this.strokeWidth=this.strokeWidth+"px";k++},draw:function(c){var b=parseInt(this.parentNode.getAttribute("width"));var d=parseInt(this.parentNode.getAttribute("height"));
this.focalNode=document.createElementNS(o.SVG,"rect");this.focalNode.setAttribute("style","fill: "+this.color+"; stroke-width: "+this.strokeWidth+";");
this.focalNode.setAttribute("rx",this.rx);this.parentNode.appendChild(this.focalNode);this.focalNode.name=this.name;this.focalNode.textLabel=document.createElementNS(o.SVG,"text");
this.focalNode.textLabel.setAttribute("style","fill: "+this.fontColor+"; stroke-width: 1px;");this.focalNode.textLabel.appendChild(document.createTextNode(this.name));
this.parentNode.appendChild(this.focalNode.textLabel);this.focalNode.h=this.focalNode.textLabel.getBBox().height+10;this.focalNode.w=this.focalNode.textLabel.getBBox().width+10;
this.focalNode.setAttribute("height",this.focalNode.h+"px");this.focalNode.setAttribute("width",this.focalNode.w+"px");var e=h.connect("mousedown",this.focalNode,this,function(g){this.handleMove(this.focalNode,g)
});var e=h.connect("mousedown",this.focalNode.textLabel,this,function(g){this.handleMove(this.focalNode,g)});var f=Math.random()*(b*0.8)+(b*0.1);
var a=(Math.random()*(d*0.8))+(d*0.1);this.setPosition({x:f,y:a})},setPosition:function(c){var a=parseFloat(c.x);var b=parseFloat(c.y);
this.focalNode.setAttribute("x",a);this.focalNode.setAttribute("y",b);this.focalNode.textLabel.setAttribute("x",a+5+"px");this.focalNode.textLabel.setAttribute("y",b+(2*this.focalNode.h/3)+"px");
o.syncVertixLines(this)},handleMove:function(c,s){var f=c.parentNode.getScreenCTM();var p=c.parentNode.createSVGPoint();p.x=s.clientX;
p.y=s.clientY;p=p.matrixTransform(f.inverse());var d=parseFloat(p.x)-parseFloat(c.getAttribute("x"));var e=parseFloat(p.y)-parseFloat(c.getAttribute("y"));
var g=this.getChildren("rectangle");this._moving=c;var a=h.connect("mousemove",document,this,function(q){var v=c.parentNode.getScreenCTM();
var r=c.parentNode.createSVGPoint();r.x=q.clientX;r.y=q.clientY;r=r.matrixTransform(v.inverse());this.setPosition({x:r.x-d,y:r.y-e});
this.parentNode.updateArrowMarker()});var b=h.connect("mouseup",document,this,function(){h.disconnect(a);h.disconnect(b);this.parentNode.updateArrowMarker()
})}})})();(function(){var g=ObjectsUtil.get("layout.shapes.ShapesRegistry");var k=ObjectsUtil.get("util.svg.SVGUtil");var f="1px";var h="#444";
var j=0;ObjectsUtil.declare("layout.shapes.Connector",["layout.shapes.AbstractNode"],{focalNode:null,source:null,target:null,name:null,color:null,rx:null,strokeWidth:null,type:null,constructor:function(a){this.type="connector";
this.setSource(a.source);this.setTarget(a.target);this.name=a.name||("Connector"+j);this.guid=a.id||this.source.guid+"_"+this.target.guid+"_"+j;
this.strokeWidth=a.strokeWidth||f;this.color=a.color||h;j++},setSource:function(a){var b=g.get("RectangleNode",a);this.source=b;b.addChild(this)
},setTarget:function(a){var b=g.get("RectangleNode",a);this.target=b;b.addChild(this)},draw:function(a){this.focalNode=document.createElementNS(k.SVG,"path");
this.focalNode.setAttribute("style","stroke: "+this.color+"; stroke-width:"+this.strokeWidth+";");this.parentNode.insertBefore(this.focalNode,this.parentNode.firstChild);
this.focalNode.setAttribute("marker-end","url(#Triangle)");return this.focalNode}})})();var ShapesRegistry=ObjectsUtil.get("layout.shapes.ShapesRegistry");
(function(){ShapesRegistry.register("Connector","layout.shapes.Connector");ShapesRegistry.register("RectangleNode","layout.shapes.RectangleNode");
ShapesRegistry.register("Graph","layout.shape.Graph")})();(function(){var g=ObjectsUtil.get("layout.routers.HorizontalTreeRouter");var e=ObjectsUtil.get("util.core.Events");
var h=ObjectsUtil.get("util.svg.SVGUtil");var f=ObjectsUtil.get("layout.shapes.ShapesRegistry");ObjectsUtil.declare("layout.shape.Graph",["layout.shapes.AbstractNode"],{routingObject:null,height:null,width:null,_layoutInterval:null,_moving:null,_defs:null,constructor:function(a){this.height=a.height;
this.width=a.width;var c=a.container;var b=a.router;this.router=b||new g(this);this.focalNode=document.getElementById(c);this.updateArrowMarker()
},draw:function(b,a){},_paint:function(a){a.args.parentNode=this;if(!a.args.id){a.args.id=a.args.name}a.args.container=this;var b=f.draw(a.descriptor,a.args,a);
return b},updateArrowMarker:function(){if(!this._defs){this._defs=document.createElementNS(h.SVG,"defs");var b=document.createElementNS(h.SVG,"marker");
b.setAttribute("id","Triangle");b.setAttribute("viewBox","0 0 20 20");b.setAttribute("refX","20");b.setAttribute("refY","10");b.setAttribute("markerUnits","strokeWidth");
b.setAttribute("markerWidth","8");b.setAttribute("markerHeight","6");b.setAttribute("orient","auto");var a=document.createElementNS(h.SVG,"path");
b.appendChild(a);a.setAttribute("d","M 0 0 L 20 10 L 0 20 z");this._defs.appendChild(b)}else{this.focalNode.removeChild(this._defs)}this.focalNode.appendChild(this._defs)
},addRectNode:function(a){a.parentNode=this;var b=f.draw("RectangleNode",a);this.addChild(b)},drawConnector:function(a){a.parentNode=this;
var b=f.draw("Connector",a);this.addChild(b)},layout:function(){this.router.layout()}})})();(function(){var b=ObjectsUtil.define("util.core.DomUtil",{empty:function(a){if(!a.tagName){a=document.getElementById(a)
}if(!a){return}if(a.canHaveChildren){try{a.innerHTML="";return}catch(f){}}for(var e;e=a.lastChild;){this._empty(e,a)}},_empty:function(d,a){if(d.firstChild){this.empty(d)
}if(a){a.removeChild(d);if(d.removeNode){d.removeNode(false)}}},calculateTextSize:function(h,j){var k=document.createElement("span");
k.innerHTML=h;k.style.visibility="hidden";var m=this.position(k);if(typeof j==="object"&&!j.parentNode){for(var l in j){k.style[l]=j[l]
}}else{k.style.fontSize=window.getComputedStyle(j,null).getPropertyValue("font-size");k.style.fontFamily=window.getComputedStyle(j,null).getPropertyValue("font-family");
k.style.fontWeight=window.getComputedStyle(j,null).getPropertyValue("font-weight")}var a=document.body;a.appendChild(k);var m=this.position(k);
a.removeChild(k);return m},position:function(k,m){var h=ObjectsUtil.get("util.core.CoreUtil");k=this.nodeById(k);var a=this.getFirstParent(k,"body");
var j=k.getBoundingClientRect();j={x:j.left,y:j.top,w:j.right-j.left,h:j.bottom-j.top};if(m){var l=this.scrollValue(k);j.x+=l.x;j.y+=l.y
}return j},transformValue:function(e){var a=e.getAttribute("transform");if(!a){return{x:0,y:0}}a=a.substring("translate(".length,a.length-1);
var f=a.split(",");if(f.length<2){f=a.split(" ")}return{x:parseFloat(f[0]),y:parseFloat(f[1])}},scrollValue:function(p){var j=function(g,d){var f;
var e=window["page"+g+"Offset"];if(typeof(e)==="number"){f=e}else{var c="scroll"+d;if(document.body&&document.body[c]){f=document.body[c]
}else{if(document.documentElement&&document.documentElement[c]){f=document.documentElement[c]}}}return f};var o=function(){return j("Y","Top")
};var a=function(){return j("X","Left")};var l=0,k=0;var m={x:a(),y:o()};var n=p;while(n){if(n!==document.body&&n!==document.documentElement){if(n.scrollTop>0){m.y=m.y+n.scrollTop;
break}if(n.scrollLeft>0){m.x=m.x+n.scrollLeft;break}}n=n.parentNode}return m},nodeById:function(e,a){var f=ObjectsUtil.get("util.core.CoreUtil");
if(f.checkBrowser("ie")){this.nodeById=function(c,d){if(typeof c!=="string"){return c}return(d||document).getElementById(c)};return this.nodeById(e,a)
}this.nodeById=function(c,d){if(typeof c!=="string"){return c}if(!a){a=document}var m=a.getElementById(c);if(m.id==c||(m.attributes&&m.attributes.id&&m.attributes.id.value==c)){return m
}var k=a.all[c];if(!k){return}if(!f.isArray(k)){k=[k]}for(var n=0,l;l=k[n];n++){if(l.id==c||(l.attributes&&l.attributes.id&&l.attributes.id.value==c)){return l
}}};return this.nodeById(e,a)},transformPoint:function(h,k){var j=ObjectsUtil.get("util.core.DomUtil").getFirstParent(h,"svg");var a=j.getScreenCTM();
var g=j.createSVGPoint();g.x=k.x;g.y=k.y;g=g.matrixTransform(a.inverse());k.x=g.x;k.y=g.y},getFirstParent:function(f,h){if(!f||!h){return
}h=h.toUpperCase();if(f.tagName.toUpperCase()===h){return f}var g=f.parentNode;var a;while(g){if(g.tagName&&(g.tagName.toUpperCase()===h.toUpperCase())){a=g;
break}g=g.parentNode}return a}})})();(function(){var b=ObjectsUtil.define("util.core.CoreUtil",{store:{},toString:{}.toString,_browserSettings:null,clone:function(e){var a={};
for(var f in e){a[f]=e[f]}return a},stopEvent:function(a){a.cancelBubble=true;a.preventDefault();a.stopPropagation()},checkBrowser:function(d){var a=this.store[d];
if(a!==undefined){return a}a=navigator.userAgent.search(d);this.store[d]=a;return a},browserSettings:function(){if(this._browserSettings){return this._browserSettings
}var e=navigator.userAgent;var a;var f=e.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*([\d\.]+)/i)||[];if(/trident/i.test(f[1])){a=/\brv[ :]+(\d+(\.\d+)?)/g.exec(e)||[];
this._browserSettings={browser:"ie",version:a[1]||""};return this._browserSettings}f=f[2]?[f[1],f[2]]:[navigator.appName,navigator.appVersion,"-?"];
if((a=e.match(/version\/([\.\d]+)/i))!=null){f[2]=a[1]}this._browserSettings={browser:f[0].toLowerCase(),version:f[1]||""}},version:function(a){var d=this.browserSettings();
if(d.browser===a){return parseFloat(d.version)}return 0},isFunction:function(a){return this._is(a,"[object Function]")},isString:function(a){return this._is(a,"[object String]")
},isArray:function(a){return this._is(a,"[object Array]")},_is:function(d,a){return this.toString.call(d)===a}})})();(function(){var SVGUtil=ObjectsUtil.get("util.svg.SVGUtil");
var Events=ObjectsUtil.get("util.core.Events");var UUIDGenerator=ObjectsUtil.get("util.core.UUIDGenerator");var incremntal=0;var DEFAULT_COLOR="rgb(255,255,255)";
var DEFAULT_FONT_COLOR="#fff";var DEFAULT_ROUND_RATIO="10px";var ShapesRegistry=ObjectsUtil.get("layout.shapes.ShapesRegistry");ShapesRegistry.register("StrucutreDiagram","layout.shapes.StrucutreDiagram");
ShapesRegistry.register("Part","layout.shapes.Part");ShapesRegistry.register("Port","layout.shapes.Port");ShapesRegistry.register("PartIcon","layout.shapes.PartIcon");
ShapesRegistry.register("PortConnector","layout.shapes.PortConnector");ObjectsUtil.declare("layout.shapes.StructureDiagramNode",["layout.shapes.AbstractNode"],{_moveHandle:null,constructor:function(args){this._moveHandle=Events.subscribe("structure.diagram.node.move."+this.id,function(args){var self=this;
var visited=[];var updateMoveInformation=function(entry){if(visited.indexOf(entry)>-1){return}visited.push(entry);var position=entry.getPrecisePosition?entry.getPrecisePosition():entry.getPosition();
if(!self.parentNode.layoutInformation){self.parentNode.layoutInformation={}}var updatedInfo={x:position.x,y:position.y,h:position.h,w:position.w};
self.parentNode.layoutInformation[entry.id]=updatedInfo;var children=entry.getChildren();for(var index=0,child;child=children[index];
index++){updateMoveInformation(child)}};updateMoveInformation(this)},this)},destroy:function(){Events.unsubsribe(this._moveHandle)}});
var StructureDiagramUtil=ObjectsUtil.define("layout.shapes.diagram.structure..StructureDiagramUtil",{portToPart:function(port,userHandler,otherPort){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
var portObject=CoreUtil.isString(port)?ShapesRegistry.get("Port",port):port;var part=otherPort||portObject.container;var partPosition=part.getPosition();
var portPosition=portObject.getPosition();var deltaRight=parseInt(Math.abs(portPosition.x-(partPosition.x+partPosition.w)+portPosition.w));
var deltaLeft=parseInt(Math.abs((portPosition.x-(partPosition.x))+portPosition.w));var deltaTop=parseInt(Math.abs(portPosition.y-(partPosition.y-portPosition.h)));
var deltaBottom=parseInt(Math.abs(portPosition.y-(partPosition.y+partPosition.h)+portPosition.h));var handler=function(x,y,direction,portPosition){var isCorner=function(att1,att2){return att1<5&&att2<5
};if(port.isPrivate){if(direction==="right"){direction="left";y=y+(2)}else{if(direction==="left"){direction="right";y=y+(2);x=x+(2)}else{if(direction==="top"){direction="bottom";
y=y+((portPosition.h/2)+2)}else{if(direction==="bottom"){direction="top";y=y-((portPosition.h/2)+2)}else{direction="right"}}}}}userHandler(x,y,direction,portPosition,(isCorner(deltaBottom,deltaLeft)||isCorner(deltaTop,deltaLeft)||isCorner(deltaBottom,deltaRight)||isCorner(deltaTop,deltaRight)),{deltaRight:deltaRight,deltaLeft:deltaLeft,deltaTop:deltaTop,deltaBottom:deltaBottom})
};var side;if(deltaRight<deltaLeft&&deltaRight<=deltaTop&&deltaRight<=deltaBottom){if(partPosition.y-portPosition.h>portPosition.y){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)
}else{if((portPosition.y>(partPosition.y+partPosition.h+document.body.scrollTop)-portPosition.h)){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)
}else{return handler(portPosition.x+(portPosition.w-2),portPosition.y+(portPosition.h/2),"right",portPosition)}}}else{if(deltaLeft<deltaRight&&deltaLeft<=deltaTop&&deltaLeft<=deltaBottom){if(partPosition.y-portPosition.h>portPosition.y){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)
}else{if((portPosition.y>(partPosition.y+partPosition.h+document.body.scrollTop)-portPosition.h)){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)
}else{return handler(portPosition.x+(portPosition.w-2),portPosition.y+(portPosition.h/2),"left",portPosition)}}}else{if(deltaTop<deltaRight&&deltaTop<deltaLeft&&deltaTop<deltaBottom){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)
}else{if(deltaBottom<deltaRight&&deltaBottom<deltaLeft&&deltaBottom<deltaTop){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)
}}}}}});ObjectsUtil.declare("layout.shapes.StrucutreDiagram",["layout.shape.Graph"],{layoutInformation:null,settings:null,constructor:function(args){this.layoutInformation=args.layout
},draw:function(args,entry){this.focalNode.style.width="100%";this.focalNode.style.height="3600px";this._incomplete=true;this.settings=entry.args.settings||{};
var layout=entry.args.layout;if(this.height){this.setAttribute("height",this.height)}if(this.width){this.setAttribute("width",this.width)
}var nodes=args.nodes;if(!nodes){return}var mapByParent={"":{}};var getArray=function(id){var array=mapByParent[id||""];if(array){return array
}mapByParent[id]={};return mapByParent[id]};var undefineds=[];var setDetails=function(node){var args=node.args;var id=args.id||args.name;
if(id){node.children={};var obj=getArray(args.parent)[args.id||args.name||new Date().getTime()]=node}else{if(undefineds.indexOf(node)===-1){undefineds.push(node)
}}};for(var index=0,node;node=nodes[index];index++){setDetails(node)}var search=function(obj,id){for(var att in obj){if(att===id){return obj[id]
}var val=search(obj[att].children,id);if(val){return val}}};var pending=[];var putInHirarchy=function(obj){for(var id in obj){if(!id){continue
}var subObject=obj[id];var array=search(mapByParent[""],id);if(array){var indexOf=pending.indexOf(id);if(indexOf>-1){pending.splice(indexOf,1)
}var contents=mapByParent[id];for(var att in contents){array.children[att]=contents[att]}delete mapByParent[id]}else{var indexOf=pending.indexOf(id);
if(indexOf===-1){pending.push(id)}}for(var att in subObject){putInHirarchy(subObject[att].children)}}};putInHirarchy(mapByParent);while(pending.length>0){putInHirarchy(mapByParent)
}var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var mainObject=mapByParent[""];var avoid=[];var flatten=function(obj){for(var att in obj){var current=obj[att];
if(avoid.indexOf(current)>-1){continue}if(current.descriptor==="Part"&&!mainObject[att]){mainObject[att]=CoreUtil.clone(current);avoid.push(mainObject[att])
}flatten(current.children)}};flatten(mainObject);var reEnforce={};var reEnforce=function(obj){for(var att in obj){if(reEnforce[att]){continue
}reEnforce[att]=att;var current=obj[att];reEnforce(current);var children=current.children;for(var sub in children){var subObject=obj[sub];
if(subObject){reEnforce(subObject);reEnforce:{for(var subAtt in mainObject[sub].children){current.children[sub].children=mainObject[sub].children;
break reEnforce}for(var subAtt in current.children[sub].children){mainObject[sub].children=current.children[sub].children;break reEnforce
}}}}}};reEnforce(mainObject);var prepareArgs=function(originalArgs,parentNode,container,suffixId){var subArgs=CoreUtil.clone(originalArgs,parentNode,container);
subArgs.parent=container.id;subArgs.parentNode=parentNode;if(!subArgs.id){subArgs.id=subArgs.name}if(suffixId){subArgs.id=suffixId+"_"+subArgs.id
}if(layout){var layoutInfo=layout[subArgs.id];if(layoutInfo){subArgs.x=layoutInfo.x;subArgs.y=layoutInfo.y;subArgs.h=layoutInfo.h;subArgs.w=layoutInfo.w;
subArgs.hasLayoutInformation=true}}subArgs.container=container;return subArgs};var rowMargin=20;var columnMargin=20;var horiontalSpace=30;
var verticalSpace=30;var columnStart=columnMargin;var rowStart=rowMargin+horiontalSpace;var isAutoLayout=true;for(var att in mainObject){var current=mainObject[att];
var args=prepareArgs(current.args,this,this);if(!args.x||!args.y){if(!isAutoLayout){columnStart=columnStart+columnMargin+20}args.x=rowStart;
args.y=columnStart;isAutoLayout=true}else{isAutoLayout=false}if(current.descriptor==="Part"){args.isStructureDiagram=true}var shape=ShapesRegistry.draw(current.descriptor,args);
var children=current.children;var margined=false;var parentSet=false;var pending=[];for(var subAtt in children){var subCurrent=children[subAtt];
var subShapeArgs=prepareArgs(subCurrent.args,this,shape,att);var subShape=ShapesRegistry.draw(subCurrent.descriptor,subShapeArgs);subShape._incomplete=true;
if(!subShapeArgs.hasLayoutInformation){shape.addChild(subShape);parentSet=true}else{parentSet=false}if(subCurrent.descriptor==="Part"||(subCurrent.descriptor==="Port"&&(subCurrent.args.isPrivate==="true"||subCurrent.args.isPrivate===true))){if(!margined){rowStart=rowStart+rowMargin+horiontalSpace;
columnStart=columnStart+columnMargin+20;margined=true}var subChildren=subCurrent.children;for(var subSubAtt in subChildren){var subSubCurrent=subChildren[subSubAtt];
if(subSubCurrent.descriptor==="Port"){var _args=prepareArgs(subSubCurrent.args,this,subShape,att);var subShape1=ShapesRegistry.draw(subSubCurrent.descriptor,_args);
if(!_args.hasLayoutInformation){subShape.addChild(subShape1)}else{pending.push(subShape1)}}}var subPosition=subShape.getPosition();if(subPosition.x+rowStart>650){var containerPosition=shape.getPosition();
var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;columnStart=currentHeightEnd+verticalSpace;rowStart=rowMargin+horiontalSpace+rowMargin+horiontalSpace
}if(isAutoLayout){subShape.shiftPosition({x:rowStart,y:columnStart})}delete subShape._incomplete;for(var pendingIndex=0,currentPending;
currentPending=pending[pendingIndex];pendingIndex++){subShape.addChild(currentPending)}pending=[];subPosition=subShape.getPosition();
var containerPosition=shape.getPosition();var end=subPosition.x+subPosition.w;var currentEnd=(containerPosition.x+containerPosition.w)-40;
var heightEnd=subPosition.y+subPosition.h;var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;var wDiff=end-currentEnd;
var hDiff=heightEnd-currentHeightEnd;if(hDiff>0||wDiff>0){var object={};if(wDiff>0){object.w=wDiff}if(hDiff>0){object.h=hDiff}shape.shiftPosition(object)
}rowStart=rowStart+subPosition.w+rowMargin+rowMargin+rowMargin+rowMargin}pending=[];if(!parentSet){shape.addChild(subShape)}delete subShape._incomplete
}var containerPosition=shape.getPosition();var currentEnd=(containerPosition.x+containerPosition.h)-40;var containerPosition=shape.getPosition();
var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;columnStart=columnMargin+currentHeightEnd+verticalSpace;rowStart=rowMargin+horiontalSpace;
this.addChild(shape)}for(var att in mainObject){var part=ShapesRegistry.get("Part",att);for(var uncategoriedIndex=0,uncategoried;uncategoried=undefineds[uncategoriedIndex];
uncategoriedIndex++){var args=uncategoried.args;var source=args.sources[0];var target=args.targets[0];var partSource=att+"_"+source;if(!ShapesRegistry.get("Port",partSource)){continue
}var partTarget=att+"_"+target;if(!ShapesRegistry.get("Port",partTarget)){continue}var altered=CoreUtil.clone(args);altered.sources=[partSource];
altered.part=att;altered.targets=[partTarget];altered.parentNode=this;altered.container=part;ShapesRegistry.draw(uncategoried.descriptor,altered)
}}var pos=ObjectsUtil.get("util.core.DomUtil").position(this.focalNode,true);this.focalNode.style.height=(currentHeightEnd+20)+"px";this._incomplete=false;
this.refreshBoundaries();var parts=ShapesRegistry.get("Part");var byGroups=ShapesRegistry.getAndGroup("Part");this.adjustShapes(layout||{},byGroups,parts)
},adjustShapes:function(layout,byGroups,parts,around){var visited=[];for(var att in parts){var part=parts[att];var alteredPosition=part.getPosition();
var shiftVal=this._adjustShapes(parts[att],layout,visited,around);if(shiftVal){shiftVal=shiftVal-5;part.shiftPosition({x:-(around?shiftVal-around:shiftVal)})
}if(byGroups){var subParts=byGroups[part.name];for(var subAtt in subParts){var subPart=subParts[subAtt];var basePosition=subPart.getPosition();
for(var sub2Att in subParts){if(sub2Att===subAtt){continue}var subPart2=subParts[sub2Att];var subPart2Position=subPart2.getPosition();
if(subPart2Position.x>basePosition.x||Math.abs(subPart2Position.y-basePosition.y)>50){continue}var to=subPart2Position.x+subPart2Position.w;
for(var index=0,subPart2child;subPart2child=subPart2.children[index];index++){if(subPart2child.className==="layout.shapes.Port"){var x=parseFloat(subPart2child.labelNode.getAttribute("x"));
var textWidth=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(subPart2child.labelNode.childNodes[0].textContent+"...",subPart2child.labelNode).w;
var exepctedTo=x+textWidth;if(exepctedTo>to){to=exepctedTo}}}var subShift=this._adjustShapes(subPart,layout,[],to);if(subShift!=basePosition.x){subShift=(to)-subShift;
subPart.shiftPosition({x:subShift})}}}}}},_adjustShapes:function(part,layout,visited,around,level){if(layout[part.id]||visited.indexOf(part)>-1){return
}visited.push(part);var position=part.getPosition();var shiftVal=around||0;for(var index=0,child;child=part.children[index];index++){if(child.className==="layout.shapes.Port"){var x=parseFloat(child.labelNode.getAttribute("x"));
if(x<shiftVal){shiftVal=x}}else{if(child.className==="layout.shapes.Part"){var nestedShiftVal=this._adjustShapes(child,layout,visited);
if(nestedShiftVal<shiftVal){var alteredPosition=child.getPosition();alteredPosition.x=alteredPosition.x-nestedShiftVal;child.setPosition(alteredPosition)
}}}}return shiftVal},refreshBoundaries:function(){var position=ObjectsUtil.get("util.core.DomUtil").position(this.focalNode,true);var verticalEnd=position.y+position.h;
var horizontalEnd=position.x+position.w;var children=this.getChildren("partNode");var maxY=0,maxX=0;for(var index=0,child;child=children[index];
index++){if(child.className!=="layout.shapes.Part"){continue}var pos=child.getPosition();var horizontalEnd=pos.x+pos.w;if(horizontalEnd>maxX){maxX=horizontalEnd
}verticalEnd=pos.y+pos.h+20;if(verticalEnd>maxY){maxY=verticalEnd}var verticalEnd=pos.y+pos.h;if(verticalEnd>maxY){maxY=verticalEnd}var partChildren=child.getChildren();
for(var subIndex=0,partChild;partChild=partChildren[subIndex];subIndex++){if(partChild.labelNode){var labelPos=ObjectsUtil.get("util.core.DomUtil").position(partChild.labelNode);
horizontalEnd=labelPos.x+labelPos.w;if(horizontalEnd>maxX){maxX=horizontalEnd}verticalEnd=labelPos.y+labelPos.h;if(verticalEnd>maxY){maxY=verticalEnd
}}var partChildChildren=partChild.getChildren();for(var subSubIndex=0,partChildChild;partChildChild=partChildChildren[subSubIndex];subSubIndex++){if(!partChildChild.labelNode){continue
}labelPos=ObjectsUtil.get("util.core.DomUtil").position(partChildChild.labelNode);horizontalEnd=labelPos.x+labelPos.w;if(horizontalEnd>maxX){maxX=horizontalEnd
}verticalEnd=labelPos.y+labelPos.h;if(verticalEnd>maxY){maxY=verticalEnd}}}}var height=parseFloat(this.focalNode.style.height);if(Math.abs(maxY-height)>1){this.focalNode.style.height=(maxY+10)+"px"
}var width=parseFloat(this.focalNode.style.width);if(Math.abs(maxX-width)>1){this.focalNode.style.width=(maxX+10)+"px"}}});ObjectsUtil.declare("layout.shapes.Part",["layout.shapes.StructureDiagramNode"],{isStructureDiagram:null,multiplicity:null,children:null,focalNode:null,guid:null,iconPart:null,name:null,parent:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,height:null,width:null,yCoord:null,xCoord:null,_moving:null,type:null,constructor:function(args){this.isStructureDiagram=args.isStructureDiagram;
this.multiplicity=args.multiplicity;this.type="partNode";this.parent=args.parent;this.children=[];this.name=args.name||("Node"+incremntal);
this.guid=args.id||this.name;this.color=args.color||DEFAULT_COLOR;this.fontColor=args.fontColor||DEFAULT_FONT_COLOR;this.rx=args.rx||DEFAULT_ROUND_RATIO;
this.strokeWidth=args.strokeWidth||1;this.strokeWidth=this.strokeWidth+"px";incremntal++},addChild:function(child){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
if(CoreUtil.isArray(child)){for(var index=0,c;c=child[index];index++){this.children.push(c)}}else{this.children.push(child)}this.applyConstraints()
},getChildren:function(type,args){if(type){var filtered=[];for(var index=0,child;child=this.children[index];index++){if(child.type===type){var valid=true;
if(args){for(var att in args){if(!args[att]?child[att]:args[att]!==child[att]){valid=false;break}}}if(valid){filtered.push(child)}}}return filtered
}return this.children},draw:function(args){var settings=this.getSuperContainer().settings;this.part_highlight_color=settings.part_highlight_color||"#5DBCD2";
this.part_container_highlight_color=settings.part_container_highlight_color||"#FFFFFF";this.part_container_label_highlight_color=settings.part_container_label_highlight_color||"#e6e6e6";
var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var DomUtil=ObjectsUtil.get("util.core.DomUtil");this.focalNode=document.createElementNS(SVGUtil.SVG,"g");
var mouseMoveHandler=Events.connect("mousemove",this.focalNode,this,function(e){if(this.__resizeStarted){return}var self=this;var stopListening=function(){delete self.__resizeStarted;
Events.disconnect(self._tempResizeMouseUpHandler);Events.disconnect(self._tempResizeMouseDownHandler);Events.disconnect(self._tempResizeMouseMoveHandler);
self.focalNode.style.cursor="";delete self._tempResizeMouseDownHandler};var iseDetected=false;var position=DomUtil.position(this.focalNode);
var horizontalEnd=position.x+position.w;var horizontalDiff=(e.clientX)-horizontalEnd;if(Math.abs(horizontalDiff)<10){this.focalNode.style.cursor="col-resize";
iseDetected=true}else{var verticalEnd=position.y+position.h;var verticalDiff=(e.clientY)-verticalEnd;if(Math.abs(verticalDiff)<10){this.focalNode.style.cursor="row-resize";
iseDetected=true}}Events.disconnect(this._tempResizeMouseDownHandler);Events.disconnect(this._tempResizeMouseOutHandler);if(iseDetected){this._tempResizeMouseDownHandler=Events.connect("mousedown",document,this,function(e){if(this.__resizeStarted){stopListening()
}Events.disconnect(this._tempResizeMouseOutHandler);CoreUtil.stopEvent(e);this.__resizeStarted=true;this._tempResizeMouseUpHandler=Events.connect("mouseup",document,this,function(e){CoreUtil.stopEvent(e);
stopListening();this.getSuperContainer().refreshBoundaries()});this._tempResizeMouseMoveHandler=Events.connect("mousemove",document,this,function(e){CoreUtil.stopEvent(e);
if(!this._tempResizeMouseDownHandler){stopListening();return}var children=this.getChildren();var maxY=0,maxX=0;for(var index=0,child;
child=children[index];index++){if(child.className!=="layout.shapes.Part"){continue}var pos=DomUtil.position(child.focalNode);var horizontalEnd=pos.x+pos.w;
if(horizontalEnd>maxX){maxX=horizontalEnd}var verticalEnd=pos.y+pos.h;if(verticalEnd>maxY){maxY=verticalEnd}}var object={};var position=DomUtil.position(this.focalNode);
var set=false;if(this._tempResizeMouseDownHandler.verticalDiff){if(e.clientY>maxY){object.h=(e.clientY)-position.y;set=true}}else{if(this._tempResizeMouseDownHandler.horizontalDiff){if(e.clientX>maxX){object.w=(e.clientX)-position.x;
set=true}}}if(set){this.setPosition(object)}})});this._tempResizeMouseDownHandler.horizontalDiff=horizontalDiff;this._tempResizeMouseDownHandler.verticalDiff=verticalDiff;
this._tempResizeMouseOutHandler=Events.connect("mouseout",this.focalNode,this,function(e){stopListening()})}else{stopListening()}});this.focalNode.setAttribute("style","fill: "+this.color+"; font-family:'sans-serif';");
this.parentNode.appendChild(this.focalNode);this.rectNode=document.createElementNS(SVGUtil.SVG,"rect");this.rectNode.setAttribute("style","stroke:#000000;");
this.rectNode.setAttribute("fill","#FFFFFF");this.focalNode.appendChild(this.rectNode);this.highlightNode=document.createElementNS(SVGUtil.SVG,"rect");
this.highlightNode.setAttribute("style","stroke:#000000;");if(!this.isStructureDiagram){this.highlightNode.setAttribute("fill",this.part_highlight_color)
}else{this.highlightNode.setAttribute("fill",this.part_container_highlight_color)}this.focalNode.appendChild(this.highlightNode);this.nameNode=document.createElementNS(SVGUtil.SVG,"text");
this.nameNode.setAttribute("style","fill: #000000;  font-family:tahoma; font-size: 10; font-weight:bold");this.nameNode.appendChild(document.createTextNode(args.name));
this.focalNode.appendChild(this.nameNode);if(!this.isStructureDiagram){this.iconPart=ShapesRegistry.draw("PartIcon",{parentNode:this.focalNode})
}this.setPosition({x:args.x,y:args.y,h:args.h,w:args.w});var mouseDownHandler=Events.connect("mousedown",this.focalNode,this,function(e){if(this._tempResizeMouseDownHandler){return
}this.handleMove(this.focalNode,e)});var mouseDownHandler=Events.connect("mousedown",this.highlightNode,this,function(e){if(this._tempResizeMouseDownHandler){return
}this.handleMove(this.focalNode,e)})},updatePosition:function(position){var currentPosition=ObjectsUtil.get("util.core.DomUtil").transformValue(this.focalNode);
currentPosition.h=parseFloat(this.rectNode.getAttribute("height"));currentPosition.w=parseFloat(this.rectNode.getAttribute("width"));
if(position.h){currentPosition.h=currentPosition.h+position.h}if(position.w){currentPosition.w=currentPosition.w+position.w;var children=this.getChildren("portNode");
for(var childIndex=0,child;child=children[childIndex];childIndex++){StructureDiagramUtil.portToPart(child,function(x,y,direction,portPosition){if(direction==="right"){var pos=child.getPosition();
child.shiftPosition({x:position.w},true)}})}}this.setPosition(currentPosition,true)},shiftPosition:function(shiftObject,args){var position={x:this.xCoord,y:this.yCoord,h:this.height,w:this.width};
for(var att in shiftObject){position[att]=(position[att]||0)+shiftObject[att]}this.setPosition(position,args)},setPosition:function(position,restrained){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
var currentPosition=this.getPosition();var xCoord=parseFloat(position.x)||this.xCoord||0;var yCoord=parseFloat(position.y)||this.yCoord||0;
var height=parseFloat(position.h)||this.height||40;var textWidth=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(this.nameNode.childNodes[0].textContent+"...",this.nameNode).w;
var width=parseFloat(position.w)||this.width||(textWidth+75);if(height<40){height=40}if(width<(textWidth+75)){width=(textWidth+75)}this.highlightNode.setAttribute("height",20);
this.highlightNode.setAttribute("width",width);this.rectNode.setAttribute("height",height);this.rectNode.setAttribute("width",width);
if(!this.isStructureDiagram){this.iconPart.setPosition({x:width-25,y:6})}this.focalNode.setAttribute("transform","translate("+xCoord+","+yCoord+")");
if(!this.isStructureDiagram&&this.multiplicity==="*"){if(!this.shadowNode){this.shadowNode=document.createElementNS(SVGUtil.SVG,"rect");
this.shadowNode.setAttribute("style","stroke:#000000;");this.shadowNode.setAttribute("fill","none");this.focalNode.insertBefore(this.shadowNode,this.focalNode.firstChild)
}this.shadowNode.setAttribute("transform","translate("+(3)+","+(-3)+")");this.shadowNode.setAttribute("height",height);this.shadowNode.setAttribute("width",width)
}this.nameNode.setAttribute("y","15");if(this.isStructureDiagram){this.nameNode.setAttribute("x","15");if(!this.nameNode.highlight){this.nameNode.highlight=document.createElementNS("http://www.w3.org/2000/svg","rect");
this.nameNode.highlight.setAttribute("style","fill:"+this.part_container_label_highlight_color+";");this.nameNode.parentNode.insertBefore(this.nameNode.highlight,this.nameNode);
this.nameNode.highlight.border=document.createElementNS(SVGUtil.SVG,"polygon");this.nameNode.highlight.border.setAttribute("style","stroke:black;stroke-width:1;");
this.nameNode.parentNode.insertBefore(this.nameNode.highlight.border,this.nameNode)}else{this.nameNode.parentNode.removeChild(this.nameNode.highlight);
this.nameNode.parentNode.insertBefore(this.nameNode.highlight,this.nameNode);this.nameNode.parentNode.removeChild(this.nameNode.highlight.border);
this.nameNode.parentNode.insertBefore(this.nameNode.highlight.border,this.nameNode)}this.nameNode.highlight.setAttribute("x","1");this.nameNode.highlight.setAttribute("y","1");
this.nameNode.highlight.setAttribute("width",textWidth+10);this.nameNode.highlight.setAttribute("height",18);var xDelta=0;var yDelta=0;
if(!CoreUtil.browserSettings()||CoreUtil.browserSettings().browser!=="chrome"){xDelta=2;yDelta=18}else{xDelta=0;yDelta=20}this.nameNode.highlight.border.setAttribute("points",(textWidth+11)+","+xDelta+" "+(textWidth+11)+","+yDelta)
}else{this.nameNode.setAttribute("x",(width/2)-(textWidth/2))}if(!restrained){var newPosition=this.getPosition();var shiftX=newPosition.x-currentPosition.x;
var shiftY=newPosition.y-currentPosition.y;if(shiftX!==0||shiftY!==0){for(var index=0,child;child=this.children[index];index++){if(child.className==="layout.shapes.Port"||child.className==="layout.shapes.Part"){child.shiftPosition({x:shiftX,y:shiftY})
}}}this.applyConstraints()}this.xCoord=xCoord;this.yCoord=yCoord;this.height=height;this.width=width;if(this.container&&this.container.getPrecisePosition){var containerPosition=this.container.getPrecisePosition();
var lastEnd=this.yCoord+this.height;var lastWidthEnd=this.xCoord+this.width;var containerEnd=containerPosition.y+containerPosition.h-20;
var containerWidthEnd=containerPosition.x+containerPosition.w-20;var hDiff=lastEnd-containerEnd;var wDiff=lastWidthEnd-containerWidthEnd;
if(hDiff>0||wDiff>0){var object={};var changed=false;if(hDiff>0){object.h=hDiff+20;changed=true}if(wDiff>10){object.w=wDiff+20;changed=true
}if(changed){this.container.shiftPosition(object)}}}this.refreshBoundaries()},refreshBoundaries:function(){var superContainer=this.getSuperContainer();
if(superContainer._incomplete){return}superContainer.refreshBoundaries()},getPosition:function(){var DomUtil=ObjectsUtil.get("util.core.DomUtil");
var position=DomUtil.position(this.focalNode,true);var focRect=this.focalNode.getBoundingClientRect();var focParentRect=this.focalNode.parentNode.parentNode.getBoundingClientRect();
position.x=focRect.left-focParentRect.left;position.y=focRect.top-focParentRect.top;position.y=(position.y+8)-parseInt(window.getComputedStyle(this.focalNode.parentNode.parentNode,null).getPropertyValue("padding-top"));
position.x=(position.x+8)-parseInt(window.getComputedStyle(this.focalNode.parentNode.parentNode,null).getPropertyValue("padding-left"));
var container=DomUtil.getFirstParent(this.focalNode,"svg").parentNode;var scrollLeft=container.scrollLeft;var scrollTop=container.scrollTop;
position.x=position.x+(scrollLeft||0);position.y=position.y+(scrollTop||0);if(this.shadowNode){position.w=position.w-3;position.h=position.h-3
}return position},getPrecisePosition:function(){return{h:this.height,w:this.width,y:this.yCoord,x:this.xCoord}},applyConstraints:function(){if(this._incomplete){return
}var position=this.getPosition();var alteredPosition=this.getPosition();var shiftVal=0;for(var index=0,child;child=this.children[index];
index++){if(child.className==="layout.shapes.Port"){child.applyConstraints()}else{if(child.className==="layout.shapes.Part"){}}}if(alteredPosition.w!==position.w){this.setPosition(alteredPosition,true)
}},handleMove:function(vertex,event){var DomUtil=ObjectsUtil.get("util.core.DomUtil");var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
var canvas=DomUtil.getFirstParent(vertex,"svg");var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();p.x=event.clientX;
p.y=event.clientY;p=p.matrixTransform(m.inverse());var position=this.getPrecisePosition();var deltaX=parseFloat(p.x)-parseFloat(position.x);
var deltaY=parseFloat(p.y)-parseFloat(position.y);var originalPosition;if(this.container.getPrecisePosition){originalPosition=this.container.getPrecisePosition()
}this._moving=vertex;var disableTextSelection=Events.connect("onselectstart",document,this,function(e){CoreUtil.stopEvent(e)});var mouseMoveHandle=Events.connect("mousemove",document,this,function(e){var self=this;
var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();p.x=e.clientX;p.y=e.clientY;p=p.matrixTransform(m.inverse());var object={};
var position=self.getPrecisePosition();object.y=p.y;object.x=p.x;var containerNewPosition=self.container[self.container.getPrecisePosition?"getPrecisePosition":"getPosition"]();
if(object.x-deltaX<containerNewPosition.x){return}if(object.y-deltaY<containerNewPosition.y){return}self.setPosition({x:object.x-deltaX,y:object.y-deltaY});
if(originalPosition){var containerNewPosition=self.container.getPrecisePosition();var lastEnd=self.yCoord+self.height;var lastWidthEnd=self.xCoord+self.width;
var containerEnd=originalPosition.y+originalPosition.h;var containerWidthEnd=originalPosition.x+originalPosition.w;var hDiff=lastEnd-containerEnd;
var wDiff=lastWidthEnd-containerWidthEnd;if(hDiff<0&&wDiff<0){self.container.setPosition(originalPosition)}}});var mouseUpHandle=Events.connect("mouseup",document,this,function(){Events.disconnect(mouseMoveHandle);
Events.disconnect(mouseUpHandle);Events.disconnect(disableTextSelection);this._moving=undefined;this.getSuperContainer().refreshBoundaries();
Events.publish("structure.diagram.node.move."+this.id)});CoreUtil.stopEvent(event)}});var ICON_WIDTH=12;var ICON_HEIGHT=10;ObjectsUtil.declare("layout.shapes.PartIcon",["layout.shapes.AbstractNode"],{draw:function(args){this.iconNode=document.createElementNS(SVGUtil.SVG,"rect");
this.iconNode.setAttribute("style","stroke:#000000;");this.iconNode.setAttribute("height",ICON_HEIGHT);this.iconNode.setAttribute("width",ICON_WIDTH);
this.iconNode.setAttribute("fill","none");this.parentNode.appendChild(this.iconNode)},setPosition:function(position){var xCoord=parseFloat(position.x)||0;
var yCoord=parseFloat(position.y)||0;var margin=2;var separator=1;var partHeight=2;var partWidth=6;this.iconNode.setAttribute("x",xCoord);
this.iconNode.setAttribute("y",yCoord);if(!this.iconNodePart1){this.iconNodePart1=document.createElementNS(SVGUtil.SVG,"rect")}else{this.parentNode.removeChild(this.iconNodePart1)
}this.iconNodePart1.setAttribute("style","stroke:#000000;");this.iconNodePart1.setAttribute("height",partHeight);this.iconNodePart1.setAttribute("width",partWidth);
this.iconNodePart1.setAttribute("y",yCoord+margin);this.iconNodePart1.setAttribute("x",xCoord-(partWidth/2));this.iconNodePart1.setAttribute("fill","#5DBCD2");
this.parentNode.appendChild(this.iconNodePart1);if(!this.iconNodePart2){this.iconNodePart2=document.createElementNS(SVGUtil.SVG,"rect")
}else{this.parentNode.removeChild(this.iconNodePart2)}this.iconNodePart2.setAttribute("style","stroke:#000000;");this.iconNodePart2.setAttribute("height",partHeight);
this.iconNodePart2.setAttribute("width",partWidth);this.iconNodePart2.setAttribute("y",yCoord+margin+partHeight+margin);this.iconNodePart2.setAttribute("x",xCoord-(partWidth/2));
this.iconNodePart2.setAttribute("fill","#5DBCD2");this.parentNode.appendChild(this.iconNodePart2)}});var PortSymbols=ObjectsUtil.define("layout.shapes.Port.PortSymbols",{right:function(port){port.symbol=document.createElementNS(SVGUtil.SVG,"polygon");
port.symbol.setAttribute("points","8,2 2.5,5 8,8");port.symbol.setAttribute("style","fill:black;stroke:#000000;stroke-width:1");port.containerNode.appendChild(port.symbol)
},left:function(port){port.symbol=document.createElementNS(SVGUtil.SVG,"polygon");port.symbol.setAttribute("points","2.5,2 8,5 2.5,8");
port.symbol.setAttribute("style","fill:#000000;stroke:#000000;stroke-width:1");port.containerNode.appendChild(port.symbol)},twoArrows:function(port){var drawLine=function(x1,y1,x2,y2){var line1=document.createElementNS(SVGUtil.SVG,"line");
line1.setAttribute("x1",x1);line1.setAttribute("y1",y1);line1.setAttribute("x2",x2);line1.setAttribute("y2",y2);line1.setAttribute("style","fill:#000000;stroke:#000000;stroke-width:1");
port.containerNode.appendChild(line1)};drawLine("4","2","8.5","4");drawLine("1.5","4","8.5","4");drawLine("1.5","6","8.5","6");drawLine("1.5","6","6","8")
},conjugated:function(port){var symbol=PortSymbols._drawCircleSymbol(port,"Conjucated port");symbol.setAttribute("style","stroke: black;")
},conjugatedReplicated:function(port){var symbol=PortSymbols._drawCircleSymbol(port,"Conjucated replicated port");symbol.setAttribute("style","stroke: black;");
port.set3D()},replicatedEndPort:function(port){PortSymbols.endPort(port,"Replicated end port");port.set3D()},endPort:function(port,title){var symbol=PortSymbols._drawCircleSymbol(port,title||"End port");
var currentParentColor=port.focalNode.getAttribute("fill");symbol.setAttribute("style","stroke: "+currentParentColor+";");symbol.setAttribute("fill",currentParentColor);
port.focalNode.setAttribute("fill","#000000")},conjucatedReplicatedRelayPort:function(port){var symbol=PortSymbols._drawRectSymbol(port,"Conjucated replicated relay port");
symbol.setAttribute("style","stroke: black;");port.set3D()},conjucatedRelayPort:function(port){var symbol=PortSymbols._drawRectSymbol(port,"Conjucated relay port");
symbol.setAttribute("style","stroke: black;")},replicatedRelayPort:function(port){PortSymbols.relayPort(port,"Replicated relay port");
port.set3D()},relayPort:function(port,title){var symbol=PortSymbols._drawRectSymbol(port,title||"Relay port");symbol.setAttribute("style","stroke: black;");
var currentParentColor=port.focalNode.getAttribute("fill");symbol.setAttribute("style","stroke: "+currentParentColor+";");symbol.setAttribute("fill",currentParentColor);
port.focalNode.setAttribute("fill","#000000")},_drawCircleSymbol:function(port,title){var circle=document.createElementNS(SVGUtil.SVG,"circle");
circle.setAttribute("fill","#000000");circle.setAttribute("r",3);circle.setAttribute("cx",5);circle.setAttribute("cy",5);port.containerNode.appendChild(circle);
PortSymbols._appendTooltip(title,port,circle);return circle},_drawRectSymbol:function(port,title){var rect=document.createElementNS(SVGUtil.SVG,"rect");
rect.setAttribute("fill","#000000");rect.setAttribute("height",4);rect.setAttribute("width",4);rect.setAttribute("x",3);rect.setAttribute("y",3);
port.containerNode.appendChild(rect);PortSymbols._appendTooltip(title,port,rect);return rect},_appendTooltip:function(title,port,element){if(title){element.titleElement=document.createElementNS(SVGUtil.SVG,"title");
port.focalNode.appendChild(element.titleElement);element.titleElement.appendChild(document.createTextNode(title));element.titleElement=document.createElementNS(SVGUtil.SVG,"title");
element.appendChild(element.titleElement);element.titleElement.appendChild(document.createTextNode(title))}}});var ConnectorSymbols=ObjectsUtil.define("layout.shapes.connector.ConnectorSymbols",{draw:function(connector,args,direction,receive){return ConnectorSymbols._draw(connector,args,direction,receive)
},_draw:function(connector,args,direction,receive){if(!connector.connectorSymbol){connector.connectorSymbol=document.createElementNS(SVGUtil.SVG,"g");
connector.connectorSymbol.setAttribute("fill","none");var r=5;var delta=4;var title="";if(args.indexOf("provide")>-1){connector.connectorSymbol.path=document.createElementNS(SVGUtil.SVG,"path");
connector.connectorSymbol.path.setAttribute("style","stroke: #000000;");connector.connectorSymbol.appendChild(connector.connectorSymbol.path);
title="Provide"}if(args.indexOf("require")>-1){connector.connectorSymbol.circle1=document.createElementNS(SVGUtil.SVG,"circle");connector.connectorSymbol.circle1.setAttribute("style","stroke: black;");
connector.connectorSymbol.circle1.setAttribute("r",r);connector.connectorSymbol.appendChild(connector.connectorSymbol.circle1);connector.connectorSymbol.setAttribute("fill","white");
if(title){title=title+"\\"}title=title+"Require"}if(title){connector.connectorSymbol.title=document.createElementNS(SVGUtil.SVG,"title");
connector.connectorSymbol.appendChild(connector.connectorSymbol.title);connector.connectorSymbol.title.appendChild(document.createTextNode(title))
}connector.parentNode.appendChild(connector.connectorSymbol)}else{connector.parentNode.removeChild(connector.connectorSymbol);connector.parentNode.appendChild(connector.connectorSymbol)
}if(connector.connectorSymbol.path){var r=5;var delta=4;var firstEnd=r+delta;var otherEnd=firstEnd*-1;if(receive){if(direction==="vertical"){var pair1=(otherEnd+",0");
var pair2=(firstEnd+",0")}else{var pair1=("0,"+otherEnd);var pair2=("0,"+(firstEnd))}}else{if(direction==="vertical"){var pair2=(otherEnd+",0");
var pair1=(firstEnd+",0")}else{var pair2=("0,"+otherEnd);var pair1=("0,"+(firstEnd))}}var pathString="M"+pair1+(" A"+r+","+r)+" 0 0,1 "+pair2;
connector.connectorSymbol.path.setAttribute("d",pathString)}return connector.connectorSymbol}});var LABEL_FONT_SETTINGS={fontSize:10,fontFamily:"arial, serif",fontWeight:"normal"};
ObjectsUtil.declare("layout.shapes.Port",["layout.shapes.StructureDiagramNode"],{focalNode:null,guid:null,isPrivate:null,connectors:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,portType:null,constructor:function(args){this.type="portNode";
this.isPrivate=(args.isPrivate==="true"||args.isPrivate===true)?true:false;this.multiplicity=args.multiplicity;this.connectors={sources:[],targets:[]};
this.portType=args.portType;this.name=args.name||("Node"+incremntal);this.guid=args.id||this.name;this.color=args.color||DEFAULT_COLOR;
this.fontColor=args.fontColor||DEFAULT_FONT_COLOR;this.rx=args.rx||DEFAULT_ROUND_RATIO;this.strokeWidth=args.strokeWidth||1;this.strokeWidth=this.strokeWidth+"px";
incremntal++},addConnector:function(child,type){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");if(CoreUtil.isArray(child)){for(var index=0,c;
c=child[index];index++){if(this.connectors[type].indexOf(c)>-1){continue}this.connectors[type].push(c)}}else{if(this.connectors[type].indexOf(child)==-1){this.connectors[type].push(child)
}}},draw:function(args){var settings=this.getSuperContainer().settings;this.portFillColor=settings.portFillColor||"#FFFFCC";this.containerNode=document.createElementNS(SVGUtil.SVG,"g");
this.parentNode.appendChild(this.containerNode);this.focalNode=document.createElementNS(SVGUtil.SVG,"rect");this.focalNode.setAttribute("style","stroke:#000000;");
this.focalNode.setAttribute("height","10");this.focalNode.setAttribute("width","10");this.focalNode.setAttribute("fill",this.portFillColor);
this.containerNode.appendChild(this.focalNode);var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var DomUtil=ObjectsUtil.get("util.core.DomUtil");
var typeSymbol=args.typeSymbol;if(typeSymbol){if(typeSymbol.indexOf("(function")>-1){var typeSymboleEval=eval(typeSymbol);if(CoreUtil.isFunction(typeSymboleEval)){typeSymboleEval(this)
}}}else{var portType=args.portType;var mappedFunction=PortSymbols[portType];if(mappedFunction){mappedFunction(this)}}this.labelNode=document.createElementNS(SVGUtil.SVG,"text");
this.labelNode.setAttribute("style","fill: #000000;  font-family:"+LABEL_FONT_SETTINGS.fontFamily+"; font-size: "+LABEL_FONT_SETTINGS.fontSize+";  font-weight:"+LABEL_FONT_SETTINGS.fontWeight+";");
var portLabelText=args.name;if(args.multiplicity!==undefined){portLabelText=portLabelText+"["+args.multiplicity+"]"}this.labelNode.appendChild(document.createTextNode(portLabelText));
this.parentNode.appendChild(this.labelNode);var partObject=this.container;if(args.x!==undefined&&args.y!==undefined){this.setPosition({x:args.x,y:args.y},true)
}else{if(!this.isPrivate){var x,y,delta;var position=partObject.getPosition();var portPosition=this.getPosition();var children=partObject.getChildren("portNode",{isPrivate:undefined});
var adjustedLength=children.length;var w=this.getPosition().w;var direction=children.length%10;var partMax=position.x+position.w;for(var index=0,child;
child=children[index];index++){StructureDiagramUtil.portToPart(child,function(x,y,_direction,portPosition){if(_direction==="right"||_direction==="left"){return
}var prevWidth=DomUtil.calculateTextSize(child.labelNode.childNodes[0].textContent,child.labelNode).w;var childPosition=child.getPosition();
var start=child.getPosition().x;var reachTo=start+prevWidth/2;if(partMax<reachTo+childPosition.w*2||partMax<start+childPosition.w*2){return
}var diff=(prevWidth/2+w/2);var deltaDiff=position.w/6;if(diff>position.w/5-15){direction++}if(diff>position.w/4){direction++}})}var self=this;
if(direction<10){var directionFinder=function(direction,looped){if(direction===0){delta=(((position.h/2))/2)-5;x=position.x-portPosition.w;
y=(position.y+(position.h/2))-portPosition.h-delta}else{if(direction===1){delta=((position.h/2))/2;x=position.x-portPosition.w;y=((position.y+(position.h/2))-portPosition.h)+delta
}else{if(direction===2){delta=((position.w/2))/2;x=(position.x-portPosition.w)+(position.w/2)-delta;y=(position.y)-portPosition.h}else{if(direction===3){x=(position.x-portPosition.w)+(position.w/2);
y=(position.y)-portPosition.h}else{if(direction===4){delta=((position.w/2))/2;x=(position.x-portPosition.w)+(position.w/2)+delta;y=(position.y)-portPosition.h
}else{if(direction===5){delta=((position.h/2))/2;x=((position.x+position.w)-portPosition.w);y=((position.y+(position.h/2))-portPosition.h)-delta
}else{if(direction===6){delta=((position.h/2))/2;x=((position.x+position.w)-portPosition.w);y=((position.y+(position.h/2))-portPosition.h)+delta
}else{if(direction===7){delta=((position.w/2))/2;x=((position.x-portPosition.w)+(position.w/2))-delta;y=(position.y+(position.h))-portPosition.h
}else{if(direction===8){x=(position.x-portPosition.w)+(position.w/2);y=(position.y+(position.h))-portPosition.h}else{if(direction===9){delta=((position.w/2))/2;
x=((position.x-portPosition.w)+(position.w/2))+delta;y=(position.y+(position.h))-portPosition.h}}}}}}}}}}};directionFinder(direction)
}else{var start=children.length-10;var direction=start%8;var endY=(position.y+position.h)-20;if(direction<6){var byIndex=((parseFloat(direction/2)+((start-direction+1)/3))*portPosition.h);
if(!byIndex){byIndex=4}var delta=parseInt(start/8)+byIndex+(portPosition.h*2);var right=direction%2;if(!right){var x=((position.x)-portPosition.w);
var y=((position.y+(position.h/2))-portPosition.h)+delta;var diff=y-endY;if(diff>0){partObject.updatePosition({h:diff})}}else{var x=((position.x)-portPosition.w)+position.w
}var updatedPosition=partObject.getPosition();var y=((updatedPosition.y+(updatedPosition.h)))-((portPosition.h*2))+4}else{if(direction%2===0){var x=(position.x+position.w)-(portPosition.w/2);
var y=position.y-portPosition.h;partObject.updatePosition({w:30})}else{var x=(position.x+position.w)-parseFloat(portPosition.w*3);var y=(position.y+position.h)-portPosition.h
}}}for(var childIndex=0,child;child=children[childIndex];childIndex++){child.applyConstraints()}this.setPosition({x:x,y:y})}}this.applyConstraints();
var mouseDownHandler=Events.connect("mousedown",this.containerNode,this,function(e){this.handleMove(this.focalNode,e)});var mouseDownHandler=Events.connect("mousedown",this.labelNode,this,function(e){this.handleMove(this.focalNode,e)
})},setPosition:function(position,restrained){xCoord=parseFloat(position.x)||0;yCoord=parseFloat(position.y)||0;this.containerNode.setAttribute("transform","translate("+xCoord+","+yCoord+")");
if(this.multiplicity==="*"){this.set3D()}var self=this;StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition){if(direction==="right"){self.labelNode.setAttribute("x",x+2);
self.labelNode.setAttribute("y",y-1)}else{if(direction==="top"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.focalNode);
self.labelNode.setAttribute("x",x-parseFloat(position.w/2));self.labelNode.setAttribute("y",y-parseFloat(portPosition.h/2))}else{if(direction==="left"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.labelNode);
self.labelNode.setAttribute("x",parseFloat((x-(position.w+portPosition.w))));self.labelNode.setAttribute("y",y)}else{if(direction==="bottom"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.focalNode);
self.labelNode.setAttribute("x",x-parseFloat(position.w/2));self.labelNode.setAttribute("y",y+parseFloat(portPosition.h))}}}}if(!restrained){self.applyConstraints()
}});var parentNode=self.labelNode.parentNode;parentNode.removeChild(self.labelNode);parentNode.appendChild(self.labelNode)},set3D:function(){if(!this.shadowNode){this.shadowNode=document.createElementNS(SVGUtil.SVG,"rect");
this.shadowNode.setAttribute("style","stroke:#000000;");this.shadowNode.setAttribute("fill",this.portFillColor||"#FFFFFF");this.containerNode.insertBefore(this.shadowNode,this.containerNode.firstChild)
}this.shadowNode.setAttribute("transform","translate("+(1)+","+(-2)+")");this.shadowNode.setAttribute("height",11);this.shadowNode.setAttribute("width",11)
},applyConstraints:function(){var part=this.container;if(!part||part._incomplete){return}var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
var childPosition=this.getPosition();var position=part.getPosition();if(this.isPrivate){var changed=false;var maxX=((position.x+position.w)-childPosition.w)-childPosition.w;
var minX=position.x+childPosition.w;var maxY=((position.y+position.h)-childPosition.h)-childPosition.h;var minY=position.y+childPosition.h;
var newPosition=CoreUtil.clone(childPosition);if(newPosition.x<minX){newPosition.x=minX;changed=true}else{if(newPosition.x>maxX){newPosition.x=maxX;
changed=true}}if(newPosition.y<minY){newPosition.y=minY;changed=true}else{if(newPosition.y>maxY){newPosition.y=maxY;changed=true}}if(changed){this.setPosition(newPosition,true)
}}else{var enforceY=true;var newPosition=CoreUtil.clone(childPosition);var updateY=function(){var pos1=(position.y)-childPosition.h;var pos2=(position.y+position.h)-childPosition.h;
var diff1=Math.abs(newPosition.y-pos1);var diff2=Math.abs(newPosition.y-pos2);if(diff2<=diff1){newPosition.y=pos2}else{newPosition.y=pos1
}};if(childPosition.x<position.x-childPosition.w){newPosition.x=position.x-childPosition.w}else{if(childPosition.x>((position.x+position.w)-childPosition.w)){newPosition.x=(position.x+position.w)-childPosition.w
}else{var max=(position.x+position.w)-childPosition.w;var min=position.x-childPosition.w;var current=newPosition.x;StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition,isCorner,deltaInformation){if(isCorner){updateY()
}else{if(direction==="bottom"){if(Math.abs(deltaInformation.deltaBottom)>1){newPosition.y=newPosition.y+deltaInformation.deltaBottom}}else{if(direction==="top"){if(Math.abs(deltaInformation.deltaTop)>1){newPosition.y=newPosition.y-deltaInformation.deltaTop
}}else{if(direction==="right"){if(Math.abs(deltaInformation.deltaRight)>1){newPosition.x=newPosition.x+deltaInformation.deltaRight}}else{if(direction==="left"){if(Math.abs(deltaInformation.deltaLeft)>1){newPosition.x=newPosition.x-deltaInformation.deltaLeft
}}}}}}});enforceY=false}}if(enforceY){var max=(position.y+position.h)-childPosition.h;var min=(position.y)-childPosition.h;var current=childPosition.y-childPosition.h;
if(current<min||current>max){updateY()}}var minimuxX=position.x-childPosition.w;var maximumX=(position.x+position.w)-childPosition.w;
var minimuxY=position.y-childPosition.h;var maximumY=(position.y+position.h)-childPosition.h;if(newPosition.x<minimuxX){newPosition.x=minimuxX
}if(newPosition.x>maximumX){newPosition.x=maximumX}if(newPosition.y<minimuxY){newPosition.y=minimuxY}if(newPosition.y>maximumY){newPosition.y=maximumY
}if(parseInt(newPosition.x)!==parseInt(childPosition.x)||parseInt(newPosition.y)!==parseInt(childPosition.y)||parseInt(newPosition.h)!==parseInt(childPosition.h)||parseInt(newPosition.w)!==parseInt(childPosition.w)){this.setPosition(newPosition,true)
}}},getPosition:function(){var transform=ObjectsUtil.get("util.core.DomUtil").transformValue(this.containerNode);transform.w=13;transform.h=13;
return transform},handleMove:function(vertex,event){var DomUtil=ObjectsUtil.get("util.core.DomUtil");var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");
var canvas=DomUtil.getFirstParent(vertex,"svg");var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();var scrollValue=DomUtil.scrollValue(vertex);
p.x=event.clientX+scrollValue.x;p.y=event.clientY+scrollValue.y;p=p.matrixTransform(m.inverse());var position=this.getPosition();var deltaX=parseFloat(p.x)-parseFloat(position.x);
var deltaY=parseFloat(p.y)-parseFloat(position.y);this._moving=vertex;var disableTextSelection=Events.connect("onselectstart",document,this,function(e){CoreUtil.stopEvent(e)
});var mouseMoveHandle=Events.connect("mousemove",document,this,function(e){var self=this;var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();
p.x=e.clientX;p.y=e.clientY;p=p.matrixTransform(m.inverse());var object={};if(this.isPrivate){object.y=p.y;object.x=p.x}else{StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition,isCorner){if(isCorner){object.y=p.y;
object.x=p.x}else{if(direction==="left"||direction==="right"){object.y=p.y}else{object.x=p.x}}})}self.shiftPosition(object);CoreUtil.stopEvent(e)
});var mouseUpHandle=Events.connect("mouseup",document,this,function(){Events.disconnect(mouseMoveHandle);Events.disconnect(mouseUpHandle);
Events.disconnect(disableTextSelection);this._moving=undefined;this.getSuperContainer().refreshBoundaries();Events.publish("structure.diagram.node.move."+this.id)
});CoreUtil.stopEvent(event)}});var Events=ObjectsUtil.get("util.core.Events");var incremntal=0;var sources=[];ObjectsUtil.declare("layout.shapes.PortConnector",["layout.shapes.StructureDiagramNode"],{focalNode:null,guid:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,connectorType:null,constructor:function(args){this.connectorType=args.connectorType;
this.type="portConnector";this.name=args.name||("Connector"+incremntal);this.guid=args.id||this.name;this.sources=args.sources;this.targets=args.targets;
this.part=args.part;incremntal++;this.points=args.points},draw:function(args){var colors=["red","green","blue","brown","black","orange","lime"];
var colors=["black","black","black","black","black","black","black","black"];if(sources.indexOf(this.sources[0])===-1){sources.push(this.sources[0])
}var color=colors[sources.indexOf(this.sources[0])];this.focalNode=document.createElementNS(SVGUtil.SVG,"polyline");this.focalNode.setAttribute("style","fill:none;stroke:"+color+";stroke-width:1px;");
this.parentNode.appendChild(this.focalNode);if(this.points){this.focalNode.setAttribute("points",this.points)}else{this.setPosition();
for(var typeIndex=0,type;type=["sources","targets"][typeIndex];typeIndex++){for(var index=0,current;current=this[type][index];index++){var currentPort=ShapesRegistry.get("Port",current);
currentPort.addConnector(this,type);Events.connect("setPosition",currentPort,this,function(position){this.setPosition(position)});this.container.applyConstraints()
}}}},setPosition:function(position){if(this.sources[0]===this.targets[0]){return this.focalNode.setAttribute("points","")}var positions=[];
var properTarget=this["targets"][0];var properSource=this["sources"][0];var targetObject=ShapesRegistry.get("Port",properTarget);var sourceObject=ShapesRegistry.get("Port",properSource);
if(targetObject.getPosition().x<sourceObject.getPosition().x){var temp=properSource;properSource=properTarget;properTarget=temp}var handler=function(x,y,direction){positions.push({x:x,y:y,direction:direction})
};var adjustPosition=function(object){if(object.direction==="left"){object.x=object.x;object.y=object.y+(5)}else{if(object.direction==="right"){object.x=object.x+(10);
object.y=object.y+(5)}else{if(object.direction==="top"){object.x=object.x+5;object.y=object.y}else{if(object.direction==="bottom"){object.y=object.y+10;
object.x=object.x+(5)}}}}};var source=ShapesRegistry.get("Port",properSource);var sourcePart=source.container;var sourcePartPosition=sourcePart.getPosition();
var sourcePosition=source.getPosition();StructureDiagramUtil.portToPart(properSource,handler);var target=ShapesRegistry.get("Port",properTarget);
var targetPart=target.container;var targetPartPosition=targetPart.getPosition();var targetPosition=target.getPosition();StructureDiagramUtil.portToPart(properTarget,handler);
var selfConnector=sourcePart===targetPart;var points=[];var pos1=positions[0];if(!positions[0]){return}sourcePosition.direction=pos1.direction;
var pos2=positions[1];if(!pos2){return}targetPosition.direction=pos2.direction;var currentSourcePosition=source.getPosition();var currentTargetPosition=target.getPosition();
var isInternal=false;var self=this;var revertDirectionForRelayPorts=function(currentPosition,current,other,otherPosition){if(current.isPrivate){if(otherPosition.direction==="left"){currentPosition.direction="right"
}else{if(otherPosition.direction==="top"){currentPosition.direction="bottom"}else{if(otherPosition.direction==="bottom"){currentPosition.direction="top"
}else{if(otherPosition.direction==="right"){currentPosition.direction="left"}}}}}else{if(current.parent===self.part&&(other.isPrivate||other.parent!==self.part)){if(currentPosition.direction==="left"){currentPosition.direction="right"
}else{if(currentPosition.direction==="top"){currentPosition.direction="bottom"}else{if(currentPosition.direction==="bottom"){currentPosition.direction="top"
}else{if(currentPosition.direction==="right"){currentPosition.direction="left"}}}}}}};if(source.isPrivate){revertDirectionForRelayPorts(targetPosition,target,source,sourcePosition);
revertDirectionForRelayPorts(sourcePosition,source,target,targetPosition)}else{revertDirectionForRelayPorts(sourcePosition,source,target,targetPosition);
revertDirectionForRelayPorts(targetPosition,target,source,sourcePosition)}var direction=sourcePosition.direction;var preciseTarget={x:targetPosition.x,y:targetPosition.y,direction:targetPosition.direction};
adjustPosition(preciseTarget);var finalDestination={x:preciseTarget.x,y:preciseTarget.y};var preciseStart={x:sourcePosition.x,y:sourcePosition.y,direction:sourcePosition.direction};
var moveTo=function(obj){var nextObj={};if(obj.direction==="left"){nextObj.x=obj.x-(10);nextObj.y=obj.y}else{if(obj.direction==="right"){nextObj.x=obj.x+(10);
nextObj.y=obj.y}else{if(obj.direction==="top"){nextObj.x=obj.x;nextObj.y=obj.y-(10)}else{if(obj.direction==="bottom"){nextObj.x=obj.x;
nextObj.y=obj.y+(10)}}}}nextObj.direction=obj.direction;return nextObj};var points=[];var start={x:sourcePosition.x,y:sourcePosition.y,direction:sourcePosition.direction};
adjustPosition(start);points.push(start);var afterStart=moveTo(start);points.push(afterStart);var end={x:targetPosition.x,y:targetPosition.y,direction:targetPosition.direction};
adjustPosition(end);var beforeEnd=moveTo(end);points.push({x:beforeEnd.x,y:afterStart.y});points.push(beforeEnd);points.push(end);var detectOverlappedPoints=function(){var length=points.length;
for(var index=0;index<length-1;index++){var p1=points[index];var p2=points[index+1];var p3=points[index+2];var compareAtt=function(att){if(!p3){return false
}if(p1[att]===p2[att]&&p2[att]===p3[att]){return true}return false};if(compareAtt("y")){var otherDiff=0;if(((sourcePosition.direction==="left")&&(targetPosition.direction==="left"))){var p4=points[index+3];
if(p4){var differenceToPart=p4.y-p1.y}else{var differenceToPart=(targetPartPosition.y)-p1.y-(sourcePosition.h*1.5)}}else{if(((sourcePosition.direction==="left")&&(targetPosition.direction==="bottom"))){var differenceToPart=(targetPartPosition.y)-p1.y-(sourcePosition.h*1.5);
if(targetPartPosition.x>sourcePartPosition.x&&sourcePartPosition.y<targetPartPosition.y){var otherDiff=(targetPartPosition.x)-p1.x-(sourcePosition.h*1.5)
}}else{var differenceToPart=(sourcePartPosition.y+sourcePartPosition.h)-p2.y}}var upatedY=undefined;if(p2.x<p1.x&&p2.x<p3.x){upatedY=p2.y+differenceToPart;
points.splice(index+2,0,{x:p2.x+otherDiff,y:upatedY})}else{if(p3.y<p1.y&&p3.y<p2.y){upatedY=p2.y-differenceToPart;points.splice(index+2,0,{x:p1.x,y:upatedY})
}}if(upatedY){p3.y=upatedY}}else{if(compareAtt("x")){if((sourcePosition.direction==="bottom"&&targetPosition.direction==="top")){var differenceToPart=(targetPartPosition.x+targetPartPosition.w)-p1.x
}else{if(((sourcePosition.direction==="right"||sourcePosition.direction==="bottom")&&(p2.direction==="top"||p2.direction==="bottom"))||(sourcePosition.direction==="top"&&(p3.direction==="bottom"||p3.direction==="top"))){if((targetPart===sourcePart&&(target.isPrivate||source.isPrivate))){var differenceToPart=(targetPosition.x)-p1.x-(sourcePosition.h)
}else{var differenceToPart=(targetPartPosition.x)-p1.x-(sourcePosition.h*1.5)}if(sourcePosition.direction==="bottom"&&targetPosition.direction==="bottom"&&sourcePosition.y<targetPosition.y){var p0=points[index-1];
if(p0){p0.y=p2.y;p1.y=p2.y}}}else{var differenceToPart=(targetPartPosition.x+targetPartPosition.w)-p1.x}}var upatedY=undefined;if(p2.y<p1.y&&p2.y<p3.y){if(points[index+1].direction===points[index+2].direction&&!points[index+3]&&!(targetPosition.direction==="top")){points.splice(index+1,1)
}else{upatedY=p2.x+differenceToPart;points.splice(index+2,0,{x:p3.x,y:p2.y})}}else{if(p2.y>p1.y&&p2.y>p3.y){upatedY=p2.x+differenceToPart;
points.splice(index+2,0,{x:p3.x,y:p2.y})}}if(upatedY){p1.x=upatedY;p2.x=upatedY}}}}};detectOverlappedPoints();var removeUnwantedReturns=function(){var lastSimilarPars=[];
for(var index=1;index<points.length-5;index++){var p1=points[index];var p2=points[index+1];var p3=points[index+2];var p4=points[index+3];
if(p1.x===p2.x&&p3.x===p4.x&&p4.x>p2.x){points[index+1].y=p4.y;points.splice(points.indexOf(p3),1);points.splice(points.indexOf(p4),1);
index=1;continue}}};var shortenPath=function(){for(var index=1;index<points.length-3;index++){var point1=points[index];var point2=points[index+1];
var point3=points[index+2];if(!((point3.direction==="left"||point3.direction==="top")&&point1.y<point3.y&&(point1.direction==="bottom"))||(point3.direction&&point3.direction===point1.direction)){continue
}if(point1.y===point2.y&&point2.x===point3.x){point1.y=point3.y;if(points[index+3]){point3.x=points[index+3].x}points.splice(points.indexOf(point2),1);
index=1;continue}}};shortenPath();removeUnwantedReturns();var findLongestLine=function(){var longest={points:[],delta:0};var length=points.length;
for(var index=0;index<length-1;index++){var point1=points[index];var point2=points[index+1];var delta1=Math.abs(point2.x-point1.x);var delta2=Math.abs(point2.y-point1.y);
var delta=delta1>delta2?delta1:delta2;if(longest.delta<delta){longest={points:[point1,point2],delta:delta}}}return longest.points};var getIntersection=function(line){var line=findLongestLine();
var point1=line[0];var point2=line[1];var delta1=Math.abs(point2.x-point1.x);var delta2=Math.abs(point2.y-point1.y);if(delta1>delta2){return{direction:"horiontal",x:point1.x+(delta1/2),y:point1.y}
}else{var p1;if(point1.y>point2.y){p1=point1}else{p1=point2}return{direction:"vertical",x:point2.x,y:p1.y-(delta2/2)}}};if(this.connectorType&&this.connectorType.length>0){var symnbolLocation=getIntersection(findLongestLine());
var targetAsIs=ShapesRegistry.get("Port",this["targets"][0]);var sourceAsIs=ShapesRegistry.get("Port",this["sources"][0]);var receive;
if(targetAsIs.getPosition().x>=sourceAsIs.getPosition().x){receive=false;if(symnbolLocation.direction==="vertical"){symnbolLocation.y=symnbolLocation.y-20
}else{symnbolLocation.x=symnbolLocation.x-20}}else{receive=true;if(symnbolLocation.direction==="vertical"){symnbolLocation.y=symnbolLocation.y+20
}else{symnbolLocation.yx=symnbolLocation.x+20}}var elem=ConnectorSymbols.draw(this,this.connectorType,symnbolLocation.direction,receive);
elem.setAttribute("transform","translate("+symnbolLocation.x+","+symnbolLocation.y+")")}var sourceParent=source.focalNode.parentNode;
var targetParent=target.focalNode.parentNode;var sourceParentParent=sourceParent.parentNode;var targetParentParent=targetParent.parentNode;
sourceParentParent.removeChild(sourceParent);sourceParentParent.appendChild(sourceParent);targetParentParent.removeChild(targetParent);
targetParentParent.appendChild(targetParent);this.focalNode.setAttribute("points",this.arrayToPoints(points));var connectorList=[];var all=source.connectors.sources.concat(source.connectors.targets).concat(target.connectors.sources).concat(target.connectors.sources);
for(var index=0,current;current=all[index];index++){if(!connectorList[current.name]){connectorList[current.name]=current}}this.adjustOverlappedConnectors(connectorList)
},adjustOverlappedConnectors:function(connectorList){var portConnectors=connectorList||ShapesRegistry.get("PortConnector");var shapePoints={};
for(var name in portConnectors){var connector=portConnectors[name];if(!connector.getAttribute){continue}var connectorPoints=[];shapePoints[connector.name]={connector:connector,connectorPoints:connectorPoints};
var points=connector.getAttribute("points").split(" ");for(var index=0,point;point=points[index];index++){var pair=point.split(",");connectorPoints.push({x:parseFloat(pair[0]),y:parseFloat(pair[1])})
}}var connectorIndex=0;var visitedTargets={};var visitedConnectors=[];var indenMap=ObjectsUtil.newInstance("util.core.Map");for(var name in shapePoints){var object=shapePoints[name];
var portConnector=object.connector;var connectorPoints=object.connectorPoints;for(var subName in shapePoints){connectorIndex++;var subObject=shapePoints[subName];
var subPortConnector=subObject.connector;if(subPortConnector===portConnector){continue}var subConnectorPoints=subObject.connectorPoints;
var target=subPortConnector.targets[0];if(visitedTargets[target]===undefined){visitedTargets[target]=0}else{if(visitedConnectors.indexOf(subPortConnector)===-1){visitedTargets[target]++
}}visitedConnectors.push(subPortConnector);var increment=indenMap.get(subPortConnector);if(!increment){increment=((visitedTargets[target]%2)?2:-2)*(Math.round(visitedTargets[target]/2));
indenMap.put(subPortConnector,increment)}var alteredPoints=[subConnectorPoints[0],subConnectorPoints[1]];var changed=false;for(var index=0;
index<subConnectorPoints.length-1;index++){var current=subConnectorPoints[index];var next=subConnectorPoints[index+1];var pairX=[current.x,next.x];
var pairY=[current.y,next.y];var changeHorizontal,changeVertical;for(var mainIndex=0;mainIndex<connectorPoints.length-1;mainIndex++){var mainCurrent=connectorPoints[mainIndex];
var mainNext=connectorPoints[mainIndex+1];var adjustNewValue=function(getter,ignoreGetter){var direction=1;var increase=3;var lastMax=3;
var newValue=subConnectorPoints[index][getter]+(increase*direction);var found=false;while(!found){search:{for(var searchName in shapePoints){var searchObject=shapePoints[searchName];
var searchObjectPoints=searchObject.connectorPoints;for(var searchIndex=0,searchPoint;searchPoint=searchObjectPoints[searchIndex];searchIndex++){if(searchPoint[getter]===newValue&&(Math.abs(searchPoint[ignoreGetter]-subConnectorPoints[index][ignoreGetter])<25||Math.abs(searchPoint[ignoreGetter]-subConnectorPoints[index+1][ignoreGetter])<25)){if(direction<1){if(increase<0.1){increase=lastMax+1;
lastMax++}else{increase=increase/2}}direction=direction*-1;newValue=subConnectorPoints[index][getter]+(increase*direction);break search
}}}found=true;break}}return newValue};var changeHorizontal=mainCurrent.x===current.x&&mainNext.x===next.x&&mainCurrent.x===next.x&&(mainNext.y===next.y||Math.abs(current.y-mainCurrent.y)<=3);
var changeVertical=mainCurrent.y===current.y&&mainNext.y===next.y&&mainCurrent.y===next.y&&(mainNext.x===next.x||Math.abs(current.x-mainCurrent.x)<=3);
if(changeHorizontal){var newValue=adjustNewValue("x","y");subObject.alteredx=true;subConnectorPoints[index].x=newValue;subConnectorPoints[index+1].x=newValue;
subPortConnector.movedHorizontally=true;changed=true}else{if(changeVertical){var newValue=adjustNewValue("y","x");subObject.alteredy=true;
subConnectorPoints[index].y=newValue;subConnectorPoints[index+1].y=newValue;subPortConnector.movedVertically=true;changed=true}}}}for(var index=0;
index<subConnectorPoints.length-2;index++){var p1=subConnectorPoints[index];var p2=subConnectorPoints[index+1];var p3=subConnectorPoints[index+2];
if(p2.y<p1.y&&p2.y<p3.y&&p1.x===p2.x&&p2.x===p3.x){subConnectorPoints.splice(index+1,1);index=0}else{if(p2.x<p1.x&&p2.x<p3.x&&p1.y===p2.y&&p2.y===p3.y){subConnectorPoints.splice(index+1,1);
index=0}}}for(var index=0;index<subConnectorPoints.length-1;index++){var p1=subConnectorPoints[index];var p2=subConnectorPoints[index+1];
var p3=subConnectorPoints[index+2];if(p2.x!=p1.x&&Math.abs(p2.x-p1.x)<7){p2.x=p1.x;index=-1;changed=true}else{if(p2.y-p1.y&&Math.abs(p2.y-p1.y)<7){p2.y=p1.y;
index=0;changed=true}else{if(index>4){break}}}}if(changed){var alteredPoints="";for(var pointIndex=0,currentPoint;currentPoint=subConnectorPoints[pointIndex];
pointIndex++){var prev1=subConnectorPoints[pointIndex-1];var prev2=subConnectorPoints[pointIndex-2];if(alteredPoints){alteredPoints=alteredPoints+" "
}var newPoint=currentPoint;if(prev1&&prev2){if(currentPoint.x!==prev1.x&&currentPoint.y!==prev1.y){if(prev2.x==prev1.x){newPoint.x=prev2.x
}else{if(prev2.y==prev1.y){newPoint.y=prev2.y}}}}alteredPoints=alteredPoints+newPoint.x+","+newPoint.y}subPortConnector.setAttribute("points",alteredPoints)
}}}},arrayToPoints:function(points){var pointString="";for(var index=0,current;current=points[index];index++){if(pointString){pointString=pointString+" "
}pointString=pointString+current.x+","+current.y}return pointString},getPosition:function(){return{x:parseFloat(this.focalNode.getAttribute("x")),y:parseFloat(this.focalNode.getAttribute("y")),w:13,h:13}
}})})();var StateTree={};function StateNode(a,b){this.parent=a;this.id=b;this.activeColour=null;this.passiveColor=null}StateNode.prototype.getParent=function(){return this.parent
};StateNode.prototype.getRoot=function(){var b=this;var a=null;while(b!==null){a=b;b=b.getParent()}return a};StateNode.prototype.getId=function(){return this.id
};StateNode.prototype.getDepth=function(){var a=this;var b=0;while(a!==null){a=a.getParent();b++}return b};function StateColourer(b,a){this.numShades=b;
this.numColours=a;this.cachedColours=this.baseColours.slice()}StateColourer.prototype.passiveColour="999999";StateColourer.prototype.baseColours=["CC99A2","9AAFAF","FFFF7F","98FB98","9DD6D6","D2AB6F","B19CD9"];
StateColourer.prototype.getBasePassiveColour=function(){var a=this.passiveColour;for(var b=0;b<(5-this.numShades)&&b<3;b++){a=this.lighten(a)
}return a};StateColourer.prototype.getBaseColour=function(c){var a;if(c<this.cachedColours.length){a=this.cachedColours[c]}else{c=c%this.cachedColours.length;
a=this.modifyColour(this.cachedColours[c]);this.cachedColours[c]=a}for(var b=0;b<(5-this.numShades)&&b<3;b++){a=this.lighten(a)}return a
};StateColourer.prototype.getLightenAmount=function(){return 15};StateColourer.prototype.getModifyAmount=function(){return 20};StateColourer.prototype.modifyColour=function(c){var c=this.createColour(c);
var a,b;if(c.red>c.blue){if(c.red>c.green){c.red-=this.getModifyAmount();if(c.blue>c.green){c.green+=this.getModifyAmount()}else{c.blue+=this.getModifyAmount()
}}else{c.green-=this.getModifyAmount();c.blue+=this.getModifyAmount()}}else{if(c.blue>c.green){c.blue-=this.getModifyAmount();if(c.red>c.green){c.green+=this.getModifyAmount()
}else{c.red+=this.getModifyAmount()}}else{c.blue-=this.getModifyAmount();c.red+=this.getModifyAmount()}}return c.toHex()};StateColourer.prototype.lighten=function(b){var b=this.createColour(b);
var a=this.getLightenAmount();b.modifyRed(a);b.modifyBlue(a);b.modifyGreen(a);return b.toHex()};StateColourer.prototype.createColour=function(f){var c=parseInt(f,16);
var e=(c>>16);var a=((c>>8)&255);var d=(c&255);return new Colour(e,a,d)};function Colour(c,a,b){this.red=c;this.blue=a;this.green=b}Colour.prototype.modifyRed=function(a){this.red+=a;
if(this.red>255){this.red=255}else{if(this.red<0){this.red=0}}};Colour.prototype.modifyBlue=function(a){this.blue+=a;if(this.blue>255){this.blue=255
}else{if(this.blue<0){this.blue=0}}};Colour.prototype.modifyGreen=function(a){this.green+=a;if(this.green>255){this.green=255}else{if(this.green<0){this.green=0
}}};Colour.prototype.modifyByName=function(a,b){if(a!=="red"&&a!=="blue"&&a!=="green"){throw"Not a valid colour name"}};Colour.prototype.toHex=function(){var a=this.green|(this.blue<<8)|(this.red<<16);
return a.toString(16)};function StateTable(b,a){this.table=b;this.stateTree=a}StateTable.prototype.readTable=function(){var c=this.table.find("tr");
var d=0;for(var a=1;a<c.length;a++){var b=jQuery(c[a]).find("td")[0];this.stateTree.stateNodes.push(this.stateTree.createState(jQuery(b),d++))
}};StateTable.prototype.colour=function(){var f=this.table.find("tr");var b,d,a;if(this.stateTree.type==="state"){b=jQuery(f[0]).find("td");
for(var e=1;e<b.length;e++){jQuery(b[e]).css("background-color","#"+this.stateTree.stateNodes[e-1].activeColour)}}for(var e=1;e<f.length;
e++){d=this.stateTree.stateNodes[e-1];b=jQuery(f[e]).find("td");a=jQuery(b[0]);a.css("background-color","#"+d.activeColour);for(var c=1;
c<b.length;c++){a=jQuery(b[c]);if(a.text().match(/^\s$/)){a.css("background-color","#"+d.passiveColour)}else{a.css("background-color","#"+d.activeColour)
}}}};function EventSequence(c,a,b){this.headerTable=c;this.bodyTable=a;this.stateTree=b}EventSequence.prototype.readTable=function(){var a=jQuery(this.headerTable).find("td");
var c=0;for(var b=1;b<a.length;b++){this.stateTree.stateNodes.push(this.stateTree.createState(jQuery(a[b]),c++))}};EventSequence.prototype.colour=function(){var f,b,d,a;
f=jQuery(this.headerTable).find("td");for(var e=1;e<f.length;e++){d=this.stateTree.stateNodes[e-1];jQuery(f[e]).css("background-color","#"+d.activeColour)
}f=jQuery(this.bodyTable).find("tr");for(var e=1;e<f.length;e++){d=this.stateTree.stateNodes[e-1];b=jQuery(f[e]).find("td");for(var c=0;
c<b.length;c++){a=jQuery(b[c]);if(a.text().match(/^\s$/)){a.css("background-color","#"+d.passiveColour)}else{a.css("background-color","#"+d.activeColour)
}}}};StateTree.init=function(b,a){StateTree.stateNodes=[];if(b.hasClass("event-statetable")){StateTree.type="event";StateTree.handler=new StateTable(b,this)
}else{if(b.hasClass("state-statetable")){StateTree.type="state";StateTree.handler=new StateTable(b,this)}else{if(b.hasClass("event-sequence-grid")){StateTree.type="eventSequence";
StateTree.handler=new EventSequence(b.find("table")[0],b.find("table")[1],this)}else{console.log("Unknown state table type");StateTree.type="unknown"
}}}};StateTree.createState=function(a,d){var c=parseInt(a.attr("data-parent"));var b=StateTree.stateNodes[c];if(isNaN(c)){b=null}return new StateNode(b,d)
};StateTree.maxDepth=function(){var a=0;var b;for(var c=0;c<StateTree.stateNodes.length;c++){b=StateTree.stateNodes[c].getDepth();if(b>a){a=b
}}return a};StateTree.numStateFamilies=function(){numStateFamilies=0;for(var a=0;a<StateTree.stateNodes.length;a++){if(StateTree.stateNodes[a].getParent()===null){numStateFamilies++
}}return numStateFamilies};StateTree.readTable=function(){StateTree.handler.readTable()};StateTree.assignStateColours=function(){var b=new StateColourer(StateTree.maxDepth(),StateTree.numStateFamilies());
var c=0;var d;for(var a=0;a<StateTree.stateNodes.length;a++){d=StateTree.stateNodes[a];if(d.getParent()===null){d.passiveColour=b.getBasePassiveColour();
d.activeColour=b.getBaseColour(c++)}else{d.passiveColour=b.lighten(d.getParent().passiveColour);d.activeColour=b.lighten(d.getParent().activeColour)
}}};StateTree.colour=function(){StateTree.assignStateColours();StateTree.handler.colour()};StateTree.colourStateTables=function(){jQuery(document).ready(function(){jQuery(".statetable").each(function(){StateTree.init(jQuery(this));
StateTree.readTable();StateTree.colour()})})};StateTree.colourEventSequences=function(){jQuery(document).ready(function(){jQuery(".event-sequence-grid").each(function(){StateTree.init(jQuery(this));
StateTree.readTable();StateTree.colour()})})};