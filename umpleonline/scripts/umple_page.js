Page = new Object();
Page.selectedItem = null;
Page.selectedClass = null;
Page.selectedAssociation = null;
Page.selectedGeneralization = null;
Page.codeEffect = null;
Page.clickCount = 0;
Page.repeatToolItem = false;
Page.shortcutsEnabled = true;
Page.modelDelimiter = "//$?[End_of_model]$?";
Page.padding = 30;

Page.codeMirrorOn = false;
Page.codeMirrorEditor = null;


Page.init = function()
{ 
  jQuery.noConflict();
  jQuery(document).keydown(function(event){Action.keyboardShortcut(event);});
  
  Page.initPaletteArea();
  Page.initCanvasArea();
  Page.initUmpleTextArea();
  Page.initSourceCodeArea();
  Action.loadFile();
}

Page.initPaletteArea = function()
{
  var palette = "#palette";
  var paletteItems = palette + " *";
  jQuery(palette).accordion({fillSpace: true, active: 1, collapsible: true});
  jQuery(paletteItems).addClass("unselectable");
  
  Page.initJQueryButton("buttonGenerateCode");
  Page.initJQueryButton("buttonStartOver");
  
  Page.initHighlighter("buttonAddClass");
  Page.initHighlighter("buttonAddAssociation");
  Page.initHighlighter("buttonAddGeneralization");
  Page.initHighlighter("buttonDeleteEntity");
  Page.initHighlighter("buttonPngImage");
  Page.initHighlighter("buttonYumlImage");
  Page.initHighlighter("buttonSimulateCode");
  Page.initHighlighter("buttonUigu");
  Page.initHighlighter("buttonCopy");
  Page.initHighlighter("buttonCopyEncodedURL");
  Page.initHighlighter("buttonSmaller");
  Page.initHighlighter("buttonLarger");
  Page.initHighlighter("buttonSyncCode");
  Page.initHighlighter("buttonSyncDiagram");

  Page.initToggleTool("buttonAddClass");
  Page.initToggleTool("buttonAddAssociation");
  Page.initToggleTool("buttonAddGeneralization");
  Page.initToggleTool("buttonDeleteEntity");
   
  Page.initAction("buttonPngImage");
  Page.initAction("buttonYumlImage");
  Page.initAction("buttonPhpCode");
  Page.initAction("buttonEcoreCode");  
  Page.initAction("buttonJavaCode");
  Page.initAction("buttonJavaAPIDoc");
//  Page.initAction("buttonZip");
  Page.initAction("buttonRubyCode");
  Page.initAction("buttonSqlCode");
  Page.initAction("buttonCppCode");
  Page.initAction("buttonPhotoReady");
  Page.initAction("buttonSimulateCode");
  Page.initAction("buttonShowHideTextEditor");
  Page.initAction("buttonShowHideCanvas");
  Page.initAction("buttonShowHideLayoutEditor");
  Page.initAction("buttonManualSync");
  Page.initAction("buttonCopy");
  Page.initAction("buttonCopyEncodedURL");
  Page.initAction("buttonUndo");
  Page.initAction("buttonRedo");
  Page.initAction("buttonUigu");
  Page.initAction("buttonStartOver");
  Page.initAction("buttonGenerateCode");
  Page.initAction("buttonSmaller");
  Page.initAction("buttonLarger");
  Page.initAction("buttonSyncCode");
  Page.initAction("buttonSyncDiagram");
  
  Page.enablePaletteItem("buttonUndo", false);
  Page.enablePaletteItem("buttonRedo", false);
  Page.enablePaletteItem("buttonSyncDiagram", false);
  jQuery("#buttonCodeComplete").hide();
  jQuery("#buttonViewComplete").hide();
  
  Page.initExamples();
  Page.initOptions();
}

Page.initOptions = function()
{
  jQuery("#buttonShowHideLayoutEditor").attr('checked', false);
  jQuery("#buttonShowHideTextEditor").attr('checked', true);
  jQuery("#buttonShowHideCanvas").attr('checked', true);
  jQuery("#buttonPhotoReady").attr('checked', false);
  jQuery("#buttonManualSync").attr('checked', false);
  
  jQuery("#buttonShowHideTextEditor").attr('disabled', false);
  jQuery("#buttonShowHideCanvas").attr('disabled', false);
  jQuery("#buttonPhotoReady").attr('disabled', false);
  jQuery("#buttonManualSync").attr('disabled', false);
  
  Action.showHideLayoutEditor(true); // hide the layout editor
}

