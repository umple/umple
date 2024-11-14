FROM --platform=linux/amd64 alpine

RUN addgroup nodeuser
RUN adduser  -D -H -S nodeuser -G nodeuser

RUN apk add sudo
RUN sudo apk add --no-cache python3
RUN sudo apk add --no-cache openjdk17

RUN mkdir output 
RUN mkdir input

COPY javaRunner/javaRunner.sh /
RUN chmod +x /javaRunner.sh
RUN chown -R nodeuser /output
RUN chown -R nodeuser /input
RUN chmod -R u=rwx /output
RUN chmod -R u=r /input

USER nodeuser

ENTRYPOINT ["/javaRunner.sh"]