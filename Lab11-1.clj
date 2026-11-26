(ns java-interop.core)

(defn demonstrate-java-interop []
  (println "=== JAVA INTEROPERABILITY DEMO ==-\n")
  
  (println "1. Static Methods:")
  (let [abs-val (Math/abs -150)
        current-time (System/currentTimeMillis)]
    (println "   Math/abs (-150):        " abs-val)
    (println "   System/currentTimeMillis:" current-time)
    (println))

  (println "2 & 3. Object Creation & Instance Methods:")
  (let [java-list (java.util.ArrayList.)
        _ (.add java-list "Clojure")
        _ (.add java-list "Java")
        _ (.add java-list "Python")
        
        java-map (java.util.HashMap.)
        _ (.put java-map "language" "Clojure")
        _ (.put java-map "type" "Functional")]
    
    (println "   ArrayList instance:     " java-list)
    (println "   ArrayList size (.size): " (.size java-list))
    (println "   ArrayList get index 1:  " (.get java-list 1))
    (println "   HashMap instance:       " java-map)
    (println "   HashMap get 'language': " (.get java-map "language"))
    (println))

  (println "4. Converting Collections:")
  (let [clj-vector [10 20 30 40]
        java-array-list (java.util.ArrayList. clj-vector)
        converted-clj-vec (into [] java-array-list)
        
        clj-map {:name "Alice" :role "Developer"}
        java-hash-map (java.util.HashMap. clj-map)
        converted-clj-map (into {} java-hash-map)]
    
    (println "   Clojure vector:         " clj-vector)
    (println "   Converted Java list:    " java-array-list (type java-array-list))
    (println "   Converted back to Clojure:" converted-clj-vec (type converted-clj-vec))
    (println "   Clojure map:            " clj-map)
    (println "   Converted Java map:     " java-hash-map (type java-hash-map))
    (println "   Converted back to Clojure:" converted-clj-map (type converted-clj-map))
    (println)))

(defn -main []
  (demonstrate-java-interop))

(-main)
