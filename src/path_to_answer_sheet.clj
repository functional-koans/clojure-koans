(ns path-to-answer-sheet
  (:use [runner.koans :only [ordered-koans]]
        [path-to-enlightenment :only [meditations fancy-assert __ ___]]
        [clojure.string :only [join split trim] :as string]))

(def answers
  {"equalities" {"__" [true
                       2
                       7
                       5
                       4/2
                       false
                       6/3
                       3]}

   "lists" {"__" [1 2 3 4 5
                  1
                  [2 3 4 5]
                  ()
                  [:a :b :c :d :e]
                  [0 :a :b :c :d :e]
                  :a
                  [:b :c :d :e]
                  "No dice!"
                  ()]}

   "vectors" {"__" [1
                    []
                    [1]
                    [nil]
                    2
                    [333]
                    :peanut
                    :jelly
                    :jelly
                    [:butter :and]
                    3]}

   "sets" {"__" [nil
                 3
                 #{1 2 3 4 5}
                 #{1 2 3 4 5}
                 #{2 3}
                 #{1 4}]}

   "maps" {"__" [{}
                 0
                 1
                 2
                 2
                 1
                 1
                 "Vancouver"
                 nil
                 :key-not-found
                 true
                 false
                 "February"
                 1 "January"
                 2006 2010 2014
                 "Vancouver"]}

   "functions" {"__" [20
                      10 5
                      30 2
                      15
                      20 '*]
                "___" ['(fn [f] (f 5))
                       '(fn [f] (f 5))]}

   "conditionals" {"__" [:a
                         []
                         nil
                         :glory
                         4 6 :your-road
                         ''doom 0
                         :cocked-pistol
                         :say-what?]}

   "higher_order_functions" {"__" [4 8 12
                                   '(* x x)
                                   [false false true false false]
                                   ()
                                   [:anything :goes :here]
                                   '(< x 31)
                                   '(* 10 x) '(< x 4)
                                   24
                                   100
                                   '(count a) '(count b)]}

   "runtime_polymorphism" {"__" ['(str (:name a) " eats veggies.")
                                 '(str (:name a) " eats animals.")
                                 '(str "I don't know what " (:name a) " eats.")
                                 "Hello World!"
                                 "Hello, you silly world."
                                 "Hello to this group: Peter, Paul, Mary!" ]}

   "lazy_sequences" {"__" [[1 2 3 4]
                           [0 1 2 3 4]
                           10
                           95
                           '(range 20)
                           :a]
                     "___" ['(fn [x] :foo)]}

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
                               'multiply-by-5
                               '(comp dec square)]}

   "recursion" {"__" [true
                      'acc
                      '(loop [coll coll
                              acc ()]
                         (if (seq coll)
                           (recur (rest coll) (conj acc (first coll)))
                           acc))
                      '(loop [n n
                              acc 1]
                         (if (zero? n)
                             acc
                             (recur (dec n) (* acc n))))]
                "___" ['not]}

   "destructuring" {"__" [":bar:foo"
                          '(format (str "First comes %s, "
                                        "then comes %s, "
                                        "then comes %s with the baby carriage")
                                   a b c)
                          '(apply str
                             (interpose " "
                               (apply list
                                  first-name
                                  last-name
                                  (interleave (repeat "aka") aliases))))
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
   "refs" {"__" ["hello"
                 "hello"
                 "better"
                 "better!!!"
                 '(dosync (ref-set the-world 0))
                 '(map :jerry [@the-world @bizarro-world])
                 ]
           "___" ['(fn [x] (+ 20 x))]}

   "atoms" {"__" [0
                  1
                  '(swap! atomic-clock (partial + 4))
                  20
                  20
                  'atomic-clock 20 :fin
                  ]}

   "macros" {"__" ['~(first form)
                   '~(nth form 2)
                   'form
                   '(drop 2 form)
                   "Hello, Macros!"
                   10
                   ''(+ 9 1)
                   ''(* 10 2)
                   ''(+ 10 (2 * 3))]}

   "datatypes" {"__" ['(print
                         (str "You're really the "
                              (.category this)
                              ", " recipient "... sorry."))
                      "peace"
                      "literature"
                      "physics"
                      nil
                      [true false]
                      (str "Congratulations on your Best Picture Oscar, "
                           "Evil Alien Conquerors!")]}

   "java_interop" {"__" ['java.lang.String
                         "SELECT * FROM"
                         10
                         1024
                         ]
                   "___" ['#(.toUpperCase %)
                          ]
                   }

   })

(defn replace-with [s k replacements]
  (let [unreplaced-texts (split s (re-pattern (str "\\b" k "\\b")))]
    (join
      (butlast
        (interleave
          unreplaced-texts
          (concat (map pr-str replacements) (repeat k)))))))

(defn koan-text [koan]
  (slurp (str "src/koans/" koan ".clj")))

(defn answers-for [koan sym]
  ((answers koan {}) sym []))

(defn fill-in-answers [text koan sym]
  (replace-with text sym (answers-for koan sym)))

(defn print-non-failing-error [koan]
  (println (str "\n" koan ".clj is passing without filling in the blanks")))

(defmacro ensure-failure [& forms]
  (let [pairs (partition 2 forms)
        tests (map (fn [[doc# code#]]
                     `(if (try
                           (fancy-assert ~code# ~doc#)
                           false
                           (catch AssertionError e# true)
                           (catch Exception e# true))
                       :pass
                       (throw (AssertionError. (pr-str ~doc# ~code#)))))
                   pairs)]
    `(do ~@tests)))

(defn ensure-failing-without-answers []
  (if (every?
        (fn [koan]
          (let [form (koan-text koan)
                form (string/replace form "(meditations" "(ensure-failure")
                fake-err (java.io.PrintStream. (java.io.ByteArrayOutputStream.))
                real-err System/err
                result (try
                         (load-string form)
                         true
                         (catch AssertionError e (prn e) false)
                         (catch Exception e (prn e) false))]
            (if result
              :pass
              (print-non-failing-error koan))))
        ordered-koans)
    (println "\nTests all fail before the answers are filled in.")))

(defn ensure-passing-with-answers []
  (try
    (dorun (map
      (fn [koan]
        (load-string
          (-> (koan-text koan)
              (fill-in-answers koan "__")
              (fill-in-answers koan "___"))))
      ordered-koans))
    (println "\nAll tests pass after the answers are filled in.")

    (catch Exception e
      (println "\nAnswer sheet fail: " e)
      (.printStackTrace e)
      (println "Answer sheet fail"))))

(defn run []
  (ensure-failing-without-answers)
  (ensure-passing-with-answers))


