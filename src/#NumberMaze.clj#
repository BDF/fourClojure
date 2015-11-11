(ns NumberMaze)

;; (= 1 (__ 1 1))  ; 1

(defn a[start goal]
      (loop [s [start]
	    c 1]
      	   (if (some #(= goal %) s)
	       c
	       (recur
		(vec (apply concat (map (partial (juxt #(* % 2) #(/ % 2) #(+ % 2))) s)))
		(inc c)))))

(defn b[start goal]
      (loop [s [start]
	    c 1]
      	   (if (some #(= goal %) s)
	       c
	       (recur
		(vec (apply concat (map (fn [x] ((juxt #(* % 2) #(/ % 2) #(+ % 2)) x)) s)))
		(inc c)))))

(fn [start goal]
      (loop [s [start]
	    c 1]
      	   (if (some #(= goal %) s)
	       c
	       (recur
		(vec (apply concat (map (fn [x] ((juxt #(* % 2) #(/ % 2) #(+ % 2)) x)) s)))
		(inc c)))))




(->> c (+ 3) (/ 2) (- 1)) 
   (- 1 (/ 2 (+ 3 c)))



;; 	       (concat 
;;		((juxt #(* % 2) #(/ % 2) #(+ % 2)) start)
;;  (ns user (:require NumberMaze :reload :verbose))
;;(map (partial (juxt #(* % 2) #(/ % 2) #(+ % 2))) [1 2 3])
;; (map (fn [x] (juxt #(* % 2) #(/ % 2) #(+ % 2)) x) [1 2 3])

(defn ask []
  (println "Please answer \"y\"[yes] or \"n\"[no]:")
  (.trim (read-line)))

(defn get-valid-answer [question]
  (println question)
  (->> (repeatedly ask)
       (filter #{"y" "n"})
       (first)))

       (first (filter #{"Y" "N"} (repeatedly ask)))






       
       