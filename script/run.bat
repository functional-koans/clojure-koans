@echo off
setLocal EnableDelayedExpansion

set CLASSPATH="
for %%j in (".\lib\*.jar", ".\lib\dev\*.jar") do (
  set CLASSPATH=!CLASSPATH!;%%~fj
)
set CLASSPATH=!CLASSPATH!"
set CLASSPATH=%CLASSPATH%;src;resources

java -Xmx1G -cp %CLASSPATH% clojure.main script\run.clj

