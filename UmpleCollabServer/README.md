# Umple Collaboration Server
This code base provides the functionality to facilitate CodeMirror 6 collaboration in UmpleOnline. It sets up a server in Docker that any UmpleOnline user can connect to, such that others can collaborate on the same session director..

# Setup
1. Create config.cfg file from config.cfg.template with correct parameters (Explained below).
2. Run ./setup.sh


# Config.cfg
__portToUse__
Port that the Nginx redirectst to the Docker image. 


# Setup.sh
This shell script contains commands to build docker images and to run the main docker container. The server will start at the following url by default.  
__http:localhost:4400__  

