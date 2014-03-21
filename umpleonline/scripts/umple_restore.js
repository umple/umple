// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
jQuery(document).ready(function(){
    
  var name = "filecode=";
  var view = "view=";
  var diagram = "diagram=";
  var preferences = "pref=";
  
  //Split the cookie to different values
  var ca = document.cookie.split(';');  
  //Order of filecode, view, diagram, and preferences
  var filepath = null;
  
  //Hide the restore link
  jQuery('#restorecode').hide();
  
  //Find the values in the cookie and store them in the variables
  for(var i=0; i<ca.length; i++) 
  {
      var c = ca[i].trim();
      if (c.indexOf(name)==0)
      {
        filepath = c.substring(name.length,c.length);
      }
      else if (c.indexOf(view)==0)
      {
        view = c.substring(view.length,c.length);
      }
      else if (c.indexOf(diagram)==0)
      {
        diagram = c.substring(diagram.length,c.length);
      }
      else if (c.indexOf(preferences)==0)
      {
        preferences = c.substring(preferences.length,c.length);
      }
  }
  //If the filepath is found in the cookie
  if(filepath != null && filepath.length != 0)
  {
    //Display the link for a minute
    jQuery('#restorecode').show();

    setTimeout(function() {
  jQuery('#restorecode').hide();
},30000);
    
    //Activate the link button
    jQuery('#restorecode').click(function(){
      //Load Umple Code
      jQuery('#restorecode').hide();
      Page.setFilename(filepath);
      Action.loadFile();
      
      //Set the user preference by finding letters in the values
      
      //View Attributes
      if(view.indexOf("d") != -1)
      {
        if(!jQuery("#buttonShowHideTextEditor").attr("checked"))
        {
          jQuery("#buttonShowHideTextEditor").trigger('click');
        }
      }      
      if(view.indexOf("t") != -1)
      {
        if(!jQuery("#buttonShowHideTextEditor").attr("checked"))
        {
          jQuery('#buttonShowHideTextEditor').trigger('click');
        }
      }
      if(view.indexOf("l") != -1)
      {
        if(!jQuery("#buttonShowHideLayoutEditor").attr("checked"))
        {
          jQuery('#buttonShowHideLayoutEditor').trigger('click');
        }
      }
      if(view.indexOf("a") != -1)
      {
        if(!jQuery("#buttonToggleAttributes").attr("checked"))
        {
          jQuery('#buttonToggleAttributes').trigger('click');
        }
      }        
      if(view.indexOf("m") != -1)
      {
        if(!jQuery("#buttonToggleMethods").attr("checked"))
        {
          jQuery('#buttonToggleMethods').trigger('click');
        }
      }      
      
      //Diagram Type
      if(diagram.indexOf("e") != -1)
      {
        if(!jQuery("#buttonShowEditableClassDiagram").attr("checked"))
        {
          jQuery("#buttonShowEditableClassDiagram").trigger('click');
        }
      }      
      else if(diagram.indexOf("c") != -1)
      {
        if(!jQuery("#buttonShowGvClassDiagram").attr("checked"))
        {
          jQuery('#buttonShowGvClassDiagram').trigger('click');
        }
      }
      else if(diagram.indexOf("s") != -1)
      {
        if(!jQuery("#buttonShowGvStateDiagram").attr("checked"))
        {
          jQuery('#buttonShowGvStateDiagram').trigger('click');
        }
      }
      
      //Preferences
      if(preferences.indexOf("p") != -1)
      {
        if(!jQuery("#buttonPhotoReady").attr("checked"))
        {
          jQuery('#buttonPhotoReady').trigger('click');
        }
      }        
      if(preferences.indexOf("s") != -1)
      {
        if(!jQuery("#buttonManualSync").attr("checked"))
        {
          jQuery('#buttonManualSync').trigger('click');
        }
      }  
    });
  }
});


//This is activated when the user closes/refreshes the page
window.onbeforeunload = function(event) {
  //Get Expiration datetime
    var date = new Date();
    date.setTime(date.getTime()+(30*24*60*60*1000));
  
  //If the umple code is not blank, save the model.
  if(!(Page.getUmpleCode() === "//$?[End_of_model]$?"))
  {
    //First store the filename of the Umple Code
    document.cookie =  "filecode=" + Page.getFilename() + ";" + "expires="+date.toGMTString() + ";";
    
    //These were settings the user set
    //Used single letter to save space
    //Show View
    cookie_view = "view=";
    if(jQuery("#buttonShowHideCanvas").attr("checked"))
      cookie_view += "d";
    if(jQuery("#buttonShowHideTextEditor").attr("checked"))
      cookie_view += "t";
    if(jQuery("#buttonShowHideLayoutEditor").attr("checked"))
      cookie_view += "l";
    if(jQuery("#buttonToggleAttributes").attr("checked"))
      cookie_view += "a";
    if(jQuery("#buttonToggleMethods").attr("checked"))
      cookie_view += "m"
    cookie_view += ";" + "expires="+date.toGMTString() + ";";    
    document.cookie = cookie_view;
      
    //Diagram Type
    cookie_diagram = "diagram=";
    if(jQuery("#buttonShowEditableClassDiagram").attr("checked"))
      cookie_diagram += "e";
    else if(jQuery("#buttonShowGvClassDiagram").attr("checked"))
      cookie_diagram += "c";
    else if(jQuery("#buttonShowGvStateDiagram").attr("checked"))
      cookie_diagram += "s";      
    cookie_diagram += ";" + "expires="+date.toGMTString() + ";";  
    document.cookie = cookie_diagram;
              
    //Preferences
    cookie_pref = "pref=";
    if(jQuery("#buttonPhotoReady").attr("checked"))
      cookie_pref += "p";
    if(jQuery("#buttonManualSync").attr("checked"))
      cookie_pref += "s";
    cookie_pref += ";" + "expires="+date.toGMTString() + ";";    
    document.cookie = cookie_pref;
        
  }
  
};