(ns lazySearching)


;Given any number of sequences, each sorted from smallest to largest, find 
; the smallest number which appears in each sequence. The sequences may be 
; infinite, so be careful to search lazily.

;3
(def t1 (list [3 4 5]))

;4
(def t2 (list [1 2 3 4 5 6 7] [0.5 3/2 4 19]))
	
;(= 7 
(def t3 (list (range) (range 0 100 7/6) [2 3 5 7 11 13]))

;(= 64 (__ 
(def t4 (list 
          (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))) ;; at least as large as 20

(defn ls[& x]
  (let [mValSeq (map first x)
        mVal    (apply min mValSeq)]
    (if (apply = mValSeq)
      mVal
      (let [y (map rest (filter #(=    mVal (first %)) x))
            z           (filter #(not= mVal (first %)) x)]
      (recur (concat y z))))))
  

(filter #(= (apply min (map first t2)) (first %)) t2)
(map rest (filter #(= (apply min (map first t2)) (first %)) t2))
(ls [3 4 5])
(ls [1 2 3 4 5 6 7] [0.5 3/2 4 19])
(ls (range) (range 0 100 7/6) [2 3 5 7 11 13])
(ls (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))

(fn [& x]
  (let [mValSeq (map first x)
        mVal    (apply min mValSeq)]
    (if (apply = mValSeq)
      mVal
      (let [y (map rest (filter #(=    mVal (first %)) x))
            z           (filter #(not= mVal (first %)) x)]
      (recur (concat y z))))))
  
