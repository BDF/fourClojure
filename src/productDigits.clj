(ns productDigits)


; (= (__ 1 1) [1])
; (= (__ 99 9) [8 9 1])
; (= (__ 999 99) [9 8 9 0 1])

;(Math/ceil (Math/log10 2334567))
;(map #(rem t1 %) 
(defn pd[x y]
  (loop [v (* x y)
         r '()]
    (if (= v 0)
      r
      (recur (quot v 10) (conj r (rem v 10)) ))))

(pd 1 1)
(pd 99 9)
(pd 999 99)


(fn [x y]
  (loop [v (* x y)
         r '()]
    (if (= v 0)
      r
      (recur (quot v 10) (conj r (rem v 10)) ))))

(defn pd2[x y]
  (map (comp read-string str) (str (* x y))))

(pd2 1 1)
(pd2 99 9)
(pd2 999 99)
