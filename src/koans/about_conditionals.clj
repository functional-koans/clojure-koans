(meditations
  "Your will face many decisions"
  (= __ (if (false? (= 4 5)) :a :b))

  "Some of them leave you no alternative"
  (= __ (if (> 4 3) []))

  "And in such a case you may have nothing"
  (= nil (if (nil? __) [:a :b :c])))

