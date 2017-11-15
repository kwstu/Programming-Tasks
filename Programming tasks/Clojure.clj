(defn fizzBuzz [x]
	  (if (= (mod x 3)(mod x 5) 0) "FizzBuzz"
	  (if (= (mod x 5) 0) "Buzz"
	    (if (= (mod x 3) 0) "Fizz" (str x))
	    )
	  )
	)
(map fizzBuzz (range 1 100))

(defn fizzBuzzBang [x]
	(if (< (rand-int 100) 20) "Bang"
	(if (= (mod x 3)(mod x 5) 0) "FizzBuzz"
     (if (= (mod x 5) 0) "Buzz"
      (if (= (mod x 3) 0) "Fizz"

        (str x))
    )
      )
  )
  )

(map fizzBuzzBang (range 1 100))


 (defn bangCount [x]
  (count
   (filter (fn [kWord] (= kWord "Bang")) x)
  )
  )

 (bangCount (map fizzBuzzBang (range 10000)))
