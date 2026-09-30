#!/usr/bin/env sh
exec  1> "/output/logfile.txt"
exec  2> "/output/errors"

cd /input/

case "$1" in
  *.py)
    echo "Python result:"
    # Run the main module by its dotted name: generated modules import each other by package, and
    # -m adds /input to the path only after startup, so a generated module named like one Python
    # loads at startup (os, io) cannot replace it
    module=$(echo "${1%.py}" | tr / .)
    shift
    python3 -m "$module" "$@"
    ;;
  *)
    echo "Java result:"
    java $@
    ;;
esac

mv /output/logfile.txt /output/completed
