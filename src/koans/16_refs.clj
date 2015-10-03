(ns koans.16-refs
  (:require [koan-engine.core :refer :all]))

(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  "In the beginning, there was a word"
  (= __ (deref the-world))

  "You can get the word more succinctly, but it's the same"
  (= __ @the-world)

  "You can be the change you wish to see in the world."
  (= __ (do
          (dosync (ref-set the-world "better"))
          @the-world))

  "Alter where you need not replace"
  (= __ (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world))

  "Don't forget to do your work in a transaction!"
  (= 0 (do __
           @the-world))

  "Functions passed to alter may depend on the data in the ref"
  (= 20 (do
          (dosync (alter the-world ___))))

  "Two worlds are better than one"
  (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          __))))
