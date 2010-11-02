#!/bin/sh
CLASSPATH=src

for f in lib/*.jar; do
  CLASSPATH=$CLASSPATH:$f
done

java -cp "$CLASSPATH" clojure.main -e '(load "path_to_answer_sheet")' -e "(do (in-ns 'path-to-answer-sheet) (run))"
echo
