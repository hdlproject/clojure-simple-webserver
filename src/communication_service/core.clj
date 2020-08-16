(ns communication-service.core
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route])
  (:gen-class)
  (:import (java.util Date)))

(defn get-date []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (.getTime (Date.)))}]
    response))

(defn get-time []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (t/time-now))}]
    response))


(defroutes app
           (GET "/" [] "<h1>Welcome</h1>")
           (GET "/get-time" [] (get-time))
           (GET "/get-date" [] (get-date))
           (route/not-found "<h1>Page not found</h1>"))

(defn -main [& args]
  (let [port (Integer/parseInt (first args))]
    (run-server app {:port port})
    (printf "Server started on port %s%n" port)))

