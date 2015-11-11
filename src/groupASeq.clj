(ns groupASeq)

(= 
  (__ 
     #(> % 5) [1 3 6 8]) 
   {false [1 3], true [6 8]})
	
(= (__ 
     #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
	
(= (__ 
     count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

;(apply map vector (vector (map #(> % 5) [1 3 6 8]) [1 3 6 8]))

;(def users [{:name "James" :age 26}  {:name "John" :age 43}])
;#'user/users
;user=> (update-in users [0 :age] inc)
;[{:name "James", :age 26} {:name "John", :age 44}]


(defn gas[f s]
  (reduce #(assoc %1 s
                  (f %2)
                  (conj (get %1 (f %2) []) %2)) {} s))
(gas #(> % 5) [1 3 6 8])
(gas #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
(gas count [[1] [1 2] [3] [1 2 3] [2 3]])


(defn gas2[f s]
  (apply merge-with into
        (for [x s]
          {(f x) [x]})))
  
(gas2 #(> % 5) [1 3 6 8])
(gas2 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
(gas2 count [[1] [1 2] [3] [1 2 3] [2 3]])
                 
;(reduce (fn[x y] update-in x [(> y 5)] (cons ) {} [1 3 6 8])
                 
;(apply f x '(y z)) is equivalent to (f x y z), so your code is equivalent to 
;(map list '(1 a) '(2 b) '(3 c)).

#(apply merge-with into
        (for [x %2]
          {(% x) [x]}))

; (for [x %2]  {(% x) [x]})  
;;  -->
;  ({1/2 [[1 2]]} {1/2 [[2 4]]} {2/3 [[4 6]]} {1/2 [[3 6]]})
;; -->
;(merge-with into 
;            {1/2 [[1 2]]} 
;            {1/2 [[2 4]]} 
;            {2/3 [[4 6]]} 
;            {1/2 [[3 6]]})
;(apply merge-with 
;       into 
;       (list {1/2 [[1 2]]} {1/2 [[2 4]]} {2/3 [[4 6]]} {1/2 [[3 6]]}))

                       
(fn [f s]
  (reduce #(assoc %1 
                  (f %2)
                  (conj (get %1 (f %2) []) %2)) {} s))
