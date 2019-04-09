# VCAP_SERVICES

[![Build Status](https://travis-ci.org/germanattanasio/vcap_services.svg?branch=master)](http://travis-ci.org/germanattanasio/vcap_services)
[![Coverage Status](https://coveralls.io/repos/germanattanasio/vcap_services/badge.svg?branch=master&service=github)](https://coveralls.io/github/germanattanasio/vcap_services?branch=master)
[![npm-version](https://img.shields.io/npm/v/vcap_services.svg)](https://www.npmjs.com/package/vcap_services)
[![npm-downloads](https://img.shields.io/npm/dm/vcap_services.svg)](https://www.npmjs.com/package/vcap_services)

Parse and return service credentials from `VCAP_SERVICES` environment variable that [Bluemix] provides.

## Installation

```sh
$ npm install vcap_services --save
```

## Usage

```sh
var vcapServices = require('vcap_services');
var credentials = vcapServices.getCredentials('personality_insights');
console.log(credentials);
```

If `VCAP_SERVICES` is:
```json
{
  "personality_insights": [{
      "credentials": {
        "password": "<password>",
        "url": "<url>",
        "username": "<username>"
      },
    "label": "personality_insights",
    "name": "personality-insights-service",
    "plan": "standard"
  }]
}
```

Output:
```json
{
  "password": "<password>",
  "url": "<url>",
  "username": "<username>"
}
```

### Getting credentials for a specific plan

Get credentials that match a specific service plan.
```sh
var vcapServices = require('vcap_services');
var credentials = vcapServices.getCredentials('personality_insights', 'standard');
console.log(credentials);
```

### Getting credentials for a specific instance
Get credentials that match a specific service instance (replace "YOUR NLC NAME" with the name of your service instance).
```sh
var vcapServices = require('vcap_services');
var credentials = vcapServices.getCredentials('natural_language_classifier', null, 'YOUR NLC NAME');
console.log(credentials);
```

### Getting credentials for a specific plan and instance
Get credentials that match a specific service plan and instance (replace "YOUR NLC NAME" with the name of your service instance).
```sh
var vcapServices = require('vcap_services');
var credentials = vcapServices.getCredentials('natural_language_classifier', 'standard', 'YOUR NLC NAME');
console.log(credentials);
```

## Tests
Running all the tests:
```sh
$ npm test
```

Running a specific test:
```sh
$ mocha -g '<test name>'
```


## License

MIT.

## Contributing
See [CONTRIBUTING](https://github.com/germanattanasio/vcap_services/blob/master/CONTRIBUTING.md).

[Bluemix]: http://bluemix.net/
