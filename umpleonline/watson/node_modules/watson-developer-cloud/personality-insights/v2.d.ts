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
import { RequestResponse } from 'request';
import { BaseService } from '../lib/base_service';
declare class PersonalityInsightsV2 extends BaseService {
    static URL: string;
    /**
     * Construct a PersonalityInsightsV2 object.
     *
     * @param {Object} options - Options for the service.
     * @param {string} options.version_date - The API version date to use with the service, in "YYYY-MM-DD" format. Whenever the API is changed in a backwards incompatible way, a new minor version of the API is released. The service uses the API version for the date you specify, or the most recent version before that date. Note that you should not programmatically specify the current date at runtime, in case the API has been updated since your application's release. Instead, specify a version date that is compatible with your application, and don't change it until your application is ready for a later version.
     * @param {string} [options.url] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/personality-insights/api'). The base url may differ between Bluemix regions.
     * @param {string} [options.username] - The username used to authenticate with the service. Username and password credentials are only required to run your application locally or outside of Bluemix. When running on Bluemix, the credentials will be automatically loaded from the `VCAP_SERVICES` environment variable.
     * @param {string} [options.password] - The password used to authenticate with the service. Username and password credentials are only required to run your application locally or outside of Bluemix. When running on Bluemix, the credentials will be automatically loaded from the `VCAP_SERVICES` environment variable.
     * @param {boolean} [options.use_unauthenticated] - Set to `true` to avoid including an authorization header. This option may be useful for requests that are proxied.
     * @param {Object} [options.headers] - Default headers that shall be included with every request to the service.
     * @param {boolean} [options.headers.X-Watson-Learning-Opt-Out] - Set to `true` to opt-out of data collection. By default, all IBM Watson services log requests and their results. Logging is done only to improve the services for future users. The logged data is not shared or made public. If you are concerned with protecting the privacy of users' personal information or otherwise do not want your requests to be logged, you can opt out of logging.
     * @constructor
     * @returns {PersonalityInsightsV2}
     * @throws {Error}
     */
    constructor(options: PersonalityInsightsV2.Options);
    /**
     * @param {Object} params - The parameters to call the service
     * @param {string} text - The text to analyze.
     * @param {Object} contentItems - A JSON input (if 'text' is not provided).
     * @param {boolean} include_raw - include raw results
     * @param {boolean} accept_language - The language expected for the output.
     * @param {string} language - The language of the input.
     * @param callback The callback.
     * @returns {ReadableStream|void}
     */
    profile(params: PersonalityInsightsV2.ProfileParams, callback: PersonalityInsightsV2.Callback): any;
}
declare namespace PersonalityInsightsV2 {
    type Callback = (error: any, body?: any, response?: RequestResponse) => void;
    type Options = {
        url?: string;
        username?: string;
        password?: string;
        use_unauthenticated?: boolean;
        headers?: object;
    };
    interface ProfileParams {
        text?: string;
        contentItems?: any;
        content_items?: any;
        include_raw?: boolean;
        csv?: boolean;
        csv_headers?: boolean;
        language?: string;
        accept_language?: string;
        acceptLanguage?: string;
    }
}
export = PersonalityInsightsV2;
