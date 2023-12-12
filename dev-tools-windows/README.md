Welcome To Umple Development Using Windows!

This directory contains files that you can run built-in umple commands to speed up your Umple Development.

First-Time Setup:
- With Windows Search Bar, search for "Edit the system environment variables"
  - <img src=https://github.com/umple/umple/assets/30543699/79dd6983-3870-4dc8-9928-71b622cff29a height="400" width="300">
  - Click on Environment Variables
  - <img src=https://github.com/umple/umple/assets/30543699/d998fc55-a26c-431e-bd7e-d2440ef65799 height="400" width="300">
- Under System Variables, edit the variable with name "Path" and add the current Path.
  - Locate the Current Path Value by copying the path of this README.file
  - An Example Current Path would be C:/../../umple/dev-tools-windows

Java must be installed to run all of these. Some require graphviz, php, ruby, txl and other dependencies as well

For developers:

 bumple
  - does a full build of Umple (make sure you have done git pull first
  - you should run this before creating any pull request 
  - Takes 2-5 minutes. Emulates what the server does and cleanly deals with UmpleVersion

 fbumple
   - does a first build of Umple, needed after freshly cloning from git
   
 qbumple
  - Does a quick build (compiles .ump source, then generated code, then builds jars)
  - Used when you have edited compiler code in .ump, .error etc. and want to
  - determine if it compiles using the command line compiler and run manual tests
  - follow with tumple or bumple before creating a pull request

 qfbumple
  - Same as the above, but also builds umple jars other than the main umple.jar;
  - needed when testing umplesync.jar for example

 tumple
  - Runs a the unit tests only
  - Does not rebuild the compiler nor run the testbed tests
  - Used when you want to do basic test after doing qbumple

 pumple
  - Propagates the umple jars to umpleonline.
  - Ensures changed javascript is minified correctly
  - Builds other aspects needed to run umpleonline such as the Docker images used for execution
  - Must be run after any changes to a local version of UmpleOnline
  - not done as part of a full build so must be done separately

 mumple
  - Rebuilds the user manual from sources in build/reference
  - Must be run to validate that edits to the user manual are valid before pushing changes
  - Done as part of a full build. But if you are only pushing manual changes, you can skip the full build using this.

uminify
  - Minify Umple Scripts
