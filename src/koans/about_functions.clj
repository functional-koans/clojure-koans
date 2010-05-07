(defn raise-to-the-tenth-power [n]
  (Math/pow n 10))

(meditations
  "Functions are often defined before they are used"
  (= __ (raise-to-the-tenth-power 2))

  "But they can also be defined inline"
  (= __ ((fn [n] (Math/pow n __)) 2))

  "Or using even shorter syntax"
  (= __ (#(Math/pow % 10) __))

  "One function can beget another"
  (= __ (((fn []
            (fn [a b] __ a b)))
          4 5))

  "Higher-order functions take function arguments"
  (= 25 (___
          (fn [n] (* n n)))))
