import commonjs from '@rollup/plugin-commonjs';
import resolve from '@rollup/plugin-node-resolve';
import typescript from 'rollup-plugin-typescript2';

export default {
  input: [
    "./editor.mjs",
    // "./collab.ts"
    ],
  output: {
    file: "./editor.bundle.js",
    format: "iife",
    name: "cm6",
    // inlineDynamicImports: false
  },
  plugins: [
    resolve({
      extensions: ['.mjs', 
      // '.ts'
    ]
    }),
    commonjs(), 
    typescript()
  ]
}