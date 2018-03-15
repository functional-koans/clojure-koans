(ns koans.10-runtime-polymorphism
  (:require [koan-engine.core :refer :all]))

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (cons a more)))
                   "!")))

(defmulti diet (fn [x] (:eater x)))
(defmethod diet :herbivore [a] __)
(defmethod diet :carnivore [a] __)
(defmethod diet :default [a] __)

(meditations
  "Полиморфизм. Без аргументов."
  (= __ (hello))

  "Один аргумент"
  (= __ (hello "world"))

  "Тысячи их"
  (= __
     (hello "Peter" "Paul" "Mary"))

  "Мультиметоды и диспетчеризация. Всё просто."
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  "Имена разные"
  (= "Thumper eats veggies."
     (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore}))

  "Разные методы исходя из вывода"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  "Традиционно, есть и метод по-умолчанию"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"})))
