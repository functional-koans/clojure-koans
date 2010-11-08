(meditations
  "Destructuring is an arbiter: it breaks up arguments"
  (= __ ((fn [[a b]] (str b a))
           [:foo :bar]))

  "Whether in function definitions"
  (= "First comes love, then comes marriage, then comes Clojure with the baby carriage"
     ((fn [[a b c]] __)
       ["love" "marriage" "Clojure"]))

)
