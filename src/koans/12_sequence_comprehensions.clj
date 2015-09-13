(ns koans.12-sequence-comprehensions
  (:require [koan-engine.core :refer :all]))

(meditations
  "Sequence comprehensions can bind each element in turn to a symbol"
  (= __
     (for [x (range 6)]
       x))

  "They can easily emulate mapping"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x))
          (range 6))
     (for [x (range 6)]
       __))

  "And also filtering"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x __ :when (odd? x)]
       x))

  "Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x))
          (filter odd? (range 10)))
     (for [x (range 10) :when __]
       __))

  "More complex transformations simply take multiple binding forms"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       __)))
