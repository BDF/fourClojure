(ns simpleClojures)


;Given a positive integer n, return a function (f x) which computes x**n. Observe that the effect of 
;this is to preserve the value of n for use outside the scope in which it is defined.

(defn sc[n]
  #(apply * (repeat n %)))

(defn sc2[n]
  #(Math/pow % n))

(= 256 ((sc2 2) 16), ((sc2 8) 2))
	
(= [1 8 27 64] (map (sc 3) [1 2 3 4]))
	
(= [1 2 4 8 16] (map #((sc %) 2) [0 1 2 3 4]))
