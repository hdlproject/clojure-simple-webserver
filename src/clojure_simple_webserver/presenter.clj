(ns clojure-simple-webserver.presenter
  (:require [clojure-simple-webserver.model :as model]
            [clojure-simple-webserver.config :refer [config]]))

(defn get-covid19 [country status from to]
  (let [covid19-data (model/get-covid19 (:covid19-service-address config) country status from to)]
    (let [response {:status  200
                    :headers {"Content-Type" "application/json"}
                    :body    (str covid19-data)}]
      response)))
