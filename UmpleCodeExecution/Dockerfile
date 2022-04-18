FROM alpine

RUN apk add --update nodejs npm
RUN apk add docker
RUN apk add sudo

RUN addgroup nodeuser
RUN adduser  -D -H -S nodeuser -G nodeuser \
        && echo "nodeuser ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/nodeuser \
        && chmod 0440 /etc/sudoers.d/nodeuser

WORKDIR /usr/src/app
COPY package*.json ./

RUN npm install


# Bundle app source
COPY . .

EXPOSE 4400

RUN chown -R nodeuser:nodeuser /usr/src/app
RUN chown -R nodeuser:nodeuser /home
USER nodeuser

CMD [ "npm", "start" ]