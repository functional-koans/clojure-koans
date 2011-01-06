(defn is-even? [n]
  (if (= n 0) __
      (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n acc true]
    (if (= n 0) __
        (recur (dec n) (not acc)))))

(defn factorial [n]
  __)

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? (bigint 100003)))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (= (factorial (bigint 1000)) (factorial (bigint 1000)))

  "But what happens when the machine limits you?"
  (= (factorial (bigint 10000)) (factorial (bigint 10000))))
