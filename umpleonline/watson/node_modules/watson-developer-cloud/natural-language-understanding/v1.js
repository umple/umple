"use strict";
/**
 * Copyright 2017,2018 IBM All Rights Reserved.
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
var GeneratedNaturalLanguageUnderstandingV1 = require("./v1-generated");
var NaturalLanguageUnderstandingV1 = /** @class */ (function (_super) {
    __extends(NaturalLanguageUnderstandingV1, _super);
    function NaturalLanguageUnderstandingV1(options) {
        var _this = this;
        // For backward compatibility, allow version to be passed in version_date.
        var _options = extend({}, options);
        _options.version = _options.version_date || _options.version;
        _this = _super.call(this, _options) || this;
        return _this;
    }
    NaturalLanguageUnderstandingV1.VERSION_DATE_2016_01_23 = '2016-01-23';
    NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27 = '2017-02-27';
    return NaturalLanguageUnderstandingV1;
}(GeneratedNaturalLanguageUnderstandingV1));
module.exports = NaturalLanguageUnderstandingV1;
//# sourceMappingURL=v1.js.map