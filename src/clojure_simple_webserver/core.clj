(ns clojure-simple-webserver.core
  (:require [org.httpkit.server :refer [run-server]]
            [clojure-simple-webserver.api :refer [app]]
            [clojure-simple-webserver.config :refer [config]])
  (:gen-class))


(defn -main []
  (let [port (Integer/parseInt (:port config))]
    (run-server app {:port port})
    (printf "Server started on port %s%n" port)))
