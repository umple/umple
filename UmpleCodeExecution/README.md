# Umple Code Execution
This code base provides the functionality to securely execute Java code using Docker containers.

# Setup
1. Create config.cfg file from config.cfg.template with correct parameters (Explained below).
2. Run ./setup.sh
3. (Optional) Run the following command to compile and use latest Javascript changes if haven't done yet.  
__ant -DshouldPackageUmpleOnline=true -Dmyenv=wlocal -f build.umple.xml packageUmpleonline__


# Config.cfg
__umplePath__  
Path to the Umple's ump folder where temporary user folders are created. The full path to umpleonline/ump
__tempPath__  
A directory where temporary files can be written. Suggested: /tmp
__mainContainerName__  
Name of the always running container and image. Use the default unless you are running more than one instance.
__tempContainerName__  
Name of the temporary java container and image created for Java execution. Use the default unless you are running more than one instance.
__portToUse__
Port that the Umple Php code uses to communicate with the Docker image. Suggested: 4400. If you are running more than one instance, then each would need a new port.
__timeoutValue__
How many seconds execution will run before the execution is ended. Default 20, but reduce if the server resources are limited.

# Setup.sh
This shell script contains commands to build docker images and to run the main docker container. The server will start at the following url by default.  
__http:localhost:4400__  

# Other Issues
1. If timeout is coming even though the docker is running, make sure that umplePath in config.cfg does not start with '~'.