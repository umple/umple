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

require( 'dotenv' ).config( {silent: true} );

var express = require( 'express' );  // app server
var bodyParser = require( 'body-parser' );  // parser for post requests
//var watson = require( 'watson-developer-cloud' );  // watson sdk
var AssistantV1 = require('watson-developer-cloud/assistant/v1');  // watson assistant sdk
var http = require('http');

// The following requires are needed for logging purposes
var uuid = require( 'uuid' );
var vcapServices = require( 'vcap_services' );
var basicAuth = require( 'basic-auth-connect' );

var app = express();

// Bootstrap application settings
app.use( express.static( './public' ) ); // load UI from public folder
app.use( bodyParser.json() );

// Create the service wrapper
/*
var conversation = watson.conversation( {
  url: 'https://gateway.watsonplatform.net/conversation/api',
  username: process.env.CONVERSATION_USERNAME || '<username>',
  password: process.env.CONVERSATION_PASSWORD || '<password>',
  version_date: '2017-05-26',
  version: 'v1'
} );
*/
// Set up Assistant service wrapper.
var conversation = new AssistantV1({
  version: '2018-09-20',
  iam_apikey: process.env.CONVERSATION_USERNAME || '<username>',
  url: process.env.CONVERSATION_PASSWORD || '<password>'
});



// Create service wrapper for Natural Language Understanding
const NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
/*
const nlu = new NaturalLanguageUnderstandingV1({
  'username': process.env.NATURAL_LANGUAGE_UNDERSTANDING_USERNAME || '<username>',
  'password': process.env.NATURAL_LANGUAGE_UNDERSTANDING_PASSWORD || '<password>',
  version_date: NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
*/

var nlu = new NaturalLanguageUnderstandingV1({
  version: '2018-11-16',
  iam_apikey: process.env.NATURAL_LANGUAGE_UNDERSTANDING_USERNAME || '<username>',
  url: process.env.NATURAL_LANGUAGE_UNDERSTANDING_PASSWORD || '<password>'
});


// Define what features you want to extract with NLU
// In this case, we're interested in entities and relations
var features= {
      categories: {
        limit: 3
      },
      entities: {
        mentions: true,
        model: '0af23d03-3b2d-4407-b61e-3d1c63f5e99a'
        //'model': '65d130fd-0497-485d-8280-07147d915931'
        //'sentiment': true,
        //'limit': 1
      },
      relations: {
        model: '0af23d03-3b2d-4407-b61e-3d1c63f5e99a'    
        //'model': '65d130fd-0497-485d-8280-07147d915931'   
      }
    };

