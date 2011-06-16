(ns path-to-enlightenment
  (:use [runner.freshness :only [setup-freshener]])
  (:require [clojure.set]
            [clojure.string]))

(def __ :fill-in-the-blank)
(def ___ (fn [& args] __))

(defmacro fancy-assert
  ([x] (fancy-assert x ""))
  ([x message]
   `(try
     (assert ~x ~message)
     (catch Exception e#
       (throw (Exception. (str '~message "\n" '~x )
                          e#))))))

(defmacro meditations [& forms]
  (let [pairs (partition 2 forms)
        tests (map (fn [[doc# code#]]
                     `(fancy-assert ~code# ~doc#))
                   pairs)]
    `(do ~@tests)))

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

