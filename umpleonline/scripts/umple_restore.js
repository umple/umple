// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
jQuery(document).ready(function(){
    
  var name = "filecode=";
  var view = "VIEW=";
  var diagram = "DIAGRAM=";
  var preferences = "PREF=";
  
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
      else if (c.indexOf(preferences)!=-1)
      {
        preferences = c.substring(preferences.length,c.length);
      }
  }
  
  if(preferences.indexOf("g") != -1) // Found g so hide gdpr
  {
    Action.hidegdpr();
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
      if(view.indexOf("d") != -1)  // found d so show diagram if needed
      {
        if(!jQuery("#buttonShowHideCanvas").prop("checked"))
        {
          jQuery("#buttonShowHideCanvas").trigger('click');
        }
      }
      else // did NOT find d so hide diagram if needed
      {
        if(jQuery("#buttonShowHideCanvas").prop("checked"))
        {
          jQuery("#buttonShowHideCanvas").trigger('click');
        }      
      }
      
      if(view.indexOf("t") != -1) // found t so show text if needed
      {
        if(!jQuery("#buttonShowHideTextEditor").prop("checked"))
        {
          jQuery('#buttonShowHideTextEditor').trigger('click');
        }
      }
      else // did NOT find t so hide text if needed
      {
        if(jQuery("#buttonShowHideTextEditor").prop("checked"))
        {
          jQuery('#buttonShowHideTextEditor').trigger('click');
        }      
      }
      
      if(view.indexOf("l") != -1) // found l so show layout editor if needed
      {
        if(!jQuery("#buttonShowHideLayoutEditor").prop("checked"))
        {
          jQuery('#buttonShowHideLayoutEditor').trigger('click');
        }
      }
      else // did NOT find l so hide layout editor if needed
      {
        if(jQuery("#buttonShowHideLayoutEditor").prop("checked"))
        {
          jQuery('#buttonShowHideLayoutEditor').trigger('click');
        }      
      }
      
      if(view.indexOf("a") != -1) // found a so show layout editor if needed
      {
        if(!jQuery("#buttonToggleAttributes").prop("checked"))
        {
          jQuery('#buttonToggleAttributes').trigger('click');
        }
      }
      else // did NOT find a so hide attributes if needed
      {
        if(jQuery("#buttonToggleAttributes").prop("checked"))
        {
          jQuery('#buttonToggleAttributes').trigger('click');
        }
      }
      
      if(view.indexOf("m") != -1) // found m so show methods if needed
      {
        if(!jQuery("#buttonToggleMethods").prop("checked"))
        {
          jQuery('#buttonToggleMethods').trigger('click');
        }
      }
      else // did NOT find m so hide methods if needed
      {
        if(jQuery("#buttonToggleMethods").prop("checked"))
        {
          jQuery('#buttonToggleMethods').trigger('click');
        }      
      }
      
      //Diagram Type
      if(diagram.indexOf("e") != -1)
      {
        if(!jQuery("#buttonShowEditableClassDiagram").prop("checked"))
        {
          jQuery("#buttonShowEditableClassDiagram").trigger('click');
        }
      }      
      else if(diagram.indexOf("c") != -1)
      {
        if(!jQuery("#buttonShowGvClassDiagram").prop("checked"))
        {
          jQuery('#buttonShowGvClassDiagram').trigger('click');
        }
      }
      else if(diagram.indexOf("s") != -1)
      {
        if(!jQuery("#buttonShowGvStateDiagram").prop("checked"))
        {
          jQuery('#buttonShowGvStateDiagram').trigger('click');
        }
      }
      
      //Preferences
      if(preferences.indexOf("p") != -1) // Found p so make photo ready if needed
      {
        if(!jQuery("#buttonPhotoReady").prop("checked"))
        {
          jQuery('#buttonPhotoReady').trigger('click');
        }
      }
      else // did NOT find p so make non-photo ready if needed
      {
        if(jQuery("#buttonPhotoReady").prop("checked"))
        {
          jQuery('#buttonPhotoReady').trigger('click');
        }      
      }
      
      if(preferences.indexOf("s") != -1) // Found s so make manual sync if needed
      {
        if(!jQuery("#buttonManualSync").prop("checked"))
        {
          jQuery('#buttonManualSync').trigger('click');
        }
      }
      else // did NOT find s so get rid of manual sync if needed
      {
        if(jQuery("#buttonManualSync").prop("checked"))
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
    cookie_view = "VIEW=";
    if(jQuery("#buttonShowHideCanvas").prop("checked"))
      cookie_view += "d";
    if(jQuery("#buttonShowHideTextEditor").prop("checked"))
      cookie_view += "t";
    if(jQuery("#buttonShowHideLayoutEditor").prop("checked"))
      cookie_view += "l";
    if(jQuery("#buttonToggleAttributes").prop("checked"))
      cookie_view += "a";
    if(jQuery("#buttonToggleMethods").prop("checked"))
      cookie_view += "m"
    if(jQuery("#buttonToggleTransitionLabel").prop("checked"))
      cookie_view += "r";
    if(jQuery("#buttonToggleGuardLabel").prop("checked"))
      cookie_view += "g";
    cookie_view += ";" + "expires="+date.toGMTString() + ";";    
    document.cookie = cookie_view;
      
    //Diagram Type
    cookie_diagram = "DIAGRAM=";
    if(jQuery("#buttonShowEditableClassDiagram").prop("checked"))
      cookie_diagram += "e";
    else if(jQuery("#buttonShowGvClassDiagram").prop("checked"))
      cookie_diagram += "c";
    else if(jQuery("#buttonShowGvStateDiagram").prop("checked"))
      cookie_diagram += "s";      
    cookie_diagram += ";" + "expires="+date.toGMTString() + ";";  
    document.cookie = cookie_diagram;        
  }
                
  //Preferences
  cookie_pref = "PREF=";
  if(Action.gdprHidden)
    cookie_pref += "g";
  if(jQuery("#buttonPhotoReady").prop("checked"))
    cookie_pref += "p";
  if(jQuery("#buttonManualSync").prop("checked"))
    cookie_pref += "s";
  cookie_pref += ";" + "expires="+date.toGMTString() + ";";    
  document.cookie = cookie_pref;
};
