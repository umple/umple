FROM nginx:1.13.5-alpine

MAINTAINER Umple umple-help@googlegroups.com

# give php its own user and install UmpleOnline's dependencies
RUN adduser -D -H -h /var/cache/php -s /sbin/nologin -G nginx php && \
    apk add --no-cache openjdk8 python py-pip graphviz zip \
		       php7 php7-fpm php7-sockets && \
    pip install supervisor==3.3.3

# make sure supervisord, nginx and php-fpm are configured
COPY docker_config/supervisord.conf /etc/supervisord.conf
COPY docker_config/nginx.conf /etc/nginx/conf.d/default.conf
COPY docker_config/php-fpm.conf /etc/php7/php-fpm.d/php-fpm.conf

# For some reason javadoc (and a bunch of other java stuff that
# is usually available) is not in the search path. This adds
# javadoc by linking it into /usr/bin so UmpleOnline can use it.
RUN ln -s /usr/lib/jvm/default-jvm/bin/javadoc /usr/bin/javadoc

# copy over the website data
COPY . /var/www

# make sure the php files are readable
# for extra security, only /ump is writable since it is the only place
# session data should be written
RUN chown -R :nginx /var/www && \
    chmod -R g+r /var/www && \
    chmod -R g+w /var/www/ump

# this is what runs on container startup
CMD supervisord --nodaemon --configuration=/etc/supervisord.conf

