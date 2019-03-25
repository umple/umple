"use strict";
/**
 * Copyright 2014 IBM Corp. All Rights Reserved.
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
Object.defineProperty(exports, "__esModule", { value: true });
var extend = require("extend");
var fileType = require("file-type");
var isstream_1 = require("isstream");
var mime_types_1 = require("mime-types");
var path_1 = require("path");
// custom type guards
function isFileObject(obj) {
    return obj && obj.value;
}
function isFileStream(obj) {
    return obj && isstream_1.isReadable(obj) && obj.path;
}
function isFileParam(obj) {
    return (obj &&
        (isstream_1.isReadable(obj) || Buffer.isBuffer(obj) || isFileObject(obj) || obj.data));
}
exports.isFileParam = isFileParam;
function isEmptyObject(obj) {
    return obj && Object.keys(obj).length === 0 && obj.constructor === Object;
}
exports.isEmptyObject = isEmptyObject;
/**
 * This function retrieves the content type of the input.
 * @param {NodeJS.ReadableStream|Buffer|string} inputData - The data to retrieve content type for.
 * @returns {string} the content type of the input.
 */
function getContentType(inputData) {
    var contentType = null;
    if (isFileStream(inputData)) {
        // if the inputData is a NodeJS.ReadableStream
        var mimeType = mime_types_1.lookup(inputData.path);
        contentType = { mime: mimeType || null };
    }
    else if (Buffer.isBuffer(inputData)) {
        // if the inputData is a Buffer
        contentType = fileType(inputData);
    }
    else if (typeof inputData === 'string') {
        // if the inputData is a string
        contentType = fileType(Buffer.from(inputData));
    }
    return contentType ? contentType.mime : null;
}
exports.getContentType = getContentType;
/**
 *
 * @param {string} url - the url string.
 * @returns {string}
 */
function stripTrailingSlash(url) {
    // Match a forward slash / at the end of the string ($)
    return url.replace(/\/$/, '');
}
exports.stripTrailingSlash = stripTrailingSlash;
/**
 * Validates that all required params are provided
 * @param params - the method parameters.
 * @param requires - the required parameter names.
 * @returns {Error|null}
 */
function getMissingParams(params, requires) {
    var missing;
    if (!requires) {
        return null;
    }
    else if (!params) {
        missing = requires;
    }
    else {
        missing = [];
        requires.forEach(function (require) {
            if (!params[require]) {
                missing.push(require);
            }
        });
    }
    return missing.length > 0
        ? new Error('Missing required parameters: ' + missing.join(', '))
        : null;
}
exports.getMissingParams = getMissingParams;
/**
 * Return true if 'text' is html
 * @param  {string} text - The 'text' to analyze
 * @returns {boolean} true if 'text' has html tags
 */
function isHTML(text) {
    return /<[a-z][\s\S]*>/i.test(text);
}
exports.isHTML = isHTML;
/**
 * Returns the first match from formats that is key the params map
 * otherwise null
 * @param  {Object} params - The parameters.
 * @param  {string[]} requires - The keys we want to check
 * @returns {string|null}
 */
function getFormat(params, formats) {
    if (!formats || !params) {
        return null;
    }
    for (var _i = 0, formats_1 = formats; _i < formats_1.length; _i++) {
        var item = formats_1[_i];
        if (item in params) {
            return item;
        }
    }
    return null;
}
exports.getFormat = getFormat;
/**
 * this function builds a `form-data` object for each file parameter
 * @param {FileParamAttributes} fileParams - the file parameter attributes
 * @param {NodeJS.ReadableStream|Buffer|FileObject} fileParams.data - the data content of the file
 * @param {string} fileParams.contentType - the content type of the file
 * @returns {FileObject}
 */
function buildRequestFileObject(fileParams) {
    // build filename
    var filename;
    if (fileParams.filename) {
        // prioritize user-given filenames
        filename = fileParams.filename;
    }
    else if (isFileObject(fileParams.data) &&
        fileParams.data.options &&
        fileParams.data.value) {
        // if FileObject with value and options
        filename = fileParams.data.options.filename;
    }
    else if (isFileStream(fileParams.data)) {
        // if readable stream with path property
        filename = fileParams.data.path;
    }
    else if (isFileObject(fileParams.data) &&
        isFileStream(fileParams.data.value)) {
        // if FileObject with stream value
        filename = fileParams.data.value.path;
    }
    // toString handles the case when path is a buffer
    filename = filename ? path_1.basename(filename.toString()) : '_';
    // build contentType
    var contentType = 'application/octet-stream';
    if (isFileObject(fileParams.data) &&
        fileParams.data.options &&
        fileParams.data.options.contentType) {
        // if form-data object
        contentType = fileParams.data.options.contentType;
    }
    else if (fileParams.contentType) {
        // for multiple producers, this is either null, or the _content_type parameter
        // for single producers, this is the single content type
        contentType = fileParams.contentType;
    }
    else {
        // else utilize file-type package
        if (isFileObject(fileParams.data)) {
            contentType = getContentType(fileParams.data.value) || contentType;
        }
        else {
            contentType = getContentType(fileParams.data) || contentType;
        }
    }
    // build value
    var value = isFileObject(fileParams.data)
        ? fileParams.data.value
        : fileParams.data;
    if (typeof value === 'string') {
        value = Buffer.from(value);
    }
    return {
        value: value,
        options: {
            filename: filename,
            contentType: contentType
        }
    };
}
exports.buildRequestFileObject = buildRequestFileObject;
/**
 * this function converts an object's keys to lower case
 * @param {Object} headers - the header parameters
 * @returns {Object}
 */
function toLowerKeys(obj) {
    var _obj = {};
    if (obj) {
        _obj = extend.apply(void 0, [{}].concat(Object.keys(obj).map(function (key) {
            var _a;
            return (_a = {},
                _a[key.toLowerCase()] = obj[key],
                _a);
        })));
    }
    return _obj;
}
exports.toLowerKeys = toLowerKeys;
//# sourceMappingURL=helper.js.map