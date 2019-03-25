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

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/chatbot.js"></script>    
    </head>

    <body>
        <h1 style="font-family: sans-serif;">Chatbot</h1>
        
        <input type="button" onclick="debug4()" value="debug" id="debug"/>
        <input type="button" onclick="callChatbot('Hey, how are you?')" value="callChatbot" id="callChatbot"/>
 
        <div id="chathistory"></div>

        <div>
            <input type="text" id="userinput"/>
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






