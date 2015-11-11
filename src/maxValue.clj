(ns maxValue)


(defn myMax[& x]
  (print x))
;  (apply (fn[&z] (reduce #(> %1 %2 %1 %2) z))
                   

(myMax 1 2 3 4)
         
                            

         

((fn[& z] (reduce #(if (> %1 %2) %1 %2) z)) 1 2 3 4 5)

((fn[& z] (print z)) 1 2 3 4 5)



