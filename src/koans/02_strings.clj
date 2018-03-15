(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as string]))

(meditations
  "Строка — это текст, обрамлённый двойными кавычками"
  (= __ "hello")

  "Но это лишь вершина айсберга"
  (= __ (str 'world))

  "Создавая одну строку можно объединением нескольких"
  (= "Cool right?" (str __ __))

  "Можно получить символьный литерал"
  (= \C (get "Characters" __))

  "Сосчитать сколько их"
  (= __ (count "Hello World"))

  "Но он — не строка"
  (= __ (= \c "c"))

  "А что если нужна лишь часть строки?"
  (= "World" (subs "Hello World" __ __))

  "Объединяем элементы в строку"
  (= __ (string/join '(1 2 3)))

  "Объединяем, но разделяя между собой"
  (= "1, 2, 3" (string/join __ '(1 2 3)))

  "Можно разделить построчно"
  (= [__ __ __] (string/split-lines "1\n2\n3"))

  "Можно инвертировать"
  (= __ (string/reverse "hello"))

  "Можно найти индекс первого совпадения"
  (= 0 (string/index-of "hello world" __))

  "Или последнего"
  (= __ (string/last-index-of "hello world, hello" "hello"))

  "А если ничто не совпало, то что мы получим?"
  (= __ (string/index-of "hello world" "bob"))

  "Иногда неплохо бы избавиться от пробелов"
  (= __ (string/trim "  \nhello world \t \n"))

  "Тест на символьный литерал"
  (= __ (char? \c))

  "Тут точно не пройдёт"
  (= __ (char? "a"))

  "«Чары» — они не строки"
  (= __ (string? \b))

  "А строки — строки"
  (= true (string? __))

  "Иногда и пустые"
  (= __ (string/blank? ""))

  "Хотя на первый взгляд и не скажешь"
  (= __ (string/blank? " \n \t  "))

  "Всё же большинство строк не пусты"
  (= __ (string/blank? "hello?\nare you out there?")))
