(ns mylib.mylib)

;; (defn foo
;;   "I don't do a whole lot."
;;   [x]
;;   (prn x "Hello, World!"))

(defn to-base-base-aux [b n ret]
  (if (zero? n)
    ret
    (recur b (quot n b) (cons (mod n b) ret))))

(defn to-base
  "convert an integer `n` into a base `base` list, return it.
   example,
   (to-base 2 144) => (1 0 0 1 0 0 0 0)"
  ([base]
   (fn [n] (to-base base n)))
  ([base n]
   (if (zero? n)
     [0]
     (to-base-base-aux base n []))))

(comment
  ((to-base 2) 345)
  (map (to-base 2) (range 10))
  :rcf)
