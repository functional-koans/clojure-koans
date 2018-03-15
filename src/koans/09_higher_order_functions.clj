(ns koans.09-higher-order-functions
  (:require [koan-engine.core :refer :all]))

(meditations
  "Создаём номую последовательность изменяя данную"
  (= [__ __ __] (map (fn [x] (* 4 x)) [1 2 3]))

  "Изменяйте, создаваю свои функции"
  (= [1 4 9 16 25] (map (fn [x] __) [1 2 3 4 5]))

  "Или используйте существующие"
  (= __ (map nil? [:a :b nil :c :d]))

  "Такой фильтр не пропустит ничего"
  (= __ (filter (fn [x] false) '(:anything :goes :here)))

  "А такой?"
  (= __ (filter (fn [x] true) '(:anything :goes :here)))

  "Какой фильтр здесь?"
  (= [10 20 30] (filter (fn [x] __) [10 20 30 40 50 60 70 80]))

  "Сначала фильтруем, потом изменяем полученное"
  (= [10 20 30] (map (fn [x] __) (filter (fn [x] __) [1 2 3 4 5 6 7 8])))

  "Уменьшаем объём, увеличиваем значение"
  (= __ (reduce (fn [a b] (* a b)) [1 2 3 4]))

  "Можно указать начальное значение"
  (= 2400 (reduce (fn [a b] (* a b)) __ [1 2 3 4]))

  "Не только числа"
  (= "longest" (reduce (fn [a b]
                         (if (< __ __) b a))
                       ["which" "word" "is" "longest"])))
