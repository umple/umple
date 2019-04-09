[![build status](https://secure.travis-ci.org/nulltask/express-csv.png)](http://travis-ci.org/nulltask/express-csv)
# Express CSV

```
 _____                                 ____ ______     __
| ____|_  ___ __  _ __ ___  ___ ___   / ___/ ___\ \   / /
|  _| \ \/ / '_ \| '__/ _ \/ __/ __| | |   \___ \\ \ / / 
| |___ >  <| |_) | | |  __/\__ \__ \ | |___ ___) |\ V /  
|_____/_/\_\ .__/|_|  \___||___/___/  \____|____/  \_/   
           |_|                                           
```

  Express CSV provides response CSV easily to [Express](http://expressjs.com/).

## Installation

npm:

    $ npm install express-csv

## Usage

Example:

```js
var express = require('express')
  , csv = require('express-csv')
  , app = module.exports = express.createServer();

app.get('/', function(req, res) {
  res.csv([
    ["a", "b", "c"]
  , ["d", "e", "f"]
  ]);
});

app.listen(3000);
```

Response:

```
$ curl --verbose http://127.0.0.1:3000/
* About to connect() to 127.0.0.1 port 3000 (#0)
*   Trying 127.0.0.1... connected
* Connected to 127.0.0.1 (127.0.0.1) port 3000 (#0)
> GET / HTTP/1.1
> User-Agent: curl/7.21.4 (universal-apple-darwin11.0) libcurl/7.21.4 OpenSSL/0.9.8r zlib/1.2.5
> Host: 127.0.0.1:3000
> Accept: */*
> 
< HTTP/1.1 200 OK
< X-Powered-By: Express
< Content-Type: text/csv; charset=utf-8
< Content-Length: 26
< Connection: keep-alive
< 
"a","b","c"
"d","e","f"
* Connection #0 to host 127.0.0.1 left intact
* Closing connection #0
```

Alternatively, you can also pass an array of objects to be serialized, in which case the object's
properties will be iterated over.  E.g.:

```js
res.csv([ { name: "joe", id: 1 }]
//=> "joe", 1
```

## License

    The MIT License

    Copyright (c) 2012 Seiya Konno <nulltask@gmail.com>

    Permission is hereby granted, free of charge, to any person obtaining
    a copy of this software and associated documentation files (the
    'Software'), to deal in the Software without restriction, including
    without limitation the rights to use, copy, modify, merge, publish,
    distribute, sublicense, and/or sell copies of the Software, and to
    permit persons to whom the Software is furnished to do so, subject to
    the following conditions:

    The above copyright notice and this permission notice shall be
    included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
    IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
    CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
    TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
    SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.