const express = require('express');
const http = require('http');
const fs = require('fs');
const DockerExecution = require('./dockerExecution');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

const server = http.createServer(app);
const port=4400;
const basePath= __dirname+"/models/"; //current working path

// Declare max requests
const MAX_REQUESTS = 20;
const mainFileName = "JavaMainClasses.txt";
let numberOfRequests = 0;

app.all('*', (req, res, next) =>
{
    res.header('Access-Control-Allow-Origin', '*'); // TODO CHANGE ORIGIN
    res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
});

app.post('/run' , (req, res)  => 
{
    canProceed((err) => {
        if(err) {
            return res.send(err); 
        } else {
            numberOfRequests++;

            // Extract out path and validate
            const path = basePath + req.body.path;
            const compileError = req.body.error;
            console.log("Compilation error or warning: " + compileError);

            const pathError = validatePath(path);
            if(pathError) {
                numberOfRequests--;
                return res.send(pathError);
            }

            // Check for main file error
            const mainFileError = validateMainFile(path);

            // If there were error previously and now
            // It means, there was compilation error
            if(mainFileError && compileError) {
                numberOfRequests--;
                return res.send({errors:"", output:""});
            } else if(mainFileError) { 
                numberOfRequests--;
                return res.send(mainFileError);
            }

            console.log("Given path:",req.body.path);
            console.log("Base path: ", path);

            // Read main file content
            const mainFunctions = readMainFile(path);
            if(mainFunctions.length == 0 || mainFunctions[0] === '') {
                numberOfRequests--;
                return res.send({errors: "Main function name is not provided.", output:""});
            }

            let output = "";
            let totalServed = 0;
            mainFunctions.forEach((mainFunction) => {
                console.log("Finding file: " + (mainFunction + '.class'));
                const foundFilePath = findFile(path, "/",mainFunction + '.class');
                console.log("Found file at: ", foundFilePath);
            
                // Execute docker 
                const dockerExecution = new DockerExecution(foundFilePath, mainFunction, req.body.path);
                try {
                    dockerExecution.run((err, data) =>
                    {
                        output += `<strong>For main method in class ${mainFunction}:</strong>\n`
                        output += `${err || ""}\n`;
                        output += `${data}\n`
                        totalServed++;
                        console.log("Processed request ", totalServed);
                        if(totalServed >= mainFunctions.length) {
                            numberOfRequests--;
                            return res.send({errors: "", output:output});
                        }
                    });
                } catch(err) {
                    console.log(err);
                    output += `<strong>For main method in class ${mainFunction}:</strong>\n`
                    output += "Error processing your request\n"
                    totalServed++;
                    if(totalServed >= mainFunctions.length) {
                        numberOfRequests--;
                        return res.send({errors: "", output:output});
                    }
                }
            });
        }
    });   
});

const readMainFile = (path) => {
    const buffer = fs.readFileSync(path + "/" + mainFileName, 'utf8');
    const fileContent = buffer.toString().replace(/\r/g,'').replace(/\n/g,'');
    return fileContent.split(" ");
}

const findFile = (dirPath, curPath, file)  => {
    const files = fs.readdirSync(dirPath);

    for(let i = 0; i < files.length; i++) {
        if (fs.statSync(dirPath + "/" + files[i]).isDirectory()) {
            const cur =  findFile(dirPath + "/" + files[i], curPath + "/" + files[i], file)
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
        return {errors:"Cannot execute model because no Umple class was found with a public static void main() function.", output: ""};
    }
}

const validatePath = (path) => {
    if(!path) {
        return {errors:"Path is required.", output:""};
    } else if(!fs.existsSync(path)) {
        return {errors:'Path does not exist.', output:""};
    }

    try {
        fs.accessSync(path, fs.constants.R_OK)
    } catch {
        return {errors: 'Access denied.', output:""};
    }

    return null;
}

const canProceed = (callback) => {
    // Check max number of requests allowed
    if(numberOfRequests >= MAX_REQUESTS) {
        callback({errors:"Server is busy, please try in some time for code execution.", output:""})
    } else {
        callback(null);
    }
}


server.listen(port, () => {
    console.log("Listening at "+port)
});



