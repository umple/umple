#!/bin/bash

BASEDIR=$(dirname "$0")
echo "Running setup.sh for UmpleLsp in $BASEDIR"
cd "$BASEDIR"

if [ ! -f config.cfg ]; then
  echo "config.cfg not found — creating from config.cfg.template"
  cp config.cfg.template config.cfg
fi

. config.cfg

# Resolve umplePath to absolute if relative
if [[ "$umplePath" != /* ]]; then
  umplePath="$(cd "$BASEDIR/.."; pwd)/$umplePath"
fi

if [ ! -d "$umplePath" ]; then
  echo "WARNING: umplePath=$umplePath does not exist. Creating it."
  mkdir -p "$umplePath"
fi

echo "This will kill and remove any existing my$containerName container (ignore any error if not already running)"
echo "Then it will (re)build the Docker image for the LSP server"
echo "Then it will start the container on port $portToUse"

# KILL EXISTING CONTAINER
docker container kill my$containerName 2>/dev/null
docker container rm my$containerName 2>/dev/null

# Copy umplesync.jar into build context
SYNCJAR="$(cd "$BASEDIR/.."; pwd)/dist/umplesync.jar"
if [ -f "$SYNCJAR" ]; then
  cp "$SYNCJAR" "$BASEDIR/umplesync.jar"
else
  echo "WARNING: umplesync.jar not found at $SYNCJAR — diagnostics will be disabled"
  touch "$BASEDIR/umplesync.jar"
fi

# Copy canonical lsp-proxy server.js into build context
cp "$(cd "$BASEDIR/.."; pwd)/umpleonline/scripts/lsp-proxy/server.js" "$BASEDIR/server.js"

# BUILD DOCKERFILE
docker build --no-cache -t $containerName .
rm -f "$BASEDIR/server.js"

# RUN CONTAINER
# Mount the ump directory so the LSP server can read .ump files
portmap="-p 0.0.0.0:$portToUse:9999"

if [ $# -gt 0 ] && [ "$1" == 'bg' ]; then
  docker run --restart=unless-stopped --name my$containerName \
    -v "$umplePath:$umplePath" \
    -e UMP_BASE_DIR="$umplePath" $portmap $containerName >/dev/null 2>&1 &
else
  docker run --restart=unless-stopped --name my$containerName \
    -v "$umplePath:$umplePath" \
    -e UMP_BASE_DIR="$umplePath" $portmap $containerName
fi
