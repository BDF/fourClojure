(ns recogCards)

; A standard American deck of playing cards has 
; four suits - spades, hearts, diamonds, and clubs - and thirteen cards in each suit. 
; Two is the lowest rank, followed by other integers up to ten; then the jack, queen, 
; king, and ace.

;It's convenient for humans to represent these cards as suit/rank pairs, such as H5 or DQ: 
;the heart five and diamond queen respectively. But these forms are not convenient for 
;programmers, so to write a card game you need some way to parse an input string into 
;meaningful components. For purposes of determining rank, we will define the cards to be 
;valued from 0 (the two) to 12 (the ace)

; Write a function which converts (for example) the string "SJ" into a map of 
; {:suit :spade, :rank 9}. A ten will always be represented with the single 
; character "T", rather than the two characters "10".

;{:suit :diamond :rank 10} 
(def t1 "DQ")
	
;(= {:suit :heart :rank 3} 
(def t2  "H5")
	
;(= {:suit :club :rank 12} 
(def t3 "CA")

(def t4a (map str '[S2 S3 S4 S5 S6 S7 S8 S9 ST SJ SQ SK SA]))

;(= (range 13) 
(def t4 (map (comp :rank rc str)
             '[S2 S3 S4 S5 S6 S7 S8 S9 ST SJ SQ SK SA]))

; maybe convert str to char
(def suit {"D" :diamond "H" :heart "C" :club "S"  :S})
(def rank (apply hash-map
                 (interleave 
                   (concat (map str (range 2 10) ) '("T" "J" "Q" "K" "A"))
                   (range 0 13))))

(defn rc[[s r]]
  (let [rank (apply hash-map
                 (interleave 
                   (concat (map str (range 2 10) ) '("T" "J" "Q" "K" "A"))
                   (range 0 13)))
        suit {"D" :diamond "H" :heart "C" :club "S"  :S}]
    {:suit (get suit (str s)) :rank (get rank (str r))}))
    ;(apply (fn [x y] {:suite (get suit x) :rank (get rank y)}) (map str (seq x)))))

(rc t1)
(rc t2)
(rc t3)
(map rc t4a)



(fn [[s r]]
  (let [rank (apply hash-map
                 (interleave 
                   (concat (map str (range 2 10) ) '("T" "J" "Q" "K" "A"))
                   (range 0 13)))
        suit {"D" :diamond "H" :heart "C" :club "S"  :S}]
    {:suit (get suit (str s)) :rank (get rank (str r))}))

; amalloy
(defn rc2  [[s r]]
  (println s r)
  {:suit ({\S :spade, \H :heart, \D :diamond, \C :club} s)
   :rank ({\A 12 \K 11 \Q 10 \J 9 \T 8}
          r (- (int r) 50))})
(rc2 t1)
(rc2 t2)
(rc2 t3)
