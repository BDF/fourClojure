(ns keepTheCaps)




(def phone-number "672-345-456-3212")
(def matcher (re-matcher #"((\d+)-(\d+))" phone-number))
(def myMs (re-find matcher))
(apply str myMs)
(re-groups matcher)
(re-groups matcher)
;["672-345" "672-345" "672" "345"]
(re-find matcher)
;["456-3212" "456-3212" "456" "3212"]
(re-groups matcher)
;["456-3212" "456-3212" "456" "3212"]
(re-groups matcher)
;["456-3212" "456-3212" "456" "3212"]
(re-find matcher)
(re-groups matcher)
;IllegalStateException No match found  java.util.regex.Matcher.group (Matcher.java:468)


(def tVal "HeLlO, WoRlD!")
(def matcher (re-matcher #"([A-Z]+)" tVal))
(def myCaps (re-find matcher))
myCaps

(defn grabTheCaps[x]
  (apply str (filter #(re-find #"[A-Z]" (str %)) x)))


(fn[x] (apply str (filter #(re-find #"[A-Z]" (str %)) x)))


(grabTheCaps "HeLlO, WoRlD!")
(grabTheCaps "empty")
(grabTheCaps "$#A(*&987Zf")