// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// This file holds all the functions that initialize and control the layout of the
// dynamic elements of umpleonline.

var Layout = {};
Layout.isTextVisible = true;
Layout.isDiagramVisible = true;
Layout.isPaletteVisible = true;

// The handles for the main layout controlling features
var canvasHandle = "#umpleCanvasColumn";
var editorHandle = "#textEditorColumn";
var modelEditorHandle = "#topTextEditor";
var paletteHandle = "#paletteColumn";
var layoutEditorHandle = "#bottomTextEditor";

/////////////////////////////////////
// Layout initialization functions //
/////////////////////////////////////

//Initializes any constants the layout depends on
Layout.init = function()
{
  Layout.padding = 2*parseInt(jQuery('body').css('marginLeft')) 
    + parseInt(jQuery(editorHandle).css('paddingRight'))
    + parseInt(jQuery(canvasHandle).css('paddingLeft'));
  
  this.minCanvasSize = new UmplePosition(0,0,420,490);
  this.minEditorSize = new UmplePosition(0,0,284,0);
  this.maxEditorSize = new UmplePosition(
      0,
      0,
      jQuery(window).innerWidth() - this.padding - jQuery(paletteHandle).outerWidth() - Layout.minCanvasSize.width,
      0);
}

// Initializes the canvas size
Layout.initUmpleCanvasSize = function()
{
  var canvas = jQuery(canvasHandle);
  if (this.isDiagramVisible==false) {this.showHideCanvas(false);}
  
  var offsetTop = Math.round(canvas.position().top);
  var offsetLeft = Math.round(canvas.position().left);
  
  canvas.width(jQuery(window).width() - offsetLeft - this.padding);
  canvas.height(jQuery(window).height() - offsetTop - this.padding);
}

// Initializes the text editor size
Layout.initUmpleTextAreaSize = function()
{
  jQuery(editorHandle).resizable({
    start: function(event, ui)
      {
        Layout.canvasStartingWidth = jQuery(canvasHandle).outerWidth()
          - parseInt(jQuery(editorHandle).css('paddingRight'));
          - parseInt(jQuery(canvasHandle).css('paddingLeft')); 
        Layout.editorStartingWidth = jQuery(editorHandle).outerWidth();
      },
    resize: function(event, ui){Layout.umpleTextEditorResizing(event, ui);},
    stop: function(event, ui){Layout.umpleTextEditorResized(event, ui);},
    autoHide: true,
    minWidth: this.minEditorSize.width,
    maxWidth: this.maxEditorSize.width,
    handles:"e"});
  
  this.resizeCodeMirrorEditor(jQuery(modelEditorHandle).height());
  jQuery(editorHandle).width(508);
  
  this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery(canvasHandle).outerWidth(), undefined);
}

Layout.initPaletteSize = function()
{
  jQuery("#paletteColumn").height(jQuery(window).innerHeight() - jQuery("#header").outerHeight() - 
      jQuery("#topLine").outerHeight() - Layout.padding);
}

///////////////////////////////////////////
// Functions to set sizes of UI elements //
///////////////////////////////////////////

Layout.setTextEditorSize = function(width, height) 
{
  var umpleTextEditor = jQuery(editorHandle);
  
  if(width == undefined) width = umpleTextEditor.outerWidth();
  if(height == undefined) height = this.calculateMainHeight();
  
  if(width < Layout.minEditorSize.width) 
  {
    width = Layout.minEditorSize.width;
  }
  
  umpleTextEditor.width(width);
  
  this.adjustTextEditorHeight(height);

  if(this.isDiagramVisible)
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery(canvasHandle).outerWidth(), undefined);
}

