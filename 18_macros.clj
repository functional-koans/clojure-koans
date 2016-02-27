(ns koans.18-macros
  (:require [koan-engine.core :refer :all]))

(defmacro hello [x]
  (str "Hello, " x))

(defmacro infix [form]
  (list (second form) (first form) (nth form 2)))

(defmacro infix-better [form]
  `(~(second form) ; Note the syntax-quote (`) and unquote (~) characters!
    __
    __ ))

(defmacro r-infix [form]
  (cond (not (seq? form))
        __
        (= 1 (count form))
        `(r-infix ~(first form))
        :else
        (let [operator (second form)
              first-arg (first form)
              others __]
          `(~operator
            (r-infix ~first-arg)
            (r-infix ~others)))))

(meditations
  "Macros are like functions created at compile time"
  (= __ (hello "Macros!"))

  "I can haz infix?"
  (= __ (infix (9 + 1)))

  "Remember, these are nothing but code transformations"
  (= __ (macroexpand '(infix (9 + 1))))

  "You can do better than that - hand crafting FTW!"
  (= __ (macroexpand '(infix-better (10 * 2))))

  "Things don't always work as you would like them to... "
  (= __ (macroexpand '(infix-better ( 10 + (2 * 3)))))

  "Really, you don't understand recursion until you understand recursion"
  (= 36 (r-infix (10 + (2 * 3) + (4 * 5)))))
