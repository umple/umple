#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

java $@

mv /output/logfile.txt /output/completed