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
Layout.padding = 30;

Layout.minEditorSize;
Layout.maxEditorSize;
Layout.minCanvasSize;

// The handles for the main layout controlling features
var canvasHandle = "umpleCanvas";
var modelEditorHandle = "umpleTextEditor";
var paletteHandle = "paletteColumn";
var layoutEditorHandle = "umpleLayoutEditor";

/////////////////////////////////////
// Layout initialization functions //
/////////////////////////////////////

// Initializes the canvas size
Layout.initUmpleCanvasSize = function()
{
  var canvas = jQuery("#" + canvasHandle);
  if (this.isDiagramVisible==false) {this.showHideCanvas(false);}
  
  var offsetTop = Math.round(canvas.position().top);
  var offsetLeft = Math.round(canvas.position().left);
  
  var defaultWidth = canvas.width();
  var defaultHeight = canvas.height();
  
  this.minCanvasSize = new UmplePosition(0,0,defaultWidth,defaultHeight);
  this.minEditorSize = new UmplePosition(0,0,jQuery("#" + modelEditorHandle).width(),0);
  this.maxEditorSize = new UmplePosition(
      0,
      0,
      jQuery(window).innerWidth() - 2*this.padding - jQuery("#" + paletteHandle).width() - Layout.minCanvasSize.width,
      0);
  
  var startupWidth = jQuery(window).width() - offsetLeft - this.padding;
  var startupHeight = jQuery(window).height() - offsetTop - this.padding;
  
  canvas.width(startupWidth);
  canvas.height(startupHeight);
}

// Initializes the text editor size
Layout.initUmpleTextAreaSize = function()
{
  var umpleTextEditor = jQuery("#" + modelEditorHandle);
  var umpleLayoutEditor = jQuery("#" + layoutEditorHandle);
  
  umpleTextEditor.resizable({
    stop: function(event, ui){Layout.umpleTextEditorResizing(event, ui);},
    autoHide: true,
    minWidth: this.minEditorSize.width,
    maxWidth: this.maxEditorSize.width,
    alsoResize: umpleLayoutEditor,
    handles:"e"});
  
  this.resizeCodeMirrorEditor(jQuery("#" + modelEditorHandle).height());
  umpleTextEditor.width(508);
  umpleLayoutEditor.width(508);
  
  this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery("#" + canvasHandle).width(), undefined);
}

///////////////////////////////////////////
// Functions to set sizes of UI elements //
///////////////////////////////////////////

Layout.setTextEditorSize = function(width, height) 
{
  var umpleTextEditor = jQuery("#" + modelEditorHandle);
  var umpleLayoutEditor = jQuery("#" + layoutEditorHandle);
  
  if(width == undefined) width = umpleTextEditor.width();
  if(height == undefined) height = this.calculateMainHeight();
  
  if(width < Layout.minEditorSize.width) 
  {
    width = Layout.minEditorSize.width;
  }
  
  umpleTextEditor.width(width);
  umpleTextEditor.height(height);
  umpleLayoutEditor.width(width);
  umpleLayoutEditor.height(height);

  if(this.isDiagramVisible)
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery("#" + canvasHandle).width(), undefined);
}

//Sets the size of the canvas. If either the height or width are undefined, they are unchanged.
Layout.setUmpleCanvasSize = function(width, height)
{
  var umpleCanvas = jQuery("#" + canvasHandle);
  
  //Note, the maxWidth is needed to stop the canvas from horizontally resizing beyond the window width, but ONLY if 
  //the resize buttons are used. The maxWidth stops the canvas from resizing nicely when disabling then enabling the 
  //text editor
  var maxWidth = jQuery(window).innerWidth() - 2*this.padding - this.minEditorSize.width 
    - jQuery("#" + paletteHandle).width();
  
  if(width == undefined) width = umpleCanvas.width();
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
  
  jQuery("#palette").height(height + 7);
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

////////////////////////////////////////////
// Functions to show and hide UI elements //
////////////////////////////////////////////

Layout.showHideLayoutEditor = function(doShow)
{
  var layoutEditor = jQuery("#" + layoutEditorHandle);
  var modelEditor = jQuery("#" + modelEditorHandle);
  var newHeight = jQuery("#" + canvasHandle).height();
   
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
  var modelEditor = jQuery("#" + modelEditorHandle);
  var layoutBox = jQuery("#buttonShowHideLayoutEditor");
  var layoutListItem = jQuery("#layoutListItem");
  var canvas = jQuery("#" + canvasHandle);
  
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
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + canvas.width(), undefined);
  if(this.isTextVisible)
    this.setTextEditorSize(this.calculateLeftoverWidth() + modelEditor.width(), undefined);
}

Layout.showHideCanvas = function(doShow)
{ 
  var canvas = jQuery("#" + canvasHandle);
  var modelEditor = jQuery("#" + modelEditorHandle);
  
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
    this.setUmpleCanvasSize(this.calculateLeftoverWidth() + canvas.width(), undefined);
  if(this.isTextVisible)
    this.setTextEditorSize(this.calculateLeftoverWidth() + modelEditor.width(), undefined);
}

Layout.resizeCodeMirrorEditor = function(newHeight) 
{
   Page.codeMirrorEditor.getWrapperElement().style.height=newHeight+"px";
   Page.codeMirrorEditor.refresh();
}

Layout.adjustTextEditorHeight = function(height) 
{  
  if (jQuery("#buttonShowHideLayoutEditor").attr('checked'))
  {
    jQuery("#" + modelEditorHandle).height(height*0.7 + 3);
    if(Page.codeMirrorOn) {
       this.resizeCodeMirrorEditor(height*0.7 + 3);
    }
    jQuery("#" + layoutEditorHandle).height(height*0.3);
  }
  else
  {
    jQuery("#" + modelEditorHandle).height(height + 6);
    if(Page.codeMirrorOn) {
       this.resizeCodeMirrorEditor(height + 6);
    }
  }
  jQuery("#" + modelEditorHandle).height(height + 6);
}

/////////////////////////////////////////
// Dynamic resizing handling functions //
/////////////////////////////////////////

Layout.mainApplicationHeightResizing = function(event, ui)
{
  var currentHeight = ui.size.height;
  
  this.setUmpleCanvasSize(jQuery("#" + canvasHandle).width(), currentHeight);
}

Layout.umpleTextEditorResizing = function(event, ui)
{
  var currentWidth = ui.size.width;
  
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
  var currentHeight = jQuery("#" + canvasHandle).height();
  var currentWidth = jQuery("#" + canvasHandle).width();
  
  var inc = 100;
  var newHeight=currentHeight + 0.25*inc*factor;
  var newWidth=currentWidth + inc*factor;
  
  this.setUmpleCanvasSize(newWidth, newHeight);
}

// A helper function to calculate the unused width of the page, depending on what is currently visible
Layout.calculateLeftoverWidth = function() 
{
  var width = jQuery(window).innerWidth() - 2*this.padding;
  if(this.isTextVisible) 
  {
    width -= jQuery("#" + modelEditorHandle).width();
  }
  if(this.isDiagramVisible)
  {
    width -= jQuery("#" + canvasHandle).width();
  }
  if(this.isPaletteVisible)
  {
    width -= jQuery("#" + paletteHandle).width();
  }
  return width;
}

// Helper function to calculate the height of the canvas, textEditor, and palette
Layout.calculateMainHeight = function() 
{
  return jQuery("#" + canvasHandle).height();
}