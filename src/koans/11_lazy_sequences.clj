(ns koans.11-lazy-sequences
  (:require [koan-engine.core :refer :all]))

(meditations
  "There are many ways to generate a sequence"
  (= [1 2 3 4] (range 1 5))

  "The range starts at the beginning by default"
  (= [0 1 2 3 4] (range 5))

  "Only take what you need when the sequence is large"
  (= [0 1 2 3 4 5 6 7 8 9]
     (take 10 (range 100)))

  "Or limit results by dropping what you don't need"
  (= [95 96 97 98 99]
     (drop 95 (range 100)))

  "Iteration provides an infinite lazy sequence"
  (= [1 2 4 8 16 32 64 128] (take 8 (iterate (fn [x] (* x 2)) 1)))

  "Repetition is key"
  (= [:a :a :a :a :a :a :a :a :a :a]
     (repeat 10 :a))

  "Iteration can be used for repetition"
  (= (repeat 100 "hello")
     (take 100 (iterate (fn [x] x) "hello"))))
