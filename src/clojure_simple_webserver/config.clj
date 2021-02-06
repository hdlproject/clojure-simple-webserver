(ns clojure-simple-webserver.config)

(defn get-config []
  {
   :port                    (or (System/getenv "PORT") "8080")
   :covid19-service-address (System/getenv "COVID19_SERVICE_ADDRESS")
   })

(def config (get-config))
