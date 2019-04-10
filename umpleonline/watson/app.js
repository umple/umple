/** Umple NLU USING ASSIST V1
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';

require('dotenv').config({ silent: true });

var AssistantV1 = require('watson-developer-cloud/assistant/v1');  // watson assistant sdk
var http = require('http');
const querystring = require('querystring');

// Ensure NLU is not confused by sending it this exact string
var firstMessage = 'hello, how can you?';
var userInput = firstMessage;
var watsonJson = null;
var globalResponse = null;

var conversation;
var NaturalLanguageUnderstandingV1;
var nlu;
var features;

var debug = false;

// Ctrl-C to close
process.on('SIGINT', function() {
  process.exit();
});

if (process.argv.length > 2 && process.argv[2] === '-debug') {
  console.log('Running in debug mode...');
  debug = true;
}

if (!debug) {
  // Create the service wrapper
  // Set up Assistant service wrapper.
  conversation = new AssistantV1({
    version: '2018-09-20',
    iam_apikey: process.env.CONVERSATION_USERNAME || '<username>',
    url: process.env.CONVERSATION_PASSWORD || '<password>'
  });

  // Create service wrapper for Natural Language Understanding
  NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');

  nlu = new NaturalLanguageUnderstandingV1({
    version: '2018-11-16',
    iam_apikey: process.env.NATURAL_LANGUAGE_UNDERSTANDING_USERNAME || '<username>',
    url: process.env.NATURAL_LANGUAGE_UNDERSTANDING_PASSWORD || '<password>'
  });


  // Define what features you want to extract with NLU
  // In this case, we're interested in entities and relations
  features = {
    categories: {
      limit: 3
    },
    entities: {
      mentions: true,
      model: '0af23d03-3b2d-4407-b61e-3d1c63f5e99a'
    },
    relations: {
      model: '0af23d03-3b2d-4407-b61e-3d1c63f5e99a'   
    }
  };
}

// Endpoint to be called from the client side
function callWatson(callback) {
  var workspace = process.env.WORKSPACE_ID || '<workspace-id>';
  if (!workspace || workspace === '<workspace-id>') {
    return Error("Bad Workspace ID.");
  }
  var payload = {
    workspace_id: workspace,
    context: {},
    input: {}
  };
  var params = null;
  payload.input.text = userInput;
  payload.input.type = 'text';
  params = { text: userInput, features: features };

  // TODO Must maintain context/state for more complex back-and-forth conversations

  if (params == null) {
    params = { text: firstMessage, features: features }
  }

  nlu.analyze(params, function (error, response) {
    if (error) {
      return error;
    }
    if (response != null) {
      //if response not null, save entities detected by nlu as variable entities
      var entities = response.entities;
      var containerList = entities.map(function (entry) {
        if (entry.type == "container_ent") {
          return (entry.text);
        }
      });
      containerList = containerList.filter(function (entry) {
        if (entry != null) {
          return (entry);
        }
      });
      if (containerList.length > 0) {
        payload.context.varContainer = containerList[0];
      } else {
        payload.context.varContainer = null;
      }
      var partList = entities.map(function (entry) {
        if (entry.type == "part_ent") {
          return (entry.text);
        }
      });

      partList = partList.filter(function (entry) {
        if (entry != null) {
          return (entry);
        }
      });
      if (partList.length > 0) {
        payload.context.varPart = partList[0];
      } else {
        payload.context.varPart = null;
      }

      //Parent
      var parentList = entities.map(function (entry) {
        if (entry.type == "parent_ent") {
          return (entry.text);
        }
      });

      parentList = parentList.filter(function (entry) {
        if (entry != null) {
          return (entry);
        }
      });
      if (parentList.length > 0) {
        payload.context.varParent = parentList[0];
      } else {
        payload.context.varParent = null;
      }

      //Child
      var childList = entities.map(function (entry) {
        if (entry.type == "child_ent") {
          return (entry.text);
        }
      });

      childList = childList.filter(function (entry) {
        if (entry != null) {
          return (entry);
        }
      });
      if (childList.length > 0) {
        payload.context.varChild = childList[0];
      } else {
        payload.context.varChild = null;
      }

    } else {
      if (payload.context.varContainer) {
        payload.context.varContainer = null;
      }
      if (payload.context.varPart) {
        payload.context.varPart = null;
      }
      if (payload.context.varChid) {
        payload.context.varChild = null;
      }
      if (payload.context.varParent) {
        payload.context.varParent = null;
      }
      console.log('response from NLU entity extraction is null');
    }
    // Send the input to the conversation service
    conversation.message(payload, function (err, data) {
      if (err) {
        return err;
      }
      watsonJson = data;
      //console.log(watsonJson);
      
      callback();
      
      return watsonJson;
    });
    return watsonJson;
  });

  console.log("callWatson() returned");
  return watsonJson;
}

// call Watson once to initialize it
if (!debug) callWatson(() => {});

var server = http.createServer((request, response) => {
  globalResponse = response;
  const { headers, method, url } = request;
  let body = [];
  console.log('Called app.js \n');
  response.setHeader("Access-Control-Allow-Origin", "*");

  request.on('data', (info) => {
    body.push(info);
  }).on('end', () => {
    body = Buffer.concat(body).toString(); 
    const qs = querystring.parse(body);
    userInput = qs.input;
    console.log(userInput);

    response.on('error', (err) => { console.error(err); });
    response.statusCode = 200;
    response.setHeader('Content-Type', 'application/json');

    if (!debug && !userInput.includes('has a')) {
      callWatson(() => {
        if (!(((watsonJson||{}).intents||[])[0]||{}).intent) {
          processResponseDebug();
        }
        writeResponse();
      });
    } else {
      processResponseDebug();
      writeResponse();
    }

  });
}).listen(8002);

function writeResponse() {
  console.log('writeResponse():');
  console.log(watsonJson);
  globalResponse.write(JSON.stringify(watsonJson));
  globalResponse.end();
}

/**
 * Debug function used to reply with canned responses in order to avoid unneeded API calls to Watson.
 * It is also used as a backup when Watson does not understand user input, eg for functionality not yet implemented.
 * This function assumes valid input.
 */
