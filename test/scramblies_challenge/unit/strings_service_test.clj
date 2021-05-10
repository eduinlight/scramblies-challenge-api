(ns scramblies-challenge.unit.strings-service-test
  (:require [cheshire.core :as cheshire]
            [clojure.test :refer :all]
            [scramblies-challenge.modules.strings.service :refer [scramble?]]))

(deftest testing-strings-services

  (testing "scramble"
    (is (scramble? "a" "a"))
    (is (scramble? "aaad" "ada"))
    (is (not (scramble? "ad" "ada")))
    (is (not (scramble? "adz" "ada")))
    (is (not (scramble? "wwx" "wxwz")))))
