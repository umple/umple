var jsonResponse;
var intent;

const defaultClassPositions = [[ 50,  50], [250,  50], [450,  50],
                               [ 50, 200], [250, 200], [450, 200],
                               [ 50, 350], [250, 350], [450, 350],
                               [ 50, 500], [250, 500], [450, 500]];
var numClasses = 0;

function addMessage() {
  var userInput = document.getElementById('userinput').value;
  if (userInput == '') return;

  document.getElementById('chathistory').innerHTML +=
    ('<div class="bubble usermsg">' + userInput + '</div>');
  document.getElementById('userinput').value = ""

  callChatbot(userInput);

  window.scrollTo(0, document.body.scrollHeight);
}

function chatbotReply(response) {
  if (response) {
    document.getElementById('chathistory').innerHTML +=
      ('<div class="bubble chatbot"><b>Chatbot:</b> ' + response + '</div>');
  } else {
    document.getElementById('chathistory').innerHTML +=
      ('<div class="bubble chatbot"><b>Chatbot:</b>Sorry, I didn\'t get that, can you rephrase? :)</div>');
  }
  window.scrollTo(0, document.body.scrollHeight);
}

function chatbotAction() {
  intent = jsonResponse.output.intents[0].intent;
  console.log(jsonResponse);

  const action = {
    'Create_Class': addClass,
    // TODO Add all the other intents here
  };

  action[intent]();
}

function callChatbot(userInput) {
  $(document).ready(function() {
    var jqueryXHR = $.ajax({
      type: 'POST',
      url: 'http://localhost:8002/watson/index.js',
      dataType: 'json',
      data: {
        'param': '0',
        'input': userInput
      },
    });
    console.log(userInput);
    jqueryXHR.always(function(resp) {
      jsonResponse = resp;
      chatbotAction();
      chatbotReply(jsonResponse.output.generic[0].text);
    });
  });
}

function wait(ms) {
  var start = new Date().getTime();
  var end = start;
  while (end < start + ms) {
    end = new Date().getTime();
  }
}

function addClass() {
  const className = jsonResponse.output.entities[0].value || 'NewClass';
  window.parent.Action.directAddClass(className, defaultClassPositions[numClasses]);
  numClasses++;
}

function debug4() {
  window.parent.Action.directAddClass("Pizza", ['500', '750']);
}