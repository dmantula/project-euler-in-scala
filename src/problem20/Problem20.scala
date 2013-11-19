package problem20

import scala.annotation.tailrec

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
object Problem20 extends App {
  // BigInt-based tail-recursion factorial
  private def fact(n: Int) = {
    @tailrec
    def rec(n: Int, acc: BigInt):BigInt =
      if (n <= 1)
        acc
      else
        rec(n - 1, acc * n)
    rec(n, BigInt(1))
  }

  // Sum of digits of BigInt
  private def sumDigits(b: BigInt) = b.toString.toArray.map{c => c.asDigit}.sum

  println(sumDigits(fact(100)))
}
