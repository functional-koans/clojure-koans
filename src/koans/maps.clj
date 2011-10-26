(meditations
  "There are two ways to create maps"
  (= __ (hash-map))

  "Maps in clojure associate keys with values"
  (= __ (count (hash-map)))

  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a __))

  "The size is the number of entries"
  (= __ (count {:a 1 :b 2}))

  "You can look up the value for a given key"
  (= __ (get {:a 1 :b 2} :b))

  "Maps can be used as lookup functions"
  (= __ ({:a 1 :b 2} :a))

  "And so can keywords"
  (= __ (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= __ ({2006 "Torino" 2010 "Vancouver" 2014 "Sochi"} 2010))

  "You may not be able to find an entry for a key"
  (= __ (get {:a 1 :b 2} :c))

  "But you can provide your own default"
  (= __ (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= __ (contains? {:a nil :b nil} :b))

  "Or if it is missing"
  (= __ (contains? {:a nil :b nil} :c))

  "Maps are immutable, but you can create a new, 'changed' version"
  (= {1 "January" 2 __} (assoc {1 "January" } 2 "February"))

  "You can also 'remove' an entry"
  (= {__ __} (dissoc {1 "January" 2 "February"} 2))

  "Often you will need to get the keys (which will be in hash order)"
  (= (list __ __ __)
     (sort (keys {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"})))

  "Or the values"
  (= (list "Sochi" "Torino" __)
     (sort (vals {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"}))))