Page.initHighlighter = function(id)
{
  var selector = "#" + id;
  jQuery(selector).mouseover(function() {Page.highlightItem(id);});
  jQuery(selector).mouseout(function() {Page.unhighlightItem(id);});
}

Page.removeHighlighter = function(id)
{
  var selector = "#" + id;
  
  jQuery(selector).unbind('mouseover');
  jQuery(selector).unbind('mouseout');
}

Page.enableCheckBoxItem = function(boxId, listItemId, doEnable)
{
  var listItem = jQuery("#" + listItemId);
  var checkbox = jQuery("#" + boxId);
  
  if (doEnable)
  {
  	checkbox.attr('disabled', false);
  	checkbox.css('cursor', 'pointer');
  	listItem.css('color', 'Black');
  	
  }
  else
  {
  	checkbox.attr('disabled', true);
	checkbox.css('cursor', 'not-allowed');
	listItem.css('color', 'Silver');
  }
}

Page.enablePaletteItem = function(id, doEnable)
{
  var item = jQuery("#" + id);
  var enabled = !item.hasClass("disabled");
  
  if (enabled == doEnable) return;
  
  if (doEnable)
  {
  	item.removeClass();
  	item.attr('disabled', true);
  	Page.initHighlighter(id);
  }
  else
  {
  	item.removeClass();
  	item.addClass("disabled");
  	item.attr('disabled', false);
  	Page.removeHighlighter(id);
  }
}

Page.initToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.click(function() {Page.toggleToolItem(id, false);});
  item.dblclick(function() {Page.toggleToolItem(id, true);});
}

Page.removeToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.unbind('click');
  item.unbind('dblclick');
}

Page.initJQueryButton = function(id)
{
  var selector = "#" + id;
  var value = jQuery(selector).attr("value");
  jQuery(selector).button({label: value});
}

Page.initAction = function(id)
{
  var selector = "#" + id;
  jQuery(selector).click(Action.clicked);
}

Page.initUmpleTextArea = function()
{
  jQuery("#umpleModelEditor").keyup(function(eventObject){Action.umpleTyped(eventObject);});

jQuery("#umpleModelEditor").mousedown(function(){setTimeout("jQuery(\"#linenum\").val(Action.getCaretPosition())",25)});
  jQuery("#umpleLayoutEditor").keyup(function(eventObject){Action.umpleTyped(eventObject);});
  jQuery("#umpleModelEditor").focus(function(){Action.focusOn("umpleModelEditor", true);});
  jQuery("#umpleLayoutEditor").focus(function(){Action.focusOn("umpleLayoutEditor", true);});
  jQuery("#umpleModelEditor").blur(function(){Action.focusOn("umpleModelEditor", false);});
  jQuery("#umpleLayoutEditor").blur(function(){Action.focusOn("umpleLayoutEditor", false);});

  // Uncomment the following line to turn CodeMirror on by default; comment out to
  // require the user to type cm1 to turn code mirror on
  Page.initCodeMirrorEditor();
  Page.resizeCodeMirrorEditor( jQuery("#umpleModelEditor").height());
}

Page.initCodeMirrorEditor = function() {
  var foldFunc = CodeMirror.newFoldFunction(CodeMirror.braceRangeFinder);
  Page.codeMirrorEditor = CodeMirror.fromTextArea(
     document.getElementById('umpleModelEditor'),{
        lineNumbers: true,
        matchBrackets: true,
        mode: "text/x-umple",
        lineWrapping: true,
        onGutterClick: foldFunc,
        onChange: function(ed, changes) {Action.umpleCodeMirrorTypingActivity();},
        onCursorActivity: function() {Action.umpleCodeMirrorCursorActivity();}
      }
      );
  Page.codeMirrorOn = true;  
}

Page.resizeCodeMirrorEditor = function(newHeight) {
   Page.setFeedbackMessage("Will Set new height to "+newHeight);

   Page.codeMirrorEditor.getWrapperElement().style.height=newHeight+"px";
   Page.setFeedbackMessage("Set new height to "+newHeight);
   Page.codeMirrorEditor.refresh();
}

Page.isPhotoReady = function()
{
  var selector = "#buttonPhotoReady";
  return jQuery(selector).attr('checked');
}

