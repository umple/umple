#!/bin/bash
if [ -e umple.jar ] 
then
  echo "REMOTE BUILD"
  java -jar umple.jar Elevator.ump
else
  echo "LOCAL BUILD"
  java -jar ../../../dist/umple.jar Elevator.ump  
fi
