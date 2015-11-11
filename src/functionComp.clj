(ns functionComp)

;Write a function which allows you to create function compositions. 
; The parameter list should take a variable number of functions, and 
; create a function applies them from right-to-left.

;(= [3 2 1] ((__ rest reverse) [1 2 3 4]))
(def t1 (list rest reverse))

;(= 5 ((__ (partial + 3) second) [1 2 3 4]))
(def t2 (list (partial + 3) second))
  
;(= true ((__ zero? #(mod % 8) +) 3 5 7 9))
(def t3 (list zero? #(mod % 8) +))

;(= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
(= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
(def t4 #(.toUpperCase %) #(apply str %) take)

(defn fx[& x]
  (fn [& v] 
    (first (reduce #(list (apply %2 %1)) v (reverse x)))))

((fx rest reverse) [1 2 3 4])
((fx (partial + 3) second) [1 2 3 4])
((fx zero? #(mod % 8) +) 3 5 7 9)
((fx #(.toUpperCase %) #(apply str %) take) 5 "hello world")

;(fn [& x]
;  (fn [& v] 
;    (first (reduce #(list (apply %2 %1)) v (reverse x)))))
      
(defn fx2[& x]
  (fn [& v] 
    (loop [f (reverse x)
           r v]
      (if (empty? f)
        (first r)
        (recur (rest f) (list (apply (first f) r)))))))

((fx2 rest reverse) [1 2 3 4])
((fx2 (partial + 3) second) [1 2 3 4])
((fx2 zero? #(mod % 8) +) 3 5 7 9)
((fx2 #(.toUpperCase %) #(apply str %) take) 5 "hello world")

