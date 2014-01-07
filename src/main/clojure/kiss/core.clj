(ns kiss.core
  (:require [kiss.compiler :as compiler])
  (:import [kiss.lang Environment])
  (:use [mikera.cljutils error]))

;; EXPERIMENTAL - API subject to change!!!
;;
;; Don't rely on any of this stuff being here in the future

(defn empty-environment
  "Returns an empty kiss environment"
  ([]
    Environment/EMPTY))

(defn kmerge
  "Merge kiss environments, returning a new environment"
  (^Environment [^Environment a] a)
  (^Environment [^Environment a ^Environment b] (TODO))
  (^Environment [^Environment a ^Environment b & more ]
    (reduce kmerge (kmerge a b) more)))

(defmacro kiss
  "Compiles and executes kiss code in the given environment, returning an updated kiss environment"
  [env & body]
  (apply compiler/clojure-compile env body))

(defn keval
  "Evaluates kiss code in a given environment, returing the result."
  ([code]
    (keval (empty-environment) code))
  ([env code]
    (kiss env code)))