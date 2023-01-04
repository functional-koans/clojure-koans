(ns koans.25-threading-macros
  (:require [koan-engine.core :refer :all]))

(def a-list
  '(1 2 3 4 5))

(def a-list-with-maps
  '({:a 1} {:a 2} {:a 3}))

(defn function-that-takes-a-map [map a b]
  (get map :a))

(defn function-that-takes-a-coll [a b coll]
  (map :a coll))

(meditations
 "We can use thread first for more readable sequential operations"
 (= {:a 1}
    (-> {}
        (assoc :a 1)))

 "Consider also the case of strings"
 (= "Hello world, and moon, and stars"
    (-> "Hello world"
        (str ", and moon")
        (str ", and stars")))

 "When a function has no arguments to partially apply, just reference it"
 (= "String with a trailing space"
    (-> "String with a trailing space "
        clojure.string/trim))

 "Most operations that take a scalar value as an argument can be threaded-first"
 (= 6
    (-> {}
        (assoc :a 1)
        (assoc :b 2)
        (assoc :c {:d 4
                   :e 5})
        (update-in [:c :e] inc)
        (get-in [:c :e])))

 "We can use functions we have written ourselves that follow this pattern"
 (= 1
  (-> {}
      (assoc :a 1)
      (function-that-takes-a-map "hello" "there")))

 "We can also thread last using ->>"
 (= '(2 3 4)
    (->> [1 2 3]
         (map inc)))

 "Most operations that take a collection can be threaded-last"
 (= 12
    (->> a-list
         (map inc)
         (filter even?)
         (into [])
         (reduce +)))

 "We can use functions we have written ourselves that follow this pattern"
 (= [1 2 3]
    (->> a-list-with-maps
         (function-that-takes-a-coll "hello" "there")
         (into [])
         )))
