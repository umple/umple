#! /bin/bash

. config.cfg

# BUILD DOCKERFILES
docker build -t $mainContainerName .
docker build -t $tempContainerName -f javaRunner/Dockerfile .

# RUN MAIN CONTAINER
docker run -v /var/run/docker.sock:/var/run/docker.sock -v "$umplePath:/usr/src/app/models/" -v "$tempPath:/usr/src/app/output/" -p 4400:4400 $mainContainerName;