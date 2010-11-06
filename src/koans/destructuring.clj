(meditations
  "Destructuring allows you to break up arguments"
  (= __ ((fn [[a b]] (str b a))
           [:foo :bar])))
