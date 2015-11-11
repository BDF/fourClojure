(ns pascalsTriangle)

;Write a function that, for any given input vector of numbers, returns an infinite 
; lazy sequence of vectors, where each next one is constructed from the previous 
; following the rules used in Pascal's Triangle. For example, for [3 1 2], 
; the next row is [3 4 3 2].

(= (second 
     
(def t1 [2 3 2]);
;    [2 5 5 2])
test not run	
(= (take 5 
         (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
test not run	
(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
test not run	
(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))

(defn pt[x]
  (let [v (cons 0 (conj x 0))]

    
     
(defn ptx[x]
  (let [f #(for [i (range 0 (dec (count %)))]
             (+ (nth % i) (nth % (inc i))))]
    (lazy-seq 
      (cons x (ptx (f (concat '(0) x '(0))))))))
    
(fn pt[x]
  (let [f #(for [i (range 0 (dec (count %)))]
             (+ (nth % i) (nth % (inc i))))]
    (lazy-seq 
      (cons x (pt (f (concat '(0) x '(0))))))))

(cons 0 (conj t1 0))
(range 0 (count t1))
     
(nth (cons 0 (conj t1 0)) 2)
     
(pt t1)
     
(take 5 (ptx [1]))
(take 2 (ptx [3 1 2]))
     
     (pt [1 1])
     

    (let [v (concat '(0) t1 '(0))]
      (for [i (range 0 (dec (count v)))]
        (+ (nth v i) (nth v (inc i)))))
    
    
(for [i (range 0 (count (concat '(0) t1 '(0))))]
  i)
  

; sheldon's solution    
(fn [s] (iterate #(vec (map + (cons 0 %) (conj % 0))) s))