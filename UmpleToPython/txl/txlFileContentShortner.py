# How to use :
#   - Copy the TXL files in the same directory as this file
#   - Run the file (the file will generate multiple one-line strings)
#   - Copy the strings in cruise.umple/src/generators/Generator_CodePython.ump (generateTxlFiles function -> Replace the String[][] filesData Array)

import os

def isValidTXL(fileName) :
    return fileName.split(".")[1] == "txl" or fileName.split(".")[1] == "Grm"

def shorten(content) :
    return content.replace('\\', '\\\\').replace('\n', '\\n').replace('\t', '\\t').replace('\"', '\\"')

output = "String[][] filesData = {"

for fileName in os.listdir() :
    if (isValidTXL(fileName)) :
        file = open(fileName, "r")
        output = output + "{ \"txl/" + fileName + "\", \"" + shorten(file.read()) + "\"}, \n"

output = output + "};"
print(output)
