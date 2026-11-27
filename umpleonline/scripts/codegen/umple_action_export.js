// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for exporting the model: images, clipboard copies, separate windows and the simulator

Action.copyToClp = function(txt){
    prenode=document.createElement("PRE");
    txt = document.createTextNode(txt);
    prenode.appendChild(txt);
    var m = document;
    var w = window;
    var b = m.body;
    b.appendChild(prenode);

    if (b.createTextRange) {
        var d = b.createTextRange();
        d.moveToElementText(txt);
        d.select();
        m.execCommand('copy');
    } 
    else {
        var d = m.createRange();
        var g = w.getSelection;
        d.selectNodeContents(txt);
        g().removeAllRanges();
        g().addRange(d);
        m.execCommand('copy');
        g().removeAllRanges();
    }
    prenode.remove();
}

Action.pngImage = function()
{
  var jsonText = Json.toString(UmpleSystem);
  var jsonEncodedText = encodeURIComponent(jsonText);
  window.open("scripts/compiler.php?asImage=" + jsonEncodedText, "UMLClassDiagram");
}

Action.yumlImage = function()
{
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).showLoading();
  Action.ajax(Action.yumlImageCallback,"save=1");
}

Action.yumlImageCallback = function(response)
{
  var filename = response.responseText;
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).hideLoading();
  window.open("scripts/compiler.php?asYuml=" + filename, "yumlClassDiagram");
  Page.showViewDone();
}

Action.uigu = function()
{
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).showLoading();
  Action.ajax(Action.uiguCallback,"save=1");
}

Action.uiguCallback = function(response)
{
  var filename = response.responseText;
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).hideLoading();
  window.open("scripts/compiler.php?asUI=" + filename, "showUserInterface");
  Page.showViewDone();
}

Action.copyClipboardCode = function()
{
  Action.copyToClp(Page.getUmpleCode());
  Page.setFeedbackMessage("Code has been copied to the clipboard");  
}

Action.copyClipboardMixset = function()
{
  Action.copyToClp(Page.copyableMixset);
  Page.setFeedbackMessage("Mixset with selected diagram filters and options is in clipboard");  
}

Action.copyCommandLineCode = function()
{
  var pretext="sh\n";
  pretext+="echo Will compile umple file. Requires umple command to be installed\n";
  pretext+="cd ~/tmp\n";
  pretext+="mkdir testump-$$\n";
  pretext+="cd testump-$$\n";
  pretext+="cat >> test.ump <<ENDUMP\n";
  var posttext="\nENDUMP\n";
  posttext+="umple test.ump -c -\n";
  posttext+="echo Use ctrl-D to exit back to the original shell\n\n";
  Action.copyToClp(pretext+Page.getUmpleCode()+posttext);
  Page.setFeedbackMessage("Shell code to compile on command line was copied to clipboard");  
}

Action.showCodeInSeparateWindow = function()
{
  const d = new Date();
  const pad = (n) => String(n).padStart(2, "0");
  const stamp =
    d.getFullYear() +
    pad(d.getMonth() + 1) +
    pad(d.getDate()) + " " +
    pad(d.getHours()) + ":" +
    pad(d.getMinutes()) + ":" +
    pad(d.getSeconds());

  const header = `// UmpleOnline code as of ${stamp}\n\n`;
  const content = header + Page.getUmpleCode();
  
  codeWindow = window.open("","UmpleCode","height=700, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + content + '</pre></code>');
  codeWindow.document.title="Umple raw code";
  codeWindow.document.close();
}

Action.showEncodedURLCodeInSeparateWindow = function()
{
  const MAX_ENCODED_URL_LEN = 2000; // conservative safe limit
  const url = Page.getEncodedURL();
  const len = url.length;

  let header = "";
  if (len > MAX_ENCODED_URL_LEN) {
    header =
      "// WARNING: Encoded URL length (" + len + " characters)\n" +
      "// exceeds recommended limit (" + MAX_ENCODED_URL_LEN + ").\n" +
      "// Use Save & Collaborate for larger models.\n\n";

    Page.setFeedbackMessage(
      "Encoded URL too long (" + len + " chars). Use Save & Collaborate instead."
    );
  } else {
    Page.setFeedbackMessage(
      "Encoded URL generated (" + len + " chars). Ideal for PowerPoint embedding."
    );
  }

  const content = header + url;

  codeWindow = window.open("","UmpleEncodedURL","height=500, width=520, left=100, top=100, location=no, status=no, scrollbars=yes");

  codeWindow.document.write('<code><pre id="umpleCode">' + content + '</pre></code>');
  codeWindow.document.title = "Umple encoded URL";
  codeWindow.document.close();
}


Action.simulateCode = function()
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).showLoading();
  Action.ajax(Action.simulateCodeCallback,"language=Simulate");
}

Action.simulateCodeCallback = function(response)
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).hideLoading();
  var modelId = response.responseText;
  window.open("../umpleonline/simulate.php?model=" + modelId, "umpleSimulator");
  Page.showViewDone(); 
}
