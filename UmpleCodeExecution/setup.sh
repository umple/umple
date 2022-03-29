#! /bin/bash

. config.cfg

echo "This process will kill and remove any existing my"mainContainerName "container (ignore any error if not already running)"
echo "Then it will (re)build docker images for executing code from UmpleOnline"
echo "Then it will start the container on port" $portToUse
echo "If docker requires running with sudo, then so will this script"

# KILL EXISTING CONTAINER
docker container kill my$mainContainerName
docker container rm my$mainContainerName

# BUILD DOCKERFILES
docker build -t $mainContainerName .
docker build -t $tempContainerName -f javaRunner/Dockerfile .

# RUN MAIN CONTAINER
docker run --name my$mainContainerName -v /var/run/docker.sock:/var/run/docker.sock -v "$umplePath:/usr/src/app/models/" -v "$tempPath:/usr/src/app/output/" -p "$portToUse:4400" $mainContainerName;