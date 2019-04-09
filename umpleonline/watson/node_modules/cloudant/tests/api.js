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

// Cloudant client API tests
require('dotenv').config();

var fs = require('fs');
var should = require('should');

var nock = require('./nock.js');
var Cloudant = require('../cloudant.js');


// These globals may potentially be parameterized.
var ME = process.env.cloudant_username || 'nodejs';
var PASSWORD = process.env.cloudant_password || null;
var SERVER = 'https://' + ME + '.cloudant.com';
var MYDB = 'mydb';
var mydb = null;
var cc = null;
var ddoc = null;
var viewname = null;


describe('Cloudant API', function() {
  it('is a function', function() {
    Cloudant.should.be.type('function');
  });
  it('has arity 2: options, callback', function() {
    Cloudant.should.have.lengthOf(2);
  });
});

describe('Initialization', function() {
  it('runs synchronously with one argument', function() {
    (function() {
      var db = Cloudant({account:ME});
    }).should.not.throw();
  });

  it('supports a ping callback', function(done) {
    var mocks = nock(SERVER)
      .get('/_session').reply(200, {ok:true, userCtx:{name:null,roles:[]}})
      .get('/')        .reply(200, {couchdb:'Welcome', version:'1.0.2'});

    Cloudant({account:ME}, function(er, cloudant, body) {
      should(er).equal(null, 'No problem pinging Cloudant');
      cloudant.should.be.an.Object;
      body.should.be.an.Object;
      body.should.have.a.property("couchdb");
      body.should.have.a.property("version");
      body.should.have.a.property("userCtx");
      body.userCtx.should.be.an.Object;
      body.userCtx.should.have.a.property("name");
      body.userCtx.should.have.a.property("roles");
      body.userCtx.roles.should.be.an.Array;

      mocks.done();
      done();
    });
  });

  it('uses cookie auth for ping callback', function(done) {
    var mocks = nock(SERVER)
      .get('/_session').reply(200, {ok:true, userCtx:{name:null,roles:[]}})
      .post('/_session').reply(200, {ok:true, userCtx:{name:ME,roles:[]}})
      .get('/')        .reply(200, {couchdb:'Welcome', version:'1.0.2'});

    Cloudant({account:ME, account:ME, password:PASSWORD}, function(er, cloudant, welcome) {
      should(er).equal(null, 'No problem pinging Cloudant');
      cloudant.should.be.an.Object;

      mocks.done();
      done();
    });
  });

  it('supports instantiation without a callback', function(done) {
    var c = Cloudant({account:ME});
    // check we get a Nano object back
    c.should.be.an.Object;
    c.should.have.property("use");
    c.should.have.property("config");
    c.should.have.property("db");
    c.should.have.property("relax");
    done();
  });
});

describe('Authentication', function() {
  it('supports Authentication API - POST /_api/v2/api_keys', function(done) {
    var mocks = nock(SERVER)
      .post('/_api/v2/api_keys').reply(200, { "password": "Eivln4jPiLS8BoTxjXjVukDT", "ok": true, "key": "thandoodstrenterprourete" });

    var c = Cloudant({account:ME, password:PASSWORD});
    c.generate_api_key(function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("password");
      d.password.should.be.a.String;
      d.should.have.a.property("ok");
      d.ok.should.be.a.Boolean;
      d.should.have.a.property("key");
      d.key.should.be.a.String;

      mocks.done();
      done();
    });
  });
});

describe('CORS', function() {
  it('supports CORS API - GET /_api/v2/user/config/cors', function(done) {
    var mocks = nock(SERVER)
      .get('/_api/v2/user/config/cors').reply(200, { "enable_cors": true, "allow_credentials": true, "origins": ["*"]});

    var c = Cloudant({account:ME, password:PASSWORD});
    c.get_cors(function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("enable_cors");
      d.enable_cors.should.be.a.Boolean;
      d.should.have.a.property("allow_credentials");
      d.allow_credentials.should.be.a.Boolean;
      d.should.have.a.property("origins");
      d.origins.should.be.an.Array;

      mocks.done();
      done();
    });
  });

  it('supports CORS API - PUT /_api/v2/user/config/cors', function(done) {
    var mocks = nock(SERVER)
      .put('/_api/v2/user/config/cors').reply(200, { "ok": true });

    var c = Cloudant({account:ME, password:PASSWORD});
    c.set_cors({ "enable_cors": true, "allow_credentials": true, "origins": ["*"]}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);

      mocks.done();
      done();
    });
  });
});

