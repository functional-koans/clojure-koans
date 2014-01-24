(defproject clojure-koans "0.5.0-SNAPSHOT"
  :description "The Clojure koans."
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [koan-engine "0.2.0"]]
  :dev-dependencies [[lein-koan "0.1.2"]]
  :profiles {:dev {:dependencies [[lein-koan "0.1.2"]]}}
  :repl-options {
                 :init-ns koan-engine.runner
                 :init (do
                         (ns koans.01-equalities (:use koan-engine.core))
                         (ns koans.02-lists (:use koan-engine.core))
                         (ns koans.03-vectors (:use koan-engine.core))
                         (ns koans.04-sets (:use koan-engine.core))
                         (ns koans.05-maps (:use koan-engine.core))
                         (ns koans.06-functions (:use koan-engine.core))
                         (ns koans.07-conditionals (:use koan-engine.core))
                         (ns koans.08-higher-order-functions (:use koan-engine.core))
                         (ns koans.09-runtime-polymorphism (:use koan-engine.core))
                         (ns koans.10-lazy-sequences (:use koan-engine.core))
                         (ns koans.11-sequence-comprehensions (:use koan-engine.core))
                         (ns koans.12-creating-functions (:use koan-engine.core))
                         (ns koans.13-recursion (:use koan-engine.core))
                         (ns koans.14-destructuring (:use koan-engine.core))
                         (ns koans.15-refs (:use koan-engine.core))
                         (ns koans.16-atoms (:use koan-engine.core))
                         (ns koans.17-macros (:use koan-engine.core))
                         (ns koans.18-datatypes (:use koan-engine.core))
                         (ns koans.19-java-interop (:use koan-engine.core))
                         (ns koans.20-partition (:use koan-engine.core))
                         (ns koans.21-group-by (:use koan-engine.core))
                         (ns koan-engine.runner (:use koan-engine.core))
                         )
                 }
  :plugins [[lein-koan "0.1.2"]]
  :main koan-engine.runner/exec)
