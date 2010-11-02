@echo off
setLocal EnableDelayedExpansion
set CLASSPATH="
for /R ./lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
)
set CLASSPATH=!CLASSPATH!"
set CLASSPATH=%CLASSPATH%;src

java -Xmx1G -cp "%CLASSPATH%" clojure.main -e "(load \"path_to_enlightenment\")" -e "(do (in-ns 'path-to-enlightenment) (run))"