Page.initSourceCodeArea = function()
{
  SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
  var generatedCodeRowSelector = "#generatedCodeRow";
  jQuery(generatedCodeRowSelector).hide();
}

Page.hideGeneratedCode = function()
{
  jQuery("#generatedCodeRow").hide();
}

Page.initCanvasArea = function()
{
  var canvas = jQuery("#" + Page.umpleCanvasId());
  
  var offsetTop = Math.round(canvas.position().top);
  var offsetLeft = Math.round(canvas.position().left);
  
  var defaultWidth = canvas.width();
  var defaultHeight = canvas.height();
  Action.minCanvasSize = new UmplePosition(0,0,defaultWidth,defaultHeight);
  
  var windowHeight = jQuery(window).height()-35;
  var windowWidth = jQuery(window).width();
  
  var startupWidth = windowWidth - offsetLeft - Page.padding;
  var startupHeight = windowHeight - offsetTop - Page.padding;
  
  Page.setUmpleCanvasSize(startupWidth,startupHeight);
  
  canvas.click(function(event){Action.umpleCanvasClicked(event);});
  canvas.mousemove(Action.mouseMove);
  canvas.focus(function(){Action.focusOn(Page.umpleCanvasId(), true);});
  canvas.blur(function(){Action.focusOn(Page.umpleCanvasId(), false);});
  canvas.delegate("[class$='editableDoubleClick']", 'dblclick', InlineEditor.handleOnClick);
  canvas.delegate("[class$='editableSingleClick']", 'click', InlineEditor.handleOnClick);
  canvas.resizable({stop: function(event, ui){Action.umpleCanvasResizing(event, ui);},
  							  autoHide: true,
  							  minHeight: Action.minCanvasSize.height,
  							  minWidth: Action.minCanvasSize.width});
  
  // remove the jquery resizable handle
  jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
  jQuery(".ui-icon").removeClass("ui-icon");
}

Page.initExamples = function()
{
  jQuery("#inputExample").change(Action.loadExample);
  jQuery("#defaultExampleOption").attr("selected",true);
}

Page.highlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).addClass("highlight");
}

Page.unhighlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).removeClass("highlight");
}

Page.enableDiagram = function(doEnable)
{
  Page.enableEditDragAndResize(doEnable);
  Page.enablePaletteItem("buttonAddClass", doEnable);
  Page.enablePaletteItem("buttonAddAssociation", doEnable);
  Page.enablePaletteItem("buttonAddGeneralization", doEnable);
  Page.enablePaletteItem("buttonDeleteEntity", doEnable);
  Page.showDiagramSyncNeeded(!doEnable);
}

Page.enableEditDragAndResize = function(doEnable)
{
  if (doEnable)
  {
  	jQuery("span.editable").removeClass("uneditable");
  	jQuery("div.umpleClass").removeClass("unselectable");
  	jQuery("div.umpleClass.ui-draggable").draggable("option", "disabled", false);
  	jQuery("div.umpleClass.ui-resizable").resizable("option", "disabled", false);
  } 
  else
  {
  	jQuery("span.editable").addClass("uneditable");
  	jQuery("div.umpleClass").addClass("unselectable");
  	jQuery("div.umpleClass.ui-draggable").draggable("option", "disabled", true);
  	jQuery("div.umpleClass.ui-resizable").resizable("option", "disabled", true);
  }
}

Page.toggleToolItem = function(id, doubleClicked)
{
  if (doubleClicked == undefined) doubleClicked = false;
  Page.repeatToolItem = doubleClicked;
  
  var toolSelected = id.substring(6);
  var isNewTool = (toolSelected != Page.selectedItem);
  
  if (isNewTool)
  {
    Page.selectToggleTool(toolSelected);
  }
  else
  {
    Page.unselectAllToggleTools();
  }
}

Page.unselectAllToggleTools = function()
{
  Action.removeNewClass();
  Action.removeNewAssociation();
  Action.removeNewGeneralization();
  
  var allSelectedItems = "ul.toggle li.selected"; 
  jQuery(allSelectedItems).removeClass("selected highlight");
  
  setTimeout("Page.enableEditDragAndResize(true);", 500);
  Page.selectedItem = null;
  Page.repeatToolItem = false;
}

