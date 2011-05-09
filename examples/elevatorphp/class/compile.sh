#!/bin/bash
if [ -e umple.jar ] 
then
  echo "REMOVE BUILD"
  java -jar umple.jar Elevator.ump
else
  echo "LOCAL BUILD"
  java -jar ../../../dist/umple.jar Elevator.ump  
fi
