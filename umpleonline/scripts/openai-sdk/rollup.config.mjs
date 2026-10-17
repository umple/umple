import commonjs from '@rollup/plugin-commonjs';
import resolve from '@rollup/plugin-node-resolve';
import json from '@rollup/plugin-json';

export default {
  input: "./index.mjs",
  output: {
    file: "./openai.bundle.js",
    format: "iife",
    name: "OpenAI",
    exports: "default"
  },
  context: 'window',
  onwarn(warning, warn) {
    // Suppress circular dependency warnings from OpenAI SDK
    if (warning.code === 'CIRCULAR_DEPENDENCY') return;
    // Use default for everything else
    warn(warning);
  },
  plugins: [
    resolve({
      browser: true,
      preferBuiltins: false,
      extensions: ['.mjs', '.js', '.json']
    }),
    commonjs({
      // Handle TypeScript-generated this references
      transformMixedEsModules: true
    }),
    json()
  ]
};
