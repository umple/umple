# Cloudant Node.js Client

This is the official Cloudant library for Node.js.

* [Installation and Usage](#installation-and-usage)
* [Getting Started](#getting-started)
  * [Initialization](#initialization)
  * [Callback Signature](#callback-signature)
  * [Password Authentication](#password-authentication)
  * [Cloudant Local](#cloudant-local)
* [API Reference](#api-reference)
* [Authorization and API Keys](#authorization-and-api-keys)
  * [Generate an API key](#generate-an-api-key)
  * [Use an API Key](#use-an-api-key)
* [CORS](#cors)
* [Virtual Hosts](#virtual-hosts)
* [Cloudant Query](#cloudant-query)
* [Cloudant Search](#cloudant-search)
* [Cookie Authentication](#cookie-authentication)
* [Advanced Features](#advanced-features)
  * [Advanced Configuration](#advanced-configuration)
  * [Pool size and open sockets](#pool-size-and-open-sockets)
  * [Extending the Cloudant Library](#extending-the-cloudant-library)
  * [Pipes](#pipes)
* [Development and Contribution](#development-and-contribution)
  * [Local Development](#local-development)
  * [Test Suite](#test-suite)
  * [Using in Other Projects](#using-in-other-projects)
  * [Security Note](#security-note)
* [License](#license)
* [Reference](#reference)


## Installation and Usage

The best way to use the Cloudant client is to begin with your own Node.js project, and define this work as your dependency. In other words, put me in your package.json dependencies. The `npm` tool can do this for you, from the command line:

    $ npm install --save cloudant

Notice that your package.json will now reflect this package. Everything is working if you can run this command with no errors:

    $ node -e 'require("cloudant"); console.log("Cloudant works");'
    Cloudant works

### Getting Started

Now it's time to begin doing real work with Cloudant and Node.js.

Initialize your Cloudant connection by supplying your *account* and *password*, and supplying a callback function to run when everything is ready.

~~~ js
// Load the Cloudant library.
var Cloudant = require('cloudant');

var me = 'nodejs'; // Set this to your own account
var password = process.env.cloudant_password;

// Initialize the library with my account.
var cloudant = Cloudant({account:me, password:password});

cloudant.db.list(function(err, allDbs) {
  console.log('All my databases: %s', allDbs.join(', '))
});
~~~

Possible output (depending on your databases, of course):

     All my databases: example_db, jasons_stuff, scores

Upper-case `Cloudant` is this package you load using `require()`, while lower-case `cloudant` represents an authenticated, confirmed connection to your Cloudant service.

If you omit the "password" field, you will get an "anonymous" connection: a client that sends no authentication information (no passwords, no cookies, etc.)

To use the example code as-is, you must first install the `dotenv` package from npm, then create a `.env` file with your Cloudant credentials. For example:

~~~
npm install dotenv                               # Install ./node_modules/dotenv
echo "/.env"                       >> .gitignore # Do not track .env in the revision history
echo "cloudant_username=myaccount" >  .env       # Replace myaccount with your account name
echo "cloudant_password='secret'"  >> .env       # Replace secret with your password
~~~

Here is simple but complete example of working with data:

~~~ js
require('dotenv').load();

// Load the Cloudant library.
var Cloudant = require('cloudant');

// Initialize Cloudant with settings from .env
var username = process.env.cloudant_username || "nodejs";
var password = process.env.cloudant_password;
var cloudant = Cloudant({account:username, password:password});

// Remove any existing database called "alice".
cloudant.db.destroy('alice', function(err) {

  // Create a new "alice" database.
  cloudant.db.create('alice', function() {

    // Specify the database we are going to use (alice)...
    var alice = cloudant.db.use('alice')

    // ...and insert a document in it.
    alice.insert({ crazy: true }, 'rabbit', function(err, body, header) {
      if (err) {
        return console.log('[alice.insert] ', err.message);
      }

      console.log('You have inserted the rabbit.');
      console.log(body);
    });
  });
});
~~~

If you run this example, you will see:

    You have inserted the rabbit.
    { ok: true,
      id: 'rabbit',
      rev: '1-6e4cb465d49c0368ac3946506d26335d' }

You can find a further CRUD example in the [example](https://github.com/cloudant/nodejs-cloudant/tree/master/example) directory of this project.

### Initialization

To use Cloudant, `require('cloudant')` in your code. That will return the initialization function. Run that function, passing your account name and password, and an optional callback. (And see the [security note](#security-note) about placing your password into your source code.

In general, the common style is that `Cloudant` (upper-case) is the **package** you load; wheareas `cloudant` (lower-case) is your connection to your database--the result of calling `Cloudant()`:

~~~ js
var Cloudant = require('cloudant');
var cloudant = Cloudant({account:me, password:password});
~~~

If you would prefer, you can also initialize Cloudant with a URL:

~~~ js
var Cloudant = require('cloudant')
var cloudant = Cloudant("https://MYUSERNAME:MYPASSWORD@MYACCOUNT.cloudant.com");
~~~

You can optionally provide a callback to the Cloudant initialization function. This will make the library automatically "ping" Cloudant to confirm the connection and that your credentials work.

Here is a simple example of initializing asychronously, using its optional callback parameter:

~~~ js
var Cloudant = require('cloudant');
var me = 'nodejs'; // Replace with your account.
var password = process.env.cloudant_password;

Cloudant({account:me, password:password}, function(err, cloudant) {
  if (err) {
    return console.log('Failed to initialize Cloudant: ' + err.message);
  }

  var db = cloudant.db.use("animals");
  db.get("dog", function(err, data) {
    // The rest of your code goes here. For example:
    console.log("Found dog:", data);
  });
});
~~~

### Callback Signature

After initialization, in general, callback functions receive three arguments:

* `err` - the error, if any
* `body` - the http _response body_ from Cloudant, if no error.
* `header` - the http _response header_ from Cloudant, if no error

The `ping()` function is the only exception to this rule. It does not return headers since a "ping" is made from multiple requests to gather various bits of information.

### Password Authentication

By default, when you connect to your cloudant account (i.e. "me.cloudant.com"), you authenticate as the account owner (i.e. "me"). However, you can use Cloudant with any username and password. Just provide an additional "username" option when you initialize Cloudant. This will connect to your account, but using the username as the authenticated user. (And of course, use the appropriate password.)

~~~ js
var Cloudant = require('cloudant');
var me = "nodejs";         // Substitute with your Cloudant user account.
var otherUsername = "jhs"; // Substitute with some other Cloudant user account.
var otherPassword = process.env.other_cloudant_password;

Cloudant({account:me, username:otherUsername, password:otherPassword}, function(er, cloudant, reply) {
  if (er) {
    throw er;
  }

  console.log('Connected with username: %s', reply.userCtx.name);
});
~~~

### Cloudant Local

If you use Cloudant Local, everything works exactly the same, except you provide a *hostname* parameter to indicate which server to use:

~~~ js
Cloudant({hostname:"companycloudant.local", username:"somebody", password:"somebody's secret"}, function(er, cloudant, reply) {
  if (er)
    throw er

  console.log('Connected with username: %s', reply.userCtx.name)
})
~~~


## API Reference

Cloudant is a wrapper around the Nano library and as such, Nano's documentation should be consulted for:

- [Database functions](https://github.com/apache/couchdb-nano#database-functions)
- [Document functions](https://github.com/apache/couchdb-nano#document-functions)
- [Multipart functions](https://github.com/apache/couchdb-nano#multipart-functions)
- [Attachment functions](https://github.com/apache/couchdb-nano#attachments-functions)
- [View and Design functions](https://github.com/apache/couchdb-nano#views-and-design-functions)

This library adds documentation for the following:

- [Authorization and API Keys](#authorization-and-api-keys)
  - [Generate an API key](#generate-an-api-key)
  - [Use an API Key](#use-an-api-key)
- [CORS](#cors)
- [Cloudant Query](#cloudant-query)
- [Cloudant Search](#cloudant-search)
- [Cookie Authentication](#cookie-authentication)
- [Advanced Features](#advanced-features)
  - [Advanced Configuration](#advanced-configuration)
  - [Pool size and open sockets](#pool-size-and-open-sockets)
  - [Extending the Cloudant Library](#extending-the-cloudant-library)
  - [Pipes](#pipes)
- [Development](#development)
  - [Test Suite](#test-suite)
  - [Using in Other Projects](#using-in-other-projects)
- [License](#license)
- [Reference](#reference)


## Authorization and API Keys

This feature interfaces with the Cloudant [authorization API][Authorization].

Use the authorization feature to generate new API keys to access your data. An API key is basically a username/password pair for granting others access to your data, without giving them the keys to the castle.

### Generate an API key

~~~ js
var Cloudant = require('cloudant');
var me = 'nodejs'; // Replace with your account.
var password = process.env.cloudant_password;
var cloudant = Cloudant({account:me, password:password});

cloudant.generate_api_key(function(er, api) {
  if (er) {
    throw er; // You probably want wiser behavior than this.
  }

  console.log('API key: %s', api.key);
  console.log('Password for this key: %s', api.password);
  console.log('');

  // Set the security for three users: nobody, nodejs, and the above API key.
  // (The "nodejs" user is an example account that belongs to IBM Cloudant.)
  var db = "animals";
  var security = {
    nobody: [],
    nodejs : [ '_reader', '_writer', '_admin', '_replicator' ]
  };
  security[api.key] = [ '_reader', '_writer' ];

  var my_database = cloudant.db.use(db);
  my_database.set_security(security, function(er, result) {
    if (er) {
      throw er;
    }

    console.log('Set security for ' + db);
    console.log(result);
    console.log('');

    // Or you can read the security settings from a database.
    my_database.get_security(function(er, result) {
      if (er) {
        throw er;
      }

      console.log('Got security for ' + db);
      console.log(result);
    });
  });
});
~~~

Output:

    API key: thandoodstrenterprourete
    Password for this key: Eivln4jPiLS8BoTxjXjVukDT

    Set security for animals
    { ok: true }

    Got security for animals
    { cloudant:
      { nobody: [],
        thandoodstrenterprourete: [ '_reader', '_writer' ],
        nodejs: [ '_reader', '_writer', '_admin', '_replicator' ] } }

See the Cloudant API for full details](https://docs.cloudant.com/api.html#authorization)

### Use an API Key

To use an API key, initialize a new Cloudant connection, and provide an additional "key" option when you initialize Cloudant. This will connect to your account, but using the "key" as the authenticated user. (And of course, use the appropriate password associated with the API key.)

~~~ js
var Cloudant = require('cloudant');
var cloudant = Cloudant({account:"me", key:api.key, password:api.password});
~~~

## CORS

If you need to access your Cloudant database from a web application that is served from a domain other than your Cloudant account, you will need to enable CORS (Cross-origin resource sharing).

e.g. enable CORS from any domain:

~~~ js
cloudant.set_cors({ enable_cors: true, allow_credentials: true, origins: ["*"]}, function(err, data) {
  console.log(err, data);
});
~~~

or enable access from a list of specified domains:

~~~ js
cloudant.set_cors({ enable_cors: true, allow_credentials: true, origins: [ "https://mydomain.com","https://mysubdomain.mydomain.com"]}, function(err, data) {
  console.log(err, data);
});
~~~

or disable CORS access

~~~ js
cloudant.set_cors({ enable_cors: false, origins: [] }, function(err, data) {
  console.log(err, data);
});
~~~

or to fetch the current CORS configuration

~~~ js
cloudant.get_cors(function(err, data) {
  console.log(data);
});
~~~

Output:

    { enable_cors: true, allow_credentials: true, origins: [ '*' ] }

See <https://docs.cloudant.com/api.html#cors> for further details.


## Virtual Hosts

If you wish to access your Cloudant domain name (myaccount.cloudant.com) using a CNAME'd domain name (mysubdomain.mydomain.com) then you can
instruct Cloudant to do so.

e.g. add a virtual host
~~~ js
cloudant.add_virtual_host({ host: "mysubdomain.mydomain.com", path: "/mypath"}, function(err, data) {
  console.log(err, data);
});
~~~

e.g. view virtual host configuration

~~~ js
cloudant.get_virtual_hosts(function(err, data) {
  console.log(err, data);
});
~~~

or delete a virtual host
~~~ js
cloudant.delete_virtual_host({ host: "mysubdomain.mydomain.com", path: "/mypath"}, function(err, data) {
  console.log(err, data);
});
~~~

## Cloudant Query

This feature interfaces with Cloudant's query functionality. See the [Cloudant Query documentation][Cloudant Query] for details.

As with Nano, when working with a database (as opposed to the root server), run the `.db.use()` method.

~~~ js
var db = cloudant.db.use('my_db')
~~~

To see all the indexes in a database, call the database `.index()` method with a callback function.

~~~ js
db.index(function(er, result) {
  if (er) {
    throw er;
  }

  console.log('The database has %d indexes', result.indexes.length);
  for (var i = 0; i < result.indexes.length; i++) {
    console.log('  %s (%s): %j', result.indexes[i].name, result.indexes[i].type, result.indexes[i].def);
  }

  result.should.have.a.property('indexes').which.is.an.Array;
  done();
});
~~~

Example output:

    The database has 3 indexes
      _all_docs (special): {"fields":[{"_id":"asc"}]}
      first-name (json): {"fields":[{"name":"asc"}]}
      last-name (json): {"fields":[{"name":"asc"}]}

To create an index, use the same `.index()` method but with an extra initial argument: the index definition. For example, to make an index on middle names in the data set:

~~~ js
var first_name = {name:'first-name', type:'json', index:{fields:['name']}}
db.index(first_name, function(er, response) {
  if (er) {
    throw er;
  }

  console.log('Index creation result: %s', response.result);
});
~~~

Output:

    Index creation result: created

To query using the index, use the `.find()` method.

~~~ js
db.find({selector:{name:'Alice'}}, function(er, result) {
  if (er) {
    throw er;
  }

  console.log('Found %d documents with name Alice', result.docs.length);
  for (var i = 0; i < result.docs.length; i++) {
    console.log('  Doc id: %s', result.docs[i]._id);
  }
});
~~~


## Cloudant Search

This feature interfaces with Cloudant's search functionality. See the [Cloudant Search documentation][Cloudant Search] for details.

First, when working with a database (as opposed to the root server), run the `.use()` method.

~~~ js
var db = cloudant.db.use('my_db')
~~~

In this example, we will begin with some data to search: a collection of books.

~~~
var books = [
  {author:"Charles Dickens", title:"David Copperfield"},
  {author:"David Copperfield", title:"Tales of the Impossible"},
  {author:"Charles Dickens", title:"Great Expectation"}
]

db.bulk({docs:books}, function(er) {
  if (er) {
    throw er;
  }

  console.log('Inserted all documents');
});
~~~

To create a Cloudant Search index, create a design document the normal way you would with Nano, the database `.insert()` method.

To see all the indexes in a database, call the database `.index()` method with a callback function.
             , {_id: '_design/library', indexes:{books:{analyzer:{name:'standard'}, index:index}}}

~~~ js
// Note, you can make a normal JavaScript function. It is not necessary
// for you to convert it to a string as with other languages and tools.
var book_indexer = function(doc) {
  if (doc.author && doc.title) {
    // This looks like a book.
    index('title', doc.title);
    index('author', doc.author);
  }
}

var ddoc = {
  _id: '_design/library',
  indexes: {
    books: {
      analyzer: {name: 'standard'},
      index   : book_indexer
    }
  }
};

db.insert(ddoc, function (er, result) {
  if (er) {
    throw er;
  }

  console.log('Created design document with books index');
});
~~~

To query this index, use the database `.search()` method. The first argument is the design document name, followed by the index name, and finally an object with your search parameters.

~~~ js
db.search('library', 'books', {q:'author:dickens'}, function(er, result) {
  if (er) {
    throw er;
  }

  console.log('Showing %d out of a total %d books by Dickens', result.rows.length, result.total_rows);
  for (var i = 0; i < result.rows.length; i++) {
    console.log('Document id: %s', result.rows[i].id);
  }
});
~~~

## Cookie Authentication

Cloudant supports making requests using Cloudant's [cookie authentication](https://docs.cloudant.com/authentication.html#cookie-authentication).

~~~ js
var Cloudant = require('cloudant');
var username = 'nodejs'; // Set this to your own account
var password = process.env.cloudant_password;
var cloudant = Cloudant({account:username, password:password});

// A global variable to store the cookies. Of course, you can store cookies any way you wish.
var cookies = {}


// In this example, we authenticate using the same username/userpass as above.
// However, you can use a different combination to authenticate as other users
// in your database. This can be useful for using a less-privileged account.
cloudant.auth(username, password, function(er, body, headers) {
  if (er) {
    return console.log('Error authenticating: ' + er.message);
  }

  console.log('Got cookie for %s: %s', username, headers['set-cookie']);

  // Store the authentication cookie for later.
  cookies[username] = headers['set-cookie'];
});
~~~

To reuse a cookie:

~~~ js
// (Presuming the "cookies" global from the above example is still in scope.)

var Cloudant = require('cloudant');
var username = 'nodejs'; // Set this to your own account
var other_cloudant = Cloudant({account:username, cookie:cookies[username]});

var alice = other_cloudant.db.use('alice')
alice.insert({_id:"my_doc"}, function (er, body, headers) {
  if (er) {
    return console.log('Failed to insert into alice database: ' + er.message);
  }

  // Change the cookie if Cloudant tells us to.
  if (headers && headers['set-cookie']) {
    cookies[username] = headers['set-cookie'];
  }
});
~~~

Getting current session:

~~~ js
// (Presuming the "cookie" global from the above example is still in scope.)

var Cloudant = require('cloudant');
var username = 'nodejs'; // Set this to your own account
var cloudant = Cloudant({account:username, cookie:cookies[username]});

cloudant.session(function(er, session) {
  if (er) {
    return console.log('oh noes!');
  }

  console.log('user is %s and has these roles: %j',
    session.userCtx.name, session.userCtx.roles);
});
~~~



## Advanced Features


### Debugging

If you wish to see further information about what the nodejs-cloudant library is doing, then its debugging output can be sent to the console by simply setting an environement variable:

    export DEBUG=cloudant
    # then run your Node.js application

Debug messages will be displayed to indicate each of the Cloudant-specific function calls.

If you want to see all debug messages, including calls made by the underlying `nano` library and HTTP requests/responses sent, then simply change the environment variable to

    export DEBUG=cloudant,nano
    # then run your Node.js application

This will log every request and response as in the following example:

    nano { method: 'POST', headers: { 'content-type': 'application/json', accept: 'application/json' }, uri: 'https://xxxx:yyyyy@xxxx.cloudant.com/woof', body: '{"a":1,"b":2}' } +3ms
    nano { err: null, body: { ok: true, id: '98f178cb8f4fe089f70fa4c92a0c84b1', rev: '1-25f9b97d75a648d1fcd23f0a73d2776e' }, headers: { 'x-couch-request-id': '8220322dee', location: 'http://reader.cloudant.com/woof/98f178cb8f4fe089f70fa4c92a0c84b1', date: 'Mon, 07 Sep 2015 13:06:01 GMT', 'content-type': 'application/json', 'cache-control': 'must-revalidate', 'strict-transport-security': 'max-age=31536000', 'x-content-type-options': 'nosniff;', connection: 'close', statusCode: 201, uri: 'https://xxxx:yyyy@xxxx.cloudant.com/woof' } } 

Note that credentials used in the requests are also written to the log.

Similarly, if you only want `nano`-level debugging:

    export DEBUG=nano
    # then run your Node.js application

The environment variable can also be defined on the same line as the Node.js script you are running e.g.:

    DEBUG="*" node myscript.js

### Advanced Configuration

Besides the account and password options, you can add an optionsl `requestDefaults` value, which will initialize Request (the underlying HTTP library) as you need it.

~~~ js

// Use an HTTP proxy to connect to Cloudant.
var options =
  { "account"         : "my_account"
  , "password"        : "secret"
  , "requestDefaults": { "proxy": "http://localhost:8080" }
  }
var cloudant = require('cloudant')(opts);
// Now using the HTTP proxy...

~~~

Please check [Request][request] for more information on the defaults. They support features like cookie jar, proxies, ssl, etc.

### Pool size and open sockets

A very important configuration parameter if you have a high traffic website and are using Cloudant is setting up the `pool.size`. By default, the node.js https global agent (client) has a certain size of active connections that can run simultaneously, while others are kept in a queue. Pooling can be disabled by setting the `agent` property in `requestDefaults` to false, or adjust the global pool size using:

~~~ js
var https = require('https')
https.globalAgent.maxSockets = 20
~~~

You can also increase the size in your calling context using `requestDefaults` if this is problematic. refer to the [Request][request] documentation and examples for further clarification.

Here is an example of explicitly using the keep alive agent (installed using `npm install agentkeepalive`), especially useful to limit your open sockets when doing high-volume access to Cloudant:

~~~ js
var HttpsAgent = require('agentkeepalive').HttpsAgent;
var myagent = new HttpsAgent({
    maxSockets: 50,
    maxKeepAliveRequests: 0,
    maxKeepAliveTime: 30000
  });
var cloudant = require('cloudant')({account:"me", password:"secret", requestDefaults:{agent:myagent}});
// Using Cloudant with myagent...
~~~

### Extending the Cloudant Library

Cloudant is minimalistic but you can add your own features with `cloudant.request(opts, callback)`

For example, to create a function to retrieve a specific revision of the `rabbit` document:

~~~ js
function getrabbitrev(rev, callback) {
  cloudant.request({ db: 'alice',
                     doc: 'rabbit',
                     method: 'get',
                     params: { rev: rev }
                   }, callback)
}

getrabbitrev('4-2e6cdc4c7e26b745c2881a24e0eeece2', function(err, body) {
  if (!err)
    console.log(body)
})
~~~

### Pipes

You can pipe in Cloudant like in any other stream.  for example if our `rabbit` document has an attachment with name `picture.png` (with a picture of our white rabbit, of course!) you can pipe it to a `writable
stream`

See the [Attachment Functions](#attachment-functions) section for examples of piping to and from attachments.


## Development and Contribution

This is an open-source library, published under the Apache 2.0 license. We very much welcome contributions to the project so if you would like 
to contribute (even if it's fixing a typo in the README!) simply

* fork this repository. Visit https://github.com/cloudant/nodejs-cloudant and click the "Fork" button.
* commit changes into your copy of the repository
* when you're ready, create a Pull Request to contribute your changes back into this project

If you're not confident about being able to fix a problem yourself, or want to simply [report an issue](https://github.com/cloudant/nodejs-cloudant/issues) then please.

### Local Development

To join the effort developing this project, start from our GitHub page: https://github.com/cloudant/nodejs-cloudant

First clone this project from GitHub, and then install its dependencies using npm.

    $ git clone https://github.com/cloudant/nodejs-cloudant
    $ npm install

### Test Suite

We use npm to handle running the test suite. To run the comprehensive test suite, just run `npm test`.

or after adding a new test you can run it individually (with verbose output) using:

~~~ sh
npm test-verbose
~~~

This runs against a local "mock" web server, called Nock. However the test suite can also run against a live Cloudant service. I have registered "nodejs.cloudant.com" for this purpose.

~~~ sh
    $ npm test-live
~~~

Get the password from Jason somehow, and set it a file called `.env` at the root of this project:

    cloudant_password=thisisthepassword

### Using in Other Projects

If you work on this project plus another one, your best bet is to clone from GitHub and then *link* this project to your other one. With linking, your other project depends on this one; but instead of a proper install, npm basically symlinks this project into the right place.

Go to this project and "link" it into the global namespace (sort of an "export").

    $ cd cloudant
    $ npm link
    /Users/jhs/.nvm/v0.10.25/lib/node_modules/cloudant -> /Users/jhs/src/cloudant/nodejs-cloudant

Go to your project and "link" it into there (sort of an "import").

    $ cd ../my-project
    $ npm link cloudant
    /Users/jhs/src/my-project/node_modules/cloudant -> /Users/jhs/.nvm/v0.10.25/lib/node_modules/cloudant -> /Users/jhs/src/cloudant/nodejs-cloudant

Now your project has the dependency in place, however you can work on both of them in tandem.

### Security Note

**DO NOT hard-code your password and commit it to Git**. Storing your password directly in your source code (even in old commits) is a serious security risk to your data. Whoever gains access to your software will now also have read, write, and delete access to your data. Think about GitHub security bugs, or contractors, or disgruntled employees, or lost laptops at a conference. If you check in your password, all of these situations become major liabilities. (Also, note that if you follow these instructions, the `export` command with your password will likely be in your `.bash_history` now, which is kind of bad. However, if you input a space before typing the command, it will not be stored in your history.)

Here is simple but complete example of working with data:

~~~ js
var Cloudant = require('cloudant')

var me = 'nodejs' // Set this to your own account
var password = process.env.cloudant_password

Cloudant({account:me, password:password}, function(er, cloudant) {
  if (er)
    return console.log('Error connecting to Cloudant account %s: %s', me, er.message)

  // Clean up the database we created previously.
  cloudant.db.destroy('alice', function() {
    // Create a new database.
    cloudant.db.create('alice', function() {
      // specify the database we are going to use
      var alice = cloudant.db.use('alice')
      // and insert a document in it
      alice.insert({ crazy: true }, 'rabbit', function(err, body, header) {
        if (err)
          return console.log('[alice.insert] ', err.message)

        console.log('you have inserted the rabbit.')
        console.log(body)
      })
    })
  })
})
~~~

If you run this example, you will see:

    you have inserted the rabbit.
    { ok: true,
      id: 'rabbit',
      rev: '1-6e4cb465d49c0368ac3946506d26335d' }

## License

Copyright (c) 2015 IBM Cloudant, Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the
License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific language governing permissions
and limitations under the License.


## Reference

* [Nano Library]
* [Cloudant Documentation]
* [Cloudant Query](https://docs.cloudant.com/cloudant_query.html)
* [Cloudant Search](https://docs.cloudant.com/search.html)
* [Authentication](https://docs.cloudant.com/authentication.html)
* [Authorization](https://docs.cloudant.com/authorization.html)
* [CORS](https://docs.cloudant.com/cors.html)
* [Issues](https://github.com/cloudant/nodejs-cloudant/issues)
* [Follow library](https://github.com/iriscouch/follow)

[Nano Library]: https://github.com/apache/couchdb-nano
[Cloudant Documentation]: https://docs.cloudant.com/
[Cloudant Query]: https://docs.cloudant.com/cloudant_query.html
[Cloudant Search]: https://docs.cloudant.com/search.html
[Authentication]: https://docs.cloudant.com/authentication.html
[Authorization]: https://docs.cloudant.com/authorization.html
[CORS]: https://docs.cloudant.com/cors.html
[Issues]: https://github.com/cloudant/nodejs-cloudant/issues
[Follow library]: https://github.com/iriscouch/follow
[request]: https://github.com/request/request
