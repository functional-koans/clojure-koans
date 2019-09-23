(ns koans.26-transducers
  (:require [koan-engine.core :refer :all]))

(def xfms
  (comp (map inc)
  (filter even?)))

(meditations
 "Consider that sequence operations can be used as transducers"
 (= __
    (transduce xfms conj [1 2 3]))

 "We can do this eagerly"
 (= __
    (into [] xfms [1 2 3]))
 
 "Or lazily"
 (= __
    (sequence xfms [1 2 3]))

 "The transduce function can combine mapping and reduction"
 (= __
    (transduce xfms + [1 2 3])))
