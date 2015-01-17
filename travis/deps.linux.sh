#!/bin/bash 

# Tell the script to fail on any non-zero return value
set -e

# check for linux
test "$TRAVIS_OS_NAME" == "linux"

sudo apt-get install php5-gd php-pear php-apc php5-curl libgd2-xpm libt1-5 php5-cli php5-common php5-dev shtool

sudo ln -s /usr/share/java/ant-contrib.jar /usr/share/ant/lib/