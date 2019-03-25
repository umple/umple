/// <reference types="node" />
import { FileObject } from '../lib/helper';
/**
 * Takes the beginning of an audio file and returns the associated content-type / mime type
 *
 * @param {Buffer} buffer with at least the first 4 bytes of the file
 * @return {String|undefined} - the contentType of undefined
 */
export declare function fromHeader(buffer: Buffer): string;
/**
 * Guess the content type from the filename
 *
 * Note: Blob and File objects include a .type property, but we're ignoring it because it's frequently either
 * incorrect (e.g. video/ogg instead of audio/ogg) or else a different format than what's expected (e.g. audio/x-wav)
 *
 * @param {String|ReadableStream|FileObject|Buffer|File} file - string filename or url, or binary File/Blob object
 * @return {String|undefined}
 */
export declare function fromFilename(file: String | ReadableStream | FileObject | Buffer | File): string;
