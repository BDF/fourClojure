(ns interleaveTwoSeq)


(def t1 '([1 2 3] [:a :b :c])) ; '(1 :a 2 :b 3 :c)
(def t2 '([1 2] [3 4 5 6])) ;  '(1 3 2 4)
(def t3 '([1 2 3 4] [5])) ;  '( [1 5])
(def t4 '([30 20] [25 15])) ; [30 25 20 15])


(defn its[x y]
  (mapcat #(list %1 %2) x y))

(its (first t1) (second t1))
(its (first t2) (second t2))
(its (first t3) (second t3))
(its (first t4) (second t4))

;(fn [x y] (mapcat #(list %1 %2) x y))



