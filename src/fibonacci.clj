(ns fibonacci)

(def sqrtOf5  (Math/sqrt 5))
(def oneOverSqrtOf5 (/ 1 sqrtOf5))
(def onePlusSqrtOf5DivBy2 (/ (+ 1 sqrtOf5) 2))
(def oneMinusSqrtOf5DivBy2 (/ (- 1 sqrtOf5) 2))

(defn fibFun[x]
  (long 
    (+ 0.5
       (-
         (* oneOverSqrtOf5 (Math/pow onePlusSqrtOf5DivBy2 x))
         (Math/pow oneMinusSqrtOf5DivBy2 2)))))

(map fibFun (take 20 (range)))
   

;; Two assocs in a row does not change the original value.
(defn fib[x]
  (reduce
      #(do
         (println %1 %2)
         (assoc %1 :v (+ (:v %1) (:x %1)) :x (:v %1))
         )
      {:v 0 :x 1}
      (take x (range))))

(defn fib[z]
  (loop [v 0
         x 1
         r []]
    (if (> (count r) z)
      (rest r)
      (recur (+ v x) v (conj r v)))))

(fib 3)
(fib 4)
(fib 5)
(fib 6)
(fib 7)
(fib 8)
(fib 9)
(fib 10)
(fib 11)
(fib 12)

(map fib (take 2 (range)))
(map fib (take 3 (range)))
(map fib (take 10 (range)))
(map fib (take 20 (range)))
(map fibFun (take 20 (range)))

  
(defn do-to-map [amap keyseq f]
  (reduce #(assoc %1 %2 (f (%1 %2))) amap keyseq))
          
; 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
; 0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12

; f(0) = 0
; f(1) = 1
; f(2) = f(1) + f(0)
; f(3) = f(2) + f(1)
           
(1/sqrt(5)) * (pow(((1 + sqrt(5)) / 2), n) - 
                       pow(((1 - sqrt(5)) / 2), n));
           