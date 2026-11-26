(ns sequence-transformations.core)

(def numbers-vector [1 2 3 4 5 6 7 8 9 10])
(def numbers-list   '(2 4 6 8 10 12 14 16 18 20))

(defn demonstrate-transformations []
  (println "=== SEQUENCE TRANSFORMATIONS DEMO ==-\n")
  
  (println "1. MAP (Square each element):")
  (println "   Vector original: " numbers-vector)
  (println "   Vector squared:  " (map #(* % %) numbers-vector))
  (println "   List squared:    " (map #(* % %) numbers-list))
  (println)

  (println "2. FILTER (Retain only even numbers):")
  (println "   Vector original: " numbers-vector)
  (println "   Vector evens:    " (filter even? numbers-vector))
  (println "   List evens:      " (filter even? numbers-list))
  (println)

  (println "3. REDUCE (Aggregate - Sum and Maximum):")
  (println "   Sum of vector:   " (reduce + numbers-vector))
  (println "   Maximum of list: " (reduce max numbers-list))
  (println)

  (println "4. TAKE and DROP (Slicing sequences):")
  (println "   Take first 4 of vector:  " (take 4 numbers-vector))
  (println "   Drop first 3 of vector:  " (drop 3 numbers-vector))
  (println "   Take 3, drop 2 of list:  " (take 3 (drop 2 numbers-list)))
  (println)

  (println "5. THREADING MACRO (->>) Chaining operations:")
  
  (let [result-vector (->> numbers-vector
                           (filter even?)
                           (map #(* % %))
                           (reduce +))]
    (println "   Vector pipeline (filter evens -> square -> sum):" result-vector))

  (let [result-list (->> numbers-list
                         (drop 2)
                         (take 3)
                         (map #(* 10 %))
                         (reduce max))]
    (println "   List pipeline (drop 2 -> take 3 -> map *10 -> max):  " result-list)))

(defn -main []
  (demonstrate-transformations))

(-main)
