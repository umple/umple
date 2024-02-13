#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

first=$(echo $@ | cut -d'/' -f1)

if [ $first = "Python" ]; then
    echo "Python result:"
    python $@
else
    echo "Java result:"
    java $@
fi

mv /output/logfile.txt /output/completed
