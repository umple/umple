# How to use :
#   - Copy the TXL files in the same directory as this file
#   - Run the file (the file will generate multiple one-line strings)
#   - Copy the strings in cruise.umple/src/generators/Generator_CodePython.ump (generateTxlFiles function -> strings with Content)

def shorten(content) :
    return content.replace('\\', '\\\\').replace('\n', '\\n').replace('\t', '\\t').replace('\"', '\\"')

javaGrmFile = open("Java.Grm", "r")
pythonGrmFile = open("Python.Grm", "r")
umpleJavaToPython = open("umpleJavaToPython.txl", "r")

print("String javaGrmContent = \"" + shorten(javaGrmFile.read()) + "\";")
print("String pythonGrmContent = \"" + shorten(pythonGrmFile.read()) + "\";")
print("String umpleJavaToPythonTxlContent = \"" + shorten(umpleJavaToPython.read()) + "\";")
