(ns path-to-enlightenment
  (:use [runner.freshness :only [setup-freshener]])
  (:require [clojure.set]
            [clojure.string]
            [clojure.test]))

(def __ :fill-in-the-blank)
(def ___ (fn [& args] __))

(defmacro meditations [& forms]
  (let [pairs (conj (partition 2 forms)
                    ["Bootstrap for file/line reporting"
                     '(clojure.test/is (= 0 0))])
        tests (map (fn [[doc# code#]]
                     `(clojure.test/is ~code# ~doc#))
                   pairs)]
    `(and ~@tests)))

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
                            (map (fn [xs] (vec (take 2 xs))))
                            (into {})
                            ('org.clojure/clojure))]
    (map read-string
         (take 3 (clojure.string/split version-string #"[\.\-]")))))

(defn run []
  (require-version (parse-required-version))
  (setup-freshener))

