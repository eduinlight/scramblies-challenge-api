(ns scramblies-challenge.modules.api.core
  (:require
   [ring.util.http-response :refer :all]
   [compojure.api.sweet :refer :all]
   [scramblies-challenge.modules.strings.service :refer [scramble?]]
   [schema.core :as s]
   [scramblies-challenge.modules.api.schemas.scramble-post :refer [ScramblePost]]))

(defn api-routes
  []
  (context "/api" []
    :tags ["api"]

    (POST "/scramble" []
      :return {:result Boolean}
      :body [schema ScramblePost]
      :summary "returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false"
      (ok {:result (let [{str1 :str1
                          str2 :str2} schema] (scramble? str1 str2))}))))
