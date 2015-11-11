(ns splitSequence)

(def t1 '(3 [1 2 3 4 5 6])); [[1 2 3] [4 5 6]])
(def t2 '(1 [:a :b :c :d])); [[:a] [:b :c :d]])
(def t3 '(2 [[1 2] [3 4] [5 6]])); [[[1 2] [3 4]] [[5 6]]])


(defn ss[v l]
  [(take v l) (drop v l)])
  
(fn [v l] [(take v l) (drop v l)])

#(conj [] (take %1 %2) (drop %1 %2))




(ss (first t1) (second t1))
(ss (first t2) (second t2))
(ss (first t3) (second t3))
  