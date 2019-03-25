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
var isStream = require("isstream");
var omit = require("object.omit");
var toCSV = require("../lib/json-training-to-csv");
var GeneratedNaturalLanguageClassifierV1 = require("./v1-generated");
var NaturalLanguageClassifierV1 = /** @class */ (function (_super) {
    __extends(NaturalLanguageClassifierV1, _super);
    function NaturalLanguageClassifierV1(options) {
        return _super.call(this, options) || this;
    }
    NaturalLanguageClassifierV1.prototype.create = function (params, callback) {
        var _this = this;
        console.warn("WARNING: create() was renamed to createClassifier(). Support for create() will be removed in the next major release");
        if (!params || !params.training_data) {
            callback(new Error('Missing required parameters: training_data'));
            return;
        }
        if (!(Array.isArray(params.training_data) ||
            typeof params.training_data === 'string' ||
            isStream(params.training_data))) {
            callback(new Error('training_data needs to be a String, Array or Stream'));
            return;
        }
        toCSV(params.training_data, function (err, csv) {
            if (err) {
                callback(err);
                return;
            }
            var newParams = {
                metadata: Buffer.from(JSON.stringify(omit(params, ['training_data'])), 'utf8'),
                training_data: csv
            };
            return _super.prototype.createClassifier.call(_this, newParams, callback);
        });
    };
    NaturalLanguageClassifierV1.prototype.classify = function (params, callback) {
        var newParams = params || {};
        if (!newParams.classifier_id) {
            newParams.classifier_id = newParams.classifier;
        }
        return _super.prototype.classify.call(this, newParams, callback);
    };
    NaturalLanguageClassifierV1.prototype.status = function (params, callback) {
        console.warn("WARNING: status() was renamed to getClassifier(). Support for status() will be removed in the next major release");
        var newParams = params || {};
        if (!newParams.classifier_id) {
            newParams.classifier_id = newParams.classifier;
        }
        return _super.prototype.getClassifier.call(this, newParams, callback);
    };
    NaturalLanguageClassifierV1.prototype.list = function (params, callback) {
        console.warn("WARNING: list() was renamed to listClassifiers(). Support for list() will be removed in the next major release");
        return _super.prototype.listClassifiers.call(this, params, callback);
    };
    NaturalLanguageClassifierV1.prototype.remove = function (params, callback) {
        console.warn("WARNING: remove() was renamed to deleteClassifier(). Support for remove() will be removed in the next major release");
        var newParams = params || {};
        if (!newParams.classifier_id) {
            newParams.classifier_id = newParams.classifier;
        }
        return _super.prototype.deleteClassifier.call(this, newParams, callback);
    };
    return NaturalLanguageClassifierV1;
}(GeneratedNaturalLanguageClassifierV1));
module.exports = NaturalLanguageClassifierV1;
//# sourceMappingURL=v1.js.map