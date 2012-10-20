package or

import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec

class EulerTest028 extends Specification {

  def calcDiagonalSum(acc: Long, start: Int, currentStep: Int, size: Int) = {
    
  }
  class BangInt(i: Int) {
    def diagonalSum(): Int = {
      require(i % 2 == 1 && i > 0, "Only uneaven positive sizes")
      def calcDiagonalSum(acc: Long, step: Int, currentSize: Int): Int = {
        
        1
      }
      if (i == 1) 1        
      else calcDiagonalSum(1, 2, 1)
    }
  }
  """Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13""" should {
    implicit def x(x: Int) = new BangInt(x)
    "a 5*5 should have a diagonal sum of 101" in {
      5.diagonalSum must equalTo(101)
    }
  }
}
