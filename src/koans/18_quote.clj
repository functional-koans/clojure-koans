(ns koans.18-quote
  (:require [koan-engine.core :refer :all]))


(meditations
  "Wrap a quote around a list to suppress evaluation"
  (= (quote (1 2 3 4 5)) '(1 2 3 4 5))

  "There is a shortcut too!"
  (= (quote (1 2 3 4 5)) '(1 2 3 4 5))

  "You can quote symbols as well as lists... without evaluation!"
  (= 'age (let [age 9] (quote age)))

  "You can use a literal list as a data collection without having Clojure try to call a function"
  (= (cons 1 (quote (2 3))) (list 1 2 3) (cons 1 [2 3]))

  "The quote affects all of its arguments, not just the top level"
  (= (list 1 '(+ 2 3)) '(1 (+ 2 3)))

  "Syntax-quote (`) acts similarly to the normal quote"
  (= (list 1 2 3) `(1 2 3) '(1 2 3))

  "Unquote (~) within a syntax-quoted expression lets you mark specific expressions as requiring evaluation"
  (= (list 1 5) `(1 ~(+ 2 3)) '(1 5)))
