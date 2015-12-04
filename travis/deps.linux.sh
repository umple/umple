#!/bin/bash 

# Tell the script to fail on any non-zero return value
set -e

# check for linux
test "$TRAVIS_OS_NAME" == "linux"

export JAVA_HOME=/usr/lib/jvm/java-8-oracle
export PATH=$JAVA_HOME/bin:$PATH

java -version
echo $PATH
