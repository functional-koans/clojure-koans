@echo off
java -cp lib\clojure-1.2.0-beta1.jar;src clojure.main -e "(load \"path_to_enlightenment\")" -e "(do (in-ns 'path-to-enlightenment) (run))"
