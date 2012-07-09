package or

import org.specs2.mutable._
import scala.annotation.tailrec
import Iterator._

class EulerTest9 extends Specification {
  def sq(n: Int) = n * n
  def isPTriplet(n: Int, triplet: (Int, Int)) = {
    val triplet3 = n - (triplet._1 + triplet._2)
    (triplet._1 < triplet._2) &&
      (sq(triplet._1) + sq(triplet._2)) == sq(triplet3) &&
      	(triplet._1 + triplet._2 + triplet3 == n)
  }
  def findPythagoreanTriplet(n: Int): Option[(Int, Int, Int)] = {
    val cMax = n / 2
    def req(triplet: (Int, Int)): Option[(Int, Int, Int)] = {
      if (isPTriplet(n, triplet)) return Some(triplet._1, triplet._2, (n - (triplet._1 + triplet._2)))
      triplet match {
        case (a, b) if a > 1 => req(a - 1, b)
        case (a, b) if b > 2 => req(b - 2, b -1)
        case _ => None
      }
    }
    req((cMax - 1, cMax))
  }
   def findPythagoreanTripletProduct(n: Int) = {
     val triplet = findPythagoreanTriplet(n).getOrElse((0, 0, 0))
     (triplet._1) * (triplet._2) * (triplet._3)
   }
  "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2" should {
    "verify a known puthagorean triplet 345" in {
      isPTriplet(12, (3, 4)) must equalTo(true)
    }
    "find a pythagorean triplet for c2 = 12" in {
      findPythagoreanTriplet(12) must equalTo(Some((3, 4, 5)))
    }
    "find a pythagorean triplet for c2 = 1000" in {
    	findPythagoreanTriplet(1000) must equalTo(Some((200, 375, 425)))
    }
    "find a pythagorean triplet sum for c2 = 1000" in {
    	findPythagoreanTripletProduct(1000) must equalTo(31875000)
    }
  }
}