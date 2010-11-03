(defn factorial [n]
  __)

(meditations
  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (= (factorial 1000N) (factorial 1000N))

  "But what happens when the machine limits you?"
  (= (factorial 10000N) (factorial 10000N)))
