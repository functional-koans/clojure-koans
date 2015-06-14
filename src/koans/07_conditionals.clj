(ns koans.07-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :defcon-five        :blue
        :defcon-four        :green
        :defcon-three       :yellow
        :defcon-two         :red
        :defcon-one         :white
        :say-what?))

(meditations
  "You will face many decisions"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  "Some of them leave you no alternative"
  (= __ (if (> 4 3)
          []))

  "And in such a situation you may have nothing"
  (= __ (if (nil? 0)
          [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
              :doom
              __))

  "You may have a multitude of possible paths"
  (let [x 5]
    (= :your-road (cond (= x __) :road-not-taken
                        (= x __) :another-road-not-taken
                        :else __)))

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? __)
          'doom
          'more-doom))

  "In case of emergency, sound the alarms"
  (= :white
     (explain-defcon-level __))

  "But admit it when you don't know what to do"
  (= __
     (explain-defcon-level :defcon-seven)))
