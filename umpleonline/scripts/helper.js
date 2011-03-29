
function roundTo(num, decimalAccuracy)
{
  var factor = Math.pow(10,decimalAccuracy);
  if (decimalAccuracy > 0)
  {
    return Math.round(num/factor)*factor;
  }
  else
  {
    return Math.round(num/factor)*factor;
  }
}

String.prototype.trim = function() {
  return this.replace(/^\s+|\s+$/g,"");
}
String.prototype.ltrim = function() {
  return this.replace(/^\s+/,"");
}
String.prototype.rtrim = function() {
  return this.replace(/\s+$/,"");
}

function trim(str)
{
  return str.replace(/^\s+|\s+$/g, '');
}

function format(rawInput)
{
  var formattedText = rawInput;
  var lastFormattedText = "";
  while (formattedText != lastFormattedText)
  {
    lastFormattedText = formattedText;
    for(var i=1; i<arguments.length; i++)
    {
      formattedText = formattedText.replace("{" + (i - 1) + "}", arguments[i]);
    }
  }
  
  return formattedText;
}
