(ns TreesIntoTables)

;Because Clojure's for macro allows you to "walk" over multiple sequences in a
; nested fashion, it is excellent for transforming all sorts of sequences. If 
; you don't want a sequence as your final output (say you want a map), you are 
; often still best-off using for, because you can produce a sequence and feed it 
; into a map, for example.

; For this problem, your goal is to "flatten" a map of hashmaps. Each key in your 
; output map should be the "path"1 that you would have to take in the original map
; to get to a value, so for example {1 {2 3}} should result in {[1 2] 3}. 
; You only need to flatten one level of maps: if one of the values is a map,
; just leave it alone.

;1 That is, (get-in original [k1 k2]) should be the same as (get result [k1 k2])


(def t1 '{a {p 1, q 2}
          b {m 3, n 4}})
;   '{[a p] 1, [a q] 2
;     [b m] 3, [b n] 4})
	
(def t2 '{[1] {a b c d}
         [2] {q r s t u v w x}})

;   '{[[1] a] b, [[1] c] d,
;     [[2] q] r, [[2] s] t,
;     [[2] u] v, [[2] w] x})
	
(def t3  '{m {1 [a b c] 3 nil}})
  
;  '{[m 1] [a b c], [m 3] nil})

(defn tit[x]
  (into {} (for [k (keys x)
                 k2 (keys (get x k))]
             [[k k2] (get-in x [k k2])])))

  

(tit t1)
(tit t2)
(tit t3)

(fn[x]
  (into {} (for [k (keys x)
                 k2 (keys (get x k))]
             [[k k2] (get-in x [k k2])])))


;daowen's solution:
#(into {} 
       (for [[i m] %, 
             [j v] m] 
         [[i j] v]))
