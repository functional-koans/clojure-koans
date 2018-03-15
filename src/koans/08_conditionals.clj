(ns koans.08-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
        :bicycling        "pretty fast"
        :jogging          "not super fast"
        :walking          "not fast at all"
        "is that even exercise?"))

(meditations
  "Нужно принимать решения"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  "Иногда альтернативы нет"
  (= __ (if (> 4 3)
          []))

  "И вы ничего не получаете"
  (= __ (if (nil? 0)
          [:a :b :c]))

  "Иногда выбор есть"
  (= :glory (if (not (empty? ()))
              :doom
              __))

  "И вариантов много"
  (let [x 5]
    (= :your-road (cond (= x __) :road-not-taken
                        (= x __) :another-road-not-taken
                        :else __)))

  "Получаем doom"
  (= 'doom (if-not (zero? __)
          'doom
          'more-doom))

  "Выбирать можно и так"
  (= "pretty fast"
     (explain-exercise-velocity __))

  "Можно задавать ответ по-умолчанию"
  (= __
     (explain-exercise-velocity :watching-tv)))
