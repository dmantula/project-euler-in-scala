package utils.math

object GcdLcm {
  // Greatest common divisor
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  // Least common multiple
  def lcm(a: Long, b: Long) = (a * b) / gcd(a, b)
}
