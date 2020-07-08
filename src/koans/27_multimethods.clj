(ns koans.27-multimethods
  (:require [koan-engine.core :refer :all]))

(defmulti multimethod-without-args
 (fn [keyword-arg] keyword-arg))

(defmethod multimethod-without-args :first [_]
 (str "Hello, World!"))

(defmethod multimethod-without-args :second [_]
 (str "Hello there"))

(defmulti multimethod-with-args
 (fn [opt-one opt-two] opt-one))

(defmethod multimethod-with-args :path-one [_ opts]
 (:first-opt opts))

(defmethod multimethod-with-args :path-two [_ opts]
 (let [numbers (:second-opt opts)]
  (->> numbers
       (map inc)
       (reduce +))))

(defmethod multimethod-with-args :path-three [_])

(meditations
 "A multimethod takes one or more arguments to dispatch on"
 (= __
    (multimethod-without-args :first))

 "Though it can be ignored and represented by _ in defmethods"
 (= __
    (multimethod-without-args :second))

 "Alternatively, we can use the arguments in defmethods"
 (= __
    (multimethod-with-args :path-one {:first-opt 1
                                      :second-opt 2}))
 
 "This allows us to do something different in each method implementation"
 (= __
    (multimethod-with-args :path-two {:first-opt 1
                                      :second-opt [0 1 2]})))
