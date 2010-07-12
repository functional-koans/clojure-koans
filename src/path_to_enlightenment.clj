(ns koans.path-to-enlightenment
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

(load "about_equalities"
      "about_lists"
      "about_vectors"
      "about_sets"
      "about_maps"
      "about_functions"
      "about_conditionals"
      "about_higher_order_functions"
      "about_runtime_polymorphism"
      "about_sequence_comprehensions"
      "about_partial_functions")

(println "You have achieved clojure enlightenment. Namaste.")
