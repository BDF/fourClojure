(ns halfTruth)

(def t1 '(false false)); false
(def t2 '(true false)); true
(def t3 '(true)) ; false 
(def t4 '(false true false)) ; true
(def t5 '(true true true)) ;false 
(def t6 '(true true true false)) ;true


(defn ht [& x]
  (reduce #(or %1 %2) x))

(defn ht2 [& x]
  (reduce #(and (or %1 %2) (and %1 %2)) x))
(apply ht2 t1)
(apply ht2 t2)
(apply ht2 t3)
(apply ht2 t4)
(apply ht2 t5)
(apply ht2 t6)

false; false false
true;  true  false
false; true  true
true;  true false
false; true true
true;  false true


(defn ht3 [& x]
  (reduce #(and %1 %2) x))

(defn ht4 [& x]
  (not (contains? #{0, (count x)} (count (filter true? x)))))

(fn [& x]
  (not (contains? #{0, (count x)} (count (filter true? x)))))


(apply ht4 t2) ; true
(apply ht4 t4) ; true
(apply ht4 t6) ; true
(apply ht4 t1) ; false
(apply ht4 t3) ; false
(apply ht4 t5) ; false

(defn ht5 [& x]
  (and (not (every? true? x))
       (some true? x)))

(apply not= t1)
(apply not= t2)
(apply not= t3)
(apply not= t4)
(apply not= t5)
(apply not= t6)

(apply ht5 t2) ; true
(apply ht5 t4) ; true
(apply ht5 t6) ; true

(apply ht5 t1) ; false
(apply ht5 t3) ; false
(apply ht5 t5) ; false

(defn ht4 [& x]
  (not (contains? #{0, (count x)} (count (filter true? x)))))
