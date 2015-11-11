(ns dotProduct)


;(= 0 
(def t1 (list [0 1 0] [1 0 0]))
	
;(= 3 
(def t2 (list [1 1 1] [1 1 1]))
	
;(= 32 
(def t3 (list [1 2 3] [4 5 6]))
	
;(= 256 
(def t4 (list [2 5 6] [100 10 1]))



(defn dp [x y]
  (apply + (map * x y)))


(fn [x y]
  (apply + (map * x y)))