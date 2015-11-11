(ns introToIterate)


(take 5 (iterate #(+ 3 %) 1))

'(1 4 7 10 13)
'(1 4 7 10 0xD)
(range 1 16 3)