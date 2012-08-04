(defproject clojure-koans "0.4.5"
  :description "The Clojure koans."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [koan-engine "0.1.2-SNAPSHOT"]]
  :dev-dependencies [[swank-clojure "1.3.0" :exclusions [org.clojure/clojure]]
                     [lein-koan "0.1.0"]]
  :main koan-engine.runner/exec)
