(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

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
    (= :your-road (cond (= x 2) :road-not-taken
                        (= x 3) :another-road-not-taken
                        :else :your-road)))

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? 1)
          'doom
          'doom))

  "In case of emergency, sound the alarms"
  (= :sirens
     (explain-defcon-level :cocked-pistol))

  "But admit it when you don't know what to do"
  (= :say-what?
     (explain-defcon-level :yo-mama)))
