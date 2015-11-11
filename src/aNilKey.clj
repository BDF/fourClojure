(ns aNilKey)


(defn isNilKey [key hash]
  (#(and (contains? %2 %1) (nil? (%1 %2))) key hash))


(isNilKey :a {:a nil :b 2})
(isNilKey :b {:a nil :b 2})
(isNilKey :c {:a nil :b 2})
