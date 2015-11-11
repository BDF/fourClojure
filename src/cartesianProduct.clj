(ns cartesianProduct)


;(def t1 (list #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"}))
(def t1 (list #{"ace" "king" "queen"} #{"S" "H" "D" "C"}))

(def t1a #{["ace"   "S"] ["ace"   "H"] ["ace"   "D"] ["ace"   "C"]
           ["king"  "S"] ["king"  "H"] ["king"  "D"] ["king"  "C"]
           ["queen" "S"] ["queen" "H"] ["queen" "D"] ["queen" "C"]})

(def t2 (list #{1 2 3} #{4 5}))
(def t2a #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(def t3 (list (into #{} (range 10))
              (into #{} (range 30))))



(defn cartProd [x y]
  (into #{} (for [a x
                  b y]
              [a b])))

#(into #{} (for [a %1
                 b %2]
             [a b]))


(= (cartProd (first t1) (second t1)) t1a)
(= (cartProd (first t2) (second t2)) t2a)
(count (cartProd (first t3) (second t3)))


; daowen's solution:
(fn cart [x y]
  (set (mapcat #(map (partial vector %) y) x)))

; amalloy's solution:
#(set (for [x % y %2] [x y]))
