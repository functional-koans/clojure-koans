#!/bin/sh
CLASSPATH=src

for f in lib/*.jar; do
  CLASSPATH=$CLASSPATH:$f
done

java -Xmx1G -cp $CLASSPATH jline.ConsoleRunner clojure.main
