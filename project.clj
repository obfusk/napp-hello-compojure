(defproject napp-hello-compojure "0.1.0-SNAPSHOT"
  :description  "hello world w/ compojure"
  :url          "https://github.com/obfusk/napp-hello-compojure"

  :licenses [ { :name "GPLv2", :distribution :repo
                :url "http://www.opensource.org/licenses/GPL-2.0" } ]

  :dependencies [ [org.clojure/clojure      "1.5.1"]
                  [compojure                "1.1.5"]
                  [ring/ring-jetty-adapter  "1.2.0"] ]

  :main         napp-hello-compojure.core
  :ring         { :handler napp-hello-compojure.core/handler }
)
