package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest5 extends Specification {
  def isDivisableBy(n: Int, divisable: Seq[Int]): Boolean = {
    divisable.filter(d => n % d != 0).length == 0
  }
  def e5(divisable: Seq[Int]): Int = {
    val step = divisable.min
    def e5Req(n: Int): Int = {
      if (isDivisableBy(n, divisable)) {
        return n
      }
      else
        e5Req(n + step)
    }
	e5Req(step + step)
  }
  "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder" should {
    "2520 for 10" in {
      e5(Seq(10, 9, 8, 7, 6)) must equalTo(2520)
    }
    "232792560 for 20" in {
    	e5(Seq(20, 19, 18, 17, 16, 15, 14, 13, 12, 11)) must equalTo(232792560)
    }
  }
}