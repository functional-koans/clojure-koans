(meditations
  "You will face many decisions"
  (= __ (if (false? (= 4 5))
            :a
            :b))

  "Some of them leave you no alternative"
  (= __ (if (> 4 3)
            []))

  "And in such a case you may have nothing"
  (= nil (if (nil? __)
             [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
                :doom
                __))

  "Or your fate may be sealed"
  (= __ (if-not (zero? __)
                'doom
                'doom)))

