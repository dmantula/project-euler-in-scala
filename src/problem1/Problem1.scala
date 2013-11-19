package problem1

/**
 * If we list all the natural numbers below 10 that are multiples
 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem1 extends App {

  // Calculate sum of multiples of divisor "d" between 0 and "n"
  private def sumOfMultiples(d: Int)(n: Int) = {
    // Number of multiples
    val m = n / d
    // Sum of arithmetic progression multiplied by divisor
    (m * (m + 1) / 2) * d
  }

  def calc(n: Int): Int =
    sumOfMultiples(3)(n-1) + sumOfMultiples(5)(n-1) - sumOfMultiples(15)(n-1)

  print("Result = " + calc(1000))
}

