(def __ nil)

(defn test-creating-vectors []
  (let [empty-vector (vec nil)]
    (assert (= clojure.lang.PersistentVector (class empty-vector)))
    (assert (= __ (.size empty-vector)))))

(defn test-vector-literals []
  (let [vector (vec nil)]
    (assert (= [] vector)))
  (let [vector (vec '(1))]
    (assert (= [1] vector)))
  (let [vector (vec '(1 2))]
    (assert (= [1 __] vector)))
  (let [vector (vec nil)]
    (assert (= __ (conj vector 333)))))

(defn test-accessing-vector-elements []
  (let [vector [:peanut, :butter, :and, :jelly]]
    (assert (= __ (nth vector 0)))
    (assert (= __ (first vector)))
    (assert (= __ (nth vector 3)))
    (assert (= __ (last vector)))))

(defn test-vectors-and-ranges []
  (assert (not (= [1 2 3 4 5] (range 1 5))))
  (assert (= [1 2 3 4] (range 1 5)))
  (assert (= __ (range 5 10))))