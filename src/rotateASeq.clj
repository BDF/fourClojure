(ns rotateASeq)

;(= 
(def t1 '(2 [1 2 3 4 5])); '(3 4 5 1 2))
(def t2 '(-2 [1 2 3 4 5])); '(4 5 1 2 3))
(def t3 '(6 [1 2 3 4 5])); '(2 3 4 5 1))
(def t4 '(1 (:a :b :c))); '(:b :c :a))
(def t5 '(-4 (:a :b :c))); '(:c :a :b))


(defn ras[x y]
  (let [f #(concat (rest %) (-> % first list))
        b #(concat (-> % last list) (butlast %))]
    (if (> x 0)
      (take 3 (iterate f y))
      (take (- 0 x) (iterate f y)))))


(defn rasx[x y]
  (let [c (count y)]
    (take c (drop (mod x c) (cycle y)))))

(rasx (first t1) (second t1))
(rasx (first t2) (second t2))
(rasx (first t3) (second t3))
(rasx (first t4) (second t4))
(rasx (first t5) (second t5))
(rasx 2 '(:a :b :c))





        
