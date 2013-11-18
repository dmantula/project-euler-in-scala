package problem48

/**
 * The series, 1^^1 + 2^^2 + 3^^3 + ... + 10^^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^^1 + 2^^2 + 3^^3 + ... + 1000^^1000.
 */
object Problem48 extends App {

  def calc(n: Int, lastDigitsNum: Int): String = {
    val sumAsString = (1 to n)
      .map{x => BigInt(x).pow(x)}
      .foldLeft(BigInt(0))(_+_)
      .toString

    // Return last "n" digits
    sumAsString.substring(sumAsString.length - lastDigitsNum)
  }

  println(calc(1000, 10))
}