describe('Authorization', function() {
  this.timeout(10 * 1000);

  before(function(done) {
    var mocks = nock(SERVER)
      .put('/' + MYDB).reply(200, { "ok": true });

    cc = Cloudant({account:ME, password:PASSWORD});
    cc.db.create(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = cc.db.use("mydb");

      mocks.done();
      done();
    });
  });

  it('supports Authorization API GET _api/v2/db/<db>/_security', function(done) {
    var mocks = nock(SERVER)
      .get('/_api/v2/db/' + MYDB + '/_security').reply(200, { });

    mydb.get_security(function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.be.empty;

      mocks.done();
      done();
    });
  });

  it('supports Authorization API - PUT _api/v2/db/<db/_security', function(done) {
    var mocks = nock(SERVER)
      .put('/_api/v2/db/' + MYDB + '/_security').reply(200, { "ok": true });

    mydb.set_security({ "nobody": ["_reader"]}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);

      mocks.done();
      done();
    });
  });

  after(function(done) {
    var mocks = nock(SERVER)
      .delete('/' + MYDB).reply(200, { "ok": true });

    cc.db.destroy(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = null;
      cc = null;

      mocks.done();
      done();
    });
  });
});

describe('Changes query', function() {
  before(function(done) {
    var mocks = nock(SERVER)
      .put('/' + MYDB).reply(200, { "ok": true });

    cc = Cloudant({account:ME, password:PASSWORD});
    cc.db.create(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = cc.db.use("mydb");
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });

  it('create query dummy data', function(done) {
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_bulk_docs')
      .reply(200, [{"id":"doc1","rev":"1-967a00dff5e02add41819138abb3284d"},{"id":"doc2","rev":"1-967a00dff5e02add41819138abb3284d"}]);

    mydb.bulk({docs: [ {_id:'doc1'},{_id:'doc2'} ]}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Array;
      for (var i in d) {
        d[i].should.be.an.Object;
        d[i].should.have.a.property("id");
        d[i].should.have.a.property("rev");
      }

      mocks.done();
      done();
    });
  });

  // Remember the first change for subsequent tests.
  var firstChange = null

  it('gets a simple changes feed', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_changes')
      .reply(200, { results: [ { seq: '1-g1AAAAEJeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WIgORGpIcgGRSPUhPBnMiYy6Qx25uZm5uYJpGSD-RNuSxAEmGBiAFtGQ_hstM8es7ANEH8lEWACBUVnc', id: 'doc2', changes: [ { rev: '1-967a00dff5e02add41819138abb3284d' } ] }, { seq: '2-g1AAAAEzeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgN0s2MjZLMyVSe5IDkEyqh5rACDbB3Mzc3MA0jUgT8liAJEMDkAIash_hDgPzNJPEZENUU0zxm3IAYgrQLcxQtxilppilGBkTMiMLAAylXs8', id: 'doc1', changes: [ { rev: '1-967a00dff5e02add41819138abb3284d' } ] } ], last_seq: '2-g1AAAAETeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgN0s2MjZLMyVSe5IDkEyqh5rACDbB3Mzc3MA0jUgT8liAJEMDkAIash_hDgPzNJPEZENUU0zxm3IAYgqSW4xSU8xSjIyzAPAlU1s', pending: 0 });

    mydb.changes(function(er, body) {
      should(er).equal(null);
      body.should.have.a.property('last_seq');
      body.should.have.a.property('results').which.is.instanceOf(Object);
      body.results.should.have.a.length(2);
      body.results[0].should.be.an.Object.and.have.a.property('id').and.match(/^doc[12]$/);
      body.results[0].should.be.an.Object.and.have.a.property('seq').and.match(/^1-/);
      body.results[1].should.be.an.Object.and.have.a.property('id').and.match(/^doc[12]$/);
      body.results[1].should.be.an.Object.and.have.a.property('seq').and.match(/^2-/);

      firstChange = body.results[0];

      mocks.done();
      done();
    });
  });

  it('supports the "since" parameter', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_changes?since='+firstChange.seq)
      .reply(200, { results: [ { seq: '2-g1AAAAEzeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgTzNKNTBPskTVboZLe5IDkEyqB5vAnMgINsEwKTXVxDKFkH4iHZjHAiQZGoAU0JL9CHemmCVbGqdZkmTKAYgpYN9C3GpiaWhiYmCeBQCL518O', id: 'doc2', changes: [Object] } ], last_seq: '2-g1AAAAETeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgTzNKNTBPskTVboZLe5IDkEyqh5rACDbBMCk11cQyhUgH5LEASYYGIAU0ZD_CHSlmyZbGaZYkmXIAYgqSW0wsDU1MDMyzAGgWU5k', pending: 0 });

    mydb.changes({since:firstChange.seq}, function(er, body) {
      should(er).equal(null);
      body.results.should.have.a.length(1);
      body.results[0].should.be.an.Object.and.have.a.property('id').and.match(/^doc[12]$/);
      body.results[0].should.be.an.Object.and.have.a.property('seq').and.match(/^2-/);

      mocks.done();
      done();
    });
  });

  it('supports since="now"', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_changes?since=now')
      .reply(200, { results: [], last_seq: '2-g1AAAAETeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgTzNINUkzNCZSe5IDkEyqh5rACDbB1CQpzdI8lUgT8liAJEMDkAIash_hDoMkE7MkAwuSTDkAMQXJLSlpRuaGJiZZADxoU4k', pending: 0 });

    mydb.changes({since:'now'}, function(er, body) {
      should(er).equal(null);
      body.results.should.have.a.length(0);

      mocks.done();
      done();
    });
  });

  after(function(done) {
    var mocks = nock(SERVER)
      .delete('/' + MYDB).reply(200, { "ok": true });

    cc.db.destroy(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = null;
      cc = null;
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });
});

