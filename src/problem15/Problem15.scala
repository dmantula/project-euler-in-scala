package problem15

/**
 * Starting in the top left corner of a 2×2 grid, and only
 * being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner.
 *
 * (http://projecteuler.net/project/images/p_015.gif)
 *
 * How many such routes are there through a 20×20 grid?
 */
object Problem15 extends App {
  // Range (x to y) represented as BitInts
  def rangeInBigInt(x: Int, y: Int) = (x to y) map { x:Int => BigInt(x) }

  // Product of numbers between x and y
  def prod(x: Int, y: Int) = rangeInBigInt(x, y).foldLeft(BigInt(1))(_*_)

  // Solution = (2m)! / (m!)^2   -- number of combinations ( 2m m )
  def binaryPermutations(m: Int) = prod(m + 1, 2 * m) / prod(1, m)

  println(binaryPermutations(20))
}
