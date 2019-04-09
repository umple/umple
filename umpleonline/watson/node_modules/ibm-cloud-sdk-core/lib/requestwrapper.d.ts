/// <reference types="request" />
import request = require('request');
/**
 * Check if the service/request have error and try to format them.
 * @param  {Function} cb the request callback
 * @private
 * @returns {request.RequestCallback}
 */
export declare function formatErrorIfExists(cb: Function): request.RequestCallback;
/**
 * Creates the request.
 * 1. Merge default options with user provided options
 * 2. Checks for missing parameters
 * 3. Encode path and query parameters
 * 4. Call the api
 * @private
 * @returns {ReadableStream|undefined}
 * @throws {Error}
 */
export declare function sendRequest(parameters: any, _callback: any): any;
