(meditations
  "Lists can be expressed by function or a quoted form"
  (= '(__ __ __ __ __) (list 1 2 3 4 5))

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= __ (first '(1 2 3 4 5)))

  "As well as the rest"
  (= __ (rest '(1 2 3 4 5)))

  "The rest when nothing is left is empty"
  (= __ (rest '(100)))

  "And construction by adding an element to the front is simple"
  (= __ (cons :a '(:b :c :d :e)))

  "Conjoining an element to a list can be done in the reverse order"
  (= __ (conj '(:a :b :c :d :e) 0))

  "You can use a list like a stack to get the first element"
  (= __ (peek '(:a :b :c :d :e)))

  "Or the others"
  (= __ (pop '(:a :b :c :d :e)))

  "But watch out if you try to pop nothing"
  (= __ (try
          (pop '())
          (catch IllegalStateException e "No dice!")))

  "The rest of nothing isn't so strict"
  (= __ (try
          (rest '())
          (catch IllegalStateException e "No dice!"))))
