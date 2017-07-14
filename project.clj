(defproject rewire "0.1.0-SNAPSHOT"
  :description "Tinkering with BCV parser to learn Clojure"
  :url "https://github.com/bigleafio/rewire"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot rewire.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