describe('Changes follower', function() {
  before(function(done) {
    var mocks = nock(SERVER)
      .put('/' + MYDB).reply(200, { "ok": true });

    cc = Cloudant({account:ME, password:PASSWORD});
    cc.db.create(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = cc.db.use("mydb");
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });

  it('create query dummy data', function(done) {
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_bulk_docs')
      .reply(200, [{"id":"doc1","rev":"1-967a00dff5e02add41819138abb3284d"},{"id":"doc2","rev":"1-967a00dff5e02add41819138abb3284d"}]);

    mydb.bulk({docs: [ {_id:'doc1'},{_id:'doc2'} ]}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Array;
      for (var i in d) {
        d[i].should.be.an.Object;
        d[i].should.have.a.property("id");
        d[i].should.have.a.property("rev");
      }

      mocks.done();
      done();
    });
  });

  // Remember the first change for subsequent tests.
  var firstChange = null

  it('follows changes', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB)
      .reply(200, { update_seq: '2-g1AAAADbeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtUrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WIgORGpIcgGRSPVgPI5F68liAJEMDkAJq20-8XRB9ByD6QPZlAQCMOkh4', db_name: 'mydb', sizes: { file: 58038, external: 8, active: 2166 }, purge_seq: 0, other: { data_size: 8 }, doc_del_count: 0, doc_count: 2, disk_size: 58038, disk_format_version: 6, compact_running: false, instance_start_time: '0' })
      .filteringPath(/[?&](since=.*|feed=continuous|heartbeat=.*)/g, '') // Strip out the standard parameters: ?since=0&feed=continuous&heartbeat=30000
      .get('/' + MYDB + '/_changes')
      .reply(200, '{"seq":"1-g1AAAAEleJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgN7cAQoNkVO1muLQnOQDJpHqQCYkMRFqZxwIkGRqAFFDbfoTNhomWaSZJxkTaDDHlAMQUoPuZExnBppgZG6clJ5kSMiMLABOLXCo","id":"doc1","changes":[{"rev":"1-967a00dff5e02add41819138abb3284d"}]}\n' +
        '{"seq":"2-g1AAAAFTeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgN7cAQoNkVO1muLQnOQDJpHqwCcyJjGATEi0NkpOTkgnpJ9KBeSxAkqEBSAEt2Y9wp2GiZZpJkjGR7oSYcgBiCpJbzYyN05KTTAmZkQUA7ZNq0w","id":"doc2","changes":[{"rev":"1-967a00dff5e02add41819138abb3284d"}]}\n');

    var iterations = 0;
    var feed = mydb.follow(function(er, change) {
      should(er).equal(null);
      iterations += 1;
      change.should.be.an.Object;
      change.should.have.a.property('id').and.match(/^doc[12]$/);

      // First change should match "1-...", second should match "2-...".
      change.should.have.a.property('seq').and.match(new RegExp('^' + iterations + '-'));

      if (iterations == 1) {
        firstChange = change;
      } else if (iterations == 2) {
        feed.stop();

        mocks.done();
        done();
      }
    });
  });

  it('supports the "since" parameter', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB)
      .reply(200, { update_seq: '2-g1AAAADbeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtUrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WIgORGpIcgGRSPVgPI5F68liAJEMDkAJq20-8XRB9ByD6QPZlAQCMOkh4', db_name: 'mydb', sizes: { file: 58038, external: 8, active: 2166 }, purge_seq: 0, other: { data_size: 8 }, doc_del_count: 0, doc_count: 2, disk_size: 58038, disk_format_version: 6, compact_running: false, instance_start_time: '0' })
      .filteringPath(/[?&](since=.*|feed=continuous|heartbeat=.*)/g, '') // Strip out the standard parameters: ?since &feed, &heartbeat
      .get('/' + MYDB + '/_changes')
      .reply(200, '{"seq":"2-g1AAAAEzeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtUrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgNzFIM7c0S0XVboZLe5IDkEyqB5vAnMgINiEtLTHR2MSMkH4iHZjHAiQZGoAU0JL9CHcmGVsmG6amkmTKAYgpYN9C3GqalJpikmKUBQBsbl-8","id":"doc2","changes":[{"rev":"1-967a00dff5e02add41819138abb3284d"}]}\n');

    var feed = mydb.follow({since:firstChange.seq}, function(er, change) {
      should(er).equal(null);
      change.should.be.an.Object;
      change.should.have.a.property('id').and.match(/^doc[12]$/);
      change.should.have.a.property('seq').and.match(/^2-/);
      feed.stop();

      mocks.done();
      done();
    });
  });

  it('supports since="now"', function(done) {
    var docId = firstChange.id;

    var mocks = nock(SERVER)
      .get('/' + MYDB)
      .reply(200, { update_seq: '2-g1AAAADbeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtUrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WIgORGpIcgGRSPVgPI5F68liAJEMDkAJq20-8XRB9ByD6QPZlAQCMOkh4', db_name: 'mydb', sizes: { file: 58038, external: 8, active: 2166 }, purge_seq: 0, other: { data_size: 8 }, doc_del_count: 0, doc_count: 2, disk_size: 58038, disk_format_version: 6, compact_running: false, instance_start_time: '0' })
      .post('/' + MYDB)
      .reply(200, {ok:true,id:docId,rev:"2-a1933e6ba0b5ac9868cd6f5adc12dc5f"})
      .filteringPath(/[?&](since=.*|feed=continuous|heartbeat=.*)/g, '') // Strip out the standard parameters: ?since &feed, &heartbeat
      .get('/' + MYDB + '/_changes')
      .reply(200, '{"seq":"3-g1AAAAEzeJzLYWBgYMlgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASpjSmRIsv___39WBpCVCxRgT05OSjQ0SyNSe5IDkEyqB5vAnMgENsHM1CDZPDGFkH4ibchjAZIMDUAKaMl-hDtTLZMMktOMSDLlAMQUsG8ZIaYYWpqmGCVnAQDI71_n","id":"'+docId+'","changes":[{"rev":"2-a1933e6ba0b5ac9868cd6f5adc12dc5f"}]}\n');

    // Make an update that will trigger the "since=now" follower.
    setTimeout(update_doc, 1);
    var feed = mydb.follow({since:'now'}, on_change);

    function update_doc() {
      var newDoc = {_id:docId, _rev:firstChange.changes[0].rev, newField:'newValue'}
      mydb.insert(newDoc, function(er, result) {
        should(er).equal(null);
      });
    }

    function on_change(er, change) {
      should(er).equal(null);
      change.should.have.a.property('id').and.equal(docId);
      change.should.have.a.property('seq').and.match(/^3-/);
      feed.stop();

      mocks.done();
      done();
    }
  });

  after(function(done) {
    var mocks = nock(SERVER)
      .delete('/' + MYDB).reply(200, { "ok": true });

    cc.db.destroy(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = null;
      cc = null;
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });
});

