(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as string]))

(meditations
  "A string is nothing more than text surrounded by double quotes"
  (= __ "hello")

  "But double quotes are just magic on top of something deeper"
  (= __ (str 'world))

  "You can do more than create strings, you can put them together"
  (= "Cool right?" (str __ __))

  "You can even get certain characters"
  (= \C (get "Characters" __))

  "Or even count the characters"
  (= __ (count "Hello World"))

  "But strings and characters are not the same"
  (= __ (= \c "c"))

  "What if you only wanted to get part of a string?"
  (= "World" (subs "Hello World" __ __))

  "How about joining together elements in a list?"
  (= __ (string/join '(1 2 3)))

  "What if you wanted to separate them out?"
  (= "1, 2, 3" (string/join __ '(1 2 3)))

  "Maybe you want to separate out all your lines"
  (= [__ __ __] (string/split-lines "1\n2\n3"))

  "You may want to make sure your words are backwards"
  (= __ (string/reverse "hello"))

  "Maybe you want to find the index of the first occurence of a substring"
  (= 0 (.indexOf "hello world" __))

  "Or maybe the last index of the same"
  (= __ (.lastIndexOf "hello world, hello" "hello"))

  "But when something doesn't exist, it turns up negative"
  (= __ (.indexOf "hello world" "bob"))

  "Sometimes you don't want whitespace cluttering the front and back"
  (= __ (string/trim "  \nhello world \t \n"))

  "You can check if something is a char"
  (= __ (char? \c))

  "But it may not be"
  (= __ (char? "a"))

  "But chars aren't strings"
  (= __ (string? \b))

  "Strings are strings"
  (= true (string? __))

  "Some strings may be blank"
  (= __ (string/blank? ""))

  "Even if at first glance they aren't"
  (= __ (string/blank? " \n \t  "))

  "However, most strings aren't blank"
  (= __ (string/blank? "hello?\nare you out there?")))
