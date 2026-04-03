# Dockerfile for UmpleLsp — standalone LSP container for local development
FROM --platform=linux/amd64 alpine

RUN apk add --no-cache nodejs-current npm openjdk21-jre-headless
RUN npm install -g umple-lsp-server@latest

WORKDIR /usr/src/app

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