function processResponseDebug() {
  console.log('Processing request in debug mode');
  var messageText = userInput.toLowerCase();
  var words = messageText.split(' ');
  if (messageText.includes('create a')) { // supports a/an
    for (var i = 0; i < words.length - 2; i++) {
      if (words[i] === 'create') {
        // strip punctuation
        var className = firstLetterUppercase(words[i + 2].replace(/[^\w\s]|_/g, "").replace(/\s+/g, " "));
        watsonJson = { 
          intents: [{intent: 'create_class'}],
          entities: [{value: className}],
          output: {text: ['I created a class called ' + className + '.']}
        };
      }
    }
    return;
  }

  if (messageText.includes('has a')) {
    for (var i = 0; i < words.length - 2; i++) {
      if (words[i] === 'has') {
        var className = firstLetterUppercase(words[i - 1]);
        var attributeName = words[i + 2].replace(/[^\w\s]|_/g, "").replace(/\s+/g, " ");
        watsonJson = {
          intents: [{intent: 'add_attribute'}],
          entities: [{value: className}, {value: attributeName}],
          output: [{text: className + ' now has the attribute ' + attributeName + '.'}]
        };
      }
    }
    return;
  }

  if (messageText.includes('is composed of')) {
    for (var i = 0; i < words.length - 3; i++) {
      if (words[i] === 'is') {
        var wholeClassName = firstLetterUppercase(words[i - 1]);
        var partClassName = firstLetterUppercase(words[i + 3].replace(/[^\w\s]|_/g, "").replace(/\s+/g, " "));
        // assume the plural when partClassName ends with s
        if (partClassName.substr(-1) === 's') {
          partClassName = partClassName.slice(0, -1);
        }
        watsonJson = {
          intents: [{intent: 'create_composition'}],
          entities: [{value: wholeClassName}, {value: partClassName}],
          output: {text: [wholeClassName + ' is now composed of ' + partClassName + '.']},
          context: {varContainer: wholeClassName, varPart: partClassName}
        };
      }
    }
    return;
  }

  // not very useful, but good for testing
  if (messageText.includes('is associated with')) {
    for (var i = 0; i < words.length - 3; i++) {
      if (words[i] === 'is') {
        var className1 = firstLetterUppercase(words[i - 1]);
        var className2 = '';
        if (words[i + 3] === 'a') { 
          className2 = words[i + 4]; 
        } else {
          className2 = words[i + 3];
        }
        className2 = firstLetterUppercase(className2.replace(/[^\w\s]|_/g, "").replace(/\s+/g, " "));
        watsonJson = {
          intents: [{intent: 'create_association'}],
          entities: [{value: className1}, {value: className2}],
          output: [{text: 'A ' + className1 + ' has many ' + className2 + 's.'}]
        };
      }
    }
    return;
  }

  if (messageText.includes('is a')) {
    for (var i = 0; i < words.length - 2; i++) {
      if (words[i] === 'is') {
        var childClassName = firstLetterUppercase(words[i - 1]);
        var parentClassName = firstLetterUppercase(words[i + 2].replace(/[^\w\s]|_/g, "").replace(/\s+/g, " "));
        watsonJson = {
          intents: [{intent: 'create_inheritance'}],
          entities: [{value: childClassName}, {value: parentClassName}],
          output: {text: [childClassName + ' is a subclass of ' + parentClassName + '.']}
        };
      }
    }
    return;
  }

  function firstLetterUppercase(input) {
    return input[0].toUpperCase() + input.substring(1);
  }

}
