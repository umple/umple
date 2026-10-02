#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

case "$1" in
  -m)
    # PythonNext: from its generated root, run the main module by its dotted name
    echo "Python result:"
    cd "$2" || exit 1
    shift 2
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
