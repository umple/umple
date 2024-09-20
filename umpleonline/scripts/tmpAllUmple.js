/*  Prototype JavaScript framework, version 1.7.1
 *  (c) 2005-2010 Sam Stephenson
 *
 *  Prototype is freely distributable under the terms of an MIT-style license.
 *  For details, see the Prototype web site: http://www.prototypejs.org/
 *
 *--------------------------------------------------------------------------*/

var Prototype = {

  Version: '1.7.1',

  Browser: (function(){
    var ua = navigator.userAgent;
    var isOpera = Object.prototype.toString.call(window.opera) == '[object Opera]';
    return {
      IE:             !!window.attachEvent && !isOpera,
      Opera:          isOpera,
      WebKit:         ua.indexOf('AppleWebKit/') > -1,
      Gecko:          ua.indexOf('Gecko') > -1 && ua.indexOf('KHTML') === -1,
      MobileSafari:   /Apple.*Mobile/.test(ua)
    }
  })(),

  BrowserFeatures: {
    XPath: !!document.evaluate,

    SelectorsAPI: !!document.querySelector,

    ElementExtensions: (function() {
      var constructor = window.Element || window.HTMLElement;
      return !!(constructor && constructor.prototype);
    })(),
    SpecificElementExtensions: (function() {
      if (typeof window.HTMLDivElement !== 'undefined')
        return true;

      var div = document.createElement('div'),
          form = document.createElement('form'),
          isSupported = false;

      if (div['__proto__'] && (div['__proto__'] !== form['__proto__'])) {
        isSupported = true;
      }

      div = form = null;

      return isSupported;
    })()
  },

  ScriptFragment: '<script[^>]*>([\\S\\s]*?)<\/script\\s*>',
  JSONFilter: /^\/\*-secure-([\s\S]*)\*\/\s*$/,

  emptyFunction: function() { },

  K: function(x) { return x }
};

if (Prototype.Browser.MobileSafari)
  Prototype.BrowserFeatures.SpecificElementExtensions = false;
/* Based on Alex Arnell's inheritance implementation. */

var Class = (function() {

  var IS_DONTENUM_BUGGY = (function(){
    for (var p in { toString: 1 }) {
      if (p === 'toString') return false;
    }
    return true;
  })();

  function subclass() {};
  function create() {
    var parent = null, properties = $A(arguments);
    if (Object.isFunction(properties[0]))
      parent = properties.shift();

    function klass() {
      this.initialize.apply(this, arguments);
    }

    Object.extend(klass, Class.Methods);
    klass.superclass = parent;
    klass.subclasses = [];

    if (parent) {
      subclass.prototype = parent.prototype;
      klass.prototype = new subclass;
      parent.subclasses.push(klass);
    }

    for (var i = 0, length = properties.length; i < length; i++)
      klass.addMethods(properties[i]);

    if (!klass.prototype.initialize)
      klass.prototype.initialize = Prototype.emptyFunction;

    klass.prototype.constructor = klass;
    return klass;
  }

  function addMethods(source) {
    var ancestor   = this.superclass && this.superclass.prototype,
        properties = Object.keys(source);

    if (IS_DONTENUM_BUGGY) {
      if (source.toString != Object.prototype.toString)
        properties.push("toString");
      if (source.valueOf != Object.prototype.valueOf)
        properties.push("valueOf");
    }

    for (var i = 0, length = properties.length; i < length; i++) {
      var property = properties[i], value = source[property];
      if (ancestor && Object.isFunction(value) &&
          value.argumentNames()[0] == "$super") {
        var method = value;
        value = (function(m) {
          return function() { return ancestor[m].apply(this, arguments); };
        })(property).wrap(method);

        value.valueOf = (function(method) {
          return function() { return method.valueOf.call(method); };
        })(method);

        value.toString = (function(method) {
          return function() { return method.toString.call(method); };
        })(method);
      }
      this.prototype[property] = value;
    }

    return this;
  }

  return {
    create: create,
    Methods: {
      addMethods: addMethods
    }
  };
})();
(function() {

  var _toString = Object.prototype.toString,
      _hasOwnProperty = Object.prototype.hasOwnProperty,
      NULL_TYPE = 'Null',
      UNDEFINED_TYPE = 'Undefined',
      BOOLEAN_TYPE = 'Boolean',
      NUMBER_TYPE = 'Number',
      STRING_TYPE = 'String',
      OBJECT_TYPE = 'Object',
      FUNCTION_CLASS = '[object Function]',
      BOOLEAN_CLASS = '[object Boolean]',
      NUMBER_CLASS = '[object Number]',
      STRING_CLASS = '[object String]',
      ARRAY_CLASS = '[object Array]',
      DATE_CLASS = '[object Date]',
      NATIVE_JSON_STRINGIFY_SUPPORT = window.JSON &&
        typeof JSON.stringify === 'function' &&
        JSON.stringify(0) === '0' &&
        typeof JSON.stringify(Prototype.K) === 'undefined';



  var DONT_ENUMS = ['toString', 'toLocaleString', 'valueOf',
   'hasOwnProperty', 'isPrototypeOf', 'propertyIsEnumerable', 'constructor'];

  var IS_DONTENUM_BUGGY = (function(){
    for (var p in { toString: 1 }) {
      if (p === 'toString') return false;
    }
    return true;
  })();

  function Type(o) {
    switch(o) {
      case null: return NULL_TYPE;
      case (void 0): return UNDEFINED_TYPE;
    }
    var type = typeof o;
    switch(type) {
      case 'boolean': return BOOLEAN_TYPE;
      case 'number':  return NUMBER_TYPE;
      case 'string':  return STRING_TYPE;
    }
    return OBJECT_TYPE;
  }

  function extend(destination, source) {
    for (var property in source)
      destination[property] = source[property];
    return destination;
  }

  function inspect(object) {
    try {
      if (isUndefined(object)) return 'undefined';
      if (object === null) return 'null';
      return object.inspect ? object.inspect() : String(object);
    } catch (e) {
      if (e instanceof RangeError) return '...';
      throw e;
    }
  }

  function toJSON(value) {
    return Str('', { '': value }, []);
  }

  function Str(key, holder, stack) {
    var value = holder[key];
    if (Type(value) === OBJECT_TYPE && typeof value.toJSON === 'function') {
      value = value.toJSON(key);
    }

    var _class = _toString.call(value);

    switch (_class) {
      case NUMBER_CLASS:
      case BOOLEAN_CLASS:
      case STRING_CLASS:
        value = value.valueOf();
    }

    switch (value) {
      case null: return 'null';
      case true: return 'true';
      case false: return 'false';
    }

    var type = typeof value;
    switch (type) {
      case 'string':
        return value.inspect(true);
      case 'number':
        return isFinite(value) ? String(value) : 'null';
      case 'object':

        for (var i = 0, length = stack.length; i < length; i++) {
          if (stack[i] === value) {
            throw new TypeError("Cyclic reference to '" + value + "' in object");
          }
        }
        stack.push(value);

        var partial = [];
        if (_class === ARRAY_CLASS) {
          for (var i = 0, length = value.length; i < length; i++) {
            var str = Str(i, value, stack);
            partial.push(typeof str === 'undefined' ? 'null' : str);
          }
          partial = '[' + partial.join(',') + ']';
        } else {
          var keys = Object.keys(value);
          for (var i = 0, length = keys.length; i < length; i++) {
            var key = keys[i], str = Str(key, value, stack);
            if (typeof str !== "undefined") {
               partial.push(key.inspect(true)+ ':' + str);
             }
          }
          partial = '{' + partial.join(',') + '}';
        }
        stack.pop();
        return partial;
    }
  }

  function stringify(object) {
    return JSON.stringify(object);
  }

  function toQueryString(object) {
    return $H(object).toQueryString();
  }

  function toHTML(object) {
    return object && object.toHTML ? object.toHTML() : String.interpret(object);
  }

  function keys(object) {
    if (Type(object) !== OBJECT_TYPE) { throw new TypeError(); }
    var results = [];
    for (var property in object) {
      if (_hasOwnProperty.call(object, property))
        results.push(property);
    }

    if (IS_DONTENUM_BUGGY) {
      for (var i = 0; property = DONT_ENUMS[i]; i++) {
        if (_hasOwnProperty.call(object, property))
          results.push(property);
      }
    }

    return results;
  }

  function values(object) {
    var results = [];
    for (var property in object)
      results.push(object[property]);
    return results;
  }

  function clone(object) {
    return extend({ }, object);
  }

  function isElement(object) {
    return !!(object && object.nodeType == 1);
  }

  function isArray(object) {
    return _toString.call(object) === ARRAY_CLASS;
  }

  var hasNativeIsArray = (typeof Array.isArray == 'function')
    && Array.isArray([]) && !Array.isArray({});

  if (hasNativeIsArray) {
    isArray = Array.isArray;
  }

  function isHash(object) {
    return object instanceof Hash;
  }

  function isFunction(object) {
    return _toString.call(object) === FUNCTION_CLASS;
  }

  function isString(object) {
    return _toString.call(object) === STRING_CLASS;
  }

  function isNumber(object) {
    return _toString.call(object) === NUMBER_CLASS;
  }

  function isDate(object) {
    return _toString.call(object) === DATE_CLASS;
  }

  function isUndefined(object) {
    return typeof object === "undefined";
  }

  extend(Object, {
    extend:        extend,
    inspect:       inspect,
    toJSON:        NATIVE_JSON_STRINGIFY_SUPPORT ? stringify : toJSON,
    toQueryString: toQueryString,
    toHTML:        toHTML,
    keys:          Object.keys || keys,
    values:        values,
    clone:         clone,
    isElement:     isElement,
    isArray:       isArray,
    isHash:        isHash,
    isFunction:    isFunction,
    isString:      isString,
    isNumber:      isNumber,
    isDate:        isDate,
    isUndefined:   isUndefined
  });
})();
Object.extend(Function.prototype, (function() {
  var slice = Array.prototype.slice;

  function update(array, args) {
    var arrayLength = array.length, length = args.length;
    while (length--) array[arrayLength + length] = args[length];
    return array;
  }

  function merge(array, args) {
    array = slice.call(array, 0);
    return update(array, args);
  }

  function argumentNames() {
    var names = this.toString().match(/^[\s\(]*function[^(]*\(([^)]*)\)/)[1]
      .replace(/\/\/.*?[\r\n]|\/\*(?:.|[\r\n])*?\*\//g, '')
      .replace(/\s+/g, '').split(',');
    return names.length == 1 && !names[0] ? [] : names;
  }


  function bind(context) {
    if (arguments.length < 2 && Object.isUndefined(arguments[0]))
      return this;

    if (!Object.isFunction(this))
      throw new TypeError("The object is not callable.");

    var nop = function() {};
    var __method = this, args = slice.call(arguments, 1);

    var bound = function() {
      var a = merge(args, arguments), c = context;
      var c = this instanceof bound ? this : context;
      return __method.apply(c, a);
    };

    nop.prototype   = this.prototype;
    bound.prototype = new nop();

    return bound;
  }

  function bindAsEventListener(context) {
    var __method = this, args = slice.call(arguments, 1);
    return function(event) {
      var a = update([event || window.event], args);
      return __method.apply(context, a);
    }
  }

  function curry() {
    if (!arguments.length) return this;
    var __method = this, args = slice.call(arguments, 0);
    return function() {
      var a = merge(args, arguments);
      return __method.apply(this, a);
    }
  }

  function delay(timeout) {
    var __method = this, args = slice.call(arguments, 1);
    timeout = timeout * 1000;
    return window.setTimeout(function() {
      return __method.apply(__method, args);
    }, timeout);
  }

  function defer() {
    var args = update([0.01], arguments);
    return this.delay.apply(this, args);
  }

  function wrap(wrapper) {
    var __method = this;
    return function() {
      var a = update([__method.bind(this)], arguments);
      return wrapper.apply(this, a);
    }
  }

  function methodize() {
    if (this._methodized) return this._methodized;
    var __method = this;
    return this._methodized = function() {
      var a = update([this], arguments);
      return __method.apply(null, a);
    };
  }

  var extensions = {
    argumentNames:       argumentNames,
    bindAsEventListener: bindAsEventListener,
    curry:               curry,
    delay:               delay,
    defer:               defer,
    wrap:                wrap,
    methodize:           methodize
  };

  if (!Function.prototype.bind)
    extensions.bind = bind;

  return extensions;
})());



(function(proto) {


  function toISOString() {
    return this.getUTCFullYear() + '-' +
      (this.getUTCMonth() + 1).toPaddedString(2) + '-' +
      this.getUTCDate().toPaddedString(2) + 'T' +
      this.getUTCHours().toPaddedString(2) + ':' +
      this.getUTCMinutes().toPaddedString(2) + ':' +
      this.getUTCSeconds().toPaddedString(2) + 'Z';
  }


  function toJSON() {
    return this.toISOString();
  }

  if (!proto.toISOString) proto.toISOString = toISOString;
  if (!proto.toJSON) proto.toJSON = toJSON;

})(Date.prototype);


RegExp.prototype.match = RegExp.prototype.test;

RegExp.escape = function(str) {
  return String(str).replace(/([.*+?^=!:${}()|[\]\/\\])/g, '\\$1');
};
var PeriodicalExecuter = Class.create({
  initialize: function(callback, frequency) {
    this.callback = callback;
    this.frequency = frequency;
    this.currentlyExecuting = false;

    this.registerCallback();
  },

  registerCallback: function() {
    this.timer = setInterval(this.onTimerEvent.bind(this), this.frequency * 1000);
  },

  execute: function() {
    this.callback(this);
  },

  stop: function() {
    if (!this.timer) return;
    clearInterval(this.timer);
    this.timer = null;
  },

  onTimerEvent: function() {
    if (!this.currentlyExecuting) {
      try {
        this.currentlyExecuting = true;
        this.execute();
        this.currentlyExecuting = false;
      } catch(e) {
        this.currentlyExecuting = false;
        throw e;
      }
    }
  }
});
Object.extend(String, {
  interpret: function(value) {
    return value == null ? '' : String(value);
  },
  specialChar: {
    '\b': '\\b',
    '\t': '\\t',
    '\n': '\\n',
    '\f': '\\f',
    '\r': '\\r',
    '\\': '\\\\'
  }
});

Object.extend(String.prototype, (function() {
  var NATIVE_JSON_PARSE_SUPPORT = window.JSON &&
    typeof JSON.parse === 'function' &&
    JSON.parse('{"test": true}').test;

  function prepareReplacement(replacement) {
    if (Object.isFunction(replacement)) return replacement;
    var template = new Template(replacement);
    return function(match) { return template.evaluate(match) };
  }

  function gsub(pattern, replacement) {
    var result = '', source = this, match;
    replacement = prepareReplacement(replacement);

    if (Object.isString(pattern))
      pattern = RegExp.escape(pattern);

    if (!(pattern.length || pattern.source)) {
      replacement = replacement('');
      return replacement + source.split('').join(replacement) + replacement;
    }

    while (source.length > 0) {
      if (match = source.match(pattern)) {
        result += source.slice(0, match.index);
        result += String.interpret(replacement(match));
        source  = source.slice(match.index + match[0].length);
      } else {
        result += source, source = '';
      }
    }
    return result;
  }

  function sub(pattern, replacement, count) {
    replacement = prepareReplacement(replacement);
    count = Object.isUndefined(count) ? 1 : count;

    return this.gsub(pattern, function(match) {
      if (--count < 0) return match[0];
      return replacement(match);
    });
  }

  function scan(pattern, iterator) {
    this.gsub(pattern, iterator);
    return String(this);
  }

  function truncate(length, truncation) {
    length = length || 30;
    truncation = Object.isUndefined(truncation) ? '...' : truncation;
    return this.length > length ?
      this.slice(0, length - truncation.length) + truncation : String(this);
  }

  function strip() {
    return this.replace(/^\s+/, '').replace(/\s+$/, '');
  }

  function stripTags() {
    return this.replace(/<\w+(\s+("[^"]*"|'[^']*'|[^>])+)?>|<\/\w+>/gi, '');
  }

  function stripScripts() {
    return this.replace(new RegExp(Prototype.ScriptFragment, 'img'), '');
  }

  function extractScripts() {
    var matchAll = new RegExp(Prototype.ScriptFragment, 'img'),
        matchOne = new RegExp(Prototype.ScriptFragment, 'im');
    return (this.match(matchAll) || []).map(function(scriptTag) {
      return (scriptTag.match(matchOne) || ['', ''])[1];
    });
  }

  function evalScripts() {
    return this.extractScripts().map(function(script) { return eval(script); });
  }

  function escapeHTML() {
    return this.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;');
  }

  function unescapeHTML() {
    return this.stripTags().replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&amp;/g,'&');
  }


  function toQueryParams(separator) {
    var match = this.strip().match(/([^?#]*)(#.*)?$/);
    if (!match) return { };

    return match[1].split(separator || '&').inject({ }, function(hash, pair) {
      if ((pair = pair.split('='))[0]) {
        var key = decodeURIComponent(pair.shift()),
            value = pair.length > 1 ? pair.join('=') : pair[0];

        if (value != undefined) value = decodeURIComponent(value);

        if (key in hash) {
          if (!Object.isArray(hash[key])) hash[key] = [hash[key]];
          hash[key].push(value);
        }
        else hash[key] = value;
      }
      return hash;
    });
  }

  function toArray() {
    return this.split('');
  }

  function succ() {
    return this.slice(0, this.length - 1) +
      String.fromCharCode(this.charCodeAt(this.length - 1) + 1);
  }

  function times(count) {
    return count < 1 ? '' : new Array(count + 1).join(this);
  }

  function camelize() {
    return this.replace(/-+(.)?/g, function(match, chr) {
      return chr ? chr.toUpperCase() : '';
    });
  }

  function capitalize() {
    return this.charAt(0).toUpperCase() + this.substring(1).toLowerCase();
  }

  function underscore() {
    return this.replace(/::/g, '/')
               .replace(/([A-Z]+)([A-Z][a-z])/g, '$1_$2')
               .replace(/([a-z\d])([A-Z])/g, '$1_$2')
               .replace(/-/g, '_')
               .toLowerCase();
  }

  function dasherize() {
    return this.replace(/_/g, '-');
  }

  function inspect(useDoubleQuotes) {
    var escapedString = this.replace(/[\x00-\x1f\\]/g, function(character) {
      if (character in String.specialChar) {
        return String.specialChar[character];
      }
      return '\\u00' + character.charCodeAt().toPaddedString(2, 16);
    });
    if (useDoubleQuotes) return '"' + escapedString.replace(/"/g, '\\"') + '"';
    return "'" + escapedString.replace(/'/g, '\\\'') + "'";
  }

  function unfilterJSON(filter) {
    return this.replace(filter || Prototype.JSONFilter, '$1');
  }

  function isJSON() {
    var str = this;
    if (str.blank()) return false;
    str = str.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, '@');
    str = str.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']');
    str = str.replace(/(?:^|:|,)(?:\s*\[)+/g, '');
    return (/^[\],:{}\s]*$/).test(str);
  }

  function evalJSON(sanitize) {
    var json = this.unfilterJSON(),
        cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
    if (cx.test(json)) {
      json = json.replace(cx, function (a) {
        return '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
      });
    }
    try {
      if (!sanitize || json.isJSON()) return eval('(' + json + ')');
    } catch (e) { }
    throw new SyntaxError('Badly formed JSON string: ' + this.inspect());
  }

  function parseJSON() {
    var json = this.unfilterJSON();
    return JSON.parse(json);
  }

  function include(pattern) {
    return this.indexOf(pattern) > -1;
  }

  function startsWith(pattern) {
    return this.lastIndexOf(pattern, 0) === 0;
  }

  function endsWith(pattern) {
    var d = this.length - pattern.length;
    return d >= 0 && this.indexOf(pattern, d) === d;
  }

  function empty() {
    return this == '';
  }

  function blank() {
    return /^\s*$/.test(this);
  }

  function interpolate(object, pattern) {
    return new Template(this, pattern).evaluate(object);
  }

  return {
    gsub:           gsub,
    sub:            sub,
    scan:           scan,
    truncate:       truncate,
    strip:          String.prototype.trim || strip,
    stripTags:      stripTags,
    stripScripts:   stripScripts,
    extractScripts: extractScripts,
    evalScripts:    evalScripts,
    escapeHTML:     escapeHTML,
    unescapeHTML:   unescapeHTML,
    toQueryParams:  toQueryParams,
    parseQuery:     toQueryParams,
    toArray:        toArray,
    succ:           succ,
    times:          times,
    camelize:       camelize,
    capitalize:     capitalize,
    underscore:     underscore,
    dasherize:      dasherize,
    inspect:        inspect,
    unfilterJSON:   unfilterJSON,
    isJSON:         isJSON,
    evalJSON:       NATIVE_JSON_PARSE_SUPPORT ? parseJSON : evalJSON,
    include:        include,
    startsWith:     startsWith,
    endsWith:       endsWith,
    empty:          empty,
    blank:          blank,
    interpolate:    interpolate
  };
})());

var Template = Class.create({
  initialize: function(template, pattern) {
    this.template = template.toString();
    this.pattern = pattern || Template.Pattern;
  },

  evaluate: function(object) {
    if (object && Object.isFunction(object.toTemplateReplacements))
      object = object.toTemplateReplacements();

    return this.template.gsub(this.pattern, function(match) {
      if (object == null) return (match[1] + '');

      var before = match[1] || '';
      if (before == '\\') return match[2];

      var ctx = object, expr = match[3],
          pattern = /^([^.[]+|\[((?:.*?[^\\])?)\])(\.|\[|$)/;

      match = pattern.exec(expr);
      if (match == null) return before;

      while (match != null) {
        var comp = match[1].startsWith('[') ? match[2].replace(/\\\\]/g, ']') : match[1];
        ctx = ctx[comp];
        if (null == ctx || '' == match[3]) break;
        expr = expr.substring('[' == match[3] ? match[1].length : match[0].length);
        match = pattern.exec(expr);
      }

      return before + String.interpret(ctx);
    });
  }
});
Template.Pattern = /(^|.|\r|\n)(#\{(.*?)\})/;

var $break = { };

var Enumerable = (function() {
  function each(iterator, context) {
    try {
      this._each(iterator, context);
    } catch (e) {
      if (e != $break) throw e;
    }
    return this;
  }

  function eachSlice(number, iterator, context) {
    var index = -number, slices = [], array = this.toArray();
    if (number < 1) return array;
    while ((index += number) < array.length)
      slices.push(array.slice(index, index+number));
    return slices.collect(iterator, context);
  }

  function all(iterator, context) {
    iterator = iterator || Prototype.K;
    var result = true;
    this.each(function(value, index) {
      result = result && !!iterator.call(context, value, index, this);
      if (!result) throw $break;
    }, this);
    return result;
  }

  function any(iterator, context) {
    iterator = iterator || Prototype.K;
    var result = false;
    this.each(function(value, index) {
      if (result = !!iterator.call(context, value, index, this))
        throw $break;
    }, this);
    return result;
  }

  function collect(iterator, context) {
    iterator = iterator || Prototype.K;
    var results = [];
    this.each(function(value, index) {
      results.push(iterator.call(context, value, index, this));
    }, this);
    return results;
  }

  function detect(iterator, context) {
    var result;
    this.each(function(value, index) {
      if (iterator.call(context, value, index, this)) {
        result = value;
        throw $break;
      }
    }, this);
    return result;
  }

  function findAll(iterator, context) {
    var results = [];
    this.each(function(value, index) {
      if (iterator.call(context, value, index, this))
        results.push(value);
    }, this);
    return results;
  }

  function grep(filter, iterator, context) {
    iterator = iterator || Prototype.K;
    var results = [];

    if (Object.isString(filter))
      filter = new RegExp(RegExp.escape(filter));

    this.each(function(value, index) {
      if (filter.match(value))
        results.push(iterator.call(context, value, index, this));
    }, this);
    return results;
  }

  function include(object) {
    if (Object.isFunction(this.indexOf))
      if (this.indexOf(object) != -1) return true;

    var found = false;
    this.each(function(value) {
      if (value == object) {
        found = true;
        throw $break;
      }
    });
    return found;
  }

  function inGroupsOf(number, fillWith) {
    fillWith = Object.isUndefined(fillWith) ? null : fillWith;
    return this.eachSlice(number, function(slice) {
      while(slice.length < number) slice.push(fillWith);
      return slice;
    });
  }

  function inject(memo, iterator, context) {
    this.each(function(value, index) {
      memo = iterator.call(context, memo, value, index, this);
    }, this);
    return memo;
  }

  function invoke(method) {
    var args = $A(arguments).slice(1);
    return this.map(function(value) {
      return value[method].apply(value, args);
    });
  }

  function max(iterator, context) {
    iterator = iterator || Prototype.K;
    var result;
    this.each(function(value, index) {
      value = iterator.call(context, value, index, this);
      if (result == null || value >= result)
        result = value;
    }, this);
    return result;
  }

  function min(iterator, context) {
    iterator = iterator || Prototype.K;
    var result;
    this.each(function(value, index) {
      value = iterator.call(context, value, index, this);
      if (result == null || value < result)
        result = value;
    }, this);
    return result;
  }

  function partition(iterator, context) {
    iterator = iterator || Prototype.K;
    var trues = [], falses = [];
    this.each(function(value, index) {
      (iterator.call(context, value, index, this) ?
        trues : falses).push(value);
    }, this);
    return [trues, falses];
  }

  function pluck(property) {
    var results = [];
    this.each(function(value) {
      results.push(value[property]);
    });
    return results;
  }

  function reject(iterator, context) {
    var results = [];
    this.each(function(value, index) {
      if (!iterator.call(context, value, index, this))
        results.push(value);
    }, this);
    return results;
  }

  function sortBy(iterator, context) {
    return this.map(function(value, index) {
      return {
        value: value,
        criteria: iterator.call(context, value, index, this)
      };
    }, this).sort(function(left, right) {
      var a = left.criteria, b = right.criteria;
      return a < b ? -1 : a > b ? 1 : 0;
    }).pluck('value');
  }

  function toArray() {
    return this.map();
  }

  function zip() {
    var iterator = Prototype.K, args = $A(arguments);
    if (Object.isFunction(args.last()))
      iterator = args.pop();

    var collections = [this].concat(args).map($A);
    return this.map(function(value, index) {
      return iterator(collections.pluck(index));
    });
  }

  function size() {
    return this.toArray().length;
  }

  function inspect() {
    return '#<Enumerable:' + this.toArray().inspect() + '>';
  }









  return {
    each:       each,
    eachSlice:  eachSlice,
    all:        all,
    every:      all,
    any:        any,
    some:       any,
    collect:    collect,
    map:        collect,
    detect:     detect,
    findAll:    findAll,
    select:     findAll,
    filter:     findAll,
    grep:       grep,
    include:    include,
    member:     include,
    inGroupsOf: inGroupsOf,
    inject:     inject,
    invoke:     invoke,
    max:        max,
    min:        min,
    partition:  partition,
    pluck:      pluck,
    reject:     reject,
    sortBy:     sortBy,
    toArray:    toArray,
    entries:    toArray,
    zip:        zip,
    size:       size,
    inspect:    inspect,
    find:       detect
  };
})();

function $A(iterable) {
  if (!iterable) return [];
  if ('toArray' in Object(iterable)) return iterable.toArray();
  var length = iterable.length || 0, results = new Array(length);
  while (length--) results[length] = iterable[length];
  return results;
}


function $w(string) {
  if (!Object.isString(string)) return [];
  string = string.strip();
  return string ? string.split(/\s+/) : [];
}

Array.from = $A;


(function() {
  var arrayProto = Array.prototype,
      slice = arrayProto.slice,
      _each = arrayProto.forEach; // use native browser JS 1.6 implementation if available

  function each(iterator, context) {
    for (var i = 0, length = this.length >>> 0; i < length; i++) {
      if (i in this) iterator.call(context, this[i], i, this);
    }
  }
  if (!_each) _each = each;

  function clear() {
    this.length = 0;
    return this;
  }

  function first() {
    return this[0];
  }

  function last() {
    return this[this.length - 1];
  }

  function compact() {
    return this.select(function(value) {
      return value != null;
    });
  }

  function flatten() {
    return this.inject([], function(array, value) {
      if (Object.isArray(value))
        return array.concat(value.flatten());
      array.push(value);
      return array;
    });
  }

  function without() {
    var values = slice.call(arguments, 0);
    return this.select(function(value) {
      return !values.include(value);
    });
  }

  function reverse(inline) {
    return (inline === false ? this.toArray() : this)._reverse();
  }

  function uniq(sorted) {
    return this.inject([], function(array, value, index) {
      if (0 == index || (sorted ? array.last() != value : !array.include(value)))
        array.push(value);
      return array;
    });
  }

  function intersect(array) {
    return this.uniq().findAll(function(item) {
      return array.indexOf(item) !== -1;
    });
  }


  function clone() {
    return slice.call(this, 0);
  }

  function size() {
    return this.length;
  }

  function inspect() {
    return '[' + this.map(Object.inspect).join(', ') + ']';
  }

  function indexOf(item, i) {
    if (this == null) throw new TypeError();

    var array = Object(this), length = array.length >>> 0;
    if (length === 0) return -1;

    i = Number(i);
    if (isNaN(i)) {
      i = 0;
    } else if (i !== 0 && isFinite(i)) {
      i = (i > 0 ? 1 : -1) * Math.floor(Math.abs(i));
    }

    if (i > length) return -1;

    var k = i >= 0 ? i : Math.max(length - Math.abs(i), 0);
    for (; k < length; k++)
      if (k in array && array[k] === item) return k;
    return -1;
  }


  function lastIndexOf(item, i) {
    if (this == null) throw new TypeError();

    var array = Object(this), length = array.length >>> 0;
    if (length === 0) return -1;

    if (!Object.isUndefined(i)) {
      i = Number(i);
      if (isNaN(i)) {
        i = 0;
      } else if (i !== 0 && isFinite(i)) {
        i = (i > 0 ? 1 : -1) * Math.floor(Math.abs(i));
      }
    } else {
      i = length;
    }

    var k = i >= 0 ? Math.min(i, length - 1) :
     length - Math.abs(i);

    for (; k >= 0; k--)
      if (k in array && array[k] === item) return k;
    return -1;
  }

  function concat(_) {
    var array = [], items = slice.call(arguments, 0), item, n = 0;
    items.unshift(this);
    for (var i = 0, length = items.length; i < length; i++) {
      item = items[i];
      if (Object.isArray(item) && !('callee' in item)) {
        for (var j = 0, arrayLength = item.length; j < arrayLength; j++) {
          if (j in item) array[n] = item[j];
          n++;
        }
      } else {
        array[n++] = item;
      }
    }
    array.length = n;
    return array;
  }


  function wrapNative(method) {
    return function() {
      if (arguments.length === 0) {
        return method.call(this, Prototype.K);
      } else if (arguments[0] === undefined) {
        var args = slice.call(arguments, 1);
        args.unshift(Prototype.K);
        return method.apply(this, args);
      } else {
        return method.apply(this, arguments);
      }
    };
  }


  function map(iterator) {
    if (this == null) throw new TypeError();
    iterator = iterator || Prototype.K;

    var object = Object(this);
    var results = [], context = arguments[1], n = 0;

    for (var i = 0, length = object.length >>> 0; i < length; i++) {
      if (i in object) {
        results[n] = iterator.call(context, object[i], i, object);
      }
      n++;
    }
    results.length = n;
    return results;
  }

  if (arrayProto.map) {
    map = wrapNative(Array.prototype.map);
  }

  function filter(iterator) {
    if (this == null || !Object.isFunction(iterator))
      throw new TypeError();

    var object = Object(this);
    var results = [], context = arguments[1], value;

    for (var i = 0, length = object.length >>> 0; i < length; i++) {
      if (i in object) {
        value = object[i];
        if (iterator.call(context, value, i, object)) {
          results.push(value);
        }
      }
    }
    return results;
  }

  if (arrayProto.filter) {
    filter = Array.prototype.filter;
  }

  function some(iterator) {
    if (this == null) throw new TypeError();
    iterator = iterator || Prototype.K;
    var context = arguments[1];

    var object = Object(this);
    for (var i = 0, length = object.length >>> 0; i < length; i++) {
      if (i in object && iterator.call(context, object[i], i, object)) {
        return true;
      }
    }

    return false;
  }

  if (arrayProto.some) {
    var some = wrapNative(Array.prototype.some);
  }


  function every(iterator) {
    if (this == null) throw new TypeError();
    iterator = iterator || Prototype.K;
    var context = arguments[1];

    var object = Object(this);
    for (var i = 0, length = object.length >>> 0; i < length; i++) {
      if (i in object && !iterator.call(context, object[i], i, object)) {
        return false;
      }
    }

    return true;
  }

  if (arrayProto.every) {
    var every = wrapNative(Array.prototype.every);
  }

  var _reduce = arrayProto.reduce;
  function inject(memo, iterator) {
    iterator = iterator || Prototype.K;
    var context = arguments[2];
    return _reduce.call(this, iterator.bind(context), memo);
  }

  if (!arrayProto.reduce) {
    var inject = Enumerable.inject;
  }

  Object.extend(arrayProto, Enumerable);

  if (!arrayProto._reverse)
    arrayProto._reverse = arrayProto.reverse;

  Object.extend(arrayProto, {
    _each:     _each,

    map:       map,
    collect:   map,
    select:    filter,
    filter:    filter,
    findAll:   filter,
    some:      some,
    any:       some,
    every:     every,
    all:       every,
    inject:    inject,

    clear:     clear,
    first:     first,
    last:      last,
    compact:   compact,
    flatten:   flatten,
    without:   without,
    reverse:   reverse,
    uniq:      uniq,
    intersect: intersect,
    clone:     clone,
    toArray:   clone,
    size:      size,
    inspect:   inspect
  });

  var CONCAT_ARGUMENTS_BUGGY = (function() {
    return [].concat(arguments)[0][0] !== 1;
  })(1,2);

  if (CONCAT_ARGUMENTS_BUGGY) arrayProto.concat = concat;

  if (!arrayProto.indexOf) arrayProto.indexOf = indexOf;
  if (!arrayProto.lastIndexOf) arrayProto.lastIndexOf = lastIndexOf;
})();
function $H(object) {
  return new Hash(object);
};

var Hash = Class.create(Enumerable, (function() {
  function initialize(object) {
    this._object = Object.isHash(object) ? object.toObject() : Object.clone(object);
  }


  function _each(iterator, context) {
    for (var key in this._object) {
      var value = this._object[key], pair = [key, value];
      pair.key = key;
      pair.value = value;
      iterator.call(context, pair);
    }
  }

  function set(key, value) {
    return this._object[key] = value;
  }

  function get(key) {
    if (this._object[key] !== Object.prototype[key])
      return this._object[key];
  }

  function unset(key) {
    var value = this._object[key];
    delete this._object[key];
    return value;
  }

  function toObject() {
    return Object.clone(this._object);
  }



  function keys() {
    return this.pluck('key');
  }

  function values() {
    return this.pluck('value');
  }

  function index(value) {
    var match = this.detect(function(pair) {
      return pair.value === value;
    });
    return match && match.key;
  }

  function merge(object) {
    return this.clone().update(object);
  }

  function update(object) {
    return new Hash(object).inject(this, function(result, pair) {
      result.set(pair.key, pair.value);
      return result;
    });
  }

  function toQueryPair(key, value) {
    if (Object.isUndefined(value)) return key;

    var value = String.interpret(value);

    value = value.gsub(/(\r)?\n/, '\r\n');
    value = encodeURIComponent(value);
    value = value.gsub(/%20/, '+');
    return key + '=' + value;
  }

  function toQueryString() {
    return this.inject([], function(results, pair) {
      var key = encodeURIComponent(pair.key), values = pair.value;

      if (values && typeof values == 'object') {
        if (Object.isArray(values)) {
          var queryValues = [];
          for (var i = 0, len = values.length, value; i < len; i++) {
            value = values[i];
            queryValues.push(toQueryPair(key, value));
          }
          return results.concat(queryValues);
        }
      } else results.push(toQueryPair(key, values));
      return results;
    }).join('&');
  }

  function inspect() {
    return '#<Hash:{' + this.map(function(pair) {
      return pair.map(Object.inspect).join(': ');
    }).join(', ') + '}>';
  }

  function clone() {
    return new Hash(this);
  }

  return {
    initialize:             initialize,
    _each:                  _each,
    set:                    set,
    get:                    get,
    unset:                  unset,
    toObject:               toObject,
    toTemplateReplacements: toObject,
    keys:                   keys,
    values:                 values,
    index:                  index,
    merge:                  merge,
    update:                 update,
    toQueryString:          toQueryString,
    inspect:                inspect,
    toJSON:                 toObject,
    clone:                  clone
  };
})());

Hash.from = $H;
Object.extend(Number.prototype, (function() {
  function toColorPart() {
    return this.toPaddedString(2, 16);
  }

  function succ() {
    return this + 1;
  }

  function times(iterator, context) {
    $R(0, this, true).each(iterator, context);
    return this;
  }

  function toPaddedString(length, radix) {
    var string = this.toString(radix || 10);
    return '0'.times(length - string.length) + string;
  }

  function abs() {
    return Math.abs(this);
  }

  function round() {
    return Math.round(this);
  }

  function ceil() {
    return Math.ceil(this);
  }

  function floor() {
    return Math.floor(this);
  }

  return {
    toColorPart:    toColorPart,
    succ:           succ,
    times:          times,
    toPaddedString: toPaddedString,
    abs:            abs,
    round:          round,
    ceil:           ceil,
    floor:          floor
  };
})());

function $R(start, end, exclusive) {
  return new ObjectRange(start, end, exclusive);
}

var ObjectRange = Class.create(Enumerable, (function() {
  function initialize(start, end, exclusive) {
    this.start = start;
    this.end = end;
    this.exclusive = exclusive;
  }

  function _each(iterator, context) {
    var value = this.start;
    while (this.include(value)) {
      iterator.call(context, value);
      value = value.succ();
    }
  }

  function include(value) {
    if (value < this.start)
      return false;
    if (this.exclusive)
      return value < this.end;
    return value <= this.end;
  }

  return {
    initialize: initialize,
    _each:      _each,
    include:    include
  };
})());



var Abstract = { };


var Try = {
  these: function() {
    var returnValue;

    for (var i = 0, length = arguments.length; i < length; i++) {
      var lambda = arguments[i];
      try {
        returnValue = lambda();
        break;
      } catch (e) { }
    }

    return returnValue;
  }
};

var Ajax = {
  getTransport: function() {
    return Try.these(
      function() {return new XMLHttpRequest()},
      function() {return new ActiveXObject('Msxml2.XMLHTTP')},
      function() {return new ActiveXObject('Microsoft.XMLHTTP')}
    ) || false;
  },

  activeRequestCount: 0
};

Ajax.Responders = {
  responders: [],

  _each: function(iterator, context) {
    this.responders._each(iterator, context);
  },

  register: function(responder) {
    if (!this.include(responder))
      this.responders.push(responder);
  },

  unregister: function(responder) {
    this.responders = this.responders.without(responder);
  },

  dispatch: function(callback, request, transport, json) {
    this.each(function(responder) {
      if (Object.isFunction(responder[callback])) {
        try {
          responder[callback].apply(responder, [request, transport, json]);
        } catch (e) { }
      }
    });
  }
};

Object.extend(Ajax.Responders, Enumerable);

Ajax.Responders.register({
  onCreate:   function() { Ajax.activeRequestCount++ },
  onComplete: function() { Ajax.activeRequestCount-- }
});
Ajax.Base = Class.create({
  initialize: function(options) {
    this.options = {
      method:       'post',
      asynchronous: true,
      contentType:  'application/x-www-form-urlencoded',
      encoding:     'UTF-8',
      parameters:   '',
      evalJSON:     true,
      evalJS:       true
    };
    Object.extend(this.options, options || { });

    this.options.method = this.options.method.toLowerCase();

    if (Object.isHash(this.options.parameters))
      this.options.parameters = this.options.parameters.toObject();
  }
});
Ajax.Request = Class.create(Ajax.Base, {
  _complete: false,

  initialize: function($super, url, options) {
    $super(options);
    this.transport = Ajax.getTransport();
    this.request(url);
  },

  request: function(url) {
    this.url = url;
    this.method = this.options.method;
    var params = Object.isString(this.options.parameters) ?
          this.options.parameters :
          Object.toQueryString(this.options.parameters);

    if (!['get', 'post'].include(this.method)) {
      params += (params ? '&' : '') + "_method=" + this.method;
      this.method = 'post';
    }

    if (params && this.method === 'get') {
      this.url += (this.url.include('?') ? '&' : '?') + params;
    }

    this.parameters = params.toQueryParams();

    try {
      var response = new Ajax.Response(this);
      if (this.options.onCreate) this.options.onCreate(response);
      Ajax.Responders.dispatch('onCreate', this, response);

      this.transport.open(this.method.toUpperCase(), this.url,
        this.options.asynchronous);

      if (this.options.asynchronous) this.respondToReadyState.bind(this).defer(1);

      this.transport.onreadystatechange = this.onStateChange.bind(this);
      this.setRequestHeaders();

      this.body = this.method == 'post' ? (this.options.postBody || params) : null;
      this.transport.send(this.body);

      /* Force Firefox to handle ready state 4 for synchronous requests */
      if (!this.options.asynchronous && this.transport.overrideMimeType)
        this.onStateChange();

    }
    catch (e) {
      this.dispatchException(e);
    }
  },

  onStateChange: function() {
    var readyState = this.transport.readyState;
    if (readyState > 1 && !((readyState == 4) && this._complete))
      this.respondToReadyState(this.transport.readyState);
  },

  setRequestHeaders: function() {
    var headers = {
      'X-Requested-With': 'XMLHttpRequest',
      'X-Prototype-Version': Prototype.Version,
      'Accept': 'text/javascript, text/html, application/xml, text/xml, */*'
    };

    if (this.method == 'post') {
      headers['Content-type'] = this.options.contentType +
        (this.options.encoding ? '; charset=' + this.options.encoding : '');

      /* Force "Connection: close" for older Mozilla browsers to work
       * around a bug where XMLHttpRequest sends an incorrect
       * Content-length header. See Mozilla Bugzilla #246651.
       */
      if (this.transport.overrideMimeType &&
          (navigator.userAgent.match(/Gecko\/(\d{4})/) || [0,2005])[1] < 2005)
            headers['Connection'] = 'close';
    }

    if (typeof this.options.requestHeaders == 'object') {
      var extras = this.options.requestHeaders;

      if (Object.isFunction(extras.push))
        for (var i = 0, length = extras.length; i < length; i += 2)
          headers[extras[i]] = extras[i+1];
      else
        $H(extras).each(function(pair) { headers[pair.key] = pair.value });
    }

    for (var name in headers)
      this.transport.setRequestHeader(name, headers[name]);
  },

  success: function() {
    var status = this.getStatus();
    return !status || (status >= 200 && status < 300) || status == 304;
  },

  getStatus: function() {
    try {
      if (this.transport.status === 1223) return 204;
      return this.transport.status || 0;
    } catch (e) { return 0 }
  },

  respondToReadyState: function(readyState) {
    var state = Ajax.Request.Events[readyState], response = new Ajax.Response(this);

    if (state == 'Complete') {
      try {
        this._complete = true;
        (this.options['on' + response.status]
         || this.options['on' + (this.success() ? 'Success' : 'Failure')]
         || Prototype.emptyFunction)(response, response.headerJSON);
      } catch (e) {
        this.dispatchException(e);
      }

      var contentType = response.getHeader('Content-type');
      if (this.options.evalJS == 'force'
          || (this.options.evalJS && this.isSameOrigin() && contentType
          && contentType.match(/^\s*(text|application)\/(x-)?(java|ecma)script(;.*)?\s*$/i)))
        this.evalResponse();
    }

    try {
      (this.options['on' + state] || Prototype.emptyFunction)(response, response.headerJSON);
      Ajax.Responders.dispatch('on' + state, this, response, response.headerJSON);
    } catch (e) {
      this.dispatchException(e);
    }

    if (state == 'Complete') {
      this.transport.onreadystatechange = Prototype.emptyFunction;
    }
  },

  isSameOrigin: function() {
    var m = this.url.match(/^\s*https?:\/\/[^\/]*/);
    return !m || (m[0] == '#{protocol}//#{domain}#{port}'.interpolate({
      protocol: location.protocol,
      domain: document.domain,
      port: location.port ? ':' + location.port : ''
    }));
  },

  getHeader: function(name) {
    try {
      return this.transport.getResponseHeader(name) || null;
    } catch (e) { return null; }
  },

  evalResponse: function() {
    try {
      return eval((this.transport.responseText || '').unfilterJSON());
    } catch (e) {
      this.dispatchException(e);
    }
  },

  dispatchException: function(exception) {
    (this.options.onException || Prototype.emptyFunction)(this, exception);
    Ajax.Responders.dispatch('onException', this, exception);
  }
});

Ajax.Request.Events =
  ['Uninitialized', 'Loading', 'Loaded', 'Interactive', 'Complete'];








Ajax.Response = Class.create({
  initialize: function(request){
    this.request = request;
    var transport  = this.transport  = request.transport,
        readyState = this.readyState = transport.readyState;

    if ((readyState > 2 && !Prototype.Browser.IE) || readyState == 4) {
      this.status       = this.getStatus();
      this.statusText   = this.getStatusText();
      this.responseText = String.interpret(transport.responseText);
      this.headerJSON   = this._getHeaderJSON();
    }

    if (readyState == 4) {
      var xml = transport.responseXML;
      this.responseXML  = Object.isUndefined(xml) ? null : xml;
      this.responseJSON = this._getResponseJSON();
    }
  },

  status:      0,

  statusText: '',

  getStatus: Ajax.Request.prototype.getStatus,

  getStatusText: function() {
    try {
      return this.transport.statusText || '';
    } catch (e) { return '' }
  },

  getHeader: Ajax.Request.prototype.getHeader,

  getAllHeaders: function() {
    try {
      return this.getAllResponseHeaders();
    } catch (e) { return null }
  },

  getResponseHeader: function(name) {
    return this.transport.getResponseHeader(name);
  },

  getAllResponseHeaders: function() {
    return this.transport.getAllResponseHeaders();
  },

  _getHeaderJSON: function() {
    var json = this.getHeader('X-JSON');
    if (!json) return null;

    try {
      json = decodeURIComponent(escape(json));
    } catch(e) {
    }

    try {
      return json.evalJSON(this.request.options.sanitizeJSON ||
        !this.request.isSameOrigin());
    } catch (e) {
      this.request.dispatchException(e);
    }
  },

  _getResponseJSON: function() {
    var options = this.request.options;
    if (!options.evalJSON || (options.evalJSON != 'force' &&
      !(this.getHeader('Content-type') || '').include('application/json')) ||
        this.responseText.blank())
          return null;
    try {
      return this.responseText.evalJSON(options.sanitizeJSON ||
        !this.request.isSameOrigin());
    } catch (e) {
      this.request.dispatchException(e);
    }
  }
});

Ajax.Updater = Class.create(Ajax.Request, {
  initialize: function($super, container, url, options) {
    this.container = {
      success: (container.success || container),
      failure: (container.failure || (container.success ? null : container))
    };

    options = Object.clone(options);
    var onComplete = options.onComplete;
    options.onComplete = (function(response, json) {
      this.updateContent(response.responseText);
      if (Object.isFunction(onComplete)) onComplete(response, json);
    }).bind(this);

    $super(url, options);
  },

  updateContent: function(responseText) {
    var receiver = this.container[this.success() ? 'success' : 'failure'],
        options = this.options;

    if (!options.evalScripts) responseText = responseText.stripScripts();

    if (receiver = $(receiver)) {
      if (options.insertion) {
        if (Object.isString(options.insertion)) {
          var insertion = { }; insertion[options.insertion] = responseText;
          receiver.insert(insertion);
        }
        else options.insertion(receiver, responseText);
      }
      else receiver.update(responseText);
    }
  }
});

Ajax.PeriodicalUpdater = Class.create(Ajax.Base, {
  initialize: function($super, container, url, options) {
    $super(options);
    this.onComplete = this.options.onComplete;

    this.frequency = (this.options.frequency || 2);
    this.decay = (this.options.decay || 1);

    this.updater = { };
    this.container = container;
    this.url = url;

    this.start();
  },

  start: function() {
    this.options.onComplete = this.updateComplete.bind(this);
    this.onTimerEvent();
  },

  stop: function() {
    this.updater.options.onComplete = undefined;
    clearTimeout(this.timer);
    (this.onComplete || Prototype.emptyFunction).apply(this, arguments);
  },

  updateComplete: function(response) {
    if (this.options.decay) {
      this.decay = (response.responseText == this.lastText ?
        this.decay * this.options.decay : 1);

      this.lastText = response.responseText;
    }
    this.timer = this.onTimerEvent.bind(this).delay(this.decay * this.frequency);
  },

  onTimerEvent: function() {
    this.updater = new Ajax.Updater(this.container, this.url, this.options);
  }
});

(function(GLOBAL) {

  var UNDEFINED;
  var SLICE = Array.prototype.slice;

  var DIV = document.createElement('div');


  function $(element) {
    if (arguments.length > 1) {
      for (var i = 0, elements = [], length = arguments.length; i < length; i++)
        elements.push($(arguments[i]));
      return elements;
    }

    if (Object.isString(element))
      element = document.getElementById(element);
    return Element.extend(element);
  }

  GLOBAL.$ = $;


  if (!GLOBAL.Node) GLOBAL.Node = {};

  if (!GLOBAL.Node.ELEMENT_NODE) {
    Object.extend(GLOBAL.Node, {
      ELEMENT_NODE:                1,
      ATTRIBUTE_NODE:              2,
      TEXT_NODE:                   3,
      CDATA_SECTION_NODE:          4,
      ENTITY_REFERENCE_NODE:       5,
      ENTITY_NODE:                 6,
      PROCESSING_INSTRUCTION_NODE: 7,
      COMMENT_NODE:                8,
      DOCUMENT_NODE:               9,
      DOCUMENT_TYPE_NODE:         10,
      DOCUMENT_FRAGMENT_NODE:     11,
      NOTATION_NODE:              12
    });
  }

  var ELEMENT_CACHE = {};

  function shouldUseCreationCache(tagName, attributes) {
    if (tagName === 'select') return false;
    if ('type' in attributes) return false;
    return true;
  }

  var HAS_EXTENDED_CREATE_ELEMENT_SYNTAX = (function(){
    try {
      var el = document.createElement('<input name="x">');
      return el.tagName.toLowerCase() === 'input' && el.name === 'x';
    }
    catch(err) {
      return false;
    }
  })();


  var oldElement = GLOBAL.Element;
  function Element(tagName, attributes) {
    attributes = attributes || {};
    tagName = tagName.toLowerCase();

    if (HAS_EXTENDED_CREATE_ELEMENT_SYNTAX && attributes.name) {
      tagName = '<' + tagName + ' name="' + attributes.name + '">';
      delete attributes.name;
      return Element.writeAttribute(document.createElement(tagName), attributes);
    }

    if (!ELEMENT_CACHE[tagName])
      ELEMENT_CACHE[tagName] = Element.extend(document.createElement(tagName));

    var node = shouldUseCreationCache(tagName, attributes) ?
     ELEMENT_CACHE[tagName].cloneNode(false) : document.createElement(tagName);

    return Element.writeAttribute(node, attributes);
  }

  GLOBAL.Element = Element;

  Object.extend(GLOBAL.Element, oldElement || {});
  if (oldElement) GLOBAL.Element.prototype = oldElement.prototype;

  Element.Methods = { ByTag: {}, Simulated: {} };

  var methods = {};

  var INSPECT_ATTRIBUTES = { id: 'id', className: 'class' };
  function inspect(element) {
    element = $(element);
    var result = '<' + element.tagName.toLowerCase();

    var attribute, value;
    for (var property in INSPECT_ATTRIBUTES) {
      attribute = INSPECT_ATTRIBUTES[property];
      value = (element[property] || '').toString();
      if (value) result += ' ' + attribute + '=' + value.inspect(true);
    }

    return result + '>';
  }

  methods.inspect = inspect;


  function visible(element) {
    return $(element).style.display !== 'none';
  }

  function toggle(element, bool) {
    element = $(element);
    if (Object.isUndefined(bool))
      bool = !Element.visible(element);
    Element[bool ? 'show' : 'hide'](element);

    return element;
  }

  function hide(element) {
    element = $(element);
    element.style.display = 'none';
    return element;
  }

  function show(element) {
    element = $(element);
    element.style.display = '';
    return element;
  }


  Object.extend(methods, {
    visible: visible,
    toggle:  toggle,
    hide:    hide,
    show:    show
  });


  function remove(element) {
    element = $(element);
    element.parentNode.removeChild(element);
    return element;
  }

  var SELECT_ELEMENT_INNERHTML_BUGGY = (function(){
    var el = document.createElement("select"),
        isBuggy = true;
    el.innerHTML = "<option value=\"test\">test</option>";
    if (el.options && el.options[0]) {
      isBuggy = el.options[0].nodeName.toUpperCase() !== "OPTION";
    }
    el = null;
    return isBuggy;
  })();

  var TABLE_ELEMENT_INNERHTML_BUGGY = (function(){
    try {
      var el = document.createElement("table");
      if (el && el.tBodies) {
        el.innerHTML = "<tbody><tr><td>test</td></tr></tbody>";
        var isBuggy = typeof el.tBodies[0] == "undefined";
        el = null;
        return isBuggy;
      }
    } catch (e) {
      return true;
    }
  })();

  var LINK_ELEMENT_INNERHTML_BUGGY = (function() {
    try {
      var el = document.createElement('div');
      el.innerHTML = "<link />";
      var isBuggy = (el.childNodes.length === 0);
      el = null;
      return isBuggy;
    } catch(e) {
      return true;
    }
  })();

  var ANY_INNERHTML_BUGGY = SELECT_ELEMENT_INNERHTML_BUGGY ||
   TABLE_ELEMENT_INNERHTML_BUGGY || LINK_ELEMENT_INNERHTML_BUGGY;

  var SCRIPT_ELEMENT_REJECTS_TEXTNODE_APPENDING = (function () {
    var s = document.createElement("script"),
        isBuggy = false;
    try {
      s.appendChild(document.createTextNode(""));
      isBuggy = !s.firstChild ||
        s.firstChild && s.firstChild.nodeType !== 3;
    } catch (e) {
      isBuggy = true;
    }
    s = null;
    return isBuggy;
  })();

  function update(element, content) {
    element = $(element);

    var descendants = element.getElementsByTagName('*'),
     i = descendants.length;
    while (i--) purgeElement(descendants[i]);

    if (content && content.toElement)
      content = content.toElement();

    if (Object.isElement(content))
      return element.update().insert(content);


    content = Object.toHTML(content);
    var tagName = element.tagName.toUpperCase();

    if (tagName === 'SCRIPT' && SCRIPT_ELEMENT_REJECTS_TEXTNODE_APPENDING) {
      element.text = content;
      return element;
    }

    if (ANY_INNERHTML_BUGGY) {
      if (tagName in INSERTION_TRANSLATIONS.tags) {
        while (element.firstChild)
          element.removeChild(element.firstChild);

        var nodes = getContentFromAnonymousElement(tagName, content.stripScripts());
        for (var i = 0, node; node = nodes[i]; i++)
          element.appendChild(node);

      } else if (LINK_ELEMENT_INNERHTML_BUGGY && Object.isString(content) && content.indexOf('<link') > -1) {
        while (element.firstChild)
          element.removeChild(element.firstChild);

        var nodes = getContentFromAnonymousElement(tagName,
         content.stripScripts(), true);

        for (var i = 0, node; node = nodes[i]; i++)
          element.appendChild(node);
      } else {
        element.innerHTML = content.stripScripts();
      }
    } else {
      element.innerHTML = content.stripScripts();
    }

    content.evalScripts.bind(content).defer();
    return element;
  }

  function replace(element, content) {
    element = $(element);

    if (content && content.toElement) {
      content = content.toElement();
    } else if (!Object.isElement(content)) {
      content = Object.toHTML(content);
      var range = element.ownerDocument.createRange();
      range.selectNode(element);
      content.evalScripts.bind(content).defer();
      content = range.createContextualFragment(content.stripScripts());
    }

    element.parentNode.replaceChild(content, element);
    return element;
  }

  var INSERTION_TRANSLATIONS = {
    before: function(element, node) {
      element.parentNode.insertBefore(node, element);
    },
    top: function(element, node) {
      element.insertBefore(node, element.firstChild);
    },
    bottom: function(element, node) {
      element.appendChild(node);
    },
    after: function(element, node) {
      element.parentNode.insertBefore(node, element.nextSibling);
    },

    tags: {
      TABLE:  ['<table>',                '</table>',                   1],
      TBODY:  ['<table><tbody>',         '</tbody></table>',           2],
      TR:     ['<table><tbody><tr>',     '</tr></tbody></table>',      3],
      TD:     ['<table><tbody><tr><td>', '</td></tr></tbody></table>', 4],
      SELECT: ['<select>',               '</select>',                  1]
    }
  };

  var tags = INSERTION_TRANSLATIONS.tags;

  Object.extend(tags, {
    THEAD: tags.TBODY,
    TFOOT: tags.TBODY,
    TH:    tags.TD
  });

  function replace_IE(element, content) {
    element = $(element);
    if (content && content.toElement)
      content = content.toElement();
    if (Object.isElement(content)) {
      element.parentNode.replaceChild(content, element);
      return element;
    }

    content = Object.toHTML(content);
    var parent = element.parentNode, tagName = parent.tagName.toUpperCase();

    if (tagName in INSERTION_TRANSLATIONS.tags) {
      var nextSibling = Element.next(element);
      var fragments = getContentFromAnonymousElement(
       tagName, content.stripScripts());

      parent.removeChild(element);

      var iterator;
      if (nextSibling)
        iterator = function(node) { parent.insertBefore(node, nextSibling) };
      else
        iterator = function(node) { parent.appendChild(node); }

      fragments.each(iterator);
    } else {
      element.outerHTML = content.stripScripts();
    }

    content.evalScripts.bind(content).defer();
    return element;
  }

  if ('outerHTML' in document.documentElement)
    replace = replace_IE;

  function isContent(content) {
    if (Object.isUndefined(content) || content === null) return false;

    if (Object.isString(content) || Object.isNumber(content)) return true;
    if (Object.isElement(content)) return true;
    if (content.toElement || content.toHTML) return true;

    return false;
  }

  function insertContentAt(element, content, position) {
    position   = position.toLowerCase();
    var method = INSERTION_TRANSLATIONS[position];

    if (content && content.toElement) content = content.toElement();
    if (Object.isElement(content)) {
      method(element, content);
      return element;
    }

    content = Object.toHTML(content);
    var tagName = ((position === 'before' || position === 'after') ?
     element.parentNode : element).tagName.toUpperCase();

    var childNodes = getContentFromAnonymousElement(tagName, content.stripScripts());

    if (position === 'top' || position === 'after') childNodes.reverse();

    for (var i = 0, node; node = childNodes[i]; i++)
      method(element, node);

    content.evalScripts.bind(content).defer();
  }

  function insert(element, insertions) {
    element = $(element);

    if (isContent(insertions))
      insertions = { bottom: insertions };

    for (var position in insertions)
      insertContentAt(element, insertions[position], position);

    return element;
  }

  function wrap(element, wrapper, attributes) {
    element = $(element);

    if (Object.isElement(wrapper)) {
      $(wrapper).writeAttribute(attributes || {});
    } else if (Object.isString(wrapper)) {
      wrapper = new Element(wrapper, attributes);
    } else {
      wrapper = new Element('div', wrapper);
    }

    if (element.parentNode)
      element.parentNode.replaceChild(wrapper, element);

    wrapper.appendChild(element);

    return wrapper;
  }

  function cleanWhitespace(element) {
    element = $(element);
    var node = element.firstChild;

    while (node) {
      var nextNode = node.nextSibling;
      if (node.nodeType === Node.TEXT_NODE && !/\S/.test(node.nodeValue))
        element.removeChild(node);
      node = nextNode;
    }
    return element;
  }

  function empty(element) {
    return $(element).innerHTML.blank();
  }

  function getContentFromAnonymousElement(tagName, html, force) {
    var t = INSERTION_TRANSLATIONS.tags[tagName], div = DIV;

    var workaround = !!t;
    if (!workaround && force) {
      workaround = true;
      t = ['', '', 0];
    }

    if (workaround) {
      div.innerHTML = '&#160;' + t[0] + html + t[1];
      div.removeChild(div.firstChild);
      for (var i = t[2]; i--; )
        div = div.firstChild;
    } else {
      div.innerHTML = html;
    }

    return $A(div.childNodes);
  }

  function clone(element, deep) {
    if (!(element = $(element))) return;
    var clone = element.cloneNode(deep);
    if (!HAS_UNIQUE_ID_PROPERTY) {
      clone._prototypeUID = UNDEFINED;
      if (deep) {
        var descendants = Element.select(clone, '*'),
         i = descendants.length;
        while (i--)
          descendants[i]._prototypeUID = UNDEFINED;
      }
    }
    return Element.extend(clone);
  }

  function purgeElement(element) {
    var uid = getUniqueElementID(element);
    if (uid) {
      Element.stopObserving(element);
      if (!HAS_UNIQUE_ID_PROPERTY)
        element._prototypeUID = UNDEFINED;
      delete Element.Storage[uid];
    }
  }

  function purgeCollection(elements) {
    var i = elements.length;
    while (i--)
      purgeElement(elements[i]);
  }

  function purgeCollection_IE(elements) {
    var i = elements.length, element, uid;
    while (i--) {
      element = elements[i];
      uid = getUniqueElementID(element);
      delete Element.Storage[uid];
      delete Event.cache[uid];
    }
  }

  if (HAS_UNIQUE_ID_PROPERTY) {
    purgeCollection = purgeCollection_IE;
  }


  function purge(element) {
    if (!(element = $(element))) return;
    purgeElement(element);

    var descendants = element.getElementsByTagName('*'),
     i = descendants.length;

    while (i--) purgeElement(descendants[i]);

    return null;
  }

  Object.extend(methods, {
    remove:  remove,
    update:  update,
    replace: replace,
    insert:  insert,
    wrap:    wrap,
    cleanWhitespace: cleanWhitespace,
    empty:   empty,
    clone:   clone,
    purge:   purge
  });



  function recursivelyCollect(element, property, maximumLength) {
    element = $(element);
    maximumLength = maximumLength || -1;
    var elements = [];

    while (element = element[property]) {
      if (element.nodeType === Node.ELEMENT_NODE)
        elements.push(Element.extend(element));

      if (elements.length === maximumLength) break;
    }

    return elements;
  }


  function ancestors(element) {
    return recursivelyCollect(element, 'parentNode');
  }

  function descendants(element) {
    return Element.select(element, '*');
  }

  function firstDescendant(element) {
    element = $(element).firstChild;
    while (element && element.nodeType !== Node.ELEMENT_NODE)
      element = element.nextSibling;

    return $(element);
  }

  function immediateDescendants(element) {
    var results = [], child = $(element).firstChild;

    while (child) {
      if (child.nodeType === Node.ELEMENT_NODE)
        results.push(Element.extend(child));

      child = child.nextSibling;
    }

    return results;
  }

  function previousSiblings(element) {
    return recursivelyCollect(element, 'previousSibling');
  }

  function nextSiblings(element) {
    return recursivelyCollect(element, 'nextSibling');
  }

  function siblings(element) {
    element = $(element);
    var previous = previousSiblings(element),
     next = nextSiblings(element);
    return previous.reverse().concat(next);
  }

  function match(element, selector) {
    element = $(element);

    if (Object.isString(selector))
      return Prototype.Selector.match(element, selector);

    return selector.match(element);
  }


  function _recursivelyFind(element, property, expression, index) {
    element = $(element), expression = expression || 0, index = index || 0;
    if (Object.isNumber(expression)) {
      index = expression, expression = null;
    }

    while (element = element[property]) {
      if (element.nodeType !== 1) continue;
      if (expression && !Prototype.Selector.match(element, expression))
        continue;
      if (--index >= 0) continue;

      return Element.extend(element);
    }
  }


  function up(element, expression, index) {
    element = $(element);

    if (arguments.length === 1) return $(element.parentNode);
    return _recursivelyFind(element, 'parentNode', expression, index);
  }

  function down(element, expression, index) {
    element = $(element), expression = expression || 0, index = index || 0;

    if (Object.isNumber(expression))
      index = expression, expression = '*';

    var node = Prototype.Selector.select(expression, element)[index];
    return Element.extend(node);
  }

  function previous(element, expression, index) {
    return _recursivelyFind(element, 'previousSibling', expression, index);
  }

  function next(element, expression, index) {
    return _recursivelyFind(element, 'nextSibling', expression, index);
  }

  function select(element) {
    element = $(element);
    var expressions = SLICE.call(arguments, 1).join(', ');
    return Prototype.Selector.select(expressions, element);
  }

  function adjacent(element) {
    element = $(element);
    var expressions = SLICE.call(arguments, 1).join(', ');
    var siblings = Element.siblings(element), results = [];
    for (var i = 0, sibling; sibling = siblings[i]; i++) {
      if (Prototype.Selector.match(sibling, expressions))
        results.push(sibling);
    }

    return results;
  }

  function descendantOf_DOM(element, ancestor) {
    element = $(element), ancestor = $(ancestor);
    while (element = element.parentNode)
      if (element === ancestor) return true;
    return false;
  }

  function descendantOf_contains(element, ancestor) {
    element = $(element), ancestor = $(ancestor);
    if (!ancestor.contains) return descendantOf_DOM(element, ancestor);
    return ancestor.contains(element) && ancestor !== element;
  }

  function descendantOf_compareDocumentPosition(element, ancestor) {
    element = $(element), ancestor = $(ancestor);
    return (element.compareDocumentPosition(ancestor) & 8) === 8;
  }

  var descendantOf;
  if (DIV.compareDocumentPosition) {
    descendantOf = descendantOf_compareDocumentPosition;
  } else if (DIV.contains) {
    descendantOf = descendantOf_contains;
  } else {
    descendantOf = descendantOf_DOM;
  }


  Object.extend(methods, {
    recursivelyCollect:   recursivelyCollect,
    ancestors:            ancestors,
    descendants:          descendants,
    firstDescendant:      firstDescendant,
    immediateDescendants: immediateDescendants,
    previousSiblings:     previousSiblings,
    nextSiblings:         nextSiblings,
    siblings:             siblings,
    match:                match,
    up:                   up,
    down:                 down,
    previous:             previous,
    next:                 next,
    select:               select,
    adjacent:             adjacent,
    descendantOf:         descendantOf,

    getElementsBySelector: select,

    childElements:         immediateDescendants
  });


  var idCounter = 1;
  function identify(element) {
    element = $(element);
    var id = Element.readAttribute(element, 'id');
    if (id) return id;

    do { id = 'anonymous_element_' + idCounter++ } while ($(id));

    Element.writeAttribute(element, 'id', id);
    return id;
  }


  function readAttribute(element, name) {
    return $(element).getAttribute(name);
  }

  function readAttribute_IE(element, name) {
    element = $(element);

    var table = ATTRIBUTE_TRANSLATIONS.read;
    if (table.values[name])
      return table.values[name](element, name);

    if (table.names[name]) name = table.names[name];

    if (name.include(':')) {
      if (!element.attributes || !element.attributes[name]) return null;
      return element.attributes[name].value;
    }

    return element.getAttribute(name);
  }

  function readAttribute_Opera(element, name) {
    if (name === 'title') return element.title;
    return element.getAttribute(name);
  }

  var PROBLEMATIC_ATTRIBUTE_READING = (function() {
    DIV.setAttribute('onclick', Prototype.emptyFunction);
    var value = DIV.getAttribute('onclick');
    var isFunction = (typeof value === 'function');
    DIV.removeAttribute('onclick');
    return isFunction;
  })();

  if (PROBLEMATIC_ATTRIBUTE_READING) {
    readAttribute = readAttribute_IE;
  } else if (Prototype.Browser.Opera) {
    readAttribute = readAttribute_Opera;
  }


  function writeAttribute(element, name, value) {
    element = $(element);
    var attributes = {}, table = ATTRIBUTE_TRANSLATIONS.write;

    if (typeof name === 'object') {
      attributes = name;
    } else {
      attributes[name] = Object.isUndefined(value) ? true : value;
    }

    for (var attr in attributes) {
      name = table.names[attr] || attr;
      value = attributes[attr];
      if (table.values[attr])
        name = table.values[attr](element, value);
      if (value === false || value === null)
        element.removeAttribute(name);
      else if (value === true)
        element.setAttribute(name, name);
      else element.setAttribute(name, value);
    }

    return element;
  }

  function hasAttribute(element, attribute) {
    attribute = ATTRIBUTE_TRANSLATIONS.has[attribute] || attribute;
    var node = $(element).getAttributeNode(attribute);
    return !!(node && node.specified);
  }

  GLOBAL.Element.Methods.Simulated.hasAttribute = hasAttribute;

  function classNames(element) {
    return new Element.ClassNames(element);
  }

  var regExpCache = {};
  function getRegExpForClassName(className) {
    if (regExpCache[className]) return regExpCache[className];

    var re = new RegExp("(^|\\s+)" + className + "(\\s+|$)");
    regExpCache[className] = re;
    return re;
  }

  function hasClassName(element, className) {
    if (!(element = $(element))) return;

    var elementClassName = element.className;

    if (elementClassName.length === 0) return false;
    if (elementClassName === className) return true;

    return getRegExpForClassName(className).test(elementClassName);
  }

  function addClassName(element, className) {
    if (!(element = $(element))) return;

    if (!hasClassName(element, className))
      element.className += (element.className ? ' ' : '') + className;

    return element;
  }

  function removeClassName(element, className) {
    if (!(element = $(element))) return;

    element.className = element.className.replace(
     getRegExpForClassName(className), ' ').strip();

    return element;
  }

  function toggleClassName(element, className, bool) {
    if (!(element = $(element))) return;

    if (Object.isUndefined(bool))
      bool = !hasClassName(element, className);

    var method = Element[bool ? 'addClassName' : 'removeClassName'];
    return method(element, className);
  }

  var ATTRIBUTE_TRANSLATIONS = {};

  var classProp = 'className', forProp = 'for';

  DIV.setAttribute(classProp, 'x');
  if (DIV.className !== 'x') {
    DIV.setAttribute('class', 'x');
    if (DIV.className === 'x')
      classProp = 'class';
  }

  var LABEL = document.createElement('label');
  LABEL.setAttribute(forProp, 'x');
  if (LABEL.htmlFor !== 'x') {
    LABEL.setAttribute('htmlFor', 'x');
    if (LABEL.htmlFor === 'x')
      forProp = 'htmlFor';
  }
  LABEL = null;

  function _getAttr(element, attribute) {
    return element.getAttribute(attribute);
  }

  function _getAttr2(element, attribute) {
    return element.getAttribute(attribute, 2);
  }

  function _getAttrNode(element, attribute) {
    var node = element.getAttributeNode(attribute);
    return node ? node.value : '';
  }

  function _getFlag(element, attribute) {
    return $(element).hasAttribute(attribute) ? attribute : null;
  }

  DIV.onclick = Prototype.emptyFunction;
  var onclickValue = DIV.getAttribute('onclick');

  var _getEv;

  if (String(onclickValue).indexOf('{') > -1) {
    _getEv = function(element, attribute) {
      var value = element.getAttribute(attribute);
      if (!value) return null;
      value = value.toString();
      value = value.split('{')[1];
      value = value.split('}')[0];
      return value.strip();
    };
  }
  else if (onclickValue === '') {
    _getEv = function(element, attribute) {
      var value = element.getAttribute(attribute);
      if (!value) return null;
      return value.strip();
    };
  }

  ATTRIBUTE_TRANSLATIONS.read = {
    names: {
      'class':     classProp,
      'className': classProp,
      'for':       forProp,
      'htmlFor':   forProp
    },

    values: {
      style: function(element) {
        return element.style.cssText.toLowerCase();
      },
      title: function(element) {
        return element.title;
      }
    }
  };

  ATTRIBUTE_TRANSLATIONS.write = {
    names: {
      className:   'class',
      htmlFor:     'for',
      cellpadding: 'cellPadding',
      cellspacing: 'cellSpacing'
    },

    values: {
      checked: function(element, value) {
        element.checked = !!value;
      },

      style: function(element, value) {
        element.style.cssText = value ? value : '';
      }
    }
  };

  ATTRIBUTE_TRANSLATIONS.has = { names: {} };

  Object.extend(ATTRIBUTE_TRANSLATIONS.write.names,
   ATTRIBUTE_TRANSLATIONS.read.names);

  var CAMEL_CASED_ATTRIBUTE_NAMES = $w('colSpan rowSpan vAlign dateTime ' +
   'accessKey tabIndex encType maxLength readOnly longDesc frameBorder');

  for (var i = 0, attr; attr = CAMEL_CASED_ATTRIBUTE_NAMES[i]; i++) {
    ATTRIBUTE_TRANSLATIONS.write.names[attr.toLowerCase()] = attr;
    ATTRIBUTE_TRANSLATIONS.has.names[attr.toLowerCase()]   = attr;
  }

  Object.extend(ATTRIBUTE_TRANSLATIONS.read.values, {
    href:        _getAttr2,
    src:         _getAttr2,
    type:        _getAttr,
    action:      _getAttrNode,
    disabled:    _getFlag,
    checked:     _getFlag,
    readonly:    _getFlag,
    multiple:    _getFlag,
    onload:      _getEv,
    onunload:    _getEv,
    onclick:     _getEv,
    ondblclick:  _getEv,
    onmousedown: _getEv,
    onmouseup:   _getEv,
    onmouseover: _getEv,
    onmousemove: _getEv,
    onmouseout:  _getEv,
    onfocus:     _getEv,
    onblur:      _getEv,
    onkeypress:  _getEv,
    onkeydown:   _getEv,
    onkeyup:     _getEv,
    onsubmit:    _getEv,
    onreset:     _getEv,
    onselect:    _getEv,
    onchange:    _getEv
  });


  Object.extend(methods, {
    identify:        identify,
    readAttribute:   readAttribute,
    writeAttribute:  writeAttribute,
    classNames:      classNames,
    hasClassName:    hasClassName,
    addClassName:    addClassName,
    removeClassName: removeClassName,
    toggleClassName: toggleClassName
  });


  function normalizeStyleName(style) {
    if (style === 'float' || style === 'styleFloat')
      return 'cssFloat';
    return style.camelize();
  }

  function normalizeStyleName_IE(style) {
    if (style === 'float' || style === 'cssFloat')
      return 'styleFloat';
    return style.camelize();
  }

  function setStyle(element, styles) {
    element = $(element);
    var elementStyle = element.style, match;

    if (Object.isString(styles)) {
      elementStyle.cssText += ';' + styles;
      if (styles.include('opacity')) {
        var opacity = styles.match(/opacity:\s*(\d?\.?\d*)/)[1];
        Element.setOpacity(element, opacity);
      }
      return element;
    }

    for (var property in styles) {
      if (property === 'opacity') {
        Element.setOpacity(element, styles[property]);
      } else {
        var value = styles[property];
        if (property === 'float' || property === 'cssFloat') {
          property = Object.isUndefined(elementStyle.styleFloat) ?
           'cssFloat' : 'styleFloat';
        }
        elementStyle[property] = value;
      }
    }

    return element;
  }


  function getStyle(element, style) {
    element = $(element);
    style = normalizeStyleName(style);

    var value = element.style[style];
    if (!value || value === 'auto') {
      var css = document.defaultView.getComputedStyle(element, null);
      value = css ? css[style] : null;
    }

    if (style === 'opacity') return value ? parseFloat(value) : 1.0;
    return value === 'auto' ? null : value;
  }

  function getStyle_Opera(element, style) {
    switch (style) {
      case 'height': case 'width':
        if (!Element.visible(element)) return null;

        var dim = parseInt(getStyle(element, style), 10);

        if (dim !== element['offset' + style.capitalize()])
          return dim + 'px';

        return Element.measure(element, style);

      default: return getStyle(element, style);
    }
  }

  function getStyle_IE(element, style) {
    element = $(element);
    style = normalizeStyleName_IE(style);

    var value = element.style[style];
    if (!value && element.currentStyle) {
      value = element.currentStyle[style];
    }

    if (style === 'opacity' && !STANDARD_CSS_OPACITY_SUPPORTED)
      return getOpacity_IE(element);

    if (value === 'auto') {
      if ((style === 'width' || style === 'height') && Element.visible(element))
        return Element.measure(element, style) + 'px';
      return null;
    }

    return value;
  }

  function stripAlphaFromFilter_IE(filter) {
    return (filter || '').replace(/alpha\([^\)]*\)/gi, '');
  }

  function hasLayout_IE(element) {
    if (!element.currentStyle.hasLayout)
      element.style.zoom = 1;
    return element;
  }

  var STANDARD_CSS_OPACITY_SUPPORTED = (function() {
    DIV.style.cssText = "opacity:.55";
    return /^0.55/.test(DIV.style.opacity);
  })();

  function setOpacity(element, value) {
    element = $(element);
    if (value == 1 || value === '') value = '';
    else if (value < 0.00001) value = 0;
    element.style.opacity = value;
    return element;
  }

  function setOpacity_IE(element, value) {
    if (STANDARD_CSS_OPACITY_SUPPORTED)
      return setOpacity(element, value);

    element = hasLayout_IE($(element));
    var filter = Element.getStyle(element, 'filter'),
     style = element.style;

    if (value == 1 || value === '') {
      filter = stripAlphaFromFilter_IE(filter);
      if (filter) style.filter = filter;
      else style.removeAttribute('filter');
      return element;
    }

    if (value < 0.00001) value = 0;

    style.filter = stripAlphaFromFilter_IE(filter) +
     'alpha(opacity=' + (value * 100) + ')';

    return element;
  }


  function getOpacity(element) {
    return Element.getStyle(element, 'opacity');
  }

  function getOpacity_IE(element) {
    if (STANDARD_CSS_OPACITY_SUPPORTED)
      return getOpacity(element);

    var filter = Element.getStyle(element, 'filter');
    if (filter.length === 0) return 1.0;
    var match = (filter || '').match(/alpha\(opacity=(.*)\)/);
    if (match[1]) return parseFloat(match[1]) / 100;
    return 1.0;
  }


  Object.extend(methods, {
    setStyle:   setStyle,
    getStyle:   getStyle,
    setOpacity: setOpacity,
    getOpacity: getOpacity
  });

  if ('styleFloat' in DIV.style) {
    methods.getStyle = getStyle_IE;
    methods.setOpacity = setOpacity_IE;
    methods.getOpacity = getOpacity_IE;
  }

  var UID = 0;

  GLOBAL.Element.Storage = { UID: 1 };

  function getUniqueElementID(element) {
    if (element === window) return 0;

    if (typeof element._prototypeUID === 'undefined')
      element._prototypeUID = Element.Storage.UID++;
    return element._prototypeUID;
  }

  function getUniqueElementID_IE(element) {
    if (element === window) return 0;
    if (element == document) return 1;
    return element.uniqueID;
  }

  var HAS_UNIQUE_ID_PROPERTY = ('uniqueID' in DIV);
  if (HAS_UNIQUE_ID_PROPERTY)
    getUniqueElementID = getUniqueElementID_IE;

  function getStorage(element) {
    if (!(element = $(element))) return;

    var uid = getUniqueElementID(element);

    if (!Element.Storage[uid])
      Element.Storage[uid] = $H();

    return Element.Storage[uid];
  }

  function store(element, key, value) {
    if (!(element = $(element))) return;
    var storage = getStorage(element);
    if (arguments.length === 2) {
      storage.update(key);
    } else {
      storage.set(key, value);
    }
    return element;
  }

  function retrieve(element, key, defaultValue) {
    if (!(element = $(element))) return;
    var storage = getStorage(element), value = storage.get(key);

    if (Object.isUndefined(value)) {
      storage.set(key, defaultValue);
      value = defaultValue;
    }

    return value;
  }


  Object.extend(methods, {
    getStorage: getStorage,
    store:      store,
    retrieve:   retrieve
  });


  var Methods = {}, ByTag = Element.Methods.ByTag,
   F = Prototype.BrowserFeatures;

  if (!F.ElementExtensions && ('__proto__' in DIV)) {
    GLOBAL.HTMLElement = {};
    GLOBAL.HTMLElement.prototype = DIV['__proto__'];
    F.ElementExtensions = true;
  }

  function checkElementPrototypeDeficiency(tagName) {
    if (typeof window.Element === 'undefined') return false;
    var proto = window.Element.prototype;
    if (proto) {
      var id = '_' + (Math.random() + '').slice(2),
       el = document.createElement(tagName);
      proto[id] = 'x';
      var isBuggy = (el[id] !== 'x');
      delete proto[id];
      el = null;
      return isBuggy;
    }

    return false;
  }

  var HTMLOBJECTELEMENT_PROTOTYPE_BUGGY =
   checkElementPrototypeDeficiency('object');

  function extendElementWith(element, methods) {
    for (var property in methods) {
      var value = methods[property];
      if (Object.isFunction(value) && !(property in element))
        element[property] = value.methodize();
    }
  }

  var EXTENDED = {};
  function elementIsExtended(element) {
    var uid = getUniqueElementID(element);
    return (uid in EXTENDED);
  }

  function extend(element) {
    if (!element || elementIsExtended(element)) return element;
    if (element.nodeType !== Node.ELEMENT_NODE || element == window)
      return element;

    var methods = Object.clone(Methods),
     tagName = element.tagName.toUpperCase();

    if (ByTag[tagName]) Object.extend(methods, ByTag[tagName]);

    extendElementWith(element, methods);
    EXTENDED[getUniqueElementID(element)] = true;
    return element;
  }

  function extend_IE8(element) {
    if (!element || elementIsExtended(element)) return element;

    var t = element.tagName;
    if (t && (/^(?:object|applet|embed)$/i.test(t))) {
      extendElementWith(element, Element.Methods);
      extendElementWith(element, Element.Methods.Simulated);
      extendElementWith(element, Element.Methods.ByTag[t.toUpperCase()]);
    }

    return element;
  }

  if (F.SpecificElementExtensions) {
    extend = HTMLOBJECTELEMENT_PROTOTYPE_BUGGY ? extend_IE8 : Prototype.K;
  }

  function addMethodsToTagName(tagName, methods) {
    tagName = tagName.toUpperCase();
    if (!ByTag[tagName]) ByTag[tagName] = {};
    Object.extend(ByTag[tagName], methods);
  }

  function mergeMethods(destination, methods, onlyIfAbsent) {
    if (Object.isUndefined(onlyIfAbsent)) onlyIfAbsent = false;
    for (var property in methods) {
      var value = methods[property];
      if (!Object.isFunction(value)) continue;
      if (!onlyIfAbsent || !(property in destination))
        destination[property] = value.methodize();
    }
  }

  function findDOMClass(tagName) {
    var klass;
    var trans = {
      "OPTGROUP": "OptGroup", "TEXTAREA": "TextArea", "P": "Paragraph",
      "FIELDSET": "FieldSet", "UL": "UList", "OL": "OList", "DL": "DList",
      "DIR": "Directory", "H1": "Heading", "H2": "Heading", "H3": "Heading",
      "H4": "Heading", "H5": "Heading", "H6": "Heading", "Q": "Quote",
      "INS": "Mod", "DEL": "Mod", "A": "Anchor", "IMG": "Image", "CAPTION":
      "TableCaption", "COL": "TableCol", "COLGROUP": "TableCol", "THEAD":
      "TableSection", "TFOOT": "TableSection", "TBODY": "TableSection", "TR":
      "TableRow", "TH": "TableCell", "TD": "TableCell", "FRAMESET":
      "FrameSet", "IFRAME": "IFrame"
    };
    if (trans[tagName]) klass = 'HTML' + trans[tagName] + 'Element';
    if (window[klass]) return window[klass];
    klass = 'HTML' + tagName + 'Element';
    if (window[klass]) return window[klass];
    klass = 'HTML' + tagName.capitalize() + 'Element';
    if (window[klass]) return window[klass];

    var element = document.createElement(tagName),
     proto = element['__proto__'] || element.constructor.prototype;

    element = null;
    return proto;
  }

  function addMethods(methods) {
    if (arguments.length === 0) addFormMethods();

    if (arguments.length === 2) {
      var tagName = methods;
      methods = arguments[1];
    }

    if (!tagName) {
      Object.extend(Element.Methods, methods || {});
    } else {
      if (Object.isArray(tagName)) {
        for (var i = 0, tag; tag = tagName[i]; i++)
          addMethodsToTagName(tag, methods);
      } else {
        addMethodsToTagName(tagName, methods);
      }
    }

    var ELEMENT_PROTOTYPE = window.HTMLElement ? HTMLElement.prototype :
     Element.prototype;

    if (F.ElementExtensions) {
      mergeMethods(ELEMENT_PROTOTYPE, Element.Methods);
      mergeMethods(ELEMENT_PROTOTYPE, Element.Methods.Simulated, true);
    }

    if (F.SpecificElementExtensions) {
      for (var tag in Element.Methods.ByTag) {
        var klass = findDOMClass(tag);
        if (Object.isUndefined(klass)) continue;
        mergeMethods(klass.prototype, ByTag[tag]);
      }
    }

    Object.extend(Element, Element.Methods);
    Object.extend(Element, Element.Methods.Simulated);
    delete Element.ByTag;
    delete Element.Simulated;

    Element.extend.refresh();

    ELEMENT_CACHE = {};
  }

  Object.extend(GLOBAL.Element, {
    extend:     extend,
    addMethods: addMethods
  });

  if (extend === Prototype.K) {
    GLOBAL.Element.extend.refresh = Prototype.emptyFunction;
  } else {
    GLOBAL.Element.extend.refresh = function() {
      if (Prototype.BrowserFeatures.ElementExtensions) return;
      Object.extend(Methods, Element.Methods);
      Object.extend(Methods, Element.Methods.Simulated);

      EXTENDED = {};
    };
  }

  function addFormMethods() {
    Object.extend(Form, Form.Methods);
    Object.extend(Form.Element, Form.Element.Methods);
    Object.extend(Element.Methods.ByTag, {
      "FORM":     Object.clone(Form.Methods),
      "INPUT":    Object.clone(Form.Element.Methods),
      "SELECT":   Object.clone(Form.Element.Methods),
      "TEXTAREA": Object.clone(Form.Element.Methods),
      "BUTTON":   Object.clone(Form.Element.Methods)
    });
  }

  Element.addMethods(methods);

})(this);
(function() {

  function toDecimal(pctString) {
    var match = pctString.match(/^(\d+)%?$/i);
    if (!match) return null;
    return (Number(match[1]) / 100);
  }

  function getRawStyle(element, style) {
    element = $(element);

    var value = element.style[style];
    if (!value || value === 'auto') {
      var css = document.defaultView.getComputedStyle(element, null);
      value = css ? css[style] : null;
    }

    if (style === 'opacity') return value ? parseFloat(value) : 1.0;
    return value === 'auto' ? null : value;
  }

  function getRawStyle_IE(element, style) {
    var value = element.style[style];
    if (!value && element.currentStyle) {
      value = element.currentStyle[style];
    }
    return value;
  }

  function getContentWidth(element, context) {
    var boxWidth = element.offsetWidth;

    var bl = getPixelValue(element, 'borderLeftWidth',  context) || 0;
    var br = getPixelValue(element, 'borderRightWidth', context) || 0;
    var pl = getPixelValue(element, 'paddingLeft',      context) || 0;
    var pr = getPixelValue(element, 'paddingRight',     context) || 0;

    return boxWidth - bl - br - pl - pr;
  }

  if ('currentStyle' in document.documentElement) {
    getRawStyle = getRawStyle_IE;
  }


  function getPixelValue(value, property, context) {
    var element = null;
    if (Object.isElement(value)) {
      element = value;
      value = getRawStyle(element, property);
    }

    if (value === null || Object.isUndefined(value)) {
      return null;
    }

    if ((/^(?:-)?\d+(\.\d+)?(px)?$/i).test(value)) {
      return window.parseFloat(value);
    }

    var isPercentage = value.include('%'), isViewport = (context === document.viewport);

    if (/\d/.test(value) && element && element.runtimeStyle && !(isPercentage && isViewport)) {
      var style = element.style.left, rStyle = element.runtimeStyle.left;
      element.runtimeStyle.left = element.currentStyle.left;
      element.style.left = value || 0;
      value = element.style.pixelLeft;
      element.style.left = style;
      element.runtimeStyle.left = rStyle;

      return value;
    }

    if (element && isPercentage) {
      context = context || element.parentNode;
      var decimal = toDecimal(value), whole = null;

      var isHorizontal = property.include('left') || property.include('right') ||
       property.include('width');

      var isVertical   = property.include('top') || property.include('bottom') ||
        property.include('height');

      if (context === document.viewport) {
        if (isHorizontal) {
          whole = document.viewport.getWidth();
        } else if (isVertical) {
          whole = document.viewport.getHeight();
        }
      } else {
        if (isHorizontal) {
          whole = $(context).measure('width');
        } else if (isVertical) {
          whole = $(context).measure('height');
        }
      }

      return (whole === null) ? 0 : whole * decimal;
    }

    return 0;
  }

  function toCSSPixels(number) {
    if (Object.isString(number) && number.endsWith('px'))
      return number;
    return number + 'px';
  }

  function isDisplayed(element) {
    while (element && element.parentNode) {
      var display = element.getStyle('display');
      if (display === 'none') {
        return false;
      }
      element = $(element.parentNode);
    }
    return true;
  }

  var hasLayout = Prototype.K;
  if ('currentStyle' in document.documentElement) {
    hasLayout = function(element) {
      if (!element.currentStyle.hasLayout) {
        element.style.zoom = 1;
      }
      return element;
    };
  }

  function cssNameFor(key) {
    if (key.include('border')) key = key + '-width';
    return key.camelize();
  }

  Element.Layout = Class.create(Hash, {
    initialize: function($super, element, preCompute) {
      $super();
      this.element = $(element);

      Element.Layout.PROPERTIES.each( function(property) {
        this._set(property, null);
      }, this);

      if (preCompute) {
        this._preComputing = true;
        this._begin();
        Element.Layout.PROPERTIES.each( this._compute, this );
        this._end();
        this._preComputing = false;
      }
    },

    _set: function(property, value) {
      return Hash.prototype.set.call(this, property, value);
    },

    set: function(property, value) {
      throw "Properties of Element.Layout are read-only.";
    },

    get: function($super, property) {
      var value = $super(property);
      return value === null ? this._compute(property) : value;
    },

    _begin: function() {
      if (this._isPrepared()) return;

      var element = this.element;
      if (isDisplayed(element)) {
        this._setPrepared(true);
        return;
      }


      var originalStyles = {
        position:   element.style.position   || '',
        width:      element.style.width      || '',
        visibility: element.style.visibility || '',
        display:    element.style.display    || ''
      };

      element.store('prototype_original_styles', originalStyles);

      var position = getRawStyle(element, 'position'), width = element.offsetWidth;

      if (width === 0 || width === null) {
        element.style.display = 'block';
        width = element.offsetWidth;
      }

      var context = (position === 'fixed') ? document.viewport :
       element.parentNode;

      var tempStyles = {
        visibility: 'hidden',
        display:    'block'
      };

      if (position !== 'fixed') tempStyles.position = 'absolute';

      element.setStyle(tempStyles);

      var positionedWidth = element.offsetWidth, newWidth;
      if (width && (positionedWidth === width)) {
        newWidth = getContentWidth(element, context);
      } else if (position === 'absolute' || position === 'fixed') {
        newWidth = getContentWidth(element, context);
      } else {
        var parent = element.parentNode, pLayout = $(parent).getLayout();

        newWidth = pLayout.get('width') -
         this.get('margin-left') -
         this.get('border-left') -
         this.get('padding-left') -
         this.get('padding-right') -
         this.get('border-right') -
         this.get('margin-right');
      }

      element.setStyle({ width: newWidth + 'px' });

      this._setPrepared(true);
    },

    _end: function() {
      var element = this.element;
      var originalStyles = element.retrieve('prototype_original_styles');
      element.store('prototype_original_styles', null);
      element.setStyle(originalStyles);
      this._setPrepared(false);
    },

    _compute: function(property) {
      var COMPUTATIONS = Element.Layout.COMPUTATIONS;
      if (!(property in COMPUTATIONS)) {
        throw "Property not found.";
      }

      return this._set(property, COMPUTATIONS[property].call(this, this.element));
    },

    _isPrepared: function() {
      return this.element.retrieve('prototype_element_layout_prepared', false);
    },

    _setPrepared: function(bool) {
      return this.element.store('prototype_element_layout_prepared', bool);
    },

    toObject: function() {
      var args = $A(arguments);
      var keys = (args.length === 0) ? Element.Layout.PROPERTIES :
       args.join(' ').split(' ');
      var obj = {};
      keys.each( function(key) {
        if (!Element.Layout.PROPERTIES.include(key)) return;
        var value = this.get(key);
        if (value != null) obj[key] = value;
      }, this);
      return obj;
    },

    toHash: function() {
      var obj = this.toObject.apply(this, arguments);
      return new Hash(obj);
    },

    toCSS: function() {
      var args = $A(arguments);
      var keys = (args.length === 0) ? Element.Layout.PROPERTIES :
       args.join(' ').split(' ');
      var css = {};

      keys.each( function(key) {
        if (!Element.Layout.PROPERTIES.include(key)) return;
        if (Element.Layout.COMPOSITE_PROPERTIES.include(key)) return;

        var value = this.get(key);
        if (value != null) css[cssNameFor(key)] = value + 'px';
      }, this);
      return css;
    },

    inspect: function() {
      return "#<Element.Layout>";
    }
  });

  Object.extend(Element.Layout, {
    PROPERTIES: $w('height width top left right bottom border-left border-right border-top border-bottom padding-left padding-right padding-top padding-bottom margin-top margin-bottom margin-left margin-right padding-box-width padding-box-height border-box-width border-box-height margin-box-width margin-box-height'),

    COMPOSITE_PROPERTIES: $w('padding-box-width padding-box-height margin-box-width margin-box-height border-box-width border-box-height'),

    COMPUTATIONS: {
      'height': function(element) {
        if (!this._preComputing) this._begin();

        var bHeight = this.get('border-box-height');
        if (bHeight <= 0) {
          if (!this._preComputing) this._end();
          return 0;
        }

        var bTop = this.get('border-top'),
         bBottom = this.get('border-bottom');

        var pTop = this.get('padding-top'),
         pBottom = this.get('padding-bottom');

        if (!this._preComputing) this._end();

        return bHeight - bTop - bBottom - pTop - pBottom;
      },

      'width': function(element) {
        if (!this._preComputing) this._begin();

        var bWidth = this.get('border-box-width');
        if (bWidth <= 0) {
          if (!this._preComputing) this._end();
          return 0;
        }

        var bLeft = this.get('border-left'),
         bRight = this.get('border-right');

        var pLeft = this.get('padding-left'),
         pRight = this.get('padding-right');

        if (!this._preComputing) this._end();
        return bWidth - bLeft - bRight - pLeft - pRight;
      },

      'padding-box-height': function(element) {
        var height = this.get('height'),
         pTop = this.get('padding-top'),
         pBottom = this.get('padding-bottom');

        return height + pTop + pBottom;
      },

      'padding-box-width': function(element) {
        var width = this.get('width'),
         pLeft = this.get('padding-left'),
         pRight = this.get('padding-right');

        return width + pLeft + pRight;
      },

      'border-box-height': function(element) {
        if (!this._preComputing) this._begin();
        var height = element.offsetHeight;
        if (!this._preComputing) this._end();
        return height;
      },

      'border-box-width': function(element) {
        if (!this._preComputing) this._begin();
        var width = element.offsetWidth;
        if (!this._preComputing) this._end();
        return width;
      },

      'margin-box-height': function(element) {
        var bHeight = this.get('border-box-height'),
         mTop = this.get('margin-top'),
         mBottom = this.get('margin-bottom');

        if (bHeight <= 0) return 0;

        return bHeight + mTop + mBottom;
      },

      'margin-box-width': function(element) {
        var bWidth = this.get('border-box-width'),
         mLeft = this.get('margin-left'),
         mRight = this.get('margin-right');

        if (bWidth <= 0) return 0;

        return bWidth + mLeft + mRight;
      },

      'top': function(element) {
        var offset = element.positionedOffset();
        return offset.top;
      },

      'bottom': function(element) {
        var offset = element.positionedOffset(),
         parent = element.getOffsetParent(),
         pHeight = parent.measure('height');

        var mHeight = this.get('border-box-height');

        return pHeight - mHeight - offset.top;
      },

      'left': function(element) {
        var offset = element.positionedOffset();
        return offset.left;
      },

      'right': function(element) {
        var offset = element.positionedOffset(),
         parent = element.getOffsetParent(),
         pWidth = parent.measure('width');

        var mWidth = this.get('border-box-width');

        return pWidth - mWidth - offset.left;
      },

      'padding-top': function(element) {
        return getPixelValue(element, 'paddingTop');
      },

      'padding-bottom': function(element) {
        return getPixelValue(element, 'paddingBottom');
      },

      'padding-left': function(element) {
        return getPixelValue(element, 'paddingLeft');
      },

      'padding-right': function(element) {
        return getPixelValue(element, 'paddingRight');
      },

      'border-top': function(element) {
        return getPixelValue(element, 'borderTopWidth');
      },

      'border-bottom': function(element) {
        return getPixelValue(element, 'borderBottomWidth');
      },

      'border-left': function(element) {
        return getPixelValue(element, 'borderLeftWidth');
      },

      'border-right': function(element) {
        return getPixelValue(element, 'borderRightWidth');
      },

      'margin-top': function(element) {
        return getPixelValue(element, 'marginTop');
      },

      'margin-bottom': function(element) {
        return getPixelValue(element, 'marginBottom');
      },

      'margin-left': function(element) {
        return getPixelValue(element, 'marginLeft');
      },

      'margin-right': function(element) {
        return getPixelValue(element, 'marginRight');
      }
    }
  });

  if ('getBoundingClientRect' in document.documentElement) {
    Object.extend(Element.Layout.COMPUTATIONS, {
      'right': function(element) {
        var parent = hasLayout(element.getOffsetParent());
        var rect = element.getBoundingClientRect(),
         pRect = parent.getBoundingClientRect();

        return (pRect.right - rect.right).round();
      },

      'bottom': function(element) {
        var parent = hasLayout(element.getOffsetParent());
        var rect = element.getBoundingClientRect(),
         pRect = parent.getBoundingClientRect();

        return (pRect.bottom - rect.bottom).round();
      }
    });
  }

  Element.Offset = Class.create({
    initialize: function(left, top) {
      this.left = left.round();
      this.top  = top.round();

      this[0] = this.left;
      this[1] = this.top;
    },

    relativeTo: function(offset) {
      return new Element.Offset(
        this.left - offset.left,
        this.top  - offset.top
      );
    },

    inspect: function() {
      return "#<Element.Offset left: #{left} top: #{top}>".interpolate(this);
    },

    toString: function() {
      return "[#{left}, #{top}]".interpolate(this);
    },

    toArray: function() {
      return [this.left, this.top];
    }
  });

  function getLayout(element, preCompute) {
    return new Element.Layout(element, preCompute);
  }

  function measure(element, property) {
    return $(element).getLayout().get(property);
  }

  function getHeight(element) {
    return Element.getDimensions(element).height;
  }

  function getWidth(element) {
    return Element.getDimensions(element).width;
  }

  function getDimensions(element) {
    element = $(element);
    var display = Element.getStyle(element, 'display');

    if (display && display !== 'none') {
      return { width: element.offsetWidth, height: element.offsetHeight };
    }

    var style = element.style;
    var originalStyles = {
      visibility: style.visibility,
      position:   style.position,
      display:    style.display
    };

    var newStyles = {
      visibility: 'hidden',
      display:    'block'
    };

    if (originalStyles.position !== 'fixed')
      newStyles.position = 'absolute';

    Element.setStyle(element, newStyles);

    var dimensions = {
      width:  element.offsetWidth,
      height: element.offsetHeight
    };

    Element.setStyle(element, originalStyles);

    return dimensions;
  }

  function getOffsetParent(element) {
    element = $(element);

    if (isDocument(element) || isDetached(element) || isBody(element) || isHtml(element))
      return $(document.body);

    var isInline = (Element.getStyle(element, 'display') === 'inline');
    if (!isInline && element.offsetParent) return $(element.offsetParent);

    while ((element = element.parentNode) && element !== document.body) {
      if (Element.getStyle(element, 'position') !== 'static') {
        return isHtml(element) ? $(document.body) : $(element);
      }
    }

    return $(document.body);
  }


  function cumulativeOffset(element) {
    element = $(element);
    var valueT = 0, valueL = 0;
    if (element.parentNode) {
      do {
        valueT += element.offsetTop  || 0;
        valueL += element.offsetLeft || 0;
        element = element.offsetParent;
      } while (element);
    }
    return new Element.Offset(valueL, valueT);
  }

  function positionedOffset(element) {
    element = $(element);

    var layout = element.getLayout();

    var valueT = 0, valueL = 0;
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;
      element = element.offsetParent;
      if (element) {
        if (isBody(element)) break;
        var p = Element.getStyle(element, 'position');
        if (p !== 'static') break;
      }
    } while (element);

    valueL -= layout.get('margin-top');
    valueT -= layout.get('margin-left');

    return new Element.Offset(valueL, valueT);
  }

  function cumulativeScrollOffset(element) {
    var valueT = 0, valueL = 0;
    do {
      valueT += element.scrollTop  || 0;
      valueL += element.scrollLeft || 0;
      element = element.parentNode;
    } while (element);
    return new Element.Offset(valueL, valueT);
  }

  function viewportOffset(forElement) {
    var valueT = 0, valueL = 0, docBody = document.body;

    var element = $(forElement);
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;
      if (element.offsetParent == docBody &&
        Element.getStyle(element, 'position') == 'absolute') break;
    } while (element = element.offsetParent);

    element = forElement;
    do {
      if (element != docBody) {
        valueT -= element.scrollTop  || 0;
        valueL -= element.scrollLeft || 0;
      }
    } while (element = element.parentNode);
    return new Element.Offset(valueL, valueT);
  }

  function absolutize(element) {
    element = $(element);

    if (Element.getStyle(element, 'position') === 'absolute') {
      return element;
    }

    var offsetParent = getOffsetParent(element);
    var eOffset = element.viewportOffset(),
     pOffset = offsetParent.viewportOffset();

    var offset = eOffset.relativeTo(pOffset);
    var layout = element.getLayout();

    element.store('prototype_absolutize_original_styles', {
      left:   element.getStyle('left'),
      top:    element.getStyle('top'),
      width:  element.getStyle('width'),
      height: element.getStyle('height')
    });

    element.setStyle({
      position: 'absolute',
      top:    offset.top + 'px',
      left:   offset.left + 'px',
      width:  layout.get('width') + 'px',
      height: layout.get('height') + 'px'
    });

    return element;
  }

  function relativize(element) {
    element = $(element);
    if (Element.getStyle(element, 'position') === 'relative') {
      return element;
    }

    var originalStyles =
     element.retrieve('prototype_absolutize_original_styles');

    if (originalStyles) element.setStyle(originalStyles);
    return element;
  }


  function scrollTo(element) {
    element = $(element);
    var pos = Element.cumulativeOffset(element);
    window.scrollTo(pos.left, pos.top);
    return element;
  }


  function makePositioned(element) {
    element = $(element);
    var position = Element.getStyle(element, 'position'), styles = {};
    if (position === 'static' || !position) {
      styles.position = 'relative';
      if (Prototype.Browser.Opera) {
        styles.top  = 0;
        styles.left = 0;
      }
      Element.setStyle(element, styles);
      Element.store(element, 'prototype_made_positioned', true);
    }
    return element;
  }

  function undoPositioned(element) {
    element = $(element);
    var storage = Element.getStorage(element),
     madePositioned = storage.get('prototype_made_positioned');

    if (madePositioned) {
      storage.unset('prototype_made_positioned');
      Element.setStyle(element, {
        position: '',
        top:      '',
        bottom:   '',
        left:     '',
        right:    ''
      });
    }
    return element;
  }

  function makeClipping(element) {
    element = $(element);

    var storage = Element.getStorage(element),
     madeClipping = storage.get('prototype_made_clipping');

    if (Object.isUndefined(madeClipping)) {
      var overflow = Element.getStyle(element, 'overflow');
      storage.set('prototype_made_clipping', overflow);
      if (overflow !== 'hidden')
        element.style.overflow = 'hidden';
    }

    return element;
  }

  function undoClipping(element) {
    element = $(element);
    var storage = Element.getStorage(element),
     overflow = storage.get('prototype_made_clipping');

    if (!Object.isUndefined(overflow)) {
      storage.unset('prototype_made_clipping');
      element.style.overflow = overflow || '';
    }

    return element;
  }

  function clonePosition(element, source, options) {
    options = Object.extend({
      setLeft:    true,
      setTop:     true,
      setWidth:   true,
      setHeight:  true,
      offsetTop:  0,
      offsetLeft: 0
    }, options || {});

    source  = $(source);
    element = $(element);
    var p, delta, layout, styles = {};

    if (options.setLeft || options.setTop) {
      p = Element.viewportOffset(source);
      delta = [0, 0];
      if (Element.getStyle(element, 'position') === 'absolute') {
        var parent = Element.getOffsetParent(element);
        if (parent !== document.body) delta = Element.viewportOffset(parent);
      }
    }

    if (options.setWidth || options.setHeight) {
      layout = Element.getLayout(source);
    }

    if (options.setLeft)
      styles.left = (p[0] - delta[0] + options.offsetLeft) + 'px';
    if (options.setTop)
      styles.top  = (p[1] - delta[1] + options.offsetTop)  + 'px';

    if (options.setWidth)
      styles.width  = layout.get('border-box-width')  + 'px';
    if (options.setHeight)
      styles.height = layout.get('border-box-height') + 'px';

    return Element.setStyle(element, styles);
  }


  if (Prototype.Browser.IE) {
    getOffsetParent = getOffsetParent.wrap(
      function(proceed, element) {
        element = $(element);

        if (isDocument(element) || isDetached(element) || isBody(element) || isHtml(element))
          return $(document.body);

        var position = element.getStyle('position');
        if (position !== 'static') return proceed(element);

        element.setStyle({ position: 'relative' });
        var value = proceed(element);
        element.setStyle({ position: position });
        return value;
      }
    );

    positionedOffset = positionedOffset.wrap(function(proceed, element) {
      element = $(element);
      if (!element.parentNode) return new Element.Offset(0, 0);
      var position = element.getStyle('position');
      if (position !== 'static') return proceed(element);

      var offsetParent = element.getOffsetParent();
      if (offsetParent && offsetParent.getStyle('position') === 'fixed')
        hasLayout(offsetParent);

      element.setStyle({ position: 'relative' });
      var value = proceed(element);
      element.setStyle({ position: position });
      return value;
    });
  } else if (Prototype.Browser.Webkit) {
    cumulativeOffset = function(element) {
      element = $(element);
      var valueT = 0, valueL = 0;
      do {
        valueT += element.offsetTop  || 0;
        valueL += element.offsetLeft || 0;
        if (element.offsetParent == document.body) {
          if (Element.getStyle(element, 'position') == 'absolute') break;
        }

        element = element.offsetParent;
      } while (element);

      return new Element.Offset(valueL, valueT);
    };
  }


  Element.addMethods({
    getLayout:              getLayout,
    measure:                measure,
    getWidth:               getWidth,
    getHeight:              getHeight,
    getDimensions:          getDimensions,
    getOffsetParent:        getOffsetParent,
    cumulativeOffset:       cumulativeOffset,
    positionedOffset:       positionedOffset,
    cumulativeScrollOffset: cumulativeScrollOffset,
    viewportOffset:         viewportOffset,
    absolutize:             absolutize,
    relativize:             relativize,
    scrollTo:               scrollTo,
    makePositioned:         makePositioned,
    undoPositioned:         undoPositioned,
    makeClipping:           makeClipping,
    undoClipping:           undoClipping,
    clonePosition:          clonePosition
  });

  function isBody(element) {
    return element.nodeName.toUpperCase() === 'BODY';
  }

  function isHtml(element) {
    return element.nodeName.toUpperCase() === 'HTML';
  }

  function isDocument(element) {
    return element.nodeType === Node.DOCUMENT_NODE;
  }

  function isDetached(element) {
    return element !== document.body &&
     !Element.descendantOf(element, document.body);
  }

  if ('getBoundingClientRect' in document.documentElement) {
    Element.addMethods({
      viewportOffset: function(element) {
        element = $(element);
        if (isDetached(element)) return new Element.Offset(0, 0);

        var rect = element.getBoundingClientRect(),
         docEl = document.documentElement;
        return new Element.Offset(rect.left - docEl.clientLeft,
         rect.top - docEl.clientTop);
      }
    });
  }


})();

(function() {

  var IS_OLD_OPERA = Prototype.Browser.Opera &&
   (window.parseFloat(window.opera.version()) < 9.5);
  var ROOT = null;
  function getRootElement() {
    if (ROOT) return ROOT;
    ROOT = IS_OLD_OPERA ? document.body : document.documentElement;
    return ROOT;
  }

  function getDimensions() {
    return { width: this.getWidth(), height: this.getHeight() };
  }

  function getWidth() {
    return getRootElement().clientWidth;
  }

  function getHeight() {
    return getRootElement().clientHeight;
  }

  function getScrollOffsets() {
    var x = window.pageXOffset || document.documentElement.scrollLeft ||
     document.body.scrollLeft;
    var y = window.pageYOffset || document.documentElement.scrollTop ||
     document.body.scrollTop;

    return new Element.Offset(x, y);
  }

  document.viewport = {
    getDimensions:    getDimensions,
    getWidth:         getWidth,
    getHeight:        getHeight,
    getScrollOffsets: getScrollOffsets
  };

})();
window.$$ = function() {
  var expression = $A(arguments).join(', ');
  return Prototype.Selector.select(expression, document);
};

Prototype.Selector = (function() {

  function select() {
    throw new Error('Method "Prototype.Selector.select" must be defined.');
  }

  function match() {
    throw new Error('Method "Prototype.Selector.match" must be defined.');
  }

  function find(elements, expression, index) {
    index = index || 0;
    var match = Prototype.Selector.match, length = elements.length, matchIndex = 0, i;

    for (i = 0; i < length; i++) {
      if (match(elements[i], expression) && index == matchIndex++) {
        return Element.extend(elements[i]);
      }
    }
  }

  function extendElements(elements) {
    for (var i = 0, length = elements.length; i < length; i++) {
      Element.extend(elements[i]);
    }
    return elements;
  }


  var K = Prototype.K;

  return {
    select: select,
    match: match,
    find: find,
    extendElements: (Element.extend === K) ? K : extendElements,
    extendElement: Element.extend
  };
})();
/*!
 * Sizzle CSS Selector Engine
 *  Copyright 2011, The Dojo Foundation
 *  Released under the MIT, BSD, and GPL Licenses.
 *  More information: http://sizzlejs.com/
 */
(function(){

var chunker = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^\[\]]*\]|['"][^'"]*['"]|[^\[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g,
	done = 0,
	toString = Object.prototype.toString,
	hasDuplicate = false,
	baseHasDuplicate = true,
	rBackslash = /\\/g,
	rNonWord = /\W/;

[0, 0].sort(function() {
	baseHasDuplicate = false;
	return 0;
});

var Sizzle = function( selector, context, results, seed ) {
	results = results || [];
	context = context || document;

	var origContext = context;

	if ( context.nodeType !== 1 && context.nodeType !== 9 ) {
		return [];
	}

	if ( !selector || typeof selector !== "string" ) {
		return results;
	}

	var m, set, checkSet, extra, ret, cur, pop, i,
		prune = true,
		contextXML = Sizzle.isXML( context ),
		parts = [],
		soFar = selector;

	do {
		chunker.exec( "" );
		m = chunker.exec( soFar );

		if ( m ) {
			soFar = m[3];

			parts.push( m[1] );

			if ( m[2] ) {
				extra = m[3];
				break;
			}
		}
	} while ( m );

	if ( parts.length > 1 && origPOS.exec( selector ) ) {

		if ( parts.length === 2 && Expr.relative[ parts[0] ] ) {
			set = posProcess( parts[0] + parts[1], context );

		} else {
			set = Expr.relative[ parts[0] ] ?
				[ context ] :
				Sizzle( parts.shift(), context );

			while ( parts.length ) {
				selector = parts.shift();

				if ( Expr.relative[ selector ] ) {
					selector += parts.shift();
				}

				set = posProcess( selector, set );
			}
		}

	} else {
		if ( !seed && parts.length > 1 && context.nodeType === 9 && !contextXML &&
				Expr.match.ID.test(parts[0]) && !Expr.match.ID.test(parts[parts.length - 1]) ) {

			ret = Sizzle.find( parts.shift(), context, contextXML );
			context = ret.expr ?
				Sizzle.filter( ret.expr, ret.set )[0] :
				ret.set[0];
		}

		if ( context ) {
			ret = seed ?
				{ expr: parts.pop(), set: makeArray(seed) } :
				Sizzle.find( parts.pop(), parts.length === 1 && (parts[0] === "~" || parts[0] === "+") && context.parentNode ? context.parentNode : context, contextXML );

			set = ret.expr ?
				Sizzle.filter( ret.expr, ret.set ) :
				ret.set;

			if ( parts.length > 0 ) {
				checkSet = makeArray( set );

			} else {
				prune = false;
			}

			while ( parts.length ) {
				cur = parts.pop();
				pop = cur;

				if ( !Expr.relative[ cur ] ) {
					cur = "";
				} else {
					pop = parts.pop();
				}

				if ( pop == null ) {
					pop = context;
				}

				Expr.relative[ cur ]( checkSet, pop, contextXML );
			}

		} else {
			checkSet = parts = [];
		}
	}

	if ( !checkSet ) {
		checkSet = set;
	}

	if ( !checkSet ) {
		Sizzle.error( cur || selector );
	}

	if ( toString.call(checkSet) === "[object Array]" ) {
		if ( !prune ) {
			results.push.apply( results, checkSet );

		} else if ( context && context.nodeType === 1 ) {
			for ( i = 0; checkSet[i] != null; i++ ) {
				if ( checkSet[i] && (checkSet[i] === true || checkSet[i].nodeType === 1 && Sizzle.contains(context, checkSet[i])) ) {
					results.push( set[i] );
				}
			}

		} else {
			for ( i = 0; checkSet[i] != null; i++ ) {
				if ( checkSet[i] && checkSet[i].nodeType === 1 ) {
					results.push( set[i] );
				}
			}
		}

	} else {
		makeArray( checkSet, results );
	}

	if ( extra ) {
		Sizzle( extra, origContext, results, seed );
		Sizzle.uniqueSort( results );
	}

	return results;
};

Sizzle.uniqueSort = function( results ) {
	if ( sortOrder ) {
		hasDuplicate = baseHasDuplicate;
		results.sort( sortOrder );

		if ( hasDuplicate ) {
			for ( var i = 1; i < results.length; i++ ) {
				if ( results[i] === results[ i - 1 ] ) {
					results.splice( i--, 1 );
				}
			}
		}
	}

	return results;
};

Sizzle.matches = function( expr, set ) {
	return Sizzle( expr, null, null, set );
};

Sizzle.matchesSelector = function( node, expr ) {
	return Sizzle( expr, null, null, [node] ).length > 0;
};

Sizzle.find = function( expr, context, isXML ) {
	var set;

	if ( !expr ) {
		return [];
	}

	for ( var i = 0, l = Expr.order.length; i < l; i++ ) {
		var match,
			type = Expr.order[i];

		if ( (match = Expr.leftMatch[ type ].exec( expr )) ) {
			var left = match[1];
			match.splice( 1, 1 );

			if ( left.substr( left.length - 1 ) !== "\\" ) {
				match[1] = (match[1] || "").replace( rBackslash, "" );
				set = Expr.find[ type ]( match, context, isXML );

				if ( set != null ) {
					expr = expr.replace( Expr.match[ type ], "" );
					break;
				}
			}
		}
	}

	if ( !set ) {
		set = typeof context.getElementsByTagName !== "undefined" ?
			context.getElementsByTagName( "*" ) :
			[];
	}

	return { set: set, expr: expr };
};

Sizzle.filter = function( expr, set, inplace, not ) {
	var match, anyFound,
		old = expr,
		result = [],
		curLoop = set,
		isXMLFilter = set && set[0] && Sizzle.isXML( set[0] );

	while ( expr && set.length ) {
		for ( var type in Expr.filter ) {
			if ( (match = Expr.leftMatch[ type ].exec( expr )) != null && match[2] ) {
				var found, item,
					filter = Expr.filter[ type ],
					left = match[1];

				anyFound = false;

				match.splice(1,1);

				if ( left.substr( left.length - 1 ) === "\\" ) {
					continue;
				}

				if ( curLoop === result ) {
					result = [];
				}

				if ( Expr.preFilter[ type ] ) {
					match = Expr.preFilter[ type ]( match, curLoop, inplace, result, not, isXMLFilter );

					if ( !match ) {
						anyFound = found = true;

					} else if ( match === true ) {
						continue;
					}
				}

				if ( match ) {
					for ( var i = 0; (item = curLoop[i]) != null; i++ ) {
						if ( item ) {
							found = filter( item, match, i, curLoop );
							var pass = not ^ !!found;

							if ( inplace && found != null ) {
								if ( pass ) {
									anyFound = true;

								} else {
									curLoop[i] = false;
								}

							} else if ( pass ) {
								result.push( item );
								anyFound = true;
							}
						}
					}
				}

				if ( found !== undefined ) {
					if ( !inplace ) {
						curLoop = result;
					}

					expr = expr.replace( Expr.match[ type ], "" );

					if ( !anyFound ) {
						return [];
					}

					break;
				}
			}
		}

		if ( expr === old ) {
			if ( anyFound == null ) {
				Sizzle.error( expr );

			} else {
				break;
			}
		}

		old = expr;
	}

	return curLoop;
};

Sizzle.error = function( msg ) {
	throw "Syntax error, unrecognized expression: " + msg;
};

var Expr = Sizzle.selectors = {
	order: [ "ID", "NAME", "TAG" ],

	match: {
		ID: /#((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,
		CLASS: /\.((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,
		NAME: /\[name=['"]*((?:[\w\u00c0-\uFFFF\-]|\\.)+)['"]*\]/,
		ATTR: /\[\s*((?:[\w\u00c0-\uFFFF\-]|\\.)+)\s*(?:(\S?=)\s*(?:(['"])(.*?)\3|(#?(?:[\w\u00c0-\uFFFF\-]|\\.)*)|)|)\s*\]/,
		TAG: /^((?:[\w\u00c0-\uFFFF\*\-]|\\.)+)/,
		CHILD: /:(only|nth|last|first)-child(?:\(\s*(even|odd|(?:[+\-]?\d+|(?:[+\-]?\d*)?n\s*(?:[+\-]\s*\d+)?))\s*\))?/,
		POS: /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^\-]|$)/,
		PSEUDO: /:((?:[\w\u00c0-\uFFFF\-]|\\.)+)(?:\((['"]?)((?:\([^\)]+\)|[^\(\)]*)+)\2\))?/
	},

	leftMatch: {},

	attrMap: {
		"class": "className",
		"for": "htmlFor"
	},

	attrHandle: {
		href: function( elem ) {
			return elem.getAttribute( "href" );
		},
		type: function( elem ) {
			return elem.getAttribute( "type" );
		}
	},

	relative: {
		"+": function(checkSet, part){
			var isPartStr = typeof part === "string",
				isTag = isPartStr && !rNonWord.test( part ),
				isPartStrNotTag = isPartStr && !isTag;

			if ( isTag ) {
				part = part.toLowerCase();
			}

			for ( var i = 0, l = checkSet.length, elem; i < l; i++ ) {
				if ( (elem = checkSet[i]) ) {
					while ( (elem = elem.previousSibling) && elem.nodeType !== 1 ) {}

					checkSet[i] = isPartStrNotTag || elem && elem.nodeName.toLowerCase() === part ?
						elem || false :
						elem === part;
				}
			}

			if ( isPartStrNotTag ) {
				Sizzle.filter( part, checkSet, true );
			}
		},

		">": function( checkSet, part ) {
			var elem,
				isPartStr = typeof part === "string",
				i = 0,
				l = checkSet.length;

			if ( isPartStr && !rNonWord.test( part ) ) {
				part = part.toLowerCase();

				for ( ; i < l; i++ ) {
					elem = checkSet[i];

					if ( elem ) {
						var parent = elem.parentNode;
						checkSet[i] = parent.nodeName.toLowerCase() === part ? parent : false;
					}
				}

			} else {
				for ( ; i < l; i++ ) {
					elem = checkSet[i];

					if ( elem ) {
						checkSet[i] = isPartStr ?
							elem.parentNode :
							elem.parentNode === part;
					}
				}

				if ( isPartStr ) {
					Sizzle.filter( part, checkSet, true );
				}
			}
		},

		"": function(checkSet, part, isXML){
			var nodeCheck,
				doneName = done++,
				checkFn = dirCheck;

			if ( typeof part === "string" && !rNonWord.test( part ) ) {
				part = part.toLowerCase();
				nodeCheck = part;
				checkFn = dirNodeCheck;
			}

			checkFn( "parentNode", part, doneName, checkSet, nodeCheck, isXML );
		},

		"~": function( checkSet, part, isXML ) {
			var nodeCheck,
				doneName = done++,
				checkFn = dirCheck;

			if ( typeof part === "string" && !rNonWord.test( part ) ) {
				part = part.toLowerCase();
				nodeCheck = part;
				checkFn = dirNodeCheck;
			}

			checkFn( "previousSibling", part, doneName, checkSet, nodeCheck, isXML );
		}
	},

	find: {
		ID: function( match, context, isXML ) {
			if ( typeof context.getElementById !== "undefined" && !isXML ) {
				var m = context.getElementById(match[1]);
				return m && m.parentNode ? [m] : [];
			}
		},

		NAME: function( match, context ) {
			if ( typeof context.getElementsByName !== "undefined" ) {
				var ret = [],
					results = context.getElementsByName( match[1] );

				for ( var i = 0, l = results.length; i < l; i++ ) {
					if ( results[i].getAttribute("name") === match[1] ) {
						ret.push( results[i] );
					}
				}

				return ret.length === 0 ? null : ret;
			}
		},

		TAG: function( match, context ) {
			if ( typeof context.getElementsByTagName !== "undefined" ) {
				return context.getElementsByTagName( match[1] );
			}
		}
	},
	preFilter: {
		CLASS: function( match, curLoop, inplace, result, not, isXML ) {
			match = " " + match[1].replace( rBackslash, "" ) + " ";

			if ( isXML ) {
				return match;
			}

			for ( var i = 0, elem; (elem = curLoop[i]) != null; i++ ) {
				if ( elem ) {
					if ( not ^ (elem.className && (" " + elem.className + " ").replace(/[\t\n\r]/g, " ").indexOf(match) >= 0) ) {
						if ( !inplace ) {
							result.push( elem );
						}

					} else if ( inplace ) {
						curLoop[i] = false;
					}
				}
			}

			return false;
		},

		ID: function( match ) {
			return match[1].replace( rBackslash, "" );
		},

		TAG: function( match, curLoop ) {
			return match[1].replace( rBackslash, "" ).toLowerCase();
		},

		CHILD: function( match ) {
			if ( match[1] === "nth" ) {
				if ( !match[2] ) {
					Sizzle.error( match[0] );
				}

				match[2] = match[2].replace(/^\+|\s*/g, '');

				var test = /(-?)(\d*)(?:n([+\-]?\d*))?/.exec(
					match[2] === "even" && "2n" || match[2] === "odd" && "2n+1" ||
					!/\D/.test( match[2] ) && "0n+" + match[2] || match[2]);

				match[2] = (test[1] + (test[2] || 1)) - 0;
				match[3] = test[3] - 0;
			}
			else if ( match[2] ) {
				Sizzle.error( match[0] );
			}

			match[0] = done++;

			return match;
		},

		ATTR: function( match, curLoop, inplace, result, not, isXML ) {
			var name = match[1] = match[1].replace( rBackslash, "" );

			if ( !isXML && Expr.attrMap[name] ) {
				match[1] = Expr.attrMap[name];
			}

			match[4] = ( match[4] || match[5] || "" ).replace( rBackslash, "" );

			if ( match[2] === "~=" ) {
				match[4] = " " + match[4] + " ";
			}

			return match;
		},

		PSEUDO: function( match, curLoop, inplace, result, not ) {
			if ( match[1] === "not" ) {
				if ( ( chunker.exec(match[3]) || "" ).length > 1 || /^\w/.test(match[3]) ) {
					match[3] = Sizzle(match[3], null, null, curLoop);

				} else {
					var ret = Sizzle.filter(match[3], curLoop, inplace, true ^ not);

					if ( !inplace ) {
						result.push.apply( result, ret );
					}

					return false;
				}

			} else if ( Expr.match.POS.test( match[0] ) || Expr.match.CHILD.test( match[0] ) ) {
				return true;
			}

			return match;
		},

		POS: function( match ) {
			match.unshift( true );

			return match;
		}
	},

	filters: {
		enabled: function( elem ) {
			return elem.disabled === false && elem.type !== "hidden";
		},

		disabled: function( elem ) {
			return elem.disabled === true;
		},

		checked: function( elem ) {
			return elem.checked === true;
		},

		selected: function( elem ) {
			if ( elem.parentNode ) {
				elem.parentNode.selectedIndex;
			}

			return elem.selected === true;
		},

		parent: function( elem ) {
			return !!elem.firstChild;
		},

		empty: function( elem ) {
			return !elem.firstChild;
		},

		has: function( elem, i, match ) {
			return !!Sizzle( match[3], elem ).length;
		},

		header: function( elem ) {
			return (/h\d/i).test( elem.nodeName );
		},

		text: function( elem ) {
			var attr = elem.getAttribute( "type" ), type = elem.type;
			return elem.nodeName.toLowerCase() === "input" && "text" === type && ( attr === type || attr === null );
		},

		radio: function( elem ) {
			return elem.nodeName.toLowerCase() === "input" && "radio" === elem.type;
		},

		checkbox: function( elem ) {
			return elem.nodeName.toLowerCase() === "input" && "checkbox" === elem.type;
		},

		file: function( elem ) {
			return elem.nodeName.toLowerCase() === "input" && "file" === elem.type;
		},

		password: function( elem ) {
			return elem.nodeName.toLowerCase() === "input" && "password" === elem.type;
		},

		submit: function( elem ) {
			var name = elem.nodeName.toLowerCase();
			return (name === "input" || name === "button") && "submit" === elem.type;
		},

		image: function( elem ) {
			return elem.nodeName.toLowerCase() === "input" && "image" === elem.type;
		},

		reset: function( elem ) {
			var name = elem.nodeName.toLowerCase();
			return (name === "input" || name === "button") && "reset" === elem.type;
		},

		button: function( elem ) {
			var name = elem.nodeName.toLowerCase();
			return name === "input" && "button" === elem.type || name === "button";
		},

		input: function( elem ) {
			return (/input|select|textarea|button/i).test( elem.nodeName );
		},

		focus: function( elem ) {
			return elem === elem.ownerDocument.activeElement;
		}
	},
	setFilters: {
		first: function( elem, i ) {
			return i === 0;
		},

		last: function( elem, i, match, array ) {
			return i === array.length - 1;
		},

		even: function( elem, i ) {
			return i % 2 === 0;
		},

		odd: function( elem, i ) {
			return i % 2 === 1;
		},

		lt: function( elem, i, match ) {
			return i < match[3] - 0;
		},

		gt: function( elem, i, match ) {
			return i > match[3] - 0;
		},

		nth: function( elem, i, match ) {
			return match[3] - 0 === i;
		},

		eq: function( elem, i, match ) {
			return match[3] - 0 === i;
		}
	},
	filter: {
		PSEUDO: function( elem, match, i, array ) {
			var name = match[1],
				filter = Expr.filters[ name ];

			if ( filter ) {
				return filter( elem, i, match, array );

			} else if ( name === "contains" ) {
				return (elem.textContent || elem.innerText || Sizzle.getText([ elem ]) || "").indexOf(match[3]) >= 0;

			} else if ( name === "not" ) {
				var not = match[3];

				for ( var j = 0, l = not.length; j < l; j++ ) {
					if ( not[j] === elem ) {
						return false;
					}
				}

				return true;

			} else {
				Sizzle.error( name );
			}
		},

		CHILD: function( elem, match ) {
			var type = match[1],
				node = elem;

			switch ( type ) {
				case "only":
				case "first":
					while ( (node = node.previousSibling) )	 {
						if ( node.nodeType === 1 ) {
							return false;
						}
					}

					if ( type === "first" ) {
						return true;
					}

					node = elem;

				case "last":
					while ( (node = node.nextSibling) )	 {
						if ( node.nodeType === 1 ) {
							return false;
						}
					}

					return true;

				case "nth":
					var first = match[2],
						last = match[3];

					if ( first === 1 && last === 0 ) {
						return true;
					}

					var doneName = match[0],
						parent = elem.parentNode;

					if ( parent && (parent.sizcache !== doneName || !elem.nodeIndex) ) {
						var count = 0;

						for ( node = parent.firstChild; node; node = node.nextSibling ) {
							if ( node.nodeType === 1 ) {
								node.nodeIndex = ++count;
							}
						}

						parent.sizcache = doneName;
					}

					var diff = elem.nodeIndex - last;

					if ( first === 0 ) {
						return diff === 0;

					} else {
						return ( diff % first === 0 && diff / first >= 0 );
					}
			}
		},

		ID: function( elem, match ) {
			return elem.nodeType === 1 && elem.getAttribute("id") === match;
		},

		TAG: function( elem, match ) {
			return (match === "*" && elem.nodeType === 1) || elem.nodeName.toLowerCase() === match;
		},

		CLASS: function( elem, match ) {
			return (" " + (elem.className || elem.getAttribute("class")) + " ")
				.indexOf( match ) > -1;
		},

		ATTR: function( elem, match ) {
			var name = match[1],
				result = Expr.attrHandle[ name ] ?
					Expr.attrHandle[ name ]( elem ) :
					elem[ name ] != null ?
						elem[ name ] :
						elem.getAttribute( name ),
				value = result + "",
				type = match[2],
				check = match[4];

			return result == null ?
				type === "!=" :
				type === "=" ?
				value === check :
				type === "*=" ?
				value.indexOf(check) >= 0 :
				type === "~=" ?
				(" " + value + " ").indexOf(check) >= 0 :
				!check ?
				value && result !== false :
				type === "!=" ?
				value !== check :
				type === "^=" ?
				value.indexOf(check) === 0 :
				type === "$=" ?
				value.substr(value.length - check.length) === check :
				type === "|=" ?
				value === check || value.substr(0, check.length + 1) === check + "-" :
				false;
		},

		POS: function( elem, match, i, array ) {
			var name = match[2],
				filter = Expr.setFilters[ name ];

			if ( filter ) {
				return filter( elem, i, match, array );
			}
		}
	}
};

var origPOS = Expr.match.POS,
	fescape = function(all, num){
		return "\\" + (num - 0 + 1);
	};

for ( var type in Expr.match ) {
	Expr.match[ type ] = new RegExp( Expr.match[ type ].source + (/(?![^\[]*\])(?![^\(]*\))/.source) );
	Expr.leftMatch[ type ] = new RegExp( /(^(?:.|\r|\n)*?)/.source + Expr.match[ type ].source.replace(/\\(\d+)/g, fescape) );
}

var makeArray = function( array, results ) {
	array = Array.prototype.slice.call( array, 0 );

	if ( results ) {
		results.push.apply( results, array );
		return results;
	}

	return array;
};

try {
	Array.prototype.slice.call( document.documentElement.childNodes, 0 )[0].nodeType;

} catch( e ) {
	makeArray = function( array, results ) {
		var i = 0,
			ret = results || [];

		if ( toString.call(array) === "[object Array]" ) {
			Array.prototype.push.apply( ret, array );

		} else {
			if ( typeof array.length === "number" ) {
				for ( var l = array.length; i < l; i++ ) {
					ret.push( array[i] );
				}

			} else {
				for ( ; array[i]; i++ ) {
					ret.push( array[i] );
				}
			}
		}

		return ret;
	};
}

var sortOrder, siblingCheck;

if ( document.documentElement.compareDocumentPosition ) {
	sortOrder = function( a, b ) {
		if ( a === b ) {
			hasDuplicate = true;
			return 0;
		}

		if ( !a.compareDocumentPosition || !b.compareDocumentPosition ) {
			return a.compareDocumentPosition ? -1 : 1;
		}

		return a.compareDocumentPosition(b) & 4 ? -1 : 1;
	};

} else {
	sortOrder = function( a, b ) {
		if ( a === b ) {
			hasDuplicate = true;
			return 0;

		} else if ( a.sourceIndex && b.sourceIndex ) {
			return a.sourceIndex - b.sourceIndex;
		}

		var al, bl,
			ap = [],
			bp = [],
			aup = a.parentNode,
			bup = b.parentNode,
			cur = aup;

		if ( aup === bup ) {
			return siblingCheck( a, b );

		} else if ( !aup ) {
			return -1;

		} else if ( !bup ) {
			return 1;
		}

		while ( cur ) {
			ap.unshift( cur );
			cur = cur.parentNode;
		}

		cur = bup;

		while ( cur ) {
			bp.unshift( cur );
			cur = cur.parentNode;
		}

		al = ap.length;
		bl = bp.length;

		for ( var i = 0; i < al && i < bl; i++ ) {
			if ( ap[i] !== bp[i] ) {
				return siblingCheck( ap[i], bp[i] );
			}
		}

		return i === al ?
			siblingCheck( a, bp[i], -1 ) :
			siblingCheck( ap[i], b, 1 );
	};

	siblingCheck = function( a, b, ret ) {
		if ( a === b ) {
			return ret;
		}

		var cur = a.nextSibling;

		while ( cur ) {
			if ( cur === b ) {
				return -1;
			}

			cur = cur.nextSibling;
		}

		return 1;
	};
}

Sizzle.getText = function( elems ) {
	var ret = "", elem;

	for ( var i = 0; elems[i]; i++ ) {
		elem = elems[i];

		if ( elem.nodeType === 3 || elem.nodeType === 4 ) {
			ret += elem.nodeValue;

		} else if ( elem.nodeType !== 8 ) {
			ret += Sizzle.getText( elem.childNodes );
		}
	}

	return ret;
};

(function(){
	var form = document.createElement("div"),
		id = "script" + (new Date()).getTime(),
		root = document.documentElement;

	form.innerHTML = "<a name='" + id + "'/>";

	root.insertBefore( form, root.firstChild );

	if ( document.getElementById( id ) ) {
		Expr.find.ID = function( match, context, isXML ) {
			if ( typeof context.getElementById !== "undefined" && !isXML ) {
				var m = context.getElementById(match[1]);

				return m ?
					m.id === match[1] || typeof m.getAttributeNode !== "undefined" && m.getAttributeNode("id").nodeValue === match[1] ?
						[m] :
						undefined :
					[];
			}
		};

		Expr.filter.ID = function( elem, match ) {
			var node = typeof elem.getAttributeNode !== "undefined" && elem.getAttributeNode("id");

			return elem.nodeType === 1 && node && node.nodeValue === match;
		};
	}

	root.removeChild( form );

	root = form = null;
})();

(function(){

	var div = document.createElement("div");
	div.appendChild( document.createComment("") );

	if ( div.getElementsByTagName("*").length > 0 ) {
		Expr.find.TAG = function( match, context ) {
			var results = context.getElementsByTagName( match[1] );

			if ( match[1] === "*" ) {
				var tmp = [];

				for ( var i = 0; results[i]; i++ ) {
					if ( results[i].nodeType === 1 ) {
						tmp.push( results[i] );
					}
				}

				results = tmp;
			}

			return results;
		};
	}

	div.innerHTML = "<a href='#'></a>";

	if ( div.firstChild && typeof div.firstChild.getAttribute !== "undefined" &&
			div.firstChild.getAttribute("href") !== "#" ) {

		Expr.attrHandle.href = function( elem ) {
			return elem.getAttribute( "href", 2 );
		};
	}

	div = null;
})();

if ( document.querySelectorAll ) {
	(function(){
		var oldSizzle = Sizzle,
			div = document.createElement("div"),
			id = "__sizzle__";

		div.innerHTML = "<p class='TEST'></p>";

		if ( div.querySelectorAll && div.querySelectorAll(".TEST").length === 0 ) {
			return;
		}

		Sizzle = function( query, context, extra, seed ) {
			context = context || document;

			if ( !seed && !Sizzle.isXML(context) ) {
				var match = /^(\w+$)|^\.([\w\-]+$)|^#([\w\-]+$)/.exec( query );

				if ( match && (context.nodeType === 1 || context.nodeType === 9) ) {
					if ( match[1] ) {
						return makeArray( context.getElementsByTagName( query ), extra );

					} else if ( match[2] && Expr.find.CLASS && context.getElementsByClassName ) {
						return makeArray( context.getElementsByClassName( match[2] ), extra );
					}
				}

				if ( context.nodeType === 9 ) {
					if ( query === "body" && context.body ) {
						return makeArray( [ context.body ], extra );

					} else if ( match && match[3] ) {
						var elem = context.getElementById( match[3] );

						if ( elem && elem.parentNode ) {
							if ( elem.id === match[3] ) {
								return makeArray( [ elem ], extra );
							}

						} else {
							return makeArray( [], extra );
						}
					}

					try {
						return makeArray( context.querySelectorAll(query), extra );
					} catch(qsaError) {}

				} else if ( context.nodeType === 1 && context.nodeName.toLowerCase() !== "object" ) {
					var oldContext = context,
						old = context.getAttribute( "id" ),
						nid = old || id,
						hasParent = context.parentNode,
						relativeHierarchySelector = /^\s*[+~]/.test( query );

					if ( !old ) {
						context.setAttribute( "id", nid );
					} else {
						nid = nid.replace( /'/g, "\\$&" );
					}
					if ( relativeHierarchySelector && hasParent ) {
						context = context.parentNode;
					}

					try {
						if ( !relativeHierarchySelector || hasParent ) {
							return makeArray( context.querySelectorAll( "[id='" + nid + "'] " + query ), extra );
						}

					} catch(pseudoError) {
					} finally {
						if ( !old ) {
							oldContext.removeAttribute( "id" );
						}
					}
				}
			}

			return oldSizzle(query, context, extra, seed);
		};

		for ( var prop in oldSizzle ) {
			Sizzle[ prop ] = oldSizzle[ prop ];
		}

		div = null;
	})();
}

(function(){
	var html = document.documentElement,
		matches = html.matchesSelector || html.mozMatchesSelector || html.webkitMatchesSelector || html.msMatchesSelector;

	if ( matches ) {
		var disconnectedMatch = !matches.call( document.createElement( "div" ), "div" ),
			pseudoWorks = false;

		try {
			matches.call( document.documentElement, "[test!='']:sizzle" );

		} catch( pseudoError ) {
			pseudoWorks = true;
		}

		Sizzle.matchesSelector = function( node, expr ) {
			expr = expr.replace(/\=\s*([^'"\]]*)\s*\]/g, "='$1']");

			if ( !Sizzle.isXML( node ) ) {
				try {
					if ( pseudoWorks || !Expr.match.PSEUDO.test( expr ) && !/!=/.test( expr ) ) {
						var ret = matches.call( node, expr );

						if ( ret || !disconnectedMatch ||
								node.document && node.document.nodeType !== 11 ) {
							return ret;
						}
					}
				} catch(e) {}
			}

			return Sizzle(expr, null, null, [node]).length > 0;
		};
	}
})();

(function(){
	var div = document.createElement("div");

	div.innerHTML = "<div class='test e'></div><div class='test'></div>";

	if ( !div.getElementsByClassName || div.getElementsByClassName("e").length === 0 ) {
		return;
	}

	div.lastChild.className = "e";

	if ( div.getElementsByClassName("e").length === 1 ) {
		return;
	}

	Expr.order.splice(1, 0, "CLASS");
	Expr.find.CLASS = function( match, context, isXML ) {
		if ( typeof context.getElementsByClassName !== "undefined" && !isXML ) {
			return context.getElementsByClassName(match[1]);
		}
	};

	div = null;
})();

function dirNodeCheck( dir, cur, doneName, checkSet, nodeCheck, isXML ) {
	for ( var i = 0, l = checkSet.length; i < l; i++ ) {
		var elem = checkSet[i];

		if ( elem ) {
			var match = false;

			elem = elem[dir];

			while ( elem ) {
				if ( elem.sizcache === doneName ) {
					match = checkSet[elem.sizset];
					break;
				}

				if ( elem.nodeType === 1 && !isXML ){
					elem.sizcache = doneName;
					elem.sizset = i;
				}

				if ( elem.nodeName.toLowerCase() === cur ) {
					match = elem;
					break;
				}

				elem = elem[dir];
			}

			checkSet[i] = match;
		}
	}
}

function dirCheck( dir, cur, doneName, checkSet, nodeCheck, isXML ) {
	for ( var i = 0, l = checkSet.length; i < l; i++ ) {
		var elem = checkSet[i];

		if ( elem ) {
			var match = false;

			elem = elem[dir];

			while ( elem ) {
				if ( elem.sizcache === doneName ) {
					match = checkSet[elem.sizset];
					break;
				}

				if ( elem.nodeType === 1 ) {
					if ( !isXML ) {
						elem.sizcache = doneName;
						elem.sizset = i;
					}

					if ( typeof cur !== "string" ) {
						if ( elem === cur ) {
							match = true;
							break;
						}

					} else if ( Sizzle.filter( cur, [elem] ).length > 0 ) {
						match = elem;
						break;
					}
				}

				elem = elem[dir];
			}

			checkSet[i] = match;
		}
	}
}

if ( document.documentElement.contains ) {
	Sizzle.contains = function( a, b ) {
		return a !== b && (a.contains ? a.contains(b) : true);
	};

} else if ( document.documentElement.compareDocumentPosition ) {
	Sizzle.contains = function( a, b ) {
		return !!(a.compareDocumentPosition(b) & 16);
	};

} else {
	Sizzle.contains = function() {
		return false;
	};
}

Sizzle.isXML = function( elem ) {
	var documentElement = (elem ? elem.ownerDocument || elem : 0).documentElement;

	return documentElement ? documentElement.nodeName !== "HTML" : false;
};

var posProcess = function( selector, context ) {
	var match,
		tmpSet = [],
		later = "",
		root = context.nodeType ? [context] : context;

	while ( (match = Expr.match.PSEUDO.exec( selector )) ) {
		later += match[0];
		selector = selector.replace( Expr.match.PSEUDO, "" );
	}

	selector = Expr.relative[selector] ? selector + "*" : selector;

	for ( var i = 0, l = root.length; i < l; i++ ) {
		Sizzle( selector, root[i], tmpSet );
	}

	return Sizzle.filter( later, tmpSet );
};


window.Sizzle = Sizzle;

})();

Prototype._original_property = window.Sizzle;

;(function(engine) {
  var extendElements = Prototype.Selector.extendElements;

  function select(selector, scope) {
    return extendElements(engine(selector, scope || document));
  }

  function match(element, selector) {
    return engine.matches(selector, [element]).length == 1;
  }

  Prototype.Selector.engine = engine;
  Prototype.Selector.select = select;
  Prototype.Selector.match = match;
})(Sizzle);

window.Sizzle = Prototype._original_property;
delete Prototype._original_property;

var Form = {
  reset: function(form) {
    form = $(form);
    form.reset();
    return form;
  },

  serializeElements: function(elements, options) {
    if (typeof options != 'object') options = { hash: !!options };
    else if (Object.isUndefined(options.hash)) options.hash = true;
    var key, value, submitted = false, submit = options.submit, accumulator, initial;

    if (options.hash) {
      initial = {};
      accumulator = function(result, key, value) {
        if (key in result) {
          if (!Object.isArray(result[key])) result[key] = [result[key]];
          result[key].push(value);
        } else result[key] = value;
        return result;
      };
    } else {
      initial = '';
      accumulator = function(result, key, value) {
        value = value.gsub(/(\r)?\n/, '\r\n');
        value = encodeURIComponent(value);
        value = value.gsub(/%20/, '+');
        return result + (result ? '&' : '') + encodeURIComponent(key) + '=' + value;
      }
    }

    return elements.inject(initial, function(result, element) {
      if (!element.disabled && element.name) {
        key = element.name; value = $(element).getValue();
        if (value != null && element.type != 'file' && (element.type != 'submit' || (!submitted &&
            submit !== false && (!submit || key == submit) && (submitted = true)))) {
          result = accumulator(result, key, value);
        }
      }
      return result;
    });
  }
};

Form.Methods = {
  serialize: function(form, options) {
    return Form.serializeElements(Form.getElements(form), options);
  },


  getElements: function(form) {
    var elements = $(form).getElementsByTagName('*');
    var element, results = [], serializers = Form.Element.Serializers;

    for (var i = 0; element = elements[i]; i++) {
      if (serializers[element.tagName.toLowerCase()])
        results.push(Element.extend(element));
    }
    return results;
  },

  getInputs: function(form, typeName, name) {
    form = $(form);
    var inputs = form.getElementsByTagName('input');

    if (!typeName && !name) return $A(inputs).map(Element.extend);

    for (var i = 0, matchingInputs = [], length = inputs.length; i < length; i++) {
      var input = inputs[i];
      if ((typeName && input.type != typeName) || (name && input.name != name))
        continue;
      matchingInputs.push(Element.extend(input));
    }

    return matchingInputs;
  },

  disable: function(form) {
    form = $(form);
    Form.getElements(form).invoke('disable');
    return form;
  },

  enable: function(form) {
    form = $(form);
    Form.getElements(form).invoke('enable');
    return form;
  },

  findFirstElement: function(form) {
    var elements = $(form).getElements().findAll(function(element) {
      return 'hidden' != element.type && !element.disabled;
    });
    var firstByIndex = elements.findAll(function(element) {
      return element.hasAttribute('tabIndex') && element.tabIndex >= 0;
    }).sortBy(function(element) { return element.tabIndex }).first();

    return firstByIndex ? firstByIndex : elements.find(function(element) {
      return /^(?:input|select|textarea)$/i.test(element.tagName);
    });
  },

  focusFirstElement: function(form) {
    form = $(form);
    var element = form.findFirstElement();
    if (element) element.activate();
    return form;
  },

  request: function(form, options) {
    form = $(form), options = Object.clone(options || { });

    var params = options.parameters, action = form.readAttribute('action') || '';
    if (action.blank()) action = window.location.href;
    options.parameters = form.serialize(true);

    if (params) {
      if (Object.isString(params)) params = params.toQueryParams();
      Object.extend(options.parameters, params);
    }

    if (form.hasAttribute('method') && !options.method)
      options.method = form.method;

    return new Ajax.Request(action, options);
  }
};

/*--------------------------------------------------------------------------*/


Form.Element = {
  focus: function(element) {
    $(element).focus();
    return element;
  },

  select: function(element) {
    $(element).select();
    return element;
  }
};

Form.Element.Methods = {

  serialize: function(element) {
    element = $(element);
    if (!element.disabled && element.name) {
      var value = element.getValue();
      if (value != undefined) {
        var pair = { };
        pair[element.name] = value;
        return Object.toQueryString(pair);
      }
    }
    return '';
  },

  getValue: function(element) {
    element = $(element);
    var method = element.tagName.toLowerCase();
    return Form.Element.Serializers[method](element);
  },

  setValue: function(element, value) {
    element = $(element);
    var method = element.tagName.toLowerCase();
    Form.Element.Serializers[method](element, value);
    return element;
  },

  clear: function(element) {
    $(element).value = '';
    return element;
  },

  present: function(element) {
    return $(element).value != '';
  },

  activate: function(element) {
    element = $(element);
    try {
      element.focus();
      if (element.select && (element.tagName.toLowerCase() != 'input' ||
          !(/^(?:button|reset|submit)$/i.test(element.type))))
        element.select();
    } catch (e) { }
    return element;
  },

  disable: function(element) {
    element = $(element);
    element.disabled = true;
    return element;
  },

  enable: function(element) {
    element = $(element);
    element.disabled = false;
    return element;
  }
};

/*--------------------------------------------------------------------------*/

var Field = Form.Element;

var $F = Form.Element.Methods.getValue;

/*--------------------------------------------------------------------------*/

Form.Element.Serializers = (function() {
  function input(element, value) {
    switch (element.type.toLowerCase()) {
      case 'checkbox':
      case 'radio':
        return inputSelector(element, value);
      default:
        return valueSelector(element, value);
    }
  }

  function inputSelector(element, value) {
    if (Object.isUndefined(value))
      return element.checked ? element.value : null;
    else element.checked = !!value;
  }

  function valueSelector(element, value) {
    if (Object.isUndefined(value)) return element.value;
    else element.value = value;
  }

  function select(element, value) {
    if (Object.isUndefined(value))
      return (element.type === 'select-one' ? selectOne : selectMany)(element);

    var opt, currentValue, single = !Object.isArray(value);
    for (var i = 0, length = element.length; i < length; i++) {
      opt = element.options[i];
      currentValue = this.optionValue(opt);
      if (single) {
        if (currentValue == value) {
          opt.selected = true;
          return;
        }
      }
      else opt.selected = value.include(currentValue);
    }
  }

  function selectOne(element) {
    var index = element.selectedIndex;
    return index >= 0 ? optionValue(element.options[index]) : null;
  }

  function selectMany(element) {
    var values, length = element.length;
    if (!length) return null;

    for (var i = 0, values = []; i < length; i++) {
      var opt = element.options[i];
      if (opt.selected) values.push(optionValue(opt));
    }
    return values;
  }

  function optionValue(opt) {
    return Element.hasAttribute(opt, 'value') ? opt.value : opt.text;
  }

  return {
    input:         input,
    inputSelector: inputSelector,
    textarea:      valueSelector,
    select:        select,
    selectOne:     selectOne,
    selectMany:    selectMany,
    optionValue:   optionValue,
    button:        valueSelector
  };
})();

/*--------------------------------------------------------------------------*/


Abstract.TimedObserver = Class.create(PeriodicalExecuter, {
  initialize: function($super, element, frequency, callback) {
    $super(callback, frequency);
    this.element   = $(element);
    this.lastValue = this.getValue();
  },

  execute: function() {
    var value = this.getValue();
    if (Object.isString(this.lastValue) && Object.isString(value) ?
        this.lastValue != value : String(this.lastValue) != String(value)) {
      this.callback(this.element, value);
      this.lastValue = value;
    }
  }
});

Form.Element.Observer = Class.create(Abstract.TimedObserver, {
  getValue: function() {
    return Form.Element.getValue(this.element);
  }
});

Form.Observer = Class.create(Abstract.TimedObserver, {
  getValue: function() {
    return Form.serialize(this.element);
  }
});

/*--------------------------------------------------------------------------*/

Abstract.EventObserver = Class.create({
  initialize: function(element, callback) {
    this.element  = $(element);
    this.callback = callback;

    this.lastValue = this.getValue();
    if (this.element.tagName.toLowerCase() == 'form')
      this.registerFormCallbacks();
    else
      this.registerCallback(this.element);
  },

  onElementEvent: function() {
    var value = this.getValue();
    if (this.lastValue != value) {
      this.callback(this.element, value);
      this.lastValue = value;
    }
  },

  registerFormCallbacks: function() {
    Form.getElements(this.element).each(this.registerCallback, this);
  },

  registerCallback: function(element) {
    if (element.type) {
      switch (element.type.toLowerCase()) {
        case 'checkbox':
        case 'radio':
          Event.observe(element, 'click', this.onElementEvent.bind(this));
          break;
        default:
          Event.observe(element, 'change', this.onElementEvent.bind(this));
          break;
      }
    }
  }
});

Form.Element.EventObserver = Class.create(Abstract.EventObserver, {
  getValue: function() {
    return Form.Element.getValue(this.element);
  }
});

Form.EventObserver = Class.create(Abstract.EventObserver, {
  getValue: function() {
    return Form.serialize(this.element);
  }
});
(function(GLOBAL) {
  var DIV = document.createElement('div');
  var docEl = document.documentElement;
  var MOUSEENTER_MOUSELEAVE_EVENTS_SUPPORTED = 'onmouseenter' in docEl
   && 'onmouseleave' in docEl;

  var Event = {
    KEY_BACKSPACE: 8,
    KEY_TAB:       9,
    KEY_RETURN:   13,
    KEY_ESC:      27,
    KEY_LEFT:     37,
    KEY_UP:       38,
    KEY_RIGHT:    39,
    KEY_DOWN:     40,
    KEY_DELETE:   46,
    KEY_HOME:     36,
    KEY_END:      35,
    KEY_PAGEUP:   33,
    KEY_PAGEDOWN: 34,
    KEY_INSERT:   45
  };


  var isIELegacyEvent = function(event) { return false; };

  if (window.attachEvent) {
    if (window.addEventListener) {
      isIELegacyEvent = function(event) {
        return !(event instanceof window.Event);
      };
    } else {
      isIELegacyEvent = function(event) { return true; };
    }
  }

  var _isButton;

  function _isButtonForDOMEvents(event, code) {
    return event.which ? (event.which === code + 1) : (event.button === code);
  }

  var legacyButtonMap = { 0: 1, 1: 4, 2: 2 };
  function _isButtonForLegacyEvents(event, code) {
    return event.button === legacyButtonMap[code];
  }

  function _isButtonForWebKit(event, code) {
    switch (code) {
      case 0: return event.which == 1 && !event.metaKey;
      case 1: return event.which == 2 || (event.which == 1 && event.metaKey);
      case 2: return event.which == 3;
      default: return false;
    }
  }

  if (window.attachEvent) {
    if (!window.addEventListener) {
      _isButton = _isButtonForLegacyEvents;
    } else {
      _isButton = function(event, code) {
        return isIELegacyEvent(event) ? _isButtonForLegacyEvents(event, code) :
         _isButtonForDOMEvents(event, code);
      }
    }
  } else if (Prototype.Browser.WebKit) {
    _isButton = _isButtonForWebKit;
  } else {
    _isButton = _isButtonForDOMEvents;
  }

  function isLeftClick(event)   { return _isButton(event, 0) }

  function isMiddleClick(event) { return _isButton(event, 1) }

  function isRightClick(event)  { return _isButton(event, 2) }

  function element(event) {
    return Element.extend(_element(event));
  }

  function _element(event) {
    event = Event.extend(event);

    var node = event.target, type = event.type,
     currentTarget = event.currentTarget;

    if (currentTarget && currentTarget.tagName) {
      if (type === 'load' || type === 'error' ||
        (type === 'click' && currentTarget.tagName.toLowerCase() === 'input'
          && currentTarget.type === 'radio'))
            node = currentTarget;
    }

    if (node.nodeType == Node.TEXT_NODE)
      node = node.parentNode;

    return Element.extend(node);
  }

  function findElement(event, expression) {
    var element = _element(event), match = Prototype.Selector.match;
    if (!expression) return Element.extend(element);
    while (element) {
      if (Object.isElement(element) && match(element, expression))
        return Element.extend(element);
      element = element.parentNode;
    }
  }

  function pointer(event) {
    return { x: pointerX(event), y: pointerY(event) };
  }

  function pointerX(event) {
    var docElement = document.documentElement,
     body = document.body || { scrollLeft: 0 };

    return event.pageX || (event.clientX +
      (docElement.scrollLeft || body.scrollLeft) -
      (docElement.clientLeft || 0));
  }

  function pointerY(event) {
    var docElement = document.documentElement,
     body = document.body || { scrollTop: 0 };

    return  event.pageY || (event.clientY +
       (docElement.scrollTop || body.scrollTop) -
       (docElement.clientTop || 0));
  }


  function stop(event) {
    Event.extend(event);
    event.preventDefault();
    event.stopPropagation();

    event.stopped = true;
  }


  Event.Methods = {
    isLeftClick:   isLeftClick,
    isMiddleClick: isMiddleClick,
    isRightClick:  isRightClick,

    element:     element,
    findElement: findElement,

    pointer:  pointer,
    pointerX: pointerX,
    pointerY: pointerY,

    stop: stop
  };

  var methods = Object.keys(Event.Methods).inject({ }, function(m, name) {
    m[name] = Event.Methods[name].methodize();
    return m;
  });

  if (window.attachEvent) {
    function _relatedTarget(event) {
      var element;
      switch (event.type) {
        case 'mouseover':
        case 'mouseenter':
          element = event.fromElement;
          break;
        case 'mouseout':
        case 'mouseleave':
          element = event.toElement;
          break;
        default:
          return null;
      }
      return Element.extend(element);
    }

    var additionalMethods = {
      stopPropagation: function() { this.cancelBubble = true },
      preventDefault:  function() { this.returnValue = false },
      inspect: function() { return '[object Event]' }
    };

    Event.extend = function(event, element) {
      if (!event) return false;

      if (!isIELegacyEvent(event)) return event;

      if (event._extendedByPrototype) return event;
      event._extendedByPrototype = Prototype.emptyFunction;

      var pointer = Event.pointer(event);

      Object.extend(event, {
        target: event.srcElement || element,
        relatedTarget: _relatedTarget(event),
        pageX:  pointer.x,
        pageY:  pointer.y
      });

      Object.extend(event, methods);
      Object.extend(event, additionalMethods);

      return event;
    };
  } else {
    Event.extend = Prototype.K;
  }

  if (window.addEventListener) {
    Event.prototype = window.Event.prototype || document.createEvent('HTMLEvents').__proto__;
    Object.extend(Event.prototype, methods);
  }

  var EVENT_TRANSLATIONS = {
    mouseenter: 'mouseover',
    mouseleave: 'mouseout'
  };

  function getDOMEventName(eventName) {
    return EVENT_TRANSLATIONS[eventName] || eventName;
  }

  if (MOUSEENTER_MOUSELEAVE_EVENTS_SUPPORTED)
    getDOMEventName = Prototype.K;

  function getUniqueElementID(element) {
    if (element === window) return 0;

    if (typeof element._prototypeUID === 'undefined')
      element._prototypeUID = Element.Storage.UID++;
    return element._prototypeUID;
  }

  function getUniqueElementID_IE(element) {
    if (element === window) return 0;
    if (element == document) return 1;
    return element.uniqueID;
  }

  if ('uniqueID' in DIV)
    getUniqueElementID = getUniqueElementID_IE;

  function isCustomEvent(eventName) {
    return eventName.include(':');
  }

  Event._isCustomEvent = isCustomEvent;

  function getRegistryForElement(element, uid) {
    var CACHE = GLOBAL.Event.cache;
    if (Object.isUndefined(uid))
      uid = getUniqueElementID(element);
    if (!CACHE[uid]) CACHE[uid] = { element: element };
    return CACHE[uid];
  }

  function destroyRegistryForElement(element, uid) {
    if (Object.isUndefined(uid))
      uid = getUniqueElementID(element);
    delete GLOBAL.Event.cache[uid];
  }


  function register(element, eventName, handler) {
    var registry = getRegistryForElement(element);
    if (!registry[eventName]) registry[eventName] = [];
    var entries = registry[eventName];

    var i = entries.length;
    while (i--)
      if (entries[i].handler === handler) return null;

    var uid = getUniqueElementID(element);
    var responder = GLOBAL.Event._createResponder(uid, eventName, handler);
    var entry = {
      responder: responder,
      handler:   handler
    };

    entries.push(entry);
    return entry;
  }

  function unregister(element, eventName, handler) {
    var registry = getRegistryForElement(element);
    var entries = registry[eventName];
    if (!entries) return;

    var i = entries.length, entry;
    while (i--) {
      if (entries[i].handler === handler) {
        entry = entries[i];
        break;
      }
    }

    if (!entry) return;

    var index = entries.indexOf(entry);
    entries.splice(index, 1);

    return entry;
  }


  function observe(element, eventName, handler) {
    element = $(element);
    var entry = register(element, eventName, handler);

    if (entry === null) return element;

    var responder = entry.responder;
    if (isCustomEvent(eventName))
      observeCustomEvent(element, eventName, responder);
    else
      observeStandardEvent(element, eventName, responder);

    return element;
  }

  function observeStandardEvent(element, eventName, responder) {
    var actualEventName = getDOMEventName(eventName);
    if (element.addEventListener) {
      element.addEventListener(actualEventName, responder, false);
    } else {
      element.attachEvent('on' + actualEventName, responder);
    }
  }

  function observeCustomEvent(element, eventName, responder) {
    if (element.addEventListener) {
      element.addEventListener('dataavailable', responder, false);
    } else {
      element.attachEvent('ondataavailable', responder);
      element.attachEvent('onlosecapture',   responder);
    }
  }

  function stopObserving(element, eventName, handler) {
    element = $(element);
    var handlerGiven = !Object.isUndefined(handler),
     eventNameGiven = !Object.isUndefined(eventName);

    if (!eventNameGiven && !handlerGiven) {
      stopObservingElement(element);
      return element;
    }

    if (!handlerGiven) {
      stopObservingEventName(element, eventName);
      return element;
    }

    var entry = unregister(element, eventName, handler);

    if (!entry) return element;
    removeEvent(element, eventName, entry.responder);
    return element;
  }

  function stopObservingStandardEvent(element, eventName, responder) {
    var actualEventName = getDOMEventName(eventName);
    if (element.removeEventListener) {
      element.removeEventListener(actualEventName, responder, false);
    } else {
      element.detachEvent('on' + actualEventName, responder);
    }
  }

  function stopObservingCustomEvent(element, eventName, responder) {
    if (element.removeEventListener) {
      element.removeEventListener('dataavailable', responder, false);
    } else {
      element.detachEvent('ondataavailable', responder);
      element.detachEvent('onlosecapture',   responder);
    }
  }



  function stopObservingElement(element) {
    var uid = getUniqueElementID(element),
     registry = getRegistryForElement(element, uid);

    destroyRegistryForElement(element, uid);

    var entries, i;
    for (var eventName in registry) {
      if (eventName === 'element') continue;

      entries = registry[eventName];
      i = entries.length;
      while (i--)
        removeEvent(element, eventName, entries[i].responder);
    }
  }

  function stopObservingEventName(element, eventName) {
    var registry = getRegistryForElement(element);
    var entries = registry[eventName];
    if (!entries) return;
    delete registry[eventName];

    var i = entries.length;
    while (i--)
      removeEvent(element, eventName, entries[i].responder);
  }


  function removeEvent(element, eventName, handler) {
    if (isCustomEvent(eventName))
      stopObservingCustomEvent(element, eventName, handler);
    else
      stopObservingStandardEvent(element, eventName, handler);
  }



  function getFireTarget(element) {
    if (element !== document) return element;
    if (document.createEvent && !element.dispatchEvent)
      return document.documentElement;
    return element;
  }

  function fire(element, eventName, memo, bubble) {
    element = getFireTarget($(element));
    if (Object.isUndefined(bubble)) bubble = true;
    memo = memo || {};

    var event = fireEvent(element, eventName, memo, bubble);
    return Event.extend(event);
  }

  function fireEvent_DOM(element, eventName, memo, bubble) {
    var event = document.createEvent('HTMLEvents');
    event.initEvent('dataavailable', bubble, true);

    event.eventName = eventName;
    event.memo = memo;

    element.dispatchEvent(event);
    return event;
  }

  function fireEvent_IE(element, eventName, memo, bubble) {
    var event = document.createEventObject();
    event.eventType = bubble ? 'ondataavailable' : 'onlosecapture';

    event.eventName = eventName;
    event.memo = memo;

    element.fireEvent(event.eventType, event);
    return event;
  }

  var fireEvent = document.createEvent ? fireEvent_DOM : fireEvent_IE;



  Event.Handler = Class.create({
    initialize: function(element, eventName, selector, callback) {
      this.element   = $(element);
      this.eventName = eventName;
      this.selector  = selector;
      this.callback  = callback;
      this.handler   = this.handleEvent.bind(this);
    },


    start: function() {
      Event.observe(this.element, this.eventName, this.handler);
      return this;
    },

    stop: function() {
      Event.stopObserving(this.element, this.eventName, this.handler);
      return this;
    },

    handleEvent: function(event) {
      var element = Event.findElement(event, this.selector);
      if (element) this.callback.call(this.element, event, element);
    }
  });

  function on(element, eventName, selector, callback) {
    element = $(element);
    if (Object.isFunction(selector) && Object.isUndefined(callback)) {
      callback = selector, selector = null;
    }

    return new Event.Handler(element, eventName, selector, callback).start();
  }

  Object.extend(Event, Event.Methods);

  Object.extend(Event, {
    fire:          fire,
    observe:       observe,
    stopObserving: stopObserving,
    on:            on
  });

  Element.addMethods({
    fire:          fire,

    observe:       observe,

    stopObserving: stopObserving,

    on:            on
  });

  Object.extend(document, {
    fire:          fire.methodize(),

    observe:       observe.methodize(),

    stopObserving: stopObserving.methodize(),

    on:            on.methodize(),

    loaded:        false
  });

  if (GLOBAL.Event) Object.extend(window.Event, Event);
  else GLOBAL.Event = Event;

  GLOBAL.Event.cache = {};

  function destroyCache_IE() {
    GLOBAL.Event.cache = null;
  }

  if (window.attachEvent)
    window.attachEvent('onunload', destroyCache_IE);

  DIV = null;
  docEl = null;
})(this);

(function(GLOBAL) {
  /* Code for creating leak-free event responders is based on work by
   John-David Dalton. */

  var docEl = document.documentElement;
  var MOUSEENTER_MOUSELEAVE_EVENTS_SUPPORTED = 'onmouseenter' in docEl
    && 'onmouseleave' in docEl;

  function isSimulatedMouseEnterLeaveEvent(eventName) {
    return !MOUSEENTER_MOUSELEAVE_EVENTS_SUPPORTED &&
     (eventName === 'mouseenter' || eventName === 'mouseleave');
  }

  function createResponder(uid, eventName, handler) {
    if (Event._isCustomEvent(eventName))
      return createResponderForCustomEvent(uid, eventName, handler);
    if (isSimulatedMouseEnterLeaveEvent(eventName))
      return createMouseEnterLeaveResponder(uid, eventName, handler);

    return function(event) {
      var cacheEntry = Event.cache[uid];
      var element = cacheEntry.element;

      Event.extend(event, element);
      handler.call(element, event);
    };
  }

  function createResponderForCustomEvent(uid, eventName, handler) {
    return function(event) {
      var cacheEntry = Event.cache[uid], element = cacheEntry.element;

      if (Object.isUndefined(event.eventName))
        return false;

      if (event.eventName !== eventName)
        return false;

      Event.extend(event, element);
      handler.call(element, event);
    };
  }

  function createMouseEnterLeaveResponder(uid, eventName, handler) {
    return function(event) {
      var cacheEntry = Event.cache[uid], element = cacheEntry.element;

      Event.extend(event, element);
      var parent = event.relatedTarget;

      while (parent && parent !== element) {
        try { parent = parent.parentNode; }
        catch(e) { parent = element; }
      }

      if (parent === element) return;
      handler.call(element, event);
    }
  }

  GLOBAL.Event._createResponder = createResponder;
  docEl = null;
})(this);

(function(GLOBAL) {
  /* Support for the DOMContentLoaded event is based on work by Dan Webb,
     Matthias Miller, Dean Edwards, John Resig, and Diego Perini. */

  var TIMER;

  function fireContentLoadedEvent() {
    if (document.loaded) return;
    if (TIMER) window.clearTimeout(TIMER);
    document.loaded = true;
    document.fire('dom:loaded');
  }

  function checkReadyState() {
    if (document.readyState === 'complete') {
      document.detachEvent('onreadystatechange', checkReadyState);
      fireContentLoadedEvent();
    }
  }

  function pollDoScroll() {
    try {
      document.documentElement.doScroll('left');
    } catch (e) {
      TIMER = pollDoScroll.defer();
      return;
    }

    fireContentLoadedEvent();
  }

  if (document.addEventListener) {
    document.addEventListener('DOMContentLoaded', fireContentLoadedEvent, false);
  } else {
    document.attachEvent('onreadystatechange', checkReadyState);
    if (window == top) TIMER = pollDoScroll.defer();
  }

  Event.observe(window, 'load', fireContentLoadedEvent);
})(this);


Element.addMethods();
/*------------------------------- DEPRECATED -------------------------------*/

Hash.toQueryString = Object.toQueryString;

var Toggle = { display: Element.toggle };

Element.Methods.childOf = Element.Methods.descendantOf;

var Insertion = {
  Before: function(element, content) {
    return Element.insert(element, {before:content});
  },

  Top: function(element, content) {
    return Element.insert(element, {top:content});
  },

  Bottom: function(element, content) {
    return Element.insert(element, {bottom:content});
  },

  After: function(element, content) {
    return Element.insert(element, {after:content});
  }
};

var $continue = new Error('"throw $continue" is deprecated, use "return" instead');

var Position = {
  includeScrollOffsets: false,

  prepare: function() {
    this.deltaX =  window.pageXOffset
                || document.documentElement.scrollLeft
                || document.body.scrollLeft
                || 0;
    this.deltaY =  window.pageYOffset
                || document.documentElement.scrollTop
                || document.body.scrollTop
                || 0;
  },

  within: function(element, x, y) {
    if (this.includeScrollOffsets)
      return this.withinIncludingScrolloffsets(element, x, y);
    this.xcomp = x;
    this.ycomp = y;
    this.offset = Element.cumulativeOffset(element);

    return (y >= this.offset[1] &&
            y <  this.offset[1] + element.offsetHeight &&
            x >= this.offset[0] &&
            x <  this.offset[0] + element.offsetWidth);
  },

  withinIncludingScrolloffsets: function(element, x, y) {
    var offsetcache = Element.cumulativeScrollOffset(element);

    this.xcomp = x + offsetcache[0] - this.deltaX;
    this.ycomp = y + offsetcache[1] - this.deltaY;
    this.offset = Element.cumulativeOffset(element);

    return (this.ycomp >= this.offset[1] &&
            this.ycomp <  this.offset[1] + element.offsetHeight &&
            this.xcomp >= this.offset[0] &&
            this.xcomp <  this.offset[0] + element.offsetWidth);
  },

  overlap: function(mode, element) {
    if (!mode) return 0;
    if (mode == 'vertical')
      return ((this.offset[1] + element.offsetHeight) - this.ycomp) /
        element.offsetHeight;
    if (mode == 'horizontal')
      return ((this.offset[0] + element.offsetWidth) - this.xcomp) /
        element.offsetWidth;
  },


  cumulativeOffset: Element.Methods.cumulativeOffset,

  positionedOffset: Element.Methods.positionedOffset,

  absolutize: function(element) {
    Position.prepare();
    return Element.absolutize(element);
  },

  relativize: function(element) {
    Position.prepare();
    return Element.relativize(element);
  },

  realOffset: Element.Methods.cumulativeScrollOffset,

  offsetParent: Element.Methods.getOffsetParent,

  page: Element.Methods.viewportOffset,

  clone: function(source, target, options) {
    options = options || { };
    return Element.clonePosition(target, source, options);
  }
};

/*--------------------------------------------------------------------------*/

if (!document.getElementsByClassName) document.getElementsByClassName = function(instanceMethods){
  function iter(name) {
    return name.blank() ? null : "[contains(concat(' ', @class, ' '), ' " + name + " ')]";
  }

  instanceMethods.getElementsByClassName = Prototype.BrowserFeatures.XPath ?
  function(element, className) {
    className = className.toString().strip();
    var cond = /\s/.test(className) ? $w(className).map(iter).join('') : iter(className);
    return cond ? document._getElementsByXPath('.//*' + cond, element) : [];
  } : function(element, className) {
    className = className.toString().strip();
    var elements = [], classNames = (/\s/.test(className) ? $w(className) : null);
    if (!classNames && !className) return elements;

    var nodes = $(element).getElementsByTagName('*');
    className = ' ' + className + ' ';

    for (var i = 0, child, cn; child = nodes[i]; i++) {
      if (child.className && (cn = ' ' + child.className + ' ') && (cn.include(className) ||
          (classNames && classNames.all(function(name) {
            return !name.toString().blank() && cn.include(' ' + name + ' ');
          }))))
        elements.push(Element.extend(child));
    }
    return elements;
  };

  return function(className, parentElement) {
    return $(parentElement || document.body).getElementsByClassName(className);
  };
}(Element.Methods);

/*--------------------------------------------------------------------------*/

Element.ClassNames = Class.create();
Element.ClassNames.prototype = {
  initialize: function(element) {
    this.element = $(element);
  },

  _each: function(iterator, context) {
    this.element.className.split(/\s+/).select(function(name) {
      return name.length > 0;
    })._each(iterator, context);
  },

  set: function(className) {
    this.element.className = className;
  },

  add: function(classNameToAdd) {
    if (this.include(classNameToAdd)) return;
    this.set($A(this).concat(classNameToAdd).join(' '));
  },

  remove: function(classNameToRemove) {
    if (!this.include(classNameToRemove)) return;
    this.set($A(this).without(classNameToRemove).join(' '));
  },

  toString: function() {
    return $A(this).join(' ');
  }
};

Object.extend(Element.ClassNames.prototype, Enumerable);

/*--------------------------------------------------------------------------*/

(function() {
  window.Selector = Class.create({
    initialize: function(expression) {
      this.expression = expression.strip();
    },

    findElements: function(rootElement) {
      return Prototype.Selector.select(this.expression, rootElement);
    },

    match: function(element) {
      return Prototype.Selector.match(element, this.expression);
    },

    toString: function() {
      return this.expression;
    },

    inspect: function() {
      return "#<Selector: " + this.expression + ">";
    }
  });

  Object.extend(Selector, {
    matchElements: function(elements, expression) {
      var match = Prototype.Selector.match,
          results = [];

      for (var i = 0, length = elements.length; i < length; i++) {
        var element = elements[i];
        if (match(element, expression)) {
          results.push(Element.extend(element));
        }
      }
      return results;
    },

    findElement: function(elements, expression, index) {
      index = index || 0;
      var matchIndex = 0, element;
      for (var i = 0, length = elements.length; i < length; i++) {
        element = elements[i];
        if (Prototype.Selector.match(element, expression) && index === matchIndex++) {
          return Element.extend(element);
        }
      }
    },

    findChildElements: function(element, expressions) {
      var selector = expressions.toArray().join(', ');
      return Prototype.Selector.select(selector, element || document);
    }
  });
})();
/* v0.8.0beta */

/*
 * Dom Utilities
 */
function Dom() {} 
  
Dom.getEvent = function(e)
{
  if (!e) var e = window.event;
  return e;
}

Dom.getObject = function(e)
{
  if (e.currentTarget) return e.currentTarget;
  else return event.srcElement;
}

Dom.removeObject = function(obj)
{
  if (obj == null)
  {
    return;
  }
  obj.parentNode.removeChild(obj);
}

Dom.x = function(e)
{
  if (e.pageX) return e.pageX;
  else return e.x;
  //else return e.clientX;  // This has been changed for IE
}

Dom.y = function(e)
{
  if (e.pageY) return e.pageY;
  else return e.y;
  //else return e.clientY; // This has been changed for IE
}

Dom.left = function(div)
{
  return div.offsetLeft == 0 && div.offsetTop == 0 ? div.style.left.substr(0,div.style.left.length- "px".length) : div.offsetLeft;
}

Dom.top = function(div)
{
  return div.offsetLeft == 0 && div.offsetTop == 0 ? div.style.top.substr(0,div.style.top.length- "px".length) : div.offsetTop;
}

Dom.cornerX = function(e)
{
  if (e.layerX) return Dom.x(e) - e.layerX;
  else return Dom.x(e) - e.offsetX;
}

Dom.cornerY = function(e)
{
  if (e.layerY) return Dom.y(e) - e.layerY;
  else return Dom.y(e) - e.offsetY;
}

Dom.setClass = function(obj,className)
{
  obj.setAttribute("class",className);
  obj.setAttribute("className",className);
}

Dom.setStyle = function(obj,css)
{
  obj.setAttribute("style",css);
  obj.style.cssText = css;
}

Dom.setDisplay = function(id,displayType)
{
  var obj = document.getElementById(id);
  if (obj == null)
  {
    return;
  }
  obj.style.display = displayType;
}

Dom.attachEvent = function(obj,eventName,functionReference)
{
  if (obj.attachEvent) 
  {
    obj.attachEvent("on"+eventName, functionReference);
  }
  else if (obj.addEventListener) 
  {
    obj.addEventListener(eventName, functionReference, true);
  }

}

Dom.getElementsByName = function(tag, name) 
{
  var elem = document.getElementsByTagName(tag);
  var arr = new Array();
  for(i = 0,iarr = 0; i < elem.length; i++) 
  {
    att = elem[i].getAttribute("name");
    if(att == name) 
    {
      arr[iarr] = elem[i];
      iarr++;
    }
  }
  return arr;
}

/*********************************************************************
 * No onMouseOut event if the mouse pointer hovers a child element 
 * *** Please do not remove this header. ***
 * This code is working on my IE7, IE6, FireFox, Opera and Safari
 * 
 * Usage: 
 * <div onMouseOut="fixOnMouseOut(this, event, 'JavaScript Code');"> 
 *    So many childs 
 *  </div>
 *
 * @Author Hamid Alipour Codehead @ webmaster-forums.code-head.com    
**/
Dom.is_child_of =  function(parent, child) 
{
  if(child != null) 
  {
   try {
     while( child.parentNode ) 
     {
       if( (child = child.parentNode) == parent ) 
       {
        return true;
       }
     }
   } 
   catch (e) 
   {
     Debugger.log("Unable to ask is_child_of: " + e);
   }
  }
  return false;
}
Dom.divMouseEvent = function(element, event, JavaScript_code) {
  var current_mouse_target = null;
  if( event.toElement ) {
    current_mouse_target = event.toElement;
  } else if( event.relatedTarget ) {
    current_mouse_target = event.relatedTarget;
  }
  if( !Dom.is_child_of(element, current_mouse_target) && element != current_mouse_target ) {
    eval(JavaScript_code);
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license   
Ajax = new Object();
Ajax.isSending = false;
Ajax.queue = [];

Ajax.waitUntilReady = function()
{
  if (!Ajax.isSending && Ajax.queue.length > 0)
  {
    Ajax.isSending = true;
    var sender = Ajax.queue[0];
    sender.go();
    Ajax.queue.splice(0,1);
  }
  
  if (Ajax.queue.length > 0)
  {
    setTimeout("Ajax.waitUntilReady()",100);
  }
}

Ajax.createHttp = function()
{
  for (var i=0;i<httpFactories.length;i++) 
  {
    try { return httpFactories[i](); }
    catch (e) { continue; }
  }
  return false;
}

Ajax.sendRequest = function(url,callback,postData)
{
  var sender = new AjaxSender(url,callback,postData);
  Ajax.queue.push(sender);
  Ajax.waitUntilReady();  
}

Ajax.defaultAjaxHandle = function(http)
{
  var response = http.responseText;
  alert(response);
}

var httpFactories = [
    function () {return new XMLHttpRequest()},
    function () {return new ActiveXObject("Msxml2.XMLHTTP")},
    function () {return new ActiveXObject("Msxml3.XMLHTTP")},
    function () {return new ActiveXObject("Microsoft.XMLHTTP")}
  ];

  

function AjaxSender(aUrl,aCallback,aPostData)
{
  this.url = aUrl;
  this.callback = aCallback;
  this.postData = aPostData;


  this.go = function()
  {
    var url = this.url;
    var callback = this.callback;
    var postData = this.postData;
  
    http = Ajax.createHttp();
    if (!http) { return; }
    
    var method = (postData) ? "POST" : "GET";
    callback = (callback) ? callback : Ajax.defaultAjaxHandle;
    
    http.open(method, url, true);

    if (postData)
    {
      http.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    }
  
    http.onreadystatechange = 
      function () {
        if (http.readyState != 4) { return; }
        if (http.status != 200 && http.status != 304) { return; }
        callback(http);
        Ajax.isSending = false;
      }
  
    if (http.readyState == 4) return;
    http.send(postData);
  }
 } 



 console.log("ajax.js loaded", this == window);
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license

function roundTo(num, decimalAccuracy)
{
  var factor = Math.pow(10,decimalAccuracy);
  if (decimalAccuracy > 0)
  {
    return Math.round(num/factor)*factor;
  }
  else
  {
    return Math.round(num/factor)*factor;
  }
}

String.prototype.trim = function() {
  return this.replace(/^\s+|\s+$/g,"");
}
String.prototype.ltrim = function() {
  return this.replace(/^\s+/,"");
}
String.prototype.rtrim = function() {
  return this.replace(/\s+$/,"");
}

function trim(str)
{
  return str.replace(/^\s+|\s+$/g, '');
}

function format(rawInput)
{
  var formattedText = rawInput;
  var lastFormattedText = "";
  while (formattedText != lastFormattedText)
  {
    lastFormattedText = formattedText;
    for(var i=1; i<arguments.length; i++)
    {
      formattedText = formattedText.replace("{" + (i - 1) + "}", arguments[i]);
    }
  }
  
  return formattedText;
}

// Simplified version of the above that doesn't recurse if the argument has the {0}
function formatOnce(rawInput)
{
  var formattedText = rawInput;
  for(var i=1; i<arguments.length; i++)
  {
    formattedText = formattedText.replace("{" + (i - 1) + "}", arguments[i]);
  }
  
  return formattedText;
}
Json = new Object();

Json.toObject = function(jsonText)
{
  if (jsonText == "")
  {
    return null;
  }
  eval(format("var data = {0};", jsonText));
  return data;
}

Json.toString = function(obj, name, shouldWrap)
{
  if (typeof(name) == "undefined") { name = null; }
  if (typeof(shouldWrap) == "undefined") { shouldWrap = true; }

  var json = "";
  for (var i in obj) 
  {
  	var attr = obj[i];
    if (("" + attr).startsWith("function") || attr == undefined)
    {
      continue;
    }
    if (json.length > 0)
    {
      json += ',';
    }
    if (Json.isObject(attr))
    {
      json += Json.toString(attr,i,false);
    }
    else if (Json.isArray(attr))
    {
      json += format('"{0}" : [',i);
      
      for (var index = 0; index < attr.length; index++)
      {
        if (index > 0)
        {
          json += ',';
        }
        json += Json.toString(attr[index],null,true); // format('"{0}"',attr[index]); 
      }
      json += ']';
    }
    else
    {
      json += format('"{0}" : "{1}"',i,obj[i]); 
    }
  }
  
  
  if (name != null)
  {
    json = format('"{0}" : {{1}}',name,json);
  }
  
  if (shouldWrap)
  {
    json = format('{{0}}',json);
  }
  
  return json;
}


Json.isObject = function(obj)
{
  return typeof(obj) == "object" && ! Json.isArray(obj);
}

Json.isArray = function(obj)
{
  return obj.constructor.toString().indexOf("Array") != -1
}

Debugger = new Object();

Debugger.inspect = function(obj)
{
  var msg = "";
  for (var i in obj) 
  {
    if (("" + obj[i]).startsWith("function"))
    {
      continue;
    }
    msg += typeof(obj) + "." + i + "=" + obj[i] + "\n";
  }
  alert(msg);
}


Debugger.log = function(msg)
{
  console.log(msg);
}
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
eval(function(p,a,c,k,e,d){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--){d[e(c)]=k[c]||e(c)}k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};while(c--){if(k[c]){p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c])}}return p}('f(!1o.31){p 31=h(){p l={5S:{"1e-1c":"","73-2E":1,"2a-1P":u,"1I":u,"6T-6S":U,"1F-1P":4,"5F":O,"5x":U,"1q":U,"5v":O,"6i-6p":U,"6J":O},Q:{5D:u,5i:16,5k:16,7P:O,7I:"5L",1b:{4e:"91 1i",3Y:"92 1i",5l:"93 90 6K",6X:"8Z I 8W 1X 8X 6K 8Y",3u:"3u",6h:"?",1u:"31\\n\\n",5Z:"94\'t 95 7J C: ",7z:"9b 9c\'t 9a C 2j-2n 99: ",6B:"<!96 2j 97 \\"-//98//8b 8V 1.0 8U//8I\\" \\"2y://7A.7E.7o/8J/86/8b/86-8K.8H\\"><2j 8G=\\"2y://7A.7E.7o/8D/8E\\"><70><8F 2y-8L=\\"8M-8S\\" 5h=\\"2c/2j; 8T=8R-8\\" /><36>8Q 31</36></70><2R 1f=\\"2a-7T:8N,\'7h 8O 8P\',7h,7L;9d-53:#9e;53:#9D;2a-1P:9E;2c-8i:85;\\"><z 1f=\\"2c-8i:85;5n-4z:9F;\\"><z 1f=\\"2a-7T:9C,9B,9y,8C-7L;2a-1P:9z-9A;\\">31</z><z 1f=\\"2a-1P:.9G;5n-9H:9N;\\"><z>84 2.0.9O (9M 9L 6H)</z><z><a 2q=\\"2y://6a.4a\\" 9I=\\"4P\\" 1f=\\"53:#9J;2c-9K:9x;\\">2y://6a.4a</a></z></z><z>9w I 9k 9l.</z><z>9m 9j-6H 9i 9f.</z></z></2R></2j>"},7j:O},1p:{59:u,3q:u,3o:u,5j:{}},30:{},8a:{9g:/\\/\\*[\\s\\S]*?\\*\\//4M,9h:/\\/\\/.*$/4M,9n:/#.*$/4M,9o:/"(?:\\.|(\\\\\\")|[^\\""\\n])*"/g,9u:/\'(?:\\.|(\\\\\\\')|[^\\\'\'\\n])*\'/g,9v:/"(?:\\.|(\\\\\\")|[^\\""])*"/g,9t:/\'(?:\\.|(\\\\\\\')|[^\\\'\'])*\'/g,3e:/\\w+:\\/\\/[\\w-.\\/?%&=]*/g,9s:{E:/(&1C;|<)\\?=?/g,17:/\\?(&2m;|>)/g},9p:{E:/(&1C;|<)%=?/g,17:/%(&2m;|>)/g},9q:{E:/(&1C;|<)\\s*2n.*?(&2m;|>)/47,17:/(&1C;|<)\\/\\s*2n\\s*(&2m;|>)/47}},1q:{15:h(32){p 38=J.1t("37"),4L=l.1q.77;38.Y="1q";C(p 2N 1X 4L){p 6j=4L[2N],4G=R 6j(32),22=4G.15();32.5E[2N]=4G;f(22==u){1V}f(9r(22)=="9P"){22=l.1q.6C(22,32.1j,2N)}22.Y+="8w "+2N;38.1z(22)}q 38},6C:h(4v,6O,4w){p a=J.1t("a"),5e=a.1f,4F=l.Q,57=4F.5i,5c=4F.5k;a.2q="#"+4w;a.36=4v;a.5P=6O;a.6c=4w;a.1r=4v;f(5z(57)==O){5e.1N=57+"5H"}f(5z(5c)==O){5e.2u=5c+"5H"}a.8q=h(e){8j{l.1q.6f(c,e||1o.6g,c.5P,c.6c)}8m(e){l.B.1u(e.6F)}q O};q a},6f:h(7i,7a,5T,7O,72){p 4Y=l.1p.5j[5T],45;f(4Y==u||(45=4Y.5E[7O])==u){q u}q 45.2h(7i,7a,72)},77:{4e:h(4p){c.15=h(){f(4p.T("5v")!=U){q}q l.Q.1b.4e};c.2h=h(4q,8v,8B){p z=4p.z;4q.71.51(4q);z.Y=z.Y.D("5t","")}},3Y:h(8g){c.15=h(){q l.Q.1b.3Y};c.2h=h(8p,8o,8t){p 33=l.B.3d(8g.5r).D(/</g,"&1C;"),2b=l.B.4y("","4P",8r,8n,"8x=0, 8k=1, 8s=0, 6n=1");33=l.B.2W(33);2b.J.3t("<5L>"+33+"</5L>");2b.J.4N()}},5l:h(4S){p 3x,8y,5M=4S.1j;c.15=h(){p 2A=l.Q;f(2A.5D==u){q u}h 1L(5C){p 5s="";C(p 5A 1X 5C){5s+="<8z 1c=\'"+5A+"\' 1W=\'"+5C[5A]+"\'/>"}q 5s};h 2p(43){p 5p="";C(p 5o 1X 43){5p+=" "+5o+"=\'"+43[5o]+"\'"}q 5p};p 48={1N:2A.5i,2u:2A.5k,1j:5M+"ai",6z:"bu/x-74-79",36:l.Q.1b.5l},46={bl:"bm",bx:"bA",bz:"5P="+5M,bF:"O"},4t=2A.5D,35;f(/aQ/i.1R(61.6b)){35="<8h"+2p({aT:"bd:bf-b9-b5-b4-b7",b8:"2y://ba.be.4a/bb/74/bc/79/b3.b2#84=9,0,0,0"})+2p(48)+">"+1L(46)+1L({aU:4t})+"</8h>"}F{35="<aS"+2p(48)+2p(46)+2p({aR:4t})+"/>"}3x=J.1t("z");3x.1r=35;q 3x};c.2h=h(aV,aW,4R){p 68=4R.b1;6V(68){2J"7C":p 5d=l.B.2W(l.B.3d(4S.5r).D(/&1C;/g,"<").D(/&2m;/g,">").D(/&b0;/g,"&"));f(1o.6e){1o.6e.aZ("2c",5d)}F{q l.B.2W(5d)}2J"aX":l.B.1u(l.Q.1b.6X);2B;2J"aY":l.B.1u(4R.6F);2B}}},bh:h(4I){c.15=h(){q l.Q.1b.3u};c.2h=h(bg,by,bB){p 25=J.1t("bG"),1J=u;f(l.1p.3o!=u){J.2R.51(l.1p.3o)}l.1p.3o=25;25.1f.bC="bE:bD;1N:6m;2u:6m;E:-6l;4z:-6l;";J.2R.1z(25);1J=25.4J.J;6t(1J,1o.J);1J.3t("<z 1e=\\""+4I.z.Y.D("5t","")+" bn\\">"+4I.z.1r+"</z>");1J.4N();25.4J.4A();25.4J.3u();h 6t(6A,6s){p 2S=6s.7M("4K");C(p i=0;i<2S.v;i++){f(2S[i].6r.bk()=="6q"&&/bi\\.12$/.1R(2S[i].2q)){6A.3t("<4K 6z=\\"2c/12\\" 6r=\\"6q\\" 2q=\\""+2S[i].2q+"\\"></4K>")}}}}},bj:h(bo){c.15=h(){q l.Q.1b.6h};c.2h=h(bv,bt){p 2b=l.B.4y("","4P",bq,bs,"6n=0"),1J=2b.J;1J.3t(l.Q.1b.6B);1J.4N();2b.4A()}}}},B:{5m:h(6R){q 6R+3z.aN(3z.aa()*ab).2f()},5u:h(4E,4x){p 3l={},1S;C(1S 1X 4E){3l[1S]=4E[1S]}C(1S 1X 4x){3l[1S]=4x[1S]}q 3l},7w:h(4u){6V(4u){2J"U":q U;2J"O":q O}q 4u},4y:h(3e,6M,4D,4C,2I){p x=(6N.1N-4D)/2,y=(6N.2u-4C)/2;2I+=", E="+x+", 4z="+y+", 1N="+4D+", 2u="+4C;2I=2I.D(/^,/,"");p 4Q=1o.9Q(3e,6M,2I);4Q.4A();q 4Q},78:h(1A,29,23){f(1A.6D){1A["e"+29+23]=23;1A[29+23]=h(){1A["e"+29+23](1o.6g)};1A.6D("a6"+29,1A[29+23])}F{1A.a7(29,23,O)}},1u:h(A){1u(l.Q.1b.1u+A)},4c:h(5a,5Y){p 2k=l.1p.59,3j=u;f(2k==u){2k={};C(p 55 1X l.30){p 3g=l.30[55].ac;f(3g==u){1V}C(p i=0;i<3g.v;i++){2k[3g[i]]=55}}l.1p.59=2k}3j=l.30[2k[5a]];f(3j==u&&5Y!=O){l.B.1u(l.Q.1b.5Z+5a)}q 3j},42:h(A,60){p 2T=A.21("\\n");C(p i=0;i<2T.v;i++){2T[i]=60(2T[i])}q 2T.4h("\\n")},6x:h(){p z=J.1t("z"),3h=J.1t("z"),6d=10,i=1;28(i<=aO){f(i%6d===0){z.1r+=i;i+=(i+"").v}F{z.1r+="&ah;";i++}}3h.Y="5F 2E";3h.1z(z);q 3h},6U:h(A){q A.D(/^[ ]*[\\n]+|[\\n]*[ ]*$/g,"")},7d:h(A){p 3i,4V={},5b=R M("^\\\\[(?<54>(.*?))\\\\]$"),69=R M("(?<1c>[\\\\w-]+)"+"\\\\s*:\\\\s*"+"(?<1W>"+"[\\\\w-%#]+|"+"\\\\[.*?\\\\]|"+"\\".*?\\"|"+"\'.*?\'"+")\\\\s*;?","g");28((3i=69.N(A))!=u){p 2g=3i.1W.D(/^[\'"]|[\'"]$/g,"");f(2g!=u&&5b.1R(2g)){p m=5b.N(2g);2g=m.54.v>0?m.54.21(/\\s*,\\s*/):[]}4V[3i.1c]=2g}q 4V},80:h(A,12){f(A==u||A.v==0||A=="\\n"){q A}A=A.D(/</g,"&1C;");A=A.D(/ {2,}/g,h(m){p 4U="";C(p i=0;i<m.v-1;i++){4U+="&1O;"}q 4U+" "});f(12!=u){A=l.B.42(A,h(2i){f(2i.v==0){q""}p 3k="";2i=2i.D(/^(&1O;| )+/,h(s){3k=s;q""});f(2i.v==0){q 3k}q 3k+"<I 1e=\\""+12+"\\">"+2i+"</I>"})}q A},7f:h(66,67){p 2Z=66.2f();28(2Z.v<67){2Z="0"+2Z}q 2Z},5y:h(){p 3b=J.1t("z"),3f,3a=0,52=J.2R,1j=l.B.5m("5y"),2O="<z 1e=\\"",2Q="</z>",4W="</1T>";3b.1r=2O+"6L\\">"+2O+"26\\">"+2O+"2E\\">"+2O+"5h"+"\\"><1T 1e=\\"7V\\"><1T 1j=\\""+1j+"\\">&1O;"+4W+4W+2Q+2Q+2Q+2Q;52.1z(3b);3f=J.a5(1j);f(/a4/i.1R(61.6b)){p 5Q=1o.9V(3f,u);3a=7l(5Q.9W("1N"))}F{3a=3f.9U}52.51(3b);q 3a},6Q:h(7R,6Y){p 1F="";C(p i=0;i<6Y;i++){1F+=" "}q 7R.D(/\\t/g,1F)},6P:h(2P,41){p 9T=2P.21("\\n"),1F="\\t",5f="";C(p i=0;i<50;i++){5f+="                    "}h 7X(3c,18,7Z){q 3c.1M(0,18)+5f.1M(0,7Z)+3c.1M(18+1,3c.v)};2P=l.B.42(2P,h(20){f(20.1h(1F)==-1){q 20}p 18=0;28((18=20.1h(1F))!=-1){p 7U=41-18%41;20=7X(20,18,7U)}q 20});q 2P},3d:h(A){q(l.Q.7P==U)?A.D(/<br\\s*\\/?>|&1C;br\\s*\\/?&2m;/47,"\\n"):A},3P:h(A){q A.D(/\\s*$/g,"").D(/^\\s*/,"")},2W:h(A){p 1Q=l.B.3d(A).21("\\n"),9X=R 5B(),7S=/^\\s*/,24=9Y;C(p i=0;i<1Q.v&&24>0;i++){p 3V=1Q[i];f(l.B.3P(3V).v==0){1V}p 3S=7S.N(3V);f(3S==u){q A}24=3z.24(3S[0].v,24)}f(24>0){C(p i=0;i<1Q.v;i++){1Q[i]=1Q[i].1M(24)}}q 1Q.4h("\\n")},7B:h(2L,2K){f(2L.H<2K.H){q-1}F{f(2L.H>2K.H){q 1}F{f(2L.v<2K.v){q-1}F{f(2L.v>2K.v){q 1}}}}q 0},2D:h(8d,2G){h 8e(3W,81){q[R l.4i(3W[0],3W.H,81.12)]};p a2=0,3X=u,3y=[],8c=2G.4m?2G.4m:8e;28((3X=2G.3D.N(8d))!=u){3y=3y.2H(8c(3X,2G))}q 3y},6o:h(8f){q 8f.D(l.8a.3e,h(m){q"<a 2q=\\""+m+"\\">"+m+"</a>"})}},1I:h(7c,4l){h 88(4s){p 49=[];C(p i=0;i<4s.v;i++){49.K(4s[i])}q 49};p 3m=4l?[4l]:88(J.7M(l.Q.7I)),7g="1r",2t=u;f(3m.v===0){q}C(p i=0;i<3m.v;i++){p 2F=3m[i],2s=l.B.7d(2F.Y),2Y;2s=l.B.5u(7c,2s);2Y=2s["7J"];f(2Y==u){1V}f(2s["2j-2n"]=="U"){2t=R l.44(2Y)}F{p 4o=l.B.4c(2Y);f(4o){2t=R 4o()}F{1V}}2t.1I(2F[7g],2s);p 2l=2t.z;f(l.Q.7j){2l=J.1t("a0");2l.1W=2t.z.1r;2l.1f.1N="aj";2l.1f.2u="aE"}2F.71.aF(2l,2F)}},aD:h(76){l.B.78(1o,"aC",h(){l.1I(76)})}};l.4i=h(4j,75,12){c.1W=4j;c.H=75;c.v=4j.v;c.12=12};l.4i.Z.2f=h(){q c.1W};l.44=h(4g){p 1H=l.B.4c(4g),4f=R l.30.aA(),aB=u;f(1H==u){q}1H=R 1H();c.4X=4f;f(1H.3K==u){l.B.1u(l.Q.1b.7z+4g);q}4f.4B.K({3D:1H.3K.I,4m:7F});h 39(4d,7G){C(p j=0;j<4d.v;j++){4d[j].H+=7G}};h 7F(14,aH){p 7x=14.I,1E=[],4k=1H.4B,7p=14.H+14.E.v,2X=1H.3K,1n;C(p i=0;i<4k.v;i++){1n=l.B.2D(7x,4k[i]);39(1n,7p);1E=1E.2H(1n)}f(2X.E!=u&&14.E!=u){1n=l.B.2D(14.E,2X.E);39(1n,14.H);1E=1E.2H(1n)}f(2X.17!=u&&14.17!=u){1n=l.B.2D(14.17,2X.17);39(1n,14.H+14[0].aM(14.17));1E=1E.2H(1n)}q 1E}};l.44.Z.1I=h(7u,7t){c.4X.1I(7u,7t);c.z=c.4X.z};l.87=h(){};l.87.Z={T:h(7v,7n){p 5J=c.1L[7v];q l.B.7w(5J==u?7n:5J)},15:h(7y){q J.1t(7y)},7m:h(5G){C(p i=0;i<c.1Y.v;i++){p 2V=c.1Y[i];f(2V===u){1V}f((5G.H>2V.H)&&(5G.H<2V.H+2V.v)){q U}}q O},6v:h(3v,7D){p 2e=[];f(3v!=u){C(p i=0;i<3v.v;i++){2e=2e.2H(l.B.2D(7D,3v[i]))}}2e=2e.aL(l.B.7B);q 2e},6u:h(){C(p i=0;i<c.1Y.v;i++){f(c.7m(c.1Y[i])){c.1Y[i]=u}}},6k:h(2C){p 3w=2C.21(/\\n/g),3s=7l(c.T("73-2E")),7e=(3s+3w.v).2f().v,89=c.T("1I",[]);2C="";C(p i=0;i<3w.v;i++){p 1s=3w[i],2w=/^(&1O;|\\s)+/.N(1s),5w="2E aK"+(i%2==0?1:2),82=l.B.7f(3s+i,7e),83=89.1h((3s+i).2f())!=-1,1D=u;f(2w!=u){1D=2w[0].2f();1s=1s.1M(1D.v);1D=1D.D(/&1O;/g," ");2w=l.1p.3q*1D.v}F{2w=0}1s=l.B.3P(1s);f(1s.v==0){1s="&1O;"}f(83){5w+=" aI"}2C+="<z 1e=\\""+5w+"\\">"+"<I 1e=\\"aJ\\">"+82+".</I>"+"<1T 1e=\\"5h\\">"+(1D!=u?"<I 1e=\\"az\\">"+1D.D(/\\s/g,"&1O;")+"</I>":"")+"<1T 1e=\\"7V\\" 1f=\\"5n-E: "+2w+"5H !aq;\\">"+1s+"</1T>"+"</1T>"+"</z>"}q 2C},6w:h(5N,5K){p 18=0,3n="",3r=l.B.80;C(p i=0;i<5K.v;i++){p 1y=5K[i];f(1y===u||1y.v===0){1V}3n+=3r(5N.1M(18,1y.H-18),"63")+3r(1y.1W,1y.12);18=1y.H+1y.v}3n+=3r(5N.1M(18),"63");q 3n},1I:h(1g,5R){p am=l.Q,3p=l.1p,z,34;c.1L={};c.z=u;c.26=u;c.I=u;c.2d=u;c.5E={};c.1j=l.B.5m("ar");3p.5j[c.1j]=c;f(1g===u){1g=""}f(3p.3q===u){3p.3q=l.B.5y()}c.1L=l.B.5u(l.5S,5R||{});f(c.T("6J")==U){c.1L.1q=c.1L.5x=O}c.z=z=c.15("37");c.26=c.15("37");c.26.Y="26";z.Y="6L";z.1j=c.1j;f(c.T("5v")){z.Y+=" 5t"}f(c.T("5x")==O){z.Y+=" ax"}z.Y+=" "+c.T("1e-1c");z.1f.av=c.T("2a-1P","");c.5r=1g;c.I=l.B.6U(1g).D(/\\r/g," ");34=c.T("1F-1P");c.I=c.T("6T-6S")==U?l.B.6P(c.I,34):l.B.6Q(c.I,34);c.I=l.B.2W(c.I);f(c.T("1q")){c.2d=c.15("37");c.2d.Y="2d";c.2d.1z(l.1q.15(c));z.1z(c.2d)}f(c.T("5F")){z.1z(l.B.6x())}z.1z(c.26);c.1Y=c.6v(c.4B,c.I);c.6u();1g=c.6w(c.I,c.1Y);1g=c.6k(l.B.3P(1g));f(c.T("6i-6p")){1g=l.B.6o(1g)}c.26.1r=1g},au:h(A){A=A.D(/^\\s+|\\s+$/g,"").D(/\\s+/g,"\\\\b|\\\\b");q"\\\\b"+A+"\\\\b"},at:h(2z){c.3K={E:{3D:2z.E,12:"2n"},17:{3D:2z.17,12:"2n"},I:R M("(?<E>"+2z.E.1i+")"+"(?<I>.*?)"+"(?<17>"+2z.17.1i+")","aw")}}};q l}()}f(!5B.1h){5B.Z.1h=h(5V,3J){3J=3z.as(3J||0,0);C(p i=3J;i<c.v;i++){f(c[i]==5V){q i}}q-1}}f(!1o.M){(h(){p 2v={N:V.Z.N,64:5q.Z.64,D:5q.Z.D,21:5q.Z.21},1G={11:/(?:[^\\\\([#\\s.]+|\\\\(?!k<[\\w$]+>|[65]{[^}]+})[\\S\\s]?|\\((?=\\?(?!#|<[\\w$]+>)))+|(\\()(?:\\?(?:(#)[^)]*\\)|<([$\\w]+)>))?|\\\\(?:k<([\\w$]+)>|[65]{([^}]+)})|(\\[\\^?)|([\\S\\s])/g,al:/(?:[^$]+|\\$(?![1-9$&`\']|{[$\\w]+}))+|\\$(?:([1-9]\\d*|[$&`\'])|{([$\\w]+)})/g,3F:/^(?:\\s+|#.*)+/,3R:/^(?:[?*+]|{\\d+(?:,\\d*)?})/,7H:/&&\\[\\^?/g,7q:/]/g},7N=h(5I,7Y,7K){C(p i=7K||0;i<5I.v;i++){f(5I[i]===7Y){q i}}q-1},7k=/()??/.N("")[1]!==3A,3L={};M=h(1d,1U){f(1d 4T V){f(1U!==3A){3G 62("56\'t 58 an 6G ao 5X V ap ay")}q 1d.3I()}p 1U=1U||"",7s=1U.1h("s")>-1,7r=1U.1h("x")>-1,4b=O,3C=[],13=[],11=1G.11,G,3N,3O,3E,3B;11.L=0;28(G=2v.N.2x(11,1d)){f(G[2]){f(!1G.3R.1R(1d.19(11.L))){13.K("(?:)")}}F{f(G[1]){3C.K(G[3]||u);f(G[3]){4b=U}13.K("(")}F{f(G[4]){3E=7N(3C,G[4]);13.K(3E>-1?"\\\\"+(3E+1)+(5z(1d.5O(11.L))?"":"(?:)"):G[0])}F{f(G[5]){13.K(3L.6Z?3L.6Z.7C(G[5],G[0].5O(1)==="P"):G[0])}F{f(G[6]){f(1d.5O(11.L)==="]"){13.K(G[6]==="["?"(?!)":"[\\\\S\\\\s]");11.L++}F{3N=M.6E("&&"+1d.19(G.H),1G.7H,1G.7q,"",{5W:"\\\\"})[0];13.K(G[6]+3N+"]");11.L+=3N.v+1}}F{f(G[7]){f(7s&&G[7]==="."){13.K("[\\\\S\\\\s]")}F{f(7r&&1G.3F.1R(G[7])){3O=2v.N.2x(1G.3F,1d.19(11.L-1))[0].v;f(!1G.3R.1R(1d.19(11.L-1+3O))){13.K("(?:)")}11.L+=3O-1}F{13.K(G[7])}}}F{13.K(G[0])}}}}}}}3B=V(13.4h(""),2v.D.2x(1U,/[aG]+/g,""));3B.1v={1i:1d,2o:4b?3C:u};q 3B};M.ak=h(1c,o){3L[1c]=o};V.Z.N=h(A){p 1a=2v.N.2x(c,A),1c,i,5g;f(1a){f(7k&&1a.v>1){5g=R V("^"+c.1i+"$(?!\\\\s)",c.3U());2v.D.2x(1a[0],5g,h(){C(i=1;i<7b.v-2;i++){f(7b[i]===3A){1a[i]=3A}}})}f(c.1v&&c.1v.2o){C(i=1;i<1a.v;i++){1c=c.1v.2o[i-1];f(1c){1a[1c]=1a[i]}}}f(c.3H&&c.L>(1a.H+1a[0].v)){c.L--}}q 1a}})()}V.Z.3U=h(){q(c.3H?"g":"")+(c.9Z?"i":"")+(c.6W?"m":"")+(c.3F?"x":"")+(c.a1?"y":"")};V.Z.3I=h(7Q){p 3T=R M(c.1i,(7Q||"")+c.3U());f(c.1v){3T.1v={1i:c.1v.1i,2o:c.1v.2o?c.1v.2o.19(0):u}}q 3T};V.Z.2x=h(a3,A){q c.N(A)};V.Z.9S=h(9R,7W){q c.N(7W[0])};M.3Z=h(4r,4Z){p 40="/"+4r+"/"+(4Z||"");q M.3Z[40]||(M.3Z[40]=R M(4r,4Z))};M.3M=h(A){q A.D(/[-[\\]{}()*+?.\\\\^$|,#\\s]/g,"\\\\$&")};M.6E=h(A,E,W,1k,2M){p 2M=2M||{},2U=2M.5W,X=2M.af,1k=1k||"",4O=1k.1h("g")>-1,6y=1k.1h("i")>-1,5U=1k.1h("m")>-1,4H=1k.1h("y")>-1,1k=1k.D(/y/g,""),E=E 4T V?(E.3H?E:E.3I("g")):R M(E,"g"+1k),W=W 4T V?(W.3H?W:W.3I("g")):R M(W,"g"+1k),1K=[],2r=0,1m=0,1l=0,1x=0,27,1Z,1w,1B,3Q,4n;f(2U){f(2U.v>1){3G ae("56\'t 58 ag ad 5X 3M 6I")}f(5U){3G 62("56\'t 58 3M 6I 6G a8 a9 6W aP")}3Q=M.3M(2U);4n=R V("^(?:"+3Q+"[\\\\S\\\\s]|(?:(?!"+E.1i+"|"+W.1i+")[^"+3Q+"])+)+",6y?"i":"")}28(U){E.L=W.L=1l+(2U?(4n.N(A.19(1l))||[""])[0].v:0);1w=E.N(A);1B=W.N(A);f(1w&&1B){f(1w.H<=1B.H){1B=u}F{1w=u}}f(1w||1B){1m=(1w||1B).H;1l=(1w?E:W).L}F{f(!2r){2B}}f(4H&&!2r&&1m>1x){2B}f(1w){f(!2r++){27=1m;1Z=1l}}F{f(1B&&2r){f(!--2r){f(X){f(X[0]&&27>1x){1K.K([X[0],A.19(1x,27),1x,27])}f(X[1]){1K.K([X[1],A.19(27,1Z),27,1Z])}f(X[2]){1K.K([X[2],A.19(1Z,1m),1Z,1m])}f(X[3]){1K.K([X[3],A.19(1m,1l),1m,1l])}}F{1K.K(A.19(1Z,1m))}1x=1l;f(!4O){2B}}}F{E.L=W.L=0;3G b6("bw bp 8l 8u 8A")}}f(1m===1l){1l++}}f(4O&&!4H&&X&&X[0]&&A.v>1x){1K.K([X[0],A.19(1x),1x,A.v])}E.L=W.L=0;q 1K};',62,725,'||||||||||||this|||if||function||||sh||||var|return||||null|length||||div|str|utils|for|replace|left|else|_109|index|code|document|push|lastIndex|XRegExp|exec|false||config|new||getParam|true|RegExp|_121|vN|className|prototype||part|css|_107|_c3|create||right|pos|slice|_111|strings|name|_101|class|style|_ed|indexOf|source|id|_122|_12d|_12c|_ca|window|vars|toolbar|innerHTML|_e0|createElement|alert|_x|_131|_12e|_ec|appendChild|obj|_132|lt|_e5|_c6|tab|lib|_bd|highlight|doc|_12a|params|substr|width|nbsp|size|_97|test|_4b|span|_102|continue|value|in|matches|_130|_91|split|_8|_57|min|_3c|lines|_12f|while|_56|font|wnd|text|bar|_d7|toString|_6e|execute|_75|html|_5b|_b7|gt|script|captureNames|attributes|href|_12b|_b4|_b1|height|_f8|_e1|call|http|_f4|_28|break|_da|getMatches|line|_b3|_a1|concat|_51|case|m2|m1|_123|_5|_80|_88|_81|body|_40|_62|_124|_d4|unindent|_c9|_b5|_7a|brushes|SyntaxHighlighter|_2|_22|_f2|_32|title|DIV|_3|offsetMatches|_7d|_7b|_8e|fixForBlogger|url|_7c|_5e|_65|_6a|_5c|_76|_4a|_af|_e9|printFrame|_f0|spaceWidth|_ea|_dc|write|print|_d5|_db|_25|_a6|Math|undefined|_10d|_106|regex|_10c|extended|throw|global|addFlags|_f6|htmlScript|_100|escape|cc|len|trim|_133|quantifier|_9d|_116|getNativeFlags|_9c|_a2|_a5|viewSource|cache|key|_89|eachLine|_2c|HtmlScript|_18|_30|gi|_2f|_ad|com|_105|findBrush|_c0|expandSource|_be|_bc|join|Match|_b9|_c7|_ab|func|esc|_b6|_19|_1a|_11b|_ac|swf|_4c|_9|_b|_49|popup|top|focus|regexList|_50|_4f|_48|_e|_7|_129|_38|contentWindow|link|_4|gm|close|_126|_blank|win|_35|_24|instanceof|_73|_6b|_82|xmlBrush|_17|_11c||removeChild|_7e|color|values|_5d|can|_f|supply|discoveredBrushes|_59|_6c|_10|_37|_d|_8c|r2|content|toolbarItemWidth|highlighters|toolbarItemHeight|copyToClipboard|guid|margin|_2e|_2d|String|originalCode|_2a|collapsed|merge|collapse|_e2|gutter|measureSpace|isNaN|_2b|Array|_29|clipboardSwf|toolbarCommands|ruler|_d2|px|_fb|_d0|_e7|pre|_27|_e6|charAt|highlighterId|_83|_ee|defaults|_14|_128|_f5|escapeChar|one|_5a|noBrush|_61|navigator|TypeError|plain|match|pP|_78|_79|_36|_6d|alexgorbatchev|userAgent|commandName|_66|clipboardData|executeCommand|event|help|auto|_6|createDisplayLines|500px|0px|scrollbars|processUrls|links|stylesheet|rel|_3f|copyStyles|removeNestedMatches|findMatches|processMatches|createRuler|_127|type|_3e|aboutDialog|createButton|attachEvent|matchRecursive|message|when|2009|character|light|clipboard|syntaxhighlighter|_4e|screen|_a|processSmartTabs|processTabs|_47|tabs|smart|trimFirstAndLastLines|switch|multiline|copyToClipboardConfirmation|_85|unicode|head|parentNode|_16|first|shockwave|_ba|_b8|items|addEvent|flash|_13|arguments|_aa|parseParams|_dd|padNumber|_b0|Times|_12|debug|_ff|parseInt|isMatchNested|_cf|org|_c8|classRight|_104|_103|_cd|_cc|_ce|toBoolean|_c5|_d1|brushNotHtmlScript|www|matchesSortCallback|get|_d6|w3|process|_c1|classLeft|tagName|brush|_fd|serif|getElementsByTagName|_fa|_15|bloggerMode|_115|_84|_99|family|_93|block|args|insertSpaces|_fc|_90|decorate|_a3|_e3|_e4|version|center|xhtml1|Highlighter|toArray|_de|regexLib|DTD|_a7|_a0|defaultAdd|_a8|_1e|object|align|try|resizable|contains|catch|400|_20|_1f|onclick|750|menubar|_21|unbalanced|_1b|item|location|_26|param|delimiters|_1c|sans|1999|xhtml|meta|xmlns|dtd|EN|TR|transitional|equiv|Content|Georgia|New|Roman|About|utf|Type|charset|Transitional|XHTML|is|your|now|The|to|expand|view|copy|Can|find|DOCTYPE|PUBLIC|W3C|option|configured|Brush|wasn|background|fff|Gorbatchev|multiLineCComments|singleLineCComments|Alex|2004|syntax|highlighter|Copyright|singleLinePerlComments|doubleQuotedString|aspScriptTags|scriptScriptTags|typeof|phpScriptTags|multiLineSingleQuotedString|singleQuotedString|multiLineDoubleQuotedString|JavaScript|none|Helvetica|xx|large|Arial|Geneva|000|1em|3em|75em|bottom|target|0099FF|decoration|01|March|4em|296|string|open|_119|apply|_8a|offsetWidth|getComputedStyle|getPropertyValue|_98|1000|ignoreCase|textarea|sticky|_a4|_117|opera|getElementById|on|addEventListener|using|the|random|1000000|aliases|than|SyntaxError|valueNames|more|middot|_clipboard|70em|addPlugin|replaceVar|_ef|flags|constructing|from|important|highlighter_|max|forHtmlScript|getKeywords|fontSize|sgi|nogutter|another|spaces|Xml|_bf|load|all|30em|replaceChild|sx|_c4|highlighted|number|alt|sort|lastIndexOf|round|150|flag|msie|src|embed|classid|movie|_33|_34|ok|error|setData|amp|command|cab|swflash|96b8|11cf|Error|444553540000|codebase|ae6d|download|pub|cabs|clsid|macromedia|d27cdb6e|_39|printSource|shCore|about|toLowerCase|allowScriptAccess|always|printing|_42|data|500||250|_44|application|_43|subject|wmode|_3a|flashVars|transparent|_3b|cssText|absolute|position|menu|IFRAME'.split('|'),0,{}))
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Alloy = function()
{
	var keywords =	'abstract assert ' +
					'assert fact in all else extends ' +
					'module sig ' +
					'String Int ' +
					'one some lone set no ';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,	css: 'comments' },		// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,		css: 'comments' },		// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },		// strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },		// strings
		{ regex: /\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,			css: 'value' },			// numbers
		{ regex: /(?!\@interface\b)\@[\$\w]+\b/g,			css: 'color1' },		// annotation @anno
		{ regex: /\@interface\b/g,					css: 'color2' },		// @interface keyword
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' }		// java keyword
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags);
};

SyntaxHighlighter.brushes.Alloy.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Alloy.aliases		= ['Alloy', 'alloy', 'als'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Cpp = function()
{
	// Copyright 2006 Shin, YoungJin
	
	var datatypes =	'ATOM BOOL BOOLEAN BYTE CHAR COLORREF DWORD DWORDLONG DWORD_PTR ' +
					'DWORD32 DWORD64 FLOAT HACCEL HALF_PTR HANDLE HBITMAP HBRUSH ' +
					'HCOLORSPACE HCONV HCONVLIST HCURSOR HDC HDDEDATA HDESK HDROP HDWP ' +
					'HENHMETAFILE HFILE HFONT HGDIOBJ HGLOBAL HHOOK HICON HINSTANCE HKEY ' +
					'HKL HLOCAL HMENU HMETAFILE HMODULE HMONITOR HPALETTE HPEN HRESULT ' +
					'HRGN HRSRC HSZ HWINSTA HWND INT INT_PTR INT32 INT64 LANGID LCID LCTYPE ' +
					'LGRPID LONG LONGLONG LONG_PTR LONG32 LONG64 LPARAM LPBOOL LPBYTE LPCOLORREF ' +
					'LPCSTR LPCTSTR LPCVOID LPCWSTR LPDWORD LPHANDLE LPINT LPLONG LPSTR LPTSTR ' +
					'LPVOID LPWORD LPWSTR LRESULT PBOOL PBOOLEAN PBYTE PCHAR PCSTR PCTSTR PCWSTR ' +
					'PDWORDLONG PDWORD_PTR PDWORD32 PDWORD64 PFLOAT PHALF_PTR PHANDLE PHKEY PINT ' +
					'PINT_PTR PINT32 PINT64 PLCID PLONG PLONGLONG PLONG_PTR PLONG32 PLONG64 POINTER_32 ' +
					'POINTER_64 PSHORT PSIZE_T PSSIZE_T PSTR PTBYTE PTCHAR PTSTR PUCHAR PUHALF_PTR ' +
					'PUINT PUINT_PTR PUINT32 PUINT64 PULONG PULONGLONG PULONG_PTR PULONG32 PULONG64 ' +
					'PUSHORT PVOID PWCHAR PWORD PWSTR SC_HANDLE SC_LOCK SERVICE_STATUS_HANDLE SHORT ' +
					'SIZE_T SSIZE_T TBYTE TCHAR UCHAR UHALF_PTR UINT UINT_PTR UINT32 UINT64 ULONG ' +
					'ULONGLONG ULONG_PTR ULONG32 ULONG64 USHORT USN VOID WCHAR WORD WPARAM WPARAM WPARAM ' +
					'char bool short int __int32 __int64 __int8 __int16 long float double __wchar_t ' +
					'clock_t _complex _dev_t _diskfree_t div_t ldiv_t _exception _EXCEPTION_POINTERS ' +
					'FILE _finddata_t _finddatai64_t _wfinddata_t _wfinddatai64_t __finddata64_t ' +
					'__wfinddata64_t _FPIEEE_RECORD fpos_t _HEAPINFO _HFILE lconv intptr_t ' +
					'jmp_buf mbstate_t _off_t _onexit_t _PNH ptrdiff_t _purecall_handler ' +
					'sig_atomic_t size_t _stat __stat64 _stati64 terminate_function ' +
					'time_t __time64_t _timeb __timeb64 tm uintptr_t _utimbuf ' +
					'va_list wchar_t wctrans_t wctype_t wint_t signed';

	var keywords =	'break case catch class const __finally __exception __try ' +
					'const_cast continue private public protected __declspec ' +
					'default delete deprecated dllexport dllimport do dynamic_cast ' +
					'else enum explicit extern if for friend goto inline ' +
					'mutable naked namespace new noinline noreturn nothrow ' +
					'register reinterpret_cast return selectany ' +
					'sizeof static static_cast struct switch template this ' +
					'thread throw true false try typedef typeid typename union ' +
					'using uuid virtual void volatile whcar_t while';
					
	var functions =	'assert isalnum isalpha iscntrl isdigit isgraph islower isprint' +
					'ispunct isspace isupper isxdigit tolower toupper errno localeconv ' +
					'setlocale acos asin atan atan2 ceil cos cosh exp fabs floor fmod ' +
					'frexp ldexp log log10 modf pow sin sinh sqrt tan tanh jmp_buf ' +
					'longjmp setjmp raise signal sig_atomic_t va_arg va_end va_start ' +
					'clearerr fclose feof ferror fflush fgetc fgetpos fgets fopen ' +
					'fprintf fputc fputs fread freopen fscanf fseek fsetpos ftell ' +
					'fwrite getc getchar gets perror printf putc putchar puts remove ' +
					'rename rewind scanf setbuf setvbuf sprintf sscanf tmpfile tmpnam ' +
					'ungetc vfprintf vprintf vsprintf abort abs atexit atof atoi atol ' +
					'bsearch calloc div exit free getenv labs ldiv malloc mblen mbstowcs ' +
					'mbtowc qsort rand realloc srand strtod strtol strtoul system ' +
					'wcstombs wctomb memchr memcmp memcpy memmove memset strcat strchr ' +
					'strcmp strcoll strcpy strcspn strerror strlen strncat strncmp ' +
					'strncpy strpbrk strrchr strspn strstr strtok strxfrm asctime ' +
					'clock ctime difftime gmtime localtime mktime strftime time';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,	css: 'comments' },			// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,		css: 'comments' },			// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },			// strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },			// strings
		{ regex: /^ *#.*/gm,										css: 'preprocessor' },
		{ regex: new RegExp(this.getKeywords(datatypes), 'gm'),		css: 'color1 bold' },
		{ regex: new RegExp(this.getKeywords(functions), 'gm'),		css: 'functions bold' },
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword bold' }
		];
};

SyntaxHighlighter.brushes.Cpp.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Cpp.aliases	= ['cpp', 'c'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Java = function()
{
	var keywords =	'abstract assert boolean break byte case catch char class const ' +
					'continue default do double else enum extends ' +
					'false final finally float for goto if implements import ' +
					'instanceof int interface long native new null ' +
					'package private protected public return ' +
					'short static strictfp super switch synchronized this throw throws true ' +
					'transient try void volatile while';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,	css: 'comments' },		// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,		css: 'comments' },		// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },		// strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },		// strings
		{ regex: /\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,				css: 'value' },			// numbers
		{ regex: /(?!\@interface\b)\@[\$\w]+\b/g,					css: 'color1' },		// annotation @anno
		{ regex: /\@interface\b/g,									css: 'color2' },		// @interface keyword
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' }		// java keyword
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags);
};

SyntaxHighlighter.brushes.Java.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Java.aliases		= ['java'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.NuSMV = function()
{
	var keywords =	'MODULE ' +
					'IVAR VAR ASSIGN DEFINE TRANS ' +
					'INVARSPEC SPEC CTLSPEC LTLSPEC ' +
					'next init esac case TRUE FALSE ' +
					'main EF AG AX AF EX EG U A E ';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,	css: 'comments' },		// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,		css: 'comments' },		// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },		// strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },		// strings
		{ regex: /\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,			css: 'value' },			// numbers
		{ regex: /(?!\@interface\b)\@[\$\w]+\b/g,			css: 'color1' },		// annotation @anno
		{ regex: /\@interface\b/g,					css: 'color2' },		// @interface keyword
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' }		// java keyword
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags);
};

SyntaxHighlighter.brushes.NuSMV.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.NuSMV.aliases		= ['NuSMV', 'nusmv', 'smv'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Php = function()
{
	var funcs	=	'abs acos acosh addcslashes addslashes ' +
					'array_change_key_case array_chunk array_combine array_count_values array_diff '+
					'array_diff_assoc array_diff_key array_diff_uassoc array_diff_ukey array_fill '+
					'array_filter array_flip array_intersect array_intersect_assoc array_intersect_key '+
					'array_intersect_uassoc array_intersect_ukey array_key_exists array_keys array_map '+
					'array_merge array_merge_recursive array_multisort array_pad array_pop array_product '+
					'array_push array_rand array_reduce array_reverse array_search array_shift '+
					'array_slice array_splice array_sum array_udiff array_udiff_assoc '+
					'array_udiff_uassoc array_uintersect array_uintersect_assoc '+
					'array_uintersect_uassoc array_unique array_unshift array_values array_walk '+
					'array_walk_recursive atan atan2 atanh base64_decode base64_encode base_convert '+
					'basename bcadd bccomp bcdiv bcmod bcmul bindec bindtextdomain bzclose bzcompress '+
					'bzdecompress bzerrno bzerror bzerrstr bzflush bzopen bzread bzwrite ceil chdir '+
					'checkdate checkdnsrr chgrp chmod chop chown chr chroot chunk_split class_exists '+
					'closedir closelog copy cos cosh count count_chars date decbin dechex decoct '+
					'deg2rad delete ebcdic2ascii echo empty end ereg ereg_replace eregi eregi_replace error_log '+
					'error_reporting escapeshellarg escapeshellcmd eval exec exit exp explode extension_loaded '+
					'feof fflush fgetc fgetcsv fgets fgetss file_exists file_get_contents file_put_contents '+
					'fileatime filectime filegroup fileinode filemtime fileowner fileperms filesize filetype '+
					'floatval flock floor flush fmod fnmatch fopen fpassthru fprintf fputcsv fputs fread fscanf '+
					'fseek fsockopen fstat ftell ftok getallheaders getcwd getdate getenv gethostbyaddr gethostbyname '+
					'gethostbynamel getimagesize getlastmod getmxrr getmygid getmyinode getmypid getmyuid getopt '+
					'getprotobyname getprotobynumber getrandmax getrusage getservbyname getservbyport gettext '+
					'gettimeofday gettype glob gmdate gmmktime ini_alter ini_get ini_get_all ini_restore ini_set '+
					'interface_exists intval ip2long is_a is_array is_bool is_callable is_dir is_double '+
					'is_executable is_file is_finite is_float is_infinite is_int is_integer is_link is_long '+
					'is_nan is_null is_numeric is_object is_readable is_real is_resource is_scalar is_soap_fault '+
					'is_string is_subclass_of is_uploaded_file is_writable is_writeable mkdir mktime nl2br '+
					'parse_ini_file parse_str parse_url passthru pathinfo readlink realpath rewind rewinddir rmdir '+
					'round str_ireplace str_pad str_repeat str_replace str_rot13 str_shuffle str_split '+
					'str_word_count strcasecmp strchr strcmp strcoll strcspn strftime strip_tags stripcslashes '+
					'stripos stripslashes stristr strlen strnatcasecmp strnatcmp strncasecmp strncmp strpbrk '+
					'strpos strptime strrchr strrev strripos strrpos strspn strstr strtok strtolower strtotime '+
					'strtoupper strtr strval substr substr_compare';

	var keywords =	'and or xor array as break case ' +
					'cfunction class const continue declare default die do else ' +
					'elseif enddeclare endfor endforeach endif endswitch endwhile ' +
					'extends for foreach function include include_once global if ' +
					'new old_function return static switch use require require_once ' +
					'var while abstract interface public implements extends private protected throw';
	
	var constants	= '__FILE__ __LINE__ __METHOD__ __FUNCTION__ __CLASS__';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,	css: 'comments' },			// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,		css: 'comments' },			// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },			// double quoted strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },			// single quoted strings
		{ regex: /\$\w+/g,											css: 'variable' },			// variables
		{ regex: new RegExp(this.getKeywords(funcs), 'gmi'),		css: 'functions' },			// common functions
		{ regex: new RegExp(this.getKeywords(constants), 'gmi'),	css: 'constants' },			// constants
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' }			// keyword
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.phpScriptTags);
};

SyntaxHighlighter.brushes.Php.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Php.aliases	= ['php'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
 SyntaxHighlighter.brushes.Python = function()
 {
     var keywords = 'and assert break class continue def del elif else ' +
     'except exec finally for from global if import in is ' +
     'lambda not or pass raise return try yield while';

     var funcs = '__import__ abs all any apply basestring bin bool buffer callable ' +
     'chr classmethod cmp coerce compile complex delattr dict dir ' +
     'divmod enumerate eval execfile file filter float format frozenset ' +
     'getattr globals hasattr hash help hex id input int intern ' +
     'isinstance issubclass iter len list locals long map max min next ' +
     'object oct open ord pow print property range raw_input reduce ' +
     'reload repr reversed round set setattr slice sorted staticmethod ' +
     'str sum super tuple type type unichr unicode vars xrange zip';

     var special = 'None True False self cls class_';

     this.regexList = [
         { regex: SyntaxHighlighter.regexLib.singleLinePerlComments,	css: 'comments' },		// one line comments
         { regex: SyntaxHighlighter.regexLib.singleLineCComments,	    css: 'comments' },      // Umple comments
         { regex: /^\s*@\w+/gm,                                         css: 'decorator' },     // decorators
         { regex: /(['\"]{3})([^\1])*?\1/gm,                            css: 'comments' },      // multiline comments
         { regex: /"(?!")(?:\.|\\\"|[^\""\n])*"/gm,                     css: 'string' },        // String double quote
         { regex: /'(?!')(?:\.|(\\\')|[^\''\n])*'/gm,                   css: 'string' },        // String single quote
         { regex: /\+|\-|\*|\/|\%|=|==/gm,                              css: 'keyword' },       // Keywords
         { regex: /\b\d+\.?\w*/g,				                        css: 'value' },			// numbers
         { regex: new RegExp(this.getKeywords(funcs), 'gm'),		    css: 'functions' },		// python functions
         { regex: new RegExp(this.getKeywords(keywords), 'gm'),		    css: 'keyword' },		// python keywords
         { regex: new RegExp(this.getKeywords(special), 'gm'),		    css: 'color1' }		    // python special
         ];
 
     this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags);
 };
 
 SyntaxHighlighter.brushes.Python.prototype	= new SyntaxHighlighter.Highlighter();
 SyntaxHighlighter.brushes.Python.aliases		= ['py', 'python'];
 
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Ruby = function()
{
	// Contributed by Erik Peterson.
	
	var keywords =	'alias and BEGIN begin break case class def define_method defined do each else elsif ' +
					'END end ensure false for if in module new next nil not or raise redo rescue retry return ' +
					'self super then throw true undef unless until when while yield';

	var builtins =	'Array Bignum Binding Class Continuation Dir Exception FalseClass File::Stat File Fixnum Fload ' +
					'Hash Integer IO MatchData Method Module NilClass Numeric Object Proc Range Regexp String Struct::TMS Symbol ' +
					'ThreadGroup Thread Time TrueClass';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLinePerlComments,	css: 'comments' },		// one line comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },		// double quoted strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,		css: 'string' },		// single quoted strings
		{ regex: /\b[A-Z0-9_]+\b/g,									css: 'constants' },		// constants
		{ regex: /:[a-z][A-Za-z0-9_]*/g,							css: 'color2' },		// symbols
		{ regex: /(\$|@@|@)\w+/g,									css: 'variable bold' },	// $global, @instance, and @@class variables
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' },		// keywords
		{ regex: new RegExp(this.getKeywords(builtins), 'gm'),		css: 'color1' }			// builtins
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags);
};

SyntaxHighlighter.brushes.Ruby.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Ruby.aliases		= ['ruby', 'rails', 'ror'];
/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Sql = function()
{
	var funcs	=	'abs avg case cast coalesce convert count current_timestamp ' +
					'current_user day isnull left lower month nullif replace right ' +
					'session_user space substring sum system_user upper user year';

	var keywords =	'absolute action add after alter as asc at authorization begin bigint ' +
					'binary bit by cascade char character check checkpoint close collate ' +
					'column commit committed connect connection constraint contains continue ' +
					'create cube current current_date current_time cursor database date ' +
					'deallocate dec decimal declare default delete desc distinct double drop ' +
					'dynamic else end end-exec escape except exec execute false fetch first ' +
					'float for force foreign forward free from full function global goto grant ' +
					'group grouping having hour ignore index inner insensitive insert instead ' +
					'int integer intersect into is isolation key last level load local max min ' +
					'minute modify move name national nchar next no numeric of off on only ' +
					'open option order out output partial password precision prepare primary ' +
					'prior privileges procedure public read real references relative repeatable ' +
					'restrict return returns revoke rollback rollup rows rule schema scroll ' +
					'second section select sequence serializable set size smallint static ' +
					'statistics table temp temporary then time timestamp to top transaction ' +
					'translation trigger true truncate uncommitted union unique update values ' +
					'varchar varying view when where with work';

	var operators =	'all and any between cross in join like not null or outer some';

	this.regexList = [
		{ regex: /--(.*)$/gm,												css: 'comments' },			// one line and multiline comments
		{ regex: SyntaxHighlighter.regexLib.multiLineDoubleQuotedString,	css: 'string' },			// double quoted strings
		{ regex: SyntaxHighlighter.regexLib.multiLineSingleQuotedString,	css: 'string' },			// single quoted strings
		{ regex: new RegExp(this.getKeywords(funcs), 'gmi'),				css: 'color2' },			// functions
		{ regex: new RegExp(this.getKeywords(operators), 'gmi'),			css: 'color1' },			// operators and such
		{ regex: new RegExp(this.getKeywords(keywords), 'gmi'),				css: 'keyword' }			// keyword
		];
};

SyntaxHighlighter.brushes.Sql.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Sql.aliases	= ['sql'];

/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 * 
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 * 
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.Xml = function()
{
	function process(match, regexInfo)
	{
		var constructor = SyntaxHighlighter.Match,
			code = match[0],
			tag = new XRegExp('(&lt;|<)[\\s\\/\\?]*(?<name>[:\\w-\\.]+)', 'xg').exec(code),
			result = []
			;
		
		if (match.attributes != null) 
		{
			var attributes,
				regex = new XRegExp('(?<name> [\\w:\\-\\.]+)' +
									'\\s*=\\s*' +
									'(?<value> ".*?"|\'.*?\'|\\w+)',
									'xg');

			while ((attributes = regex.exec(code)) != null) 
			{
				result.push(new constructor(attributes.name, match.index + attributes.index, 'color1'));
				result.push(new constructor(attributes.value, match.index + attributes.index + attributes[0].indexOf(attributes.value), 'string'));
			}
		}

		if (tag != null)
			result.push(
				new constructor(tag.name, match.index + tag[0].indexOf(tag.name), 'keyword')
			);

		return result;
	}
	
	this.regexList = [
		{ regex: new XRegExp('(\\&lt;|<)\\!\\[[\\w\\s]*?\\[(.|\\s)*?\\]\\](\\&gt;|>)', 'gm'),			css: 'color2' },	// <![ ... [ ... ]]>
		{ regex: new XRegExp('(\\&lt;|<)!--\\s*.*?\\s*--(\\&gt;|>)', 'gm'),								css: 'comments' },	// <!-- ... -->
		{ regex: new XRegExp('(&lt;|<)[\\s\\/\\?]*(\\w+)(?<attributes>.*?)[\\s\\/\\?]*(&gt;|>)', 'sg'), func: process }
	];
};

SyntaxHighlighter.brushes.Xml.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Xml.aliases	= ['xml', 'xhtml', 'xslt', 'html', 'xhtml'];
/**
 * Class: InlineEditor
 *
 * Version 0.1 (pending)
 *
 * License: Public Domain
 *
 *
 * User-overridable functions:
 * More documentation further down in code.
 *
 *    InlineEditor.customEditor      = function( theElement ) { ...
 *    InlineEditor.editorValue    = fuction( theEditor ) { ...
 *    InlineEditor.elementValue   = function( theElement ) { ...
 *    InlineEditor.elementChanged = function( theElement, oldVal, newVal ) { ...
 *
 *
 * Key CSS class names:
 *    editable:   Tables with this class will have their 'td' cells made editable.
 *    uneditable: At event time, cells with this class will NOT be editable.
 *    editing:    When editing, the 'td' element will have this class.
 *
 *
 * Useful utility functions:
 *
 *    InlineEditor.addClass( element, classname )
 *        Adds classname to the 'class' attribute of the element.
 *
 *    InlineEditor.removeClass( element, classname )
 *        Removes classname from the 'class' attribute of the element.
 *
 *    InlineEditor.checkClass( element, classname )
 *        True if class attribute of the element contains classname, false otherwise.
 *
 *    InlineEditor.swapClass( element, classname1, classname2 )
 *        Replaces classname1 with classname2 in class attribute of the element.
 *
 *     InlineEditor.columnNumer( cell )
 *        Returns column number of cell (zero index) or -1 if there are problems.
 *
 *     InlineEditor.rowNumer( cell )
 *        Returns row number of cell (zero index) or -1 if there are problems.
 *
 *     InlineEditor.rowID( cell )
 *        Returns row ID, useful if you use that to tie to a database primary key.
 *
 *
 * Change Log:
 *
 *    v0.1.1 - More reliable window.onload event adding. Added customEditor
 *             extensible function.
 *    v0.1 - Initial release.
 *
 *
 * Author:
 *
 *    Robert Harder
 *    rharder # users,sf,net
 */

/** Global var to test for IE */
var inlineeditor_isIE = ( navigator.userAgent.toLowerCase().search( 'msie' ) != -1 && navigator.userAgent.toLowerCase().search( 'opera' ) == -1 ) ? true : false;

var InlineEditor = {

/* ********  F U N C T I O N S   Y O U   M I G H T   C A L L  ******** */
    alreadyInited : false,  // In case we get called twice.

    /**
     * This should be called automatically when the page loads,
     * but if you also are setting up a function to run on
     * window.onload then this might get bumped out of position.
     * If that's the case, then make sure you call InlineEditor.init()
     * yourself.
     *
     * If you create some nodes programmatically, you can also rerun
     * this code to scan for "editable" classes. Like this:
     *
     * var foo document.createElement('div');
     * foo.className = 'editable';
     * ...
     * InlineEditor.init( foo );
     */
 /*   init: function( arg )
    {
        // What is the arg?
        var isNode  = false;
        var isEvent = false;
        if( arg.nodeType )
        {
            isNode = true;
        }
        
        // If we're already inited and we're not being asked to
        // init a new a node, bail out.
        if( !isNode && InlineEditor.alreadyInited )
        {
        	return;
        }
            
        // Find all elements with class 'editable' and make them editable
        jQuery("[class$='editable']").live('click', InlineEditor.handleOnClick);
                
        if( !isNode )
            InlineEditor.alreadyInited = true;
    },  // end init
*/


    addClass:    function(o,c)     { return InlineEditor.jscss('add',o,c); },
    removeClass: function(o,c)     { return InlineEditor.jscss('remove',o,c); },
    checkClass:  function(o,c)     { return InlineEditor.jscss('check',o,c); },
    swapClass:   function(o,c1,c2) { return InlineEditor.jscss('swap',o,c1,c2); },


    /**
     * Return the column number, if a table cell.
     */
 /*   columnNumber: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        // Find cell and return column number
        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr  = cell.parentNode;
        var tds = tr.getElementsByTagName('TD');
        for( var i = 0; i < tds.length; i++ )
            if( tds[i] == cell )
                return i;

        return -1;
    },  // end columnNumber
*/

    /**
     * Return the row number, based on the row's immediate
     * parent, which may be a 'tbody' or the actual 'table'.
     */
/*    rowNumber: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        // Find cell's parent row and return row number
        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr  = cell.parentNode;
        var trs = tr.parentNode.childNodes;
        for( var i = 0; i < trs.length; i++ )
            if( trs[i] == tr )
                return i;

        return -1;
    },  // end rowNumber
*/


    /**
     * Returns the ID of the parent row. Useful if you use
     * that to track the row to some sort of database primary key.
     */
 /*   rowID: function( cell )
    {
        // Ensure we have a 'td' cell
        if( cell.nodeType != 1    ) return -1;
        if( cell.tagName  != 'TD' ) return -1;

        if( !cell.parentNode || cell.parentNode.tagName != 'TR' ) return -1;
        var tr = cell.parentNode;
        return tr.id;
    },  // end rowID


    sizeTo: function( changeMe, model )
    {
        changeMe.style.position = 'absolute';
        changeMe.style.zindex = 99;
        changeMe.style.left   = model .offsetLeft + 'px';
        changeMe.style.top    = model .offsetTop + 'px';
        changeMe.style.width  = model .offsetWidth + 'px';
        changeMe.style.height = model .offsetHeight + 'px';

        return changeMe;
    },  // end sizeTo
*/


/* ********  F U N C T I O N S   Y O U   M I G H T   O V E R R I D E  ******** */


    // These are examples of how you might override certain functions
    // if you want to add more complex behaviors.
    /*

...

your code

...
*/
    // The default editor is a one-line 'input' element.
    // If you need anything more complex like a textarea
    // or a select box or something, return it here.
    //
    // Remember to code the following:
    //
    //    - Set the editor's starting value
    //    - Set the editor's size
    //
    customEditor : function( theElement )
    {
		var editor = jQuery("<input/>");
		
		editor.attr("id", theElement.attr("id") +"_editor");
        editor.val(theElement.html() == "-- Add More --" ? "" : theElement.html());
        editor.width(theElement.parent().width() - 30);
        editor.height(theElement.offset().height);
        
        return editor;
    },   // end customEditor

/*
    // If you use a custom editor, you may need to provide a
    // way to determine what the value is. The default behavior,
    // which will still take over if you return nothing, is
    // to check for the presence of the 'value' property.
    // If your editor has no 'value' property then the 'innerHTML'
    // property is used. If this suits your needs
    // even with your custom editor, then there's no need to
    // use this function.
    //
    InlineEditor.editorValue = function( editor )
    {
        // Hypothetical editor with some obscure way
        // of determing what the user selection is.
        if( editor.tagName == 'SomeObscureControl' )
            return editor.squareRootOfSelectedMenuItem;     

    }   // end editorValue


...

    // If you have anything "funny" going on you're welcome
    // to define/override this function to determine just what
    // the starting value is. The default behavior, which will
    // be employed if you return nothing, is to use 'innerHTML'.
    InlineEditor.elementValue = function( theElement )
    {
        // Ignore the extra 'span' I threw in there. Just give me text.
        return theElement.innerText;

    }   // end elementValue



    // Unless you just want people to dink around with the
    // transient-by-nature current page, you'll probably want
    // to define/override this function and do something that
    // saves the user's changes. Here is an example using
    // "ajax" to immediately post a change. In this case,
    // I was using Google's Map APIs, so that's how I create
    // the HttpRequest.
    //
    InlineEditor.elementChanged = function( theElement, oldVal, newVal )
    {
        InlineEditor.addClass( theElement, 'uneditable' ); // Special InlineEditor class
        InlineEditor.addClass( theElement, 'saving' );     // My own class, maybe gray text

        var request = GXmlHttp.create(); // I was using Google's tools
        var url = "http://www.myserver.com/update.php?id=" + cell.id + "&val="+newVal;

        request.open("GET", url, true);
        request.onreadystatechange = function() {
            if (request.readyState == 4) {

                InlineEditor.removeClass( theElement, 'uneditable' );
                InlineEditor.removeClass( theElement, 'saving' );

            }   // end if: readystate 4
        };  // end onreadystatechange
        request.send(null);

    };  // end elementChanged




    */

/* ********  F U N C T I O N S   Y O U   S H O U L D   N O T   C A L L  ******** */

/*
    recursiveAddOnClickHandler: function( element )
    {
        //element.onclick = InlineEditor.handleOnClick;
        if (element.id) jQuery("#" + element.id).live("click", InlineEditor.handleOnClick);
        
        if( element.childNodes ){
            children = element.childNodes;
            for( i = 0; i < children.length; i++ ){
                if( children[i].onclick ){

                    InlineEditor.recursiveAddOnClickHandler( children[i] );

                }   // end if: child also needs handler
            }   // end for: each child
        }   // end if: children
    },   // end recursiveAddOnClickHandler
*/


    /**
     * Called when element is double-clicked.
     * At the time of this event, the class is checked to see
     * if the cell is marked 'uneditable'.
     */
    handleOnClick: function( evt )
    {
        var evt = InlineEditor.fixEvent( evt );
        var target = jQuery(InlineEditor.findEditableTarget( evt.target ));
		
		// If element is "uneditable" or "editing" don't edit.
        if (target.hasClass("uneditable") || target.hasClass("editing"))
        {
            return;
        }
        
        // Save original value.
        var oldHTML = target.html();
		var oldVal  = null;
        if( InlineEditor.elementValue ) // USER CAN PROVIDE OVERRIDE FUNCTION (WE DID NOT)
        {    
            oldVal = InlineEditor.elementValue( target );
        }
        if( !oldVal )
        {
            oldVal = target.html();
        }
        
        // Set up editor element
        // User overridable function
        var editor = null;
        if( InlineEditor.customEditor ){ // USER CAN PROVIDE OVERRIDE FUNCTION (WE DID NOT)
            editor = InlineEditor.customEditor( target );
        }   // end if: customEditor

        /*if( !editor ) { // If user didn't provide custom editor (WE DID)
          // Big? Make TEXTAREA.
            if( target.offsetHeight > 20  && target.innerHTML.length > 20 ){
                editor = document.createElement('textarea');
                editor.innerHTML = oldVal;
                editor.style.position = 'absolute';
                editor.style.zindex = 99;
                editor.style.left   = target.offsetLeft + 'px';
                editor.style.top    = target.offsetTop + 'px';
                editor.style.width  = target.offsetWidth + 'px';
                editor.style.height = target.offsetHeight + 'px';
            }   // end if: big
            else {
                editor = document.createElement('input');
                editor.value = oldVal;
                editor.style.position = 'absolute';
                editor.style.zindex = 99;
                editor.style.left   = target.offsetLeft + 'px';
                editor.style.top    = target.offsetTop + 'px';
                editor.style.width  = target.offsetWidth + 'px';
            }   // end else: use 'input'
        }*/   // end else: default

        // Listen for when focus is lost.
        editor.focusout(function(event){ InlineEditor.handleInputBlur( editor, oldVal, oldHTML );})
        editor.keypress(function(event)
        {
            var returnKey = 13;
        	if (event.which == returnKey)
        	{
        	  editor.blur();
        	  if (oldVal == "-- Add More --" && editor.val() != "")
        	  {
        	  	var nextEditorTargetId =  target.attr("id");
        	  	jQuery("#" + nextEditorTargetId).click();
        	  }
        	}
	    });
        
        // Prep target
        target.addClass("editing");

        // Add editor
        target.html("");
        target.append(editor);
        
        editor.focusin();
        editor.select();
        
        return false; // Don't propagate up. No need. Right?
    },   // end handleDoubleClick


    /**
     * Called when user is done editing the cell.
     */
    handleInputBlur: function( editor, oldVal, oldHTML )
    {
        // Gather values
        var parent = editor.parent();
        var newVal = null;
        
        if( InlineEditor.editorValue )
        {
            newVal = InlineEditor.editorValue( editor );
        }
        if( !newVal )
        {
            newVal = editor.val() == "" ? oldVal : editor.val();
        }
        
        // If nothing changed, bail out
        if( oldVal == newVal )
        {
            parent.html(oldHTML);
            parent.removeClass("editing");
            return;
        }   // end if: no change

        // Save value in the element
        parent.html(newVal);
        
        // If user wants to know of the change, pass it on.
        if( InlineEditor.elementChanged )
            InlineEditor.elementChanged( parent, oldVal, newVal );

    },   // end handleInputBlur


    /**
     * Thanks to http://www.onlinetools.org/articles/unobtrusivejavascript/cssjsseparation.html
     * for this bit of code.
     */
    jscss: function(a,o,c1,c2)
    {
        switch (a){
            case 'swap':
                o.className=!InlineEditor.jscss('check',o,c1) ?
                    o.className.replace(c2,c1) :
                    o.className.replace(c1,c2);
                break;
            case 'add':
                if(!InlineEditor.jscss('check',o,c1)){o.className+=o.className?' '+c1:c1;}
                break;
            case 'remove':
                var rep=o.className.match(' '+c1)?' '+c1:c1;
                o.className=o.className.replace(rep,'');
                break;
            case 'check':
                return new RegExp('\\b'+c1+'\\b').test(o.className)
                break;
        }   // end switch: action
    },  // end jscss


    fixEvent: function( evt )
    {
        var E = evt ? evt : window.event; // 'event' seems to be a special word in IE, so I'm using 'E' instead.
        if( E.target )
            if( E.target.nodeType == 3 )
                E.target = E.target.parentNode;

        //make sure Opera doesn't set this object
        if( inlineeditor_isIE )
            if( E.srcElement )
                E.target = E.srcElement;

        return E;
    },   // end fixEvent


    findEditableTarget: function( target )
    {
        // If a table cell, we assume that's editable
        if( target.nodeType == 1 && target.tagName == 'TD' )
            return target;

        if( InlineEditor.checkClass( target, 'editable' ) )
            return target;

        if( target.parentNode )
            return InlineEditor.findEditableTarget( target.parentNode );

        return null;
    },  // end findEditableTarget


    addEvent: function( target, eventName, func, capture )
    {
        if( target.addEventListener ){
            target.addEventListener( eventName, func, capture );
            return true;
        }   // end if: addEventListener
        else if( target.attachEvent )
            return target.attachEvent( 'on'+eventName, func );
    },  // end addEvent


    removeEvent: function( target, eventName, func, capture )
    {
        if( target.removeEventListener ){
            target.removeEventListener( eventName, func, capture );
            return true;
        }   // end if: removeEventListener
        else if( target.detachEvent )
            return target.detachEvent( 'on'+eventName, func );
    }   // end removeEvent

}   // end class InlineEditor

/**
 * Add InlineEditor.init() to window.onload.
 */
//InlineEditor.addEvent(window,'load',InlineEditor.init,false);
DropboxChooser = {};

DropboxChooser.init = function() {
  jQuery(".dropbox-button-chooser").each(function() {
    this.setAttribute("data-link-type", "direct");
    this.setAttribute("data-extensions", ".ump");
    var button = this;
    this.addEventListener("DbxChooserSuccess", function(e) {
      DropboxChooser.load(e.files[0].link);
    }, false);
  });
}

DropboxChooser.load = function(link) {
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  
  jQuery.get(link)
  .done(function(content) {
    Action.freshLoad = true;
    Page.setUmpleCode(content);
    Page.hideLoading();
    TabControl.getCurrentHistory().save(content, "dropboxLoad");
    Action.updateUmpleDiagram();
    Action.setCaretPosition("0");
    Action.updateLineNumberDisplay();
  })
  .fail(function() {
    Page.setFeedbackMessage("Cannot load from the chosen Dropbox file.");
    Page.hideLoading();
  });
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
var DropboxInitializer = {}

DropboxInitializer.initializeDropbox = function() 
{
  jQuery('.dropbox-add-saver')
    .addClass('dropbox-option')
    .append('<li id="ttDropboxSaver"><span class="dropbox-button-saver"></span></li>');
  jQuery('.dropbox-add-chooser')
    .addClass('dropbox-option')
    .append('<li id="ttDropboxChooser"><input type="dropbox-chooser" class="dropbox-button-chooser"/></li>');
  DropboxChooser.init();
  DropboxSaver.init();
};

DropboxMaster = {
  resetTimeout: 2000,
};
DropboxSaver = {};

DropboxSaver.init = function() {
  jQuery(".dropbox-button-saver").each(function() {
    DropboxSaver.createSaverIn(this);
  });
}

DropboxSaver.createSaverIn = function(parent) {
  var link = DropboxSaver.getAbsoluteLink(Page.getFilename());
  var saver = Dropbox.createSaveButton({
    files: [{url: link}],
    success: function() {
      window.setTimeout(function() {
        jQuery(parent).children(".dropbox-dropin-btn").remove();
        DropboxSaver.createSaverIn(parent);
      }, DropboxMaster.resetTimeout);
    },
    error: function(err) {
      console.log(err);
      Page.setFeedbackMessage("Cannot save to the chosen Dropbox location.");
    },
  });
  jQuery(parent).append(saver);
}

DropboxSaver.getAbsoluteLink = function(relativeLink) {
  var a = document.createElement('a');
  a.href = relativeLink.replace(/^\.\.\//, "");
  return a.href;
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions triggered by UI elements in UmpleOnline
// plus helper functions
// Actions associated with editing the graphical diagram are
// located in the umple_action_diagram.js file.
//
var Action = new Object();
Action.waiting_time = 1500;
Action.oldTimeout = null;
Action.elementClicked = false;
Action.canCreateByDrag = true;
Action.manualSync = false;
Action.diagramInSync = true;
Action.freshLoad = false;
Action.gentime = new Date().getTime();
Action.savedCanonical = "";
Action.gdprHidden = false;
Action.update = "";

// Regulators of whether a save occurs on not
// false: the program proceeds and saves as normal; true: skip the save as the program would have saved earlier already
let justUpdatetoSaveLater = false;

Action.setjustUpdatetoSaveLater = function(state){
  justUpdatetoSaveLater = state;
}

let justUpdatetoSaveLaterForTextCallback = false;

Action.setjustUpdatetoSaveLaterForTextCallback = function(state){
  justUpdatetoSaveLaterForTextCallback = state;
}

Action.clicked = function(event)
{
  Page.clickCount += 1;

  var obj = event.currentTarget;
  var action = obj.id.substring(6);
  if (action == "PhpCode")
  {
    Action.generateCode("php","Php");
  }
  else if (action == "RubyCode")
  {
    Action.generateCode("ruby","Ruby");
  }
  else if (action == "JavaCode")
  {
    Action.generateCode("java","Java");
  }
  else if (action == "RTCppCode")
  {
    Action.generateCode("rtcpp","RTCpp");
  }
  else if (action == "AlloyCode")
  {
    Action.generateCode("alloy","Alloy");
  }
  else if (action == "NuSMVCode")
  {
    Action.generateCode("nusmv","NuSMV");
  }
  else if (action == "CppCode")
  {
    Action.generateCode("cpp","Cpp");
  }
  else if (action == "SQLCode")
  {
    Action.generateCode("sql","Sql");
  }
  else if (action == "JavaAPIDoc")
  {
    Action.generateCode("javadoc","javadoc");
  }
  else if (action == "StateDiagram")
  {
    Action.generateCode("stateDiagram","stateDiagram");
  }
  else if (action == "StructureDiagram")
  {
    Action.generateCode("structureDiagram","structureDiagram");
  }
  else if (action == "FeatureDiagram")
  {
    Action.generateCode("featureDiagram","featureDiagram");
  }
  else if (action == "classDiagram")
  {
    Action.generateCode("classDiagram","classDiagram");
  }
  else if (action == "entityRelationshipDiagram")
  {
    Action.generateCode("entityRelationshipDiagram","entityRelationshipDiagram");
  }
  else if (action == "EcoreCode")
  {
    Action.generateCode("xml","Ecore");
  }
  else if (action == "GenerateCode")
  {
    var languageAndGenerate = $("inputGenerateCode").value.split(":");
    Action.generateCode(languageAndGenerate[0],languageAndGenerate[1]);
  }
  else if (action == "ExecuteCode")
  {
    var languageAndExecute = $("inputGenerateCode").value.split(":");
    Action.executeCode(languageAndExecute[0],languageAndExecute[1]);
  }
  else if (action == "SimulateCode")
  {
    Action.simulateCode();
  }
  else if (action == "StartOver")
  {
    Action.startOver();
  }
  else if (action == "ShowRefreshUmpleOnlineCompletely")
  {
  	Action.showRefreshUmpleOnlineCompletely();
  }
  else if (action == "LoadBlankModel")
  {
  	 Action.loadBlankModel();
  }
  else if (action == "PngImage")
  {
    Action.pngImage();
  }
  else if (action == "YumlImage")
  {
    Action.yumlImage();
  }
  else if (action == "Jsf")
  {
    Action.uigu();
  }
  else if (action == "CopyClip")
  {
    Action.copyClipboardCode();
  }  
  else if (action == "Copy")
  {
    Action.showCodeInSeparateWindow();
  }
  else if (action == "CopyCommandLine")
  {
    Action.copyCommandLineCode();
  }  
  else if (action == "CopyEncodedURL")
  {
    Action.showEncodedURLCodeInSeparateWindow();
  }
  else if (action == "CopyLocalBrowser")
  {
    if (typeof(Storage) !== "undefined") {
      localStorage.setItem("umpleLocalStorage1",Page.getUmpleCode());
      Page.setFeedbackMessage("Model saved. Use Load From Browser later to restore.")
    }
    else{Page.setFeedbackMessage("Unable to copy the model to browser storage. An error occurred.")}
  }
  else if (action == "LoadLocalBrowser")
  {
    if (typeof(Storage) !== "undefined") {
      var textToLoad = localStorage.getItem("umpleLocalStorage1");
      if(textToLoad != null) {
        Page.setUmpleCode(textToLoad);
      }
    }
  }
  else if (action == "CreateTask") 
  {
    jQuery("#taskArea").css("display","block");
    //jQuery("#taskNameArea").css("display","block");
    jQuery("#labelTaskName").css("display","block");
    jQuery("#taskNameCell").css("display","block");
    jQuery("#instructions").css("display","block");
    jQuery("#isExperimentCell").css("display","block");
    Layout.zoomResize();
  }
  else if (action == "LoadTask")
  {
    jQuery("#loadTaskNameArea").css("display","block");
  }
  else if (action == "LoadThisTask")
  {
    Action.loadTask(Page.getModel().split("-")[1], false);
  }
  else if (action == "RequestLoadTaskURL")
  {
    var taskname = Page.getModel().split("-")[1];
    Action.copyToClp(window.location.hostname + "/bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname);
  }
  else if (action == "RequestAllZip") 
  {
    if (document.getElementById("downloadTaskDirLink") === null)
    {
      var link = document.createElement("a");
      link.setAttribute("href", "scripts/tab_control.php?downloadTaskUserDir=1&taskid=" + Page.getModel());
      link.setAttribute('id', "downloadTaskDirLink");
      var linkText = document.createTextNode("Download ZIP File From Here");
      link.appendChild(linkText);
      
      var node = document.createElement("LI");   
      node.appendChild(link);
      document.getElementById("taskSubmenu").appendChild(node);
    }
    else
    {
      document.getElementById("downloadTaskDirLink").setAttribute("href", "scripts/tab_control.php?downloadTaskUserDir=1&taskid=" + Page.getModel());
    }

    setTimeout(function () {
      document.getElementById("downloadTaskDirLink").remove();
    }, 30000);
  }
  else if (action == "DownloadFiles")
  {
    TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
    
    // issue#1554
    //window.location.href = "scripts/tab_control.php?download=1&&model=" + Page.getModel();
    if (document.getElementById("downloadLink") === null)
    {
      var link = document.createElement("a");
      link.setAttribute("href", "scripts/tab_control.php?download=1&&model=" + Page.getModel());
      link.setAttribute('id', "downloadLink");
      var linkText = document.createTextNode("Download ZIP File From Here");
      link.appendChild(linkText);
      
      var node = document.createElement("LI");   
      node.appendChild(link);
      document.getElementById("saveLoad").appendChild(node);
    }
    else 
    {
      document.getElementById("downloadLink").setAttribute("href", "scripts/tab_control.php?download=1&&model=" + Page.getModel());
    }

    setTimeout(function () {
      document.getElementById("downloadLink").remove();
    }, 30000);
  }
  else if (action == "Undo")
  {
    Action.undo();
  }
  else if (action == "Redo")
  {
    Action.redo();
  }
  else if (action == "Reindent") 
  { 
    var lines = Page.getRawUmpleCode().split("\n");
    var cursorPos = Page.codeMirrorEditor.getCursor(true);
    var whiteSpace = lines[cursorPos.line].match(/^\s*/)[0].length;
    var lengthToFirstCh = cursorPos.ch - whiteSpace;
    cursorPos.ch = lengthToFirstCh;
    Action.reindent(lines, cursorPos);
  }
  else if (action == "ShowHideTextEditor")
  {
    Layout.showHideTextEditor();
    Page.showText = !Page.showText;
    Page.setShowHideIconState('SHT_button');
  }
  else if (action == "ShowHideCanvas")
  {
    Layout.showHideCanvas();
    Page.showCanvas = !Page.showCanvas;
    Page.setShowHideIconState('SHD_button');
  }
  else if (action == "ShowEditableClassDiagram")
  {
    Action.changeDiagramType({type:"editableClass"});
  }
  else if (action == "ShowJointJSClassDiagram")
  {
    Action.changeDiagramType({type:"JointJSClass"});
  }
  else if (action == "ShowGvClassDiagram")
  {
    Action.changeDiagramType({type:"GvClass"});
  }
  else if (action == "ShowGvFeatureDiagram")
  {
    Action.changeDiagramType({type:"GvFeature"});//buttonShowGvFeatureDiagram
  }
  else if (action == "ShowGvStateDiagram")
  {
    Action.changeDiagramType({type:"GvState"});
  }
  else if (action == "ShowStructureDiagram")
  {
    Action.changeDiagramType({type:"structure"});
  }
  else if (action == "ShowHideLayoutEditor")
  {
    Layout.showHideLayoutEditor();
  }
  else if (action == "ManualSync")
  {
    Action.enableManualSync();
  }
  else if (action == "SyncDiagram")
  {
    Action.processTyping("codeMirrorEditor", true);
    Page.codeMirrorEditor.focus();
  }
  else if (action == "PhotoReady")
  {
    Action.photoReady();
  }
  else if (action == "ToggleAttributes")
  {
    Action.toggleAttributes();
    Page.setShowHideIconState('SHA_button');
  }
  else if (action == "ToggleMethods")
  {
    Action.toggleMethods();
    Page.setShowHideIconState('SHM_button');
  }
  else if (action == "ToggleActions")
  {
    Action.toggleActions();
  }
  else if (action == "ToggleTraits")
  {
    Action.toggleTraits();
  }  
  else if (action == "ToggleTransitionLabels")
  {
    Action.toggleTransitionLabels();
  }
  else if (action == "ToggleGuards")
  {
    Action.toggleGuards();
  }
  else if (action == "ToggleGuardLabels")
  {
    Action.toggleGuardLabels();
  }
  else if (action == "AllowPinch")
  {
    Action.allowPinch();
  }
  else if (action == "ToggleFeatureDependency")
  {
    Action.toggleFeatureDependency();
  }
  else if(action == "StructureLink")
  {
    Action.generateStructureDiagramFile();
  }
  else if(action == "TabsCheckbox")
  {
    Action.toggleTabs();
  }
}

Action.focusOn = function(id, gained)
{
  var selector = "#" + id;
  var isPlainEditor = ((id == "umpleModelEditorText" || id == "umpleLayoutEditorText") || id == "CodeMirror");

  if(id == "CodeMirror") selector = ".CodeMirror-scroll"
  
  if (gained) 
  {
    if (!Page.isPhotoReady() || isPlainEditor)
    {
      jQuery(selector).parent().addClass("focus");
      jQuery(selector).addClass("visibleFocus");
      if (isPlainEditor)
      {
        Page.shortcutsEnabled = false;
        if (Page.selectedItem != null) Page.unselectAllToggleTools();
        Action.unselectAll();
      }
    }
  }
  else
  { 
    jQuery(selector).parent().removeClass("focus");
    jQuery(selector).removeClass("visibleFocus");
    if (isPlainEditor || id == "CodeMirror")
    {
      Page.shortcutsEnabled = true;
    }
  }
}

Action.startOver = function()
{
  Page.setUmpleCode("");
  UmpleSystem.merge(null);
  window.location = "umple.php";
  // Action.saveNewFile();
  // location.
  // location.reload();
}

Action.showRefreshUmpleOnlineCompletely = function()
{
	jQuery("#buttonStartOver").show();
}

Action.loadBlankModel = function()
{
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode="); //left empty
}

Action.undo = function()
{
  if (jQuery("#buttonUndo").hasClass("disabled")) return;
  Action.redoOrUndo(true);
}

Action.redo = function()
{
  if (jQuery("#buttonRedo").hasClass("disabled")) return;
  Action.redoOrUndo(false);
}

// The following from https://developer.mozilla.org/en-US/docs/Web/API/HTML_Drag_and_Drop_API/File_drag_and_drop
Action.dropHandler = function(ev) {
  Page.setFeedbackMessage("File will be dropped")

  // Prevent default behavior (Prevent file from being opened)
  ev.preventDefault();

  if (ev.dataTransfer.items) {
    // Use DataTransferItemList interface to access the file(s)
    for (var i = 0; i < ev.dataTransfer.items.length; i++) {
      // If dropped items aren't files, reject them
      if (ev.dataTransfer.items[i].kind === 'file') {
        var file = ev.dataTransfer.items[i].getAsFile();
        file.text().then(function(text) {
          Page.setUmpleCode(text);
        });
      }
    }
  } else {
    // Use DataTransfer interface to access the file(s)
    for (var i = 0; i < ev.dataTransfer.files.length; i++) {
       ev.dataTransfer.files[i].text().then(function(text) {
        Page.setUmpleCode(text);
      });
    }
  }
}

Action.dragOverHandler = function(ev) {
  //console.log('File(s) in drop zone');

  // Prevent default behavior (Prevent file from being opened)
  ev.preventDefault();
}

Action.redoOrUndo = function(isUndo)
{
  var afterHistoryChange = "";
  if (Action.manualSync && Action.diagramInSync)
  {
    Action.diagramInSync = false;
    Page.enablePaletteItem("buttonSyncDiagram", true);
    Page.enableDiagram(false);
  }
  
  if (isUndo) afterHistoryChange = TabControl.getCurrentHistory().getPreviousVersion();
  else afterHistoryChange = TabControl.getCurrentHistory().getNextVersion();
  if (afterHistoryChange == History.noChange)
  {
    afterHistoryChange = "";
  }
  
  var delimiterLoc = afterHistoryChange.indexOf(Page.modelDelimiter);
  var rawReplacement = "";
  if(delimiterLoc == -1) {
    rawReplacement = afterHistoryChange;
  }
  else {
    rawReplacement = afterHistoryChange.substring(0,delimiterLoc);
  }
  var rawOriginal = Page.getRawUmpleCode().replace(Page.modelDelimiter, "");
  var theDiff=Action.findDiff(rawOriginal, rawReplacement);
  var prevLine=Action.getCaretPosition();
  Action.freshLoad = true;
  Page.setUmpleCode(afterHistoryChange);
  if (!Action.manualSync) Action.updateLayoutEditorAndDiagram();

  Action.setjustUpdatetoSaveLater(true);
  
  setTimeout(function () { // Delay so it doesn't get erased
    // Page.setFeedbackMessage("Changed line "+theDiff[3]+" "+theDiff[1]);
    if(theDiff[1] == theDiff[2])
    {
      // change was in diagram so leave caret where it is
      Action.setCaretPosition(prevLine);
    }
    else
    {
      // set line number to where change occurred
      Action.setCaretPosition(theDiff[3]);
    }   
  }, 300);
}

Action.findDiff = function(oldString, newString)
{

  var lineNumber = 0; // line number in newString
  
  var lOld = oldString.length, lNew = newString.length;
  var l=lOld; // Assume old is shorter
  if (lNew < l) l=lNew; // Actually new is shorter
  var i=0;

  while(i < l && oldString.charAt(i) === newString.charAt(i)) {
    i++;
    if(oldString.charAt(i) === '\n' && newString.charAt(i) === '\n') lineNumber++;
  }
  
  // i is now the character index where the difference begins
  var startChange=newString.substring(i,1);
  
  // Tuple is length of old, length of new, position of change, line number chg
  return [lOld, lNew, i, lineNumber+1];
}

// Initial load of a file (e.g. example or blank) at initialization
Action.loadFile = function()
{
  var filename = Page.getFilename();
  if (filename != "")
  {
    Action.setjustUpdatetoSaveLater(true);
    if (Page.getModel().substring(0, 8) == "taskroot")
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&isTask=1&filename={0}",filename));
    } 
    else 
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&filename={0}",filename));
    }
  }
  else
  {
    Action.saveNewFile();
  }
}

// Triggered by the above Action.loadFile. Initial load of a file at startup
Action.loadFileCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  if (Object.keys(TabControl.tabs).length > 1) return;
  Page.setUmpleCode(response.responseText, true);
  TabControl.getCurrentHistory().save(response.responseText,"loadFileCallback");
  Action.setjustUpdatetoSaveLater(true);
  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(response.responseText);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  if (!Action.manualSync) {
    Action.updateUmpleDiagram();
    Action.freshLoad = false;
  }
}

Action.loadTask = function(taskName, isBookmark)
{
  jQuery("#showInstrcutionsArea").css("display","block");
  if (!isBookmark)
  {
    Ajax.sendRequest("bookmark.php", Action.loadTaskBookmark,format("taskname={0}&model={0}",taskName));
    //Ajax.sendRequest("scripts/compiler.php",Action.loadTaskCallback,format("loadTask=1&filename={0}",taskName));
  } else {
    if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&loadInstructionAsHTML=1&filename={0}",taskName));
    }
    else
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&filename={0}",taskName));
    }
  }
}

Action.loadTaskBookmark = function(response)
{
  if (response.responseText.split(" ")[0] == "Task")
  {
    window.alert("Load Task Failed! " + response.responseText);
  }
  else
  {
    window.location.href = "umple.php?model=" + response.responseText;
  }
}

Action.loadTaskCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  if (Object.keys(TabControl.tabs).length > 1) return;

  Action.setjustUpdatetoSaveLater(true);
  TabControl.getCurrentHistory().save(response.responseText,"loadTaskCallback");
  var responseArray = response.responseText.split("task delimiter");
  Page.setUmpleCode(responseArray[0]);
  //jQuery("#textareaShowInstrcutions").val(responseArray[1]);
  //jQuery("#labelShowInstructions").text("Task Instructions: " + responseArray[2]);
  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  if (!Action.manualSync) Action.updateUmpleDiagram();
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?taskname=" + responseArray[2] + "&model=" + responseArray[3];
}

Action.loadTaskExceptCodeCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  //if (Object.keys(TabControl.tabs).length > 1) return;

  if (!justUpdatetoSaveLater){
    TabControl.getCurrentHistory().save(response.responseText,"loadTaskExceptCodeCallback");
    Action.setjustUpdatetoSaveLater(true);
  }
  var responseArray = response.responseText.split("task delimiter");
  jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":");
  jQuery("#requestorName").val(responseArray[4]);
  jQuery("#labelInstructions").css("display","block");
  jQuery("#taskArea").css("display","block");
  if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
  {
    jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":               Requestor Name:" + responseArray[4]);
    jQuery("#labelCompletionURL").css("display", "none");
    jQuery("#completionURLCell").css("display", "none");
    jQuery("#labelRequestorName").css("display", "none");
    jQuery("#requestorName").css("display", "none");
    jQuery("#instructionsHTML").html(responseArray[1]);
  }
  else 
  {
    jQuery("#instructions").val(responseArray[1]);
    jQuery("#instructions").css("display","block");
    jQuery("#completionURL").val(responseArray[5]);
    jQuery("#isExperimentCell").css("display", "inline");
    jQuery("#isExperiment").prop('checked', responseArray[6] == 'true');
    jQuery('#instructions').each(function () {
      this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
    }).on('input', function () {
      this.style.height = 'auto';
      this.style.height = (this.scrollHeight) + 'px';
    });

    //jQuery("#completionURL").css("width", responseArray[5].length + "ch");
  }
  // jQuery('#instructions').each(function () {
  //   this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
  // }).on('input', function () {
  //   this.style.height = 'auto';
  //   this.style.height = (this.scrollHeight) + 'px';
  // });

  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  Layout.zoomResize();
}

Action.submitLoadTask = function()
{
  var taskName = jQuery("#inputLoadTaskName").val();
  let patt = /^(\w|\.)+$/; // taskName Take only [ A-Z or a-z or 0-9 or _ or . ]
  if (!patt.test(taskName))//taskName.indexOf(" ") != -1 || taskName.indexOf("/") != -1 || taskName.indexOf("-") != -1 || taskName.indexOf("\\") != -1) 
  {
    window.alert("Task Name can only contain letters(case insensitive), underscores, dots, and digits!");
    return;
  }
  Action.loadTask(taskName, false);
}

Action.submitTaskWork =function()
{
  Ajax.sendRequest("task.php", Action.submitTaskWorkCallback, format("submitTaskWork=1&model={0}&responseURL={1}", Page.getModel(), window.location.href));
}

Action.submitTaskWorkCallback = function(response)
{
  window.alert("Successfully submitted Task!");
  var responseArray = response.responseText.split("task submit delimiter");
  if (responseArray[0] == "")
  {
    window.location.href = responseArray[2];
  }
  else
  {
    window.location.href = responseArray[0] + "?task=" + responseArray[1] + "&url=" + responseArray[2];
  }
}

Action.launchParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  window.open("bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname);
}

Action.copyParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  var copiedURL = window.location.hostname + window.location.pathname.substring(0, window.location.pathname.lastIndexOf('/')) + "/bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname;
  Action.copyToClp(copiedURL);
  Page.setFeedbackMessage("Participant URL is in copy buffer: " + copiedURL);
}

Action.openStartFreshWork = function() 
{
  var a= confirm("Are you sure to start from fresh?"); 
  if(a) { 
    window.location.href = "/umpleonline/umple.php"
  }
}

Action.copyToClp = function(txt){
    prenode=document.createElement("PRE");
    txt = document.createTextNode(txt);
    prenode.appendChild(txt);
    var m = document;
    var w = window;
    var b = m.body;
    b.appendChild(prenode);

    if (b.createTextRange) {
        var d = b.createTextRange();
        d.moveToElementText(txt);
        d.select();
        m.execCommand('copy');
    } 
    else {
        var d = m.createRange();
        var g = w.getSelection;
        d.selectNodeContents(txt);
        g().removeAllRanges();
        g().addRange(d);
        m.execCommand('copy');
        g().removeAllRanges();
    }
    prenode.remove();
}

Action.openInstructionInNewTab = function()
{
  jQuery("#buttonReshowInstructions").css("display", "inline");
  // var winPrint = window.open('', '', 'left=0,top=0,width=800,height=600,toolbar=0,scrollbars=0,status=0');
  // winPrint.document.write("<!DOCTYPE html><html><head><title>Instructions</title></head><body>" + jQuery("#instructionsHTML").html() + "</body></html>");
  // winPrint.document.close();
  // winPrint.focus();
  var tab = window.open('about:blank', '_blank');
  tab.document.write(jQuery("#instructionsHTML").html()); // where 'html' is a variable containing your HTML
  tab.document.close();
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  Layout.zoomResize();
}

Action.reshowInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "block");
  jQuery("#labelInstructions").css("display", "inline");
  jQuery("#buttonReshowInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "inline");
  Layout.zoomResize();
}

Action.hideInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  jQuery("#buttonReshowInstructions").css("display", "inline");
  Layout.zoomResize();
}

Action.saveNewFile = function()
{
  var umpleCode = Page.getUmpleCode();
  var filename = Page.getFilename();
  
  if (filename == "")
  {
    Ajax.sendRequest("scripts/compiler.php",Action.saveNewFileCallback,format("save=1&&umpleCode={0}",umpleCode));
  }
}

Action.saveNewFileCallback = function(response)
{
  Page.setFilename(response.responseText);
}

Action.changeDiagramType = function(newDiagramType)
{
  var changedType = false;
  jQuery(".layoutListItem").hide();

  if(newDiagramType.type == "editableClass") { 
    if(Page.useEditableClassDiagram) return;
    Page.useEditableClassDiagram = true;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowEditableClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('editableClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();

  }
  else if(newDiagramType.type == "JointJSClass") { 
    if(Page.useJointJSClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = true;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowJointJSClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('JointJSClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }  
  else if(newDiagramType.type == "GvClass") { 
    if(Page.useGvClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = true;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvClass');
    jQuery(".view_opt_class").show();

  }
  else if(newDiagramType.type == "GvState") {
    if(Page.useGvStateDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = true;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvStateDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvState');
    jQuery(".view_opt_state").show();

  }
  else if(newDiagramType.type == "GvFeature") {
   if(Page.useGvFeatureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = true;
    changedType = true;
    jQuery("#buttonShowGvFeatureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvFeature');
    jQuery(".view_opt_feature").show();


  }
  else if(newDiagramType.type == "structure") { // Structure Diagram
    if(Page.useGvStructureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = true;
    Page.useGvFeatureDiagram = false;
    changedType = true;
    jQuery("#buttonShowStructureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('structure');
  }
  if (changedType) {
    Action.redrawDiagram();
  }
}

Action.pngImage = function()
{
  var jsonText = Json.toString(UmpleSystem);
  var jsonEncodedText = encodeURIComponent(jsonText);
  window.open("scripts/compiler.php?asImage=" + jsonEncodedText, "UMLClassDiagram");
}

Action.yumlImage = function()
{
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).showLoading();
  Action.ajax(Action.yumlImageCallback,"save=1");
}

Action.yumlImageCallback = function(response)
{
  var filename = response.responseText;
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).hideLoading();
  window.open("scripts/compiler.php?asYuml=" + filename, "yumlClassDiagram");
  Page.showViewDone();
}

Action.uigu = function()
{
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).showLoading();
  Action.ajax(Action.uiguCallback,"save=1");
}

Action.uiguCallback = function(response)
{
  var filename = response.responseText;
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).hideLoading();
  window.open("scripts/compiler.php?asUI=" + filename, "showUserInterface");
  Page.showViewDone();
}

Action.copyClipboardCode = function()
{
  Action.copyToClp(Page.getUmpleCode());
  Page.setFeedbackMessage("Code has been copied to the clipboard");  
}

Action.copyCommandLineCode = function()
{
  var pretext="sh\n";
  pretext+="echo Will compile umple file. Requires umple command to be installed\n";
  pretext+="cd ~/tmp\n";
  pretext+="mkdir testump-$$\n";
  pretext+="cd testump-$$\n";
  pretext+="cat >> test.ump <<ENDUMP\n";
  var posttext="\nENDUMP\n";
  posttext+="umple test.ump -c -\n";
  posttext+="echo Use ctrl-D to exit back to the original shell\n\n";
  Action.copyToClp(pretext+Page.getUmpleCode()+posttext);
  Page.setFeedbackMessage("Shell code to compile on command line was copied to clipboard");  
}

Action.showCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleCode"+Math.random()*10000,"height=700, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getUmpleCode() + '</pre></code>');
  codeWindow.document.title="Umple raw code";
  codeWindow.document.close();
}

Action.showEncodedURLCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleEncodedURL"+Math.random()*10000,"height=500, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getEncodedURL() + '</pre></code>');
  codeWindow.document.title="Umple encoded URL";
  codeWindow.document.close();
}

Action.simulateCode = function()
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).showLoading();
  Action.ajax(Action.simulateCodeCallback,"language=Simulate");
}

Action.simulateCodeCallback = function(response)
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).hideLoading();
  var modelId = response.responseText;
  window.open("../umpleonline/simulate.php?model=" + modelId, "umpleSimulator");
  Page.showViewDone(); 
}
//Called by Action.drawStateMenu(), this multiuse function takes any textual input requires for 
//menu edits on states.
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawInputState = function(inputType,stateCode,stateName){
  // DEBUG
  // console.log("Inside drawInputState: ")
  // console.log("with inputType: ", inputType)
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "fixed";
  prompt.id="promptBox";
  var promptRect=prompt.getBoundingClientRect();
  if(event.clientX+promptRect.width>window.innerWidth){
    prompt.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    prompt.style.left = event.clientX+"px";
  }
  if(event.clientY+promptRect.height>window.innerHeight){
    prompt.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    prompt.style.top = event.clientY+"px";
  }
  var input = document.createElement('input');
  input.type = 'text';
  input.style.padding = '5px';
  input.style.borderRadius = '3px';
  input.style.border = '1px solid #ccc';
  input.style.width = '200px';
  input.style.marginLeft = '5px';
  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.textContent='Error - Please enter an alphanumeric name beginning with a non-numeric character.';
  inputErrorMsg.style.color="red";
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  var unsanitizedState=stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  var label = document.createElement('label');
  label.htmlFor = 'inputLabel';
  label.style.marginRight = '5px';
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  if(inputType=="rename"){
    console.log("Renaming State ...")
    label.appendChild(document.createTextNode("New name for \'"+stateName+"\'?"));
    input.value = stateName;
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        //only accounts for case where states all have unique names
        if(Action.validateAttributeName(input.value)){
          console.log("Getting code from codemirror editor ...")

          // Removing CM5
          // let orig=Page.codeMirrorEditor.getValue();

          // get contents of codemirror 6 editor
          let orig = Page.codeMirrorEditor6.state.doc.toString();

          let regex=new RegExp("(\\W+)("+stateName+")(\\W+)");
          let res;
          while((res=orig.match(regex))!=null){
            orig=orig.substr(0,res.index+res[1].length)+input.value.trim()+orig.substr(res.index+res[1].length+res[2].length,orig.length-(res.index+res[1].length+res[2].length));
          }
          console.log("Setting updated code to codemirror editor ...")
          // Removing CM5
          // Page.codeMirrorEditor.setValue(orig);

          // update content of codemirror 6 editor with updated code/text
          Page.setCodeMirror6Text(orig);

          // Action.processTyping("codeMirrorEditor")
          setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

          document.removeEventListener("mousedown", hider);
          console.log("Removing mousedown event ...")
          prompt.remove();
          Action.removeContextMenu();
          // Removing CM5
          // TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
          TabControl.getCurrentHistory().save(orig, "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });  
  } else if(inputType=="substate") {
    console.log("Substating state ...")
    label.appendChild(document.createTextNode("Name of new substate?"));
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
          let subtext=unsanitizedState.substr(0,unsanitizedState.length-1)+"  "+input.value+"{}}";
          console.log("Getting original code and adding substate ...")
          // Removing CM5
          // subtext=Page.codeMirrorEditor.getValue().replace(unsanitizedState,subtext);
          subtext=Page.codeMirrorEditor6.state.doc.toString().replace(unsanitizedState,subtext);

          console.log("Setting updated code with substate into codemirror editor ...")
          // Removing CM5
          // Page.codeMirrorEditor.setValue(subtext);
          Page.setCodeMirror6Text(subtext);

          setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

          document.removeEventListener("mousedown", hider);
          console.log("Removing mousedown event ...")
          prompt.remove();
          Action.removeContextMenu();
          // Removing CM5
          // TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
          TabControl.getCurrentHistory().save(subtext, "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
   
  } else if(inputType=="transition"){ //should have an indicator after user enters label so they know to press another state
    console.log("Adding Transition ...")
    label.appendChild(document.createTextNode("Condition for new transition?"));
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
          
          var orig=stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
          document.removeEventListener("mousedown", hider);
          prompt.remove();
          Action.removeContextMenu();
          console.log("Waiting to select target state for transition ...")
          var assocState=function (event){
              let targ=event.target;
              while(targ.parentElement.id!="graph0"){
                targ=targ.parentNode;
              }
              let elemText=targ.outerHTML.substr(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length,targ.outerHTML.indexOf("&quot;)\"")-(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length));
              elemText=elemText.split("^*^"); //index 0: class, index 1: base state, index 2: remaining states
              let subtext="  "+input.value+" -> "+elemText[2]+";\n}";
              let newState=orig.substr(0,orig.length-1)+subtext;
              console.log("New state created ...")
              // Removing CM5
              // Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(orig,newState));
              console.log("Replacing original state with new state in the code ...")
              Page.setCodeMirror6Text(Page.codeMirrorEditor6.state.doc.toString().replace(orig,newState));

              setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

              //TODO - Saving/edit history doesn't seem to be working here.
              // Removing CM5
              // TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
              TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
              let others=document.getElementsByClassName("node");
              for(let q=0;q<others.length;q++){
                others[q].removeEventListener("mousedown",assocState);
              }
              elems=document.getElementsByClassName("cluster");
              for(let q=0;q<others.length;q++){
                others[q].removeEventListener("mousedown",assocState);
              }  
            };
          //add event listener to Graphviz nodes for left click
          var elems=document.getElementsByClassName("node");
          for(let i=0;i<elems.length;i++){
            elems[i].addEventListener("mousedown", assocState);
          }       
          elems=document.getElementsByClassName("cluster");
          for(let i=0;i<elems.length;i++){
            elems[i].addEventListener("mousedown", assocState);
          }       
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
  }
  // Add the prompt to the page
  prompt.appendChild(label);
  prompt.appendChild(input);
  document.body.appendChild(prompt);
  input.focus();
}
//Deletes a target state within the specific SM and Class, as well any transitions to/from target state
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.deleteState = function(stateCode,className,smName,stateName){
  // console.log("Inside Action.deleteState ...")
  let subStates=stateName.split(",");
  console.log("Getting code from codemirror editor ...")
  // Removing CM5
  // let orig=Page.codeMirrorEditor.getValue();
  let orig=Page.codeMirrorEditor6.state.doc.toString();
  console.log("Deleting State: ", stateName)
  let unsanitizedState = stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  orig=orig.replace(unsanitizedState,"");
  //delete any transitions leading to target state - this handles the case where there are NOT multiple states with the same name
 let regex=new RegExp("[^{};]*->\\s*([^\\S\\s]*|\\s*)(\\/\\s*{[^}]*})*([^\\S\\s]*|\\s*)("+subStates[subStates.length-1]+")(\\s+\\w+)*\\s*;");
  let res;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  console.log("Setting updated code to codemirror editor ...")
  // Removing CM5
  // Page.codeMirrorEditor.setValue(orig);
  Page.setCodeMirror6Text(orig);

  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

  // Removing CM5
  // TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
  TabControl.getCurrentHistory().save(orig, "menuUpdate");
  Action.removeContextMenu();
}
//Action.drawStateMenu() is triggered by contextmenu event on Graphviz State Diagram "node" elements
//Draws a div containing the editing options for state GV diagrams, as well as calling the related function when clicked
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawStateMenu = function(){
  // console.log("Inside drawStateMenu: ")
  if(!Action.diagramInSync){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var targ=event.target;
  //iterate up to top of graph elements
  while(targ.parentElement.id!="graph0"){
    targ=targ.parentNode;
  }
  //grabs state name
  var elemText=targ.outerHTML.substr(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length,targ.outerHTML.indexOf("&quot;)\"")-(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length));
  elemText=elemText.split("^*^"); //index 0: class, index 1: base state, index 2: remaining states
  elemText[2]=elemText[2].split(".");
  // Removing CM5
  // var orig=Page.codeMirrorEditor.getValue();
  var orig = Page.codeMirrorEditor6.state.doc.toString();
  // Removing CM5
  // var chosenStateIndices=Action.selectStateInClass(elemText[0],elemText[1],elemText[2][0]);
  var chosenStateIndices=Action.selectStateInClassCM6(elemText[0],elemText[1],elemText[2][0]);
  for(let i=1;i<elemText[2].length;i++){
    // Removing CM5
    // chosenStateIndices=Action.selectStateInState(chosenStateIndices.startIndex,chosenStateIndices.endIndex,elemText[2][i]);
    chosenStateIndices=Action.selectStateInStateCM6(chosenStateIndices.startIndex,chosenStateIndices.endIndex,elemText[2][i]);
  }
  var chosenState=orig.substr(chosenStateIndices.startIndex,chosenStateIndices.endIndex-chosenStateIndices.startIndex);
  // console.log("chosenState: ", chosenState)
  if(typeof chosenState != 'string'){
    return;
  }
  //this section generates the context menu, grabbing option names and associated functions from the vars below 
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Rename State","Delete State","Add Substate","Add Transition"];
  //need to sanitize any linebreaks or quotes that could break the generated HTML
  var jsInput=chosenState.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  var rowFuncs = ["Action.drawInputState(\"rename\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")","Action.deleteState(\""+jsInput+"\",\""+elemText[0]+"\",\""+elemText[1]+"\",\""+elemText[2]+"\")","Action.drawInputState(\"substate\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")","Action.drawInputState(\"transition\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")"];
  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  //add rows
  for (var i = 0; i < rowContent.length; i++) {
    var row = document.createElement("div");
    row.style.padding = "5px";
    row.style.borderRadius = "3px";
    row.style.cursor = "pointer";
    row.style.transition = "background-color 0.3s";
    row.textContent = rowContent[i];
    row.setAttribute('onclick',"javascript:"+rowFuncs[i]);
    //Highlight row on hover
    row.addEventListener("mouseover", function() {
      this.style.backgroundColor = "#ddd";
    });
    row.addEventListener("mouseout", function() {
      this.style.backgroundColor = "transparent";
    });
    //add row to context menu
    menu.appendChild(row);
  }
  //set menu location at mouse, while ensuring it is on screen
  var menuRect=menu.getBoundingClientRect();
  if(event.clientX+menuRect.width>window.innerWidth){
    menu.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    menu.style.left = event.clientX+"px";
  }
  if(event.clientY+menuRect.height>window.innerHeight){
    menu.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    menu.style.top = event.clientY+"px";
  }
  //Add an event listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
    var prompt=document.getElementById("promptBox");
    if (e.target != menu && !menu.contains(e.target)) {
      if(prompt!=null&&e.target != prompt && !prompt.contains(e.target)){
        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
      } else {
        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
      }
    }
  });
  document.body.appendChild(menu);
}
Action.displayTransitionMenu = function(event) {
  if (!Action.diagramInSync) {
      return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var targ = event.target;
  //iterate up to top of graph elements
  while (targ.parentElement.id != "graph0") {
      targ = targ.parentNode;
  }
  //grabs state name
  var elemText = targ.outerHTML.substr(targ.outerHTML.indexOf("transitionClicked(&quot;") + "transitionClicked(&quot;".length, targ.outerHTML.indexOf("&quot;)\"") - (targ.outerHTML.indexOf("transitionClicked(&quot;") + "transitionClicked(&quot;".length));
  elemText = elemText.replaceAll("&amp;", "&");
  let id = elemText.split("*^*");
  let identifierState = id[3].split(".");
  dest = id[4].split(".");

  // var selection = Action.selectStateInClass(id[0], id[1], identifierState[0]);
  var selection = Action.selectStateInClassCM6(id[0], id[1], identifierState[0]);

  for (var i = 1; i < identifierState.length; i++) {
      //selection = Action.selectStateInState(selection.startIndex, selection.endIndex, identifierState[i]);
      selection = Action.selectStateInStateCM6(selection.startIndex, selection.endIndex, identifierState[i]);
  }

  let searchTerm = id[2].replaceAll("+", "\\+").replaceAll("-", "\\-").replaceAll("*", "\\*").replaceAll("?", "\\?").replaceAll("|", "\\|"); //preceed any accidental quantifiers with escape character
  searchTerm = searchTerm.replace("after", "after~`~?:Every`~`?"); //subpar solution, could be improved
  if (id[5] != "") {
      let guardStr = id[5].trim().replaceAll("+", "\\+").replaceAll("-", "\\-").replaceAll("*", "\\*").replaceAll("?", "\\?").replaceAll("|", "\\|"); //preceed any accidental quantifiers with escape character
      searchTerm = searchTerm + "\\s*[\\s*" + guardStr.trim().slice(1, guardStr.trim().length - 1) + "\\s*]";
  }

  searchTerm = searchTerm.replaceAll("]", "\\]").replaceAll("[", "\\[").replaceAll(")", "\\)?").replaceAll("(", "\\(?").replaceAll("~`~", "(").replaceAll("`~`", ")").replaceAll(" ", "\\s*").replaceAll(",", "\\s*,\\s*").replaceAll("!", "\\s*!\\s*").replaceAll("/", "\\s*/\\s*");
  searchTerm = searchTerm.replaceAll("&&", "&{1,2}");
  let pattern = new RegExp(searchTerm + ".*->", "s");

  // let startIndex = Page.codeMirrorEditor.getValue().substr(selection.startIndex, selection.endIndex - selection.startIndex).search(pattern) + selection.startIndex;
     let startIndex = Page.codeMirrorEditor6.state.doc.toString().substr(selection.startIndex, selection.endIndex - selection.startIndex).search(pattern) + selection.startIndex;
  
     // let cText = Page.codeMirrorEditor.getValue().substr(startIndex);
     let cText = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex);

  let line = Action.findEOL(cText);
  if (!(line.split("->").length - 1 === 1) ) {
      //alert("Please edit this complex transition in the textual code.");
      Page.setFeedbackMessage(" Please edit this complex transition in the textual code.");
      return;
  }
  let endIndex = startIndex + line.length;
  // let code = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
   let code = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");

  const match = code.trim().match(pattern2);
  // Extracting captured groups based on the updated pattern
  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let action = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);
  let destinationState = match[10].trim();
  if (guard === null) {
      guard = "";
  }
  //
  if (action === null) {
      action = "";
  }
  //

  //need to sanitize any linebreaks or quotes that could break the generated HTML
  //var jsInput=chosenState.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Change or Add Event Name", "Change or Add Guard", "Change or Add Action", "Change Destination State", "Delete Transition"];
  var rowFuncs = [
      "Action.modifyTransitionEventName(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.modifyTransitionGuard(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.modifyTransitionAction(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.changeTransition(\"" + destinationState + "\",\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.deleteTransition(\"" + startIndex + "\",\"" + endIndex + "\")"

  ];

  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  //add rows
  for (var i = 0; i < rowContent.length; i++) {
      var row = document.createElement("div");
      row.style.padding = "5px";
      row.style.borderRadius = "3px";
      row.style.cursor = "pointer";
      row.style.transition = "background-color 0.3s";
      row.textContent = rowContent[i];
      row.setAttribute('onclick', "javascript:" + rowFuncs[i]);
      // Highlight row on hover
      row.addEventListener("mouseover", function() {
          this.style.backgroundColor = "#ddd";
      });
      row.addEventListener("mouseout", function() {
          this.style.backgroundColor = "transparent";
      });

      //add row to context menu
      menu.appendChild(row);

  }

  //set menu location at mouse, while ensuring it is on screen
  var menuRect = menu.getBoundingClientRect();
  if (event.clientX + menuRect.width > window.innerWidth) {
      menu.style.right = (window.innerWidth - event.clientX) + "px";
  } else {
      menu.style.left = event.clientX + "px";
  }
  if (event.clientY + menuRect.height > window.innerHeight) {
      menu.style.bottom = (window.innerHieght - event.clientY) + "px";
  } else {
      menu.style.top = event.clientY + "px";
  }
  // Add a listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
      var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)) {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.addEventListener('keydown', function hideMenu(e) {
    var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)&&e.key === "Escape") {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.body.appendChild(menu);
}

Action.changeTransition = function(dest,startIndex,endIndex) {
   // let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
   let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

   // Assuming classCode contains the full transition line, including condition and destination
   let trimmedString = classCode.trim().replace(/;$/, "");

   // Split the string into condition (with guard) and destination parts
   let parts = trimmedString.split("->");
   parts[0] = parts[0].trim(); // Condition part
   parts[1] = parts[1].trim(); // Destination part

   // Ensure there are two parts (condition and destination)
   if (parts.length != 2) {
       console.log("Invalid transition format.");
       return;
   }
  var prompt = document.createElement('div');
    prompt.style.zIndex = "1000";
    prompt.style.border = "1px solid #ccc";
    prompt.style.backgroundColor = "#f8f8f8";
    prompt.style.padding = "5px";
    prompt.style.position = "absolute";
    prompt.style.left = '50%';
    prompt.style.top = '50%';
    prompt.style.transform = 'translate(-50%, -50%)';
    prompt.id = "promptBox";

    var input = document.createElement('input');
    input.type = 'text';
    input.value=parts[1];
    input.style.padding = '5px';
    input.style.margin = '5px';
    input.style.width = '200px';

    var submitButton = document.createElement('button');
    submitButton.textContent = 'Change Destination';
    submitButton.style.padding = '5px';
    submitButton.style.marginLeft = '5px';

    // Append elements to the prompt
    prompt.appendChild(input);
    prompt.appendChild(submitButton);

    // Add the prompt to the document body
    document.body.appendChild(prompt);
    input.focus(); // Automatically focus the input
    var hider=function hidePrompt(e) {
      if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
        document.removeEventListener("mousedown", hidePrompt);
        prompt.remove();
      }
    };
    // Add a listener to hide the prompt when the user clicks outside of it
    document.addEventListener("mousedown", hider);
    document.addEventListener("keydown", function(e) {
      if (e.key === "Escape") {
        prompt.remove();
        document.removeEventListener("keydown", arguments.callee);
      }
    });
    // Event listener for the submit action
    submitButton.addEventListener('click', function() {
        // Validate input value is not empty
        if (input.value.trim() === "") {
            console.log("Input for new destination state is empty.");
            return;
        }


        // Create the modified transition string with the new destination
        let modifiedTransition = parts[0] + " -> " + parts[1].replace(dest,input.value.trim()) + ";";
        
        // cm5
        // let orig = Page.codeMirrorEditor.getValue();
        let orig = Page.codeMirrorEditor6.state.doc.toString();
        let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;
        //let updatedContent = orig.replace(classCode.trim(), modifiedTransition);

        // Update the editor with the new content
        //Page.codeMirrorEditor.setValue(updatedContent);
        Page.setCodeMirror6Text(updatedContent);


        Action.removeContextMenu();
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "changeTransitionDestination");
        document.removeEventListener("mousedown",hider);
        prompt.remove(); // Remove the prompt after processing
        Action.selectMatchingText(modifiedTransition);
    });
    input.addEventListener("keydown", function(e) {
      if (e.key === "Enter") {
        e.preventDefault(); // Prevent the default form submission behavior
        e.stopPropagation();
        submitButton.click();
      }
    });
};


Action.deleteTransition = function(startIndex, endIndex) {
  //let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
 let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

 // let orig = Page.codeMirrorEditor.getValue();
 let orig = Page.codeMirrorEditor6.state.doc.toString();

  orig = orig.replace(classCode, "");
  // Update the editor with the new code

  // Page.codeMirrorEditor.setValue(orig);
     Page.setCodeMirror6Text(orig);

  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
};

// cm5
// Action.deleteTransition = function(startIndex, endIndex) {
//   let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);

//   let orig = Page.codeMirrorEditor.getValue();

//   orig = orig.replace(classCode, "");
//   // Update the editor with the new code

//   Page.codeMirrorEditor.setValue(orig);

//   Action.removeContextMenu();
//   TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
// };


Action.modifyTransitionGuard = function(startIndex,endIndex) {

  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");
  // let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  
  const match =classCode.trim().match(pattern2);

  // Extracting captured groups based on the updated pattern
  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let action = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);
  let destinationState = match[10].trim();
     if(guard===null){
       guard="";
     }
     //
     if(action===null){
       action="";
     }
  // Create the input prompt for renaming the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";

  var input = document.createElement('input');
  input.type = 'text';
  input.value = guard;
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Guard';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
    // Validate input value is not empty

    let trimmedString = classCode.trim();

    // Split the string into condition (with guard) and destination parts
    let parts = trimmedString.split("->");
    parts[0] = parts[0].trim(); 
    parts[1] = parts[1].trim(); // Destination part

    // Ensure there are two parts (condition and destination)
    if (parts.length != 2) {
        console.log("Invalid transition format.");
        return;
    }
    let modifiedTransition = "";
    if (input.value.trim() === "") {
      if (guard === null || guard === "") {
        return;
     }
     else{
       pattern=new RegExp("\\[\\s*(.*?)\\s*\\]", "g");
       modifiedTransition = classCode.replace(pattern,"");
     }
    }
    else{
      if (guard === null || guard === "") {
        if(action==null || action === ""){
          parts[0]=eventName+" ["+input.value.trim()+"]";

        }
        else{
          if(parts[1].includes(action)){
            parts[0]=eventName+" ["+input.value.trim()+"]";
          }
          else{
            parts[0]=eventName+" ["+input.value.trim()+"]"+" /{" +action+"}"
          }

        }
        modifiedTransition = parts[0]+ " -> " + parts[1];

      }
      else{
        modifiedTransition = classCode.replace(guard,input.value.trim());
      }
    }


    // Assuming classyCode is meant to represent the original content where the transition is to be found
    //let orig = Page.codeMirrorEditor.getValue();
    let orig = Page.codeMirrorEditor6.state.doc.toString();
    let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;
    //let updatedContent = orig.replace(classCode.trim(), modifiedTransition);

    // Update the editor with the new content
    //Page.codeMirrorEditor.setValue(updatedContent);
    Page.setCodeMirror6Text(updatedContent);

    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "modifyGuard");
    document.removeEventListener("mousedown",hider);
    prompt.remove(); // Remove the prompt after processing
    Action.selectMatchingText(modifiedTransition);
});
input.addEventListener("keydown", function(e) {
  if (e.key === "Enter") {
    e.preventDefault(); // Prevent the default form submission behavior
    e.stopPropagation();
    submitButton.click();
  }
});
};



Action.modifyTransitionAction = function(startIndex,endIndex) {
  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");
  // let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

  const match =classCode.trim().match(pattern2);
  // Extracting captured groups based on the updated pattern

  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let currentAction = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);

     if(guard===null){
       guard="";
     }
     //
  if(currentAction===null){
    currentAction="";
  }
  // Create the input prompt for  the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
    prompt.style.border = "1px solid #ccc";
    prompt.style.backgroundColor = "#f8f8f8";
    prompt.style.padding = "5px";
    prompt.style.position = "absolute";
    prompt.style.left = '50%';
    prompt.style.top = '50%';
    prompt.style.transform = 'translate(-50%, -50%)';
    prompt.id = "promptBox";

  var textarea = document.createElement('textarea');
  textarea.style.width = '300px';
    textarea.style.height = '100px';
    textarea.value = currentAction || ""; // Pre-fill the textarea with the current action if any
    // Styling for the textarea omitted for brevity...

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Action';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(textarea);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  textarea.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
      // Validate input value is not empty

      let trimmedString = classCode.trim();

      // Split the string into condition (with guard) and destination parts
      let parts = trimmedString.split("->");
      parts[0] = parts[0].trim(); 
      parts[1] = parts[1].trim(); // Destination part

      // Ensure there are two parts (condition and destination)
      if (parts.length != 2) {
          console.log("Invalid transition format.");
          return;
      }
      let modifiedTransition = "";
      if (textarea.value.trim() === "") {
        if (currentAction === null || currentAction === "") {
          return;
       }
       else{
         pattern=new RegExp("/\\s*\\{.*?\\}\\s*->", "g");
         modifiedTransition = classCode.replace(pattern," ->");
       }
      }
      else{
        if (currentAction === null || currentAction === "") {
          modifiedTransition = parts[0]+"/{"+textarea.value.trim()+"}"+ " -> " + parts[1];


        }
        else{
          modifiedTransition = classCode.replace(currentAction,textarea.value.trim());
        }
      }


      // Assuming classyCode is meant to represent the original content where the transition is to be found
      //let orig = Page.codeMirrorEditor.getValue();
      let orig = Page.codeMirrorEditor6.state.doc.toString();
      let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;
      //let updatedContent = orig.replace(classCode.trim(), modifiedTransition);

      // Update the editor with the new content
      // Page.codeMirrorEditor.setValue(updatedContent);
         Page.setCodeMirror6Text(updatedContent);

      Action.removeContextMenu();
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "modifyAction");
      document.removeEventListener("mousedown",hider);
      prompt.remove(); // Remove the prompt after processing
      Action.selectMatchingText(modifiedTransition);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
};





Action.modifyTransitionEventName = function(startIndex, endIndex) {
  //let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  let pattern2 = new RegExp("^(.*?)\\s*(\\[(.*?)\\])?\\s*(\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\w+);?$", "s");

  const match = classCode.match(pattern2);


  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : null;
  let action = match[5] ? match[5].trim() : null;
  let destinationState = match[6].trim();
  // Create the input prompt for renaming the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";

  var input = document.createElement('input');
  input.type = 'text';
  input.value = eventName;
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Event Name';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider = function hidePrompt(e) {
      if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
          document.removeEventListener("mousedown", hidePrompt);
          prompt.remove();
      }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
      // Validate input value is not empty
      if (input.value.trim() === "") {
          console.log("Input for new transition condition is empty.");
          return;
      }

      // Create the modified transition string
      let modifiedTransition = classCode.replace(eventName, input.value.trim());

      // Assuming classyCode is meant to represent the original content where the transition is to be found
      //let orig = Page.codeMirrorEditor.getValue();
      let orig = Page.codeMirrorEditor6.state.doc.toString();
      let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;

      // Update the editor with the new content
      //Page.codeMirrorEditor.setValue(updatedContent);
      Page.setCodeMirror6Text(updatedContent);

      Action.removeContextMenu();
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "renameTransition");
      document.removeEventListener("mousedown", hider);
      prompt.remove(); // Remove the prompt after processing
      Action.selectMatchingText(modifiedTransition);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
};

//Searches the document for any element matching the "customContextMenu" tag, and removes it. 
//Removes context menu on state and class diagrams
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.removeContextMenu = function(){
  var o = document.getElementsByTagName('customContextMenu');
  if (o.length != 0) {
    o.item(0).remove();
  }
}

//codemirror5
// //Called from Action.drawInput(), searches for existing displayColor definitions in the class code, replaces it if it exists,
// //prepends a new displayColor statement to the start of the class if one doesn't exist.
// //Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
// Action.setColor=function(classCode,className,color){
//   let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
//   if(!classyCode.includes("displayColor")){ //if color is not already set, we can prepend it to the start of the class
//     let subtext="{  displayColor "+color+";\n"; 
//     subtext=classyCode.substr(0,classyCode.indexOf("{"))+subtext+classyCode.substr(classyCode.indexOf("{")+1,classyCode.length-classyCode.indexOf("{")-1);
//     Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(classyCode,subtext));
//   } else { //otherwise, use regex to replace existing displayColor statement
//     let subtext="displayColor "+color+";"; 
//     let regex=new RegExp("displayColor\\s+.*;");
//     subtext=classyCode.replace(regex,subtext);
//     Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(classyCode,subtext));
//     setTimeout(function(){
//         TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
//     }, 100);

//   }
// }

//Called from Action.drawInput(), searches for existing displayColor definitions in the class code, replaces it if it exists,
//prepends a new displayColor statement to the start of the class if one doesn't exist.
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.setColor=function(classCode,className,color){
  // console.log("classCode: " + classCode);
  // console.log("className: " + className);
  //  console.log("color: " + color);
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(!classyCode.includes("displayColor")){ //if color is not already set, we can prepend it to the start of the class
    let subtext="{  displayColor "+color+";\n"; 
    subtext=classyCode.substr(0,classyCode.indexOf("{"))+subtext+classyCode.substr(classyCode.indexOf("{")+1,classyCode.length-classyCode.indexOf("{")-1);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(classyCode,subtext) } });

  //  Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(classyCode,subtext));
  } else { //otherwise, use regex to replace existing displayColor statement
    let subtext="displayColor "+color+";"; 
    let regex=new RegExp("displayColor\\s+.*;");
    subtext=classyCode.replace(regex,subtext);

    //Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(classyCode,subtext));
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(classyCode,subtext) } });

    setTimeout(function(){
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    }, 100);

    // setTimeout(function(){
    //     TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
    // }, 100);

  }
}

//Multiuse function called whenever a user wants to use a menu edit function that requires user input
//allows users to input their text/color selection, listens for "enter", then performs the relevant edit
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawInput = function(inputType,classCode,className){
  console.warn("class code: " + classCode);
  // creating input div
  // console.log("zzzzzz- inputType: " + inputType);
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "fixed";
  prompt.id="promptBox";
  //draw at mouse location
  var promptRect=prompt.getBoundingClientRect();
  if(event.clientX+promptRect.width>window.innerWidth){
    prompt.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    prompt.style.left = event.clientX+"px";
  }
  if(event.clientY+promptRect.height>window.innerHeight){
    prompt.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    prompt.style.top = event.clientY+"px";
  }
  var input = document.createElement('input');
  input.type = 'text';
  input.style.padding = '5px';
  input.style.borderRadius = '3px';
  input.style.border = '1px solid #ccc';
  input.style.width = '200px';
  input.style.marginLeft = '5px';
  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.textContent='Error - Please enter an alphanumeric name.';
  inputErrorMsg.style.color="red";
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);

  if(inputType=="attri"){
    //create the attribute dropdown list
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    option1.value = "String";
    option1.text = "String";
    var option2 = document.createElement("option");
    option2.value = "Integer";
    option2.text = "Integer";
    var option3 = document.createElement("option");
    option3.value = "Double";
    option3.text = "Double";
    var option4 = document.createElement("option");
    option4.value = "Float";
    option4.text = "Float";
    var option5 = document.createElement("option");
    option5.value = "Boolean";
    option5.text = "Boolean";
    var option6 = document.createElement("option");
    option6.value = "Date";
    option6.text = "Date";
    var option7 = document.createElement("option");
    option7.value = "Time";
    option7.text = "Time";
    select.add(option1);
    select.add(option2);
    select.add(option3);
    select.add(option4);
    select.add(option5);
    select.add(option6);
    select.add(option7);
    prompt.appendChild(select);
    //create the text input for attribute name
    var input = document.createElement("input");
    input.type = "text";
    input.style.padding = "5px";
    input.style.borderRadius = "3px";
    input.style.border = "1px solid #ccc";
    input.style.width = "200px";
    input.style.marginLeft = "5px";
    input.addEventListener("keydown", function(e) {
      if (e.key === "Enter") {
        // console.log("1"); 
        if(Action.validateAttributeName(input.value)){
          // console.log("1.1 validate");
          let orig=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
          let newClass;
          if(input.value.includes(":")){ //In the case users wish to type in the format - "newAttrName:Type" - instead of using dropdown
            let attriInput=input.value.split(":");
            newClass=orig.substr(0,orig.length-1)+"  "+attriInput[1].trim()+" "+attriInput[0].trim()+";\n}";
          
          } else { //if users use dropdown and type attribute name in text box
            newClass=orig.substr(0,orig.length-1)+"  "+select.value+" "+input.value+";\n}";
            // console.log("select value ", select.value);
            // console.log("input value:", input.value);
          }
          // console.log("1.2 before dispatch");
          // Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(orig,newClass));
          const textlength = Page.codeMirrorEditor6.state.doc.length
          const insertval = Page.codeMirrorEditor6.state.doc.toString().replace(orig,newClass)

          // console.log("TL::",textlength);
          // console.log("insert value" , insertval);
          console.log("orig value" , orig);
          console.log("=======================");
          console.log("newclass value" , newClass);

          Page.codeMirrorEditor6.dispatch({ 
            changes: { 
              from: 0, 
              to: textlength,
              insert:  insertval
            } 
          });

          setTimeout(() => {
            const textlength = Page.codeMirrorEditor6.state.doc.length
            const newClass2 = newClass.replace("String xx;", "String xx;\n String xx2;")
            const insertval = Page.codeMirrorEditor6.state.doc.toString().replace(newClass,newClass2)

            // console.log("TL::",textlength);
            // console.log("insert value" , insertval);
            console.log("orig value" , orig);
            console.log("=======================");
            console.log("newclass value" , newClass);
            console.log("=======================");
            console.log("newclass2 value" , newClass2);

            Page.codeMirrorEditor6.dispatch({ 
              changes: { 
                from: 0, 
                to: textlength,
                insert:  insertval
              } 
             });
          
            
          }, 30000);

          console.log("1.3 after dispatch");

          document.removeEventListener("mousedown", hider);
        
          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
          // TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(input);
  } else if(inputType=="rename"){
    var replaceAllLabel = document.createElement('label');
    replaceAllLabel.htmlFor = 'replace-all-checkbox';
    replaceAllLabel.style.marginRight = '5px';
    replaceAllLabel.appendChild(document.createTextNode("New name for \'"+className+"\'?"));
    input.value = className;
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        console.log("2"); 
        if(Action.validateAttributeName(input.value)){
          // let orig=Page.codeMirrorEditor.getValue();
          let orig = Page.codeMirrorEditor6.state.doc.toString();
          let regex=new RegExp("(\\W+)("+className+")(\\W+)");
          let res;
          while((res=orig.match(regex))!=null){
            orig=orig.substr(0,res.index+res[1].length)+input.value.trim()+orig.substr(res.index+res[1].length+res[2].length,orig.length-(res.index+res[1].length+res[2].length));
          }
          // Page.codeMirrorEditor.setValue(orig);
          Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });
          document.removeEventListener("mousedown", hider);
          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(replaceAllLabel);
    prompt.appendChild(input);    
  } else if(inputType=="subclass") {
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        console.log("3"); 
        if(Action.validateAttributeName(input.value)){
          let subtext="\nclass "+input.value+"\n{\n  isA "+className+";\n}\n";
         // Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue()+subtext);
          Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString() + subtext}});
          document.removeEventListener("mousedown", hider);
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
          prompt.remove();
          Action.removeContextMenu();
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(input);
  } else if(inputType=="color"){
    var label=document.createElement("label");
    label.textContent="Color - ";
    var arrow=document.createElement("span");
    arrow.innerHTML="&#8594;";
    arrow.style.cursor="pointer";
    arrow.fontSize="20px";
    arrow.style.paddingLeft="5px";
    input.style.width="30px";
    input.style.height="30px";
    input.type="color";
    var inputFunc=function setter(e) {
      if (e.key === 'Enter') {
        document.removeEventListener('keydown',setter);
        Action.setColor(classCode,className,input.value);
        prompt.remove();
        Action.removeContextMenu();
      }
    };
    document.addEventListener('keydown', inputFunc);
    arrow.addEventListener("click", function(){
      Action.setColor(classCode,className,input.value);
      document.removeEventListener('keydown',inputFunc);
      prompt.remove();
      Action.removeContextMenu();
    });
    // Add event listeners for hover
    arrow.addEventListener("mouseover", function() {
      arrow.style.color = "blue";
    });
    arrow.addEventListener("mouseout", function() {
      arrow.style.color = "black";
    });
    prompt.appendChild(label);
    prompt.appendChild(input);
    prompt.appendChild(arrow);
  }
  // Add the prompt to the page
  document.body.appendChild(prompt);
  input.focus();

  // console.log("zzzzzz- inputType end: " + inputType);
}

// code mirror 5 
// //Searches for existing associations, children, and associationClasses related to the target class
// //Associations are: deleted
// //Children are: pointed to parent (if exists)
// //associationClasses are: deleted
// //Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
// Action.deleteClass = function(classCode, className){
//   let orig=Page.codeMirrorEditor.getValue();
//   orig=orig.replace(classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\""),"");
//   //deletes all associations leading to target class
//   let regex=new RegExp(".*\\s*(-|<)(>|-)\\s*.*\\s*"+className+"(\\s+\\w+)*\\s*;");
//   let res;
//   while((res=orig.match(regex))!=null){ 
//     orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
//   }
//   regex=new RegExp(".*"+className+"\\s*(<|-)(>|-)\\s*.*\\s+\\w+;");
//   while((res=orig.match(regex))!=null){ 
//     orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
//   }
//   //finds all children of target class and connects them to parent of target, if it exists
//   regex=new RegExp("isA\\s+"+className);
//   if(orig.match(regex)!=null){
//     let subregex=new RegExp("isA\\s+(\\w+);");
//     let test;
//     if((test=classCode.match(subregex))!=null){ //if parent class exists, link children to it
//       let parentClass="isA "+test[1]+";";
//       while((res=orig.match(regex))!=null){
//         orig=orig.substr(0,res.index)+parentClass+orig.substr(res.index+res[0].length+1,orig.length-(res.index+res[0].length+1));
//       }
//     } else { //if parent class does not exist, delete relevant isA statements
//       while((res=orig.match(regex))!=null){
//         orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length+1,orig.length-(res.index+res[0].length+1));
//       }
//     }
//   }
//   //remove any associationClass definitions containing this class
//   regex=new RegExp("associationClass\\s+\\w+\\s*\\n*{(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*;)*([\\s|\\t]*[*]\\s+"+className+";)(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*)*?}");
//   res=null;
//   while((res=orig.match(regex))!=null){ 
//     orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
//   }
//   //set editor code, save new state, and remove the context menu
//   Page.codeMirrorEditor.setValue(orig);
//   Action.removeContextMenu();
//   TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
// }




//Searches for existing associations, children, and associationClasses related to the target class
//Associations are: deleted
//Children are: pointed to parent (if exists)
//associationClasses are: deleted
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.deleteClass = function(classCode, className){
  // let orig=Page.codeMirrorEditor.getValue();
  let orig=Page.codeMirrorEditor6.state.doc.toString();

  orig=orig.replace(classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\""),"");
  //deletes all associations leading to target class
  let regex=new RegExp(".*\\s*(-|<)(>|-)\\s*.*\\s*"+className+"(\\s+\\w+)*\\s*;");
  let res;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  regex=new RegExp(".*"+className+"\\s*(<|-)(>|-)\\s*.*\\s+\\w+;");
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  //finds all children of target class and connects them to parent of target, if it exists
  regex=new RegExp("isA\\s+"+className);
  if(orig.match(regex)!=null){
    let subregex=new RegExp("isA\\s+(\\w+);");
    let test;
    if((test=classCode.match(subregex))!=null){ //if parent class exists, link children to it
      let parentClass="isA "+test[1]+";";
      while((res=orig.match(regex))!=null){
        orig=orig.substr(0,res.index)+parentClass+orig.substr(res.index+res[0].length+1,orig.length-(res.index+res[0].length+1));
      }
    } else { //if parent class does not exist, delete relevant isA statements
      while((res=orig.match(regex))!=null){
        orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length+1,orig.length-(res.index+res[0].length+1));
      }
    }
  }
  //remove any associationClass definitions containing this class
  regex=new RegExp("associationClass\\s+\\w+\\s*\\n*{(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*;)*([\\s|\\t]*[*]\\s+"+className+";)(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*)*?}");
  res=null;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  //set editor code, save new state, and remove the context menu
  //Page.codeMirrorEditor.setValue(orig);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });


  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
}

// codemirror 5
// //Adds an association to a class, this function is called by Action.displayMenu() when the user selects "Add Association"
// //Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
// Action.addAssociationGv = function(classCode, className){
//   var elems=document.getElementsByClassName("node");
//   var orig=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
//   Action.removeContextMenu();
//   //add event listener to Graphviz nodes for left click
//   for(let i=0;i<elems.length;i++){
//     elems[i].addEventListener("mousedown", function assocClass(event){
//       var elemText=event.target;
//       //iterate up to find class node
//       while(elemText.parentElement.id!="graph0"){
//         elemText=elemText.parentNode;
//       }
//       elemText=elemText.outerHTML.substr(elemText.outerHTML.indexOf("&nbsp;"),elemText.outerHTML.indexOf("</text>")-elemText.outerHTML.indexOf("&nbsp;")).replaceAll("&nbsp;","").trim();
//       let subtext="  * -> 1 "+elemText+";\n}\n";
//       let newClass=orig.substr(0,orig.length-1)+subtext;
//       Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(orig,newClass));
//       TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
//       let others=document.getElementsByClassName("node");
//       for(let q=0;q<others.length;q++){
//         others[q].removeEventListener("mousedown",assocClass);
//       }
//     });
//   }
// }



//Adds an association to a class, this function is called by Action.displayMenu() when the user selects "Add Association"
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.addAssociationGv = function(classCode, className){
  var elems=document.getElementsByClassName("node");
  var orig=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  Action.removeContextMenu();
  //add event listener to Graphviz nodes for left click
  for(let i=0;i<elems.length;i++){
    elems[i].addEventListener("mousedown", function assocClass(event){
      var elemText=event.target;
      //iterate up to find class node
      while(elemText.parentElement.id!="graph0"){
        elemText=elemText.parentNode;
      }
      elemText=elemText.outerHTML.substr(elemText.outerHTML.indexOf("&nbsp;"),elemText.outerHTML.indexOf("</text>")-elemText.outerHTML.indexOf("&nbsp;")).replaceAll("&nbsp;","").trim();
      let subtext="  * -> 1 "+elemText+";\n}\n";
      let newClass=orig.substr(0,orig.length-1)+subtext;

      Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(orig,newClass) } });

      //Page.codeMirrorEditor.setValue(Page.codeMirrorEditor.getValue().replace(orig,newClass));
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
      let others=document.getElementsByClassName("node");
      for(let q=0;q<others.length;q++){
        others[q].removeEventListener("mousedown",assocClass);
      }
    });
  }
}
 
//Action.displayMenu() is triggered by contextmenu event on Graphviz Class "node" elements
//Draws a div containing the editing options for class GV diagrams, as well as calling the related function when clicked
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.displayMenu = function(event) {
  if(!Action.diagramInSync){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var elemText=event.target;
  //iterate up to top of class table
  while(elemText.parentElement.id!="graph0"){
    elemText=elemText.parentNode;
  }
  //unstable - grabs class name
  elemText=elemText.outerHTML.substr(elemText.outerHTML.indexOf("&nbsp;"),elemText.outerHTML.indexOf("</text>")-elemText.outerHTML.indexOf("&nbsp;")).replaceAll("&nbsp;","").trim();
 // var orig=Page.codeMirrorEditor.getValue();
 var orig=Page.codeMirrorEditor6.state.doc.toString();
 
 var chosenClass=Action.splitStates(orig);
  for(let i=0;i<chosenClass.length;i++){
    if(chosenClass[i].startsWith("class "+elemText+"{")||chosenClass[i].startsWith("class "+elemText+" ")||chosenClass[i].startsWith("class "+elemText+"\n")){
      chosenClass=chosenClass[i];
    }
  }
  if(typeof chosenClass != 'string'){
    return;
  }
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Add Attribute","Rename Class","Delete Class","Add Subclass","Add Association","Change Color"];
  var jsInput=chosenClass.replaceAll("\n","&#10").replaceAll("\"","&#$quot");;
  console.info("jsInput: " + jsInput);
  var rowFuncs = ["Action.drawInput(\"attri\",\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"rename\",\""+jsInput+"\",\""+elemText+"\")","Action.deleteClass(\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"subclass\",\""+jsInput+"\",\""+elemText+"\")","Action.addAssociationGv(\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"color\",\""+jsInput+"\",\""+elemText+"\")"];

  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  //add rows
  for (var i = 0; i < rowContent.length; i++) {
    var row = document.createElement("div");
    row.style.padding = "5px";
    row.style.borderRadius = "3px";
    row.style.cursor = "pointer";
    row.style.transition = "background-color 0.3s";
    row.textContent = rowContent[i];
    row.setAttribute('onclick',"javascript:"+rowFuncs[i]);
    // Highlight row on hover
    row.addEventListener("mouseover", function() {
      this.style.backgroundColor = "#ddd";
    });
    row.addEventListener("mouseout", function() {
      this.style.backgroundColor = "transparent";
    });

    //add row to context menu
    menu.appendChild(row);

  }

  //set menu location at mouse, while ensuring it is on screen
  var menuRect=menu.getBoundingClientRect();
  if(event.clientX+menuRect.width>window.innerWidth){
    menu.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    menu.style.left = event.clientX+"px";
  }
  if(event.clientY+menuRect.height>window.innerHeight){
    menu.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    menu.style.top = event.clientY+"px";
  }
  // Add a listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
    var prompt=document.getElementById("promptBox");
    if (e.target != menu && !menu.contains(e.target)) {
      if(prompt!=null&&e.target != prompt && !prompt.contains(e.target)){

        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
        
      } else {


        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
      }
    }
  });
  document.body.appendChild(menu);
}

Action.displayAssociMenu = function(event, associationLink) {
  const regex = /Action\.selectAssociation\('([^']+)'\)/;

  // Use the regex to extract the content
  const associationDetails = associationLink.match(regex);


  // associationDetails array contains the extracted information
  let indices = Action.selectAssociation(associationDetails[1]);

  var detailsArray = associationDetails[1].split(',');

  if (detailsArray.length == 4) {
      var destination = detailsArray[1].trim();
      var className = detailsArray[0].trim();
      var endInfo = detailsArray[2].split(' ');
      var startInfo = detailsArray[3].split(' ');

  } else {
      var destination = detailsArray[1].trim();
      var endInfo = detailsArray[2].split(' ');
      var startInfo = detailsArray[2].split(' ');
      var className = detailsArray[0].trim();

  }
  
  var searchCursor = new RegExp("(associationClass|class|interface|trait) " + className + "($|\\\s|[{])");
  var nextCursor = new RegExp("(class|interface|trait) [A-Za-z]");
  if (Page.codeMirrorOn) {
      scursor = Page.codeMirrorEditor.getSearchCursor(searchCursor);

      if (!scursor.findNext()) {
          return; // false
      }

      // Have found declaration of class. Now have to search for the next class or end
      var theStart = scursor.from();

      var theEnd = new Object();

      theEnd.line = Page.codeMirrorEditor.lineCount();
      theEnd.ch = 9999;

      scursor = Page.codeMirrorEditor.getSearchCursor(nextCursor, scursor.to());

      while (scursor.findNext()) {
          var endObject = scursor.from();

          //This is checking if the class declaration found was in a single line comment.
          innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("//"), endObject);
          var commentFound = innerCursor.findPrevious();
          if (commentFound && innerCursor.from().line == endObject.line) {
              //The class declaration found was actually in a single line comment, keep searching
              continue;
          }

          //Check if the found class declaration is in a multiline comment
          innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"), endObject);
          //Search backwards for a /* or */
          var commentFound = innerCursor.findPrevious();
          if (commentFound) {
              if (commentFound[0] === "/*") {
                  //Note, if an exit multiline comment is found first, then the class declaration cannot be in a comment

                  //Look for the exit marker
                  innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"), endObject);
                  var commentFound = innerCursor.findNext();

                  if (commentFound) {
                      var commentEnd = innerCursor.from();
                      if (commentEnd.line > endObject.line || (commentEnd.line == endObject.line && commentEnd.ch >= endObject.ch)) {
                          //The class declaration found is in a multiline comment, keep looking
                          continue;
                      }
                  }
              }
          }

          theEnd.line = endObject.line - 1;
          theEnd.ch = 999;
          break;
      }

      Page.codeMirrorEditor.setSelection(theStart, theEnd);
      var classCode = Page.codeMirrorEditor.getSelection(); //get the class code for where the association belong

  }
  var jsInput = classCode.replaceAll("\n", "&#10").replaceAll("\"", "&#$quot");;
  let isEnd = 1; //0 as start 1 as end
  let startIndex = indices.startIndex;
  let endIndex = indices.endIndex;
  Page.codeMirrorEditor.setSelection(Action.indexToPos(startIndex, Page.codeMirrorEditor.getValue()), Action.indexToPos(endIndex, Page.codeMirrorEditor.getValue()))
  var selectedText = Page.codeMirrorEditor.getSelection();

  if (selectedText.includes(endInfo[0].trim()) == false) {
      isEnd = 3;//association class
  }
  var menu = document.createElement('customContextMenu');
  //special menu for association class
  var rowContent = isEnd === 3 ?
  ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" role name"] :
  ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" multiplicity" , "Alter "+destination+" role name", "Delete the association"];
  //var rowContent = ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" multiplicity" , "Alter "+destination+" role name", "Delete the association."];
  var rowFuncs = isEnd === 3 ?
        [
            "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
            "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
            "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 1 + "\")"
        ] :[

        
      "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
      "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
      "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[0] + "\",\"" + isEnd + "\")",
      "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 1 + "\")",
      "Action.deleteAssociation(\"" + jsInput + "\",\"" + selectedText + "\")"

  ];

  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  //add rows
  for (var i = 0; i < rowContent.length; i++) {
      var row = document.createElement("div");
      row.style.padding = "5px";
      row.style.borderRadius = "3px";
      row.style.cursor = "pointer";
      row.style.transition = "background-color 0.3s";
      row.textContent = rowContent[i];
      row.setAttribute('onclick', "javascript:" + rowFuncs[i]);
      // Highlight row on hover
      row.addEventListener("mouseover", function() {
          this.style.backgroundColor = "#ddd";
      });
      row.addEventListener("mouseout", function() {
          this.style.backgroundColor = "transparent";
      });

      //add row to context menu
      menu.appendChild(row);

  }

  //set menu location at mouse, while ensuring it is on screen
  var menuRect = menu.getBoundingClientRect();
  if (event.clientX + menuRect.width > window.innerWidth) {
      menu.style.right = (window.innerWidth - event.clientX) + "px";
  } else {
      menu.style.left = event.clientX + "px";
  }
  if (event.clientY + menuRect.height > window.innerHeight) {
      menu.style.bottom = (window.innerHieght - event.clientY) + "px";
  } else {
      menu.style.top = event.clientY + "px";
  }
  // Add a listener to hide the menu when the user clicks outside of it
  document.addEventListener('keydown', function hideMenu(e) {
    var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)&&e.key === "Escape") {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.addEventListener('mousedown', function hideMenu(e) {
      var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)) {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.body.appendChild(menu);
};

Action.validateMultiplicity = function(multiplicity) {
  // Check if not empty
  if (!multiplicity) return false;

  // Validate '*' or a single positive integer including '0'
  if (multiplicity === "*" || multiplicity.match(/^\d+$/)) return true;

  // Validate range formats including "n..m", "0..*", "1..*", "n..*", "0..m", "1..m"
  if (multiplicity.match(/^(\d+|\*)\.\.(\d+|\*)$/)) {
    const parts = multiplicity.split('..');
    const lowerBound = parts[0];
    const upperBound = parts[1];

    // Handle '*' in either part of the range
    if (lowerBound === '*' || upperBound === '*') {
      // Validate "0..*" or "n..*" where n > 0
      if (lowerBound === '0' || lowerBound.match(/^\d+$/) && lowerBound !== '0') return true;
    } else {
      // Validate "n..m" where n <= m
      const n = parseInt(lowerBound, 10);
      const m = parseInt(upperBound, 10);

      if (n <= m) return true;
    }
  }

  // If none of the above conditions met, return false
  return false;
};

Action.modifyMultiplicity = function(classCode,selectedText, mult, isStart){
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(isStart==1){
    var isEnd=true;
    
  }
  else if(isStart==3){
    //alert("unable to change end multiplicity for associationClass");
    Page.setFeedbackMessage(" unable to change end multiplicity for associationClass ");
    return;
  }
  else{
    var isEnd=false;
    ;
  }
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";
 
  var input = document.createElement('input');
  input.type = 'text';
  input.value = mult; // Pre-fill with the current attribute name
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';
 
  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.style.color = "red";
  inputErrorMsg.textContent = "Please enter a valid multiplicity format (e.g., '*', '1', '0..1', '1..*', '2..5').";
 
  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);
  
  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);

   // Add ESC key listener to close the prompt
   document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });

  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
    if(Action.validateMultiplicity(input.value.trim())){
    var escapedOldMult = mult.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
    
    let updatedAssociationString;
    
    if (isEnd) {
        // If it's the end multiplicity and there are two occurrences, replace the second one
        const parts = selectedText.split(new RegExp(escapedOldMult));
        if (parts.length === 3) { // Assuming exactly two occurrences
            updatedAssociationString = parts[0] + mult.trim() + parts[1] + input.value.trim() + parts[2];
        } else if (parts.length === 2) { // Assuming only one occurrence (end multiplicity)
            updatedAssociationString = parts[0] + input.value.trim() + parts[1];
        }
    } else {
        // If it's the start multiplicity, simply replace the first occurrence
        updatedAssociationString = selectedText.replace(new RegExp(escapedOldMult), input.value.trim());
    }
    // CM5 remove
    //let orig=Page.codeMirrorEditor.getValue();
    let orig=Page.codeMirrorEditor6.state.doc.toString();;
    if((classyCode.includes(selectedText))==false){
      orig=orig.replace(selectedText,updatedAssociationString);
    }
    else{
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(selectedText,updatedAssociationString);
     orig=orig.replace(classyCode,modifiedClassCode);
    }
    
    //Page.codeMirrorEditor.setValue(orig);
    Page.setCodeMirror6Text(orig);

    // Apply updatedAssociationString to the Umple code as needed
    
     Action.removeContextMenu();
     TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
     // TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
     
     prompt.remove(); // Remove the prompt after processing
     Action.selectMatchingText(updatedAssociationString);
  }
  else {
    // If the format is invalid, display a message
    //alert("Invalid multiplicity format. Please enter a valid format (e.g., '*', '1', '0..1', '1..*', or '2..5').");
    input.focus(); // Re-focus on the input to allow the user to correct it
    prompt.appendChild(inputErrorMsg);
      }
  });

  // Add Enter key listener to trigger the change
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
 };


Action.modifyRoleName = function(classCode,selectedText, roleName,mult,isStart){
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(isStart==1){
    var isEnd=true;
    
  }
  else{
    var isEnd=false;
    ;
  }
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";
 
  var input = document.createElement('input');
  input.type = 'text';
  input.value = roleName; // Pre-fill with the current attribute name
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';
 
  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.style.color = "red";
  inputErrorMsg.textContent = "To add a role name at this end there must be a role name at the other end first";
 
  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);
 
  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
    var newRoleName = input.value.trim();
    if(roleName==""){
      var connectionPattern = /(\s*<-\s*|\s*><\s*|\s*--\s*|\s*->\s*|\s*<@>-\s*|\s*-\s*<@>\s*)/;
    var parts = selectedText.split(connectionPattern);
    var startPart = parts[0].trim(); // "1 parent"
    var updatedStartPart, updatedEndPart;
    var updatedAssociationString;
    if(parts.length>2){
      var endPart = parts[2].trim(); // "* FunctionalArea child;"
      if (isEnd) {
        if((endPart.includes("sorted"))){
          var endParts2 = endPart.split("sorted");
          var endParts = endPart.split(";");
          updatedEndPart = endParts2[0].trim()+" "+newRoleName+""+"sorted"+endParts2[1];
        }
        else{
        var endParts = endPart.split(";");
          updatedEndPart = endParts[0].trim()+" "+newRoleName+";";
        }
      } else {
        if((classyCode.includes(selectedText))==false){
          updatedStartPart = startPart.trim()+" "+newRoleName;
        }
        else{
          updatedStartPart = mult.trim()+" "+newRoleName;
        }
        if((startPart.includes("sorted"))){
          var startParts = startPart.split("sorted");

          updatedStartPart = mult.trim()+" "+newRoleName+""+"sorted"+startParts[1];
        }
      }
      updatedAssociationString = isEnd ? (startPart + parts[1] + updatedEndPart) : (updatedStartPart + parts[1] + endPart);
    }
    else{
      let parts2 = selectedText.split(";");
      parts=parts2[0].split(" ");
      if (isEnd==false) {
        updatedStartPart = mult.trim()+" "+newRoleName;
        if(parts.length>2){
          updatedAssociationString = updatedStartPart+" "+parts[1].trim()+" "+parts[2].trim()+";";
        }
        else{
          //Page.setFeedbackMessage("To add a role name at this end there must be a role name at the other end first");
          input.focus();
          prompt.appendChild(inputErrorMsg);
          return;
          //updatedAssociationString = updatedStartPart+" "+parts[1].trim()+";";
        }
      } else {
        endParts = selectedText.split(";");
        updatedAssociationString = endParts[0].trim()+" "+newRoleName+";";
      }
    }
    }
    else{
      updatedAssociationString = selectedText.replace(roleName, newRoleName);
    }
    
    //let orig=Page.codeMirrorEditor.getValue();
    let orig=Page.codeMirrorEditor6.state.doc.toString();

    if((classyCode.includes(selectedText))==false){
      orig=orig.replace(selectedText,updatedAssociationString);
    }
    else{
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(selectedText,updatedAssociationString);
     orig=orig.replace(classyCode,modifiedClassCode);
    }
    
    //Page.codeMirrorEditor.setValue(orig);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

    // Apply updatedAssociationString to the Umple code as needed
    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    // TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate"); 
     prompt.remove(); // Remove the prompt after processing
     Action.selectMatchingText(updatedAssociationString);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
 };

   
 Action.deleteAssociation = function(classCode, selectedText) {
  // let orig = Page.codeMirrorEditor.getValue();
  let orig = Page.codeMirrorEditor6.state.doc.toString();

  let classyCode = classCode.replaceAll("&#10", "\n").replaceAll("&#$quot", "\"");
  if ((classyCode.includes(selectedText)) == false) {
      orig = orig.replace(selectedText, "");
  } else {
      let modifiedClassCode = classyCode;
      modifiedClassCode = modifiedClassCode.replace(selectedText, "");

      orig = orig.replace(classyCode, modifiedClassCode);
  }

  // Page.codeMirrorEditor.setValue(orig);
  Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });
  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
  // TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
}

Action.displayAttributeMenu = function(event, attributeName, attributeType) {
  if(!Action.diagramInSync){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var elemText=event.target;
  attributeName = attributeName.trim();
  //iterate up to top of class table
  while(elemText.parentElement.id!="graph0"){
    elemText=elemText.parentNode;
  }
  //unstable - grabs class name
  elemText=elemText.outerHTML.substr(elemText.outerHTML.indexOf("&nbsp;"),elemText.outerHTML.indexOf("</text>")-elemText.outerHTML.indexOf("&nbsp;")).replaceAll("&nbsp;","").trim();
  var orig=Page.codeMirrorEditor.getValue();
  var chosenClass=Action.splitStates(orig);
  for(let i=0;i<chosenClass.length;i++){
    if(chosenClass[i].startsWith("class "+elemText+"{")||chosenClass[i].startsWith("class "+elemText+" ")||chosenClass[i].startsWith("class "+elemText+"\n")){
      chosenClass=chosenClass[i];
    }
  }
  if(typeof chosenClass != 'string'){
    return;
  }
  
  // Create context menu for attribute
  var menu = document.createElement('customContextMenu');
  var menuHeader = document.createElement('div');
  menuHeader.textContent = "Attribute: " + attributeName + "Type: " + attributeType;
  menuHeader.style.padding = "5px";
  menuHeader.style.borderBottom = "1px solid #ccc";
  menuHeader.style.fontWeight = "bold";
  menu.appendChild(menuHeader);
  var rowContent = ["Rename Attribute", "Change Type", "Delete Attribute"];
  var jsInput=chosenClass.replaceAll("\n","&#10").replaceAll("\"","&#$quot");;
  var rowFuncs = [
    "Action.renameAttribute(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")",
    "Action.changeAttributeType(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")",
    "Action.deleteAttribute(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")"
  ];


  // Set common styles for the menu
  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  
  // Add rows for each action in the context menu
  for (var i = 0; i < rowContent.length; i++) {
    var row = document.createElement("div");
    row.style.padding = "5px";
    row.style.borderRadius = "3px";
    row.style.cursor = "pointer";
    row.style.transition = "background-color 0.3s";
    row.textContent = rowContent[i];
    row.setAttribute('onclick', "javascript:" + rowFuncs[i]);
    
    // Event listeners for visual feedback on hover
    row.addEventListener("mouseover", function() {
      this.style.backgroundColor = "#ddd";
    });
    row.addEventListener("mouseout", function() {
      this.style.backgroundColor = "transparent";
    });
    
    menu.appendChild(row); // Add row to context menu
  }

  // Position the menu at the mouse location while ensuring it is on screen
  var menuRect = menu.getBoundingClientRect();
  if (event.clientX + menuRect.width > window.innerWidth) {
    menu.style.right = (window.innerWidth - event.clientX) + "px";
  } else {
    menu.style.left = event.clientX + "px";
  }
  if (event.clientY + menuRect.height > window.innerHeight) {
    menu.style.bottom = (window.innerHeight - event.clientY) + "px";
  } else {
    menu.style.top = event.clientY + "px";
  }
  document.addEventListener('keydown', function hideMenu(e) {
    var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)&&e.key === "Escape") {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  // Add an event listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
    if (e.target != menu && !menu.contains(e.target)) {
      document.removeEventListener('mousedown', hideMenu);
      Action.removeContextMenu();
    }
  });

  document.body.appendChild(menu); // Add the menu to the page
};

Action.renameAttribute = function(classCode, className, attributeName, attributeType) {
 // Create the input prompt for renaming an attribute
 var prompt = document.createElement('div');
 prompt.style.zIndex = "1000";
 prompt.style.border = "1px solid #ccc";
 prompt.style.backgroundColor = "#f8f8f8";
 prompt.style.padding = "5px";
 prompt.style.position = "absolute";
 prompt.style.left = '50%';
 prompt.style.top = '50%';
 prompt.style.transform = 'translate(-50%, -50%)';
 prompt.id = "promptBox";

 var input = document.createElement('input');
 input.type = 'text';
 input.value = attributeName; // Pre-fill with the current attribute name
 input.style.padding = '5px';
 input.style.margin = '5px';
 input.style.width = '200px';

 var submitButton = document.createElement('button');
 submitButton.textContent = 'Rename';
 submitButton.style.padding = '5px';
 submitButton.style.marginLeft = '5px';

 // Append elements to the prompt
 prompt.appendChild(input);
 prompt.appendChild(submitButton);

 // Add the prompt to the document body
 document.body.appendChild(prompt);
 input.focus(); // Automatically focus the input
 var hider=function hidePrompt(e) {
  if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
    document.removeEventListener("mousedown", hidePrompt);
    prompt.remove();
  }
};
document.addEventListener("mousedown", hider);
 // Event listener for the submit action
 submitButton.addEventListener('click', function() {
  if(Action.validateAttributeName(input.value.trim())){
    let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
    let hasType = classyCode.includes(attributeName + " :");
    let attrRegexWithType = new RegExp("\\b" + attributeName + "\\s*:\\s*\\w+\\s*;\\n?", "g");
    let attrRegexWithoutType = new RegExp("\\b" + attributeName + "\\s*;\\n?", "g");
    let newAttributeDeclaration = hasType ?
      attributeType + " " + input.value.trim()+";\n" :
      input.value.trim()+";\n";
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(attrRegexWithType, newAttributeDeclaration);
    modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType, newAttributeDeclaration);
    let globalAttrRegex = new RegExp("\\b" + attributeName + "\\b", "g");
    modifiedClassCode = modifiedClassCode.replace(globalAttrRegex, input.value.trim());

    //let orig=Page.codeMirrorEditor.getValue();
    let orig = Page.codeMirrorEditor6.state.doc.toString();

    orig=orig.replace(classyCode,modifiedClassCode);
    //Page.codeMirrorEditor.setValue(orig);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    //TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString() , "menuUpdate");
    document.removeEventListener("mousedown", hider);
    prompt.remove(); // Remove the prompt after processing
    }
 });
};

Action.changeAttributeType = function(classCode, className, attributeName, currentType) {
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";

  var select = document.createElement("select");
  // Add options to the select
  ["String", "Integer", "Double", "Float", "Boolean", "Date", "Time"].forEach(function(type) {
    var option = document.createElement("option");
    option.value = type;
    option.text = type;
    if (type === currentType) { // Mark the current type as selected
      option.selected = true;
    }
    select.appendChild(option);
  });

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change Type';
  submitButton.style.padding = '5px';
  submitButton.style.margin = '5px';
  prompt.appendChild(select);
  prompt.appendChild(submitButton);

  document.body.appendChild(prompt);
  select.focus(); // Automatically focus the select dropdown
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  document.addEventListener("mousedown", hider);
  // Event listener for the submit button action
    submitButton.addEventListener('click', function() {
      var selectedType = select.options[select.selectedIndex].value;

      if (selectedType !== currentType) { // Proceed only if the type has been changed
        let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
        let modifiedClassCode = classyCode;
        if(currentType !="String"){
          let attrRegexWithType = new RegExp("\\b" + currentType + "\\s" + attributeName,"g");
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithType,  selectedType+" "+attributeName);
        }
        else{
          
          let attrRegexWithType = new RegExp("\\b" + currentType + "\\s" + attributeName, "g");
          let attrRegexWithoutType = new RegExp("\\b" + attributeName  , "g");
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithType,  selectedType+" "+attributeName);
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType,  selectedType+" "+attributeName);
        }
        
        //let orig=Page.codeMirrorEditor.getValue();
        let orig=Page.codeMirrorEditor6.state.doc.toString();
        orig=orig.replace(classyCode,modifiedClassCode);
        // Update the editor with the new code

        //Page.codeMirrorEditor.setValue(orig);
        Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

        Action.removeContextMenu();
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
        document.removeEventListener("mousedown", hider);
        prompt.remove(); // Remove the prompt after processing

      }
      else{
        document.removeEventListener("mousedown", hider);
        prompt.remove();
      }
      })
    };


Action.deleteAttribute = function(classCode, className, attributeName, attributeType) {
  // Decode HTML entities in the classCode to work with actual line breaks and quotes
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  let attrRegexWithType = new RegExp("\\b" + attributeType + "\\s" + attributeName + "\\s*;", "g");
  let attrRegexWithoutType = new RegExp("\\b" + attributeName + "\\s*;\\n?", "g");
  // Use the regex to replace the attribute line with an empty string
  let modifiedClassCode = classyCode;
  modifiedClassCode = modifiedClassCode.replace(attrRegexWithType, "");
  modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType, "");
  
  //let orig=Page.codeMirrorEditor.getValue();
  let orig = Page.codeMirrorEditor6.state.doc.toString();
  
  orig = orig.replace(classyCode,modifiedClassCode);
  
  // Update the editor with the new code
  // Page.codeMirrorEditor.setValue(orig);
  Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
};




Action.classSelected = function(obj)
{
  // console.log("Inside classSelected")
  var previouslySelected = Page.selectedClass;
  var newClassSelected = obj;
  
  if (previouslySelected != null)
  {
    Page.selectedClass = null;
    
    // Change background color to white
    jQuery("#"+previouslySelected.id).css('background-color','white');
    
    // Hide anchors on previous class
    var selector = "#" + previouslySelected.id + "_anchor";
    for (var i=0; i<8; i++) jQuery(selector + i).hide();
  }
 
  if (newClassSelected != null)
  {
    jQuery("#umpleCanvas").addClass("unscrollable");
    Page.selectedClass = UmpleSystem.find(newClassSelected.id);
    
    // Change background color to blue
    jQuery("#"+newClassSelected.id).css('background-color', '#F3F6FB');
    
    // Show anchors on new class and remove the hovers
    var selector = "#" + newClassSelected.id + "_anchor";
    var hover = "#" + newClassSelected.id + "_hover";
    for (var i=0; i<8; i++)
    {
      jQuery(selector + i).show();
      jQuery(hover + i).hide();
    }
  }
  else
  {
    jQuery("#umpleCanvas").removeClass("unscrollable");
  }
}

Action.classHover = function(event,isHovering)
{
  var updateClass = event.currentTarget;
  if (!Action.diagramInSync) return;
  if (Page.selectedClass != null && Page.selectedClass.id == updateClass.id) return;
  
  var displayType = isHovering ? "block" : "none";
  var umpleClass = jQuery("#" + updateClass.id);
  
  // change the background color
  if (isHovering) umpleClass.css("background-color", "#F3F6FB");
  else umpleClass.css("background-color", "white");
  
  // show or hide the hovers (if they are enabled)
  if (Page.canShowHovers())
  {
    var numHovers = 8;
    var hoverSelector = "#" + updateClass.id + "_hover";
    for (var i=0; i<numHovers; i++)
    {
      if (isHovering) jQuery(hoverSelector + i).show();
      else jQuery(hoverSelector + i).hide();  
    }
  }
}

Action.unselectAll = function()
{
  Action.classSelected(null);
  Action.associationSelected(null);
  Action.generalizationSelected(null);
  Action.transitionSelected(null);
}

Action.classClicked = function(event)
{
  // DEBUG F
  // console.log("Debug F1: Inside classClicked")
  // console.log("Event: ", event)
  if (!Action.diagramInSync) return;
  Action.focusOn("umpleCanvas", true);
  Action.focusOn("umpleModelEditorText", false);

  Action.unselectAll();
  Action.elementClicked = true;
  var obj = event.currentTarget;

  Action.selectClass(obj.id);
  
  if (Page.selectedItem == "DeleteEntity")
  {
    DiagramEdit.classDeleted(obj.id);
  }
  else if (Page.selectedItem == "AddAssociation")
  {
    if (DiagramEdit.newAssociation == null)
    {
      Action.canCreateByDrag = false;
      DiagramEdit.createAssociationPartOne(event);
    }
    else
    {
      DiagramEdit.createAssociationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  else if (Page.selectedItem == "AddGeneralization")
  {
    if (DiagramEdit.newGeneralization == null)
    {
      var successful = DiagramEdit.createGeneralizationPartOne(event);
      if (successful) Action.canCreateByDrag = false;
    }
    else
    {
      DiagramEdit.createGeneralizationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  
  else
  {
    Action.classSelected(obj);
  }
}

/*
  Called whenever a state or nested state is clicked in a state diagram
  Internally calls Action.selectStateInClassCM6() if single-level state is clicked in diagram
  or
  calls Action.selectStateInStateCM6() if nested-state is clicked in  diagram
  Highlights the corresponding code for diagram part clicked, in the code editor

  Parameters: identifier - complete name of target that was clicked in state machine diagram (See example below)
              Single State -> CourseSection^*^status^*^Open
                              CourseSection - Class name
                              status - state-machine name
                              open - state name
              Nested State -> CourseSection^*^status^*^Open.NotEnoughStudents
                              CourseSection - class name
                              status - state-machine name
                              Open.NotEnoughStudents - nested state
*/
Action.stateClicked = function(identifier)
{
    // console.log("Debug G1: Inside stateClicked")
    // console.log("Identifier: ", identifier)
    if (!Action.diagramInSync) return;
    Action.focusOn("umpleCanvas", true);
    Action.focusOn("umpleModelEditorText", false);
    var idSplit=identifier.split("^*^");
    var identifierClass=idSplit[0]
    var identifierSM=idSplit[1]
    var identifierState=idSplit[2].replace("Entry:","").replace("Exit:","");
    identifierState=identifierState.replace("Exit:","");
    // console.log("identifierState: ", identifierState)
    Action.unselectAll();
    Action.elementClicked = true;
    var selectionIndicies=null;
    var selectionIndiciesCM6=null;
    if(identifierState.includes('.')){ //nested case
      console.log("stateClicked - nested state case")
      identifierState=identifierState.split('.');
      // Removing CM5
      // selectionIndicies=Action.selectStateInClass(identifierClass,identifierSM,identifierState[0]);
      selectionIndiciesCM6=Action.selectStateInClassCM6(identifierClass,identifierSM,identifierState[0]);
      // console.log("selectionIndicies: ", selectionIndicies)
      // console.log("identifierState.length: ", identifierState.length)
      for(let i=1;i<identifierState.length;i++){
        console.log("Iterating states within Identified state ...")
        // console.log("selectionIndiciesCM6.startIndex: ", selectionIndiciesCM6.startIndex)
        // Removing CM5
        // selectionIndicies=Action.selectStateInState(selectionIndicies.startIndex,selectionIndicies.endIndex,identifierState[i]);
        selectionIndiciesCM6=Action.selectStateInStateCM6(selectionIndiciesCM6.startIndex,selectionIndiciesCM6.endIndex,identifierState[i]);
      }
    } else { //base case
      console.log("stateClicked - else - base case")
      // Removing CM5
      // selectionIndicies=Action.selectStateInClass(identifierClass,identifierSM,identifierState);
      // console.log("selectionIndicies: ", selectionIndicies)
      selectionIndiciesCM6 = Action.selectStateInClassCM6(identifierClass,identifierSM,identifierState);
      console.log("selectionIndiciesCM6: ", selectionIndiciesCM6)
    }
    // Removing CM5
    // Action.highlightByIndex(selectionIndicies.startIndex,selectionIndicies.endIndex);
    Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);



   if (Page.selectedItem == "AddTransition")
    {
        if (DiagramEdit.newTransition == null)
        {
            Action.canCreateByDrag = false;
            DiagramEdit.createTransitionPartOne(event);
        }
        else
        {
            DiagramEdit.createTransitionPartTwo(event);
            setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
        }
    }
    else
    {
        //Action.stateSelected(identifier);
    }
}

Action.associationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
  
  var obj = event.currentTarget;
  Action.associationSelected(obj);
}

/*
  Called when a transition is clicked in the state digram
  Internally calls Action.selectStateInClassCM6() and Action.selectStateInStateCM6() 
  to locate selected class, start and end states in the code present in code editor
  and highlights the target transition between the start and end states

  Parameters: identifier - complete name of target that was clicked in state machine diagram (See example below)
              CourseSection*^*status*^*openRegistration*^*Planned*^*Open.NotEnoughStudents*^*
              CourseSection - class name
              status - state-machine name
              openRegistration - transition name
              Planned - start state
              Open.NotEnoughStudents - end state
*/
Action.transitionClicked = function(identifier)
{
  // console.log("Inside transitionClicked: ")
  // console.log("identifier: ", identifier)
  if(!Action.diagramInSync) return;
  if(typeof identifier === "string" && identifier === null) return;
  Action.elementClicked = true;
  Action.unselectAll();
  let id = identifier.split("*^*");
  let identifierState=id[3].split(".");
  
  dest=id[4];
  //dest=id[4].split(".");
  // Removing CM5
  // var selection = Action.selectStateInClass(id[0],id[1],identifierState[0]);
  var selection = Action.selectStateInClassCM6(id[0],id[1],identifierState[0]);
  dest=id[4].split(".");

  for (var i=1;i<identifierState.length;i++){
    // Removing CM5
    // selection=Action.selectStateInState(selection.startIndex,selection.endIndex,identifierState[i]);
    selection=Action.selectStateInStateCM6(selection.startIndex,selection.endIndex,identifierState[i]);
  }
  let searchTerm=id[2].replaceAll("+","\\+").replaceAll("-","\\-").replaceAll("*","\\*").replaceAll("?","\\?").replaceAll("|","\\|"); //preceed any accidental quantifiers with escape character
  searchTerm=searchTerm.replace("after","after~`~?:Every`~`?"); //subpar solution, could be improved
  if(id[5]!=""){

    let guardStr=id[5].trim().replaceAll("+","\\+").replaceAll("-","\\-").replaceAll("*","\\*").replaceAll("?","\\?").replaceAll("|","\\|"); //preceed any accidental quantifiers with escape character
    searchTerm=searchTerm+"\\s*[\\s*"+guardStr.trim().slice(1,guardStr.trim().length-1)+"\\s*]";

  }
  searchTerm=searchTerm.replaceAll("]","\\]").replaceAll("[","\\[").replaceAll(")","\\)?").replaceAll("(","\\(?").replaceAll("~`~","(").replaceAll("`~`",")").replaceAll(" ","\\s*").replaceAll(",","\\s*,\\s*").replaceAll("!","\\s*!\\s*").replaceAll("/","\\s*/\\s*"); 
  searchTerm=searchTerm.replaceAll("&&","&{1,2}");
  let pattern= new RegExp(searchTerm+".*->","s");

  // Removing CM5
  // let startIndex=Page.codeMirrorEditor.getValue().substr(selection.startIndex,selection.endIndex-selection.startIndex).search(pattern)+selection.startIndex;
  // let cText = Page.codeMirrorEditor.getValue().substr(startIndex);
  let startIndex=Page.codeMirrorEditor6.state.doc.toString().substr(selection.startIndex,selection.endIndex-selection.startIndex).search(pattern)+selection.startIndex;
  let cText = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex);
  let line = Action.findEOL(cText);
  let endIndex=startIndex+line.length;
  // Removing CM5
  // Action.highlightByIndex(startIndex,endIndex);
  Action.highlightByIndexCM6(startIndex,endIndex);

// DEBUG THE FOLLOWING MAY NEED CHANGING FOR CM6  
  if(!(line.split("->").length - 1 === 1) ){
    //alert("Please edit this complex transition in the textual code.");
    Page.setFeedbackMessage("Please edit this complex transition in the textual code.");
  }
  
  Action.highlightByIndex(startIndex,endIndex);
// DEBUG the following block commented out for unknown reason
  /*
  let code = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
   let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");
   const match =code.trim().match(pattern2);
 
   // Extracting captured groups based on the updated pattern
   let eventName = match[1].trim();
   let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
   let action = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);
   let destinationState = match[10].trim();
*/
}
Action.generalizationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
    
  var obj = event.currentTarget;
  Action.generalizationSelected(obj);
}

Action.associationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateAssociation = event.currentTarget;
  var umpleAssociation = UmpleSystem.findAssociation(updateAssociation.id);
  
  if (updateAssociation != null && Page.canShowHovers())
  {
    var hoverCount = 2;
    var selector = "#" + updateAssociation.id + "_hover";
    
    for (var i=0; i<hoverCount; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.transitionHover = function(event,isHovering)
{
    if (!Action.diagramInSync) return;
    var updateTransition = event.currentTarget;
    var umpleTransition = UmpleSystem.findTransition(updateTransition.id);

    if (updateAssociation != null && Page.canShowHovers())
    {
        var hoverCount = 2;
        var selector = "#" + updateAssociation.id + "_hover";

        for (var i=0; i<hoverCount; i++)
        {
            if (isHovering) jQuery(selector+i).show();
            else jQuery(selector+i).hide();
        }
    }
}


Action.generalizationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateGeneralization = event.currentTarget;
  
  if (updateGeneralization != null && Page.canShowHovers())
  {
    var selector = "#" + updateGeneralization.id + "_hover";
    for (var i=0; i<3; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.associationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.associationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedAssociation = obj;
    updateObj = obj;
  }
  else if (Page.selectedAssociation != null)
  {
    updateObj = Page.selectedAssociation;
    Page.selectedAssociation = null;
  }
  else
  {
    return;  
  }
  
  var anchorCount = 2;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}

Action.transitionSelected = function(obj)
{
    // Page.setFeedbackMessage("transition selected");
    var isSelected = (obj == null) ? false : true;
    var updateObj = null;

    if (Page.selectedItem == "DeleteEntity" && obj != null)
    {
        var addToQueue = false;
        DiagramEdit.transitionDeleted(obj.id, addToQueue);
        return;
    }

    if (obj != null)
    {
        Page.selectedTransition = obj;
        updateObj = obj;
    }
    else if (Page.selectedTransition != null)
    {
        updateObj = Page.selectedTransition;
        Page.selectedTransition = null;
    }
    else
    {
        return;
    }

    var anchorCount = 2;
    var anchorSelector = "#" + updateObj.id + "_anchor";
    for (var i=0; i<anchorCount; i++)
    {
        if (isSelected) jQuery(anchorSelector + i).show();
        else jQuery(anchorSelector + i).hide();
    }
}

Action.generalizationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.generalizationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedGeneralization = obj;
    updateObj = obj;
  }
  else if (Page.selectedGeneralization != null)
  {
    updateObj = Page.selectedGeneralization;
    Page.selectedGeneralization = null;
  }
  else
  {
    return;  
  }

  var anchorCount = 3;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}

Action.executeCode = function(languageStyle, languageName)
{
  var executeCodeSelector = "#buttonExecuteCode";
  var actualLanguage = languageName;
  
  jQuery(executeCodeSelector).showLoading();
  Action.ajax(
    function(response) { 
      Action.executeCodeCallback(response); 
    },
    format("execute=true&language={0}&languageStyle={1}&model={2}", actualLanguage, languageStyle, Page.getModel()),
    "true"
  );
}

Action.generateCode = function(languageStyle, languageName)
{
  var generateCodeSelector = "#buttonGenerateCode";
  var actualLanguage = languageName;
  var additionalCallback;
  if (Page.getAdvancedMode() == 0 && (languageName === "Cpp"))
  {
    actualLanguage = "Experimental-"+languageName;
  }

  if(languageName === "StateTables")
  {
    additionalCallback = StateTree.colourStateTables;
  }

  if(languageName === "EventSequence")
  {
    additionalCallback = StateTree.colourEventSequences;
  }

  //Vahdat
  if(languageName === "stateDiagram")
  {
    actualLanguage = languageName+"."+$("inputGenerateCode").value.split(":")[1];
  }
  
  jQuery(generateCodeSelector).showLoading();
  Action.ajax(
    function(response) { 
      Action.generateCodeCallback(response, languageStyle, additionalCallback); 
    },
    format("language={0}&languageStyle={1}", actualLanguage, languageStyle),
    "true"
  );
}

Action.photoReady = function()
{
  var canvasSel = "#" + Page.umpleCanvasId();
  if (Page.isPhotoReady())
  {
    jQuery(canvasSel).addClass("photoReady");
  }
  else
  {
    jQuery(canvasSel).removeClass("photoReady");
  }
  
  UmpleSystem.redrawCanvas();
}

Action.executeCodeCallback = function(response)
{
  var executeCodeSelector = "#buttonExecuteCode";
  jQuery(executeCodeSelector).hideLoading();
  Page.showExecutionArea();
  Page.hideGeneratedCodeOnly();
  Page.showExecutedResponse(response.responseText);
  window.location.href='#codeExecutionArea';
}

Action.generateCodeCallback = function(response, language, optionalCallback)
{
  Page.showGeneratedCode(response.responseText,language);
  Page.hideExecutionArea();
  Action.gentime = new Date().getTime();

  if(optionalCallback !== undefined)
  {
    optionalCallback();
  }

  var generateCodeSelector = "#buttonGenerateCode";
  jQuery(generateCodeSelector).hideLoading();
  Page.showCodeDone();
  window.location.href='#genArea';
}

Action.classMouseDown = function(event)
{
  if (!Action.canCreateByDrag) return;
  
  if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation == null)
  {
    DiagramEdit.createAssociationPartOne(event);
  }
  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization == null)
  {
    DiagramEdit.createGeneralizationPartOne(event);
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition == null)
  {
      DiagramEdit.createTransitionPartOne(event);
  }
}

Action.classMouseUp = function(event)
{
  if (!Action.canCreateByDrag) return;
  
  if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation != null)
  {
    DiagramEdit.createAssociationPartTwo(event);
  }
  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization != null)
  {
    DiagramEdit.createGeneralizationPartTwo(event);
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition != null){
    DiagramEdit.createTransitionPartTwo(event);
  }
}

Action.mouseMove = function(event)
{
  Page.clickCount = 0;
  
  if (Page.selectedItem == "AddClass")
  {
    if (DiagramEdit.newClass == null)
    {
      DiagramEdit.newClass = new UmpleClass();
      DiagramEdit.newClass.name = "";
      DiagramEdit.newClass.id = "tempClass";
    }
    Action.drawClassOutline(event, DiagramEdit.newClass);
  }
  
  if (DiagramEdit.newAssociation != null && Page.selectedItem == "AddAssociation")
  {
    Action.drawAssociationLine(event, DiagramEdit.newAssociation);
  }
  if (DiagramEdit.newTransition != null && Page.selectedItem == "AddTransition")
  {
    Action.drawTransitionLine(event, Diagramedit.newTransition);
  }
  if (DiagramEdit.newGeneralization != null && Page.selectedItem == "AddGeneralization")
  {
    Action.drawGeneralizationLine(event, DiagramEdit.newGeneralization);
  }
}

Action.drawClassOutline = function(event, newClass)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var screenPosition = new UmplePosition(event.pageX, event.pageY + 1,0,0);
  var mousePosition = screenPosition.subtract(UmpleSystem.position());
  
  newClass.position = new UmplePosition(mousePosition.x, mousePosition.y, UmpleClassFactory.defaultSize.width, UmpleClassFactory.defaultSize.height);
  var classOutline = newClass.drawableClassOutline();
  jQuery(canvasSelector).append(classOutline);
  
  var classSel = "#" + newClass.id;
  var widthSel = classSel + "_width";
  var heightSel = classSel + "_height";
  
  var offset = new Object();
  offset.left = screenPosition.x;
  offset.top = screenPosition.y;
  
  jQuery(classSel).offset(offset);
  jQuery(widthSel).width(newClass.position.width);
  jQuery(heightSel).height(newClass.position.height);
}

Action.drawAssociationLine = function(event, newAssociation)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var mousePosition = new UmplePosition(event.pageX, event.pageY,0,0);
  newAssociation.classTwoPosition = mousePosition.subtract(UmpleSystem.position());
  jQuery(canvasSelector).append(newAssociation.drawable());
}

Action.drawTransitionLine = function(event, newTransition)
{
    var canvasSelector = "#" + Page.umpleCanvasId();
    var mousePosition = new UmplePosition(event.pageX, event.pageY,0,0);
    newTransition.toStatePosition = mousePosition.subtract(UmpleSystem.position());
    jQuery(canvasSelector).append(newTransition.drawable());
}


Action.drawGeneralizationLine = function(event, newGeneralization)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var generalizationSelector = "#" + newGeneralization.getElementId();
  
  var umpleSystem = UmpleSystem.position();
  var parentX = event.pageX - 5 - umpleSystem.x;
  var parentY = event.pageY + 5 - umpleSystem.y; 
  newGeneralization.parentPosition = new UmplePosition(parentX,parentY,0,0);
  
  jQuery(generalizationSelector).remove();
  jQuery(canvasSelector).append(newGeneralization.drawable(false));
}

Action.umpleCanvasClicked = function(event)
{
  if (Action.elementClicked)
  {
    Action.elementClicked = false;
    return;
  }
  
  if (Page.selectedItem == "AddClass")
  {
    var position = new UmplePosition(Math.floor(event.pageX),Math.floor(event.pageY),0,0);
    DiagramEdit.addClass(position);
  }
  else if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation != null)
  {
    if (Page.clickCount > 1)
    {
      DiagramEdit.removeNewAssociation();
    }
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition != null)
  {
    if (Page.clickCount >1)
    {
      DiagramEdit.removeNewTransition();
    }
  }

  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization != null)
  {
    if (Page.clickCount > 1)
    {
    	DiagramEdit.removeNewGeneralization();
    }
  }
  else
  {
    Action.unselectAll();
  }
}

// Called when a change is made by a command that modifies the text, to refresh it
// and then refresh the diagram.
Action.directUpdateCommandCallback = function(response)
{
  Action.updateUmpleTextCallback(response);
  Action.redrawDiagram();
}

// Called whenever any change is made on the graphic pane
// such as adding/deleting/moving/renaming class/assoc/generalization
Action.updateUmpleTextCallback = function(response)
{
  // console.log("Inside updateUmpleTextCallback: ")
  if (!justUpdatetoSaveLater && !justUpdatetoSaveLaterForTextCallback){
    TabControl.getCurrentHistory().save(response.responseText, "TextCallback");
    Page.setExampleMessage("");
  }
  Action.freshLoad = true;
  
  Page.setUmpleCode(response.responseText, Action.update.codeChange);
  // DEBUG
  // Page.setFeedbackMessage("update text callback -");
  // Page.catFeedbackMessage(response.responseText);
  // Page.catFeedbackMessage("-");
  
  Page.hideLoading();

  if (DiagramEdit.textChangeQueue.length == 0) 
  {
    Action.freshLoad = false;
    DiagramEdit.pendingChanges = false;
    Action.setjustUpdatetoSaveLater(false);
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  else{
    Action.setjustUpdatetoSaveLater(true);
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
    DiagramEdit.doTextUpdate();
  }
  
  //Uncomment for testing purposes only - to update the image after updating the text
  //Action.updateUmpleDiagram();
}

Action.setExampleType = function setExampleType()
{
  // Hide them all first
  jQuery("#itemLoadExamples").hide();
  jQuery("#itemLoadExamples2").hide();
  jQuery("#itemLoadExamples3").hide();
  jQuery("#itemLoadExamples4").hide();
     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").prop("selected",true);
   }
   else if(Page.getExampleType() == "smModels") {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").prop("selected",true);
   }
   else if(Page.getExampleType() == "featureModels") {
     jQuery("#itemLoadExamples4").show();
     jQuery("#defaultExampleOption4").prop("selected",true);
   }
   else {
     jQuery("#itemLoadExamples3").show();
     jQuery("#defaultExampleOption3").prop("selected",true);
   }   
}

Action.loadExample = function loadExample()
{
  var diagramType = this.dataset['diagramType'];
  var $option = jQuery(' option:selected', this);
  if ($option.hasClass('openUmprOption')) {
    // user wants to open the umpr repository
    location.href = "http://umpr.umple.org?diagram-type=" + diagramType;
    return;
  }

  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
  var exampleName = Page.getSelectedExample().slice(0,-4);
  var diagramType="";
  if(Page.useGvStateDiagram) {
    diagramType="&diagramtype=state";
    //jQuery("#genjava").prop("selected",true);
  }
 else if(Page.useGvFeatureDiagram) {
    diagramType="&diagramtype=GvFeature";
    //jQuery("#genjava").prop("selected",true);
  }
  else if(Page.useStructureDiagram) {
    diagramType="&diagramtype=structure&generateDefault=cpp";
    //jQuery("#gencpp").prop("selected",true);
  }
  else {
    //jQuery("#genjava").prop("selected",true);
  }
  
  var largerSelector = "#buttonLarger";
  var smallerSelector = "#buttonSmaller";
  var canvasSelector = "#" + Page.umpleCanvasId();
  
  umpleCanvasWidth = jQuery(canvasSelector).width();
  umpleCanvasHeight = jQuery(canvasSelector).height();
  
  var sel = Page.getSelectedExample();
  
  if (exampleName.startsWith("https")) {
    var shortExampleName=exampleName.split("/").pop();
    var newURL="?filename="+exampleName.substr(8)+".ump"+diagramType;
  }
  else
  {
    var shortExampleName=exampleName;
    var newURL="?example="+shortExampleName+diagramType;
  }
  
  Page.setExampleMessage("<a href=\""+newURL+"\">URL for "+shortExampleName+" example</a>");

 // TODO - fix so history works nicely
 //   if(history.pushState) {history.pushState("", document.title, newURL);}
           
  jQuery("#inputExample").blur();
}

Action.loadExampleCallback = function(response)
{
  Action.freshLoad = true;
  Action.setjustUpdatetoSaveLater(true);
  Page.setUmpleCode(response.responseText, function(){
    Page.hideLoading();
    Action.updateUmpleDiagram()}
  );
  Action.setCaretPosition("0");
  Action.updateLineNumberDisplay();
  TabControl.getCurrentHistory().save(response.responseText, "loadExampleCallback");
}

Action.customSizeTyped = function()
{
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  
  var width = jQuery("#widthField").val();
  var height = jQuery("#heightField").val();
  
  Action.oldTimeout = setTimeout(function(){ Page.setUmpleCanvasSize(width, height); }, Action.waiting_time);
}

Action.moveSelectedClass = function(umpleClass, delta)
{
  if (umpleClass == null) return;
  
  umpleClass.position = umpleClass.position.add(delta);
  UmpleSystem.updateClass(umpleClass);
  Action.classSelected(umpleClass);
  
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  Action.oldTimeout = setTimeout(function() {DiagramEdit.classMoved(Page.selectedClass);}, 1000); 
}

Action.keyboardShortcut = function(event)
{
    
  if (!Page.shortcutsEnabled)
  {
    return;
  }
  
  var shortcut = event.which;

  if (shortcut == 27)    // escape
  {
    var shortcutDisabled = Page.unselectAllToggleTools();

    if(!shortcutDisabled)
    {
      jQuery(".visibleFocus").blur();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    if(Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0)
    {
      DiagramEdit.classDeleted(Page.selectedClass.id);
      event.preventDefault();	  
    }
    else if(Page.selectedAssociation)
    {
      DiagramEdit.associationDeleted(Page.selectedAssociation.id);
      event.preventDefault();	  
    }
    else if(Page.selectedGeneralization)
    {
      DiagramEdit.generalizationDeleted(Page.selectedGeneralization.id);
      event.preventDefault();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleClass").is(":focus")){
  	DiagramEdit.classDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && (jQuery(".untracedAssociation").is(":focus")||jQuery(".redTracedAssociation").is(":focus"))){
  	DiagramEdit.associationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleGeneralization").is(":focus")){
  	DiagramEdit.generalizationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
}

Action.getCaretPosition = function() // TIM Returns the line number
{
  var ctrl = document.getElementById('umpleModelEditorText');
  
  var CaretPos = Action.getInputSelectionStart(ctrl);
  
  var nlcount=1;
  var theCode=Page.getRawUmpleCode();

  for(var ch=0; ch<(CaretPos); ch++)
  {
     if(theCode.charAt(ch)=="\n") nlcount++;
     
     // The following for debugging
     if (Page.getAdvancedMode() == 2 && ch < 15) { // debug
       Page.catFeedbackMessage("<"+ch+" "+theCode.charAt(ch)+"="+theCode.charCodeAt(ch)+"> ");
     }
  }
  return nlcount;
}

// The following from http://stackoverflow.com/questions/263743/how-to-get-cursor-position-in-textarea/3373056#3373056
Action.getInputSelectionStart = function(el) 
{
  var start = 0, normalizedValue, range, textInputRange, len, endRange;

  if (typeof el.selectionStart == "number" && typeof el.selectionEnd == "number") 
  {
    start = el.selectionStart;
    // The following for debugging
    if (Page.getAdvancedMode() == 2) 
    { // debug
      Page.setFeedbackMessage("Non-IE browser ");
    }
  }
  else 
  { // IE Support
    // The following for debugging
    if (Page.getAdvancedMode() == 2) // debug
    { 
      Page.setFeedbackMessage("IE-type browser ");
    }
    range = document.selection.createRange();
    
    if (range && range.parentElement() == el) {
      len = el.value.length;
      normalizedValue = el.value.replace(/\r\n/g, "\n");
    
      // Create a working TextRange that lives only in the input
      textInputRange = el.createTextRange();
      textInputRange.moveToBookmark(range.getBookmark());
    
      // Check if the start and end of the selection are at the very end
      // of the input, since moveStart/moveEnd doesn't return what we want
      // in those cases
      endRange = el.createTextRange();
      endRange.collapse(false);
    
      if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) 
      {
        start = len;
      } 
      else 
      {
        start = -textInputRange.moveStart("character", -len);
        start += normalizedValue.slice(0, start).split("\n").length - 1;
      }
    }
  }

  return start;
}

Action.setCaretPosition = function(line)
{
  if(isNaN(line-0)) 
  {
    // It is not a number so must be a special hidden command
    if(line=="gd") 
    {
      jQuery('#gdprtext').show();
      Action.gdprHidden = false;      
    }
    if(line=="av") 
    {
      // Special backdoor to turn on experimental features
      document.getElementById('advancedMode').value=1;


      Page.setFeedbackMessage("");
      return;
    }
    if(line=="db") 
    { // turn on debugging and do certain debugging options
      document.getElementById('advancedMode').value=2;
      Page.setFeedbackMessage("Debug Mode");
      return;
    }
    if(line=="sp")
    { // creates Survey Pass; modifies conditions to allow for survey to be displayed:
      // includes setting RandomizedFrequency to 1, MinutesBeforePrompt to 5 secs, EditsBeforePrompt to 1;
      if (existSCookie("surveyCookie")==null && window.localStorage.getItem("surveyShown")==null){
        if (document.getElementById("styleTip")!=null)
          document.getElementById("styleTip").innerHTML="";
        window.randomSurveyRoll = 1;
        window.surveyData.EditsBeforePrompt=1;
        timeSurveyUp = false;
        clearTimeout(timeSurvey);
        timeSurvey = setTimeout(function(){timeSurveyUp = true;}, 10000);
        timeSurvey;
        displayedText=false;
        if (!displayedText){
          beforeInstance = TabControl.getCurrentHistory().currentIndex;
          document.addEventListener("mouseover", function(){
            if (TabControl.getCurrentHistory().currentIndex-beforeInstance >= 1 && !displayedText && timeSurveyUp){
                displaySurvey();
                this.removeEventListener('mouseover', arguments.callee);
            }                        
          });
        }
      }
      
    }
    if (line=="sc")
    { // clears all survey cookies including whether URL has been shown already, whether the user has been skipped, and whether Survey Pass has been activated
      // run twice for it to be effective
      let setToExpire=new Date();
      setToExpire.setTime(setToExpire.getTime()-1000);
      document.cookie="surveyCookie=done; expires="+setToExpire.toUTCString()+"; path=/;";
      window.localStorage.removeItem("surveyShown");
      document.addEventListener("mouseover", function(){});
      setCookieBeforeClose("off");
    }
    if(line=="tc")
    { // resets cookies for tips
      Page.setFeedbackMessage("Clearing tip cookies");
      let currentTime=new Date();
      currentTime.setTime(currentTime.getTime()-1000);
      window.localStorage.removeItem("first_time");
      document.cookie="tipCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
    }
    if(line.substr(0,2)=="cm") 
    {
      if(line.substr(2,1)=="0" && Page.codeMirrorOn) 
      {
        Page.setFeedbackMessage("Turning code mirroring off");
        Page.codeMirrorEditor.toTextArea();
        Page.codeMirrorOn=false;
        jQuery("#linenum").val("0");
      }
      else if(line.substr(2,1)=="1" && !Page.codeMirrorOn) 
      {
        Page.initCodeMirrorEditor();
        jQuery("#linenum").val("0");
      }
      return;
    }
    if(line.substr(0,2)=="bp") {  // Begin prompt - Also invoked by ctrl-b
      Action.promptAndExecuteTest();
      return;
    }
    else
    {
      if(!Action.selectMatchingText(line)) 
      {
        Page.setFeedbackMessage("Line number or word \""+line+"\" not located");
        setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},3000);
      }
      return;
    }
  }
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor.setSelection({line: line-1,ch: 0},{line: line-1,ch: 999999});
    Page.codeMirrorEditor.focus();
    
    // DEBUG
    // console.log("Inside Action.setCaretPosition() ... Line number: ", line)
    /* codemirror 6 line highlight by number*/
    if(line >= 1) {
      const docPosition = Page.codeMirrorEditor6.state.doc.line(line).from;
      // Page.codeMirrorEditor6.dispatch({effects: cm6.addLineHighlight.of(docPosition)})
      Page.codeMirrorEditor6.dispatch({
        selection: { anchor: docPosition },
        scrollIntoView: true
      })
    }
 
    return;
  }
  var ctrl = document.getElementById('umpleModelEditorText');
  var startPos=0;
  var endPos=-1;

  if(line<1)
  {
    endPos=0;
  }
  else
  {
    var theCode=Page.getRawUmpleCode();
    for(var ch=0; ch<theCode.length; ch++)
    {
      if(theCode.charAt(ch)=='\n')
      {
        line--;
        if(line==1) startPos=ch+1;
        if(line==0) {
          endPos=ch; 
          break;
        }
      }
    }
    if(endPos==-1) { // got to end
      endPos=theCode.length;
      if(line!=1) startPos=endPos;
    }
  }

  if(ctrl.setSelectionRange)
  {
    ctrl.focus();
    ctrl.setSelectionRange(startPos,endPos);
  }
  else if (ctrl.createTextRange) {
    var range = ctrl.createTextRange();
    range.collapse(true);
    range.moveEnd('character', endPos);
    range.moveStart('character', startPos);
    range.select();
  }
}

// This pops up a panel that can be used to execute certain specialized test commands
// This should be expanded to allow other commands
Action.promptAndExecuteTest = function() {

  // Get the arguments if any (separated by spaces)
  var testCommand=prompt("Umpleonline test prompt. Enter command e.g. 'ac Classname' to add a class","");

  var edargs=testCommand.substr(2,99).strip().split(" "); 
  if(testCommand.substr(0,1)=="a") {
    // add something
    if(testCommand.substr(1,1)=="c") {
      // add class - one argument
      if(edargs.length >=1) {
        Action.directAddClass(edargs[0]);
        return;
      }
    }
    else if (testCommand.substr(1,1)=="a") {
      // add attribute to class - two arguments
      if(edargs.length >=2) {
        Action.directAddAttribute(edargs[0],edargs[1]);
        return;
      }
    }
    else {
      Page.setFeedbackMessage("Syntax error in test add command");
    }
    Page.setFeedbackMessage("Syntax error in test command");
  }
  else {

  }
  return;
}

// Adds a class with the given name. The class may already be there. Just edits the text.
// This could be modified to 
Action.directAddClass = function(className) {

  var umpleJson = Json.toString({"position" : {"x" : "10","y" : "10","width" : "109","height" : "41"},"name" : className});

  Page.setFeedbackMessage("Adding class "+className);
  Action.setjustUpdatetoSaveLater(false);
  Action.ajax(Action.directUpdateCommandCallback,format("action=addClass&actionCode={0}",umpleJson));

  // After a pause to let the ajax return, then redraw the diagram.
  // This could be put in a new callback
  // setTimeout(function() {Action.redrawDiagram();},1000);
  return;
}

// Adds an attribute to a class
Action.directAddAttribute = function(classname, attribute) {
  // This has to be written.
  // It should look for a matching class, and then look for the attributes in it, then
  // inject the new attribute after it. This assumes no type. That could be added by changing
  // this to have three arguments (if the third one was missing there would be no type, hence
  // string as default.
  // If there is no matching class, this should output a message 
  
  Page.setFeedbackMessage("((when written) Adding to class "+classname+" attribute "+attribute);  
  return;
}


// Searches for the matching text in the code mirror editor
// Does not span lines
Action.selectMatchingText = function(text) 
{
  // Does nothing if CodeMirror is off
  if(Page.codeMirrorOn) {
    var scursor = Page.codeMirrorEditor.getSearchCursor(text);
    if(!scursor.findNext()) {
      return false;
    }
    Page.codeMirrorEditor.setSelection(scursor.from(),scursor.to());
    Page.codeMirrorEditor.focus();
    return true;
  }
  return false;
}

// Removing CM5
// Code behind highlighting of text
// Action.selectItem = function(searchCursor, nextCursor)
// {
//   console.log("Debug F3: Inside selectItem")
// 	if(Page.codeMirrorOn) {
//     var scursor = Page.codeMirrorEditor.getSearchCursor(searchCursor);
//     // console.log("scursor: ", scursor)
//     // console.log("nextCursor: ", nextCursor)
    
//     if(!scursor.findNext()) {
//       console.log("scursor.findNext() is NULL or EMPTY !")
//       return; // false
//     }

//     // Have found declaration of class. Now have to search for the next class or end
//     var start = scursor.from();

//     var theEnd=new Object();

//     theEnd.line = Page.codeMirrorEditor.lineCount();
//     theEnd.ch = 9999;
    
//     scursor = Page.codeMirrorEditor.getSearchCursor(nextCursor,scursor.to());
    
//     while(scursor.findNext())
//     {
//       var endObject = scursor.from();
      
//       //This is checking if the class declaration found was in a single line comment.
//       innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("//"), endObject);
//       var commentFound = innerCursor.findPrevious();
//       if(commentFound && innerCursor.from().line == endObject.line) 
//       {
//         //The class declaration found was actually in a single line comment, keep searching
//         continue;
//       }

//       //Check if the found class declaration is in a multiline comment
//       innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"), endObject);
//       //Search backwards for a /* or */
//       var commentFound = innerCursor.findPrevious();
//       if (commentFound) 
//       {
//         if(commentFound[0] === "/*") 
//         {
//           //Note, if an exit multiline comment is found first, then the class declaration cannot be in a comment
          
//           //Look for the exit marker
//           innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"), endObject);
//           var commentFound = innerCursor.findNext();
          
//           if(commentFound) 
//           {
//             var commentEnd = innerCursor.from();
//             if (commentEnd.line > endObject.line || (commentEnd.line == endObject.line && commentEnd.ch >= endObject.ch))
//             {
//               //The class declaration found is in a multiline comment, keep looking
//               continue;
//             }
//           }
//         }
//       }
      
//       theEnd.line = endObject.line -1;
//       theEnd.ch = 999;
//       break;
//     }
//     // console.log("start of selection: ", start)
//     // console.log("end of selection: ", theEnd)
//     Page.codeMirrorEditor.setSelection(start,theEnd);
//     return;    //true 
//   }
//   return;  // false - important do not return a value or it won't work in Firefox/Opera
// }

/*
  Called by Action.selectClass() or Action.selectMethod() or Action.selectState()
  Returns an object containing start and end indices of item (class or method or state)
  based on the searchCursor parameter
  Parameters: searchCursor - a regular expression object created in either of Caller methods 
                              with target class name or method name or state name
*/
Action.selectItemCM6 = function(searchCursor){
  // console.log("Debug F4: Inside selectItemCM6")
  if(Page.codeMirrorOn) {
    var text = Page.codeMirrorEditor6.state.doc.toString();
    let splitBuffer=Action.splitStates(text);
    let currClass=null;
    for(let i=0;i<splitBuffer.length;i++){
      if(splitBuffer[i].search(searchCursor)==0){
        currClass=splitBuffer[i];
        break;
      }
    }
    // console.log("currClass: ", currClass)
    let startIndex=text.indexOf(currClass);
    let endIndex=startIndex+currClass.length;
    // let endIndex=startIndex+currClass.length +1;

    // console.log("startIndex:", startIndex)
    // console.log("endIndex:", endIndex)
    var outputObj={startIndex: startIndex,endIndex: endIndex};
    return outputObj;
  }
}


// Highlights the text of the method that is currently selected.
Action.selectMethod = function(methodName, type, accessMod)
{
  // console.log("Inside selectMethod: ")
	var scursor = new RegExp(accessMod+" "+type+" "+methodName+"(\\\s|[(])");
	var ncursor = new RegExp("(public|protected|private|class) [A-Za-z]");

  // Removing CM5
  // Action.selectItem(scursor, ncursor);

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex) ;
}

// CM5 Associated removed

// Action.selectAssociation = function(associationDetails) {
//   var detailsArray = associationDetails.split(',');
//   var className = detailsArray[0];
//   var searchCursor = new RegExp("(associationClass|class|interface|trait) " + className + "($|\\\s|[{])");
//   var nextCursor = new RegExp("(class|interface|trait) [A-Za-z]");
//   if (Page.codeMirrorOn) {
//       scursor = Page.codeMirrorEditor.getSearchCursor(searchCursor);

//       if (!scursor.findNext()) {
//           return; // false
//       }

//       // Have found declaration of class. Now have to search for the next class or end
//       var theStart = scursor.from();

//       var theEnd = new Object();

//       theEnd.line = Page.codeMirrorEditor.lineCount();
//       theEnd.ch = 9999;

//       scursor = Page.codeMirrorEditor.getSearchCursor(nextCursor, scursor.to());

//       while (scursor.findNext()) {
//           var endObject = scursor.from();

//           //This is checking if the class declaration found was in a single line comment.
//           innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("//"), endObject);
//           var commentFound = innerCursor.findPrevious();
//           if (commentFound && innerCursor.from().line == endObject.line) {
//               //The class declaration found was actually in a single line comment, keep searching
//               continue;
//           }

//           //Check if the found class declaration is in a multiline comment
//           innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"), endObject);
//           //Search backwards for a /* or */
//           var commentFound = innerCursor.findPrevious();
//           if (commentFound) {
//               if (commentFound[0] === "/*") {
//                   //Note, if an exit multiline comment is found first, then the class declaration cannot be in a comment

//                   //Look for the exit marker
//                   innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"), endObject);
//                   var commentFound = innerCursor.findNext();

//                   if (commentFound) {
//                       var commentEnd = innerCursor.from();
//                       if (commentEnd.line > endObject.line || (commentEnd.line == endObject.line && commentEnd.ch >= endObject.ch)) {
//                           //The class declaration found is in a multiline comment, keep looking
//                           continue;
//                       }
//                   }
//               }
//           }

//           theEnd.line = endObject.line - 1;
//           theEnd.ch = 999;
//           break;
//       }

//       Page.codeMirrorEditor.setSelection(theStart, theEnd);
//       //debug console.log("theStart: ", theStart);
//       // console.log("theEnd: ", theEnd);
//       var selectedText = Page.codeMirrorEditor.getSelection();//get the class code for where the association belong
//   }
//   var start, end;
//   //for labelAssociation
//   if (detailsArray.length > 3) {
//       if (detailsArray[2].trim().includes(' ')) {
//           // When there's a space, indicating the presence of a role name or additional details
//           var array = detailsArray[2].split(' ');
//           start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&"); // Assuming the start multiplicity is always in the 4th segment
//           if (array.length == 2) {
//               // When there's more than just the multiplicity and class name, indicating a role name is present
//               end = array[0].trim() + ' ' + detailsArray[1].trim() + ' ' + array[1].trim();
//           } else {
//               end = array[0].trim() + ' ' + detailsArray[1].trim();
//           }
//       } else {
//           // When there's no space, meaning no role name is present
//           start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&");
//           end = detailsArray[2].trim() + ' ' + detailsArray[1].trim();
//       }


//       var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
//       var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
//       var patternString = startEscaped + "(?:\\s+sorted\\s+{.*?})?" + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped + "(?:\\s+sorted\\s+{.*?})?" + "\\s*;";

//       var pattern = new RegExp(patternString, "g");
//       var code = Page.codeMirrorEditor.getValue();
//       //Finding matches using the constructed pattern
//       var matches = selectedText.match(pattern);
//       if (matches) {
          
//           startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
//           endIndex = startIndex + matches[0].length;
//           Action.highlightByIndex(startIndex, endIndex);

//           //debug : console.log("startIndex: ", startIndex);
//           //debug : console.log("endIndex: ", endIndex);

//           return { startIndex: startIndex, endIndex: endIndex };
//       } else {
//           if (endEscaped.startsWith("1")) { // this for simple writing association
//               end = endEscaped.substring(2).trim();
//               endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
//               patternString = startEscaped + "\\s+" + endEscaped+ "\\s*;";
//               pattern = new RegExp(patternString, "g");
//               matches = selectedText.match(pattern);
//               if (matches == null) {
//                   patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
//                   pattern = new RegExp(patternString, "g");
//                   matches = selectedText.match(pattern);
//               }
              
//               startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
//               endIndex = startIndex + matches[0].length;
//               Action.highlightByIndex(startIndex, endIndex);
//               return { startIndex: startIndex, endIndex: endIndex };
//           } else {
//               if (startEscaped.trim().includes(' ')) {
//                   var newstart = startEscaped.split(' ');
//                   startEscaped = newstart[0].trim() + " " + className + " " + newstart[1].trim();
//               } else {
//                   startEscaped += " " + className;
//               }
              
//               patternString = startEscaped + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped+ "\\s*;";
//               pattern = new RegExp(patternString, "g");
//               matches = code.match(pattern);
//               if (matches == null) {
//                   patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
//                   pattern = new RegExp(patternString, "g");
//                   matches = code.match(pattern);
//               }
              
//               startIndex = code.indexOf(matches[0]);
//               endIndex = startIndex + matches[0].length;
//               Action.highlightByIndex(startIndex, endIndex);
//               console.log("startIndex: ", startIndex);
//               console.log("endIndex: ", endIndex);  
//               return { startIndex: startIndex, endIndex: endIndex };

//           }
//       }

//   } else { //for two label association

//       var array = detailsArray[2].split(' ');
//       start = array[0].trim();
//       end = array[1].trim();

//       var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
//       var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
//       var patternString = startEscaped + ".*?" + endEscaped+ "\\s*;";
//       var pattern = new RegExp(patternString, "g");
//       var code = Page.codeMirrorEditor.getValue();
//       //Finding matches using the constructed pattern
//       var matches = selectedText.match(pattern);
//       if (matches) {
//           startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
//           endIndex = startIndex + matches[0].length;
//           Action.highlightByIndex(startIndex, endIndex);
//           return { startIndex: startIndex, endIndex: endIndex };
//       }

//   }
// }


Action.selectAssociation = function(associationDetails) {
  var detailsArray = associationDetails.split(',');
  var className = detailsArray[0];
  var searchCursor = new RegExp("(associationClass|class|interface|trait) " + className + "($|\\\s|[{])");
  var nextCursor = new RegExp("(class|interface|trait) [A-Za-z]");
  if (Page.codeMirrorOn) {
      scursor = Page.codeMirrorEditor.getSearchCursor(searchCursor);

      if (!scursor.findNext()) {
          return; // false
      }

      // Have found declaration of class. Now have to search for the next class or end
      var theStart = scursor.from();

      var theEnd = new Object();

      theEnd.line = Page.codeMirrorEditor.lineCount();
      theEnd.ch = 9999;

      scursor = Page.codeMirrorEditor.getSearchCursor(nextCursor, scursor.to());

      while (scursor.findNext()) {
          var endObject = scursor.from();

          //This is checking if the class declaration found was in a single line comment.
          innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("//"), endObject);
          var commentFound = innerCursor.findPrevious();
          if (commentFound && innerCursor.from().line == endObject.line) {
              //The class declaration found was actually in a single line comment, keep searching
              continue;
          }

          //Check if the found class declaration is in a multiline comment
          innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"), endObject);
          //Search backwards for a /* or */
          var commentFound = innerCursor.findPrevious();
          if (commentFound) {
              if (commentFound[0] === "/*") {
                  //Note, if an exit multiline comment is found first, then the class declaration cannot be in a comment

                  //Look for the exit marker
                  innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"), endObject);
                  var commentFound = innerCursor.findNext();

                  if (commentFound) {
                      var commentEnd = innerCursor.from();
                      if (commentEnd.line > endObject.line || (commentEnd.line == endObject.line && commentEnd.ch >= endObject.ch)) {
                          //The class declaration found is in a multiline comment, keep looking
                          continue;
                      }
                  }
              }
          }

          theEnd.line = endObject.line - 1;
          theEnd.ch = 999;
          break;
      }

      Page.codeMirrorEditor.setSelection(theStart, theEnd);
      //debug console.log("theStart: ", theStart);
      // console.log("theEnd: ", theEnd);
      var selectedText = Page.codeMirrorEditor.getSelection();
      //get the class code for where the association belong
  }
  var start, end;
  //for labelAssociation
  if (detailsArray.length > 3) {
      if (detailsArray[2].trim().includes(' ')) {
          // When there's a space, indicating the presence of a role name or additional details
          var array = detailsArray[2].split(' ');
          start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&"); // Assuming the start multiplicity is always in the 4th segment
          if (array.length == 2) {
              // When there's more than just the multiplicity and class name, indicating a role name is present
              end = array[0].trim() + ' ' + detailsArray[1].trim() + ' ' + array[1].trim();
          } else {
              end = array[0].trim() + ' ' + detailsArray[1].trim();
          }
      } else {
          // When there's no space, meaning no role name is present
          start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&");
          end = detailsArray[2].trim() + ' ' + detailsArray[1].trim();
      }


      var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var patternString = startEscaped + "(?:\\s+sorted\\s+{.*?})?" + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped + "(?:\\s+sorted\\s+{.*?})?" + "\\s*;";

      var pattern = new RegExp(patternString, "g");
      // var code = Page.codeMirrorEditor.getValue();
      var code = Page.codeMirrorEditor6.state.doc.toString();
      //Finding matches using the constructed pattern
      var matches = selectedText.match(pattern);
      if (matches) {
          
          startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
          endIndex = startIndex + matches[0].length;
          
          Action.highlightByIndexCM6(startIndex, endIndex);

          //debug : console.log("startIndex: ", startIndex);
          //debug : console.log("endIndex: ", endIndex);

          return { startIndex: startIndex, endIndex: endIndex };
      } else {
          if (endEscaped.startsWith("1")) { // this for simple writing association
              end = endEscaped.substring(2).trim();
              endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
              patternString = startEscaped + "\\s+" + endEscaped+ "\\s*;";
              pattern = new RegExp(patternString, "g");
              matches = selectedText.match(pattern);
              if (matches == null) {
                  patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
                  pattern = new RegExp(patternString, "g");
                  matches = selectedText.match(pattern);
              }
              
              startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
              endIndex = startIndex + matches[0].length;
              Action.highlightByIndexCM6(startIndex, endIndex);
              return { startIndex: startIndex, endIndex: endIndex };
          } else {
              if (startEscaped.trim().includes(' ')) {
                  var newstart = startEscaped.split(' ');
                  startEscaped = newstart[0].trim() + " " + className + " " + newstart[1].trim();
              } else {
                  startEscaped += " " + className;
              }
              
              patternString = startEscaped + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped+ "\\s*;";
              pattern = new RegExp(patternString, "g");
              matches = code.match(pattern);
              if (matches == null) {
                  patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
                  pattern = new RegExp(patternString, "g");
                  matches = code.match(pattern);
              }
              
              startIndex = code.indexOf(matches[0]);
              endIndex = startIndex + matches[0].length;
              Action.highlightByIndexCM6(startIndex, endIndex);
              //console.log("startIndex: ", startIndex);
              //console.log("endIndex: ", endIndex);  
              return { startIndex: startIndex, endIndex: endIndex };

          }
      }

  } else { //for two label association

      var array = detailsArray[2].split(' ');
      start = array[0].trim();
      end = array[1].trim();

      var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var patternString = startEscaped + ".*?" + endEscaped+ "\\s*;";
      var pattern = new RegExp(patternString, "g");
      // var code = Page.codeMirrorEditor.getValue();
      var code = Page.codeMirrorEditor6.state.doc.toString();
      //Finding matches using the constructed pattern
      var matches = selectedText.match(pattern);
      if (matches) {
          startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
          endIndex = startIndex + matches[0].length;
          Action.highlightByIndexCM6(startIndex, endIndex);
          return { startIndex: startIndex, endIndex: endIndex };
      }

  }
}


// Highlights the text of the class that is currently selected.
Action.selectClass = function(className) 
{
  // console.log("Inside selectClass: ")
	var scursor = new RegExp("(associationClass|class|interface|trait) "+className+"($|\\\s|[{])");
	var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

  // Removing CM5
  // Action.selectItem(scursor, ncursor);

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);
}

// Highlights the text of the state that is currently selected.
Action.selectState = function(stateName)
{
  // console.log("Inside selectState: ")
    var scursor = new RegExp("(class|interface|trait) "+stateName+"($|\\\s|[{])");
    var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

  // Removing CM5
  // Action.selectItem(scursor, ncursor);

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);
}

Action.splitStates=function(inputStr){
  let output=[];
  let temp="";
  let depth=0;
  let inComment=false;
  let EOLflag=false;
  for(var inChar in inputStr){
    let curChar=inputStr.charAt(inChar);
    if(EOLflag&&curChar!='\n'&&curChar!=" "){
      EOLflag=false;
      if(curChar!='{'){
        temp="";
      }
    }
    if(curChar=='/'&&inputStr.charAt((parseInt(inChar)+1))=='/'){
      inComment=true;
    }
    if(curChar=='\n'&&inComment){
         inComment=false;
    }

    if(curChar=='{'&&!inComment){ //increase depth
      temp=temp+curChar;
      depth++;
    }else if(curChar=='}'&&!inComment){ //decrease depth
      temp=temp+curChar;
      depth--;
      if(depth==0){
        output.push(temp.trim());
        temp="";
      }
    } else if(curChar=='\n'&&depth==0){ //flush temp at EOL when depth=0
      EOLflag=true;
      temp=temp+"\n";
    } else if(curChar==' '&&depth==0&&temp==""){//ignore empty spaces when depth=0
    }else { //push char to temp variable
        temp=temp+curChar;
    }

  }
  return output;
}
Action.indexToPos = function(index,inputText){
  var ch=0;
  var outputLine=0;
  var temp="";
  for(var i=0;i<index;i++){
    let curChar=inputText.charAt(i);
        if(curChar=="\n"){
      outputLine++;
      temp="";
    } else {
      temp=temp+curChar;
    }
  }
  ch=temp.length;
  output={line:outputLine,ch:ch};
  return  output;
}

// Removing CM5
// Action.selectStateInClass = function(className, smName, stateName)
// {
//   console.log("Debug: Inside selectStateInClass")
//   if(Page.codeMirrorOn) {
//     let text = Page.codeMirrorEditor.getValue();
//     let splitBuffer=Action.splitStates(text);
//     let currClass=null;
//     let pattern = new RegExp("(?:class|queued)\\s+"+className,"");
//     for(let i=0;i<splitBuffer.length;i++){
//       if(splitBuffer[i].search(pattern)==0){
//         currClass=splitBuffer[i]; //set currClass to class code
//         break;
//       }
//     }
//     splitBuffer=Action.splitStates(currClass.substr(currClass.indexOf("{")+1)); //split class into un-nested SMs
//     let currSM=null;
//     for(let i=0;i<splitBuffer.length;i++){
//       let query=new RegExp("(?:queued\\s*)?"+smName);
//       if(splitBuffer[i].search(query)==0){
//         currSM=splitBuffer[i]; //set currSM to un-nested SM code
//         break;
//       }
//     }
//     splitBuffer=Action.splitStates(currSM.substr(currSM.indexOf("{")+1));
//     if (splitBuffer!=null) {
//       let states = splitBuffer;
//       let finState=null;
//       for(let i=0;i<states.length;i++){
//         if(states[i].search(stateName)==0){
//           finState=states[i];
//           break;
//         }
//       }
//       let startIndex=text.indexOf(currClass);//index of class start
//       let endIndex=startIndex+currClass.length;
//       startIndex=text.substr(startIndex,endIndex).indexOf(currSM)+startIndex;//match[1] contains the SM definition+name
//       endIndex=startIndex+currSM.length;
//       startIndex=text.substr(startIndex,endIndex).indexOf(finState)+startIndex;//finds target state definition within target class and state machine
//       endIndex=startIndex+finState.length;
//       var outputObj={startIndex:startIndex,endIndex:startIndex+finState.length};
//       return outputObj;
      
//     } else {
//       console.log("No matching state found with regex:"+pattern);
//     }
//   } else {
//     console.log("No matching class and state machine found for class: "+className+" and sm "+smName);
//   }
//   return null;
// }

/*
  Returns the start and ending position of state inside a state machine in a specific class
  Parameters: stateName - state that has to be searched
              smName - state machine inside which state has to be searched
              className - class inside which state machine containing the state exists
*/
Action.selectStateInClassCM6 = function(className, smName, stateName) 
{
  // console.log("Debug: Inside selectStateInClass CM6");
  if(Page.codeMirrorOn) {
    var text = Page.codeMirrorEditor6.state.doc.toString();
    let splitBuffer=Action.splitStates(text);
    let currClass=null;
    let pattern = new RegExp("(?:class|queued)\\s+"+className,"");
    for(let i=0;i<splitBuffer.length;i++){
      if(splitBuffer[i].search(pattern)==0){
        currClass=splitBuffer[i]; //set currClass to class code
        break;
      }
    }
    // console.log("currClass: ", currClass)
    splitBuffer=Action.splitStates(currClass.substr(currClass.indexOf("{")+1)); //split class into un-nested SMs
    let currSM=null;
    for(let i=0;i<splitBuffer.length;i++){
      let query=new RegExp("(?:queued\\s*)?"+smName);
      if(splitBuffer[i].search(query)==0){
        currSM=splitBuffer[i]; //set currSM to un-nested SM code
        break;
      }
    }
    // console.log("currSM: ", currSM)
    splitBuffer=Action.splitStates(currSM.substr(currSM.indexOf("{")+1));
    if (splitBuffer!=null) {
      let states = splitBuffer;
      let finState=null;
      for(let i=0;i<states.length;i++){
        if(states[i].search(stateName)==0){
          finState=states[i];
          break;
        }
      }
      let startIndex=text.indexOf(currClass);//index of class start
      let endIndex=startIndex+currClass.length;
      // console.log("initial startIndex: ", startIndex)
      // console.log("initial endIndex: ", endIndex)
      startIndex=text.substr(startIndex,endIndex).indexOf(currSM)+startIndex;//match[1] contains the SM definition+name
      endIndex=startIndex+currSM.length;
      startIndex=text.substr(startIndex,endIndex).indexOf(finState)+startIndex;//finds target state definition within target class and state machine
      endIndex=startIndex+finState.length;
      // console.log("startIndex: ", startIndex)
      // console.log("endIndex: ", endIndex)
      var outputObj={startIndex:startIndex,endIndex:startIndex+finState.length};
      return outputObj;
      
    } else {
      console.log("No matching state found with regex:"+pattern);
    }
  } else {
    console.log("No matching class and state machine found for class: "+className+" and sm "+smName);
  }
  return null; 
}

// Removing CM5
// Action.selectStateInState = function(startIndex,endIndex,target){
//   console.log("Debug: Inside selectStateInState")
//   // console.log("Parameters: ", startIndex, endIndex, target)
//   let temp=Page.codeMirrorEditor.getValue().substr(startIndex,endIndex-startIndex);
//   // console.log("code for NestedState: ", temp)
//   let states=Action.splitStates(temp.substr(temp.indexOf("{")+1));
//   // console.log("states: ", states)
//   var stateFin=null;
//   for(let i=0;i<states.length;i++){
//     if(states[i].startsWith(target)){
//       stateFin=states[i];
//       break;
//     }
//   }
//   // console.log("stateFin: ", stateFin)
//   // console.log("startIndex: ", startIndex)
//   let outputStart=temp.indexOf(stateFin)+startIndex;
//   let outputEnd=outputStart+stateFin.length;
//   let outputObj={startIndex:outputStart,endIndex:outputEnd};
//   // console.log("outputObj: ", outputObj)
//   return outputObj;
// }

/*
  Returns the start and ending position of target state within given indices range
*/
Action.selectStateInStateCM6 = function(startIndex,endIndex,target){
  // console.log("Debug: Inside selectStateInState CM6")
  var temp = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex,endIndex-startIndex);
  // console.log("code for NestedState: ", temp)
  let states=Action.splitStates(temp.substr(temp.indexOf("{")+1));
  // console.log("states: ", states)
  var stateFin=null;
  for(let i=0;i<states.length;i++){
    if(states[i].startsWith(target)){
      stateFin=states[i];
      break;
    }
  }
  // console.log("stateFin: ", stateFin)
  let outputStart=temp.indexOf(stateFin)+startIndex;
  let outputEnd=outputStart+stateFin.length;
  let outputObj={startIndex:outputStart,endIndex:outputEnd};
  return outputObj;
}

Action.highlightByIndex = function(startIndex,endIndex){
  Page.codeMirrorEditor.setSelection(Action.indexToPos(startIndex,Page.codeMirrorEditor.getValue()),
  Action.indexToPos(endIndex,Page.codeMirrorEditor.getValue()))
}

/*
  Highlights specific code in codemirror6 editor with startIndex and endIndex
  Parameters: startIndex, endIndex
              Exact position of start and end characters of code block to be highlighted in code-editor
*/
Action.highlightByIndexCM6 = function(startIndex,endIndex){
  // console.log("Inside highlightByIndexCM6: Highlighting code ...")
  let startSelection = Action.indexToPos(startIndex,Page.codeMirrorEditor6.state.doc.toString());
  let startDocPosition = Page.codeMirrorEditor6.state.doc.line(startSelection.line +1).from;
  // console.log("selection start: ", startSelection)
  // console.log("selection start Document Position: ", startDocPosition)
  let endSelection = Action.indexToPos(endIndex,Page.codeMirrorEditor6.state.doc.toString());
  let endDocPosition = Page.codeMirrorEditor6.state.doc.line(endSelection.line +1).from;
  // console.log("selection end: ", endSelection)
  // console.log("selection end Document Position: ", endDocPosition)

  // following code selects first line of intended block
  // Page.codeMirrorEditor6.dispatch({ 
  //   selection: { anchor: startDocPosition }, 
  //   scrollIntoView: true 
  // })

  // following is for multiple selection ranges
  Page.codeMirrorEditor6.dispatch({
    selection: cm6.EditorSelection.create([
      cm6.EditorSelection.range(startDocPosition, endDocPosition),
      // cm6.EditorSelection.range(endDocPosition, endDocPosition+1),
      // cm6.EditorSelection.cursor(endDocPosition+1)
    ]),
    scrollIntoView: true
  })
}

Action.findEOL = function(inputStr){ //returns ONLY depth==0 lines as an array without letting non-EOL \n's cause line breaks
  let output="";
  let temp="";
  let depth=0;
  let EOLflag=false;
  for(var inChar in inputStr){
    let curChar=inputStr.charAt(inChar);
    if(curChar=='{'){
      depth++;
      temp=temp+curChar;
    } else if(curChar=='}'){
      depth--;
      temp=temp+curChar;
    } else if(curChar==';'&&depth==0){
      output=temp+';';
      break;
    } else {
      temp=temp+curChar;
    }

  }
  return output;
}
Action.delayedFocus = function(ms) 
{
  var ctrl=document.getElementById('umpleModelEditorText');
  setTimeout(function() {ctrl.focus();},ms);
}

Action.updateLineNumberDisplay = function()
{
  // console.log("Inside Action.updateLineNumberDisplay()...")
  jQuery("#linenum").val(Action.getCaretPosition());
}

Action.umpleTyped = function(eventObject)
{
  // DEBUG
  console.log("Inside Action.umpleTyped()...")
  // This function is not called by CodeMirror
  // See umpleCodeMirrorTypingActivity if CodeMirror is on (as it normally is)
  // debug - output key code
  if (Page.getAdvancedMode() == "2") { // debug
     Page.catFeedbackMessage("["+eventObject.keyCode+"] ");
  }
  Action.updateLineNumberDisplay();

  var eventCode = eventObject.keyCode;
  
  // Ignore 33=pgup 34=pgdn 35=end 36=hom 37=lef 38=up 39=rt 40=dn
  if(eventCode>=33 && eventCode <=40) return;

  var target = eventObject.target.id;
  Action.umpleTypingActivity(target);
}

Action.umpleCodeMirrorCursorActivity = function() {
  // console.log("Inside Action.umpleCodeMirrorCursorActivity()...")
  // Removing CM5
  // var line = Page.codeMirrorEditor.getCursor(true).line+1;
  var docPosition = Page.codeMirrorEditor6.state.selection.main.head;
  var line = Page.codeMirrorEditor6.state.doc.lineAt(docPosition);
  jQuery("#linenum").val(line.number);
}

// Called whenever any text is changed in codemirror 5 or codemirror 6
Action.umpleCodeMirrorTypingActivity = function(editorThatChanged) {
  // DEBUG
  console.log("Inside Action.umpleCodeMirrorTypingActivity...")

  if(Action.freshLoad == false) {
    // Start/restart timer to eventually process this by triggerink disk save and diagram update
    Action.umpleTypingActivity(editorThatChanged);
    if(editorThatChanged == "codeMirrorEditor") {
      Page.codeMirrorEditor.save();
    }
  }
  else {
    Action.freshLoad = false;
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }

}

Action.trimMultipleNonPrintingAndComments = function(text) {
  text = Action.removeComments(text);
  text = text.replace(/[^\x21-\x7E]+/g, ' '); // change non-printing chars to spaces
  text= text.replace(/^\s+|\s+$/g, '');      // remove leading/trailing spaces
  return text;
}

Action.removeComments = function(str) 
{
   // From http://james.padolsey.com/javascript/javascript-comment-removal-revisted/
 
    var uid = '_' + +new Date(),
        primatives = [],
        primIndex = 0;
 
    return (
        str
        /* Remove strings */
        .replace(/(['"])(\\\1|.)+?\1/g, function(match){
            primatives[primIndex] = match;
            return (uid + '') + primIndex++;
        })
 
        /* Remove Regexes */
        .replace(/([^\/])(\/(?!\*|\/)(\\\/|.)+?\/[gim]{0,3})/g, function(match, $1, $2){
            primatives[primIndex] = $2;
            return $1 + (uid + '') + primIndex++;
        })
 
        /*
        - Remove single-line comments that contain would-be multi-line delimiters
            E.g. // Comment /* <--
        - Remove multi-line comments that contain would be single-line delimiters
            E.g. /* // <-- 
       */
        .replace(/\/\/.*?\/?\*.+?(?=\n|\r|$)|\/\*[\s\S]*?\/\/[\s\S]*?\*\//g, ' ')
 
        /*
        Remove single and multi-line comments,
        no consideration of inner-contents
       */
        .replace(/\/\/.+?(?=\n|\r|$)|\/\*[\s\S]+?\*\//g, ' ')
 
        /*
        Remove multi-line comments that have a replaced ending (string/regex)
        Greedy, so no inner strings/regexes will stop it.
       */
        .replace(RegExp('\\/\\*[\\s\\S]+' + uid + '\\d+', 'g'), ' ')
 
        /* Bring back strings & regexes */
        .replace(RegExp(uid + '(\\d+)', 'g'), function(match, n){
            return primatives[n];
        })
    );
}

// Called each time a character is typed
// Sets a timer or resets the time such that the function processTyping
// ends up being called after a 3s gap in calls to this.
Action.umpleTypingActivity = function(target) {
  console.log("Inside Action.umpleTypingActivity()...")
  if (Action.manualSync && Action.diagramInSync)
  {
    if (jQuery("#umpleCanvasColumn").is(":visible")) Page.enablePaletteItem("buttonSyncDiagram", true);
    Action.diagramInSync = false;
    Page.enableDiagram(false);
  }
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  if(target == "diagramEdit") Action.oldTimeout = setTimeout('Action.processTyping("' + target + '",' + false + ')', 500);
  else Action.oldTimeout = setTimeout('Action.processTyping("' + target + '",' + false + ')', Action.waiting_time);
}

var checkComplexityCooldown = 300000;
var checkComplexityLastUsage = 0;
var checkComplexityFeedbackMessage = 'Suggestion: Since there are so many classes, <a href="javascript:Page.clickShowGvClassDiagram()">switch to automated layout</a> (G).';
var checkComplexityDisplayTime = 120000;
Action.checkComplexity = function()
{
	if((Date.now() - checkComplexityCooldown) < checkComplexityLastUsage)
	{
		return;
	}
	var editorText = jQuery("#umpleModelEditorText").val();
	var matches = editorText.match(/class( |\n)((.|\n)*?){/g);
	if(matches == null)
	{
		return;
	}
	var numMatches = matches.length;
	if(numMatches > 10)
	{
		Page.setFeedbackMessage(checkComplexityFeedbackMessage);
		checkComplexityLastUsage = Date.now();
		setTimeout(Action.removeCheckComplexityWarning, checkComplexityDisplayTime);
	}
}

//since there is a cooldown on when checkComplexity is called
//removeCheckComplexityWarning will only be called after the 5 minute cooldown has passed.
Action.removeCheckComplexityWarning = function()
{
	if(Page.getFeedbackMessage() == checkComplexityFeedbackMessage)
	{
		Page.setFeedbackMessage("");
	}
}

// Called after a 3s delay as controlled by umpleTypingActivity when
// text has been edited in any of the editors (indicated by target)
// Target can be diagramEdit (when diagram changed), newEditor for CM6, codeMirrorEditor (will be obsolete)
Action.processTyping = function(target, manuallySynchronized)
{
  // DEBUG
  console.log("Inside Action.processTyping ...", target)
  document.getElementById("umpleModelEditorText").value = Page.codeMirrorEditor6.state.doc.toString();

  // Save in history after a pause in typing
  if (target != "diagramEdit") 
  {
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
  }
  else{
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  // Cause changed in text to be made to the diagram
  if (!Action.manualSync || manuallySynchronized)
  {
    Action.diagramInSync = true;
    if (target == "umpleModelEditorText" || target == "codeMirrorEditor" || target == "newEditor") {
      Action.updateLayoutEditorAndDiagram(target); 
      // issue#1554
      var downloadLink = document.getElementById("downloadLink");
      if (downloadLink !== null){
        downloadLink.remove();
      }
      
      Page.enablePaletteItem("buttonSyncDiagram", false);
    }
    else if(target == "diagramEdit")
    {
      Action.ajax(Action.updateFromDiagramCallback,Action.getLanguage());
    }
    //Page.enableDiagram(true);
  }

  if (target != "diagramEdit"){
    if (!justUpdatetoSaveLater){
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "processTyping");
    }
    else if (target == "umpleModelEditorText" || target == "codeMirrorEditor"){
      Action.setjustUpdatetoSaveLater(false);
    }
    Page.setExampleMessage("");
    
  }
	setTimeout(Action.checkComplexity,10000);
}

// Refactoring definitive text location
// This function stores just the core umple code, NOT the layout
Action.updateCurrentUmpleTextBeingEdited = function(codeToSave){
  // console.log("Inside Action.updateCurrentUmpleTextBeingEdited() ...")
  // Back up the data in the main editor
  Page.currentUmpleTextBeingEdited = codeToSave;
  
  // Backup save for CM5 CodeMirror 5 to be deleted 
  jQuery("#umpleModelEditorText").val(codeToSave);
  
  // Update the content in CM6 CodeMirror 6
  // Page.blahblah("stuff");
  Page.setCodeMirror6Text(codeToSave);
};

Action.updateLayoutEditorAndDiagram = function(target)
{
  // console.log(target + ": Inside updateLayoutEditorAndDiagram")
  Action.ajax(Action.updateUmpleLayoutEditor,"language=Json",target);
}

Action.updateUmpleLayoutEditor = function(response)
{
  // DEBUG
  // console.log("Inside Action.updateUmpleLayoutEditor()...")
  //Extract data from response
  var codeparts = response.responseText.split('URL_SPLIT');
  var errorMessage=codeparts[0];
  var umpleJson=codeparts[1];//Remove the URL_SPLIT in umpleJson

  //If anything failed, set umpleJson to response.responseText
  if(umpleJson == null || umpleJson == undefined)
  {
	  umpleJson = response.responseText;
  }
  
  Page.showLayoutLoading();
  //TODO: for some reason in the live version this call isnt being made
  //but oddly the diagram is updated, and that is done in the callback
      
  Action.ajax(Action.updateUmpleLayoutEditorCallback,format("action=addPositioning&actionCode={0}",umpleJson));  
}

Action.updateUmpleLayoutEditorCallback = function(response)
{
  // DEBUG
  // console.log("Inside updateUmpleLayoutEditorCallback")
  var umpleCode = response.responseText;
  // console.log("Extracting Positioning from Response")
  var positioning = Page.splitUmpleCode(umpleCode)[1];
  // console.log("Positioning: " + positioning)
  Page.setUmplePositioningCode(positioning);
  Page.hideLoading();
  Action.updateUmpleDiagramForce(true);
}

Action.updateUmpleDiagram = function() {
 return Action.updateUmpleDiagramForce(true)
}

Action.updateUmpleDiagramForce = function(forceUpdate)
{
  // DEBUG
  // console.log("Inside updateUmpleDiagramForce")
  var canonical = Action.trimMultipleNonPrintingAndComments(Page.getUmpleCode());
  if(!forceUpdate) {
    if(canonical == Action.savedCanonical)   
    {
      // The umple code is as we last sent to the diagram, except for comment
      // changes, spaces, tabs and newlines, so we return without doing anything
      return;
    }
  }
  Action.savedCanonical=canonical;
  Page.showCanvasLoading();
  
  Action.ajax(Action.updateUmpleDiagramCallback, Action.getLanguage());

}

//Action.displayAttributeMenu = function(event, attributeName, attributeType) {
  // For testing: Display an alert or log to the console
  //alert("Attribute clicked:\nName: " + attributeName + "\nType: " + attributeType);
  // Or use console.log if you prefer not to use an alert
  // console.log("Attribute clicked: Name - " + attributeName + ", Type - " + attributeType);
  
  // Prevent the default click behavior just in case
  //event.preventDefault();
//};

Action.updateUmpleDiagramCallback = function(response)
{
  // console.log("Debug E6.1: Inside updateUmpleDiagramCallback")
  var diagramCode = "";
  var errorMessage = "";

  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  Page.hideExecutionArea();

  // console.log("diagramCode: ", diagramCode)
  if(diagramCode == null || diagramCode == "" || diagramCode == "null") 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    // reset error message
    if(!Action.diagramInSync)
    {
      Action.diagramInSync = true;
    }

    Page.setFeedbackMessage("");
    Page.hideGeneratedCode();
    
    // Display editable class diagram
    if(Page.useEditableClassDiagram) {
      var newSystem = Json.toObject(diagramCode);
      UmpleSystem.merge(newSystem);
      UmpleSystem.update(); 
      
      //Apply readonly styles
      if (Page.readOnly) 
      {
        jQuery("span.editable").addClass("uneditable");
      }
    }
    else if(Page.useJointJSClassDiagram) {

      var model = JSON.parse(diagramCode.replace( new RegExp('} { "name": "', "gi"), '}, { "name": "' ));

      var umpleCanvas = jQuery("#umpleCanvas");

      var paper = JJSdiagram.initJJSDiagram(umpleCanvas, model);

      // zooming with the mouse wheel or finger swipe
      var MouseWheelHandler = function (event){
        var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));
        if (event.altKey === true) {
          var paperHeight = paper.options.height;
          var paperWidth = paper.options.width;
          // scaleFactor is either 1.1 or 0.9
          var scaleFactor = 1 + (Math.abs(delta) / (delta * 10));
          paper.setDimensions(paperWidth * scaleFactor, paperHeight * scaleFactor)

          //correct paper sizing
          if( JJSdiagram.paper ) 
          JJSdiagram.paper.setDimensions(jQuery("#umpleCanvas")[0].clientWidth, jQuery("#umpleCanvas")[0].clientHeight);

          //scale the content
          //commented it out because the customized object does not scale
          //paper.scaleContentToFit({padding: 15});
        }
      };
      // using the umpleCanvas as the mouse wheel event target, as it is a stable entity
      var paperHolder = document.getElementById("umpleCanvas");

      if (paperHolder.addEventListener) {
        // IE9, Chrome, Safari, Opera
        paperHolder.addEventListener("mousewheel", MouseWheelHandler, false);
        // Firefox
        paperHolder.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
      }
      // IE 6/7/8
      else {paperHolder.attachEvent("onmousewheel", MouseWheelHandler);}

      // Simulate a click on the canvas to draw focus and enable keyboard shortcuts.
      jQuery("#jjsPaper").click(function(){ Action.focusOn(Page.umpleCanvasId(), true);});

    }
    // Display static svg diagram
    else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram )
    {
      jQuery("#umpleCanvas").html(format('{0}', diagramCode));
      jQuery("#umpleCanvas").children().first().attr("id", "svgCanvas");
      Action.setupPinch();
    }
    //Display structure diagram
    else if(Page.useStructureDiagram)
    {
      jQuery("#umpleCanvas").html('<svg id="svgCanvas"></svg>');
      eval(diagramCode);
    }   
  }

  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }
  
  Page.hideLoading();
  if(Page.useGvClassDiagram){
    var elems=document.getElementsByClassName("node");
    // Add event listener to Graphviz Class nodes for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.displayMenu(event);
      });
      // Add event listener for double click, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.displayMenu(event); // Call the same function to display the menu
      });
      var attributeAnchors = elems[i].getElementsByTagName("a");
      // Start from 1 to skip the first <a> element which is for the class name
      for (let j = 1; j < attributeAnchors.length; j++) {
        let titleText = attributeAnchors[j].getAttribute("xlink:title");
        let [attributeType, attributeName] = titleText.split(' ');
        attributeAnchors[j].addEventListener("dblclick", function (event) {
          event.preventDefault();
          Action.displayAttributeMenu(event, attributeName, attributeType); // Calls the testing function
        });
        attributeAnchors[j].addEventListener("contextmenu", function (event) {
          event.preventDefault();
          event.stopPropagation();
          Action.displayAttributeMenu(event, attributeName, attributeType); // Calls the testing function
        });
      }
    }
      var associationElems = document.getElementsByClassName("edge");
    for (let i = 0; i < associationElems.length; i++) {
      var associationAnchors = associationElems[i].getElementsByTagName("a");
      for (let j = 0; j < associationAnchors.length; j++) {
        let associationLink = associationAnchors[j].getAttribute("xlink:href");
        associationAnchors[j].addEventListener("dblclick", function(event) {
            event.preventDefault(); // Prevent the default click behavior
            Action.displayAssociMenu(event,associationLink);
        });
        associationAnchors[j].addEventListener("contextmenu", function(event) {
          event.preventDefault(); // Prevent the default click behavior
          Action.displayAssociMenu(event,associationLink);
      });
    }
  }
}
  

  if(Page.useGvStateDiagram){
    //add double click to display menu, issue#2081
    var elems=document.getElementsByClassName("node");
    // Add event listener to Graphviz state nodes for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    elems=document.getElementsByClassName("cluster");
    // Add event listener to Graphviz clusters for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click on clusters, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    var transitionElems = document.getElementsByClassName("edge");

    for (let i = 0; i < transitionElems.length; i++) {
      transitionElems[i].addEventListener("dblclick", function(event) {
        event.preventDefault(); // Prevent the default click behavior
        Action.displayTransitionMenu(event);
    });
    transitionElems[i].addEventListener("contextmenu", function(event) {
        event.preventDefault();
        Action.displayTransitionMenu(event);
    });
    }
  }  
}

Action.updateFromDiagramCallback = function(response)
{
  var diagramCode = "";
  var errorMessage = "";
  
  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  
  if((diagramCode == null || diagramCode == "" || diagramCode == "null") && Action.diagramInSync) 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    Action.diagramInSync = true;
  }
  
  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }  
}

// Gets the code to display from the AJAX response
Action.getDiagramCode = function(responseText)
{
  var output = "";
  
  // Also want to use the same response for JointJS
  if(Page.useEditableClassDiagram || Page.useJointJSClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[1];
    
    if(output == "null") output = "";
    
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram)
  {
    // The graphviz diagrams are taken from the inner svg tag only. 
    // This allows the website to have a dynamic canvas size around the diagram
    var codeparts = responseText.split('<svg width=');
    
    //Put the start of the svg back together. 
    if(codeparts.length>1 && codeparts[1].length>100) {
      output = "<svg width="+codeparts[1];
      //remove the redundant svg closing tag
      output = output.replace(/<\/svg>$/, "");
    }
  }
  else if(Page.useStructureDiagram)
  {
    output = responseText.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "svgCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  
  return output;
}

// Gets any error code from the AJAX response
Action.getErrorCode = function(responseText)
{
  var output = "";
  if(Page.useEditableClassDiagram || Page.useStructureDiagram)
  {
    output = responseText.split('URL_SPLIT')[0];
    
    if(output == "<p>") output = "";
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram)
  {
    var miscStuffAndErrorMessages = responseText.split('<svg width=')[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      output = miscStuffAndErrorMessages.split("</script>&nbsp;")[0];
    }
  }

  return output;
}

// This function is no longer being called as its caller has been commented out
Action.classResizing = function(event, ui)
{
  var classId = event.target.id;
  var umpleClass = UmpleSystem.find(classId);
  var classSel = "#" + classId;
  
  var newWidth = Math.round(jQuery(classSel).width());
  var newHeight = Math.round(jQuery(classSel).height());
  
  UmpleSystem.updatingSize(umpleClass,newWidth,newHeight);
}

Action.associationSnap = function(x, y, dragDivSel) 
{
  var id = jQuery(dragDivSel).prop("id");
  var elementId = id.substr(0,id.lastIndexOf("_"));
  var index = id.substr(id.lastIndexOf("_") + "anchor".length + 1);
  var association = UmpleSystem.findAssociation(elementId);
  var umpleClass = association.getClass(index);
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.associationSnapClassReady = function(x,y,umpleClass)
{
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.updateMovedAssociation = function(dragDivSel, association)
{
  jQuery(dragDivSel).show();
  var dragOffset = jQuery(dragDivSel).offset();
  var dragDivId = jQuery(dragDivSel).prop("id");
  jQuery(dragDivSel).hide();
  
  var left = Math.round(dragOffset.left);
  var top = Math.round(dragOffset.top);
  
  var xys = Action.associationSnap(left,top,dragDivSel);
  var screenPosition = (new UmplePosition(xys[0],xys[1],0,0));  
  
  if (dragDivId.endsWith("_anchor0"))
  {
    association.setOffsetOnePosition(screenPosition);
  }
  else
  {
    association.setOffsetTwoPosition(screenPosition);
  }
  
  UmpleSystem.redrawAssociation(association);
  Action.associationSelected(null);
}

Action.validateAttributeName = function(newAttribute)
{
  return newAttribute.length!=0  && (
     newAttribute.match(/^[_a-zA-Z0-9]+$/) ||
     newAttribute.match(/^[_a-zA-Z0-9]+[\u0020]*:[\u0020]*[_a-zA-Z0-9]+(\[\])?$/)
     );
}

Action.validateMethodName = function(newMethod)
{
  return newMethod.length!=0 &&
     newMethod.match(/^[-+#]?\s*[_a-zA-Z0-9]+\s*\(([_a-zA-Z0-9]+(\[\])?(,\s*[_a-zA-Z0-9]+(\[\])?)*)?\)(\s*:\s*[_a-zA-Z0-9]+(\[\])?)?$/);
}

Action.toggleAttributes = function()
{
  Page.showAttributes = !Page.showAttributes;
  Action.redrawDiagram();
}
  
Action.toggleMethods = function()
{
  Page.showMethods = !Page.showMethods;
  Action.redrawDiagram();
}

Action.toggleActions = function()
{
  Page.showActions = !Page.showActions;
  Action.redrawDiagram();
}

Action.toggleTransitionLabels = function()
{
  Page.showTransitionLabels = !Page.showTransitionLabels;
  Action.redrawDiagram();
}

Action.toggleGuards = function()
{
  Page.showGuards = !Page.showGuards;
  Action.redrawDiagram();
}
Action.toggleGuardLabels = function()
{
  Page.showGuardLabels = !Page.showGuardLabels;
  Action.redrawDiagram();
}
Action.allowPinch = function()
{
  Page.allowPinch = !Page.allowPinch;
  Action.redrawDiagram();
}
Action.toggleFeatureDependency = function()
{
  Page.showFeatureDependency = !Page.showFeatureDependency;
  Action.redrawDiagram();
}
Action.toggleTraits = function()
{
  Page.showTraits = !Page.showTraits;
  Action.redrawDiagram();
}


Action.redrawDiagram = function()
{
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      //Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddTransition', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddTransition');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
}

InlineEditor.elementChanged = function(obj, oldVal, newVal)
{
  var editType = obj.attr("name");
  var objId = obj.attr("id");

  if (editType == "className")
  {
    var id = objId.substr(0,objId.length - "_name".length);
    DiagramEdit.classNameChanged(id,oldVal,newVal);
  }
  else if (editType == "attributeEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_attribute_".length - index.length);
    DiagramEdit.attributeNameChanged(id,index,oldVal,newVal);
  }
  else if(editType == "methodEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_method_".length - index.length);
    DiagramEdit.methodChanged(id,index,oldVal,newVal);
  }
  else if (editType == "attributeNew")
  {
    var id = objId.substr(0,objId.length - "_newAttribute".length);
    DiagramEdit.attributeNew(id,newVal);
  }
  else if(editType == "methodNew")
  {
    var id = objId.substr(0,objId.length - "_newMethod".length);
    DiagramEdit.methodNew(id,newVal);
  }
}

Action.enableManualSync = function(enable)
{
  var checkbox = jQuery("#buttonManualSync");
  var syncDiagram = jQuery("#buttonSyncDiagram");
  if (enable == undefined) enable = checkbox.is(":checked");
  
  if (enable)
  {
  Action.manualSync = true;
  }
  else
  {
    Action.manualSync = false;
    Action.processTyping("umpleModelEditorText",true);
    Page.enablePaletteItem("buttonSyncDiagram", false);
  }
}

Action.generateStructureDiagramFile = function()
{
  var filename = Page.getFilename().slice(0, -9) + "structureDiagram.svg";

  var svgContents =  jQuery("#innerGeneratedCodeRow").html().slice(4, -1);

  svgContents = format('<svg xmlns="http://www.w3.org/2000/svg" {0}>', svgContents);

  jQuery("#buttonStructureLink").showLoading();

  Ajax.sendRequest("scripts/compiler.php", Action.generateStructureDiagramFileCallback, 
    format("save=1&filename={0}&svgContent={1}", filename, svgContents));
}

Action.generateStructureDiagramFileCallback = function(response)
{
  jQuery("#buttonStructureLink").hideLoading();
  Page.toggleStructureDiagramLink(true, response.responseText);
}

Action.ajax = function(callback,post,target,errors,tabIndependent)
{
  // console.log("Debug E2 : Action.ajax() with target: ", target)
  // console.log("callback : ", callback)
  // CM5 -  Page.getUmpleCode()
  // CM6 - cm6.getCodeMirror6UmpleText()
  var modelAndPositioning = null;
  modelAndPositioning = Page.getUmpleCode();
  // if-else or conditional based on target will not work here,
  // because after first AJAX call, the `target` variable is undefined
  // if(target == "newEditor"){
  //   modelAndPositioning = cm6.getCodeMirror6UmpleText();
  // }
  // else {
  //   modelAndPositioning = Page.getUmpleCode();
  // }
  // console.log("Debug E3: ", target)
  // console.log(": \nmodelAndPositioning", modelAndPositioning)
  var umpleCode = encodeURIComponent(modelAndPositioning);
  var filename = Page.getFilename();
  // var errors = typeof(errors) != 'undefined' ? errors : "false";
  var errors = "true";
  TabControl.useActiveTabTo(TabControl.saveTab)(umpleCode);

  var tabContextOld = TabControl.getActiveTabId();
  var wrappedCallback = !tabIndependent? function(response){
    var tabContextNew = TabControl.getActiveTabId();
    if (tabContextNew !== tabContextOld){
      Page.hideLoading();
      return;
    }
    callback(response);
  } : callback;
  Ajax.sendRequest("scripts/compiler.php",wrappedCallback,format("{0}&error={3}&umpleCode={1}&filename={2}",post,umpleCode,filename,errors));
}

//Mac Keyboard Shortcut
if (navigator.appVersion.indexOf("Mac")!=-1)
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[cmd+z]');
    jQuery('#redosmall').html('[cmd+shift+z]');
  });
  Mousetrap.bind(['command+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['command+shift+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}
else //Non Mac
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[ctrl+z]');
    jQuery('#redosmall').html('[ctrl+y]');
  });
  Mousetrap.bind(['ctrl+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['ctrl+y'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}

//Arrow Up
Mousetrap.bind(['up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-5,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Down
Mousetrap.bind(['down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,5,0,0));
    return false; //equivalent to e.preventDefault();
  } 
});
Mousetrap.bind(['shift+down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Left
Mousetrap.bind(['left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Right
Mousetrap.bind(['right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Functions for changing diagram view - change consistently in umple_page.js
Mousetrap.bind(['ctrl+e'], function(e){
  Page.clickShowEditableClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+j'], function(e){
  Page.clickShowJointJSClassDiagram();
  return false; //equivalent to e.preventDefault();
});


Mousetrap.bind(['ctrl+g'], function(e){
  Page.clickShowGvClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+s'], function(e){
  Page.clickShowGvStateDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+l'], function(e){
  Page.clickShowStructureDiagram();
  return false; //equivalent to e.preventDefault();
});

//Functions for showing and hiding parts of the view
Mousetrap.bind(['ctrl+t', 'ctrl+alt+shift+t'], function(e){
  Page.clickShowHideText();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+d'], function(e){
  Page.clickShowHideCanvas();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+n', 'ctrl+alt+n'], function(e){
  Page.clickShowHideMenu();
  return false; //equivalent to e.preventDefault();
});

// Functions for changing what is shown on the diagram
Mousetrap.bind(['shift+ctrl+a'], function(e){
  Page.clickToggleAttributes();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+m'], function(e){
  Page.clickToggleMethods();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+r'], function(e){
  Page.clickToggleTraits();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+i'], function(e){
  Page.clickToggleTransitionLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+k'], function(e){
  Page.clickToggleGuardLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+b'], function(e){
  Action.promptAndExecuteTest();
  return false;
});

Mousetrap.bind(['ctrl+o'], function(e){
  Action.copyCommandLineCode();
  return false;
});

// Functions for editing the diagram - using shift
Mousetrap.bind(['g'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {      
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery('#buttonAddGeneralization').click();
    }        
  }  
});

Mousetrap.bind(['a'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery('#buttonAddAssociation').click();
    }
  }
});

Mousetrap.bind(['c'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {        
      jQuery('#buttonAddClass').click();
    }        
  }
});

Action.toggleTabsCheckbox = function(language)
{
  // Workaround for TextUml having java prefix
  if($("inputGenerateCode").value.split(":")[1] == "TextUml"){
    language = "TextUml";
  }

  if(language == "java" || language == "php" || language == "cpp" ||
    language == "python" || language == "ruby" || language == "sql") {
    jQuery("#ttTabsCheckbox").show();
    jQuery("#tabRow").show();

    if ($("inputGenerateCode").value.split(":")[1] == "USE" || $("inputGenerateCode").value.split(":")[1] == "UmpleSelf" || $("inputGenerateCode").value.split(":")[1] == "Json") {
      jQuery("#ttTabsCheckbox").hide();
      jQuery("#tabRow").hide();
    }
  }
  else {
    jQuery("#ttTabsCheckbox").hide();
    jQuery("#tabRow").hide();
    if(jQuery('#buttonTabsCheckbox').is(':checked')){
      jQuery('#buttonTabsCheckbox').click();
    }
  }
}

// Function for splitting code into tabs for every new file, activated when checking the Show Tabs checkbox
Action.toggleTabs = function()
{
  // Checking on the checkbox
  if(jQuery('#buttonTabsCheckbox').is(':checked')){

    // Show row with buttons for each filename
    jQuery('#tabRow').show();

    // Hide main code window with glommed files
    jQuery('#innerGeneratedCodeRow').hide();

    // Show first file codeblock
    jQuery('#tabButton1').click();

  }
  // Checking off the checkbox
  else{

    // Hide row with buttons
    jQuery('#tabRow').hide();

    // Show main code window with glommed files
    jQuery('#innerGeneratedCodeRow').show();

    // Hide all file codeblocks
    jQuery('#innerGeneratedCodeRow').nextAll().hide();

  }
}

Action.generateTabsCode = function(theCode)
{
  var arrCodeFiles = [];
  var intFileCounter = 0;
  var strFileContents = "";
  var arrFileNames = [];
  var strNewLine = "";
  var skipSpace = false;

  // Read full code output line by line
  theCode.split('URL_SPLIT')[1].split("\n").forEach(function(theLine){

    // If New File Beginning
    if( (theLine.indexOf("//%%") >= 0) || (theLine.indexOf("# %%") >= 0)){
      intFileCounter++;
      strFileName = theLine.slice(14);
      strFileName = strFileName.substr(0, strFileName.indexOf(' '));
      arrFileNames[intFileCounter] = strFileName;
      jQuery('#generatedCodeRow').append("<div id='innerGeneratedCodeRow" + intFileCounter + "'></div>");
      arrCodeFiles[intFileCounter] = "";
      skipSpace = true;
    }
    else{
      if(!skipSpace){
         arrCodeFiles[intFileCounter] += theLine + "\n";
      }
      else{
        skipSpace = false;
      }
    }
  });

  // Output buttons for number of files found
  for (i=1; i <= intFileCounter; i++){
    jQuery('#tabRow').append("<button type='button' id='tabButton" + i + "'>" + arrFileNames[i] + "</button>");
    jQuery('#tabButton' + i).click({code: arrCodeFiles[i], tabnumber: i}, showTab);
  }
}

Action.getLanguage = function() 
{
  var language = "";
  if(Page.useEditableClassDiagram) {language="language=Json";}
    // JointJS receives the full model (class and state machine) in JSON
  else if(Page.useJointJSClassDiagram) {language="language=JsonMixed";}
  else if(Page.useGvClassDiagram) {
    if(Page.showTraits) {
      language="language=traitDiagram";
    }
    else {
      language="language=classDiagram";
    }
  }
  else if(Page.useGvStateDiagram) {language="language=stateDiagram"}
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
 

  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
    if(Page.showTransitionLabels) language=language+".showtransitionlabels";
    if(!Page.showGuards) language=language+".hideguards";    
    if(Page.showGuardLabels) language=language+".showguardlabels";
    language=language+"."+$("inputGenerateCode").value.split(":")[1];
  }
  // append any suboptions needed for GvClassDiagram
  if(Page.useGvClassDiagram) { 
    if(Page.showMethods) language=language+".showmethods";
    if(!Page.showAttributes) language=language+".hideattributes";
  }
  // append any suboptions needed for GvFeatureDiagram
  if(Page.useGvFeatureDiagram) {
    language="language=featureDiagram";
    if(Page.showFeatureDependency) language=language+".showFeatureDependency";
  }
  return language;
}

function showTab(event)
{
  // Hide all file codeblocks
  jQuery('#innerGeneratedCodeRow').nextAll().hide();

  // Show only relevant file codeblock
  jQuery('#innerGeneratedCodeRow' + event.data.tabnumber).show();

  // Highlight code for specific file only
  Page.showGeneratedCode(event.data.code, $("inputGenerateCode").value.split(":")[0], event.data.tabnumber);

  // Hide main code window with glommed files
  jQuery('#innerGeneratedCodeRow').hide();
}

Action.hidegdpr = function() 
{
  jQuery('#gdprtext').hide();
  Action.gdprHidden = true;
}

Action.reindent = function(lines, cursorPos)
{
  var offset = "";
  var codeAfterIndent = "";
  var len = lines.length;
  var inBlockComment = false;
  var statementEnd = true; // i.e. have semicolon at the end of the statement.
  var statementEndIndentSpace = 0;
  var indexOfCursor = -1;
  for (var i = 0; i < len; i++) 
  {
    var trimmedLine = lines[i].trim();

    // remove quotation
    var indexOfFirstQuote  = trimmedLine.indexOf("\"");
    var indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    while (indexOfFirstQuote != -1 && indexOfLastQuote != -1)
    {
      trimmedLine = trimmedLine.slice(0, indexOfFirstQuote) + trimmedLine.slice(indexOfLastQuote+1, trimmedLine.length);
      indexOfFirstQuote  = trimmedLine.indexOf("\"");
      indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    }

    // remove comment
    if (trimmedLine.indexOf("//") != -1)
    {
      trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("//")).trim();
    }

    if (inBlockComment)
    {
      if (trimmedLine.indexOf("*/") != -1)
      {
        trimmedLine = trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim();
        inBlockComment = false;
      }
      else {
        if (i != lines.length -1)
        {
          codeAfterIndent += lines[i] + "\n";
        } else {
          codeAfterIndent += lines[i];
        }
        continue;
      }
    }
    else if (trimmedLine.indexOf("/*") != -1)
    {
      if (trimmedLine.indexOf("*/") == -1)
      {
        inBlockComment = true;
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")).trim();
      }
      else
      {
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")) + trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim(); // remove block comment for trimmed line
      }
      
    }
    
    var indexOfOpenCurlyBrace = trimmedLine.indexOf("{");
    var indexOfCloseCurlyBrace = trimmedLine.indexOf("}");
    var indexOfSemiColon = trimmedLine.indexOf(";");
    
    if (indexOfSemiColon != -1 && indexOfSemiColon != trimmedLine.length - 1 && trimmedLine.substr(indexOfSemiColon+1).trim().charAt(0) != "}")
    {
      lines.splice(i + 1, 0, trimmedLine.substr(indexOfSemiColon + 1));
      if (i <= cursorPos.line)
      {
        cursorPos.line++;
      }
      lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfSemiColon + 1);
      Action.reindent(lines, cursorPos);
      return;
    }

    var doNotIndent = indexOfOpenCurlyBrace != -1 && indexOfCloseCurlyBrace != -1 && indexOfCloseCurlyBrace - indexOfOpenCurlyBrace < 40 && trimmedLine.substr(0, indexOfCloseCurlyBrace).indexOf("{", indexOfOpenCurlyBrace + 1) == -1;
    if (doNotIndent)
    {
      if (indexOfCloseCurlyBrace != trimmedLine.length - 1)
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace + 1);
        Action.reindent(lines, cursorPos);
        return;
      }
      
      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{")
        {
          statementEnd = true;
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }
    }
    else 
    {
      if (indexOfOpenCurlyBrace != -1 && indexOfOpenCurlyBrace != trimmedLine.length - 1) // put code after an open curly bracket to next line
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfOpenCurlyBrace + 1));
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfOpenCurlyBrace + 1);
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        Action.reindent(lines, cursorPos);
        return;
      }

      if (indexOfCloseCurlyBrace != -1 && trimmedLine.length > 1)
      {
        if (indexOfCloseCurlyBrace == 0)
        {
          lines.splice(i + 1, 0, trimmedLine.substr(1));
          lines[i] = "}";
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
        } else {
          lines.splice(i + 1, 0, "}");
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
          if (indexOfCloseCurlyBrace != trimmedLine.length - 1) // there is code after close curly bracket
          {
            lines.splice(i + 2, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
            if (i <= cursorPos.line)
            {
              cursorPos.line++;
            }
          }
          lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace);
        }
        Action.reindent(lines, cursorPos);
        return;
      }


      if (statementEnd && trimmedLine.indexOf(";") != trimmedLine.length - 1 && trimmedLine.slice(-1) != "{" && trimmedLine.slice(-1) != "}" && trimmedLine.slice(-2) != "||")
      {
        statementEnd = false;
        statementEndIndentSpace = lines[i].match(/^\s*/)[0].length;
      }

      if (indexOfCloseCurlyBrace != -1)
      {
        offset = offset.substr(2);
      }

      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{" || trimmedLine.slice(-2) == "||" && trimmedLine.slice(-1) == "}")
        {
          statementEnd = true;
          lines[i] = offset + lines[i].trim();
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }

      if (indexOfOpenCurlyBrace != -1)
      {
        offset += "  ";
      }
    }

    if (i != lines.length -1)
    {
      codeAfterIndent += lines[i] + "\n";
    } else {
      codeAfterIndent += lines[i];
    }
  }
  
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor.setValue(codeAfterIndent);
  }
  
  // Refactoring definitive text location
  Action.updateCurrentUmpleTextBeingEdited(codeAfterIndent);

  var cursorLine = Page.getRawUmpleCode().split("\n")[cursorPos.line];
  var whiteSpace = cursorLine.match(/^\s*/)[0].length;
  if (cursorPos.ch >= cursorLine.trim().length) 
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, cursorLine.trim().length + whiteSpace);
  }
  else if (cursorPos.ch >= 0)
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, cursorPos.ch+whiteSpace);
  }
  else
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, 0);
  }
  Page.codeMirrorEditor.focus();
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions triggered by graphically editing the diagram in UmpleOnline

DiagramEdit = new Object();
DiagramEdit.textChangeQueue = [];
DiagramEdit.pendingChanges = false;
DiagramEdit.newClass = null;
DiagramEdit.newAssociation = null;
DiagramEdit.newTransition = null;
DiagramEdit.newGeneralization = null;

//Queues and initiates updates to the text editor after the diagram is edited
DiagramEdit.updateUmpleText = function(update)
{
  if(DiagramEdit.textChangeQueue.length == 0 && !DiagramEdit.pendingChanges)
  {
    DiagramEdit.pendingChanges = true;
    DiagramEdit.textChangeQueue.push(update);
    DiagramEdit.doTextUpdate();
  }
  else
  {
    DiagramEdit.textChangeQueue.push(update);
  }
  
  Action.umpleTypingActivity("diagramEdit");
  // Action.umpleTypingActivity("newDiagramEdit");
}

DiagramEdit.doTextUpdate = function()
{
  update = DiagramEdit.textChangeQueue.shift();
  Action.update = update;

  if(update.codeChange) {
    Page.hideGeneratedCode();
  }

  Action.ajax(Action.updateUmpleTextCallback,update.actionCode);
}

///////////////////////////////////////////////////////
// Main functions for changing the diagram graphically
///////////////////////////////////////////////////////

DiagramEdit.addClass = function(position)
{
  Action.setjustUpdatetoSaveLater(false);
  DiagramEdit.removeNewClass();
  var umpleClass = UmpleSystem.createClass(position);
  var umpleJson = Json.toString(umpleClass);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({ 
    actionCode: format("action=addClass&actionCode={0}",umpleJson),
    codeChange: true
  });
}

// Create an association based on the temporary association
// line drawn in the diagram using "add association" drawing tool
DiagramEdit.addAssociation = function(line)
{
  Action.setjustUpdatetoSaveLater(false);
  // the line shown when selecting participating classes
  // is a dummy - erase it and create association 
  DiagramEdit.removeNewAssociation();
  var umpleAssociation = UmpleSystem.createAssociation( line.classOneId,
                              line.classTwoId,
                              line.classOnePosition.add(UmpleSystem.position()),
                              line.classTwoPosition.add(UmpleSystem.position()));

  // obtain the json representation of the association
  var umpleJson = Json.toString(umpleAssociation);
  
  // unselect all drawing tools in the palette and show loading images
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=addAssociation&actionCode={0}",umpleJson),
    codeChange: true
  });
}

DiagramEdit.addTransition = function(line)
{
  Action.setjustUpdatetoSaveLater(false);
    // the line shown when selecting participating states
  // is a dummy - erase it and create transition
  DiagramEdit.removeNewTransition();
  var umpleTransition = UmpleSystem.createTransition(line.fromStateId, line.toStateId);

  // obtain the json representation of the Transition
  var umpleJson = Json.toString(umpleTransition);
  
  // unselect all drawing tools in the palette and show loading images
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=addTransition&actionCode={0}",umpleJson),
    codeChange: true
  });
}

DiagramEdit.addGeneralization = function(umpleGeneralization)
{
  Action.setjustUpdatetoSaveLater(false);
  DiagramEdit.removeNewGeneralization();
  UmpleSystem.createGeneralization(umpleGeneralization.childId, umpleGeneralization.parentId);
  var umpleJson = Json.toString(umpleGeneralization);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=addGeneralization&actionCode={0}",umpleJson),
    codeChange: true
  });
}

/* Creating an association (via diagram) is divided into two parts:
 * The first is selecting the first class, and
 * then anchoring the first end of the association line.  
 * The second is doing the same for the second chosen class, and then launching
 * necessary actions to add the association to the Umple System
 */
DiagramEdit.createAssociationPartOne = function(event)
{

    // get the position of the click and compute the first end's position
  var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
  var umpleSystem = UmpleSystem.position();
  var classOneX = mousePosition.x - umpleSystem.x;
  var classOneY = mousePosition.y - umpleSystem.y;
  
  // draw a dummy association line and anchor it to the location of the click
  Action.classSelected(event.currentTarget);
  DiagramEdit.newAssociation = new UmpleAssociation();
  DiagramEdit.newAssociation.classOneId = event.currentTarget.id;
  DiagramEdit.newAssociation.classOnePosition = new UmplePosition(classOneX,classOneY,0,0); 
}

DiagramEdit.createAssociationPartTwo = function(event)
{
  var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
  Action.classSelected(event.currentTarget);

  if(DiagramEdit.newAssociation.classOneId <= event.currentTarget.id)
  {
    //The inline association definition belongs in the first class clicked
    DiagramEdit.newAssociation.classTwoId = event.currentTarget.id;
    DiagramEdit.newAssociation.classTwoPosition = mousePosition.subtract(UmpleSystem.position());
  }
  else
  {
    //The inline association definition belongs in the second class clicked
    DiagramEdit.newAssociation.classTwoId = DiagramEdit.newAssociation.classOneId;
    DiagramEdit.newAssociation.classTwoPosition = DiagramEdit.newAssociation.classOnePosition;
    DiagramEdit.newAssociation.classOneId = event.currentTarget.id;
    DiagramEdit.newAssociation.classOnePosition = mousePosition.subtract(UmpleSystem.position());
  }
  
  DiagramEdit.addAssociation(DiagramEdit.newAssociation);
}


/* Creating a transition (via diagram) is divided into two parts:
 * The first is selecting the first state, and
 * then anchoring the first end of the transition line.
 * The second is doing the same for the second chosen state, and then launching
 * necessary actions to add the transition to the Umple System
 */
DiagramEdit.createTransitionPartOne = function(event)
{

    // get the position of the click and compute the first end's position
    var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
    var umpleSystem = UmpleSystem.position();
    var stateOneX = mousePosition.x - umpleSystem.x;
    var stateOneY = mousePosition.y - umpleSystem.y;

    // draw a dummy transition line and anchor it to the location of the click
    Action.classSelected(event.currentTarget);
    DiagramEdit.newTransition = new UmpleTransition();
    DiagramEdit.newTransition.fromStatePosition = event.currentTarget.id;
    DiagramEdit.newTransition.toStatePosition = new UmplePosition(stateOneX,stateOneY,0,0);
    DiagramEdit.newTransition.eventName = "event1";
}

DiagramEdit.createTransitionPartTwo = function(event)
{
    var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
    Action.classSelected(event.currentTarget);
    //The inline transition definition belongs in the first state clicked
    DiagramEdit.newTransition.toStateId = event.currentTarget.id;
    DiagramEdit.newTransition.toStatePosition = mousePosition.subtract(UmpleSystem.position());
    DiagramEdit.addTransition(DiagramEdit.newTransition);
}
DiagramEdit.createGeneralizationPartOne = function(event)
{
  var childClass = UmpleSystem.find(event.currentTarget.id);
  if (childClass.extendsClass != null) return false;
      
  Action.classSelected(event.currentTarget);
  DiagramEdit.newGeneralization = new UmpleGeneralization();
  DiagramEdit.newGeneralization.childId = event.currentTarget.id;
  
  umpleSystem = UmpleSystem.position();
  childPositionX = Dom.x(event) - umpleSystem.x;
  childPositionY = Dom.y(event) - umpleSystem.y;
  DiagramEdit.newGeneralization.childPosition = new UmplePosition(childPositionX,childPositionY,0,0);
}

DiagramEdit.createGeneralizationPartTwo = function(event)
{
  Action.classSelected(event.currentTarget);
    
  DiagramEdit.newGeneralization.parentId = event.currentTarget.id;
  DiagramEdit.newGeneralization.parentPosition = new UmplePosition(Dom.x(event),Dom.y(event),0,0);
  DiagramEdit.addGeneralization(DiagramEdit.newGeneralization);
}

DiagramEdit.classMoved = function(targetClass)
{
  Action.setjustUpdatetoSaveLater(false);
  var umpleClassMoved = UmpleSystem.find(targetClass.id);
  var classObj = jQuery("#" + umpleClassMoved.id);
 
  // assure the offsets are round numbers
  newPositionX = Math.floor(classObj.offset().left);
  newPositionY = Math.floor(classObj.offset().top);
  UmpleSystem.updatePosition(umpleClassMoved,newPositionX,newPositionY);
  
  var editClass = Json.toString(umpleClassMoved);
  var umpleCode = Page.getUmpleCode();
  
  // make call to the back end to update the umple code
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: false
  });
  Action.classSelected(targetClass);
  
  UmpleSystem.trimOverlappingAssociations(umpleClassMoved);
}

// This function is no longer being called as its caller has been commented out
DiagramEdit.classResized = function(event, ui)
{
  Action.setjustUpdatetoSaveLater(false);
  var classDiv = event.target;
  var id = classDiv.id;
  var umpleClass = UmpleSystem.find(id);
  
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass, addToQueue);
  
  // update the position (in umple code) of any association affected
  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      var isClassOne = umpleAssociation.classOneId == umpleClass.id;
      var offset = isClassOne ? umpleAssociation.offsetOnePosition : umpleAssociation.offsetTwoPosition;
    
      var anchorId = isClassOne ? "_anchor0" : "_anchor1";
      var dragDivSelector = "#" + umpleAssociation.id + anchorId;
      var addToQueue = true;
    
      DiagramEdit.associationMoved(dragDivSelector, addToQueue);
    }
  }
  
  var editClass = Json.toString(umpleClass);
  var umpleCode = Page.getUmpleCode();
  
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format('action=editClass&actionCode={0}',editClass),
    codeChange: false
  });
  Action.classSelected(classDiv);
}

DiagramEdit.associationMoved = function(dragDivSelector, addToQueue)
{
  Action.setjustUpdatetoSaveLater(false);
  if (DiagramEdit.newAssociation != null) DiagramEdit.removeNewAssociation();
  if (addToQueue == undefined) addToQueue = false;
  
  var dragDivId = jQuery(dragDivSelector).attr("id");
  var associationId = dragDivId.substr(0, dragDivId.length - "_anchorX".length);
  var association = UmpleSystem.findAssociation(associationId);
  
  Action.updateMovedAssociation(dragDivSelector, association);
    
  var editAssociation = Json.toString(association);

  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    codeChange: false,
    actionCode: format("action=editAssociation&actionCode={0}",editAssociation)
  });
}

DiagramEdit.regularAssociationMoving = function(dragSelector)
{
  if (DiagramEdit.newAssociation == null)
  {
    var dragId = jQuery(dragSelector).attr("id");
    var id = dragId.substr(0,dragId.length - "_anchorX".length);

    // get the association being moved and create a temporary one
    // to display movement
    var association = UmpleSystem.findAssociation(id);
    var dragAssociation = new UmpleAssociation();
    
    // identify which end is being moved and update its attributes
    if (dragId.endsWith("_anchor0"))
    {
      dragAssociation.classOneId = association.classTwoId;
      dragAssociation.classOnePosition = association.classTwoPosition;
      dragAssociation.offsetOnePosition = association.offsetTwoPosition;
    }
    else
    {
      dragAssociation.classOneId = association.classOneId;
      dragAssociation.classOnePosition = association.classOnePosition;
      dragAssociation.offsetOnePosition = association.offsetOnePosition;
    } 
    DiagramEdit.newAssociation = dragAssociation;
  }
  
  var dragOffset = jQuery(dragSelector).offset();
  var xys = Action.associationSnap(Math.round(dragOffset.left),Math.round(dragOffset.top),dragSelector);
  var screenPosition = new UmplePosition(xys[0],xys[1]);
  DiagramEdit.newAssociation.classTwoPosition = screenPosition.subtract(UmpleSystem.position());
  DiagramEdit.newAssociation.offsetTwoPosition = new UmplePosition(0,0,0,0);

  var canvasSelector = "#" + Page.umpleCanvasId();
  jQuery(canvasSelector).append(DiagramEdit.newAssociation.drawable());
}

DiagramEdit.reflexiveAssociationMoving = function(dragSelector)
{
  var dragId = jQuery(dragSelector).attr("id");
  var id = dragId.substr(0,dragId.length - "_anchorX".length);
  var association = UmpleSystem.findAssociation(id);

  if (DiagramEdit.newAssociation == null)
  {
    DiagramEdit.newAssociation = new UmpleAssociation();
    DiagramEdit.newAssociation.classOneId = association.classOneId;
    DiagramEdit.newAssociation.classTwoId = association.classTwoId;
    DiagramEdit.newAssociation.classOnePosition = association.classOnePosition;
    DiagramEdit.newAssociation.classTwoPosition = association.classTwoPosition;
    DiagramEdit.newAssociation.offsetOnePosition = association.offsetOnePosition;
    DiagramEdit.newAssociation.offsetTwoPosition = association.offsetTwoPosition;
    DiagramEdit.newAssociation.id = DiagramEdit.newAssociation.getElementId();
  }
  
  var dragOffset = jQuery(dragSelector).offset();
  var xys = Action.associationSnap(Math.round(dragOffset.left),Math.round(dragOffset.top),dragSelector);
  var screenPosition = (new UmplePosition(xys[0],xys[1],0,0));
  var offset = screenPosition.subtract(UmpleSystem.position());
  offset.x = offset.x - DiagramEdit.newAssociation.classOnePosition.x;
  offset.y = offset.y - DiagramEdit.newAssociation.classOnePosition.y;
  
  if (dragId.endsWith("_anchor0")) DiagramEdit.newAssociation.offsetOnePosition = offset;
  else DiagramEdit.newAssociation.offsetTwoPosition = offset;
  
  var canvasSelector = "#" + Page.umpleCanvasId();
  jQuery(canvasSelector).append(DiagramEdit.newAssociation.drawableReflexive());
}

DiagramEdit.classNameChanged = function(diagramId,oldName,newName)
{
  Action.setjustUpdatetoSaveLater(false);
  if(newName.length=0 || !newName.match(/^[_a-zA-Z0-9]+$/))
  {

    Action.updateUmpleDiagram();
    var message="Class names must be alphanumeric. &lt;"
      +(newName.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))
      +"&gt is not valid.";
    setTimeout(function() {Page.setFeedbackMessage(message);},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.renameClass(diagramId,oldName,newName);
    // Reset height and width to minimum - TRYING
    umpleClass.position.width = UmpleClassFactory.defaultSize.width;

    var editClass = Json.toString(umpleClass);
    delete umpleClass.oldname;
  
    Page.showModelLoading();
    Page.showLayoutLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
  }
}

DiagramEdit.attributeNameChanged = function(diagramId,index,oldName,newAttribute)
{
  Action.setjustUpdatetoSaveLater(false);
  if(!Action.validateAttributeName(newAttribute))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("UML Attributes must be alphanumeric with an optional type after a colon. &lt;"
      +(newAttribute.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    umpleClass.attributes[index].set(newAttribute);
    UmpleSystem.redraw(umpleClass);
  
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetAttribute(index);
  }
}

DiagramEdit.attributeNew = function(diagramId,attributeInput)
{
  Action.setjustUpdatetoSaveLater(false);
  if(!Action.validateAttributeName(attributeInput))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("UML Attributes must be alphanumeric with "
      + "an optional type after a colon. &lt;"
      + (attributeInput.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))
      + "&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else // new attribute is valid
  {
    var umpleClass = UmpleSystem.find(diagramId);
    var attributeIndex = umpleClass.addAttribute(attributeInput);

    
    
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetAttribute(attributeIndex);
    UmpleSystem.updateClass(umpleClass);
    UmpleSystem.redrawGeneralizationsTo(umpleClass);
    UmpleSystem.trimOverlappingAssociations(umpleClass);
    UmpleSystem.update();
  }
}

DiagramEdit.classDeleted = function(diagramId)
{
  Action.setjustUpdatetoSaveLater(false);
  var addToQueue = true;
  var umpleClass = UmpleSystem.find(diagramId);
  var associationsAffected = [];
  var generalizationsAffected = [];
  
  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      associationsAffected.push(umpleAssociation.id);  
    }
  }
  for (var i=0; i<UmpleSystem.umpleClasses.length; i++)
  {
    var currentClass = UmpleSystem.umpleClasses[i];
    if (currentClass.extendsClass == umpleClass.id)
    {
      generalizationsAffected.push(currentClass.id + "_generalization");
    }
  }
  
  for (var i=0; i<associationsAffected.length; i++)
  {
    DiagramEdit.associationDeleted(associationsAffected[i], addToQueue);
  }
  for (var i=0; i<generalizationsAffected.length; i++)
  {
    DiagramEdit.generalizationDeleted(generalizationsAffected[i], addToQueue);
  }
    
  var result = UmpleSystem.removeClass(diagramId);
  var removeClass = Json.toString(result);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeClass&actionCode={0}",removeClass),
    codeChange: true
  });
}

DiagramEdit.methodNew = function(diagramId, methodInput)
{
  Action.setjustUpdatetoSaveLater(false);
  if(!Action.validateMethodName(methodInput))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("Invalid UML Method. &lt;"+(methodInput.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    var methodIndex = umpleClass.addMethod(methodInput);
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    
    
    umpleClass.resetMethod(methodIndex);
    UmpleSystem.updateClass(umpleClass);
    UmpleSystem.redrawGeneralizationsTo(umpleClass);
    UmpleSystem.trimOverlappingAssociations(umpleClass); 
    UmpleSystem.update();
  }
}

DiagramEdit.methodChanged = function(diagramId,index,oldName,newMethod)
{
  Action.setjustUpdatetoSaveLater(false);
  if(!Action.validateMethodName(newMethod))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("Invalid UML Method. &lt;"+(newMethod.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    umpleClass.methods[index].set(newMethod);
    UmpleSystem.redraw(umpleClass);
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetMethod(index);
  }
}

DiagramEdit.methodDelete = function(diagramId,index)
{
  Action.setjustUpdatetoSaveLater(false);
  var umpleClass = UmpleSystem.find(diagramId);
  umpleClass.removeMethod(index);
  // Reset height and width to sensible values
  var classObj = jQuery("#" + umpleClass.id);
  //  umpleClass.position.height = Math.round(classObj.height());
  //  umpleClass.position.width = Math.round(classObj.width());

// This needs fixing so it picks up the correct width
// Look trimOverlap, which seems to know the correct width
  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

//  umpleClass.position.height = UmpleClassFactory.defaultSize.height;
//  umpleClass.position.width = UmpleClassFactory.defaultSize.width;
  

  var editClass = Json.toString(umpleClass);
  Page.showModelLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: true
  });

  umpleClass.resetMethod(index);
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);
  UmpleSystem.trimOverlappingAssociations(umpleClass);
  UmpleSystem.update();
}

DiagramEdit.attributeDelete = function(diagramId,index)
{
  Action.setjustUpdatetoSaveLater(false);
  var umpleClass = UmpleSystem.find(diagramId);
  umpleClass.removeAttribute(index);
  // Reset height and width to sensible values
  var classObj = jQuery("#" + umpleClass.id);
//  umpleClass.position.height = Math.round(classObj.height());
//  umpleClass.position.width = Math.round(classObj.width());
  
// This needs fixing so it picks up the correct width
// Look trimOverlap, which seems to know the correct width
  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

//  umpleClass.position.height = UmpleClassFactory.defaultSize.height;
//  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

  var editClass = Json.toString(umpleClass);
  Page.showModelLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: true
  });

  umpleClass.resetAttribute(index);
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);    
  UmpleSystem.trimOverlappingAssociations(umpleClass);
  UmpleSystem.update();
}

DiagramEdit.associationDeleted = function(diagramId, addToQueue)
{
  Action.setjustUpdatetoSaveLater(false);
  if (addToQueue == undefined) addToQueue = false;
  var removed = UmpleSystem.removeAssociation(diagramId);
  var json = Json.toString(removed);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeAssociation&actionCode={0}",json),
    codeChange: true
  });
}

DiagramEdit.transitionDeleted = function(diagramId, addToQueue)
{
  Action.setjustUpdatetoSaveLater(false);
  if (addToQueue == undefined) addToQueue = false;
  var removed = UmpleSystem.removeTransition(diagramId);
  var json = Json.toString(removed);

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();

  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
      actionCode: format("action=removeTransition&actionCode={0}",json),
      codeChange: true
  });
}

DiagramEdit.generalizationDeleted = function(diagramId, addToQueue)
{
  Action.setjustUpdatetoSaveLater(false);
  if (addToQueue == undefined) addToQueue = false;
  var removed = UmpleSystem.removeGeneralization(diagramId)
  var json = Json.toString(removed);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeGeneralization&actionCode={0}",json),
    codeChange: true
  });
}

/////////////////////////////////////
//Helper and auxilliary functions
/////////////////////////////////////

DiagramEdit.removeNewClass = function()
{
  if (DiagramEdit.newClass != null)
  {
    var classSelector = "#" + DiagramEdit.newClass.id;
    DiagramEdit.newClass = null;
    jQuery(classSelector).remove();
    return true;
  }

  return false;
}

DiagramEdit.removeNewAssociation = function()
{
  if (DiagramEdit.newAssociation != null)
  {
    var lineSelector = "#"+DiagramEdit.newAssociation.getElementId();
    jQuery(lineSelector).remove();
    DiagramEdit.newAssociation = null;
    return true;
  }
  return false;
}

DiagramEdit.removeNewTransition = function()
{
    if (DiagramEdit.newTransition != null)
  {
    var lineSelector = "#"+DiagramEdit.newTransition.getElementId();
    jQuery(lineSelector).remove();
    DiagramEdit.newTransition = null;
    return true;
  }
  return false;
}

DiagramEdit.removeNewGeneralization = function()
{
  if (DiagramEdit.newGeneralization != null)
  {
    var lineSelector = "#" + DiagramEdit.newGeneralization.getElementId();
    jQuery(lineSelector).remove();
    DiagramEdit.newGeneralization = null;
    return true;
  }
  return false;
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models associations in the graphical view of UmpleOnline

UmpleAssociationFactory = new Object();

UmpleAssociationFactory.create = function(data)
{
  var umpleAssociation = new UmpleAssociation();
  umpleAssociation.id = data.id;
  umpleAssociation.classOneId = data.classOneId;
  umpleAssociation.classTwoId = data.classTwoId;
  umpleAssociation.offsetOnePosition = UmplePositionFactory.copy(data.offsetOnePosition);
  umpleAssociation.offsetTwoPosition = UmplePositionFactory.copy(data.offsetTwoPosition);
  umpleAssociation.multiplicityOne = data.multiplicityOne;
  umpleAssociation.multiplicityTwo = data.multiplicityTwo;
  umpleAssociation.name = data.name;
  umpleAssociation.roleOne = data.roleOne;
  umpleAssociation.roleTwo = data.roleTwo;
  umpleAssociation.isSymmetricReflexive = (data.isSymmetricReflexive == "true" || data.isSymmetricReflexive == true) ? true : false;
  umpleAssociation.isLeftNavigable = (data.isLeftNavigable == "true" || data.isLeftNavigable == true) ? true : false;
  umpleAssociation.isRightNavigable = (data.isRightNavigable == "true" || data.isRightNavigable == true) ? true : false;
  umpleAssociation.isLeftComposition = (data.isLeftComposition == "true" || data.isLeftComposition == true) ? true : false;
  umpleAssociation.isRightComposition = (data.isRightComposition == "true" || data.isRightComposition == true) ? true : false;
  umpleAssociation.color = data.isTraced;
  return umpleAssociation;
}

function UmpleAssociation()
{
  this.id;
  this.classOneId;
  this.classTwoId;
  this.classOnePosition = null;
  this.classTwoPosition = null;
  this.offsetOnePosition = null;
  this.offsetTwoPosition = null;
  this.multiplicityOne = "";
  this.multiplicityTwo = "";
  this.name = "";
  this.roleOne = "";
  this.roleTwo = "";
  this.isSymmetricReflexive = false;
  this.isLeftNavigable = true;
  this.isRightNavigable = true;
  this.isLeftComposition = false;
  this.isRightComposition = false;
  this.color = "black";
  
  this.setClasses = function(aClassOneId,aClassTwoId)
  {
    this.classOneId = aClassOneId;
    this.classTwoId = aClassTwoId;
  }
  
  this.setDefaultMultiplicities = function()
  {
    this.multiplicityOne = "*";
    this.multiplicityTwo = "*";
  }

  this.setDefaultRoles = function()
  {
    if(this.classOneId == this.classTwoId)
    {
      this.roleTwo = "roleName";
    }
  }
  
  this.setRoles = function(aRole1, aRole2)
  {
    this.roleOne = aRole1;
    this.roleTwo = aRole2;
  }
  
  this.setName = function(aName)
  {
    this.name = aName;
  }
  
  this.getName = function()
  {
    if (this.name == null || this.name == "") return this.deriveName();
    else return this.name;
  }
  
  this.deriveName = function()
  {
    var derivedName = "";
    var classOnePart = this.classOneId;
    var classTwoPart = this.classTwoId;
    
    if(!(this.roleOne == null || this.roleOne === ""))
    {
      classOnePart = this.classOneId + ":" + this.roleOne;
    }

    if(!(this.roleTwo == null || this.roleTwo === ""))
    {
      classTwoPart = this.classTwoId + ":" + this.roleTwo;
    }
    
    if (this.classOneId <= this.classTwoId)
    {
      derivedName = classOnePart + "__" + classTwoPart;
    }
    else
    {
      derivedName = classTwoPart + "__" + classOnePart;
    }
    return derivedName;
  }
  
  this.getElementId = function()
  {
    return this.id == null ? "newassociation" : this.id;
  }
  
  this.getClass = function(index)
  {
    return index == 0 ? UmpleSystem.find(this.classOneId) : UmpleSystem.find(this.classTwoId);
  }
  
  this.setOffsetOnePosition = function(offsetOnePosition)
  {
    var classOne = UmpleSystem.find(this.classOneId);
    this.classOnePosition = classOne.position;
    this.offsetOnePosition = offsetOnePosition.subtract(classOne.position).subtract(UmpleSystem.position());
    this.offsetOnePosition.width = 0;
    this.offsetOnePosition.height = 0;
  }
  
  this.setOffsetTwoPosition = function(offsetTwoPosition)
  {
    var classTwo = UmpleSystem.find(this.classTwoId);
    this.classTwoPosition = classTwo.position;
    this.offsetTwoPosition = offsetTwoPosition.subtract(classTwo.position).subtract(UmpleSystem.position());
    this.offsetTwoPosition.width = 0;
    this.offsetTwoPosition.height = 0;
  }
  
  // Used to trim non-reflexive associations to the edge of classes
  this.trimOverlap = function()
  {
    // set up needed variables
    var associationLine = new UmpleLine(this.offsetOnePosition.add(this.classOnePosition), this.offsetTwoPosition.add(this.classTwoPosition));
    var classOneBorders = UmpleSystem.find(this.classOneId).borderLines();
    var classTwoBorders = UmpleSystem.find(this.classTwoId).borderLines();
    var currentOne = this.offsetOnePosition.add(this.classOnePosition);
    var currentTwo = this.offsetTwoPosition.add(this.classTwoPosition);
    var intersections1 = [];
    var intersections2 = [];

    // find all intersections between the association line and class one borders
    for (var i=0; i<classOneBorders.length; i++)
    {
      intersection = associationLine.intersection(classOneBorders[i])
      if (intersection != null) intersections1.push(intersection);
    }
    
    // find all intersections between the association line and class two borders
    for (var i=0; i<classTwoBorders.length; i++)
    {
      intersection = associationLine.intersection(classTwoBorders[i]);
      if (intersection != null) intersections2.push(intersection);
    }
    
    // min is the shortest possible association line, and is set to the current
    // line by default
    var min = new UmpleLine(currentOne, currentTwo);

    // identify the cutoff point (intersection) on end one that results 
    // in the shortest association line
    var current = new UmpleLine(min.pointOne, min.pointTwo);
    for (var i=0; i<intersections1.length; i++)
    {
      current.pointOne = intersections1[i];
      if (current.length() < min.length()) {min = new UmpleLine(current.pointOne, current.pointTwo);}
    }
    
    // identify the cutoff point (intersection) on end two that results 
    // in the shortest association line
    var current = new UmpleLine(min.pointOne, min.pointTwo);
    for (var i=0; i<intersections2.length; i++)
    {
      current.pointTwo = intersections2[i];
      if (current.length() < min.length()) {min = new UmpleLine(current.pointOne, current.pointTwo);}
    }

    this.setOffsetOnePosition(min.pointOne.add(UmpleSystem.position()));
    this.setOffsetTwoPosition(min.pointTwo.add(UmpleSystem.position()));
  }

  // Used to move the endpoints of a reflexive associations to the closest edges of the class they were placed
  this.adjustReflexiveEndpoints = function()
  {
    var endOne = this.offsetOnePosition;
    var endTwo = this.offsetTwoPosition;

    var borders = UmpleSystem.find(this.classOneId).borderLines();

    // move the first point to the closest edge
    this.snapToClosestEdge(endOne, borders);

    // move the second point to the closest edge
    this.snapToClosestEdge(endTwo, borders);
  }

  this.snapToClosestEdge = function(point, borders)
  {
    var isNearTop = true;
    var isNearLeft = true;

    var adjustedX = point.x + this.classOnePosition.x;
    var adjustedY = point.y + this.classOnePosition.y;

    var topBottomDist = adjustedY - borders[0].pointOne.y;
    var leftRightDist = adjustedX - borders[1].pointOne.x;

    if(topBottomDist > borders[2].pointOne.y - adjustedY)
    {
      isNearTop = false;
      topBottomDist = borders[2].pointOne.y - adjustedY;
    }

    if(leftRightDist > borders[3].pointOne.x - adjustedX)
    {
      isNearLeft = false;
      leftRightDist = borders[3].pointOne.x - adjustedX;
    }

    if(topBottomDist <= leftRightDist)
    { 
      if(isNearTop) //Snap to top edge
        point.y = 0; 
      else //Snap to bottom edge
        point.y = this.classOnePosition.height;
    }
    else
    { 
      if(isNearLeft) //Snap to left edge
        point.x = 0;
      else //Snap to right edge
        point.x = this.classOnePosition.width;
    }
  }
  
  this.drawable = function()
  {
    if (this.id == null)
    {
      associationDiv = this.drawableTemp();  
    }
    else if (this.isReflexive())
    {
      associationDiv = this.drawableReflexive();
    }
    else if (this.isComposition())
    {
      associationDiv = this.drawableComposition();
    }
    else if (this.isBidirectional())
    {
      associationDiv = this.drawableBidirectional();
    }
    else
    {
      associationDiv = this.drawableUnidirectional();
    }
    return associationDiv;
  }
  
  ///////////////////////////////////////////////
  //Main rendering functions for the associations
  ///////////////////////////////////////////////
  this.drawableTemp = function()
  {
    var associationSel = "#" + this.getElementId();
    jQuery(associationSel).remove();
    
    var associationDiv = this.createBaseJQueryObject();
    associationDiv.addClass("umpleAssociationTemp");
    associationDiv.attr("id", "newassociation");
    
    var line = new UmpleLine(this.classOnePosition.add(this.offsetOnePosition), this.classTwoPosition.add(this.offsetTwoPosition));
    associationDiv.append(line.drawable());
            
    return associationDiv;
  }
  
  this.drawableBidirectional = function()
  {
    var associationSel = "#" + this.id;
    jQuery(associationSel).remove();
    
    var associationDiv = this.createBaseJQueryObject();
    if(this.color == "red") associationDiv.addClass("redTracedAssociation");
    else associationDiv.addClass("untracedAssociation");
    associationDiv.attr("id", this.id);
    associationDiv.attr("tabindex", 2);
    
    var classOne = UmpleSystem.find(this.classOneId);
    var classTwo = UmpleSystem.find(this.classTwoId);
  
  //If the classes are undefined quite operation
  if(classOne == null || classOne == undefined || classTwo == null || classTwo == undefined)
    return associationDiv;
  
    this.classOnePosition = classOne.position;
    this.classTwoPosition = classTwo.position;
    var perimeterOne = this.classOnePosition.add(this.offsetOnePosition);
    var perimeterTwo = this.classTwoPosition.add(this.offsetTwoPosition);

    var line = new UmpleLine(perimeterOne.add(UmpleClassFactory.offsetError),perimeterTwo.add(UmpleClassFactory.offsetError));
    
    if (!this.isComposition()) {
    	associationDiv.append(line.drawable());
    }
    
    // initiate the hovers and anchors
    var hoverHtml = "";
    var offset = -3;
    hoverHtml += this.anchorDivHtml("hover",0,perimeterOne.x + offset, perimeterOne.y + offset);
    hoverHtml += this.anchorDivHtml("anchor",0,perimeterOne.x + offset, perimeterOne.y + offset);
    hoverHtml += this.anchorDivHtml("hover",1,perimeterTwo.x + offset, perimeterTwo.y + offset);
    hoverHtml += this.anchorDivHtml("anchor",1,perimeterTwo.x + offset, perimeterTwo.y + offset);
    var angle = perimeterOne.slopeAngle(perimeterTwo);
    
    // draw the multiplicities
    var multiplicityOnePosition = this.multiplicityPosition(true);
    var multiplicityTwoPosition = this.multiplicityPosition(false);
    var multiOneHtml = this.multiplicityDivHtml("one",this.multiplicityOne,multiplicityOnePosition.x,multiplicityOnePosition.y); 
    var multiTwoHtml = this.multiplicityDivHtml("two",this.multiplicityTwo,multiplicityTwoPosition.x,multiplicityTwoPosition.y);
    
    // draw the role names 
    if (this.roleOne != "")
    {
      roleOnePosition = this.rolePosition(true);
      var roleOneHtml = this.roleDivHtml("one",this.roleOne,roleOnePosition.x,roleOnePosition.y);
    }
    else roleOneHtml = "";
    
    if (this.roleTwo != "") 
    {
      roleTwoPosition = this.rolePosition(false);
      var roleTwoHtml = this.roleDivHtml("two",this.roleTwo,roleTwoPosition.x,roleTwoPosition.y);
    }
    else roleTwoHtml = "";
  
    currentHtml = associationDiv.html();
    associationDiv.html(multiOneHtml + multiTwoHtml + roleOneHtml + roleTwoHtml + hoverHtml + currentHtml);
    
    return associationDiv;
  }
  
  this.drawableUnidirectional = function()
  {
    var associationDiv = this.drawableBidirectional();
    var peak = null;
    
    if (this.isLeftNavigable)
    {
      peak = this.classOnePosition.add(this.offsetOnePosition);
      otherEnd = this.classTwoPosition.add(this.offsetTwoPosition);
    }
    else
    {
      peak = this.classTwoPosition.add(this.offsetTwoPosition);
      otherEnd = this.classOnePosition.add(this.offsetOnePosition);
    }
    
    var associationLineSlopeAngle = peak.slopeAngle360(otherEnd);
    var edge1SlopeAngle = associationLineSlopeAngle + 30;
    var edge2SlopeAngle = associationLineSlopeAngle - 30;
    var distance = 10;
    
    var vertice1 = peak.travelForward(distance, edge1SlopeAngle);
    var vertice2 = peak.travelForward(distance, edge2SlopeAngle);
    
    var edge1 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice1.add(UmpleClassFactory.offsetError));
    var edge2 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice2.add(UmpleClassFactory.offsetError));
    associationDiv.append(edge1.drawable());
    associationDiv.append(edge2.drawable());
    
    return associationDiv;
  }
  
  this.drawableComposition = function()
  {
    var associationDiv = this.drawableBidirectional();

    var peak = null;
    
    if (this.isLeftComposition)
    {
      peak = this.classOnePosition.add(this.offsetOnePosition);
      otherEnd = this.classTwoPosition.add(this.offsetTwoPosition);
    }
    else
    {
      peak = this.classTwoPosition.add(this.offsetTwoPosition);
      otherEnd = this.classOnePosition.add(this.offsetOnePosition);
    }
    
    var associationLineSlopeAngle = peak.slopeAngle360(otherEnd);
    var edge1SlopeAngle = associationLineSlopeAngle + 30;
    var edge2SlopeAngle = associationLineSlopeAngle - 30;
    var distance = 8;
    
    var vertice1 = peak.travelForward(distance, edge1SlopeAngle);
    var vertice2 = peak.travelForward(distance, edge2SlopeAngle);
    var vertice3 = vertice1.travelForward(distance, edge2SlopeAngle);
    
    var edge1 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice1.add(UmpleClassFactory.offsetError));
    var edge2 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice2.add(UmpleClassFactory.offsetError));
    var edge3 = new UmpleLine(vertice1.add(UmpleClassFactory.offsetError), vertice3.add(UmpleClassFactory.offsetError));
    var edge4 = new UmpleLine(vertice2.add(UmpleClassFactory.offsetError), vertice3.add(UmpleClassFactory.offsetError));

    associationDiv.append(edge1.drawable());
    associationDiv.append(edge2.drawable());
    associationDiv.append(edge3.drawable());
    associationDiv.append(edge4.drawable());

    var assocLine = new UmpleLine(vertice3.add(UmpleClassFactory.offsetError),otherEnd.add(UmpleClassFactory.offsetError));
    associationDiv.append(assocLine.drawable());


    // to draw an empty diamond (i.e. not coloured in), comment out the following lines of code 
    // until the next comment indicates

    var distanceM = 4;
    
    var vertice1M = peak.travelForward(distanceM, edge1SlopeAngle);
    var vertice2M = peak.travelForward(distanceM, edge2SlopeAngle);
    var vertice3M = vertice1.travelForward(distanceM, edge2SlopeAngle);
    var vertice4M = vertice2.travelForward(distanceM, edge1SlopeAngle);

    var edge1M = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice3M.add(UmpleClassFactory.offsetError));
    var edge2M = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice4M.add(UmpleClassFactory.offsetError));
    var edge3M = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice3.add(UmpleClassFactory.offsetError));
    
    var edge4M = new UmpleLine(vertice1.add(UmpleClassFactory.offsetError), vertice4M.add(UmpleClassFactory.offsetError));
    var edge5M = new UmpleLine(vertice1.add(UmpleClassFactory.offsetError), vertice2M.add(UmpleClassFactory.offsetError));
    var edge6M = new UmpleLine(vertice1.add(UmpleClassFactory.offsetError), vertice2.add(UmpleClassFactory.offsetError));
    
    var edge7M = new UmpleLine(vertice2.add(UmpleClassFactory.offsetError), vertice1M.add(UmpleClassFactory.offsetError));
    var edge8M = new UmpleLine(vertice2.add(UmpleClassFactory.offsetError), vertice3M.add(UmpleClassFactory.offsetError));
    
    var edge9M = new UmpleLine(vertice3.add(UmpleClassFactory.offsetError), vertice1M.add(UmpleClassFactory.offsetError));
    var edge10M = new UmpleLine(vertice3.add(UmpleClassFactory.offsetError), vertice2M.add(UmpleClassFactory.offsetError));
    
    var edge11M = new UmpleLine(vertice1M.add(UmpleClassFactory.offsetError), vertice2M.add(UmpleClassFactory.offsetError));
    var edge12M = new UmpleLine(vertice1M.add(UmpleClassFactory.offsetError), vertice3M.add(UmpleClassFactory.offsetError));
    var edge13M = new UmpleLine(vertice1M.add(UmpleClassFactory.offsetError), vertice4M.add(UmpleClassFactory.offsetError));

    var edge14M = new UmpleLine(vertice2M.add(UmpleClassFactory.offsetError), vertice3M.add(UmpleClassFactory.offsetError));
    var edge15M = new UmpleLine(vertice2M.add(UmpleClassFactory.offsetError), vertice4M.add(UmpleClassFactory.offsetError));

    var edge16M = new UmpleLine(vertice3M.add(UmpleClassFactory.offsetError), vertice4M.add(UmpleClassFactory.offsetError));

    associationDiv.append(edge1M.drawable());
    associationDiv.append(edge2M.drawable());
    associationDiv.append(edge3M.drawable());
    associationDiv.append(edge4M.drawable());
    associationDiv.append(edge5M.drawable());
    associationDiv.append(edge6M.drawable());
    associationDiv.append(edge7M.drawable());
    associationDiv.append(edge8M.drawable());
    associationDiv.append(edge9M.drawable());
    associationDiv.append(edge10M.drawable());
    associationDiv.append(edge11M.drawable());
    associationDiv.append(edge12M.drawable());
    associationDiv.append(edge13M.drawable());
    associationDiv.append(edge14M.drawable());
    associationDiv.append(edge15M.drawable());
    associationDiv.append(edge16M.drawable());

    // end of code block to comment out for empty arrow (see above) 

    return associationDiv;
  }

  this.drawableReflexive = function() 
  {
    // replace the old association div with a fresh one
    var associationSel = "#" + this.id;
    jQuery(associationSel).remove();
    var associationDiv = this.createBaseJQueryObject();
    if(this.color == "red") associationDiv.addClass("redTracedAssociation");
    else associationDiv.addClass("untracedAssociation");
    associationDiv.attr("id", this.id);
    associationDiv.attr("tabindex", 2);
    
    // set the class positions
    var umpleClass = UmpleSystem.find(this.classOneId);
    this.classOnePosition = umpleClass.position;
    this.classTwoPosition = umpleClass.position;
    var classHeight = umpleClass.position.height;
    var classWidth = umpleClass.position.width;
    
    // initialize variables to be used
    var segmentLength = 15;
    
    // identify which class wall (N,S,E or W) end one sits on
    var endOneWall = this.whichWall(true);
    factorX = endOneWall == "West"? -1 : endOneWall == "South"? 0 : endOneWall == "East"? 1 :  0;
    factorY = endOneWall == "West"?  0 : endOneWall == "South"? 1 : endOneWall == "East"? 0 : -1;
    
    // set the start and end points of segment one (small line starting at offset one and perpendicular to class wall)
    var segmentOneStart = this.offsetOnePosition.add(this.classOnePosition);
    var segmentOneEnd = this.offsetOnePosition.add(this.classOnePosition).add(new UmplePosition(segmentLength*factorX, segmentLength*factorY,0,0));
    if(endOneWall == "South") segmentOneStart.y = segmentOneStart.y - 1;
    var segmentOne = new UmpleLine(segmentOneStart, segmentOneEnd);
    
    // identify which class wall (N,S,E or W) end two sits on
    var endTwoWall = this.whichWall(false);
    factorX = endTwoWall == "West"? -1 : endTwoWall == "South"? 0 : endTwoWall == "East"? 1 :  0;
    factorY = endTwoWall == "West"?  0 : endTwoWall == "South"? 1 : endTwoWall == "East"? 0 : -1;
  
    // set the start and end points of segment two (small line starting at offset two and perpendicular to class wall)
    var segmentTwoStart = this.offsetTwoPosition.add(this.classTwoPosition);
    var segmentTwoEnd = this.offsetTwoPosition.add(this.classTwoPosition).add(new UmplePosition(segmentLength*factorX, segmentLength*factorY,0,0));
    var segmentTwo = new UmpleLine(segmentTwoStart, segmentTwoEnd);
    
    // add both segments to the div
    associationDiv.append(segmentOne.drawable());
    associationDiv.append(segmentTwo.drawable());
    
    // The point(s) to add the label to
    var labelPositionOne = new UmplePosition(0, 0, 0, 0);
    
    // if both ends are on same wall connect them with one line
    // also set the position for the label
    if(endOneWall == endTwoWall)
    {
      var connector = new UmpleLine(segmentOneEnd, segmentTwoEnd);
      
      if(endOneWall == "North" || endOneWall == "South") 
      {
        if(this.isSymmetricReflexive) 
        {
          // Set the label position to the midpoint of the connector
          labelPositionOne.x = (segmentOneEnd.x + segmentTwoEnd.x)/2;
          labelPositionOne.y = segmentOneEnd.y;
        }
      }
      else 
      {
        if(this.isSymmetricReflexive) 
        {
          // Set the the label position to the midpoint of the connector
          labelPositionOne.x = segmentOneEnd.x;
          labelPositionOne.y = (segmentOneEnd.y + segmentTwoEnd.y)/2;
        }
      }
      
      associationDiv.append(connector.drawable());
    }
    
    // if ends are on adjacent walls, connect them with two lines
    else if (this.offsetOnePosition.wallsAreAdjacent(endOneWall, endTwoWall))
    {
      var meetingPoint = new UmplePosition(0,0,0,0);
      var anEndIsOnLeft = (endOneWall == "West" || endTwoWall == "West");
      var anEndIsOnTop = (endOneWall == "North" || endTwoWall == "North");
    
      if (anEndIsOnLeft) meetingPoint.x = this.classOnePosition.x - segmentLength;
      else meetingPoint.x = this.classOnePosition.x + classWidth + segmentLength;
      if (anEndIsOnTop) meetingPoint.y = this.classOnePosition.y - segmentLength;
      else meetingPoint.y = this.classOnePosition.y + classHeight + segmentLength;
      
      var connectorOne = new UmpleLine(segmentOneEnd, meetingPoint);
      var connectorTwo = new UmpleLine(segmentTwoEnd, meetingPoint);
      associationDiv.append(connectorOne.drawable());
      associationDiv.append(connectorTwo.drawable());
      
      if(this.isSymmetricReflexive) 
      {
        // Set the label position to the connection point of the two added line segments
        labelPositionOne.set(meetingPoint.x, meetingPoint.y);
      }
    }
    
    // otherwise, ends are on opposite walls - connect them using three lines
    else
    {
      var meetingPoint1 = new UmplePosition(0,0,0,0);
      var meetingPoint2 = new UmplePosition(0,0,0,0);
      var connector1;
      var connector2;
      var connector3;
      var start;
      var end;
        
      // if top and bottom, go around the left of the class
      if (endOneWall == "South" || endTwoWall == "South")
      {
        // connecting points at top left and bottom left
        meetingPoint1.x = this.classOnePosition.x - segmentLength;
        meetingPoint1.y = this.classOnePosition.y - segmentLength;
        meetingPoint2.x = meetingPoint1.x;
        meetingPoint2.y = this.classOnePosition.y + classHeight + segmentLength;
        
        if (endTwoWall == "South")
        {
          start = segmentOneEnd;
          end = segmentTwoEnd;
        }
        else
        {
          start = segmentTwoEnd;
          end = segmentOneEnd;
        }
        
        if(this.isSymmetricReflexive) 
        {
          labelPositionOne.x = meetingPoint1.x;
          labelPositionOne.y = (meetingPoint1.y + meetingPoint2.y)/2;
        }
      }
      // if left and right, go around the bottom of the class
      else
      {
        // connecting points at bottom left and bottom right
        meetingPoint1.x = this.classOnePosition.x - segmentLength;
        meetingPoint1.y = this.classOnePosition.y + classHeight + segmentLength;
        meetingPoint2.x = this.classOnePosition.x + classWidth + segmentLength;
        meetingPoint2.y = meetingPoint1.y;
        
        if (endTwoWall == "East")
        {
          start = segmentOneEnd;
          end = segmentTwoEnd;
        }
        else
        {
          start = segmentTwoEnd;
          end = segmentOneEnd;
        }
        
        if(this.isSymmetricReflexive) 
        {
          labelPositionOne.x = (meetingPoint1.x + meetingPoint2.x)/2;
          labelPositionOne.y = meetingPoint1.y;
        }
      }
      connector1 = new UmpleLine(start, meetingPoint1);
      connector2 = new UmpleLine(meetingPoint1, meetingPoint2);
      connector3 = new UmpleLine(meetingPoint2, end);
      
      associationDiv.append(connector1.drawable());
      associationDiv.append(connector2.drawable());
      associationDiv.append(connector3.drawable()); 
    }
    
    // Set the label positions for non-symmetric reflexive associations.
    // If it is not symmetric, then the labels are always at the midpoints of the line
    // segments that are attached to the class
    if(!this.isSymmetricReflexive) 
    {
      var labelPositionTwo = new UmplePosition(0, 0, 0, 0);
      
      if(endOneWall == "North" || endOneWall == "South")
      {
        labelPositionOne.x = segmentOneEnd.x;
        labelPositionOne.y = (segmentOneStart.y + segmentOneEnd.y)/2;
      }
      else 
      {
        labelPositionOne.x = (segmentOneStart.x + segmentOneEnd.x)/2;
        labelPositionOne.y = segmentOneEnd.y;
      }
      
      if(endTwoWall == "North" || endTwoWall == "South")
      {
        labelPositionTwo.x = segmentTwoEnd.x;
        labelPositionTwo.y = (segmentTwoStart.y + segmentTwoEnd.y)/2;
      }
      else 
      {
        labelPositionTwo.x = (segmentTwoStart.x + segmentTwoEnd.x)/2;
        labelPositionTwo.y = segmentTwoEnd.y;
      }
    }
    
    // Create the markup for the anchors to move the associations
    var hoverHtml = "";
    var hover0 = segmentOneStart;
    var hover1 = segmentTwoStart;
    var centerHover = 3;
    hoverHtml += this.anchorDivHtml("hover",0,hover0.x - centerHover, hover0.y - centerHover);
    hoverHtml += this.anchorDivHtml("anchor",0,hover0.x - centerHover, hover0.y - centerHover);
    hoverHtml += this.anchorDivHtml("hover",1,hover1.x - centerHover, hover1.y - centerHover);
    hoverHtml += this.anchorDivHtml("anchor",1,hover1.x - centerHover, hover1.y - centerHover);
    
    // Create the markup for the association labels and multiplicities
    if(this.isSymmetricReflexive)
    {
      var multiplicityPosition = UmplePositionFactory.copy(this.centerMultiplicityPosition(labelPositionOne));
      
      // draw the role names
      var rolePosition = this.adjustRolePosition(labelPositionOne, true);
      var roleHtml = this.roleDivHtml("center", this.roleOne, rolePosition.x, rolePosition.y)

      //draw the multiplicities
      var multiHtml = this.multiplicityDivHtml("center", this.multiplicityOne, 
          multiplicityPosition.x, multiplicityPosition.y); 
    }
    else
    { 
      var multiplicityPositionOne = UmplePositionFactory.copy(
          this.reflexiveMultiplicityPosition(labelPositionOne, labelPositionTwo, true));
      var multiplicityPositionTwo = UmplePositionFactory.copy(
          this.reflexiveMultiplicityPosition(labelPositionTwo, labelPositionOne, false));
      
      // draw the role names
      var rolePositionOne = this.adjustRolePosition(labelPositionOne, true);
      var rolePositionTwo = this.adjustRolePosition(labelPositionTwo, false);
      var roleHtml = (this.roleDivHtml("one", this.roleOne, rolePositionOne.x, rolePositionOne.y)
          + this.roleDivHtml("two", this.roleTwo, rolePositionTwo.x, rolePositionTwo.y));
      
      //draw the multiplicities
      var multiHtml = 
        (this.multiplicityDivHtml("one", this.multiplicityOne, multiplicityPositionOne.x, multiplicityPositionOne.y)
        + this.multiplicityDivHtml("two", this.multiplicityTwo, multiplicityPositionTwo.x, multiplicityPositionTwo.y)); 
    }
    
    if (this.id == null)
    {
      associationDiv.attr("id", "newassociation");
      return associationDiv;
    } 
    
    var currentHtml = associationDiv.html();
    associationDiv.html(multiHtml + roleHtml + hoverHtml + currentHtml);
    
    return associationDiv;
  }
  
  /////////////////////////////////////////////////
  //Helper functions for rendering the associations
  /////////////////////////////////////////////////
  this.isReflexive = function()
  {
    return this.classOneId == this.classTwoId || this.isSymmetricReflexive;
  }
  
  this.isBidirectional = function()
  {
    if (this.isRightNavigable == undefined || this.isLeftNavigable == undefined)
    {
      return true;
    }
    return this.isRightNavigable && this.isLeftNavigable;
  }

  this.isComposition = function()
  {
    return this.isRightComposition || this.isLeftComposition;
  }
  
  this.endHasArrow = function(isEndOne)
  {
    if (isEndOne) return this.isLeftNavigable;
    else return this.isRightNavigable;
  }

  this.contains = function(umpleClass)
  {
    return umpleClass.id == this.classOneId || umpleClass.id == this.classTwoId;
  }
  
  this.anchorDivHtml = function(type,index,x,y)
  {
    return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,type,index,x,y);
  }
  
  this.multiplicityDivHtml = function(leftOrRight,multiplicity,x,y,role)
  {
    if (role == undefined || role == "undefined") role = "";
    return format('<div id="{0}_{1}" class="multiplicity" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}&nbsp;&nbsp;{5}</div>',this.id,leftOrRight,x,y,multiplicity,role);
  }
  
  this.roleDivHtml = function(position,role,x,y)
  {
    if (position == "one") idExtension = "roleOne";
    else if (position == "two") idExtension = "roleTwo";
    else if (position == "center") idExtension = "role";
    else idExtension = "";
    return format('<div id="{0}_{1}" class="role" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}</div>',this.id,idExtension,x,y,role);
  }
  
  this.whichWall = function(isEndOne)
  {
    // set proper values according to which end we are dealing with
    if (isEndOne)
    {
      var classPosition = this.classOnePosition;
      var offset = this.offsetOnePosition;
    }
    else
    {
      var classPosition = this.classTwoPosition;
      var offset = this.offsetTwoPosition;
    }
    
    // determine which class wall the association end resides on
    var max = 1;
    if (offset.x == 0)
    {
      return "West";
    }
    else if (offset.y == 0)
    {
      return "North";
    }
    else if (Math.abs(offset.x-classPosition.width) <= max)
    {
      return "East";
    }
    else
    {
      return "South";
    }
  }
  
  this.multiplicityPosition = function(isEndOne)
  {
    // perimeters are the offset positions relative to the umple canvas
    // (as opposed to their end class)
    if (isEndOne)
    {
      var perimeterOne = this.classOnePosition.add(this.offsetOnePosition);
      var perimeterTwo = this.classTwoPosition.add(this.offsetTwoPosition);
      var multiplicity = this.multiplicityOne;
    }
    else
    {
      var perimeterOne = this.classTwoPosition.add(this.offsetTwoPosition);
      var perimeterTwo = this.classOnePosition.add(this.offsetOnePosition);
      var multiplicity = this.multiplicityTwo;
    }
    
    // identify which wall the association end lies on
    var wall = this.whichWall(isEndOne);
    
    var multHeight = multiplicity == "*"? new UmplePosition(0,10,0,0):new UmplePosition(0,16,0,0);
    var multWidth = new UmplePosition(5*multiplicity.length+1,0,0,0);
    
    // allow extra space for arrow in undirectional associations
    // reduce space if multiplicity is *
    var space = 3;
    if ((!this.isBidirectional() && this.endHasArrow(isEndOne)) || this.isComposition()) space += 5;
    
    // slope angle of the association
    var angle = perimeterOne.slopeAngle360(perimeterTwo);
    
    // multiplicity is positioned at middle angle between
    // association and class wall
    if (wall == "North")
    {
      if (angle < 90)
      {
        var halfWaySlope = (180-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multWidth);
        multPosition = multPosition.subtract(multHeight);
      }
      else
      {
        var halfWaySlope = angle/2;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
      }
    }
    else if (wall == "East")
    {
      if (angle >= 0 && angle <= 90)
      {
        var halfWaySlope = (angle+90)/2 + 270;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
      }
      else
      {
        var halfWaySlope = ((360-angle+90)/2 + angle)%360;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
      }
    }
    else if (wall == "South")
    {
      if (angle <= 270)
      {
        var halfWaySlope = (360-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        var temp = multPosition;
      }
      else
      {
        var halfWaySlope = (angle-180)/2 + 180;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        var temp = multPosition;
        multPosition = multPosition.subtract(multWidth);
      }
    }
    else
    {
      if (angle <= 180)
      {
        var halfWaySlope = (270-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multWidth);
      }
      else
      {
        var halfWaySlope = (angle-90)/2 + 90;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
        multPosition = multPosition.subtract(multWidth);
      }
    }
    return multPosition;
  }
  
  //Sets the location of a multiplicity label for symmetric reflexive associations.
  // An UmplePosition is returned that includes the width of the role name.
  this.centerMultiplicityPosition = function(labelPosition) 
  {
    var wallOne = this.whichWall(true);
    var wallTwo = this.whichWall(false);
    
    var offset = 1;
    var space = 5;
    
    labelPosition.width = 5*this.multiplicityOne.length + space + 6*this.roleOne.length;
    labelPosition.height = 16; 
    
    if((wallOne == "West" && wallTwo == "West") 
      || (wallOne == "North" && wallTwo == "South")
      || (wallOne == "South" && wallTwo == "North")) 
    {
      //label is offset to left
      labelPosition.x -= (labelPosition.width + offset);
      labelPosition.y -= labelPosition.height/2;
    } 
    else if(wallOne == "East" && wallTwo == "East") 
    {
      //label is offset to right
      labelPosition.x += offset;
      labelPosition.y -= labelPosition.height/2;
    } 
    else if(wallOne == "North" || wallTwo == "North") 
    {
      //label is offset upwards
      labelPosition.y -= (offset + labelPosition.height);
      labelPosition.x -= labelPosition.width/2;
    } 
    else 
    {
      //label is offset downwards
      labelPosition.y += offset;
      labelPosition.x -= labelPosition.width/2;
    } 
    
    return labelPosition;
  }
  
  // Sets the location of a multiplicity label for non-symmetric reflexive associations.
  // An UmplePosition is returned that includes the width of the role name.
  this.reflexiveMultiplicityPosition = function(position, otherPosition, isAssociationOne) 
  {
    var space = 5;
    var offset = 1;
    
    if(isAssociationOne) 
    {
      var wall = this.whichWall(true);
      var otherWall = this.whichWall(false);
      var multiplicityLength = this.multiplicityOne.length;
      var roleLength = this.roleOne.length;
    }
    else 
    {
      var wall = this.whichWall(false);
      var otherWall = this.whichWall(true);
      var multiplicityLength = this.multiplicityTwo.length;
      var roleLength = this.roleTwo.length;
    }
    
    position.width = 5*multiplicityLength + space + 6*roleLength;
    position.height = 16; 
    
    if(wall == "North") 
    {
      position.y -= position.height/2;
      if((otherWall == "North" && position.x < otherPosition.x) 
          || otherWall == "East")
      {
        // label is offset to the left
        position.x -= (position.width + offset);
      }
      else
      {
        // label is offset to the right
        position.x += offset;
      }
    }
    else if (wall == "East")
    {
      if((otherWall == "East" && position.y < otherPosition.y)
          || otherWall == "South" || otherWall == "West")
      {
        //label is offset upwards
        position.y -= (position.height);
      }
      else 
      {
        //label is offset downwards
        position.y += offset;
      }
    }
    else if(wall == "South")
    {
      position.y -= position.height/2;
      if((otherWall == "South" && position.x < otherPosition.x)
          || otherWall == "East")
      {
        // label is offset to the left
        position.x -= (position.width + offset);
      }
      else 
      {
        // label is offset to the right
        position.x += offset;
      }
    }
    else if (wall == "West")
    {
      position.x -= position.width;
      if((otherWall == "West" && position.y < otherPosition.y)
          || otherWall == "East" || otherWall == "South")
      {
        //label is offset upwards 
        position.y -= (position.height);
      }
      else
      {
        //label is offset downwards 
        position.y += offset;
      }
    }
    return position;
  }
  
  this.rolePosition = function(isEndOne)
  {
    var multiplicity = isEndOne? this.multiplicityOne : this.multiplicityTwo;
    var role = isEndOne? this.roleOne : this.roleTwo;
    var perimeterOne = isEndOne? this.classOnePosition.add(this.offsetOnePosition):
                   this.classTwoPosition.add(this.offsetTwoPosition);
    var perimeterTwo = isEndOne? this.classTwoPosition.add(this.offsetTwoPosition):
                   this.classOnePosition.add(this.offsetOnePosition);
    
    // length of multiplicity plus a space character
    var multLength = new UmplePosition(5*(multiplicity.length),0,0,0);
    var roleLength = new UmplePosition(6*(role.length),0,0,0,0);
    var multHeight = new UmplePosition(0,16,0,0);
    var roleHeight = multHeight;
    var space = new UmplePosition(5,0,0,0);
    var multPosition = this.multiplicityPosition(isEndOne);
    
    // new algorithm: reuse angles from multiplicity to know which side it goes on
    // 8 cases in total
    var wall = this.whichWall(isEndOne); 
    
    // slope angle of the association
    var angle = perimeterOne.slopeAngle360(perimeterTwo);
    if (wall == "North")
    {
      if (angle < 90)
      {
        // role goes on left of multiplicity
        rolePosition = multPosition.subtract(roleLength).subtract(multLength);
      }
      else
      {
        // role goes on right of multiplicity
        rolePosition = multPosition.add(multLength).add(space);
      }
      // re adjust position if multiplicity is "*"
      if (multiplicity == "*") rolePosition = rolePosition.subtract(new UmplePosition(0,6,0,0));
    }
    else if (wall == "East")
    {
      // role goes on right 
      rolePosition = multPosition.add(multLength).add(space);
    }
    else if (wall == "South")
    {
      if (angle <= 270)
      {
        // role goes on right 
        rolePosition = multPosition.add(multLength).add(space);
      }
      else
      {
        // role goes on left
        rolePosition = multPosition.subtract(roleLength).subtract(multLength);
      }
    }
    else
    {
      // role goes on left
      rolePosition = multPosition.subtract(roleLength).subtract(multLength);
    }
    return rolePosition;  
  }
  
  this.adjustRolePosition = function(labelPosition, isAssociationEndOne)
  {
    var multiplicityLength = isAssociationEndOne ? this.multiplicityOne.length : this.multiplicityTwo.length;
    //Move the label over by the length of the multiplicity label and a space
    labelPosition.x += 5*multiplicityLength + 6;
    return labelPosition;
  }

  this.createBaseJQueryObject = function()
  {
    return jQuery(format("<div class='{0}'></div>", this.getName()))
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models attributes in the graphical view of UmpleOnline

UmpleAttributeFactory = new Object();

UmpleAttributeFactory.create = function(data)
{
  var type = data.type;
  var name = data.name;
  var color = data.traceColor;
  if(color == "") color = "black";

  var umpleAttribute = new UmpleAttribute(type, name, color);
  return umpleAttribute;
}

function UmpleAttribute(aType,aName,aColor)
{
  this.type = aType;
  this.name = aName;
  this.textColor = aColor;

  if(this.aColor === "" || this.aColor === undefined ) this.aColor = "black"; 

  this.set = function(input)
  {
    this.textColor = "black";
    var isExisting = this.type != "" && this.name != "";
    if (isExisting)
    {
      this.oldType = this.type;
      this.oldName = this.name;
    }
  
    var typeAndName = input.split(":");
    if (typeAndName.length < 2)
    {
      this.type = "String";
      this.name = input;
    }
    else
    {
      this.name = typeAndName[0].trim();
      this.type = typeAndName[1].trim();
    }
    
    if (!isExisting)
    {
      this.newType = this.type;
      this.newName = this.name;
    }
    
  }
  
  this.copy = function()
  {
    return new UmpleAttribute(this.type,this.name,this.textColor);
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models classes in the graphical view of UmpleOnline

UmpleClassFactory = new Object();
UmpleClassFactory.defaultSize = new UmplePosition(0,0,109,41);
UmpleClassFactory.offsetError = new UmplePosition(0,0,0,0);

UmpleClassFactory.create = function(data)
{
  var umpleClass = new UmpleClass();
  umpleClass.id = data.id;
  umpleClass.name = data.name;
  umpleClass.isInterface = data.isInterface;
  umpleClass.isAbstract = data.isAbstract;
  umpleClass.displayColor = data.displayColor;
  if(umpleClass.displayColor == "") umpleClass.displayColor="transparent";  
  umpleClass.position.x = data.position.x;
  umpleClass.position.y = data.position.y;
  umpleClass.position.width = data.position.width;
  umpleClass.position.height = data.position.height;
  umpleClass.extendsClass = data.extendsClass;

  for (var i = 0; i < data.attributes.length; i++)
  {
    if(data.attributes[i].modifier == "const") 
    {
      continue;
    }
    umpleClass.attributes.push(UmpleAttributeFactory.create(data.attributes[i]));
  }
  for (var i = 0; i < data.methods.length; i++)
  {
    umpleClass.methods.push(UmpleMethodFactory.create(data.methods[i]));
  }
  if(data.implementedInterfaces != null)
  {
    for (var i = 0; i < data.implementedInterfaces.length; i++)
    {
      umpleClass.interfaces[i] = data.implementedInterfaces[i].interfacesName +"";
    }
  }  
  
  return umpleClass;
}

UmpleClassFactory.perimeterPosition = function(umpleClass, currentPosition, offset)
{
  if (typeof(offset) == "undefined")
  {
    offset = new UmplePosition(0,0,0,0);
  }

  var x = currentPosition.x;
  var y = currentPosition.y;

  var delta = 0;
  var minX = offset.x + umpleClass.position.x + delta;
  var maxX = minX + umpleClass.position.width;

  var minY = offset.y + umpleClass.position.y + delta;
  var maxY = minY + umpleClass.position.height;
  
  var realX = x < minX  ? minX  : x > maxX  ? maxX : x;
  var realY = y < minY ? minY : y > maxY ? maxY : y;

  var minXDelta = x - minX;
  var maxXDelta = maxX - x;
  var minYDelta = y - minY;
  var maxYDelta = maxY - y;

  var deltaX = Math.min(minXDelta,maxXDelta);
  var deltaY = Math.min(minYDelta,maxYDelta);
  

  if (deltaX < deltaY)
  {
    realX = minXDelta < maxXDelta ? minX : maxX;
  }
  else if (deltaY < deltaX)
  {
    realY = minYDelta < maxYDelta ? minY : maxY;
  }
  
  return new UmplePosition(Math.round(realX),Math.round(realY),0,0);
}



function UmpleClass()
{
  this.id;
  this.name;
  this.isInterface;
  this.isAbstract;
  this.displayColor = "transparent";
  this.position = new UmplePosition(0,0,109,41);
  this.attributes = [];
  this.methods = [];
  this.interfaces = [];
  this.extendsClass;

  this.addAttribute = function(typeAndName)
  {
    var attribute = new UmpleAttribute("","","");
    attribute.set(typeAndName);
    this.attributes.push(attribute);
    return this.attributes.length - 1;
  }
  
  this.removeAttribute = function(index)
  {
    var attribute = this.attributes[index];
    attribute.deleteType = attribute.type;
    attribute.deleteName = attribute.name;
  }
  
  this.resetAttribute = function(index)
  {
    if (this.attributes[index].deleteName != null)
    {
      this.attributes.splice(index,1);
    }
    else
    {
      this.attributes[index] = this.attributes[index].copy();
    }
  }

  this.resetMethod = function(index)
  {
    if(this.methods[index].deleteName != null)
    {
      this.methods.splice(index,1);
    }
    else
    {
      this.methods[index] = this.methods[index].copy();
    }
  }


  this.addMethod = function(data)
  {
    var method = new UmpleMethod("","","","");
    method.set(data);
    this.methods.push(method);
    return this.methods.length - 1;
  }

  this.removeMethod = function(index)
  {
    var method = this.methods[index];
    method.deleteType = method.type;
    method.deleteVisibility = method.visibility;
    method.deleteName = method.name;
    method.deleteParameters = method.parameters;
  }


  this.setExtendsClass = function(umpleClassId)
  {
    this.extendsClass = umpleClassId;
  }
  
  this.removeExtendsClass = function()
  {
    this.extendsClass = null;
  }
  
  // Used by trimOverlap to enable associations to line up properly
  this.borderLines = function()
  {
    var classObj = jQuery("#" + this.id);
    var width = classObj.width();
    var height = classObj.height();

    var topLeft = this.position;
    var topRight = this.position.add(new UmplePosition(width,0,0,0));
    var bottomLeft = this.position.add(new UmplePosition(0,height,0,0));
    var bottomRight = this.position.add(new UmplePosition(width,height,0,0));

    borders = [];
    borders.push(new UmpleLine(topLeft, topRight));
    borders.push(new UmpleLine(topLeft, bottomLeft));
    borders.push(new UmpleLine(bottomLeft, bottomRight));
    borders.push(new UmpleLine(topRight, bottomRight));
    
    return borders;
  }
         
  this.drawable = function()
  {
  var classDiv = this.drawClass();
  var generalizationDiv = this.drawGeneralization();  
  var divs = [classDiv,generalizationDiv];
    return divs;
  }
  
  this.drawClass = function()
  {
    var classSel = "#" + this.id;
    var existingClassDiv = jQuery(classSel).get();
    
    if (existingClassDiv == undefined || existingClassDiv == null || existingClassDiv == "")
    {
      classDiv = jQuery("<div></div>");
      classDiv.addClass("umpleClass");
      classDiv.attr("tabindex", 2);
    }
    else
    {
      classDiv = jQuery(existingClassDiv);
      removalSel = format("div#{0} .classTable," +
           "div#{0} .umpleAttribute," +
           "div#{0} .umpleAttributeNew," +
           "div#{0} .anchor, " +
           "div#{0} .hover", this.id);
      jQuery(removalSel).remove();
    }
    
    classDiv.attr("id", this.id);
        
    var offset = -3.5;
    var bottomOffset = -3;
     
    var attributesInnerHtml = '';
    var methodsInnerHtml = '';
    var classInnerHtml = '';

    if (this.attributes.length > 0)
    {
      // For each attribute, output the html
      for (var i=0; i<this.attributes.length; i++)
      { 
        var attr = this.attributes[i];

        var colorStyle = ""
        if(attr.textColor != "black") colorStyle = format("style='color:{0}'", attr.textColor);

        if (Page.isPhotoReady())
        {
          attributesInnerHtml += format('<div class="umpleAttribute" {3}>{0} : {1}</div>',attr.name,attr.type, colorStyle);
        }
        else
        {
          attributesInnerHtml += format('<div class="umpleAttribute" {5}><span id="{2}_attribute_{3}" name="attributeEdit" class="editable editableDoubleClick">{0} : {1}</span> <img src="scripts/delete2.jpg" onclick="DiagramEdit.attributeDelete({4}{2}{4},{4}{3}{4})" /></div>',attr.name,attr.type,this.id,i,"'",colorStyle);
        }
      }
    } // End of loop adding attributes
    
    if(this.methods.length > 0)
    {
      for(var i = 0; i<this.methods.length;i++)
      {
        var method = this.methods[i];

        var visibility="";
        if(method.visibility == "public")
          visibility = "+ ";
        else if(method.visibility == "private")
          visibility = "- ";
        else if(method.visibility == "protected")
          visibility = "# ";
        else
          visibility = "+ ";   //set default visibility to public

        var methodtype = (method.type == "" ?  "void" : method.type)
        
        if(Page.isPhotoReady())
        {

          if ( method.isAbstract == "true")
          {
            methodsInnerHtml += format('<div class="umpleMethod">{3}<span style="font-style:italic">{1}({2}) </span> : {0} </div>',methodtype,method.name,method.parameters,visibility);
          }
          else 
          {
            methodsInnerHtml += format('<div class="umpleMethod">{3}{1}({2}) : {0} </div>',methodtype,method.name,method.parameters,visibility);
          }
        }
        else
          if ( method.isAbstract == "true")
          {
            methodsInnerHtml += format('<div class="umpleMethod"><span id="{4}_method_{5}" name="methodEdit" class="editable editableDoubleClick">{3}<span style="font-style:italic">{1}({2})</span> : {0} </span> <img src="scripts/delete2.jpg" onclick="DiagramEdit.methodDelete({6}{4}{6},{6}{5}{6})" /></div>',methodtype,method.name,method.parameters,visibility,this.id,i,"'");
          }
          else {
            methodsInnerHtml += format('<div class="umpleMethod"><span id="{4}_method_{5}" name="methodEdit" class="editable editableDoubleClick">{3}{1}({2}) : {0} </span> <img src="scripts/delete2.jpg" onclick="DiagramEdit.methodDelete({6}{4}{6},{6}{5}{6})" /></div>',methodtype,method.name,method.parameters,visibility,this.id,i,"'");
          }
      }
    }
    
    attributesInnerHtml += format('<div class="umpleAttributeNew"><span id="{0}_newAttribute" name="attributeNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady() ? '&nbsp;' : '-- Add More --');

    methodsInnerHtml += format('<div class="umpleMethodNew"><span id="{0}_newMethod" name="methodNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady() ? '&nbsp;' : '-- Add More --');

    if (!Page.isPhotoReady())
    {
// The following commented out to remove unneeded hovers that are not selectable anyway
// Similar code removed from UmpleClass.drawClass
/*
      classInnerHtml +=
      this.anchorDivHtml("anchor",0) +
      this.anchorDivHtml("anchor",1) +
      this.anchorDivHtml("anchor",2) +
      this.anchorDivHtml("anchor",3) +
      this.anchorDivHtml("anchor",4) +
      this.anchorDivHtml("anchor",5) +
      this.anchorDivHtml("anchor",6) +
      this.anchorDivHtml("anchor",7) +

      this.anchorDivHtml("hover",0) +
      this.anchorDivHtml("hover",1) +
      this.anchorDivHtml("hover",2) +
      this.anchorDivHtml("hover",3) +
      this.anchorDivHtml("hover",4) +
      this.anchorDivHtml("hover",5) +
      this.anchorDivHtml("hover",6) +
      this.anchorDivHtml("hover",7);
*/
    }
    


    rowspan = 3;
    if(Page.showAttributes)
     rowspan+=1;
    if(Page.showMethods)
     rowspan+=1;
      
    classInnerHtml +=
      format(
      '<table bgcolor="'+ this.displayColor+
      '" class="classTable" border="0">', this.id) +
      format(
      '  <tr class="height">' +
      '    <td rowspan="{2}"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.height,rowspan) + 
      '  <tr class="classArea">' +
      '    <td > <img src="scripts/class.png" title="Class" /> ';
    
    

    if (Page.isPhotoReady())
    {
      if (this.isInterface == "true")
      {
        classInnerHtml += format('<span>&#171interface&#187<span><br><span id="{0}_name" name="className">{1}</span>',this.id,this.name);
      }
      else if (this.isAbstract == "true")
      {
        classInnerHtml += format('<span>&#171abstract&#187<span><br><span id="{0}_name" name="className">{1}</span>',this.id,this.name);
      }
      else
      {
         classInnerHtml += format('<span id="{0}_name" name="className">{1}</span>',this.id,this.name);
      }
    }
    else
    {
      if (this.isInterface == "true")
      {
        classInnerHtml += format('<span>&#171interface&#187<span><br><span id="{0}_name" name="className" class="editable editableDoubleClick">{1}</span>',this.id, this.name);
      }
      else if (this.isAbstract == "true") 
      {
        classInnerHtml += format('<span>&#171abstract&#187<span><br><span id="{0}_name" name="className" class="editable editableDoubleClick">{1}</span>',this.id, this.name);
      }
      else
      {
        classInnerHtml += format('<span id="{0}_name" name="className" class="editable editableDoubleClick" >{1}</span>',this.id, this.name);

      }
    }
    
    classInnerHtml += ('</td> ' + '</tr>');


    if(Page.showAttributes == true)
    {  
        classInnerHtml += 
        format(
        '  <tr class="attributeArea">' +
        '    <td class="attributes">{0}' +
        '    </td>' +
        '  </tr>',attributesInnerHtml);

      }
      
    if(Page.showMethods == true)
    {
      classInnerHtml +=
      format(
      '  <tr class="methodArea">' +
      '    <td class="methods">{0}' +
      '    </td>' +
      '  </tr>',methodsInnerHtml);
    }

        classInnerHtml +=
        format(
        '  <tr class="width">' +
        '    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />' +
        '    </td>' +
        '  </tr>',this.id,this.position.width); 
 
    classInnerHtml += '</table>';
 
    var existing = classDiv.html();
    classDiv.html(classInnerHtml + existing);
  
  return classDiv;
  }
  
  this.drawableClassOutline = function()
  {
    var classSel = "#tempClass";
    var classDiv = jQuery(classSel).get();
    
    if (classDiv == undefined || classDiv == null || classDiv == "")
    {
      classDiv = jQuery("<div></div>");
      classDiv.addClass("umpleClass");
      classDiv.attr("id", this.id);
    }
    else
    {
      classDiv = jQuery(classSel);
    }

    var classInnerHtml =
      '<table class="classTable" "border="0">' +
      format(
      '  <tr class="height">' +
      '    <td rowspan="4"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.height) + 
      '  <tr class="classArea">' +
      '    <td> <img src="scripts/class.png" title="Class" /> ' +
      format(       
      '      <span id="{0}_name" name="className" >{1}</span>',this.id,this.name) +
      '    </td>' +
      '  </tr>' + 
      '  <tr class="attributeArea">' +
      '    <td class="attributes">' +
      '    </td>' +
      '  </tr>' +
      '  <tr class="width">' +
      format(
      '    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.width) + 
      '</table>';
    
    classDiv.html(classInnerHtml);
    return classDiv;
  }
  
  this.drawGeneralization = function()
  {
    
    var umpleGeneralization = null;
    var generalizationDiv = [];
    var parent = UmpleSystem.find(this.extendsClass);
    if (parent == null && this.interfaces.length == 0)
    {
      return null;
    }
    if (parent != null)
    {
      umpleGeneralization = new UmpleGeneralization();
      umpleGeneralization.childId = this.id;
      umpleGeneralization.parentId = parent.id;
      umpleGeneralization.childPosition = this.position;
      umpleGeneralization.parentPosition = parent.position;
    
      generalizationDiv[0] = umpleGeneralization.drawable();
    }

    if(this.interfaces.length > 0)
    {
      var parent_in = null;
      for (var i = 0; i < this.interfaces.length; i++)
      {
        parent_in = UmpleSystem.find(this.interfaces[i]);
        if (parent_in == null)
        {
          continue;
        }
        umpleGeneralization = new UmpleGeneralization();
        umpleGeneralization.childId = this.id;
        umpleGeneralization.parentId = parent_in.id;
        umpleGeneralization.childPosition = this.position;
        umpleGeneralization.parentPosition = parent_in.position;
    
        generalizationDiv[i+1] = umpleGeneralization.drawable();
      }
    }
    return generalizationDiv;
  }
  

  this.anchorDivHtml = function(type,index)
  {
    return format('<div id="{0}_{1}{2}" class="{3}" name="{4}" style="top: 0px; left: 0px; cursor:{5}; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,type,index,type,type,"move");
  }
  
  

}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models generalizations in the graphical view of UmpleOnline

function UmpleGeneralization()
{
  this.parentId = null;
  this.childId = null;
  this.parentPosition = null;
  this.childPosition = null;
  this.id = null;
  
  this.setClasses = function(aChildId,aParentId)
  {
    this.childId = aChildId;
    this.parentId = aParentId;
  }
  
  this.setChildId = function(aChildId)
  {
  	this.childId = aChildId;
  }
  
  this.setParentId = function(aParentId)
  {
  	this.parentId = aParentId;
  }
  
  this.getElementId = function()
  {
    return this.id == null ? "newgeneralization" : this.id;
  }
  
  this.getChildId = function()
  {
    return this.childId;
  }
  
  this.getParentId = function()
  {
    return this.parentId;
  }
  
  this.drawable = function(isPermanent)
  {
  	if (isPermanent == undefined) isPermanent = true;
  	
  	if (this.childId == null || this.childId == undefined) 
  	{
  	  return null;
  	}
  	
  	var generalizationSel = "#" + this.childId + "_generalization"; 
  	jQuery(generalizationSel).remove();
  	var generalizationDiv = jQuery("<div></div>");
  	
  	var idValue = isPermanent ? this.childId + "_generalization" : "newgeneralization";
    var classValue = "umpleGeneralization";
    generalizationDiv.attr("id", idValue);
    generalizationDiv.attr("tabindex", 2);
    generalizationDiv.addClass(classValue);
    
  	var triangleHeight = new UmplePosition(0,10,0,0); 
    var triangleBase = new UmplePosition(15,0,0,0);
    var tipLength = new UmplePosition(0,22,0,0);
    
    var lineStart = this.childPosition;
    var offsetInChild = new UmplePosition(this.childPosition.width/2,0,0,0);
    var lineEnd = this.parentPosition;
    var offsetInParent = new UmplePosition(this.parentPosition.width/2,this.parentPosition.height,0,0);
    offsetInParent = offsetInParent.add(triangleHeight).add(tipLength);
    
    lineEnd = lineEnd.add(offsetInParent);
    lineStart = lineStart.add(offsetInChild);
    
    var leftBound = this.childPosition.x;
    var rightBound = this.childPosition.x + this.childPosition.width;
    var bottomBound = this.childPosition.y + this.childPosition.height;
    var topBound = this.childPosition.y;
    var drawVertical = true;
    
    if (lineEnd.y > topBound)
    {
      if (lineEnd.y < bottomBound)
      {
      	if (Math.abs(lineEnd.x - rightBound) < Math.abs(lineEnd.x - leftBound)) 
      	{
      	  lineStart = lineStart.add(new UmplePosition(this.childPosition.width/2,0,0,0));
      	  lineStart.y = lineEnd.y;
      	  drawVertical = false;
      	}
        else 
        {
          lineStart = lineStart.subtract(new UmplePosition(this.childPosition.width/2,0,0,0));
          lineStart.y = lineEnd.y;
          drawVertical = false;
        } 	
      }
	  else {lineStart = lineStart.add(new UmplePosition(0,this.childPosition.height,0,0));}
    }
    
    var lineBreak = new UmplePosition(lineStart.x, lineEnd.y);
    if (drawVertical)
    {
      var verticalLine = new UmpleLine(lineBreak.add(UmpleClassFactory.offsetError), lineEnd.add(UmpleClassFactory.offsetError));
      var horizontalLine = new UmpleLine(lineStart.add(UmpleClassFactory.offsetError), lineBreak.add(UmpleClassFactory.offsetError));
      generalizationDiv.append(verticalLine.drawable());
    }
    else
    { 
      var horizontalLine = new UmpleLine(lineStart.add(UmpleClassFactory.offsetError), lineEnd.add(UmpleClassFactory.offsetError));
    } 
    generalizationDiv.append(horizontalLine.drawable());
    
    var tipStart = lineEnd;
    var tipEnd = lineEnd.subtract(tipLength);
    var tipLine = new UmpleLine(tipStart.add(UmpleClassFactory.offsetError),tipEnd.add(UmpleClassFactory.offsetError));
    generalizationDiv.append(tipLine.drawable());
      	
    var verticeA = tipEnd.subtract(new UmplePosition(triangleBase.x/2,0,0,0));
    var verticeB = verticeA.add(triangleBase);
    var verticeC = tipEnd.subtract(triangleHeight);
    var triangleBase = new UmpleLine(verticeA.add(UmpleClassFactory.offsetError), verticeB.add(UmpleClassFactory.offsetError));
    var triangleLeft = new UmpleLine(verticeA.add(UmpleClassFactory.offsetError), verticeC.add(UmpleClassFactory.offsetError));
    var triangleRight = new UmpleLine(verticeB.add(UmpleClassFactory.offsetError), verticeC.add(UmpleClassFactory.offsetError));
    
    generalizationDiv.append(triangleBase.drawable());
    generalizationDiv.append(triangleRight.drawable());
    generalizationDiv.append(triangleLeft.drawable());

    var hoverHtml = "";
// The following commented out to remove unneeded hovers that are not selectable anyway
// Similar code removed from UmpleClass.drawClass 
/*    var hoverOffset = new UmplePosition(3,3,0,0);
    var hoverPoint1 = lineStart.subtract(hoverOffset);
    var hoverPoint2 = tipEnd.subtract(hoverOffset);
    var hoverPoint3 = tipStart.subtract(hoverOffset);
    hoverHtml += this.anchorDivHtml("hover",0,hoverPoint1.x,hoverPoint1.y);
    hoverHtml += this.anchorDivHtml("anchor",0,hoverPoint1.x,hoverPoint1.y); 
    hoverHtml += this.anchorDivHtml("hover",1,hoverPoint2.x,hoverPoint2.y);
    hoverHtml += this.anchorDivHtml("anchor",1,hoverPoint2.x,hoverPoint2.y);
    hoverHtml += this.anchorDivHtml("hover",2,hoverPoint3.x,hoverPoint3.y);
    hoverHtml += this.anchorDivHtml("anchor",2,hoverPoint3.x,hoverPoint3.y);
*/    
    var currentHtml = generalizationDiv.html();
    generalizationDiv.html(hoverHtml + currentHtml);
    
    return generalizationDiv;
  }
  
  this.anchorDivHtml = function(type,index,x,y)
  {
    return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.childId + "_generalization",type,index,x,y);
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models history (undo stack) in UmpleOnline

History = new Object();

// capacity of the circular structure; we will reuse after cycling through
History.versionCount = 9999;
History.noChange = "//$?[No_Change]$?";

History.getInstance = function(id)
{
  var instance = new Object();

  instance.id = id;

  // History item currently on display; -1 means nothing saved.
  instance.currentIndex = -1;
  
  // Initially there is nothing saved.
  instance.oldestAvailableIndex = 0;
  instance.newestAvailableIndex = 0;

  // Initially nothing is saved.
  instance.firstSave = true;
  instance.undoButton = false;
  instance.redoButton = false;

  instance.getNextVersion = function() {return History.getNextVersion(instance)};
  instance.getPreviousVersion = function() {return History.getPreviousVersion(instance)};
  instance.save = function(umpleCode, reason) {return History.save(instance, umpleCode, reason)};
  instance.distanceBetween = function(index1, index2) {return History.distanceBetween(instance, index1, index2)};
  instance.setButtons = function() {return History.setButtons(instance)};
  instance.getVersion = function(versionNumber) {return History.getVersion(instance, versionNumber)};
  instance.setVersion = function(versionNumber, umpleCode) {return History.setVersion(instance, versionNumber, umpleCode)};
  
  return instance;
}

History.setButtons = function(instance)
{
  History.enableButtonUndo(instance, instance.undoButton);
  History.enableButtonRedo(instance, instance.redoButton);
}

History.enableButtonUndo = function(instance, value)
{
  instance.undoButton = value;
  Page.enablePaletteItem("buttonUndo", value);
}

History.enableButtonRedo = function(instance, value)
{
  instance.redoButton = value;
  Page.enablePaletteItem("buttonRedo", value);
}

// Returns the version that had been saved; called when moving forward
// using a 'redo' operation; called from Action.redo
History.getNextVersion = function(instance)
{
  History.enableButtonUndo(instance, true);
  
  var result;
  
  if (!instance.FirstSave && instance.newestAvailableIndex != instance.currentIndex)
  {
  	instance.currentIndex = History.incrementIndex(instance.currentIndex);
  	// Page.catFeedbackMessage("Set history for next to " + History.currentIndex); // DEBUG

  	result = instance.getVersion(instance.currentIndex);
  	if (result == undefined) result = History.noChange;
  } 
  else
  {
  	result = History.noChange;
  }
  
  if (instance.newestAvailableIndex == instance.currentIndex)
  {
  	History.enableButtonRedo(instance, false);
  }
  return result;
}

// Returns the previously saved version in the undo stack
// Moves the pointer back in the undo stack
// Called from Action.undo and also from save in the case of an apparent undo
History.getPreviousVersion = function(instance)
{
  var result;
  
  if (!instance.FirstSave && instance.oldestAvailableIndex != instance.currentIndex)
  {
  	instance.currentIndex = History.decrementIndex(instance.currentIndex);
  	// Page.catFeedbackMessage("Set history back to " + History.currentIndex); // DEBUG

  	result = instance.getVersion(instance.currentIndex);

  	if (result == undefined) result = History.noChange;
  	else History.enableButtonRedo(instance, true);
  }
  else
  {
    // No previously saved versions
  	result = History.noChange;
  }
  
  if (instance.oldestAvailableIndex == instance.currentIndex)
  {
    History.enableButtonUndo(instance, false);
  }
  return result;
}

// Save a new version of the code
History.save = function(instance, umpleCode, reason)
{
  // console.log("History.save() :  Saving a new version of code ...")
  if (instance.getVersion(instance.currentIndex) == umpleCode) return;

  console.log("========== saved");
  if (!instance.firstSave) 
  {
    // Whenever we save we set the highest saved index
    // So we can't redo
    History.enableButtonRedo(instance, false);
    History.enableButtonUndo(instance, true);
  } 
  
  var gap = instance.distanceBetween(instance.oldestAvailableIndex, instance.currentIndex);
  if (gap == instance.versionCount - 1)
  {
  	instance.oldestAvailableIndex = History.incrementIndex(instance.oldestAvailableIndex);
  }

  instance.currentIndex = History.incrementIndex(instance.currentIndex);
  // Page.catFeedbackMessage("Set history for new to " + History.currentIndex + " " + reason);// DEBUG

  instance.newestAvailableIndex = instance.currentIndex;
  instance.setVersion(instance.currentIndex, umpleCode);
  
  if(instance.firstSave) {
    instance.firstSave = false;
  }
}

// Find the previous index of a saved item, this
// is simply by decrementing, except if we hit zero, in which case we 
// cycle back around from versionCount.
// The result may be 'invalid' in that nothing may have bet been stored there
History.decrementIndex = function(index)
{
  var result;
  if (index == 0)
  {
  	result = History.versionCount - 1;
  }
  else 
  {
  	result = index - 1;
  }
  return result;
}

// Find the next index above the argument; loop around to zero
// if we exceed versionCount since we are using a circular structure
// The result may be 'invalid' in that nothing may have bet been stored there
History.incrementIndex = function(index)
{
  var result = (index + 1) % History.versionCount;
  return result;
}

// Retrieve the index with version versionNumber
History.getVersion = function(instance, versionNumber)
{
  var selector = "#" + "textEditorColumn";
  var requested = instance.id + "version" + versionNumber;
  
  return jQuery(selector).data(requested);
}

// Store a new version with index versionNumber
History.setVersion = function(instance, versionNumber, umpleCode)
{
  var selector = "#" + "textEditorColumn";
  var requested = instance.id + "version" + versionNumber;

  return jQuery(selector).data(requested, umpleCode);
}


History.distanceBetween = function(instance, index1, index2)
{
  if (instance.currentIndex == -1) return 0;
  
  var distance = 0;
  var i = index1;
  
  while (i != index2) 
  {
  	i = History.incrementIndex(i);
  	distance += 1;
  } 
  return distance;
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// This file holds all the functions that initialize and control the layout of the
// dynamic elements of umpleonline.

var Layout = {};
Layout.isTextVisible = true;
Layout.isDiagramVisible = true;
Layout.isPaletteVisible = true;
Layout.isLayoutVisible = false;
Layout.layoutHandler = null;
Layout.isInSmallScreenMode = false;
Layout.screenThresholdWidth = 945;

// The handles for the main layout controlling features
var canvasHandle = "#umpleCanvasColumn";
var editorHandle = "#textEditorColumn";
var modelEditorHandle = "#newEditor";
var paletteHandle = "#paletteColumn";
var layoutEditorHandle = "#bottomTextEditor";

/////////////////////////////////////
// Layout initialization functions //
/////////////////////////////////////

//Initializes any constants the layout depends on
Layout.init = function()
{
  Layout.errorMessageSpace = jQuery(".spacer").outerHeight();
  if(Layout.errorMessageSpace === null)
  {
    Layout.errorMessageSpace = 0;
  }

  var layoutQuery = this.checkLayoutNeeded();

  if(layoutQuery.layoutType === "large")
  {
    this.layoutHandler = new LargeScreenManager();
    this.isInSmallScreenMode = false;
  }
  else if(layoutQuery.layoutType === "small")
  {
    this.layoutHandler = new SmallScreenManager();
    this.isInSmallScreenMode = true;
  }
  
  this.layoutHandler.transition(true);

  jQuery(window).bind("resize", function(event)
    {
      // Stops resizing events from bubbling up from the page's resizable elements
      if(!jQuery(event.target).hasClass("ui-resizable"))
        Layout.zoomResize(); 
    });
};

Layout.checkLayoutNeeded = function() {
  if(jQuery(window).innerWidth() > jQuery(window).innerHeight() && !(jQuery("body").innerWidth()<580 && jQuery("body").innerHeight()<580) )
  {
    return {layoutType: "large"};
  }
  else
  {
    return {layoutType: "small"};
  }
};

Layout.initPaletteSize = function()
{
  this.layoutHandler.initPaletteSize();
};

// Initializes the canvas size
Layout.initUmpleCanvasSize = function()
{
  this.layoutHandler.initUmpleCanvasSize();
};

// Initializes the text editor size
Layout.initUmpleTextAreaSize = function()
{
  this.layoutHandler.initUmpleTextAreaSize();
}

///////////////////////////////////////////
// Functions to set sizes of UI elements //
///////////////////////////////////////////

Layout.setTextEditorSize = function(width, height) 
{
  this.layoutHandler.setTextEditorSize(width, height);
}

//Sets the size of the canvas. If either the height or width are undefined, they are unchanged.
Layout.setUmpleCanvasSize = function(width, height)
{
  this.layoutHandler.setUmpleCanvasSize(width, height);
}

//Sets the height of the model and layout text editors, depending on what is enabled
Layout.adjustTextEditorHeight = function(height) 
{  
  if(this.isLayoutVisible)
  {
    jQuery(modelEditorHandle).outerHeight(height*0.7);
    if(Page.codeMirrorOn) this.resizeCodeMirrorEditor(height*0.7);
    jQuery(layoutEditorHandle).outerHeight(height*0.3);
  }
  else
  {
    jQuery(modelEditorHandle).outerHeight(height);
    if(Page.codeMirrorOn) this.resizeCodeMirrorEditor(height);
  }
  jQuery(editorHandle).height(height);
}

Layout.resizeCodeMirrorEditor = function(newHeight) 
{
  if(Page.codeMirrorOn)
  {
    Page.codeMirrorEditor.getWrapperElement().style.height=newHeight+"px";
    Page.codeMirrorEditor.refresh();
  }
}

////////////////////////////////////////////
// Functions to show and hide UI elements //
////////////////////////////////////////////

Layout.showHideLayoutEditor = function(doShow)
{
  var layoutEditor = jQuery(layoutEditorHandle);
  var newHeight = jQuery(editorHandle).height();
   
  if (doShow == undefined) doShow = !this.isLayoutVisible;
  
  if (doShow)
  {
    Layout.isLayoutVisible = true;
    layoutEditor.show();
  }
  else
  {
    Layout.isLayoutVisible = false;
    layoutEditor.hide();
  }

  this.adjustTextEditorHeight(newHeight);
}

Layout.showHideTextEditor = function(doShow)
{
  var editor = jQuery(editorHandle);
  var layoutBox = jQuery("#buttonShowHideLayoutEditor");
  var layoutListItem = jQuery(".layoutListItem");
  
  if (doShow == undefined) doShow = !this.isTextVisible; 
    
  if (doShow)
  {
    editor.show();
    this.isTextVisible = true;
    // enable the show/hide layout editor option
    layoutBox.prop('disabled', false);
    layoutBox.css('cursor', 'pointer');
    layoutListItem.css('color', 'Black');
    // show the line number selector box
    jQuery("#linetext").show()
    // force reset
    Page.setUmpleCode(Page.getUmpleCode()); 
  }
  else
  {    
    editor.hide();
    this.isTextVisible = false;
    // disable the show/hide layout editor option
    layoutBox.prop('disabled', true);
    layoutBox.css('cursor', 'not-allowed');
    layoutListItem.css('color', 'DimGray');
    // hide the line number selector box
    jQuery("#linetext").hide()
  }

  // Allow layouthandler to readjust the resizable properties
  this.layoutHandler.showHideResizableAdjustment();

  //Resize the elements according to the layoutHandler
  this.layoutHandler.showHideResize();
}

Layout.showHideCanvas = function(doShow)
{ 
  var canvas = jQuery(canvasHandle);
  
  if (doShow == undefined) doShow = !this.isDiagramVisible;
  
  if (doShow)
  {
    canvas.show();
    this.isDiagramVisible = true;
    Action.manualSync = jQuery("#buttonManualSync").prop('checked');
    jQuery("#buttonShowHideCanvas").prop('checked',true);
    
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddTransition', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddAssociation');
	  Page.initToggleTool('buttonAddTransition');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
  }
  else
  {
    canvas.hide();
    this.isDiagramVisible = false;
    Action.manualSync = true; //allows editing without interruption from ajax calls
    jQuery("#buttonShowHideCanvas").prop('checked',false);
    
    Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", false);
    Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", false);
    
    Page.enablePaletteItem('buttonAddClass', false);
    Page.enablePaletteItem('buttonAddAssociation', false);
	Page.enablePaletteItem('buttonAddTransition', false);    
	Page.enablePaletteItem('buttonAddGeneralization', false);
    Page.enablePaletteItem('buttonDeleteEntity', false);
    Page.enablePaletteItem('buttonSyncDiagram', false);

    Page.removeToggleTool('buttonAddClass');
    Page.removeToggleTool('buttonAddAssociation');
	Page.removeToggleTool('buttonAddTransition');
    Page.removeToggleTool('buttonAddGeneralization');
    Page.removeToggleTool('buttonDeleteEntity');
  }
  
  //Allow layouthandler to readjust the resizable properties
  this.layoutHandler.showHideResizableAdjustment();

  //Resize the elements according to the layoutHandler
  this.layoutHandler.showHideResize();
}

Layout.showHideMenu = function(doShow)
{
  var menu = jQuery("#paletteColumn");

  if (doShow == undefined) doShow = !this.isPaletteVisible;
  if (doShow)
  {
    Layout.isPaletteVisible = true;
    menu.show();
  }
  else
  {
    Layout.isPaletteVisible = false;
    menu.hide();
  }

  this.layoutHandler.showHideResizableAdjustment();

  this.layoutHandler.showHideResize();
}

//Deals with any resize of the window. This includes browser zoom and resize within the OS.
Layout.zoomResize = function()
{ 
  var layoutQuery = this.checkLayoutNeeded();

  if(layoutQuery.layoutType === "large")
  {
    if(this.isInSmallScreenMode) this.toggleSmallScreenMode();
  }
  else if(layoutQuery.layoutType === "small")
  {
    if(!this.isInSmallScreenMode) this.toggleSmallScreenMode();
  }
  
  this.layoutHandler.adjustAfterWindowResize();
}

// A function to switch between the small and normal screen modes
Layout.toggleSmallScreenMode = function()
{ 
  if(this.isInSmallScreenMode)
  {
    this.isInSmallScreenMode = false;
    this.layoutHandler = new LargeScreenManager();
  }
  else
  {
    this.isInSmallScreenMode = true;
    this.layoutHandler = new SmallScreenManager();
  }
  
  this.layoutHandler.transition(false);
}

Layout.verticallyResizing = function(event, ui) {this.layoutHandler.verticallyResizing(event, ui);}

Layout.verticallyResized = function(event, ui) {this.layoutHandler.verticallyResized(event, ui);}

Layout.editorResizing = function(event, ui) {this.layoutHandler.editorResizing(event, ui);}

Layout.editorResized = function(event, ui) {this.layoutHandler.editorResized(event, ui);}

Layout.canvasResizing = function(event, ui) {this.layoutHandler.canvasResizing(event, ui);}

Layout.canvasResized = function(event, ui) {this.layoutHandler.canvasResized(event, ui);}

// Helper function to calculate the height of the canvas, textEditor, and palette
Layout.calculateMainHeight = function() 
{
  return jQuery(paletteHandle).outerHeight();
}

/////////////////////
// Layout Managers //
/////////////////////

// Controls the layout when the width of the screen is larger than the width threshold
function LargeScreenManager()
{
  //////////////////////////////
  // Initialization functions //
  //////////////////////////////
  
  // Called when the layout is switching to this manager from another manager
  // Also called when the Layout is initializing
  this.transition = function(firstTime)
  {
    if(!firstTime)
    {
      try {jQuery(editorHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
      try {jQuery(paletteHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
      try {jQuery(canvasHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}

      //Remove unnecessary styles
      jQuery(editorHandle).removeClass('smallScreenEditor smallScreenEditorNoMargin');
      jQuery(canvasHandle).removeClass('smallScreenCanvas smallScreenCanvasNoEditor smallScreenCanvasNoEditorNoPalette');
    }

    // Adjust the margins appropriately
    this.adjustMarginSpace();

    // reset the height-tracking factor
    this.heightFactor = 1;
  
    // set the minimum sizes
    this.minCanvasSize = new UmplePosition(0,0,420,50);
    this.minEditorSize = new UmplePosition(0,0,284,0);

    var maxEditorWidth = jQuery("body").outerWidth(true) - this.marginSpace 
      - jQuery(paletteHandle).outerWidth() - this.minCanvasSize.width;
    var maxCanvasWidth = jQuery("body").outerWidth(true) - this.marginSpace
      - jQuery(paletteHandle).outerWidth() - this.minEditorSize.width;
    
    this.maxEditorSize = new UmplePosition(0, 0, maxEditorWidth, 0);
    this.maxCanvasSize = new UmplePosition(0, 0, maxCanvasWidth, 0);

    //Allow horizontal resizing
    this.initEditorResizable();
    this.initCanvasResizable();
    
    //Allow vertical resizing
    this.initVerticalResizable();
  }
  
  //Initializes the canvas size and resizable properties
  this.initUmpleCanvasSize = function()
  {
    this.initCanvasResizable();
    this.setUmpleCanvasSize(this.minCanvasSize.width)
  }
  
  //Initializes the text editor size and resizable properties
  this.initUmpleTextAreaSize = function() 
  {
    this.initEditorResizable();
    
    // Expands the text editor to 70 characters
    this.setTextEditorSize(508, undefined);
    
    this.adjustAfterWindowResize();  
  }
  
  this.initPaletteSize = function()
  {
    jQuery("#paletteColumn").height(this.calculateHeight());
    jQuery("#palette").accordion("refresh");
    
    //Allow vertical resizing
    this.initVerticalResizable();
  }
  
  ////////////////////////////
  // Size setting functions //
  ////////////////////////////
  
  this.setTextEditorSize = function(width, height)
  {
    var umpleTextEditor = jQuery(editorHandle);
    
    if(width == undefined) width = umpleTextEditor.outerWidth();
    if(height == undefined) height = Layout.calculateMainHeight();
    
    if(width < this.minEditorSize.width) width = this.minEditorSize.width;
    else{
      if(!Layout.isDiagramVisible) width = width;
    }

    umpleTextEditor.outerWidth(width);
    
    Layout.adjustTextEditorHeight(height);


    if(Layout.isDiagramVisible){
      this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery(canvasHandle).outerWidth(), undefined);
    }
  }
  
  this.setUmpleCanvasSize = function(width, height)
  {
    var umpleCanvas = jQuery(canvasHandle);

    if(width == undefined) width = umpleCanvas.outerWidth();
    if(height == undefined) height = Layout.calculateMainHeight();
    
    if (width < this.minCanvasSize.width) width = this.minCanvasSize.width;
    if (height < this.minCanvasSize.height) height = this.minCanvasSize.height;
    if (width > this.maxCanvasSize.width && Layout.isTextVisible) width = this.maxCanvasSize.width;
    umpleCanvas.outerWidth(width);
    umpleCanvas.height(height);

    jQuery("#palette").accordion("refresh");
  }
  
  ///////////////////////////////
  // Reaction resize functions //
  ///////////////////////////////
  
  this.showHideResize = function()
  {

    //Adjust margin spacing
    this.adjustMarginSpace();
    this.adjustMaxSizes();    
      
    //Adjust sizes
    if(Layout.isDiagramVisible && !Layout.isTextVisible){
      this.setUmpleCanvasSize(this.calculateLeftoverWidth() + jQuery(canvasHandle).outerWidth(), undefined);
    }
    else{
      if(Layout.isTextVisible)
        this.setTextEditorSize(this.calculateLeftoverWidth() + jQuery(editorHandle).outerWidth(), undefined);
    }
  }

  this.showHideResizableAdjustment = function()
  {

    if(!Layout.isDiagramVisible || !Layout.isTextVisible)
    {
      try {jQuery(canvasHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
      try {jQuery(editorHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
    }
    else if(Layout.isDiagramVisible && Layout.isTextVisible)
    {
      this.initCanvasResizable();
      this.initEditorResizable();
    }

    if(jQuery(editorHandle).outerWidth() < this.minEditorSize.width || jQuery(canvasHandle).outerWidth() < this.minCanvasSize.width)
    {
      try {jQuery(canvasHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
      try {jQuery(editorHandle).resizable('destroy');}
      catch(e) {/*Already disabled*/}
    }
    else
    {
      this.initCanvasResizable();
      this.initEditorResizable();
    }

    this.adjustMaxSizes();
  }

  this.adjustMaxSizes = function()
  {
    if(Layout.isDiagramVisible && Layout.isTextVisible)
    {
      //Recalculate the max sizes of the editor and canvas
      var maxEditorWidth = jQuery("body").outerWidth(true) - this.marginSpace;

      if(Layout.isDiagramVisible)
        maxEditorWidth -= this.minCanvasSize.width;

      if(Layout.isPaletteVisible) 
        maxEditorWidth -= jQuery(paletteHandle).outerWidth();
      
      var maxCanvasWidth = jQuery("body").outerWidth(true) - this.marginSpace;

      if(Layout.isTextVisible)
        maxCanvasWidth -= this.minEditorSize.width;

      if(Layout.isPaletteVisible) 
        maxCanvasWidth -= jQuery(paletteHandle).outerWidth();
      
      this.maxEditorSize = new UmplePosition(0, 0, maxEditorWidth, 0);
      this.maxCanvasSize = new UmplePosition(0, 0, maxCanvasWidth, 0);

      if(jQuery(editorHandle).outerWidth() > this.minEditorSize.width && jQuery(canvasHandle).outerWidth() > this.minCanvasSize.width)
      {
        jQuery(editorHandle).resizable('option', 'maxWidth', this.maxEditorSize.width);
        jQuery(canvasHandle).resizable('option', 'maxWidth', this.maxCanvasSize.width);
      }
    }
    
    Action.setupPinch(); // does nothing unless there is an svg    
  }
  
  this.adjustAfterWindowResize = function()
  {

    //Adjust the max sizes of the resizables
    this.adjustMaxSizes();

    //Resize the palette height
    jQuery("#paletteColumn").height(this.calculateHeight());
    jQuery("#palette").accordion("refresh");
    
    //Resize the editor and canvas
    var leftoverWidth = this.calculateLeftoverWidth();

    if ((jQuery(canvasHandle).outerWidth() < this.minCanvasSize.width && jQuery(canvasHandle).outerWidth() + leftoverWidth >= this.minCanvasSize.width && leftoverWidth>0) || (jQuery(canvasHandle).outerWidth() + leftoverWidth <= this.minCanvasSize.width && leftoverWidth>0)){
      this.setTextEditorSize(jQuery(editorHandle).outerWidth(), undefined);
    }
    else{
      this.setTextEditorSize(leftoverWidth + jQuery(editorHandle).outerWidth(), undefined);
    }

    this.showHideResizableAdjustment();
  }
  
  ////////////////////////////////////////
  // Draggable resizing setup functions //
  ////////////////////////////////////////
  
  this.initVerticalResizable = function()
  {
    jQuery("#mainApplication").resizable({
      resize: function(event, ui){Layout.verticallyResizing(event,ui);},
      stop: function(event, ui){Layout.verticallyResized(event, ui);},
      autoHide: true,
      minHeight: this.minCanvasSize.height,
      handles: "s"
    });
  }
  
  this.initEditorResizable = function()
  {
    if(!Layout.isTextVisible || !Layout.isDiagramVisible) return;

    jQuery(editorHandle).resizable({
      start: function(event, ui){Layout.savedStartingWidth = jQuery(canvasHandle).outerWidth();},
      resize: function(event, ui){Layout.editorResizing(event, ui);},
      stop: function(event, ui){Layout.editorResized(event, ui);},
      autoHide: true,
      minWidth: this.minEditorSize.width,
      maxWidth: this.maxEditorSize.width,
      handles: "e"
    });
  }
  
  this.initCanvasResizable = function()
  {
    if(!Layout.isTextVisible || !Layout.isDiagramVisible) return;

    var canvas = jQuery(canvasHandle);
    
    canvas.resizable({
      start: function(event, ui){Layout.savedStartingWidth = jQuery(editorHandle).outerWidth();},
      resize: function(event, ui){Layout.canvasResizing(event, ui);},
      stop: function(event, ui){Layout.canvasResized(event, ui);},
      autoHide: true,
      minWidth: this.minCanvasSize.width,
      maxWidth: this.maxCanvasSize.width,
      handles: "w"
    });
  }
  
  ///////////////////////////////////////////
  // Draggable resizing handling functions //
  ///////////////////////////////////////////
  
  this.verticallyResizing = function(event, ui)
  {
    var currentHeight = ui.size.height;
    jQuery(paletteHandle).outerHeight(currentHeight);
    jQuery(editorHandle).outerHeight(currentHeight);
    jQuery(canvasHandle).outerHeight(currentHeight);
    Layout.adjustTextEditorHeight(currentHeight);
    jQuery("#palette").accordion("refresh");
  }
  
  this.verticallyResized = function(event, ui)
  {
    this.heightFactor = jQuery("#mainApplication").outerHeight()
      / (jQuery(window).innerHeight() - jQuery("#header").outerHeight() 
      - jQuery("#topLine").outerHeight() - parseInt(jQuery("body").css('marginBottom'))
      - parseInt(jQuery("body").css('marginTop')));
    
    this.setTextEditorSize(undefined, ui.size.height);
    jQuery("#mainApplication").css('height', 'auto');
  }
  
  this.editorResizing = function(event, ui)
  {
    var currentWidth = ui.size.width;
    var deltaWidth = ui.originalSize.width - currentWidth;
    jQuery(canvasHandle).outerWidth(Layout.savedStartingWidth + deltaWidth);
    jQuery(modelEditorHandle).width(currentWidth);
    jQuery(layoutEditorHandle).width(currentWidth);
  }
  
  this.editorResized = function(event, ui)
  {
    var currentWidth = ui.size.width;
    jQuery(modelEditorHandle).css('width', 'auto');
    jQuery(layoutEditorHandle).css('width', 'auto');
    this.setTextEditorSize(currentWidth, undefined);
    delete Layout.savedStartingWidth;
  }
  
  this.canvasResizing = function(event, ui)
  {
    var currentWidth = ui.size.width;

    jQuery(canvasHandle).outerWidth(currentWidth);
    var deltaWidth = currentWidth - ui.originalSize.width;
    jQuery(editorHandle).width(Layout.savedStartingWidth - deltaWidth);
    jQuery(modelEditorHandle).width(Layout.savedStartingWidth - deltaWidth);
    jQuery(layoutEditorHandle).width(Layout.savedStartingWidth - deltaWidth);
    jQuery(canvasHandle).css('left', '0px'); //Corrects the resize dragging moving the canvas right
    Action.setupPinch(); // does nothing unless there is an svg
  }
  
  this.canvasResized = function(event, ui)
  {    
    var currentWidth = ui.size.width;
    jQuery(modelEditorHandle).css('width', 'auto');
    jQuery(layoutEditorHandle).css('width', 'auto');
    this.setTextEditorSize(this.calculateLeftoverWidth() + jQuery(editorHandle).outerWidth(), undefined);
    delete this.savedStartingWidth;
  }
  
  //////////////////////
  // Helper functions //
  //////////////////////
  
  this.adjustMarginSpace = function()
  {
    jQuery(editorHandle).removeClass("largeScreenEditor largeScreenEditorNoMargin");
    jQuery(canvasHandle).removeClass("largeScreenCanvas largeScreenCanvasNoMargin");

    if(Layout.isTextVisible)
    {
      if(Layout.isDiagramVisible && Layout.isPaletteVisible)
      {
        jQuery(editorHandle).addClass("largeScreenEditor");
        jQuery(canvasHandle).addClass("largeScreenCanvas");
      }
      else if(Layout.isDiagramVisible || Layout.isPaletteVisible)
      {
        jQuery(editorHandle).addClass("largeScreenEditor");
        jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin");
      }
      else 
      {
        jQuery(editorHandle).addClass("largeScreenEditorNoMargin");
        jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin");
      }
    }
    else
    {
      jQuery(editorHandle).addClass("largeScreenEditorNoMargin");

      if(Layout.isDiagramVisible && Layout.isPaletteVisible)
      {
        jQuery(canvasHandle).addClass("largeScreenCanvas");
      }
      else
      {
        jQuery(canvasHandle).addClass("largeScreenCanvasNoMargin");
      }
    }

    // Note: the +1 in the right margin accounts for any rounding errors
    // that occur during the zoom of the page, with the least amount of 
    // visual disturbance
    this.marginSpace = parseInt(jQuery('body').css('marginLeft'))
      + parseInt(jQuery('body').css('marginRight')) + 1
      + parseInt(jQuery(canvasHandle).css("marginLeft")) 
      + parseInt(jQuery(editorHandle).css("marginRight"));
  }

  this.calculateLeftoverWidth = function() 
  { 
    var width = jQuery("body").outerWidth(true) - this.marginSpace;
    if(Layout.isTextVisible) width -= jQuery(editorHandle).outerWidth();
    if(Layout.isDiagramVisible) width -= jQuery(canvasHandle).outerWidth();
    if(Layout.isPaletteVisible) width -= jQuery(paletteHandle).outerWidth();
    return width;
  }
  
  this.calculateHeight = function()
  {
    var tabHeight = TabControl.isHidden() ? 0 : jQuery("#tabControl").outerHeight();
    var taskAreaHeight = jQuery("#taskArea").css("display") == "none" ? 0 : jQuery("#taskArea").outerHeight();
    if (taskAreaHeight > jQuery(window).innerHeight()/2)
    {
      taskAreaHeight =0;
    }
    var newHeight = (jQuery(window).innerHeight() - jQuery("#header").outerHeight() 
      - jQuery("#topLine").outerHeight() - tabHeight - parseInt(jQuery("body").css('marginBottom'))
      - parseInt(jQuery("body").css('marginTop')) - Layout.errorMessageSpace) * this.heightFactor - taskAreaHeight;
    
    if(newHeight < this.minCanvasSize.height)
      return this.minCanvasSize.height;
    else
      return newHeight;
  }
}

//Controls the layout when the width of the screen is smaller than the width threshold
function SmallScreenManager()
{  
  //////////////////////////////
  // Initialization functions //
  //////////////////////////////
  
  //Called when the layout is switching to this manager from another manager
  this.transition = function(firstTime)
  {
    if(!firstTime)
    {
      //Reset any resizables
      try {jQuery(editorHandle).resizable('destroy');}
      catch (e) {/*already disabled*/}
      try {jQuery(canvasHandle).resizable('destroy');}
      catch (e) {/*already disabled*/}
      try {jQuery("#mainApplication").resizable('destroy');}
      catch (e) {/*already disabled*/};
      
      //Remove the other styles
      jQuery(editorHandle).removeClass('largeScreenEditor largeScreenEditorNoMargin');
      jQuery(canvasHandle).removeClass('largeScreenCanvas largeScreenCanvasNoMargin');
    }

    this.adjustMarginSpace();

    this.minCanvasSize = new UmplePosition(0,0,420,50);
    this.minEditorSize = new UmplePosition(0,0,284,0);
    
    this.initEditorResizable();
    this.initCanvasResizable();
    this.initPaletteResizable();
  }
  
  this.initUmpleCanvasSize = function()
  {
    this.setUmpleCanvasSize(undefined, this.calculateHeight());
    this.initCanvasResizable();
    this.initPaletteResizable();
    if (Layout.isDiagramVisible==false) {Layout.showHideCanvas(false);}
  }
  
  this.initUmpleTextAreaSize = function() 
  {
    this.setTextEditorSize();
    this.initEditorResizable();
  }
  
  this.initPaletteSize = function()
  {
    jQuery("#paletteColumn").outerHeight(this.calculateHeight());
    jQuery("#palette").accordion("refresh");
  }
  
  ////////////////////////////
  // Size setting functions //
  ////////////////////////////
  
  this.setTextEditorSize = function(width, height)
  {
    var width = this.calculateLeftoverWidth();

    // This -1 exists to deal with any rounding errors that may occur during zooming
    // It ensures the layout does not float down in the page
    if(Layout.isPaletteVisible)
    {
      jQuery(editorHandle).outerWidth(width);
    }
    else
    {
      jQuery(editorHandle).outerWidth(width);
    }
    
    if(height != undefined)
      Layout.adjustTextEditorHeight(height);
    else
      Layout.adjustTextEditorHeight(this.calculateHeight());
  }
  
  this.setUmpleCanvasSize = function(width, height)
  {
    if (Layout.isTextVisible)
      jQuery(canvasHandle).outerWidth(jQuery("body").width());
    else
      jQuery(canvasHandle).outerWidth(this.calculateLeftoverWidth());
    
    if(height != undefined)
    {
      jQuery(canvasHandle).outerHeight(height);
    }
  }
  
  ///////////////////////////////
  // Reaction resize functions //
  ///////////////////////////////

  this.showHideResize = function()
  {
    var canvasHeight = undefined;

    this.adjustMarginSpace();

    if(Layout.isTextVisible)
    {
      this.setTextEditorSize(undefined, jQuery(paletteHandle).outerHeight());
    }
    else
    {
      canvasHeight = jQuery(paletteHandle).outerHeight();
    }
    
    jQuery("#palette").accordion('refresh');
    this.pairResizables();
    this.setUmpleCanvasSize(undefined, canvasHeight);
  }

  this.showHideResizableAdjustment = function() {} //unused function

  this.adjustAfterWindowResize = function()
  {   
    jQuery("#paletteColumn").outerHeight(this.calculateHeight());
    jQuery("#palette").accordion("refresh");
    
    this.setTextEditorSize();
    this.setUmpleCanvasSize(undefined, this.calculateHeight());
  }
  
  ////////////////////////////////////////
  // Draggable resizing setup functions //
  ////////////////////////////////////////
  
  this.initEditorResizable = function()
  { 
    jQuery(editorHandle).resizable({
      autoHide: true,
      minHeight: 30,
      handles: "s"
    });
    
    this.pairResizables();
  }
  
  this.initPaletteResizable = function()
  {
    jQuery(paletteHandle).resizable({
      autoHide: true,
      minHeight: 30,
      handles: "s"
    });
    
    this.pairResizables();
  }
  
  this.initCanvasResizable = function()
  {
    jQuery(canvasHandle).resizable({
      autoHide: true,
      minHeight: 30,
      handles: "s"
    });
    
    this.pairResizables();
  }
  
  ///////////////////////////////////////////
  // Draggable resizing handling functions //
  ///////////////////////////////////////////
  
  //Resizing the palette
  this.verticallyResizing = function(event, ui)
  {
    jQuery(paletteHandle).outerHeight(ui.size.height);
    jQuery("#palette").accordion("refresh");
  }
  
  this.verticallyResized = function(event, ui) {} //Unused function
  
  //Resizing the text editor
  this.editorResizing = function(event, ui)
  {
    Layout.adjustTextEditorHeight(ui.size.height);
  }
  
  this.editorResized = function(event, ui) {} //Unused function
  
  //Resizing the canvas
  this.canvasResizing = function(event, ui)
  {
    jQuery(canvasHandle).outerHeight(ui.size.height);
  }
  
  this.canvasResized = function(event, ui) {} //Unused function
  
  //////////////////////
  // Helper functions //
  //////////////////////
  
  this.adjustMarginSpace = function()
  {
    jQuery(canvasHandle).removeClass('smallScreenCanvas smallScreenCanvasNoEditor smallScreenCanvasNoEditorNoPalette');
    jQuery(editorHandle).removeClass('smallScreenEditor smallScreenEditorNoMargin');

    if(Layout.isTextVisible)
    {
      jQuery(canvasHandle).addClass('smallScreenCanvas');
      if(Layout.isPaletteVisible)
      {
        jQuery(editorHandle).addClass('smallScreenEditor');
      }
      else
      {
        jQuery(editorHandle).addClass('smallScreenEditorNoMargin');
      }
    }
    else
    {
      jQuery(editorHandle).addClass('smallScreenEditorNoMargin');
      if(Layout.isPaletteVisible && Layout.isDiagramVisible)
      {
        jQuery(canvasHandle).addClass('smallScreenCanvasNoEditor');
      }
      else
      {
        jQuery(canvasHandle).addClass('smallScreenCanvasNoEditorNoPalette');
      }
    }

    this.marginSpace = parseInt(jQuery('body').css('marginLeft')) 
    + parseInt(jQuery('body').css('marginRight')) + 1
    + parseInt(jQuery(editorHandle).css('marginRight'))
    + parseInt(jQuery(canvasHandle).css('marginLeft'));
  }

  this.calculateLeftoverWidth = function() 
  {
    if(Layout.isPaletteVisible)
    {
      return jQuery("body").outerWidth(true) - this.marginSpace 
        - jQuery(paletteHandle).outerWidth();
    }
    else
    {
      return jQuery("body").outerWidth(true) - this.marginSpace;
    }
  }
  
  this.calculateHeight = function()
  {
    var tabHeight = TabControl.isHidden() ? 0 : jQuery("#tabControl").outerHeight(); 
    var taskAreaHeight = jQuery("#taskArea").css("display") == "none" ? 0 : jQuery("#taskArea").outerHeight();
    if (taskAreaHeight > jQuery(window).innerHeight()/2)
    {
      taskAreaHeight =0;
    }
    var height = (jQuery(window).innerHeight() - jQuery("#header").outerHeight(true)
      - 2*jQuery("#topLine").outerHeight(true) - tabHeight - Layout.errorMessageSpace)/2 - taskAreaHeight;

    return height;
  }
  
  this.pairResizables = function()
  {
    if(!jQuery(editorHandle).is('.ui-resizable')
        || !jQuery(paletteHandle).is('.ui-resizable')
        || !jQuery(canvasHandle).is('.ui-resizable'))
    {
      return;
    }
    
    if(Layout.isTextVisible)
    { //if the text editor is visible, the palette will be resized with it
      //Resizing functions
      var textEditorResizingFunction = function(event, ui)
      {
        Layout.editorResizing(event, ui);
        Layout.verticallyResizing(event, ui);
      };
      var paletteResizingFunction = textEditorResizingFunction;
      var canvasResizingFunction = function(event, ui) { Layout.canvasResizing(event, ui); };
      
      //Resized functions
      var textEditorResizedFunction = function(event, ui)
      {
        Layout.editorResized(event, ui);
        Layout.verticallyResized(event, ui);
      };
      var paletteResizedFunction = textEditorResizedFunction;
      var canvasResizedFunction = function(event,ui) { Layout.canvasResized(event, ui); };
    }
    else
    { //if the text editor is not visible, the palette will be resized with the canvas
      //Resizing functions
      var textEditorResizingFunction = function(event, ui) { Layout.editorResizing(event,ui); };
      var canvasResizingFunction = function(event, ui) 
      { 
        Layout.canvasResizing(event, ui); 
        Layout.verticallyResizing(event, ui);
      };
      var paletteResizingFunction = canvasResizingFunction;
      
      //Resized functions
      var textEditorResizedFunction = function(event, ui) { Layout.editorResized(event, ui); };
      var canvasResizedFunction = function(event,ui) 
      { 
        Layout.canvasResized(event, ui); 
        Layout.verticallyResized(event, ui);
      };
      var paletteResizedFunction = canvasResizedFunction;
    }
    
    jQuery(editorHandle).resizable('option', 'resize', textEditorResizingFunction);
    jQuery(editorHandle).resizable('option', 'stop', textEditorResizedFunction);
    jQuery(paletteHandle).resizable('option', 'resize', paletteResizingFunction);
    jQuery(paletteHandle).resizable('option', 'stop', paletteResizedFunction);
    jQuery(canvasHandle).resizable('option', 'resize', canvasResizingFunction);
    jQuery(canvasHandle).resizable('option', 'stop', canvasResizedFunction);
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Drawing lines in the graphical view of UmpleOnline

function UmpleLine(pointA, pointB)
{
  this.pointOne = pointA;
  this.pointTwo = pointB;

  this.drawable = function(offset)
  {
    var line = jQuery("<div class='umpleLine'></div>");

    var start = UmplePositionFactory.copy(this.pointOne);
    var end = UmplePositionFactory.copy(this.pointTwo);
    
    if (typeof(offset) != "undefined")
    {
      start.x = start.x + offset.x;
      start.y = start.y + offset.y;
      end.x = end.x + offset.x;
      end.y = end.y + offset.y;
    }
  
    var i=0;
    if (start.y == end.y)
    {
      var point = start.x < end.x ? start : end;
      var width = Math.abs(end.x - start.x);

      line.append(this.createConnector(point.x,point.y,width,1));
      line.append(this.createSelector(point.x,point.y,width,6));
    
      return line;
    }
    else if (start.x == end.x)
    {
      var point = start.y < end.y ? start : end;
      var height = Math.abs(end.y - start.y);
    
      line.append(this.createConnector(point.x,point.y,1,height));
      line.append(this.createSelector(point.x,point.y,6,height));
    
    return line;
    }
  
    var slope = this.slope();
    var xDelta = end.x > start.x ? 1 : -1;
    var yDelta = xDelta * slope;
    if (Math.abs(slope) > 1)
    {
      yDelta = end.y > start.y ? 1 : -1;
      xDelta = yDelta * (1 / slope);
    }
  
    var counter = 0;
    var y = start.y;
    for (var x = start.x; (x <= end.x && xDelta > 0) || (x >= end.x && xDelta < 0); x+=xDelta)
    {
      if (counter++ > 1000) break;
    
      line.append(this.createConnector(x,y,1,1));
      line.append(this.createSelector(x,y,6,6));
      y += yDelta;
      i++;
    }
  
    return line;
  }

  this.slope = function()
  {
    slope = (this.pointTwo.y - this.pointOne.y) / (this.pointTwo.x - this.pointOne.x); 
    return slope;
  }

  this.length = function()
  {
    var a = this.pointTwo.x - this.pointOne.x;
    var b = this.pointTwo.y - this.pointOne.y;
    var c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    return Math.round(c);
  }

  this.createConnector = function(x,y,width,height)
  {
    var connector = jQuery("<div></div>");
    connector.addClass("umpleAssociation");
    connector.attr("name", this.startId);
    connector.css({"position":"absolute", "left":x, "top":y, "width":width, "height":height});
  
    return connector;
  }

  this.createSelector = function(x,y,width,height)
  {
    var selector = jQuery("<div></div>");
    selector.addClass("umpleAssociationSelector");
    selector.attr("name", this.startId);
    selector.css({"position":"absolute", "left":x, "top":y, "width":width, "height":height});
   
    return selector;
  }

  this.intersection = function(otherLine)
  {
    var x1 = this.pointOne.x;
    var y1 = this.pointOne.y;
    var x2 = this.pointTwo.x;
    var y2 = this.pointTwo.y;
  
    var x3 = otherLine.pointOne.x;
    var y3 = otherLine.pointOne.y;
    var x4 = otherLine.pointTwo.x;
    var y4 = otherLine.pointTwo.y;
  
    var slope1 = this.slope();
    var slope2 = otherLine.slope();
    
    var intersectX = null;
    var intersectY = null;
    var yIntercept1 = null;
    var yIntercept2 = null;
    var found = false;
    
    if (slope1 == slope2) 
    {
      return null;
    }
    
    if (slope1 == Infinity || slope1 == -Infinity)
    {
      yIntercept2 = y3 - slope2*x3;
      intersectX = x1;
      intersectY = slope2*intersectX + yIntercept2;
      found = true;
    }
    else if (slope2 == Infinity || slope2 == -Infinity)
    {
      yIntercept1 = y1 - slope1*x1;
      intersectX = x3;
      intersectY = slope1*intersectX + yIntercept1;
      found = true;
    }
    
    if (!found)
    {
      yIntercept1 = y1 - slope1*x1;
      yIntercept2 = y3 - slope2*x3;
    
      intersectX = (yIntercept2 - yIntercept1) / (slope1 - slope2);
      intersectY = slope1*intersectX + yIntercept1;
    }
    
    var largerX1 = (x2 > x1)? x2 : x1;
    var largerX2 = (x4 > x3)? x4 : x3;
    var largerY1 = (y2 > y1)? y2 : y1;
    var largerY2 = (y4 > y3)? y4 : y3;
    var smallerX1 = (largerX1 == x2) ? x1 : x2;
    var smallerX2 = (largerX2 == x4) ? x3 : x4;
    var smallerY1 = (largerY1 == y2) ? y1 : y2;
    var smallerY2 = (largerY2 == y4) ? y3 : y4;
    
    if (intersectX < smallerX1 || intersectX < smallerX2  ||
        intersectX > largerX1  || intersectX > largerX2   ||
        intersectY < smallerY1 || intersectY < smallerY2  ||
        intersectY > largerY1  || intersectY > largerY2) 
    {
  	  return null;
    }
  
    intersectX = Math.round(intersectX);
    intersectY = Math.round(intersectY);
    
    return new UmplePosition(intersectX,intersectY,0,0);
  }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models methods in the graphical view of UmpleOnline

UmpleMethodFactory = new Object();

UmpleMethodFactory.create = function(data)
{
  var umpleMethod = new UmpleMethod(data.visibility, data.isAbstract, data.type, data.name, data.parameters);
  return umpleMethod;
}

function UmpleMethod(aVisibility, isAbstract, aType, aName, theParameters)
{
  this.visibility = aVisibility;
  this.isAbstract = isAbstract;
  this.type = aType;
  this.name = aName;
  this.parameters = (typeof(theParameters) == "string" ? theParameters.split(",") : theParameters);
  //console.log(typeof(theParameters) + ":" + theParameters);
  //console.log(typeof(this.parameters) + ":" + this.parameters);
  //Had to resort to this cheap hack. I have no idea why it was sometimes an array and sometimes a String


  this.set = function(input)
  {
    var isExisting = (this.name != "");

    if (isExisting)
    {
      this.oldVisibility = this.visibility;
      this.oldType = this.type;
      this.oldName = this.name;
      this.oldParameters = this.parameters;
    }

    input = input.trim();
    var sign = input.charAt(0);

    if(sign == "+")
    {
      this.visibility = "public";
      input = input.substr(1);
    }
    else if(sign == "-")
    {
      this.visibility = "private";
      input = input.substr(1);
    }
    else if(sign == "#")
    {
      this.visibility = "protected";
      input = input.substr(1);
    }
    else
      this.visibility = "public";    

    var data = input.split(":");

    if (data.length < 2)
    {
      this.type = "void";
      this.name = input.substring(0,input.indexOf("(")).trim();
      this.parameters = input.match("\\((.*)\\)")[1].replace(/\s+/g, "").split(",");
    }
    else
    {
      var nameandargs = data[0].trim();
      this.type = data[1].trim();
      this.name = nameandargs.substring(0,nameandargs.indexOf("(")).trim();
      this.parameters = nameandargs.match("\\((.*)\\)")[1].replace(/\s+/g, "").split(",");
      
    }
    if (!isExisting)
    {
      this.newVisibility = this.visibility;
      this.newType = this.type;
      this.newName = this.name;
      this.newParameters = this.parameters;
    }

  }

  this.copy = function()
  {
    return new UmpleMethod(this.visibility, this.type, this.name, this.parameters);
  }





}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Initializing and maintaining the features on the screen in UmpleOnline
// Layout initialization and maintenance is located in umple_layout.js.

Page = new Object();

// Refactoring definitive text location
Page.currentUmpleTextBeingEdited = "";

Page.selectedItem = null;
Page.selectedClass = null;
Page.selectedAssociation = null;
Page.selectedTransition = null;
Page.selectedGeneralization = null;
Page.canEditTask = false;
Page.canCreateTask = true;
Page.codeEffect = null;
Page.clickCount = 0;
Page.repeatToolItem = false;
Page.shortcutsEnabled = true;
Page.diagramSyncNeededAppend = false;
Page.modelDelimiter = "//$?[End_of_model]$?";

Page.codeMirrorOn = false;
Page.codeMirrorEditor = null;
Page.codeMirrorEditor6 = null;
Page.hLine = null;

Page.modelLoadingCount = 0;
Page.layoutLoadingCount = 0;
Page.canvasLoadingCount = 0;
Page.onLoadingCompleteCallbacks = [];

// Global options
Page.readOnly = false; // initially allow editing
Page.useEditableClassDiagram = true;
Page.useGvClassDiagram = false;
Page.useGvStateDiagram = false;
Page.useGvFeatureDiagram = false;
Page.showFeatureDependency = false;
Page.useStructureDiagram = false;
Page.useFeatureDiagram = false;
Page.showAttributes = true;
Page.showMethods = false;
Page.showActions = true;
Page.showText = true;
Page.showCanvas = true;
Page.showTraits = false;
Page.showTransitionLabels = false;
Page.showGuardLabels = false;
Page.showGuards = true;
Page.modifiedDiagrams = false;
Page.allowPinch = false;

  Page.blahblah = function (theString) {
    console.log("In blah blah "+theString);
  }



// The following is set called from umple.php
Page.init = function(doShowDiagram, doShowText, doShowMenu, doReadOnly, doShowLayout, diagramType,generateDefault, doLoadTask, doEditTask, doCreateTask)
{ 
  if(performance.navigation.type == 2)
  {
    location.reload(true);
  }
  Page.canEditTask = doEditTask;
  Page.canCreateTask = doCreateTask;
  Layout.isDiagramVisible = doShowDiagram;  
  Layout.isTextVisible = doShowText;  
  Layout.isPaletteVisible = doShowMenu;  
  Layout.isLayoutVisible = doShowLayout;
  Page.readOnly = doReadOnly;

  TabControl.init();
  jQuery(".layoutListItem").hide();

  // Set diagram type - anything else means use the default editable class diagram
  if(diagramType == "GvState")   
  { 
    Page.useGvStateDiagram = true;
    Page.useEditableClassDiagram = false; 
    Page.setDiagramTypeIconState('GvState');
    Page.useGvFeatureDiagram = false;
    jQuery(".view_opt_state").show();

  }
  else if(diagramType == "GvClass")   
  {
    Page.useGvClassDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.setDiagramTypeIconState('GvClass');
    Page.useGvFeatureDiagram = false;
    jQuery(".view_opt_class").show();

  }
  else if(diagramType == "GvClassTrait")   
  {
    Page.useGvClassDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.setDiagramTypeIconState('GvClass');
    Page.useGvFeatureDiagram = false;
    Page.showTraits=true;
    jQuery(".view_opt_class").show();
  } 
  else if(diagramType == "GvFeature")   
  {
    Page.useGvFeatureDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.setDiagramTypeIconState('GvFeature');
    jQuery(".view_opt_feature").show();

  }
  else if(diagramType == "structureDiagram")
  {
    Page.useStructureDiagram = true;
    Page.useEditableClassDiagram = false;  
    Page.setDiagramTypeIconState('structureDiagram');
    Page.useGvFeatureDiagram = false;
  }
  else
  {
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }

  jQuery.noConflict();
  jQuery(document).keydown(function(event){Action.keyboardShortcut(event);});
  
  Layout.init();
  Page.initPaletteArea();
  Page.initCanvasArea();
  Page.initUmpleTextArea();
  Page.initSourceCodeArea();
  Page.initCodeExecutionArea();
  jQuery(document).ready(function() {
    DropboxInitializer.initializeDropbox();
    ToolTips.initTooltips();
  });

  if(Page.readOnly) {jQuery("#" + Page.umpleCanvasId()).addClass("photoReady");}

  Action.loadFile();
  if (doLoadTask)
  {
    Action.loadTask(jQuery("#model").val().split("-")[1], true); // load task instruction
  }
  
  jQuery(generateDefault).prop("selected",true);
};

Page.initPaletteArea = function()
{
  var palette = "#palette";
  var paletteItems = palette + " *";
  jQuery(palette).accordion({heightStyle: "fill", fillSpace: true, active: 1, collapsible: true});
  jQuery(paletteItems).addClass("unselectable");
  
  Layout.initPaletteSize();
  
  Page.initJQueryButton("buttonGenerateCode");
  Page.initJQueryButton("buttonExecuteCode");
  Page.initJQueryButton("buttonStartOver");
  Page.initJQueryButton("buttonShowRefreshUmpleOnlineCompletely")
  Page.initJQueryButton("buttonLoadBlankModel");
  
  Page.initHighlighter("buttonAddClass");
  Page.initHighlighter("buttonAddAssociation");
  Page.initHighlighter("buttonAddTransition");
  Page.initHighlighter("buttonAddGeneralization");
  Page.initHighlighter("buttonDeleteEntity");
  Page.initHighlighter("buttonPngImage");
  Page.initHighlighter("buttonYumlImage");
  Page.initHighlighter("buttonSimulateCode");
  Page.initHighlighter("buttonUigu");
  Page.initHighlighter("buttonCopyClip");
  Page.initHighlighter("buttonCopy");
  Page.initHighlighter("buttonCopyEncodedURL");
  Page.initHighlighter("buttonCopyCommandLine");
  Page.initHighlighter("buttonCopyLocalBrowser");
  Page.initHighlighter("buttonLoadLocalBrowser");
  if (Page.canEditTask)
  {
    //Page.initHighlighter("buttonEditTask");
    //Page.initHighlighter("buttonLoadThisTask");
    Page.initHighlighter("buttonRequestAllZip");
    Page.initHighlighter("buttonRequestLoadTaskURL");
  }
  if (Page.canCreateTask)
  {
    Page.initHighlighter("buttonCreateTask");
  }
  Page.initHighlighter("buttonLoadTask")
  
  Page.initHighlighter("buttonDownloadFiles");
  Page.initHighlighter("buttonSmaller");
  Page.initHighlighter("buttonLarger");
  Page.initHighlighter("buttonSyncCode");
  Page.initHighlighter("buttonSyncDiagram");
  Page.initHighlighter("buttonToggleMethods");
  Page.initHighlighter("buttonToggleAttributes");
  Page.initHighlighter("buttonToggleActions");
  Page.initHighlighter("buttonToggleTransitionLabels");
  Page.initHighlighter("buttonToggleGuards");
  Page.initHighlighter("buttonToggleGuardLabels");
  Page.initHighlighter("buttonToggleTraits");
  Page.initHighlighter("buttonToggleFeatureDependency");
  Page.initHighlighter("buttonallowPinch");
  Page.initHighlighter("buttonReindent");
  
  Page.initToggleTool("buttonAddClass");
  Page.initToggleTool("buttonAddAssociation");
  Page.initToggleTool("buttonAddTransition");
  Page.initToggleTool("buttonAddGeneralization");
  Page.initToggleTool("buttonDeleteEntity");
   
  Page.initAction("buttonPngImage");
  Page.initAction("buttonYumlImage");
  Page.initAction("buttonPhpCode");
  Page.initAction("buttonEcoreCode");  
  Page.initAction("buttonJavaCode");
  Page.initAction("buttonJavaAPIDoc");
//  Page.initAction("buttonZip");
  Page.initAction("buttonRubyCode");
  Page.initAction("buttonAlloyCode");
  Page.initAction("buttonNuSMVCode");
  Page.initAction("buttonSqlCode");
  Page.initAction("buttonCppCode");
  Page.initAction("buttonPhotoReady");
  Page.initAction("buttonSimulateCode");
  Page.initAction("buttonShowHideTextEditor");
  Page.initAction("buttonShowHideCanvas");
  Page.initAction("buttonShowEditableClassDiagram");
  Page.initAction("buttonShowJointJSClassDiagram");
    
  Page.initAction("buttonShowGvClassDiagram");
  Page.initAction("buttonShowGvStateDiagram");
  Page.initAction("buttonShowGvFeatureDiagram");//buttonShowGvFeatureDiagram
  Page.initAction("buttonShowStructureDiagram");
  Page.initAction("buttonShowHideLayoutEditor");
  Page.initAction("buttonManualSync");
  Page.initAction("buttonCopyClip");
  Page.initAction("buttonCopy");
  Page.initAction("buttonCopyEncodedURL");
  Page.initAction("buttonCopyCommandLine");
  Page.initAction("buttonCopyLocalBrowser");
  Page.initAction("buttonLoadLocalBrowser");
  if (Page.canEditTask)
  {
    //Page.initAction("buttonEditTask");
    //Page.initAction("buttonLoadThisTask");
    Page.initAction("buttonRequestAllZip");
    Page.initAction("buttonRequestLoadTaskURL");
  }
  if (Page.canCreateTask)
  {
    Page.initAction("buttonCreateTask");
  }
  Page.initAction("buttonLoadTask");

  Page.initAction("buttonDownloadFiles");
  Page.initAction("buttonUndo");
  Page.initAction("buttonRedo");
  Page.initAction("buttonReindent");
  Page.initAction("buttonUigu");
  Page.initAction("buttonStartOver");
  Page.initAction("buttonShowRefreshUmpleOnlineCompletely");
  Page.initAction("buttonLoadBlankModel");
  Page.initAction("buttonGenerateCode");
  Page.initAction("buttonExecuteCode");
  Page.initAction("buttonTabsCheckbox");
  Page.initAction("buttonSmaller");
  Page.initAction("buttonLarger");
  Page.initAction("buttonSyncCode");
  Page.initAction("buttonSyncDiagram");
  Page.initAction("buttonToggleMethods");
  Page.initAction("buttonToggleAttributes");
  Page.initAction("buttonToggleActions");
  Page.initAction("buttonToggleTraits");
  Page.initAction("buttonToggleFeatureDependency");
  Page.initAction("buttonToggleTransitionLabels");
  Page.initAction("buttonToggleGuards");
  Page.initAction("buttonToggleGuardLabels");
  Page.initAction("buttonAllowPinch");
    
  Page.initLabels();

  Page.enablePaletteItem("buttonUndo", false);
  Page.enablePaletteItem("buttonRedo", false);
  Page.enablePaletteItem("buttonSyncDiagram", false);
  Page.enablePaletteItem("buttonAddTransition", false);

  jQuery("#genstatus").hide();
  jQuery("#buttonViewComplete").hide();
  
  Page.initExamples();
  Page.initOptions();
  if(Page.readOnly) {
    jQuery("#mainDrawMenu").hide();
    jQuery(".layoutListItem").hide();
    jQuery("#preferencesTitle").hide();
    jQuery("#ttPhotoReady").hide();
    jQuery("#ttManualSync").hide();
    jQuery("#canvasSizeTitle").hide();
    jQuery("#buttonSmaller").hide();
    jQuery("#buttonLarger").hide();
    jQuery("#menuBookmarkable").hide();
  }
  if(Page.readOnly || !Layout.isPaletteVisible) {  
    jQuery("#topBookmarkable").hide();
  }
  if(!Layout.isPaletteVisible) {jQuery("#paletteColumn").hide();}
  if(!Layout.isTextVisible) {
    if(Page.readOnly) {
      jQuery("#topLine").hide(); 
    }
    else {
      jQuery("#linetext").hide();
    }
  }

  // Only show execute code button for the Java language
  jQuery("#inputGenerateCode").on('change', function() {
    if(this.value.split(":")[1] === 'Java' || this.value.split(":")[1] === 'Python') {
      jQuery("#buttonExecuteCode").show();
    } else {
      jQuery("#buttonExecuteCode").hide();
    }
  })
}

Page.initOptions = function()
{
  jQuery("#buttonShowHideLayoutEditor").prop('checked', Layout.isLayoutVisible);
  jQuery("#buttonShowHideTextEditor").prop('checked', Layout.isTextVisible);
  jQuery("#buttonShowHideCanvas").prop('checked', Layout.isDiagramVisible);
	jQuery("#buttonTabsCheckbox").prop('checked', false);
	jQuery("#tabRow").hide();
	jQuery("#ttTabsCheckbox").hide();
  jQuery("#buttonToggleAttributes").prop('checked',true);
  jQuery("#buttonToggleActions").prop('checked',true);
  jQuery("#buttonToggleTransitionLabels").prop('checked',false);
  jQuery("#buttonToggleGuards").prop('checked',true);  
  jQuery("#buttonToggleGuardLabels").prop('checked',false);
  jQuery("#buttonToggleTraits").prop('checked',Page.showTraits);
  jQuery("#buttonToggleFeatureDependency").prop('checked',false);
  jQuery("#buttonAllowPinch").prop('checked',false);
  
  if(Page.useEditableClassDiagram)
   jQuery("#buttonShowEditableClassDiagram").prop('checked', true);
  if(Page.useJointJSClassDiagram)
   jQuery("#buttonShowJointJSClassDiagram").prop('checked', true);
  if(Page.useGvClassDiagram)
    jQuery("#buttonShowGvClassDiagram").prop('checked', true);
  if(Page.useGvFeatureDiagram)
    jQuery("#buttonShowGvFeatureDiagram").prop('checked', true);

  if(Page.useGvStateDiagram)
    jQuery("#buttonShowGvStateDiagram").prop('checked', true);
  if(Page.useStructureDiagram)
    jQuery("#buttonShowStructureDiagram").prop('checked', true);

  jQuery("#buttonPhotoReady").prop('checked', false);
  jQuery("#buttonManualSync").prop('checked', false);
  
  jQuery("#buttonShowHideTextEditor").prop('disabled', false);
  jQuery("#buttonShowHideCanvas").prop('disabled', false);
  jQuery("#buttonPhotoReady").prop('disabled', false);
  jQuery("#buttonManualSync").prop('disabled', false);
}

Page.initHighlighter = function(id)
{
  var selector = "#" + id;
  jQuery(selector).mouseover(function() {Page.highlightItem(id);});
  jQuery(selector).mouseout(function() {Page.unhighlightItem(id);});
}

Page.removeHighlighter = function(id)
{
  var selector = "#" + id;
  
  jQuery(selector).unbind('mouseover');
  jQuery(selector).unbind('mouseout');
}

Page.enableCheckBoxItem = function(boxId, listItemId, doEnable)
{
  var listItem = jQuery("#" + listItemId);
  var checkbox = jQuery("#" + boxId);
  
  if (doEnable)
  {
    checkbox.prop('disabled', false);
    checkbox.css('cursor', 'pointer');
    listItem.css('color', 'Black');
    
  }
  else
  {
    checkbox.prop('disabled', true);
    checkbox.css('cursor', 'not-allowed');
    listItem.css('color', 'Silver');
  }
}

Page.enablePaletteItem = function(id, doEnable)
{
  var item = jQuery("#" + id);
  var enabled = !item.hasClass("disabled");
  
  if (enabled == doEnable) return;
  
  if (doEnable)
  {
    item.removeClass();
    item.prop('disabled', true);
    Page.initHighlighter(id);
  }
  else
  {
    item.removeClass();
    item.addClass("disabled");
    item.prop('disabled', false);
    Page.removeHighlighter(id);
  }
}

Page.initToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.unbind().click(function() {Page.toggleToolItem(id, false);});
  item.dblclick(function() {Page.toggleToolItem(id, true);});
}

Page.removeToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.unbind('click');
  item.unbind('dblclick');
}

Page.initJQueryButton = function(id)
{
  var selector = "#" + id;
  var value = jQuery(selector).attr("value");
  jQuery(selector).button({
    label: value,
    className: "jQuery-palette-button"
  });
}

Page.initAction = function(id)
{
  var selector = "#" + id;
  jQuery(selector).click(Action.clicked);
}

// Binds the label text on buttons to the button action
// Allows the user to click the label or the actual button
Page.initLabels = function()
{
  var labels = jQuery(".buttonExtend");
  
  for(var i = 0, len = labels.length; i < len; i++)
  {
    var labelId = "#" + jQuery(labels[i]).prop("id");
    jQuery(labelId).click(function(x) {
      return function() {
        jQuery("#" + jQuery(x).prop("id").replace("label", "button")).trigger('click');
      }
    }(labelId));
  }
}

// BOOKMARK: adding basic event handlers to model and layout editors:: calls to Action...
Page.initUmpleTextArea = function()
{
  var modelEditor = jQuery("#umpleModelEditorText");
  var layoutEditor = jQuery("#umpleLayoutEditorText");
  
  modelEditor.keyup(function(eventObject){
    Action.freshLoad = false;
    Action.umpleTyped(eventObject);
  });
  modelEditor.mousedown(function(){setTimeout("jQuery(\"#linenum\").val(Action.getCaretPosition())",25)});
  layoutEditor.keyup(function(eventObject){
    Action.freshLoad = false;
    Action.setjustUpdateNowtoSaveLater(false);
    Action.umpleCodeMirrorTypingActivity("layoutEditor");
  }); // Fixes Issue#1571 Editing on the layout editor will not update the Umple diagram
  modelEditor.focus(function(){Action.focusOn("umpleModelEditorText", true);});
  layoutEditor.focus(function(){Action.focusOn("umpleLayoutEditorText", true);});
  modelEditor.blur(function(){Action.focusOn("umpleModelEditorText", false);});
  layoutEditor.blur(function(){Action.focusOn("umpleLayoutEditorText", false);});
  
  Page.initCodeMirrorEditor();
  Layout.initUmpleTextAreaSize();
  if (!Layout.isTextVisible) {Layout.showHideTextEditor(false);}
  if (!Layout.isLayoutVisible) {Layout.showHideLayoutEditor(false);}
}

/* CodeMirror 5 */
Page.initCodeMirrorEditor = function() {
  Page.codeMirrorEditor = CodeMirror.fromTextArea(
    document.getElementById('umpleModelEditorText'),{
        lineNumbers: true,
        matchBrackets: true,
        readOnly: Page.readOnly,
        mode: "text/x-umple",
        lineWrapping: true,
                   
        extraKeys: { // Change consistently in umple_action.js for Mousetrap
          "Ctrl-E": function(cm) {Page.clickShowEditableClassDiagram()},
          "Ctrl-J": function(cm) {Page.clickShowJointJSClassDiagram()},
          "Ctrl-G": function(cm) {Page.clickShowGvClassDiagram()},
          "Ctrl-S": function(cm) {Page.clickShowGvStateDiagram()},
          "Ctrl-L": function(cm) {Page.clickShowStructureDiagram()},
          "Ctrl-T": function(cm) {Page.clickShowHideText()},
          "Shift-Ctrl-Alt-T": function(cm) {Page.clickShowHideText()},
          "Ctrl-D": function(cm) {Page.clickShowHideCanvas()},
          "Ctrl-N": function(cm) {Page.clickShowHideMenu()},
          "Ctrl-Alt-N": function(cm) {Page.clickShowHideMenu()},
          "Ctrl-Shift-=": function(cm) {Page.clickButtonlarger()},
          "Ctrl-Shift--": function(cm) {Page.clickButtonSmaller()},
          "Shift-Ctrl-A": function(cm) {Page.clickToggleAttributes()},
          "Ctrl-M": function(cm) {Page.clickToggleMethods()},
          "Ctrl-R": function(cm) {Page.clickToggleTraits()},
          "Ctrl-I": function(cm) {Page.clickToggleTransitionLabels()},
          "Ctrl-K": function(cm) {Page.clickToggleGuardLabels()},
          "Ctrl-O": function(cm) {Action.copyCommandLineCode()},
          "Ctrl-B": function(cm) {Action.promptAndExecuteTest()},
          "Esc": function(cm) {cm.getInputField().blur()}
          }
        }
      );
    
  /* codemirror 6 */
  const extraKeys = [
    { key: "Ctrl-E", run: function() { Page.clickShowEditableClassDiagram() } },
    { key: "Ctrl-J", run: function() { Page.clickShowJointJSClassDiagram() } },
    { key: "Ctrl-G", run: function() { Page.clickShowGvClassDiagram() } },
    { key: "Ctrl-S", run: function() { Page.clickShowGvStateDiagram() } },
    { key: "Ctrl-L", run: function() { Page.clickShowStructureDiagram() } },
    { key: "Ctrl-T", run: function() { Page.clickShowHideText() } },
    { key: "Shift-Ctrl-Alt-T", run: function() { Page.clickShowHideText() } },
    { key: "Ctrl-D", run: function() { Page.clickShowHideCanvas() } },
    { key: "Ctrl-N", run: function() { Page.clickShowHideMenu() } },
    { key: "trl-Alt-N", run: function() { Page.clickShowHideMenu() } },
    { key: "Ctrl-Shift-=", run: function() { Page.clickButtonlarger() } },
    { key: "Ctrl-Shift--", run: function() { Page.clickButtonSmaller() } },
    { key: "Shift-Ctrl-A", run: function() { Page.clickToggleAttributes() } },
    { key: "Ctrl-M", run: function() { Page.clickToggleMethods() } },
    { key: "Ctrl-R", run: function() { Page.clickToggleTraits() } },
    { key: "Ctrl-I", run: function() { Page.clickToggleTransitionLabels() } },
    { key: "Ctrl-K", run: function() { Page.clickToggleGuardLabels() } },
    { key: "Ctrl-O", run: function() { Page.copyCommandLineCode() } },
    { key: "Ctrl-B", run: function() { Page.promptAndExecuteTest() } },
    { key: "Esc", run: function(cm6) { cm6.getInputField().blur() } },
  ]
    
  // codemirror 6 
  // comment the following when trying to mount react app
  const initialState = cm6.createEditorState(
    document.getElementById("umpleModelEditorText").value, 
    {
      extensions: []
    });
  Page.codeMirrorEditor6 = cm6.createEditorView(
    initialState, document.getElementById("newEditor"));

  // adds changeListenerPlugin to the code editor
  // to listen to code changes happening in it
  // either due to collaborative editing or normal editing
  // without triggering any keyboard/mouse events
  Page.codeMirrorEditor6.dispatch({
    effects: cm6.StateEffect.appendConfig.of(cm6.changeListenerPlugin)
  });

  // monitor codemirror6 state to listen to any changes in editor contents and update diagram accordingly
  // Page.codeMirrorEditor6.dom.addEventListener("input", () => {
  //   console.log("Input event triggered...")
  //   const newText = Page.codeMirrorEditor6.state.doc.toString();
  //   setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
  // });

  // Event triggering changes for CodeMirror 5
  Page.codeMirrorEditor.on('focus', function (id, gained) {
    Action.focusOn('CodeMirror', true);
  });
  Page.codeMirrorEditor.on('blur', function (id, gained) {
    Action.focusOn('CodeMirror', false);
  });
  Page.codeMirrorEditor.on('gutterClick', function (id, theLine) {
    Page.codeMirrorEditor.foldCode(theLine);
  });

  
  /* codemirror 5: detect changes. See below for inverse */
  /* This is triggered indirectly by keyUP, which causes save to element 
    umpleModelEditorText */
  // Removing CM5
  // Page.codeMirrorEditor.on('change', function (ed, changes) {
  //   /* start timer to process changes 3s after after the editing is done */
  //   console.log("onChange Triggered")
  //   Action.umpleCodeMirrorTypingActivity("codeMirrorEditor");
  //   /* update codemirror 6 panel with the same changes  .. NO LONGER DONE HERE  */
  //   // Page.setCodeMirror6Text(document.getElementById("umpleModelEditorText").value);
  //  });
      
  // Sets the codemirror 6 text without any change trigger (hopefully)
  Page.setCodeMirror6Text = function (textToSet) {
    // DEBUG
    // console.log("Inside Page.setCodeMirror6Text() ...")
    Page.codeMirrorEditor6.dispatch({ 
      changes: { 
        from: 0, 
        to: Page.codeMirrorEditor6.state.doc.length, 
        insert: textToSet
        }
    } )
  }
   
  // codemirror 6: respond to each keyup to start the process of marking a change
  // Page.codeMirrorEditor6.dom.addEventListener('keyup', function (ed, changes) {
  //   console.log("keyup Event Triggered ...")
  //   // start timer to process changes 3s after the editing is done
  //   // Action.umpleCodeMirrorTypingActivity("newEditor");
  //   setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
  //  // console.log("keyup event triggered in CodeMirror 6 and hopefully saved text !!"+cm6.getCodeMirror6UmpleText());
  // });

  // Removing CM5
  // CM5 cursorActivity event
  // Page.codeMirrorEditor.on('cursorActivity', function () {
  //   Page.codeMirrorEditor.addLineClass(Page.hLine, null);
  //   Page.hLine = Page.codeMirrorEditor.addLineClass(
  //   Page.codeMirrorEditor.getCursor().line,'activeline');
  //   Action.umpleCodeMirrorCursorActivity();
  // });

  // Page.codeMirrorEditor6.dom.addEventListener('mousedown', function () {
  //   console.log("mousedown Event Triggered by CM6 editor ...")
  //   Action.umpleCodeMirrorCursorActivity();
  // });

  // Event triggering events end here
  Page.hLine = Page.codeMirrorEditor.addLineClass(0, "activeline");
  Page.codeMirrorOn = true;  
  
  // DOES NOT WORK - DEBUG ... testing to see if we can trigger change made in CodeMirror 6
/*  document.getElementById('umpleModelEditorText')
     .addEventListener('DOMSubtreeModified',function () {
    console.log("       CM6 changes to umpleModelEditorText: "+Page.codeMirrorEditor6.state.doc.toString());
    // start timer to process changes 3s after after the editing is done
    Action.umpleCodeMirrorTypingActivity("notUsed");    
  } ); */
}

// Function to make the E G S icons in UmpleOnline context senstive (#1400)
Page.setDiagramTypeIconState = function(diagramType){
  buttonList = ['ECD_button','GCD_button','SD_button'];
  for (i = 0, l = buttonList.length; i<l;++i){
    document.getElementById(buttonList[i]).className = "button2";
  }
  switch(diagramType){
    case 'editableClass':
    document.getElementById('ECD_button').className = "button2 active";
    break;
    case 'GvClass':
    document.getElementById('GCD_button').className = "button2 active";
    break;
    case 'GvState':
    document.getElementById('SD_button').className = "button2 active";
    break;
  }
}

// Function to make the T D A M icons in UmpleOnline context senstive (#1400)
Page.setShowHideIconState = function(selectedButton){
  switch(selectedButton){
    case 'SHT_button':
      if(Page.showText){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHD_button':
      if(Page.showCanvas){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHA_button':
      if(Page.showAttributes){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHM_button':
      if(Page.showMethods){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
  }
}

// Functions to click various menu items - invoked by code mirror and MouseTrap
Page.clickShowEditableClassDiagram = function() {
  jQuery('#buttonShowEditableClassDiagram').trigger('click');
}
Page.clickShowJointJSClassDiagram = function() {
  jQuery('#buttonShowJointJSClassDiagram').trigger('click');
}
Page.clickShowGvClassDiagram = function() {
  jQuery('#buttonShowGvClassDiagram').trigger('click');
}
Page.clickShowGvStateDiagram = function() {
  jQuery('#buttonShowGvStateDiagram').trigger('click');
}
Page.clickShowGvFeatureDiagram = function() {
  jQuery('#buttonShowGvFeatureDiagram').trigger('click');
}
Page.clickShowStructureDiagram = function() {
  jQuery('#buttonShowStructureDiagram').trigger('click');
}
Page.clickShowHideText = function() {
  jQuery('#buttonShowHideTextEditor').trigger('click');
}
Page.clickShowHideCanvas = function() {
  jQuery('#buttonShowHideCanvas').trigger('click');
}
Page.clickShowHideMenu = function() {
  Layout.showHideMenu(); // No clickable button
}

Page.clickButtonlarger = function() {
  jQuery('#buttonLarger').trigger('click');
}
Page.clickButtonSmaller = function() {
  jQuery('#buttonSmaller').trigger('click');
}
Page.clickToggleAttributes = function() {
  jQuery('#buttonToggleAttributes').trigger('click');
}
Page.clickToggleMethods = function() {
  jQuery('#buttonToggleMethods').trigger('click');
}
Page.clickToggleTraits = function() {
  jQuery('#buttonToggleTraits').trigger('click');
}
Page.clickToggleFeatureDependency= function() {
  jQuery('#buttonToggleFeatureDependency').trigger('click');
}
Page.clickToggleTransitionLabels = function() {
  jQuery('#buttonToggleTransitionLabels').trigger('click');
}
Page.clickToggleGuardLabels = function() {
  jQuery('#buttonToggleGuards').trigger('click');
}
Page.clickToggleGuardLabels = function() {
  jQuery('#buttonToggleGuardLabels').trigger('click');
}

Page.clickAllowPinch = function() {
  jQuery('#buttonAllowPinch').trigger('click');
}


Page.isPhotoReady = function()
{
  if(Page.readOnly) {
    return(true)
  }
  else {
    var selector = "#buttonPhotoReady";
    return jQuery(selector).prop('checked');
  }
}

Page.initSourceCodeArea = function()
{
  SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
  var generatedCodeRowSelector = "#generatedCodeRow";
  jQuery(generatedCodeRowSelector).hide();
}

Page.initCodeExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).hide();
}

Page.showExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).show();
}

Page.hideExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).hide();
}

Page.hideGeneratedCode = function()
{
  jQuery("#generatedCodeRow").hide();
  jQuery("#innerGeneratedCodeRow").hide();
  if(!Page.useStructureDiagram) jQuery("#svgCanvas").hide();
}

Page.hideGeneratedCodeOnly = function() {
  jQuery("#generatedCodeRow").hide();
  jQuery("#innerGeneratedCodeRow").hide();
}

Page.initCanvasArea = function()
{
  var canvas = jQuery("#umpleCanvas");
  Layout.initUmpleCanvasSize();
  
  canvas.click(function(event){Action.umpleCanvasClicked(event);});
  canvas.mousemove(Action.mouseMove);
  canvas.focus(function(){Action.focusOn(Page.umpleCanvasId(), true);});
  canvas.blur(function(){Action.focusOn(Page.umpleCanvasId(), false);});
  canvas.delegate("[class$='editableDoubleClick']", 'dblclick', InlineEditor.handleOnClick);
  canvas.delegate("[class$='editableSingleClick']", 'click', InlineEditor.handleOnClick);

  if (!Layout.isDiagramVisible) {Layout.showHideCanvas(false);}
}
//The purpose of this function is make sure the URL example argument selects the appropriate dropdown example
Page.setExamples = function(ex)
{
  var exValue = ex+".ump"
  jQuery("#inputExample").change(Action.loadExample);
  jQuery("#inputExample option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
 
  jQuery("#inputExampleType").change(Action.setExampleType);

  jQuery("#inputExample2").change(Action.loadExample);
  jQuery("#inputExample2 option").each(function(){
     if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample2 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
  
  jQuery("#inputExample3").change(Action.loadExample);
  jQuery("#inputExample3 option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample3 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
 
  jQuery("#inputExample4").change(Action.loadExample);
  jQuery("#inputExample4 option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample4 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
}
Page.initExamples = function()
{
 
  jQuery("#inputExample").change(Action.loadExample);
  jQuery("#defaultExampleOption").attr("selected",true);
 
  jQuery("#inputExampleType").change(Action.setExampleType);

  jQuery("#inputExample2").change(Action.loadExample);
  jQuery("#defaultExampleOption2").attr("selected",true);

  jQuery("#inputExample3").change(Action.loadExample);
  jQuery("#defaultExampleOption3").attr("selected",true);

  jQuery("#inputExample4").change(Action.loadExample);
  jQuery("#defaultExampleOption4").attr("selected",true);

  if (Page.useStructureDiagram) {
    jQuery("#structureModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples4").hide();      
  }
  else if (Page.useGvStateDiagram) {
    jQuery("#smModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples3").hide();
    jQuery("#itemLoadExamples4").hide();  
  }
 else if (Page.useGvFeatureDiagram) {
    jQuery("#featureModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples3").hide();    
  }
  else {
    jQuery("#cdModels").prop("selected",true); 
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples3").hide(); 
    jQuery("#itemLoadExamples4").hide();       
  }  
}

Page.highlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).addClass("highlight");
}

Page.unhighlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).removeClass("highlight");
}

Page.enableDiagram = function(doEnable)
{
  Page.enableEditDragAndResize(doEnable);
  Page.enablePaletteItem("buttonAddClass", doEnable);
  Page.enablePaletteItem("buttonAddAssociation", doEnable);
  Page.enablePaletteItem("buttonAddGeneralization", doEnable);
  Page.enablePaletteItem("buttonDeleteEntity", doEnable);
  Page.showDiagramSyncNeeded(!doEnable);
}
Page.enableTransition = function(doEnable)
{
    Page.enablePaletteItem("buttonAddTransition", doEnable);
    Page.enablePaletteItem("buttonAddAssociation", !doEnable);
}

Page.enableEditDragAndResize = function(doEnable)
{
  if (doEnable)
  {
    jQuery("span.editable").removeClass("uneditable");
    jQuery("div.umpleClass").removeClass("unselectable");
    jQuery("div.umpleClass.ui-draggable").draggable({disabled: false});
  } 
  else
  {
    jQuery("span.editable").addClass("uneditable");
    jQuery("div.umpleClass").addClass("unselectable");
    jQuery("div.umpleClass.ui-draggable").draggable({disabled: true});
    jQuery(':text').blur()

  }
}

Page.toggleToolItem = function(id, doubleClicked)
{
  if (doubleClicked == undefined) doubleClicked = false;
  Page.repeatToolItem = doubleClicked;
  
  var toolSelected = id.substring(6);
  var isNewTool = (toolSelected != Page.selectedItem);
  
  if (isNewTool)
  {
    Page.selectToggleTool(toolSelected);
  }
  else
  {
    Page.unselectAllToggleTools();
  }
}

Page.unselectAllToggleTools = function()
{
  var unselected = false;
  var temp = false;

  temp = DiagramEdit.removeNewClass();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewAssociation();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewTransition();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewGeneralization();
  if(temp) unselected = true;
  
  var allSelectedItems = "ul.toggle li.selected"; 
  jQuery(allSelectedItems).removeClass("selected highlight");
  
  setTimeout("Page.enableEditDragAndResize(true);", 500);
  Page.selectedItem = null;
  Page.repeatToolItem = false;

  return unselected;
}

Page.selectToggleTool = function(toolSelected)
{
  if (Page.selectedItem != null)
  {
    DiagramEdit.removeNewClass();
    DiagramEdit.removeNewAssociation();
    DiagramEdit.removeNewTransition();
    DiagramEdit.removeNewGeneralization();
  }
  
  Page.enableEditDragAndResize(false);
  Page.selectedItem = toolSelected;
  Action.unselectAll();
  
  var allSelectedItems = format("ul.toggle li.selected");
  var newSelectedItem = "#button" + toolSelected;
  jQuery(allSelectedItems).removeClass("selected highlight");
  jQuery(newSelectedItem).addClass("selected");
}

Page.canShowHovers = function()
{
  return Page.selectedItem == null || Page.selectedItem == "DeleteEntity";
}

Page.getRawUmpleCode = function()
{
  // DEBUG
  // console.log("Inside Page.getRawUmpleCode ...")
  // console.log("Reading Model Code from 'umpleModelEditorText' html element ...")
  return document.getElementById('umpleModelEditorText').value;
}

// CM6 function corresponding to CM5 Page.getRawUmpleCode()
Page.getRawUmpleCodeCM6 = function()
{
  // DEBUG
  // console.log("Reading Model Code from CM6 editor ...")
  return Page.codeMirrorEditor6.state.doc.toString();
}

Page.getUmpleCode = function()
{
  // DEBUG
  // console.log("Inside Page.getUmpleCode ...")
  var modelCleaned = Page.getRawUmpleCode().replace(Page.modelDelimiter, "");
  // var modelCleaned = Page.getRawUmpleCodeCM6().replace(Page.modelDelimiter, "");
  // console.log("Reading Positioning Code from 'umpleLayoutEditorText' html element ...")
  var positioning = jQuery("#umpleLayoutEditorText").val().replace(Page.modelDelimiter, "");
  if(positioning !== "" && !positioning.includes("namespace -;")){
   // prepend namespace cancellation to prevent namespace redefinition errors
    positioning = "\n\nnamespace -;\n"+positioning;
  }
  var umpleCode = modelCleaned + Page.modelDelimiter + positioning;
  return umpleCode;
}

Page.getEncodedURL = function()
{
  var server=window.location.href.split("?")[0];
  if(server.substr(0,37)=="https://cruise.umple.org/umpleonline/") {
    server = "http://try.umple.org/";
  }
  return server+"?text=" + encodeURIComponent(Page.getUmpleCode());
}

Page.splitUmpleCode = function(umpleCode)
{
  // DEBUG
  // console.log("Inside Page.splitUmpleCode ...")
  var splitIndex = umpleCode.indexOf(Page.modelDelimiter);
  if (splitIndex == -1)
  {
    model = umpleCode;
    positioning = "";
  }
  else
  {
    umpleCode = umpleCode.replace(Page.modelDelimiter, "");
  
    var model = umpleCode.substr(0, splitIndex);
    var positioning = umpleCode.substr(splitIndex, umpleCode.length);
  }
  var modelAndPositioning = [model, positioning];
  return modelAndPositioning;
}  

// Takes as an argument the full file with core code and layout info
// Called by fuunctions such as loadExampeCallback and loadFileCallback
// Also called by updateUmpleTextCallback which is triggered by diagram edit by directUpdateCommandCallback  
// Updates all text editors, and then can call a function called reason
Page.setUmpleCode = function(umpleCode, reason)
{
  // DEBUG
  // console.log("Inside Page.setUmpleCode() ...")
  var modelAndPositioning = Page.splitUmpleCode(umpleCode);

  // Update the layout editor with the second part of the combined file
  // console.log("Setting positioningCode into umpleLayoutEditorText html element ...")
  jQuery("#umpleLayoutEditorText").val(modelAndPositioning[1]);

  if(Page.codeMirrorOn) {
    // issue#1409  Do not Set the umple code if codeChange is false(i.e. reason is false)
    if (!((typeof reason === 'boolean') && reason == false))
    {
      // Update the codemirror 5 editor itself
      // console.log("Setting modelCode to codeMirror editor ...")
      Page.codeMirrorEditor.setValue(modelAndPositioning[0]);
    }
  }
  // Refactoring definitive text location
  // Update Codemirror 6 and the backup variable
  // console.log("Setting modelCode to codeMirror 6 ...")
  Action.updateCurrentUmpleTextBeingEdited(modelAndPositioning[0]);
  //OLD jQuery("#umpleModelEditorText").val(modelAndPositioning[0]);

  if (typeof reason === 'function'){
    reason();
  }
}

Page.setUmplePositioningCode = function(positioning)
{
  jQuery("#umpleLayoutEditorText").val(positioning);
}

Page.umpleCanvasId = function()
{
  return "umpleCanvas";
}

// Page.createBookmark() is called when Save & Collaborate button is clicked in umpleonline ui
// this method internally calls Page.connectCollabServer() which connects the current client to the UmpleCollabServer
// and enables the current users to collaborate by sharing the collaborative URL
Page.createBookmark = function()
{
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?model=" + Page.getModel();
}

Page.createTask = function()
{
  var taskName = jQuery("#taskName").val();
  let patt = /^(\w|\.)+$/; // taskName Take only [ A-Z or a-z or 0-9 or _ or . ]
  if (!patt.test(taskName))//taskName.indexOf(" ") != -1 || taskName.indexOf("/") != -1 || taskName.indexOf("-") != -1 || taskName.indexOf("\\") != -1) 
  {
    window.alert("Task Name can only contain letters(case insensitive), underscores, dots, and digits!");
    return;
  }
  var requestorName = jQuery("#requestorName").val();
  var instructions = jQuery("#instructions");
  var completionURL = jQuery("#completionURL").val();
  var isExperiment = jQuery("#isExperiment").is(':checked');
  // jQuery("#labelInstructions").hide();
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  Ajax.sendRequest("task.php",Page.createTaskCallback,format("taskName={0}&instructions={1}&model={2}&requestorName={3}&completionURL={4}&isExperiment={5}", 
    taskName, instructions.val(), Page.getModel(), requestorName, completionURL, isExperiment));
}


Page.createTaskCallback = function(response)
{
  if (response.responseText.split(" ")[0] == "Task")
  {
    window.alert("Not able to create a task with that name. " + response.responseText);
  }
  else 
  {
    //window.alert("Successfully created a Task! Now you will be navaigate to task modfication page");
    window.location.href = "umple.php?task=1&model=" + response.responseText;
  }
}

Page.editTask = function()
{
  var instructions = jQuery("#instructions");
  var taskName = jQuery("#model").val().split("-")[1];
  var requestorName = jQuery("#requestorName").val();
  var completionURL = jQuery("#completionURL").val();
  var isExperiment = jQuery("#isExperiment").is(':checked');
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  Ajax.sendRequest("task.php", Page.editTaskCallback, "edit=1&taskName=" + taskName + "&instructions=" + instructions.val() + "&model=" 
    + Page.getModel() + "&requestorName=" + requestorName + "&completionURL=" + completionURL + "&isExperiment=" + isExperiment);
  //window.location.href = "task.php?edit=1&taskName=" + taskName + "&instructions=" + instructions.val() + "&model=" + Page.getModel() + "&requestorName=" + requestorName;
  //window.alert("Successfully edit Task " + taskName + "!");
}

Page.editTaskCallback = function(response)
{
  Page.setFeedbackMessage('Changes saved');
}

Page.cancelTaskResponse = function()
{
  var answer = confirm("Are you sure to cancel this task response?");
  if (answer)
  {
    window.location.href = "task.php?cancelTaskResponse=1&model=" + Page.getModel();
  }
}
Page.hideTask = function(){
    jQuery("#taskArea").css("display","none");
    jQuery("#labelTaskName").css("display","none");
    jQuery("#taskNameCell").css("display","none");
    jQuery("#instructions").css("display","none");
    jQuery("#isExperimentCell").css("display","none");
    jQuery("#isExperiment").attr("checked", false);
    Layout.zoomResize();
}
Page.cancelTask = function(){
   
   if (jQuery("#completionURL").val()!='' || jQuery("#taskName").val()!='' || jQuery("#requestorName").val()!='' || jQuery("#instructions").val()!=''){

    var answer = confirm ("Are you sure you want to end the task creation process?");
	
    if (answer){
    jQuery("#taskName").val('');
    jQuery("#requestorName").val('');
    jQuery("#completionURL").val('');
    jQuery("#instructions").val('');
    Page.hideTask();
    }
    }
    else{ Page.hideTask();}
}

Page.endTaskEdit = function() {
  
    var answer = confirm ("Are you sure you want to end the task editing process?");
    if (answer){
    	Page.hideTask();
    }
  
}

Page.toggleTabs = function()
{
  TabControl.isHidden()? TabControl.showTabs() : TabControl.hideTabs();
  Layout.layoutHandler.adjustAfterWindowResize();
}

Page.showDiagramSyncNeeded = function(doShow)
{
  var canvas = jQuery("#umpleCanvas");
  var messageDiv =  '<div id="syncNeededMessage" class="syncNeededMessage unselectable">' +
              'Diagram is out of synchronization with the text due to selecting Manual Sync or an error in the text that has caused the compiler to produce no output. ' +
            '</div>';
  if (doShow && !Page.diagramSyncNeededAppend)
  {
    canvas.append(messageDiv);
    Page.diagramSyncNeededAppend = true;
    Page.readOnly = true;
    UmpleSystem.redrawCanvas();
  }
  else if(!doShow && Page.diagramSyncNeededAppend)
  {
    jQuery("#syncNeededMessage").remove();
    Page.diagramSyncNeededAppend = false;
    Page.readOnly = false;
    UmpleSystem.redrawCanvas();
  }
  
}

Page.hideLoading = function()
{
  var modelEditor = "#topTextEditor";
  var layoutEditor = "#bottomTextEditor";
  var canvas = "#" + Page.umpleCanvasId();  

  if(Page.modelLoadingCount > 0) Page.modelLoadingCount--;
  if(Page.layoutLoadingCount > 0) Page.layoutLoadingCount--;
  if(Page.canvasLoadingCount > 0) Page.canvasLoadingCount--;

  if(Page.modelLoadingCount === 0) jQuery(modelEditor).hideLoading();
  if(Page.layoutLoadingCount === 0) jQuery(layoutEditor).hideLoading();
  if(Page.canvasLoadingCount === 0) jQuery(canvas).hideLoading();
  
  if(Page.modelLoadingCount === 0 
    && Page.layoutLoadingCount === 0 
    && Page.canvasLoadingCount === 0)
  {
    jQuery(".bookmarkableUrl").removeClass("disabled");
  }
}

Page.showModelLoading = function()
{
  var modelEditor = jQuery("#topTextEditor");

  if(Page.modelLoadingCount == 0)
  {
    if (jQuery("#textEditorColumn").is(":visible"))
    {
      modelEditor.showLoading();
    }
    jQuery(".bookmarkableUrl").addClass("disabled");
  }

  Page.modelLoadingCount++;
}

Page.showLayoutLoading = function()
{
  var layoutEditor = jQuery("#bottomTextEditor");
  
  if(Page.layoutLoadingCount == 0)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    if (layoutEditor.is(":visible")) 
    {
      layoutEditor.showLoading();
    }
  }

  Page.layoutLoadingCount++;
}

Page.showCanvasLoading = function()
{
  console.log("Inside Page.showCanvasLoading() ...")
  var canvas = jQuery("#umpleCanvas");
  if(Page.canvasLoadingCount == 0)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    if (canvas.is(":visible"))
    {
      canvas.showLoading();
    }
  }
  
  Page.canvasLoadingCount++;
}

Page.resetCanvasSize = function()
{
  Page.setUmpleCanvasSize(Layout.minCanvasSize.width, Layout.minCanvasSize.height);
}


Page.getSelectedExample = function()
{
  var inputExample = "";
  var theExampleType = Page.getExampleType();
  if(theExampleType == "cdModels") {
    var requiresGvClass = false; // Some class diagrams  are too complex to edit
    inputExample = jQuery("#inputExample option:selected").val();
    if (inputExample == "GeometricSystem.ump") {
      requiresGvClass = true;
    }
    
    if(requiresGvClass) {
      // if diagram type not a editable class diagram, set it 
      if(!Page.useGvClassDiagram) {
        jQuery("#buttonShowGvClassDiagram").attr('checked', true); 
        Action.changeDiagramType({type: "GvClass"});
      }
    }
    else {
      // if diagram type not a class diagram, set it to a class diagram
      if(!(Page.useEditableClassDiagram || Page.useGvClassDiagram)) {
        jQuery("#buttonShowEditableClassDiagram").attr('checked', true); 
        Action.changeDiagramType({type: "editableClass"});
      }
    }
  }
  else if (theExampleType == "featureModels")
    {
       inputExample = jQuery("#inputExample4 option:selected").val(); 
     //  if (inputExample == "BerkeleyDB_SP_featureDepend.ump")
     //  this.showFeatureDependency = true;
       if( !Page.useGvFeatureDiagram) {
         jQuery("#buttonShowGvFeatureDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "GvFeature"});
      }
    
    }
  else {

    if(theExampleType == "smModels") {
      inputExample = jQuery("#inputExample2 option:selected").val();
      // if diagram type is not a state machine, set to state machine
      if( !Page.useGvStateDiagram && !Page.useJointJSClassDiagram) {
         jQuery("#buttonShowGvStateDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "GvState"});
      }
    }
    else {
      inputExample = jQuery("#inputExample3 option:selected").val();
      // if diagram type is not a structure diagram, set to structure diagram
      if( !Page.useStructureDiagram) {
         jQuery("#buttonShowStructureDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "structure"});
      }    
    }
  }
  return inputExample;
}

Page.getExampleType = function()
{
  var exampleType = jQuery("#exampleType option:selected").val();
  return exampleType;
}

Page.showCodeDone = function()
{
  var gcselector = "#genstatus";
  jQuery(gcselector).show();
  setTimeout(function() {jQuery(gcselector).hide();}, 2000);
}

Page.showViewDone = function()
{
  var selector = "#buttonViewComplete";
  jQuery(selector).dialog({closeOnEscape:true, hide:'puff', height:100, width:250});
  setTimeout(function() {jQuery(selector).dialog("close");}, 2000);
}

Page.showExecutedResponse = function(responseText) {
  jQuery("#executionMessage").html(responseText);
}

Page.showGeneratedCode = function(code,language,tabnumber)
{
	// Default "tabnumber" parameter to null, ie. only output to the main codeblock
	if (typeof(tabnumber)==='undefined') tabnumber = "";

	Action.toggleTabsCheckbox(language);

  Page.applyGeneratedCodeAreaStyles(language);
  
  var errorMarkup = Page.getErrorMarkup(code, language);
  var generatedMarkup = Page.getGeneratedMarkup(code, language);

  //Set download link, any error or warning messages 
	if (tabnumber == "")
  {
    jQuery("#downloadArea").html(errorMarkup);
  } else {
    jQuery("#messageArea").html(errorMarkup);
  }

  //Set the generated content
  if(language == "java" || language == "php" || language == "cpp" 
    || language == "ruby" || language == "python" || language == "xml" || language == "sql" || language == "alloy" || language == "nusmv")
  {
		jQuery("#innerGeneratedCodeRow" + tabnumber).html(
			formatOnce('<pre class="brush: {1};">{0}</pre>',generatedMarkup,language)
		)
    SyntaxHighlighter.highlight("code");

		if(tabnumber == ""){
			// Remove all previous file codeblocks
			jQuery('#innerGeneratedCodeRow').nextAll().remove();
			// Clear tab row contents
			jQuery('#tabRow').html('');
			// Generate tabs
			Action.generateTabsCode(code);
			Action.toggleTabs();
		}
  }
  else if(language == "structureDiagram")
  {
    //render the structure diagram
    eval(generatedMarkup);

    //Add a download link to the top of the structure diagram
    //This onclick ensures the href is not followed
    var downloadLink = '<div id="diagramLinkContainer"></div>';
    errorMarkup = downloadLink + errorMarkup;

		if(errorMarkup != ""){
    	jQuery("#messageArea").html(errorMarkup);
		}
    Page.toggleStructureDiagramLink(false);
  }
  else
  {
    jQuery("#innerGeneratedCodeRow" + tabnumber).html(generatedMarkup);
  }
}

Page.applyGeneratedCodeAreaStyles = function(language)
{
  var generatedArea = jQuery("#generatedCodeRow");
  generatedArea.show();
  jQuery("#innerGeneratedCodeRow").show();

  //Modify styles and show or hide containers depending on the content
  //Error message
  if(language == "diagramUpdate") 
  {
    generatedArea.removeClass('generatedCode');
    generatedArea.removeClass('generatedDiagram');
  }
  //One of the svg diagram types
  else if(language == "stateDiagram" || language == "classDiagram" || language == "structureDiagram")
  {
    generatedArea.removeClass('generatedCode');
    generatedArea.addClass('generatedDiagram');
    
    if(language == "structureDiagram")
    {
      //Add an svg container to hold the structure diagram
      jQuery("#innerGeneratedCodeRow").html('<svg id="generatedSVGCanvas"></svg>')
    }
  }
  //Generated code
  else
  {
    generatedArea.removeClass('generatedDiagram');
    generatedArea.addClass('generatedCode');
  }
}

// Pulls any error and warning markup from the response from code generation
Page.getErrorMarkup = function(code, language)
{
  var output = "";
  
  if(language == "classDiagram" || language == "stateDiagram")
  { // Covers Graphviz class and state diagrams
    output = code.split("<svg xmlns=")[0];
    output = output.replace(/&nbsp;\s*$/, "");
  }
  else if(language == "javadoc" || language == "yumlDiagram")
  { // Covers javadoc and YUML diagrams
    output = code.split("<iframe ")[0];
  }
  else if(language == "diagramUpdate")
  { // Covers simple right-hand side canvas updates
    output = code.replace(/<p>[\s\S]*/, "");
  }
  else
  {
    // Covers the rest of the generated languages
    // Don't assign error markup unless there was a split - see #1362
    var split = code.split("<p>URL_SPLIT");
    if (split.length > 1){
      output = split[0];
    }
  }

  return output;
}

// Removes any extraneous code from the generated code to display
Page.getGeneratedMarkup = function(code, language)
{
  var output = "";
  
  if(language == "classDiagram" || language == "stateDiagram")
  { // Covers Graphviz class and state diagrams
    output = code.split("<svg width=")[1];
    output = "<svg width=" + output;
    output = output.replace(/<\/svg>$/, "");
  }
  else if(language == "javadoc" || language == "yumlDiagram")
  { // Covers javadoc and YUML diagrams
    output = code.split("<iframe ")[1];
    output = "<iframe " + output;
  }
  else if(language == "diagramUpdate")
  { // Covers simple right-hand side canvas updates
    // No generated code to extract
  }
  else if(language == "structureDiagram") 
  {// Covers the structure diagram code
    output = code.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "generatedSVGCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  else
  {
    // Covers the rest of the generated languages
    // Assign to entire code block if non-splitting - see #1362
    var split = code.split("<p>URL_SPLIT");
    output = (split.length > 1) ? split[1] : code;
  }
  return output;
}

Page.toggleStructureDiagramLink = function(isGenerated, filename)
{
  linkContainer = jQuery("#diagramLinkContainer");

  if(isGenerated)
  {
    linkContainer.html(format("<a href='{0}' target='_blank' id='structureLink'>Download the SVG for the following</a>", filename))
    jQuery("#structureLink").on('click', function(event) 
    {
      Page.toggleStructureDiagramLink(false);
    });
  }
  else
  {
    linkContainer.html('<div id="buttonStructureLink" value="Generate SVG"></div>');
    Page.initJQueryButton("buttonStructureLink");
    Page.initAction("buttonStructureLink");
  }
}

Page.setFilename = function(filename)
{
  jQuery("#filename").val(filename);
}

Page.setFeedbackMessage = function(feedbackMessage)
{
  document.getElementById('feedbackMessage').innerHTML=feedbackMessage;
}

Page.setExampleMessage = function(exampleMessage)
{
  document.getElementById('exampleMessage').innerHTML=exampleMessage;
}

Page.getFeedbackMessage = function()
{
  return document.getElementById('feedbackMessage').innerHTML;
}

Page.catFeedbackMessage = function(feedbackMessage)
{
  var origMsg = document.getElementById('feedbackMessage').innerHTML;
  document.getElementById('feedbackMessage').innerHTML=origMsg+feedbackMessage;
}

Page.getFilename = function()
{
  return jQuery("#filename").val();
}

Page.getAdvancedMode = function()
{
  return document.getElementById("advancedMode").value;
}

Page.getModel = function()
{
  return jQuery("#model").val();
}

jQuery.fn.selectRange = function(start, end) {
  return this.each(function() 
  {
    if(this.setSelectionRange) 
    {
      this.focus();
      this.setSelectionRange(start, end);
    } 
    else if(this.createTextRange) 
    {
       var range = this.createTextRange();
       range.collapse(true);
       range.moveEnd('character', end);
       range.moveStart('character', start);
       range.select();
    }
  });
}

// checks if the uel of current page is bookmark or not
Page.isBookmarkURL = function() {
  const currentURL = window.location.href;
  const modelName = currentURL.substring(currentURL.indexOf("?model=") + 1) 
  if(currentURL.includes("model") && modelName.length!=0){
    return true;
  }
  return false;
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models positions in the umpleOnline graphical view

UmplePositionFactory = new Object();

UmplePositionFactory.copy = function(position)
{
  return new UmplePosition(position.x,position.y,position.width,position.height);
}

function UmplePosition(aX, aY, aWidth, aHeight)
{
  this.x = aX;
  this.y = aY;
  this.width = aWidth;
  this.height = aHeight;
  
  this.set = function(aX,aY)
  {
    this.x = aX;
    this.y = aY;
  }

  this.subtract = function(other)
  {
    return new UmplePosition(this.x - other.x, this.y - other.y, this.width - other.width, this.height - other.height);
  }
  
  this.add = function(other)
  {
    if (other == null)
    {
      return UmplePositionFactory.copy(this);
    }
    return new UmplePosition(this.x + other.x, this.y + other.y, this.width + other.width, this.height + other.height);
  }
  
  this.slopeAngle = function(pointB)
  {
    return this.slopeAngleAndQuadrant(pointB)[0];
  }
  
  this.quadrant = function(pointB)
  {
    return this.slopeAngleAndQuadrant(pointB)[1];
  }
 
  this.equalsIgnoreSize = function(aPosition)
  {
  	if (this.x != aPosition.x)
  	{
  	  return false;
  	}
  	if (this.y != aPosition.y)
  	{
  	  return false;
  	}
  	return true;
  }
  
  this.slopeAngleAndQuadrant = function(pointB)
  {
    var lengthY = pointB.y - this.y;
    var lengthX = this.x - pointB.x;
    
    var slope = lengthY / lengthX;
    var angle = Math.atan(slope) * 180.0 / 3.14159;
    
    var topRight = lengthY >= 0 && lengthX >= 0;
    var topLeft = lengthY >= 0 && lengthX < 0;
    var bottomRight = lengthY < 0 && lengthX >= 0;
    var bottomLeft = lengthY < 0 && lengthX < 0;
    
    var quadrant = topRight ? "top-right" : topLeft ? "top-left" : bottomRight ? "bottom-right" : "bottom-left";
    return [angle,quadrant];  
  }
  
  this.slopeAngle360 = function(pointB)
  {
    var slopeAngle;
    if (this.y == pointB.y)
    {
      if (this.x > pointB.x) return 180;
      else return 0;
    }
    var lengthY = pointB.y - this.y;
    var lengthX = pointB.x - this.x;
    var slope = lengthX / lengthY;
  
    if (pointB.y < this.y)
    {
      slopeAngle = 90 + Math.atan(slope) * 180/3.14159;    	
    }
    else
    {
      slopeAngle = 270 + Math.atan(slope) * 180/3.14159;
    }
    
    return Math.round(slopeAngle);
  }
  
  this.travelForward = function(distance, slopeAngle)
  {
    var result = new UmplePosition(0,0,0,0);
    var deltaX = 0;
    var deltaY = 0;
    
    if (slopeAngle >= 0 && slopeAngle < 90)
    {
      deltaX = Math.cos(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.sin(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x + deltaX;
      result.y = this.y - deltaY;
    }
    else if (slopeAngle >= 90 && slopeAngle < 180)
    {
      slopeAngle -= 90;
      deltaX = Math.sin(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.cos(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x - deltaX;
      result.y = this.y - deltaY;
    }
    else if (slopeAngle >= 180 && slopeAngle < 270)
    {
      slopeAngle -= 180;
      deltaX = Math.cos(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.sin(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x - deltaX;
      result.y = this.y + deltaY;
    }
    else
    {
      slopeAngle -= 270;
      deltaX = Math.sin(slopeAngle*3.14159/180)*distance;
      deltaY = Math.cos(slopeAngle*3.14159/180)*distance;
      result.x = this.x + deltaX;
      result.y = this.y + deltaY;
    }
    
    result.x = Math.round(result.x);
    result.y = Math.round(result.y);
    return result;
  }
  
  this.wallsAreAdjacent = function(w1, w2)
  {
  	if (w1 == w2) return false;
  	if (w1 == "West" && w2 == "East") return false;
	if (w1 == "East" && w2 == "West") return false;
	if (w1 == "North" && w2 == "South") return false;
	if (w1 == "South" && w2 == "North") return false;
    return true;    
  }
  
  
  this.areAnglesSimilar = function(one,two)
  {
    var delta = 3;
    return Math.abs(one - two) <= delta;
  }
  
  this.toString = function()
  {
  	return "(" + this.x + "," + this.y + "," + this.width + "," + this.height + ")";
  }
  
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
jQuery(document).ready(function(){
    
  var name = "filecode=";
  var view = "VIEW=";
  var diagram = "DIAGRAM=";
  var preferences = "PREF=";
  
  //Split the cookie to different values
  var ca = document.cookie.split(';');  
  //Order of filecode, view, diagram, and preferences
  var filepath = null;
  
  //Hide the restore link
  jQuery('#restorecode').hide();
  
  //Find the values in the cookie and store them in the variables
  for(var i=0; i<ca.length; i++) 
  {
      var c = ca[i].trim();
      if (c.indexOf(name)==0)
      {
        filepath = c.substring(name.length,c.length);
      }
      else if (c.indexOf(view)==0)
      {
        view = c.substring(view.length,c.length);
      }
      else if (c.indexOf(diagram)==0)
      {
        diagram = c.substring(diagram.length,c.length);
      }
      else if (c.indexOf(preferences)!=-1)
      {
        preferences = c.substring(preferences.length,c.length);
      }
  }
  
  if(preferences.indexOf("g") != -1) // Found g so hide gdpr
  {
    Action.hidegdpr();
  }
  
  //If the filepath is found in the cookie
  if(filepath != null && filepath.length != 0)
  {
    //Display the link for a minute
    jQuery('#restorecode').show();
    setTimeout(function() {
  jQuery('#restorecode').hide();
},30000);
    
    //Activate the link button
    jQuery('#restorecode').click(function(){
      //Load Umple Code
      jQuery('#restorecode').hide();
      Page.setFilename(filepath);
      Action.loadFile();
      
      //Set the user preference by finding letters in the values
      
      //View Attributes
      if(view.indexOf("d") != -1)  // found d so show diagram if needed
      {
        if(!jQuery("#buttonShowHideCanvas").prop("checked"))
        {
          jQuery("#buttonShowHideCanvas").trigger('click');
        }
      }
      else // did NOT find d so hide diagram if needed
      {
        if(jQuery("#buttonShowHideCanvas").prop("checked"))
        {
          jQuery("#buttonShowHideCanvas").trigger('click');
        }      
      }
      
      if(view.indexOf("t") != -1) // found t so show text if needed
      {
        if(!jQuery("#buttonShowHideTextEditor").prop("checked"))
        {
          jQuery('#buttonShowHideTextEditor').trigger('click');
        }
      }
      else // did NOT find t so hide text if needed
      {
        if(jQuery("#buttonShowHideTextEditor").prop("checked"))
        {
          jQuery('#buttonShowHideTextEditor').trigger('click');
        }      
      }
      
      if(view.indexOf("l") != -1) // found l so show layout editor if needed
      {
        if(!jQuery("#buttonShowHideLayoutEditor").prop("checked"))
        {
          jQuery('#buttonShowHideLayoutEditor').trigger('click');
        }
      }
      else // did NOT find l so hide layout editor if needed
      {
        if(jQuery("#buttonShowHideLayoutEditor").prop("checked"))
        {
          jQuery('#buttonShowHideLayoutEditor').trigger('click');
        }      
      }
      
      if(view.indexOf("a") != -1) // found a so show layout editor if needed
      {
        if(!jQuery("#buttonToggleAttributes").prop("checked"))
        {
          jQuery('#buttonToggleAttributes').trigger('click');
        }
      }
      else // did NOT find a so hide attributes if needed
      {
        if(jQuery("#buttonToggleAttributes").prop("checked"))
        {
          jQuery('#buttonToggleAttributes').trigger('click');
        }
      }
      
      if(view.indexOf("m") != -1) // found m so show methods if needed
      {
        if(!jQuery("#buttonToggleMethods").prop("checked"))
        {
          jQuery('#buttonToggleMethods').trigger('click');
        }
      }
      else // did NOT find m so hide methods if needed
      {
        if(jQuery("#buttonToggleMethods").prop("checked"))
        {
          jQuery('#buttonToggleMethods').trigger('click');
        }      
      }
      
      //Diagram Type
      if(diagram.indexOf("e") != -1)
      {
        if(!jQuery("#buttonShowEditableClassDiagram").prop("checked"))
        {
          jQuery("#buttonShowEditableClassDiagram").trigger('click');
        }
      }      
      else if(diagram.indexOf("c") != -1)
      {
        if(!jQuery("#buttonShowGvClassDiagram").prop("checked"))
        {
          jQuery('#buttonShowGvClassDiagram').trigger('click');
        }
      }
      else if(diagram.indexOf("s") != -1)
      {
        if(!jQuery("#buttonShowGvStateDiagram").prop("checked"))
        {
          jQuery('#buttonShowGvStateDiagram').trigger('click');
        }
      }
      
      //Preferences
      if(preferences.indexOf("p") != -1) // Found p so make photo ready if needed
      {
        if(!jQuery("#buttonPhotoReady").prop("checked"))
        {
          jQuery('#buttonPhotoReady').trigger('click');
        }
      }
      else // did NOT find p so make non-photo ready if needed
      {
        if(jQuery("#buttonPhotoReady").prop("checked"))
        {
          jQuery('#buttonPhotoReady').trigger('click');
        }      
      }
      
      if(preferences.indexOf("s") != -1) // Found s so make manual sync if needed
      {
        if(!jQuery("#buttonManualSync").prop("checked"))
        {
          jQuery('#buttonManualSync').trigger('click');
        }
      }
      else // did NOT find s so get rid of manual sync if needed
      {
        if(jQuery("#buttonManualSync").prop("checked"))
        {
          jQuery('#buttonManualSync').trigger('click');
        } 
      }      
    });
  }
});


//This is activated when the user closes/refreshes the page
window.onbeforeunload = function(event) {
  //Get Expiration datetime
    var date = new Date();
    date.setTime(date.getTime()+(30*24*60*60*1000));
  
  //If the umple code is not blank, save the model.
  if(!(Page.getUmpleCode() === "//$?[End_of_model]$?"))
  {
    //First store the filename of the Umple Code
    document.cookie =  "filecode=" + Page.getFilename() + ";" + "expires="+date.toGMTString() + ";";
    
    //These were settings the user set
    //Used single letter to save space
    //Show View
    cookie_view = "VIEW=";
    if(jQuery("#buttonShowHideCanvas").prop("checked"))
      cookie_view += "d";
    if(jQuery("#buttonShowHideTextEditor").prop("checked"))
      cookie_view += "t";
    if(jQuery("#buttonShowHideLayoutEditor").prop("checked"))
      cookie_view += "l";
    if(jQuery("#buttonToggleAttributes").prop("checked"))
      cookie_view += "a";
    if(jQuery("#buttonToggleMethods").prop("checked"))
      cookie_view += "m"
    if(jQuery("#buttonToggleTransitionLabel").prop("checked"))
      cookie_view += "r";
    if(jQuery("#buttonToggleGuardLabel").prop("checked"))
      cookie_view += "g";
    cookie_view += ";" + "expires="+date.toGMTString() + ";";    
    document.cookie = cookie_view;
      
    //Diagram Type
    cookie_diagram = "DIAGRAM=";
    if(jQuery("#buttonShowEditableClassDiagram").prop("checked"))
      cookie_diagram += "e";
    else if(jQuery("#buttonShowGvClassDiagram").prop("checked"))
      cookie_diagram += "c";
    else if(jQuery("#buttonShowGvStateDiagram").prop("checked"))
      cookie_diagram += "s";      
    cookie_diagram += ";" + "expires="+date.toGMTString() + ";";  
    document.cookie = cookie_diagram;        
  }
                
  //Preferences
  cookie_pref = "PREF=";
  if(Action.gdprHidden)
    cookie_pref += "g";
  if(jQuery("#buttonPhotoReady").prop("checked"))
    cookie_pref += "p";
  if(jQuery("#buttonManualSync").prop("checked"))
    cookie_pref += "s";
  cookie_pref += ";" + "expires="+date.toGMTString() + ";";    
  document.cookie = cookie_pref;
};
function existSCookie(name) {
    return document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')
}

function setCookieBeforeClose(mode){
    if (mode=="on"){
        window.onbeforeunload = function(){ 
            //set timed cookies before the next appearance of the survey
            if(window.randomSurveyRoll != 1){
                setSurveyCookie(60)
            }
            else if (notToday){
                setSurveyCookie(1);
            }
            else if (clickedForMoreSurvey == false && clickedStartSurvey == false){ // ignored survey message
                setSurveyCookie(15);
            }
            else if (clickedForMoreSurvey == true && clickedStartSurvey == false){ // checked out RecruitementMessage only
                setSurveyCookie(30);
            }
            else {
                setSurveyCookie(60)
            }
        };
    }
    else{
        window.onbeforeunload = function(){};
    }
}

function groupHideToday(){
    hideRecruitementMessage();
    if (document.getElementById("surveyMessage")!=null){
        document.getElementById("mainSurveySpan").removeChild(document.getElementById("surveyMessage"));
        document.getElementById("mainSurveySpan").removeChild(document.getElementById("surveyExtra"));
    }
    notToday=true;
}

// ##########
// MAIN
// ##########

// checks if Recruitment Message has been seen
var clickedForMoreSurvey = false;
// checks if user followed survey URL
var clickedStartSurvey = false;

// ensures survey message has been displayed
var displayedText=false;
var notToday=false;
var timeSurveyUp = false;

// confirm user hasn't completed any survey, is past the 15-/30-/60-day probation period (allocated onbeforeunload)
if (existSCookie("surveyCookie") == null && window.surveyData!=null){
    if (window.randomSurveyRoll == 1){ // rolled 1 in umple.php file
        // ensure user has not completed this survey yet by comparing URLs
        var surveySeen = window.localStorage.getItem("surveyShown");
        if (surveySeen == null || surveySeen != window.surveyData.SurveyURL){
            if (timeSurvey) // clear any loading setTimeout function
                clearTimeout(timeSurvey);
            // set delay for MinutesBeforePrompt
            var timeSurvey = setTimeout(function(){timeSurveyUp = true;}, window.surveyData.MinutesBeforePrompt*60*1000);
            timeSurvey;
            //count number of edits made to page
            var beforeInstance = TabControl.getCurrentHistory().currentIndex;
            if (!displayedText){
                document.addEventListener("mouseover", function(){
                    if (TabControl.getCurrentHistory().currentIndex-beforeInstance > window.surveyData.EditsBeforePrompt && !displayedText && timeSurveyUp){
                        displaySurvey();
                        this.removeEventListener('mouseover', arguments.callee);
                    }                        
                });
            }
        }
    }
    setCookieBeforeClose("on");
}

function setSurveyCookie(days){
    let currentTime=new Date(Date.now() + days*24*60*60*1000);
    document.cookie="surveyCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
}

// creates text nodes for survey message
function displaySurvey(){
    displayedText = true;
    var surveyArea = document.getElementById("mainSurveySpan");

    if (!surveyArea.contains(document.getElementById("surveyMessage"))){
        //creating space for InvitationalMessage
        var surveyMessage = document.createElement("span");
        surveyMessage.innerHTML='<span><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey" onmouseover="showRecruitementMessage()">'+window.surveyData.InvitationalMessage+'</a></span><br/>';
        surveyMessage.id="surveyMessage";
        surveyArea.appendChild(surveyMessage);

        //creating space for RecruitementMessage
        var surveyExtra = document.createElement("span");
        surveyExtra.innerHTML=window.surveyData.RecruitmentText +'<div id="surveyPopUp"><span class="linkToSurvey" onclick="countClicked()"><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey"class="linkToSurvey">Start Survey</a></span><span onclick="groupHideToday()" class="linkToNotSurvey">Not Today</span></div>';
        surveyExtra.id="surveyExtra";
        surveyArea.appendChild(surveyExtra);

        surveyExtra.addEventListener("mouseleave", function(){hideRecruitementMessage()});
        surveyMessage.addEventListener("click", function(){countClicked()});

        sendToSurveyLog("SurveyRequested");
    }
}

// Show/Hide Functions

function showRecruitementMessage(){
    clickedForMoreSurvey = true;
    if (!document.getElementById('surveyExtra').classList.contains("fade-in")){
        document.getElementById('surveyExtra').classList.remove("fade-outInst");
        document.getElementById('surveyExtra').classList.add("fade-in");
    }
}

function hideRecruitementMessage(){
    if (!document.getElementById('surveyExtra').classList.contains("fade-outInst")){
        document.getElementById('surveyExtra').classList.remove("fade-in");
        document.getElementById('surveyExtra').classList.add("fade-outInst");
    }
}

// confirms user has accessed survey URL
function countClicked(){
    window.localStorage.setItem("surveyShown", window.surveyData.surveyURL);
    clickedStartSurvey = true;

    sendToSurveyLog("SurveyClicked");
}

function sendToSurveyLog(action){ // action is either SurveyRequested or SurveyClicked
    console.log("processing");
    let recordTime=new Date(Date.now()).toString();
    if (action=="SurveyRequested"){
        jQuery.ajax({
            url: 'umple.php',
            method: 'POST',
            data: {surveyLogInfo: "\n"+action+" "+recordTime},
            dataType: 'html',
        }).done(function(){
            console.log("Success: Files sent!");
        }).fail(function(){
            console.log("An error occurred, the files couldn't be sent!");
        });
    }
    if(action=="SurveyClicked"){
        jQuery.ajax({
            url: 'umple.php',
            method: 'POST',
            data: {surveyLogInfo2: "\n"+action+" "+recordTime},
            dataType: 'html',
        }).done(function(){
            console.log("Success: Files sent!");
        }).fail(function(){
            console.log("An error occurred, the files couldn't be sent!");
        });
    }
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models an Umple model containing classes and associations
// in the graphical view of UmpleOnline

UmpleSystem = new Object();
UmpleSystem.umpleClasses = [];
UmpleSystem.umpleAssociations = [];
UmpleSystem.umpleTransitions = [];
  
UmpleSystem.position = function()
{
  var canvas = jQuery("#umpleCanvas");
  var x = Math.ceil(canvas.offset().left - canvas.scrollLeft()); 
  var y = Math.ceil(canvas.offset().top - canvas.scrollTop());
  var p = new UmplePosition(x,y,0,0);
  return p;
}

UmpleSystem.findIn = function(allUmpleElements,diagramId)
{
  if (allUmpleElements == null) return null;
  
  for (var i=0; i<allUmpleElements.length; i++)
  {
    var umpleElement = allUmpleElements[i];
    if (umpleElement.id == diagramId)
    {
      return umpleElement;
    }
  }
  return null;
}

UmpleSystem.find = function(diagramId)
{
  return UmpleSystem.findIn(this.umpleClasses,diagramId);
}

UmpleSystem.findAssociation = function(diagramId)
{
  var association = UmpleSystem.findIn(this.umpleAssociations,diagramId); 
  return association;
}

/* New association is being added via the diagram - this
 * method creates the association object and adds it
 * to the Umple System */
UmpleSystem.createAssociation = function(classOneId, classTwoId, screenOnePosition, screenTwoPosition)
{
  // create association object
  var umpleAssociation = new UmpleAssociation();

  // set its attributes according to parameters
  umpleAssociation.id = this.nextAssociationId();
  umpleAssociation.setClasses(classOneId, classTwoId);
  umpleAssociation.setOffsetOnePosition(screenOnePosition);
  umpleAssociation.setOffsetTwoPosition(screenTwoPosition);
  umpleAssociation.setDefaultMultiplicities();
  umpleAssociation.setDefaultRoles();
  umpleAssociation.setName(umpleAssociation.getName());
  // adjust the association start and end points to snap the association to the class edges
  if(classOneId == classTwoId)
  {
    umpleAssociation.adjustReflexiveEndpoints();
  }
  else
  {
    umpleAssociation.trimOverlap();
  }

  // add it to the Umple System
  return this.addAssociation(umpleAssociation);
}

/* New transition is being added via the diagram - this
* method creates the transition object and adds it
* to the Umple System */
UmpleSystem.createTransition = function(fromTransitionId, toTransitionId)
{
    // create transition object
    var umpleTransition = new UmpleTransition();

    // set its attributes according to parameters
    umpleTransition.id = this.nextTransitionId();
    umpleTransition.setStates(fromStateId, toStateId);
    umpleTransition.setDefaultEvent();
    umpleTransition.setName(umpleTransition.getName());

    // add it to the Umple System
    return this.addTransition(umpleTransition);
}

UmpleSystem.createGeneralization = function(childId, parentId)
{
  var child = UmpleSystem.find(childId);
  child.extendsClass = parentId;
  UmpleSystem.updateClass(child);
}

/* Add association to the umple system */
UmpleSystem.addAssociation = function(umpleAssociation)
{
  this.umpleAssociations.push(umpleAssociation);
  var associationDiv = this.redrawAssociation(umpleAssociation);
  
  return umpleAssociation;
}

/* Add transition to the umple system */
UmpleSystem.addTransition = function(umpleTransition)
{
    this.umpleTransitions.push(umpleTransition);
    var transitionDiv = this.redrawTransition(umpleTransition);

    return umpleTransition;
}

/* Create a new class to be added to the Umple System
 * 
 */
UmpleSystem.createClass = function(screenPosition)
{
  // create the class object
  var umpleClass = new UmpleClass();
  
  // set the default ID and other attributes
  umpleClass.id = this.nextId("NewClass");
  umpleClass.name = umpleClass.id;
  umpleClass.position.set(screenPosition.x - UmpleSystem.position().x, screenPosition.y - UmpleSystem.position().y, UmpleClassFactory.defaultSize.width, UmpleClassFactory.defaultSize.height);
  
  // add the class to the Umple System and draw
  // any generalizations lines that lead to it
  var addedClass = this.addClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(addedClass);
  return addedClass;
}

UmpleSystem.addClass = function(umpleClass)
{
  this.umpleClasses.push(umpleClass);
  this.updateClass(umpleClass);
  
  var classObj = jQuery("#" + umpleClass.id);
  
  classObj.click(Action.classClicked);
  classObj.mouseover(function(event) { Action.classHover(event,true);} );
  classObj.mouseout(function(event) { Action.classHover(event,false);} );
  classObj.mousedown(function(event) { setTimeout(function(){Action.classMouseDown(event);}, 400);} );
  // classObj.touchstart(function(event) { setTimeout(function(){Action.classMouseDown(event);}, 400);} );
  classObj.mouseup(function(event){ Action.classMouseUp(event); });
  // classObj.touchend(function(event){ Action.classMouseUp(event); });
   if (!Page.readOnly) 
   {
    classObj.draggable
    ({
     containment:'parent', 
     stop:function(event,ui){DiagramEdit.classMoved(event.target
    )}
   });
  /*     classObj.resizable
  ({
	  minHeight:UmpleClassFactory.defaultSize.height, 
	  minWidth:UmpleClassFactory.defaultSize.width, 
	  autoHide:true,
	  containment:'parent',
	  resize:function(event,ui){DiagramEditclassResizing(event,ui);},
	  stop:function(event,ui){DiagramEditclassResized(event,ui);}
  }); */
}

// remove the jquery resizable handle
jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
  //UmpleSystem.redrawGeneralizationsTo(umpleClass);
  return umpleClass;   
}

UmpleSystem.replaceClass = function(newClass)
{
  for (var i=0; i< this.umpleClasses.length; i++)
  {
    var existingClass = this.umpleClasses[i];
    if (existingClass.id == newClass.id)
    {
      var classSel = "#" + existingClass.id;
      var generalizationSel = classSel + "_generalization";
      var existingClassDiv = jQuery(classSel).get();
      var existingGeneralizationDiv = jQuery(generalizationSel).get();
      
      jQuery(existingClassDiv).attr("id", newClass.id);
      
      if (existingGeneralizationDiv != undefined)
      {
      	jQuery(existingGeneralizationDiv).attr("id", newClass.id + "_generalization");
      	jQuery(existingGeneralizationDiv).remove();
      }
      
      this.umpleClasses[i] = newClass;
      this.updateClass(this.umpleClasses[i]);
      
      return;
    }
  }
}

UmpleSystem.renameClass = function(diagramId, oldName, newName)
{
  var umpleClass = UmpleSystem.find(diagramId);
  var classSel = "#" + diagramId;
  var generalizationSel = classSel + "_generalization";
  
  newName = this.nextId(newName);
  umpleClass.id = newName;
  umpleClass.name = newName;
  umpleClass.oldname = oldName;
  
  jQuery(classSel).attr("id", umpleClass.id);
  if (jQuery(generalizationSel).get() != undefined)
  {
  	jQuery(generalizationSel).attr("id", umpleClass.id + "_generalization");
  }
  
  for (var i=0; i< this.umpleAssociations.length; i++)
  {
    var existingAssociation = this.umpleAssociations[i];
    if (existingAssociation.classOneId == oldName)
    {
      existingAssociation.classOneId = umpleClass.id;
    }
    if (existingAssociation.classTwoId == oldName)
    {
      existingAssociation.classTwoId = umpleClass.id;
    }
  }
  
  for (var i=0; i< this.umpleClasses.length; i++)
  {
  	var child = this.umpleClasses[i];
  	if (child.extendsClass == oldName)
  	{
  	  child.extendsClass = newName;
  	  this.updateClass(child);
  	}
  }
  
  UmpleSystem.updateClass(umpleClass);
  
  return umpleClass;
}

UmpleSystem.replaceAssociation = function(newAssociation)
{
  for (var i=0; i< this.umpleAssociations.length; i++)
  {
    var existingAssociation = this.umpleAssociations[i];
    if (existingAssociation.id == newAssociation.id)
    {
      this.umpleAssociations[i] = newAssociation;
      index = i;
    }
  }
   
  this.redrawAssociation(newAssociation);
  return;
}

UmpleSystem.updatePosition = function(umpleClass,screenX,screenY)
{
  umpleClass.position.x = screenX - UmpleSystem.position().x;
  umpleClass.position.y = screenY - UmpleSystem.position().y;
  UmpleSystem.redrawAssociationsFor(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);
  UmpleSystem.updateClass(umpleClass);
}

UmpleSystem.updateClass = function(umpleClass)
{
  var divs = umpleClass.drawable();
  var classDiv = divs[0];
  var generalizationDiv = divs[1];
  
  var canvas = jQuery("#" + Page.umpleCanvasId());
  var classObj = jQuery("#" + umpleClass.id);
  canvas.append(classDiv);
  //canvas.append(generalizationDiv);
  if(generalizationDiv != null)
  {
    for(var i=0; i<generalizationDiv.length; i++)
    {
      canvas.append(generalizationDiv[i]);
    }
    
  }
  
  UmpleSystem.redraw(umpleClass);

  
  var buffer = 2;
  var isDirty = false;
  
  if (classObj.width() > umpleClass.position.width + buffer)
  {
    umpleClass.position.width = classObj.width();
    isDirty = true;
  }
  
  if (classObj.height() > umpleClass.position.height + buffer)
  {
    umpleClass.position.height = classObj.height();
    isDirty = true;
  }
  if (isDirty)
  {
    UmpleSystem.redraw(umpleClass);    
  }  
  
/*  classObj.resizable("destroy");
  classObj.resizable
  ({
    minHeight:UmpleClassFactory.defaultSize.height, 
    minWidth:UmpleClassFactory.defaultSize.width, 
    autoHide:true,
    containment:'parent',
    resize:function(event,ui){DiagramEditclassResizing(event,ui);},
    stop:function(event,ui){DiagramEditclassResized(event,ui);}
  }); */
  
  //remove the jquery resizable handle
  jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
}

UmpleSystem.redrawAssociationsFor = function(umpleClass)
{
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      UmpleSystem.redrawAssociation(umpleAssociation);
    }
  }
}

UmpleSystem.redrawAssociation = function(umpleAssociation)
{
  var associationSel = "#" + umpleAssociation.id;
  var canvasSel = "#" + Page.umpleCanvasId();
  var associationDiv = null;
  
  associationDiv = umpleAssociation.drawable();
  jQuery(canvasSel).append(associationDiv);
  
  if (!Page.isPhotoReady())
  {
    jQuery(associationSel).click(Action.associationClicked);
    jQuery(associationSel).mouseover(function(event) { Action.associationHover(event,true); });
    jQuery(associationSel).mouseout(function(event) { Action.associationHover(event,false); });
    UmpleSystem.setDragableAssociationAnchor(umpleAssociation,0);
    UmpleSystem.setDragableAssociationAnchor(umpleAssociation,1);
  }
  
  return associationDiv;
}

UmpleSystem.redrawTransition = function(umpleTransition)
{
    var transitionSel = "#" + umpleTransition.id;
    var canvasSel = "#" + Page.umpleCanvasId();
    var transitionDiv = null;

    transitionDiv = umpleTransition.drawable();
    jQuery(canvasSel).append(transitionDiv);

    if (!Page.isPhotoReady())
    {
        jQuery(transitionSel).click(Action.transitionClicked);
    }

    return transitionDiv;
}


UmpleSystem.redrawGeneralizationsTo = function(parent)
{
  for (var i=0; i<this.umpleClasses.length; i++)
  {
  	var umpleClass = this.umpleClasses[i];
  	if (umpleClass.extendsClass == parent.id) 
  	{
  	  this.updateClass(umpleClass);
  	}
    else if(umpleClass.interfaces.length > 0)
    {
      for (var j = 0; j < umpleClass.interfaces.length; j++)
      {
        if ( umpleClass.interfaces[j] == parent.id)
        {
          this.updateClass(umpleClass);
        }
       
      }
    }
  }
}

UmpleSystem.update = function()
{
  for(var i = 0; i<this.umpleClasses.length;++i)
  {
    var umpleClass = this.umpleClasses[i];
    umpleClass.position.height = 28;
    if(Page.showAttributes)
      umpleClass.position.height += 17*(umpleClass.attributes.size());
    if(Page.showMethods)
      umpleClass.position.height += 17*(umpleClass.methods.size());
    UmpleSystem.updateClass(umpleClass);
  }

  for(var i = 0; i<this.umpleAssociations.length;++i)
  {
    var umpleClass1 = UmpleSystem.find(this.umpleAssociations[i].classOneId);
    var x = this.umpleAssociations[i].offsetOnePosition.x+umpleClass1.position.x+UmpleSystem.position().x;
    var y = this.umpleAssociations[i].offsetOnePosition.y+umpleClass1.position.y+UmpleSystem.position().y;
    var xys1 =  Action.associationSnapClassReady(x,y,umpleClass1);

    var umpleClass2 = UmpleSystem.find(this.umpleAssociations[i].classTwoId);
    x = this.umpleAssociations[i].offsetTwoPosition.x+umpleClass2.position.x+UmpleSystem.position().x;
    y = this.umpleAssociations[i].offsetTwoPosition.y+umpleClass2.position.y+UmpleSystem.position().y;
    var xys2 =  Action.associationSnapClassReady(x,y,umpleClass2);

    var screenPosition1 = new UmplePosition(xys1[0],xys1[1],0,0);
    var screenPosition2 = new UmplePosition(xys2[0],xys2[1],0,0);

    this.umpleAssociations[i].setOffsetOnePosition(screenPosition1);
    this.umpleAssociations[i].setOffsetTwoPosition(screenPosition2);
    UmpleSystem.redrawAssociation(this.umpleAssociations[i]);
  }
  
  for(var i = 0; i<this.umpleClasses.length;++i)
  {
    UmpleSystem.trimOverlappingAssociations(this.umpleClasses[i]);
  }

}

UmpleSystem.redraw = function(umpleClass)
{
  var screenX = umpleClass.position.x + UmpleSystem.position().x;
  var screenY = umpleClass.position.y + UmpleSystem.position().y;
  
  var classSel = "#" + umpleClass.id;
  var generalizationSel = classSel + "_generalization";
  var widthSel = classSel + "_width";
  var heightSel = classSel + "_height";
  
  var offset = new Object();
  offset.top = screenY;
  offset.left = screenX;
  jQuery(classSel).offset(offset);
  jQuery(widthSel).width(umpleClass.position.width);
  jQuery(heightSel).height(umpleClass.position.height);
  
  if (!Page.isPhotoReady())
  {
    // The following can be deleted
/*    UmpleSystem.updateAnchor(umpleClass,0);
    UmpleSystem.updateAnchor(umpleClass,1);
    UmpleSystem.updateAnchor(umpleClass,2);
    UmpleSystem.updateAnchor(umpleClass,3);
    UmpleSystem.updateAnchor(umpleClass,4);
    UmpleSystem.updateAnchor(umpleClass,5);
    UmpleSystem.updateAnchor(umpleClass,6);
    UmpleSystem.updateAnchor(umpleClass,7);
*/    
    var generalizationDiv = jQuery(generalizationSel).get();
    if(generalizationDiv != undefined)
    {
      jQuery(generalizationSel).click(Action.generalizationClicked);
      jQuery(generalizationSel).mouseover(function(event) { Action.generalizationHover(event,true); });
      jQuery(generalizationSel).mouseout(function(event) { Action.generalizationHover(event,false); });
    }
  }
  
  this.redrawAssociationsFor(umpleClass);
}

UmpleSystem.trimOverlappingAssociations = function(umpleClass)
{
  // trim any association that may now overlap a class

  Page.showLayoutLoading();

  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    
    if (umpleAssociation.contains(umpleClass))
    {
      var oldOffsetOne = UmplePositionFactory.copy(umpleAssociation.offsetOnePosition); 
      var oldOffsetTwo = UmplePositionFactory.copy(umpleAssociation.offsetTwoPosition);

      if(umpleAssociation.isReflexive()) 
        umpleAssociation.adjustReflexiveEndpoints();
      else 
        umpleAssociation.trimOverlap();

      // if an offset position has changed, update the association
      if (!oldOffsetOne.equalsIgnoreSize(umpleAssociation.offsetOnePosition) ||
          !oldOffsetTwo.equalsIgnoreSize(umpleAssociation.offsetTwoPosition))
      {
        Page.showLayoutLoading();
        // redraw the association
        UmpleSystem.redrawAssociation(umpleAssociation);
        
        // prepare an update call to the back and add it to the queue
        var editAssociation = Json.toString(umpleAssociation);
        DiagramEdit.updateUmpleText({
          actionCode: format("action=editAssociation&actionCode={0}",editAssociation),
          codeChange: false
        });
      }
    }
  }

  if (UmpleSystem.umpleAssociations.length == 0){
    Action.setjustUpdatetoSaveLater(false);
  }

  Page.hideLoading()
}

// The following can be deleted
UmpleSystem.updateAnchor = function(umpleClass,index)
{
  var classSel = "#" + umpleClass.id;
  var anchorSel = classSel + "_anchor" + index;
  var hoverSel = classSel + "_hover" + index;
  
  var position = "";
  
  switch (index)
  {
    case 0: position = "left top"; 		break;
    case 1: position = "left center"; 	break;
    case 2: position = "left bottom"; 	break;
    case 3: position = "center bottom"; break;
    case 4: position = "right bottom";	break;
    case 5: position = "right center"; 	break;
    case 6: position = "right top"; 	break;
    case 7: position = "center top";	break;
  }
  
  jQuery(anchorSel).show(); //jQuery does not support .position() on hidden elements
  jQuery(hoverSel).show();
  jQuery(anchorSel).position({my:"center", at:position, of:classSel});
  jQuery(hoverSel).position({my:"center", at:position, of:classSel});
  jQuery(anchorSel).hide();
  jQuery(hoverSel).hide();
}

UmpleSystem.setDragableAssociationAnchor = function(umpleAssociation,anchorNbr)
{
  if (Page.readOnly) {return}
  
  if (umpleAssociation.isReflexive())
  {
    var anchorSel = "#" + umpleAssociation.id + "_anchor" + anchorNbr;
    var umpleClassId = anchorNbr == 0 ? umpleAssociation.classOneId : umpleAssociation.classTwoId;
    
    jQuery(anchorSel).draggable
    ({
    	drag: function(event, ui) {DiagramEdit.reflexiveAssociationMoving("#" + event.target.id);},
    	stop: function(event, ui) {DiagramEdit.associationMoved("#" + event.target.id);},
    	cursor: 'pointer',
    	snap: '#' + umpleClassId,
    	snapTolerance: 5,
    	containment: '#' + umpleClassId, 
    	zIndex: 1
    });
  }
  else
  { 
    var anchorSel = "#" + umpleAssociation.id + "_anchor" + anchorNbr;
    var umpleClassId = anchorNbr == 0 ? umpleAssociation.classOneId : umpleAssociation.classTwoId;
    
    jQuery(anchorSel).draggable
    ({
    	drag: function(event, ui) {DiagramEdit.regularAssociationMoving("#" + event.target.id);},
    	stop: function(event, ui) {DiagramEdit.associationMoved("#" + event.target.id);},
    	cursor: 'pointer',
    	snap: '#' + umpleClassId,
    	snapTolerance: 5,
    	containment: '#' + umpleClassId,
    	zIndex: 1
    });
  }  
}

UmpleSystem.updatingSize = function(umpleClass,newWidth,newHeight)
{
  umpleClass.position.width = newWidth;
  umpleClass.position.height = newHeight;
  UmpleSystem.redraw(umpleClass);
}

UmpleSystem.removeClass = function(diagramId)
{
  for (var i=0; i<this.umpleClasses.length; i++)
  {
    var umpleClass = this.umpleClasses[i];
    if (umpleClass.id == diagramId)
    {
      this.umpleClasses.splice(i,1);
      var classSel = "#" + diagramId;
      var generalizationSel = classSel + "_generalization";
      
      jQuery(classSel).remove();
      jQuery(generalizationSel).remove();
      
      return umpleClass;
    }
  }
  return null;
}

UmpleSystem.removeAssociation = function(diagramId)
{
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    if (umpleAssociation.id == diagramId)
    {
      this.umpleAssociations.splice(i,1);
      
      var associationSel = "#" + diagramId;
      jQuery(associationSel).remove();
      
      return umpleAssociation;
    }
  }
  return null;
}

UmpleSystem.removeTransition = function(diagramId)
{
    for (var i=0; i<this.umpleAssociations.length; i++)
    {
        var umpleTransition = this.umpleAssociations[i];
        if (umpleTransition == diagramId)
        {
            this.umpleTransitions.splice(i,1);

            var transitionSel = "#" + diagramId;
            jQuery(transitionSel).remove();

            return umpleTransition;
        }
    }
    return null;
}

UmpleSystem.removeGeneralization = function(diagramId)
{
  var generalizationSel = "#" + diagramId;
  jQuery(generalizationSel).remove();
  
  var umpleClassId = diagramId.replace("_generalization", "");
  var umpleClass = UmpleSystem.find(umpleClassId);
  umpleClass.extendsClass = null;
  
  var umpleGeneralization = new UmpleGeneralization();
  umpleGeneralization.childId = umpleClass.id;
  umpleGeneralization.parentId = umpleClass.extendsClass;
  
  return umpleGeneralization;
}

UmpleSystem.redrawCanvas = function()
{
  UmpleSystem.merge(UmpleSystem);
}

UmpleSystem.merge = function(newSystem)
{
  UmpleSystem.mergeClasses(newSystem);
  UmpleSystem.mergeAssociations(newSystem);
}

UmpleSystem.mergeClasses = function(newSystem)
{
  if (newSystem == null)
  {
    while (this.umpleClasses.length > 0)
    {
      this.removeClass(this.umpleClasses[0].id);
    }
    return;
  }
  
  for (var i=0; i<this.umpleClasses.length; i++)
  {
    var umpleClass = this.umpleClasses[i];
    var newClass = this.findIn(newSystem.umpleClasses,umpleClass.id);
    
    if (newClass == null)
    {
      i -= 1;
      this.removeClass(umpleClass.id);
    }
    else
    {
      this.replaceClass(UmpleClassFactory.create(newClass));
    }
  }
  
  for (var i=0; i<newSystem.umpleClasses.length; i++)
  {
  	var newClass = newSystem.umpleClasses[i];
  	var existingClass = this.find(newClass.id);
    
    if (existingClass == null)
    {
      this.addClass(UmpleClassFactory.create(newClass));
    }
  }
  
  for (var i=0; i<this.umpleClasses.length; i++)
  {
  	var umpleClass = this.umpleClasses[i]; 
  	if (umpleClass.extendsClass != null || umpleClass.interfaces.length >0)
  	{
      this.updateClass(umpleClass);
  	}
  }
}

UmpleSystem.mergeAssociations = function(newSystem)
{
  if (newSystem == null)
  {
    while (this.umpleAssociations.length > 0)
    {
      this.removeAssociation(this.umpleAssociations[0].id);
    }
    return;
  }
  
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    var newAssociation = this.findIn(newSystem.umpleAssociations,umpleAssociation.id);
    
    if (newAssociation == null)
    {
      i -= 1;
      this.removeAssociation(umpleAssociation.id);
    }
    else
    {
      this.replaceAssociation(UmpleAssociationFactory.create(newAssociation));
    }
  }
  
  for (var i=0; i<newSystem.umpleAssociations.length; i++)
  {
    var existingAssociation = this.findAssociation(newSystem.umpleAssociations[i].id);
    
    if (existingAssociation == null)
    {
      var newAssociation = UmpleAssociationFactory.create(newSystem.umpleAssociations[i]);
      this.addAssociation(newAssociation);
    }
  }
}

UmpleSystem.nextId = function(desiredName)
{
  var template = "umpleElement_";
  var nextElementId = template + "0";
  if (typeof(desiredName) != "undefined")
  {
    template = desiredName;
    nextElementId = desiredName;
  }

  var found = false;
  var nextIndex = 0;
  while (nextIndex < 100 && !found)
  {
    if (nextIndex > 0)
    {
    nextElementId = template + nextIndex;
    }
    found = true;
    for (var i=0; i<this.umpleClasses.length; i++)
    {
      if (this.umpleClasses[i].id == nextElementId)
      {
        found = false;
        nextIndex += 1;
        break;
      }
    }
    if (found)
    {
      return nextElementId;
    }
  }
  return "";
}

UmpleSystem.nextAssociationId = function(desiredName)
{
  var template = "umpleAssociation_";
  var nextElementId = template + "0";
  if (typeof(desiredName) != "undefined")
  {
    template = desiredName;
    nextElementId = desiredName;
  }

  var found = false;
  var nextIndex = 0;
  while (nextIndex < 100 && !found)
  {
    if (nextIndex > 0)
    {
    nextElementId = template + nextIndex;
    }
    found = true;
    for (var i=0; i<this.umpleAssociations.length; i++)
    {
      if (this.umpleAssociations[i].id == nextElementId)
      {
        found = false;
        nextIndex += 1;
        break;
      }
    }
    if (found)
    {
      return nextElementId;
    }
  }
  return "";
}

UmpleSystem.nextTransitionId = function(desiredName)
{
    var template = "umpleTransition_";
    var nextElementId = template + "0";
    if (typeof(desiredName) != "undefined")
    {
        template = desiredName;
        nextElementId = desiredName;
    }

    var found = false;
    var nextIndex = 0;
    while (nextIndex < 100 && !found)
    {
        if (nextIndex > 0)
        {
            nextElementId = template + nextIndex;
        }
        found = true;
        for (var i=0; i<this.umpleTransitions.length; i++)
        {
            if (this.umpleTransitions[i].id == nextElementId)
            {
                found = false;
                nextIndex += 1;
                break;
            }
        }
        if (found)
        {
            return nextElementId;
        }
    }
    return "";
}

TabControl = new Object();

// Constants
TabControl.maxTabs = 10;
TabControl.maxNameLength = 32;
TabControl.defaultTabName = "Untitled";
TabControl.showHideKey = "showUmpleTabs";

TabControl.requestQueue = [];
TabControl.remoteDelim = "%NAME:CONTENT:DELIM%";

// Regular expressions used to validate names as valid filenames
TabControl.illegalNameRegxp = /[\/\?<>\\:\*\|":]/g;
TabControl.controlNameRegxp = /[\x00-\x1f\x80-\x9f]/g;
TabControl.reservedNameRegxp = /^\.+$/;
TabControl.windowsReservedNameRegxp = /^(con|prn|aux|nul|com[0-9]|lpt[0-9])(\..*)?$/i;
TabControl.windowsTrailingRegxp = /[\. ]+$/;
TabControl.nameReplacement = "_";

/**
 * Initializes the tab control.
 */
TabControl.init = function()
{
  jQuery("#tabs").sortable({
    axis: "x",
    helper: 'clone',
    items: "li:not(.unsortable)",
    update: TabControl.saveActiveTabs,
  });

  jQuery.fn.selectText = function(){
    var doc = document;
    var element = this[0];
    if (doc.body.createTextRange) {
        var range = document.body.createTextRange();
        range.moveToElementText(element);
        range.select();
    } else if (window.getSelection) {
        var selection = window.getSelection();
        var range = document.createRange();
        range.selectNodeContents(element);
        selection.removeAllRanges();
        selection.addRange(range);
    }
  };

  TabControl.reset();
  if (!localStorage[TabControl.showHideKey])
  {
    TabControl.hideTabs();
  }
  TabControl.loadAllTabs();
}

/**
 * Shows the tab control div.
 */
TabControl.showTabs = function()
{
  jQuery('#toggleTabsButton').html('Hide Tabs');
  jQuery("#tabControl").show();
  localStorage[TabControl.showHideKey] = true;
 // document.getElementById("toggleTabsButton").innerHTML = "Hide Tabs"; 
}

/**
 * Hides the tab control div.
 */
TabControl.hideTabs = function()
{
  jQuery('#toggleTabsButton').html('Show Tabs');  
  jQuery("#tabControl").hide();
  delete localStorage[TabControl.showHideKey];
 // document.getElementById("toggleTabsButton").innerHTML = "Show Tabs";  
}

/**
 * Save the order of the active tabs.
 */
TabControl.saveActiveTabs = function()
{
  var tabNames = [];
  jQuery(".tabname").each(function()
  {
    tabNames.push(jQuery(this).text())
  });
  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    function(response){},
    format("index=1&&model={0}&&orderedTabNames={1}", Page.getModel(), encodeURIComponent(JSON.stringify(tabNames))));
}

/**
 * Returns the currently active tab ID.
 */
TabControl.getActiveTabId = function()
{
  return (TabControl.activeTab)? TabControl.activeTab.id : null;
}

/**
 * Return true if the tab control is hidden.
 */
TabControl.isHidden = function()
{
  return jQuery("#tabControl").is(":hidden");
}

/**
 * Resets the state of the tab control.
 */
TabControl.reset = function(){
  TabControl.activeTab = null;
  TabControl.tabs = {}
  TabControl.nextTabId = 1;
  TabControl.requestQueue = [];

  // Don't show tabs when there are tabs that are queued for loading
  TabControl.queuedTabs = 0;

  // Make sure that we don't let people create tabs called model. 
  TabControl.reservedNames = {"model": true};
}

/**
 * Returns a sanitized name suitable for filenames on all OS.
 */
TabControl.sanitizeName = function(name)
{
  var sanitized = name
    .replace(TabControl.illegalNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.controlNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.reservedNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.windowsReservedNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.windowsTrailingNameRegxp, TabControl.nameReplacement);
  return sanitized;
}

/**
 * Returns an auto-incremented name based on name availability.
 */
TabControl.findNextAvailableTabName = function(baseTabName)
{
  // Count upwards until we find a name that is available
  var tabName = baseTabName;
  var counter = 2;
  while (TabControl.reservedNames.hasOwnProperty(tabName)) {
    tabName = baseTabName + counter++;
  }
  return tabName;
}

/**
 * Returns first class name found in code.
 */
TabControl.extractNameFromCode = function(code)
{
  var classNameRegexp = /class[\s]*([a-zA-Z_$][a-zA-Z_$0-9]*)[\s]*{/g;
  var match = classNameRegexp.exec(code);
  if (match) return match[1];
}

/**
 * Creates a new tab.
 * name: name of the tab to create
 * fromRemote: true if code should be taken from remote (requires file with given name to exist)
 * resetCode: true if current editor code should not be used to create the new tab
 */
TabControl.createTab = function(name, code, shouldNotSaveActiveTabs)
{
  if (Page.readOnly && name == 'afterTabControlInit')
  {
    return;
  } else if (name == 'afterTabControlInit')
  {
    name = null;
  }

  // Enforce maximum number of tabs
  if (Object.keys(TabControl.tabs).length == TabControl.maxTabs) return;

  // Tab IDs auto-increment similar to PKs of a database
  var newTabId = TabControl.nextTabId++;
  var baseTabName = !name? TabControl.defaultTabName : name;
  if (code != null)
  {
    // Try to find a name from the code if we don't have a desired name
    // and we're not creating new code from scratch
    if (!name) {
      var extractedName = TabControl.extractNameFromCode(code);
      if (extractedName) baseTabName = extractedName;
    }
  }
  else
  {
    code = Page.modelDelimiter;
  }
  var tabName = TabControl.findNextAvailableTabName(baseTabName);
  
  // Create the tab entity - still need to wait for filename to be populated by server
  TabControl.tabs[newTabId] = {
    name: tabName,
    id: newTabId,
    history: History.getInstance(newTabId),
    nameIsEphemeral: name == null,
  };

  // Bind the code to the tab
  TabControl.reservedNames[tabName] = true;
  TabControl.saveTab(newTabId, code);

  // Create the physical tab element
  var createBtn = jQuery("#createTabBtn");
  var tabTemplate = jQuery('<li id="tab' + newTabId + '" class="">' + 
    '<a class="tabname" title="Double-click to rename tab" id="tabName' + newTabId + '" href="javascript:TabControl.selectTab(\'' + newTabId + '\');">' + tabName + '</a>' + 
      '<button class="tabbtn" onclick="javascript:TabControl.deleteTab(\'' + newTabId + '\');">&times;</button></li>');
  tabTemplate.insertBefore(createBtn);

  // Disable the create button if we've hit the maximum
  if (Object.keys(TabControl.tabs).length == TabControl.maxTabs) createBtn.hide();

  // Add event handlers to handle renaming
  var tabNameDiv = TabControl.getTabNameDiv(newTabId);
  handleNameEdit = function() {
    // Exit edit mode and deselect the text
    tabNameDiv.attr('contentEditable', false);
    if (window.getSelection) window.getSelection().removeAllRanges();
    else if (document.selection) document.selection.empty();

    // Sanitize the input to ensure that we can use it as a filename
    var newName = tabNameDiv.text();
    var oldName = TabControl.tabs[newTabId].name;

    // Do nothing on revert or no op
    if (newName === oldName)
    {
      return;
    }
    // Validation
    var nameIsValid = false;
    if (TabControl.sanitizeName(newName) !== newName)
    {
      alert("The name contains invalid characters. Please try again.");
    }
    else if (newName.length === 0 || newName.length > TabControl.maxNameLength)
    {
      alert("Name must be between 1 and " + TabControl.maxNameLength + " characters long. Please try again.");
    }
    else if (TabControl.reservedNames.hasOwnProperty(newName))
    {
      alert("This name is already in use. Please try again.")
    }
    else
    {
      nameIsValid = true;
    }

    if (nameIsValid)
    {
      // Apply renames
      tabNameDiv.text(newName);
      TabControl.renameTab(newTabId, newName);
    }
    else
    {
      // Revert the name if the name is invalid and reselect it
      tabNameDiv.text(oldName);
      tabNameDiv.selectText();
      tabNameDiv.attr('contentEditable', true);
    }
  }

  // Double-click to begin edit mode
  tabNameDiv.bind('dblclick', function() {
    tabNameDiv.attr('contentEditable', true);
    tabNameDiv.focus();
    tabNameDiv.selectText();
  // Both blur and enter keypress exits edit mode
  }).blur(handleNameEdit).keypress(function(e) {
    var enterKeyCode = 13;
    var deleteKeyCode = 8;
    if(e.which == enterKeyCode) tabNameDiv.blur();
    if(e.which != deleteKeyCode && tabNameDiv.text().length >= TabControl.maxNameLength) e.preventDefault();
  });
  
  // Don't save active tabs as we populate them from remote
  if (!shouldNotSaveActiveTabs)
  {
    TabControl.saveActiveTabs();
  }

  // If we're just creating a new tab, select it after we save it
  TabControl.selectTab(newTabId);
}

/**
 * Saves the code contents of a tab to the remote file.
 * tabId: the ID of the tab to save
 * umpleCode: the code to save to the tab
 * isNewTab: true if the save corresponds to a newly created tab
 */
TabControl.saveTab = function(tabId, umpleCode)
{
  // console.log("Inside TabControl.saveTab() ...")
  var filename = TabControl.getTabFilename(TabControl.tabs[tabId].name);
  var modelname = Page.getModel();
  localStorage[filename] = umpleCode;
  if (String(Page.getFilename()).indexOf("tasks") !== -1)
  {
    filename = "tasks/" + filename;
    modelname = "tasks/" + modelname;
  }
  var umpleCodeWithoutAmpersand = umpleCode.replace(/&/g, "%26").replace(/\+/g, "%2B");
  TabControl.addToRequestQueue(
    "scripts/compiler.php",
    TabControl.saveTabCallback(tabId),
    format("save=1&&lock=1&&model={2}&&umpleCode={0}&&filename={1}", umpleCodeWithoutAmpersand, filename, modelname));
}

TabControl.saveTabCallback = function(tabId)
{
  return function(response) {
    // Make sure the tab exists before we save the filename for it
    if (TabControl.tabs[tabId])
    {
      TabControl.tabs[tabId].filename = response.responseText;
    }
  }
}

/**
 * Selects a tab.
 * tabId: the ID of the tab to select
 */
TabControl.selectTab = function(tabId)
{ 
  // console.log("Inside TabControl.selectTab() ...")
  if (TabControl.activeTab) {
    // Do nothing if already selected
    if (tabId == TabControl.activeTab.id) return;

    // Deselect old tab and save the current page contents to it
    var oldActiveTabDiv = TabControl.getTabDiv(TabControl.activeTab.id);
    oldActiveTabDiv.removeClass("selected");
    TabControl.saveTab(TabControl.activeTab.id, Page.getUmpleCode());
  }

  // Select the new tab
  TabControl.activeTab = TabControl.tabs[tabId];
  var activeTabDiv = TabControl.getTabDiv(tabId);
  activeTabDiv.addClass("selected");
  TabControl.getCurrentHistory().setButtons();

  // Load code from cache
  var filename = TabControl.getTabFilename(TabControl.activeTab.name);
  Page.setUmpleCode(localStorage[filename]);

  // Reset caret position
  Action.setCaretPosition(0);
  Action.updateLineNumberDisplay();

  // update the diagram
  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
}

/**
 * Loads all tabs by checking for files on remote and generating each of them.
 * If no files are found (aside from model.ump), creates a single tab for it. 
 */
TabControl.loadAllTabs = function()
{
  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    TabControl.loadAllTabsCallback,
    format("list=1&&model={0}", Page.getModel()));
}

TabControl.loadAllTabsCallback = function(response)
{
  // The response is a break-separated list of tab name and content pairings
  var tabs = response.responseText.split("<br />")
  var foundRemoteTabs = false;

  tabs.map(function(nameContent)
  {
      if (!nameContent) return;
      var nameContentSplit = nameContent.split(TabControl.remoteDelim);
      var name = nameContentSplit[0];
      var content = nameContentSplit[1];
      if (!name || name === "model") return;
      if (!foundRemoteTabs)
      {
        // Hide tabs until all of the tabs are populated
        TabControl.hideTabs();
        foundRemoteTabs = true;
      }
      TabControl.createTab(name, content, true);
  });

  // If no tabs are found, we should initialize with a single tab
  if (!foundRemoteTabs)
  {
    TabControl.createTab(null, Page.getUmpleCode());
  }
  else
  {
    TabControl.showTabs();
  }
}

/**
 * Deletes a tab.
 * tabId: the ID of the tab to delete
 */
TabControl.deleteTab = function(tabId)
{
  if (Page.readOnly)
  {
    return;
  } 
  // Don't delete if we only have one tab
  if (Object.keys(TabControl.tabs).length > 1) {
    // Confirm deletion
    var tabName = TabControl.getTabNameDiv(tabId);
    var result = confirm("Are you sure you want to remove the file " + tabName.text() + ".ump from the model? If you answer OK, the code will be deleted; this cannot be undone, so consider answering Cancel and saving it first.");
    if (!result) return;

    // If we're deleting the currently active tab, we need to navigate away
    var shouldUpdateSelection = tabId == TabControl.activeTab.id;
    
    // Delete the tab locally
    TabControl.getTabDiv(tabId).remove();

    var tabName = TabControl.tabs[tabId].name;
    var filename = TabControl.tabs[tabId].filename;
    delete TabControl.reservedNames[tabName];
    delete TabControl.tabs[tabId];
    delete localStorage[filename];

    // The create button should now be re-enabled
    var createBtn = jQuery("#createTabBtn");
    createBtn.show();

    // Delete the tab on remote
    TabControl.addToRequestQueue(
      "scripts/tab_control.php",
      function(response){},
      format("delete=1&&model={0}&&name={1}", Page.getModel(), tabName));
    
    // Navigate to the first tab as necessary
    if (shouldUpdateSelection) {
        TabControl.activeTab = null;
        TabControl.selectTab(Object.keys(TabControl.tabs)[0]);
    }

    TabControl.saveActiveTabs();
  }
}

/**
 * Renames a tab.
 * tabId: the ID of the tab to rename
 * newName: the new name of the tab
 */
TabControl.renameTab = function(tabId, newName, updateUI)
{
  if (Page.readOnly)
  {
    return;
  } 
  // If the new name already exists, return
  if (TabControl.reservedNames.hasOwnProperty(newName)) return;

  // If the names are the same, then there's no work to do either
  var oldname = TabControl.tabs[tabId].name;
  if (oldname == newName) return;

  // Update cached contents
  var oldfilename = TabControl.getTabFilename(oldname);
  var newfilename = TabControl.getTabFilename(newName);
  localStorage[newfilename] = localStorage[oldfilename]
  delete localStorage[oldfilename];

  // Only programmatic calls need to update the GUI text again
  if (updateUI)
  {
    TabControl.getTabNameDiv(tabId).text(newName);
  }

  // If a name was renamed, then it is no longer ephemeral
  TabControl.tabs[tabId].nameIsEphemeral = false;

  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    TabControl.renameTabCallback(tabId, newName),
    format("rename=1&&model={0}&&oldname={1}&&newname={2}", Page.getModel(), oldname, newName));

  TabControl.saveActiveTabs();
}

TabControl.renameTabCallback = function(tabId, newName)
{
  return function(response) {
    delete TabControl.reservedNames[TabControl.tabs[tabId].name];
    TabControl.reservedNames[newName] = true;
    TabControl.tabs[tabId].name = newName;
  }
}

/**
 * Formats the remote filename given a tab name
 */
TabControl.getTabFilename = function(tabName)
{
  return format("{0}/{1}.ump", Page.getModel(), tabName);
}

/**
 * Gets the tab name div element.
 */
TabControl.getTabNameDiv = function(tabId)
{
  return jQuery("#tabName" + tabId);
}

/**
 * Gets the tab div element.
 */
TabControl.getTabDiv = function(tabId)
{
  return jQuery("#tab" + tabId);
}

/**
 * Add an ajax call to the request queue.
 */
TabControl.addToRequestQueue = function(endpoint, callback, parameters)
{
  var requestPayload = {
    endpoint: endpoint,
    callback: TabControl.getQueuedCallback(callback),
    parameters: parameters};

  TabControl.requestQueue.push(requestPayload);
  // If this is the only item in the queue, trigger execution
  if (TabControl.requestQueue.length === 1)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    Ajax.sendRequest(
        requestPayload.endpoint,
        TabControl.getQueuedHeadCallback(requestPayload.callback),
        requestPayload.parameters);
  }
}

/**
 * Extra queue manipulation for head requests.
 */
TabControl.getQueuedHeadCallback = function(callback)
{
  return function(response)
  {
    // Discard an extra item when the callback returns
    TabControl.requestQueue.shift();
    callback(response);
  }
}

/**
 * Returns a callback that executes the next item in queue.
 */
TabControl.getQueuedCallback = function(callback)
{
  return function(response)
  {
    // TODO: consider retrying the request on failure
    // The runtime of this is O(n), which is presumably okay since it's
    // running on the client and n is the number of concurrent requests
    var nextRequest = TabControl.requestQueue.shift();
    callback(response);
    if (nextRequest) {
      if (nextRequest.hasOwnProperty("endpoint"))
      {
        Ajax.sendRequest(
            nextRequest.endpoint,
            nextRequest.callback,
            nextRequest.parameters);
      }
      else
      {
          nextRequest.callback();
      }
    }
    else
    {
      if(Page.modelLoadingCount === 0 
        && Page.layoutLoadingCount === 0 
        && Page.canvasLoadingCount === 0)
      {
        jQuery(".bookmarkableUrl").removeClass("disabled");
      }
    }
  }
}

/**
 * Utility method to execute arbitrary code sequentially in the queue.
 */
TabControl.addCallbackToRequestQueue = function(callback)
{
  var callbackWrapper = {callback: TabControl.getQueuedCallback(callback)};
  TabControl.requestQueue.push(callbackWrapper);
  if (TabControl.requestQueue.length === 1)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    TabControl.getQueuedHeadCallback(callbackWrapper.callback());
  }
}

/**
 * Gets the current history object.
 */
TabControl.getCurrentHistory = function()
{
  // console.log("Inside TabControl.getCurrentHistory() ...")
  if (!TabControl.activeTab) return History.getInstance();
  return TabControl.tabs[TabControl.activeTab.id].history;
}

/**
 * Calls the callable using the currently active tab.
 */
TabControl.useActiveTabTo = function(tabCallable)
{
  if (!TabControl.activeTab) return function(){};
  return tabCallable.bind(null, TabControl.activeTab.id);
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Initializes all the tooltips on umpleonline

// This is a dictionary of all the tooltips that are not initialized using the title attribute.
// The are in the following format: 'id: ["tag type", "tooltip HTML"]'
// These tooltips can use full HTML and can be styled using css
var ToolTips = {}

// All custom shortcut types
var undo, redo, toggleTextEditor;

// Some special shortcuts
if (navigator.appVersion.indexOf("Mac")!=-1)
{
  undo = 'cmd-z';
  redo = 'cmd-shift-z';
  toggleTextEditor = 'ctrl-t';
}
else
{
  undo = 'ctrl-z';
  redo = 'ctrl-y';
  toggleTextEditor = 'ctrl-alt-shift-t';
}



ToolTips.tooltipEntries = {
  // save model tooltips
  ttSaveBookmark: ["li", "Click to bookmark this model"],
  ttSaveModel: ["li", "Click to save this model for ongoing editing.<br/><br/>After clicking this, you will need to use your browser's functionality to copy or bookmark the newly-created semi-permanent URL.<br/><br/>As you make further edits at the new URL, they will be instantly saved. You will be able to come back any time to continue editing.<br/><br/>The URL and its model will continue to be available for up to a year from the last time you edited it.<br/><br/>Do not use the new URL as a safe backup: If you (or anyone else who you give the URL) modifies or deletes the text, then your work would be lost. <br/><br/>You can share the URL with others, or open multiple tabs with it by yourself. As you type the text will change simultaneously in all open tabs."],
  buttonCopyClip: ["li", "Click to copy the code to the clipboard<br/><br/>After doing this you can paste the result into a .ump file on your computer. Note that this will copy diagram layout information which is normally hidden, as well as the Umple text."],
  buttonCopy: ["li", "Click to open a window containing the plain source for this model"],
  buttonCopyCommandLine: ["li", "Click to copy a script to execute your model on the Linux or Mac command line.<br/><br/>After doing this, paste the result into a terminal.<br/><br/>The script will create a new directory under ~/tmp, create the umple file there as test.ump. compile the Umple and resulting Java (and suggest for you how to run the Java if there is a main program present).<br/><br/>Before doing this you need to install the Java development environment and an 'umple' script using a tool such as homebrew. The Umple script should run 'java -jar umple.jar' with a .ump file as an argument  </br><b>Shortcut: [ctrl-o]</b>"],
  buttonCopyEncodedURL: ["li", "Click to view a url encoded with this model.<br/><br/>This only works for small models with about 5 classes or less.<br/><br/>You can send people that URL so they can recreate your model in their browser, or you can use this to embed a small example in a presentation file (such as PowerPoint)."],  
  buttonCopyLocalBrowser: ["li", "Click to save the Umple text from the current tab in your browser local storage for later reloading using Load from Browser below.<br/><br/>This can be useful to transfer text to a different browser tab, or temporarily stash some work you may want to come back to. But it should not be used for a permanent backup."],  
  buttonLoadLocalBrowser: ["li", "Click to load the Umple text from what you had previously saved in this browser (above).<br/><br/>This operation can be undone."],
  buttonDownloadFiles: ["li", "Click to download your entire model, one .ump file per Umple tab.<br/><br/>This is a two-step process. After you click this, the zip file will be created and a link will appear below; you must click on that link to actually complete the download.<br/><br/>This is the best way to safely back up your work to your own computer."],
  buttonCreateTask: ["li", "Create a modeling task for participants to try.</br>You will be able to give them some instructions. The model currently appearing here will be their starting point. The instructions could be requirements to model, or changes to make. This can be for an experiment or a course assignment."],
  buttonLoadTask: ["li", "Load a model and a set of instructions that have been created by someone running an experiment or a teacher of a course. You need to enter the task name that the person gave you."],
  buttonRequestAllZip: ["li", "Create a zip file to download, containing all submissions for this task."],
  ttDropboxSaver: ["li", "Click to save your model to dropbox"],

  // start over tooltips
  //ttStartOver: ["li", "Click to clear the text editor and the diagram. Once clicked, all of your saved works will be lost."],
  ttShowRefreshUmpleCompletely: ["li", "Click to erase your work and completely restart UmpleOnline.<br/><br/>Use this only if UmpleOnline gets into a state where things seem messed up. After doing this you will NOT be able to use the undo command to restore the model. The text and diagrams will be permanently erased. You should select 'Download Files' above first to back up your work.<br/><br/>For safety, this is a two-step process: A confirmation link will appear below that you must click on after you click on this."],
  ttLoadBlankModel: ["li", "Click to load a blank model.<br/><br/>This can be undone using the undo command in Tools. This is the best way to start new work, but you may want to download your files first (above) to back them up."],  
  
  // load example tooltips
  ttDropboxChooser: ["li", "Click to load an example from dropbox"],

  // diagram editing tools tooltips
  buttonAddClass: ["li", "Click the diagram to add a class </br><b>Shortcut: [c]</b>"],
  buttonAddAssociation: ["li", "Click on two classes to create an association </br><b>Shortcut: [a]</b>"],
  buttonAddGeneralization: ["li", "Click on two classes to create a generalization </br><b>Shortcut: [g]</b>"],
  buttonDeleteEntity: ["li", "Click on a class, association, or generalization to delete that entity </br><b>Shortcut: [DEL]</b>"],
  buttonUndo: ["li", "Click to undo the most recent action </br><b>Shortcut: [" + undo + "]</b>"],
  buttonRedo: ["li", "Click to redo the most recent undone action </br><b>Shortcut: [" + redo + "]</b>"],
  buttonReindent: ["li", "Click this to adjust the text so that blocks marked by { and } have their contents indented by 2 spaces"],
  buttonSyncDiagram: ["li", "Click to sync the diagram and the text"],

  // code generation tooltip
  ttGeneratedCodeType: ["li", "Choose the language or diagram to generate"],
  ttGenerateCode: ["li", "Click this button to generate the above code or diagram"],
  ttExecuteCode: ["li", "Click this button to execute the above code"],

  // show/hide elements tooltips
  ttShowHideCanvas: ['li', "Show/Hide the diagram </br><b>Shortcut: [ctrl+d]</b>"],
  ttShowHideTextEditor: ['li', "Show/Hide the text editor </br><b>Shortcut: [" + toggleTextEditor + "]"],
  ttShowHideLayoutEditor: ['li', "Show/Hide the layout editor"],
  ttToggleAttributes: ['li', "Show/Hide attributes in class diagrams </br><b>Shortcut: [shift+ctrl+a]</b>"],
  ttToggleMethods: ['li', "Show/Hide methods in class diagrams </br><b>Shortcut: [ctrl+m]</b>"],
  ttToggleTraits: ['li', "Show/Hide traits; when selected any traits and their relationships are explicitly shown; when unselected, traits are merged into their client classes </br><b>Shortcut: [ctrl+r]</b>"],
  ttToggleActions: ['li', "Show/Hide actions in state diagrams (hide to simplify)"],
  ttToggleGuards: ['li', "Show/Hide guards in state diagrams (hide to simplify)"],
  ttToggleTransitionLabels: ['li', "Show/Hide transition labels in state diagrams (t1, t2 etc.) to allow reference"],
  ttToggleGuardLabels: ['li', "Show/Hide guard labels on the state diagrams (g1, g2 etc.) to allow reference"],
  SHT_button: ['a', "Show/Hide the text editor - <b>" + toggleTextEditor +"</b>" ],
  SHD_button: ['a', "Show/hide diagram pane on right - <b> ctrl-D</b>"],
  SHA_button: ['a', "Show/hide attributes in class diagrams - <b>shift-ctrl-A</b>"],
  SHM_button: ['a', "Show/hide methods in class diagrams - <b>ctrl-M</b>"],
  

  // diagram type tooltips
  ttShowEditableClassDiagram: ["li", "Display a graphically editable class diagram </br><b>Shortcut: [ctrl+e]</b>"],
  ttShowJointJSClassDiagram: ["li", "Display a graphically editable class diagram displayed using joint.js </br><b>Shortcut: [ctrl+j]</b>"],
  ttShowGvClassDiagram: ["li", "Display a class diagram rendered using GraphViz </br><b>Shortcut: [ctrl+g]</b>"],
  ttShowGvStateDiagram: ["li", "Display a state diagram rendered using GraphViz</br><b>Shortcut: [ctrl+s]</b>"],
  ttShowStructureDiagram: ["li", "Display a graphically editable composite structure diagram </br><b>Shortcut: [ctrl+l]</b>"],
  ttShowGvFeatureDiagram: ["li", "Display a feature diagram rendered using GraphViz </br>"],

  ECD_button: ['a', "Editable class diagram - <b>ctrl-E</b>"],
  GCD_button: ['a', "Graphviz class diagram - <b>ctrl-G</b>"],
  SD_button: ['a', "State diagram - <b>ctrl-S</b>"],

  // preferences tooltips
  ttPhotoReady: ["li", "Remove editing handles from diagram"],
  ttManualSync: ["li", "Stop the diagram from syncing automatically"],
  ttAllowPinch: ["li", "When active on GraphViz diagrams, this allows two-fingered gestures to zoom the diagram in or out to make it have any desired resolution and size (but prevents the entire browser from being zoomed in this manner)"],

  // other views tooltips
  ttYumlImage: ["li", "Generate a class diagram using Yuml in another window"],

  ttSaveNCollab: ["a", "Click to save this model for ongoing editing.<br/><br/>After clicking this, you will need to use your browser's functionality to copy or bookmark the newly-created semi-permanent URL.<br/><br/>As you make further edits at the new URL, they will be instantly saved. You will be able to come back any time to continue editing.<br/><br/>The URL and its model will continue to be available for up to a year from the last time you edited it.<br/><br/>Do not use the new URL as a safe backup: If you (or anyone else who you give the URL) modifies or deletes the text, then your work would be lost. <br/><br/>You can share the URL with others, or open multiple tabs with it by yourself. As you type the text will change simultaneously in all open tabs."],
};


ToolTips.initTooltips = function()
{  
  // Initialize the tooltips in the above tooltip dictionary
  for(var id in this.tooltipEntries)
  {
  //Special cases
    if (id=="SD_button"||id=="GCD_button"||id=="ECD_button"||id=="SHT_button"||id=="SHD_button"||id=="SHA_button"||id=="SHM_button") {
      jQuery("#" + id).tooltip({
        items: this.tooltipEntries[id][0],
        content: this.tooltipEntries[id][1],
        show: {delay: 1000},
        position: {my:"left top+25%", of:"#"+id}
        });
    }
    else{
      jQuery("#" + id).tooltip({
        items: this.tooltipEntries[id][0],
        content: this.tooltipEntries[id][1],
        show: {delay: 1000},
        position: {my:"right", at:"left", of:"#"+id}
      });
      }
  }

  //Special cases

  //Sets the example dropdown menus tooltip so it does not collide with the
  //contents of the dropdown list
  dropDownTooltips = {
    exampleType: ["li", "Choose an example type to load"],
    itemLoadExamples: ["li", "Choose a class diagram example to load. * means executable, since it has a main program"],
    itemLoadExamples2: ["li", "Choose a state diagram example to load. * means executable, since it has a main program"],
    itemLoadExamples3: ["li", "Choose a composite structure diagram example to load"]
  }

  for(id in dropDownTooltips)
  {
    jQuery("#" + id).tooltip({
      items: dropDownTooltips[id][0],
      content: dropDownTooltips[id][1],
      show: {delay: 1000},
      position: {my:"center+15% bottom", at:"top", of:"#"+id}
    });
  }

  // Sets the rest of the tooltips using the styling provided by the jQuery style.
  // These tooltips use the title attribute as the content
  jQuery(document).tooltip({show: {delay: 1000}});
}
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models associations in the graphical view of UmpleOnline

UmpleTransitionFactory = new Object();

UmpleTransitionFactory.create = function(data)
{
    var umpleTransition = new UmpleTransition();
    umpleTransition.id = data.id;
    umpleTransition.fromStateId = data.fromStateId;
    umpleTransition.toStateId = data.toStateId;
    umpleTransition.name = data.name;
    umpleTransition.eventName = data.eventName;
    return umpleTransition;
}

function UmpleTransition() {
    this.id = null;
    this.fromStatePosition = null;
    this.toStatePosition = null;
    this.fromStateId;
    this.toStateId;
    this.name = "";
    this.eventName = "";
    this.color = "black";

    this.setStates = function (fromStateId, toStateId) {
        this.fromStateId = fromStateId;
        this.toStateId = toStateId;
    }

    this.setDefaultEvent = function () {
        this.eventName = "event1";
    }

    this.setName = function (aName) {
        this.name = aName;
    }

    this.getName = function () {
        return this.name;
    }

    this.getElementId = function () {
        return this.id == null ? "newtransition" : this.id;
    }

    this.getState = function (index) {
        return index == 0 ? UmpleSystem.find(this.fromStateId) : UmpleSystem.find(this.toStateId);
    }

}

var ObjectsUtil={objects:{},parentCalls:{},declare:function(a,c,n){if(ObjectsUtil.objects[a]){return}this.parentCalls[a]={};ObjectsUtil.objects[a]=function(){ObjectsUtil.objects[a].prototype.constructor.apply(this,arguments)};var o=[];for(var h=0;h<c.length;h++){o.push(c[h])}var b=[];for(var h=0;h<o.length;h++){var i=o[h];var g=ObjectsUtil.get(i);if(typeof g!=="function"){continue}var f=g.prototype;var d=f.constructor;if(d){b.push(d)}for(var l in f){if(l!=="constructor"){var j=f[l];if(typeof j==="function"){if(!this.parentCalls[a][l]){this.parentCalls[a][l]=[]}this.parentCalls[a][l].push(j)}else{ObjectsUtil.objects[a].prototype[l]=j}}else{}}}ObjectsUtil.objects[a].prototype.className=a;var m;for(var l in n){if(l==="constructor"){m=n[l]}else{ObjectsUtil.objects[a].prototype[l]=n[l]}}var k=this.parentCalls[a];for(var l in k){if(!ObjectsUtil.objects[a].prototype[l]){var e=k[l];if(e.length>0){ObjectsUtil.objects[a].prototype[l]=e[0]}}}ObjectsUtil.objects[a].prototype.constructor=function(){for(var p=0;p<b.length;p++){b[p].apply(this,arguments)}if(m){m.apply(this,arguments)}}},superCall:function(c,e,b){var d=this.parentCalls[d.className];if(d){for(var a=0;a<d.length;a++){d[a].call(c,b)}}},define:function(b,a){if(ObjectsUtil.objects[b]){return}ObjectsUtil.objects[b]=a;return a},get:function(a){return ObjectsUtil.objects[a]},newInstance:function(d,c){var a=new ObjectsUtil.objects[d](c);if(typeof c!=="string"){for(var b in c){if(a[b]){continue}a[b]=c[b]}}return a},isArray:function(a){return a&&(typeof a=="array"||a instanceof Array)}};(function(){var a=ObjectsUtil.get("util.core.CoreUtil");ObjectsUtil.declare("util.core.Map",[],{values:null,keys:null,constructor:function(){this.values=[];this.keys=[]},put:function(b,d){var c=this.keys.indexOf(b);if(c===-1){this.values.push(d);this.keys.push(b)}else{this.values[c]=d}},get:function(b){return this.values[this.keys.indexOf(b)]},remove:function(b){var c=this.keys.indexOf(b);if(c<0){return}this.values.splice(c,1);this.keys.splice(c,1)},clear:function(){this.values=[];this.keys=[]}})})();(function(){var a=ObjectsUtil.newInstance("util.core.Map");var b=[];ObjectsUtil.define("util.core.Events",{topics:{},suspend:null,connect:function(c,e,d,j){var k=this;var f,i;if(e.addEventListener){f=function(){j.apply(d,arguments)};e.addEventListener(c,f,false);i=function(){e.removeEventListener(c,f,false)}}else{var g=a.get(e);if(!g){g=[];a.put(e,g)}if(!g[c]){g[c]={bridged:e[c],connects:[]};var k=this;e[c]=function(){g[c].bridged.apply(e,arguments);if(!k.suspend){var m=g[c].connects;for(var l=0,n;n=m[l];l++){n.callback.apply(n.context,arguments)}}}}g[c].connects.push({callback:j,context:d});f=j}var h={callback:f,disconnector:i,type:c,object:e,context:d};b.push(h);return h},disconnectAll:function(){while(b.length>0){this.disconnect(b[0],a)}this.topics={}},disconnect:function(h,e){if(!h){return}if(h.object.removeEventListener){h.disconnector()}else{var j=a.get(h.object);if(!j){return}var g=j[h.type];if(!g){return}g=g.connects;if(!g){return}for(var d=0,k;k=g[d];d++){if(k.callback===h.callback){g.splice(g.indexOf(k),1);d=0}}}var f=b.indexOf(h);if(f>-1){b.splice(f,1)}},subscribe:function(c,f,d){if(!this.topics[c]){this.topics[c]=[]}var e={handler:f,context:d};this.topics[c].push(e);return e},unsubscribe:function(c,e){if(!this.topics[c]){return}var d=this.topics[c].indexof(e);if(d>-1){this.topics[c].splice(d,1)}},publish:function(d){var f=this.topics[d];if(!f){return}for(var c=0,e;e=f[c];c++){var g=Array.prototype.slice.call(arguments,1);e.handler.apply(e.context||this,g)}}})})();(function(){ObjectsUtil.define("util.core.UUIDGenerator",{generate:function(){return"xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g,function(c){var a=Math.random()*16|0,b=c==="x"?a:(a&3|8);return b.toString(16)})}})})();(function(){ObjectsUtil.define("util.svg.SVGUtil",{SVG:"http://www.w3.org/2000/svg",syncLineBetweenVertices:function(h,n,A){var z=n.getRootNode();var m=parseFloat(z.getAttribute("height"));var j=n.focalNode;var i=A.focalNode;var q=parseFloat(j.getAttribute("x"));var c=parseFloat(j.getAttribute("y"));var e=parseFloat(j.getAttribute("height"));var s=parseFloat(j.getAttribute("width"));var p=parseFloat(i.getAttribute("x"));var b=parseFloat(i.getAttribute("y"));var d=parseFloat(i.getAttribute("height"));var r=parseFloat(i.getAttribute("width"));var y=q+(s/2);var v=c+(e/2);var x={y:v,x:y};var k={y:b,x:p+(r/2),getRange:function(F,D){var E=p/m;var C=(r/2)*E;var B=p+(r/2);if(Math.abs(F-B)<2){return B}if(F<p+(r/2)){return B-C}else{if(F>p+(r/2)){return B+C}else{return B}}}};var l={y:b+d,x:p+(r/2),getRange:function(F,D){var E=p/m;var C=(r/2)*E;var B=p+(r/2);if(Math.abs(F-B)<2){return B}if(F<p+(r/2)){return B-C}else{if(F>p+(r/2)){return B+C}else{return B}}}};var f={y:b+(d/2),x:p,getRange:function(F,D){var E=b/m;var C=(d/2)*E;var B=b+(d/2);if(Math.abs(D-B)<2){return B}if(D<b+(d/2)){return B-C}else{if(D>b+(d/2)){return B+C}else{return B}}}};var o={y:b+(d/2),x:p+r,getRange:function(F,D){var E=b/m;var C=(d/2)*E;var B=b+(d/2);if(Math.abs(D-B)<2){return B}if(D<b+(d/2)){return B-C}else{if(D>b+(d/2)){return B+C}else{return B}}}};var a=function(C,B){return Math.abs((C.x-B.x))+Math.abs((C.y-B.y))};var w=a(x,k);var u=a(x,l);var g=a(x,f);var t=a(x,o);if(w<u&&w<g&&w<t){h.setAttribute("d","M"+y+","+v+" L"+k.getRange(y,v)+" "+k.y)}else{if(u<w&&u<g&&u<t){h.setAttribute("d","M"+y+","+v+" L"+l.getRange(y,v)+" "+l.y)}else{if(g<w&&g<u&&g<t){h.setAttribute("d","M"+y+","+v+" L"+f.x+" "+f.getRange(y,v))}else{if(t<w&&t<u&&t<g){h.setAttribute("d","M"+y+","+v+" L"+o.x+" "+o.getRange(y,v))}}}}n.parentNode.refreshChild(h)},syncVertixLines:function(a){var c=ObjectsUtil.get("util.svg.SVGUtil");var d=a.getChildren("connector");for(var e=0;b=d[e];e++){var b=d[e];c.syncLineBetweenVertices(b.focalNode,b.source,b.target)}},getConnector:function(a,e){var c=a.getChildren("connector");for(var b=0;b<c.length;b++){var d=c[b];if(d.target===a){if(d.source===e){return d}}else{if(d.source===a){if(d.target===e){return d}}}}return null}})})();(function(){var c=ObjectsUtil.get("util.svg.SVGUtil");var b={};var a={};ObjectsUtil.define("layout.shapes.ShapesRegistry",{register:function(e,d){b[e]=d},draw:function(g,e,f){var d=ObjectsUtil.newInstance(b[g],e,f);if(!a[g]){a[g]={}}a[g][d.id||d.guid]=d;d.draw(e,f);return d},get:function(d,e){return e?a[d][e]:a[d]},getAndGroup:function(g,j){var h=this.get(g,j);var d={};for(var e in h){var i=h[e];if(!i){continue}var f=i.parent;if(!f){continue}if(!d[f]){d[f]={}}d[f][e]=i}return d},destroy:function(d){a[d.guid].destroy();a[d.guid]=undefined},empty:function(){a={}},showMessage:function(e,h){var g=document.getElementById(e);if(!g){return}ObjectsUtil.get("util.core.Events").disconnectAll();ObjectsUtil.get("layout.shapes.ShapesRegistry").empty();ObjectsUtil.get("util.core.DomUtil").empty(g);var d=ObjectsUtil.get("util.svg.SVGUtil");var i=g.descriptionMessage||document.createElementNS(d.SVG,"text");i.setAttribute("x",20);i.setAttribute("y",20);i.setAttribute("style","fill: #000000;  font-family:tahoma; font-size: 16;  font-weight:bold");i.appendChild(document.createTextNode(h));g.appendChild(i);var f=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(h,i);g.style.width=f.w+120+"px";g.style.height=f.h+5+"px";g.style.border="none";g.descriptionMessage=i},paint:function(e,d){if(d&&e.args.container){ObjectsUtil.get("util.core.Events").disconnectAll();ObjectsUtil.get("layout.shapes.ShapesRegistry").empty();ObjectsUtil.get("util.core.DomUtil").empty(e.args.container)}this._paint(e)},_paint:function(g,d,e){if(d){g.args.parentNode=d}if(e){g.args.container=e}if(!g.args.id){g.args.id=g.args.name}var f=ShapesRegistry.draw(g.descriptor,g.args,g);return f}})})();(function(){var d=ObjectsUtil.get("util.svg.SVGUtil");var a=ObjectsUtil.get("layout.shapes.ShapesRegistry");var e=40;var c=100000;var b=0.0005;b=0.0005;ObjectsUtil.declare("layout.routers.AutomaticRouter",[],{forcex:null,forcey:null,_layoutInterval:null,graph:null,constructor:function(f){this.graph=f;this.forcex={};this.forcey={}},layout:function(){var f=this;f._doLayout();this._layoutInterval=setInterval(function(){f._doLayout()},100)},_doLayout:function(){var g=this.graph.getChildren("rectangle");for(var i=0;vertix1=g[i];i++){var l=vertix1.name;this.forcex[l]=0;this.forcey[l]=0;for(var j=0;vertix2=g[j];j++){var k=vertix2.name;if(l===k){continue}var q=parseFloat(vertix2.getAttribute("x"))-parseFloat(vertix1.getAttribute("x"));var p=parseFloat(vertix2.getAttribute("y"))-parseFloat(vertix1.getAttribute("y"));var o=Math.pow(q,2)+Math.pow(p,2);this.forcex[l]-=(c/o)*q;this.forcey[l]-=(c/o)*p;if(d.getConnector(vertix1,vertix2)){var f=Math.sqrt(o);this.forcex[l]+=(f-e)*q;this.forcey[l]+=(f-e)*p}}}var h=0;for(var i=0;vertix1=g[i];i++){var l=vertix1.name;var n=this.forcex[l]*b;var m=this.forcey[l]*b;h=h+Math.abs(n)+Math.abs(m);vertix1.setPosition({x:parseFloat(vertix1.getAttribute("x"))+n,y:parseFloat(vertix1.getAttribute("y"))+m})}if(Math.round(h)<40){clearInterval(this._layoutInterval)}}})})();(function(){var d=ObjectsUtil.get("util.svg.SVGUtil");var a=ObjectsUtil.get("layout.shapes.ShapesRegistry");var e=40;var c=100000;var b=0.0005;b=0.0005;ObjectsUtil.declare("layout.routers.HorizontalTreeRouter",[],{forcex:null,forcey:null,graph:null,constructor:function(f){this.graph=f;this.forcex={};this.forcey={}},layout:function(){var f=this;f._doLayout()},_doLayout:function(){var q=[];var n=function(y,E){var A=[];var D=y.getChildren("connector");for(var x=0;x<D.length;x++){var C=D[x];if(C.source===y){var B=C.target;if(E&&q.indexOf(B)>-1){continue}A.push(C.target)}else{if(C.target===y){var z=C.source;if(E&&q.indexOf(z)>-1){continue}A.push(C.source)}}}return A};var f=function(z){var A=z.getChildren("connector");if(A.length<1){return 1}var y=0;for(var x=0;subChild=A[x];x++){y=y+f(subChild)}return y};var s=function(A){var C=A.getChildren("connector");if(C.length<1){return 1}var z=0;for(var y=0;subChild=C[y];y++){var B;if(subChild.source===A){B=subChild.target}else{if(subChild.target===A){B=subChild.source}}if(!B){continue}var x=parseFloat(B.getAttribute("width"));if(x>z){z=x}}return z};var o=function(A,C){if(!C){C=[]}var x=n(A);if(x.length===1){return 1}var z=0;for(var y=0;y<x.length;y++){var B=x[y];if(C.indexOf(B)>-1){continue}C.push(x[y]);z=z+o(x[y],C)}return z};var g=this.graph.getChildren("rectangle");var u=g;u.sort(function(y,x){return f(x)-f(y)});var v=40;var t=30;var r={x:0,y:0};var i=function(J,M,S,N){if(q.indexOf(J)>-1){return}q.push(J);var G=f(J,true);if(N){G--}J.setPosition({x:M,y:S});if(S>r.y){r.y=S}if(M>r.x){r.x=M}var L=n(J,true);var y=L.length;var Q=G*v;var E=S-(Q/2);var H=0;for(var C=0;C<y;C++){var I=L[C];var K=f(I)-1;var R=E;if(C){R=R+v}if(!K){K=1}var B=R+(K*v);var D=(R+B)/2;var F=M+t+parseFloat(J.getAttribute("width"));I.setPosition({x:F,y:D});if(D>r.y){r.y=D}if(F>r.x){r.x=F}E=B-v;H=H+(K||1);q.push(I);var z=n(I,true);var O=F+parseFloat(I.getAttribute("width"))+t;if(z.length===1){i(z[0],O,D,true)}else{if(z.length>=2){var A=R+v/2;var x=(((B-A)/z.length))+v/z.length;for(var P=0;P<z.length;P++){i(z[P],O,A+(x*P),true)}}}}};for(var j=0;j<u.length;j++){var p=u[j];if(q.indexOf(p)>-1){continue}var m=o(p);var w=q.length===0?((m*v)/4):r.y+v;i(p,t,w)}if(!this.graph.height){var h=parseFloat(this.graph.getAttribute("height"));var l=r.y+v;if(l>h){this.graph.setAttribute("height",parseFloat(l))}}if(!this.graph.width){var k=parseFloat(this.graph.getAttribute("width"));var l=r.x+100;if(l>k){this.graph.setAttribute("width",parseFloat(l))}}for(var j=0;j<q.length;j++){var p=q[j];p.parentNode.refreshChild(p.focalNode);d.syncVertixLines(p)}}})})();(function(){var b=0;var a=ObjectsUtil.get("util.core.Events");ObjectsUtil.declare("layout.shapes.AbstractNode",[],{focalNode:null,guid:null,children:null,type:null,parentNode:null,incremntal:null,_incomplete:null,constructor:function(c){this.children=[];this.id=c.id;this.parentNode=c.parentNode;this.incremntal++},getChildren:function(c){return this.children[c||""]||[]},getPosition:function(){return{x:0,y:0,h:0,w:0}},setPosition:function(c,d){},shiftPosition:function(f,e){var c=this.getPosition();for(var d in f){c[d]=(c[d]||0)+f[d]}this.setPosition(c,e)},getSuperContainer:function(){var d=this.container;while(true){var c=d.container;if(c&&c.className){d=c}else{break}}return d},addChild:function(d){this.removeChild(d);var c=d.type||"";if(!this.children[c]){this.children[c]=[]}this.children[c].push(d)},removeChild:function(e){var d=e.type||"";if(!this.children[d]){return}if(!this.children[d]){return}var c=this.children[d].indexOf(e);if(c==-1){return}this.children[d].splice(c,1)},appendChild:function(c){this.focalNode.appendChild(c)},refreshChild:function(c){if(c.parentNode===this.focalNode){this.focalNode.removeChild(c);this.insertBefore(c,this.focalNode.firstChild)}},insertBefore:function(d,c){if(!c){this.appendChild(d)}else{this.focalNode.insertBefore(d,c)}},draw:function(c){},getAttribute:function(c){return this.focalNode.getAttribute(c)},setAttribute:function(c,d){this.focalNode.setAttribute(c,d)},getRootNode:function(){var c=this.parentNode.focalNode;if(c.tagName==="svg"){return c}var d=c.parentNode;while(d){d=d.parentNode;if(d&&d.tagName==="svg"){return d}}return c},handleMove:function(c,d){},destroy:function(){}})})();(function(){var c=ObjectsUtil.get("util.svg.SVGUtil");var b=ObjectsUtil.get("util.core.Events");var e=ObjectsUtil.get("util.core.UUIDGenerator");var g=0;var f="#222";var a="#fff";var d="10px";ObjectsUtil.declare("layout.shapes.RectangleNode",["layout.shapes.AbstractNode"],{focalNode:null,guid:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,constructor:function(h){this.type="rectangle";this.name=h.name||("Node"+g);this.guid=h.id||this.name;this.color=h.color||f;this.fontColor=h.fontColor||a;this.rx=h.rx||d;this.strokeWidth=h.strokeWidth||1;this.strokeWidth=this.strokeWidth+"px";g++},draw:function(k){var l=parseInt(this.parentNode.getAttribute("width"));var j=parseInt(this.parentNode.getAttribute("height"));this.focalNode=document.createElementNS(c.SVG,"rect");this.focalNode.setAttribute("style","fill: "+this.color+"; stroke-width: "+this.strokeWidth+";");this.focalNode.setAttribute("rx",this.rx);this.parentNode.appendChild(this.focalNode);this.focalNode.name=this.name;this.focalNode.textLabel=document.createElementNS(c.SVG,"text");this.focalNode.textLabel.setAttribute("style","fill: "+this.fontColor+"; stroke-width: 1px;");this.focalNode.textLabel.appendChild(document.createTextNode(this.name));this.parentNode.appendChild(this.focalNode.textLabel);this.focalNode.h=this.focalNode.textLabel.getBBox().height+10;this.focalNode.w=this.focalNode.textLabel.getBBox().width+10;this.focalNode.setAttribute("height",this.focalNode.h+"px");this.focalNode.setAttribute("width",this.focalNode.w+"px");var i=b.connect("mousedown",this.focalNode,this,function(n){this.handleMove(this.focalNode,n)});var i=b.connect("mousedown",this.focalNode.textLabel,this,function(n){this.handleMove(this.focalNode,n)});var h=Math.random()*(l*0.8)+(l*0.1);var m=(Math.random()*(j*0.8))+(j*0.1);this.setPosition({x:h,y:m})},setPosition:function(h){var j=parseFloat(h.x);var i=parseFloat(h.y);this.focalNode.setAttribute("x",j);this.focalNode.setAttribute("y",i);this.focalNode.textLabel.setAttribute("x",j+5+"px");this.focalNode.textLabel.setAttribute("y",i+(2*this.focalNode.h/3)+"px");c.syncVertixLines(this)},handleMove:function(o,h){var k=o.parentNode.getScreenCTM();var i=o.parentNode.createSVGPoint();i.x=h.clientX;i.y=h.clientY;i=i.matrixTransform(k.inverse());var n=parseFloat(i.x)-parseFloat(o.getAttribute("x"));var l=parseFloat(i.y)-parseFloat(o.getAttribute("y"));var j=this.getChildren("rectangle");this._moving=o;var r=b.connect("mousemove",document,this,function(u){var s=o.parentNode.getScreenCTM();var t=o.parentNode.createSVGPoint();t.x=u.clientX;t.y=u.clientY;t=t.matrixTransform(s.inverse());this.setPosition({x:t.x-n,y:t.y-l});this.parentNode.updateArrowMarker()});var q=b.connect("mouseup",document,this,function(){b.disconnect(r);b.disconnect(q);this.parentNode.updateArrowMarker()})}})})();(function(){var a=ObjectsUtil.get("layout.shapes.ShapesRegistry");var c=ObjectsUtil.get("util.svg.SVGUtil");var b="1px";var e="#444";var d=0;ObjectsUtil.declare("layout.shapes.Connector",["layout.shapes.AbstractNode"],{focalNode:null,source:null,target:null,name:null,color:null,rx:null,strokeWidth:null,type:null,constructor:function(f){this.type="connector";this.setSource(f.source);this.setTarget(f.target);this.name=f.name||("Connector"+d);this.guid=f.id||this.source.guid+"_"+this.target.guid+"_"+d;this.strokeWidth=f.strokeWidth||b;this.color=f.color||e;d++},setSource:function(g){var f=a.get("RectangleNode",g);this.source=f;f.addChild(this)},setTarget:function(g){var f=a.get("RectangleNode",g);this.target=f;f.addChild(this)},draw:function(f){this.focalNode=document.createElementNS(c.SVG,"path");this.focalNode.setAttribute("style","stroke: "+this.color+"; stroke-width:"+this.strokeWidth+";");this.parentNode.insertBefore(this.focalNode,this.parentNode.firstChild);this.focalNode.setAttribute("marker-end","url(#Triangle)");return this.focalNode}})})();var ShapesRegistry=ObjectsUtil.get("layout.shapes.ShapesRegistry");(function(){ShapesRegistry.register("Connector","layout.shapes.Connector");ShapesRegistry.register("RectangleNode","layout.shapes.RectangleNode");ShapesRegistry.register("Graph","layout.shape.Graph")})();(function(){var d=ObjectsUtil.get("layout.routers.HorizontalTreeRouter");var b=ObjectsUtil.get("util.core.Events");var c=ObjectsUtil.get("util.svg.SVGUtil");var a=ObjectsUtil.get("layout.shapes.ShapesRegistry");ObjectsUtil.declare("layout.shape.Graph",["layout.shapes.AbstractNode"],{routingObject:null,height:null,width:null,_layoutInterval:null,_moving:null,_defs:null,constructor:function(g){this.height=g.height;this.width=g.width;var e=g.container;var f=g.router;this.router=f||new d(this);this.focalNode=document.getElementById(e);this.updateArrowMarker()},draw:function(e,f){},_paint:function(f){f.args.parentNode=this;if(!f.args.id){f.args.id=f.args.name}f.args.container=this;var e=a.draw(f.descriptor,f.args,f);return e},updateArrowMarker:function(){if(!this._defs){this._defs=document.createElementNS(c.SVG,"defs");var e=document.createElementNS(c.SVG,"marker");e.setAttribute("id","Triangle");e.setAttribute("viewBox","0 0 20 20");e.setAttribute("refX","20");e.setAttribute("refY","10");e.setAttribute("markerUnits","strokeWidth");e.setAttribute("markerWidth","8");e.setAttribute("markerHeight","6");e.setAttribute("orient","auto");var f=document.createElementNS(c.SVG,"path");e.appendChild(f);f.setAttribute("d","M 0 0 L 20 10 L 0 20 z");this._defs.appendChild(e)}else{this.focalNode.removeChild(this._defs)}this.focalNode.appendChild(this._defs)},addRectNode:function(f){f.parentNode=this;var e=a.draw("RectangleNode",f);this.addChild(e)},drawConnector:function(f){f.parentNode=this;var e=a.draw("Connector",f);this.addChild(e)},layout:function(){this.router.layout()}})})();(function(){var a=ObjectsUtil.define("util.core.DomUtil",{empty:function(b){if(!b.tagName){b=document.getElementById(b)}if(!b){return}if(b.canHaveChildren){try{b.innerHTML="";return}catch(c){}}for(var d;d=b.lastChild;){this._empty(d,b)}},_empty:function(c,b){if(c.firstChild){this.empty(c)}if(b){b.removeChild(c);if(c.removeNode){c.removeNode(false)}}},calculateTextSize:function(g,f){var e=document.createElement("span");e.innerHTML=g;e.style.visibility="hidden";var c=this.position(e);if(typeof f==="object"&&!f.parentNode){for(var d in f){e.style[d]=f[d]}}else{e.style.fontSize=window.getComputedStyle(f,null).getPropertyValue("font-size");e.style.fontFamily=window.getComputedStyle(f,null).getPropertyValue("font-family");e.style.fontWeight=window.getComputedStyle(f,null).getPropertyValue("font-weight")}var b=document.body;b.appendChild(e);var c=this.position(e);b.removeChild(e);return c},position:function(e,c){var g=ObjectsUtil.get("util.core.CoreUtil");e=this.nodeById(e);var b=this.getFirstParent(e,"body");var f=e.getBoundingClientRect();f={x:f.left,y:f.top,w:f.right-f.left,h:f.bottom-f.top};if(c){var d=this.scrollValue(e);f.x+=d.x;f.y+=d.y}return f},transformValue:function(d){var b=d.getAttribute("transform");if(!b){return{x:0,y:0}}b=b.substring("translate(".length,b.length-1);var c=b.split(",");if(c.length<2){c=b.split(" ")}return{x:parseFloat(c[0]),y:parseFloat(c[1])}},scrollValue:function(c){var i=function(n,l){var j;var k=window["page"+n+"Offset"];if(typeof(k)==="number"){j=k}else{var m="scroll"+l;if(document.body&&document.body[m]){j=document.body[m]}else{if(document.documentElement&&document.documentElement[m]){j=document.documentElement[m]}}}return j};var d=function(){return i("Y","Top")};var b=function(){return i("X","Left")};var g=0,h=0;var f={x:b(),y:d()};var e=c;while(e){if(e!==document.body&&e!==document.documentElement){if(e.scrollTop>0){f.y=f.y+e.scrollTop;break}if(e.scrollLeft>0){f.x=f.x+e.scrollLeft;break}}e=e.parentNode}return f},nodeById:function(d,b){var c=ObjectsUtil.get("util.core.CoreUtil");if(c.checkBrowser("ie")){this.nodeById=function(f,e){if(typeof f!=="string"){return f}return(e||document).getElementById(f)};return this.nodeById(d,b)}this.nodeById=function(j,i){if(typeof j!=="string"){return j}if(!b){b=document}var f=b.getElementById(j);if(f.id==j||(f.attributes&&f.attributes.id&&f.attributes.id.value==j)){return f}var h=b.all[j];if(!h){return}if(!c.isArray(h)){h=[h]}for(var e=0,g;g=h[e];e++){if(g.id==j||(g.attributes&&g.attributes.id&&g.attributes.id.value==j)){return g}}};return this.nodeById(d,b)},transformPoint:function(e,c){var d=ObjectsUtil.get("util.core.DomUtil").getFirstParent(e,"svg");var b=d.getScreenCTM();var f=d.createSVGPoint();f.x=c.x;f.y=c.y;f=f.matrixTransform(b.inverse());c.x=f.x;c.y=f.y},getFirstParent:function(e,c){if(!e||!c){return}c=c.toUpperCase();if(e.tagName.toUpperCase()===c){return e}var d=e.parentNode;var b;while(d){if(d.tagName&&(d.tagName.toUpperCase()===c.toUpperCase())){b=d;break}d=d.parentNode}return b}})})();(function(){var a=ObjectsUtil.define("util.core.CoreUtil",{store:{},toString:{}.toString,_browserSettings:null,clone:function(d){var b={};for(var c in d){b[c]=d[c]}return b},stopEvent:function(b){b.cancelBubble=true;b.preventDefault();b.stopPropagation()},checkBrowser:function(c){var b=this.store[c];if(b!==undefined){return b}b=navigator.userAgent.search(c);this.store[c]=b;return b},browserSettings:function(){if(this._browserSettings){return this._browserSettings}var d=navigator.userAgent;var b;var c=d.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*([\d\.]+)/i)||[];if(/trident/i.test(c[1])){b=/\brv[ :]+(\d+(\.\d+)?)/g.exec(d)||[];this._browserSettings={browser:"ie",version:b[1]||""};return this._browserSettings}c=c[2]?[c[1],c[2]]:[navigator.appName,navigator.appVersion,"-?"];if((b=d.match(/version\/([\.\d]+)/i))!=null){c[2]=b[1]}this._browserSettings={browser:c[0].toLowerCase(),version:c[1]||""}},version:function(b){var c=this.browserSettings();if(c.browser===b){return parseFloat(c.version)}return 0},isFunction:function(b){return this._is(b,"[object Function]")},isString:function(b){return this._is(b,"[object String]")},isArray:function(b){return this._is(b,"[object Array]")},_is:function(c,b){return this.toString.call(c)===b}})})();(function(){var SVGUtil=ObjectsUtil.get("util.svg.SVGUtil");var Events=ObjectsUtil.get("util.core.Events");var UUIDGenerator=ObjectsUtil.get("util.core.UUIDGenerator");var incremntal=0;var DEFAULT_COLOR="rgb(255,255,255)";var DEFAULT_FONT_COLOR="#fff";var DEFAULT_ROUND_RATIO="10px";var ShapesRegistry=ObjectsUtil.get("layout.shapes.ShapesRegistry");ShapesRegistry.register("StrucutreDiagram","layout.shapes.StrucutreDiagram");ShapesRegistry.register("Part","layout.shapes.Part");ShapesRegistry.register("Port","layout.shapes.Port");ShapesRegistry.register("PartIcon","layout.shapes.PartIcon");ShapesRegistry.register("PortConnector","layout.shapes.PortConnector");ObjectsUtil.declare("layout.shapes.StructureDiagramNode",["layout.shapes.AbstractNode"],{_moveHandle:null,constructor:function(args){this._moveHandle=Events.subscribe("structure.diagram.node.move."+this.id,function(args){var self=this;var visited=[];var updateMoveInformation=function(entry){if(visited.indexOf(entry)>-1){return}visited.push(entry);var position=entry.getPrecisePosition?entry.getPrecisePosition():entry.getPosition();if(!self.parentNode.layoutInformation){self.parentNode.layoutInformation={}}var updatedInfo={x:position.x,y:position.y,h:position.h,w:position.w};self.parentNode.layoutInformation[entry.id]=updatedInfo;var children=entry.getChildren();for(var index=0,child;child=children[index];index++){updateMoveInformation(child)}};updateMoveInformation(this)},this)},destroy:function(){Events.unsubsribe(this._moveHandle)}});var StructureDiagramUtil=ObjectsUtil.define("layout.shapes.diagram.structure..StructureDiagramUtil",{portToPart:function(port,userHandler,otherPort){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var portObject=CoreUtil.isString(port)?ShapesRegistry.get("Port",port):port;var part=otherPort||portObject.container;var partPosition=part.getPosition();var portPosition=portObject.getPosition();var deltaRight=parseInt(Math.abs(portPosition.x-(partPosition.x+partPosition.w)+portPosition.w));var deltaLeft=parseInt(Math.abs((portPosition.x-(partPosition.x))+portPosition.w));var deltaTop=parseInt(Math.abs(portPosition.y-(partPosition.y-portPosition.h)));var deltaBottom=parseInt(Math.abs(portPosition.y-(partPosition.y+partPosition.h)+portPosition.h));var handler=function(x,y,direction,portPosition){var isCorner=function(att1,att2){return att1<5&&att2<5};if(port.isPrivate){if(direction==="right"){direction="left";y=y+(2)}else{if(direction==="left"){direction="right";y=y+(2);x=x+(2)}else{if(direction==="top"){direction="bottom";y=y+((portPosition.h/2)+2)}else{if(direction==="bottom"){direction="top";y=y-((portPosition.h/2)+2)}else{direction="right"}}}}}userHandler(x,y,direction,portPosition,(isCorner(deltaBottom,deltaLeft)||isCorner(deltaTop,deltaLeft)||isCorner(deltaBottom,deltaRight)||isCorner(deltaTop,deltaRight)),{deltaRight:deltaRight,deltaLeft:deltaLeft,deltaTop:deltaTop,deltaBottom:deltaBottom})};var side;if(deltaRight<deltaLeft&&deltaRight<=deltaTop&&deltaRight<=deltaBottom){if(partPosition.y-portPosition.h>portPosition.y){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)}else{if((portPosition.y>(partPosition.y+partPosition.h+document.body.scrollTop)-portPosition.h)){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)}else{return handler(portPosition.x+(portPosition.w-2),portPosition.y+(portPosition.h/2),"right",portPosition)}}}else{if(deltaLeft<deltaRight&&deltaLeft<=deltaTop&&deltaLeft<=deltaBottom){if(partPosition.y-portPosition.h>portPosition.y){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)}else{if((portPosition.y>(partPosition.y+partPosition.h+document.body.scrollTop)-portPosition.h)){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)}else{return handler(portPosition.x+(portPosition.w-2),portPosition.y+(portPosition.h/2),"left",portPosition)}}}else{if(deltaTop<deltaRight&&deltaTop<deltaLeft&&deltaTop<deltaBottom){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y,"top",portPosition)}else{if(deltaBottom<deltaRight&&deltaBottom<deltaLeft&&deltaBottom<deltaTop){return handler(portPosition.x+(portPosition.w/2-2),portPosition.y+(portPosition.h/2+4),"bottom",portPosition)}}}}}});ObjectsUtil.declare("layout.shapes.StrucutreDiagram",["layout.shape.Graph"],{layoutInformation:null,settings:null,constructor:function(args){this.layoutInformation=args.layout},draw:function(args,entry){this.focalNode.style.width="100%";this.focalNode.style.height="3600px";this._incomplete=true;this.settings=entry.args.settings||{};var layout=entry.args.layout;if(this.height){this.setAttribute("height",this.height)}if(this.width){this.setAttribute("width",this.width)}var nodes=args.nodes;if(!nodes){return}var mapByParent={"":{}};var getArray=function(id){var array=mapByParent[id||""];if(array){return array}mapByParent[id]={};return mapByParent[id]};var undefineds=[];var setDetails=function(node){var args=node.args;var id=args.id||args.name;if(id){node.children={};var obj=getArray(args.parent)[args.id||args.name||new Date().getTime()]=node}else{if(undefineds.indexOf(node)===-1){undefineds.push(node)}}};for(var index=0,node;node=nodes[index];index++){setDetails(node)}var search=function(obj,id){for(var att in obj){if(att===id){return obj[id]}var val=search(obj[att].children,id);if(val){return val}}};var pending=[];var putInHirarchy=function(obj){for(var id in obj){if(!id){continue}var subObject=obj[id];var array=search(mapByParent[""],id);if(array){var indexOf=pending.indexOf(id);if(indexOf>-1){pending.splice(indexOf,1)}var contents=mapByParent[id];for(var att in contents){array.children[att]=contents[att]}delete mapByParent[id]}else{var indexOf=pending.indexOf(id);if(indexOf===-1){pending.push(id)}}for(var att in subObject){putInHirarchy(subObject[att].children)}}};putInHirarchy(mapByParent);while(pending.length>0){putInHirarchy(mapByParent)}var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var mainObject=mapByParent[""];var avoid=[];var flatten=function(obj){for(var att in obj){var current=obj[att];if(avoid.indexOf(current)>-1){continue}if(current.descriptor==="Part"&&!mainObject[att]){mainObject[att]=CoreUtil.clone(current);avoid.push(mainObject[att])}flatten(current.children)}};flatten(mainObject);var reEnforce={};var reEnforce=function(obj){for(var att in obj){if(reEnforce[att]){continue}reEnforce[att]=att;var current=obj[att];reEnforce(current);var children=current.children;for(var sub in children){var subObject=obj[sub];if(subObject){reEnforce(subObject);reEnforce:{for(var subAtt in mainObject[sub].children){current.children[sub].children=mainObject[sub].children;break reEnforce}for(var subAtt in current.children[sub].children){mainObject[sub].children=current.children[sub].children;break reEnforce}}}}}};reEnforce(mainObject);var prepareArgs=function(originalArgs,parentNode,container,suffixId){var subArgs=CoreUtil.clone(originalArgs,parentNode,container);subArgs.parent=container.id;subArgs.parentNode=parentNode;if(!subArgs.id){subArgs.id=subArgs.name}if(suffixId){subArgs.id=suffixId+"_"+subArgs.id}if(layout){var layoutInfo=layout[subArgs.id];if(layoutInfo){subArgs.x=layoutInfo.x;subArgs.y=layoutInfo.y;subArgs.h=layoutInfo.h;subArgs.w=layoutInfo.w;subArgs.hasLayoutInformation=true}}subArgs.container=container;return subArgs};var rowMargin=20;var columnMargin=20;var horiontalSpace=30;var verticalSpace=30;var columnStart=columnMargin;var rowStart=rowMargin+horiontalSpace;var isAutoLayout=true;for(var att in mainObject){var current=mainObject[att];var args=prepareArgs(current.args,this,this);if(!args.x||!args.y){if(!isAutoLayout){columnStart=columnStart+columnMargin+20}args.x=rowStart;args.y=columnStart;isAutoLayout=true}else{isAutoLayout=false}if(current.descriptor==="Part"){args.isStructureDiagram=true}var shape=ShapesRegistry.draw(current.descriptor,args);var children=current.children;var margined=false;var parentSet=false;var pending=[];for(var subAtt in children){var subCurrent=children[subAtt];var subShapeArgs=prepareArgs(subCurrent.args,this,shape,att);var subShape=ShapesRegistry.draw(subCurrent.descriptor,subShapeArgs);subShape._incomplete=true;if(!subShapeArgs.hasLayoutInformation){shape.addChild(subShape);parentSet=true}else{parentSet=false}if(subCurrent.descriptor==="Part"||(subCurrent.descriptor==="Port"&&(subCurrent.args.isPrivate==="true"||subCurrent.args.isPrivate===true))){if(!margined){rowStart=rowStart+rowMargin+horiontalSpace;columnStart=columnStart+columnMargin+20;margined=true}var subChildren=subCurrent.children;for(var subSubAtt in subChildren){var subSubCurrent=subChildren[subSubAtt];if(subSubCurrent.descriptor==="Port"){var _args=prepareArgs(subSubCurrent.args,this,subShape,att);var subShape1=ShapesRegistry.draw(subSubCurrent.descriptor,_args);if(!_args.hasLayoutInformation){subShape.addChild(subShape1)}else{pending.push(subShape1)}}}var subPosition=subShape.getPosition();if(subPosition.x+rowStart>650){var containerPosition=shape.getPosition();var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;columnStart=currentHeightEnd+verticalSpace;rowStart=rowMargin+horiontalSpace+rowMargin+horiontalSpace}if(isAutoLayout){subShape.shiftPosition({x:rowStart,y:columnStart})}delete subShape._incomplete;for(var pendingIndex=0,currentPending;currentPending=pending[pendingIndex];pendingIndex++){subShape.addChild(currentPending)}pending=[];subPosition=subShape.getPosition();var containerPosition=shape.getPosition();var end=subPosition.x+subPosition.w;var currentEnd=(containerPosition.x+containerPosition.w)-40;var heightEnd=subPosition.y+subPosition.h;var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;var wDiff=end-currentEnd;var hDiff=heightEnd-currentHeightEnd;if(hDiff>0||wDiff>0){var object={};if(wDiff>0){object.w=wDiff}if(hDiff>0){object.h=hDiff}shape.shiftPosition(object)}rowStart=rowStart+subPosition.w+rowMargin+rowMargin+rowMargin+rowMargin}pending=[];if(!parentSet){shape.addChild(subShape)}delete subShape._incomplete}var containerPosition=shape.getPosition();var currentEnd=(containerPosition.x+containerPosition.h)-40;var containerPosition=shape.getPosition();var currentHeightEnd=(containerPosition.y+containerPosition.h)-20;columnStart=columnMargin+currentHeightEnd+verticalSpace;rowStart=rowMargin+horiontalSpace;this.addChild(shape)}for(var att in mainObject){var part=ShapesRegistry.get("Part",att);for(var uncategoriedIndex=0,uncategoried;uncategoried=undefineds[uncategoriedIndex];uncategoriedIndex++){var args=uncategoried.args;var source=args.sources[0];var target=args.targets[0];var partSource=att+"_"+source;if(!ShapesRegistry.get("Port",partSource)){continue}var partTarget=att+"_"+target;if(!ShapesRegistry.get("Port",partTarget)){continue}var altered=CoreUtil.clone(args);altered.sources=[partSource];altered.part=att;altered.targets=[partTarget];altered.parentNode=this;altered.container=part;ShapesRegistry.draw(uncategoried.descriptor,altered)}}var pos=ObjectsUtil.get("util.core.DomUtil").position(this.focalNode,true);this.focalNode.style.height=(currentHeightEnd+20)+"px";this._incomplete=false;this.refreshBoundaries();var parts=ShapesRegistry.get("Part");var byGroups=ShapesRegistry.getAndGroup("Part");this.adjustShapes(layout||{},byGroups,parts)},adjustShapes:function(layout,byGroups,parts,around){var visited=[];for(var att in parts){var part=parts[att];var alteredPosition=part.getPosition();var shiftVal=this._adjustShapes(parts[att],layout,visited,around);if(shiftVal){shiftVal=shiftVal-5;part.shiftPosition({x:-(around?shiftVal-around:shiftVal)})}if(byGroups){var subParts=byGroups[part.name];for(var subAtt in subParts){var subPart=subParts[subAtt];var basePosition=subPart.getPosition();for(var sub2Att in subParts){if(sub2Att===subAtt){continue}var subPart2=subParts[sub2Att];var subPart2Position=subPart2.getPosition();if(subPart2Position.x>basePosition.x||Math.abs(subPart2Position.y-basePosition.y)>50){continue}var to=subPart2Position.x+subPart2Position.w;for(var index=0,subPart2child;subPart2child=subPart2.children[index];index++){if(subPart2child.className==="layout.shapes.Port"){var x=parseFloat(subPart2child.labelNode.getAttribute("x"));var textWidth=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(subPart2child.labelNode.childNodes[0].textContent+"...",subPart2child.labelNode).w;var exepctedTo=x+textWidth;if(exepctedTo>to){to=exepctedTo}}}var subShift=this._adjustShapes(subPart,layout,[],to);if(subShift!=basePosition.x){subShift=(to)-subShift;subPart.shiftPosition({x:subShift})}}}}}},_adjustShapes:function(part,layout,visited,around,level){if(layout[part.id]||visited.indexOf(part)>-1){return}visited.push(part);var position=part.getPosition();var shiftVal=around||0;for(var index=0,child;child=part.children[index];index++){if(child.className==="layout.shapes.Port"){var x=parseFloat(child.labelNode.getAttribute("x"));if(x<shiftVal){shiftVal=x}}else{if(child.className==="layout.shapes.Part"){var nestedShiftVal=this._adjustShapes(child,layout,visited);if(nestedShiftVal<shiftVal){var alteredPosition=child.getPosition();alteredPosition.x=alteredPosition.x-nestedShiftVal;child.setPosition(alteredPosition)}}}}return shiftVal},refreshBoundaries:function(){var position=ObjectsUtil.get("util.core.DomUtil").position(this.focalNode,true);var verticalEnd=position.y+position.h;var horizontalEnd=position.x+position.w;var children=this.getChildren("partNode");var maxY=0,maxX=0;for(var index=0,child;child=children[index];index++){if(child.className!=="layout.shapes.Part"){continue}var pos=child.getPosition();var horizontalEnd=pos.x+pos.w;if(horizontalEnd>maxX){maxX=horizontalEnd}verticalEnd=pos.y+pos.h+20;if(verticalEnd>maxY){maxY=verticalEnd}var verticalEnd=pos.y+pos.h;if(verticalEnd>maxY){maxY=verticalEnd}var partChildren=child.getChildren();for(var subIndex=0,partChild;partChild=partChildren[subIndex];subIndex++){if(partChild.labelNode){var labelPos=ObjectsUtil.get("util.core.DomUtil").position(partChild.labelNode);horizontalEnd=labelPos.x+labelPos.w;if(horizontalEnd>maxX){maxX=horizontalEnd}verticalEnd=labelPos.y+labelPos.h;if(verticalEnd>maxY){maxY=verticalEnd}}var partChildChildren=partChild.getChildren();for(var subSubIndex=0,partChildChild;partChildChild=partChildChildren[subSubIndex];subSubIndex++){if(!partChildChild.labelNode){continue}labelPos=ObjectsUtil.get("util.core.DomUtil").position(partChildChild.labelNode);horizontalEnd=labelPos.x+labelPos.w;if(horizontalEnd>maxX){maxX=horizontalEnd}verticalEnd=labelPos.y+labelPos.h;if(verticalEnd>maxY){maxY=verticalEnd}}}}var height=parseFloat(this.focalNode.style.height);if(Math.abs(maxY-height)>1){this.focalNode.style.height=(maxY+10)+"px"}var width=parseFloat(this.focalNode.style.width);if(Math.abs(maxX-width)>1){this.focalNode.style.width=(maxX+10)+"px"}}});ObjectsUtil.declare("layout.shapes.Part",["layout.shapes.StructureDiagramNode"],{isStructureDiagram:null,multiplicity:null,children:null,focalNode:null,guid:null,iconPart:null,name:null,parent:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,height:null,width:null,yCoord:null,xCoord:null,_moving:null,type:null,constructor:function(args){this.isStructureDiagram=args.isStructureDiagram;this.multiplicity=args.multiplicity;this.type="partNode";this.parent=args.parent;this.children=[];this.name=args.name||("Node"+incremntal);this.guid=args.id||this.name;this.color=args.color||DEFAULT_COLOR;this.fontColor=args.fontColor||DEFAULT_FONT_COLOR;this.rx=args.rx||DEFAULT_ROUND_RATIO;this.strokeWidth=args.strokeWidth||1;this.strokeWidth=this.strokeWidth+"px";incremntal++},addChild:function(child){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");if(CoreUtil.isArray(child)){for(var index=0,c;c=child[index];index++){this.children.push(c)}}else{this.children.push(child)}this.applyConstraints()},getChildren:function(type,args){if(type){var filtered=[];for(var index=0,child;child=this.children[index];index++){if(child.type===type){var valid=true;if(args){for(var att in args){if(!args[att]?child[att]:args[att]!==child[att]){valid=false;break}}}if(valid){filtered.push(child)}}}return filtered}return this.children},draw:function(args){var settings=this.getSuperContainer().settings;this.part_highlight_color=settings.part_highlight_color||"#5DBCD2";this.part_container_highlight_color=settings.part_container_highlight_color||"#FFFFFF";this.part_container_label_highlight_color=settings.part_container_label_highlight_color||"#e6e6e6";var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var DomUtil=ObjectsUtil.get("util.core.DomUtil");this.focalNode=document.createElementNS(SVGUtil.SVG,"g");var mouseMoveHandler=Events.connect("mousemove",this.focalNode,this,function(e){if(this.__resizeStarted){return}var self=this;var stopListening=function(){delete self.__resizeStarted;Events.disconnect(self._tempResizeMouseUpHandler);Events.disconnect(self._tempResizeMouseDownHandler);Events.disconnect(self._tempResizeMouseMoveHandler);self.focalNode.style.cursor="";delete self._tempResizeMouseDownHandler};var iseDetected=false;var position=DomUtil.position(this.focalNode);var horizontalEnd=position.x+position.w;var horizontalDiff=(e.clientX)-horizontalEnd;if(Math.abs(horizontalDiff)<10){this.focalNode.style.cursor="col-resize";iseDetected=true}else{var verticalEnd=position.y+position.h;var verticalDiff=(e.clientY)-verticalEnd;if(Math.abs(verticalDiff)<10){this.focalNode.style.cursor="row-resize";iseDetected=true}}Events.disconnect(this._tempResizeMouseDownHandler);Events.disconnect(this._tempResizeMouseOutHandler);if(iseDetected){this._tempResizeMouseDownHandler=Events.connect("mousedown",document,this,function(e){if(this.__resizeStarted){stopListening()}Events.disconnect(this._tempResizeMouseOutHandler);CoreUtil.stopEvent(e);this.__resizeStarted=true;this._tempResizeMouseUpHandler=Events.connect("mouseup",document,this,function(e){CoreUtil.stopEvent(e);stopListening();this.getSuperContainer().refreshBoundaries()});this._tempResizeMouseMoveHandler=Events.connect("mousemove",document,this,function(e){CoreUtil.stopEvent(e);if(!this._tempResizeMouseDownHandler){stopListening();return}var children=this.getChildren();var maxY=0,maxX=0;for(var index=0,child;child=children[index];index++){if(child.className!=="layout.shapes.Part"){continue}var pos=DomUtil.position(child.focalNode);var horizontalEnd=pos.x+pos.w;if(horizontalEnd>maxX){maxX=horizontalEnd}var verticalEnd=pos.y+pos.h;if(verticalEnd>maxY){maxY=verticalEnd}}var object={};var position=DomUtil.position(this.focalNode);var set=false;if(this._tempResizeMouseDownHandler.verticalDiff){if(e.clientY>maxY){object.h=(e.clientY)-position.y;set=true}}else{if(this._tempResizeMouseDownHandler.horizontalDiff){if(e.clientX>maxX){object.w=(e.clientX)-position.x;set=true}}}if(set){this.setPosition(object)}})});this._tempResizeMouseDownHandler.horizontalDiff=horizontalDiff;this._tempResizeMouseDownHandler.verticalDiff=verticalDiff;this._tempResizeMouseOutHandler=Events.connect("mouseout",this.focalNode,this,function(e){stopListening()})}else{stopListening()}});this.focalNode.setAttribute("style","fill: "+this.color+"; font-family:'sans-serif';");this.parentNode.appendChild(this.focalNode);this.rectNode=document.createElementNS(SVGUtil.SVG,"rect");this.rectNode.setAttribute("style","stroke:#000000;");this.rectNode.setAttribute("fill","#FFFFFF");this.focalNode.appendChild(this.rectNode);this.highlightNode=document.createElementNS(SVGUtil.SVG,"rect");this.highlightNode.setAttribute("style","stroke:#000000;");if(!this.isStructureDiagram){this.highlightNode.setAttribute("fill",this.part_highlight_color)}else{this.highlightNode.setAttribute("fill",this.part_container_highlight_color)}this.focalNode.appendChild(this.highlightNode);this.nameNode=document.createElementNS(SVGUtil.SVG,"text");this.nameNode.setAttribute("style","fill: #000000;  font-family:tahoma; font-size: 10; font-weight:bold");this.nameNode.appendChild(document.createTextNode(args.name));this.focalNode.appendChild(this.nameNode);if(!this.isStructureDiagram){this.iconPart=ShapesRegistry.draw("PartIcon",{parentNode:this.focalNode})}this.setPosition({x:args.x,y:args.y,h:args.h,w:args.w});var mouseDownHandler=Events.connect("mousedown",this.focalNode,this,function(e){if(this._tempResizeMouseDownHandler){return}this.handleMove(this.focalNode,e)});var mouseDownHandler=Events.connect("mousedown",this.highlightNode,this,function(e){if(this._tempResizeMouseDownHandler){return}this.handleMove(this.focalNode,e)})},updatePosition:function(position){var currentPosition=ObjectsUtil.get("util.core.DomUtil").transformValue(this.focalNode);currentPosition.h=parseFloat(this.rectNode.getAttribute("height"));currentPosition.w=parseFloat(this.rectNode.getAttribute("width"));if(position.h){currentPosition.h=currentPosition.h+position.h}if(position.w){currentPosition.w=currentPosition.w+position.w;var children=this.getChildren("portNode");for(var childIndex=0,child;child=children[childIndex];childIndex++){StructureDiagramUtil.portToPart(child,function(x,y,direction,portPosition){if(direction==="right"){var pos=child.getPosition();child.shiftPosition({x:position.w},true)}})}}this.setPosition(currentPosition,true)},shiftPosition:function(shiftObject,args){var position={x:this.xCoord,y:this.yCoord,h:this.height,w:this.width};for(var att in shiftObject){position[att]=(position[att]||0)+shiftObject[att]}this.setPosition(position,args)},setPosition:function(position,restrained){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var currentPosition=this.getPosition();var xCoord=parseFloat(position.x)||this.xCoord||0;var yCoord=parseFloat(position.y)||this.yCoord||0;var height=parseFloat(position.h)||this.height||40;var textWidth=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(this.nameNode.childNodes[0].textContent+"...",this.nameNode).w;var width=parseFloat(position.w)||this.width||(textWidth+75);if(height<40){height=40}if(width<(textWidth+75)){width=(textWidth+75)}this.highlightNode.setAttribute("height",20);this.highlightNode.setAttribute("width",width);this.rectNode.setAttribute("height",height);this.rectNode.setAttribute("width",width);if(!this.isStructureDiagram){this.iconPart.setPosition({x:width-25,y:6})}this.focalNode.setAttribute("transform","translate("+xCoord+","+yCoord+")");if(!this.isStructureDiagram&&this.multiplicity==="*"){if(!this.shadowNode){this.shadowNode=document.createElementNS(SVGUtil.SVG,"rect");this.shadowNode.setAttribute("style","stroke:#000000;");this.shadowNode.setAttribute("fill","none");this.focalNode.insertBefore(this.shadowNode,this.focalNode.firstChild)}this.shadowNode.setAttribute("transform","translate("+(3)+","+(-3)+")");this.shadowNode.setAttribute("height",height);this.shadowNode.setAttribute("width",width)}this.nameNode.setAttribute("y","15");if(this.isStructureDiagram){this.nameNode.setAttribute("x","15");if(!this.nameNode.highlight){this.nameNode.highlight=document.createElementNS("http://www.w3.org/2000/svg","rect");this.nameNode.highlight.setAttribute("style","fill:"+this.part_container_label_highlight_color+";");this.nameNode.parentNode.insertBefore(this.nameNode.highlight,this.nameNode);this.nameNode.highlight.border=document.createElementNS(SVGUtil.SVG,"polygon");this.nameNode.highlight.border.setAttribute("style","stroke:black;stroke-width:1;");this.nameNode.parentNode.insertBefore(this.nameNode.highlight.border,this.nameNode)}else{this.nameNode.parentNode.removeChild(this.nameNode.highlight);this.nameNode.parentNode.insertBefore(this.nameNode.highlight,this.nameNode);this.nameNode.parentNode.removeChild(this.nameNode.highlight.border);this.nameNode.parentNode.insertBefore(this.nameNode.highlight.border,this.nameNode)}this.nameNode.highlight.setAttribute("x","1");this.nameNode.highlight.setAttribute("y","1");this.nameNode.highlight.setAttribute("width",textWidth+10);this.nameNode.highlight.setAttribute("height",18);var xDelta=0;var yDelta=0;if(!CoreUtil.browserSettings()||CoreUtil.browserSettings().browser!=="chrome"){xDelta=2;yDelta=18}else{xDelta=0;yDelta=20}this.nameNode.highlight.border.setAttribute("points",(textWidth+11)+","+xDelta+" "+(textWidth+11)+","+yDelta)}else{this.nameNode.setAttribute("x",(width/2)-(textWidth/2))}if(!restrained){var newPosition=this.getPosition();var shiftX=newPosition.x-currentPosition.x;var shiftY=newPosition.y-currentPosition.y;if(shiftX!==0||shiftY!==0){for(var index=0,child;child=this.children[index];index++){if(child.className==="layout.shapes.Port"||child.className==="layout.shapes.Part"){child.shiftPosition({x:shiftX,y:shiftY})}}}this.applyConstraints()}this.xCoord=xCoord;this.yCoord=yCoord;this.height=height;this.width=width;if(this.container&&this.container.getPrecisePosition){var containerPosition=this.container.getPrecisePosition();var lastEnd=this.yCoord+this.height;var lastWidthEnd=this.xCoord+this.width;var containerEnd=containerPosition.y+containerPosition.h-20;var containerWidthEnd=containerPosition.x+containerPosition.w-20;var hDiff=lastEnd-containerEnd;var wDiff=lastWidthEnd-containerWidthEnd;if(hDiff>0||wDiff>0){var object={};var changed=false;if(hDiff>0){object.h=hDiff+20;changed=true}if(wDiff>10){object.w=wDiff+20;changed=true}if(changed){this.container.shiftPosition(object)}}}this.refreshBoundaries()},refreshBoundaries:function(){var superContainer=this.getSuperContainer();if(superContainer._incomplete){return}superContainer.refreshBoundaries()},getPosition:function(){var DomUtil=ObjectsUtil.get("util.core.DomUtil");var position=DomUtil.position(this.focalNode,true);var focRect=this.focalNode.getBoundingClientRect();var focParentRect=this.focalNode.parentNode.parentNode.getBoundingClientRect();position.x=focRect.left-focParentRect.left;position.y=focRect.top-focParentRect.top;position.y=(position.y+8)-parseInt(window.getComputedStyle(this.focalNode.parentNode.parentNode,null).getPropertyValue("padding-top"));position.x=(position.x+8)-parseInt(window.getComputedStyle(this.focalNode.parentNode.parentNode,null).getPropertyValue("padding-left"));var container=DomUtil.getFirstParent(this.focalNode,"svg").parentNode;var scrollLeft=container.scrollLeft;var scrollTop=container.scrollTop;position.x=position.x+(scrollLeft||0);position.y=position.y+(scrollTop||0);if(this.shadowNode){position.w=position.w-3;position.h=position.h-3}return position},getPrecisePosition:function(){return{h:this.height,w:this.width,y:this.yCoord,x:this.xCoord}},applyConstraints:function(){if(this._incomplete){return}var position=this.getPosition();var alteredPosition=this.getPosition();var shiftVal=0;for(var index=0,child;child=this.children[index];index++){if(child.className==="layout.shapes.Port"){child.applyConstraints()}else{if(child.className==="layout.shapes.Part"){}}}if(alteredPosition.w!==position.w){this.setPosition(alteredPosition,true)}},handleMove:function(vertex,event){var DomUtil=ObjectsUtil.get("util.core.DomUtil");var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var canvas=DomUtil.getFirstParent(vertex,"svg");var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();p.x=event.clientX;p.y=event.clientY;p=p.matrixTransform(m.inverse());var position=this.getPrecisePosition();var deltaX=parseFloat(p.x)-parseFloat(position.x);var deltaY=parseFloat(p.y)-parseFloat(position.y);var originalPosition;if(this.container.getPrecisePosition){originalPosition=this.container.getPrecisePosition()}this._moving=vertex;var disableTextSelection=Events.connect("onselectstart",document,this,function(e){CoreUtil.stopEvent(e)});var mouseMoveHandle=Events.connect("mousemove",document,this,function(e){var self=this;var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();p.x=e.clientX;p.y=e.clientY;p=p.matrixTransform(m.inverse());var object={};var position=self.getPrecisePosition();object.y=p.y;object.x=p.x;var containerNewPosition=self.container[self.container.getPrecisePosition?"getPrecisePosition":"getPosition"]();if(object.x-deltaX<containerNewPosition.x){return}if(object.y-deltaY<containerNewPosition.y){return}self.setPosition({x:object.x-deltaX,y:object.y-deltaY});if(originalPosition){var containerNewPosition=self.container.getPrecisePosition();var lastEnd=self.yCoord+self.height;var lastWidthEnd=self.xCoord+self.width;var containerEnd=originalPosition.y+originalPosition.h;var containerWidthEnd=originalPosition.x+originalPosition.w;var hDiff=lastEnd-containerEnd;var wDiff=lastWidthEnd-containerWidthEnd;if(hDiff<0&&wDiff<0){self.container.setPosition(originalPosition)}}});var mouseUpHandle=Events.connect("mouseup",document,this,function(){Events.disconnect(mouseMoveHandle);Events.disconnect(mouseUpHandle);Events.disconnect(disableTextSelection);this._moving=undefined;this.getSuperContainer().refreshBoundaries();Events.publish("structure.diagram.node.move."+this.id)});CoreUtil.stopEvent(event)}});var ICON_WIDTH=12;var ICON_HEIGHT=10;ObjectsUtil.declare("layout.shapes.PartIcon",["layout.shapes.AbstractNode"],{draw:function(args){this.iconNode=document.createElementNS(SVGUtil.SVG,"rect");this.iconNode.setAttribute("style","stroke:#000000;");this.iconNode.setAttribute("height",ICON_HEIGHT);this.iconNode.setAttribute("width",ICON_WIDTH);this.iconNode.setAttribute("fill","none");this.parentNode.appendChild(this.iconNode)},setPosition:function(position){var xCoord=parseFloat(position.x)||0;var yCoord=parseFloat(position.y)||0;var margin=2;var separator=1;var partHeight=2;var partWidth=6;this.iconNode.setAttribute("x",xCoord);this.iconNode.setAttribute("y",yCoord);if(!this.iconNodePart1){this.iconNodePart1=document.createElementNS(SVGUtil.SVG,"rect")}else{this.parentNode.removeChild(this.iconNodePart1)}this.iconNodePart1.setAttribute("style","stroke:#000000;");this.iconNodePart1.setAttribute("height",partHeight);this.iconNodePart1.setAttribute("width",partWidth);this.iconNodePart1.setAttribute("y",yCoord+margin);this.iconNodePart1.setAttribute("x",xCoord-(partWidth/2));this.iconNodePart1.setAttribute("fill","#5DBCD2");this.parentNode.appendChild(this.iconNodePart1);if(!this.iconNodePart2){this.iconNodePart2=document.createElementNS(SVGUtil.SVG,"rect")}else{this.parentNode.removeChild(this.iconNodePart2)}this.iconNodePart2.setAttribute("style","stroke:#000000;");this.iconNodePart2.setAttribute("height",partHeight);this.iconNodePart2.setAttribute("width",partWidth);this.iconNodePart2.setAttribute("y",yCoord+margin+partHeight+margin);this.iconNodePart2.setAttribute("x",xCoord-(partWidth/2));this.iconNodePart2.setAttribute("fill","#5DBCD2");this.parentNode.appendChild(this.iconNodePart2)}});var PortSymbols=ObjectsUtil.define("layout.shapes.Port.PortSymbols",{right:function(port){port.symbol=document.createElementNS(SVGUtil.SVG,"polygon");port.symbol.setAttribute("points","8,2 2.5,5 8,8");port.symbol.setAttribute("style","fill:black;stroke:#000000;stroke-width:1");port.containerNode.appendChild(port.symbol)},left:function(port){port.symbol=document.createElementNS(SVGUtil.SVG,"polygon");port.symbol.setAttribute("points","2.5,2 8,5 2.5,8");port.symbol.setAttribute("style","fill:#000000;stroke:#000000;stroke-width:1");port.containerNode.appendChild(port.symbol)},twoArrows:function(port){var drawLine=function(x1,y1,x2,y2){var line1=document.createElementNS(SVGUtil.SVG,"line");line1.setAttribute("x1",x1);line1.setAttribute("y1",y1);line1.setAttribute("x2",x2);line1.setAttribute("y2",y2);line1.setAttribute("style","fill:#000000;stroke:#000000;stroke-width:1");port.containerNode.appendChild(line1)};drawLine("4","2","8.5","4");drawLine("1.5","4","8.5","4");drawLine("1.5","6","8.5","6");drawLine("1.5","6","6","8")},conjugated:function(port){var symbol=PortSymbols._drawCircleSymbol(port,"Conjucated port");symbol.setAttribute("style","stroke: black;")},conjugatedReplicated:function(port){var symbol=PortSymbols._drawCircleSymbol(port,"Conjucated replicated port");symbol.setAttribute("style","stroke: black;");port.set3D()},replicatedEndPort:function(port){PortSymbols.endPort(port,"Replicated end port");port.set3D()},endPort:function(port,title){var symbol=PortSymbols._drawCircleSymbol(port,title||"End port");var currentParentColor=port.focalNode.getAttribute("fill");symbol.setAttribute("style","stroke: "+currentParentColor+";");symbol.setAttribute("fill",currentParentColor);port.focalNode.setAttribute("fill","#000000")},conjucatedReplicatedRelayPort:function(port){var symbol=PortSymbols._drawRectSymbol(port,"Conjucated replicated relay port");symbol.setAttribute("style","stroke: black;");port.set3D()},conjucatedRelayPort:function(port){var symbol=PortSymbols._drawRectSymbol(port,"Conjucated relay port");symbol.setAttribute("style","stroke: black;")},replicatedRelayPort:function(port){PortSymbols.relayPort(port,"Replicated relay port");port.set3D()},relayPort:function(port,title){var symbol=PortSymbols._drawRectSymbol(port,title||"Relay port");symbol.setAttribute("style","stroke: black;");var currentParentColor=port.focalNode.getAttribute("fill");symbol.setAttribute("style","stroke: "+currentParentColor+";");symbol.setAttribute("fill",currentParentColor);port.focalNode.setAttribute("fill","#000000")},_drawCircleSymbol:function(port,title){var circle=document.createElementNS(SVGUtil.SVG,"circle");circle.setAttribute("fill","#000000");circle.setAttribute("r",3);circle.setAttribute("cx",5);circle.setAttribute("cy",5);port.containerNode.appendChild(circle);PortSymbols._appendTooltip(title,port,circle);return circle},_drawRectSymbol:function(port,title){var rect=document.createElementNS(SVGUtil.SVG,"rect");rect.setAttribute("fill","#000000");rect.setAttribute("height",4);rect.setAttribute("width",4);rect.setAttribute("x",3);rect.setAttribute("y",3);port.containerNode.appendChild(rect);PortSymbols._appendTooltip(title,port,rect);return rect},_appendTooltip:function(title,port,element){if(title){element.titleElement=document.createElementNS(SVGUtil.SVG,"title");port.focalNode.appendChild(element.titleElement);element.titleElement.appendChild(document.createTextNode(title));element.titleElement=document.createElementNS(SVGUtil.SVG,"title");element.appendChild(element.titleElement);element.titleElement.appendChild(document.createTextNode(title))}}});var ConnectorSymbols=ObjectsUtil.define("layout.shapes.connector.ConnectorSymbols",{draw:function(connector,args,direction,receive){return ConnectorSymbols._draw(connector,args,direction,receive)},_draw:function(connector,args,direction,receive){if(!connector.connectorSymbol){connector.connectorSymbol=document.createElementNS(SVGUtil.SVG,"g");connector.connectorSymbol.setAttribute("fill","none");var r=5;var delta=4;var title="";if(args.indexOf("provide")>-1){connector.connectorSymbol.path=document.createElementNS(SVGUtil.SVG,"path");connector.connectorSymbol.path.setAttribute("style","stroke: #000000;");connector.connectorSymbol.appendChild(connector.connectorSymbol.path);title="Provide"}if(args.indexOf("require")>-1){connector.connectorSymbol.circle1=document.createElementNS(SVGUtil.SVG,"circle");connector.connectorSymbol.circle1.setAttribute("style","stroke: black;");connector.connectorSymbol.circle1.setAttribute("r",r);connector.connectorSymbol.appendChild(connector.connectorSymbol.circle1);connector.connectorSymbol.setAttribute("fill","white");if(title){title=title+"\\"}title=title+"Require"}if(title){connector.connectorSymbol.title=document.createElementNS(SVGUtil.SVG,"title");connector.connectorSymbol.appendChild(connector.connectorSymbol.title);connector.connectorSymbol.title.appendChild(document.createTextNode(title))}connector.parentNode.appendChild(connector.connectorSymbol)}else{connector.parentNode.removeChild(connector.connectorSymbol);connector.parentNode.appendChild(connector.connectorSymbol)}if(connector.connectorSymbol.path){var r=5;var delta=4;var firstEnd=r+delta;var otherEnd=firstEnd*-1;if(receive){if(direction==="vertical"){var pair1=(otherEnd+",0");var pair2=(firstEnd+",0")}else{var pair1=("0,"+otherEnd);var pair2=("0,"+(firstEnd))}}else{if(direction==="vertical"){var pair2=(otherEnd+",0");var pair1=(firstEnd+",0")}else{var pair2=("0,"+otherEnd);var pair1=("0,"+(firstEnd))}}var pathString="M"+pair1+(" A"+r+","+r)+" 0 0,1 "+pair2;connector.connectorSymbol.path.setAttribute("d",pathString)}return connector.connectorSymbol}});var LABEL_FONT_SETTINGS={fontSize:10,fontFamily:"arial, serif",fontWeight:"normal"};ObjectsUtil.declare("layout.shapes.Port",["layout.shapes.StructureDiagramNode"],{focalNode:null,guid:null,isPrivate:null,connectors:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,portType:null,constructor:function(args){this.type="portNode";this.isPrivate=(args.isPrivate==="true"||args.isPrivate===true)?true:false;this.multiplicity=args.multiplicity;this.connectors={sources:[],targets:[]};this.portType=args.portType;this.name=args.name||("Node"+incremntal);this.guid=args.id||this.name;this.color=args.color||DEFAULT_COLOR;this.fontColor=args.fontColor||DEFAULT_FONT_COLOR;this.rx=args.rx||DEFAULT_ROUND_RATIO;this.strokeWidth=args.strokeWidth||1;this.strokeWidth=this.strokeWidth+"px";incremntal++},addConnector:function(child,type){var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");if(CoreUtil.isArray(child)){for(var index=0,c;c=child[index];index++){if(this.connectors[type].indexOf(c)>-1){continue}this.connectors[type].push(c)}}else{if(this.connectors[type].indexOf(child)==-1){this.connectors[type].push(child)}}},draw:function(args){var settings=this.getSuperContainer().settings;this.portFillColor=settings.portFillColor||"#FFFFCC";this.containerNode=document.createElementNS(SVGUtil.SVG,"g");this.parentNode.appendChild(this.containerNode);this.focalNode=document.createElementNS(SVGUtil.SVG,"rect");this.focalNode.setAttribute("style","stroke:#000000;");this.focalNode.setAttribute("height","10");this.focalNode.setAttribute("width","10");this.focalNode.setAttribute("fill",this.portFillColor);this.containerNode.appendChild(this.focalNode);var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var DomUtil=ObjectsUtil.get("util.core.DomUtil");var typeSymbol=args.typeSymbol;if(typeSymbol){if(typeSymbol.indexOf("(function")>-1){var typeSymboleEval=eval(typeSymbol);if(CoreUtil.isFunction(typeSymboleEval)){typeSymboleEval(this)}}}else{var portType=args.portType;var mappedFunction=PortSymbols[portType];if(mappedFunction){mappedFunction(this)}}this.labelNode=document.createElementNS(SVGUtil.SVG,"text");this.labelNode.setAttribute("style","fill: #000000;  font-family:"+LABEL_FONT_SETTINGS.fontFamily+"; font-size: "+LABEL_FONT_SETTINGS.fontSize+";  font-weight:"+LABEL_FONT_SETTINGS.fontWeight+";");var portLabelText=args.name;if(args.multiplicity!==undefined){portLabelText=portLabelText+"["+args.multiplicity+"]"}this.labelNode.appendChild(document.createTextNode(portLabelText));this.parentNode.appendChild(this.labelNode);var partObject=this.container;if(args.x!==undefined&&args.y!==undefined){this.setPosition({x:args.x,y:args.y},true)}else{if(!this.isPrivate){var x,y,delta;var position=partObject.getPosition();var portPosition=this.getPosition();var children=partObject.getChildren("portNode",{isPrivate:undefined});var adjustedLength=children.length;var w=this.getPosition().w;var direction=children.length%10;var partMax=position.x+position.w;for(var index=0,child;child=children[index];index++){StructureDiagramUtil.portToPart(child,function(x,y,_direction,portPosition){if(_direction==="right"||_direction==="left"){return}var prevWidth=DomUtil.calculateTextSize(child.labelNode.childNodes[0].textContent,child.labelNode).w;var childPosition=child.getPosition();var start=child.getPosition().x;var reachTo=start+prevWidth/2;if(partMax<reachTo+childPosition.w*2||partMax<start+childPosition.w*2){return}var diff=(prevWidth/2+w/2);var deltaDiff=position.w/6;if(diff>position.w/5-15){direction++}if(diff>position.w/4){direction++}})}var self=this;if(direction<10){var directionFinder=function(direction,looped){if(direction===0){delta=(((position.h/2))/2)-5;x=position.x-portPosition.w;y=(position.y+(position.h/2))-portPosition.h-delta}else{if(direction===1){delta=((position.h/2))/2;x=position.x-portPosition.w;y=((position.y+(position.h/2))-portPosition.h)+delta}else{if(direction===2){delta=((position.w/2))/2;x=(position.x-portPosition.w)+(position.w/2)-delta;y=(position.y)-portPosition.h}else{if(direction===3){x=(position.x-portPosition.w)+(position.w/2);y=(position.y)-portPosition.h}else{if(direction===4){delta=((position.w/2))/2;x=(position.x-portPosition.w)+(position.w/2)+delta;y=(position.y)-portPosition.h}else{if(direction===5){delta=((position.h/2))/2;x=((position.x+position.w)-portPosition.w);y=((position.y+(position.h/2))-portPosition.h)-delta}else{if(direction===6){delta=((position.h/2))/2;x=((position.x+position.w)-portPosition.w);y=((position.y+(position.h/2))-portPosition.h)+delta}else{if(direction===7){delta=((position.w/2))/2;x=((position.x-portPosition.w)+(position.w/2))-delta;y=(position.y+(position.h))-portPosition.h}else{if(direction===8){x=(position.x-portPosition.w)+(position.w/2);y=(position.y+(position.h))-portPosition.h}else{if(direction===9){delta=((position.w/2))/2;x=((position.x-portPosition.w)+(position.w/2))+delta;y=(position.y+(position.h))-portPosition.h}}}}}}}}}}};directionFinder(direction)}else{var start=children.length-10;var direction=start%8;var endY=(position.y+position.h)-20;if(direction<6){var byIndex=((parseFloat(direction/2)+((start-direction+1)/3))*portPosition.h);if(!byIndex){byIndex=4}var delta=parseInt(start/8)+byIndex+(portPosition.h*2);var right=direction%2;if(!right){var x=((position.x)-portPosition.w);var y=((position.y+(position.h/2))-portPosition.h)+delta;var diff=y-endY;if(diff>0){partObject.updatePosition({h:diff})}}else{var x=((position.x)-portPosition.w)+position.w}var updatedPosition=partObject.getPosition();var y=((updatedPosition.y+(updatedPosition.h)))-((portPosition.h*2))+4}else{if(direction%2===0){var x=(position.x+position.w)-(portPosition.w/2);var y=position.y-portPosition.h;partObject.updatePosition({w:30})}else{var x=(position.x+position.w)-parseFloat(portPosition.w*3);var y=(position.y+position.h)-portPosition.h}}}for(var childIndex=0,child;child=children[childIndex];childIndex++){child.applyConstraints()}this.setPosition({x:x,y:y})}}this.applyConstraints();var mouseDownHandler=Events.connect("mousedown",this.containerNode,this,function(e){this.handleMove(this.focalNode,e)});var mouseDownHandler=Events.connect("mousedown",this.labelNode,this,function(e){this.handleMove(this.focalNode,e)})},setPosition:function(position,restrained){xCoord=parseFloat(position.x)||0;yCoord=parseFloat(position.y)||0;this.containerNode.setAttribute("transform","translate("+xCoord+","+yCoord+")");if(this.multiplicity==="*"){this.set3D()}var self=this;StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition){if(direction==="right"){self.labelNode.setAttribute("x",x+2);self.labelNode.setAttribute("y",y-1)}else{if(direction==="top"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.focalNode);self.labelNode.setAttribute("x",x-parseFloat(position.w/2));self.labelNode.setAttribute("y",y-parseFloat(portPosition.h/2))}else{if(direction==="left"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.labelNode);self.labelNode.setAttribute("x",parseFloat((x-(position.w+portPosition.w))));self.labelNode.setAttribute("y",y)}else{if(direction==="bottom"){var position=ObjectsUtil.get("util.core.DomUtil").calculateTextSize(self.labelNode.childNodes[0].textContent,self.focalNode);self.labelNode.setAttribute("x",x-parseFloat(position.w/2));self.labelNode.setAttribute("y",y+parseFloat(portPosition.h))}}}}if(!restrained){self.applyConstraints()}});var parentNode=self.labelNode.parentNode;parentNode.removeChild(self.labelNode);parentNode.appendChild(self.labelNode)},set3D:function(){if(!this.shadowNode){this.shadowNode=document.createElementNS(SVGUtil.SVG,"rect");this.shadowNode.setAttribute("style","stroke:#000000;");this.shadowNode.setAttribute("fill",this.portFillColor||"#FFFFFF");this.containerNode.insertBefore(this.shadowNode,this.containerNode.firstChild)}this.shadowNode.setAttribute("transform","translate("+(1)+","+(-2)+")");this.shadowNode.setAttribute("height",11);this.shadowNode.setAttribute("width",11)},applyConstraints:function(){var part=this.container;if(!part||part._incomplete){return}var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var childPosition=this.getPosition();var position=part.getPosition();if(this.isPrivate){var changed=false;var maxX=((position.x+position.w)-childPosition.w)-childPosition.w;var minX=position.x+childPosition.w;var maxY=((position.y+position.h)-childPosition.h)-childPosition.h;var minY=position.y+childPosition.h;var newPosition=CoreUtil.clone(childPosition);if(newPosition.x<minX){newPosition.x=minX;changed=true}else{if(newPosition.x>maxX){newPosition.x=maxX;changed=true}}if(newPosition.y<minY){newPosition.y=minY;changed=true}else{if(newPosition.y>maxY){newPosition.y=maxY;changed=true}}if(changed){this.setPosition(newPosition,true)}}else{var enforceY=true;var newPosition=CoreUtil.clone(childPosition);var updateY=function(){var pos1=(position.y)-childPosition.h;var pos2=(position.y+position.h)-childPosition.h;var diff1=Math.abs(newPosition.y-pos1);var diff2=Math.abs(newPosition.y-pos2);if(diff2<=diff1){newPosition.y=pos2}else{newPosition.y=pos1}};if(childPosition.x<position.x-childPosition.w){newPosition.x=position.x-childPosition.w}else{if(childPosition.x>((position.x+position.w)-childPosition.w)){newPosition.x=(position.x+position.w)-childPosition.w}else{var max=(position.x+position.w)-childPosition.w;var min=position.x-childPosition.w;var current=newPosition.x;StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition,isCorner,deltaInformation){if(isCorner){updateY()}else{if(direction==="bottom"){if(Math.abs(deltaInformation.deltaBottom)>1){newPosition.y=newPosition.y+deltaInformation.deltaBottom}}else{if(direction==="top"){if(Math.abs(deltaInformation.deltaTop)>1){newPosition.y=newPosition.y-deltaInformation.deltaTop}}else{if(direction==="right"){if(Math.abs(deltaInformation.deltaRight)>1){newPosition.x=newPosition.x+deltaInformation.deltaRight}}else{if(direction==="left"){if(Math.abs(deltaInformation.deltaLeft)>1){newPosition.x=newPosition.x-deltaInformation.deltaLeft}}}}}}});enforceY=false}}if(enforceY){var max=(position.y+position.h)-childPosition.h;var min=(position.y)-childPosition.h;var current=childPosition.y-childPosition.h;if(current<min||current>max){updateY()}}var minimuxX=position.x-childPosition.w;var maximumX=(position.x+position.w)-childPosition.w;var minimuxY=position.y-childPosition.h;var maximumY=(position.y+position.h)-childPosition.h;if(newPosition.x<minimuxX){newPosition.x=minimuxX}if(newPosition.x>maximumX){newPosition.x=maximumX}if(newPosition.y<minimuxY){newPosition.y=minimuxY}if(newPosition.y>maximumY){newPosition.y=maximumY}if(parseInt(newPosition.x)!==parseInt(childPosition.x)||parseInt(newPosition.y)!==parseInt(childPosition.y)||parseInt(newPosition.h)!==parseInt(childPosition.h)||parseInt(newPosition.w)!==parseInt(childPosition.w)){this.setPosition(newPosition,true)}}},getPosition:function(){var transform=ObjectsUtil.get("util.core.DomUtil").transformValue(this.containerNode);transform.w=13;transform.h=13;return transform},handleMove:function(vertex,event){var DomUtil=ObjectsUtil.get("util.core.DomUtil");var CoreUtil=ObjectsUtil.get("util.core.CoreUtil");var canvas=DomUtil.getFirstParent(vertex,"svg");var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();var scrollValue=DomUtil.scrollValue(vertex);p.x=event.clientX+scrollValue.x;p.y=event.clientY+scrollValue.y;p=p.matrixTransform(m.inverse());var position=this.getPosition();var deltaX=parseFloat(p.x)-parseFloat(position.x);var deltaY=parseFloat(p.y)-parseFloat(position.y);this._moving=vertex;var disableTextSelection=Events.connect("onselectstart",document,this,function(e){CoreUtil.stopEvent(e)});var mouseMoveHandle=Events.connect("mousemove",document,this,function(e){var self=this;var m=vertex.parentNode.getScreenCTM();var p=canvas.createSVGPoint();p.x=e.clientX;p.y=e.clientY;p=p.matrixTransform(m.inverse());var object={};if(this.isPrivate){object.y=p.y;object.x=p.x}else{StructureDiagramUtil.portToPart(this,function(x,y,direction,portPosition,isCorner){if(isCorner){object.y=p.y;object.x=p.x}else{if(direction==="left"||direction==="right"){object.y=p.y}else{object.x=p.x}}})}self.shiftPosition(object);CoreUtil.stopEvent(e)});var mouseUpHandle=Events.connect("mouseup",document,this,function(){Events.disconnect(mouseMoveHandle);Events.disconnect(mouseUpHandle);Events.disconnect(disableTextSelection);this._moving=undefined;this.getSuperContainer().refreshBoundaries();Events.publish("structure.diagram.node.move."+this.id)});CoreUtil.stopEvent(event)}});var Events=ObjectsUtil.get("util.core.Events");var incremntal=0;var sources=[];ObjectsUtil.declare("layout.shapes.PortConnector",["layout.shapes.StructureDiagramNode"],{focalNode:null,guid:null,name:null,color:null,fontColor:null,rx:null,parentNode:null,strokeWidth:null,_moving:null,type:null,connectorType:null,constructor:function(args){this.connectorType=args.connectorType;this.type="portConnector";this.name=args.name||("Connector"+incremntal);this.guid=args.id||this.name;this.sources=args.sources;this.targets=args.targets;this.part=args.part;incremntal++;this.points=args.points},draw:function(args){var colors=["red","green","blue","brown","black","orange","lime"];var colors=["black","black","black","black","black","black","black","black"];if(sources.indexOf(this.sources[0])===-1){sources.push(this.sources[0])}var color=colors[sources.indexOf(this.sources[0])];this.focalNode=document.createElementNS(SVGUtil.SVG,"polyline");this.focalNode.setAttribute("style","fill:none;stroke:"+color+";stroke-width:1px;");this.parentNode.appendChild(this.focalNode);if(this.points){this.focalNode.setAttribute("points",this.points)}else{this.setPosition();for(var typeIndex=0,type;type=["sources","targets"][typeIndex];typeIndex++){for(var index=0,current;current=this[type][index];index++){var currentPort=ShapesRegistry.get("Port",current);currentPort.addConnector(this,type);Events.connect("setPosition",currentPort,this,function(position){this.setPosition(position)});this.container.applyConstraints()}}}},setPosition:function(position){if(this.sources[0]===this.targets[0]){return this.focalNode.setAttribute("points","")}var positions=[];var properTarget=this["targets"][0];var properSource=this["sources"][0];var targetObject=ShapesRegistry.get("Port",properTarget);var sourceObject=ShapesRegistry.get("Port",properSource);if(targetObject.getPosition().x<sourceObject.getPosition().x){var temp=properSource;properSource=properTarget;properTarget=temp}var handler=function(x,y,direction){positions.push({x:x,y:y,direction:direction})};var adjustPosition=function(object){if(object.direction==="left"){object.x=object.x;object.y=object.y+(5)}else{if(object.direction==="right"){object.x=object.x+(10);object.y=object.y+(5)}else{if(object.direction==="top"){object.x=object.x+5;object.y=object.y}else{if(object.direction==="bottom"){object.y=object.y+10;object.x=object.x+(5)}}}}};var source=ShapesRegistry.get("Port",properSource);var sourcePart=source.container;var sourcePartPosition=sourcePart.getPosition();var sourcePosition=source.getPosition();StructureDiagramUtil.portToPart(properSource,handler);var target=ShapesRegistry.get("Port",properTarget);var targetPart=target.container;var targetPartPosition=targetPart.getPosition();var targetPosition=target.getPosition();StructureDiagramUtil.portToPart(properTarget,handler);var selfConnector=sourcePart===targetPart;var points=[];var pos1=positions[0];if(!positions[0]){return}sourcePosition.direction=pos1.direction;var pos2=positions[1];if(!pos2){return}targetPosition.direction=pos2.direction;var currentSourcePosition=source.getPosition();var currentTargetPosition=target.getPosition();var isInternal=false;var self=this;var revertDirectionForRelayPorts=function(currentPosition,current,other,otherPosition){if(current.isPrivate){if(otherPosition.direction==="left"){currentPosition.direction="right"}else{if(otherPosition.direction==="top"){currentPosition.direction="bottom"}else{if(otherPosition.direction==="bottom"){currentPosition.direction="top"}else{if(otherPosition.direction==="right"){currentPosition.direction="left"}}}}}else{if(current.parent===self.part&&(other.isPrivate||other.parent!==self.part)){if(currentPosition.direction==="left"){currentPosition.direction="right"}else{if(currentPosition.direction==="top"){currentPosition.direction="bottom"}else{if(currentPosition.direction==="bottom"){currentPosition.direction="top"}else{if(currentPosition.direction==="right"){currentPosition.direction="left"}}}}}}};if(source.isPrivate){revertDirectionForRelayPorts(targetPosition,target,source,sourcePosition);revertDirectionForRelayPorts(sourcePosition,source,target,targetPosition)}else{revertDirectionForRelayPorts(sourcePosition,source,target,targetPosition);revertDirectionForRelayPorts(targetPosition,target,source,sourcePosition)}var direction=sourcePosition.direction;var preciseTarget={x:targetPosition.x,y:targetPosition.y,direction:targetPosition.direction};adjustPosition(preciseTarget);var finalDestination={x:preciseTarget.x,y:preciseTarget.y};var preciseStart={x:sourcePosition.x,y:sourcePosition.y,direction:sourcePosition.direction};var moveTo=function(obj){var nextObj={};if(obj.direction==="left"){nextObj.x=obj.x-(10);nextObj.y=obj.y}else{if(obj.direction==="right"){nextObj.x=obj.x+(10);nextObj.y=obj.y}else{if(obj.direction==="top"){nextObj.x=obj.x;nextObj.y=obj.y-(10)}else{if(obj.direction==="bottom"){nextObj.x=obj.x;nextObj.y=obj.y+(10)}}}}nextObj.direction=obj.direction;return nextObj};var points=[];var start={x:sourcePosition.x,y:sourcePosition.y,direction:sourcePosition.direction};adjustPosition(start);points.push(start);var afterStart=moveTo(start);points.push(afterStart);var end={x:targetPosition.x,y:targetPosition.y,direction:targetPosition.direction};adjustPosition(end);var beforeEnd=moveTo(end);points.push({x:beforeEnd.x,y:afterStart.y});points.push(beforeEnd);points.push(end);var detectOverlappedPoints=function(){var length=points.length;for(var index=0;index<length-1;index++){var p1=points[index];var p2=points[index+1];var p3=points[index+2];var compareAtt=function(att){if(!p3){return false}if(p1[att]===p2[att]&&p2[att]===p3[att]){return true}return false};if(compareAtt("y")){var otherDiff=0;if(((sourcePosition.direction==="left")&&(targetPosition.direction==="left"))){var p4=points[index+3];if(p4){var differenceToPart=p4.y-p1.y}else{var differenceToPart=(targetPartPosition.y)-p1.y-(sourcePosition.h*1.5)}}else{if(((sourcePosition.direction==="left")&&(targetPosition.direction==="bottom"))){var differenceToPart=(targetPartPosition.y)-p1.y-(sourcePosition.h*1.5);if(targetPartPosition.x>sourcePartPosition.x&&sourcePartPosition.y<targetPartPosition.y){var otherDiff=(targetPartPosition.x)-p1.x-(sourcePosition.h*1.5)}}else{var differenceToPart=(sourcePartPosition.y+sourcePartPosition.h)-p2.y}}var upatedY=undefined;if(p2.x<p1.x&&p2.x<p3.x){upatedY=p2.y+differenceToPart;points.splice(index+2,0,{x:p2.x+otherDiff,y:upatedY})}else{if(p3.y<p1.y&&p3.y<p2.y){upatedY=p2.y-differenceToPart;points.splice(index+2,0,{x:p1.x,y:upatedY})}}if(upatedY){p3.y=upatedY}}else{if(compareAtt("x")){if((sourcePosition.direction==="bottom"&&targetPosition.direction==="top")){var differenceToPart=(targetPartPosition.x+targetPartPosition.w)-p1.x}else{if(((sourcePosition.direction==="right"||sourcePosition.direction==="bottom")&&(p2.direction==="top"||p2.direction==="bottom"))||(sourcePosition.direction==="top"&&(p3.direction==="bottom"||p3.direction==="top"))){if((targetPart===sourcePart&&(target.isPrivate||source.isPrivate))){var differenceToPart=(targetPosition.x)-p1.x-(sourcePosition.h)}else{var differenceToPart=(targetPartPosition.x)-p1.x-(sourcePosition.h*1.5)}if(sourcePosition.direction==="bottom"&&targetPosition.direction==="bottom"&&sourcePosition.y<targetPosition.y){var p0=points[index-1];if(p0){p0.y=p2.y;p1.y=p2.y}}}else{var differenceToPart=(targetPartPosition.x+targetPartPosition.w)-p1.x}}var upatedY=undefined;if(p2.y<p1.y&&p2.y<p3.y){if(points[index+1].direction===points[index+2].direction&&!points[index+3]&&!(targetPosition.direction==="top")){points.splice(index+1,1)}else{upatedY=p2.x+differenceToPart;points.splice(index+2,0,{x:p3.x,y:p2.y})}}else{if(p2.y>p1.y&&p2.y>p3.y){upatedY=p2.x+differenceToPart;points.splice(index+2,0,{x:p3.x,y:p2.y})}}if(upatedY){p1.x=upatedY;p2.x=upatedY}}}}};detectOverlappedPoints();var removeUnwantedReturns=function(){var lastSimilarPars=[];for(var index=1;index<points.length-5;index++){var p1=points[index];var p2=points[index+1];var p3=points[index+2];var p4=points[index+3];if(p1.x===p2.x&&p3.x===p4.x&&p4.x>p2.x){points[index+1].y=p4.y;points.splice(points.indexOf(p3),1);points.splice(points.indexOf(p4),1);index=1;continue}}};var shortenPath=function(){for(var index=1;index<points.length-3;index++){var point1=points[index];var point2=points[index+1];var point3=points[index+2];if(!((point3.direction==="left"||point3.direction==="top")&&point1.y<point3.y&&(point1.direction==="bottom"))||(point3.direction&&point3.direction===point1.direction)){continue}if(point1.y===point2.y&&point2.x===point3.x){point1.y=point3.y;if(points[index+3]){point3.x=points[index+3].x}points.splice(points.indexOf(point2),1);index=1;continue}}};shortenPath();removeUnwantedReturns();var findLongestLine=function(){var longest={points:[],delta:0};var length=points.length;for(var index=0;index<length-1;index++){var point1=points[index];var point2=points[index+1];var delta1=Math.abs(point2.x-point1.x);var delta2=Math.abs(point2.y-point1.y);var delta=delta1>delta2?delta1:delta2;if(longest.delta<delta){longest={points:[point1,point2],delta:delta}}}return longest.points};var getIntersection=function(line){var line=findLongestLine();var point1=line[0];var point2=line[1];var delta1=Math.abs(point2.x-point1.x);var delta2=Math.abs(point2.y-point1.y);if(delta1>delta2){return{direction:"horiontal",x:point1.x+(delta1/2),y:point1.y}}else{var p1;if(point1.y>point2.y){p1=point1}else{p1=point2}return{direction:"vertical",x:point2.x,y:p1.y-(delta2/2)}}};if(this.connectorType&&this.connectorType.length>0){var symnbolLocation=getIntersection(findLongestLine());var targetAsIs=ShapesRegistry.get("Port",this["targets"][0]);var sourceAsIs=ShapesRegistry.get("Port",this["sources"][0]);var receive;if(targetAsIs.getPosition().x>=sourceAsIs.getPosition().x){receive=false;if(symnbolLocation.direction==="vertical"){symnbolLocation.y=symnbolLocation.y-20}else{symnbolLocation.x=symnbolLocation.x-20}}else{receive=true;if(symnbolLocation.direction==="vertical"){symnbolLocation.y=symnbolLocation.y+20}else{symnbolLocation.yx=symnbolLocation.x+20}}var elem=ConnectorSymbols.draw(this,this.connectorType,symnbolLocation.direction,receive);elem.setAttribute("transform","translate("+symnbolLocation.x+","+symnbolLocation.y+")")}var sourceParent=source.focalNode.parentNode;var targetParent=target.focalNode.parentNode;var sourceParentParent=sourceParent.parentNode;var targetParentParent=targetParent.parentNode;sourceParentParent.removeChild(sourceParent);sourceParentParent.appendChild(sourceParent);targetParentParent.removeChild(targetParent);targetParentParent.appendChild(targetParent);this.focalNode.setAttribute("points",this.arrayToPoints(points));var connectorList=[];var all=source.connectors.sources.concat(source.connectors.targets).concat(target.connectors.sources).concat(target.connectors.sources);for(var index=0,current;current=all[index];index++){if(!connectorList[current.name]){connectorList[current.name]=current}}this.adjustOverlappedConnectors(connectorList)},adjustOverlappedConnectors:function(connectorList){var portConnectors=connectorList||ShapesRegistry.get("PortConnector");var shapePoints={};for(var name in portConnectors){var connector=portConnectors[name];if(!connector.getAttribute){continue}var connectorPoints=[];shapePoints[connector.name]={connector:connector,connectorPoints:connectorPoints};var points=connector.getAttribute("points").split(" ");for(var index=0,point;point=points[index];index++){var pair=point.split(",");connectorPoints.push({x:parseFloat(pair[0]),y:parseFloat(pair[1])})}}var connectorIndex=0;var visitedTargets={};var visitedConnectors=[];var indenMap=ObjectsUtil.newInstance("util.core.Map");for(var name in shapePoints){var object=shapePoints[name];var portConnector=object.connector;var connectorPoints=object.connectorPoints;for(var subName in shapePoints){connectorIndex++;var subObject=shapePoints[subName];var subPortConnector=subObject.connector;if(subPortConnector===portConnector){continue}var subConnectorPoints=subObject.connectorPoints;var target=subPortConnector.targets[0];if(visitedTargets[target]===undefined){visitedTargets[target]=0}else{if(visitedConnectors.indexOf(subPortConnector)===-1){visitedTargets[target]++}}visitedConnectors.push(subPortConnector);var increment=indenMap.get(subPortConnector);if(!increment){increment=((visitedTargets[target]%2)?2:-2)*(Math.round(visitedTargets[target]/2));indenMap.put(subPortConnector,increment)}var alteredPoints=[subConnectorPoints[0],subConnectorPoints[1]];var changed=false;for(var index=0;index<subConnectorPoints.length-1;index++){var current=subConnectorPoints[index];var next=subConnectorPoints[index+1];var pairX=[current.x,next.x];var pairY=[current.y,next.y];var changeHorizontal,changeVertical;for(var mainIndex=0;mainIndex<connectorPoints.length-1;mainIndex++){var mainCurrent=connectorPoints[mainIndex];var mainNext=connectorPoints[mainIndex+1];var adjustNewValue=function(getter,ignoreGetter){var direction=1;var increase=3;var lastMax=3;var newValue=subConnectorPoints[index][getter]+(increase*direction);var found=false;while(!found){search:{for(var searchName in shapePoints){var searchObject=shapePoints[searchName];var searchObjectPoints=searchObject.connectorPoints;for(var searchIndex=0,searchPoint;searchPoint=searchObjectPoints[searchIndex];searchIndex++){if(searchPoint[getter]===newValue&&(Math.abs(searchPoint[ignoreGetter]-subConnectorPoints[index][ignoreGetter])<25||Math.abs(searchPoint[ignoreGetter]-subConnectorPoints[index+1][ignoreGetter])<25)){if(direction<1){if(increase<0.1){increase=lastMax+1;lastMax++}else{increase=increase/2}}direction=direction*-1;newValue=subConnectorPoints[index][getter]+(increase*direction);break search}}}found=true;break}}return newValue};var changeHorizontal=mainCurrent.x===current.x&&mainNext.x===next.x&&mainCurrent.x===next.x&&(mainNext.y===next.y||Math.abs(current.y-mainCurrent.y)<=3);var changeVertical=mainCurrent.y===current.y&&mainNext.y===next.y&&mainCurrent.y===next.y&&(mainNext.x===next.x||Math.abs(current.x-mainCurrent.x)<=3);if(changeHorizontal){var newValue=adjustNewValue("x","y");subObject.alteredx=true;subConnectorPoints[index].x=newValue;subConnectorPoints[index+1].x=newValue;subPortConnector.movedHorizontally=true;changed=true}else{if(changeVertical){var newValue=adjustNewValue("y","x");subObject.alteredy=true;subConnectorPoints[index].y=newValue;subConnectorPoints[index+1].y=newValue;subPortConnector.movedVertically=true;changed=true}}}}for(var index=0;index<subConnectorPoints.length-2;index++){var p1=subConnectorPoints[index];var p2=subConnectorPoints[index+1];var p3=subConnectorPoints[index+2];if(p2.y<p1.y&&p2.y<p3.y&&p1.x===p2.x&&p2.x===p3.x){subConnectorPoints.splice(index+1,1);index=0}else{if(p2.x<p1.x&&p2.x<p3.x&&p1.y===p2.y&&p2.y===p3.y){subConnectorPoints.splice(index+1,1);index=0}}}for(var index=0;index<subConnectorPoints.length-1;index++){var p1=subConnectorPoints[index];var p2=subConnectorPoints[index+1];var p3=subConnectorPoints[index+2];if(p2.x!=p1.x&&Math.abs(p2.x-p1.x)<7){p2.x=p1.x;index=-1;changed=true}else{if(p2.y-p1.y&&Math.abs(p2.y-p1.y)<7){p2.y=p1.y;index=0;changed=true}else{if(index>4){break}}}}if(changed){var alteredPoints="";for(var pointIndex=0,currentPoint;currentPoint=subConnectorPoints[pointIndex];pointIndex++){var prev1=subConnectorPoints[pointIndex-1];var prev2=subConnectorPoints[pointIndex-2];if(alteredPoints){alteredPoints=alteredPoints+" "}var newPoint=currentPoint;if(prev1&&prev2){if(currentPoint.x!==prev1.x&&currentPoint.y!==prev1.y){if(prev2.x==prev1.x){newPoint.x=prev2.x}else{if(prev2.y==prev1.y){newPoint.y=prev2.y}}}}alteredPoints=alteredPoints+newPoint.x+","+newPoint.y}subPortConnector.setAttribute("points",alteredPoints)}}}},arrayToPoints:function(points){var pointString="";for(var index=0,current;current=points[index];index++){if(pointString){pointString=pointString+" "}pointString=pointString+current.x+","+current.y}return pointString},getPosition:function(){return{x:parseFloat(this.focalNode.getAttribute("x")),y:parseFloat(this.focalNode.getAttribute("y")),w:13,h:13}}})})();
var StateTree = {}

//////////////////////////////////////////////////////////////
//                      STATENODE CLASS                     //
//////////////////////////////////////////////////////////////
function StateNode(parent, id) 
{
  this.parent = parent;
  this.id = id;
  this.activeColour = null;
  this.passiveColor = null;
};

StateNode.prototype.getParent = function() 
{
  return this.parent;
};

StateNode.prototype.getRoot = function() 
{
  var currentNode = this;
  var prevNode = null;
  while(currentNode !== null) 
  {
    prevNode = currentNode;
    currentNode = currentNode.getParent();
  }

  return prevNode;
};

StateNode.prototype.getId = function() 
{
  return this.id;
};

StateNode.prototype.getDepth = function() 
{
  var currentNode = this;
  var depth = 0;
  while(currentNode !== null) 
  {
    currentNode = currentNode.getParent();
    depth++;
  }

  return depth;
};

//////////////////////////////////////////////////////////////
//                    STATECOLOURER CLASS                   //
//////////////////////////////////////////////////////////////
function StateColourer(numShades, numStateFamilies) 
{
  this.numShades = numShades;
  this.numColours = numStateFamilies;
  this.cachedColours = this.baseColours.slice();
};

StateColourer.prototype.passiveColour = "999999"; //Gray

StateColourer.prototype.baseColours = 
[
  "CC99A2", //Pink 
  "9AAFAF", //Light blue
  "FFFF7F", //Light yellow
  "98FB98", //Light green
  "9DD6D6", //Light turquoise
  "D2AB6F", //Light brown
  "B19CD9" //Light purple
];

StateColourer.prototype.getBasePassiveColour = function()
{
  var returnedColour = this.passiveColour;

  for(var i = 0; i < (5 - this.numShades) && i < 3; i++)
  {
    returnedColour = this.lighten(returnedColour);
  }

  return returnedColour;
}

StateColourer.prototype.getBaseColour = function(colourId)
{
  var returnedColour;

  if(colourId < this.cachedColours.length)
  {
    returnedColour = this.cachedColours[colourId];
  }
  else
  {
    colourId = colourId%this.cachedColours.length;
    returnedColour = this.modifyColour(this.cachedColours[colourId]);
    this.cachedColours[colourId] = returnedColour;
  }

  for(var i = 0; i < (5 - this.numShades) && i < 3; i++)
  {
    returnedColour = this.lighten(returnedColour);
  }

  return returnedColour;
};

StateColourer.prototype.getLightenAmount = function()
{
  return 15;
}

StateColourer.prototype.getModifyAmount = function()
{
  return 20;
}

StateColourer.prototype.modifyColour = function(colour)
{
  var colour = this.createColour(colour);
  var max, min;
  if(colour.red > colour.blue) 
  {
    if(colour.red > colour.green) 
    {
      colour.red -= this.getModifyAmount();
      if(colour.blue > colour.green) colour.green += this.getModifyAmount();
      else colour.blue += this.getModifyAmount();
    }
    else
    {
      colour.green -= this.getModifyAmount();
      colour.blue += this.getModifyAmount();
    }
  }
  else
  {
    if(colour.blue > colour.green)
    {
      colour.blue -= this.getModifyAmount();
      if(colour.red > colour.green) colour.green += this.getModifyAmount();
      else colour.red += this.getModifyAmount();
    }
    else
    {
      colour.blue -= this.getModifyAmount();
      colour.red += this.getModifyAmount();
    }
  }

  return colour.toHex();
};

StateColourer.prototype.lighten = function(colour) 
{
  var colour = this.createColour(colour);
  var amount = this.getLightenAmount();
  colour.modifyRed(amount);
  colour.modifyBlue(amount);
  colour.modifyGreen(amount);
  return colour.toHex();
};

StateColourer.prototype.createColour = function(colour) 
{
  var num = parseInt(colour, 16);
  var r = (num >> 16);
  var b = ((num >> 8) & 0x00FF);
  var g = (num & 0x0000FF);

  return new Colour(r, b, g);
};

//////////////////////////////////////////////////////////////
//                      COLOUR OBJECT                       //
//////////////////////////////////////////////////////////////
function Colour(red, blue, green)
{
  this.red = red;
  this.blue = blue;
  this.green = green;
};

Colour.prototype.modifyRed = function(value)
{
  this.red += value;
  if(this.red > 255) this.red = 255;
  else if(this.red < 0) this.red = 0;
}

Colour.prototype.modifyBlue = function(value)
{
  this.blue += value;
  if(this.blue > 255) this.blue = 255;
  else if(this.blue < 0) this.blue = 0;
}

Colour.prototype.modifyGreen = function(value)
{
  this.green += value;
  if(this.green > 255) this.green = 255;
  else if(this.green < 0) this.green = 0;
}

Colour.prototype.modifyByName = function(colourName, value)
{
  if(colourName !== "red" && colourName !== "blue" && colourName !== "green")
    throw "Not a valid colour name";
}

Colour.prototype.toHex = function()
{
  var newColour = this.green | (this.blue << 8) | (this.red << 16); 
  return newColour.toString(16);
};

//////////////////////////////////////////////////////////////
//                   STATETABLE FUNCTIONS                   //
//////////////////////////////////////////////////////////////
function StateTable(table, stateTree)
{
  this.table = table;
  this.stateTree = stateTree;
};

StateTable.prototype.readTable = function() 
{
  var rows = this.table.find("tr");

  //process first entry in each row (except the first) to get the state tree
  var id = 0;

  for(var i = 1; i < rows.length; i++) 
  {
    var entry = jQuery(rows[i]).find("td")[0];
    this.stateTree.stateNodes.push(
      this.stateTree.createState(jQuery(entry), id++));
  }
};

StateTable.prototype.colour = function() 
{
  //Colour the states
  var rows = this.table.find("tr");
  var rowEntries, rowState, cell;

  //Colour the header
  if(this.stateTree.type === "state") 
  {
    rowEntries = jQuery(rows[0]).find("td");
    for(var i = 1; i < rowEntries.length; i++) 
    {
      jQuery(rowEntries[i]).css("background-color", "#" +
        this.stateTree.stateNodes[i - 1].activeColour);
    }
  }

  //Colour the rest of the table
  for(var i = 1; i < rows.length; i++) 
  {
    rowState = this.stateTree.stateNodes[i - 1];
    rowEntries = jQuery(rows[i]).find("td");

    cell = jQuery(rowEntries[0]);
    cell.css("background-color", "#" + rowState.activeColour);

    for(var j = 1; j < rowEntries.length; j++) 
    {
      cell = jQuery(rowEntries[j]);
      if(cell.text().match(/^\s$/)) {
        cell.css("background-color", "#" + rowState.passiveColour);
      }
      else
        cell.css("background-color", "#" + rowState.activeColour);
    }
  }
};

//////////////////////////////////////////////////////////////
//                 EVENTSEQUENCE FUNCTIONS                  //
//////////////////////////////////////////////////////////////

function EventSequence(headerTable, bodyTable, stateTree)
{
  this.headerTable = headerTable;
  this.bodyTable = bodyTable;
  this.stateTree = stateTree;
};

EventSequence.prototype.readTable = function()
{
  var entries = jQuery(this.headerTable).find("td");

  //process each entry, except the first to get the state tree
  var id = 0;

  for(var i = 1; i < entries.length; i++) 
  {
    this.stateTree.stateNodes.push(
      this.stateTree.createState(jQuery(entries[i]), id++));
  }
};

EventSequence.prototype.colour = function()
{
  var rows, rowEntries, rowState, cell;

  //Colour the floating column
  rows = jQuery(this.headerTable).find("td");

  for(var i = 1; i < rows.length; i++)
  {
    rowState = this.stateTree.stateNodes[i - 1];
    jQuery(rows[i]).css("background-color", "#" + rowState.activeColour);
  }

  //Colour the main table
  rows = jQuery(this.bodyTable).find("tr");

  // Colour all rows, except the top row
  for(var i = 1; i < rows.length; i++)
  {
    rowState = this.stateTree.stateNodes[i - 1];
    rowEntries = jQuery(rows[i]).find("td");

    for(var j = 0; j < rowEntries.length; j++)
    {
      cell = jQuery(rowEntries[j]);

      if(cell.text().match(/^\s$/)) 
        cell.css("background-color", "#" + rowState.passiveColour);
      else
        cell.css("background-color", "#" + rowState.activeColour);
    }
  }
};

//////////////////////////////////////////////////////////////
//                   STATETREE  FUNCTIONS                   //
//////////////////////////////////////////////////////////////
StateTree.init = function(table, type)
{
  StateTree.stateNodes = [];

  if(table.hasClass("event-statetable")) 
  {
    StateTree.type = "event";
    StateTree.handler = new StateTable(table, this);
  } 
  else if(table.hasClass("state-statetable")) 
  {
    StateTree.type = "state";
    StateTree.handler = new StateTable(table, this);
  } 
  else if(table.hasClass("event-sequence-grid"))
  {
    StateTree.type = "eventSequence";
    StateTree.handler = new EventSequence(table.find("table")[0], 
                                          table.find("table")[1], 
                                          this);
  }
  else 
  {
    console.log("Unknown state table type");
    StateTree.type = "unknown";
  }
};

StateTree.createState = function(stateRow, id)
{
  var parentId = parseInt(stateRow.attr("data-parent"));
  var parent = StateTree.stateNodes[parentId];

  if(isNaN(parentId)) 
  {
    parent = null;
  } 

  return new StateNode(parent, id);
};

StateTree.maxDepth = function() 
{
  var max = 0;
  var stateDepth;
  for(var i = 0; i < StateTree.stateNodes.length; i++) 
  {
    stateDepth = StateTree.stateNodes[i].getDepth();

    if(stateDepth > max) max = stateDepth;
  }

  return max;
};

StateTree.numStateFamilies = function() 
{
  numStateFamilies = 0;
  for(var i = 0; i < StateTree.stateNodes.length; i++) 
  {
    if(StateTree.stateNodes[i].getParent() === null)
      numStateFamilies++;
  }

  return numStateFamilies;
};

StateTree.readTable = function()
{
  StateTree.handler.readTable();
};

StateTree.assignStateColours = function()
{
  var colourer = new StateColourer(StateTree.maxDepth(), 
    StateTree.numStateFamilies());

  //Assign each state their passive and active colours
  var colourId = 0;
  var stateNode;

  for(var i = 0; i < StateTree.stateNodes.length; i++) 
  {
    stateNode = StateTree.stateNodes[i];
    //Non-child state
    if(stateNode.getParent() === null)
    {
      stateNode.passiveColour = colourer.getBasePassiveColour();
      stateNode.activeColour = colourer.getBaseColour(colourId++);
    } 
    else //Child state 
    {
      stateNode.passiveColour = colourer.lighten(
        stateNode.getParent().passiveColour);
      stateNode.activeColour = colourer.lighten(
        stateNode.getParent().activeColour);
    }
  }
}

StateTree.colour = function()
{
  StateTree.assignStateColours();
  StateTree.handler.colour();
}

// Entry function for colouring the State Tables
StateTree.colourStateTables = function() 
{
  jQuery(document).ready(function () 
  {
    jQuery(".statetable").each(function() {
      StateTree.init(jQuery(this));
      StateTree.readTable();
      StateTree.colour();
    });
  });
}; 

// Entry function for colouring the Event Sequences
StateTree.colourEventSequences = function()
{
  jQuery(document).ready(function() 
  {
    jQuery(".event-sequence-grid").each(function() {
      StateTree.init(jQuery(this));
      StateTree.readTable();
      StateTree.colour();
    });
  });
};
