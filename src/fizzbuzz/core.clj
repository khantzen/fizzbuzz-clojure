(ns fizzbuzz.core)

(defn filter-non-null [arr] (filter #(not (nil? %)) arr))
(defn join_or_default [orDefault] #(if (empty? %) (str orDefault) (apply str %)))

(defn create-fizzBuzz [fizzBuzzRules]
  (fn fb?
    ([arg]
     (->
      (map #(% arg) fizzBuzzRules)
      (filter-non-null)
      ((join_or_default arg))
    ))

    ([arg & next] (str (fb? arg) " " (apply fb? next))))
)

(defn create_is_divisible_by [value]  #(= 0 (mod % value)))
  
(def divBy3? (create_is_divisible_by 3))
(def divBy5? (create_is_divisible_by 5))
  
(defn fizz-buzz-rule [predicate return-value] #(when (predicate %) return-value) )

(def classic-fizzBuzz
  [ (fizz-buzz-rule divBy3? "Fizz") (fizz-buzz-rule divBy5? "Buzz") ] 
)

(def fizzBuzz (create-fizzBuzz classic-fizzBuzz))
