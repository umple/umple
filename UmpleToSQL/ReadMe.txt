This project contains the JET for generating java code using the cruise.umple 
tool. The only package within the /src directory which sould compile is the 
cruise.umple.compiler.java which contains the working top level generating files.
the rest of the folders are simply there because JET requires that each template
be given a name and a package to put it into. Therefore, in essence, some of the
files in cruise.umple.compiler.java contain all the files in the other folders.

Contents of the cruise.umple.compiler.java folder need to be copied over the old 
contents in the same package name of cruise.umple. This is not done automatically.

Notice: In case this is not done automatically by your Eclipse version on your 
system, include the project cruise.umple in UmpleJetProject's build path. 