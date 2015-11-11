(ns reverseASet)


(defn reverseASet[a]
  (for [x (range (dec (count a)) -1 -1)]
    (nth a x)))
(reverseASet [1 2 3 4 5])
(reverseASet (sorted-set 5 7 2 7))
(reverseASet [[1 2][3 4][5 6]] )

(defn reverseASet2[a]
  (for [x (range 1 (inc (count a)))]
    (first (take-last x a))))
(reverseASet2 [1 2 3 4 5])
(reverseASet2 (sorted-set 5 7 2 7))
(reverseASet2 [[1 2][3 4][5 6]] )


(defn reverseASet3[a]
  (reduce #(conj %1 %2) nil a))

(fn[x] (reduce #(conj %1 %2) nil x)

(reduce #(list %1 %2) nil '(1 2 3))

(reverseASet3 [1 2 3 4 5])
(reverseASet3 (sorted-set 5 7 2 7))
(reverseASet3 [[1 2][3 4][5 6]] )
