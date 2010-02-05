(load "about_asserts")
(load "about_vectors")

(defmacro meditate-on
  "Runs tests but exits if an assertion fails"
  [test-function]
  `(try
   (~test-function)
   (catch Throwable t#
     (println (str "\n\"" (:zen (meta #'~test-function)) "\"\n"
                   "[FAILURE] - "(:name (meta #'~test-function))
                   " failed\n" t# "\n"))
     (System/exit 1))))

(meditate-on test-truth)
(meditate-on test-assert-equality)
(meditate-on test-fill-in-values)

(meditate-on test-creating-vectors)
(meditate-on test-vector-literals)
(meditate-on test-accessing-vector-elements)
(meditate-on test-vectors-and-ranges)

(println "You have achieved clojure zen. Go out into the universe and spread your newfound knowledge.")
