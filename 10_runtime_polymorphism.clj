
  ; "Some functions can be used in different ways - with no arguments"
  (= __ (hello))

  ; "With one argument"
  (= __ (hello "world"))

  ; "Or with many arguments"
  (= __
     (hello "Peter" "Paul" "Mary"))

  ; "Multimethods allow more complex dispatching"
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  ; "Animals have different names"
  (= "Thumper eats veggies."
     (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore}))

  ; "Different methods are used depending on the dispatch function result"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  ; "You may use a default method when no others match"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"}))
