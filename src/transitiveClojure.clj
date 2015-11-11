(ns transitiveClojure)


d
r:   #{}
t:   [27 9]
(def c (list  [9 3] [8 4] [4 2]))
(def r 
f:   ([27 9] [27 3] [27 9] [27 9] [27 9])
keep:   ([27 9] [27 9] [27 9] [27 9])
concat:   ([8 4] [4 2])


(defn tc[x]
  (let [keys (map first x)]
  
  x))
  
(let 
  [divides        #{[8 4] [9 3] [4 2] [27 9]}]
  (= (tc divides) #{[8 4] [9 3] [4 2] [27 9] [27 3] [8 2]}))
	
(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (tc more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"] ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
	
(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (tc progeny)
     #{["father" "son"] ["father" "grandson"] ["uncle" "cousin"] ["son" "grandson"]}))


(def t1 #{[8 4] [9 3] [4 2] [27 9]})
(def t2 #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
(def t3 #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]})

(take 10 (iterate (partial + 2) 0))
;user=> (take 20 (iterate (partial + 2) 0))
;user=> (def powers-of-two (iterate (partial * 2) 1))
;user=> (def fib (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))

  ; conj
  ; disj
  ; contains?
 
(defn tc[x]
  (reduce #(do
             (println %1 %2 x)
             (if (= (second %1) (first %2))
               #{ [(first %1) (second %2)] %1}
               (set %1)))
          x))
  
  


(tc t1)
(tc t2)