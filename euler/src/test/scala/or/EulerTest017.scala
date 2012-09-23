package or

import scala.collection.immutable.Stream.consWrapper
import scala.actors._
import Actor._
import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec
import java.util.concurrent.TimeUnit

class EulerTest017 extends Specification {
  

  
  "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total" should {
  val m = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five",
    6 -> "six", 7 -> "seven", 8 -> "eight", 9 -> "nine", 10 -> "ten",
    11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen",
    16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen")
  val t = Map(20 -> "twentie", 30 -> "thirtie", 40 -> "fourty", 50 -> "fifty",
    60 -> "sixtie", 70 -> "seventie", 80 -> "eighty", 90 -> "ninety")
  val hundred = "hundred"
  def numberToString(i: Int): String = {
    if (1 <= i && i <= 19) m(i)
    else "zero"
  }
    "If all the numbers from 1 to 1000 (one thousand) inclusive were written out" in {
      numberToString(1) must equalTo("one")
      numberToString(10) must equalTo("ten")
    }
  }
}
