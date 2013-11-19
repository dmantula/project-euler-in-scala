package problem16

/**
 * 2^^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^^1000?
 */
object Problem16 extends App {
  // Power of n as BigInt
  private def bigPow(n: Int, pow: Int) = BigInt(n).pow(pow)

  // Sum of digits of BigInt
  private def sumDigits(b: BigInt) = b.toString.toArray.map(c => c.asDigit).sum

  def calc(pow: Int) = sumDigits(bigPow(2, pow))

  println(calc(1000))
}
