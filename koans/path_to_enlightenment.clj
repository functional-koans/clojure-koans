(load "about-asserts")

(defmacro meditate-on
  "Runs tests but exits if an assertion fails"
  [test-function]
  `(try
   (~test-function)
   (catch Throwable t#
     (println (str (:zen (meta #'~test-function)) "\n"
                   (:name (meta #'~test-function))
                   " returned " t#))
     (System/exit 1))))

(meditate-on test-truth)
(meditate-on test-assert-equality)
(meditate-on test-fill-in-values)
(println "You have achieved clojure zen. Go out into the universe and spread your newfound knowledge.")
