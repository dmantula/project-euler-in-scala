package problem14

import scala.annotation.tailrec
import Math.max

/**
 * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */
object Problem14 extends App {

  // Calculates length of chain for given number
  // TODO: might me cached
  private def calcLength(i: Int): Int = {
    @tailrec
    def rec(i: Long, currLen: Int): Int = {
      if (i == 1)
        currLen
      else if ((i & 1) == 0)
        rec(i / 2, currLen + 1)
      else
        rec(3 * i + 1, currLen + 1)
    }

    rec(i.toLong, 0)
  }

  // Returns number from range (1, n) which
  // has the longest chain to 1
  def calc(n: Int): Int = {
    @tailrec
    def rec(n: Int, curr: Int, currMaxLen: Int, currMax: Int): Int =
      if (curr > n)
        currMax
      else {
        val maxLen = max(currMaxLen, calcLength(curr))
        val maxVal = if (maxLen == currMaxLen) currMax else curr
        rec(n, curr + 1, maxLen, maxVal)
      }

    rec(n, 1, Int.MinValue, 1)
  }

  println(calc(1000000))
}
