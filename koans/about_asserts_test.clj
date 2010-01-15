(ns about-asserts-test
  (:use clojure.test))

(deftest test-truth
  (testing "We shall contemplate truth by testing reality, via asserts."
    (assert false))) ;; This should be true

(deftest test-assert-equality
  (testing "To understand reality, we must compare our expectations against reality."
    (let [expected-value 0
          actual-value (+ 1 1)]
      (is (= expected-value actual-value)))))