(ns packASequence)


(def t1 [1 1 2 1 1 1 3 3])
(def t2 [:a :a :b :b :c])
(def t3 [[1 2] [1 2] [3 4]])


(defn pas[x]
  (partition-by max x))

(defn pas2[x]
  (partition-by identity x))


(pas t1)
(pas t2)
(pas t3)
(pas2 t1)
(pas2 t2)
(pas2 t3)
