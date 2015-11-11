(ns wordSorting)

;Write a function that splits a sentence up into a sorted list of 
;words. Capitalization should not affect sort order and punctuation 
; should be ignored.

(def t1 "Have a nice day.")
;   ["a" "day" "Have" "nice"])

(def t2  "Clojure is a fun language!")
;   ["a" "Clojure" "fun" "is" "language"])

(def t3 "Fools fall for foolish follies.")
;   ["fall" "follies" "foolish" "Fools" "for"])

(defn ws[x]
  (sort-by 
    #(. % toLowerCase) (. x split "[ \\p{Punct}]")))

(ws t1)
(ws t2)
(ws t3)

(fn [x]
   (sort-by 
     #(. % toLowerCase) (. x split "[ \\p{Punct}]")))

#(sort-by clojure.string/lower-case (re-seq #"\w+" %))