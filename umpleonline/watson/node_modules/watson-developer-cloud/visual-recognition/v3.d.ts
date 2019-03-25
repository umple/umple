/// <reference types="node" />
import GeneratedVisualRecognitionV3 = require('./v3-generated');
declare class VisualRecognitionV3 extends GeneratedVisualRecognitionV3 {
    static VERSION_DATE_2016_05_20: string;
    private static betaError;
    constructor(options: any);
    classify(params: any, callback: any): void | NodeJS.ReadableStream;
    detectFaces(params: any, callback: any): void | NodeJS.ReadableStream;
    retrainClassifier(params: any, callback: any): void | NodeJS.ReadableStream;
    recognizeText(params: any, callback: any): void;
    createCollection(params: any, callback: any): void;
    getCollection(params: any, callback: any): void;
    listCollections(params: any, callback: any): void;
    deleteCollection(params: any, callback: any): void;
    addImage(params: any, callback: any): void;
    listImages(params: any, callback: any): void;
    getImage(params: any, callback: any): void;
    deleteImage(params: any, callback: any): void;
    setImageData(params: any, callback: any): void;
    getImageData(params: any, callback: any): void;
    deleteImageData(params: any, callback: any): void;
    findSimilar(params: any, callback: any): void;
}
export = VisualRecognitionV3;
