#!/bin/sh
# Only used in docker. To provide access when the ump folder is mounted on the host's tmp folder, which will cause the access grant from Dockerfile being revoked
chown -R php:nginx /var/www/ump
chmod -R 770 /var/www/ump

exec supervisord --nodaemon --configuration=/etc/supervisord.conf --logfile=/var/log/supervisord.log --pidfile=/var/log/supervisord.pid
