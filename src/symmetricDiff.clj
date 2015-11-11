(ns symmetricDiff)


;Write a function which returns the symmetric difference of two sets. 
;  The symmetric difference is the set of items belonging to one but not 
;  both of the two sets.
(def t1 (list #{1 2 3 4 5 6} #{1 3 5 7}))
(def t1a #{2 4 6 7})
	
(def t2 (list #{:a :b :c} #{}))
(def t2a #{:a :b :c})
	
(def t3 (list #{} #{4 5 6}))
(def t3a #{4 5 6})
	
(def t4 (list #{[1 2] [2 3]} #{[2 3] [3 4]}))
(def t4a #{[1 2] [3 4]})


(defn sd[x y]
  (apply
    disj 
    (set (concat x y))
    (#(set (filter x y)))
  )
)

(sd (first t1) (second t1))
(sd (first t2) (second t2))
(sd (first t3) (second t3))
(sd (first t4) (second t4))

(fn [x y]
  (apply
    disj 
    (set (concat x y))
    (#(set (filter x y)))
  )
)


(defn sd2[x y]
  (set (concat
         (remove x y)
         (remove y x)))
)

(sd2 (first t1) (second t1))
(sd2 (first t2) (second t2))
(sd2 (first t3) (second t3))
(sd2 (first t4) (second t4))