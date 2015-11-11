(ns flattenASequence)


(def t1 '((1 2) 3 [4 [5 6]]))
(def t2 ["a" ["b"] "c"])
(def t3 '((((:a)))))


;; (cons 2 (cons 1 '()))
;; (2 1)
;;(conj (conj '() 1 ) 2)
;; (2 1)


(defn myF [x]
  (loop [c x
         r []]
    (if (empty? c)
      r
      (if (coll? (first c))
        (recur (concat (first c) (rest c)) r)
        (recur (rest c) (conj r (first c)))))))

(defn myF2 [c]
  (if (coll? c)
    (mapcat myF2 c)
    [c]))

(fn f [x] (if (coll? x) (mapcat f x) [x]))

(myF t1)
(myF t2)
(myF t3)


(myF2 t1)
(myF2 t2)
(myF2 t3)


#(loop [c %
        r []]
    (if (empty? c)
      r
      (if (sequential? (first c))
        (recur (concat (first c) (rest c)) r)
        (recur (rest c) (conj r (first c))))))
