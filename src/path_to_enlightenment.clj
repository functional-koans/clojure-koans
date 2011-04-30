(ns path-to-enlightenment
  (:use [fresh.core :only [clj-files-in freshener]]
        [clojure.java.io :only [file]])
  (:require [clojure.set]
            [clojure.string]
            [clojure.test])
  (:import
    [java.util.concurrent ScheduledThreadPoolExecutor TimeUnit]))

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
      "lazy_sequences"
      "sequence_comprehensions"
      "creating_functions"
      "recursion"
      "destructuring"
      "refs"
      "atoms"
      "macros"
      "datatypes"])

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

(defn files-to-keep-fresh []
  (clj-files-in (file "src" "koans")))

(defn- tests-pass? [file-path]
  (use 'path-to-enlightenment)
  (load-file file-path))

(defn- among-paths? [files]
  (into #{} (map #(.getCanonicalPath %) files)))

(defn- ordered-koan-paths  []
  (map (fn [koan-name]
           (.getCanonicalPath (file "src" "koans" (str koan-name ".clj"))))
       ordered-koans))

(defn- next-koan-path [last-koan-path]
  (loop [[this-koan & more :as koan-paths] (ordered-koan-paths)]
    (when (seq more)
      (if (= last-koan-path this-koan)
        (first more)
        (recur more)))))

(defn namaste []
  (println "\nYou have achieved clojure enlightenment. Namaste."))

(defn report-refresh [report]
  (when-let [refreshed-files (seq (:reloaded report))]
    (let [these-koans (filter
                        (among-paths? refreshed-files)
                        (ordered-koan-paths))]
      (println "Refreshing:" these-koans)
      (when (every? tests-pass? these-koans)
        (if-let [next-koan-file (file (next-koan-path (last these-koans)))]
          (report-refresh {:reloaded [next-koan-file]})
          (namaste))))
    (println))
  :refreshed)

(def refresh! (freshener files-to-keep-fresh report-refresh))

(def scheduler (ScheduledThreadPoolExecutor. 1))

(defn setup-freshener []
  (.scheduleWithFixedDelay scheduler refresh! 0 500 TimeUnit/MILLISECONDS)
  (.awaitTermination scheduler Long/MAX_VALUE TimeUnit/SECONDS))

(defn run []
  (require-version (parse-required-version))
  (setup-freshener))


