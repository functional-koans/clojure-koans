(ns koans.08-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
        :bicycling        "pretty fast"
        :jogging          "not super fast"
        :walking          "not fast at all"
        "is that even exercise?"))

(meditations
  "You will face many decisions"
  (= :a (if (false? (= 4 5))
          :a
          :b))

  "Some of them leave you no alternative"
  (= [] (if (> 4 3)
          []))

  "And in such a situation you may have nothing"
  (= nil (if (nil? 0)
          [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
              :doom
              :glory))

  "You may have a multitude of possible paths"
  (let [x 5]
    (= :your-road (cond (= x 1) :road-not-taken
                        (= x 2) :another-road-not-taken
                        :else :your-road)))

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? 1)
          'doom
          'more-doom))

  "In case of emergency, go fast"
  (= "pretty fast"
     (explain-exercise-velocity :bicycling))

  "But admit it when you don't know what to do"
  (= "is that even exercise?"
     (explain-exercise-velocity :watching-tv)))
