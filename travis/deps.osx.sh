#!/bin/bash 

# Tell the script to fail on any non-zero return value
set -e

# check for OSX
test "$TRAVIS_OS_NAME" == "osx"

brew install ant

brew tap caskroom/cask
brew install brew-cask

brew cask install java

java -version