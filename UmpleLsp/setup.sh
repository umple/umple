#!/bin/bash

BASEDIR="$(cd "$(dirname "$0")" && pwd)"
echo "Running setup.sh for UmpleLsp in $BASEDIR"
cd "$BASEDIR"

# Read canonical config from umpleonline/config/lsp.ini
REPOROOT="$(cd "$BASEDIR/.."; pwd)"
LSPINI="$REPOROOT/umpleonline/config/lsp.ini"
LSPINI_TEMPLATE="$REPOROOT/umpleonline/config/lsp.ini.template"
if [ ! -f "$LSPINI" ]; then
  if [ -f "$LSPINI_TEMPLATE" ]; then
    echo "Creating lsp.ini from template"
    cp "$LSPINI_TEMPLATE" "$LSPINI"
  else
    echo "ERROR: No lsp.ini or lsp.ini.template found at $REPOROOT/umpleonline/config/"
    exit 1
  fi
fi

# Parse INI file (handles ; and # comments)
while IFS='=' read -r key value; do
  key=$(echo "$key" | xargs)
  value=$(echo "$value" | xargs)
  [[ -z "$key" || "$key" == \;* || "$key" == \#* ]] && continue
  case "$key" in
    standaloneUmpBaseDir)   umplePath="$value" ;;
    standaloneHostPort)     portToUse="$value" ;;
    standaloneContainerName) containerName="$value" ;;
    maxProcesses)           maxProcesses="$value" ;;
    useLinkedLsp)           useLinkedLsp="$value" ;;
  esac
done < "$LSPINI"

# Validate required values
if [ -z "$portToUse" ] || [ -z "$containerName" ] || [ -z "$umplePath" ] || [ -z "$maxProcesses" ]; then
  echo "ERROR: Missing required values in $LSPINI"
  echo "Required: standaloneHostPort, standaloneContainerName, standaloneUmpBaseDir, maxProcesses"
  exit 1
fi

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

# Pack npm-linked umple-lsp-server if enabled
rm -f "$BASEDIR/lsp-server.tgz"
if [ "$useLinkedLsp" = "true" ]; then
  LSP_SRC=$(node -e "console.log(require('fs').realpathSync(require('child_process').execSync('npm root -g').toString().trim() + '/umple-lsp-server'))" 2>/dev/null)
  if [ -n "$LSP_SRC" ]; then
    echo "Using npm-linked umple-lsp-server from $LSP_SRC"
    npm pack --pack-destination "$BASEDIR" "$LSP_SRC"
    LSP_TGZ=$(ls -t "$BASEDIR"/umple-lsp-server-*.tgz 2>/dev/null | head -1)
    if [ -n "$LSP_TGZ" ]; then
      mv "$LSP_TGZ" "$BASEDIR/lsp-server.tgz"
    else
      echo "ERROR: npm pack failed"
      exit 1
    fi
  else
    echo "ERROR: umple-lsp-server is not npm-linked globally"
    exit 1
  fi
fi

# Copy canonical lsp-proxy server.js into build context
cp "$(cd "$BASEDIR/.."; pwd)/umpleonline/scripts/lsp-proxy/server.js" "$BASEDIR/server.js"

# BUILD DOCKERFILE
docker build --no-cache -t $containerName .
rm -f "$BASEDIR/server.js" "$BASEDIR/lsp-server.tgz"

# RUN CONTAINER — pass all config as explicit env vars
portmap="-p 0.0.0.0:$portToUse:9999"

if [ $# -gt 0 ] && [ "$1" == 'bg' ]; then
  docker run --restart=unless-stopped --name my$containerName \
    -v "$umplePath:$umplePath" \
    -e LSP_HOST="0.0.0.0" \
    -e LSP_PORT="9999" \
    -e UMP_BASE_DIR="$umplePath" \
    -e LSP_MAX_PROCESSES="$maxProcesses" \
    $portmap $containerName >/dev/null 2>&1 &
else
  docker run --restart=unless-stopped --name my$containerName \
    -v "$umplePath:$umplePath" \
    -e LSP_HOST="0.0.0.0" \
    -e LSP_PORT="9999" \
    -e UMP_BASE_DIR="$umplePath" \
    -e LSP_MAX_PROCESSES="$maxProcesses" \
    $portmap $containerName
fi
