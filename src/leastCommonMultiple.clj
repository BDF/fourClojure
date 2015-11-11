(ns leastCommonMultiple)

;(== 
(def t1 (list 2 3))
  ; 6)
	
;(== 
  
(def t2 (list 5 3 7));
    ; 105)
	
;(== 
(def t3 (list 1/3 2/5)); 2)
	
;(== 
(def t4 (list 3/4 1/6)); 3/2)
	
;(== 
(def t5 (list 7 5/7 2 3/5)); 210)
                           
(defn lcm[& x]
  (loop [r (zipmap x x)]
    (let [m (reduce #(if (< (val %1) (val %2))
                      %1
                      %2) r)]
      (if (apply = (vals r))
        (val m)
        (recur (into r {(key m) (+ (key m) (val m))}))))))

(fn [& x]
  (let [f (fn[z] #(if (< (val %1) (val %2))
                      %1
                      %2) z)]
  (loop [r (zipmap x x)
         m (f r)]
    (if (apply = (vals r))
      (val m)
      (recur (into r {(key m) (+ (key m) (val m))})
             (f r)))))
  
(apply lcm t1)
(apply lcm t2)
(apply lcm t3)
(apply lcm t4)
(apply lcm t5)
  (apply lcm (list 5/7 3/5))

(fn [& x]
  (loop [r (zipmap x x)]
    (def m (reduce #(if (< (val %1) (val %2))
                      %1
                      %2) r))
    (if (apply = (vals r))
      (val m)
      (recur (into r {(key m) (+ (key m) (val m))})))))

(defn lcm2[& x]
  (apply clojure.set/intersection 
         (map #(set (range %1 Integer/MAX_VALUE %1)) x)))

(defn [& x]
  (let [m (reduce #(if (ratio? %2) 
                     (* (denominator %2) %1)
                     (* %2 %1)) 2 x)]
    (apply min (apply clojure.set/intersection (map #(set (range %1 m %1)) x)))))

(apply lcm2 t1)
(apply lcm2 t2)
(apply lcm2 t3)
(apply lcm2 t4)
(apply lcm2 t5)

; sheldon's solution
  (fn [& n] (reduce 
              #(/ (* % %2) 
                  ((fn g [a b] 
                     (if (zero? b) 
                       a 
                       (g b (mod a b)))) % %2)) n))  
  

  (for [[idx elt] (indexed coll) :when (pred elt)] idx))

(some #(and (= 99 (v %)) %) (range 0 (count v)))
(reduce #(if (> %1 %2) %1 %2) v)
(apply min v)

