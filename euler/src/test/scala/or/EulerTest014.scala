package or

import scala.collection.immutable.Stream.consWrapper
import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec
import java.util.concurrent.TimeUnit
object EulerTest014 {
}
class EulerTest014 extends Specification {

  def nextCollatz(n: Long): Long = if (n % 2 == 0) n / 2 else 3 * n + 1
  
  def collatzLength(n: Long, c: Long = 0, h: Long = 0): (Long, Long) = {
    if (n == 1) (c + 1, h) else {
      val nc = nextCollatz(n)
      collatzLength(nc, c + 1, nc max h)
    }
  }

  def longestStreamStartingAtUnderN(end: Long) = {
    @tailrec def reqFindMax(n: Long, maxLengthNo: Long = 0, maxLength: Long = 0, highscore: Long = 0): (Long, Long, Long) = {
      if (n == end)
        (maxLengthNo, maxLength, highscore)
      else {
        val cLength = collatzLength(n)
        if (cLength._1 > maxLength) {
          reqFindMax(n + 1, n, cLength._1, highscore max cLength._2)
        }
        else {
          reqFindMax(n + 1, maxLengthNo, maxLength, highscore max cLength._2)
        }
      }
    }
    if (end==1) (0, 0)
    else if (end==2) (1, 1)
    else reqFindMax(3)
  }
  
  "Collatz Problem: Which starting number, under one million, produces the longest chain?" should {
    "collatzLength" in {
    	collatzLength(1) must equalTo(1,0)
    	collatzLength(2) must equalTo(2,1)
    	collatzLength(4) must equalTo(3,2)
    	collatzLength(8) must equalTo(4,4)
    	collatzLength(16) must equalTo(5,8)
    	collatzLength(5) must equalTo(6,16)
    	collatzLength(10) must equalTo(7,16)
    	collatzLength(20) must equalTo(8,16)
    	collatzLength(40) must equalTo(9,20)
    	collatzLength(13) must equalTo(10,40)
    }
    "longest collatzStream starting under one million" in {
      0 must equalTo(0)
      longestStreamStartingAtUnderN(2) must equalTo((1, 1))
      longestStreamStartingAtUnderN(5) must equalTo((3, 8, 16))
      // the collatzStream peaks at 57 billions, dont use an Int as I did initially
      longestStreamStartingAtUnderN(1000000) must equalTo((837799,525, 56991483520L))
    }
  }
}
