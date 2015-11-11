(ns myRange)


(#(loop [x %1 z []] (if (= x %2) z (recur (inc x) (conj z x))))  1 4)
(#(loop [x %1 z []] (if (= x %2) z (recur (inc x) (conj z x))))  -2 2)
(#(loop [x %1 z []] (if (= x %2) z (recur (inc x) (conj z x))))  5 8)

(#(take-while (partial > %2 ) (iterate inc %1)) 1 4)
(#(take-while (partial > %2 ) (iterate inc %1)) -2 2)
(#(take-while (partial > %2 ) (iterate inc %1)) 5 8)

(#(take (- %2 %1) (iterate inc %1)) 1 4)
(#(take (- %2 %1) (iterate inc %1)) -2 2)
(#(take (- %2 %1) (iterate inc %1)) 5 8)

