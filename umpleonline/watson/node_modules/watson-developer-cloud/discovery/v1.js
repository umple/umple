"use strict";
/**
 * Copyright 2017 IBM All Rights Reserved.
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
var extend = require("extend");
var isStream = require("isstream");
var GeneratedDiscoveryV1 = require("./v1-generated");
var DiscoveryV1 = /** @class */ (function (_super) {
    __extends(DiscoveryV1, _super);
    function DiscoveryV1(options) {
        var _this = this;
        // For backward compatibility, allow version to be passed in version_date.
        var _options = extend({}, options);
        _options.version = _options.version_date || _options.version;
        _this = _super.call(this, _options) || this;
        return _this;
    }
    DiscoveryV1._ensureFilename = function (file) {
        // no changes needed for streams created by fs.ReadStream (or similar looking streams)
        if (isStream.isReadable(file) && file.path) {
            return file;
        }
        // next handle request-style value/options objects
        if (file &&
            file.hasOwnProperty('value') &&
            file.hasOwnProperty('options')) {
            if (file.options.filename) {
                return file;
            }
            return {
                value: file.value,
                options: extend({ filename: '_' }, file.options)
            };
        }
        // finally, handle all other cases by wrapping them in a request-style value/options object
        return {
            value: file,
            options: {
                filename: '_'
            }
        };
    };
    DiscoveryV1.prototype.getEnvironments = function (params, callback) {
        console.warn("WARNING: getEnvironments() was renamed to listEnvironments(). Support for getEnvironments() will be removed in the next major release");
        return _super.prototype.listEnvironments.call(this, params, callback);
    };
    DiscoveryV1.prototype.createEnvironment = function (params, callback) {
        // make sure environments with size 0 can be created
        if (params.size !== 0 && !params.size) {
            params.size = 1;
        }
        return _super.prototype.createEnvironment.call(this, params, callback);
    };
    DiscoveryV1.prototype.updateEnvironment = function (params, callback) {
        return _super.prototype.updateEnvironment.call(this, params, callback);
    };
    DiscoveryV1.prototype.updateConfiguration = function (params, callback) {
        // name is now a required parameter
        // file is now split into conversions, enrichments and normalizations
        var newParams = params || {};
        if (newParams.file) {
            var _a = newParams.file, conversions = _a.conversions, enrichments = _a.enrichments, normalizations = _a.normalizations;
            newParams.conversions = conversions;
            newParams.enrichments = enrichments;
            newParams.normalizations = normalizations;
        }
        newParams.name = newParams.name || '_';
        return _super.prototype.updateConfiguration.call(this, newParams, callback);
    };
    DiscoveryV1.prototype.getCollections = function (params, callback) {
        console.warn("WARNING: getCollections() was renamed to listCollections(). Support for getCollections() will be removed in the next major release");
        return _super.prototype.listCollections.call(this, params, callback);
    };
    DiscoveryV1.prototype.createCollection = function (params, callback) {
        // language_code is now called language
        if (params) {
            params.language = params.language || params.language_code || 'en_us';
        }
        return _super.prototype.createCollection.call(this, params, callback);
    };
    DiscoveryV1.prototype.updateCollection = function (params, callback) {
        // collection_name is now called name
        if (params) {
            params.name = params.name || params.collection_name;
        }
        return _super.prototype.updateCollection.call(this, params, callback);
    };
    DiscoveryV1.prototype.getCollectionFields = function (params, callback) {
        console.warn("WARNING: getCollectionFields() was renamed to listCollectionFields(). Support for getCollectionFields() will be removed in the next major release");
        // listFields expects an array of collection ids
        if (params && !Array.isArray(params.collection_id)) {
            params.collection_ids = [params.collection_id];
        }
        return _super.prototype.listFields.call(this, params, callback);
    };
    DiscoveryV1.prototype.getConfigurations = function (params, callback) {
        console.warn("WARNING: getConfigurations() was renamed to listConfigurations(). Support for getConfigurations() will be removed in the next major release");
        return _super.prototype.listConfigurations.call(this, params, callback);
    };
    DiscoveryV1.prototype.createConfiguration = function (params, callback) {
        // name is now a required parameter
        // file is now split into conversions, enrichments and normalizations
        var newParams = params || {};
        if (newParams.file) {
            var _a = newParams.file, conversions = _a.conversions, enrichments = _a.enrichments, normalizations = _a.normalizations;
            newParams.conversions = conversions;
            newParams.enrichments = enrichments;
            newParams.normalizations = normalizations;
        }
        newParams.name = newParams.name || '_';
        return _super.prototype.createConfiguration.call(this, newParams, callback);
    };
    DiscoveryV1.prototype.addJsonDocument = function (params, callback) {
        console.warn("WARNING: addJsonDocument() was renamed to addDocument(). Support for addJsonDocument() will be removed in the next major release");
        var fileParamType = typeof params.file;
        if (fileParamType !== 'object') {
            throw new Error("Argument error: params.file must be an object, but got " + fileParamType + ".");
        }
        var newParams = extend(params, {
            file: {
                value: JSON.stringify(params.file),
                options: {
                    filename: '_.json'
                }
            }
        });
        return this.addDocument(newParams, callback);
    };
    DiscoveryV1.prototype.updateJsonDocument = function (params, callback) {
        console.warn("WARNING: updateJsonDocument() was renamed to updateDocument(). Support for updateJsonDocument() will be removed in the next major release");
        var fileParamType = typeof params.file;
        if (fileParamType !== 'object') {
            throw new Error("Argument error: params.file must be an object, but got " + fileParamType + ".");
        }
        var newParams = extend(params, {
            file: {
                value: JSON.stringify(params.file),
                options: {
                    filename: '_.json'
                }
            }
        });
        return this.updateDocument(newParams, callback);
    };
    DiscoveryV1.prototype.query = function (params, callback) {
        var newParams = params || {};
        // query and natural_language_query can't both be populated
        if (newParams.query && newParams.natural_language_query) {
            delete newParams.natural_language_query;
        }
        if (newParams.return) {
            newParams.return_fields = newParams.return;
        }
        // passages parameters are now snake case
        Object.keys(newParams).forEach(function (key) {
            return key.match(/passages\..*/i) &&
                (newParams[key.replace('.', '_')] = newParams[key]);
        });
        return _super.prototype.query.call(this, newParams, callback);
    };
    DiscoveryV1.VERSION_DATE_2017_09_01 = '2017-09-01';
    DiscoveryV1.VERSION_DATE_2017_08_01 = '2017-08-01';
    DiscoveryV1.VERSION_DATE_2017_07_19 = '2017-07-19';
    DiscoveryV1.VERSION_DATE_2017_06_25 = '2017-06-25';
    DiscoveryV1.VERSION_DATE_2016_12_01 = '2016-12-01';
    DiscoveryV1.VERSION_DATE_2017_04_27 = '2017-04-27';
    DiscoveryV1.VERSION_DATE_2016_12_15 = '2016-12-15';
    return DiscoveryV1;
}(GeneratedDiscoveryV1));
module.exports = DiscoveryV1;
//# sourceMappingURL=v1.js.map