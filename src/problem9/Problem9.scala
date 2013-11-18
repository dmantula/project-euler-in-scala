package problem9

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
object Problem9 extends App {
  def calc(n: Int) = for {
    a <- 1 to n
    b <- a to n
    c = n - a - b
    if Math.sqrt(a * a + b * b) == c
  } yield (a * b * c)

  println(calc(1000)(0))
}
