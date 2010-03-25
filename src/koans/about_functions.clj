(defn count-items [& items]
  (count items))

(meditations
  "Functions are often defined before they are used"
  (= __ (count-items :a :b :c :d))

  "But they can also be defined inline"
  (= __ ((fn [n] (Math/pow n 10)) 2))

  "Or using even shorter syntax"
  (= __ (#(Math/pow % 10)))

  "Functions can beget others"
  (= __ (((fn []
            (fn [a b] (+ a b))))
          4 5))

  "Higher-order functions take function arguments"
  (= 25 ((fn [f] (f 5))
          (fn [n] (__ __ __)))))
