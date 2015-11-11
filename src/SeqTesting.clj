

(def t1 {:a 1, :b 2})
(def t2 (range (rand-int 20)))
(def t3 [1 2 3 4 5 6])
(def t4 #{10 (rand-int 5)})
(def t5 [{} #{} [] ()])



(foo )(inc 1)


(comment 
  (= :map (__ {:a 1, :b 2}))
(= :list (__ (range (rand-int 20))))
(= :vector (__ [1 2 3 4 5 6]))
(= :set (__ #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map __ [{} #{} [] ()]))

  )
