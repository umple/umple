This directory contains files that you can put in your
development environment to speed up Umple development:

For Unix, Mac and Linux users:

  - The following are scripts to automate common tasks
  - They assume either that your svn working set is at ~/umple or that you
  - have created a symbolic link from ~/umple to the repo location. If not,
  - the do setenv UMPLEROOT to point $UMPLEROOT to your umple repo working set

 bumple
  - does a full build of Umple (make sure you have done svn update first
  - you should run this before creating any patch
  - Takes 2-5 minutes. Emulates what the server does and cleanly deals with UmpleVersion
   
 qbumple
  - Does a quick build (umpleSelf compile packageMainJar
  - Used when you have edited compiler code in .ump, .error etc. and want to
  - determine if it compiles

 tumple
  - Runs a quick test (template.test)
  - Does not rebuild the compiler (a bit testcase) nor run the testbed tests
  - Used when you want to do a basic test after doing qbumple

 mumple
  - packages the user manual
  
 umple++
   - A bash script to assist developers do various command line development tasks when
   they have multiple trunks open
   