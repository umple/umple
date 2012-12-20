/**
 * Class: InlineEditor
 *
 * Version 0.1 (pending)
 *
 * License: Public Domain
 *
 *
 * User-overridable functions:
 * More documentation further down in code.
 *
 *    InlineEditor.customEditor      = function( theElement ) { ...
 *    InlineEditor.editorValue    = fuction( theEditor ) { ...
 *    InlineEditor.elementValue   = function( theElement ) { ...
 *    InlineEditor.elementChanged = function( theElement, oldVal, newVal ) { ...
 *
 *
 * Key CSS class names:
 *    editable:   Tables with this class will have their 'td' cells made editable.
 *    uneditable: At event time, cells with this class will NOT be editable.
 *    editing:    When editing, the 'td' element will have this class.
 *
 *
 * Useful utility functions:
 *
 *    InlineEditor.addClass( element, classname )
 *        Adds classname to the 'class' attribute of the element.
 *
 *    InlineEditor.removeClass( element, classname )
 *        Removes classname from the 'class' attribute of the element.
 *
 *    InlineEditor.checkClass( element, classname )
 *        True if class attribute of the element contains classname, false otherwise.
 *
 *    InlineEditor.swapClass( element, classname1, classname2 )
 *        Replaces classname1 with classname2 in class attribute of the element.
 *
 *     InlineEditor.columnNumer( cell )
 *        Returns column number of cell (zero index) or -1 if there are problems.
 *
 *     InlineEditor.rowNumer( cell )
 *        Returns row number of cell (zero index) or -1 if there are problems.
 *
 *     InlineEditor.rowID( cell )
 *        Returns row ID, useful if you use that to tie to a database primary key.
 *
 *
 * Change Log:
 *
 *    v0.1.1 - More reliable window.onload event adding. Added customEditor
 *             extensible function.
 *    v0.1 - Initial release.
 *
 *
 * Author:
 *
 *    Robert Harder
 *    rharder # users,sf,net
 */

/** Global var to test for IE */
var inlineeditor_isIE = ( navigator.userAgent.toLowerCase().search( 'msie' ) != -1 && navigator.userAgent.toLowerCase().search( 'opera' ) == -1 ) ? true : false;

