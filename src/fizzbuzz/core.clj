(ns fizzbuzz.core)

(defn filter-non-null [arr] (filter #(not (nil? %)) arr))
(defn join-or-default [orDefault] #(if (empty? %) (str orDefault) (apply str %)))
(defn map-rules-on [rules arg] (map #(% arg) rules))

(defn create-fizzBuzz [fizzBuzz-rules]
  (fn fb?
    ([arg]
     (-> 
      (map-rules-on fizzBuzz-rules arg)
      (filter-non-null)
      ((join-or-default arg))
    ))

    ([arg & next] (str (fb? arg) " " (apply fb? next))))
)


(defn can-be-divided-by? [value]
  (let [check (fn [q n] (= 0 (mod n q)) )]
    (partial check value)))

(defn fizz-buzz-rule [predicate return-value] #(when (predicate %) return-value) )

(def classic-fizzBuzz
  [ (fizz-buzz-rule (can-be-divided-by? 3) "Fizz") (fizz-buzz-rule (can-be-divided-by? 5) "Buzz") ] 
)

(def fizzBuzz (create-fizzBuzz classic-fizzBuzz))
