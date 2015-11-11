(ns reImplMap)

;[3 4 5 6 7]

(def t1 (__ inc [2 3 4 5 6]))
	
;(= (repeat 10 nil)
(def t2 (__ (fn [_] nil) (range 10)))
	
;(= [1e6 (inc 1e6)]
(def t3 (->> (myMap inc (range))
             (drop (dec 1e6))
             (take 2)))
   

; does not work since it is not lazy.
(defn myMapWrng [f s]
  (reduce #(conj %1 (f %2)) [] s))


; Map is one of the core elements of a functional programming language. 
; Given a function f and an input sequence s, return a lazy sequence of 
; (f x) for each element x in s.


(defn myMap[f x]
  (if (empty? x)
    '()
    (lazy-seq (cons (f (first x)) (myMap f (rest x))))))
  
(defn tMap[f x]
  (map f x))

(myMap inc [2 3 4 5 6])
(myMap (fn [_] nil) (range 10))

    
(->> (myMap inc (range))
             (drop (dec 1e6))
             (take 2))

(->> (tMap inc (range))
             (drop (dec 1e6))
             (take 2))

(fn myMap[f x]
  (if (empty? x)
    '()
    (lazy-seq (cons (f (first x)) (myMap f (rest x))))))