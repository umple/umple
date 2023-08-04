This directory contains files that you can put in your
development environment to speed up Umple development:

For Unix, Mac and Linux users (or Windows users with Cygwin or similar):

  - The following are scripts to automate common tasks
  - They assume either that your git working set is at ~/umple or that you
  - have created a symbolic link from ~/umple to the repo location. If not,
  - the do setenv UMPLEROOT {repo} to point $UMPLEROOT to your umple repo

It is suggested that you add this directory to your path.

Java must be installed to run all of these. Some require graphviz, php, ruby, txl and other dependencies as well

For normal use of Umple by end users on the command line. 

 umple
   - runs the umple command-line compiler with standard arguments
   - arguments can be .ump files, missets, and numerous others
   - use --help to list all arguments

 umple2svgcd
   - compiles an umple file and displays the resulting class diagram on your default browser
   - required argument is a .ump file
   - optional argument: -s followed by either hideattributes or showmethods
   - optional arguments: any mixsets you want to be active during diagram generation

 umple2svgsm
   - Same as above except displays the resulting state machine diagram
   - optional argument: -s followed by any of hideactions, hideguards, showtransitionlabels, showguardlabels
   
 gv2svg
   - utility to convert a graphviz file created by dot into an svg file ... used by the above two commands
   - optional argument -v will open the resulting file in your default browser

For developers

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

 dumple
  - Rebuilds the documentation (Javascript and system diagrams) of your local version of the Umple compiler
  - Needed after change if you want to be able to consult the documentation
  - Done on the main try.umple.org server

 mumple
  - Rebuilds the user manual from sources in build/reference
  - Must be run to validate that edits to the user manual are valid before pushing changes
  - Done as part of a full build. But if you are only pushing manual changes, you can skip the full build using this.
  
 bdock
   - Builds the Docker image of Umple ... done during releases
  
 startexecdocker
   - Restarts the docker image for umpleonline ... done by pumple so not normally needed to be separately run