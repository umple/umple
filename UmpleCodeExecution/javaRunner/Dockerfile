FROM --platform=linux/amd64 openjdk:17-alpine

RUN addgroup nodeuser
RUN adduser  -D -H -S nodeuser -G nodeuser

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