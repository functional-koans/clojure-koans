@echo off
setLocal EnableDelayedExpansion
set CLASSPATH="
for /R ./lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
)
set CLASSPATH=!CLASSPATH!"
set CLASSPATH=%CLASSPATH%;src

set JLINE=jline.ConsoleRunner

java -Xmx1G -cp "%CLASSPATH%" %JLINE% clojure.main

