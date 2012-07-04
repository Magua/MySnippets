package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest6 extends Specification {
  def sqSumAndSumSqDiff(max: Int): Int = {
    val list = (1 to max).toList
	val sqSum = list.map(x => x*x).sum
	val listSum = list.sum
	val sumSq = listSum * listSum
    sumSq - sqSum
  }
  "the difference between the square of the sum and the sum of the square" should {
    "be 2640 for 10" in {
      sqSumAndSumSqDiff(10) must equalTo(2640)
    }
    "be 25164150 for 100" in {
    	sqSumAndSumSqDiff(100) must equalTo(25164150)
    }
  }
}