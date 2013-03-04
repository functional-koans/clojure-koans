(meditations
  "There are two ways to create maps"
  (= {} (hash-map))

  "Maps in clojure associate keys with values"
  (= 0 (count (hash-map)))

  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a 1))

  "The size is the number of entries"
  (= 2 (count {:a 1 :b 2}))

  "You can look up the value for a given key"
  (= 2 (get {:a 1 :b 2} :b))

  "Maps can be used as lookup functions"
  (= 1 ({:a 1 :b 2} :a))

  "And so can keywords"
  (= 1 (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= "Vancouver" ({2006 "Torino" 2010 "Vancouver" 2014 "Sochi"} 2010))

  "You may not be able to find an entry for a key"
  (= nil (get {:a 1 :b 2} :c))

  "But you can provide your own default"
  (= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= true (contains? {:a nil :b nil} :b))

  "Or if it is missing"
  (= false (contains? {:a nil :b nil} :c))

  "Maps are immutable, but you can create a new, 'changed' version"
  (= {1 "January" 2 "February"} (assoc {1 "January" } 2 "February"))

  "You can also 'remove' an entry"
  (= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

  "Often you will need to get the keys (which will be in hash order)"
  (= (list 2006 2010 2014)
     (sort (keys {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"})))

  "Or the values"
  (= (list "Sochi" "Torino" "Vancouver")
     (sort (vals {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"}))))
