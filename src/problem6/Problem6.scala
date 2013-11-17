package problem6

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first
 * one hundred natural numbers and the square of the sum.
 */
object Problem6 extends App {
  def calc(n: Int) = {

    val sum = 1 to n sum

    val squareOfSum = sum * sum

    val sumOfSquares = 1 to n map (x => x * x) sum

    squareOfSum - sumOfSquares
  }

  println(calc(100))
}
