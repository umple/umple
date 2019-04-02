var jsonResponse;
var intent;
var modelLog = "";
var modelClassJsons = {};
var Action = window.parent.Action;

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

function updateModelLog() {
  var list = window.parent.document.getElementsByTagName('h');
  for (var i = 0; i < list.length; i++){
    var postCmd = list[i].firstChild.nodeValue;
    modelLog += postCmd + "\n\n";
    
    if (postCmd.includes("action=addClass")) {
      postCmd = postCmd.replace("action=addClass&actionCode=", "");
      var classInfo = JSON.parse(postCmd);
      modelClassJsons[classInfo.name] = classInfo;
    }
  }
  console.log(modelLog);
}

function chatbotAction() {
  intent = jsonResponse.output.intents[0].intent;
  
  const action = {
    'Create_Class': addClass,
    'Add_Attribute': addAttribute,
    'Add_Inheritance': addInheritance,
    'Add_Association': addAssociation,
    'Add_Composition': addComposition
  };

  action[intent]();
  updateModelLog();
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

function addAttribute() {
  const className = jsonResponse.output.entities[0].value || 'NewClass';
  const attributeName = jsonResponse.output.entities[1].value || 'attributeName';
  var json = modelClassJsons[className];
  var attributes = {
    type: "String", name: attributeName, textColor: "black", aColor: "black", newType: "String", newName: attributeName
  };
  if (typeof json["attributes"] === "undefined") { 
    json["attributes"] = [attributes];
  } else {
    json["attributes"].push(attributes);
  }
  var request = "action=editClass&actionCode=" + JSON.stringify(json);
  Action.ajax(Action.directUpdateCommandCallback, request);
}

function addInheritance() {
  const childClassName = jsonResponse.output.entities[0].value || 'SubClass';
  const parentClassName = jsonResponse.output.entities[1].value || 'SuperClass';
  var request = `action=addGeneralization&actionCode={"parentId": ${parentClassName}, "childId": ${childClassName}}`;
  Action.ajax(Action.directUpdateCommandCallback, request);
}

function addAssociation() {
  const className1 = jsonResponse.output.entities[0].value || 'NewClass1';
  const className2 = jsonResponse.output.entities[1].value || 'NewClass2';
  var request = `action=addAssociation&actionCode={  
    "classOnePosition": ${JSON.stringify(modelClassJsons[className1].position)},
    "classTwoPosition": ${JSON.stringify(modelClassJsons[className2].position)},
    "offsetOnePosition":{  
       "x":"50",
       "y":"50",
       "width":"0",
       "height":"0"
    },
    "offsetTwoPosition":{  
       "x":"50",
       "y":"50",
       "width":"0",
       "height":"0"
    },
    "multiplicityOne":"*",
    "multiplicityTwo":"*",
    "name":"${className1}__${className2}",
    "roleOne":"",
    "roleTwo":"",
    "isSymmetricReflexive":"false",
    "isLeftNavigable":"true",
    "isRightNavigable":"true",
    "isLeftComposition":"false",
    "isRightComposition":"false",
    "color":"black",
    "id":"${"umpleAssociation_" + 2*numClasses}",
    "classOneId":"${className1}",
    "classTwoId":"${className2}"
  }`;
  Action.ajax(Action.directUpdateCommandCallback, request);
}

function addComposition() {
  const wholeClassName = jsonResponse.output.entities[0].value || 'Whole';
  const partClassName = jsonResponse.output.entities[1].value || 'Part';
  var request = `TODO`;
  Action.ajax(Action.directUpdateCommandCallback, request);
}

function debug4() {
  Action.directAddClass("Pizza", ['500', '750']);
}