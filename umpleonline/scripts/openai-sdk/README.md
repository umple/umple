# OpenAI SDK Browser Bundle

This directory contains the bundled OpenAI SDK for browser usage in UmpleOnline.

## Building the Bundle

The OpenAI SDK is bundled using Rollup to create a browser-compatible IIFE bundle.

### Prerequisites
- Node.js and npm installed

### Build Command

```bash
cd /path/to/umpleonline/scripts/openai-sdk
npm start
```

This will:
1. Install dependencies (openai SDK + rollup plugins)
2. Bundle the SDK into `openai.bundle.js`
3. Expose `OpenAI` as a global variable

### Build Configuration

The `rollup.config.mjs` handles:
- **TypeScript helpers**: Sets `context: 'window'` to properly handle TypeScript-generated `this` references
- **Circular dependencies**: Suppresses circular dependency warnings (inherent to OpenAI SDK structure)
- **Mixed ES modules**: Uses `transformMixedEsModules: true` for proper CommonJS/ESM interop

### When to Rebuild

You need to rebuild the bundle when:
- Upgrading to a new version of the OpenAI SDK
- After modifying `index.mjs` (entry point)
- After changing `rollup.config.mjs`

### How It's Used

The bundle is loaded in `scripts/_load.js`:
```javascript
document.write('<script type="text/javascript" src="scripts/openai-sdk/openai.bundle.js"></script>');
```

And used throughout the AI modules:
```javascript
const client = new OpenAI({
  apiKey: "your-api-key",
  baseURL: "https://api.openai.com/v1",
  dangerouslyAllowBrowser: true
});
```

### Bundle Size
~291KB minified (includes full OpenAI SDK)

### Notes
- The `openai.bundle.js` file is committed to the repository (like `editor.bundle.js` and `allumple-min.js`)
- Users don't need to rebuild unless modifying the bundle configuration
- The bundle works with OpenAI, OpenRouter, and Google Gemini (via OpenAI-compatible endpoints)
