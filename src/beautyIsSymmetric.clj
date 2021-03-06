(ns beautyIsSymmetric)

;and(
;     and(
;          or(global:FMau:lincoln, author:lincoln), 
;          filter(bdl:1007527)), 
;     filter(meta.collection:or(MSTAR,Patents)))?
;

(def t1 '(:a 
           (:b nil nil) 
           (:b nil nil))); true)

(def t2 '(:a 
           (:b nil nil) 
           nil)); false)
(def t3  '(:a 
            (:b nil nil) 
            (:c nil nil))); false)
(def t4 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]);   true)

(def t4a [1 
     	  [2 nil 
           [3 
            [4 [5 nil nil] [6 nil nil]] nil]]
          [2 
           [3 nil 
            [4 [6 nil nil] 
             [5 nil nil]]] nil]])

(def t5  [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]);   false)
(def t6  [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]]);   false)


(defn balanced[x]
  (loop [[v l r] x]
    (list (identity v)
          (if (identity l) (balanced l))
          (if (identity r) (balanced r)))))

(defn s[[v l r]]
      (if (or (nil? l) (nil? r))
      	  (and (nil? l) (nil? r))
	  (and (= (first l) (first r)) 
	       (s (list v (nth l 1) (nth r 2)))
	       (s (list v (nth l 2) (nth r 1))))))

(defn s[x]
      (letfn
	[s
      (if (or (nil? l) (nil? r))
      	  (and (nil? l) (nil? r))
	  (and (= (first l) (first r)) 
	       (s (list v (nth l 1) (nth r 2)))
	       (s (list v (nth l 2) (nth r 1))))))

boolean mirrorEquals(BTree left, BTree right) {
  if (left == null || right == null) return left == null && right == null;
  return left.value == right.value && 
  mirrorEquals(left.left, right.right) && 
  mirrorEquals(left.right, right.left);
}
    
(bix t1)
(bix t2)
(bix t3)
(bix t4)
(bix t5)
(bix t6)
   
