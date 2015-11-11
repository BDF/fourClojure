(ns AnagramFinder)

(def t1 ["meat" "mat" "team" "mate" "eat"])
(def e1 #{#{"meat" "team" "mate"}})

(def t2 ["veer" "lake" "item" "kale" "mite" "ever"])
(def e2 #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


(set (map set (map second (group-by sort t1))))
(set (map set 
          (vals (group-by sort t1))
          ))


((comp #(map set %) #(filter (fn[x] (> (count x) 1)) %) set vals) )

((fn [y] (vals (group-by sort y))) t1)


((fn[x] (filter #(> (count %) 1) (vals (group-by sort x)))) t1)
((fn[x] (set (map set (filter #(> (count %) 1) (vals (group-by sort x)))))) t1)
(
 (fn[x] (set (map set (filter #(> (count %) 1) (vals (group-by sort x)))))) t2)

#(->> % (group-by sort) vals (filter second) (map set) set)

#{#{"mat"} #{"mate" "meat" "team"} #{"eat"}}