//Sets the size of the canvas. If either the height or width are undefined, they are unchanged.
Layout.setUmpleCanvasSize = function(width, height)
{
  var umpleCanvas = jQuery(canvasHandle);

  var maxWidth = jQuery(window).innerWidth() - this.padding - this.minEditorSize.width 
    - jQuery(paletteHandle).outerWidth();
  
  if(width == undefined) width = umpleCanvas.outerWidth();
  if(height == undefined) height = this.calculateMainHeight();
  
  if (width < this.minCanvasSize.width)
  {
    width = this.minCanvasSize.width;
  }
  if (height < this.minCanvasSize.height)
  {
    height = this.minCanvasSize.height;
  }
  if (width > maxWidth && this.isTextVisible)
  {
    width = maxWidth;
  }
  
  this.adjustTextEditorHeight(height);
  
  umpleCanvas.width(width);
  umpleCanvas.height(height);
  jQuery("#palette").accordion("resize");
    
  if (width == this.minCanvasSize.width && 
      height == this.minCanvasSize.height)
  {
    Page.enablePaletteItem("buttonSmaller", false);
  }
  else
  {
    Page.enablePaletteItem("buttonSmaller", true);
  }
}

//Sets the height of the model and layout text editors, depending on what is enabled
Layout.adjustTextEditorHeight = function(height) 
{  
  if (jQuery("#buttonShowHideLayoutEditor").attr('checked'))
  {
    jQuery(modelEditorHandle).height(height*0.7);
    if(Page.codeMirrorOn) this.resizeCodeMirrorEditor(height*0.7);
    jQuery(layoutEditorHandle).height(height*0.3);
  }
  else
  {
    jQuery(modelEditorHandle).height(height);
    if(Page.codeMirrorOn) this.resizeCodeMirrorEditor(height);
  }
  jQuery(editorHandle).height(height);
}

Layout.resizeCodeMirrorEditor = function(newHeight) 
{
  if(Page.codeMirrorOn)
  {
    Page.codeMirrorEditor.getWrapperElement().style.height=newHeight+"px";
    Page.codeMirrorEditor.refresh();
  }
}

////////////////////////////////////////////
// Functions to show and hide UI elements //
////////////////////////////////////////////

Layout.showHideLayoutEditor = function(doShow)
{
  var layoutEditor = jQuery(layoutEditorHandle);
  var newHeight = jQuery(canvasHandle).height();
   
  if (doShow == undefined) doShow = layoutEditor.is(":visible");
  
  if (doShow)  // warning: This works backwards to intuition
  {
    layoutEditor.hide();
    this.adjustTextEditorHeight(newHeight);
  }
  else
  {
    layoutEditor.show();
    this.adjustTextEditorHeight(newHeight);
  }
}

Layout.showHideTextEditor = function(doShow)
{
  var modelEditor = jQuery(editorHandle);
  var layoutBox = jQuery("#buttonShowHideLayoutEditor");
  var layoutListItem = jQuery("#layoutListItem");
  var canvas = jQuery(canvasHandle);
  
  if (doShow == undefined) doShow = !this.isTextVisible; 
    
  if (doShow)
  {
    modelEditor.show();
    this.isTextVisible = true;
    // disable the show/hide layout editor option
    layoutBox.attr('disabled', false);
    layoutBox.css('cursor', 'pointer');
    layoutListItem.css('color', 'Black');
    Page.setUmpleCode(Page.getUmpleCode()); // force reset
  }
  else
  {    
    modelEditor.hide();
    this.isTextVisible = false;
    layoutBox.attr('disabled', true);
    layoutBox.css('cursor', 'not-allowed');
    layoutListItem.css('color', 'DimGray');
  }
  
  // Resize the canvas and/or the text editor appropriately
  if(this.isDiagramVisible)
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + canvas.outerWidth(), undefined);
  if(this.isTextVisible)
    this.setTextEditorSize(this.calculateLeftoverWidth() + modelEditor.outerWidth(), undefined);
}

