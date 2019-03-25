// Example 1: sets up service wrapper, sends initial message, and receives response.

//var prompt = require('prompt-sync')();
var AssistantV2 = require('watson-developer-cloud/assistant/v2');
const http = require('http');
const querystring = require('querystring');
const fs = require('fs');

const secrets = JSON.parse(fs.readFileSync('secrets.json')); 

var userInput = '';
var watsonJson = {};

// Set up Assistant service wrapper.
var service = new AssistantV2({
  iam_apikey: secrets.iam_apikey,
  version: '2018-09-20'
});

var assistantId = secrets.assistantId;
var sessionId;

// Create session.
service.createSession({
  assistant_id: assistantId
}, function(err, result) {
  if (err) {
    console.error(err); // something went wrong
    return;
  }
  sessionId = result.session_id;
  sendMessage(''); // start conversation with empty message
});

var server = http.createServer((request, response) => {
  const { headers, method, url } = request;
  let body = [];
  console.log('Called index.js \n');
  response.setHeader("Access-Control-Allow-Origin", "*");

  request.on('data', (info) => {
    body.push(info);
  }).on('end', () => {
    body = Buffer.concat(body).toString(); 
    //console.log("\nBody: " + typeof(body) + "\n" + decodeURIComponent(body.replace(/\+/g, " ")));
    const qs = querystring.parse(body);
    userInput = qs.input;
    console.log(userInput);
    sendMessage(userInput);

    response.on('error', (err) => { console.error(err); });
    response.statusCode = 200;
    response.setHeader('Content-Type', 'application/json');

    const responseBody = { headers, method, url, body };

    //response.write(JSON.stringify(responseBody));

    console.log(JSON.stringify(watsonJson) + "\n");
    response.write(JSON.stringify(watsonJson));
    response.end();
  });
}).listen(8002);

// Send message to assistant.
function sendMessage(messageText) {
  if (messageText === '.exit') return;
  service.message({
    assistant_id: assistantId,
    session_id: sessionId,
    input: {
      message_type: 'text',
      text: messageText
    }
  }, processResponse);
}

// Process the response.
function processResponse(err, response) {
  result = '';
  if (err) {
    console.error(err); // something went wrong
    return;
  }

  var endConversation = false;

  // Check for client actions requested by the assistant.
  if (response.output.actions) {
    if (response.output.actions[0].type === 'client'){
      if (response.output.actions[0].name === 'display_time') {
        watsonJson = response;
      } else if (response.output.actions[0].name === 'end_conversation') {
        watsonJson = response;
        endConversation = true;
      }
    }
  } else {
    // Display the output from assistant, if any. Assumes a single text response.
    if (response.output.generic.length != 0) {
      watsonJson = response;
    }
  }

  // If we're not done, prompt for the next round of input.
  if (!endConversation) {
    var newMessageFromUser = userInput;
    sendMessage(newMessageFromUser);
  } else {
    service.deleteSession({
      assistant_id: assistantId,
      session_id: sessionId
    }, function(err, result) {
      if (err) {
        console.error(err); // something went wrong
      }
    });
    return;
  }
}

