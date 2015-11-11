(ns sumOfSquares)

;Write a function which takes a collection of integers as an argument. 
; Return the count of how many elements are smaller than the sum of their 
; squared component digits. For example: 10 is larger than 1 squared plus 0 squared; 
; whereas 15 is smaller than 1 squared plus 5 squared.

;(= 8 
(def t1 (range 10))
	
;(= 19 
(def t2 (range 30))
	
;(= 50 
(def t3 (range 100))
	
;(= 50 
(def t4 (range 1000))

(defn sos[x]
  (letfn [(toInt[x] (- (int x) (int \0)))
          (sqr[x] (* x x))
          (ss[z]
            (< z (apply + (map #(-> % toInt sqr) (-> z str seq)))))]
    (count (filter ss x))))

(defn sos[x]
  (letfn [(sqr[x] (* x x)
          (ss[z]
            (< z (apply + (map  (-> z str seq))))))]
    (count (filter ss x))))

(test 23)
(test 10)


(sos (range 3))

(sos t1)
(sos t2)
(sos t3)
(sos t4)


(fn [x]
  (letfn [(toInt[x] (- (int x) (int \0)))
          (sqr[x] (* x x))
          (ss[z]
            (< z (apply + (map #(-> % toInt sqr) (-> z str seq)))))]
    (count (filter ss x))))

;amalloy's solution
(fn [coll]
  (count
   (for [x coll
         :let [digits (map (comp read-string str) (str x))]
         :when (< x (reduce + (map #(* % %) digits)))]
     x)))
