(ns compressASequence)

(def t1 "Leeeeeerrroyyy")
(def t2 [1 1 2 3 3 2 2 3])
(def t3 [[1 2] [1 2] [3 4] [1 2]])


(defn myR[x]
  (reduce #(if  
           (= (last %1) %2)
             %1
             (conj %1 %2))
        [] x))


(myR t1)
(myR t2)
(myR t3)

(fn [x](reduce #(if 
                  (= (last %1) %2)
                  %1
                  (conj %1 %2))
               [] x))

;#(map last (partition-by max %))

(#(map last (partition-by (fn[x] x) %)) t1)
(#(map last (partition-by identity %)) t1)

(#(map last (partition-by max %)) t2)
(#(map last (partition-by max %)) t3)

(#(partition-by (fn[x] x) %) t1)
(#(partition-by (fn[x] x) %) t2)
(#(partition-by max %) t3)

(map max t2)


