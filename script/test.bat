@echo off
setLocal EnableDelayedExpansion
set CLASSPATH="
for /R ./lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
)
set CLASSPATH=!CLASSPATH!"

java -Xmx1G -cp "%CLASSPATH%" clojure.main -e "(load \"path_to_answer_sheet\")" -e "(do (in-ns 'path-to-answer-sheet) (run))"
