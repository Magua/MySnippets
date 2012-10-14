package or

import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec

class EulerTest020 extends Specification {

  class BangInt(i: Int) {
    val e13 = new EulerTest013()
    def !(): String =
      (1 to i - 1).reverse.toList.foldLeft(i.toString)((acc, value) => e13.multiply(acc, value))
    def bangSum(): Int = this.!.toList.map(e13.toInt).sum
  }
  "n! means n × (n − 1) × ... × 3 × 2 × 1. That" should {
    implicit def x(x: Int) = new BangInt(x)
    "work for 10!" in {
      (10!) must equalTo("3628800")
      (10 bangSum) must equalTo(27)
    }
    "work for 100!" in {
      (100 bangSum) must equalTo(648)
    }
  }
}
