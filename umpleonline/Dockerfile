# This is the main Dockerfile for UmpleOnline ... it depends on umpleonline-base
# Use the dev-tools/bdock script to build the image correctly
FROM --platform=linux/amd64 umple/umpleonline-base:latest
# To test local base, change the above to :local and back to :latest afterwards
# To save 200MB on image size, all our dependencies are in the separate
# slow-changing umpleonline-base image (see Dockerfile-base) 

# make sure supervisord, nginx and php-fpm are configured
COPY docker_config/supervisord.conf /etc/supervisord.conf
COPY docker_config/nginx.conf /etc/nginx/conf.d/default.conf
COPY docker_config/php-fpm.conf /etc/php7/php-fpm.d/php-fpm.conf

# For some reason javadoc (and a bunch of other java stuff that
# is usually available) was not in the search path. This adds
# javadoc by linking it into /usr/bin so UmpleOnline can use it.
# This is now commented out since seems no longer to be needed
#RUN ln -s /usr/lib/jvm/default-jvm/bin/javadoc /usr/bin/javadoc

# Save the branch so it can be accessed internally
ARG gitbranch
RUN echo $gitbranch > /tmp/umplegitbranch.txt

# copy over the website data
COPY . /var/www
RUN mv /var/www/UmpleCodeExecution /var
RUN sed 's/\(umplePath=\)umpleonline\/ump/\1\/var\/www\/ump/;s/_execution/_executionint/;s/portToUse=4400/portToUse=4409/' /var/UmpleCodeExecution/config.cfg.template > /var/UmpleCodeExecution/config.cfg

RUN adduser  -D -H -S docker -G docker \
        && echo "docker ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/docker \
        && chmod 0440 /etc/sudoers.d/docker

# make sure the php files are readable and log files are writable
# Windows EXE files are being removed
# as they were triggering certain security warnings
RUN chown -R :nginx /var/www && \
    chmod -R g+r /var/www && \
    chown -R :nginx /run && \
    chmod -R g+rw /run  && \
    chown -R :nginx /var/run && \
    chmod -R g+rw /var/run  && \
    chown -R :nginx /var/log && \
    chmod -R g+rw /var/log && \
    chown -R :nginx /var/cache && \
    chmod -R g+rw /var/cache 

# Recently removed the following from the above, since they had been removed from the image
#&& \
#    rm /usr/lib/python*/site-packages/setuptools/*.exe && \
#    rm /usr/lib/python*/site-packages/pip/_vendor/distlib/*.exe

# The following is commented out in an attempt to get docker-in-docker working for Umple Code Execution
#USER nginx:nginx

# this is what runs on container startup
CMD supervisord --nodaemon --configuration=/etc/supervisord.conf --logfile=/var/log/supervisord.log --pidfile=/var/log/supervisord.pid

