# Dockerfile for UmpleLsp — standalone LSP container for local development
FROM --platform=linux/amd64 alpine

RUN apk add --no-cache nodejs-current npm openjdk21-jre-headless

WORKDIR /usr/src/app

# Install umple-lsp-server: from local tarball if present, otherwise from registry
COPY lsp-server.tgz* ./
RUN if [ -f lsp-server.tgz ]; then \
      npm install -g ./lsp-server.tgz && rm -f lsp-server.tgz; \
    else \
      npm install -g umple-lsp-server@latest; \
    fi

COPY package.json package-lock.json ./
RUN npm ci --production --ignore-scripts

COPY server.js ./
COPY umplesync.jar ./

EXPOSE 9999

ENV LSP_HOST="0.0.0.0"
ENV LSP_DEV_AUTH="1"
ENV LSP_COMMAND="umple-lsp-server --stdio"
ENV UMPLESYNC_JAR_PATH="/usr/src/app/umplesync.jar"

CMD ["node", "server.js"]
