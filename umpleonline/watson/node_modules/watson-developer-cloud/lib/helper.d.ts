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
/// <reference types="node" />
export interface FileObject {
    value: NodeJS.ReadableStream | Buffer | string;
    options?: FileOptions;
}
export interface FileOptions {
    filename?: string;
    contentType?: string;
}
export interface FileParamAttributes {
    data: NodeJS.ReadableStream | Buffer | FileObject;
    contentType: string;
    filename: string;
}
export interface FileStream extends NodeJS.ReadableStream {
    path: string | Buffer;
}
export declare function isFileParam(obj: any): boolean;
export declare function isEmptyObject(obj: any): boolean;
/**
 * This function retrieves the content type of the input.
 * @param {NodeJS.ReadableStream|Buffer|string} inputData - The data to retrieve content type for.
 * @returns {string} the content type of the input.
 */
export declare function getContentType(inputData: NodeJS.ReadableStream | Buffer | string): string;
/**
 *
 * @param {string} url - the url string.
 * @returns {string}
 */
export declare function stripTrailingSlash(url: string): string;
/**
 * Validates that all required params are provided
 * @param params - the method parameters.
 * @param requires - the required parameter names.
 * @returns {Error|null}
 */
export declare function getMissingParams(params: {
    [key: string]: any;
}, requires: string[]): string[] | Error;
/**
 * Return true if 'text' is html
 * @param  {string} text - The 'text' to analyze
 * @returns {boolean} true if 'text' has html tags
 */
export declare function isHTML(text: string): boolean;
/**
 * Returns the first match from formats that is key the params map
 * otherwise null
 * @param  {Object} params - The parameters.
 * @param  {string[]} requires - The keys we want to check
 * @returns {string|null}
 */
export declare function getFormat(params: {
    [key: string]: any;
}, formats: string[]): string;
/**
 * this function builds a `form-data` object for each file parameter
 * @param {FileParamAttributes} fileParams - the file parameter attributes
 * @param {NodeJS.ReadableStream|Buffer|FileObject} fileParams.data - the data content of the file
 * @param {string} fileParams.contentType - the content type of the file
 * @returns {FileObject}
 */
export declare function buildRequestFileObject(fileParams: FileParamAttributes): FileObject;
/**
 * this function converts an object's keys to lower case
 * @param {Object} headers - the header parameters
 * @returns {Object}
 */
export declare function toLowerKeys(obj: Object): Object;