describe('Cloudant Query', function() {
  before(function(done) {
    var mocks = nock(SERVER)
      .put('/' + MYDB).reply(200, { "ok": true });

    cc = Cloudant({account:ME, password:PASSWORD});
    cc.db.create(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = cc.db.use("mydb");
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });

  it('create query dummy data', function(done) {
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_bulk_docs')
      .reply(200, [{"id":"f400bde9395b9116d108ebc89aa816b8","rev":"1-23202479633c2b380f79507a776743d5"},{"id":"f400bde9395b9116d108ebc89aa81bb8","rev":"1-3975759ccff3842adf690a5c10caee42"},{"id":"f400bde9395b9116d108ebc89aa82127","rev":"1-027467bd0efec85f21c822a8eb537073"}]);

    mydb.bulk({docs: [ {a:1},{a:2}, {a:3} ]}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Array;
      for (var i in d) {
        d[i].should.be.an.Object;
        d[i].should.have.a.property("id");
        d[i].should.have.a.property("rev");
      }

      mocks.done();
      done();
    });
  });

  it('supports Cloudant Query create indexes - POST /<db/_index API call', function(done) {
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_index')
      .reply(200, {"result":"created","id":"_design/32372935e14bed00cc6db4fc9efca0f1537d34a8","name":"32372935e14bed00cc6db4fc9efca0f1537d34a8"});

    mydb.index( { "index": {}, "type": "text"}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("result");
      d.result.should.be.a.String;
      d.result.should.be.equal("created");
      d.should.have.a.property("id");
      d.should.have.a.property("name");
      ddoc = d.id.replace(/_design\//,"");
      viewname = d.name;

      mocks.done();
      done();
    });

  });

  it('supports Cloudant Query get indexes - GET /<db/_index', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_index')
      .reply(200, {"indexes":[{"ddoc":null,"name":"_all_docs","type":"special","def":{"fields":[{"_id":"asc"}]}},{"ddoc":"_design/32372935e14bed00cc6db4fc9efca0f1537d34a8","name":"32372935e14bed00cc6db4fc9efca0f1537d34a8","type":"text","def":{"default_analyzer":"keyword","default_field":{},"selector":{},"fields":[]}}]} );

    mydb.index(function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("indexes");
      d.indexes.should.be.an.Array;
      for (var i in d.indexes) {
        d.indexes[i].should.be.an.Object;
        d.indexes[i].should.have.a.property("ddoc");
        if (typeof d.indexes[i].ddoc == "string" && d.indexes[i].ddoc.indexOf("_design") === 0) {
          d.indexes[i].should.have.a.property("type");
          d.indexes[i].type.should.equal("text");
        }
      }

      mocks.done();
      done();
    });
  });

  it('supports Cloudant Query - POST /<db/_find API call', function(done) {
    var query = { "selector": { "a": { "$gt": 2 }}};
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_find', query)
      .reply(200, {"docs":[ {"_id":"f400bde9395b9116d108ebc89aa82127","_rev":"1-027467bd0efec85f21c822a8eb537073","a":3}],"bookmark": "g2wAAAABaANkABxkYmNvcmVAZGIyLm1lYWQuY2xvdWRhbnQubmV0bAAAAAJhAGI_____amgCRj_wAAAAAAAAYQFq"} );

    mydb.find( query, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("docs");
      d.docs.should.be.an.Array;
      d.docs.should.have.a.length(1);
      d.docs[0].should.have.a.property("a");
      d.docs[0].a.should.be.a.Number;
      d.docs[0].a.should.be.equal(3);

      mocks.done();
      done();
    });
  });

  it('supports deleting a Cloudant Query index - DELETE /db/_design/ddocname/type/viewname', function(done) {
    var path = '/' + MYDB + '/_index/' + ddoc + '/text/' + viewname;
    var mocks = nock(SERVER)
      .delete(path).reply(200, {"ok":true} );

    mydb.index.del({ ddoc: ddoc, name: viewname, type:"text"}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);

      mocks.done();
      done();
    });
  });

  after(function(done) {
    var mocks = nock(SERVER)
      .delete('/' + MYDB).reply(200, { "ok": true });

    cc.db.destroy(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = null;
      cc = null;
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });
});

