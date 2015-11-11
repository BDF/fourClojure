(ns FilterPerfectSquares)


(def t1 "4,5,6,7,8,9")
(def e1 "4,9")

(def t2 "15,16,25,36,37")
(def e2 "16,25,36")


(reduce str (take 10 (range)))

(clojure.string/join "," (filter (fn[x] (some  #(= x %) (map #(* % %) (range x)))) (map #(Integer. %) (re-seq #"\d+" t1))))
(clojure.string/join "," (filter (fn[x] (some  #(= x %) (map #(* % %) (range x)))) (map #(Integer. %) (re-seq #"\d+" t2))))

((fn[y]
  (clojure.string/join "," (filter (fn[x] (some  #(= x %) (map #(* % %) (range x)))) (map #(Integer. %) (re-seq #"\d+" y))))
  ) t1)

(fn [csv]
  (let [nums (map #(Long/valueOf %) (re-seq #"\d+" csv))
        squares (filter #(-> % Math/sqrt (rem 1) zero?) nums)]
    (clojure.string/join "," squares)))
