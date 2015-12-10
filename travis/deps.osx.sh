#!/bin/bash 

# check for OSX
if [ "$TRAVIS_OS_NAME" != "osx" ]; then
  echo "Wrong OS: $TRAVIS_OS_NAME"
  exit 1
fi

brew tap caskroom/cask

brew update #; brew doctor; brew update

brew install ant brew-cask && brew cask install java

java -version