describe('Cloudant Search', function() {
  before(function(done) {
    var mocks = nock(SERVER)
      .put('/' + MYDB).reply(200, { "ok": true });

    cc = Cloudant({account:ME, password:PASSWORD});
    cc.db.create(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = cc.db.use("mydb");
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });

  it('create search dummy data', function(done) {
    var mocks = nock(SERVER)
      .post('/' + MYDB + '/_bulk_docs')
      .reply(200, [{id:'a_tale',rev:'1-3e1f4ff28eaa99dc471ff994051f30ab'},{id:'towers',rev:'1-35c7c65df2cbb9a5f501717e78c508ee'},{id:'_design/library',rev:'1-1f87108fd3f9969a5d47600d6aa5034b'}]);

    var index = function(doc) {
      index('title', doc.title);
      index('author', doc.author);
    };

    var docs = [
      {_id:'a_tale', title:'A Tale of Two Cities', author:'Charles Dickens'},
      {_id:'towers', title:'The Two Towers'      , author:'J. R. R. Tolkien'},
      { _id: '_design/library',
        indexes: {
          books: {
            analyzer: {
              name:'standard'
            },
            index: index
          }
        }
      }
    ];

    mydb.bulk({docs:docs}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Array;
      for (var i in d) {
        d[i].should.be.an.Object;
        d[i].should.have.a.property("id");
        d[i].should.have.a.property("rev");
      }

      mocks.done();
      done();
    });
  });

  it('searches test data: author:charles', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_design/library/_search/books?q=author%3Acharles')
      .reply(200, { total_rows: 1, bookmark: 'g2wAAAABaANkAB1kYmNvcmVAZGI2LnNsaW5nLmNsb3VkYW50Lm5ldGwAAAACbgQAAAAAgG4EAP___79qaAJGP8iMWIAAAABhAGo', rows: [ { id: 'a_tale', order: [Object], fields: {} } ] });

    mydb.search('library', 'books', {q:'author:charles'}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("total_rows").which.is.equal(1);
      d.bookmark.should.be.a.String;
      d.rows.should.be.instanceOf(Array).and.have.lengthOf(1);
      d.rows[0].should.be.an.Object;
      d.rows[0].should.have.a.property('id').which.is.equal('a_tale');
      d.rows[0].should.have.a.property('order').which.is.instanceOf(Array);

      mocks.done();
      done();
    });
  });

  it('searches test data: title:two', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + '/_design/library/_search/books?q=title%3Atwo')
      .reply(200,{total_rows:2,bookmark:'g1AAAACIeJzLYWBgYMpgTmGQTUlKzi9KdUhJMtcrzsnMS9dLzskvTUnMK9HLSy3JASlLcgCSSfX____PymBysz_RE9EAFEhkIFJ7HguQZGgAUkAT9oONOLy4igFsRBYAPRQqlQ',rows:[{id:'towers',order:[Object],fields:{}},{id:'a_tale',order:[Object],fields:{}}]});

    mydb.search('library', 'books', {q:'title:two'}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("total_rows").which.is.equal(2);
      d.bookmark.should.be.a.String;
      d.rows.should.be.instanceOf(Array).and.have.lengthOf(2);
      d.rows[0].should.be.an.Object;
      d.rows[0].should.have.a.property('id').which.is.equal('towers');
      d.rows[0].should.have.a.property('order').which.is.instanceOf(Array);
      d.rows[1].should.be.an.Object;
      d.rows[1].should.have.a.property('id').which.is.equal('a_tale');
      d.rows[1].should.have.a.property('order').which.is.instanceOf(Array);

      mocks.done();
      done();
    });
  });

  after(function(done) {
    var mocks = nock(SERVER)
      .delete('/' + MYDB).reply(200, { "ok": true });

    cc.db.destroy(MYDB, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.equal(true);
      mydb = null;
      cc = null;
      ddoc = viewname = null;

      mocks.done();
      done();
    });
  });
});

