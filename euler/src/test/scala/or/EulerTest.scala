package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest extends Specification {

  def e1(in: Int) = {
    @tailrec def reqE1(acc: Int, n: Int): Int = {
      if (n >= in) acc
      else if (n % 3 == 0 || n % 5 == 0) reqE1(n + acc, n + 1)
      else reqE1(acc, n + 1)
    }
    reqE1(0, 0)
  }
  "If we list all the natural numbers that are multiples of 3 or 5 we" should {
    "get 23 for 10" in {
      e1(10) must equalTo(23)
    }
    "get 233168 for 1000" in {
      e1(1000) must equalTo(233168)
    }
  }
}