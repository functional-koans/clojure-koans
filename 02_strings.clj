
  ; "A string is nothing more than text surrounded by double quotes"
  (= "hello" "hello")

  ; "But double quotes are just magic on top of something deeper"
  (= "world" (str 'world))

  ; "You can do more than create strings, you can put them together"
  (= "Cool right?" (str "Cool" " right?")) ;; J - Whitespace!!

  ; "You can even get certain characters"
  (= \C (get "Characters" 0)) ;; J - get returns character or item number at a given index

  ; "Or even count the characters"
  (= 11 (count "Hello World")) ;; J - count returns the length of a string or list

  ; "But strings and characters are not the same"
  (= false (= \c "c"))

  ; "What if you only wanted to get part of a string?"
  (= "World" (subs "Hello World" 6 11)) ;; J - subs returns a substring of a given string and can take
                                        ;; two arguments. The the first one is the begining index of the
                                        ;; substring and the second one is the last

  ; "How about joining together elements in a list?"
  (= "123" (string/join '(1 2 3)))

  ; "What if you wanted to separate them out?"
  (= "1, 2, 3" (clojure.string/join ", " '(1 2 3))) ;; J - join does non seperate with whitespace by default

  ; "Maybe you want to separate out all your lines"
  (= ["1" "2" "3"] (clojure.string/split-lines "1\n2\n3"))

  ; "You may want to make sure your words are backwards"
  (= "olleh" (string/reverse "hello"))

  ; "Maybe you want to find the index of the first occurence of a substring"
  (= 0 (clojure.string/index-of "hello world" __))

  ; "Or maybe the last index of the same"
  (= __ (clojure.string/last-index-of "hello world, hello" "hello"))

  ; "But when something doesn't exist, nothing is found"
  (=  (clojure.string/index-of "hello world" "bob")) ;; J - Errored out

  ; "Sometimes you don't want whitespace cluttering the front and back"
  (= "hello world" (clojure.string/trim "  \nhello world \t \n"))

  ; "You can check if something is a char"
  (= true (char? \c))

  ; "But it may not be"
  (= false (char? "a"))

  ; "But chars aren't strings"
  (= false (string? \b))

  ; "Strings are strings"
  (= true (string? __))

  ; "Some strings may be blank"
  (= true (clojure.string/blank? ""))

  ; "Even if at first glance they aren't"
  (= true (clojure.string/blank? " \n \t  "))

  ; "However, most strings aren't blank"
  (= false (clojure.string/blank? "hello?\nare you out there?"))
