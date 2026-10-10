#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

case "$1" in
  -m)
    # Python: run the main module by its dotted name, so it imports its package
    echo "Python result:"
    shift
    python3 -m "$@"
    ;;
  *)
    echo "Java result:"
    java $@
    ;;
esac

mv /output/logfile.txt /output/completed
