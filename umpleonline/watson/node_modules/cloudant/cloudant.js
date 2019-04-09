module.exports = Cloudant;

/**
 * Copyright (c) 2015 IBM Cloudant, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

var Nano = require('nano'),
  debug = require('debug')('cloudant'),
  nanodebug = require('debug')('nano');


// function from the old Cloudant library to
// parse an object { account: "myaccount", password: "mypassword"}
// and return a URL
var reconfigure = require('./lib/reconfigure.js')

// This IS the Cloudant API. It is mostly nano, with a few functions.
function Cloudant(credentials, callback) {
  debug('Initialize', credentials);

  // Save the username and password for potential conversion to cookie auth.
  var login = reconfigure.getCredentials(credentials);

  // Convert the credentials into a URL that will work for cloudant. The
  // credentials object will become squashed into a string, which is fine
  // except for the .cookie option.
  var cookie = credentials.cookie;

  var pkg = require('./package.json');
  var useragent = "nodejs-cloudant/" + pkg.version + " (Node.js " + process.version + ")";
  var requestDefaults = { headers: { "User-agent": useragent}, gzip:true  };
  if (typeof credentials == "object") {
    if (credentials.requestDefaults) {
      requestDefaults = credentials.requestDefaults;
      delete credentials.requestDefaults;
    }
    credentials = reconfigure(credentials);
  } else {
    credentials = reconfigure({ url: credentials})
  }

  debug('Create underlying Nano instance, credentials=%j requestDefaults=%j', credentials, requestDefaults);
  var nano = Nano({url:credentials, requestDefaults: requestDefaults, cookie: cookie, log: nanodebug});

  // our own implementation of 'use' e.g. nano.use or nano.db.use
  // it includes all db-level functions
  var use = function(db) {

    // ****************
    // Functions added to each db e.g. cloudant.use("mydb")
    // ****************

    // https://docs.cloudant.com/api.html#viewing-permissions
    var get_security = function(callback) {
      var path = "_api/v2/db/" + encodeURIComponent(db) + "/_security";
      nano.request( { path: path}, callback);
    };

    // https://docs.cloudant.com/api.html#modifying-permissions
    var set_security = function(permissions, callback) {
      var path = "_api/v2/db/" + encodeURIComponent(db) + "/_security";
      nano.request( { path: path,
                      method: "put",
                      body: {cloudant: permissions} }, callback);
    };

    // https://docs.cloudant.com/api.html#list-all-indexes &
    // https://docs.cloudant.com/api.html#creating-a-new-index
    var index = function(definition, callback) {

      // if no definition is provided, then the user wants see all the indexes
      if (typeof definition == "function") {
        callback = definition;
        nano.request({ path: encodeURIComponent(db) + "/_index" }, callback);
      } else {
        // the user wants to create a new index
        nano.request({ path: encodeURIComponent(db) + "/_index",
                       method:"post",
                       body: definition}, callback);
      }
    };

    // https://docs.cloudant.com/api.html#deleting-an-index
    var index_del = function(spec, callback) {
      spec = spec || {};
      if (!spec.ddoc)
        throw new Error('index.del() must specify a "ddoc" value');
      if (!spec.name)
        throw new Error('index.del() must specify a "name" value');
      var type = spec.type || 'json';
      var path = encodeURIComponent(db) + "/_index/" +
                 encodeURIComponent(spec.ddoc) + "/" +
                 encodeURIComponent(type) + "/" +
                 encodeURIComponent(spec.name);
      nano.request({ path:path, method:"delete"}, callback);
    };

    // https://docs.cloudant.com/api.html#finding-documents-using-an-index
    var find = function(query, callback) {
      nano.request( { path: encodeURIComponent(db) + "/_find",
                      method: "post",
                      body: query}, callback);
    };

    // add Cloudant special functions
    var obj = nano._use(db);
    obj.get_security = get_security;
    obj.set_security = set_security;
    obj.index = index;
    obj.index.del = index_del;
    obj.find = find;

    return obj;
  };

  // intercept calls to 'nano.use' to plugin our extensions
  nano._use = nano.use;
  nano.use = nano.db.use = use;


  // https://docs.cloudant.com/api.html#creating-api-keys
  var generate_api_key = function(callback) {
    nano.request({path: "_api/v2/api_keys", method: "post" }, callback);
  };

  // https://docs.cloudant.com/api.html#reading-the-cors-configuration
  var get_cors = function(callback) {
    nano.request({path: "_api/v2/user/config/cors" }, callback);
  };

  // https://docs.cloudant.com/api.html#setting-the-cors-configuration
  var set_cors = function(configuration, callback) {
    nano.request({path: "_api/v2/user/config/cors",
                  method: "put",
                  body: configuration }, callback);
  };

  // the /set_permissions API call is deprecated
  var set_permissions = function(opts, callback) {
    console.error("set_permissions is deprecated. use set_security instead");
    callback(null, null);
  };

  // https://docs.cloudant.com/api.html#setting-the-cors-configuration
  var set_cors = function(configuration, callback) {
    nano.request({path: "_api/v2/user/config/cors",
                  method: "put",
                  body: configuration }, callback);
  };

  var get_virtual_hosts = function(callback) {
    nano.request({path: "_api/v2/user/virtual_hosts",
                  method: "get"}, callback);
  };

  var add_virtual_host = function(opts, callback) {
    nano.request({path: "_api/v2/user/virtual_hosts",
                  method: "post",
                  body: opts }, callback);
  };

  var delete_virtual_host = function(opts, callback) {
    nano.request({path: "_api/v2/user/virtual_hosts",
                  method: "delete",
                  body: opts }, callback);
  };

  // add top-level Cloudant-specific functions
  nano.ping = ping;
  nano.get_cors = get_cors;
  nano.set_cors = set_cors;
  nano.set_permissions = set_permissions;
  nano.generate_api_key = generate_api_key;
  nano.get_virtual_hosts = get_virtual_hosts;
  nano.add_virtual_host = add_virtual_host;
  nano.delete_virtual_host = delete_virtual_host;

  if (callback) {
    debug('Automatic ping');
    nano.ping(login, function(er, pong, cookie) {
      if (er) {
        callback(er);
      } else {
        if (cookie) {
          requestDefaults.headers.cookie = cookie;
        }

        callback(null, nano, pong);
      }
    });
  }

  return nano;
}

function ping(login, callback) {
  var nano = this;

  if (!callback) {
    callback = login;
    login = null;
  }

  // Only call back once.
  var inner_callback = callback;
  callback = function(er, result, cookie) {
    inner_callback(er, result, cookie);
    inner_callback = function() {};
  };

  var cookie = null;
  var done = {welcome:false, session:false, auth:true};
  nano.session(       function(er, body) { returned('session', er, body); });
  nano.relax({db:""}, function(er, body) { returned('welcome', er, body); });

  // If credentials are supplied, authenticate to get a cookie.
  if (login && login.username && login.password) {
    done.auth = false;
    nano.auth(login.username, login.password, function(er, body, headers) {
      returned('auth', er, body, headers);
    });
  }

  function returned(type, er, body, headers) {
    if (er)
      return callback(er);

    debug('Pong/%s %j', type, body);
    done[type] = body;

    if (type == 'auth') {
      if (headers['set-cookie'] && headers['set-cookie'][0]) {
        cookie = headers['set-cookie'][0].replace(/;.*$/, '');
      }
    }

    if (done.welcome && done.session && done.auth) {
      // Return the CouchDB "Welcome" body but with the userCtx added in.
      done.welcome.userCtx = done.session.userCtx;
      callback(null, done.welcome, cookie);
    }
  }
}
