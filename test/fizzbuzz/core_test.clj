(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest divisible-by-three-should-yield-fizz
    (testing "12 should return Fizz"
      (is (= "Fizz" (fizzBuzz 12))))
    (testing "18 should return Fizz" 
      (is (= "Fizz" (fizzBuzz 18))))
)

(deftest divisible-by-5-should-yield-buzz
    (testing "5 should return Buzz"
        (is (= "Buzz" (fizzBuzz 5))))
    (testing "10 should return Buzz"
        (is (= "Buzz" (fizzBuzz 10))))
)

(deftest divisible-neither-by-3-nor-5-should-yield-input
    (testing "8 should return 8"
        (is (= "8" (fizzBuzz 8))))
    (testing "11 should return 11"
        (is (= "11" (fizzBuzz 11))))
        (testing "14 should return 14"
            (is (= "14" (fizzBuzz 14))))
)

(deftest divisible-by-3-and-five-should-yield-FizzBuzz
    (testing "15 should return FizzBuzz"
        (is (= "FizzBuzz" (fizzBuzz 15))))
    (testing "30 should return FizzBuzz"
        (is (= "FizzBuzz" (fizzBuzz 30))))
)

(deftest should-convert-a-list-of-value-to-FizzBuzz
    (testing "15 22 10 9 should returr FizzBuzz 22 Buzz Fizz")
        (is (= "FizzBuzz 22 Buzz Fizz" (fizzBuzz 15 22 10 9)))
              )