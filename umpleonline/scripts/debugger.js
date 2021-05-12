
Debugger = new Object();

Debugger.inspect = function(obj)
{
  var msg = "";
  for (var i in obj) 
  {
    if (("" + obj[i]).startsWith("function"))
    {
      continue;
    }
    msg += typeof(obj) + "." + i + "=" + obj[i] + "\n";
  }
  alert(msg);
}


Debugger.log = function(msg)
{
  console.log(msg);
}