// Endpoint to be call from the client side
app.post( '/api/message', function(req, res) {
  var workspace = process.env.WORKSPACE_ID || '<workspace-id>';
  if ( !workspace || workspace === '<workspace-id>' ) {
    return res.json( {
      'output': {
        'text': 'The app has not been configured with a <b>WORKSPACE_ID</b> environment variable. Please refer to the ' +
        '<a href="https://github.com/watson-developer-cloud/conversation-simple">README</a> documentation on how to set this variable. <br>' +
        'Once a workspace has been defined the intents may be imported from ' +
        '<a href="https://github.com/watson-developer-cloud/conversation-simple/blob/master/training/car_workspace.json">here</a> in order to get a working application.'
      }
    } );
  }
  var payload = {
    workspace_id: workspace,
    context: {},
    input: {}
  };
  var params = null;
  if ( req.body ) {
    if ( req.body.input ) {
      payload.input = req.body.input;
      params = {text: req.body.input.text,features:features};
    }
    if ( req.body.context ) {
      // The client must maintain context/state
      payload.context = req.body.context;
    }
  }

  if(params == null) {
   params = {text: "hello, how can you?",features:features}
  }


  nlu.analyze(params, function(error, response) {
    if (error) {
      return res.status(error.code || 500).json(error);
    }
    if(response != null) {
      //if response is not null, print response from NLU
      //var nluResponse = response;
      //console.log(JSON.stringify(response, null, 2));
      //console.log("Value of var nluResponse:" + nluResponse);


      //if response is not null, save entities detected by nlu
      //as variable entities. 
      var entities = response.entities;
      var containerList = entities.map(function(entry) {
            if(entry.type == "container_ent") {
              return(entry.text);
 //if(entry.disambiguation && entry.disambiguation.subtype && entry.disambiguation.subtype.indexOf("City") > -1) {
//return(entry.text);
 //}
}
      });
containerList = containerList.filter(function(entry) {
if(entry != null) {
 return(entry);
}
});
if(containerList.length > 0) {
 payload.context.varContainer = containerList[0];
} else {
 payload.context.varContainer= null;
}
      var partList = entities.map(function(entry) {
if(entry.type == "part_ent") {
  return(entry.text);
 //if(entry.disambiguation && entry.disambiguation.subtype) {
   //if(entry.disambiguation.subtype.indexOf("USState") > -1 || entry.disambiguation.subtype.indexOf("StateOrCounty") > -1) {
    //return(entry.text);
   //}
 //}
}
      });

partList = partList.filter(function(entry) {
if(entry != null) {
 return(entry);
}
});
if (partList.length > 0) {
 payload.context.varPart = partList[0];
} else {
 payload.context.varPart = null;
}

//Parent

var parentList = entities.map(function(entry) {
  if(entry.type == "parent_ent") {
    return(entry.text);
   //if(entry.disambiguation && entry.disambiguation.subtype) {
     //if(entry.disambiguation.subtype.indexOf("USState") > -1 || entry.disambiguation.subtype.indexOf("StateOrCounty") > -1) {
      //return(entry.text);
     //}
   //}
  }
        });
  
  parentList = parentList.filter(function(entry) {
  if(entry != null) {
   return(entry);
  }
  });
  if (parentList.length > 0) {
   payload.context.varParent = parentList[0];
  } else {
   payload.context.varParent = null;
  }



//Child

var childList = entities.map(function(entry) {
  if(entry.type == "child_ent") {
    return(entry.text);
   //if(entry.disambiguation && entry.disambiguation.subtype) {
     //if(entry.disambiguation.subtype.indexOf("USState") > -1 || entry.disambiguation.subtype.indexOf("StateOrCounty") > -1) {
      //return(entry.text);
     //}
   //}
  }
        });
  
  childList = childList.filter(function(entry) {
  if(entry != null) {
   return(entry);
  }
  });
  if (childList.length > 0) {
   payload.context.varChild = childList[0];
  } else {
   payload.context.varChild = null;
  }



    } else {
if(payload.context.varContainer) {
payload.context.varContainer = null;
}
if(payload.context.varPart) {
payload.context.varPart = null;
}
if(payload.context.varChid) {
  payload.context.varChild = null;
  }
if(payload.context.varParent) {
  payload.context.varParent = null;
  }
console.log('response from NLU entity extraction is null');
    }
// Send the input to the conversation service
    conversation.message(payload, function(err, data) {
            if (err) {
              return res.status(err.code || 500).json(err);
            }
            updateResponse(res, data);
     });

});

 /* 
  nlu.analyze(params, function(error, response) {
        if (error) {
          return res.status(error.code || 500).json(error);
        }
        if(response != null) {
          //if response is not null, save entities detected by nlu
          //as variable entities. 
          var entities = response.entities;
          var cityList = entities.map(function(entry) {
                if(entry.type == "Location") {
		 if(entry.disambiguation && entry.disambiguation.subtype && entry.disambiguation.subtype.indexOf("City") > -1) {
		  return(entry.text);
		 }
		}
          });
	  cityList = cityList.filter(function(entry) {
		if(entry != null) {
		 return(entry);
		}
	  });
	  if(cityList.length > 0) {
	   payload.context.appCity = cityList[0];
	  } else {
	   payload.context.appCity = null;
	  }
          var stateList = entities.map(function(entry) {
		if(entry.type == "Location") {
		 if(entry.disambiguation && entry.disambiguation.subtype) {
		   if(entry.disambiguation.subtype.indexOf("USState") > -1 || entry.disambiguation.subtype.indexOf("StateOrCounty") > -1) {
		    return(entry.text);
		   }
		 }
		}
          });

	  stateList = stateList.filter(function(entry) {
		if(entry != null) {
		 return(entry);
		}
	  });
	  if (stateList.length > 0) {
	   payload.context.appST = stateList[0];
	  } else {
	   payload.context.appST = null;
	  }
        } else {
	 if(payload.context.appCity) {
	  payload.context.appCity = null;
	 }
	 if(payload.context.appST) {
	  payload.context.appST = null;
	 }
	 console.log('response from NLU entity extraction is null');
        }
  // Send the input to the conversation service
        conversation.message(payload, function(err, data) {
                if (err) {
                  return res.status(err.code || 500).json(err);
                }
                updateResponse(res, data);
         });

  });
*/

} );

// Weather API key (https://www.wunderground.com/weather/api/)
var weather_api_key = process.env.WEATHER_API_KEY || 'YOUR_WEATHER_API_KEY';
function updateResponse(res, data) {

  var weatherflag = checkWeather(data);
  if(weatherflag) {
   var path = null;
   if((data.context.appCity != null) && (data.context.appST != null)) {
     path = '/api/' + weather_api_key + '/forecast/q/' + data.context.appST + '/' + data.context.appCity + '.json';
   }
   if (path == null) {
    return res.json(data)
   }
   var options = {
     host: 'api.wunderground.com',
     path: path
   };
   http.get(options, function(resp) {
     var chunkText = '';
     resp.on('data', function(chunk) {
     chunkText += chunk.toString('utf8');
     });

     resp.on('end', function() {
	var chunkJSON = JSON.parse(chunkText);
	var forecast = chunkJSON.forecast.txt_forecast.forecastday[0].fcttext;
	data.output.text = 'The weather in ' + data.context.appCity + ', ' + data.context.appST + ' will be ' + forecast;
	return res.json(data);
     });
    }).on('error', function(e) {
       console.log('failed');
    });
   } else {
     return res.json(data);
   }
};

function checkWeather(data) {
  return data.intents && data.intents.length > 0 && data.intents[0].intent === 'weather'
     && (data.context != null) && (data.context.appCity != null) && (data.context.appST != null);
};

module.exports = app;
