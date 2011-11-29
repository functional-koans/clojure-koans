#!/bin/sh
CLASSPATH=src

for f in lib/*.jar lib/dev/*.jar resources/; do
  CLASSPATH=$CLASSPATH:$f
done

if [ "$OSTYPE" = "cygwin" ]; then
	CLASSPATH=`cygpath -wp $CLASSPATH`
fi

java -cp "$CLASSPATH" clojure.main script/run.clj
echo
