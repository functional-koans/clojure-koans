(defn test-truth
  #^{:zen "We shall contemplate truth by testing reality, via asserts."}
  []
  (assert false)) ;; This should be true

(defn test-assert-equality
  #^{:zen "To understand reality, we must compare our expectations against reality."}
  []
  (let [expected-value 0
        actual-value (+ 1 1)]
    (assert (= expected-value actual-value))))
