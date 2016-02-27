
  ; "Lists can be expressed by function or a quoted form"
  (= '(1 2 3 4 5) (list 1 2 3 4 5))

  ; "They are Clojure seqs (sequences), so they allow access to the first"
  (= 1 (first '(1 2 3 4 5)))

  ; "As well as the rest"
  (= 2 3 4 5 (rest '(1 2 3 4 5))) ;; J -

  ; "Count your blessings"
  (= 3 (count '(dracula dooku chocula)))

  ; "Before they are gone"
  (= 0 (count '()))

  ; "The rest, when nothing is left, is empty"
  (=  (rest '(100))) ;; J - returns nothing.

  ; "Construction by adding an element to the front is easy"
  (= :a :b :c :d :e (cons :a '(:b :c :d :e))) ;; J - cons add's the element on the left to the beginning
                                              ;; of the list on the right and returns a seq.
                                              ;;(EX: (cons [1 2] '(3 4 5)) => '([1 2] 3 4 5)

  ; "Conjoining an element to a list isn't hard either"
  (= :a :b :c :d :e (conj '(:a :b :c :d) :e))
                                  ;; J - conj works like cons, but takes any number of arguments from
                                  ;; the right and adds them to the beginning of the list on the left
                                  ;; returning them in the structure of whatever the list on the left is defined
                                  ;; as originally. (EX: (conj [4 5 6] 1 2 3) => [1 2 3 4 5 6]

  ; "You can use a list like a stack to get the first element"
  (= :a (peek '(:a :b :c :d :e))) ;; J - returns the first element

  ; "Or the others"
  (= (:b) (pop '(:a :b :c :d :e))) ;; J - pops the first element and returns the others as a seq

  ; "But watch out if you try to pop nothing"
  (=  (try ;; J - Catch raises an error similar to 'raise' in Ruby.
          (pop '())
          (catch IllegalStateException e
            "No dice!")))

  ; "The rest of nothing isn't so strict"
  (= () (try
          (rest '())
          (catch IllegalStateException e
            "No dice!")))