Page.selectToggleTool = function(toolSelected)
{
  if (Page.selectedItem != null)
  {
    Action.removeNewClass();
    Action.removeNewAssociation();
    Action.removeNewGeneralization();
  }
  
  Page.enableEditDragAndResize(false);
  Page.selectedItem = toolSelected;
  Action.unselectAll();
  
  var allSelectedItems = format("ul.toggle li.selected");
  var newSelectedItem = "#button" + toolSelected;
  jQuery(allSelectedItems).removeClass("selected highlight");
  jQuery(newSelectedItem).addClass("selected");
}

Page.canShowHovers = function()
{
  return Page.selectedItem == null || Page.selectedItem == "DeleteEntity";
}

Page.getRawUmpleCode = function()
{
  return document.getElementById('umpleModelEditor').value;
}

Page.getUmpleCode = function()
{
  // TODO This had been instrumented with ACE. Needs cleaning up
  var model = Page.getRawUmpleCode().replace(Page.modelDelimiter, "");
  var regex = new RegExp(/^\d+/); //starts with digit, one or more E.G. 12345class X
  var lineNumbers = regex.exec(model);
  var modelCleaned = model.replace(lineNumbers,"");
  var positioning = jQuery("#umpleLayoutEditor").val().replace(Page.modelDelimiter, "");
  
  var umpleCode = modelCleaned + Page.modelDelimiter + positioning;
  return umpleCode;
}

Page.getEncodedURL = function()
{
  // TODO See if the server can be grabbed from the current one
  // TODO Internet explorer limis to about 2000 characters
    return "http://try.umple.org/?text=" + encodeURIComponent(Page.getUmpleCode());
}

Page.splitUmpleCode = function(umpleCode)
{
  var splitIndex = umpleCode.indexOf(Page.modelDelimiter);
  if (splitIndex == -1)
  {
  	model = umpleCode;
  	positioning = "";
  }
  else
  {
    umpleCode = umpleCode.replace(Page.modelDelimiter, "");
  
    var model = umpleCode.substr(0, splitIndex);
    var positioning = umpleCode.substr(splitIndex, umpleCode.length);
  }
  var modelAndPositioning = [model, positioning];
  return modelAndPositioning;
}  

Page.setUmpleCode = function(umpleCode)
{
  var modelAndPositioning = Page.splitUmpleCode(umpleCode);
 
  Page.hideGeneratedCode();
  
  jQuery("#umpleLayoutEditor").val(modelAndPositioning[1]);


  if(Page.codeMirrorOn) {
    Page.codeMirrorEditor.setValue(modelAndPositioning[0]);
  }
  jQuery("#umpleModelEditor").val(modelAndPositioning[0]);
}

Page.setUmplePositioningCode = function(positioning)
{
  jQuery("#umpleLayoutEditor").val(positioning);
}

Page.umpleCanvasId = function()
{
  return "umpleCanvas";
}

Page.showDiagramSyncNeeded = function(doShow)
{
  var canvas = jQuery("#umpleCanvas");
  var messageDiv =  '<div id="syncNeededMessage" class="syncNeededMessage unselectable">' +
  				    'Diagram is out of synchronization with the text due to selecting Manual Sync or an error in the text. ' +
  					'</div>';
  if (doShow)
  {
  	canvas.append(messageDiv);
  }
  else
  {
  	jQuery("#syncNeededMessage").remove();
  }
  
}

Page.hideLoading = function()
{
  var modelEditor = "#umpleModelEditor";
  var layoutEditor = "#umpleLayoutEditor";
  var canvas = "#" + Page.umpleCanvasId();  
  
  jQuery(modelEditor).hideLoading();
  jQuery(canvas).hideLoading();
  jQuery(layoutEditor).hideLoading();
  jQuery(".bookmarkableUrl").removeClass("disabled");
}

Page.showModelLoading = function()
{
  var modelEditor = jQuery("#umpleModelEditor");
  if (jQuery("#textEditorColumn").is(":visible"))
  {
    modelEditor.showLoading();
  }
  jQuery(".bookmarkableUrl").addClass("disabled");
}

Page.showLayoutLoading = function()
{
  var layoutEditor = jQuery("#umpleLayoutEditor");
  if (layoutEditor.is(":visible")) 
  {
  	layoutEditor.showLoading();
  }
  jQuery(".bookmarkableUrl").addClass("disabled");
}

