package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest2 extends Specification {

  def e2(max: Int) = {
    @tailrec def reqE2(acc: Int, lastTwo: (Int, Int)): Int = {
      val fib = lastTwo._1 + lastTwo._2
      if (fib > max) acc
      else if (fib % 2 == 0) reqE2(acc + fib, (lastTwo._2 -> fib))
      else reqE2(acc, (lastTwo._2 -> fib))
    }
    if (max < 2) 0
    else if (max == 2) 2
    else reqE2(2, (1 -> 2))
  }
  "By considering the even terms in the Fibonacci sequence we" should {
    "get 0 up to 1" in {
      e2(1) must equalTo(0)
    }
    "get 2 up to 2" in {
      e2(2) must equalTo(2)
    }
    "get 10 up to 10" in {
      e2(10) must equalTo(10)
    }
    "get 4613732 up to 4000000" in {
      e2(4000000) must equalTo(4613732)
    }
  }
}