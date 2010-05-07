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

(load "about_equalities")
(load "about_lists")
(load "about_vectors")
(load "about_sets")
(load "about_maps")
(load "about_functions")
(load "about_conditionals")
(load "about_higher_order_functions")
(load "about_runtime_polymorphism")
(load "about_sequence_comprehensions")
(println "You have achieved clojure enlightenment. Namaste.")
