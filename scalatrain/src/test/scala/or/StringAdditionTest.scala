package or

import org.specs2.mutable._

class StringAdditionTest extends Specification {
  implicit def stringAddition(s: String) = new StringAddition(s)
  "Strings" should {
    "support " in {
      "5" plus "6" must equalTo("11")
      "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999" plus "1" must equalTo(
        "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
    }
    "support minus" in {
      //      "1" minus "1" must equalTo("0")
      //      "2" minus "1" must equalTo("1")
      //      "1" minus "2" must equalTo("-1")
      //"10" minus "1" must equalTo("9")
      //"100000000000000000000000000000000000000000000000000000000000000000000000000000000000000" minus "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999" must equalTo("1")
    }
  }
}