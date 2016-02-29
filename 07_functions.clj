
  ; "Calling a function is like giving it a hug with parentheses"
  (= (square 9))

  ; "Functions are usually defined before they are used"
  (=  (multiply-by-ten 2))

  ; "But they can also be defined inline"
  (= 10 ((fn [n] (* 5 n)) 2))

  ; "Or using an even shorter syntax"
  (= 60 (#(* 15 %) 4)) ;; J - This is an important bit of sugar to memorize.
                       ;; To make it easy, '#' initiates the declaration of an anonymous function
                       ;; and % is the argument. So, in this case, # replaces 'fn [n]' and '%' replaces n

  ; "Even anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  ; "Arguments can also be skipped"
  (= 30 (#(* 15 %2) 1 2))

  ; "One function can beget another"
  (= 9 ((fn [] ((fn [a b] (+ a b)) 4 5))))

  ; "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5))
           *)) ;; J - Mathematical operators in Clojure serve as functions.

  ; "Higher-order functions take function arguments"
  (= 25 (#(% 5)
          (fn [n] (* n n))))

  ; "But they are often better written using the names of functions"
  (= 25 (defn square [n] (* n n)))
