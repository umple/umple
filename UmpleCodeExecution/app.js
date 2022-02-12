const express = require('express');
const http = require('http');
const fs = require('fs');
const DockerExecution = require('./dockerExecution');
const bodyParser = require('body-parser');
const os = require('os-utils');
const path = require('path');

const app = express();
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

const server = http.createServer(app);
const port=4400;
const basePath= __dirname+"/models/"; //current working path

// Declar max usage limit and max requests
const CPU_USAGE_LIMIT = 80;
const MAX_REQUESTS = 3;
const mainFileName = "JavaMainClasses.txt";
let numberOfRequests = 0;

app.all('*', function(req, res, next) 
{
    res.header('Access-Control-Allow-Origin', '*'); // TODO CHANGE ORIGIN
    res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
});

app.post('/run' ,function(req, res) 
{
    canProceed((err) => {
        if(err) {
            return res.send(err); 
        } else {
            numberOfRequests++;

            // Extract out path and validate
            const path = basePath + req.body.path;
            const error = validatePath(path) || validateMainFile(path);
            if(error) {
                return res.send(error);
            }
            console.log("Given path:",req.body.path);
            console.log("Base path: ", path);

            // Read main file content
            const mainFunctions = readMainFile(path);
            if(mainFunctions.length == 0 || mainFunctions[0] === '') {
                return res.send({error: "Main function name is not provided."});
            }

            console.log("Finding file: " + (mainFunctions[0] + '.class'));
            const foundFilePath = findFile(path, "/" + req.body.path ,mainFunctions[0] + '.class');
            console.log("Found file at: ", foundFilePath);
        
            // Execute docker 
            const dockerExecution = new DockerExecution(foundFilePath, mainFunctions[0], req.body.path);
            try {
                dockerExecution.run((err, data) =>
                {
                    numberOfRequests--;
                    res.send({errors: err, output: data});
                });
            } catch(err) {
                console.log(err);
                return res.send({errors: "Error processing your request."});
            }
        }
    });   
});

const readMainFile = (path) => {
    const buffer = fs.readFileSync(path + "/" + mainFileName, 'utf8');
    const fileContent = buffer.toString().replace(/\r/g,'').replace(/\n/g,'');
    return fileContent.split(" ");
}

const findFile = function(dirPath, curPath, file) {
    files = fs.readdirSync(dirPath);

    for(let i = 0; i < files.length; i++) {
        if (fs.statSync(dirPath + "/" + files[i]).isDirectory()) {
            const cur =  getAllFiles(dirPath + "/" + files[i], curPath + "/" + files[i], file)
            if(cur != null) {
                return cur;
            }
        } else if(files[i] == file) {
            return path.join(curPath, "/");
        }
    }
  
    return null;
}

const validateMainFile = (path) => {
    if(fs.existsSync(path + "/" + mainFileName)) {
        return null;
    } else {
        return {errors:"Main file does not exist."};
    }
}

const validatePath = (path) => {
    if(!path) {
        return {errors:"Path is required."};
    } else if(!fs.existsSync(path)) {
        return {errors:'Path does not exist.'};
    }

    try {
        fs.accessSync(path, fs.constants.R_OK)
    } catch {
        return {errors: 'Access denied.'};
    }

    return null;
}

const canProceed = (callback) => {
    // Check max number of requests allowed
    if(numberOfRequests >= MAX_REQUESTS) {
        callback({errors:"Server is busy, please try in some time for code execution."})
    }

    // Check for CPU usage
    try {
        os.cpuUsage(function(usage){
            if(usage >= CPU_USAGE_LIMIT) {
                callback({errors:"Server is busy, please try in some time for code execution."})
            } else {
                callback(null);
            }
        });
    } catch (exp) {
        console.log("error calculating cpu usage.");
        callback(null);
    }
}


server.listen(port, () => {
    console.log("Listening at "+port)
});



