(load "about-asserts")

(defn meditate-on
  "Runs tests but exits if an assertion fails"
  [test]
  (try
   (test)
   (catch Throwable t
     (println (str "Metadata zen\n" "test name failed"))
     (System/exit 1))))

(meditate-on test-truth)
(meditate-on test-assert-equality)
(println "You have achieved clojure zen. Go out into the universe and spread your newfound knowledge.")
