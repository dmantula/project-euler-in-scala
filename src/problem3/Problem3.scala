package problem3

import scala.annotation.tailrec

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
object Problem3 extends App {
  @tailrec
  private def fermatsMethod(n: Long, s: Long, k: Long): List[Long] = {
    // Using Fermat's factorization method
    // http://en.wikipedia.org/wiki/Fermat's_factorization_method
    val y = Math.sqrt((s + k) * (s + k) - n)
    // Check if we got pure square in y
    if (y == Math.ceil(y)) {
      if (s + k - y.toLong == 1)
      // the number is prime – return it
        List(n)
      else
      // got 2 factors – test them recursively
        findPrimeFactors(s + k - y.toLong) ++ findPrimeFactors(s + k + y.toLong)
    }
    else
    // Increase k
      fermatsMethod(n, s, k+1)
  }

  private def findPrimeFactorsForOdd(i: Long):List[Long] =
    fermatsMethod(i, Math.ceil(Math.sqrt(i)).toLong, 0).sortWith(_ < _)

  def findPrimeFactors(i: Long):List[Long] =
    if (i <= 1)
      List()
    // Fermat's method appliable only for odd numbers
    // Check divisibility by 2
    else if ((i & 1) == 0)
      2 :: findPrimeFactors(i / 2)
    else
      findPrimeFactorsForOdd(i).sortWith(_ < _)




  println(findPrimeFactors(600851475143L).max)
}
