(ns palindrome)


(defn detect [v]
  (let [t (range (count v))
        e (reverse t)]
    (for [x t
          :while (<= x (nth e x))]
      (= (nth v x) (nth v (nth e x))))))


(detect '(1 2 3 4 5))
(detect "racecar")
(detect [:foo :bar :foo])
(detect '(1 1 3 3 1 1))
(detect  '(:a :b :c))

(defn detect2 [v]
  (reduce #(and %1 %2) 
          (for [x (range (int (/ (count v) 2)))]
            (= (nth v x) (nth v (- (count v) (inc x)))))))
(detect2 '(1 2 3 4 5))
(detect2 "racecar")
(detect2 [:foo :bar :foo])
(detect2 '(1 1 3 3 1 1))
(detect2 '(:a :b :c))

(defn detect3 [v]
  (loop [t true
         x (take (int (/ (count v) 2)) v)
         r (reverse v)]
    (println t x r)
    (if (empty? x)
      t
      (recur (and t (= (first x) (first r))) (rest x) (rest r)))))

(detect3 '(1 2 3 4 5))
(detect3 "racecar")
(detect3 [:foo :bar :foo])
(detect3 '(1 1 3 3 1 1))
(detect3 '(:a :b :c))

(defn detect4 [v]
  (reduce #(and %1 %2) (map #(= %1 %2) v (reverse v)))
  )

(detect4 '(1 2 3 4 5))
(detect4 "racecar")
(detect4 [:foo :bar :foo])
(detect4 '(1 1 3 3 1 1))
(detect4 '(:a :b :c))

(fn[v]
  (reduce #(and %1 %2) (map #(= %1 %2) v (reverse v))))

(defn detect5 [v]
  (= (seq v) (reverse v))
  )

(detect5 '(1 2 3 4 5))
(detect5 "racecar")
(detect5 [:foo :bar :foo])
(detect5 '(1 1 3 3 1 1))
(detect5 '(:a :b :c))


(defn winnow [pred coll]
  (let [pvs (map #(vector (pred %) %) coll)]
    [(for [[p v] pvs :when p] v)
     (for [[p v] pvs :when (not p)] v)]))

(defn winnow [pred coll]
  (reduce (fn [[a b] x]
            (if (pred x)
              [(conj a x) b]
              [a (conj b x)]))
          [[] []]
          coll))


(fn [v]
  (reduce #(and %1 %2) 
          (for [x (range (int (/ (count v) 2)))]
            (= (nth v x) (nth v (- (count v) (inc x)))))))

(defn testing[& vals]
  (list ~@vals))


(detect2 '(1 2 3 4 5))
(detect2 "racecar")
(detect2 [:foo :bar :foo])
(detect2 '(1 1 3 3 1 1))
(detect2 '(:a :b :c))
