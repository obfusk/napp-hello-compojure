(ns napp-hello-compojure.core
  (:gen-class)
  (:use [compojure.core     :only [defroutes GET]]
        [ring.adapter.jetty :only [run-jetty]] ))

(defn strftime [fmt & [t]]
  (format (.replaceAll fmt "%([a-zA-Z])" "%1\\$t$1")
    (or t (java.util.Date.)) ))

(defroutes routes
  (GET "/" []
    { :headers { "Content-Type" "text/plain" }
      :body (str  "Hello World!"                      "\n"
                  "The time is: " (strftime "%F %T")  "\n"
                                                      "\n"
                  "- napp-hello-compojure"            "\n" ) } )
)

(def handler routes)

(defn -main [& [port]]
  (let [p (some #(if (seq %) %) [port (get (System/getenv) "PORT")])]
    (run-jetty #'handler { :port (Integer. (or p 8888)) }) ))
