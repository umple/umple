# Umple Code Execution
This code base provides the functionality to securely execute Java code using Docker containers.

# Setup
1. Modify config.cfg file with correct parameters (Explained below).
2. Run setup.sh


# Config.cgf
__umplePath__  
Path to the Umple's ump folder where temporary user folders are created.  
__tempPath__  
A directory where temporary files can be written.  
__mainContainerName__  
Name of the always running container and image.  
__tempContainerName__  
Name of the temporary java container and image created for Java execution.

# Setup.sh
This shell script contains commands to build docker images and to run the main docker container. The server will start at the following url by default.  
__http:localhost:4400__  
In future, the configuration of the port will be supported.