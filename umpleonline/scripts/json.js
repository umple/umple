Json = new Object();

Json.toObject = function(jsonText)
{
  if (jsonText == "")
  {
    return null;
  }
  eval(format("var data = {0};", jsonText));
  return data;
}

Json.toString = function(obj, name, shouldWrap)
{
  if (typeof(name) == "undefined") { name = null; }
  if (typeof(shouldWrap) == "undefined") { shouldWrap = true; }

  var json = "";
  for (var i in obj) 
  {
  	var attr = obj[i];
    if (("" + attr).startsWith("function") || attr == undefined)
    {
      continue;
    }
    if (json.length > 0)
    {
      json += ',';
    }
    if (Json.isObject(attr))
    {
      json += Json.toString(attr,i,false);
    }
    else if (Json.isArray(attr))
    {
      json += format('"{0}" : [',i);
      
      for (var index = 0; index < attr.length; index++)
      {
        if (index > 0)
        {
          json += ',';
        }
        json += Json.toString(attr[index],null,true); // format('"{0}"',attr[index]); 
      }
      json += ']';
    }
    else
    {
      json += format('"{0}" : "{1}"',i,obj[i]); 
    }
  }
  
  
  if (name != null)
  {
    json = format('"{0}" : {{1}}',name,json);
  }
  
  if (shouldWrap)
  {
    json = format('{{0}}',json);
  }
  
  return json;
}


Json.isObject = function(obj)
{
  return typeof(obj) == "object" && ! Json.isArray(obj);
}

Json.isArray = function(obj)
{
  return obj.constructor.toString().indexOf("Array") != -1
}