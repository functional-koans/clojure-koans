(ns koans.06-maps
  (:require [koan-engine.core :refer :all]))

(meditations
  "Don't get lost when creating a map"
  (= {:a 1 :b 2} (hash-map :a 1 __ __))

  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a __))

  "The size is the number of entries"
  (= __ (count {:a 1 :b 2}))

  "You can look up the value for a given key"
  (= __ (get {:a 1 :b 2} :b))

  "Maps can be used as functions to do lookups"
  (= __ ({:a 1 :b 2} :a))

  "And so can keywords"
  (= __ (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= __ ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

  "You may not be able to find an entry for a key"
  (= __ (get {:a 1 :b 2} :c))

  "But you can provide your own default"
  (= __ (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= __ (contains? {:a nil :b nil} :b))

  "Or if it is missing"
  (= __ (contains? {:a nil :b nil} :c))

  "Maps are immutable, but you can create a new and improved version"
  (= {1 "January" 2 __} (assoc {1 "January"} 2 "February"))

  "You can also create a new version with an entry removed"
  (= {__ __} (dissoc {1 "January" 2 "February"} 2))

  "Often you will need to get the keys, but the order is undependable"
  (= (list __ __ __)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

  "You can get the values in a similar way"
  (= (list __ __ __)
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"}))))
