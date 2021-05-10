(ns scramblies-challenge.modules.api.schemas.scramble-post
  (:require [schema.core :as s]))

(def english-lowercase-string (s/pred #(re-matches #"[a-z]+" %)))

(s/defschema ScramblePost
  {:str1 english-lowercase-string
   :str2 english-lowercase-string})
