(ns LongestIncreasingSubSeq)


(defn longIncSubSeq [x]
  (loop [f (first x)
         r (rest x)
         v '()
         c 1
         n f]
    (println "c:  " c ",  n:  " n)
    (def t (if (> c (count v))
               (range n (+ c n))
               v))
      (if (empty? r)
        (if (= 1 (count t))
          []
          t)
        (if (= (inc f) (first r))
          (recur (first r) (rest r) t (inc c) n)
          (recur (first r) (rest r) t      1  (first r)) ))))

(defn longIncSubVec [x]
  (loop [v []
         s 0
         c 0]
    (println "v:  " v ",  s:  " s  ", c:  " c)
    (def w 
      (if (> (count (subvec x s c)) (count v))
        (subvec x s c)
        v))
    (println "w:  " w ",  s:  " s  ", c:  " c)
    (if (= c (count x))
      w
      (if (= (inc (nth x c)) (nth x (inc c)))
        (recur w s (inc c))
        (recur w (inc c) (+ c 2))))))

(defn lisv [x]
  (loop [a 0
         b 0
         s 0
         e 1]
    (def f (inc e))
    (if (= e (count x))
      (if (> (- b a) 1) 
        (subvec x a b) 
        [])
      (if (= (inc (nth x (dec e))) (nth x e))
        (if (> (- f s) (- b a))
          (recur s f s f)
          (recur a b s f))
        (recur a b e f)))))

(defn lis [s]
  (->> s
       (partition 2 1)
       (partition-by (partial apply <=))
       (filter (fn [[[a b]]] (< a b)))
       (reduce (fn [m s] (if (> (count s) (count m)) s m)) [])
       (#(cons (ffirst %) (map second %)))))

(lisv [8 3 4 5 6 2])
(lisv [1 0 1 2 3 0 4 5])
(lisv [5 6 1 3 2 7])
(lisv [2 3 3 4 5])
(lisv [4 4 4 4 5])
(lisv [4 4 4 4 4])
  
          
(longIncSubVec [8 3 4 5 6 2])
(longIncSubVec [1 0 1 2 3 0 4 5])
(longIncSubVec [5 6 1 3 2 7])
(longIncSubVec [2 3 3 4 5])
(longIncSubVec [4 4 4 4 5])
(longIncSubVec [4 4 4 4 4])


(longIncSubSeq '(8 3 4 5 6 2))
(longIncSubSeq [1 0 1 2 3 0 4 5])
(longIncSubSeq [5 6 1 3 2 7])
(longIncSubSeq [2 3 3 4 5])
(longIncSubSeq [4 4 4 4 5])
(longIncSubSeq [4 4 4 4 4])

