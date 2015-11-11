(ns infixCalc)



;(= 7  
(def t1 (list 2 + 5))
	
;(= 42 
(def t2 (list  38 + 48 - 2 / 2))
	
;(= 8  
(def t3 (list 10 / 2 - 1 * 2))
	
;(= 72 
(def t4 (list 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))

(defn ic[x]
  (loop [c x]
    (if (= (count c) 1)
      c
      (recur 
        (cons ((second c) (first c) (nth c 2)) (drop 3 c))))))

(fn[&x]
  (if (= (count x) 1)
    (first x)
    (recur (cons ((second x) (first x) (nth c x)) (drop 3 )))))


(ic t1)
(ic t2)
(ic t3)
(ic t4)

;sheldon's solution:
;(fn i ([r] r) ([l o r & m] (apply i (o l r) m)))

(defn ic2 
  ([r] r)
  ([l o r & m]
    (apply ic2 (o l r) m)))

(apply ic2 t1)
(apply ic2 t2)
(apply ic2 t3)
(apply ic2 t4)

;immo's solution:
(fn [x & y]
  (reduce
    #(let [[o n] %2] (o % n))
    x
    (partition 2 y)))

;daowen's solution:
(fn infix-eval [& args]
  (if (second args)
    (let [[x op y & t] args]
      (recur (cons (op x y) t)))
    (first args)))

;amalloy's solution:
(fn c [x f y & r]
  ((if r
     #(apply c % r) +)
   (f x y)))