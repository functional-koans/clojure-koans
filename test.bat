@echo off
java -cp lib\clojure-1.2.0-RC2.jar;src clojure.main -e "(load \"path_to_answer_sheet\")" -e "(do (in-ns 'path-to-answer-sheet) (run))"
