(ns binaryTree)


;Write a predicate which checks whether or not a given sequence represents 
; a binary tree. Each node in the tree must have a value, a left child, 
; and a right child.

(def t1 '(:a (:b nil nil) nil))
   ; true)

(def t2  '(:a (:b nil nil)))
;   false)
	
;(= 
(def t3 [1 nil [2 [3 nil nil] [4 nil nil]]])
; true)
	
;(= 
(def t4  [1 [2 nil nil] [3 nil nil] [4 nil nil]])
  ; false)
	
;(= 
(def t5  [1 [2 [3 [4 nil   nil] nil] nil] nil])
  ; true)
	
;(= 
(def t6  [1 [2 [3 [4 false nil] nil] nil] nil])
  ; false)
	
;(= 
(def t7  '(:a nil ()))
  ; false)

(defn bt[x]
  (if (coll? x)
    (let [[v l r] x]
      (and (= (count x) 3) (bt l) (bt r)))
    (nil? x)))

(bt t1)
(bt t2)
(bt t3)
(bt t4)
(bt t5)
(bt t6)
(bt t7)


(fn bt[x]
  (if (coll? x)
    (let [[v l r] x]
      (and (= (count x) 3) (bt l) (bt r)))
    (nil? x)))