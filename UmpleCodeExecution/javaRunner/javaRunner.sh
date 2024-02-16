#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

py=$(echo $@ | cut -d'.' -f2)

if [ $py = "py" ]; then
    echo "Python result:"
    python $@
else
    echo "Java result:"
    java $@
fi

mv /output/logfile.txt /output/completed
