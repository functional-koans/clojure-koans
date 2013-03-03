(meditations
  "Lists can be expressed by function or a quoted form"
  (= '(1 2 3 4 5) (list 1 2 3 4 5))

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= 1 (first '(1 2 3 4 5)))

  "As well as the rest"
  (= [2 3 4 5] (rest '(1 2 3 4 5)))

  "The rest when nothing is left is empty"
  (= [] (rest '(100)))

  "And construction by adding an element to the front is simple"
  (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e)))

  "Conjoining an element to a list can be done in the reverse order"
  (= '(0 :a :b :c :d :e) (conj '(:a :b :c :d :e) 0))

  "You can use a list like a stack to get the first element"
  (= :a (peek '(:a :b :c :d :e)))

  "Or the others"
  (= '(:b :c :d :e) (pop '(:a :b :c :d :e)))

  "But watch out if you try to pop nothing"
  (= "No dice!" (try
          (pop '())
          (catch IllegalStateException e "No dice!")))

  "The rest of nothing isn't so strict"
  (= () (try
          (rest '())
          (catch IllegalStateException e "No dice!"))))
