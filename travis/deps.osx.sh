#!/bin/bash 

# check for OSX
if [ "$TRAVIS_OS_NAME" != "osx" ]; then
  echo "Wrong OS: $TRAVIS_OS_NAME"
  exit 1
fi

brew tap caskroom/cask

echo "brew update ..."
brew update > /dev/null # There is no need for all of this output to be seen

brew install ant
brew cask install java

java -version
