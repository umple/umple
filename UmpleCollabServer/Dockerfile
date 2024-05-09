FROM node:19.0.0-alpine3.16

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 8000
CMD [ "node", "./build/server.js" ]