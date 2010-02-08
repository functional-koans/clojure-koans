(defproject functional-koans "0.0.1"
  :description "The functional koans"
  :script "koans/path_to_enlightenment.clj"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.0-SNAPSHOT"]
                 [jline "0.9.94"]]
  :dev-dependencies [[lein-clojars "0.5.0-SNAPSHOT"]
                     [leiningen-run "0.3"]]
  :namespaces [koans])
