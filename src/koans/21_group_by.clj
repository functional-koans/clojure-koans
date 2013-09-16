(defn get-odds-and-evens [coll]
  (let [{odds true evens false} (group-by __ coll)]
    [odds evens]))

(meditations

  "To split a collection categorized by keys use the group-by function."
  (= __ (group-by count ["hello" "world" "foo" "bar"]))


  "Sometimes you want to filter a sequence but also keep the predicate."
  (= (get-odds-and-evens '(1 2 3 4 5))
    [[1 3 5] [2 4]])

  "You can also group by a primary key"
  (= __
     (group-by :id [{:id 1 :name "Bob"}
                   {:id 2 :name "Mike"}
                   {:id 1 :last-name "Smith"} ]))

  "but be careful when you group by non primary key"
  (= {"Bob" [{:name "Bob" :id 1}], "Mike" [{:name "Mike" :id 2}], __ [{:last-name "Smith" :id 1}]}
   (group-by :name [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"}]))

  "The true power of group-by is using a custom function"
  (= __
     (group-by #(if (:bad %) :nauty-list :nice-list)
               [{:name "Jimmy" :bad true}
                {:name "Jack" :bad false}
                {:name "Joe" :bad true}])))
