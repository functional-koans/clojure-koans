(ns koans.05-sets
  (:require [koan-engine.core :refer :all]
            [clojure.set :as set]))

(meditations
  "Создаём множество из другой коллекции"
  (= #{3} (set __))

  "Считаем как обычно"
  (= __ (count #{1 2 3}))

  "Множество — оно математическое"
  (= __ (set '(1 1 2 2 3 3 4 4 5 5)))

  "Объединение"
  (= __ (set/union #{1 2 3 4} #{2 3 5}))

  "Пересечение"
  (= __ (set/intersection #{1 2 3 4} #{2 3 5}))

  "Разность"
  (= __ (set/difference #{1 2 3 4 5} #{2 3 5})))
