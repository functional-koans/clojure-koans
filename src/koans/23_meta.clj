(ns koans.23-meta
  (:require [koan-engine.core :refer :all]))

(def giants
  (with-meta 'Giants
    {:league "National League"}))

(meditations
  "Some objects can be tagged using the with-meta function"
  (= {:league "National League"} (meta giants))

  "Or more succinctly with a reader macro"
  (= {:division "West"} (meta '^{:division "West"} Giants))

  "While others can't"
  (= "This doesn't implement the IObj interface" (try
          (with-meta
            2
            {:prime true})
          (catch ClassCastException e
            "This doesn't implement the IObj interface")))

  "Notice when metadata carries over"
  (= {:foo :bar} (meta (merge '^{:foo :bar} {:a 1 :b 2}
                     {:b 3 :c 4})))

  "And when it doesn't"
  (= nil (meta (merge {:a 1 :b 2}
                     '^{:foo :bar} {:b 3 :c 4})))

  "Metadata can be used as a type hint to avoid reflection during runtime"
  (= \C (#(.charAt ^String % 0) "Cast me"))

  "You can directly update an object's metadata"
  (= 8 (let [giants
             (with-meta
               'Giants
               {:world-series-titles (atom 7)})]
         (swap! (:world-series-titles (meta giants)) inc)
         @(:world-series-titles (meta giants))))

  "You can also create a new object from another object with metadata"
  (= {:league "National League" :park "Oracle Park"}
     (meta (vary-meta giants
                      assoc :league "National League" :park "Oracle Park")))

  "But it won't affect behavior like equality"
  (= giants (vary-meta giants dissoc :league))

  "Or the object's printed representation"
  (= "Giants" (pr-str (vary-meta giants dissoc :league))))
