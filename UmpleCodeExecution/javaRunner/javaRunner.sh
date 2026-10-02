#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

case "$1" in
  -m)
    # PythonNext: run the main module by its dotted name, so it imports its package
    echo "Python result:"
    shift
    python3 -m "$@"
    ;;
  *.py)
    echo "Python result:"
    python3 "$@"
    ;;
  *)
    echo "Java result:"
    java $@
    ;;
esac

mv /output/logfile.txt /output/completed
