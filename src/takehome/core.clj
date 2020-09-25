(ns takehome.core
  (:require [java-time :as time]))

(defn can-access? [object purchase]
  (if (= (:type purchase) :patriota)
    (and (or (= (:type object) :podcast) (= (:type object) :debate) (= (:type object) :interview) ))))