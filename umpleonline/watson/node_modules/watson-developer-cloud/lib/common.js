"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var os = require("os");
// tslint:disable-next-line:no-var-requires
var pkg = require('../package.json');
function getSdkHeaders(serviceName, serviceVersion, operationId) {
    var sdkName = 'watson-apis-node-sdk';
    var sdkVersion = pkg.version;
    var osName = os.platform();
    var osVersion = os.release();
    var nodeVersion = process.version;
    // note - all node methods are asynchronous, 'async' will always be true
    var headers = {
        'User-Agent': sdkName + "-" + sdkVersion + " " + osName + " " + osVersion + " " + nodeVersion,
        'X-IBMCloud-SDK-Analytics': "service_name=" + serviceName + ";service_version=" + serviceVersion + ";operation_id=" + operationId + ";async=true",
    };
    return headers;
}
exports.getSdkHeaders = getSdkHeaders;
//# sourceMappingURL=common.js.map