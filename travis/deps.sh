#!/bin/bash 

DEPS_FILE="$TRAVIS_BUILD_DIR/travis/deps.$TRAVIS_OS_NAME.sh"

if [[ ! -f $DEPS_FILE ]]; then 
  echo "Unknown OS: $TRAVIS_OS_NAME"

  exit 1
fi

eval $DEPS_FILE
