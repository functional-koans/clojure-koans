(defn #^{:zen "We shall contemplate truth by testing reality, via asserts."}
  test-truth
  []
  (assert false)) ;; This should be true

(defn #^{:zen "To understand reality, we must compare our expectations against reality."}
  test-assert-equality
  []
  (let [expected-value 0
        actual-value (+ 1 1)]
    (assert (= expected-value actual-value))))