describe('User Agent tests', function() {
  var server = null;

  before(function(done) {
    server =  require("http").createServer(function(request, response) {
        response.writeHead(200, {"Content-Type": "application/json"});
        response.end(JSON.stringify(request.headers));
    }).listen(8080);
    done();
  });

  it('checks that the library is using a custom user-agent', function(done) {
    var cc = Cloudant("http://localhost:8080");
    var db = cc.db.use("justtesting");
    db.get("justtesting2", function(er, data) {
      should(er).equal(null);
      data.should.be.an.Object;
      data.should.have.a.property("user-agent");
      data["user-agent"].should.be.a.String;
      var pkg = require("../package.json");
      data["user-agent"].should.match(/^nodejs-cloudant/);
      data["user-agent"].should.containEql("Node.js");
      data["user-agent"].should.containEql(process.version); // node.js version number
      data["user-agent"].should.containEql(pkg.version); // library version number
      done();
    });
  });

  after(function(done) {
    server.close();
    done();
  });
});

describe('Gzip header tests', function() {
  var server = null;

  before(function(done) {
    server =  require("http").createServer(function(request, response) {
        response.writeHead(200, {"Content-Type": "application/json"});
        response.end(JSON.stringify(request.headers));
    }).listen(8080);
    done();
  });

  it('checks that the library is providing "I accept compression" headers', function(done) {
    var cc = Cloudant("http://localhost:8080");
    var db = cc.db.use("justtesting");
    db.get("justtesting2", function(er, data) {
      should(er).equal(null);
      data.should.be.an.Object;
      data.should.have.a.property("accept-encoding");
      data["accept-encoding"].should.be.a.String;
      data["accept-encoding"].should.equal("gzip");
      done();
    });
  });

  after(function(done) {
    server.close();
    done();
  });
});

