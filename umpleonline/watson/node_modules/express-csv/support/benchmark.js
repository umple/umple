#!/usr/bin/env node

var express = require('express')
  , request = require('superagent')
  , csv = require('../')
  , app = express.createServer()
  , data = [];

for (var i = 0; i < 1000; ++i) {
  var record = [];
  for (var j = 0; j < 100; ++j) {
    record.push(j);
  }
  data.push(record);
}

app.get('/', function(req, res) {
  res.csv(data);
});

app.listen(8383);

function benchmark(time) {
  var url = 'http://127.0.0.1:8383/'
    , label = 'benchmark - ' + time + 'times'
    , fn = function() {
        --time || !function() {
          console.timeEnd(label);
          process.exit(0);
        }();
      };

  console.time(label);
  for (var i = 0, len = time; i < len; ++i) {
    request(url).end(fn);
  }
}

benchmark(100);
