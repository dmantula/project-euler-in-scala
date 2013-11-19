package problem34

import scala.annotation.tailrec

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
object Problem34 extends App {
  def fact(i: Int) = {
    @tailrec
    def rec(i: Int, acc: Int): Int =
      if (i == 0) acc
      else rec(i - 1, acc * i)
    rec(i, 1)
  }

  val factorials = (0 to 9) map {
    fact(_)
  }

  def sumOfFactorialsOfDigits = {
    x: Int =>
      x.toString.map {
        _.asDigit
      }.map {
        factorials(_)
      }.sum
  }

  def calc(min: Int, max: Int): Int = {
    def rec(i: Int, n: Int, acc: Int): Int = {
      if (i > n)
        acc
      else if (sumOfFactorialsOfDigits(i) == i)
        rec(i + 1, n, acc + i)
      else
        rec(i + 1, n, acc)
    }

    rec(min, max, 0)
  }

  /*
   Max sumOfFactorialsOfDigits among numbers from
   (1000...0) to (9999...9) has number (9999...99)

   Order of growth of sumOfFactorialsOfDigits
   is (2 * lgN) where N is number of digits.

   As far as sumOfFactorialsOfDigits(9999999) == 2540160,
   there is no 7+ digits number that might be equal to
   its sumOfFactorialsOfDigits.

   So let's search digits only in range (3, 9999999)
 */
  println(calc(3, 9999999))
}
