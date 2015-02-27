#!/bin/bash 

# Tell the script to fail on any non-zero return value
set -e

# check for linux
test "$TRAVIS_OS_NAME" == "linux"

sudo apt-get update
sudo apt-get install --force-yes php5-cli 

sudo ln -s /usr/share/java/ant-contrib.jar /usr/share/ant/lib/