var InlineEditor = {

/* ********  F U N C T I O N S   Y O U   M I G H T   C A L L  ******** */
    alreadyInited : false,  // In case we get called twice.

    /**
     * This should be called automatically when the page loads,
     * but if you also are setting up a function to run on
     * window.onload then this might get bumped out of position.
     * If that's the case, then make sure you call InlineEditor.init()
     * yourself.
     *
     * If you create some nodes programmatically, you can also rerun
     * this code to scan for "editable" classes. Like this:
     *
     * var foo document.createElement('div');
     * foo.className = 'editable';
     * ...
     * InlineEditor.init( foo );
     */
 /*   init: function( arg )
    {
        // What is the arg?
        var isNode  = false;
        var isEvent = false;
        if( arg.nodeType )
        {
            isNode = true;
        }
        
        // If we're already inited and we're not being asked to
        // init a new a node, bail out.
        if( !isNode && InlineEditor.alreadyInited )
        {
        	return;
        }
            
        // Find all elements with class 'editable' and make them editable
        jQuery("[class$='editable']").live('click', InlineEditor.handleOnClick);
                
        if( !isNode )
            InlineEditor.alreadyInited = true;
    },  // end init
*/


    addClass:    function(o,c)     { return InlineEditor.jscss('add',o,c); },
    removeClass: function(o,c)     { return InlineEditor.jscss('remove',o,c); },
    checkClass:  function(o,c)     { return InlineEditor.jscss('check',o,c); },
    swapClass:   function(o,c1,c2) { return InlineEditor.jscss('swap',o,c1,c2); },


    /**
     * Return the column number, if a table cell.
     */
 /*   columnNumber: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        // Find cell and return column number
        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr  = cell.parentNode;
        var tds = tr.getElementsByTagName('TD');
        for( var i = 0; i < tds.length; i++ )
            if( tds[i] == cell )
                return i;

        return -1;
    },  // end columnNumber
*/

    /**
     * Return the row number, based on the row's immediate
     * parent, which may be a 'tbody' or the actual 'table'.
     */
/*    rowNumber: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        // Find cell's parent row and return row number
        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr  = cell.parentNode;
        var trs = tr.parentNode.childNodes;
        for( var i = 0; i < trs.length; i++ )
            if( trs[i] == tr )
                return i;

        return -1;
    },  // end rowNumber
*/


    /**
     * Returns the ID of the parent row. Useful if you use
     * that to track the row to some sort of database primary key.
     */
 /*   rowID: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr = cell.parentNode;
        return tr.id;
    },  // end rowID


    sizeTo: function( changeMe, model )
    {
        changeMe.style.position = 'absolute';
        changeMe.style.zindex = 99;
        changeMe.style.left   = model .offsetLeft + 'px';
        changeMe.style.top    = model .offsetTop + 'px';
        changeMe.style.width  = model .offsetWidth + 'px';
        changeMe.style.height = model .offsetHeight + 'px';

        return changeMe;
    },  // end sizeTo
*/


/* ********  F U N C T I O N S   Y O U   M I G H T   O V E R R I D E  ******** */


    // These are examples of how you might override certain functions
    // if you want to add more complex behaviors.
    /*

...

your code

...
*/
    // The default editor is a one-line 'input' element.
    // If you need anything more complex like a textarea
    // or a select box or something, return it here.
    //
    // Remember to code the following:
    //
    //    - Set the editor's starting value
    //    - Set the editor's size
    //
    customEditor : function( theElement )
    {
		var editor = jQuery("<input/>");
		
		editor.attr("id", theElement.attr("id") +"_editor");
        editor.val(theElement.html() == "-- Add More --" ? "" : theElement.html());
        editor.width(theElement.parent().width() - 30);
        editor.height(theElement.offset().height);
        
        return editor;
    },   // end customEditor

/*
    // If you use a custom editor, you may need to provide a
    // way to determine what the value is. The default behavior,
    // which will still take over if you return nothing, is
    // to check for the presence of the 'value' property.
    // If your editor has no 'value' property then the 'innerHTML'
    // property is used. If this suits your needs
    // even with your custom editor, then there's no need to
    // use this function.
    //
    InlineEditor.editorValue = function( editor )
    {
        // Hypothetical editor with some obscure way
        // of determing what the user selection is.
        if( editor.tagName == 'SomeObscureControl' )
            return editor.squareRootOfSelectedMenuItem;     

    }   // end editorValue


...

    // If you have anything "funny" going on you're welcome
    // to define/override this function to determine just what
    // the starting value is. The default behavior, which will
    // be employed if you return nothing, is to use 'innerHTML'.
    InlineEditor.elementValue = function( theElement )
    {
        // Ignore the extra 'span' I threw in there. Just give me text.
        return theElement.innerText;

    }   // end elementValue



    // Unless you just want people to dink around with the
    // transient-by-nature current page, you'll probably want
    // to define/override this function and do something that
    // saves the user's changes. Here is an example using
    // "ajax" to immediately post a change. In this case,
    // I was using Google's Map APIs, so that's how I create
    // the HttpRequest.
    //
    InlineEditor.elementChanged = function( theElement, oldVal, newVal )
    {
        InlineEditor.addClass( theElement, 'uneditable' ); // Special InlineEditor class
        InlineEditor.addClass( theElement, 'saving' );     // My own class, maybe gray text

        var request = GXmlHttp.create(); // I was using Google's tools
        var url = "http://www.myserver.com/update.php?id=" + cell.id + "&val="+newVal;

        request.open("GET", url, true);
        request.onreadystatechange = function() {
            if (request.readyState == 4) {

                InlineEditor.removeClass( theElement, 'uneditable' );
                InlineEditor.removeClass( theElement, 'saving' );

            }   // end if: readystate 4
        };  // end onreadystatechange
        request.send(null);

    };  // end elementChanged




    */

/* ********  F U N C T I O N S   Y O U   S H O U L D   N O T   C A L L  ******** */

/*
    recursiveAddOnClickHandler: function( element )
    {
        //element.onclick = InlineEditor.handleOnClick;
        if (element.id) jQuery("#" + element.id).live("click", InlineEditor.handleOnClick);
        
        if( element.childNodes ){
            children = element.childNodes;
            for( i = 0; i < children.length; i++ ){
                if( children[i].onclick ){

                    InlineEditor.recursiveAddOnClickHandler( children[i] );

                }   // end if: child also needs handler
            }   // end for: each child
        }   // end if: children
    },   // end recursiveAddOnClickHandler
*/


    /**
     * Called when element is double-clicked.
     * At the time of this event, the class is checked to see
     * if the cell is marked 'uneditable'.
     */
    handleOnClick: function( evt )
    {
        var evt = InlineEditor.fixEvent( evt );
        var target = jQuery(InlineEditor.findEditableTarget( evt.target ));
		
		// If element is "uneditable" or "editing" don't edit.
        if (target.hasClass("uneditable") || target.hasClass("editing"))
        {
            return;
        }
        
        // Save original value.
        var oldHTML = target.html();
		var oldVal  = null;
        if( InlineEditor.elementValue ) // USER CAN PROVIDE OVERRIDE FUNCTION (WE DID NOT)
        {    
            oldVal = InlineEditor.elementValue( target );
        }
        if( !oldVal )
        {
            oldVal = target.html();
        }
        
        // Set up editor element
        // User overridable function
        var editor = null;
        if( InlineEditor.customEditor ){ // USER CAN PROVIDE OVERRIDE FUNCTION (WE DID NOT)
            editor = InlineEditor.customEditor( target );
        }   // end if: customEditor

        /*if( !editor ) { // If user didn't provide custom editor (WE DID)
          // Big? Make TEXTAREA.
            if( target.offsetHeight > 20  && target.innerHTML.length > 20 ){
                editor = document.createElement('textarea');
                editor.innerHTML = oldVal;
                editor.style.position = 'absolute';
                editor.style.zindex = 99;
                editor.style.left   = target.offsetLeft + 'px';
                editor.style.top    = target.offsetTop + 'px';
                editor.style.width  = target.offsetWidth + 'px';
                editor.style.height = target.offsetHeight + 'px';
            }   // end if: big
            else {
                editor = document.createElement('input');
                editor.value = oldVal;
                editor.style.position = 'absolute';
                editor.style.zindex = 99;
                editor.style.left   = target.offsetLeft + 'px';
                editor.style.top    = target.offsetTop + 'px';
                editor.style.width  = target.offsetWidth + 'px';
            }   // end else: use 'input'
        }*/   // end else: default

        // Listen for when focus is lost.
        editor.focusout(function(event){ InlineEditor.handleInputBlur( editor, oldVal, oldHTML );})
        editor.keypress(function(event)
        {
            var returnKey = 13;
        	if (event.which == returnKey)
        	{
        	  editor.blur();
        	  if (oldVal == "-- Add More --" && editor.val() != "")
        	  {
        	  	var nextEditorTargetId =  target.attr("id");
        	  	jQuery("#" + nextEditorTargetId).click();
        	  }
        	}
	    });
        
        // Prep target
        target.addClass("editing");

        // Add editor
        target.html("");
        target.append(editor);
        
        editor.focusin();
        editor.select();
        
        return false; // Don't propagate up. No need. Right?
    },   // end handleDoubleClick


    /**
     * Called when user is done editing the cell.
     */
    handleInputBlur: function( editor, oldVal, oldHTML )
    {
        // Gather values
        var parent = editor.parent();
        var newVal = null;
        
        if( InlineEditor.editorValue )
        {
            newVal = InlineEditor.editorValue( editor );
        }
        if( !newVal )
        {
            newVal = editor.val() == "" ? oldVal : editor.val();
        }
        
        // If nothing changed, bail out
        if( oldVal == newVal )
        {
            parent.html(oldHTML);
            parent.removeClass("editing");
            return;
        }   // end if: no change

        // Save value in the element
        parent.html(newVal);
        
        // If user wants to know of the change, pass it on.
        if( InlineEditor.elementChanged )
            InlineEditor.elementChanged( parent, oldVal, newVal );

    },   // end handleInputBlur


    /**
     * Thanks to http://www.onlinetools.org/articles/unobtrusivejavascript/cssjsseparation.html
     * for this bit of code.
     */
    jscss: function(a,o,c1,c2)
    {
        switch (a){
            case 'swap':
                o.className=!InlineEditor.jscss('check',o,c1) ?
                    o.className.replace(c2,c1) :
                    o.className.replace(c1,c2);
                break;
            case 'add':
                if(!InlineEditor.jscss('check',o,c1)){o.className+=o.className?' '+c1:c1;}
                break;
            case 'remove':
                var rep=o.className.match(' '+c1)?' '+c1:c1;
                o.className=o.className.replace(rep,'');
                break;
            case 'check':
                return new RegExp('\\b'+c1+'\\b').test(o.className)
                break;
        }   // end switch: action
    },  // end jscss


    fixEvent: function( evt )
    {
        var E = evt ? evt : window.event; // 'event' seems to be a special word in IE, so I'm using 'E' instead.
        if( E.target )
            if( E.target.nodeType == 3 )
                E.target = E.target.parentNode;

        //make sure Opera doesn't set this object
        if( inlineeditor_isIE )
            if( E.srcElement )
                E.target = E.srcElement;

        return E;
    },   // end fixEvent


    findEditableTarget: function( target )
    {
        // If a table cell, we assume that's editable
        if( target.nodeType == 1 && target.tagName == 'TD' )
            return target;

        if( InlineEditor.checkClass( target, 'editable' ) )
            return target;

        if( target.parentNode )
            return InlineEditor.findEditableTarget( target.parentNode );

        return null;
    },  // end findEditableTarget


    addEvent: function( target, eventName, func, capture )
    {
        if( target.addEventListener ){
            target.addEventListener( eventName, func, capture );
            return true;
        }   // end if: addEventListener
        else if( target.attachEvent )
            return target.attachEvent( 'on'+eventName, func );
    },  // end addEvent


    removeEvent: function( target, eventName, func, capture )
    {
        if( target.removeEventListener ){
            target.removeEventListener( eventName, func, capture );
            return true;
        }   // end if: removeEventListener
        else if( target.detachEvent )
            return target.detachEvent( 'on'+eventName, func );
    }   // end removeEvent

}   // end class InlineEditor

/**
 * Add InlineEditor.init() to window.onload.
 */
//InlineEditor.addEvent(window,'load',InlineEditor.init,false);