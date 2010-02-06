(meditations
 "You can use vectors in clojure to create an 'Array' like structure"
 (= __ (.size (vec nil)))

 "You can create a vector in two ways"
 (= [] (vec nil))

 "And populate it in either of these ways"
 (= [1] (vec '(1)))
 
 "But you can populate it with any number of elements at once"
 (= [1 __] (vec '(1 2)))
 
 "And add to it as well"
 (= __ (conj (vec nil) 333))

 "You can get the first element of a vector like so"
 (= :peanut (first [:peanut :butter :and :jelly]))

 "And the last in a similar fashion"
 (= __ (last [:peanut :butter :and :jelly]))

 "Or any index if you wish"
 (= __ (nth [:peanut :butter :and :jelly] 3))

 "You can also slice a vector"
 (= __ (subvec [:peanut :butter :and :jelly] 1 3)))