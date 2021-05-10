 (defproject scramblies-challenge "0.1.0-SNAPSHOT"
   :description "FIXME: write description"
   :dependencies [[org.clojure/clojure "1.10.0"]
                  [metosin/compojure-api "2.0.0-alpha30"]]
   :ring {:handler scramblies-challenge.core/app}
   :uberjar-name "server.jar"
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                                   [ring/ring-mock "0.3.2"]]
                    :plugins [[lein-ring "0.12.5"]
                              [lein-githooks "0.1.0"]
                              [lein-cljfmt "0.7.0"]
                              [cider/cider-nrepl "0.26.0"]
                              [refactor-nrepl "2.5.1"]
                              [lein-ancient "0.6.15"]
                              [jonase/eastwood "0.4.2"]
                              [lein-try "0.4.3"]
                              [lein-cloverage "1.2.2"]]
                    :githooks {:auto-install true
                               :pre-commit ["lein cljfmt fix ./src"]
                               :pre-push ["lein test" "lein eastwood"]}
                    :cljfmt {:identation? true
                             :remove-surrounding-whitespace? true
                             :remove-trailing-whitespace? true
                             :insert-missing-whitespace? true
                             :remove-consecutive-blank-lines? true
                             :remove-multiple-non-indenting-spaces? true
                             :split-keypairs-over-multiple-lines? true}}})
