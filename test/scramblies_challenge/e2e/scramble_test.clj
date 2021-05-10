(ns scramblies-challenge.e2e.scramble-test
  (:require [cheshire.core :as cheshire]
            [clojure.test :refer :all]
            [scramblies-challenge.core :refer :all]
            [ring.mock.request :as mock]))

(defn parse-body [body]
  (cheshire/parse-string (slurp body) true))

(deftest testing-scramble

  (testing "str1 has less characters than str2 - POST /api/scramble BODY {str1: 'a', str2: 'bcd'} "
    (let [response (app (-> (mock/request :post "/api/scramble")
                            (mock/json-body {:str1 "a"
                                             :str2 "bcd"})))
          body (parse-body (:body response))]
      (is (= (:status response) 200))
      (is (= (:result body) false))))

  (testing "str1 do not has to many a - POST /api/scramble BODY {str1: 'aaa', str2: 'akjsdksjdaskdjskdjawkjdwkdja'} "
    (let [response (app (-> (mock/request :post "/api/scramble")
                            (mock/json-body {:str1 "aaa"
                                             :str2 "akjsdksjdaskdjskdjawkjdwkdja"})))
          body (parse-body (:body response))]
      (is (= (:status response) 200))
      (is (= (:result body) false))))

  (testing "str1 can be transformed into str2 - POST /api/scramble BODY {str1: 'adeb', str2: 'ab'} "
    (let [response (app (-> (mock/request :post "/api/scramble")
                            (mock/json-body {:str1 "adeb"
                                             :str2 "ab"})))
          body (parse-body (:body response))]
      (is (= (:status response) 200))
      (is (= (:result body) true)))))
