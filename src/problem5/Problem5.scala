package problem5

import utils.math.GcdLcm
import scala.annotation.tailrec

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem5 extends App {

  @tailrec
  private def find0(i: Int, acc: Long, limit: Int): Long =
    if (i > limit)
      acc
    else
      find0(i + 1, GcdLcm.lcm(i, acc), limit)


  def find(limit: Int) = find0(1, 1, limit)

  println(find(20))
}
