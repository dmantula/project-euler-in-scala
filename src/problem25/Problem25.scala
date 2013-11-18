package problem25

import scala.annotation.tailrec

/**
 * The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
object Problem25 extends App {
  def calc(desiredDigits: Int) = {
    @tailrec
    def rec(i1: BigInt, i2: BigInt, n: Int, desiredDigits: Int): Int = {
      if (i2.toString.length >= desiredDigits)
        n
      else
        rec(i2, i1 + i2, n + 1, desiredDigits)
    }

    rec(BigInt(0), BigInt(1), 1, desiredDigits)
  }

  println(calc(1000))
}
