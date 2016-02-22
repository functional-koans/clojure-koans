(ns koans.24-quote
  (:require [koan-engine.core :refer :all]))


(meditations
  "use quote to express a list"
  (= (quote __) (list 1 2 3 4 5))

  "Clojure provide a shotcut"
  (= (quote __)  '(1 2 3 4 5))
  
  "The quote special operator prevents its argument from being evaluated at all"
  (= __ (let [age 9] (quote age)))

  "You can use a literal list as a data collection without having Clojure try to call a function"
  (= (cons 1 (__ (2 3))) (list 1 2 3) (cons 1 [2 3]))

  "Th quote affects all of its argument, not just the top level"
  (= (list 1 __) '(1 (+ 2 3)))

  "Syntax-quote has a few extra features that make it ideal for constructing collections to be used as code."
  (= (list __ __ __) `(1 2 3) '(1 2 3))

  "Unquote is used to demarcate specific forms as requiring evaluation by prefixing fhem with the symbol ~ within the body of a syntax-quote"
  (= (list __ __) `(1 ~(+ 2 3)) '(1 5))
  )
