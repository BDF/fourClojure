(ns primeNumbers)


;Write a function which returns the first x number of prime numbers.
	
;(= 
(def t1 2); [2 3])

;(= 
(def t1 5); [2 3 5 7 11])
	
;(= 
;(last 
(def t2 100);) 541)

;Create a list of consecutive integers from 2 to n: (2, 3, 4, ..., n).
;Initially, let p equal 2, the first prime number.
;Starting from p, count up in increments of p and mark each of these numbers 
;    greater than p itself in the list. These numbers will be 2p, 3p, 4p, etc.; 
;    note that some of them may have already been marked.
;Find the first number greater than p in the list that is not marked. If there was
;     no such number, stop. Otherwise, let p now equal this number (which is the next
;    prime), and repeat from step 3.

(defn pn[x]
  (loop [r [2]
         p  3]
    (if (>= (count r) x)
      r
      (if (some zero? (map #(mod p %) r))
        (recur r (inc p))
        (recur (conj r p) (inc p))))))

;daowen's solution:
(defn pn2[n]
  (take n (remove
    (fn [x] (some #(zero? (mod x %)) (range 2 (dec x))))
            (iterate inc 2)
            )))


(pn 5)
(last (pn 100))

;(map #(%1 %2) (cycle [str identity]) (list 1 2 3 4 5 6))