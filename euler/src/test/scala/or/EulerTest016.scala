package or

import scala.collection.immutable.Stream.consWrapper
import scala.actors._
import Actor._
import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec
import java.util.concurrent.TimeUnit

class EulerTest016 extends Specification {
  
def powSum(i: Int, pow: Int) = {
  BigInt(i).pow(pow).toString.toList.map(Character.getNumericValue(_)).sum
}
  
  "2 pow 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26" should {
    "be working" in {
      powSum(2, 15) must equalTo(26)
      powSum(2, 1000) must equalTo(1366)
    }
  }
}
