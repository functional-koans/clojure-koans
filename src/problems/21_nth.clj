(ns problems.21-nth)

(defn get-nth [n i]
  (loop [[head & tail] n index i]
    (if (= index 0)
      head
      (recur tail (dec index)))))

(= (get-nth '(4 5 6 7) 2) 6)

(= (get-nth [:a :b :c] 0) :a)

(= (get-nth [1 2 3 4] 1) 2)

(= (get-nth '([1 2] [3 4] [5 6]) 2) [5 6])