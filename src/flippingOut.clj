(ns flippingOut)

;Write a higher-order function which flips the order of the arguments of an input 
;function.

;(= 3 ((__ nth) 2 [1 2 3 4 5]))
;(= true ((__ >) 7 8))
;(= 4 ((__ quot) 2 8))
;(= [1 2 3] ((__ take) [1 2 3 4 5] 3))

(defn fo[f]
  (fn[z y] (f y z)))

(defn fo2[f]
  #(f %2 %1))

((fo nth) 2 [1 2 3 4 5])
((fo2 nth) 2 [1 2 3 4 5])

((fo >) 7 8)
((fo2 >) 7 8)

((fo quot) 2 8)
((fo2 quot) 2 8)

;(= [1 2 3] 
((fo take) [1 2 3 4 5] 3)
((fo2 take) [1 2 3 4 5] 3)
