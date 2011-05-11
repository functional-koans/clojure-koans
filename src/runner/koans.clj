(ns runner.koans
  (:use [clojure.java.io :only [file]]))

(def ordered-koans
     ["equalities"
      "lists"
      "vectors"
      "sets"
      "maps"
      "functions"
      "conditionals"
      "higher_order_functions"
      "runtime_polymorphism"
      "lazy_sequences"
      "sequence_comprehensions"
      "creating_functions"
      "recursion"
      "destructuring"
      "refs"
      "atoms"
      "macros"
      "datatypes"])

(defn ordered-koan-paths  []
  (map (fn [koan-name]
           (.getCanonicalPath (file "src" "koans" (str koan-name ".clj"))))
       ordered-koans))

(defn among-paths? [files]
  (into #{} (map #(.getCanonicalPath %) files)))

(defn next-koan-path [last-koan-path]
  (loop [[this-koan & more :as koan-paths] (ordered-koan-paths)]
    (when (seq more)
      (if (= last-koan-path this-koan)
        (first more)
        (recur more)))))

(defn tests-pass? [file-path]
  (use '[path-to-enlightenment :only [meditations __ ___]])
  (try
    (load-file file-path)
    (catch Exception e
      (println)
      (println e)
      false)))

(defn namaste []
  (println "\nYou have achieved clojure enlightenment. Namaste."))

