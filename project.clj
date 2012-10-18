(defproject clojure-koans "0.4.6"
  :description "The Clojure koans."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [koan-engine "0.1.2"]]
  :dev-dependencies [[lein-koan "0.1.2"]]
  :profiles {:dev {:dependencies [[lein-koan "0.1.2"]]}}
  :plugins [[lein-koan "0.1.2"]]
  :main koan-engine.runner/exec)
