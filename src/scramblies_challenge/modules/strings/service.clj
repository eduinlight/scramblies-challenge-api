(ns scramblies-challenge.modules.strings.service
  (:require [scramblies-challenge.modules.strings.utils :as utils]))

(defn scramble
  "Returns true if a portion of str1 characters 
   can be rearranged to match str2, otherwise returns false"
  [str1 str2]

  (if (< (count str1) (count str2))
    false
    (let [str1-count-elc (utils/count-chars-str str1)
          str2-count-elc (utils/count-chars-str str2)]
      (utils/cmp-big-vec str1-count-elc str2-count-elc))))
