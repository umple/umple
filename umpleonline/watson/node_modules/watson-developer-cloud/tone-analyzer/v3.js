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
var helper_1 = require("../lib/helper");
var GeneratedToneAnalyzerV3 = require("./v3-generated");
var ToneAnalyzerV3 = /** @class */ (function (_super) {
    __extends(ToneAnalyzerV3, _super);
    function ToneAnalyzerV3(options) {
        var _this = this;
        // For backward compatibility, allow version to be passed in version_date.
        var _options = extend({}, options);
        _options.version = _options.version_date || _options.version;
        _this = _super.call(this, _options) || this;
        return _this;
    }
    ToneAnalyzerV3.prototype.tone = function (params, callback) {
        if (params && params.tone_input) {
            return _super.prototype.tone.call(this, params, callback);
        }
        var missingParams = helper_1.getMissingParams(params, ['text']);
        if (missingParams) {
            return callback(missingParams);
        }
        var newParams = extend({}, params);
        newParams.tone_input = params.text;
        newParams.content_type = params.isHTML ? 'text/html' : 'text/plain';
        if (params.tones) {
            newParams.tones = params.tones.split(',');
        }
        if (params.sentences) {
            newParams.sentences = params.sentences;
        }
        if (params.language) {
            newParams.content_language = params.language;
        }
        return _super.prototype.tone.call(this, newParams, callback);
    };
    ToneAnalyzerV3.prototype.tone_chat = function (params, callback) {
        console.warn("WARNING: tone_chat() was renamed to toneChat(). Support for tone_chat() will be removed in the next major release");
        var missingParams = helper_1.getMissingParams(params, ['utterances']);
        if (missingParams) {
            return callback(missingParams);
        }
        var newParams = extend({}, params);
        if (params.utterances.utterances) {
            newParams.utterances = params.utterances.utterances;
        }
        return _super.prototype.toneChat.call(this, newParams, callback);
    };
    return ToneAnalyzerV3;
}(GeneratedToneAnalyzerV3));
module.exports = ToneAnalyzerV3;
//# sourceMappingURL=v3.js.map