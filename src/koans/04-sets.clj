(meditations
  "You can create a set in two ways"
  (= #{} (set __))

  "They are another important data structure in clojure"
  (= __ (count #{1 2 3}))

  "Remember that a set is a 'set'"
  (= __ (set '(1 1 2 2 3 3 4 4 5 5)))

  "You can ask clojure for the union of two sets"
  (= __ (clojure.set/union #{1 2 3 4} #{2 3 5}))

  "And also the intersection"
  (= __ (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  "But don't forget about the difference"
  (= __ (clojure.set/difference #{1 2 3 4 5} #{2 3 5})))
