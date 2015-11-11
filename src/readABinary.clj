(ns readABinary)

;(= 0     
(def t1 "0")
;(= 7     (__ 
(def t2 "111")
;(= 8     (__ 
(def t3 "1000")
;(= 9     (__ 
(def t4 "1001")
;(= 255   (__ 
(def t5 "11111111")
;(= 1365  (__ 
(def t6 "10101010101")
;(= 65535 (__ 
(def t7 "1111111111111111")


(defn rab[x]
  (int
  (:v
  (reduce #(into %1 
                 (if (= %2 \1)
                   {:v (+ (:v %1) (Math/pow 2 (:p %1)))
                    :p (inc (:p %1))}
                     {:p (inc (:p %1))}
                     ))
          {:v 0 :p 0}
          (reverse x)))))

(rab t1)
(rab t2)
(rab t3)
(rab t4)
(rab t5)
(rab t6)
(rab t7)

(defn rab2[x]
  (Integer/parseInt x 2))

(rab2 t1)
(rab2 t2)
(rab2 t3)
(rab2 t4)
(rab2 t5)
(rab2 t6)
(rab2 t7)

(defn rab3[x]
  (reduce #(+ (* %1 2) (if (= %2 \1) 1 0)) 0 x))

(rab3 t1)
(rab3 t2)
(rab3 t3)
(rab3 t4)
(rab3 t5)
(rab3 t6)
(rab3 t7)

reduce #(+ (* %1 2) (if (= %2 \1) 1 0)) 0



#(Integer/parseInt % 2)

