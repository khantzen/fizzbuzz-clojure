(ns fizzbuzz.core)

(defn validate [fbRule] (:if_validate fbRule))
(defn returnValue [orDefault] #(:then_return % orDefault))

(defn create-fizzBuzz [fizzBuzzRules]
  (fn fb?
    ([arg]
     (->
      (filter #((validate %)  arg) fizzBuzzRules)
      (first)
      ((returnValue (str arg)))))

    ([arg & next] (str (fb? arg) " " (apply fb? next)))))

(defn create_divide_by [value] #(= 0 (mod % value)))
(def divBy3? (create_divide_by 3))
(def divBy5? (create_divide_by 5))

(def classic-fizzBuzz
  [{:if_validate  #(and (divBy5? %) (divBy3? %))       :then_return "FizzBuzz"}
   {:if_validate  #(and (divBy3? %) (not (divBy5? %))) :then_return "Fizz"}
   {:if_validate  #(and (divBy5? %) (not (divBy3? %))) :then_return "Buzz"}])

(def fizzBuzz (create-fizzBuzz classic-fizzBuzz))
