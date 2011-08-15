(defproject functional-koans "0.4.2"
  :description "The functional koans"
  :dependencies [[org.clojure/clojure "1.3.0-master-SNAPSHOT"]
                 [fresh "1.0.2"]
                 [jline "0.9.94" :exclusions [junit]]]
  :dev-dependencies [[swank-clojure "1.3.0-SNAPSHOT" :exclusions [org.clojure/clojure]]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public"})