Layout.showHideCanvas = function(doShow)
{ 
  var canvas = jQuery(canvasHandle);
  
  if (doShow == undefined) doShow = !this.isDiagramVisible;
  
  if (doShow)
  {
    canvas.show();
    this.isDiagramVisible = true;
    Action.manualSync = jQuery("#buttonManualSync").attr('checked');
    jQuery("#buttonShowHideCanvas").attr('checked',true);
    
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "photoReadyListItem", true);
      Page.enableCheckBoxItem("buttonManualSync", "manualSyncListItem", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
  }
  else
  {
    canvas.hide();
    this.isDiagramVisible = false;
    Action.manualSync = true;
    jQuery("#buttonShowHideCanvas").attr('checked',false);
    
    Page.enableCheckBoxItem("buttonPhotoReady", "photoReadyListItem", false);
    Page.enableCheckBoxItem("buttonManualSync", "manualSyncListItem", false);

    
    Page.enablePaletteItem('buttonAddClass', false);
    Page.enablePaletteItem('buttonAddAssociation', false);
    Page.enablePaletteItem('buttonAddGeneralization', false);
    Page.enablePaletteItem('buttonDeleteEntity', false);
    Page.enablePaletteItem('buttonSyncDiagram', false);

    Page.removeToggleTool('buttonAddClass');
    Page.removeToggleTool('buttonAddAssociation');
    Page.removeToggleTool('buttonAddGeneralization');
    Page.removeToggleTool('buttonDeleteEntity');
  }
  
  // Resize the text editor appropriately 
  if(this.isDiagramVisible)
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + canvas.outerWidth(), undefined);
  if(this.isTextVisible)
    this.setTextEditorSize(this.calculateLeftoverWidth() + jQuery(editorHandle).outerWidth(), undefined);
}

/////////////////////////////////////////
// Dynamic resizing handling functions //
/////////////////////////////////////////

Layout.mainApplicationHeightResizing = function(event, ui)
{
  var currentHeight = ui.size.height;
  
  this.setUmpleCanvasSize(jQuery(canvasHandle).outerWidth(), currentHeight);
}

Layout.umpleTextEditorResizing = function(event, ui)
{
  var currentWidth = ui.size.width;
  var deltaWidth = Layout.editorStartingWidth - currentWidth;
  jQuery(canvasHandle).width(Layout.canvasStartingWidth + deltaWidth);
  jQuery(editorHandle).width(currentWidth);
  jQuery(modelEditorHandle).width(currentWidth);
  jQuery(layoutEditorHandle).width(currentWidth);
}

Layout.umpleTextEditorResized = function(event, ui)
{
  var currentWidth = ui.size.width;
  jQuery(modelEditorHandle).css('width', 'auto');
  jQuery(layoutEditorHandle).css('width', 'auto');
  this.setTextEditorSize(currentWidth, undefined);
}

Layout.umpleCanvasResizing = function(event, ui)
{
  var currentHeight = ui.size.height;
  var currentWidth = ui.size.width;
  
  this.setUmpleCanvasSize(currentWidth, currentHeight);
}

Layout.umpleCanvasResized = function(factor)
{ 
  var currentHeight = jQuery(canvasHandle).outerHeight();
  var currentWidth = jQuery(canvasHandle).outerWidth();
  
  var inc = 100;
  var newHeight=currentHeight + 0.25*inc*factor;
  var newWidth=currentWidth + inc*factor;
  
  this.setUmpleCanvasSize(newWidth, newHeight);
}

// A helper function to calculate the unused width of the page, depending on what is currently visible
Layout.calculateLeftoverWidth = function() 
{
  var width = jQuery(window).innerWidth() - this.padding;
  if(this.isTextVisible) width -= jQuery(editorHandle).outerWidth();
  if(this.isDiagramVisible) width -= jQuery(canvasHandle).outerWidth();
  if(this.isPaletteVisible) width -= jQuery(paletteHandle).outerWidth();
  return width;
}

// Helper function to calculate the height of the canvas, textEditor, and palette
Layout.calculateMainHeight = function() 
{
  return jQuery(paletteHandle).outerHeight();
}