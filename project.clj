(defproject functional-koans "0.4.5"
  :description "The functional koans"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [fresh "1.0.2"]
                 [jline "0.9.94" :exclusions [junit]]]
  :dev-dependencies [[swank-clojure "1.3.0" :exclusions [org.clojure/clojure]]])
