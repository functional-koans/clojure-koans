(ns path-to-answer-sheet
  (:use [path-to-enlightenment :exclude (run)]
        [clojure.string :only (join split trim)]))

(def answers
  {"equalities" {"__" [true
                       2
                       7
                       5
                       4/2
                       false
                       6/3
                       3]}
   "lists" {"__" ["1 2 3 4 5"
                  1
                  [2 3 4 5]
                  "()"
                  [:a :b :c :d :e]
                  [0 :a :b :c :d :e]
                  :a
                  [:b :c :d :e]
                  "\"No dice!\""
                  "()"]}
   "vectors" {"__" [1
                    []
                    [1]
                    [nil]
                    2
                    [333]
                    :peanut
                    :jelly
                    :jelly
                    [:butter :and]]
              "___" ['=]}
   "sets" {"__" [3
                 #{1 2 3 4 5}
                 #{1 2 3 4 5}
                 #{2 3}
                 #{1 4}]}
   "maps" {"__" [0
                 1
                 2
                 2
                 1
                 1
                 "\"Vancouver\""
                 nil
                 true
                 false
                 "\"February\""
                 1 "\"January\""
                 2006 2010 2014
                 "\"Vancouver\""]}
   "functions" {"__" [20
                      10 5
                      30 2
                      15
                      20 '*]
                "___" ['(fn [f] (f 5))
                       '(fn [f] (f 5))]}
   "conditionals" {"__" [:a
                         []
                         0
                         :glory
                         4 6 :your_road
                         ''doom 0 ]}
   "higher_order_functions" {"__" [4 8 12
                                   '(* x x)
                                   [false false true false false]
                                   "()"
                                   true
                                   '(< x 31)
                                   '(* 10 x) '(< x 4)
                                   24
                                   100
                                   '(count a) '(count b)]}
   "runtime_polymorphism" {"__" ['(str (:name a) " eats veggies.")
                                 '(str (:name a) " eats animals.")
                                 '(str "I don't know what " (:name a) " eats.")
                                 "\"Hello World!\""
                                 "\"Hello, you silly world.\""
                                 "\"Hello to this group: Peter, Paul, Mary!\"" ]}
   "sequence_comprehensions" {"__" [[0 1 2 3 4 5]
                                    '(* index index)
                                    '(range 10)
                                    '(odd? index) '(* index index)
                                    '[row column]
                                    ]}
   "creating_functions" {"__" [true false true
                               4
                              :a :b :c :d
                              :c :d
                              4
                              8]
                        "___" ['(complement nil?)
                               "multiply-by-5"
                               '(comp dec square)]}
   "recursion" {"__" [true 'acc
                      '(loop [n n acc 1]
                         (if (zero? n)
                             acc
                             (recur (dec n) (* acc n))))]
                "___" ['not]}
   "destructuring" {"__" ["\":bar:foo\""
                          '(format (str "First comes %s, "
                                        "then comes %s, "
                                        "then comes %s with the baby carriage")
                                   a b c)
                          '(trim
                             (apply str
                               (interleave
                                 (apply list
                                    first-name
                                    last-name
                                    (interleave (repeat "aka") aliases))
                                 (repeat " "))))
                          '{:original-parts full-name
                            :named-parts {:first first-name :last last-name}}
                          '(str street-address ", " city ", " state)
                          'city 'state
                            '(str street-address ", " city ", " state)]
                    "___" ['(fn [[fname lname]
                                 {:keys [street-address city state]}]
                              (str fname " " lname ", "
                                   street-address ", " city ", " state))
                           ]}
   "refs" {"__" ["\"hello\""
                 "\"hello\""
                 "\"better\""
                 "\"better!!!\""
                 '(dosync (ref-set the-world 0))
                 ]
           "___" ['(comp exclamator exclamator exclamator)
                  '(fn [x] (+ 20 x))]}
   })

(defn replace-with [s k replacements]
  (let [unreplaced-texts (split s (re-pattern (str "\\b" k "\\b")))]
    (join
      (butlast
        (interleave
          unreplaced-texts
          (concat replacements (repeat k)))))))

(defn koan-text [koan]
  (slurp (str "src/koans/" koan ".clj")))

(defn answers-for [koan sym]
  ((answers koan {}) sym []))

(defn fill-in-answers [text koan sym]
  (replace-with text sym (answers-for koan sym)))

(defn run []
  (try
    (dorun
      (map
        (fn [koan]
          (load-string
            (-> (koan-text koan)
                (fill-in-answers koan "__")
                (fill-in-answers koan "___"))))
        ordered-koans))

    (println "\nThe answer key checks out!")

    (catch Exception e
      (println "\nAnswer sheet fail: " e)
      (.printStackTrace e)
      (println "Answer sheet fail"))))

