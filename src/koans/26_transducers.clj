(ns koans.26-transducers
  (:require [koan-engine.core :refer :all]))

(def example-transducer
  (map inc))

(def transforms
  (comp (map inc)
     (filter even?)))

(meditations
 "A sequence operation with only one argument often returns a transducer"
 (= '(2 3 4)
    (sequence example-transducer [1 2 3]))

 "Consider that sequence operations can be composed as transducers"
 (= [2 4]
    (transduce transforms conj [1 2 3]))

 "We can do this eagerly"
 (= [2 4]
    (into [] transforms [1 2 3]))

 "Or lazily"
 (= '(2 4)
    (sequence transforms [1 2 3]))

 "The transduce function can combine mapping and reduction"
 (= 6
    (transduce transforms + [1 2 3])))
