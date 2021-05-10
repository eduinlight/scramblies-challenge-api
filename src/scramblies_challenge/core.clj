(ns scramblies-challenge.core
  (:require [scramblies-challenge.modules.api.core :refer [api-routes]]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(def app
  (api
   {:swagger
    {:ui "/"
     :spec "/swagger.json"
     :data {:info {:title "Scramblies-challenge"
                   :description "scramblies challenge api"}
            :tags [{:name "api"
                    :description "scramblies challenge api endpoints"}]}}}

   (api-routes)))
