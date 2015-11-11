(ns gcd)


(def t1 '(2 4)); 2
(def t2 '(10 5)); 5)
(def t3 '(5 7)); 1)
(def t4 '(1023 858)); 33)

(defn myGCD2 [x y]
  (map-indexed #(if (and (= (rem (max x y) %2) 0)
                         (= (rem (min x y) %2) 0))
                         (inc %1) -1) (range 1 (inc (min x y)))))
               
(myGCD2 (first t1) (second t1))
(myGCD2 (first t2) (second t2))
(myGCD2 (first t3) (second t3))
(myGCD2 (first t4) (second t4))


(defn myGCD3 [x y]
  (map #(if (and (= (rem (max x y) %) 0)
                 (= (rem (min x y) %) 0))
          %1 -1) (range 1 (inc (min x y)))))
               
(myGCD3 (first t1) (second t1))
(myGCD3 (first t2) (second t2))
(myGCD3 (first t3) (second t3))
(myGCD2 (first t4) (second t4))

(defn myGCD4 [x y]
  (reduce #(if (and (= (rem (max x y) %2) 0)
                    (= (rem (min x y) %2) 0))
             %2
             %1)
          (range 1 (inc (min x y)))))
               
(myGCD4 (first t1) (second t1))
(myGCD4 (first t2) (second t2))
(myGCD4 (first t3) (second t3))
(myGCD4 (first t4) (second t4))


;(fn gcd [a b] (if (zero? b) a (gcd b (mod a b))))
