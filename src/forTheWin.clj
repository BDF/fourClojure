(ns forTheWin)

[0 1] 1
[2 3] 5
[4 5] 9
[6 7] 13


(range 1 40 4)

(for [x (range 40)
            :when (= 1 (rem x 4))]
        x)

(for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z)

(for [[x y] (partition 2 (range 20))]
        (+ x y))