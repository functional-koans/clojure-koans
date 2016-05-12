(ns koans.24-quote
  (:require [koan-engine.core :refer :all]))


(meditations
  "Wrap a quote around a list to suppress evaluation"
  (= (quote (1 2 3 4 5)) __)

  "There is a shortcut too!"
  (= (quote __) '(1 2 3 4 5))

  "You can quote symbols as well as lists... without evaluation!"
  (= __ (let [age 9] (quote age)))

  "You can use a literal list as a data collection without having Clojure try to call a function"
  (= (cons 1 (__ (2 3))) (list 1 2 3) (cons 1 [2 3]))

  "The quote affects all of its arguments, not just the top level"
  (= (list 1 __) '(1 (+ 2 3)))

  "Syntax-quote (`) acts similarly to the normal quote"
  (= (list __ __ __) `(1 2 3) '(1 2 3))

  "Unquote (~) within a syntax-quoted expression lets you mark specific expressions as requiring evaluation"
  (= (list __ __) `(1 ~(+ 2 3)) '(1 5)))
