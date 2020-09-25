(ns takehome.core-test
  (:require [clojure.test :refer :all]
            [java-time :as time]
            [takehome.core :as sub]))

; (deftest test-patriota
;   (are [result purchase] (= result
;                             (sub/can-access?
;                              {:type :movie :name "1964: O Brasil entre Armas e Livros", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
;                              purchase))
;     true  {:type               :patriota
;            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
;            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811") }
;     false {:type               :patriota
;            :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
;            :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811") }))


(deftest test-patriota
  (are [result object] (= result
                            (sub/can-access?
                             object
                             { :type :patriota }))
    true { :type :podcast :name "Chernobyl - Podcast Cultura Paralela #4", :released-at "2020-03-29T20:02:34.347" }
    true { :type :debate :name "Há regras para educar os filhos?", :released-at "2020-03-29T20:02:34.356" }
    true { :type :interview :name "Congresso Brasil Paralelo - Rafael Nogueira", :released-at "2019-11-16T21:40:51.579" }
    false { :type :movie :name "Há regras para educar os filhos?", :released-at "2020-03-29T20:02:34.356"  }))