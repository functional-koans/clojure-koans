@echo off
java -cp lib\clojure-1.3.0-alpha1.jar;src clojure.main -e "(load \"path_to_enlightenment\")" -e "(do (in-ns 'path-to-enlightenment) (run))"
