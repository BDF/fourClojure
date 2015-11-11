(ns partitionASeq)


; Write a function which returns a sequence of lists of x items each. 
; Lists of less than x items should not be returned.
	
;(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
;(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
;(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

(defn pas[x y]
    (loop [s y
         r []]
    (if (< (count s) x)
      r
      (recur (drop x s) (conj r (take x s))))))

(pas 3 (range 9))
(pas 2 (range 9))


(fn [x y]
    (loop [s y
         r []]
    (if (< (count s) x)
      r
      (recur (drop x s) (conj r (take x s))))))