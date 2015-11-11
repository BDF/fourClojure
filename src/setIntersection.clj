(ns setIntersection)



(def t1 '(#{0 1 2 3} #{2 3 4 5})); #{2 3})
(def t2 '(#{0 1 2} #{3 4 5})); #{})
(def t3 '(#{:a :b :c :d} #{:c :e :a :f :d})); #{:a :c :d})


(defn si [x y]
  (set (filter #(contains? x %) y)))

(si (first t1) (second t1))
(si (first t2) (second t2))
(si (first t3) (second t3))

(fn [x y]
  (set (filter #(contains? x %) y)))


(defn si2[x y]
  ((comp set keep) x y))

(si2 (first t1) (second t1))
(si2 (first t2) (second t2))
(si2 (first t3) (second t3))

(defn si3[x y]
  (#(set (filter % %2)) x y))

(si3 (first t1) (second t1))
(si3 (first t2) (second t2))
(si3 (first t3) (second t3))
  