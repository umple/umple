"use strict";
/**
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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var url = require("url");
var base_service_1 = require("../lib/base_service");
var AuthorizationV1 = /** @class */ (function (_super) {
    __extends(AuthorizationV1, _super);
    /**
     * Authorization Service
     *
     * Generates temporary auth tokens for use in untrusted environments.
     * Tokens expire after one hour.
     *
     * @param {Object} options
     * @param {String} options.username
     * @param {String} options.password
     * @param {String} [options.url] url of the service for which auth tokens are being generated
     * @constructor
     */
    function AuthorizationV1(options) {
        var _this = _super.call(this, options) || this;
        _this['target_url'] = options.url;
        // replace the url to always point to /authorization/api
        var hostname = url.parse(_this._options.url);
        hostname.pathname = '/authorization/api';
        _this._options.url = url.format(hostname);
        return _this;
    }
    /**
     * If using an RC service, get an IAM access token. If using a CF service,
     * get a percent-encoded authorization token based on resource query string param
     *
     * @param {Object} [options]
     * @param {String} [options.url] defaults to url supplied to constructor (if any)
     * @param {Function(err, token)} callback - called with a %-encoded token if CF
     */
    AuthorizationV1.prototype.getToken = function (params, callback) {
        if (typeof params === 'function') {
            callback = params;
            params = { url: this['target_url'] };
        }
        // if the service is an RC instance, return an IAM access token
        if (this.tokenManager) {
            // callback should expect (err, token) format,
            // which is what the token manager will pass in
            return this.tokenManager.getToken(callback);
        }
        // otherwise, return a CF Watson token
        if (!params.url) {
            callback(new Error('Missing required parameters: url'));
            return;
        }
        var parameters = {
            options: {
                method: 'GET',
                url: '/v1/token?url=' + params.url
            },
            defaultOptions: this._options
        };
        return this.createRequest(parameters, callback);
    };
    AuthorizationV1.URL = 'https://stream.watsonplatform.net/authorization/api';
    return AuthorizationV1;
}(base_service_1.BaseService));
AuthorizationV1.prototype.name = 'authorization';
AuthorizationV1.prototype.serviceVersion = 'v1';
module.exports = AuthorizationV1;
//# sourceMappingURL=v1.js.map