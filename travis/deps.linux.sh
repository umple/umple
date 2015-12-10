#!/bin/bash 

# Tell the script to fail on any non-zero return value
set -e

# check for linux
test "$TRAVIS_OS_NAME" == "linux"

rvm install 2.1
rvm use 2.1

