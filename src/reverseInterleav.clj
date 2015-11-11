(ns reverseInterleav)


(def t1 '([1 2 3 4 5 6] 2)); '((1 3 5) (2 4 6)))
(def t2 (list (range 9) 3)); '((0 3 6) (1 4 7) (2 5 8)))
(def t3 (list (range 10) 5)); '((0 5) (1 6) (2 7) (3 8) (4 9)))

(defn ril [l v]
  (loop [c v
         r l
         a []]
    (if (= c 0)
      a
      (recur (dec c) (rest r) (conj a (take-nth v r))))))
(ril (first t1) (second t1))
(ril (first t2) (second t2))
(ril (first t3) (second t3))
; (take-nth y x))

(defn ril2[l v]
  (map #(drop (first %1) (second %1)) 
       (keep-indexed #(list %1 %2) 
                     (reduce #(conj %1 %2) '() (repeat v l)))))
(ril2 (first t1) (second t1))
(ril2 (first t2) (second t2))
(ril2 (first t3) (second t3))

(defn ril3[l v]
  (keep-indexed #(take-nth v (drop %1 %2)) (repeat v l)))
(ril3 (first t1) (second t1))
(ril3 (first t2) (second t2))
(ril3 (first t3) (second t3))

;(fn [l v]
;  (keep-indexed #(take-nth v (drop %1 %2)) (repeat v l)))


;
;(apply f x '(y z)) is equivalent to (f x y z), so your code is equivalent to 
;(map list '(1 a) '(2 b) '(3 c)).
;
; When called with multiple lists, map iterates the lists in parallel and calls the 
; given function with one element from each list for each element (i.e. the first 
; element of the result list is the result of calling the function with the first 
; element of each list as its arguments, the second is the result for the second elements etc.).

; So (map list '(1 a) '(2 b) '(3 c)) first calls list with the first elements of the lists
; (i.e. the numbers) as arguments and then with the second elements (the letters). 
; So you get ((list 1 2 3) (list 'a 'b 'c)).

(defn ril4[l v]
  (apply map list (partition v l)))

(ril4 (first t1) (second t1))
(ril4 (first t2) (second t2))
(ril4 (first t3) (second t3))






