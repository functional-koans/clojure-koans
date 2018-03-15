(ns koans.04-vectors
  (:require [koan-engine.core :refer :all]))

(meditations
  "Векторы в Clojure похожи на массивы"
  (= __ (count [42]))

  "Можно их содать из списка"
  (= __ (vec '(1)))

  "Или из ничего"
  (= __ (vector nil nil))

  "Число элементов — ваше дело"
  (= [1 __] (vec '(1 2)))

  "Добавляем элемент, помним что вектор «похож» на массив"
  (= __ (conj [111 222] 333))

  "Получаем первый элемент"
  (= __ (first [:peanut :butter :and :jelly]))

  "Последний элемент"
  (= __ (last [:peanut :butter :and :jelly]))

  "Да какой угодно элемент"
  (= __ (nth [:peanut :butter :and :jelly] 3))

  "Нарезаем вектор"
  (= __ (subvec [:peanut :butter :and :jelly] 1 3))

  "Коллекции сравниваются по их элементам"
  (= (list 1 2 3) (vector 1 2 __)))
