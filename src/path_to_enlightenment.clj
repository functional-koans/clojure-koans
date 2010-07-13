(ns path-to-enlightenment
  (:use clojure.test))

(def __ nil)
(def ___ (fn [& args] args))

(defmacro meditations [& forms]
  (let [pairs (partition 2 forms)]
    `(do
      ~@(map
          (fn [[doc# code#]]
            `(when-not (is ~code# ~doc#)
              (System/exit 0)))
          pairs))))

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
      "sequence_comprehensions"
      "partial_functions"])

(defn run []
  (apply load (doall (map (partial str "koans/") ordered-koans)))
  (println "You have achieved clojure enlightenment. Namaste."))
