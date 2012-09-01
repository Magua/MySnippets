package or

import scala.collection.immutable.Stream.consWrapper

import org.specs2.mutable.Specification

class EulerTest012 extends Specification {

  val tStream: Stream[Int] = triangleStream(1, 1)
  def triangleStream(n: Int, sum: Int): Stream[Int] = sum #:: triangleStream(n + 1, sum + (n + 1))
  def divisors(n: Int): Int = if (n == 1) 1 else (1 to math.sqrt(n).toInt).filter(i => n % i == 0).length * 2
  def firstTriangleNumberMoreThanNDivisors(d: Int) = tStream.find(divisors(_) > d).get

  "What is the value of the first triangle number to have over five hundred divisors?" should {
    "triangle number stream 1, 3, 6, 10, 15, 21, 28, 36, 45, 55" in {
      triangleStream(1, 1).take(10) must equalTo(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
      tStream.take(10) must equalTo(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
    }
    "divisors" in {
      divisors(1) must equalTo(1)
      divisors(3) must equalTo(2)
      divisors(6) must equalTo(4)
      divisors(10) must equalTo(4)
      divisors(15) must equalTo(4)
      divisors(21) must equalTo(4)
      divisors(28) must equalTo(6)
    }
    "firstTriangleNumberNDivisors" in {
      firstTriangleNumberMoreThanNDivisors(1) must equalTo(3)
      firstTriangleNumberMoreThanNDivisors(2) must equalTo(6)
      firstTriangleNumberMoreThanNDivisors(4) must equalTo(28)
      firstTriangleNumberMoreThanNDivisors(6) must equalTo(36)
      firstTriangleNumberMoreThanNDivisors(500) must equalTo(76576500)
    }
  }
}
