(defproject clojure-koans "0.4.9"
  :description "The Clojure koans."
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [koan-engine "0.2.0"]]
  :dev-dependencies [[lein-koan "0.1.2"]]
  :profiles {:dev {:dependencies [[lein-koan "0.1.2"]]}}
  :plugins [[lein-koan "0.1.2"]]
  :main koan-engine.runner/exec)
