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

# Pack local umple-lsp-server if npm-linked (dev)
# Dockerfile handles both cases: local tarball if present, registry if not
rm -f "$BASEDIR/lsp-server.tgz"
LSP_LINKED=$(npm ls -g umple-lsp-server 2>/dev/null | grep "\->" || true)
if [ -n "$LSP_LINKED" ]; then
  LSP_SRC=$(node -e "console.log(require('fs').realpathSync(require('child_process').execSync('npm root -g').toString().trim() + '/umple-lsp-server'))")
  echo "Using npm-linked umple-lsp-server from $LSP_SRC"
  npm pack --pack-destination "$BASEDIR" "$LSP_SRC"
  LSP_TGZ=$(ls -t "$BASEDIR"/umple-lsp-server-*.tgz 2>/dev/null | head -1)
  if [ -n "$LSP_TGZ" ]; then
    mv "$LSP_TGZ" "$BASEDIR/lsp-server.tgz"
  fi
fi

# BUILD DOCKERFILE
docker build --no-cache -t $containerName .
rm -f "$BASEDIR/lsp-server.tgz"

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
