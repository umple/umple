<?php header('X-Frame-Options: ALLOWALL'); ?>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Test webpage for chatbot</title>
        <meta name="description" content="">
        <style>
            .bubble {
                padding: 10px;
                margin: 10px 0;
                font-family: Arial, sans-serif
            }
            
            .usermsg {
                border: 2px solid #00ff00;
                background-color: #ccffcc;
            }
            
            .chatbot {
                border: 2px solid #004d99;
                background-color: #ccf5ff;
            }
        </style>
        
        <script type="text/javascript" src="./scripts/umple_action.js">
          
        </script>
        
        <script src="./scripts/jquery/jquery-2.2.4.min.js"></script>
        
        <script type="text/javascript">
                    
            function hello(x) {
              alert(x);
            }

            function addMessage() {
              var userInput = document.getElementById('userinput').value;
              if (userInput == '') return;
              
              document.getElementById('chathistory').innerHTML += 
                  ('<div class="bubble usermsg">' + userInput + '</div>');
              document.getElementById('userinput').value = ""
              
              // TODO Actually call chatbot
              wait(400);
              chatbotReply();

              window.scrollTo(0, document.body.scrollHeight);
            }

            function chatbotReply() {
                document.getElementById('chathistory').innerHTML += 
                    ('<div class="bubble chatbot"><b>Chatbot:</b> I will reply once I am implemented :)</div>');
                window.scrollTo(0, document.body.scrollHeight);
            }

            function callChatbot(userInput) {
              var xhttp = new XMLHttpRequest();
              var reply = "No reply received."
              xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById('chathistory').innerHTML += ('<div> <h2>' + 
                            reply + '</h2> </div>');
                }
              };
              xhttp.open("GET", "ajax_info.txt", true);
              xhttp.send();
            }

            function callJava() {
                // Something like this
                executeCommand("java -jar umplesync.jar -addClass ...");
            }

            function wait(ms){
               var start = new Date().getTime();
               var end = start;
               while(end < start + ms) {
                 end = new Date().getTime();
              }
            }

            function debug2() {
              // This is what happens when a new class is called
              Action.ajax(
                  function(a) {
                    var c="";
                    var b="";
                    c = Action.getDiagramCode(a.responseText);
                    b = Action.getErrorCode(a.responseText);
                    if ((c==null||c==""||c=="null")&&Action.diagramInSync) {
                      Page.enableDiagram(false);
                      Action.diagramInSync=false;
                      Page.setFeedbackMessage('<a href="#errorClick">See message.</a> To fix: edit model or click undo')
                    } else {
                      Page.enableDiagram(true);
                      Action.diagramInSync=true
                    }
                    if(b!="") {
                      Page.showGeneratedCode(b,"diagramUpdate")
                    }
                  }
                  , 
                  language=Json
              );
            }

            function debug3() {
              /*jQuery.getScript("./scripts/umple_action.js", function() {
			    console.log("typeof Action: " + typeof Action);
      			Action.ajax(DiagramEdit.addClass(0););
			  });*/
              jQuery.getScript("./scripts/umple_system.js", function() {
                console.log(UmpleSystem);
			    jQuery.getScript("./scripts/umple_class.js", function() {
				  console.log(UmpleClass);
  				  jQuery.getScript("./scripts/umple_action_diagram.js", function() {
  				    jQuery.getScript("./scripts/umple_action.js", function() {
  				      console.log(typeof Action);
  				      //console.log(textstatus);
    			      //Action.ajax(DiagramEdit.addClass(0));

  				      Action.ajax(Action.updateFromDiagramCallback,Action.getLanguage());
                    });
  				  });
			 	});
	          });
        		  
            }

            function debug3_old() {
              var umpleSystem;
              var umpleClass;
              var diagramEdit;
				
              
				// addClass using DiagramEdit.addClass
				
				jQuery.getScript("./scripts/umple_system.js", function(UmpleSystem, textstatus, jqxhr) {
				  console.log("typeof UmpleSystem: " + typeof UmpleSystem);
				  umpleSystem = UmpleSystem;
				  console.log("umpleSystem: " + umpleSystem);
				  console.log("\n\ntextstatus: " + textstatus);
				  console.log("\n\njqxhr: " + jqxhr);
				});

				jQuery.getScript("./scripts/umple_class.js", function(UmpleClass, textstatus, jqxhr) {
				  umpleClass = UmpleClass;
				  console.log("umpleClass: " + umpleClass);
				  console.log("\n\ntextstatus: " + textstatus);
				  console.log("\n\njqxhr: " + jqxhr);
				});

				//wait(500);
				

			  jQuery.getScript("./scripts/umple_action_diagram.js", function(/*DiagramEdit, textstatus, jqxhr*/) {
			    console.log("typeof DiagramEdit: " + typeof DiagramEdit);

			    //console.log("uc ctor: \n" + umpleClass.constructor);
			    //console.log(textstatus);
			    UmpleSystem = umpleSystem;
			    UmpleClass = umpleClass;
			    
		        DiagramEdit.addClass(0);
              });

				
				/*jQuery.getScript("./scripts/umple_system.js", function() {
				    jQuery.getScript("./scripts/umple_class.js", function() {
    				  jQuery.getScript("./scripts/umple_action_diagram.js", function(DiagramEdit, textstatus, jqxhr) {
    				    console.log(typeof DiagramEdit);
    				    console.log(textstatus);
    				    
      			        DiagramEdit.addClass(0);
                      });
					});
		       });*/

              /*jQuery.when(
                  jQuery.getScript( "./scripts/umple_system.js" ),
                  jQuery.getScript( "./scripts/umple_class.js" ),
                  jQuery.getScript("./scripts/umple_action_diagram.js" ),
                  jQuery.getScript("./scripts/umple_action.js" ),
                  jQuery.Deferred(function( deferred ){
                    jQuery( deferred.resolve );
                  })
              ).done(function(data, textstatus, jqxhr){
				console.log(data);
                //Action.ajax(DiagramEdit.addClass(0));
                console.log("After");
              }).fail(function(){
                console.error("Error !!!!!!!! :(")
              });*/
            }
        </script>
        
    </head>
    <body>
        <h1 style="font-family: sans-serif;">Chatbot</h1>
        
        <input type="button" onclick="debug3()" value="debug" id="debug"></input>
        
       
        <div id="chathistory">
        
        </div>

        <div>
            <input type="text" id="userinput"></input>
            <input 
              type="button" 
              onclick='addMessage()' 
              value="Send" 
              id="sendbutton"
            />
            <!-- Hit Enter to Send -->
            <script type="text/javascript">
                var input = document.getElementById("userinput");
                input.addEventListener("keyup", function(event) {
                  event.preventDefault();
                  if (event.keyCode === 13) { // ENTER
                    document.getElementById("sendbutton").click();
                  }
                });
            </script>
        </div>
        
    </body>
</html>






