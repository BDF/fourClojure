(ns indexSequences)

; Transform a sequence into a sequence of pairs containing 
; the original elements along with their index.
  
(def t1 [:a :b :c])
(def t1a [[:a 0] [:b 1] [:c 2]])

(def t2 [0 1 3]);
(def t2a '((0 0) (1 1) (3 2)))
	
(def t3 [[:foo] {:bar :baz}]) 
(def t3a [[[:foo] 0] [{:bar :baz} 1]])


(defn is[x]
  (map-indexed #(list %2 %1) x))


(is t1)
(is t2)
(is t3)

(= (is t1) t1a)
(= (is t2) t2a)
(= (is t3) t3a)


;sheldon's solution:
(fn [s] (map vector s (range)))

;immo's solution:

#(map list % (range))