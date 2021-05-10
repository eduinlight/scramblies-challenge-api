(ns scramblies-challenge.unit.strings-utils-test
  (:require [cheshire.core :as cheshire]
            [clojure.test :refer :all]
            [scramblies-challenge.modules.strings.utils :refer [elc-vec
                                                                count-chars-str
                                                                get-elc-index
                                                                cmp-big-vec]]))

(deftest testing-strings-utils

  (testing "elc-vec has 26 values is a vec and has all values equal to 0"
    (is (vector? elc-vec) true)
    (is (count elc-vec) 26)
    (is (= (reduce #(and %1 (zero? %2)) true elc-vec) true)))

  (testing "get-elc-index"
    (is (get-elc-index \a) 0)
    (is (get-elc-index \b) 1)
    (is (get-elc-index \z) 25))

  (testing "count-chars-str"
    (let [response (count-chars-str "abbzzzzz")]
      (is (vector? response) true)
      (is (count response) 26)
      (is (first response) 1)
      (is (second response) 2)
      (is (last response) 5)))

  (testing "cmp-big-vec"
    (is (not (cmp-big-vec [1] [2])))
    (is (cmp-big-vec [2] [2]) true)
    (is (not (cmp-big-vec [2, 0, 1] [1, 0, 2])))
    (is (cmp-big-vec [2, 0, 1] [1, 0, 1]))))
