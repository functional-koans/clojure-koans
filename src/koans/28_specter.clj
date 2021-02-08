(ns koans.28-specter
  (:require [koan-engine.core :refer :all]
            [com.rpl.specter :as sr]
            [eidolon.core :as e]))

;; Imagine you own a car dealership and manage your inventory with a clojure map 
(def car-inventory
  {:cars {:ford {:focus [{:doors 2
                          :color "red"}
                         {:doors 2
                          :color "blue"}]
                 :expedition [{:doors 4
                               :color "red"}
                              {:doors 4
                               :color "black"}]}
          :toyota {:camry [{:doors 2
                            :color "red"}
                           {:doors 4
                            :color "tan"}]
                   :rav4  [{:doors 4
                            :color "blue"}
                           {:doors 4
                            :color "blue"}]}
          :latacara {:prime [{:doors 11
                              :color "clear"}]
                     :prime-zero [{:doors 0
                                   :color "red"}
                                  {:doors 0
                                   :color "green"}]}}})

(def car-inventory-ford-focus
  {:car {:ford {:focus [{:doors 2
                         :color "red"}
                        {:doors 2
                         :color "blue"}]}}})

;; The hope of this exercise is to get you more familiar with specter and eidolon

(meditations

 ;; Imagine you wanted to select the keys for all of the brands of cars you own
 ;; Try doing this without specter
 (= [:ford :toyota :latacara]
    (__ (get car-inventory __)))

 ;; Now try with specter!
 (= [:ford :toyota :latacara]
    (sr/select [:cars sr/MAP-KEYS] __))

 ;; Try to just get the types of cars from latacara
 (= [:prime :prime-zero]
    (sr/select [:cars __ __] car-inventory))

 ;; Let's try to get some Values instead of keys
 ;; Let's start with selecting the vector of the two ford Focus cars we have at the dealership
 (= [[{:doors 2 :color "red"} {:doors 2 :color "blue"}]]
    (sr/select [:cars __ __] car-inventory))

 ;; That was great, but what if we actually just want the maps instead of the vector
 ;; (notice that the previous test is a vector inside of a vector)
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"}]
    (___ [:cars :ford __ sr/ALL] __))

 ;; Let's get all of the cars from both ford types, the focus and the expedition
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"} {:doors 4 :color "red"} {:doors 4 :color "black"}]
    (sr/select [:cars :ford (sr/multi-path :focus :expedition) __] car-inventory))

 ;; multi-path was cool, but imagine if you had 100 keys in the multi-path, that would be terrible
 ;; let's see if we can get there with MAP-VALS
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"} {:doors 4 :color "red"} {:doors 4 :color "black"}]
    (sr/select [__ __ sr/MAP-VALS __] car-inventory))

 ;; Great, so we can now traverse a map, going either by the absolute path or using some generalized special functions to get where we need to go
 ;; So what is Eidolon?
 ;; Eidolon is a latacora built specter library - Let's check it out 

 ;; eidolon TREE-KEYS will provide all of the keys below whatever point in the map it is called
 (= [:doors :color :doors :color :doors :color :doors :color :focus :expedition]
    (sr/select [:cars :ford e/TREE-KEYS] __))

 ;; what if instead of TREE-KEYS we wanted the TREE-LEAVES?
 (= [2 "red" 2 "blue" 4 "red" 4 "black"]
    (sr/select [:cars :ford ___] car-inventory))

 )




