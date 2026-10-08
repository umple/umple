const fs = require('fs');
const exec = require('child_process').exec;
const crypto = require('crypto');

class DockerExecution {
    constructor(path, mainFile, model, language="Java") {
        this.path = path;
        this.mainFile = mainFile;
        this.model = model;
        this.outputFolder = "output/" + this.model + "_" + this.mainFile;
        this.language=language;

        const config = this.readConfig();
        this.basePath = config['umplePath'];
        this.baseOutputPath = config['tempPath'];
        this.tempContainerName = config['tempContainerName'];
        this.timeoutValue = +config['timeoutValue'];
        this.provisioningTimeoutValue = +config['provisioningTimeoutValue'] || 25;
    }

    run(callback) {      
        // Make output folder where the output files will be written
        this.makeOutputFolder();
        const mainFilePath = this.getNormalizedMainFilename();
        console.log("Normalized main file: ", mainFilePath);
        const outputName = this.outputFolder.substring('output/'.length);
        const containerName = "umple-exec-" + crypto.randomBytes(16).toString('hex');
        let command;
        //if BASE_DIR environment variable exist, it means the docker was launced on Windows
        if(process.env['BASE_DIR']){
            command = `sh dockerTimeout.sh ${this.timeoutValue}s ${this.provisioningTimeoutValue}s ${containerName} -i -t --network none -v $BASE_DIR/umpleonline/ump/${this.model}:/input/:ro -v $BASE_DIR/umpleCodeExecution/tmp/${outputName}:/output/ ${this.tempContainerName} ${mainFilePath}`
        }else{
            command = `sh dockerTimeout.sh ${this.timeoutValue}s ${this.provisioningTimeoutValue}s ${containerName} -i -t --network none -v ${this.basePath}/${this.model}:/input/:ro -v ${this.baseOutputPath}/${outputName}:/output/ ${this.tempContainerName} ${mainFilePath}`
        }
        
        console.log("Docker command:'",command,"'"); 
        exec(command, (err, stdout, stderr) => {
            this.readOutput(err, stderr, (errorData, completeData) => {
                // If removal failed the runner may still be writing, so keep its output.
                if(stdout.trim() === "removed") this.deleteOutputFolder();
                callback(errorData, completeData);
            });
        });
    }

    getNormalizedMainFilename() {
        let path = this.path;
        if(path.startsWith('/')) {
            path = path.substring(1);
        }
        if(path.endsWith('/')) {
            path = path.substring(0, path.length - 1);
        }
        const pathArr=path.split('/');

        if(this.language=="Python"){
            return path ? `${path}/${this.mainFile}.py` : `${this.mainFile}.py`;
        }
        return path ? `${path.split('/').join('.')}.${this.mainFile}` : this.mainFile;    
    }

    readOutput(executionError, stderr, callback) {
        fs.readFile(this.outputFolder + '/completed', 'utf8', (err, completeData) => {
            fs.readFile(this.outputFolder + '/errors', 'utf8', (err, errorData) => {
                // A completed result wins even if docker wait reached its deadline.
                if(completeData !== undefined) {
                    callback(errorData, completeData);
                    return;
                }
                fs.readFile(this.outputFolder + '/logfile.txt', 'utf8', (err, partialData) => {
                    if (!partialData) partialData = "";
                    if(executionError && executionError.code === 124) {
                        partialData += "\nExecution Timed Out. Maximum allowed time is " + this.timeoutValue + " seconds.";
                    } else {
                        errorData = (errorData || "") + "\nInternal problem executing generated code. " +
                            (stderr.trim() || "Runner exited without completing output.");
                    }
                    callback(errorData, partialData);
                });
            });
        });
    }

    makeOutputFolder() {
        // Concurrent executions of the same main must not share their output.
        this.outputFolder = fs.mkdtempSync(this.outputFolder + "_");
    }

    deleteOutputFolder() {
        try {
            console.log("ATTEMPTING TO REMOVE: " + this.outputFolder);
            fs.rmSync(this.outputFolder, { recursive: true });
            console.log(`${this.outputFolder} is deleted!`);
        } catch (err) {
            console.error(`Error while deleting ${this.outputFolder}.`);
        }
    }

    readConfig() {
        const file = fs.readFileSync('./config.cfg', 'utf8');
        const config = file.toString().replace(/\r\n/g,'\n').split('\n');
        
        const obj = {};
        for(let c of config) {
            const cur = c.split('=');
            obj[cur[0]] = cur[1];
        }
        console.log("Given Config:");
        console.log(obj);
        return obj;
    }

}

module.exports = DockerExecution;
