(ns path-to-enlightenment
  (:use [clojure.test])
  (:require [clojure.set]
            [clojure.string]))

(def __ nil)
(def ___ (fn [& args] nil))

(defmacro meditations [& forms]
  (let [pairs (partition 2 forms)]
    `(do
      ~@(map
          (fn [[doc# code#]]
            `(when-not (is ~code# ~doc#)
              (System/exit 0)))
          pairs))))

(def ordered-koans
     ["equalities"
      "lists"
      "vectors"
      "sets"
      "maps"
      "functions"
      "conditionals"
      "higher_order_functions"
      "runtime_polymorphism"
      "sequence_comprehensions"
      "creating_functions"
      "recursion"
      "destructuring"
      "refs"])

(defn require-version [[required-major required-minor]]
  (let [{:keys [major minor]} *clojure-version*]
    (if (or (< major required-major)
        (and (== major required-major) (< minor required-minor)))
      (throw (Exception. (str "Clojure version " required-major "."
                              required-minor " or higher required."))))))

(defn parse-required-version []
  (let [rdr (clojure.lang.LineNumberingPushbackReader.
              (java.io.FileReader. (java.io.File. "project.clj")))
        project-form (read rdr)
        version-string (->> project-form
                            (drop 3)
                            (apply hash-map)
                            :dependencies
                            (into {})
                            ('org.clojure/clojure))]
    (map read-string
         (take 3 (clojure.string/split version-string #"[\.\-]")))))

(defn run []
  (require-version (parse-required-version))
  (apply load (doall (map (partial str "koans/") ordered-koans)))
  (println "You have achieved clojure enlightenment. Namaste."))
