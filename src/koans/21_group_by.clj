(ns koans.21-group-by
  (:require [koan-engine.core :refer :all]))

(defn get-odds-and-evens [coll]
  (let [{odds true evens false} (group-by __ coll)]
    [odds evens]))

(meditations

  "To categorize a collection by some function, use group-by."
  (= __ (group-by count ["hello" "world" "foo" "bar"]))


  "You can simulate filter + remove in one pass"
  (= (get-odds-and-evens [1 2 3 4 5])
     ((juxt filter remove) odd? [1 2 3 4 5])
     [[1 3 5] [2 4]])

  "You can also group by a primary key"
  (= __
     (group-by :id [{:id 1 :name "Bob"}
                    {:id 2 :name "Jennifer"}
                    {:id 1 :last-name "Smith"} ]))

  "But be careful when you group by non-required key"
  (= {"Bob" [{:name "Bob" :id 1}]
      "Jennifer" [{:name "Jennifer" :id 2}]
      __ [{:last-name "Smith" :id 1}]}
   (group-by :name [{:id 1 :name "Bob"}
                    {:id 2 :name "Jennifer"}
                    {:id 1 :last-name "Smith"}]))

  "The true power of group-by comes with custom functions"
  (= __
     (group-by #(if (:bad %) :naughty-list :nice-list)
               [{:name "Jimmy" :bad true}
                {:name "Anna" :bad false}
                {:name "Joe" :bad true}])))
