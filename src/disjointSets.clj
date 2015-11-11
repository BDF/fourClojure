(ns disjointSets)

; Given a set of sets, create a function which returns true if no 
; two of those sets have any elements in common1 and false 
; otherwise. Some of the test cases are a bit tricky, so pay a 
; little more attention to them.

(def t1 #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
(def t1a true)
	
(def t2 #{
          #{:a :b :c :d :e}
          #{:a :b :c :d}
          #{:a :b :c}
          #{:a :b}
          #{:a}})
(def t2a false)
	
(def t3 #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
(def t3a true)
	
(def t4 #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
(def t4a  true)
	
(def t5 #{
          #{'(:x :y :z) '(:x :y) '(:z) '()}
          #{#{:x :y :z} #{:x :y} #{:z} #{}}
          #{'[:x :y :z] [:x :y] [:z] [] {}}})
(def t5a false)
	
(def t6 #{
          #{(= "true") false}
          #{:yes :no}
          #{(class 1) 0}
          #{(symbol "true") 'false}
          #{(keyword "yes") ::no}
          #{(class '1) (int \0)}})
(def t6a  false)
	
(def t7 #{#{distinct?}
          #{#(-> %) #(-> %)}
          #{#(-> %) #(-> %) #(-> %)}
          #{#(-> %) #(-> %) #(-> %)}})
(def t7a true)
	
(def t8 #{
          #{(#(-> *)) + (quote mapcat) #_ nil}
          #{'+ '* mapcat (comment mapcat)}
          #{(do) set contains? nil?}
          #{, , , #_, , empty?}}
  )
(def t8a false)

(def s1          #{(#(-> *)) + (quote mapcat) #_ nil})
(def s2 #{'+ '* mapcat (comment mapcat)})
(def s3   #{(do) set contains? nil?})
(def s4    #{, , , #_, , empty?})

(defn ds[x]
  (every? true?
               (for [a x
                     b x :when (not= a b)]
                 (empty? (clojure.set/intersection a b))))
   )

(ds t1) ; true
(ds t2) ; false 
(ds t3) ; true 
(ds t4) ; true
(ds t5) ; false
(ds t6) ; false
(ds t7) ; true
(ds t8) ; false

#(apply distinct? (apply concat %))
;daowen's solution:
#(every?
  empty?
  (for [x % y % :when (not= x y)]
    (clojure.set/intersection x y)))



(fn ds[x]
               (for [a (map vector (range) x)
                     b (map vector (range) x) :when (not (= (first a) (first b)))]

    (empty? (#(set (filter % %2)) (second a) (second b)))))

(fn ds[x]
               (for [a (map vector (range) x)
                     b (map vector (range) x) :when (not (= (first a) (first b)))]
    (empty? (clojure.set/intersection (second a) (second b)))))

((fn ds[x]
   (every? true?
               (for [a (map vector (range) x)
                     b (map vector (range) x) :when (not (= (first a) (first b)))]
    (empty? (clojure.set/intersection (second a) (second b)))))) t8)
