(ns takehome.core
  (:require [java-time :as time]))


(defn patriota-access? [object purchase]
  (or 
   (= (:type object) :series)
   (= (:type object) :podcast)
   (= (:type object) :debate)
   (and (= (:type object) :interview)
        (time/before? (:subscription-start purchase)
                      (:released-at object)
                      (:subscription-end purchase)))))

(defn premium-access? [object purchase]
  (or
   (= (:type object) :series) 
   (= (:type object) :course) 
   (= (:type object) :podcast) 
   (= (:type object) :debate) 
   (and (= (:type object) :interview)
        (time/before? (:subscription-start purchase)
                      (:released-at object)
                      (:subscription-end purchase)))))

(defn mecenas-access? [object purchase]
  (or
   (= (:type object) :series)
   (= (:type object) :course) 
   (= (:type object) :podcast) 
   (= (:type object) :debate) 
   (and (= (:type object) :interview)
        (time/before? (:subscription-start purchase)
        (:released-at object)
        (:subscription-end purchase)))
   (and (= (:type object) :patron)
        (time/before? (:subscription-start purchase)
                      (:released-at object)
                      (:subscription-end purchase)))))


(defn can-access? [object purchase]
  (cond
    (= (:type purchase) :patriota) (patriota-access? object purchase)
    (= (:type purchase) :premium) (premium-access? object purchase)
    (= (:type purchase) :mecenas) (mecenas-access? object purchase)))
