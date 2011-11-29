@echo off
setLocal EnableDelayedExpansion

set CLASSPATH="
for %%j in (".\lib\*.jar") do (
  set CLASSPATH=!CLASSPATH!;%%~fj
)
set CLASSPATH=!CLASSPATH!"
set CLASSPATH=%CLASSPATH%;src;resources

set JLINE=jline.ConsoleRunner

java -Xmx1G -cp %CLASSPATH% %JLINE% clojure.main

