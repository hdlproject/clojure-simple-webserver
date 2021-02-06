(ns clojure-simple-webserver.model
  (:require [clj-http.client :as client]))

(defn get-covid19 [server-address country status from to]
  (let [response (client/get
                   (format "%s/country/%s/status/%s?from=%s&to=%s" server-address country status from to))]
    (:body response)))


