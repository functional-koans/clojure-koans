(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
        :ten-mph      :pretty-fast
        :watching-tv  :not-so-fast))



  ; "You will face many decisions"
  (= :a (if (false? (= 4 5))
          :a
          :b))

  ; "Some of them leave you no alternative"
  (= [] (if (> 4 3) ;; J - This is the equivalent of an if statement without an else.
          []))      ;; returns nil if false as seen below.

  ; "And in such a situation you may have nothing"
  (= nil (if (nil? 0)
          [:a :b :c]))

  ; "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
              :doom
              :glory))

  ; "You may have a multitude of possible paths"
  (let [x 5]
    (= :your-road (cond (= x 3) :road-not-taken
                        (= x 2) :another-road-not-taken
                        :else :your-road)))  ;; J - The syntax and formatting of this statement
                                             ;; are crucial in writing these statements correctly.

  ; "Or your fate may be sealed"
  (= 'doom (if-not (zero? 1)
          'doom
          'more-doom))

  ; "In case of emergency, go fast"
  (= :pretty-fast
     (explain-exercise-velocity :ten-mph))

  ; "But admit it when you don't know what to do"
  (= :not-so-fast
     (explain-exercise-velocity :watching-tv))
