(ns mapDefaults)


(defn mapDefaults[v k]
  (loop [h {}
         l k]
    (if (empty? l)
      h
      (recur (assoc h (first l) v) (rest l)))))

(defn mapDefaults2[v k]
  (apply conj (map #(assoc {} % v) k)))

(fn[v k] (apply conj (map #(assoc {} % v) k)))

    
(mapDefaults2 0 [:a :b :c])
(mapDefaults2 "x" [1 2 3])
(mapDefaults2 [:a :b] [:foo :bar])


#(loop [h {}
        l %]
   (if (empty? l)
     h)
   (recur (assoc h (first l) v) (rest l)))

(apply conj (map #(assoc {} % 5) [1 2 3]))


(mapDefaults 0 [:a :b :c])
(mapDefaults "x" [1 2 3])
(mapDefaults [:a :b] [:foo :bar])

(#(zipmap %2 (repeat %1)) 0 [:a :b :c])
