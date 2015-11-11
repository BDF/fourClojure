(ns dropEveryNthItem)


(def t1 '([1 2 3 4 5 6 7 8] 3)); [1 2 4 5 7 8])
(def t2 '([:a :b :c :d :e :f] 2)) ; [:a :c :e])
(def t3 '([1 2 3 4 5 6] 4)); [1 2 3 5 6])


(defn dropENth[l v]
  (mapcat #(if (= (count %) v) (drop-last %) %) (partition-all v l)))

(defn den[coll n]
  (keep-indexed #(when (not= (dec n) (mod % n)) %2) coll))


(fn [l v] (mapcat #(if (= (count %) v) (drop-last %) %) (partition-all v l)))


(dropENth (first t1) (second t1))
(dropENth (first t2) (second t2))
(dropENth (first t3) (second t3))


(den (first t1) (second t1))
(den (first t2) (second t2))
(den (first t3) (second t3))




