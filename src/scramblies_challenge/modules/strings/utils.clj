(ns scramblies-challenge.modules.strings.utils)

"vector that represents the 26 english lowercase characters initialized to 0"
(def elc-vec  (vec (repeat 26 0)))

(defn get-elc-index
  "Returns the index of character c for a = 0 ... z = 25"
  [c]
  (- (int c) (int \a)))

(defn count-chars-str
  "Returns a vector that represents the number or characters from str"
  [str]
  (let [num-chars-vec (atom elc-vec)]
    (doseq [character str]
      (let [index (get-elc-index character)
            value (get @num-chars-vec index)
            new-value (inc value)]
        (swap! num-chars-vec assoc (get-elc-index character) new-value)))
    @num-chars-vec))

(defn cmp-big-vec
  "Returns true if every element from vec1 is equal or bigger than vec2 otherwise false.
  vec1 and vec2 must be vectors of the same length"
  [vec1 vec2]

  (let [len (count vec1)
        ok (atom true)]

    (loop [i 0]
      (when (< i len)
        (reset! ok (and @ok (>= (get vec1 i) (get vec2 i))))
        (recur (inc i))))
    @ok))
