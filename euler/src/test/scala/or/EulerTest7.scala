package or

import org.specs2.mutable._
import scala.annotation.tailrec
import Iterator._

class EulerTest7 extends Specification {
  def findNthPrime(n: Int): Int = {
    if (n == 1) 2
    from(3,2).filter(EulerTest3.isPrime(_)).drop(n - 2).next
  }
  "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13" should {
    "be 13 for 6" in {
      findNthPrime(6) must equalTo(13)
    }
    "be 523 for 99" in {
    	findNthPrime(99) must equalTo(523)
    }
    "be 104743 for 10001" in {
    	findNthPrime(10001) must equalTo(104743)
    }
  }
}