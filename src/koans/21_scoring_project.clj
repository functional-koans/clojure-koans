; Greed is a dice game where you roll up to five dice to accumulate
; points.  The following "score" function will be used calculate the
; score of a single roll of the dice.
;
; A greed roll is scored as follows:
;
; * A set of three ones is 1000 points
;
; * A set of three numbers (other than ones) is worth 100 times the
;   number. (e.g. three fives is 500 points).
;
; * A one (that is not part of a set of three) is worth 100 points.
;
; * A five (that is not part of a set of three) is worth 50 points.
;
; * Everything else is worth 0 points.
;
;
; Examples:
;
; (score [1 1 1 5 1]) => 1150 points
; (score [2 3 4 6 2]) => 0 points
; (score [3 4 5 3 3]) => 350 points
; (score [1 5 1 2 4]) => 250 points
;
; More scoring examples are given in the tests below:
;
; Your goal is to write the score method.
;
; It's important to write this method in functional programming
; style, which is using high-level function instead of using
; function that has side-effect.

(defn score [dic]
  __)

(meditations
  "score of an empty list is zero"
  (= 0 (score []))

  "score of a single roll of 5 is 50"
  (= 50 (score [5]))

  "score of a single roll of 1 is 100"
  (= 100 (score [1]))

  "score of multiple 1s and 5s is the sum of individual scores"
  (= 300 (score [1 5 5 1]))

  "score of single 2s 3s 4s and 6s are zero"
  (= 0 (score [2 3 4 6]))

  "score of a triple 1 is 1000"
  (= 1000 (score [1 1 1]))

  "score of other triples is 100x"
  (and
    (= 200 (score [2 2 2]))
    (= 300 (score [3 3 3]))
    (= 400 (score [4 4 4]))
    (= 500 (score [5 5 5]))
    (= 600 (score [6 6 6])))

  "score of mixed is sum"
  (and
    (= 250 (score [2 5 2 2 3]))
    (= 550 (score [5 5 5 5]))
    (= 1150 (score [1 1 1 5 1])))

  "ones not left out"
  (and
    (= 300 (score [1 2 2 2]))
    (= 350 (score [1 5 2 2 2]))))
