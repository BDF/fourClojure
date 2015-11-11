(ns fourClojure.core)
(def t1 '(:a (:b nil nil) (:b nil nil)))
(def t2 '(:a (:b nil nil) nil))
(def t3 '(:a (:b nil nil) (:c nil nil)))
(def t4 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
(def t5 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
(def t6 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])

