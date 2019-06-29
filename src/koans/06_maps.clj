(ns koans.06-maps
  (:require [koan-engine.core :refer :all]))

(meditations
  "Don't get lost when creating a map"
  (= {:a 1 :b 2} (hash-map :a 1 :b 2))

  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a 1))

  "The size is the number of entries"
  (= 2 (count {:a 1 :b 2}))

  "You can look up the value for a given key"
  (= 2 (get {:a 1 :b 2} :b))

  "Maps can be used as functions to do lookups"
  (= 1 ({:a 1 :b 2} :a))

  "And so can keywords"
  (= 1 (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

  "You may not be able to find an entry for a key"
  (= nil (get {:a 1 :b 2} :c))

  "But you can provide your own default"
  (= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= true (contains? {:a nil :b nil} :b))

  "Or if it is missing"
  (= false (contains? {:a nil :b nil} :c))

  "Maps are immutable, but you can create a new and improved version"
  (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))

  "You can also create a new version with an entry removed"
  (= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

  "Create a new map by merging"
  (= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3}))

  "Specify how to handle entries with same keys when merging"
  (= {:a 1 :b 2 :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))

  "Often you will need to get the keys, but the order is undependable"
  (= (list 2010 2014 2018)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

  "You can get the values in a similar way"
  (= (list "PyeongChang" "Sochi" "Vancouver")
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))

  "You can even iterate over the map entries as a seq"
  (= {:a 2 :b 3}
     (into {}
           (map
            (fn [[k v]] [k (inc v)])
            {:a 1 :b 2}))))
