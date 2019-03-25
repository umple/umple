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
/// <reference types="node" />
import GeneratedDiscoveryV1 = require('./v1-generated');
declare class DiscoveryV1 extends GeneratedDiscoveryV1 {
    static VERSION_DATE_2017_09_01: string;
    static VERSION_DATE_2017_08_01: string;
    static VERSION_DATE_2017_07_19: string;
    static VERSION_DATE_2017_06_25: string;
    static VERSION_DATE_2016_12_01: string;
    static VERSION_DATE_2017_04_27: string;
    static VERSION_DATE_2016_12_15: string;
    static _ensureFilename(file: any): any;
    constructor(options: any);
    getEnvironments(params: any, callback: any): void | NodeJS.ReadableStream;
    createEnvironment(params: any, callback: any): void | NodeJS.ReadableStream;
    updateEnvironment(params: any, callback: any): void | NodeJS.ReadableStream;
    updateConfiguration(params: any, callback: any): void | NodeJS.ReadableStream;
    getCollections(params: any, callback: any): void | NodeJS.ReadableStream;
    createCollection(params: any, callback: any): void | NodeJS.ReadableStream;
    updateCollection(params: any, callback: any): void | NodeJS.ReadableStream;
    getCollectionFields(params: any, callback: any): void | NodeJS.ReadableStream;
    getConfigurations(params: any, callback: any): void | NodeJS.ReadableStream;
    createConfiguration(params: any, callback: any): void | NodeJS.ReadableStream;
    addJsonDocument(params: any, callback: any): void | NodeJS.ReadableStream;
    updateJsonDocument(params: any, callback: any): void | NodeJS.ReadableStream;
    query(params: any, callback: any): void | NodeJS.ReadableStream;
}
export = DiscoveryV1;
