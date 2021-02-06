(ns clojure-simple-webserver.api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-simple-webserver.presenter :as presenter]
            [ring.middleware.params :refer [wrap-params]]))

(defroutes covid19-routes
           (GET "/covid19" [country status from to]
             (presenter/get-covid19 country status from to))
           (route/not-found "<h1>Page not found</h1>"))

(def app (wrap-params covid19-routes))
