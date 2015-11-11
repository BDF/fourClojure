(ns interposeASeq)


(def t1 '(0 [1 2 3])) ; [1 0 2 0 3])
(def t2 '(", " ["one" "two" "three"])) ; ("one" ", " "two" ", " "three")
;; (apply str ("one" ", " "two" ", " "three"))
;; 

(def t3 '(:z [:a :b :c :d])); [:a :z :b :z :c :z :d])


(defn ias[x y]
  (rest (mapcat #(list x %1) y)))

(defn ias2[x y]
  (rest (mapcat list (repeat x) y)))

(ias (first t1) (second t1))
(ias (first t2) (second t2))
(ias (first t3) (second t3))

(ias2 (first t1) (second t1))
(ias2 (first t2) (second t2))
(ias2 (first t3) (second t3))

(mapcat list (repeat 5) '(3 3 3 3))
(rest '(5 3 5 3 5 3 5 3))



;(fn [x y] (drop-last (mapcat #(list %1 x) y)))

;#