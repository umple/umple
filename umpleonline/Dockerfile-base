FROM nginx:1.13.5-alpine

MAINTAINER Umple umple-help@googlegroups.com

# give php its own user and install UmpleOnline's dependencies
RUN adduser -D -H -h /var/cache/php -s /sbin/nologin -G nginx php && \
    apk add --no-cache openjdk8 python py-pip graphviz zip \
		       php7 php7-fpm php7-sockets php7-zip php7-json && \
    pip install supervisor==3.3.3

