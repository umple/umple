Directory for the UmpleOnline web tool

The public deployment of this can be found at http://try.umple.org

This can also be used via Docker. Go to http://docker.umple.org

Key files and directories means contents created at runtime

  umple.php - main program of UmpleOnline

  simulate.php - code for the simulator (not recently maintained)

  umplibrary
     *.ump example files displayed by UmpleOnline
     imagecache* - svg files that are displayed if Javascript is off
     manualexamples/*.ump - examples loaded in the user manual


  ump *** runtime directory for data storage in umpleonline
     tmp* directories for each user session. These have randomly generated base-36 characters, meaning that guessing a directory would require trillions of tries. These are deleted after a month if not used
     
     yymmdd* directories. Longer-term storage for end users. These are deleted a year after last edit. Filenames also require guessing. The date the directory was originally created is embedded in the filename
     
     tasks Base directory for tasks set up by experimenters or professors
     
     taskroot* Storage of responses to tasks by end users
     
        the date of the model is embeeded in the filename

  scripts - PhP and JavaScript scripts for Umpleonline

  download_umple.html - main page of http://dl.umple.org

  UmpleUpdateSite - website for automatic updating of Eclipse plugin
  
  docker_config - Directories used for setting up the Docker image, including setting up nginx, php and supervisord.
  
  Dockerfile - Instructions for the main Docker image built every brach push, pr and merge

  Dockerfile-base - Instructions for the Docker base image built only when a tag is added to the repository. Make before every major release that you go here https://hub.docker.com/_/nginx and update this file with the latest nginx-alpine image. Consider also checking whether a higher version of openjdk is available out of testing (i.e. edge) than the version listed.