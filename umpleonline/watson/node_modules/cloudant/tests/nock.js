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

function noop() {
  return this;
}

function nock_noop() {
  // Return a completely inert nock-compatible object.
  return {head:noop, get:noop, post:noop, put:noop, 'delete':noop, reply:noop, filteringPath:noop, done:noop, query:noop, replyWithFile:noop};
}

if (process.env.NOCK_OFF) {
  var nock = nock_noop;
} else {
  var nock = require('nock');
}

module.exports = nock;

