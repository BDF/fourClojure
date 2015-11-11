(ns mapConstruction)


(def t1 '([:a :b :c] [1 2 3])) ;
(def t2 '([1 2 3 4] ["one" "two" "three"])); {1 "one", 2 "two", 3 "three"})
(def t3 '([:foo :bar] ["foo" "bar" "baz"])); {:foo "foo", :bar "bar"})


(map #(assoc {} %1 %2) (first t1) (second t1))

(defn mc[x c]
  (into {} (map vector x c)))

(fn[x c] (into {} (map vector x c)))
#(into {} (map vector % %2)))
#(apply assoc {} (mapcat list % %2))

(mc (first t1) (second t1))
(mc (first t2) (second t2))
(mc (first t3) (second t3))


defn ril4[l v]
  (apply map list (partition v l)))