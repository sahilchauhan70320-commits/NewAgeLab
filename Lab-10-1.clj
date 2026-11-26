(ns sequence-transformations.core)

;; Define two different collections: a Vector and a List
(def numbers-vector [1 2 3 4 5 6 7 8 9 10])
(def numbers-list   '(2 4 6 8 10 12 14 16 18 20))

(defn demonstrate-transformations []
  (println "=== SEQUENCE TRANSFORMATIONS DEMO ==-\n")
  
  ;; 1. MAP: Transform a sequence (Square each element)
  (println "1. MAP (Square each element):")
  (println "   Vector original: " numbers-vector)
  (println "   Vector squared:  " (map #(* % %) numbers-vector))
  (println "   List squared:    " (map #(* % %) numbers-list))
  (println)

  ;; 2. FILTER: Select elements meeting a predicate (Retain only evens)
  (println "2. FILTER (Retain only even numbers):")
  (println "   Vector original: " numbers-vector)
  (println "   Vector evens:    " (filter even? numbers-vector))
  (println "   List evens:      " (filter even? numbers-list))
  (println)

  ;; 3. REDUCE: Aggregate elements (Sum and Maximum)
  (println "3. REDUCE (Aggregate - Sum and Maximum):")
  (println "   Sum of vector:   " (reduce + numbers-vector))
  (println "   Maximum of list: " (reduce max numbers-list))
  (println)

  ;; 4. TAKE and DROP: Slice a sequence
  (println "4. TAKE and DROP (Slicing sequences):")
  (println "   Take first 4 of vector:  " (take 4 numbers-vector))
  (println "   Drop first 3 of vector:  " (drop 3 numbers-vector))
  (println "   Take 3, drop 2 of list:  " (take 3 (drop 2 numbers-list)))
  (println)

  ;; 5. THREADING MACRO (->>): Chaining multiple operations
  (println "5. THREADING MACRO (->>) Chaining operations:")
  
  ;; Chain A: Take vector -> Filter evens -> Square them -> Sum them up
  (let [result-vector (->> numbers-vector
                           (filter even?)       ; Keeps (2 4 6 8 10)
                           (map #(* % %))       ; Squares to (4 16 36 64 100)
                           (reduce +))]         ; Sums to 220
    (println "   Vector pipeline (filter evens -> square -> sum):" result-vector))

  ;; Chain B: Take list -> Drop first 2 -> Take next 3 -> Multiply by 10 -> Find max
  (let [result-list (->> numbers-list
                         (drop 2)        ; Drops (2 4), leaves (6 8 10 12 ...)
                         (take 3)        ; Takes (6 8 10)
                         (map #(* 10 %)) ; Multiplies to (60 80 100)
                         (reduce max))]  ; Finds max (100)
    (println "   List pipeline (drop 2 -> take 3 -> map *10 -> max):  " result-list)))

(defn -main []
  (demonstrate-transformations))

;; Run the program
(-main)
