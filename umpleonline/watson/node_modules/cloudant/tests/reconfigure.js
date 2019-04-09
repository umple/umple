var should = require('should');
var reconfigure = require('../lib/reconfigure.js');

describe('Reconfigure', function() {
  
  it('is a function', function(done) {
    reconfigure.should.be.a.function;
    done();
  });
  
  it('has arity 1: credentials', function(done) {
    reconfigure.should.have.lengthOf(1);
    done();
  });
  
  it('allows only an account to be passed in', function(done) {
    var credentials = { account: "myaccount"};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://myaccount.cloudant.com");
    done();
  });
  
  it('allows an account and a password to be passed in', function(done) {
    var credentials = { account: "myaccount", password: "mypassword"};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://myaccount:mypassword@myaccount.cloudant.com");
    done();
  });
  
  it('allows a key and an account and a password to be passed in', function(done) {
    var credentials = { account: "myaccount", password: "mypassword", key: "mykey"};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://mykey:mypassword@myaccount.cloudant.com");
    done();
  });
  
  it('allows a username and an account and a password to be passed in', function(done) {
    var credentials = { account: "myaccount", password: "mypassword", username: "myusername"};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://myusername:mypassword@myaccount.cloudant.com");
    done();
  });
  
  it('allows a key and an full domain and a password to be passed in', function(done) {
    var credentials = { account: "myaccount.cloudant.com", password: "mypassword", key: "mykey"};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://mykey:mypassword@myaccount.cloudant.com");
    done();
  });
  
  it('allows complex passwords', function(done) {
    var credentials = { account: "myaccount", password: "mypassword[]{}!#&="};
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://myaccount:mypassword%5B%5D%7B%7D!%23%26%3D@myaccount.cloudant.com");
    done();
  });
  
  it('allows a local CouchDB url to used', function(done) {
    var credentials = { url: "http://localhost:5984" };
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("http://localhost:5984");
    done();
  });
  
  it('allows an HTTP Cloudant URL - switching to HTTPS', function(done) {
    var credentials = { url: "http://mykey:mypassword@mydomain.cloudant.com" };
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://mykey:mypassword@mydomain.cloudant.com");
    done();
  });
  
  it('allows an HTTP Cloudant URL with a port number - switching to HTTPS', function(done) {
    var credentials = { url: "http://mykey:mypassword@mydomain.cloudant.com:80" };
    var url = reconfigure(credentials);
    url.should.be.a.String;
    url.should.equal("https://mykey:mypassword@mydomain.cloudant.com");
    done();
  });
  
});