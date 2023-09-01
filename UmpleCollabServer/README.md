# Umple Collaboration Server
This code base provides the functionality to facilitate CodeMirror 6 collaboration in UmpleOnline. It sets up a server in Docker that any UmpleOnline user can connect to, such that others can collaborate on the same session directory.

# Setup
1. Create config.cfg file from config.cfg.template with correct parameters (Explained below).
2. Run ./setup.sh

You may need to run sudo ./setup.sh if docker requires sudo

To run in the background, so it will run indefinitely, add the argument bg to the setup.sh command

Note that for full UmpleOnline setup, the setup.sh is run by ../dev-tools/startexecdocker, which starts multiple docker images needed for various micro-services.


# Config.cfg
__portToUse__
Port that the Nginx redirects to the Docker image. 


# Setup.sh
This shell script contains commands to build docker images and to run the main docker container. The server will start at the following url by default.  
__http:localhost:8000__  

# APIs
`/healthCheck`
- to check if collab server is up and running

# Configurable Path for Collaboration
- Update path key in default.json to update the configurable path on collab_server
- By default path is set to `/collabapitest`
- You can use the default configuration file i.e. default.json as it is OR You can extend the default config file by creating other configuration files for development, production, QA, staging, etc.
- say you want to create a configuration for local/development environment.
    - Create a development.json file using default.json under config directory
    - set NODE_ENV=development