if (! process.env.NOCK_OFF) {
  describe('Gzip attachment tests', test_gzip);
}
function test_gzip() {
  it('checks that the zipped response is unzipped', function(done) {
    var mocks = nock(SERVER)
      .get('/' + MYDB + "/x/y.css").replyWithFile(200, __dirname + '/y.css.gz', {
        'content-encoding': 'gzip',
        'content-type': 'text/css'
      });

    var c = Cloudant({account:ME, password:PASSWORD});
    var mydb = c.db.use(MYDB);
    mydb.attachment.get("x","y.css", function(er,data) {
      should(er).equal(null);
      data.should.be.an.Object;
      var original = fs.readFileSync( __dirname + '/y.css');
      data.toString().should.be.equal(original.toString());

      mocks.done();
      done();
    });
  });
}

describe('Virtual Hosts', function() {
  it('supports virtual hosts API - GET /_api/v2/user/virtual_hosts', function(done) {
    var mocks = nock(SERVER)
      .get('/_api/v2/user/virtual_hosts').reply(200, {"virtual_hosts": []});

    var c = Cloudant({account:ME, password:PASSWORD});
    c.get_virtual_hosts(function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("virtual_hosts");
      d.virtual_hosts.should.be.an.Array;

      mocks.done();
      done();
    });
  });

  it('supports virtual hosts API - POST /_api/v2/user/virtual_hosts', function(done) {
    var mocks = nock(SERVER)
      .post('/_api/v2/user/virtual_hosts').reply(200, {"ok": true});

    var c = Cloudant({account:ME, password:PASSWORD});
    c.add_virtual_host({ host: "myhost.com", path:"/mypath"}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.a.Boolean;
      d.ok.should.equal(true);

      mocks.done();
      done();
    });
  });

  it('supports virtual hosts API - DELETE /_api/v2/user/config/virtual_hosts', function(done) {
    var mocks = nock(SERVER)
      .delete('/_api/v2/user/virtual_hosts').reply(200, { "ok": true });

    var c = Cloudant({account:ME, password:PASSWORD});
    c.delete_virtual_host({ host: "myhost.com", path:"/mypath"}, function(er, d) {
      should(er).equal(null);
      d.should.be.an.Object;
      d.should.have.a.property("ok");
      d.ok.should.be.a.Boolean;
      d.ok.should.be.equal(true);

      mocks.done();
      done();
    });
  });
});
