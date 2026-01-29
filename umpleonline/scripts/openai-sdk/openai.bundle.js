var OpenAI = (function () {
    'use strict';

    const default_format = 'RFC3986';
    const formatters = {
        RFC1738: (v) => String(v).replace(/%20/g, '+'),
        RFC3986: (v) => String(v),
    };
    const RFC1738 = 'RFC1738';

    const is_array$1 = Array.isArray;
    const hex_table = (() => {
        const array = [];
        for (let i = 0; i < 256; ++i) {
            array.push('%' + ((i < 16 ? '0' : '') + i.toString(16)).toUpperCase());
        }
        return array;
    })();
    const limit = 1024;
    const encode = (str, _defaultEncoder, charset, _kind, format) => {
        // This code was originally written by Brian White for the io.js core querystring library.
        // It has been adapted here for stricter adherence to RFC 3986
        if (str.length === 0) {
            return str;
        }
        let string = str;
        if (typeof str === 'symbol') {
            string = Symbol.prototype.toString.call(str);
        }
        else if (typeof str !== 'string') {
            string = String(str);
        }
        if (charset === 'iso-8859-1') {
            return escape(string).replace(/%u[0-9a-f]{4}/gi, function ($0) {
                return '%26%23' + parseInt($0.slice(2), 16) + '%3B';
            });
        }
        let out = '';
        for (let j = 0; j < string.length; j += limit) {
            const segment = string.length >= limit ? string.slice(j, j + limit) : string;
            const arr = [];
            for (let i = 0; i < segment.length; ++i) {
                let c = segment.charCodeAt(i);
                if (c === 0x2d || // -
                    c === 0x2e || // .
                    c === 0x5f || // _
                    c === 0x7e || // ~
                    (c >= 0x30 && c <= 0x39) || // 0-9
                    (c >= 0x41 && c <= 0x5a) || // a-z
                    (c >= 0x61 && c <= 0x7a) || // A-Z
                    (format === RFC1738 && (c === 0x28 || c === 0x29)) // ( )
                ) {
                    arr[arr.length] = segment.charAt(i);
                    continue;
                }
                if (c < 0x80) {
                    arr[arr.length] = hex_table[c];
                    continue;
                }
                if (c < 0x800) {
                    arr[arr.length] = hex_table[0xc0 | (c >> 6)] + hex_table[0x80 | (c & 0x3f)];
                    continue;
                }
                if (c < 0xd800 || c >= 0xe000) {
                    arr[arr.length] =
                        hex_table[0xe0 | (c >> 12)] + hex_table[0x80 | ((c >> 6) & 0x3f)] + hex_table[0x80 | (c & 0x3f)];
                    continue;
                }
                i += 1;
                c = 0x10000 + (((c & 0x3ff) << 10) | (segment.charCodeAt(i) & 0x3ff));
                arr[arr.length] =
                    hex_table[0xf0 | (c >> 18)] +
                        hex_table[0x80 | ((c >> 12) & 0x3f)] +
                        hex_table[0x80 | ((c >> 6) & 0x3f)] +
                        hex_table[0x80 | (c & 0x3f)];
            }
            out += arr.join('');
        }
        return out;
    };
    function is_buffer(obj) {
        if (!obj || typeof obj !== 'object') {
            return false;
        }
        return !!(obj.constructor && obj.constructor.isBuffer && obj.constructor.isBuffer(obj));
    }
    function maybe_map(val, fn) {
        if (is_array$1(val)) {
            const mapped = [];
            for (let i = 0; i < val.length; i += 1) {
                mapped.push(fn(val[i]));
            }
            return mapped;
        }
        return fn(val);
    }

    const has = Object.prototype.hasOwnProperty;
    const array_prefix_generators = {
        brackets(prefix) {
            return String(prefix) + '[]';
        },
        comma: 'comma',
        indices(prefix, key) {
            return String(prefix) + '[' + key + ']';
        },
        repeat(prefix) {
            return String(prefix);
        },
    };
    const is_array = Array.isArray;
    const push = Array.prototype.push;
    const push_to_array = function (arr, value_or_array) {
        push.apply(arr, is_array(value_or_array) ? value_or_array : [value_or_array]);
    };
    const to_ISO = Date.prototype.toISOString;
    const defaults = {
        addQueryPrefix: false,
        allowDots: false,
        allowEmptyArrays: false,
        arrayFormat: 'indices',
        charset: 'utf-8',
        charsetSentinel: false,
        delimiter: '&',
        encode: true,
        encodeDotInKeys: false,
        encoder: encode,
        encodeValuesOnly: false,
        format: default_format,
        formatter: formatters[default_format],
        /** @deprecated */
        indices: false,
        serializeDate(date) {
            return to_ISO.call(date);
        },
        skipNulls: false,
        strictNullHandling: false,
    };
    function is_non_nullish_primitive(v) {
        return (typeof v === 'string' ||
            typeof v === 'number' ||
            typeof v === 'boolean' ||
            typeof v === 'symbol' ||
            typeof v === 'bigint');
    }
    const sentinel = {};
    function inner_stringify(object, prefix, generateArrayPrefix, commaRoundTrip, allowEmptyArrays, strictNullHandling, skipNulls, encodeDotInKeys, encoder, filter, sort, allowDots, serializeDate, format, formatter, encodeValuesOnly, charset, sideChannel) {
        let obj = object;
        let tmp_sc = sideChannel;
        let step = 0;
        let find_flag = false;
        while ((tmp_sc = tmp_sc.get(sentinel)) !== void undefined && !find_flag) {
            // Where object last appeared in the ref tree
            const pos = tmp_sc.get(object);
            step += 1;
            if (typeof pos !== 'undefined') {
                if (pos === step) {
                    throw new RangeError('Cyclic object value');
                }
                else {
                    find_flag = true; // Break while
                }
            }
            if (typeof tmp_sc.get(sentinel) === 'undefined') {
                step = 0;
            }
        }
        if (typeof filter === 'function') {
            obj = filter(prefix, obj);
        }
        else if (obj instanceof Date) {
            obj = serializeDate?.(obj);
        }
        else if (generateArrayPrefix === 'comma' && is_array(obj)) {
            obj = maybe_map(obj, function (value) {
                if (value instanceof Date) {
                    return serializeDate?.(value);
                }
                return value;
            });
        }
        if (obj === null) {
            if (strictNullHandling) {
                return encoder && !encodeValuesOnly ?
                    // @ts-expect-error
                    encoder(prefix, defaults.encoder, charset, 'key', format)
                    : prefix;
            }
            obj = '';
        }
        if (is_non_nullish_primitive(obj) || is_buffer(obj)) {
            if (encoder) {
                const key_value = encodeValuesOnly ? prefix
                    // @ts-expect-error
                    : encoder(prefix, defaults.encoder, charset, 'key', format);
                return [
                    formatter?.(key_value) +
                        '=' +
                        // @ts-expect-error
                        formatter?.(encoder(obj, defaults.encoder, charset, 'value', format)),
                ];
            }
            return [formatter?.(prefix) + '=' + formatter?.(String(obj))];
        }
        const values = [];
        if (typeof obj === 'undefined') {
            return values;
        }
        let obj_keys;
        if (generateArrayPrefix === 'comma' && is_array(obj)) {
            // we need to join elements in
            if (encodeValuesOnly && encoder) {
                // @ts-expect-error values only
                obj = maybe_map(obj, encoder);
            }
            obj_keys = [{ value: obj.length > 0 ? obj.join(',') || null : void undefined }];
        }
        else if (is_array(filter)) {
            obj_keys = filter;
        }
        else {
            const keys = Object.keys(obj);
            obj_keys = sort ? keys.sort(sort) : keys;
        }
        const encoded_prefix = encodeDotInKeys ? String(prefix).replace(/\./g, '%2E') : String(prefix);
        const adjusted_prefix = commaRoundTrip && is_array(obj) && obj.length === 1 ? encoded_prefix + '[]' : encoded_prefix;
        if (allowEmptyArrays && is_array(obj) && obj.length === 0) {
            return adjusted_prefix + '[]';
        }
        for (let j = 0; j < obj_keys.length; ++j) {
            const key = obj_keys[j];
            const value = 
            // @ts-ignore
            typeof key === 'object' && typeof key.value !== 'undefined' ? key.value : obj[key];
            if (skipNulls && value === null) {
                continue;
            }
            // @ts-ignore
            const encoded_key = allowDots && encodeDotInKeys ? key.replace(/\./g, '%2E') : key;
            const key_prefix = is_array(obj) ?
                typeof generateArrayPrefix === 'function' ?
                    generateArrayPrefix(adjusted_prefix, encoded_key)
                    : adjusted_prefix
                : adjusted_prefix + (allowDots ? '.' + encoded_key : '[' + encoded_key + ']');
            sideChannel.set(object, step);
            const valueSideChannel = new WeakMap();
            valueSideChannel.set(sentinel, sideChannel);
            push_to_array(values, inner_stringify(value, key_prefix, generateArrayPrefix, commaRoundTrip, allowEmptyArrays, strictNullHandling, skipNulls, encodeDotInKeys, 
            // @ts-ignore
            generateArrayPrefix === 'comma' && encodeValuesOnly && is_array(obj) ? null : encoder, filter, sort, allowDots, serializeDate, format, formatter, encodeValuesOnly, charset, valueSideChannel));
        }
        return values;
    }
    function normalize_stringify_options(opts = defaults) {
        if (typeof opts.allowEmptyArrays !== 'undefined' && typeof opts.allowEmptyArrays !== 'boolean') {
            throw new TypeError('`allowEmptyArrays` option can only be `true` or `false`, when provided');
        }
        if (typeof opts.encodeDotInKeys !== 'undefined' && typeof opts.encodeDotInKeys !== 'boolean') {
            throw new TypeError('`encodeDotInKeys` option can only be `true` or `false`, when provided');
        }
        if (opts.encoder !== null && typeof opts.encoder !== 'undefined' && typeof opts.encoder !== 'function') {
            throw new TypeError('Encoder has to be a function.');
        }
        const charset = opts.charset || defaults.charset;
        if (typeof opts.charset !== 'undefined' && opts.charset !== 'utf-8' && opts.charset !== 'iso-8859-1') {
            throw new TypeError('The charset option must be either utf-8, iso-8859-1, or undefined');
        }
        let format = default_format;
        if (typeof opts.format !== 'undefined') {
            if (!has.call(formatters, opts.format)) {
                throw new TypeError('Unknown format option provided.');
            }
            format = opts.format;
        }
        const formatter = formatters[format];
        let filter = defaults.filter;
        if (typeof opts.filter === 'function' || is_array(opts.filter)) {
            filter = opts.filter;
        }
        let arrayFormat;
        if (opts.arrayFormat && opts.arrayFormat in array_prefix_generators) {
            arrayFormat = opts.arrayFormat;
        }
        else if ('indices' in opts) {
            arrayFormat = opts.indices ? 'indices' : 'repeat';
        }
        else {
            arrayFormat = defaults.arrayFormat;
        }
        if ('commaRoundTrip' in opts && typeof opts.commaRoundTrip !== 'boolean') {
            throw new TypeError('`commaRoundTrip` must be a boolean, or absent');
        }
        const allowDots = typeof opts.allowDots === 'undefined' ?
            !!opts.encodeDotInKeys === true ?
                true
                : defaults.allowDots
            : !!opts.allowDots;
        return {
            addQueryPrefix: typeof opts.addQueryPrefix === 'boolean' ? opts.addQueryPrefix : defaults.addQueryPrefix,
            // @ts-ignore
            allowDots: allowDots,
            allowEmptyArrays: typeof opts.allowEmptyArrays === 'boolean' ? !!opts.allowEmptyArrays : defaults.allowEmptyArrays,
            arrayFormat: arrayFormat,
            charset: charset,
            charsetSentinel: typeof opts.charsetSentinel === 'boolean' ? opts.charsetSentinel : defaults.charsetSentinel,
            commaRoundTrip: !!opts.commaRoundTrip,
            delimiter: typeof opts.delimiter === 'undefined' ? defaults.delimiter : opts.delimiter,
            encode: typeof opts.encode === 'boolean' ? opts.encode : defaults.encode,
            encodeDotInKeys: typeof opts.encodeDotInKeys === 'boolean' ? opts.encodeDotInKeys : defaults.encodeDotInKeys,
            encoder: typeof opts.encoder === 'function' ? opts.encoder : defaults.encoder,
            encodeValuesOnly: typeof opts.encodeValuesOnly === 'boolean' ? opts.encodeValuesOnly : defaults.encodeValuesOnly,
            filter: filter,
            format: format,
            formatter: formatter,
            serializeDate: typeof opts.serializeDate === 'function' ? opts.serializeDate : defaults.serializeDate,
            skipNulls: typeof opts.skipNulls === 'boolean' ? opts.skipNulls : defaults.skipNulls,
            // @ts-ignore
            sort: typeof opts.sort === 'function' ? opts.sort : null,
            strictNullHandling: typeof opts.strictNullHandling === 'boolean' ? opts.strictNullHandling : defaults.strictNullHandling,
        };
    }
    function stringify(object, opts = {}) {
        let obj = object;
        const options = normalize_stringify_options(opts);
        let obj_keys;
        let filter;
        if (typeof options.filter === 'function') {
            filter = options.filter;
            obj = filter('', obj);
        }
        else if (is_array(options.filter)) {
            filter = options.filter;
            obj_keys = filter;
        }
        const keys = [];
        if (typeof obj !== 'object' || obj === null) {
            return '';
        }
        const generateArrayPrefix = array_prefix_generators[options.arrayFormat];
        const commaRoundTrip = generateArrayPrefix === 'comma' && options.commaRoundTrip;
        if (!obj_keys) {
            obj_keys = Object.keys(obj);
        }
        if (options.sort) {
            obj_keys.sort(options.sort);
        }
        const sideChannel = new WeakMap();
        for (let i = 0; i < obj_keys.length; ++i) {
            const key = obj_keys[i];
            if (options.skipNulls && obj[key] === null) {
                continue;
            }
            push_to_array(keys, inner_stringify(obj[key], key, 
            // @ts-expect-error
            generateArrayPrefix, commaRoundTrip, options.allowEmptyArrays, options.strictNullHandling, options.skipNulls, options.encodeDotInKeys, options.encode ? options.encoder : null, options.filter, options.sort, options.allowDots, options.serializeDate, options.format, options.formatter, options.encodeValuesOnly, options.charset, sideChannel));
        }
        const joined = keys.join(options.delimiter);
        let prefix = options.addQueryPrefix === true ? '?' : '';
        if (options.charsetSentinel) {
            if (options.charset === 'iso-8859-1') {
                // encodeURIComponent('&#10003;'), the "numeric entity" representation of a checkmark
                prefix += 'utf8=%26%2310003%3B&';
            }
            else {
                // encodeURIComponent('✓')
                prefix += 'utf8=%E2%9C%93&';
            }
        }
        return joined.length > 0 ? prefix + joined : '';
    }

    const VERSION = '4.104.0'; // x-release-please-version

    let auto = false;
    let kind = undefined;
    let fetch$1 = undefined;
    let FormData$1 = undefined;
    let File$1 = undefined;
    let ReadableStream$1 = undefined;
    let getMultipartRequestOptions = undefined;
    let getDefaultAgent = undefined;
    let fileFromPath = undefined;
    let isFsReadStream = undefined;
    function setShims(shims, options = { auto: false }) {
        if (auto) {
            throw new Error(`you must \`import 'openai/shims/${shims.kind}'\` before importing anything else from openai`);
        }
        if (kind) {
            throw new Error(`can't \`import 'openai/shims/${shims.kind}'\` after \`import 'openai/shims/${kind}'\``);
        }
        auto = options.auto;
        kind = shims.kind;
        fetch$1 = shims.fetch;
        shims.Request;
        shims.Response;
        shims.Headers;
        FormData$1 = shims.FormData;
        shims.Blob;
        File$1 = shims.File;
        ReadableStream$1 = shims.ReadableStream;
        getMultipartRequestOptions = shims.getMultipartRequestOptions;
        getDefaultAgent = shims.getDefaultAgent;
        fileFromPath = shims.fileFromPath;
        isFsReadStream = shims.isFsReadStream;
    }

    /**
     * Disclaimer: modules in _shims aren't intended to be imported by SDK users.
     */
    class MultipartBody {
        constructor(body) {
            this.body = body;
        }
        get [Symbol.toStringTag]() {
            return 'MultipartBody';
        }
    }

    function getRuntime({ manuallyImported } = {}) {
        const recommendation = manuallyImported ?
            `You may need to use polyfills`
            : `Add one of these imports before your first \`import … from 'openai'\`:
- \`import 'openai/shims/node'\` (if you're running on Node)
- \`import 'openai/shims/web'\` (otherwise)
`;
        let _fetch, _Request, _Response, _Headers;
        try {
            // @ts-ignore
            _fetch = fetch;
            // @ts-ignore
            _Request = Request;
            // @ts-ignore
            _Response = Response;
            // @ts-ignore
            _Headers = Headers;
        }
        catch (error) {
            throw new Error(`this environment is missing the following Web Fetch API type: ${error.message}. ${recommendation}`);
        }
        return {
            kind: 'web',
            fetch: _fetch,
            Request: _Request,
            Response: _Response,
            Headers: _Headers,
            FormData: 
            // @ts-ignore
            typeof FormData !== 'undefined' ? FormData : (class FormData {
                // @ts-ignore
                constructor() {
                    throw new Error(`file uploads aren't supported in this environment yet as 'FormData' is undefined. ${recommendation}`);
                }
            }),
            Blob: typeof Blob !== 'undefined' ? Blob : (class Blob {
                constructor() {
                    throw new Error(`file uploads aren't supported in this environment yet as 'Blob' is undefined. ${recommendation}`);
                }
            }),
            File: 
            // @ts-ignore
            typeof File !== 'undefined' ? File : (class File {
                // @ts-ignore
                constructor() {
                    throw new Error(`file uploads aren't supported in this environment yet as 'File' is undefined. ${recommendation}`);
                }
            }),
            ReadableStream: 
            // @ts-ignore
            typeof ReadableStream !== 'undefined' ? ReadableStream : (class ReadableStream {
                // @ts-ignore
                constructor() {
                    throw new Error(`streaming isn't supported in this environment yet as 'ReadableStream' is undefined. ${recommendation}`);
                }
            }),
            getMultipartRequestOptions: async (
            // @ts-ignore
            form, opts) => ({
                ...opts,
                body: new MultipartBody(form),
            }),
            getDefaultAgent: (url) => undefined,
            fileFromPath: () => {
                throw new Error('The `fileFromPath` function is only supported in Node. See the README for more details: https://www.github.com/openai/openai-node#file-uploads');
            },
            isFsReadStream: (value) => false,
        };
    }

    /**
     * Disclaimer: modules in _shims aren't intended to be imported by SDK users.
     */
    const init = () => {
      if (!kind) setShims(getRuntime(), { auto: true });
    };

    init();

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class OpenAIError extends Error {
    }
    class APIError extends OpenAIError {
        constructor(status, error, message, headers) {
            super(`${APIError.makeMessage(status, error, message)}`);
            this.status = status;
            this.headers = headers;
            this.request_id = headers?.['x-request-id'];
            this.error = error;
            const data = error;
            this.code = data?.['code'];
            this.param = data?.['param'];
            this.type = data?.['type'];
        }
        static makeMessage(status, error, message) {
            const msg = error?.message ?
                typeof error.message === 'string' ?
                    error.message
                    : JSON.stringify(error.message)
                : error ? JSON.stringify(error)
                    : message;
            if (status && msg) {
                return `${status} ${msg}`;
            }
            if (status) {
                return `${status} status code (no body)`;
            }
            if (msg) {
                return msg;
            }
            return '(no status code or body)';
        }
        static generate(status, errorResponse, message, headers) {
            if (!status || !headers) {
                return new APIConnectionError({ message, cause: castToError(errorResponse) });
            }
            const error = errorResponse?.['error'];
            if (status === 400) {
                return new BadRequestError(status, error, message, headers);
            }
            if (status === 401) {
                return new AuthenticationError(status, error, message, headers);
            }
            if (status === 403) {
                return new PermissionDeniedError(status, error, message, headers);
            }
            if (status === 404) {
                return new NotFoundError(status, error, message, headers);
            }
            if (status === 409) {
                return new ConflictError(status, error, message, headers);
            }
            if (status === 422) {
                return new UnprocessableEntityError(status, error, message, headers);
            }
            if (status === 429) {
                return new RateLimitError(status, error, message, headers);
            }
            if (status >= 500) {
                return new InternalServerError(status, error, message, headers);
            }
            return new APIError(status, error, message, headers);
        }
    }
    class APIUserAbortError extends APIError {
        constructor({ message } = {}) {
            super(undefined, undefined, message || 'Request was aborted.', undefined);
        }
    }
    class APIConnectionError extends APIError {
        constructor({ message, cause }) {
            super(undefined, undefined, message || 'Connection error.', undefined);
            // in some environments the 'cause' property is already declared
            // @ts-ignore
            if (cause)
                this.cause = cause;
        }
    }
    class APIConnectionTimeoutError extends APIConnectionError {
        constructor({ message } = {}) {
            super({ message: message ?? 'Request timed out.' });
        }
    }
    class BadRequestError extends APIError {
    }
    class AuthenticationError extends APIError {
    }
    class PermissionDeniedError extends APIError {
    }
    class NotFoundError extends APIError {
    }
    class ConflictError extends APIError {
    }
    class UnprocessableEntityError extends APIError {
    }
    class RateLimitError extends APIError {
    }
    class InternalServerError extends APIError {
    }
    class LengthFinishReasonError extends OpenAIError {
        constructor() {
            super(`Could not parse response content as the length limit was reached`);
        }
    }
    class ContentFilterFinishReasonError extends OpenAIError {
        constructor() {
            super(`Could not parse response content as the request was rejected by the content filter`);
        }
    }

    var __classPrivateFieldSet$5 = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var __classPrivateFieldGet$6 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _LineDecoder_carriageReturnIndex;
    /**
     * A re-implementation of httpx's `LineDecoder` in Python that handles incrementally
     * reading lines from text.
     *
     * https://github.com/encode/httpx/blob/920333ea98118e9cf617f246905d7b202510941c/httpx/_decoders.py#L258
     */
    class LineDecoder {
        constructor() {
            _LineDecoder_carriageReturnIndex.set(this, void 0);
            this.buffer = new Uint8Array();
            __classPrivateFieldSet$5(this, _LineDecoder_carriageReturnIndex, null, "f");
        }
        decode(chunk) {
            if (chunk == null) {
                return [];
            }
            const binaryChunk = chunk instanceof ArrayBuffer ? new Uint8Array(chunk)
                : typeof chunk === 'string' ? new TextEncoder().encode(chunk)
                    : chunk;
            let newData = new Uint8Array(this.buffer.length + binaryChunk.length);
            newData.set(this.buffer);
            newData.set(binaryChunk, this.buffer.length);
            this.buffer = newData;
            const lines = [];
            let patternIndex;
            while ((patternIndex = findNewlineIndex(this.buffer, __classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f"))) != null) {
                if (patternIndex.carriage && __classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f") == null) {
                    // skip until we either get a corresponding `\n`, a new `\r` or nothing
                    __classPrivateFieldSet$5(this, _LineDecoder_carriageReturnIndex, patternIndex.index, "f");
                    continue;
                }
                // we got double \r or \rtext\n
                if (__classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f") != null &&
                    (patternIndex.index !== __classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f") + 1 || patternIndex.carriage)) {
                    lines.push(this.decodeText(this.buffer.slice(0, __classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f") - 1)));
                    this.buffer = this.buffer.slice(__classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f"));
                    __classPrivateFieldSet$5(this, _LineDecoder_carriageReturnIndex, null, "f");
                    continue;
                }
                const endIndex = __classPrivateFieldGet$6(this, _LineDecoder_carriageReturnIndex, "f") !== null ? patternIndex.preceding - 1 : patternIndex.preceding;
                const line = this.decodeText(this.buffer.slice(0, endIndex));
                lines.push(line);
                this.buffer = this.buffer.slice(patternIndex.index);
                __classPrivateFieldSet$5(this, _LineDecoder_carriageReturnIndex, null, "f");
            }
            return lines;
        }
        decodeText(bytes) {
            if (bytes == null)
                return '';
            if (typeof bytes === 'string')
                return bytes;
            // Node:
            if (typeof Buffer !== 'undefined') {
                if (bytes instanceof Buffer) {
                    return bytes.toString();
                }
                if (bytes instanceof Uint8Array) {
                    return Buffer.from(bytes).toString();
                }
                throw new OpenAIError(`Unexpected: received non-Uint8Array (${bytes.constructor.name}) stream chunk in an environment with a global "Buffer" defined, which this library assumes to be Node. Please report this error.`);
            }
            // Browser
            if (typeof TextDecoder !== 'undefined') {
                if (bytes instanceof Uint8Array || bytes instanceof ArrayBuffer) {
                    this.textDecoder ?? (this.textDecoder = new TextDecoder('utf8'));
                    return this.textDecoder.decode(bytes);
                }
                throw new OpenAIError(`Unexpected: received non-Uint8Array/ArrayBuffer (${bytes.constructor.name}) in a web platform. Please report this error.`);
            }
            throw new OpenAIError(`Unexpected: neither Buffer nor TextDecoder are available as globals. Please report this error.`);
        }
        flush() {
            if (!this.buffer.length) {
                return [];
            }
            return this.decode('\n');
        }
    }
    _LineDecoder_carriageReturnIndex = new WeakMap();
    // prettier-ignore
    LineDecoder.NEWLINE_CHARS = new Set(['\n', '\r']);
    LineDecoder.NEWLINE_REGEXP = /\r\n|[\n\r]/g;
    /**
     * This function searches the buffer for the end patterns, (\r or \n)
     * and returns an object with the index preceding the matched newline and the
     * index after the newline char. `null` is returned if no new line is found.
     *
     * ```ts
     * findNewLineIndex('abc\ndef') -> { preceding: 2, index: 3 }
     * ```
     */
    function findNewlineIndex(buffer, startIndex) {
        const newline = 0x0a; // \n
        const carriage = 0x0d; // \r
        for (let i = startIndex ?? 0; i < buffer.length; i++) {
            if (buffer[i] === newline) {
                return { preceding: i, index: i + 1, carriage: false };
            }
            if (buffer[i] === carriage) {
                return { preceding: i, index: i + 1, carriage: true };
            }
        }
        return null;
    }
    function findDoubleNewlineIndex(buffer) {
        // This function searches the buffer for the end patterns (\r\r, \n\n, \r\n\r\n)
        // and returns the index right after the first occurrence of any pattern,
        // or -1 if none of the patterns are found.
        const newline = 0x0a; // \n
        const carriage = 0x0d; // \r
        for (let i = 0; i < buffer.length - 1; i++) {
            if (buffer[i] === newline && buffer[i + 1] === newline) {
                // \n\n
                return i + 2;
            }
            if (buffer[i] === carriage && buffer[i + 1] === carriage) {
                // \r\r
                return i + 2;
            }
            if (buffer[i] === carriage &&
                buffer[i + 1] === newline &&
                i + 3 < buffer.length &&
                buffer[i + 2] === carriage &&
                buffer[i + 3] === newline) {
                // \r\n\r\n
                return i + 4;
            }
        }
        return -1;
    }

    /**
     * Most browsers don't yet have async iterable support for ReadableStream,
     * and Node has a very different way of reading bytes from its "ReadableStream".
     *
     * This polyfill was pulled from https://github.com/MattiasBuelens/web-streams-polyfill/pull/122#issuecomment-1627354490
     */
    function ReadableStreamToAsyncIterable(stream) {
        if (stream[Symbol.asyncIterator])
            return stream;
        const reader = stream.getReader();
        return {
            async next() {
                try {
                    const result = await reader.read();
                    if (result?.done)
                        reader.releaseLock(); // release lock when stream becomes closed
                    return result;
                }
                catch (e) {
                    reader.releaseLock(); // release lock when stream becomes errored
                    throw e;
                }
            },
            async return() {
                const cancelPromise = reader.cancel();
                reader.releaseLock();
                await cancelPromise;
                return { done: true, value: undefined };
            },
            [Symbol.asyncIterator]() {
                return this;
            },
        };
    }

    class Stream {
        constructor(iterator, controller) {
            this.iterator = iterator;
            this.controller = controller;
        }
        static fromSSEResponse(response, controller) {
            let consumed = false;
            async function* iterator() {
                if (consumed) {
                    throw new Error('Cannot iterate over a consumed stream, use `.tee()` to split the stream.');
                }
                consumed = true;
                let done = false;
                try {
                    for await (const sse of _iterSSEMessages(response, controller)) {
                        if (done)
                            continue;
                        if (sse.data.startsWith('[DONE]')) {
                            done = true;
                            continue;
                        }
                        if (sse.event === null ||
                            sse.event.startsWith('response.') ||
                            sse.event.startsWith('transcript.')) {
                            let data;
                            try {
                                data = JSON.parse(sse.data);
                            }
                            catch (e) {
                                console.error(`Could not parse message into JSON:`, sse.data);
                                console.error(`From chunk:`, sse.raw);
                                throw e;
                            }
                            if (data && data.error) {
                                throw new APIError(undefined, data.error, undefined, createResponseHeaders(response.headers));
                            }
                            yield data;
                        }
                        else {
                            let data;
                            try {
                                data = JSON.parse(sse.data);
                            }
                            catch (e) {
                                console.error(`Could not parse message into JSON:`, sse.data);
                                console.error(`From chunk:`, sse.raw);
                                throw e;
                            }
                            // TODO: Is this where the error should be thrown?
                            if (sse.event == 'error') {
                                throw new APIError(undefined, data.error, data.message, undefined);
                            }
                            yield { event: sse.event, data: data };
                        }
                    }
                    done = true;
                }
                catch (e) {
                    // If the user calls `stream.controller.abort()`, we should exit without throwing.
                    if (e instanceof Error && e.name === 'AbortError')
                        return;
                    throw e;
                }
                finally {
                    // If the user `break`s, abort the ongoing request.
                    if (!done)
                        controller.abort();
                }
            }
            return new Stream(iterator, controller);
        }
        /**
         * Generates a Stream from a newline-separated ReadableStream
         * where each item is a JSON value.
         */
        static fromReadableStream(readableStream, controller) {
            let consumed = false;
            async function* iterLines() {
                const lineDecoder = new LineDecoder();
                const iter = ReadableStreamToAsyncIterable(readableStream);
                for await (const chunk of iter) {
                    for (const line of lineDecoder.decode(chunk)) {
                        yield line;
                    }
                }
                for (const line of lineDecoder.flush()) {
                    yield line;
                }
            }
            async function* iterator() {
                if (consumed) {
                    throw new Error('Cannot iterate over a consumed stream, use `.tee()` to split the stream.');
                }
                consumed = true;
                let done = false;
                try {
                    for await (const line of iterLines()) {
                        if (done)
                            continue;
                        if (line)
                            yield JSON.parse(line);
                    }
                    done = true;
                }
                catch (e) {
                    // If the user calls `stream.controller.abort()`, we should exit without throwing.
                    if (e instanceof Error && e.name === 'AbortError')
                        return;
                    throw e;
                }
                finally {
                    // If the user `break`s, abort the ongoing request.
                    if (!done)
                        controller.abort();
                }
            }
            return new Stream(iterator, controller);
        }
        [Symbol.asyncIterator]() {
            return this.iterator();
        }
        /**
         * Splits the stream into two streams which can be
         * independently read from at different speeds.
         */
        tee() {
            const left = [];
            const right = [];
            const iterator = this.iterator();
            const teeIterator = (queue) => {
                return {
                    next: () => {
                        if (queue.length === 0) {
                            const result = iterator.next();
                            left.push(result);
                            right.push(result);
                        }
                        return queue.shift();
                    },
                };
            };
            return [
                new Stream(() => teeIterator(left), this.controller),
                new Stream(() => teeIterator(right), this.controller),
            ];
        }
        /**
         * Converts this stream to a newline-separated ReadableStream of
         * JSON stringified values in the stream
         * which can be turned back into a Stream with `Stream.fromReadableStream()`.
         */
        toReadableStream() {
            const self = this;
            let iter;
            const encoder = new TextEncoder();
            return new ReadableStream$1({
                async start() {
                    iter = self[Symbol.asyncIterator]();
                },
                async pull(ctrl) {
                    try {
                        const { value, done } = await iter.next();
                        if (done)
                            return ctrl.close();
                        const bytes = encoder.encode(JSON.stringify(value) + '\n');
                        ctrl.enqueue(bytes);
                    }
                    catch (err) {
                        ctrl.error(err);
                    }
                },
                async cancel() {
                    await iter.return?.();
                },
            });
        }
    }
    async function* _iterSSEMessages(response, controller) {
        if (!response.body) {
            controller.abort();
            throw new OpenAIError(`Attempted to iterate over a response with no body`);
        }
        const sseDecoder = new SSEDecoder();
        const lineDecoder = new LineDecoder();
        const iter = ReadableStreamToAsyncIterable(response.body);
        for await (const sseChunk of iterSSEChunks(iter)) {
            for (const line of lineDecoder.decode(sseChunk)) {
                const sse = sseDecoder.decode(line);
                if (sse)
                    yield sse;
            }
        }
        for (const line of lineDecoder.flush()) {
            const sse = sseDecoder.decode(line);
            if (sse)
                yield sse;
        }
    }
    /**
     * Given an async iterable iterator, iterates over it and yields full
     * SSE chunks, i.e. yields when a double new-line is encountered.
     */
    async function* iterSSEChunks(iterator) {
        let data = new Uint8Array();
        for await (const chunk of iterator) {
            if (chunk == null) {
                continue;
            }
            const binaryChunk = chunk instanceof ArrayBuffer ? new Uint8Array(chunk)
                : typeof chunk === 'string' ? new TextEncoder().encode(chunk)
                    : chunk;
            let newData = new Uint8Array(data.length + binaryChunk.length);
            newData.set(data);
            newData.set(binaryChunk, data.length);
            data = newData;
            let patternIndex;
            while ((patternIndex = findDoubleNewlineIndex(data)) !== -1) {
                yield data.slice(0, patternIndex);
                data = data.slice(patternIndex);
            }
        }
        if (data.length > 0) {
            yield data;
        }
    }
    class SSEDecoder {
        constructor() {
            this.event = null;
            this.data = [];
            this.chunks = [];
        }
        decode(line) {
            if (line.endsWith('\r')) {
                line = line.substring(0, line.length - 1);
            }
            if (!line) {
                // empty line and we didn't previously encounter any messages
                if (!this.event && !this.data.length)
                    return null;
                const sse = {
                    event: this.event,
                    data: this.data.join('\n'),
                    raw: this.chunks,
                };
                this.event = null;
                this.data = [];
                this.chunks = [];
                return sse;
            }
            this.chunks.push(line);
            if (line.startsWith(':')) {
                return null;
            }
            let [fieldname, _, value] = partition(line, ':');
            if (value.startsWith(' ')) {
                value = value.substring(1);
            }
            if (fieldname === 'event') {
                this.event = value;
            }
            else if (fieldname === 'data') {
                this.data.push(value);
            }
            return null;
        }
    }
    function partition(str, delimiter) {
        const index = str.indexOf(delimiter);
        if (index !== -1) {
            return [str.substring(0, index), delimiter, str.substring(index + delimiter.length)];
        }
        return [str, '', ''];
    }

    const isResponseLike = (value) => value != null &&
        typeof value === 'object' &&
        typeof value.url === 'string' &&
        typeof value.blob === 'function';
    const isFileLike = (value) => value != null &&
        typeof value === 'object' &&
        typeof value.name === 'string' &&
        typeof value.lastModified === 'number' &&
        isBlobLike(value);
    /**
     * The BlobLike type omits arrayBuffer() because @types/node-fetch@^2.6.4 lacks it; but this check
     * adds the arrayBuffer() method type because it is available and used at runtime
     */
    const isBlobLike = (value) => value != null &&
        typeof value === 'object' &&
        typeof value.size === 'number' &&
        typeof value.type === 'string' &&
        typeof value.text === 'function' &&
        typeof value.slice === 'function' &&
        typeof value.arrayBuffer === 'function';
    const isUploadable = (value) => {
        return isFileLike(value) || isResponseLike(value) || isFsReadStream(value);
    };
    /**
     * Helper for creating a {@link File} to pass to an SDK upload method from a variety of different data formats
     * @param value the raw content of the file.  Can be an {@link Uploadable}, {@link BlobLikePart}, or {@link AsyncIterable} of {@link BlobLikePart}s
     * @param {string=} name the name of the file. If omitted, toFile will try to determine a file name from bits if possible
     * @param {Object=} options additional properties
     * @param {string=} options.type the MIME type of the content
     * @param {number=} options.lastModified the last modified timestamp
     * @returns a {@link File} with the given properties
     */
    async function toFile(value, name, options) {
        // If it's a promise, resolve it.
        value = await value;
        // If we've been given a `File` we don't need to do anything
        if (isFileLike(value)) {
            return value;
        }
        if (isResponseLike(value)) {
            const blob = await value.blob();
            name || (name = new URL(value.url).pathname.split(/[\\/]/).pop() ?? 'unknown_file');
            // we need to convert the `Blob` into an array buffer because the `Blob` class
            // that `node-fetch` defines is incompatible with the web standard which results
            // in `new File` interpreting it as a string instead of binary data.
            const data = isBlobLike(blob) ? [(await blob.arrayBuffer())] : [blob];
            return new File$1(data, name, options);
        }
        const bits = await getBytes(value);
        name || (name = getName(value) ?? 'unknown_file');
        if (!options?.type) {
            const type = bits[0]?.type;
            if (typeof type === 'string') {
                options = { ...options, type };
            }
        }
        return new File$1(bits, name, options);
    }
    async function getBytes(value) {
        let parts = [];
        if (typeof value === 'string' ||
            ArrayBuffer.isView(value) || // includes Uint8Array, Buffer, etc.
            value instanceof ArrayBuffer) {
            parts.push(value);
        }
        else if (isBlobLike(value)) {
            parts.push(await value.arrayBuffer());
        }
        else if (isAsyncIterableIterator(value) // includes Readable, ReadableStream, etc.
        ) {
            for await (const chunk of value) {
                parts.push(chunk); // TODO, consider validating?
            }
        }
        else {
            throw new Error(`Unexpected data type: ${typeof value}; constructor: ${value?.constructor
            ?.name}; props: ${propsForError(value)}`);
        }
        return parts;
    }
    function propsForError(value) {
        const props = Object.getOwnPropertyNames(value);
        return `[${props.map((p) => `"${p}"`).join(', ')}]`;
    }
    function getName(value) {
        return (getStringFromMaybeBuffer(value.name) ||
            getStringFromMaybeBuffer(value.filename) ||
            // For fs.ReadStream
            getStringFromMaybeBuffer(value.path)?.split(/[\\/]/).pop());
    }
    const getStringFromMaybeBuffer = (x) => {
        if (typeof x === 'string')
            return x;
        if (typeof Buffer !== 'undefined' && x instanceof Buffer)
            return String(x);
        return undefined;
    };
    const isAsyncIterableIterator = (value) => value != null && typeof value === 'object' && typeof value[Symbol.asyncIterator] === 'function';
    const isMultipartBody = (body) => body && typeof body === 'object' && body.body && body[Symbol.toStringTag] === 'MultipartBody';
    const multipartFormRequestOptions = async (opts) => {
        const form = await createForm(opts.body);
        return getMultipartRequestOptions(form, opts);
    };
    const createForm = async (body) => {
        const form = new FormData$1();
        await Promise.all(Object.entries(body || {}).map(([key, value]) => addFormValue(form, key, value)));
        return form;
    };
    const addFormValue = async (form, key, value) => {
        if (value === undefined)
            return;
        if (value == null) {
            throw new TypeError(`Received null for "${key}"; to pass null in FormData, you must use the string 'null'`);
        }
        // TODO: make nested formats configurable
        if (typeof value === 'string' || typeof value === 'number' || typeof value === 'boolean') {
            form.append(key, String(value));
        }
        else if (isUploadable(value)) {
            const file = await toFile(value);
            form.append(key, file);
        }
        else if (Array.isArray(value)) {
            await Promise.all(value.map((entry) => addFormValue(form, key + '[]', entry)));
        }
        else if (typeof value === 'object') {
            await Promise.all(Object.entries(value).map(([name, prop]) => addFormValue(form, `${key}[${name}]`, prop)));
        }
        else {
            throw new TypeError(`Invalid value given to form, expected a string, number, boolean, object, Array, File or Blob but got ${value} instead`);
        }
    };

    var __classPrivateFieldSet$4 = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var __classPrivateFieldGet$5 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _AbstractPage_client;
    // try running side effects outside of _shims/index to workaround https://github.com/vercel/next.js/issues/76881
    init();
    async function defaultParseResponse(props) {
        const { response } = props;
        if (props.options.stream) {
            debug('response', response.status, response.url, response.headers, response.body);
            // Note: there is an invariant here that isn't represented in the type system
            // that if you set `stream: true` the response type must also be `Stream<T>`
            if (props.options.__streamClass) {
                return props.options.__streamClass.fromSSEResponse(response, props.controller);
            }
            return Stream.fromSSEResponse(response, props.controller);
        }
        // fetch refuses to read the body when the status code is 204.
        if (response.status === 204) {
            return null;
        }
        if (props.options.__binaryResponse) {
            return response;
        }
        const contentType = response.headers.get('content-type');
        const mediaType = contentType?.split(';')[0]?.trim();
        const isJSON = mediaType?.includes('application/json') || mediaType?.endsWith('+json');
        if (isJSON) {
            const json = await response.json();
            debug('response', response.status, response.url, response.headers, json);
            return _addRequestID(json, response);
        }
        const text = await response.text();
        debug('response', response.status, response.url, response.headers, text);
        // TODO handle blob, arraybuffer, other content types, etc.
        return text;
    }
    function _addRequestID(value, response) {
        if (!value || typeof value !== 'object' || Array.isArray(value)) {
            return value;
        }
        return Object.defineProperty(value, '_request_id', {
            value: response.headers.get('x-request-id'),
            enumerable: false,
        });
    }
    /**
     * A subclass of `Promise` providing additional helper methods
     * for interacting with the SDK.
     */
    class APIPromise extends Promise {
        constructor(responsePromise, parseResponse = defaultParseResponse) {
            super((resolve) => {
                // this is maybe a bit weird but this has to be a no-op to not implicitly
                // parse the response body; instead .then, .catch, .finally are overridden
                // to parse the response
                resolve(null);
            });
            this.responsePromise = responsePromise;
            this.parseResponse = parseResponse;
        }
        _thenUnwrap(transform) {
            return new APIPromise(this.responsePromise, async (props) => _addRequestID(transform(await this.parseResponse(props), props), props.response));
        }
        /**
         * Gets the raw `Response` instance instead of parsing the response
         * data.
         *
         * If you want to parse the response body but still get the `Response`
         * instance, you can use {@link withResponse()}.
         *
         * 👋 Getting the wrong TypeScript type for `Response`?
         * Try setting `"moduleResolution": "NodeNext"` if you can,
         * or add one of these imports before your first `import … from 'openai'`:
         * - `import 'openai/shims/node'` (if you're running on Node)
         * - `import 'openai/shims/web'` (otherwise)
         */
        asResponse() {
            return this.responsePromise.then((p) => p.response);
        }
        /**
         * Gets the parsed response data, the raw `Response` instance and the ID of the request,
         * returned via the X-Request-ID header which is useful for debugging requests and reporting
         * issues to OpenAI.
         *
         * If you just want to get the raw `Response` instance without parsing it,
         * you can use {@link asResponse()}.
         *
         *
         * 👋 Getting the wrong TypeScript type for `Response`?
         * Try setting `"moduleResolution": "NodeNext"` if you can,
         * or add one of these imports before your first `import … from 'openai'`:
         * - `import 'openai/shims/node'` (if you're running on Node)
         * - `import 'openai/shims/web'` (otherwise)
         */
        async withResponse() {
            const [data, response] = await Promise.all([this.parse(), this.asResponse()]);
            return { data, response, request_id: response.headers.get('x-request-id') };
        }
        parse() {
            if (!this.parsedPromise) {
                this.parsedPromise = this.responsePromise.then(this.parseResponse);
            }
            return this.parsedPromise;
        }
        then(onfulfilled, onrejected) {
            return this.parse().then(onfulfilled, onrejected);
        }
        catch(onrejected) {
            return this.parse().catch(onrejected);
        }
        finally(onfinally) {
            return this.parse().finally(onfinally);
        }
    }
    class APIClient {
        constructor({ baseURL, maxRetries = 2, timeout = 600000, // 10 minutes
        httpAgent, fetch: overriddenFetch, }) {
            this.baseURL = baseURL;
            this.maxRetries = validatePositiveInteger('maxRetries', maxRetries);
            this.timeout = validatePositiveInteger('timeout', timeout);
            this.httpAgent = httpAgent;
            this.fetch = overriddenFetch ?? fetch$1;
        }
        authHeaders(opts) {
            return {};
        }
        /**
         * Override this to add your own default headers, for example:
         *
         *  {
         *    ...super.defaultHeaders(),
         *    Authorization: 'Bearer 123',
         *  }
         */
        defaultHeaders(opts) {
            return {
                Accept: 'application/json',
                'Content-Type': 'application/json',
                'User-Agent': this.getUserAgent(),
                ...getPlatformHeaders(),
                ...this.authHeaders(opts),
            };
        }
        /**
         * Override this to add your own headers validation:
         */
        validateHeaders(headers, customHeaders) { }
        defaultIdempotencyKey() {
            return `stainless-node-retry-${uuid4()}`;
        }
        get(path, opts) {
            return this.methodRequest('get', path, opts);
        }
        post(path, opts) {
            return this.methodRequest('post', path, opts);
        }
        patch(path, opts) {
            return this.methodRequest('patch', path, opts);
        }
        put(path, opts) {
            return this.methodRequest('put', path, opts);
        }
        delete(path, opts) {
            return this.methodRequest('delete', path, opts);
        }
        methodRequest(method, path, opts) {
            return this.request(Promise.resolve(opts).then(async (opts) => {
                const body = opts && isBlobLike(opts?.body) ? new DataView(await opts.body.arrayBuffer())
                    : opts?.body instanceof DataView ? opts.body
                        : opts?.body instanceof ArrayBuffer ? new DataView(opts.body)
                            : opts && ArrayBuffer.isView(opts?.body) ? new DataView(opts.body.buffer)
                                : opts?.body;
                return { method, path, ...opts, body };
            }));
        }
        getAPIList(path, Page, opts) {
            return this.requestAPIList(Page, { method: 'get', path, ...opts });
        }
        calculateContentLength(body) {
            if (typeof body === 'string') {
                if (typeof Buffer !== 'undefined') {
                    return Buffer.byteLength(body, 'utf8').toString();
                }
                if (typeof TextEncoder !== 'undefined') {
                    const encoder = new TextEncoder();
                    const encoded = encoder.encode(body);
                    return encoded.length.toString();
                }
            }
            else if (ArrayBuffer.isView(body)) {
                return body.byteLength.toString();
            }
            return null;
        }
        buildRequest(inputOptions, { retryCount = 0 } = {}) {
            const options = { ...inputOptions };
            const { method, path, query, headers: headers = {} } = options;
            const body = ArrayBuffer.isView(options.body) || (options.__binaryRequest && typeof options.body === 'string') ?
                options.body
                : isMultipartBody(options.body) ? options.body.body
                    : options.body ? JSON.stringify(options.body, null, 2)
                        : null;
            const contentLength = this.calculateContentLength(body);
            const url = this.buildURL(path, query);
            if ('timeout' in options)
                validatePositiveInteger('timeout', options.timeout);
            options.timeout = options.timeout ?? this.timeout;
            const httpAgent = options.httpAgent ?? this.httpAgent ?? getDefaultAgent(url);
            const minAgentTimeout = options.timeout + 1000;
            if (typeof httpAgent?.options?.timeout === 'number' &&
                minAgentTimeout > (httpAgent.options.timeout ?? 0)) {
                // Allow any given request to bump our agent active socket timeout.
                // This may seem strange, but leaking active sockets should be rare and not particularly problematic,
                // and without mutating agent we would need to create more of them.
                // This tradeoff optimizes for performance.
                httpAgent.options.timeout = minAgentTimeout;
            }
            if (this.idempotencyHeader && method !== 'get') {
                if (!inputOptions.idempotencyKey)
                    inputOptions.idempotencyKey = this.defaultIdempotencyKey();
                headers[this.idempotencyHeader] = inputOptions.idempotencyKey;
            }
            const reqHeaders = this.buildHeaders({ options, headers, contentLength, retryCount });
            const req = {
                method,
                ...(body && { body: body }),
                headers: reqHeaders,
                ...(httpAgent && { agent: httpAgent }),
                // @ts-ignore node-fetch uses a custom AbortSignal type that is
                // not compatible with standard web types
                signal: options.signal ?? null,
            };
            return { req, url, timeout: options.timeout };
        }
        buildHeaders({ options, headers, contentLength, retryCount, }) {
            const reqHeaders = {};
            if (contentLength) {
                reqHeaders['content-length'] = contentLength;
            }
            const defaultHeaders = this.defaultHeaders(options);
            applyHeadersMut(reqHeaders, defaultHeaders);
            applyHeadersMut(reqHeaders, headers);
            // let builtin fetch set the Content-Type for multipart bodies
            if (isMultipartBody(options.body) && kind !== 'node') {
                delete reqHeaders['content-type'];
            }
            // Don't set theses headers if they were already set or removed through default headers or by the caller.
            // We check `defaultHeaders` and `headers`, which can contain nulls, instead of `reqHeaders` to account
            // for the removal case.
            if (getHeader(defaultHeaders, 'x-stainless-retry-count') === undefined &&
                getHeader(headers, 'x-stainless-retry-count') === undefined) {
                reqHeaders['x-stainless-retry-count'] = String(retryCount);
            }
            if (getHeader(defaultHeaders, 'x-stainless-timeout') === undefined &&
                getHeader(headers, 'x-stainless-timeout') === undefined &&
                options.timeout) {
                reqHeaders['x-stainless-timeout'] = String(Math.trunc(options.timeout / 1000));
            }
            this.validateHeaders(reqHeaders, headers);
            return reqHeaders;
        }
        /**
         * Used as a callback for mutating the given `FinalRequestOptions` object.
         */
        async prepareOptions(options) { }
        /**
         * Used as a callback for mutating the given `RequestInit` object.
         *
         * This is useful for cases where you want to add certain headers based off of
         * the request properties, e.g. `method` or `url`.
         */
        async prepareRequest(request, { url, options }) { }
        parseHeaders(headers) {
            return (!headers ? {}
                : Symbol.iterator in headers ?
                    Object.fromEntries(Array.from(headers).map((header) => [...header]))
                    : { ...headers });
        }
        makeStatusError(status, error, message, headers) {
            return APIError.generate(status, error, message, headers);
        }
        request(options, remainingRetries = null) {
            return new APIPromise(this.makeRequest(options, remainingRetries));
        }
        async makeRequest(optionsInput, retriesRemaining) {
            const options = await optionsInput;
            const maxRetries = options.maxRetries ?? this.maxRetries;
            if (retriesRemaining == null) {
                retriesRemaining = maxRetries;
            }
            await this.prepareOptions(options);
            const { req, url, timeout } = this.buildRequest(options, { retryCount: maxRetries - retriesRemaining });
            await this.prepareRequest(req, { url, options });
            debug('request', url, options, req.headers);
            if (options.signal?.aborted) {
                throw new APIUserAbortError();
            }
            const controller = new AbortController();
            const response = await this.fetchWithTimeout(url, req, timeout, controller).catch(castToError);
            if (response instanceof Error) {
                if (options.signal?.aborted) {
                    throw new APIUserAbortError();
                }
                if (retriesRemaining) {
                    return this.retryRequest(options, retriesRemaining);
                }
                if (response.name === 'AbortError') {
                    throw new APIConnectionTimeoutError();
                }
                throw new APIConnectionError({ cause: response });
            }
            const responseHeaders = createResponseHeaders(response.headers);
            if (!response.ok) {
                if (retriesRemaining && this.shouldRetry(response)) {
                    const retryMessage = `retrying, ${retriesRemaining} attempts remaining`;
                    debug(`response (error; ${retryMessage})`, response.status, url, responseHeaders);
                    return this.retryRequest(options, retriesRemaining, responseHeaders);
                }
                const errText = await response.text().catch((e) => castToError(e).message);
                const errJSON = safeJSON(errText);
                const errMessage = errJSON ? undefined : errText;
                const retryMessage = retriesRemaining ? `(error; no more retries left)` : `(error; not retryable)`;
                debug(`response (error; ${retryMessage})`, response.status, url, responseHeaders, errMessage);
                const err = this.makeStatusError(response.status, errJSON, errMessage, responseHeaders);
                throw err;
            }
            return { response, options, controller };
        }
        requestAPIList(Page, options) {
            const request = this.makeRequest(options, null);
            return new PagePromise(this, request, Page);
        }
        buildURL(path, query) {
            const url = isAbsoluteURL(path) ?
                new URL(path)
                : new URL(this.baseURL + (this.baseURL.endsWith('/') && path.startsWith('/') ? path.slice(1) : path));
            const defaultQuery = this.defaultQuery();
            if (!isEmptyObj(defaultQuery)) {
                query = { ...defaultQuery, ...query };
            }
            if (typeof query === 'object' && query && !Array.isArray(query)) {
                url.search = this.stringifyQuery(query);
            }
            return url.toString();
        }
        stringifyQuery(query) {
            return Object.entries(query)
                .filter(([_, value]) => typeof value !== 'undefined')
                .map(([key, value]) => {
                if (typeof value === 'string' || typeof value === 'number' || typeof value === 'boolean') {
                    return `${encodeURIComponent(key)}=${encodeURIComponent(value)}`;
                }
                if (value === null) {
                    return `${encodeURIComponent(key)}=`;
                }
                throw new OpenAIError(`Cannot stringify type ${typeof value}; Expected string, number, boolean, or null. If you need to pass nested query parameters, you can manually encode them, e.g. { query: { 'foo[key1]': value1, 'foo[key2]': value2 } }, and please open a GitHub issue requesting better support for your use case.`);
            })
                .join('&');
        }
        async fetchWithTimeout(url, init, ms, controller) {
            const { signal, ...options } = init || {};
            if (signal)
                signal.addEventListener('abort', () => controller.abort());
            const timeout = setTimeout(() => controller.abort(), ms);
            const fetchOptions = {
                signal: controller.signal,
                ...options,
            };
            if (fetchOptions.method) {
                // Custom methods like 'patch' need to be uppercased
                // See https://github.com/nodejs/undici/issues/2294
                fetchOptions.method = fetchOptions.method.toUpperCase();
            }
            return (
            // use undefined this binding; fetch errors if bound to something else in browser/cloudflare
            this.fetch.call(undefined, url, fetchOptions).finally(() => {
                clearTimeout(timeout);
            }));
        }
        shouldRetry(response) {
            // Note this is not a standard header.
            const shouldRetryHeader = response.headers.get('x-should-retry');
            // If the server explicitly says whether or not to retry, obey.
            if (shouldRetryHeader === 'true')
                return true;
            if (shouldRetryHeader === 'false')
                return false;
            // Retry on request timeouts.
            if (response.status === 408)
                return true;
            // Retry on lock timeouts.
            if (response.status === 409)
                return true;
            // Retry on rate limits.
            if (response.status === 429)
                return true;
            // Retry internal errors.
            if (response.status >= 500)
                return true;
            return false;
        }
        async retryRequest(options, retriesRemaining, responseHeaders) {
            let timeoutMillis;
            // Note the `retry-after-ms` header may not be standard, but is a good idea and we'd like proactive support for it.
            const retryAfterMillisHeader = responseHeaders?.['retry-after-ms'];
            if (retryAfterMillisHeader) {
                const timeoutMs = parseFloat(retryAfterMillisHeader);
                if (!Number.isNaN(timeoutMs)) {
                    timeoutMillis = timeoutMs;
                }
            }
            // About the Retry-After header: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After
            const retryAfterHeader = responseHeaders?.['retry-after'];
            if (retryAfterHeader && !timeoutMillis) {
                const timeoutSeconds = parseFloat(retryAfterHeader);
                if (!Number.isNaN(timeoutSeconds)) {
                    timeoutMillis = timeoutSeconds * 1000;
                }
                else {
                    timeoutMillis = Date.parse(retryAfterHeader) - Date.now();
                }
            }
            // If the API asks us to wait a certain amount of time (and it's a reasonable amount),
            // just do what it says, but otherwise calculate a default
            if (!(timeoutMillis && 0 <= timeoutMillis && timeoutMillis < 60 * 1000)) {
                const maxRetries = options.maxRetries ?? this.maxRetries;
                timeoutMillis = this.calculateDefaultRetryTimeoutMillis(retriesRemaining, maxRetries);
            }
            await sleep(timeoutMillis);
            return this.makeRequest(options, retriesRemaining - 1);
        }
        calculateDefaultRetryTimeoutMillis(retriesRemaining, maxRetries) {
            const initialRetryDelay = 0.5;
            const maxRetryDelay = 8.0;
            const numRetries = maxRetries - retriesRemaining;
            // Apply exponential backoff, but not more than the max.
            const sleepSeconds = Math.min(initialRetryDelay * Math.pow(2, numRetries), maxRetryDelay);
            // Apply some jitter, take up to at most 25 percent of the retry time.
            const jitter = 1 - Math.random() * 0.25;
            return sleepSeconds * jitter * 1000;
        }
        getUserAgent() {
            return `${this.constructor.name}/JS ${VERSION}`;
        }
    }
    class AbstractPage {
        constructor(client, response, body, options) {
            _AbstractPage_client.set(this, void 0);
            __classPrivateFieldSet$4(this, _AbstractPage_client, client, "f");
            this.options = options;
            this.response = response;
            this.body = body;
        }
        hasNextPage() {
            const items = this.getPaginatedItems();
            if (!items.length)
                return false;
            return this.nextPageInfo() != null;
        }
        async getNextPage() {
            const nextInfo = this.nextPageInfo();
            if (!nextInfo) {
                throw new OpenAIError('No next page expected; please check `.hasNextPage()` before calling `.getNextPage()`.');
            }
            const nextOptions = { ...this.options };
            if ('params' in nextInfo && typeof nextOptions.query === 'object') {
                nextOptions.query = { ...nextOptions.query, ...nextInfo.params };
            }
            else if ('url' in nextInfo) {
                const params = [...Object.entries(nextOptions.query || {}), ...nextInfo.url.searchParams.entries()];
                for (const [key, value] of params) {
                    nextInfo.url.searchParams.set(key, value);
                }
                nextOptions.query = undefined;
                nextOptions.path = nextInfo.url.toString();
            }
            return await __classPrivateFieldGet$5(this, _AbstractPage_client, "f").requestAPIList(this.constructor, nextOptions);
        }
        async *iterPages() {
            // eslint-disable-next-line @typescript-eslint/no-this-alias
            let page = this;
            yield page;
            while (page.hasNextPage()) {
                page = await page.getNextPage();
                yield page;
            }
        }
        async *[(_AbstractPage_client = new WeakMap(), Symbol.asyncIterator)]() {
            for await (const page of this.iterPages()) {
                for (const item of page.getPaginatedItems()) {
                    yield item;
                }
            }
        }
    }
    /**
     * This subclass of Promise will resolve to an instantiated Page once the request completes.
     *
     * It also implements AsyncIterable to allow auto-paginating iteration on an unawaited list call, eg:
     *
     *    for await (const item of client.items.list()) {
     *      console.log(item)
     *    }
     */
    class PagePromise extends APIPromise {
        constructor(client, request, Page) {
            super(request, async (props) => new Page(client, props.response, await defaultParseResponse(props), props.options));
        }
        /**
         * Allow auto-paginating iteration on an unawaited list call, eg:
         *
         *    for await (const item of client.items.list()) {
         *      console.log(item)
         *    }
         */
        async *[Symbol.asyncIterator]() {
            const page = await this;
            for await (const item of page) {
                yield item;
            }
        }
    }
    const createResponseHeaders = (headers) => {
        return new Proxy(Object.fromEntries(
        // @ts-ignore
        headers.entries()), {
            get(target, name) {
                const key = name.toString();
                return target[key.toLowerCase()] || target[key];
            },
        });
    };
    // This is required so that we can determine if a given object matches the RequestOptions
    // type at runtime. While this requires duplication, it is enforced by the TypeScript
    // compiler such that any missing / extraneous keys will cause an error.
    const requestOptionsKeys = {
        method: true,
        path: true,
        query: true,
        body: true,
        headers: true,
        maxRetries: true,
        stream: true,
        timeout: true,
        httpAgent: true,
        signal: true,
        idempotencyKey: true,
        __metadata: true,
        __binaryRequest: true,
        __binaryResponse: true,
        __streamClass: true,
    };
    const isRequestOptions = (obj) => {
        return (typeof obj === 'object' &&
            obj !== null &&
            !isEmptyObj(obj) &&
            Object.keys(obj).every((k) => hasOwn(requestOptionsKeys, k)));
    };
    const getPlatformProperties = () => {
        if (typeof Deno !== 'undefined' && Deno.build != null) {
            return {
                'X-Stainless-Lang': 'js',
                'X-Stainless-Package-Version': VERSION,
                'X-Stainless-OS': normalizePlatform(Deno.build.os),
                'X-Stainless-Arch': normalizeArch(Deno.build.arch),
                'X-Stainless-Runtime': 'deno',
                'X-Stainless-Runtime-Version': typeof Deno.version === 'string' ? Deno.version : Deno.version?.deno ?? 'unknown',
            };
        }
        if (typeof EdgeRuntime !== 'undefined') {
            return {
                'X-Stainless-Lang': 'js',
                'X-Stainless-Package-Version': VERSION,
                'X-Stainless-OS': 'Unknown',
                'X-Stainless-Arch': `other:${EdgeRuntime}`,
                'X-Stainless-Runtime': 'edge',
                'X-Stainless-Runtime-Version': process.version,
            };
        }
        // Check if Node.js
        if (Object.prototype.toString.call(typeof process !== 'undefined' ? process : 0) === '[object process]') {
            return {
                'X-Stainless-Lang': 'js',
                'X-Stainless-Package-Version': VERSION,
                'X-Stainless-OS': normalizePlatform(process.platform),
                'X-Stainless-Arch': normalizeArch(process.arch),
                'X-Stainless-Runtime': 'node',
                'X-Stainless-Runtime-Version': process.version,
            };
        }
        const browserInfo = getBrowserInfo();
        if (browserInfo) {
            return {
                'X-Stainless-Lang': 'js',
                'X-Stainless-Package-Version': VERSION,
                'X-Stainless-OS': 'Unknown',
                'X-Stainless-Arch': 'unknown',
                'X-Stainless-Runtime': `browser:${browserInfo.browser}`,
                'X-Stainless-Runtime-Version': browserInfo.version,
            };
        }
        // TODO add support for Cloudflare workers, etc.
        return {
            'X-Stainless-Lang': 'js',
            'X-Stainless-Package-Version': VERSION,
            'X-Stainless-OS': 'Unknown',
            'X-Stainless-Arch': 'unknown',
            'X-Stainless-Runtime': 'unknown',
            'X-Stainless-Runtime-Version': 'unknown',
        };
    };
    // Note: modified from https://github.com/JS-DevTools/host-environment/blob/b1ab79ecde37db5d6e163c050e54fe7d287d7c92/src/isomorphic.browser.ts
    function getBrowserInfo() {
        if (typeof navigator === 'undefined' || !navigator) {
            return null;
        }
        // NOTE: The order matters here!
        const browserPatterns = [
            { key: 'edge', pattern: /Edge(?:\W+(\d+)\.(\d+)(?:\.(\d+))?)?/ },
            { key: 'ie', pattern: /MSIE(?:\W+(\d+)\.(\d+)(?:\.(\d+))?)?/ },
            { key: 'ie', pattern: /Trident(?:.*rv\:(\d+)\.(\d+)(?:\.(\d+))?)?/ },
            { key: 'chrome', pattern: /Chrome(?:\W+(\d+)\.(\d+)(?:\.(\d+))?)?/ },
            { key: 'firefox', pattern: /Firefox(?:\W+(\d+)\.(\d+)(?:\.(\d+))?)?/ },
            { key: 'safari', pattern: /(?:Version\W+(\d+)\.(\d+)(?:\.(\d+))?)?(?:\W+Mobile\S*)?\W+Safari/ },
        ];
        // Find the FIRST matching browser
        for (const { key, pattern } of browserPatterns) {
            const match = pattern.exec(navigator.userAgent);
            if (match) {
                const major = match[1] || 0;
                const minor = match[2] || 0;
                const patch = match[3] || 0;
                return { browser: key, version: `${major}.${minor}.${patch}` };
            }
        }
        return null;
    }
    const normalizeArch = (arch) => {
        // Node docs:
        // - https://nodejs.org/api/process.html#processarch
        // Deno docs:
        // - https://doc.deno.land/deno/stable/~/Deno.build
        if (arch === 'x32')
            return 'x32';
        if (arch === 'x86_64' || arch === 'x64')
            return 'x64';
        if (arch === 'arm')
            return 'arm';
        if (arch === 'aarch64' || arch === 'arm64')
            return 'arm64';
        if (arch)
            return `other:${arch}`;
        return 'unknown';
    };
    const normalizePlatform = (platform) => {
        // Node platforms:
        // - https://nodejs.org/api/process.html#processplatform
        // Deno platforms:
        // - https://doc.deno.land/deno/stable/~/Deno.build
        // - https://github.com/denoland/deno/issues/14799
        platform = platform.toLowerCase();
        // NOTE: this iOS check is untested and may not work
        // Node does not work natively on IOS, there is a fork at
        // https://github.com/nodejs-mobile/nodejs-mobile
        // however it is unknown at the time of writing how to detect if it is running
        if (platform.includes('ios'))
            return 'iOS';
        if (platform === 'android')
            return 'Android';
        if (platform === 'darwin')
            return 'MacOS';
        if (platform === 'win32')
            return 'Windows';
        if (platform === 'freebsd')
            return 'FreeBSD';
        if (platform === 'openbsd')
            return 'OpenBSD';
        if (platform === 'linux')
            return 'Linux';
        if (platform)
            return `Other:${platform}`;
        return 'Unknown';
    };
    let _platformHeaders;
    const getPlatformHeaders = () => {
        return (_platformHeaders ?? (_platformHeaders = getPlatformProperties()));
    };
    const safeJSON = (text) => {
        try {
            return JSON.parse(text);
        }
        catch (err) {
            return undefined;
        }
    };
    // https://url.spec.whatwg.org/#url-scheme-string
    const startsWithSchemeRegexp = /^[a-z][a-z0-9+.-]*:/i;
    const isAbsoluteURL = (url) => {
        return startsWithSchemeRegexp.test(url);
    };
    const sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
    const validatePositiveInteger = (name, n) => {
        if (typeof n !== 'number' || !Number.isInteger(n)) {
            throw new OpenAIError(`${name} must be an integer`);
        }
        if (n < 0) {
            throw new OpenAIError(`${name} must be a positive integer`);
        }
        return n;
    };
    const castToError = (err) => {
        if (err instanceof Error)
            return err;
        if (typeof err === 'object' && err !== null) {
            try {
                return new Error(JSON.stringify(err));
            }
            catch { }
        }
        return new Error(err);
    };
    /**
     * Read an environment variable.
     *
     * Trims beginning and trailing whitespace.
     *
     * Will return undefined if the environment variable doesn't exist or cannot be accessed.
     */
    const readEnv = (env) => {
        if (typeof process !== 'undefined') {
            return process.env?.[env]?.trim() ?? undefined;
        }
        if (typeof Deno !== 'undefined') {
            return Deno.env?.get?.(env)?.trim();
        }
        return undefined;
    };
    // https://stackoverflow.com/a/34491287
    function isEmptyObj(obj) {
        if (!obj)
            return true;
        for (const _k in obj)
            return false;
        return true;
    }
    // https://eslint.org/docs/latest/rules/no-prototype-builtins
    function hasOwn(obj, key) {
        return Object.prototype.hasOwnProperty.call(obj, key);
    }
    /**
     * Copies headers from "newHeaders" onto "targetHeaders",
     * using lower-case for all properties,
     * ignoring any keys with undefined values,
     * and deleting any keys with null values.
     */
    function applyHeadersMut(targetHeaders, newHeaders) {
        for (const k in newHeaders) {
            if (!hasOwn(newHeaders, k))
                continue;
            const lowerKey = k.toLowerCase();
            if (!lowerKey)
                continue;
            const val = newHeaders[k];
            if (val === null) {
                delete targetHeaders[lowerKey];
            }
            else if (val !== undefined) {
                targetHeaders[lowerKey] = val;
            }
        }
    }
    const SENSITIVE_HEADERS = new Set(['authorization', 'api-key']);
    function debug(action, ...args) {
        if (typeof process !== 'undefined' && process?.env?.['DEBUG'] === 'true') {
            const modifiedArgs = args.map((arg) => {
                if (!arg) {
                    return arg;
                }
                // Check for sensitive headers in request body 'headers' object
                if (arg['headers']) {
                    // clone so we don't mutate
                    const modifiedArg = { ...arg, headers: { ...arg['headers'] } };
                    for (const header in arg['headers']) {
                        if (SENSITIVE_HEADERS.has(header.toLowerCase())) {
                            modifiedArg['headers'][header] = 'REDACTED';
                        }
                    }
                    return modifiedArg;
                }
                let modifiedArg = null;
                // Check for sensitive headers in headers object
                for (const header in arg) {
                    if (SENSITIVE_HEADERS.has(header.toLowerCase())) {
                        // avoid making a copy until we need to
                        modifiedArg ?? (modifiedArg = { ...arg });
                        modifiedArg[header] = 'REDACTED';
                    }
                }
                return modifiedArg ?? arg;
            });
            console.log(`OpenAI:DEBUG:${action}`, ...modifiedArgs);
        }
    }
    /**
     * https://stackoverflow.com/a/2117523
     */
    const uuid4 = () => {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, (c) => {
            const r = (Math.random() * 16) | 0;
            const v = c === 'x' ? r : (r & 0x3) | 0x8;
            return v.toString(16);
        });
    };
    const isRunningInBrowser = () => {
        return (
        // @ts-ignore
        typeof window !== 'undefined' &&
            // @ts-ignore
            typeof window.document !== 'undefined' &&
            // @ts-ignore
            typeof navigator !== 'undefined');
    };
    const isHeadersProtocol = (headers) => {
        return typeof headers?.get === 'function';
    };
    const getHeader = (headers, header) => {
        const lowerCasedHeader = header.toLowerCase();
        if (isHeadersProtocol(headers)) {
            // to deal with the case where the header looks like Stainless-Event-Id
            const intercapsHeader = header[0]?.toUpperCase() +
                header.substring(1).replace(/([^\w])(\w)/g, (_m, g1, g2) => g1 + g2.toUpperCase());
            for (const key of [header, lowerCasedHeader, header.toUpperCase(), intercapsHeader]) {
                const value = headers.get(key);
                if (value) {
                    return value;
                }
            }
        }
        for (const [key, value] of Object.entries(headers)) {
            if (key.toLowerCase() === lowerCasedHeader) {
                if (Array.isArray(value)) {
                    if (value.length <= 1)
                        return value[0];
                    console.warn(`Received ${value.length} entries for the ${header} header, using the first entry.`);
                    return value[0];
                }
                return value;
            }
        }
        return undefined;
    };
    /**
     * Converts a Base64 encoded string to a Float32Array.
     * @param base64Str - The Base64 encoded string.
     * @returns An Array of numbers interpreted as Float32 values.
     */
    const toFloat32Array = (base64Str) => {
        if (typeof Buffer !== 'undefined') {
            // for Node.js environment
            const buf = Buffer.from(base64Str, 'base64');
            return Array.from(new Float32Array(buf.buffer, buf.byteOffset, buf.length / Float32Array.BYTES_PER_ELEMENT));
        }
        else {
            // for legacy web platform APIs
            const binaryStr = atob(base64Str);
            const len = binaryStr.length;
            const bytes = new Uint8Array(len);
            for (let i = 0; i < len; i++) {
                bytes[i] = binaryStr.charCodeAt(i);
            }
            return Array.from(new Float32Array(bytes.buffer));
        }
    };
    function isObj(obj) {
        return obj != null && typeof obj === 'object' && !Array.isArray(obj);
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    /**
     * Note: no pagination actually occurs yet, this is for forwards-compatibility.
     */
    class Page extends AbstractPage {
        constructor(client, response, body, options) {
            super(client, response, body, options);
            this.data = body.data || [];
            this.object = body.object;
        }
        getPaginatedItems() {
            return this.data ?? [];
        }
        // @deprecated Please use `nextPageInfo()` instead
        /**
         * This page represents a response that isn't actually paginated at the API level
         * so there will never be any next page params.
         */
        nextPageParams() {
            return null;
        }
        nextPageInfo() {
            return null;
        }
    }
    class CursorPage extends AbstractPage {
        constructor(client, response, body, options) {
            super(client, response, body, options);
            this.data = body.data || [];
            this.has_more = body.has_more || false;
        }
        getPaginatedItems() {
            return this.data ?? [];
        }
        hasNextPage() {
            if (this.has_more === false) {
                return false;
            }
            return super.hasNextPage();
        }
        // @deprecated Please use `nextPageInfo()` instead
        nextPageParams() {
            const info = this.nextPageInfo();
            if (!info)
                return null;
            if ('params' in info)
                return info.params;
            const params = Object.fromEntries(info.url.searchParams);
            if (!Object.keys(params).length)
                return null;
            return params;
        }
        nextPageInfo() {
            const data = this.getPaginatedItems();
            if (!data.length) {
                return null;
            }
            const id = data[data.length - 1]?.id;
            if (!id) {
                return null;
            }
            return { params: { after: id } };
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class APIResource {
        constructor(client) {
            this._client = client;
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Messages$1 = class Messages extends APIResource {
        list(completionId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(completionId, {}, query);
            }
            return this._client.getAPIList(`/chat/completions/${completionId}/messages`, ChatCompletionStoreMessagesPage, { query, ...options });
        }
    };

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Completions$2 = class Completions extends APIResource {
        constructor() {
            super(...arguments);
            this.messages = new Messages$1(this._client);
        }
        create(body, options) {
            return this._client.post('/chat/completions', { body, ...options, stream: body.stream ?? false });
        }
        /**
         * Get a stored chat completion. Only Chat Completions that have been created with
         * the `store` parameter set to `true` will be returned.
         *
         * @example
         * ```ts
         * const chatCompletion =
         *   await client.chat.completions.retrieve('completion_id');
         * ```
         */
        retrieve(completionId, options) {
            return this._client.get(`/chat/completions/${completionId}`, options);
        }
        /**
         * Modify a stored chat completion. Only Chat Completions that have been created
         * with the `store` parameter set to `true` can be modified. Currently, the only
         * supported modification is to update the `metadata` field.
         *
         * @example
         * ```ts
         * const chatCompletion = await client.chat.completions.update(
         *   'completion_id',
         *   { metadata: { foo: 'string' } },
         * );
         * ```
         */
        update(completionId, body, options) {
            return this._client.post(`/chat/completions/${completionId}`, { body, ...options });
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/chat/completions', ChatCompletionsPage, { query, ...options });
        }
        /**
         * Delete a stored chat completion. Only Chat Completions that have been created
         * with the `store` parameter set to `true` can be deleted.
         *
         * @example
         * ```ts
         * const chatCompletionDeleted =
         *   await client.chat.completions.del('completion_id');
         * ```
         */
        del(completionId, options) {
            return this._client.delete(`/chat/completions/${completionId}`, options);
        }
    };
    class ChatCompletionsPage extends CursorPage {
    }
    class ChatCompletionStoreMessagesPage extends CursorPage {
    }
    Completions$2.ChatCompletionsPage = ChatCompletionsPage;
    Completions$2.Messages = Messages$1;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Chat$1 = class Chat extends APIResource {
        constructor() {
            super(...arguments);
            this.completions = new Completions$2(this._client);
        }
    };
    Chat$1.Completions = Completions$2;
    Chat$1.ChatCompletionsPage = ChatCompletionsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Speech extends APIResource {
        /**
         * Generates audio from the input text.
         *
         * @example
         * ```ts
         * const speech = await client.audio.speech.create({
         *   input: 'input',
         *   model: 'string',
         *   voice: 'ash',
         * });
         *
         * const content = await speech.blob();
         * console.log(content);
         * ```
         */
        create(body, options) {
            return this._client.post('/audio/speech', {
                body,
                ...options,
                headers: { Accept: 'application/octet-stream', ...options?.headers },
                __binaryResponse: true,
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Transcriptions extends APIResource {
        create(body, options) {
            return this._client.post('/audio/transcriptions', multipartFormRequestOptions({
                body,
                ...options,
                stream: body.stream ?? false,
                __metadata: { model: body.model },
            }));
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Translations extends APIResource {
        create(body, options) {
            return this._client.post('/audio/translations', multipartFormRequestOptions({ body, ...options, __metadata: { model: body.model } }));
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Audio extends APIResource {
        constructor() {
            super(...arguments);
            this.transcriptions = new Transcriptions(this._client);
            this.translations = new Translations(this._client);
            this.speech = new Speech(this._client);
        }
    }
    Audio.Transcriptions = Transcriptions;
    Audio.Translations = Translations;
    Audio.Speech = Speech;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Batches extends APIResource {
        /**
         * Creates and executes a batch from an uploaded file of requests
         */
        create(body, options) {
            return this._client.post('/batches', { body, ...options });
        }
        /**
         * Retrieves a batch.
         */
        retrieve(batchId, options) {
            return this._client.get(`/batches/${batchId}`, options);
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/batches', BatchesPage, { query, ...options });
        }
        /**
         * Cancels an in-progress batch. The batch will be in status `cancelling` for up to
         * 10 minutes, before changing to `cancelled`, where it will have partial results
         * (if any) available in the output file.
         */
        cancel(batchId, options) {
            return this._client.post(`/batches/${batchId}/cancel`, options);
        }
    }
    class BatchesPage extends CursorPage {
    }
    Batches.BatchesPage = BatchesPage;

    var __classPrivateFieldSet$3 = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var __classPrivateFieldGet$4 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _EventStream_instances, _EventStream_connectedPromise, _EventStream_resolveConnectedPromise, _EventStream_rejectConnectedPromise, _EventStream_endPromise, _EventStream_resolveEndPromise, _EventStream_rejectEndPromise, _EventStream_listeners, _EventStream_ended, _EventStream_errored, _EventStream_aborted, _EventStream_catchingPromiseCreated, _EventStream_handleError;
    class EventStream {
        constructor() {
            _EventStream_instances.add(this);
            this.controller = new AbortController();
            _EventStream_connectedPromise.set(this, void 0);
            _EventStream_resolveConnectedPromise.set(this, () => { });
            _EventStream_rejectConnectedPromise.set(this, () => { });
            _EventStream_endPromise.set(this, void 0);
            _EventStream_resolveEndPromise.set(this, () => { });
            _EventStream_rejectEndPromise.set(this, () => { });
            _EventStream_listeners.set(this, {});
            _EventStream_ended.set(this, false);
            _EventStream_errored.set(this, false);
            _EventStream_aborted.set(this, false);
            _EventStream_catchingPromiseCreated.set(this, false);
            __classPrivateFieldSet$3(this, _EventStream_connectedPromise, new Promise((resolve, reject) => {
                __classPrivateFieldSet$3(this, _EventStream_resolveConnectedPromise, resolve, "f");
                __classPrivateFieldSet$3(this, _EventStream_rejectConnectedPromise, reject, "f");
            }), "f");
            __classPrivateFieldSet$3(this, _EventStream_endPromise, new Promise((resolve, reject) => {
                __classPrivateFieldSet$3(this, _EventStream_resolveEndPromise, resolve, "f");
                __classPrivateFieldSet$3(this, _EventStream_rejectEndPromise, reject, "f");
            }), "f");
            // Don't let these promises cause unhandled rejection errors.
            // we will manually cause an unhandled rejection error later
            // if the user hasn't registered any error listener or called
            // any promise-returning method.
            __classPrivateFieldGet$4(this, _EventStream_connectedPromise, "f").catch(() => { });
            __classPrivateFieldGet$4(this, _EventStream_endPromise, "f").catch(() => { });
        }
        _run(executor) {
            // Unfortunately if we call `executor()` immediately we get runtime errors about
            // references to `this` before the `super()` constructor call returns.
            setTimeout(() => {
                executor().then(() => {
                    this._emitFinal();
                    this._emit('end');
                }, __classPrivateFieldGet$4(this, _EventStream_instances, "m", _EventStream_handleError).bind(this));
            }, 0);
        }
        _connected() {
            if (this.ended)
                return;
            __classPrivateFieldGet$4(this, _EventStream_resolveConnectedPromise, "f").call(this);
            this._emit('connect');
        }
        get ended() {
            return __classPrivateFieldGet$4(this, _EventStream_ended, "f");
        }
        get errored() {
            return __classPrivateFieldGet$4(this, _EventStream_errored, "f");
        }
        get aborted() {
            return __classPrivateFieldGet$4(this, _EventStream_aborted, "f");
        }
        abort() {
            this.controller.abort();
        }
        /**
         * Adds the listener function to the end of the listeners array for the event.
         * No checks are made to see if the listener has already been added. Multiple calls passing
         * the same combination of event and listener will result in the listener being added, and
         * called, multiple times.
         * @returns this ChatCompletionStream, so that calls can be chained
         */
        on(event, listener) {
            const listeners = __classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event] || (__classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event] = []);
            listeners.push({ listener });
            return this;
        }
        /**
         * Removes the specified listener from the listener array for the event.
         * off() will remove, at most, one instance of a listener from the listener array. If any single
         * listener has been added multiple times to the listener array for the specified event, then
         * off() must be called multiple times to remove each instance.
         * @returns this ChatCompletionStream, so that calls can be chained
         */
        off(event, listener) {
            const listeners = __classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event];
            if (!listeners)
                return this;
            const index = listeners.findIndex((l) => l.listener === listener);
            if (index >= 0)
                listeners.splice(index, 1);
            return this;
        }
        /**
         * Adds a one-time listener function for the event. The next time the event is triggered,
         * this listener is removed and then invoked.
         * @returns this ChatCompletionStream, so that calls can be chained
         */
        once(event, listener) {
            const listeners = __classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event] || (__classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event] = []);
            listeners.push({ listener, once: true });
            return this;
        }
        /**
         * This is similar to `.once()`, but returns a Promise that resolves the next time
         * the event is triggered, instead of calling a listener callback.
         * @returns a Promise that resolves the next time given event is triggered,
         * or rejects if an error is emitted.  (If you request the 'error' event,
         * returns a promise that resolves with the error).
         *
         * Example:
         *
         *   const message = await stream.emitted('message') // rejects if the stream errors
         */
        emitted(event) {
            return new Promise((resolve, reject) => {
                __classPrivateFieldSet$3(this, _EventStream_catchingPromiseCreated, true, "f");
                if (event !== 'error')
                    this.once('error', reject);
                this.once(event, resolve);
            });
        }
        async done() {
            __classPrivateFieldSet$3(this, _EventStream_catchingPromiseCreated, true, "f");
            await __classPrivateFieldGet$4(this, _EventStream_endPromise, "f");
        }
        _emit(event, ...args) {
            // make sure we don't emit any events after end
            if (__classPrivateFieldGet$4(this, _EventStream_ended, "f")) {
                return;
            }
            if (event === 'end') {
                __classPrivateFieldSet$3(this, _EventStream_ended, true, "f");
                __classPrivateFieldGet$4(this, _EventStream_resolveEndPromise, "f").call(this);
            }
            const listeners = __classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event];
            if (listeners) {
                __classPrivateFieldGet$4(this, _EventStream_listeners, "f")[event] = listeners.filter((l) => !l.once);
                listeners.forEach(({ listener }) => listener(...args));
            }
            if (event === 'abort') {
                const error = args[0];
                if (!__classPrivateFieldGet$4(this, _EventStream_catchingPromiseCreated, "f") && !listeners?.length) {
                    Promise.reject(error);
                }
                __classPrivateFieldGet$4(this, _EventStream_rejectConnectedPromise, "f").call(this, error);
                __classPrivateFieldGet$4(this, _EventStream_rejectEndPromise, "f").call(this, error);
                this._emit('end');
                return;
            }
            if (event === 'error') {
                // NOTE: _emit('error', error) should only be called from #handleError().
                const error = args[0];
                if (!__classPrivateFieldGet$4(this, _EventStream_catchingPromiseCreated, "f") && !listeners?.length) {
                    // Trigger an unhandled rejection if the user hasn't registered any error handlers.
                    // If you are seeing stack traces here, make sure to handle errors via either:
                    // - runner.on('error', () => ...)
                    // - await runner.done()
                    // - await runner.finalChatCompletion()
                    // - etc.
                    Promise.reject(error);
                }
                __classPrivateFieldGet$4(this, _EventStream_rejectConnectedPromise, "f").call(this, error);
                __classPrivateFieldGet$4(this, _EventStream_rejectEndPromise, "f").call(this, error);
                this._emit('end');
            }
        }
        _emitFinal() { }
    }
    _EventStream_connectedPromise = new WeakMap(), _EventStream_resolveConnectedPromise = new WeakMap(), _EventStream_rejectConnectedPromise = new WeakMap(), _EventStream_endPromise = new WeakMap(), _EventStream_resolveEndPromise = new WeakMap(), _EventStream_rejectEndPromise = new WeakMap(), _EventStream_listeners = new WeakMap(), _EventStream_ended = new WeakMap(), _EventStream_errored = new WeakMap(), _EventStream_aborted = new WeakMap(), _EventStream_catchingPromiseCreated = new WeakMap(), _EventStream_instances = new WeakSet(), _EventStream_handleError = function _EventStream_handleError(error) {
        __classPrivateFieldSet$3(this, _EventStream_errored, true, "f");
        if (error instanceof Error && error.name === 'AbortError') {
            error = new APIUserAbortError();
        }
        if (error instanceof APIUserAbortError) {
            __classPrivateFieldSet$3(this, _EventStream_aborted, true, "f");
            return this._emit('abort', error);
        }
        if (error instanceof OpenAIError) {
            return this._emit('error', error);
        }
        if (error instanceof Error) {
            const openAIError = new OpenAIError(error.message);
            // @ts-ignore
            openAIError.cause = error;
            return this._emit('error', openAIError);
        }
        return this._emit('error', new OpenAIError(String(error)));
    };

    var __classPrivateFieldGet$3 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var __classPrivateFieldSet$2 = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var _AssistantStream_instances, _AssistantStream_events, _AssistantStream_runStepSnapshots, _AssistantStream_messageSnapshots, _AssistantStream_messageSnapshot, _AssistantStream_finalRun, _AssistantStream_currentContentIndex, _AssistantStream_currentContent, _AssistantStream_currentToolCallIndex, _AssistantStream_currentToolCall, _AssistantStream_currentEvent, _AssistantStream_currentRunSnapshot, _AssistantStream_currentRunStepSnapshot, _AssistantStream_addEvent, _AssistantStream_endRequest, _AssistantStream_handleMessage, _AssistantStream_handleRunStep, _AssistantStream_handleEvent, _AssistantStream_accumulateRunStep, _AssistantStream_accumulateMessage, _AssistantStream_accumulateContent, _AssistantStream_handleRun;
    class AssistantStream extends EventStream {
        constructor() {
            super(...arguments);
            _AssistantStream_instances.add(this);
            //Track all events in a single list for reference
            _AssistantStream_events.set(this, []);
            //Used to accumulate deltas
            //We are accumulating many types so the value here is not strict
            _AssistantStream_runStepSnapshots.set(this, {});
            _AssistantStream_messageSnapshots.set(this, {});
            _AssistantStream_messageSnapshot.set(this, void 0);
            _AssistantStream_finalRun.set(this, void 0);
            _AssistantStream_currentContentIndex.set(this, void 0);
            _AssistantStream_currentContent.set(this, void 0);
            _AssistantStream_currentToolCallIndex.set(this, void 0);
            _AssistantStream_currentToolCall.set(this, void 0);
            //For current snapshot methods
            _AssistantStream_currentEvent.set(this, void 0);
            _AssistantStream_currentRunSnapshot.set(this, void 0);
            _AssistantStream_currentRunStepSnapshot.set(this, void 0);
        }
        [(_AssistantStream_events = new WeakMap(), _AssistantStream_runStepSnapshots = new WeakMap(), _AssistantStream_messageSnapshots = new WeakMap(), _AssistantStream_messageSnapshot = new WeakMap(), _AssistantStream_finalRun = new WeakMap(), _AssistantStream_currentContentIndex = new WeakMap(), _AssistantStream_currentContent = new WeakMap(), _AssistantStream_currentToolCallIndex = new WeakMap(), _AssistantStream_currentToolCall = new WeakMap(), _AssistantStream_currentEvent = new WeakMap(), _AssistantStream_currentRunSnapshot = new WeakMap(), _AssistantStream_currentRunStepSnapshot = new WeakMap(), _AssistantStream_instances = new WeakSet(), Symbol.asyncIterator)]() {
            const pushQueue = [];
            const readQueue = [];
            let done = false;
            //Catch all for passing along all events
            this.on('event', (event) => {
                const reader = readQueue.shift();
                if (reader) {
                    reader.resolve(event);
                }
                else {
                    pushQueue.push(event);
                }
            });
            this.on('end', () => {
                done = true;
                for (const reader of readQueue) {
                    reader.resolve(undefined);
                }
                readQueue.length = 0;
            });
            this.on('abort', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            this.on('error', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            return {
                next: async () => {
                    if (!pushQueue.length) {
                        if (done) {
                            return { value: undefined, done: true };
                        }
                        return new Promise((resolve, reject) => readQueue.push({ resolve, reject })).then((chunk) => (chunk ? { value: chunk, done: false } : { value: undefined, done: true }));
                    }
                    const chunk = pushQueue.shift();
                    return { value: chunk, done: false };
                },
                return: async () => {
                    this.abort();
                    return { value: undefined, done: true };
                },
            };
        }
        static fromReadableStream(stream) {
            const runner = new AssistantStream();
            runner._run(() => runner._fromReadableStream(stream));
            return runner;
        }
        async _fromReadableStream(readableStream, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            this._connected();
            const stream = Stream.fromReadableStream(readableStream, this.controller);
            for await (const event of stream) {
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_addEvent).call(this, event);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addRun(__classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_endRequest).call(this));
        }
        toReadableStream() {
            const stream = new Stream(this[Symbol.asyncIterator].bind(this), this.controller);
            return stream.toReadableStream();
        }
        static createToolAssistantStream(threadId, runId, runs, params, options) {
            const runner = new AssistantStream();
            runner._run(() => runner._runToolAssistantStream(threadId, runId, runs, params, {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'stream' },
            }));
            return runner;
        }
        async _createToolAssistantStream(run, threadId, runId, params, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            const body = { ...params, stream: true };
            const stream = await run.submitToolOutputs(threadId, runId, body, {
                ...options,
                signal: this.controller.signal,
            });
            this._connected();
            for await (const event of stream) {
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_addEvent).call(this, event);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addRun(__classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_endRequest).call(this));
        }
        static createThreadAssistantStream(params, thread, options) {
            const runner = new AssistantStream();
            runner._run(() => runner._threadAssistantStream(params, thread, {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'stream' },
            }));
            return runner;
        }
        static createAssistantStream(threadId, runs, params, options) {
            const runner = new AssistantStream();
            runner._run(() => runner._runAssistantStream(threadId, runs, params, {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'stream' },
            }));
            return runner;
        }
        currentEvent() {
            return __classPrivateFieldGet$3(this, _AssistantStream_currentEvent, "f");
        }
        currentRun() {
            return __classPrivateFieldGet$3(this, _AssistantStream_currentRunSnapshot, "f");
        }
        currentMessageSnapshot() {
            return __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f");
        }
        currentRunStepSnapshot() {
            return __classPrivateFieldGet$3(this, _AssistantStream_currentRunStepSnapshot, "f");
        }
        async finalRunSteps() {
            await this.done();
            return Object.values(__classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f"));
        }
        async finalMessages() {
            await this.done();
            return Object.values(__classPrivateFieldGet$3(this, _AssistantStream_messageSnapshots, "f"));
        }
        async finalRun() {
            await this.done();
            if (!__classPrivateFieldGet$3(this, _AssistantStream_finalRun, "f"))
                throw Error('Final run was not received.');
            return __classPrivateFieldGet$3(this, _AssistantStream_finalRun, "f");
        }
        async _createThreadAssistantStream(thread, params, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            const body = { ...params, stream: true };
            const stream = await thread.createAndRun(body, { ...options, signal: this.controller.signal });
            this._connected();
            for await (const event of stream) {
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_addEvent).call(this, event);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addRun(__classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_endRequest).call(this));
        }
        async _createAssistantStream(run, threadId, params, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            const body = { ...params, stream: true };
            const stream = await run.create(threadId, body, { ...options, signal: this.controller.signal });
            this._connected();
            for await (const event of stream) {
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_addEvent).call(this, event);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addRun(__classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_endRequest).call(this));
        }
        static accumulateDelta(acc, delta) {
            for (const [key, deltaValue] of Object.entries(delta)) {
                if (!acc.hasOwnProperty(key)) {
                    acc[key] = deltaValue;
                    continue;
                }
                let accValue = acc[key];
                if (accValue === null || accValue === undefined) {
                    acc[key] = deltaValue;
                    continue;
                }
                // We don't accumulate these special properties
                if (key === 'index' || key === 'type') {
                    acc[key] = deltaValue;
                    continue;
                }
                // Type-specific accumulation logic
                if (typeof accValue === 'string' && typeof deltaValue === 'string') {
                    accValue += deltaValue;
                }
                else if (typeof accValue === 'number' && typeof deltaValue === 'number') {
                    accValue += deltaValue;
                }
                else if (isObj(accValue) && isObj(deltaValue)) {
                    accValue = this.accumulateDelta(accValue, deltaValue);
                }
                else if (Array.isArray(accValue) && Array.isArray(deltaValue)) {
                    if (accValue.every((x) => typeof x === 'string' || typeof x === 'number')) {
                        accValue.push(...deltaValue); // Use spread syntax for efficient addition
                        continue;
                    }
                    for (const deltaEntry of deltaValue) {
                        if (!isObj(deltaEntry)) {
                            throw new Error(`Expected array delta entry to be an object but got: ${deltaEntry}`);
                        }
                        const index = deltaEntry['index'];
                        if (index == null) {
                            console.error(deltaEntry);
                            throw new Error('Expected array delta entry to have an `index` property');
                        }
                        if (typeof index !== 'number') {
                            throw new Error(`Expected array delta entry \`index\` property to be a number but got ${index}`);
                        }
                        const accEntry = accValue[index];
                        if (accEntry == null) {
                            accValue.push(deltaEntry);
                        }
                        else {
                            accValue[index] = this.accumulateDelta(accEntry, deltaEntry);
                        }
                    }
                    continue;
                }
                else {
                    throw Error(`Unhandled record type: ${key}, deltaValue: ${deltaValue}, accValue: ${accValue}`);
                }
                acc[key] = accValue;
            }
            return acc;
        }
        _addRun(run) {
            return run;
        }
        async _threadAssistantStream(params, thread, options) {
            return await this._createThreadAssistantStream(thread, params, options);
        }
        async _runAssistantStream(threadId, runs, params, options) {
            return await this._createAssistantStream(runs, threadId, params, options);
        }
        async _runToolAssistantStream(threadId, runId, runs, params, options) {
            return await this._createToolAssistantStream(runs, threadId, runId, params, options);
        }
    }
    _AssistantStream_addEvent = function _AssistantStream_addEvent(event) {
        if (this.ended)
            return;
        __classPrivateFieldSet$2(this, _AssistantStream_currentEvent, event, "f");
        __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_handleEvent).call(this, event);
        switch (event.event) {
            case 'thread.created':
                //No action on this event.
                break;
            case 'thread.run.created':
            case 'thread.run.queued':
            case 'thread.run.in_progress':
            case 'thread.run.requires_action':
            case 'thread.run.completed':
            case 'thread.run.incomplete':
            case 'thread.run.failed':
            case 'thread.run.cancelling':
            case 'thread.run.cancelled':
            case 'thread.run.expired':
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_handleRun).call(this, event);
                break;
            case 'thread.run.step.created':
            case 'thread.run.step.in_progress':
            case 'thread.run.step.delta':
            case 'thread.run.step.completed':
            case 'thread.run.step.failed':
            case 'thread.run.step.cancelled':
            case 'thread.run.step.expired':
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_handleRunStep).call(this, event);
                break;
            case 'thread.message.created':
            case 'thread.message.in_progress':
            case 'thread.message.delta':
            case 'thread.message.completed':
            case 'thread.message.incomplete':
                __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_handleMessage).call(this, event);
                break;
            case 'error':
                //This is included for completeness, but errors are processed in the SSE event processing so this should not occur
                throw new Error('Encountered an error event in event processing - errors should be processed earlier');
        }
    }, _AssistantStream_endRequest = function _AssistantStream_endRequest() {
        if (this.ended) {
            throw new OpenAIError(`stream has ended, this shouldn't happen`);
        }
        if (!__classPrivateFieldGet$3(this, _AssistantStream_finalRun, "f"))
            throw Error('Final run has not been received');
        return __classPrivateFieldGet$3(this, _AssistantStream_finalRun, "f");
    }, _AssistantStream_handleMessage = function _AssistantStream_handleMessage(event) {
        const [accumulatedMessage, newContent] = __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_accumulateMessage).call(this, event, __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f"));
        __classPrivateFieldSet$2(this, _AssistantStream_messageSnapshot, accumulatedMessage, "f");
        __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshots, "f")[accumulatedMessage.id] = accumulatedMessage;
        for (const content of newContent) {
            const snapshotContent = accumulatedMessage.content[content.index];
            if (snapshotContent?.type == 'text') {
                this._emit('textCreated', snapshotContent.text);
            }
        }
        switch (event.event) {
            case 'thread.message.created':
                this._emit('messageCreated', event.data);
                break;
            case 'thread.message.in_progress':
                break;
            case 'thread.message.delta':
                this._emit('messageDelta', event.data.delta, accumulatedMessage);
                if (event.data.delta.content) {
                    for (const content of event.data.delta.content) {
                        //If it is text delta, emit a text delta event
                        if (content.type == 'text' && content.text) {
                            let textDelta = content.text;
                            let snapshot = accumulatedMessage.content[content.index];
                            if (snapshot && snapshot.type == 'text') {
                                this._emit('textDelta', textDelta, snapshot.text);
                            }
                            else {
                                throw Error('The snapshot associated with this text delta is not text or missing');
                            }
                        }
                        if (content.index != __classPrivateFieldGet$3(this, _AssistantStream_currentContentIndex, "f")) {
                            //See if we have in progress content
                            if (__classPrivateFieldGet$3(this, _AssistantStream_currentContent, "f")) {
                                switch (__classPrivateFieldGet$3(this, _AssistantStream_currentContent, "f").type) {
                                    case 'text':
                                        this._emit('textDone', __classPrivateFieldGet$3(this, _AssistantStream_currentContent, "f").text, __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f"));
                                        break;
                                    case 'image_file':
                                        this._emit('imageFileDone', __classPrivateFieldGet$3(this, _AssistantStream_currentContent, "f").image_file, __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f"));
                                        break;
                                }
                            }
                            __classPrivateFieldSet$2(this, _AssistantStream_currentContentIndex, content.index, "f");
                        }
                        __classPrivateFieldSet$2(this, _AssistantStream_currentContent, accumulatedMessage.content[content.index], "f");
                    }
                }
                break;
            case 'thread.message.completed':
            case 'thread.message.incomplete':
                //We emit the latest content we were working on on completion (including incomplete)
                if (__classPrivateFieldGet$3(this, _AssistantStream_currentContentIndex, "f") !== undefined) {
                    const currentContent = event.data.content[__classPrivateFieldGet$3(this, _AssistantStream_currentContentIndex, "f")];
                    if (currentContent) {
                        switch (currentContent.type) {
                            case 'image_file':
                                this._emit('imageFileDone', currentContent.image_file, __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f"));
                                break;
                            case 'text':
                                this._emit('textDone', currentContent.text, __classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f"));
                                break;
                        }
                    }
                }
                if (__classPrivateFieldGet$3(this, _AssistantStream_messageSnapshot, "f")) {
                    this._emit('messageDone', event.data);
                }
                __classPrivateFieldSet$2(this, _AssistantStream_messageSnapshot, undefined, "f");
        }
    }, _AssistantStream_handleRunStep = function _AssistantStream_handleRunStep(event) {
        const accumulatedRunStep = __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_accumulateRunStep).call(this, event);
        __classPrivateFieldSet$2(this, _AssistantStream_currentRunStepSnapshot, accumulatedRunStep, "f");
        switch (event.event) {
            case 'thread.run.step.created':
                this._emit('runStepCreated', event.data);
                break;
            case 'thread.run.step.delta':
                const delta = event.data.delta;
                if (delta.step_details &&
                    delta.step_details.type == 'tool_calls' &&
                    delta.step_details.tool_calls &&
                    accumulatedRunStep.step_details.type == 'tool_calls') {
                    for (const toolCall of delta.step_details.tool_calls) {
                        if (toolCall.index == __classPrivateFieldGet$3(this, _AssistantStream_currentToolCallIndex, "f")) {
                            this._emit('toolCallDelta', toolCall, accumulatedRunStep.step_details.tool_calls[toolCall.index]);
                        }
                        else {
                            if (__classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f")) {
                                this._emit('toolCallDone', __classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f"));
                            }
                            __classPrivateFieldSet$2(this, _AssistantStream_currentToolCallIndex, toolCall.index, "f");
                            __classPrivateFieldSet$2(this, _AssistantStream_currentToolCall, accumulatedRunStep.step_details.tool_calls[toolCall.index], "f");
                            if (__classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f"))
                                this._emit('toolCallCreated', __classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f"));
                        }
                    }
                }
                this._emit('runStepDelta', event.data.delta, accumulatedRunStep);
                break;
            case 'thread.run.step.completed':
            case 'thread.run.step.failed':
            case 'thread.run.step.cancelled':
            case 'thread.run.step.expired':
                __classPrivateFieldSet$2(this, _AssistantStream_currentRunStepSnapshot, undefined, "f");
                const details = event.data.step_details;
                if (details.type == 'tool_calls') {
                    if (__classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f")) {
                        this._emit('toolCallDone', __classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f"));
                        __classPrivateFieldSet$2(this, _AssistantStream_currentToolCall, undefined, "f");
                    }
                }
                this._emit('runStepDone', event.data, accumulatedRunStep);
                break;
        }
    }, _AssistantStream_handleEvent = function _AssistantStream_handleEvent(event) {
        __classPrivateFieldGet$3(this, _AssistantStream_events, "f").push(event);
        this._emit('event', event);
    }, _AssistantStream_accumulateRunStep = function _AssistantStream_accumulateRunStep(event) {
        switch (event.event) {
            case 'thread.run.step.created':
                __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id] = event.data;
                return event.data;
            case 'thread.run.step.delta':
                let snapshot = __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id];
                if (!snapshot) {
                    throw Error('Received a RunStepDelta before creation of a snapshot');
                }
                let data = event.data;
                if (data.delta) {
                    const accumulated = AssistantStream.accumulateDelta(snapshot, data.delta);
                    __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id] = accumulated;
                }
                return __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id];
            case 'thread.run.step.completed':
            case 'thread.run.step.failed':
            case 'thread.run.step.cancelled':
            case 'thread.run.step.expired':
            case 'thread.run.step.in_progress':
                __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id] = event.data;
                break;
        }
        if (__classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id])
            return __classPrivateFieldGet$3(this, _AssistantStream_runStepSnapshots, "f")[event.data.id];
        throw new Error('No snapshot available');
    }, _AssistantStream_accumulateMessage = function _AssistantStream_accumulateMessage(event, snapshot) {
        let newContent = [];
        switch (event.event) {
            case 'thread.message.created':
                //On creation the snapshot is just the initial message
                return [event.data, newContent];
            case 'thread.message.delta':
                if (!snapshot) {
                    throw Error('Received a delta with no existing snapshot (there should be one from message creation)');
                }
                let data = event.data;
                //If this delta does not have content, nothing to process
                if (data.delta.content) {
                    for (const contentElement of data.delta.content) {
                        if (contentElement.index in snapshot.content) {
                            let currentContent = snapshot.content[contentElement.index];
                            snapshot.content[contentElement.index] = __classPrivateFieldGet$3(this, _AssistantStream_instances, "m", _AssistantStream_accumulateContent).call(this, contentElement, currentContent);
                        }
                        else {
                            snapshot.content[contentElement.index] = contentElement;
                            // This is a new element
                            newContent.push(contentElement);
                        }
                    }
                }
                return [snapshot, newContent];
            case 'thread.message.in_progress':
            case 'thread.message.completed':
            case 'thread.message.incomplete':
                //No changes on other thread events
                if (snapshot) {
                    return [snapshot, newContent];
                }
                else {
                    throw Error('Received thread message event with no existing snapshot');
                }
        }
        throw Error('Tried to accumulate a non-message event');
    }, _AssistantStream_accumulateContent = function _AssistantStream_accumulateContent(contentElement, currentContent) {
        return AssistantStream.accumulateDelta(currentContent, contentElement);
    }, _AssistantStream_handleRun = function _AssistantStream_handleRun(event) {
        __classPrivateFieldSet$2(this, _AssistantStream_currentRunSnapshot, event.data, "f");
        switch (event.event) {
            case 'thread.run.created':
                break;
            case 'thread.run.queued':
                break;
            case 'thread.run.in_progress':
                break;
            case 'thread.run.requires_action':
            case 'thread.run.cancelled':
            case 'thread.run.failed':
            case 'thread.run.completed':
            case 'thread.run.expired':
                __classPrivateFieldSet$2(this, _AssistantStream_finalRun, event.data, "f");
                if (__classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f")) {
                    this._emit('toolCallDone', __classPrivateFieldGet$3(this, _AssistantStream_currentToolCall, "f"));
                    __classPrivateFieldSet$2(this, _AssistantStream_currentToolCall, undefined, "f");
                }
                break;
        }
    };

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Assistants extends APIResource {
        /**
         * Create an assistant with a model and instructions.
         *
         * @example
         * ```ts
         * const assistant = await client.beta.assistants.create({
         *   model: 'gpt-4o',
         * });
         * ```
         */
        create(body, options) {
            return this._client.post('/assistants', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieves an assistant.
         *
         * @example
         * ```ts
         * const assistant = await client.beta.assistants.retrieve(
         *   'assistant_id',
         * );
         * ```
         */
        retrieve(assistantId, options) {
            return this._client.get(`/assistants/${assistantId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Modifies an assistant.
         *
         * @example
         * ```ts
         * const assistant = await client.beta.assistants.update(
         *   'assistant_id',
         * );
         * ```
         */
        update(assistantId, body, options) {
            return this._client.post(`/assistants/${assistantId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/assistants', AssistantsPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Delete an assistant.
         *
         * @example
         * ```ts
         * const assistantDeleted = await client.beta.assistants.del(
         *   'assistant_id',
         * );
         * ```
         */
        del(assistantId, options) {
            return this._client.delete(`/assistants/${assistantId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }
    class AssistantsPage extends CursorPage {
    }
    Assistants.AssistantsPage = AssistantsPage;

    function isRunnableFunctionWithParse(fn) {
        return typeof fn.parse === 'function';
    }

    const isAssistantMessage = (message) => {
        return message?.role === 'assistant';
    };
    const isFunctionMessage = (message) => {
        return message?.role === 'function';
    };
    const isToolMessage = (message) => {
        return message?.role === 'tool';
    };

    function isAutoParsableResponseFormat(response_format) {
        return response_format?.['$brand'] === 'auto-parseable-response-format';
    }
    function isAutoParsableTool$1(tool) {
        return tool?.['$brand'] === 'auto-parseable-tool';
    }
    function maybeParseChatCompletion(completion, params) {
        if (!params || !hasAutoParseableInput$1(params)) {
            return {
                ...completion,
                choices: completion.choices.map((choice) => ({
                    ...choice,
                    message: {
                        ...choice.message,
                        parsed: null,
                        ...(choice.message.tool_calls ?
                            {
                                tool_calls: choice.message.tool_calls,
                            }
                            : undefined),
                    },
                })),
            };
        }
        return parseChatCompletion(completion, params);
    }
    function parseChatCompletion(completion, params) {
        const choices = completion.choices.map((choice) => {
            if (choice.finish_reason === 'length') {
                throw new LengthFinishReasonError();
            }
            if (choice.finish_reason === 'content_filter') {
                throw new ContentFilterFinishReasonError();
            }
            return {
                ...choice,
                message: {
                    ...choice.message,
                    ...(choice.message.tool_calls ?
                        {
                            tool_calls: choice.message.tool_calls?.map((toolCall) => parseToolCall$1(params, toolCall)) ?? undefined,
                        }
                        : undefined),
                    parsed: choice.message.content && !choice.message.refusal ?
                        parseResponseFormat(params, choice.message.content)
                        : null,
                },
            };
        });
        return { ...completion, choices };
    }
    function parseResponseFormat(params, content) {
        if (params.response_format?.type !== 'json_schema') {
            return null;
        }
        if (params.response_format?.type === 'json_schema') {
            if ('$parseRaw' in params.response_format) {
                const response_format = params.response_format;
                return response_format.$parseRaw(content);
            }
            return JSON.parse(content);
        }
        return null;
    }
    function parseToolCall$1(params, toolCall) {
        const inputTool = params.tools?.find((inputTool) => inputTool.function?.name === toolCall.function.name);
        return {
            ...toolCall,
            function: {
                ...toolCall.function,
                parsed_arguments: isAutoParsableTool$1(inputTool) ? inputTool.$parseRaw(toolCall.function.arguments)
                    : inputTool?.function.strict ? JSON.parse(toolCall.function.arguments)
                        : null,
            },
        };
    }
    function shouldParseToolCall(params, toolCall) {
        if (!params) {
            return false;
        }
        const inputTool = params.tools?.find((inputTool) => inputTool.function?.name === toolCall.function.name);
        return isAutoParsableTool$1(inputTool) || inputTool?.function.strict || false;
    }
    function hasAutoParseableInput$1(params) {
        if (isAutoParsableResponseFormat(params.response_format)) {
            return true;
        }
        return (params.tools?.some((t) => isAutoParsableTool$1(t) || (t.type === 'function' && t.function.strict === true)) ?? false);
    }
    function validateInputTools(tools) {
        for (const tool of tools ?? []) {
            if (tool.type !== 'function') {
                throw new OpenAIError(`Currently only \`function\` tool types support auto-parsing; Received \`${tool.type}\``);
            }
            if (tool.function.strict !== true) {
                throw new OpenAIError(`The \`${tool.function.name}\` tool is not marked with \`strict: true\`. Only strict function tools can be auto-parsed`);
            }
        }
    }

    var __classPrivateFieldGet$2 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _AbstractChatCompletionRunner_instances, _AbstractChatCompletionRunner_getFinalContent, _AbstractChatCompletionRunner_getFinalMessage, _AbstractChatCompletionRunner_getFinalFunctionCall, _AbstractChatCompletionRunner_getFinalFunctionCallResult, _AbstractChatCompletionRunner_calculateTotalUsage, _AbstractChatCompletionRunner_validateParams, _AbstractChatCompletionRunner_stringifyFunctionCallResult;
    const DEFAULT_MAX_CHAT_COMPLETIONS = 10;
    class AbstractChatCompletionRunner extends EventStream {
        constructor() {
            super(...arguments);
            _AbstractChatCompletionRunner_instances.add(this);
            this._chatCompletions = [];
            this.messages = [];
        }
        _addChatCompletion(chatCompletion) {
            this._chatCompletions.push(chatCompletion);
            this._emit('chatCompletion', chatCompletion);
            const message = chatCompletion.choices[0]?.message;
            if (message)
                this._addMessage(message);
            return chatCompletion;
        }
        _addMessage(message, emit = true) {
            if (!('content' in message))
                message.content = null;
            this.messages.push(message);
            if (emit) {
                this._emit('message', message);
                if ((isFunctionMessage(message) || isToolMessage(message)) && message.content) {
                    // Note, this assumes that {role: 'tool', content: …} is always the result of a call of tool of type=function.
                    this._emit('functionCallResult', message.content);
                }
                else if (isAssistantMessage(message) && message.function_call) {
                    this._emit('functionCall', message.function_call);
                }
                else if (isAssistantMessage(message) && message.tool_calls) {
                    for (const tool_call of message.tool_calls) {
                        if (tool_call.type === 'function') {
                            this._emit('functionCall', tool_call.function);
                        }
                    }
                }
            }
        }
        /**
         * @returns a promise that resolves with the final ChatCompletion, or rejects
         * if an error occurred or the stream ended prematurely without producing a ChatCompletion.
         */
        async finalChatCompletion() {
            await this.done();
            const completion = this._chatCompletions[this._chatCompletions.length - 1];
            if (!completion)
                throw new OpenAIError('stream ended without producing a ChatCompletion');
            return completion;
        }
        /**
         * @returns a promise that resolves with the content of the final ChatCompletionMessage, or rejects
         * if an error occurred or the stream ended prematurely without producing a ChatCompletionMessage.
         */
        async finalContent() {
            await this.done();
            return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalContent).call(this);
        }
        /**
         * @returns a promise that resolves with the the final assistant ChatCompletionMessage response,
         * or rejects if an error occurred or the stream ended prematurely without producing a ChatCompletionMessage.
         */
        async finalMessage() {
            await this.done();
            return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalMessage).call(this);
        }
        /**
         * @returns a promise that resolves with the content of the final FunctionCall, or rejects
         * if an error occurred or the stream ended prematurely without producing a ChatCompletionMessage.
         */
        async finalFunctionCall() {
            await this.done();
            return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalFunctionCall).call(this);
        }
        async finalFunctionCallResult() {
            await this.done();
            return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalFunctionCallResult).call(this);
        }
        async totalUsage() {
            await this.done();
            return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_calculateTotalUsage).call(this);
        }
        allChatCompletions() {
            return [...this._chatCompletions];
        }
        _emitFinal() {
            const completion = this._chatCompletions[this._chatCompletions.length - 1];
            if (completion)
                this._emit('finalChatCompletion', completion);
            const finalMessage = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalMessage).call(this);
            if (finalMessage)
                this._emit('finalMessage', finalMessage);
            const finalContent = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalContent).call(this);
            if (finalContent)
                this._emit('finalContent', finalContent);
            const finalFunctionCall = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalFunctionCall).call(this);
            if (finalFunctionCall)
                this._emit('finalFunctionCall', finalFunctionCall);
            const finalFunctionCallResult = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalFunctionCallResult).call(this);
            if (finalFunctionCallResult != null)
                this._emit('finalFunctionCallResult', finalFunctionCallResult);
            if (this._chatCompletions.some((c) => c.usage)) {
                this._emit('totalUsage', __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_calculateTotalUsage).call(this));
            }
        }
        async _createChatCompletion(client, params, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_validateParams).call(this, params);
            const chatCompletion = await client.chat.completions.create({ ...params, stream: false }, { ...options, signal: this.controller.signal });
            this._connected();
            return this._addChatCompletion(parseChatCompletion(chatCompletion, params));
        }
        async _runChatCompletion(client, params, options) {
            for (const message of params.messages) {
                this._addMessage(message, false);
            }
            return await this._createChatCompletion(client, params, options);
        }
        async _runFunctions(client, params, options) {
            const role = 'function';
            const { function_call = 'auto', stream, ...restParams } = params;
            const singleFunctionToCall = typeof function_call !== 'string' && function_call?.name;
            const { maxChatCompletions = DEFAULT_MAX_CHAT_COMPLETIONS } = options || {};
            const functionsByName = {};
            for (const f of params.functions) {
                functionsByName[f.name || f.function.name] = f;
            }
            const functions = params.functions.map((f) => ({
                name: f.name || f.function.name,
                parameters: f.parameters,
                description: f.description,
            }));
            for (const message of params.messages) {
                this._addMessage(message, false);
            }
            for (let i = 0; i < maxChatCompletions; ++i) {
                const chatCompletion = await this._createChatCompletion(client, {
                    ...restParams,
                    function_call,
                    functions,
                    messages: [...this.messages],
                }, options);
                const message = chatCompletion.choices[0]?.message;
                if (!message) {
                    throw new OpenAIError(`missing message in ChatCompletion response`);
                }
                if (!message.function_call)
                    return;
                const { name, arguments: args } = message.function_call;
                const fn = functionsByName[name];
                if (!fn) {
                    const content = `Invalid function_call: ${JSON.stringify(name)}. Available options are: ${functions
                    .map((f) => JSON.stringify(f.name))
                    .join(', ')}. Please try again`;
                    this._addMessage({ role, name, content });
                    continue;
                }
                else if (singleFunctionToCall && singleFunctionToCall !== name) {
                    const content = `Invalid function_call: ${JSON.stringify(name)}. ${JSON.stringify(singleFunctionToCall)} requested. Please try again`;
                    this._addMessage({ role, name, content });
                    continue;
                }
                let parsed;
                try {
                    parsed = isRunnableFunctionWithParse(fn) ? await fn.parse(args) : args;
                }
                catch (error) {
                    this._addMessage({
                        role,
                        name,
                        content: error instanceof Error ? error.message : String(error),
                    });
                    continue;
                }
                // @ts-expect-error it can't rule out `never` type.
                const rawContent = await fn.function(parsed, this);
                const content = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_stringifyFunctionCallResult).call(this, rawContent);
                this._addMessage({ role, name, content });
                if (singleFunctionToCall)
                    return;
            }
        }
        async _runTools(client, params, options) {
            const role = 'tool';
            const { tool_choice = 'auto', stream, ...restParams } = params;
            const singleFunctionToCall = typeof tool_choice !== 'string' && tool_choice?.function?.name;
            const { maxChatCompletions = DEFAULT_MAX_CHAT_COMPLETIONS } = options || {};
            // TODO(someday): clean this logic up
            const inputTools = params.tools.map((tool) => {
                if (isAutoParsableTool$1(tool)) {
                    if (!tool.$callback) {
                        throw new OpenAIError('Tool given to `.runTools()` that does not have an associated function');
                    }
                    return {
                        type: 'function',
                        function: {
                            function: tool.$callback,
                            name: tool.function.name,
                            description: tool.function.description || '',
                            parameters: tool.function.parameters,
                            parse: tool.$parseRaw,
                            strict: true,
                        },
                    };
                }
                return tool;
            });
            const functionsByName = {};
            for (const f of inputTools) {
                if (f.type === 'function') {
                    functionsByName[f.function.name || f.function.function.name] = f.function;
                }
            }
            const tools = 'tools' in params ?
                inputTools.map((t) => t.type === 'function' ?
                    {
                        type: 'function',
                        function: {
                            name: t.function.name || t.function.function.name,
                            parameters: t.function.parameters,
                            description: t.function.description,
                            strict: t.function.strict,
                        },
                    }
                    : t)
                : undefined;
            for (const message of params.messages) {
                this._addMessage(message, false);
            }
            for (let i = 0; i < maxChatCompletions; ++i) {
                const chatCompletion = await this._createChatCompletion(client, {
                    ...restParams,
                    tool_choice,
                    tools,
                    messages: [...this.messages],
                }, options);
                const message = chatCompletion.choices[0]?.message;
                if (!message) {
                    throw new OpenAIError(`missing message in ChatCompletion response`);
                }
                if (!message.tool_calls?.length) {
                    return;
                }
                for (const tool_call of message.tool_calls) {
                    if (tool_call.type !== 'function')
                        continue;
                    const tool_call_id = tool_call.id;
                    const { name, arguments: args } = tool_call.function;
                    const fn = functionsByName[name];
                    if (!fn) {
                        const content = `Invalid tool_call: ${JSON.stringify(name)}. Available options are: ${Object.keys(functionsByName)
                        .map((name) => JSON.stringify(name))
                        .join(', ')}. Please try again`;
                        this._addMessage({ role, tool_call_id, content });
                        continue;
                    }
                    else if (singleFunctionToCall && singleFunctionToCall !== name) {
                        const content = `Invalid tool_call: ${JSON.stringify(name)}. ${JSON.stringify(singleFunctionToCall)} requested. Please try again`;
                        this._addMessage({ role, tool_call_id, content });
                        continue;
                    }
                    let parsed;
                    try {
                        parsed = isRunnableFunctionWithParse(fn) ? await fn.parse(args) : args;
                    }
                    catch (error) {
                        const content = error instanceof Error ? error.message : String(error);
                        this._addMessage({ role, tool_call_id, content });
                        continue;
                    }
                    // @ts-expect-error it can't rule out `never` type.
                    const rawContent = await fn.function(parsed, this);
                    const content = __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_stringifyFunctionCallResult).call(this, rawContent);
                    this._addMessage({ role, tool_call_id, content });
                    if (singleFunctionToCall) {
                        return;
                    }
                }
            }
            return;
        }
    }
    _AbstractChatCompletionRunner_instances = new WeakSet(), _AbstractChatCompletionRunner_getFinalContent = function _AbstractChatCompletionRunner_getFinalContent() {
        return __classPrivateFieldGet$2(this, _AbstractChatCompletionRunner_instances, "m", _AbstractChatCompletionRunner_getFinalMessage).call(this).content ?? null;
    }, _AbstractChatCompletionRunner_getFinalMessage = function _AbstractChatCompletionRunner_getFinalMessage() {
        let i = this.messages.length;
        while (i-- > 0) {
            const message = this.messages[i];
            if (isAssistantMessage(message)) {
                const { function_call, ...rest } = message;
                // TODO: support audio here
                const ret = {
                    ...rest,
                    content: message.content ?? null,
                    refusal: message.refusal ?? null,
                };
                if (function_call) {
                    ret.function_call = function_call;
                }
                return ret;
            }
        }
        throw new OpenAIError('stream ended without producing a ChatCompletionMessage with role=assistant');
    }, _AbstractChatCompletionRunner_getFinalFunctionCall = function _AbstractChatCompletionRunner_getFinalFunctionCall() {
        for (let i = this.messages.length - 1; i >= 0; i--) {
            const message = this.messages[i];
            if (isAssistantMessage(message) && message?.function_call) {
                return message.function_call;
            }
            if (isAssistantMessage(message) && message?.tool_calls?.length) {
                return message.tool_calls.at(-1)?.function;
            }
        }
        return;
    }, _AbstractChatCompletionRunner_getFinalFunctionCallResult = function _AbstractChatCompletionRunner_getFinalFunctionCallResult() {
        for (let i = this.messages.length - 1; i >= 0; i--) {
            const message = this.messages[i];
            if (isFunctionMessage(message) && message.content != null) {
                return message.content;
            }
            if (isToolMessage(message) &&
                message.content != null &&
                typeof message.content === 'string' &&
                this.messages.some((x) => x.role === 'assistant' &&
                    x.tool_calls?.some((y) => y.type === 'function' && y.id === message.tool_call_id))) {
                return message.content;
            }
        }
        return;
    }, _AbstractChatCompletionRunner_calculateTotalUsage = function _AbstractChatCompletionRunner_calculateTotalUsage() {
        const total = {
            completion_tokens: 0,
            prompt_tokens: 0,
            total_tokens: 0,
        };
        for (const { usage } of this._chatCompletions) {
            if (usage) {
                total.completion_tokens += usage.completion_tokens;
                total.prompt_tokens += usage.prompt_tokens;
                total.total_tokens += usage.total_tokens;
            }
        }
        return total;
    }, _AbstractChatCompletionRunner_validateParams = function _AbstractChatCompletionRunner_validateParams(params) {
        if (params.n != null && params.n > 1) {
            throw new OpenAIError('ChatCompletion convenience helpers only support n=1 at this time. To use n>1, please use chat.completions.create() directly.');
        }
    }, _AbstractChatCompletionRunner_stringifyFunctionCallResult = function _AbstractChatCompletionRunner_stringifyFunctionCallResult(rawContent) {
        return (typeof rawContent === 'string' ? rawContent
            : rawContent === undefined ? 'undefined'
                : JSON.stringify(rawContent));
    };

    class ChatCompletionRunner extends AbstractChatCompletionRunner {
        /** @deprecated - please use `runTools` instead. */
        static runFunctions(client, params, options) {
            const runner = new ChatCompletionRunner();
            const opts = {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'runFunctions' },
            };
            runner._run(() => runner._runFunctions(client, params, opts));
            return runner;
        }
        static runTools(client, params, options) {
            const runner = new ChatCompletionRunner();
            const opts = {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'runTools' },
            };
            runner._run(() => runner._runTools(client, params, opts));
            return runner;
        }
        _addMessage(message, emit = true) {
            super._addMessage(message, emit);
            if (isAssistantMessage(message) && message.content) {
                this._emit('content', message.content);
            }
        }
    }

    const STR = 0b000000001;
    const NUM = 0b000000010;
    const ARR = 0b000000100;
    const OBJ = 0b000001000;
    const NULL = 0b000010000;
    const BOOL = 0b000100000;
    const NAN = 0b001000000;
    const INFINITY = 0b010000000;
    const MINUS_INFINITY = 0b100000000;
    const INF = INFINITY | MINUS_INFINITY;
    const SPECIAL = NULL | BOOL | INF | NAN;
    const ATOM = STR | NUM | SPECIAL;
    const COLLECTION = ARR | OBJ;
    const ALL = ATOM | COLLECTION;
    const Allow = {
        STR,
        NUM,
        ARR,
        OBJ,
        NULL,
        BOOL,
        NAN,
        INFINITY,
        MINUS_INFINITY,
        INF,
        SPECIAL,
        ATOM,
        COLLECTION,
        ALL,
    };
    // The JSON string segment was unable to be parsed completely
    class PartialJSON extends Error {
    }
    class MalformedJSON extends Error {
    }
    /**
     * Parse incomplete JSON
     * @param {string} jsonString Partial JSON to be parsed
     * @param {number} allowPartial Specify what types are allowed to be partial, see {@link Allow} for details
     * @returns The parsed JSON
     * @throws {PartialJSON} If the JSON is incomplete (related to the `allow` parameter)
     * @throws {MalformedJSON} If the JSON is malformed
     */
    function parseJSON(jsonString, allowPartial = Allow.ALL) {
        if (typeof jsonString !== 'string') {
            throw new TypeError(`expecting str, got ${typeof jsonString}`);
        }
        if (!jsonString.trim()) {
            throw new Error(`${jsonString} is empty`);
        }
        return _parseJSON(jsonString.trim(), allowPartial);
    }
    const _parseJSON = (jsonString, allow) => {
        const length = jsonString.length;
        let index = 0;
        const markPartialJSON = (msg) => {
            throw new PartialJSON(`${msg} at position ${index}`);
        };
        const throwMalformedError = (msg) => {
            throw new MalformedJSON(`${msg} at position ${index}`);
        };
        const parseAny = () => {
            skipBlank();
            if (index >= length)
                markPartialJSON('Unexpected end of input');
            if (jsonString[index] === '"')
                return parseStr();
            if (jsonString[index] === '{')
                return parseObj();
            if (jsonString[index] === '[')
                return parseArr();
            if (jsonString.substring(index, index + 4) === 'null' ||
                (Allow.NULL & allow && length - index < 4 && 'null'.startsWith(jsonString.substring(index)))) {
                index += 4;
                return null;
            }
            if (jsonString.substring(index, index + 4) === 'true' ||
                (Allow.BOOL & allow && length - index < 4 && 'true'.startsWith(jsonString.substring(index)))) {
                index += 4;
                return true;
            }
            if (jsonString.substring(index, index + 5) === 'false' ||
                (Allow.BOOL & allow && length - index < 5 && 'false'.startsWith(jsonString.substring(index)))) {
                index += 5;
                return false;
            }
            if (jsonString.substring(index, index + 8) === 'Infinity' ||
                (Allow.INFINITY & allow && length - index < 8 && 'Infinity'.startsWith(jsonString.substring(index)))) {
                index += 8;
                return Infinity;
            }
            if (jsonString.substring(index, index + 9) === '-Infinity' ||
                (Allow.MINUS_INFINITY & allow &&
                    1 < length - index &&
                    length - index < 9 &&
                    '-Infinity'.startsWith(jsonString.substring(index)))) {
                index += 9;
                return -Infinity;
            }
            if (jsonString.substring(index, index + 3) === 'NaN' ||
                (Allow.NAN & allow && length - index < 3 && 'NaN'.startsWith(jsonString.substring(index)))) {
                index += 3;
                return NaN;
            }
            return parseNum();
        };
        const parseStr = () => {
            const start = index;
            let escape = false;
            index++; // skip initial quote
            while (index < length && (jsonString[index] !== '"' || (escape && jsonString[index - 1] === '\\'))) {
                escape = jsonString[index] === '\\' ? !escape : false;
                index++;
            }
            if (jsonString.charAt(index) == '"') {
                try {
                    return JSON.parse(jsonString.substring(start, ++index - Number(escape)));
                }
                catch (e) {
                    throwMalformedError(String(e));
                }
            }
            else if (Allow.STR & allow) {
                try {
                    return JSON.parse(jsonString.substring(start, index - Number(escape)) + '"');
                }
                catch (e) {
                    // SyntaxError: Invalid escape sequence
                    return JSON.parse(jsonString.substring(start, jsonString.lastIndexOf('\\')) + '"');
                }
            }
            markPartialJSON('Unterminated string literal');
        };
        const parseObj = () => {
            index++; // skip initial brace
            skipBlank();
            const obj = {};
            try {
                while (jsonString[index] !== '}') {
                    skipBlank();
                    if (index >= length && Allow.OBJ & allow)
                        return obj;
                    const key = parseStr();
                    skipBlank();
                    index++; // skip colon
                    try {
                        const value = parseAny();
                        Object.defineProperty(obj, key, { value, writable: true, enumerable: true, configurable: true });
                    }
                    catch (e) {
                        if (Allow.OBJ & allow)
                            return obj;
                        else
                            throw e;
                    }
                    skipBlank();
                    if (jsonString[index] === ',')
                        index++; // skip comma
                }
            }
            catch (e) {
                if (Allow.OBJ & allow)
                    return obj;
                else
                    markPartialJSON("Expected '}' at end of object");
            }
            index++; // skip final brace
            return obj;
        };
        const parseArr = () => {
            index++; // skip initial bracket
            const arr = [];
            try {
                while (jsonString[index] !== ']') {
                    arr.push(parseAny());
                    skipBlank();
                    if (jsonString[index] === ',') {
                        index++; // skip comma
                    }
                }
            }
            catch (e) {
                if (Allow.ARR & allow) {
                    return arr;
                }
                markPartialJSON("Expected ']' at end of array");
            }
            index++; // skip final bracket
            return arr;
        };
        const parseNum = () => {
            if (index === 0) {
                if (jsonString === '-' && Allow.NUM & allow)
                    markPartialJSON("Not sure what '-' is");
                try {
                    return JSON.parse(jsonString);
                }
                catch (e) {
                    if (Allow.NUM & allow) {
                        try {
                            if ('.' === jsonString[jsonString.length - 1])
                                return JSON.parse(jsonString.substring(0, jsonString.lastIndexOf('.')));
                            return JSON.parse(jsonString.substring(0, jsonString.lastIndexOf('e')));
                        }
                        catch (e) { }
                    }
                    throwMalformedError(String(e));
                }
            }
            const start = index;
            if (jsonString[index] === '-')
                index++;
            while (jsonString[index] && !',]}'.includes(jsonString[index]))
                index++;
            if (index == length && !(Allow.NUM & allow))
                markPartialJSON('Unterminated number literal');
            try {
                return JSON.parse(jsonString.substring(start, index));
            }
            catch (e) {
                if (jsonString.substring(start, index) === '-' && Allow.NUM & allow)
                    markPartialJSON("Not sure what '-' is");
                try {
                    return JSON.parse(jsonString.substring(start, jsonString.lastIndexOf('e')));
                }
                catch (e) {
                    throwMalformedError(String(e));
                }
            }
        };
        const skipBlank = () => {
            while (index < length && ' \n\r\t'.includes(jsonString[index])) {
                index++;
            }
        };
        return parseAny();
    };
    // using this function with malformed JSON is undefined behavior
    const partialParse = (input) => parseJSON(input, Allow.ALL ^ Allow.NUM);

    var __classPrivateFieldSet$1 = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var __classPrivateFieldGet$1 = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _ChatCompletionStream_instances, _ChatCompletionStream_params, _ChatCompletionStream_choiceEventStates, _ChatCompletionStream_currentChatCompletionSnapshot, _ChatCompletionStream_beginRequest, _ChatCompletionStream_getChoiceEventState, _ChatCompletionStream_addChunk, _ChatCompletionStream_emitToolCallDoneEvent, _ChatCompletionStream_emitContentDoneEvents, _ChatCompletionStream_endRequest, _ChatCompletionStream_getAutoParseableResponseFormat, _ChatCompletionStream_accumulateChatCompletion;
    class ChatCompletionStream extends AbstractChatCompletionRunner {
        constructor(params) {
            super();
            _ChatCompletionStream_instances.add(this);
            _ChatCompletionStream_params.set(this, void 0);
            _ChatCompletionStream_choiceEventStates.set(this, void 0);
            _ChatCompletionStream_currentChatCompletionSnapshot.set(this, void 0);
            __classPrivateFieldSet$1(this, _ChatCompletionStream_params, params, "f");
            __classPrivateFieldSet$1(this, _ChatCompletionStream_choiceEventStates, [], "f");
        }
        get currentChatCompletionSnapshot() {
            return __classPrivateFieldGet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, "f");
        }
        /**
         * Intended for use on the frontend, consuming a stream produced with
         * `.toReadableStream()` on the backend.
         *
         * Note that messages sent to the model do not appear in `.on('message')`
         * in this context.
         */
        static fromReadableStream(stream) {
            const runner = new ChatCompletionStream(null);
            runner._run(() => runner._fromReadableStream(stream));
            return runner;
        }
        static createChatCompletion(client, params, options) {
            const runner = new ChatCompletionStream(params);
            runner._run(() => runner._runChatCompletion(client, { ...params, stream: true }, { ...options, headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'stream' } }));
            return runner;
        }
        async _createChatCompletion(client, params, options) {
            super._createChatCompletion;
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_beginRequest).call(this);
            const stream = await client.chat.completions.create({ ...params, stream: true }, { ...options, signal: this.controller.signal });
            this._connected();
            for await (const chunk of stream) {
                __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_addChunk).call(this, chunk);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addChatCompletion(__classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_endRequest).call(this));
        }
        async _fromReadableStream(readableStream, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_beginRequest).call(this);
            this._connected();
            const stream = Stream.fromReadableStream(readableStream, this.controller);
            let chatId;
            for await (const chunk of stream) {
                if (chatId && chatId !== chunk.id) {
                    // A new request has been made.
                    this._addChatCompletion(__classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_endRequest).call(this));
                }
                __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_addChunk).call(this, chunk);
                chatId = chunk.id;
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return this._addChatCompletion(__classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_endRequest).call(this));
        }
        [(_ChatCompletionStream_params = new WeakMap(), _ChatCompletionStream_choiceEventStates = new WeakMap(), _ChatCompletionStream_currentChatCompletionSnapshot = new WeakMap(), _ChatCompletionStream_instances = new WeakSet(), _ChatCompletionStream_beginRequest = function _ChatCompletionStream_beginRequest() {
            if (this.ended)
                return;
            __classPrivateFieldSet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, undefined, "f");
        }, _ChatCompletionStream_getChoiceEventState = function _ChatCompletionStream_getChoiceEventState(choice) {
            let state = __classPrivateFieldGet$1(this, _ChatCompletionStream_choiceEventStates, "f")[choice.index];
            if (state) {
                return state;
            }
            state = {
                content_done: false,
                refusal_done: false,
                logprobs_content_done: false,
                logprobs_refusal_done: false,
                done_tool_calls: new Set(),
                current_tool_call_index: null,
            };
            __classPrivateFieldGet$1(this, _ChatCompletionStream_choiceEventStates, "f")[choice.index] = state;
            return state;
        }, _ChatCompletionStream_addChunk = function _ChatCompletionStream_addChunk(chunk) {
            if (this.ended)
                return;
            const completion = __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_accumulateChatCompletion).call(this, chunk);
            this._emit('chunk', chunk, completion);
            for (const choice of chunk.choices) {
                const choiceSnapshot = completion.choices[choice.index];
                if (choice.delta.content != null &&
                    choiceSnapshot.message?.role === 'assistant' &&
                    choiceSnapshot.message?.content) {
                    this._emit('content', choice.delta.content, choiceSnapshot.message.content);
                    this._emit('content.delta', {
                        delta: choice.delta.content,
                        snapshot: choiceSnapshot.message.content,
                        parsed: choiceSnapshot.message.parsed,
                    });
                }
                if (choice.delta.refusal != null &&
                    choiceSnapshot.message?.role === 'assistant' &&
                    choiceSnapshot.message?.refusal) {
                    this._emit('refusal.delta', {
                        delta: choice.delta.refusal,
                        snapshot: choiceSnapshot.message.refusal,
                    });
                }
                if (choice.logprobs?.content != null && choiceSnapshot.message?.role === 'assistant') {
                    this._emit('logprobs.content.delta', {
                        content: choice.logprobs?.content,
                        snapshot: choiceSnapshot.logprobs?.content ?? [],
                    });
                }
                if (choice.logprobs?.refusal != null && choiceSnapshot.message?.role === 'assistant') {
                    this._emit('logprobs.refusal.delta', {
                        refusal: choice.logprobs?.refusal,
                        snapshot: choiceSnapshot.logprobs?.refusal ?? [],
                    });
                }
                const state = __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_getChoiceEventState).call(this, choiceSnapshot);
                if (choiceSnapshot.finish_reason) {
                    __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_emitContentDoneEvents).call(this, choiceSnapshot);
                    if (state.current_tool_call_index != null) {
                        __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_emitToolCallDoneEvent).call(this, choiceSnapshot, state.current_tool_call_index);
                    }
                }
                for (const toolCall of choice.delta.tool_calls ?? []) {
                    if (state.current_tool_call_index !== toolCall.index) {
                        __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_emitContentDoneEvents).call(this, choiceSnapshot);
                        // new tool call started, the previous one is done
                        if (state.current_tool_call_index != null) {
                            __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_emitToolCallDoneEvent).call(this, choiceSnapshot, state.current_tool_call_index);
                        }
                    }
                    state.current_tool_call_index = toolCall.index;
                }
                for (const toolCallDelta of choice.delta.tool_calls ?? []) {
                    const toolCallSnapshot = choiceSnapshot.message.tool_calls?.[toolCallDelta.index];
                    if (!toolCallSnapshot?.type) {
                        continue;
                    }
                    if (toolCallSnapshot?.type === 'function') {
                        this._emit('tool_calls.function.arguments.delta', {
                            name: toolCallSnapshot.function?.name,
                            index: toolCallDelta.index,
                            arguments: toolCallSnapshot.function.arguments,
                            parsed_arguments: toolCallSnapshot.function.parsed_arguments,
                            arguments_delta: toolCallDelta.function?.arguments ?? '',
                        });
                    }
                    else {
                        assertNever(toolCallSnapshot?.type);
                    }
                }
            }
        }, _ChatCompletionStream_emitToolCallDoneEvent = function _ChatCompletionStream_emitToolCallDoneEvent(choiceSnapshot, toolCallIndex) {
            const state = __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_getChoiceEventState).call(this, choiceSnapshot);
            if (state.done_tool_calls.has(toolCallIndex)) {
                // we've already fired the done event
                return;
            }
            const toolCallSnapshot = choiceSnapshot.message.tool_calls?.[toolCallIndex];
            if (!toolCallSnapshot) {
                throw new Error('no tool call snapshot');
            }
            if (!toolCallSnapshot.type) {
                throw new Error('tool call snapshot missing `type`');
            }
            if (toolCallSnapshot.type === 'function') {
                const inputTool = __classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f")?.tools?.find((tool) => tool.type === 'function' && tool.function.name === toolCallSnapshot.function.name);
                this._emit('tool_calls.function.arguments.done', {
                    name: toolCallSnapshot.function.name,
                    index: toolCallIndex,
                    arguments: toolCallSnapshot.function.arguments,
                    parsed_arguments: isAutoParsableTool$1(inputTool) ? inputTool.$parseRaw(toolCallSnapshot.function.arguments)
                        : inputTool?.function.strict ? JSON.parse(toolCallSnapshot.function.arguments)
                            : null,
                });
            }
            else {
                assertNever(toolCallSnapshot.type);
            }
        }, _ChatCompletionStream_emitContentDoneEvents = function _ChatCompletionStream_emitContentDoneEvents(choiceSnapshot) {
            const state = __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_getChoiceEventState).call(this, choiceSnapshot);
            if (choiceSnapshot.message.content && !state.content_done) {
                state.content_done = true;
                const responseFormat = __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_getAutoParseableResponseFormat).call(this);
                this._emit('content.done', {
                    content: choiceSnapshot.message.content,
                    parsed: responseFormat ? responseFormat.$parseRaw(choiceSnapshot.message.content) : null,
                });
            }
            if (choiceSnapshot.message.refusal && !state.refusal_done) {
                state.refusal_done = true;
                this._emit('refusal.done', { refusal: choiceSnapshot.message.refusal });
            }
            if (choiceSnapshot.logprobs?.content && !state.logprobs_content_done) {
                state.logprobs_content_done = true;
                this._emit('logprobs.content.done', { content: choiceSnapshot.logprobs.content });
            }
            if (choiceSnapshot.logprobs?.refusal && !state.logprobs_refusal_done) {
                state.logprobs_refusal_done = true;
                this._emit('logprobs.refusal.done', { refusal: choiceSnapshot.logprobs.refusal });
            }
        }, _ChatCompletionStream_endRequest = function _ChatCompletionStream_endRequest() {
            if (this.ended) {
                throw new OpenAIError(`stream has ended, this shouldn't happen`);
            }
            const snapshot = __classPrivateFieldGet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, "f");
            if (!snapshot) {
                throw new OpenAIError(`request ended without sending any chunks`);
            }
            __classPrivateFieldSet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, undefined, "f");
            __classPrivateFieldSet$1(this, _ChatCompletionStream_choiceEventStates, [], "f");
            return finalizeChatCompletion(snapshot, __classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f"));
        }, _ChatCompletionStream_getAutoParseableResponseFormat = function _ChatCompletionStream_getAutoParseableResponseFormat() {
            const responseFormat = __classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f")?.response_format;
            if (isAutoParsableResponseFormat(responseFormat)) {
                return responseFormat;
            }
            return null;
        }, _ChatCompletionStream_accumulateChatCompletion = function _ChatCompletionStream_accumulateChatCompletion(chunk) {
            var _a, _b, _c, _d;
            let snapshot = __classPrivateFieldGet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, "f");
            const { choices, ...rest } = chunk;
            if (!snapshot) {
                snapshot = __classPrivateFieldSet$1(this, _ChatCompletionStream_currentChatCompletionSnapshot, {
                    ...rest,
                    choices: [],
                }, "f");
            }
            else {
                Object.assign(snapshot, rest);
            }
            for (const { delta, finish_reason, index, logprobs = null, ...other } of chunk.choices) {
                let choice = snapshot.choices[index];
                if (!choice) {
                    choice = snapshot.choices[index] = { finish_reason, index, message: {}, logprobs, ...other };
                }
                if (logprobs) {
                    if (!choice.logprobs) {
                        choice.logprobs = Object.assign({}, logprobs);
                    }
                    else {
                        const { content, refusal, ...rest } = logprobs;
                        Object.assign(choice.logprobs, rest);
                        if (content) {
                            (_a = choice.logprobs).content ?? (_a.content = []);
                            choice.logprobs.content.push(...content);
                        }
                        if (refusal) {
                            (_b = choice.logprobs).refusal ?? (_b.refusal = []);
                            choice.logprobs.refusal.push(...refusal);
                        }
                    }
                }
                if (finish_reason) {
                    choice.finish_reason = finish_reason;
                    if (__classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f") && hasAutoParseableInput$1(__classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f"))) {
                        if (finish_reason === 'length') {
                            throw new LengthFinishReasonError();
                        }
                        if (finish_reason === 'content_filter') {
                            throw new ContentFilterFinishReasonError();
                        }
                    }
                }
                Object.assign(choice, other);
                if (!delta)
                    continue; // Shouldn't happen; just in case.
                const { content, refusal, function_call, role, tool_calls, ...rest } = delta;
                Object.assign(choice.message, rest);
                if (refusal) {
                    choice.message.refusal = (choice.message.refusal || '') + refusal;
                }
                if (role)
                    choice.message.role = role;
                if (function_call) {
                    if (!choice.message.function_call) {
                        choice.message.function_call = function_call;
                    }
                    else {
                        if (function_call.name)
                            choice.message.function_call.name = function_call.name;
                        if (function_call.arguments) {
                            (_c = choice.message.function_call).arguments ?? (_c.arguments = '');
                            choice.message.function_call.arguments += function_call.arguments;
                        }
                    }
                }
                if (content) {
                    choice.message.content = (choice.message.content || '') + content;
                    if (!choice.message.refusal && __classPrivateFieldGet$1(this, _ChatCompletionStream_instances, "m", _ChatCompletionStream_getAutoParseableResponseFormat).call(this)) {
                        choice.message.parsed = partialParse(choice.message.content);
                    }
                }
                if (tool_calls) {
                    if (!choice.message.tool_calls)
                        choice.message.tool_calls = [];
                    for (const { index, id, type, function: fn, ...rest } of tool_calls) {
                        const tool_call = ((_d = choice.message.tool_calls)[index] ?? (_d[index] = {}));
                        Object.assign(tool_call, rest);
                        if (id)
                            tool_call.id = id;
                        if (type)
                            tool_call.type = type;
                        if (fn)
                            tool_call.function ?? (tool_call.function = { name: fn.name ?? '', arguments: '' });
                        if (fn?.name)
                            tool_call.function.name = fn.name;
                        if (fn?.arguments) {
                            tool_call.function.arguments += fn.arguments;
                            if (shouldParseToolCall(__classPrivateFieldGet$1(this, _ChatCompletionStream_params, "f"), tool_call)) {
                                tool_call.function.parsed_arguments = partialParse(tool_call.function.arguments);
                            }
                        }
                    }
                }
            }
            return snapshot;
        }, Symbol.asyncIterator)]() {
            const pushQueue = [];
            const readQueue = [];
            let done = false;
            this.on('chunk', (chunk) => {
                const reader = readQueue.shift();
                if (reader) {
                    reader.resolve(chunk);
                }
                else {
                    pushQueue.push(chunk);
                }
            });
            this.on('end', () => {
                done = true;
                for (const reader of readQueue) {
                    reader.resolve(undefined);
                }
                readQueue.length = 0;
            });
            this.on('abort', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            this.on('error', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            return {
                next: async () => {
                    if (!pushQueue.length) {
                        if (done) {
                            return { value: undefined, done: true };
                        }
                        return new Promise((resolve, reject) => readQueue.push({ resolve, reject })).then((chunk) => (chunk ? { value: chunk, done: false } : { value: undefined, done: true }));
                    }
                    const chunk = pushQueue.shift();
                    return { value: chunk, done: false };
                },
                return: async () => {
                    this.abort();
                    return { value: undefined, done: true };
                },
            };
        }
        toReadableStream() {
            const stream = new Stream(this[Symbol.asyncIterator].bind(this), this.controller);
            return stream.toReadableStream();
        }
    }
    function finalizeChatCompletion(snapshot, params) {
        const { id, choices, created, model, system_fingerprint, ...rest } = snapshot;
        const completion = {
            ...rest,
            id,
            choices: choices.map(({ message, finish_reason, index, logprobs, ...choiceRest }) => {
                if (!finish_reason) {
                    throw new OpenAIError(`missing finish_reason for choice ${index}`);
                }
                const { content = null, function_call, tool_calls, ...messageRest } = message;
                const role = message.role; // this is what we expect; in theory it could be different which would make our types a slight lie but would be fine.
                if (!role) {
                    throw new OpenAIError(`missing role for choice ${index}`);
                }
                if (function_call) {
                    const { arguments: args, name } = function_call;
                    if (args == null) {
                        throw new OpenAIError(`missing function_call.arguments for choice ${index}`);
                    }
                    if (!name) {
                        throw new OpenAIError(`missing function_call.name for choice ${index}`);
                    }
                    return {
                        ...choiceRest,
                        message: {
                            content,
                            function_call: { arguments: args, name },
                            role,
                            refusal: message.refusal ?? null,
                        },
                        finish_reason,
                        index,
                        logprobs,
                    };
                }
                if (tool_calls) {
                    return {
                        ...choiceRest,
                        index,
                        finish_reason,
                        logprobs,
                        message: {
                            ...messageRest,
                            role,
                            content,
                            refusal: message.refusal ?? null,
                            tool_calls: tool_calls.map((tool_call, i) => {
                                const { function: fn, type, id, ...toolRest } = tool_call;
                                const { arguments: args, name, ...fnRest } = fn || {};
                                if (id == null) {
                                    throw new OpenAIError(`missing choices[${index}].tool_calls[${i}].id\n${str(snapshot)}`);
                                }
                                if (type == null) {
                                    throw new OpenAIError(`missing choices[${index}].tool_calls[${i}].type\n${str(snapshot)}`);
                                }
                                if (name == null) {
                                    throw new OpenAIError(`missing choices[${index}].tool_calls[${i}].function.name\n${str(snapshot)}`);
                                }
                                if (args == null) {
                                    throw new OpenAIError(`missing choices[${index}].tool_calls[${i}].function.arguments\n${str(snapshot)}`);
                                }
                                return { ...toolRest, id, type, function: { ...fnRest, name, arguments: args } };
                            }),
                        },
                    };
                }
                return {
                    ...choiceRest,
                    message: { ...messageRest, content, role, refusal: message.refusal ?? null },
                    finish_reason,
                    index,
                    logprobs,
                };
            }),
            created,
            model,
            object: 'chat.completion',
            ...(system_fingerprint ? { system_fingerprint } : {}),
        };
        return maybeParseChatCompletion(completion, params);
    }
    function str(x) {
        return JSON.stringify(x);
    }
    function assertNever(_x) { }

    class ChatCompletionStreamingRunner extends ChatCompletionStream {
        static fromReadableStream(stream) {
            const runner = new ChatCompletionStreamingRunner(null);
            runner._run(() => runner._fromReadableStream(stream));
            return runner;
        }
        /** @deprecated - please use `runTools` instead. */
        static runFunctions(client, params, options) {
            const runner = new ChatCompletionStreamingRunner(null);
            const opts = {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'runFunctions' },
            };
            runner._run(() => runner._runFunctions(client, params, opts));
            return runner;
        }
        static runTools(client, params, options) {
            const runner = new ChatCompletionStreamingRunner(
            // @ts-expect-error TODO these types are incompatible
            params);
            const opts = {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'runTools' },
            };
            runner._run(() => runner._runTools(client, params, opts));
            return runner;
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Completions$1 = class Completions extends APIResource {
        parse(body, options) {
            validateInputTools(body.tools);
            return this._client.chat.completions
                .create(body, {
                ...options,
                headers: {
                    ...options?.headers,
                    'X-Stainless-Helper-Method': 'beta.chat.completions.parse',
                },
            })
                ._thenUnwrap((completion) => parseChatCompletion(completion, body));
        }
        runFunctions(body, options) {
            if (body.stream) {
                return ChatCompletionStreamingRunner.runFunctions(this._client, body, options);
            }
            return ChatCompletionRunner.runFunctions(this._client, body, options);
        }
        runTools(body, options) {
            if (body.stream) {
                return ChatCompletionStreamingRunner.runTools(this._client, body, options);
            }
            return ChatCompletionRunner.runTools(this._client, body, options);
        }
        /**
         * Creates a chat completion stream
         */
        stream(body, options) {
            return ChatCompletionStream.createChatCompletion(this._client, body, options);
        }
    };

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Chat extends APIResource {
        constructor() {
            super(...arguments);
            this.completions = new Completions$1(this._client);
        }
    }
    (function (Chat) {
        Chat.Completions = Completions$1;
    })(Chat || (Chat = {}));

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Sessions extends APIResource {
        /**
         * Create an ephemeral API token for use in client-side applications with the
         * Realtime API. Can be configured with the same session parameters as the
         * `session.update` client event.
         *
         * It responds with a session object, plus a `client_secret` key which contains a
         * usable ephemeral API token that can be used to authenticate browser clients for
         * the Realtime API.
         *
         * @example
         * ```ts
         * const session =
         *   await client.beta.realtime.sessions.create();
         * ```
         */
        create(body, options) {
            return this._client.post('/realtime/sessions', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class TranscriptionSessions extends APIResource {
        /**
         * Create an ephemeral API token for use in client-side applications with the
         * Realtime API specifically for realtime transcriptions. Can be configured with
         * the same session parameters as the `transcription_session.update` client event.
         *
         * It responds with a session object, plus a `client_secret` key which contains a
         * usable ephemeral API token that can be used to authenticate browser clients for
         * the Realtime API.
         *
         * @example
         * ```ts
         * const transcriptionSession =
         *   await client.beta.realtime.transcriptionSessions.create();
         * ```
         */
        create(body, options) {
            return this._client.post('/realtime/transcription_sessions', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Realtime extends APIResource {
        constructor() {
            super(...arguments);
            this.sessions = new Sessions(this._client);
            this.transcriptionSessions = new TranscriptionSessions(this._client);
        }
    }
    Realtime.Sessions = Sessions;
    Realtime.TranscriptionSessions = TranscriptionSessions;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    /**
     * @deprecated The Assistants API is deprecated in favor of the Responses API
     */
    class Messages extends APIResource {
        /**
         * Create a message.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        create(threadId, body, options) {
            return this._client.post(`/threads/${threadId}/messages`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieve a message.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        retrieve(threadId, messageId, options) {
            return this._client.get(`/threads/${threadId}/messages/${messageId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Modifies a message.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        update(threadId, messageId, body, options) {
            return this._client.post(`/threads/${threadId}/messages/${messageId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(threadId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(threadId, {}, query);
            }
            return this._client.getAPIList(`/threads/${threadId}/messages`, MessagesPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Deletes a message.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        del(threadId, messageId, options) {
            return this._client.delete(`/threads/${threadId}/messages/${messageId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }
    class MessagesPage extends CursorPage {
    }
    Messages.MessagesPage = MessagesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    /**
     * @deprecated The Assistants API is deprecated in favor of the Responses API
     */
    class Steps extends APIResource {
        retrieve(threadId, runId, stepId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.retrieve(threadId, runId, stepId, {}, query);
            }
            return this._client.get(`/threads/${threadId}/runs/${runId}/steps/${stepId}`, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(threadId, runId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(threadId, runId, {}, query);
            }
            return this._client.getAPIList(`/threads/${threadId}/runs/${runId}/steps`, RunStepsPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }
    class RunStepsPage extends CursorPage {
    }
    Steps.RunStepsPage = RunStepsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    /**
     * @deprecated The Assistants API is deprecated in favor of the Responses API
     */
    let Runs$1 = class Runs extends APIResource {
        constructor() {
            super(...arguments);
            this.steps = new Steps(this._client);
        }
        create(threadId, params, options) {
            const { include, ...body } = params;
            return this._client.post(`/threads/${threadId}/runs`, {
                query: { include },
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
                stream: params.stream ?? false,
            });
        }
        /**
         * Retrieves a run.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        retrieve(threadId, runId, options) {
            return this._client.get(`/threads/${threadId}/runs/${runId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Modifies a run.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        update(threadId, runId, body, options) {
            return this._client.post(`/threads/${threadId}/runs/${runId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(threadId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(threadId, {}, query);
            }
            return this._client.getAPIList(`/threads/${threadId}/runs`, RunsPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Cancels a run that is `in_progress`.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        cancel(threadId, runId, options) {
            return this._client.post(`/threads/${threadId}/runs/${runId}/cancel`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * A helper to create a run an poll for a terminal state. More information on Run
         * lifecycles can be found here:
         * https://platform.openai.com/docs/assistants/how-it-works/runs-and-run-steps
         */
        async createAndPoll(threadId, body, options) {
            const run = await this.create(threadId, body, options);
            return await this.poll(threadId, run.id, options);
        }
        /**
         * Create a Run stream
         *
         * @deprecated use `stream` instead
         */
        createAndStream(threadId, body, options) {
            return AssistantStream.createAssistantStream(threadId, this._client.beta.threads.runs, body, options);
        }
        /**
         * A helper to poll a run status until it reaches a terminal state. More
         * information on Run lifecycles can be found here:
         * https://platform.openai.com/docs/assistants/how-it-works/runs-and-run-steps
         */
        async poll(threadId, runId, options) {
            const headers = { ...options?.headers, 'X-Stainless-Poll-Helper': 'true' };
            if (options?.pollIntervalMs) {
                headers['X-Stainless-Custom-Poll-Interval'] = options.pollIntervalMs.toString();
            }
            while (true) {
                const { data: run, response } = await this.retrieve(threadId, runId, {
                    ...options,
                    headers: { ...options?.headers, ...headers },
                }).withResponse();
                switch (run.status) {
                    //If we are in any sort of intermediate state we poll
                    case 'queued':
                    case 'in_progress':
                    case 'cancelling':
                        let sleepInterval = 5000;
                        if (options?.pollIntervalMs) {
                            sleepInterval = options.pollIntervalMs;
                        }
                        else {
                            const headerInterval = response.headers.get('openai-poll-after-ms');
                            if (headerInterval) {
                                const headerIntervalMs = parseInt(headerInterval);
                                if (!isNaN(headerIntervalMs)) {
                                    sleepInterval = headerIntervalMs;
                                }
                            }
                        }
                        await sleep(sleepInterval);
                        break;
                    //We return the run in any terminal state.
                    case 'requires_action':
                    case 'incomplete':
                    case 'cancelled':
                    case 'completed':
                    case 'failed':
                    case 'expired':
                        return run;
                }
            }
        }
        /**
         * Create a Run stream
         */
        stream(threadId, body, options) {
            return AssistantStream.createAssistantStream(threadId, this._client.beta.threads.runs, body, options);
        }
        submitToolOutputs(threadId, runId, body, options) {
            return this._client.post(`/threads/${threadId}/runs/${runId}/submit_tool_outputs`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
                stream: body.stream ?? false,
            });
        }
        /**
         * A helper to submit a tool output to a run and poll for a terminal run state.
         * More information on Run lifecycles can be found here:
         * https://platform.openai.com/docs/assistants/how-it-works/runs-and-run-steps
         */
        async submitToolOutputsAndPoll(threadId, runId, body, options) {
            const run = await this.submitToolOutputs(threadId, runId, body, options);
            return await this.poll(threadId, run.id, options);
        }
        /**
         * Submit the tool outputs from a previous run and stream the run to a terminal
         * state. More information on Run lifecycles can be found here:
         * https://platform.openai.com/docs/assistants/how-it-works/runs-and-run-steps
         */
        submitToolOutputsStream(threadId, runId, body, options) {
            return AssistantStream.createToolAssistantStream(threadId, runId, this._client.beta.threads.runs, body, options);
        }
    };
    class RunsPage extends CursorPage {
    }
    Runs$1.RunsPage = RunsPage;
    Runs$1.Steps = Steps;
    Runs$1.RunStepsPage = RunStepsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    /**
     * @deprecated The Assistants API is deprecated in favor of the Responses API
     */
    class Threads extends APIResource {
        constructor() {
            super(...arguments);
            this.runs = new Runs$1(this._client);
            this.messages = new Messages(this._client);
        }
        create(body = {}, options) {
            if (isRequestOptions(body)) {
                return this.create({}, body);
            }
            return this._client.post('/threads', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieves a thread.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        retrieve(threadId, options) {
            return this._client.get(`/threads/${threadId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Modifies a thread.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        update(threadId, body, options) {
            return this._client.post(`/threads/${threadId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Delete a thread.
         *
         * @deprecated The Assistants API is deprecated in favor of the Responses API
         */
        del(threadId, options) {
            return this._client.delete(`/threads/${threadId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        createAndRun(body, options) {
            return this._client.post('/threads/runs', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
                stream: body.stream ?? false,
            });
        }
        /**
         * A helper to create a thread, start a run and then poll for a terminal state.
         * More information on Run lifecycles can be found here:
         * https://platform.openai.com/docs/assistants/how-it-works/runs-and-run-steps
         */
        async createAndRunPoll(body, options) {
            const run = await this.createAndRun(body, options);
            return await this.runs.poll(run.thread_id, run.id, options);
        }
        /**
         * Create a thread and stream the run back
         */
        createAndRunStream(body, options) {
            return AssistantStream.createThreadAssistantStream(body, this._client.beta.threads, options);
        }
    }
    Threads.Runs = Runs$1;
    Threads.RunsPage = RunsPage;
    Threads.Messages = Messages;
    Threads.MessagesPage = MessagesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Beta extends APIResource {
        constructor() {
            super(...arguments);
            this.realtime = new Realtime(this._client);
            this.chat = new Chat(this._client);
            this.assistants = new Assistants(this._client);
            this.threads = new Threads(this._client);
        }
    }
    Beta.Realtime = Realtime;
    Beta.Assistants = Assistants;
    Beta.AssistantsPage = AssistantsPage;
    Beta.Threads = Threads;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Completions extends APIResource {
        create(body, options) {
            return this._client.post('/completions', { body, ...options, stream: body.stream ?? false });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Content extends APIResource {
        /**
         * Retrieve Container File Content
         */
        retrieve(containerId, fileId, options) {
            return this._client.get(`/containers/${containerId}/files/${fileId}/content`, {
                ...options,
                headers: { Accept: 'application/binary', ...options?.headers },
                __binaryResponse: true,
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Files$2 = class Files extends APIResource {
        constructor() {
            super(...arguments);
            this.content = new Content(this._client);
        }
        /**
         * Create a Container File
         *
         * You can send either a multipart/form-data request with the raw file content, or
         * a JSON request with a file ID.
         */
        create(containerId, body, options) {
            return this._client.post(`/containers/${containerId}/files`, multipartFormRequestOptions({ body, ...options }));
        }
        /**
         * Retrieve Container File
         */
        retrieve(containerId, fileId, options) {
            return this._client.get(`/containers/${containerId}/files/${fileId}`, options);
        }
        list(containerId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(containerId, {}, query);
            }
            return this._client.getAPIList(`/containers/${containerId}/files`, FileListResponsesPage, {
                query,
                ...options,
            });
        }
        /**
         * Delete Container File
         */
        del(containerId, fileId, options) {
            return this._client.delete(`/containers/${containerId}/files/${fileId}`, {
                ...options,
                headers: { Accept: '*/*', ...options?.headers },
            });
        }
    };
    class FileListResponsesPage extends CursorPage {
    }
    Files$2.FileListResponsesPage = FileListResponsesPage;
    Files$2.Content = Content;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Containers extends APIResource {
        constructor() {
            super(...arguments);
            this.files = new Files$2(this._client);
        }
        /**
         * Create Container
         */
        create(body, options) {
            return this._client.post('/containers', { body, ...options });
        }
        /**
         * Retrieve Container
         */
        retrieve(containerId, options) {
            return this._client.get(`/containers/${containerId}`, options);
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/containers', ContainerListResponsesPage, { query, ...options });
        }
        /**
         * Delete Container
         */
        del(containerId, options) {
            return this._client.delete(`/containers/${containerId}`, {
                ...options,
                headers: { Accept: '*/*', ...options?.headers },
            });
        }
    }
    class ContainerListResponsesPage extends CursorPage {
    }
    Containers.ContainerListResponsesPage = ContainerListResponsesPage;
    Containers.Files = Files$2;
    Containers.FileListResponsesPage = FileListResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Embeddings extends APIResource {
        /**
         * Creates an embedding vector representing the input text.
         *
         * @example
         * ```ts
         * const createEmbeddingResponse =
         *   await client.embeddings.create({
         *     input: 'The quick brown fox jumped over the lazy dog',
         *     model: 'text-embedding-3-small',
         *   });
         * ```
         */
        create(body, options) {
            const hasUserProvidedEncodingFormat = !!body.encoding_format;
            // No encoding_format specified, defaulting to base64 for performance reasons
            // See https://github.com/openai/openai-node/pull/1312
            let encoding_format = hasUserProvidedEncodingFormat ? body.encoding_format : 'base64';
            if (hasUserProvidedEncodingFormat) {
                debug('Request', 'User defined encoding_format:', body.encoding_format);
            }
            const response = this._client.post('/embeddings', {
                body: {
                    ...body,
                    encoding_format: encoding_format,
                },
                ...options,
            });
            // if the user specified an encoding_format, return the response as-is
            if (hasUserProvidedEncodingFormat) {
                return response;
            }
            // in this stage, we are sure the user did not specify an encoding_format
            // and we defaulted to base64 for performance reasons
            // we are sure then that the response is base64 encoded, let's decode it
            // the returned result will be a float32 array since this is OpenAI API's default encoding
            debug('response', 'Decoding base64 embeddings to float32 array');
            return response._thenUnwrap((response) => {
                if (response && response.data) {
                    response.data.forEach((embeddingBase64Obj) => {
                        const embeddingBase64Str = embeddingBase64Obj.embedding;
                        embeddingBase64Obj.embedding = toFloat32Array(embeddingBase64Str);
                    });
                }
                return response;
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class OutputItems extends APIResource {
        /**
         * Get an evaluation run output item by ID.
         */
        retrieve(evalId, runId, outputItemId, options) {
            return this._client.get(`/evals/${evalId}/runs/${runId}/output_items/${outputItemId}`, options);
        }
        list(evalId, runId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(evalId, runId, {}, query);
            }
            return this._client.getAPIList(`/evals/${evalId}/runs/${runId}/output_items`, OutputItemListResponsesPage, { query, ...options });
        }
    }
    class OutputItemListResponsesPage extends CursorPage {
    }
    OutputItems.OutputItemListResponsesPage = OutputItemListResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Runs extends APIResource {
        constructor() {
            super(...arguments);
            this.outputItems = new OutputItems(this._client);
        }
        /**
         * Kicks off a new run for a given evaluation, specifying the data source, and what
         * model configuration to use to test. The datasource will be validated against the
         * schema specified in the config of the evaluation.
         */
        create(evalId, body, options) {
            return this._client.post(`/evals/${evalId}/runs`, { body, ...options });
        }
        /**
         * Get an evaluation run by ID.
         */
        retrieve(evalId, runId, options) {
            return this._client.get(`/evals/${evalId}/runs/${runId}`, options);
        }
        list(evalId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(evalId, {}, query);
            }
            return this._client.getAPIList(`/evals/${evalId}/runs`, RunListResponsesPage, { query, ...options });
        }
        /**
         * Delete an eval run.
         */
        del(evalId, runId, options) {
            return this._client.delete(`/evals/${evalId}/runs/${runId}`, options);
        }
        /**
         * Cancel an ongoing evaluation run.
         */
        cancel(evalId, runId, options) {
            return this._client.post(`/evals/${evalId}/runs/${runId}`, options);
        }
    }
    class RunListResponsesPage extends CursorPage {
    }
    Runs.RunListResponsesPage = RunListResponsesPage;
    Runs.OutputItems = OutputItems;
    Runs.OutputItemListResponsesPage = OutputItemListResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Evals extends APIResource {
        constructor() {
            super(...arguments);
            this.runs = new Runs(this._client);
        }
        /**
         * Create the structure of an evaluation that can be used to test a model's
         * performance. An evaluation is a set of testing criteria and the config for a
         * data source, which dictates the schema of the data used in the evaluation. After
         * creating an evaluation, you can run it on different models and model parameters.
         * We support several types of graders and datasources. For more information, see
         * the [Evals guide](https://platform.openai.com/docs/guides/evals).
         */
        create(body, options) {
            return this._client.post('/evals', { body, ...options });
        }
        /**
         * Get an evaluation by ID.
         */
        retrieve(evalId, options) {
            return this._client.get(`/evals/${evalId}`, options);
        }
        /**
         * Update certain properties of an evaluation.
         */
        update(evalId, body, options) {
            return this._client.post(`/evals/${evalId}`, { body, ...options });
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/evals', EvalListResponsesPage, { query, ...options });
        }
        /**
         * Delete an evaluation.
         */
        del(evalId, options) {
            return this._client.delete(`/evals/${evalId}`, options);
        }
    }
    class EvalListResponsesPage extends CursorPage {
    }
    Evals.EvalListResponsesPage = EvalListResponsesPage;
    Evals.Runs = Runs;
    Evals.RunListResponsesPage = RunListResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Files$1 = class Files extends APIResource {
        /**
         * Upload a file that can be used across various endpoints. Individual files can be
         * up to 512 MB, and the size of all files uploaded by one organization can be up
         * to 100 GB.
         *
         * The Assistants API supports files up to 2 million tokens and of specific file
         * types. See the
         * [Assistants Tools guide](https://platform.openai.com/docs/assistants/tools) for
         * details.
         *
         * The Fine-tuning API only supports `.jsonl` files. The input also has certain
         * required formats for fine-tuning
         * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input) or
         * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
         * models.
         *
         * The Batch API only supports `.jsonl` files up to 200 MB in size. The input also
         * has a specific required
         * [format](https://platform.openai.com/docs/api-reference/batch/request-input).
         *
         * Please [contact us](https://help.openai.com/) if you need to increase these
         * storage limits.
         */
        create(body, options) {
            return this._client.post('/files', multipartFormRequestOptions({ body, ...options }));
        }
        /**
         * Returns information about a specific file.
         */
        retrieve(fileId, options) {
            return this._client.get(`/files/${fileId}`, options);
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/files', FileObjectsPage, { query, ...options });
        }
        /**
         * Delete a file.
         */
        del(fileId, options) {
            return this._client.delete(`/files/${fileId}`, options);
        }
        /**
         * Returns the contents of the specified file.
         */
        content(fileId, options) {
            return this._client.get(`/files/${fileId}/content`, {
                ...options,
                headers: { Accept: 'application/binary', ...options?.headers },
                __binaryResponse: true,
            });
        }
        /**
         * Returns the contents of the specified file.
         *
         * @deprecated The `.content()` method should be used instead
         */
        retrieveContent(fileId, options) {
            return this._client.get(`/files/${fileId}/content`, options);
        }
        /**
         * Waits for the given file to be processed, default timeout is 30 mins.
         */
        async waitForProcessing(id, { pollInterval = 5000, maxWait = 30 * 60 * 1000 } = {}) {
            const TERMINAL_STATES = new Set(['processed', 'error', 'deleted']);
            const start = Date.now();
            let file = await this.retrieve(id);
            while (!file.status || !TERMINAL_STATES.has(file.status)) {
                await sleep(pollInterval);
                file = await this.retrieve(id);
                if (Date.now() - start > maxWait) {
                    throw new APIConnectionTimeoutError({
                        message: `Giving up on waiting for file ${id} to finish processing after ${maxWait} milliseconds.`,
                    });
                }
            }
            return file;
        }
    };
    class FileObjectsPage extends CursorPage {
    }
    Files$1.FileObjectsPage = FileObjectsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Methods extends APIResource {
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Graders$1 = class Graders extends APIResource {
        /**
         * Run a grader.
         *
         * @example
         * ```ts
         * const response = await client.fineTuning.alpha.graders.run({
         *   grader: {
         *     input: 'input',
         *     name: 'name',
         *     operation: 'eq',
         *     reference: 'reference',
         *     type: 'string_check',
         *   },
         *   model_sample: 'model_sample',
         *   reference_answer: 'string',
         * });
         * ```
         */
        run(body, options) {
            return this._client.post('/fine_tuning/alpha/graders/run', { body, ...options });
        }
        /**
         * Validate a grader.
         *
         * @example
         * ```ts
         * const response =
         *   await client.fineTuning.alpha.graders.validate({
         *     grader: {
         *       input: 'input',
         *       name: 'name',
         *       operation: 'eq',
         *       reference: 'reference',
         *       type: 'string_check',
         *     },
         *   });
         * ```
         */
        validate(body, options) {
            return this._client.post('/fine_tuning/alpha/graders/validate', { body, ...options });
        }
    };

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Alpha extends APIResource {
        constructor() {
            super(...arguments);
            this.graders = new Graders$1(this._client);
        }
    }
    Alpha.Graders = Graders$1;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Permissions extends APIResource {
        /**
         * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
         *
         * This enables organization owners to share fine-tuned models with other projects
         * in their organization.
         *
         * @example
         * ```ts
         * // Automatically fetches more pages as needed.
         * for await (const permissionCreateResponse of client.fineTuning.checkpoints.permissions.create(
         *   'ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd',
         *   { project_ids: ['string'] },
         * )) {
         *   // ...
         * }
         * ```
         */
        create(fineTunedModelCheckpoint, body, options) {
            return this._client.getAPIList(`/fine_tuning/checkpoints/${fineTunedModelCheckpoint}/permissions`, PermissionCreateResponsesPage, { body, method: 'post', ...options });
        }
        retrieve(fineTunedModelCheckpoint, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.retrieve(fineTunedModelCheckpoint, {}, query);
            }
            return this._client.get(`/fine_tuning/checkpoints/${fineTunedModelCheckpoint}/permissions`, {
                query,
                ...options,
            });
        }
        /**
         * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
         *
         * Organization owners can use this endpoint to delete a permission for a
         * fine-tuned model checkpoint.
         *
         * @example
         * ```ts
         * const permission =
         *   await client.fineTuning.checkpoints.permissions.del(
         *     'ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd',
         *     'cp_zc4Q7MP6XxulcVzj4MZdwsAB',
         *   );
         * ```
         */
        del(fineTunedModelCheckpoint, permissionId, options) {
            return this._client.delete(`/fine_tuning/checkpoints/${fineTunedModelCheckpoint}/permissions/${permissionId}`, options);
        }
    }
    /**
     * Note: no pagination actually occurs yet, this is for forwards-compatibility.
     */
    class PermissionCreateResponsesPage extends Page {
    }
    Permissions.PermissionCreateResponsesPage = PermissionCreateResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    let Checkpoints$1 = class Checkpoints extends APIResource {
        constructor() {
            super(...arguments);
            this.permissions = new Permissions(this._client);
        }
    };
    Checkpoints$1.Permissions = Permissions;
    Checkpoints$1.PermissionCreateResponsesPage = PermissionCreateResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Checkpoints extends APIResource {
        list(fineTuningJobId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(fineTuningJobId, {}, query);
            }
            return this._client.getAPIList(`/fine_tuning/jobs/${fineTuningJobId}/checkpoints`, FineTuningJobCheckpointsPage, { query, ...options });
        }
    }
    class FineTuningJobCheckpointsPage extends CursorPage {
    }
    Checkpoints.FineTuningJobCheckpointsPage = FineTuningJobCheckpointsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Jobs extends APIResource {
        constructor() {
            super(...arguments);
            this.checkpoints = new Checkpoints(this._client);
        }
        /**
         * Creates a fine-tuning job which begins the process of creating a new model from
         * a given dataset.
         *
         * Response includes details of the enqueued job including job status and the name
         * of the fine-tuned models once complete.
         *
         * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
         *
         * @example
         * ```ts
         * const fineTuningJob = await client.fineTuning.jobs.create({
         *   model: 'gpt-4o-mini',
         *   training_file: 'file-abc123',
         * });
         * ```
         */
        create(body, options) {
            return this._client.post('/fine_tuning/jobs', { body, ...options });
        }
        /**
         * Get info about a fine-tuning job.
         *
         * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
         *
         * @example
         * ```ts
         * const fineTuningJob = await client.fineTuning.jobs.retrieve(
         *   'ft-AF1WoRqd3aJAHsqc9NY7iL8F',
         * );
         * ```
         */
        retrieve(fineTuningJobId, options) {
            return this._client.get(`/fine_tuning/jobs/${fineTuningJobId}`, options);
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/fine_tuning/jobs', FineTuningJobsPage, { query, ...options });
        }
        /**
         * Immediately cancel a fine-tune job.
         *
         * @example
         * ```ts
         * const fineTuningJob = await client.fineTuning.jobs.cancel(
         *   'ft-AF1WoRqd3aJAHsqc9NY7iL8F',
         * );
         * ```
         */
        cancel(fineTuningJobId, options) {
            return this._client.post(`/fine_tuning/jobs/${fineTuningJobId}/cancel`, options);
        }
        listEvents(fineTuningJobId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.listEvents(fineTuningJobId, {}, query);
            }
            return this._client.getAPIList(`/fine_tuning/jobs/${fineTuningJobId}/events`, FineTuningJobEventsPage, {
                query,
                ...options,
            });
        }
        /**
         * Pause a fine-tune job.
         *
         * @example
         * ```ts
         * const fineTuningJob = await client.fineTuning.jobs.pause(
         *   'ft-AF1WoRqd3aJAHsqc9NY7iL8F',
         * );
         * ```
         */
        pause(fineTuningJobId, options) {
            return this._client.post(`/fine_tuning/jobs/${fineTuningJobId}/pause`, options);
        }
        /**
         * Resume a fine-tune job.
         *
         * @example
         * ```ts
         * const fineTuningJob = await client.fineTuning.jobs.resume(
         *   'ft-AF1WoRqd3aJAHsqc9NY7iL8F',
         * );
         * ```
         */
        resume(fineTuningJobId, options) {
            return this._client.post(`/fine_tuning/jobs/${fineTuningJobId}/resume`, options);
        }
    }
    class FineTuningJobsPage extends CursorPage {
    }
    class FineTuningJobEventsPage extends CursorPage {
    }
    Jobs.FineTuningJobsPage = FineTuningJobsPage;
    Jobs.FineTuningJobEventsPage = FineTuningJobEventsPage;
    Jobs.Checkpoints = Checkpoints;
    Jobs.FineTuningJobCheckpointsPage = FineTuningJobCheckpointsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class FineTuning extends APIResource {
        constructor() {
            super(...arguments);
            this.methods = new Methods(this._client);
            this.jobs = new Jobs(this._client);
            this.checkpoints = new Checkpoints$1(this._client);
            this.alpha = new Alpha(this._client);
        }
    }
    FineTuning.Methods = Methods;
    FineTuning.Jobs = Jobs;
    FineTuning.FineTuningJobsPage = FineTuningJobsPage;
    FineTuning.FineTuningJobEventsPage = FineTuningJobEventsPage;
    FineTuning.Checkpoints = Checkpoints$1;
    FineTuning.Alpha = Alpha;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class GraderModels extends APIResource {
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Graders extends APIResource {
        constructor() {
            super(...arguments);
            this.graderModels = new GraderModels(this._client);
        }
    }
    Graders.GraderModels = GraderModels;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Images extends APIResource {
        /**
         * Creates a variation of a given image. This endpoint only supports `dall-e-2`.
         *
         * @example
         * ```ts
         * const imagesResponse = await client.images.createVariation({
         *   image: fs.createReadStream('otter.png'),
         * });
         * ```
         */
        createVariation(body, options) {
            return this._client.post('/images/variations', multipartFormRequestOptions({ body, ...options }));
        }
        /**
         * Creates an edited or extended image given one or more source images and a
         * prompt. This endpoint only supports `gpt-image-1` and `dall-e-2`.
         *
         * @example
         * ```ts
         * const imagesResponse = await client.images.edit({
         *   image: fs.createReadStream('path/to/file'),
         *   prompt: 'A cute baby sea otter wearing a beret',
         * });
         * ```
         */
        edit(body, options) {
            return this._client.post('/images/edits', multipartFormRequestOptions({ body, ...options }));
        }
        /**
         * Creates an image given a prompt.
         * [Learn more](https://platform.openai.com/docs/guides/images).
         *
         * @example
         * ```ts
         * const imagesResponse = await client.images.generate({
         *   prompt: 'A cute baby sea otter',
         * });
         * ```
         */
        generate(body, options) {
            return this._client.post('/images/generations', { body, ...options });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Models extends APIResource {
        /**
         * Retrieves a model instance, providing basic information about the model such as
         * the owner and permissioning.
         */
        retrieve(model, options) {
            return this._client.get(`/models/${model}`, options);
        }
        /**
         * Lists the currently available models, and provides basic information about each
         * one such as the owner and availability.
         */
        list(options) {
            return this._client.getAPIList('/models', ModelsPage, options);
        }
        /**
         * Delete a fine-tuned model. You must have the Owner role in your organization to
         * delete a model.
         */
        del(model, options) {
            return this._client.delete(`/models/${model}`, options);
        }
    }
    /**
     * Note: no pagination actually occurs yet, this is for forwards-compatibility.
     */
    class ModelsPage extends Page {
    }
    Models.ModelsPage = ModelsPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Moderations extends APIResource {
        /**
         * Classifies if text and/or image inputs are potentially harmful. Learn more in
         * the [moderation guide](https://platform.openai.com/docs/guides/moderation).
         */
        create(body, options) {
            return this._client.post('/moderations', { body, ...options });
        }
    }

    function maybeParseResponse(response, params) {
        if (!params || !hasAutoParseableInput(params)) {
            return {
                ...response,
                output_parsed: null,
                output: response.output.map((item) => {
                    if (item.type === 'function_call') {
                        return {
                            ...item,
                            parsed_arguments: null,
                        };
                    }
                    if (item.type === 'message') {
                        return {
                            ...item,
                            content: item.content.map((content) => ({
                                ...content,
                                parsed: null,
                            })),
                        };
                    }
                    else {
                        return item;
                    }
                }),
            };
        }
        return parseResponse(response, params);
    }
    function parseResponse(response, params) {
        const output = response.output.map((item) => {
            if (item.type === 'function_call') {
                return {
                    ...item,
                    parsed_arguments: parseToolCall(params, item),
                };
            }
            if (item.type === 'message') {
                const content = item.content.map((content) => {
                    if (content.type === 'output_text') {
                        return {
                            ...content,
                            parsed: parseTextFormat(params, content.text),
                        };
                    }
                    return content;
                });
                return {
                    ...item,
                    content,
                };
            }
            return item;
        });
        const parsed = Object.assign({}, response, { output });
        if (!Object.getOwnPropertyDescriptor(response, 'output_text')) {
            addOutputText(parsed);
        }
        Object.defineProperty(parsed, 'output_parsed', {
            enumerable: true,
            get() {
                for (const output of parsed.output) {
                    if (output.type !== 'message') {
                        continue;
                    }
                    for (const content of output.content) {
                        if (content.type === 'output_text' && content.parsed !== null) {
                            return content.parsed;
                        }
                    }
                }
                return null;
            },
        });
        return parsed;
    }
    function parseTextFormat(params, content) {
        if (params.text?.format?.type !== 'json_schema') {
            return null;
        }
        if ('$parseRaw' in params.text?.format) {
            const text_format = params.text?.format;
            return text_format.$parseRaw(content);
        }
        return JSON.parse(content);
    }
    function hasAutoParseableInput(params) {
        if (isAutoParsableResponseFormat(params.text?.format)) {
            return true;
        }
        return false;
    }
    function isAutoParsableTool(tool) {
        return tool?.['$brand'] === 'auto-parseable-tool';
    }
    function getInputToolByName(input_tools, name) {
        return input_tools.find((tool) => tool.type === 'function' && tool.name === name);
    }
    function parseToolCall(params, toolCall) {
        const inputTool = getInputToolByName(params.tools ?? [], toolCall.name);
        return {
            ...toolCall,
            ...toolCall,
            parsed_arguments: isAutoParsableTool(inputTool) ? inputTool.$parseRaw(toolCall.arguments)
                : inputTool?.strict ? JSON.parse(toolCall.arguments)
                    : null,
        };
    }
    function addOutputText(rsp) {
        const texts = [];
        for (const output of rsp.output) {
            if (output.type !== 'message') {
                continue;
            }
            for (const content of output.content) {
                if (content.type === 'output_text') {
                    texts.push(content.text);
                }
            }
        }
        rsp.output_text = texts.join('');
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class InputItems extends APIResource {
        list(responseId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(responseId, {}, query);
            }
            return this._client.getAPIList(`/responses/${responseId}/input_items`, ResponseItemsPage, {
                query,
                ...options,
            });
        }
    }

    var __classPrivateFieldSet = (window && window.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
        if (kind === "m") throw new TypeError("Private method is not writable");
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
        return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
    };
    var __classPrivateFieldGet = (window && window.__classPrivateFieldGet) || function (receiver, state, kind, f) {
        if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
        if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
        return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
    };
    var _ResponseStream_instances, _ResponseStream_params, _ResponseStream_currentResponseSnapshot, _ResponseStream_finalResponse, _ResponseStream_beginRequest, _ResponseStream_addEvent, _ResponseStream_endRequest, _ResponseStream_accumulateResponse;
    class ResponseStream extends EventStream {
        constructor(params) {
            super();
            _ResponseStream_instances.add(this);
            _ResponseStream_params.set(this, void 0);
            _ResponseStream_currentResponseSnapshot.set(this, void 0);
            _ResponseStream_finalResponse.set(this, void 0);
            __classPrivateFieldSet(this, _ResponseStream_params, params, "f");
        }
        static createResponse(client, params, options) {
            const runner = new ResponseStream(params);
            runner._run(() => runner._createOrRetrieveResponse(client, params, {
                ...options,
                headers: { ...options?.headers, 'X-Stainless-Helper-Method': 'stream' },
            }));
            return runner;
        }
        async _createOrRetrieveResponse(client, params, options) {
            const signal = options?.signal;
            if (signal) {
                if (signal.aborted)
                    this.controller.abort();
                signal.addEventListener('abort', () => this.controller.abort());
            }
            __classPrivateFieldGet(this, _ResponseStream_instances, "m", _ResponseStream_beginRequest).call(this);
            let stream;
            let starting_after = null;
            if ('response_id' in params) {
                stream = await client.responses.retrieve(params.response_id, { stream: true }, { ...options, signal: this.controller.signal, stream: true });
                starting_after = params.starting_after ?? null;
            }
            else {
                stream = await client.responses.create({ ...params, stream: true }, { ...options, signal: this.controller.signal });
            }
            this._connected();
            for await (const event of stream) {
                __classPrivateFieldGet(this, _ResponseStream_instances, "m", _ResponseStream_addEvent).call(this, event, starting_after);
            }
            if (stream.controller.signal?.aborted) {
                throw new APIUserAbortError();
            }
            return __classPrivateFieldGet(this, _ResponseStream_instances, "m", _ResponseStream_endRequest).call(this);
        }
        [(_ResponseStream_params = new WeakMap(), _ResponseStream_currentResponseSnapshot = new WeakMap(), _ResponseStream_finalResponse = new WeakMap(), _ResponseStream_instances = new WeakSet(), _ResponseStream_beginRequest = function _ResponseStream_beginRequest() {
            if (this.ended)
                return;
            __classPrivateFieldSet(this, _ResponseStream_currentResponseSnapshot, undefined, "f");
        }, _ResponseStream_addEvent = function _ResponseStream_addEvent(event, starting_after) {
            if (this.ended)
                return;
            const maybeEmit = (name, event) => {
                if (starting_after == null || event.sequence_number > starting_after) {
                    this._emit(name, event);
                }
            };
            const response = __classPrivateFieldGet(this, _ResponseStream_instances, "m", _ResponseStream_accumulateResponse).call(this, event);
            maybeEmit('event', event);
            switch (event.type) {
                case 'response.output_text.delta': {
                    const output = response.output[event.output_index];
                    if (!output) {
                        throw new OpenAIError(`missing output at index ${event.output_index}`);
                    }
                    if (output.type === 'message') {
                        const content = output.content[event.content_index];
                        if (!content) {
                            throw new OpenAIError(`missing content at index ${event.content_index}`);
                        }
                        if (content.type !== 'output_text') {
                            throw new OpenAIError(`expected content to be 'output_text', got ${content.type}`);
                        }
                        maybeEmit('response.output_text.delta', {
                            ...event,
                            snapshot: content.text,
                        });
                    }
                    break;
                }
                case 'response.function_call_arguments.delta': {
                    const output = response.output[event.output_index];
                    if (!output) {
                        throw new OpenAIError(`missing output at index ${event.output_index}`);
                    }
                    if (output.type === 'function_call') {
                        maybeEmit('response.function_call_arguments.delta', {
                            ...event,
                            snapshot: output.arguments,
                        });
                    }
                    break;
                }
                default:
                    maybeEmit(event.type, event);
                    break;
            }
        }, _ResponseStream_endRequest = function _ResponseStream_endRequest() {
            if (this.ended) {
                throw new OpenAIError(`stream has ended, this shouldn't happen`);
            }
            const snapshot = __classPrivateFieldGet(this, _ResponseStream_currentResponseSnapshot, "f");
            if (!snapshot) {
                throw new OpenAIError(`request ended without sending any events`);
            }
            __classPrivateFieldSet(this, _ResponseStream_currentResponseSnapshot, undefined, "f");
            const parsedResponse = finalizeResponse(snapshot, __classPrivateFieldGet(this, _ResponseStream_params, "f"));
            __classPrivateFieldSet(this, _ResponseStream_finalResponse, parsedResponse, "f");
            return parsedResponse;
        }, _ResponseStream_accumulateResponse = function _ResponseStream_accumulateResponse(event) {
            let snapshot = __classPrivateFieldGet(this, _ResponseStream_currentResponseSnapshot, "f");
            if (!snapshot) {
                if (event.type !== 'response.created') {
                    throw new OpenAIError(`When snapshot hasn't been set yet, expected 'response.created' event, got ${event.type}`);
                }
                snapshot = __classPrivateFieldSet(this, _ResponseStream_currentResponseSnapshot, event.response, "f");
                return snapshot;
            }
            switch (event.type) {
                case 'response.output_item.added': {
                    snapshot.output.push(event.item);
                    break;
                }
                case 'response.content_part.added': {
                    const output = snapshot.output[event.output_index];
                    if (!output) {
                        throw new OpenAIError(`missing output at index ${event.output_index}`);
                    }
                    if (output.type === 'message') {
                        output.content.push(event.part);
                    }
                    break;
                }
                case 'response.output_text.delta': {
                    const output = snapshot.output[event.output_index];
                    if (!output) {
                        throw new OpenAIError(`missing output at index ${event.output_index}`);
                    }
                    if (output.type === 'message') {
                        const content = output.content[event.content_index];
                        if (!content) {
                            throw new OpenAIError(`missing content at index ${event.content_index}`);
                        }
                        if (content.type !== 'output_text') {
                            throw new OpenAIError(`expected content to be 'output_text', got ${content.type}`);
                        }
                        content.text += event.delta;
                    }
                    break;
                }
                case 'response.function_call_arguments.delta': {
                    const output = snapshot.output[event.output_index];
                    if (!output) {
                        throw new OpenAIError(`missing output at index ${event.output_index}`);
                    }
                    if (output.type === 'function_call') {
                        output.arguments += event.delta;
                    }
                    break;
                }
                case 'response.completed': {
                    __classPrivateFieldSet(this, _ResponseStream_currentResponseSnapshot, event.response, "f");
                    break;
                }
            }
            return snapshot;
        }, Symbol.asyncIterator)]() {
            const pushQueue = [];
            const readQueue = [];
            let done = false;
            this.on('event', (event) => {
                const reader = readQueue.shift();
                if (reader) {
                    reader.resolve(event);
                }
                else {
                    pushQueue.push(event);
                }
            });
            this.on('end', () => {
                done = true;
                for (const reader of readQueue) {
                    reader.resolve(undefined);
                }
                readQueue.length = 0;
            });
            this.on('abort', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            this.on('error', (err) => {
                done = true;
                for (const reader of readQueue) {
                    reader.reject(err);
                }
                readQueue.length = 0;
            });
            return {
                next: async () => {
                    if (!pushQueue.length) {
                        if (done) {
                            return { value: undefined, done: true };
                        }
                        return new Promise((resolve, reject) => readQueue.push({ resolve, reject })).then((event) => (event ? { value: event, done: false } : { value: undefined, done: true }));
                    }
                    const event = pushQueue.shift();
                    return { value: event, done: false };
                },
                return: async () => {
                    this.abort();
                    return { value: undefined, done: true };
                },
            };
        }
        /**
         * @returns a promise that resolves with the final Response, or rejects
         * if an error occurred or the stream ended prematurely without producing a REsponse.
         */
        async finalResponse() {
            await this.done();
            const response = __classPrivateFieldGet(this, _ResponseStream_finalResponse, "f");
            if (!response)
                throw new OpenAIError('stream ended without producing a ChatCompletion');
            return response;
        }
    }
    function finalizeResponse(snapshot, params) {
        return maybeParseResponse(snapshot, params);
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Responses extends APIResource {
        constructor() {
            super(...arguments);
            this.inputItems = new InputItems(this._client);
        }
        create(body, options) {
            return this._client.post('/responses', { body, ...options, stream: body.stream ?? false })._thenUnwrap((rsp) => {
                if ('object' in rsp && rsp.object === 'response') {
                    addOutputText(rsp);
                }
                return rsp;
            });
        }
        retrieve(responseId, query = {}, options) {
            return this._client.get(`/responses/${responseId}`, {
                query,
                ...options,
                stream: query?.stream ?? false,
            });
        }
        /**
         * Deletes a model response with the given ID.
         *
         * @example
         * ```ts
         * await client.responses.del(
         *   'resp_677efb5139a88190b512bc3fef8e535d',
         * );
         * ```
         */
        del(responseId, options) {
            return this._client.delete(`/responses/${responseId}`, {
                ...options,
                headers: { Accept: '*/*', ...options?.headers },
            });
        }
        parse(body, options) {
            return this._client.responses
                .create(body, options)
                ._thenUnwrap((response) => parseResponse(response, body));
        }
        /**
         * Creates a model response stream
         */
        stream(body, options) {
            return ResponseStream.createResponse(this._client, body, options);
        }
        /**
         * Cancels a model response with the given ID. Only responses created with the
         * `background` parameter set to `true` can be cancelled.
         * [Learn more](https://platform.openai.com/docs/guides/background).
         *
         * @example
         * ```ts
         * await client.responses.cancel(
         *   'resp_677efb5139a88190b512bc3fef8e535d',
         * );
         * ```
         */
        cancel(responseId, options) {
            return this._client.post(`/responses/${responseId}/cancel`, {
                ...options,
                headers: { Accept: '*/*', ...options?.headers },
            });
        }
    }
    class ResponseItemsPage extends CursorPage {
    }
    Responses.InputItems = InputItems;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Parts extends APIResource {
        /**
         * Adds a
         * [Part](https://platform.openai.com/docs/api-reference/uploads/part-object) to an
         * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object.
         * A Part represents a chunk of bytes from the file you are trying to upload.
         *
         * Each Part can be at most 64 MB, and you can add Parts until you hit the Upload
         * maximum of 8 GB.
         *
         * It is possible to add multiple Parts in parallel. You can decide the intended
         * order of the Parts when you
         * [complete the Upload](https://platform.openai.com/docs/api-reference/uploads/complete).
         */
        create(uploadId, body, options) {
            return this._client.post(`/uploads/${uploadId}/parts`, multipartFormRequestOptions({ body, ...options }));
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Uploads extends APIResource {
        constructor() {
            super(...arguments);
            this.parts = new Parts(this._client);
        }
        /**
         * Creates an intermediate
         * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object
         * that you can add
         * [Parts](https://platform.openai.com/docs/api-reference/uploads/part-object) to.
         * Currently, an Upload can accept at most 8 GB in total and expires after an hour
         * after you create it.
         *
         * Once you complete the Upload, we will create a
         * [File](https://platform.openai.com/docs/api-reference/files/object) object that
         * contains all the parts you uploaded. This File is usable in the rest of our
         * platform as a regular File object.
         *
         * For certain `purpose` values, the correct `mime_type` must be specified. Please
         * refer to documentation for the
         * [supported MIME types for your use case](https://platform.openai.com/docs/assistants/tools/file-search#supported-files).
         *
         * For guidance on the proper filename extensions for each purpose, please follow
         * the documentation on
         * [creating a File](https://platform.openai.com/docs/api-reference/files/create).
         */
        create(body, options) {
            return this._client.post('/uploads', { body, ...options });
        }
        /**
         * Cancels the Upload. No Parts may be added after an Upload is cancelled.
         */
        cancel(uploadId, options) {
            return this._client.post(`/uploads/${uploadId}/cancel`, options);
        }
        /**
         * Completes the
         * [Upload](https://platform.openai.com/docs/api-reference/uploads/object).
         *
         * Within the returned Upload object, there is a nested
         * [File](https://platform.openai.com/docs/api-reference/files/object) object that
         * is ready to use in the rest of the platform.
         *
         * You can specify the order of the Parts by passing in an ordered list of the Part
         * IDs.
         *
         * The number of bytes uploaded upon completion must match the number of bytes
         * initially specified when creating the Upload object. No Parts may be added after
         * an Upload is completed.
         */
        complete(uploadId, body, options) {
            return this._client.post(`/uploads/${uploadId}/complete`, { body, ...options });
        }
    }
    Uploads.Parts = Parts;

    /**
     * Like `Promise.allSettled()` but throws an error if any promises are rejected.
     */
    const allSettledWithThrow = async (promises) => {
        const results = await Promise.allSettled(promises);
        const rejected = results.filter((result) => result.status === 'rejected');
        if (rejected.length) {
            for (const result of rejected) {
                console.error(result.reason);
            }
            throw new Error(`${rejected.length} promise(s) failed - see the above errors`);
        }
        // Note: TS was complaining about using `.filter().map()` here for some reason
        const values = [];
        for (const result of results) {
            if (result.status === 'fulfilled') {
                values.push(result.value);
            }
        }
        return values;
    };

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class Files extends APIResource {
        /**
         * Create a vector store file by attaching a
         * [File](https://platform.openai.com/docs/api-reference/files) to a
         * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
         */
        create(vectorStoreId, body, options) {
            return this._client.post(`/vector_stores/${vectorStoreId}/files`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieves a vector store file.
         */
        retrieve(vectorStoreId, fileId, options) {
            return this._client.get(`/vector_stores/${vectorStoreId}/files/${fileId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Update attributes on a vector store file.
         */
        update(vectorStoreId, fileId, body, options) {
            return this._client.post(`/vector_stores/${vectorStoreId}/files/${fileId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(vectorStoreId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list(vectorStoreId, {}, query);
            }
            return this._client.getAPIList(`/vector_stores/${vectorStoreId}/files`, VectorStoreFilesPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Delete a vector store file. This will remove the file from the vector store but
         * the file itself will not be deleted. To delete the file, use the
         * [delete file](https://platform.openai.com/docs/api-reference/files/delete)
         * endpoint.
         */
        del(vectorStoreId, fileId, options) {
            return this._client.delete(`/vector_stores/${vectorStoreId}/files/${fileId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Attach a file to the given vector store and wait for it to be processed.
         */
        async createAndPoll(vectorStoreId, body, options) {
            const file = await this.create(vectorStoreId, body, options);
            return await this.poll(vectorStoreId, file.id, options);
        }
        /**
         * Wait for the vector store file to finish processing.
         *
         * Note: this will return even if the file failed to process, you need to check
         * file.last_error and file.status to handle these cases
         */
        async poll(vectorStoreId, fileId, options) {
            const headers = { ...options?.headers, 'X-Stainless-Poll-Helper': 'true' };
            if (options?.pollIntervalMs) {
                headers['X-Stainless-Custom-Poll-Interval'] = options.pollIntervalMs.toString();
            }
            while (true) {
                const fileResponse = await this.retrieve(vectorStoreId, fileId, {
                    ...options,
                    headers,
                }).withResponse();
                const file = fileResponse.data;
                switch (file.status) {
                    case 'in_progress':
                        let sleepInterval = 5000;
                        if (options?.pollIntervalMs) {
                            sleepInterval = options.pollIntervalMs;
                        }
                        else {
                            const headerInterval = fileResponse.response.headers.get('openai-poll-after-ms');
                            if (headerInterval) {
                                const headerIntervalMs = parseInt(headerInterval);
                                if (!isNaN(headerIntervalMs)) {
                                    sleepInterval = headerIntervalMs;
                                }
                            }
                        }
                        await sleep(sleepInterval);
                        break;
                    case 'failed':
                    case 'completed':
                        return file;
                }
            }
        }
        /**
         * Upload a file to the `files` API and then attach it to the given vector store.
         *
         * Note the file will be asynchronously processed (you can use the alternative
         * polling helper method to wait for processing to complete).
         */
        async upload(vectorStoreId, file, options) {
            const fileInfo = await this._client.files.create({ file: file, purpose: 'assistants' }, options);
            return this.create(vectorStoreId, { file_id: fileInfo.id }, options);
        }
        /**
         * Add a file to a vector store and poll until processing is complete.
         */
        async uploadAndPoll(vectorStoreId, file, options) {
            const fileInfo = await this.upload(vectorStoreId, file, options);
            return await this.poll(vectorStoreId, fileInfo.id, options);
        }
        /**
         * Retrieve the parsed contents of a vector store file.
         */
        content(vectorStoreId, fileId, options) {
            return this._client.getAPIList(`/vector_stores/${vectorStoreId}/files/${fileId}/content`, FileContentResponsesPage, { ...options, headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers } });
        }
    }
    class VectorStoreFilesPage extends CursorPage {
    }
    /**
     * Note: no pagination actually occurs yet, this is for forwards-compatibility.
     */
    class FileContentResponsesPage extends Page {
    }
    Files.VectorStoreFilesPage = VectorStoreFilesPage;
    Files.FileContentResponsesPage = FileContentResponsesPage;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class FileBatches extends APIResource {
        /**
         * Create a vector store file batch.
         */
        create(vectorStoreId, body, options) {
            return this._client.post(`/vector_stores/${vectorStoreId}/file_batches`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieves a vector store file batch.
         */
        retrieve(vectorStoreId, batchId, options) {
            return this._client.get(`/vector_stores/${vectorStoreId}/file_batches/${batchId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Cancel a vector store file batch. This attempts to cancel the processing of
         * files in this batch as soon as possible.
         */
        cancel(vectorStoreId, batchId, options) {
            return this._client.post(`/vector_stores/${vectorStoreId}/file_batches/${batchId}/cancel`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Create a vector store batch and poll until all files have been processed.
         */
        async createAndPoll(vectorStoreId, body, options) {
            const batch = await this.create(vectorStoreId, body);
            return await this.poll(vectorStoreId, batch.id, options);
        }
        listFiles(vectorStoreId, batchId, query = {}, options) {
            if (isRequestOptions(query)) {
                return this.listFiles(vectorStoreId, batchId, {}, query);
            }
            return this._client.getAPIList(`/vector_stores/${vectorStoreId}/file_batches/${batchId}/files`, VectorStoreFilesPage, { query, ...options, headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers } });
        }
        /**
         * Wait for the given file batch to be processed.
         *
         * Note: this will return even if one of the files failed to process, you need to
         * check batch.file_counts.failed_count to handle this case.
         */
        async poll(vectorStoreId, batchId, options) {
            const headers = { ...options?.headers, 'X-Stainless-Poll-Helper': 'true' };
            if (options?.pollIntervalMs) {
                headers['X-Stainless-Custom-Poll-Interval'] = options.pollIntervalMs.toString();
            }
            while (true) {
                const { data: batch, response } = await this.retrieve(vectorStoreId, batchId, {
                    ...options,
                    headers,
                }).withResponse();
                switch (batch.status) {
                    case 'in_progress':
                        let sleepInterval = 5000;
                        if (options?.pollIntervalMs) {
                            sleepInterval = options.pollIntervalMs;
                        }
                        else {
                            const headerInterval = response.headers.get('openai-poll-after-ms');
                            if (headerInterval) {
                                const headerIntervalMs = parseInt(headerInterval);
                                if (!isNaN(headerIntervalMs)) {
                                    sleepInterval = headerIntervalMs;
                                }
                            }
                        }
                        await sleep(sleepInterval);
                        break;
                    case 'failed':
                    case 'cancelled':
                    case 'completed':
                        return batch;
                }
            }
        }
        /**
         * Uploads the given files concurrently and then creates a vector store file batch.
         *
         * The concurrency limit is configurable using the `maxConcurrency` parameter.
         */
        async uploadAndPoll(vectorStoreId, { files, fileIds = [] }, options) {
            if (files == null || files.length == 0) {
                throw new Error(`No \`files\` provided to process. If you've already uploaded files you should use \`.createAndPoll()\` instead`);
            }
            const configuredConcurrency = options?.maxConcurrency ?? 5;
            // We cap the number of workers at the number of files (so we don't start any unnecessary workers)
            const concurrencyLimit = Math.min(configuredConcurrency, files.length);
            const client = this._client;
            const fileIterator = files.values();
            const allFileIds = [...fileIds];
            // This code is based on this design. The libraries don't accommodate our environment limits.
            // https://stackoverflow.com/questions/40639432/what-is-the-best-way-to-limit-concurrency-when-using-es6s-promise-all
            async function processFiles(iterator) {
                for (let item of iterator) {
                    const fileObj = await client.files.create({ file: item, purpose: 'assistants' }, options);
                    allFileIds.push(fileObj.id);
                }
            }
            // Start workers to process results
            const workers = Array(concurrencyLimit).fill(fileIterator).map(processFiles);
            // Wait for all processing to complete.
            await allSettledWithThrow(workers);
            return await this.createAndPoll(vectorStoreId, {
                file_ids: allFileIds,
            });
        }
    }

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    class VectorStores extends APIResource {
        constructor() {
            super(...arguments);
            this.files = new Files(this._client);
            this.fileBatches = new FileBatches(this._client);
        }
        /**
         * Create a vector store.
         */
        create(body, options) {
            return this._client.post('/vector_stores', {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Retrieves a vector store.
         */
        retrieve(vectorStoreId, options) {
            return this._client.get(`/vector_stores/${vectorStoreId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Modifies a vector store.
         */
        update(vectorStoreId, body, options) {
            return this._client.post(`/vector_stores/${vectorStoreId}`, {
                body,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        list(query = {}, options) {
            if (isRequestOptions(query)) {
                return this.list({}, query);
            }
            return this._client.getAPIList('/vector_stores', VectorStoresPage, {
                query,
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Delete a vector store.
         */
        del(vectorStoreId, options) {
            return this._client.delete(`/vector_stores/${vectorStoreId}`, {
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
        /**
         * Search a vector store for relevant chunks based on a query and file attributes
         * filter.
         */
        search(vectorStoreId, body, options) {
            return this._client.getAPIList(`/vector_stores/${vectorStoreId}/search`, VectorStoreSearchResponsesPage, {
                body,
                method: 'post',
                ...options,
                headers: { 'OpenAI-Beta': 'assistants=v2', ...options?.headers },
            });
        }
    }
    class VectorStoresPage extends CursorPage {
    }
    /**
     * Note: no pagination actually occurs yet, this is for forwards-compatibility.
     */
    class VectorStoreSearchResponsesPage extends Page {
    }
    VectorStores.VectorStoresPage = VectorStoresPage;
    VectorStores.VectorStoreSearchResponsesPage = VectorStoreSearchResponsesPage;
    VectorStores.Files = Files;
    VectorStores.VectorStoreFilesPage = VectorStoreFilesPage;
    VectorStores.FileContentResponsesPage = FileContentResponsesPage;
    VectorStores.FileBatches = FileBatches;

    // File generated from our OpenAPI spec by Stainless. See CONTRIBUTING.md for details.
    var _a;
    /**
     * API Client for interfacing with the OpenAI API.
     */
    class OpenAI extends APIClient {
        /**
         * API Client for interfacing with the OpenAI API.
         *
         * @param {string | undefined} [opts.apiKey=process.env['OPENAI_API_KEY'] ?? undefined]
         * @param {string | null | undefined} [opts.organization=process.env['OPENAI_ORG_ID'] ?? null]
         * @param {string | null | undefined} [opts.project=process.env['OPENAI_PROJECT_ID'] ?? null]
         * @param {string} [opts.baseURL=process.env['OPENAI_BASE_URL'] ?? https://api.openai.com/v1] - Override the default base URL for the API.
         * @param {number} [opts.timeout=10 minutes] - The maximum amount of time (in milliseconds) the client will wait for a response before timing out.
         * @param {number} [opts.httpAgent] - An HTTP agent used to manage HTTP(s) connections.
         * @param {Core.Fetch} [opts.fetch] - Specify a custom `fetch` function implementation.
         * @param {number} [opts.maxRetries=2] - The maximum number of times the client will retry a request.
         * @param {Core.Headers} opts.defaultHeaders - Default headers to include with every request to the API.
         * @param {Core.DefaultQuery} opts.defaultQuery - Default query parameters to include with every request to the API.
         * @param {boolean} [opts.dangerouslyAllowBrowser=false] - By default, client-side use of this library is not allowed, as it risks exposing your secret API credentials to attackers.
         */
        constructor({ baseURL = readEnv('OPENAI_BASE_URL'), apiKey = readEnv('OPENAI_API_KEY'), organization = readEnv('OPENAI_ORG_ID') ?? null, project = readEnv('OPENAI_PROJECT_ID') ?? null, ...opts } = {}) {
            if (apiKey === undefined) {
                throw new OpenAIError("The OPENAI_API_KEY environment variable is missing or empty; either provide it, or instantiate the OpenAI client with an apiKey option, like new OpenAI({ apiKey: 'My API Key' }).");
            }
            const options = {
                apiKey,
                organization,
                project,
                ...opts,
                baseURL: baseURL || `https://api.openai.com/v1`,
            };
            if (!options.dangerouslyAllowBrowser && isRunningInBrowser()) {
                throw new OpenAIError("It looks like you're running in a browser-like environment.\n\nThis is disabled by default, as it risks exposing your secret API credentials to attackers.\nIf you understand the risks and have appropriate mitigations in place,\nyou can set the `dangerouslyAllowBrowser` option to `true`, e.g.,\n\nnew OpenAI({ apiKey, dangerouslyAllowBrowser: true });\n\nhttps://help.openai.com/en/articles/5112595-best-practices-for-api-key-safety\n");
            }
            super({
                baseURL: options.baseURL,
                timeout: options.timeout ?? 600000 /* 10 minutes */,
                httpAgent: options.httpAgent,
                maxRetries: options.maxRetries,
                fetch: options.fetch,
            });
            this.completions = new Completions(this);
            this.chat = new Chat$1(this);
            this.embeddings = new Embeddings(this);
            this.files = new Files$1(this);
            this.images = new Images(this);
            this.audio = new Audio(this);
            this.moderations = new Moderations(this);
            this.models = new Models(this);
            this.fineTuning = new FineTuning(this);
            this.graders = new Graders(this);
            this.vectorStores = new VectorStores(this);
            this.beta = new Beta(this);
            this.batches = new Batches(this);
            this.uploads = new Uploads(this);
            this.responses = new Responses(this);
            this.evals = new Evals(this);
            this.containers = new Containers(this);
            this._options = options;
            this.apiKey = apiKey;
            this.organization = organization;
            this.project = project;
        }
        defaultQuery() {
            return this._options.defaultQuery;
        }
        defaultHeaders(opts) {
            return {
                ...super.defaultHeaders(opts),
                'OpenAI-Organization': this.organization,
                'OpenAI-Project': this.project,
                ...this._options.defaultHeaders,
            };
        }
        authHeaders(opts) {
            return { Authorization: `Bearer ${this.apiKey}` };
        }
        stringifyQuery(query) {
            return stringify(query, { arrayFormat: 'brackets' });
        }
    }
    _a = OpenAI;
    OpenAI.OpenAI = _a;
    OpenAI.DEFAULT_TIMEOUT = 600000; // 10 minutes
    OpenAI.OpenAIError = OpenAIError;
    OpenAI.APIError = APIError;
    OpenAI.APIConnectionError = APIConnectionError;
    OpenAI.APIConnectionTimeoutError = APIConnectionTimeoutError;
    OpenAI.APIUserAbortError = APIUserAbortError;
    OpenAI.NotFoundError = NotFoundError;
    OpenAI.ConflictError = ConflictError;
    OpenAI.RateLimitError = RateLimitError;
    OpenAI.BadRequestError = BadRequestError;
    OpenAI.AuthenticationError = AuthenticationError;
    OpenAI.InternalServerError = InternalServerError;
    OpenAI.PermissionDeniedError = PermissionDeniedError;
    OpenAI.UnprocessableEntityError = UnprocessableEntityError;
    OpenAI.toFile = toFile;
    OpenAI.fileFromPath = fileFromPath;
    OpenAI.Completions = Completions;
    OpenAI.Chat = Chat$1;
    OpenAI.ChatCompletionsPage = ChatCompletionsPage;
    OpenAI.Embeddings = Embeddings;
    OpenAI.Files = Files$1;
    OpenAI.FileObjectsPage = FileObjectsPage;
    OpenAI.Images = Images;
    OpenAI.Audio = Audio;
    OpenAI.Moderations = Moderations;
    OpenAI.Models = Models;
    OpenAI.ModelsPage = ModelsPage;
    OpenAI.FineTuning = FineTuning;
    OpenAI.Graders = Graders;
    OpenAI.VectorStores = VectorStores;
    OpenAI.VectorStoresPage = VectorStoresPage;
    OpenAI.VectorStoreSearchResponsesPage = VectorStoreSearchResponsesPage;
    OpenAI.Beta = Beta;
    OpenAI.Batches = Batches;
    OpenAI.BatchesPage = BatchesPage;
    OpenAI.Uploads = Uploads;
    OpenAI.Responses = Responses;
    OpenAI.Evals = Evals;
    OpenAI.EvalListResponsesPage = EvalListResponsesPage;
    OpenAI.Containers = Containers;
    OpenAI.ContainerListResponsesPage = ContainerListResponsesPage;
    var OpenAI$1 = OpenAI;

    return OpenAI$1;

})();
