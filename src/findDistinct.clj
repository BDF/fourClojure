(ns findDistinct)

(def t1 [1 2 1 3 1 2 4]); [1 2 3 4])
(def t2 [:a :a :b :b :c :c]) ; [:a :b :c])
(def t3 '([2 4] [1 2] [1 3] [1 3])) ; '([2 4] [1 2] [1 3]))
(def t4 (range 50)) ;(range 50))


(defn fd[x]
  (loop [y x
         s #{}
         r []]
    (if (empty? y)
      r
      (if (contains? s (first y))
        (recur (rest y) s r)
        (recur (rest y) 
               (conj s (first y))  
               (conj r (first y)))))))

(fd t1)
(fd t2)
(fd t3)
(= (fd t4) (range 50))

(defn fd2[x]
  (first (reduce #(if (not (contains? (nth %1 1) %2))
                    (list (conj (nth %1 0) %2)
                          (conj (nth %1 1) %2))
                    %1)
                 '([] #{}) x)))

(fd2 t1)
(fd2 t2)
(fd2 t3)
(= (fd t4) (range 50))

(defn fd3[x]
  (reduce #(if (not-any? #{%2} %1)
             (conj %1 %2)
             %1) [] x))

(fd3 t1)
(fd3 t2)
(fd3 t3)
(= (fd t4) (range 50))

(fn [x]
  (reduce #(if (not-any? #{%2} %1)
             (conj %1 %2)
             %1) [] x))


(fn [coll]
  ((fn dist [prev coll]
     (lazy-seq
      (when-let [[x & xs] (seq coll)]
        (let [more (dist (conj prev x) xs)]
          (if (contains? prev x)
            more
            (cons x more))))))
   #{} coll))
