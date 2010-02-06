(ns koans.path-to-enlightenment
  (:use clojure.test))

(def __ nil)

(defmacro meditations [& forms]
  (let [pairs (partition 2 forms)]
    `(do
       ~@(doall (map
                 (fn [[doc# code#]]
                   `(when-not (is ~code# ~doc#)
                     (System/exit 1)))
                 pairs)))))

(load "about_equalities")
(load "about_vectors")
(println "You have acheived clojure enlightenment. Namaste.")