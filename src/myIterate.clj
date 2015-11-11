(ns myIterate)


(def t1 (list 5 (fn [x] (* 2 x)) 1)) ; [1 2 4 8 16])
(def t2 (list 100 inc 0)); (take 100 (range))
(def t3 (list 9 #(inc (mod % 3)) 1)); (take 9 (cycle [1 2 3])))


(defn myIter 
  ([t f v] (myIter t f v []))
  ([t f v a]
    (if (= t 0)
      a
      (recur (dec t) f (f v) (conj a v)))))

(myIter (first t1) (second t1) (nth t1 2))
(myIter (first t2) (second t2) (nth t2 2))
(myIter (first t3) (second t3) (nth t3 2))

(defn myIter2 [t f v]
  (reduce #(conj %1 (f %2)) [] (repeat t v)))

(myIter2 (first t1) (second t1) (nth t1 2))
(myIter2 (first t2) (second t2) (nth t2 2))
(myIter2 (first t3) (second t3) (nth t3 2))

(defn positive-numbers
    ([] (positive-numbers 1))
    ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn myIt [f v]
  (lazy-seq (cons v (myIt f (f v)))))

(take (first t1) (myIt (second t1) (nth t1 2)))
(take (first t2) (myIt (second t2) (nth t2 2)))
(take (first t3) (myIt (second t3) (nth t3 2)))


(fn myI [f v] (lazy-seq (cons v (myI f (f v)))))
(def f1 (fn myI [f v] (lazy-seq (cons v (myI v (f v))))))

(take (first t1) ((fn myI [f v] (lazy-seq (cons v (myI f (f v))))) (second t1) (nth t1 2)))
(take (first t2) (f1 (second t2) (nth t2 2)))
(take (first t3) (f1 (second t3) (nth t3 2)))

; Iterate written by AMalloy at 4Clojure.com
(defn malloyIt [f x]
  (reductions (fn [a _] (f a))
              x
              (range)))




