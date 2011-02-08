(defmacro hello [x]
  (str "Hello, " x))

(defmacro infix [form]
  (list (second form) (first form) (nth form 2)))

(defmacro infix-better [form]
  `(~(second form)
    __
    __ ))

(defmacro r-infix [form]
  (list (second form)
        (if (instance? clojure.lang.PersistentList (first form))
            `(r-infix ~(first form))
            (first form))
        (if (instance? clojure.lang.PersistentList (nth form 2))
            `(r-infix ~(nth form 2))
            (nth form 2))
        ))


(meditations
 "Macros are like functions created at compile time"
 (= __ (hello "Macros!"))

 "Can I haz some infix?"
 (= __ (infix (9 + 1)))

 "Remember, these are nothing but code transformations"
 (= __ (macroexpand '(infix (9 + 1))))

 "You can do better than that, hand crafting ftw!"
 (= __ (macroexpand '(infix-better (10 * 2))))

 "Things dont always work as you would like them to... "
 (= __ (macroexpand '(infix-better ( 10 + (2 * 3)))))

 "Really, you dont understand recursion until you understand recursion"
 (= __ (r-infix (10 + (2 * 3)))))

