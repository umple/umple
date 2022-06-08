#! /bin/bash

BASEDIR=$(dirname "$0")
echo "Running setup.sh for code execution in $BASEDIR"
cd $BASEDIR

. config.cfg

echo "This process will kill and remove any existing my"mainContainerName "container (ignore any error if not already running)"
echo "Then it will (re)build docker images for executing code from UmpleOnline"
echo "Then it will start the container on port" $portToUse
echo "If docker requires running with sudo, then so will this script"
echo "Use argument bg to make it work in the background"

# KILL EXISTING CONTAINER
docker container kill my$mainContainerName
docker container rm my$mainContainerName

# BUILD DOCKERFILES
docker build -t $mainContainerName .
docker build -t $tempContainerName -f javaRunner/Dockerfile .

# RUN MAIN CONTAINER

portmap="-p 0.0.0.0:$portToUse:4400"
netcommand=""
if [ $portToUse == '4409' ]
then
  portmap=""
  netcommand=--network="container:umpleonline_local"
fi

if [ $# -gt 0 ] && [ $1 == 'bg' ]
then
  docker run --restart=unless-stopped --name my$mainContainerName $netcommand -v /var/run/docker.sock:/var/run/docker.sock -v "$umplePath:/usr/src/app/models/" -v "$tempPath:/usr/src/app/output/" $portmap $mainContainerName >/dev/null 2>&1 &
else
  docker run --restart=unless-stopped --name my$mainContainerName $netcommand -v /var/run/docker.sock:/var/run/docker.sock -v "$umplePath:/usr/src/app/models/" -v "$tempPath:/usr/src/app/output/" $portmap $mainContainerName
fi
