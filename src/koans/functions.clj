(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations
  "Functions are often defined before they are used"
  (= __ (multiply-by-ten 2))

  "But they can also be defined inline"
  (= __ ((fn [n] (* __ n)) 2))

  "Or using even shorter syntax"
  (= __ (#(* 15 %) __))

  "Short anonymous functions may take multiple arguments"
  (= __ (#(+ %1 %2 %3) 4 5 6))

  "One function can beget another"
  (= __ ((fn []
           ((fn [a b] (__ a b))
            4 5))))

  "Higher-order functions take function arguments"
  (= 25 (___
         (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 (___ square)))
