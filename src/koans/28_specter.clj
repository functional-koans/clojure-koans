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
                     :prime-three [{:doors 3
                                    :color "red"}
                                   {:doors 3
                                    :color "green"}]}}})

(def car-inventory-ford
  {:cars {:ford {:focus [{:doors 2
                         :color "red"}
                        {:doors 2
                         :color "blue"}]
                 :expedition [{:doors 4
                               :color "red"}
                              {:doors 4
                               :color "black"}]}}})

;; The hope of this exercise is to get you more familiar with specter and eidolon

(meditations

 "Imagine you wanted to select the keys for all of the brands of cars you own.
 Try doing this without specter"
 (= [:ford :toyota :latacara]
    (__ (get car-inventory __)))

 "Now try with specter!"
 (= [:ford :toyota :latacara]
    (sr/select [:cars sr/MAP-KEYS] __))

 "Try to just get the types of cars from latacara"
 (= [:prime :prime-zero]
    (sr/select [:cars __ __] car-inventory))

 "Let's try to get some Values instead of keys
 Let's start with selecting the vector of the two ford Focus cars we have at the dealership"
 (= [[{:doors 2 :color "red"} {:doors 2 :color "blue"}]]
    (sr/select [:cars __ __] car-inventory))

 "That was great, but what if we actually just want the maps instead of the vector
 (notice that the previous test is a vector inside of a vector)"
 ;; kinda confusing that you have to fill in sr/select (maybe would add a hint for sr/ALL?)
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"}]
    (___ [:cars :ford __ sr/ALL] __))

 "Let's get all of the cars from both ford types, the focus and the expedition"
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"} {:doors 4 :color "red"} {:doors 4 :color "black"}]
    (sr/select [:cars :ford (sr/multi-path :focus :expedition) __] car-inventory))

 "multi-path was cool, but imagine if you had 100 keys in the multi-path, that would be terrible
 let's see if we can get all the :ford cars with MAP-VALS"
 (= [{:doors 2 :color "red"} {:doors 2 :color "blue"} {:doors 4 :color "red"} {:doors 4 :color "black"}]
    (sr/select [__ __ sr/MAP-VALS __] car-inventory))


 "You can also pass a function to the end of a select to filter results
 Let's dig down into the maps values for all of the cars and then just get the results of the cars with 4 doors"
 (= [{:doors 4, :color "red"} {:doors 4, :color "black"} {:doors 4, :color "tan"} {:doors 4, :color "blue"} {:doors 4, :color "blue"}]
    (sr/select [:cars ___ ___ sr/ALL #(= (:doors %) 4)] car-inventory))

 "Great, so we can now traverse a map, going either by the absolute path or using some generalized special functions to get where we need to go
 So what is Eidolon?
 Eidolon is a latacora-built specter library - Let's check it out
 eidolon TREE-KEYS will provide all of the keys below whatever point in the map it is called"
 (= [:doors :color :doors :color :doors :color :doors :color :focus :expedition]
    (sr/select [:cars :ford e/TREE-KEYS] __))

 "What if instead of TREE-KEYS we wanted the TREE-LEAVES?"
 (= [2 "red" 2 "blue" 4 "red" 4 "black"]
    (sr/select [:cars :ford ___] car-inventory))

 "Another eidolon feature is collecting a value and continuing down to the items
 this will return both the collected value and the items in their own vector.
  Complete the below query to get a list of model descriptions for ford "
 (= [[:focus {:doors 2, :color "red"}] [:focus {:doors 2, :color "blue"}] [:expedition {:doors 4, :color "red"}] [:expedition {:doors 4, :color "black"}]]
  (sr/select [:cars __ e/INDEXED __] car-inventory))

 ;; TODO figure out a good use for INDEXED-SEQ :)

 "Setval and transform
 So part of specter is collecting data, but another aspect is changing that data
 imagine that someone came and painted all of your ford focuses orange."
 (= {:cars {:ford {:focus [{:doors 2, :color "orange"} {:doors 2, :color "orange"}], :expedition [{:doors 4, :color "red"} {:doors 4, :color "black"}]}}}
  (sr/setval [:cars :ford :focus sr/ALL __] __ car-inventory-ford))

 "The new orange ford focuses sell like hot cakes! now that we have sold 2 lets remove them from our inventory
 with sr/NONE"
 (= {:cars {:ford {:expedition [{:doors 4, :color "red"} {:doors 4, :color "black"}]}}}
    (sr/setval [:cars __ __] sr/NONE car-inventory-ford))

 "setval takes a map and returns a map.
 Let's use a thread to do the following:
 1. remove both of our sold ford focuses
 2. change the color of the expedition to orange to try to sell that faster as well"
 ;; TODO using placeholder for the thread macro doesn't play nice w/ the meditate macro (can this be fixed?)
 ;; TODO: add  two entries to the expected vec
 (= {:cars {:ford {:expedition [{:doors 4, :color "orange"}]}}}
    (___ car-inventory-ford
         (sr/setval [:cars :ford :focus] ___)
         (sr/setval [:cars :ford :expedition sr/ALL :color] __)))

 "Transform also takes a map and returns a map
 The format of transform is (sr/transform path function map)
 Generally I use transform when I need to do more complex functions to decide what to change things to
 Let's change any blue ford focus from out car-inventory-ford map to orange, our new favorite color"
 (= {:cars {:ford {:focus [{:doors 2, :color "red"} {:doors 2, :color "orange"}], :expedition [{:doors 4, :color "red"}]}}}
    (___ [:cars :ford :focus sr/ALL :color]
                  #(if (= % "blue")
                     "orange"
                     %)
                  __))

 ;; This is another way to right the same thing, but with a less anonymous function
 ;; (sr/transform [:cars :ford :focus sr/ALL :color]
 ;;               (fn [color]
 ;;                 (if (= color "blue")
 ;;                   "orange"
 ;;                   color))
 ;;               car-inventory-ford)

" For this final example let's scope back up to car-inventory, just for fun :)
 Let's say that the government has outlawed all cars with an even amount of doors.
 To be good to the people, let's just give them an extra one. latacara is ahead of
 the curve on this one, so we will specifically exclude them from this transform
 We are going to use eidolon's INDEXED function to collect the name of the brand,
 and then continue to dig down into the door count. From there, we can check if
 its even using an even? function and if its true increase the count by one
"
 (= {:cars {:ford {:focus [{:doors 3, :color "red"} {:doors 3, :color "blue"}], :expedition [{:doors 5, :color "red"} {:doors 5, :color "black"}]}, :toyota {:camry [{:doors 3, :color "red"} {:doors 5, :color "tan"}], :rav4 [{:doors 5, :color "blue"} {:doors 5, :color "blue"}]}, :latacara {:prime [{:doors 11, :color "clear"}], :prime-three [{:doors 3, :color "red"} {:doors 3, :color "green"}]}}}
    (sr/transform [:cars ___ ___ sr/ALL :doors]
                  (fn [brand doors]
                    (if (not= brand :latacara)
                      (if (___ doors)
                        (___ doors)
                        doors)
                      doors))
                  car-inventory))

 ;; Here is another way we could go about it in a kind of clever way
 ;; (ignoring the requirement to exclude latacara)

 ;; (sr/transform [e/TREE-LEAVES int?]
 ;;               #(if (even? %)
 ;;                  (inc %)
 ;;                  %) car-inventory)

 ;; TODO exercise to remove maps that contain keys w/ specific strings

 )
