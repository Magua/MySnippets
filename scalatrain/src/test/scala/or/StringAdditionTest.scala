package or

import org.specs2.mutable._

class StringAdditionTest extends Specification {
  implicit def stringAddition(s: String) = new StringAddition(s)
  "Strings" should {
    "support addition" in {
      "5" plus "6" must equalTo("11")
    }
    "support addition" in {
      "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999" plus "1" must equalTo(
        "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
    }
  }
}