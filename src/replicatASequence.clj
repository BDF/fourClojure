(ns replicatASequence)


(def t1 '([1 2 3] 2))
(def t2 '([:a :b] 4))
(def t3 '([4 5 6] 1))
(def t4 '( [[1 2] [3 4]] 2))
(def t5 '([44 33] 2))


(defn ras [x y]
  (reduce concat (map #(repeat y %) x)))

(fn [x y]
  (reduce concat (map #(repeat y %) x)))

(ras (first t1) (second t1))
(ras (first t2) (second t2))
(ras (first t3) (second t3))
(ras (first t4) (second t4))
(ras (first t5) (second t5))


(fn r [s t] (mapcat #(repeat t %) s))
(fn [l n] (mapcat #(repeat n %) l))
(fn [c n] (mapcat #(repeat n %) c))