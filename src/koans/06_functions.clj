(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations
  "Functions are often defined before they are used"
  (= 20 (multiply-by-ten 2))

  "But they can also be defined inline"
  (= 20 ((fn [n] (* 10 n)) 2))

  "Or using even shorter syntax"
  (= 20 (#(* 10 %) 2))

  "Short anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  "One function can beget another"
  (= 9 ((fn []
           ((fn [a b] (+ a b))
            4 5))))

  "Higher-order functions take function arguments"
  (= 25 ((fn [func] (func 5))
         (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 ((defn square5 [square] (square 5)) square)))
