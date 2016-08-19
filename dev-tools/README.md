This directory contains files that you can put in your
development environment to speed up Umple development:

For Unix, Mac and Linux users (or Windows users with Cygwin or similar):

  - The following are scripts to automate common tasks
  - They assume either that your git working set is at ~/umple or that you
  - have created a symbolic link from ~/umple to the repo location. If not,
  - the do setenv UMPLEROOT {repo} to point $UMPLEROOT to your umple repo

 umple
   - runs the umple command-line compiler with standard arguments
 
 bumple
  - does a full build of Umple (make sure you have done git pull first
  - you should run this before creating any pull request 
  - Takes 2-5 minutes. Emulates what the server does and cleanly deals with UmpleVersion
   
 qbumple
  - Does a quick build (compiles .ump source, then generated code, then builds jars)
  - Used when you have edited compiler code in .ump, .error etc. and want to
  - determine if it compiles using the command line compiler and run manual tests
  - follow with tumple or bumple before creating a pull request

 qfbumple
  - Same as the above, but also builds umple jars;
  - needed when testing umplesync.jar for example

 tumple
  - Runs a the unit tests tests
  - Does not rebuild the compiler nor run the testbed tests
  - Used when you want to do basic test after doing qbumple

pumple
  - Propagates the umple jars to umpleonline.
  - Needed to test a local version of UmpleOnline

 mumple
  - Rebuilds the user manual from sources in build/reference
  
   