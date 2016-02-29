
  ; "Don't get lost when creating a map"
  (= {:a 1 :b 2} (hash-map :a 1 :b 2)) ;; J - Hash maps are key-value pairs defined as a linear
                                       ;; sequence. {key value key2 value2} etc.
  ; "A value must be supplied for each key"
  (= {:a 1} (hash-map :a 1))

  ; "The size is the number of entries"
  (= 2 (count {:a 1 :b 2}))

  ; "You can look up the value for a given key"
  (= 2 (get {:a 1 :b 2} :b))

  ; "Maps can be used as functions to do lookups"
  (= 1 ({:a 1 :b 2} :a)) ;; J - This is a bit confusing, but it essentially amounts to a keyword placed
                         ;; on either side of a hash-map returning the key-word's matching value, the difference
                         ;; being that the left object is called as a function on the right.

  ; "And so can keywords"
  (= 1 (:a {:a 1 :b 2}))

  ; "But map keys need not be keywords"
  (= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

  ; "You may not be able to find an entry for a key"
  (= nil (get {:a 1 :b 2} :c)) ;; J - This caused a considerable delay in the REPL.

  ; "But you can provide your own default"
  (= :key-not-found (get {:a 1 :b 2} :c :key-not-found)) ;; J - The third argument for get is the default.

  ; "You can find out if a key is present"
  (= true (contains? {:a nil :b nil} :b))

  ; "Or if it is missing"
  (= false (contains? {:a nil :b nil} :c))

  ; "Maps are immutable, but you can create a new and improved version"
  (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))

  ; "You can also create a new version with an entry removed"
  (= {1 "January"} (dissoc {1 "January" 2 "February"} 2)) ;; J - This can take any number of keys to dissociate.

  ; "Often you will need to get the keys, but the order is undependable"
  (= (list 2010 2014 2018)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"}))) ;; J - If you don't sort these, they are
                                                                        ;; essentially returned in random order.
  ; "You can get the values in a similar way"
  (= (list "PyeongChang" "Vancouver" "PyeongChang")
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"}))) ;; J - Sorts numerically or alphabetically