Page.showCanvasLoading = function()
{
  var canvas = jQuery("#umpleCanvas");
  if (canvas.is(":visible"))
  {
  	canvas.showLoading();
  }
  jQuery(".bookmarkableUrl").addClass("disabled");
}

Page.resetCanvasSize = function()
{
  Page.setUmpleCanvasSize(Action.minCanvasSize.width, Action.minCanvasSize.height);
}

Page.setUmpleCanvasSize = function(width, height)
{
  
  if (width < Action.minCanvasSize.width)
  {
  	width = Action.minCanvasSize.width;
  }
  if (height < Action.minCanvasSize.height)
  {
  	height = Action.minCanvasSize.height;
  }
  
  if (jQuery("#buttonShowHideLayoutEditor").attr('checked'))
  {
    jQuery("#umpleModelEditor").height(height*0.7 + 3);
    if(Page.codeMirrorOn) {
       Page.resizeCodeMirrorEditor(height*0.7 + 3);
    }
    jQuery("#umpleLayoutEditor").height(height*0.3);
  }
  else
  {
    jQuery("#umpleModelEditor").height(height + 6);
    if(Page.codeMirrorOn) {
       Page.resizeCodeMirrorEditor(height + 6);
    }
  }
  
  jQuery("#palette").height(height + 7);
  jQuery("#umpleCanvas").width(width);
  jQuery("#umpleCanvas").height(height);
  jQuery("#palette").accordion("resize");
    
  if (width == Action.minCanvasSize.width && 
      height == Action.minCanvasSize.height)
  {
    Page.enablePaletteItem("buttonSmaller", false);
  }
  else
  {
  	Page.enablePaletteItem("buttonSmaller", true);
  }
}

Page.getSelectedExample = function()
{
  var inputExample = jQuery("#inputExample option:selected").val();
  return inputExample;
}

Page.showCodeDone = function()
{
  var selector = "#buttonCodeComplete";
  jQuery(selector).dialog({closeOnEscape:true, hide:'puff', height:100, width:250});
  setTimeout(function() {jQuery(selector).dialog("close");}, 2000);
}

Page.showViewDone = function()
{
  var selector = "#buttonViewComplete";
  jQuery(selector).dialog({closeOnEscape:true, hide:'puff', height:100, width:250});
  setTimeout(function() {jQuery(selector).dialog("close");}, 2000);
}

Page.showGeneratedCode = function(code,language)
{
  jQuery("#generatedCodeRow").show();

  if(language!="javadoc" && language !="diagramUpdate") {
    var codeparts = code.split('URL_SPLIT');
    var zipurl = "";
    var bodycode = "";
    var warningToggleLoc = 0;
    if(codeparts.length == 1) {
        bodycode = codeparts[0];
    }
    else {
        zipurl = codeparts[0];
        bodycode = codeparts[1];
    }
    jQuery("#generatedCodeRow").html(format(zipurl+'<pre class="brush: {1};">{0}</pre>',bodycode,language));
    warningToggleLoc = zipurl.indexOf("Show/Hide errors and warnings");
    if(warningToggleLoc > 30 || warningToggleLoc == -1) {
      SyntaxHighlighter.highlight("code");
    }
  }
  else {
      jQuery("#generatedCodeRow").html(format('{0}',code));
  }
}

Page.setFilename = function(filename)
{
  jQuery("#filename").val(filename);
}

Page.setFeedbackMessage = function(feedbackMessage)
{
  document.getElementById('feedbackMessage').innerHTML=feedbackMessage;
}

Page.getFeedbackMessage = function()
{
  return document.getElementById('feedbackMessage').innerHTML;
}

Page.catFeedbackMessage = function(feedbackMessage)
{
  var origMsg = document.getElementById('feedbackMessage').innerHTML;
  document.getElementById('feedbackMessage').innerHTML=origMsg+feedbackMessage;
}

Page.getFilename = function()
{
  return jQuery("#filename").val();
}

Page.getAdvancedMode = function()
{
  return document.getElementById("advancedMode").value;
}

jQuery.fn.selectRange = function(start, end) {
  return this.each(function() 
  {
    if(this.setSelectionRange) 
    {
      this.focus();
      this.setSelectionRange(start, end);
    } 
    else if(this.createTextRange) 
    {
       var range = this.createTextRange();
       range.collapse(true);
       range.moveEnd('character', end);
       range.moveStart('character', start);
       range.select();
    }
  });
};
