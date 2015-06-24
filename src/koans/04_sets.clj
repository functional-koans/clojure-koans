(ns koans.04-sets
  (:require [koan-engine.core :refer :all]
            [clojure.set :as set]))

(meditations
  "You can create a set by converting another collection"
  (= #{3} (set __))

  "Counting them is like counting other collections"
  (= __ (count #{1 2 3}))

  "Remember that a set is a *mathematical* set"
  (= __ (set '(1 1 2 2 3 3 4 4 5 5)))

  "You can ask clojure for the union of two sets"
  (= __ (set/union #{1 2 3 4} #{2 3 5}))

  "And also the intersection"
  (= __ (set/intersection #{1 2 3 4} #{2 3 5}))

  "But don't forget about the difference"
  (= __ (set/difference #{1 2 3 4 5} #{2 3 5})))
