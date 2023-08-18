#! /bin/bash

npm run build

BASEDIR=$(dirname "$0")
echo "Running setup.sh for Umple Collaboration Server"
cd $BASEDIR

. config.cfg

echo "This process will kill and remove any existing " $mainContainerName "container (ignore any error if not already running)"
echo "Then it will (re)build docker images for executing code from UmpleOnline"
echo "Then it will start the container on port" $portToUse
echo "If docker requires running with sudo, then so will this script"
echo "Use argument bg to make it work in the background"

# KILL EXISTING CONTAINER
docker container kill $mainContainerName
docker container rm $mainContainerName

# BUILD DOCKERFILES
docker build -t $mainContainerName .

# RUN MAIN CONTAINER
portmap="-p 0.0.0.0:$portToUse:8000"

if [ $# -gt 0 ] && [ $1 == 'bg' ]
then
  docker run $portmap --name $mainContainerName $mainContainerName >/dev/null 2>&1 &
else
  docker run $portmap --name $mainContainerName $mainContainerName
fi 